package Communication;

import Data.LoginModel;

/**
 * Created by محمد on 01/02/2016.
 */
public class LoginCommunication {
    /*public boolean Is_user_valid(String username,String Password){
        if(username=="Mohamed"&&)

    }*/
    LoginModel data=new LoginModel();
    public int isUservalid(String username,String password){
        data.setUsername("mohamed");
        data.setPassword("dodoo_12FK");
        if(username.equals(data.getUsername())&&password.equals(data.getPassword())){

            return 1;
        }
       else{
            return 0;
        }

    }
    public boolean isUsersupport(int id){
        if(id==1) {
        return true;
        }
        else {
            return false;
        }
    }
}
