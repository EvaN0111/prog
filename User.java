package gr.aueb.dmst.ecg.eprog;

public class User {
    
    private String Fullname;
	private String UserName;
	private String Password;

    /**
     * Full constuctor
     * @param Fullname
     * @param UserName
     * @param Password
     */
    public User(String Fullname, String UserName, String Password) {        
        this.Fullname = Fullname;
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public void setUsername(String UserName) {
        this.UserName = UserName;
    }
    public String getUsername() {
        return UserName;
    }
    public void setPassword(String Password) {
        this.Password = Password;        
    }  

    public String getPassword() {
        return Password;
    }


}