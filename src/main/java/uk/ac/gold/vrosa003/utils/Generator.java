package uk.ac.gold.vrosa003.utils;

import java.security.SecureRandom;

public class Generator {
    public String generate(int length, boolean useSpecial) {
        String characters = CharacterSet.getCharacters(useSpecial);
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}