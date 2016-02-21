package com.example.UI;

        import android.content.Context;
        import android.content.Intent;

/**
 * Created by محمد on 18/02/2016.
 */
public class ScreenManager {
  /* static public void openSecondsignup(Context first,Context second){
        Intent m=new Intent(first,second);
    }*/
    UIConstant uiConstant =new UIConstant();
  static public void openSecondsignup(Context firstScreen,String email,String password,String confirmPassword){
      Intent m=new Intent(firstScreen,SecondSignUp.class);
      m.putExtra(UIConstant.emailValid, email);
      m.putExtra(UIConstant.passwordValid,password);
      m.putExtra(UIConstant.confirmPassvalid,confirmPassword);
      firstScreen.startActivity(m);
  }
}
