package util;

import beans.User;
import config.Config;

import java.util.Scanner;

public class UserUtil {

    public static User login(String username, String password){
        User user = null;
        if("Sahil".equals(username) && "12345".equals(password)){
            System.out.println("You have login successfully!");
            user = new User(username,password);
            return user;
        }
        throw new IllegalArgumentException("Username or Password is incoorect!");
    }

    public static User requireInputsAndLogin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = sc.nextLine();

        System.out.println("Enter your password:");
        String password = sc.nextLine();

        User user = UserUtil.login(username,password);
        Config.setUser(user);
        return user;
    }

    public static User requireInputsAndLogin(int tryCount, boolean throwException){
        for(int i = 0; i<tryCount; i++) {
            try {
                User user = requireInputsAndLogin();
                return user;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
            }
        }
        if (throwException)
        throw new IllegalArgumentException ("You have banned!");
        else
            return null;
    }

}
