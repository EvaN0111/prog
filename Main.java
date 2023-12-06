package gr.aueb.dmst.ecg.eprog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        Scanner s6 = new Scanner(System.in);
        Scanner s7 = new Scanner(System.in);

        int a1, a2, gn, dec, mood;
        String np, fn, ps, un;
        boolean yn = false;

        try {
            DBconnection con2 = new DBconnection();
            con2.dbcon();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error connecting with the database.");
        }
        
        do {
            System.out.println("Would you like to:/n 1. Sign in(Type 1)/n 2. Sign up(Type 2)");
            a1 = s1.nextInt();
            //let the user choose if they want to sign in or sign up by typing 1 or 2.

            if (a1 == 1) {
                do {
                    System.out.println("Username:");
                    un = s3.nextLine();
                    System.out.println("Password:");
                    ps = s3.nextLine();

                    try {
                        UserDAO auth = new UserDAO();
                        yn = auth.authenticate(un, ps);
                        //check if username and password are correct.
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("There has been a problem authenticating your data.");
                    }
                    if (yn) {
                        System.out.println("Welcome back" + un);
                    } else {
                        System.out.println("Wrong Username or password, please try again!");
                    }
                } while (yn == false);

            } else if (a1 == 2) {
                fn = SUfn.sif();
                //call method thaqt inserts user's fullname.

                ps = SUfn.sip();
                               
                UPF u1 = new UPF();
                String uname = u1.uqun();
                //call the method that reads and ensures the uniqueness of the UserName(PK).
 
                
                //call method that inserts user's password.

                User us = new User(fn, uname, ps);
                us.setFullname(fn);
                us.setPassword(ps);
                us.setUsername(uname);

                UPF u2 = new UPF();
                u2.datain(fn, uname, ps);
                //call method that ensures that the sign up data insertion in the database was done correctly.
                u2.incounters(uname);
                //call method that ensures that the counter initialization was made correctly.
                   

            } else {
                System.out.println("Invalid option. Please choose between option 1 and 2.");
            }
        } while (a1 != 1 && a1 != 2);

        do {
            System.out.println("Would you like to:/n 1. Get a new playlist suggestion./n 2. View your Genre Statistics./n 3. View your recent Playlist History./n 4.Sign out.");
            a2 = s5.nextInt();
            if (a2 == 1){
                do {
                    do {
                        System.out.println("Choose what Genre you would like to listen: /n 1. Pop/n 2. Rock /n 3. Rap/n 4. Jazz/n 5. Hip Hop/n 6. Classic/n 7. House");
                        gn = s6.nextInt();
                        if (gn <= 0 || gn >= 8) {
                            System.out.println("Invalid option. Please choose between option 1 and 7.");
                        }
                    } while (gn <= 0 || gn >= 8);
                    //Save the selected genre in the database
                    do {
                        System.out.println("Please choose the decade./n 1.1950-1960/n 2.1960-1970/n 3.1970-1980/n 4.1990-2000/n 5.2000-2010/n 6.2010-2020");
                        dec = s6.nextInt();
                        if (dec <= 0 || dec >= 7) {
                            System.out.println("Invalid option. Please choose again.");
                        }
                    } while (dec <=0 || dec >= 7);
                    do {
                        System.out.println("What is your mood today? Please choose:/n 1.Workout/n 2.Party/n 3.Studying/n 4.Sleep/n 5.Chill");
                        mood = s6.nextInt();
                        if (mood <= 0 || mood >= 6) {
                            System.out.println("Invalid option. Please select option between 1 and 5");
                        }
                    } while (mood <= 0 || mood >= 6);

                    //Pass the data to the AI and display the suggested playlist.
                    //Store the playlist in the history table.

                    do {
                        System.out.println("Would you like to get a new playlist suggestion?");
                        np = s7.nextLine();
                        if (np != "Yes" && np != "No") {
                            System.out.println("Invalid option. Please type Yes or No.");
                        }
                    } while (np != "Yes" && np != "No");
                } while (np == "Yes");
                a2 = 5;

            } else if (a2 == 2){
                //Statistics
            } else if (a2 == 3) {
                //History
            } else {
                System.out.println("Invalid option. Please choose between option 1 and 3.");
            }
        } while (a2 != 1 && a2 != 2 && a2 !=3 && a2 != 4);

        s1.close();
        s3.close();
        s4.close();
        s5.close();
        s6.close();
        s7.close();
       
    } 
}
