package gr.aueb.dmst.ecg.eprog;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Counters {

    private Map<String, Integer> genreCount = new HashMap<>();
    private Queue<String> queue = new LinkedList<>();
    private String category;
    private int[] vas = new int[7];

    public void count(List<Integer> genres, int genr) {
        for (int i = 0; i <= 6; i++) {
            category = getGenreCategory(i);
            if (genr == i) {
                vas[i] = vas[i] +1;
                System.out.println("increased");
            } else {
                vas[i] = genres.get(i);
            }
            if (queue.size() == 10) {
                queue.remove();
            }
            queue.add(category);
            System.out.println("added");
        }
    }

    private String getGenreCategory(int i) {
        switch (i) {
            case 1: return "Pop";
            case 2: return "Rock";
            case 3: return "Rap";
            case 4: return "Jazz";
            case 5: return "Hip Hop";
            case 6: return "Classic";
            case 7: return "House";
            default: return "Unknown";
        }
    }

    public void showStatistics() {
        System.out.println("Genre count: " + genreCount);
        JOptionPane.showMessageDialog(null,"Genre count: " + genreCount);
    }

    public void showHistory() {
        JOptionPane.showMessageDialog(null,"Categories of the last songs you heard: " + queue);
    }
}