package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;

public class DBconnection {
    
    public void dbcon() {
        final Connection con;
        try {
            con = DB.openConnection();
            DB.createTables(con);
            DB.close();
            
        } catch (Exception e) {
            System.err.println("There has been a problem establishing a connection with the Database.");
        }
    }
}
