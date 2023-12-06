package gr.aueb.dmst.ecg.eprog;

import java.sql.*;
public class UserDAO {

    public Boolean  authenticate(String UserName, String Password) throws Exception {
    final Connection con;
    String query = "SELECT * FROM Input WHERE UserName=? AND Password=?; ";	
    boolean login=true;
    try{
        con= DB.openConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, UserName);
        stmt.setString(2, Password);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            rs.close();
            stmt.close();
            DB.close();
            login = false;
            return login;
        } else{
            rs.close();
            stmt.close();
            DB.close(); 
            return login;
        }
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    } finally {
        try {
            DB.close();
        } catch (Exception e) {
            
        }
    }
    }
}
 //End of authenticate