package util;

import beans.Competitor;
import beans.User;
import config.Config;

import java.util.Scanner;

public class CompetitionUtil {

    public static Competitor registerCompetitior(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Yarishmacinin adini daxil edin:");
        String name = sc.nextLine();

        System.out.println("Yarishmacinin soyadini daxil edin:");
        String surname = sc.nextLine();

        System.out.println("Yarishmacinin yashini daxil edin:");
        int age = sc.nextInt();
        Competitor competitor = new Competitor(name, surname, age);
        return competitor;
    }

    public static Competitor[] registerCompetitors(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Yarishmacilarin sayini daxil edin:");
        int countCompetitors = sc.nextInt();

        Competitor[] competitors = new Competitor[countCompetitors];

        for(int i = 0; i<countCompetitors;i++) {
            Competitor competitor = registerCompetitior();
            competitors[i] = competitor;
            competitor.setCompetitors(competitors);
        }
        System.out.println("Butun yarishmacilar ugurla daxil edildi!");
        Config.setCompetitors(competitors);
        return competitors;
    }

    public static Competitor[] registerCompetitorsAndShowInfo(){
        Competitor [] competitors = registerCompetitors();
        printCompetitors(competitors);
        return competitors;
    }

    public static void printCompetitors(Competitor[] competitors){
        if(competitors == null || competitors.length == 0){
            return;
        }
        for (int i = 0; i<competitors.length;i++){
            Competitor c = competitors[i];
            System.out.println(c);
        }
    }

    public static void printCompetitors(){
        printCompetitors(Config.getCompetitors());
    }

    public static boolean startCompetition(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 ve 5 arsinda bir reqem daxil edin:");
        int i = sc.nextInt();
        int s = (int) Math.round(Math.random()*5);
        System.out.println("Sistem terefinden sechilmish reqem: "+s);
        if(i==s){
            increasePoint();
            System.out.println("Tebrikler! Siz qalib geldiniz!\n Sizin xaliniz: "+Config.getUser().getPoint());
            return true;
        } else{
            System.out.println("Teessuf! Siz uduzdunuz!");
            return false;
        }
    }

    public static void increasePoint(){
        User user = Config.getUser();
        user.setPoint(user.getPoint()+10);
    }

    public static void showPoint(){
        System.out.println("Sizin xaliniz: "+Config.getUser().getPoint());
    }

    public static void logOut(){
        System.out.println("Sisdemden ugurla chixish edildi!");
        UserUtil.requireInputsAndLogin(3,true);
    }

    public static Competitor[] increaseCompetitors(){
        Competitor[] competitorsOld = Config.getCompetitors();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nece nefer elave etmek isteyirsiniz?");
        int increaseCount = sc.nextInt();
        Competitor[] competitorsNew = new Competitor[competitorsOld.length+increaseCount];
        for (int i = 0;i<competitorsOld.length;i++){
            competitorsNew[i] = competitorsOld[i];
        }
        for (int i =competitorsOld.length; i<competitorsNew.length;i++){
            competitorsNew[i]=registerCompetitior();
        }
        Config.setCompetitors(competitorsNew);
        return competitorsNew;
    }

}
