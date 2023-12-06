package gr.aueb.dmst.ecg.eprog;

import java.util.Scanner;

public class SUfn {

    public static String sif() {
        Scanner s01 = new Scanner(System.in);

        String fn;
        try {
            do {
                System.out.println("Insert your Full Name:");
                fn = s01.nextLine();
                // insert the user's Fullname.
            } while (fn == null);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("There has been a problem inserting your Fullname");
            fn = " ";
        }
        s01.close();

        return fn;
    }

    public static String sip() {
        Scanner s02 = new Scanner(System.in);
        String ps;
        try {
            do{
                System.out.println("Insert your Password:");
                ps = s02.nextLine();
                //insert the user's passwors.
            } while (ps == null);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("There has been a problem inserting your Password");
            ps = " ";
        }
        s02.close();
        return ps;
    }

}