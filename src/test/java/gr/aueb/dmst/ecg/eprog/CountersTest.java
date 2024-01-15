package gr.aueb.dmst.ecg.eprog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountersTest {

    private Counters counters;

    @BeforeEach
    void setUp() {
        counters = new Counters();
    }

    @Test
    void testCount() {
        counters.Count("Pop", counters.genreCount);
        counters.Count("Rock", counters.genreCount);
        // Assuming the initial count for "Pop" is 1 and "Rock" is 2
        assertEquals(1, counters.genreCount.get("Pop"));
        assertEquals(1, counters.genreCount.get("Rock"));
        // Add more assertions based on your expectations
    }

    @Test
    void testShowStatistics() {
        // Assuming you have some data in genreCount
        counters.genreCount.put("Pop", 1);
        counters.genreCount.put("Rock", 2);
        counters.ShowStatistics(counters.genreCount);
        // Check if the output is as expected (printed to console)
        // You may need to redirect System.out for testing console output
    }

    @Test
    void testShowHistory() {
        // Assuming you have added some genres to the queue
        counters.queue.add("Pop");
        counters.queue.add("Rock");
        Queue<String> history = counters.ShowHistory();
        assertTrue(history.contains("Pop"));
        assertTrue(history.contains("Rock"));
        // Add more assertions based on your expectations
    }
}
