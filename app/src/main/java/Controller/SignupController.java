package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by محمد on 04/02/2016.
 */
public class SignupController {
    public String validateEmail(String email) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==true){
            return "email valid";
        }
        else {
            return "email not valid";
        }


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
   public String checkPasswordequal(String password,String confirmpassword){

       if(password.length()>0&&password.equals(confirmpassword)){
           return "password equal confirmpassword";
       }
       else {
           return "password not equal confirmpassword";
       }
   }
    public String checkPhoneavailable(String phone){
        if(phone.length()>0){
            return "Phone available";
        }
        else {
            return "please enter phone";
        }
    }

    public String checkAddressavailable(String address){
       if(address.length()>0){
           return "Address available";
       }
       else {
           return "please enter address";
       }
   }
    public String checkGenderavailable(String gender){
        if(gender.length()>0){
            return "Gender avaliable";
        }
        else{
            return "please enter gender";
        }
    }


}
