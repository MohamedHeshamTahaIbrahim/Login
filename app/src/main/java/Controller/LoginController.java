package Controller;

import android.content.Intent;

import com.example.UI.MainActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Communication.LoginCommunication;

/**
 * Created by محمد on 01/02/2016.
 */
public class LoginController {


LoginCommunication communicate=new LoginCommunication();
    public int isUservalid(String username,String password){
        int uservalid;
         uservalid=communicate.isUservalid(username, password);
        return uservalid;
    }
    public boolean isUsersupport(String username,String password){
        int uservalid=isUservalid(username, password);
        boolean support;
        support=communicate.isUsersupport(uservalid);
        return support;
    }

public String isUservalidorsupport(String username,String password) {
   int uservalid=isUservalid(username,password);
    boolean support=isUsersupport(username,password);
    //user_valid = is_User_valid(username, password);
    //user_support = is_User_support(id);
    if (uservalid == 1 && support == true) {


        return "user_valid and user_support";

    } else if (uservalid == 1 && support == false) {
        return "user_valid but not user_support";
    } else if (uservalid == 0 && support == true) {
        return "user_not_valid but user_support";
    } else if (uservalid == 0 && support == false) {
        return "user_not_valid and not user_support";
    } else {
        return "user _not valid and user_not support";
    }
}

}
