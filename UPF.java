package gr.aueb.dmst.ecg.eprog;


import javax.swing.JOptionPane;

public class UPF {

    public String uqun() {

        boolean exists;
        String un = ".";
        SignUp su1 = new SignUp();
        try {
            do {
                do {
                    un= JOptionPane.showInputDialog("Enter your Username:");
                } while (un == null);
                //insert user's UserName and make sure it is not NULL.
                exists = su1.checkAvailability(un);
                //call method checkAvailability

                if (exists) {
                    JOptionPane.showMessageDialog(null, "This username is already taken. Please choose another one.");
                }
            } while (exists);
            //check if username is not already taken.
        } catch (Exception e) {
            System.err.println("There was a problem checking the uniqueness of the UserName.");
        }

        return un;
    }

    public void datain(String fn, String uname, String ps) {
        SignUp su2 = new SignUp();
        try {
            boolean success = su2.insertData(fn, uname, ps);
            if (success) {
                System.out.println("Your data was inserted successfully.");
            } else {
                System.out.println("There was a problem inserting your data. Please try again!");
            }
            //save them in the database.
        } catch (Exception e) {
            System.err.println("There was a problem inserting the data.");
        }
    }

    public void incounters(String uname) {
        SignUp su3 = new SignUp();
        try {
            boolean success1 = su3.initializingCounters(uname);
            if (success1) {
                System.out.println("The counters have been initialized successfully.");
            } else {
                System.out.println("There was a problem initializing the counters. We will try again!");
            }
        } catch (Exception e) {
            System.err.println("There has been a problem initializing the counters.");
        }
    }
    
}
