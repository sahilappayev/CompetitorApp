package config;

import beans.Competitor;
import beans.User;

public class Config {
   public static User user = null;
   private static Competitor[] competitors = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Config.user = user;
    }

    public static Competitor[] getCompetitors() {
        return competitors;
    }

    public static void setCompetitors(Competitor[] competitors) {
        Config.competitors = competitors;
    }
}
