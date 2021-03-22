package main.util;

public class Validator {

    public static boolean validatorCheck(String text) {
        return !text.equals("") && text.length() > 0;
    }

    public static boolean isValidNumber(int min, int max, int num) {
        return num >= min && num <= max;
    }
}
