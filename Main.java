package gr.aueb.dmst.ecg.eprog;


import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        Scanner s6 = new Scanner(System.in);
        Scanner s7 = new Scanner(System.in);

        final int[] a11 = new int[1];
        int a2;
        int gn0 = 0;
        String np, fn, psi, un, psu, gn, dec, mood;
        int a1;
        boolean yn = false;
        String namefinal = null;
        String fullfinal = null;
        String passfinal = null;
        String[] gnall = { "Pop", "Rock", "Rap", "Jazz", "HipHop", "Classic", "House" };
        String[] decall = { "1950", "1960", "1970", "1980", "1990", "2000", "2010" };
        String[] moodall = { "Workout", "Party", "Studying", "Sleep", "Chill" };

        try {
            DBconnection con2 = new DBconnection();
            con2.dbcon();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error connecting with the database.");
        }

            try {
                // colors
                JFrame jf = new JFrame(" ");
                GraphWelcome gp = new GraphWelcome();

                jf.setBounds(500, 300, 400, 275);
                jf.setLayout(new BorderLayout());
                jf.add(gp, BorderLayout.CENTER);
                JPanel panel1 = new JPanel();
                JLabel label1 = new JLabel("This is the first panel");
                panel1.add(label1);

                jf.setVisible(true);

                jf.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // When the first frame is closing, show the second panel
                        jf.dispose();
                        jf.getContentPane().remove(panel1);
                        jf.revalidate();
                        ButtonsSIU button = new ButtonsSIU();
                        a11[0] = button.bt();

                    }

                });
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error while printing the wellcome panel.");
            }

            // Remember, the method show() is deprecated

            // let the user choose if they want to sign in or sign up by typing 1 or 2.
            System.out.println("Press any letter to continue.");

            String cr = s1.nextLine();

            if (a11[0] == 1) {
                do {
                    un = JOptionPane.showInputDialog("Enter your Username:");
                    psi = JOptionPane.showInputDialog("Enter your Password:");

                    try {
                        UserDAO auth = new UserDAO();
                        yn = auth.authenticate(un, psi);
                        // check if username and password are correct.
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("There has been a problem authenticating your data.");
                    }
                    if (yn) {
                         JOptionPane.showMessageDialog(null, "Welcome back " + un);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username or password, please try again!");
                    }
                } while (yn == false);
                namefinal = un;
                passfinal = psi;

            } else if (a11[0] == 2) {
                fn = SUfn.sif();
                // call method that inserts user's fullname.

                psu = SUfn.sip();

                UPF u1 = new UPF();
                String uname = u1.uqun();
                // call the method that reads and ensures the uniqueness of the UserName(PK).

                // call method that inserts user's password.
                namefinal = uname;
                passfinal = psu;
                fullfinal = fn;

                UPF u2 = new UPF();
                u2.datain(fn, uname, psu);
                // call method that ensures that the sign up data insertion in the database was
                // done correctly.
                u2.incounters(uname);
                // call method that ensures that the counter initialization was made correctly.

            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose option 1 or 2.");  
            }

        JFrame jf4 = new JFrame(" ");
                GraphLggedIn gl = new GraphLggedIn();
                jf4.setBounds(500, 300, 475, 275);
                jf4.setLayout(new BorderLayout());
                jf4.add(gl, BorderLayout.CENTER);
                JPanel panel3 = new JPanel();
                JLabel label3 = new JLabel("This is the first panel");
                panel3.add(label3);


                jf4.setVisible(true);

                jf4.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // When the first frame is closing, show the second panel
                        jf4.dispose();
                        jf4.getContentPane().remove(panel3);
                        jf4.revalidate();

                    }

                });

        User us = new User(fullfinal, namefinal, passfinal);
        us.setFullname(fullfinal);
        us.setPassword(passfinal);
        us.setUsername(namefinal);

        do {
            System.out.printf(
                    "Would you like to:%n 1. Get a new playlist suggestion.%n 2. View your Genre Statistics.%n 3. View your recent Playlist History.%n 4. Sign out.%n");
            a2 = s5.nextInt();
            if (a2 == 1) {
                do {
                    boolean ex = false;
                    do {
                        System.out.printf(
                                "Choose what Genre you would like to listen: %n 1. Pop%n 2. Rock %n 3. Rap%n 4. Jazz%n 5. Hip Hop%n 6. Classic%n 7. House%n");
                        gn = s6.nextLine();
                        for (int i = 0; i <= 6; i++) {
                            if (gn.equals(gnall[i])) {
                                ex = true;
                            }
                        }
                        if (ex == false) {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please choose one of the listed genres.");
                        }
                    } while (ex == false);

                    boolean ex2 = false;
                    do {
                        System.out.printf(
                                "Please choose the decade.%n 1.1950%n 2.1960%n 3.1970%n 4.1980%n 5.1990%n 6.2000%n 7.2010%n");
                        dec = s6.nextLine();
                        for (int i = 0; i <= 6; i++) {
                            if (dec.equals(decall[i])) {
                                ex2 = true;
                            }
                        }
                        if (ex2 == false) {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please choose one of the listed decades.");
                        }
                    } while (ex2 == false);

                    boolean ex3 = false;
                    do {
                        System.out.printf(
                                "What is your mood today? Please choose:%n 1.Workout%n 2.Party%n 3.Studying%n 4.Sleep%n 5.Chill%n");
                        mood = s6.nextLine();
                        for (int i = 0; i <= 4; i++) {
                            if (mood.equals(moodall[i])) {
                                ex3 = true;
                            }
                        }
                        if (ex3 == false) {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please choose one of the listed moods.");
                        }
                    } while (ex3 == false);

                    String username = us.getUsername();

                    // Save the selected genre in the database and increase the appropriate counter
                    // by 1.
                    try {
                        Savecount sv = new Savecount();
                        boolean updated = sv.increaseCounter(gn, namefinal);
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
                    // connection with AI.
                    AIModel openai = new AIModel(/* input */);
                    String genlist = openai.genAnswer(gn, mood, dec);
                    genlist = openai.modify(genlist);

                    for (int k = 0; k <= 6; k++) {
                        if (gnall[k] == gn) {
                            gn0 = k;
                        }
                    }

                    // Store the playlist in the history table.

                    do {
                        JOptionPane.showMessageDialog(null, "Would you like to get a new playlist suggestion?");
                        np = s7.nextLine();
                        if (!np.equals("Yes") && !np.equals("No")) {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please type Yes or No.");
                        }
                    } while (!np.equals("Yes") && !np.equals("No"));
                } while (np.equals("Yes"));

            } else if (a2 == 2) {
                // Statistics
            } else if (a2 == 3) {
                // History
            } else if (a2 != 4) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose between option 1 and 4.");
            }
            if (a2 != 4) {
                a2 = 5;
            }
            if (a2 == 4) {
                JFrame jf3 = new JFrame(" ");
                GraphGoodbye gb = new GraphGoodbye();
                jf3.setBounds(500, 300, 400, 275);
                jf3.setLayout(new BorderLayout());
                jf3.add(gb, BorderLayout.CENTER);
                JPanel panel2 = new JPanel();
                JLabel label2 = new JLabel("This is the first panel");
                panel2.add(label2);


                jf3.setVisible(true);

                jf3.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // When the first frame is closing, show the second panel
                        jf3.dispose();
                        jf3.getContentPane().remove(panel2);
                        jf3.revalidate();

                    }

                });
            }
        } while (a2 != 1 && a2 != 2 && a2 != 3 && a2 != 4);

        s1.close();
        s3.close();
        s4.close();
        s5.close();
        s6.close();
        s7.close();

        

    }
}
