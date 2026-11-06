import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class HashSet_DuplicateRemoval {

    @Test
    void shouldRemoveDuplicateValues() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            org.prep.HashSet_DuplicateRemoval.main(new String[0]);
        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString(StandardCharsets.UTF_8);

        assertTrue(result.contains("10"));
        assertTrue(result.contains("56"));
        assertTrue(result.contains("99"));
        assertEquals(1, countOccurrences(result.lines().findFirst().orElse(""), "10"));
        assertTrue(result.contains("Size of set: 3"));
    }

    private int countOccurrences(String text, String value) {
        return (text.length() - text.replace(value, "").length()) / value.length();
    }
}
