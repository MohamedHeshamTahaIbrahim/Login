package Communication;

import Controller.SignupController;

/**
 * Created by محمد on 05/02/2016.
 */
public class SignupCommunication {
 SignupController controll=new SignupController();
    public String checkSignup(String email,String password,String confirmpassword,String phone,String address,String gender){
        String emailvalid,passwordequal,phoneequal,addressequal,genderequal;
        emailvalid=controll.validateEmail(email);
        passwordequal=controll.checkPasswordequal(password,confirmpassword);
     phoneequal=controll.checkPhoneavailable(phone);
        addressequal=controll.checkAddressavailable(address);
        genderequal=controll.checkGenderavailable(gender);

       /* passwordequal=controll.checkPasswordequal(password,confirmpassword);
        phoneequal=controll.checkPhoneavailable(phone);
        addressequal=controll.checkAddressavailable(address);
        genderequal=controll.checkGenderavailable(gender);*/
        if((emailvalid.equals("email valid"))&&(passwordequal.equals( "password equal confirmpassword"))&&(phoneequal.equals("Phone available"))&&(addressequal.equals("Address available"))&&(genderequal.equals("Gender avaliable"))){
            return "right";
        }
     else {
            return "false";
        }
    }
}
