package com.example.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

import Controller.LoginController;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        EditText username;
        EditText password;
        Button login;
        Button signup;
        LoginController control=new LoginController();
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            username=(EditText)rootView.findViewById(R.id.username);
            password=(EditText)rootView.findViewById(R.id.passsword);
            login=(Button)rootView.findViewById(R.id.login_button);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*This variable define result of Is_User_Valid
                 int result=control.isUservalid(username.getText().toString(),password.getText().toString());*/
                    /*This variable define result of  Is_User_Support
                    boolean user_support=control.isUsersupport(username.getText().toString(),password.getText().toString());*/
                    /*This variable define result of is_user_vaild_or_support*/
                    String uservalidsupport=control.isUservalidorsupport(username.getText().toString(), password.getText().toString());
                    Toast.makeText(getContext(),uservalidsupport,Toast.LENGTH_SHORT).show();
                }
            });
            signup=(Button)rootView.findViewById(R.id.signup_button);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent signup=new Intent(getContext(),FirstSignup.class);
                    startActivity(signup);
                }
            });
            return rootView;

        }
    }
}
