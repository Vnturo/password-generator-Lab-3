package uk.ac.gold.vrosa003.utils;

public class CharacterSet {
    public static String getCharacters(boolean useSpecial) {
        String baseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        if (useSpecial) {
            return baseChars + "!@#$%^&*";
        }
        return baseChars;
    }
}