package uk.ac.gold.vrosa003.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void testGenerateLength() {
        // Setup
        Generator generator = new Generator();
        int expectedLength = 15;

        // Execute
        String result = generator.generate(expectedLength);

        // Assert
        assertEquals(expectedLength, result.length(), "Password length should match input");
    }

    @Test
    void testGenerateNotEmpty() {
        Generator generator = new Generator();
        String result = generator.generate(8);
        
        // Check that the result is not null and not empty
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}