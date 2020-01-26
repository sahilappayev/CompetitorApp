package util;

import beans.Competitor;

import java.util.Scanner;

public class MenuUtil {
    public static int showMenu(){
        System.out.println("Please select menu:\n" +
                "1.Yarishmacilari daxil edin\n" +
                "2.Yarishmacilari gosterin\n" +
                "3.Yarishmacilarin sayini artirin\n" +
                "4.Yarishmaya bashlayin\n" +
                "5.Xalimi goster\n" +
                "6.Logout\n");
        Scanner sc = new Scanner(System.in);
        int selectedMenu = sc.nextInt();
        if(selectedMenu>0 && selectedMenu<7)
            return selectedMenu;
        else
            System.out.println("Yalnish sechim! Yeniden cehd edin!");
            return -1;
    }
    public static int showMenuInfinit(){
        while (true){
            int selectedMenu = showMenu();
            if(selectedMenu == 1){
                Competitor[] competitors = CompetitionUtil.registerCompetitorsAndShowInfo();
            }else if (selectedMenu == 2){
                CompetitionUtil.printCompetitors();
            } else if(selectedMenu==3){
                CompetitionUtil.increaseCompetitors();
            } else if (selectedMenu == 4){
                CompetitionUtil.startCompetition();
            }else if (selectedMenu==5){
                CompetitionUtil.showPoint();
            }else if(selectedMenu==6){
                CompetitionUtil.logOut();
            }
        }
    }
}
