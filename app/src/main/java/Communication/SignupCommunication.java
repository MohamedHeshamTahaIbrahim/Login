package Communication;

import Controller.SignupController;

/**
 * Created by محمد on 05/02/2016.
 */
public class SignupCommunication {
 SignupController signupController=new SignupController();
    public boolean checkSignup(String email,String password,String confirmpassword,String phone,String address,String gender){
     boolean emailvalid,passwordequal,phoneequal,addressequal,genderequal;

        emailvalid=signupController.IsEmailVerification(email);
        passwordequal=signupController.IsPasswordVerification(password,confirmpassword);
     phoneequal=signupController.IsPhoneVerification(phone);
        addressequal=signupController.IsAddressVerification(address);
        genderequal=signupController.IsGenderVerification(gender);

       /* passwordequal=controll.checkPasswordequal(password,confirmpassword);
        phoneequal=controll.checkPhoneavailable(phone);
        addressequal=controll.checkAddressavailable(address);
        genderequal=controll.checkGenderavailable(gender);*/
        if((emailvalid==true)&&(passwordequal==true)&&(phoneequal==true)&&(addressequal==true)&&(genderequal==true)){
            return true;
        }
     else {
            return false;
        }
    }
}
