package com.example.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Controller.LoginController;
import Controller.SignupController;


public class FirstSignup extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_signup);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
       EditText email_ed;
       EditText password_ed;
       EditText confirm_Password_ed;
       Button next;
        String emaild;
      SignupController signupController=new SignupController();
        UIConstant uiConstant=new UIConstant();
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_first_signup, container, false);
            email_ed=(EditText)rootView.findViewById(R.id.email);
            password_ed=(EditText)rootView.findViewById(R.id.pass);
            confirm_Password_ed=(EditText)rootView.findViewById(R.id.confirmpassword);
            next=(Button)rootView.findViewById(R.id.next_button);
           // String nn=email.getText().toString();

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               boolean emailverification;
                boolean passwordverification;
                  emailverification= signupController.IsEmailVerification(email_ed.getText().toString());
                    if(emailverification==false){
                        email_ed.setError("email is not valid");
                    }
                 //Toast.makeText(getContext(),"result:"+emailverification,Toast.LENGTH_SHORT).show();
                 passwordverification=signupController.IsPasswordVerification(password_ed.getText().toString(),confirm_Password_ed.getText().toString());
                 // Toast.makeText(getContext(),"passresult:"+passwordverification,Toast.LENGTH_SHORT).show();
                   if(passwordverification==false){
                       password_ed.setError("paassword is not match confirm password");
                   }
                         /* FirstSignup jj=new FirstSignup();
                    Bundle bundle=new Bundle();
                    bundle.putString("email",email.getText().toString());
                    setArguments(bundle);*/
                   /* SecondSignUp.PlaceholderFragment mm=new SecondSignUp.PlaceholderFragment();
                    mm.setemail(email.getText().toString());
*/

                    if(emailverification==true&&passwordverification==true){
                       ScreenManager screenManager=new ScreenManager();
                        screenManager.openSecondsignup(getActivity(),email_ed.getText().toString(),password_ed.getText().toString(),confirm_Password_ed.getText().toString());
                      /*  Intent intent=new Intent(getActivity(),SecondSignUp.class);
                      intent.putExtra(uiConstant.emailValid,email.getText().toString());
                      intent.putExtra(uiConstant.passwordValid,password.getText().toString());
                       intent.putExtra(uiConstant.confirmPassvalid,confirmpassword.getText().toString());

                        getActivity().startActivity(intent);*/
                      /*  SecondSignUp second=new SecondSignUp();
                        Bundle uu=new Bundle();
                        uu.putString("email",email.getText().toString());
                        second.setArguments*/
                       /* next.putExtra("email",email.getText().toString());
                        next.putExtra("password",password.getText().toString());
                        next.putExtra("confirmpassword",confirmpassword.getText().toString());
                        */
                         /*Problem here*/


 /*                       Bundle bundle=new Bundle();
                        bundle.putString(emaild,email.getText().toString());
                        SecondSignUp.PlaceholderFragment m=new SecondSignUp.PlaceholderFragment();
                        m.setArguments(bundle);
*/

                       /* Bundle arguments=new Bundle();
                        arguments.putString("email",email.getText().toString());
                        SecondSignUp.PlaceholderFragment ss=new SecondSignUp.PlaceholderFragment();
                        ss.setArguments(arguments);
                        */

                      /*  next.putExtra("email",email.getText().toString());
                        next.putExtra("password",password.getText().toString());
                        next.putExtra("confirmpassword",password.getText().toString());
*/

                    }

                }
            });
            return rootView;
        }
/*private Fragment createcustomFragment(){
    Bundle bundle=new Bundle();
    bundle.putString(emaild,email.getText().toString());
    SecondSignUp.PlaceholderFragment m=new SecondSignUp.PlaceholderFragment();
    m.setArguments(bundle);
    return m;
}*/
    }
}
