package cn.edu.bupt.model;

public class UserInfo {
    private String username;
    private String password;
    
    public UserInfo(String aName, String aPass) {
        this.username = aName;
        this.password = aPass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
