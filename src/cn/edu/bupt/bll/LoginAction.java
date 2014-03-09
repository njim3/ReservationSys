package cn.edu.bupt.bll;

import cn.edu.bupt.model.Statics;
import cn.edu.bupt.model.UserInfo;
import cn.edu.bupt.util.SysTool;

public class LoginAction {
    private UserInfo userInfo;
    
    public LoginAction(UserInfo aUser) {
        this.userInfo = aUser;
    }
    
    public boolean login() {
        String username = this.userInfo.getUsername();
        String password = this.userInfo.getPassword();
        
        if (username == null || password == null)
            return false;
        
        String md5PasswordStr = SysTool.md5(password).toLowerCase();
        
        if ((!username.equals(Statics.USERNAME)) || 
                (!md5PasswordStr.equals(Statics.PASSWORD)))
            return false;
        
        return true;
    }
    
    
}
