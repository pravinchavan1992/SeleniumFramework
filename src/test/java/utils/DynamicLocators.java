package utils;

public final class DynamicLocators {

    private DynamicLocators() {

    }

    public static String getLocator(String Locator, String args) {
        return String.format(Locator, args);
    }

    public static String getLocator(String Locator, String args1, String args2) {
        return String.format(Locator, args1, args2);
    }
}
