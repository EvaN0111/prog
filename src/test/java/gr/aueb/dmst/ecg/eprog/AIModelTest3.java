package gr.aueb.dmst.ecg.eprog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AIModelTest3 {
    
    @Test
    public void testSongSeperator() {
        AIModel aimodel = new AIModel();
        try {
            // Test case 1: Valid input
            String input1 = "Song1\nSong2\nSong3";
            String[] result1 = aimodel.songSeperator(input1);
            assertArrayEquals(new String[]{"Song1", "Song2", "Song3", "", "", "", "", "", "", ""}, result1);

            // Test case 2: Empty input
            String input2 = "";
            String[] result2 = aimodel.songSeperator(input2);
            assertArrayEquals(new String[]{"", "", "", "", "", "", "", "", "", ""}, result2);

            // Test case 3: Input with less than 10 songs
            String input3 = "Song1\nSong2";
            String[] result3 = aimodel.songSeperator(input3);
            assertArrayEquals(new String[]{"Song1", "Song2", "", "", "", "", "", "", "", ""}, result3);

            // Test case 4: Input with more than 10 songs
            String input4 = "Song1\nSong2\nSong3\nSong4\nSong5\nSong6\nSong7\nSong8\nSong9\nSong10\nSong11";
            String[] result4 = aimodel.songSeperator(input4);
            assertArrayEquals(new String[]{"Song1", "Song2", "Song3", "Song4", "Song5", "Song6", "Song7", "Song8", "Song9", "Song10"}, result4);
        } catch (Exception e) {

        }
        // Test case 5: Exception case
        try {
            String input5 = null;
            aimodel.songSeperator(input5);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }
}

