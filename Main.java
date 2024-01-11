package gr.aueb.dmst.ecg.eprog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        Scanner s6 = new Scanner(System.in);
        Scanner s7 = new Scanner(System.in);

        // initialize all the necessary variables
        final int[] a11 = new int[1];
        int a2;
        String np, fn, psi, un, psu, gn, dec, mood;
        boolean yn = false;
        String namefinal = null;
        String fullfinal = null;
        String passfinal = null;
        String[] gnall = { "Pop", "Rock", "Rap", "Jazz", "HipHop", "Classic", "House" };
        String[] decall = { "1950", "1960", "1970", "1980", "1990", "2000", "2010" };
        String[] moodall = { "Workout", "Party", "Studying", "Sleep", "Chill" };

        Map<String, Integer> genrecount = new HashMap<>();

        // establish a connection with the database
        try {
            DBconnection con2 = new DBconnection();
            con2.dbcon();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error connecting with the database.");
        }

        // show the welcome panel
        try {
            // colors
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("MusiVerse App");
                frame.setUndecorated(true); // Αφαιρεί την πλαίσιο διακόσμησης
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                WelcomePanel welcomePanel = new WelcomePanel(frame);
                frame.add(welcomePanel);

                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
            // let the user choose if they want to sign in or sign up by typing 1 or 2.
            try {
                // Sleep for 5 seconds (5000 milliseconds)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ButtonsSIU button = new ButtonsSIU();
            a11[0] = button.bt();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while printing the welcome panel.");
        }

        do {
            try {
                // Sleep for 5 seconds (5000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (a11[0] != 1 && a11[0] != 2);

        // ask for appropriate data to logIn.
        if (a11[0] == 1) {
            do {
                un = JOptionPane.showInputDialog("Enter your Username:");
                psi = JOptionPane.showInputDialog("Enter your Password:");
                // check if username and password are correct.
                try {
                    UserDAO auth = new UserDAO();
                    yn = auth.authenticate(un, psi);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("There has been a problem authenticating your data.");
                }
                // show appropriate message
                if (yn) {
                    JOptionPane.showMessageDialog(null, "Welcome back " + un);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username or password, please try again!");
                }
            } while (yn == false);
            namefinal = un;
            passfinal = psi;

        } else if (a11[0] == 2) {
            // call method where user inserts fullname and password
            fn = SUfn.sif();
            psu = SUfn.sip();

            // call the method that reads and ensures the uniqueness of the UserName(PK).
            UPF u1 = new UPF();
            String uname = u1.uqun();

            namefinal = uname;
            passfinal = psu;
            fullfinal = fn;

            // call method that ensures that the sign up data insertion in the database was
            // done correctly.
            UPF u2 = new UPF();
            u2.datain(fn, uname, psu);
            // call method that ensures that the counter initialization was made correctly.
            u2.incounters(uname);

        } else {
            JOptionPane.showMessageDialog(null, "Invalid option. Please choose option 1 or 2.");
        }

        // show 'you have logged-in' panel
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MusiVerse App");
            frame.setUndecorated(true); // Αφαιρεί την πλαίσιο διακόσμησης
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LogInPanel welcomePanel = new LogInPanel(frame);
            frame.add(welcomePanel);

            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // set the user's data
        User us = new User(fullfinal, namefinal, passfinal);
        us.setFullname(fullfinal);
        us.setPassword(passfinal);
        us.setUsername(namefinal);

        Counters count = new Counters();

        // ask user what feature they would like to use
        do {
            System.out.printf(
                    "Would you like to:%n 1. Get a new playlist suggestion.%n 2. View your Genre Statistics.%n 3. View your recent Playlist History.%n 4. Sign out.%n");
            a2 = s5.nextInt();
            if (a2 == 1) {
                do {

                    String username = us.getUsername();

                    // Call the methods that show the option panels and set values graphOptions.
                    GraphOptions graphOptions = new GraphOptions();

                    // Retrieve the values
                    int genreValue = graphOptions.getGenreValue();
                    int decadeValue = graphOptions.getDecadeValue();
                    int moodValue = graphOptions.getMoodValue();

                    // Use the values as needed
                    System.out.println("Genre Value: " + genreValue);
                    System.out.println("Decade Value: " + decadeValue);
                    System.out.println("Mood Value: " + moodValue);

                    // turn the returned int values into strings
                    gn = " ";
                    for (int i = 0; i <= 6; i++) {
                        if (genreValue == i + 1) {
                            gn = gnall[i];
                        }
                    }
                    dec = " ";
                    for (int i = 0; i <= 6; i++) {
                        if (decadeValue == i + 1) {
                            dec = decall[i];
                        }
                    }
                    mood = " ";
                    for (int i = 0; i <= 4; i++) {
                        if (moodValue == i + 1) {
                            mood = moodall[i];
                        }
                    }

                    // Save the selected genre in the database and increase the appropriate counter
                    // by 1.
                    try {
                        Savecount sv = new Savecount();
                        boolean updated = sv.increaseCounter(gn, username);
                        if (updated) {
                            System.out.println("the counter for genre " + gn + " increased.");
                        } else {
                            System.out.println("the counter " + gn + " did not increase.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("There has been a problem updating the database.");
                    }

                    // Pass the data to the AI and display the suggested playlist.
                    AIModel openai = new AIModel(/* input */);
                    String genlist = openai.genAnswer(gn, mood, dec);
                    System.out.println(genlist);

                    // Store the playlist in the history table.
                    genrecount = count.MGen(username);
                    count.Count(gn, genrecount);

                    // TODO FIX THIS
                    do {
                        JOptionPane.showMessageDialog(null, "Would you like to get a new playlist suggestion?");
                        np = s7.nextLine();
                        if (!np.equals("Yes") && !np.equals("No")) {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please type Yes or No.");
                        }
                    } while (!np.equals("Yes") && !np.equals("No"));
                } while (np.equals("Yes"));

            } else if (a2 == 2) {
                // Statistics' Diagrams
                Application.launch(Counters.class, args);

            } else if (a2 == 3) {
                // History of previous genres
                count.ShowHistory();
                count.ShowStatistics(genrecount);

            } else if (a2 != 4) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose between option 1 and 4.");
            }
            if (a2 != 4) {
                a2 = 5;
            }
            if (a2 == 4) {
                // show Goodbye panel
                SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("MusiVerse App");
                    frame.setUndecorated(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    LogOutPanel welcomePanel = new LogOutPanel(frame);
                    frame.add(welcomePanel);

                    frame.setSize(600, 400);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                });
            }
        } while (a2 != 1 && a2 != 2 && a2 != 3 && a2 != 4);

        // close used scanners
        s1.close();
        s3.close();
        s4.close();
        s5.close();
        s6.close();
        s7.close();

    }

}
