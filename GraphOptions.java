package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class GraphOptions extends JFrame {
    //show option panels with buttons so that the user can choose the desired music genre, decade and mood.
    private JPanel genrePanel;
    private JPanel decadePanel;
    private JPanel moodPanel;

    private CardLayout cardLayout;
    private CountDownLatch latch = new CountDownLatch(1);
    private int g_value = 0;
    private int d_value = 0;
    private int m_value = 0;

    public GraphOptions() {
        // Set up the JFrame
        setTitle("Make your choices!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // create the genre panel with buttons
        genrePanel = new JPanel(new GridLayout(3, 3, 10, 10));
        addGenreButtons();

        // create the decade panel initially empty
        decadePanel = new JPanel();

        // create the mood panel initially empty
        moodPanel = new JPanel();

        // use cardlayout to switch between genre and decade panels
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(genrePanel, "genrePanel");
        add(decadePanel, "decadePanel");
        add(moodPanel, "moodPanel");

        // Display the JFrame
        setVisible(true);

        // Wait for user interaction
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addGenreButtons() {

        // Create buttons
        JButton popButton = createStyledButton("Pop");
        JButton rockButton = createStyledButton("Rock");
        JButton rapButton = createStyledButton("Rap");
        JButton jazzButton = createStyledButton("Jazz");
        JButton hipHopButton = createStyledButton("Hip Hop");
        JButton classicButton = createStyledButton("Classic");
        JButton houseButton = createStyledButton("House");

        // Add action listeners to the buttons
        popButton.addActionListener(createActionListener("Pop"));
        rockButton.addActionListener(createActionListener("Rock"));
        rapButton.addActionListener(createActionListener("Rap"));
        jazzButton.addActionListener(createActionListener("Jazz"));
        hipHopButton.addActionListener(createActionListener("Hip Hop"));
        classicButton.addActionListener(createActionListener("Classic"));
        houseButton.addActionListener(createActionListener("House"));

        genrePanel.add(popButton);
        genrePanel.add(rockButton);
        genrePanel.add(rapButton);
        genrePanel.add(jazzButton);
        genrePanel.add(hipHopButton);
        genrePanel.add(classicButton);
        genrePanel.add(houseButton);
    }

    private void addDecadeButtons() {

        // Create buttons for decades
        JButton decade50sButton = createStyledButton("1950s");
        JButton decade60sButton = createStyledButton("1960s");
        JButton decade70sButton = createStyledButton("1970s");
        JButton decade80sButton = createStyledButton("1980s");
        JButton decade90sButton = createStyledButton("1990s");
        JButton decade2000sButton = createStyledButton("2000s");
        JButton decade2010sButton = createStyledButton("2010s");

        // Add action listeners to the decade buttons
        decade50sButton.addActionListener(createActionListener(1950));
        decade60sButton.addActionListener(createActionListener(1960));
        decade70sButton.addActionListener(createActionListener(1970));
        decade80sButton.addActionListener(createActionListener(1980));
        decade90sButton.addActionListener(createActionListener(1990));
        decade2000sButton.addActionListener(createActionListener(2000));
        decade2010sButton.addActionListener(createActionListener(2010));

        decadePanel.add(decade50sButton);
        decadePanel.add(decade60sButton);
        decadePanel.add(decade70sButton);
        decadePanel.add(decade80sButton);
        decadePanel.add(decade90sButton);
        decadePanel.add(decade2000sButton);
        decadePanel.add(decade2010sButton);
    }

    private void addMoodButtons() {
        JButton workoutButton = createStyledButton("Workout");
        JButton partyButton = createStyledButton("Party");
        JButton studyButton = createStyledButton("Study");
        JButton sleepButton = createStyledButton("Sleep");
        JButton chillButton = createStyledButton("Chill");

        workoutButton.addActionListener(createActionListener1("Workout"));
        partyButton.addActionListener(createActionListener1("Party"));
        studyButton.addActionListener(createActionListener1("Study"));
        sleepButton.addActionListener(createActionListener1("Sleep"));
        chillButton.addActionListener(createActionListener1("Chill"));

        moodPanel.add(workoutButton);
        moodPanel.add(partyButton);
        moodPanel.add(studyButton);
        moodPanel.add(sleepButton);
        moodPanel.add(chillButton);
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(new Color(128, 0, 128)); // Set background color
        button.setForeground(Color.WHITE); // Set text color
        button.setFocusPainted(false); // Remove focus border
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Set font
        return button;
    }

    private ActionListener createActionListener(final String genre) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGenreSelected(genre);
            }
        };
    }

    private ActionListener createActionListener(final int decade) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDecadeSelected(decade);
            }
        };
    }

    private ActionListener createActionListener1(final String mood) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleMoodSelected(mood);
            }
        };
    }

    private void handleGenreSelected(String genre) {
        if (genre.equals("Pop")) {
            g_value = 1;
        } else if (genre.equals("Rock")) {
            g_value = 2;
        } else if (genre.equals("Rap")) {
            g_value = 3;
        } else if (genre.equals("Jazz")) {
            g_value = 4;
        } else if (genre.equals("Hip Hop")) {
            g_value = 5;
        } else if (genre.equals("Classic")) {
            g_value = 6;
        } else if (genre.equals("House")) {
            g_value = 7;
        }
        System.out.println(g_value);
        cardLayout.show(getContentPane(), "decadePanel");
        addDecadeButtons();
    }

    private void handleDecadeSelected(int decade) {
        if (decade == 1950) {
            d_value = 1;
        } else if (decade == 1960) {
            d_value = 2;
        } else if (decade == 1970) {
            d_value = 3;
        } else if (decade == 1980) {
            d_value = 4;
        } else if (decade == 1990) {
            d_value = 5;
        } else if (decade == 2000) {
            d_value = 6;
        } else if (decade == 2010) {
            d_value = 7;
        }
        System.out.println(d_value);
        cardLayout.show(getContentPane(), "moodPanel");
        addMoodButtons();
    }

    private void handleMoodSelected(String mood) {
        if (mood.equals("Workout")) {
            m_value = 1;
        } else if (mood.equals("Party")) {
            m_value = 2;
        } else if (mood.equals("Study")) {
            m_value = 3;
        } else if (mood.equals("Sleep")) {
            m_value = 4;
        } else if (mood.equals("Chill")) {
            m_value = 5;
        }
        System.out.println(m_value);
        latch.countDown();
        dispose();
    }

    public int getGenreValue() {
        return g_value;
    }

    public int getDecadeValue() {
        return d_value;
    }

    public int getMoodValue() {
        return m_value;
    }
}
