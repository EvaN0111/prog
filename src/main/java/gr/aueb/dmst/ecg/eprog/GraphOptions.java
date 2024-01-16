package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class GraphOptions extends JFrame {
    // show option panels with buttons so that the user can choose the desired music
    // genre, decade and mood.
    private JPanel genrePanel;
    private JPanel decadePanel;
    private JPanel moodPanel;

    private CardLayout cardLayout;
    private CountDownLatch latch = new CountDownLatch(1);
    private int g_value = 0;
    private int d_value = 0;
    private int m_value = 0;

    public GraphOptions() {
        try {
            // set up the JFrame
            setTitle("Make your choices!");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);

            // create the genre panel with buttons
            genrePanel = new StarPanel();
            genrePanel.setLayout(new BoxLayout(genrePanel, BoxLayout.Y_AXIS));
            genrePanel.setBackground(new Color(0, 0, 102));
            addTextToPanel(genrePanel, "Please, choose a genre!", BorderLayout.PAGE_START);
            addGenreButtons();

            // create the decade panel initially empty
            decadePanel = new StarPanel();
            decadePanel.setLayout(new BoxLayout(decadePanel, BoxLayout.Y_AXIS));

            // create the mood panel initially empty
            moodPanel = new StarPanel();
            moodPanel.setLayout(new BoxLayout(moodPanel, BoxLayout.Y_AXIS));

            // use cardlayout to switch between genre and decade panels
            cardLayout = new CardLayout();
            setLayout(cardLayout);
            add(genrePanel, "genrePanel");
            add(decadePanel, "decadePanel");
            add(moodPanel, "moodPanel");

            // center the frame on the screen
            setLocationRelativeTo(null);

            // display the JFrame
            setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // wait for user interaction
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addTextToPanel(JPanel panel, String text, String position) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Impact", Font.ITALIC, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        panel.add(label, position);
    }

    private void addGenreButtons() {

        // create buttons
        JButton popButton = createStyledButton("Pop");
        JButton rockButton = createStyledButton("Rock");
        JButton rapButton = createStyledButton("Rap");
        JButton jazzButton = createStyledButton("Jazz");
        JButton hipHopButton = createStyledButton("Hip Hop");
        JButton classicButton = createStyledButton("Classic");
        JButton houseButton = createStyledButton("House");

        // add action listeners to the buttons
        popButton.addActionListener(createActionListener("Pop"));
        rockButton.addActionListener(createActionListener("Rock"));
        rapButton.addActionListener(createActionListener("Rap"));
        jazzButton.addActionListener(createActionListener("Jazz"));
        hipHopButton.addActionListener(createActionListener("Hip Hop"));
        classicButton.addActionListener(createActionListener("Classic"));
        houseButton.addActionListener(createActionListener("House"));

        JPanel buttonPanel = new StarPanel();
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        popButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rapButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jazzButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hipHopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        classicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        houseButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(popButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(rockButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(rapButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(jazzButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(hipHopButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(classicButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(houseButton);

        genrePanel.add(buttonPanel);
    }

    private void addDecadeButtons() {

        // create buttons for decades
        JButton decade50sButton = createStyledButton("1950s");
        JButton decade60sButton = createStyledButton("1960s");
        JButton decade70sButton = createStyledButton("1970s");
        JButton decade80sButton = createStyledButton("1980s");
        JButton decade90sButton = createStyledButton("1990s");
        JButton decade2000sButton = createStyledButton("2000s");
        JButton decade2010sButton = createStyledButton("2010s");

        // add action listeners to the decade buttons
        decade50sButton.addActionListener(createActionListener(1950));
        decade60sButton.addActionListener(createActionListener(1960));
        decade70sButton.addActionListener(createActionListener(1970));
        decade80sButton.addActionListener(createActionListener(1980));
        decade90sButton.addActionListener(createActionListener(1990));
        decade2000sButton.addActionListener(createActionListener(2000));
        decade2010sButton.addActionListener(createActionListener(2010));

        JPanel buttonPanel = new StarPanel();
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        decade50sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade60sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade70sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade80sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade90sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade2000sButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decade2010sButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade50sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade60sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade70sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade80sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade90sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade2000sButton);
        buttonPanel.add(Box.createVerticalStrut(2)); // add some vertical spacing
        buttonPanel.add(decade2010sButton);

        decadePanel.add(buttonPanel);
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

        JPanel buttonPanel = new StarPanel();
        buttonPanel.setBackground(new Color(0, 0, 102));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        workoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        partyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        studyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sleepButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        buttonPanel.add(Box.createVerticalStrut(5)); // add some vertical spacing
        buttonPanel.add(workoutButton);
        buttonPanel.add(Box.createVerticalStrut(5)); // add some vertical spacing
        buttonPanel.add(partyButton);
        buttonPanel.add(Box.createVerticalStrut(5)); // add some vertical spacing
        buttonPanel.add(studyButton);
        buttonPanel.add(Box.createVerticalStrut(5)); // add some vertical spacing
        buttonPanel.add(sleepButton);
        buttonPanel.add(Box.createVerticalStrut(5)); // add some vertical spacing
        buttonPanel.add(chillButton);

        moodPanel.add(buttonPanel);
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.WHITE); // set background color
        button.setForeground(Color.BLACK); // set text color
        button.setFocusPainted(false); // remove focus border
        button.setFont(new Font("Impact", Font.ITALIC, 16)); // set font
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
        cardLayout.show(getContentPane(), "decadePanel");
        decadePanel.setBackground(new Color(0, 0, 102));
        addTextToPanel(decadePanel, "Please, choose a decade!", BorderLayout.CENTER);
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
        cardLayout.show(getContentPane(), "moodPanel");
        moodPanel.setBackground(new Color(0, 0, 102));
        addTextToPanel(moodPanel, "Please, choose your mood!", BorderLayout.CENTER);
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
