package main.util;

public class Validator {

    public static boolean isValidText(String text) {
        return text.length() > 0 && !text.equals(" ");
    }

    public static boolean isValidNumber(int min, int max, int num) {
        return num >= min && num <= max;
    }
}
