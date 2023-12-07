package gr.aueb.dmst.ecg.eprog;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Counters {
        
    Map<String, Integer> genreCount = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    String category;
    
    public void Count(int gn, Map<String, Integer> genreCount, Queue<String> queue) {
        if (gn == 1) {category = "Pop";}
        if (gn == 2) {category = "Rock";}
        if (gn == 3) {category = "Rap";}
        if (gn == 4) {category = "Jazz";}
        if (gn == 5) {category = "Hip Hop";}
        if (gn == 6) {category = "Classic";}
        if (gn == 7) {category = "House";}
        if (genreCount.containsKey(category)) {
            genreCount.put(category, genreCount.get(category) + 1);
        } else {
            genreCount.put(category, 1);
        }
        if (queue.size() == 10) {
            queue.remove();
        }
        queue.add(category);
    }
    public void ShowStatistics(Map<String, Integer> genreCount) {
        System.out.println("Genre count: " + genreCount); //+ τα στατιστικα σε γραφιμματα
    }    

    public void ShowHistory(Queue<String> queue) {
        System.out.println("Categories of the last songs you heard: " + queue);
    }
}
