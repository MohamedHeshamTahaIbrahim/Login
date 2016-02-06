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
       EditText email;
       EditText password;
       EditText confirmpassword;
       Button next;
        String emaild;
      SignupController control=new SignupController();
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_first_signup, container, false);
            email=(EditText)rootView.findViewById(R.id.email);
            password=(EditText)rootView.findViewById(R.id.pass);
            confirmpassword=(EditText)rootView.findViewById(R.id.confirmpassword);
            next=(Button)rootView.findViewById(R.id.next_button);
           // String nn=email.getText().toString();

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                String emailverification;
                String passwordverification;
                  emailverification= control.validateEmail(email.getText().toString());
                 Toast.makeText(getContext(),emailverification,Toast.LENGTH_SHORT).show();
                 passwordverification=control.checkPasswordequal(password.getText().toString(),confirmpassword.getText().toString());
                  Toast.makeText(getContext(),passwordverification,Toast.LENGTH_SHORT).show();
                         /* FirstSignup jj=new FirstSignup();
                    Bundle bundle=new Bundle();
                    bundle.putString("email",email.getText().toString());
                    setArguments(bundle);*/
                   /* SecondSignUp.PlaceholderFragment mm=new SecondSignUp.PlaceholderFragment();
                    mm.setemail(email.getText().toString());
*/
                    if(emailverification.equals("email valid")&&passwordverification.equals("password equal confirmpassword")){
                        Intent next=new Intent(getContext(),SecondSignUp.class);
                      /*  SecondSignUp second=new SecondSignUp();
                        Bundle uu=new Bundle();
                        uu.putString("email",email.getText().toString());
                        second.setArguments*/
                       /* next.putExtra("email",email.getText().toString());
                        next.putExtra("password",password.getText().toString());
                        next.putExtra("confirmpassword",confirmpassword.getText().toString());
                        */
                         /*Problem here*/


                        Bundle bundle=new Bundle();
                        bundle.putString(emaild,email.getText().toString());
                        SecondSignUp.PlaceholderFragment m=new SecondSignUp.PlaceholderFragment();
                        m.setArguments(bundle);

                        startActivity(next);
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
