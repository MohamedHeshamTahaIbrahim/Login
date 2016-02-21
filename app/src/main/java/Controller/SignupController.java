package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by محمد on 04/02/2016.
 */
public class SignupController {
    public boolean IsEmailVerification(String email) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        /*if(matcher.matches()==true){
            return "email valid";
        }
        else {
            return "email not valid";
        }*/

    return matcher.matches();
    }
    /*public String checkPasswordlength(String password){
        if(password.length()>0){
            return "password write";
        }
        else
        {
            return "please enter password";
        }
    }*/
   public boolean IsPasswordVerification(String password,String confirmpassword){

       if(password.length()>0&&password.equals(confirmpassword)){
           return true;
       }
       else {
           return false;
       }
   }
    public boolean IsPhoneVerification(String phone){
        if(phone.length()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean IsAddressVerification(String address){
       if(address.length()>0){
           return true;
       }
       else {
           return false;
       }
   }
    public boolean IsGenderVerification(String gender){
        if(gender.length()>0){
            return true;
        }
        else{
            return false;
        }
    }


}
