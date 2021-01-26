package utils;

import common.ReadPropertyFile;
import enums.Config;

public final class Utilities {
    private Utilities() {
    }

    public static String getEnv() {
        return System.getenv("env");
    }

    public static String getBrowser()  {
        return ReadPropertyFile.getProperty(Config.browser);
    }

    public static String getAppUrl(){
        return ReadPropertyFile.getProperty(Config.url);
    }
}
