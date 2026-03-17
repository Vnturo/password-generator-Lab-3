package uk.ac.gold.vrosa003.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void testGenerateLength() {
        // Setup
        Generator generator = new Generator();
        int expectedLength = 15;

        // Execute
        String result = generator.generate(expectedLength, false);

        // Assert
        assertEquals(expectedLength, result.length(), "Password length should match input");
    }

    @Test
    void testGenerateNotEmpty() {
        Generator generator = new Generator();
        // Execute
        String result = generator.generate(8, false);
        
        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    @Test
    void testGenerateWithoutSpecialCharacters() {
        Generator generator = new Generator();
        String result = generator.generate(50, false); // Generate a long one
        
        // Makw sure it contains alphanumeric characters
        assertTrue(result.matches("^[a-zA-Z0-9]+$"), "Password should NOT contain special characters");
    }

    @Test
    void testGenerateWithSpecialCharacters() {
        // We test the CharacterSet directly to guarantee the pool is correct
        String chars = CharacterSet.getCharacters(true);
        assertTrue(chars.contains("@"), "Character set should include special characters");
        assertTrue(chars.contains("#"), "Character set should include special characters");
    }
}