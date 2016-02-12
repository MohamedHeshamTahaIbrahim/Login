package com.example.UI;

import android.app.AlertDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import Communication.SignupCommunication;
import Controller.SignupController;
import Data.DatabaseHelper;
import Data.SignUpModel;


public class SecondSignUp extends ActionBarActivity {
static String email,password,confirmpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sign_up);
       //em=getIntent().getExtras().getString("email");
/*        PlaceholderFragment f=new PlaceholderFragment();
        Bundle bundle=new Bundle();
        bundle.putString("key","email");
        f.setArguments(bundle);
        */
        if (savedInstanceState == null) {
            email=getIntent().getExtras().getString("email");
            password=getIntent().getExtras().getString("password");
            confirmpassword=getIntent().getExtras().getString("confirmpassword");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_sign_up, menu);
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
      EditText phone,address,gender;
      Button signup;
        TextView m;
        private DatabaseHelper databaseHelper = null;


      SignupController controll=new SignupController();
       SignupCommunication s=new SignupCommunication();
      final SignUpModel model=new SignUpModel();
        String h;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
//          String w= getArguments().getString("email");

            View rootView = inflater.inflate(R.layout.fragment_second_sign_up, container, false);
          /*  Bundle mBundle = new Bundle();
            mBundle = getArguments();
            String rr= mBundle.getString("key");
            */

/*            FirstSignup n=new FirstSignup();
            n.getIntent();
           setArguments();*/

        /*    email=getArguments().getString("email");
            password=getArguments().getString("password");
            confirmpassword=getArguments().getString("confirmpassword");
*/
//String dd=getArguments().getString("email");
            phone=(EditText)rootView.findViewById(R.id.phone);
            address=(EditText)rootView.findViewById(R.id.address);
            gender=(EditText)rootView.findViewById(R.id.gender);
            m=(TextView)rootView.findViewById(R.id.textView);
            signup=(Button)rootView.findViewById(R.id.signup_button);
            //m.setText(email);
            /*String y=this.getArguments().getString("email");
            m.setText(y);*/
         //  m.setText(rr);
            /*email=getArguments().getString("email");
            password=getArguments().getString("password");
            confirmpassword=getArguments().getString("confirmpassword");*/
            //email.ge
            m.setText(model.getEmail());
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phoneavailable = controll.checkPhoneavailable(phone.getText().toString());
                    Toast.makeText(getContext(), phoneavailable, Toast.LENGTH_SHORT).show();

                    String addressavailable = controll.checkAddressavailable(address.getText().toString());
                    Toast.makeText(getContext(), addressavailable, Toast.LENGTH_SHORT).show();
                    String genderavailable = controll.checkGenderavailable(gender.getText().toString());
                    Toast.makeText(getContext(), genderavailable, Toast.LENGTH_SHORT).show();
                    String result = s.checkSignup(email, password, confirmpassword, phone.getText().toString(), address.getText().toString(), gender.getText().toString());
                    if (result.equals("right")){
                        model.setEmail(email);
                    model.setPassw(password);
                    model.setConfirmpassword(confirmpassword);
                    model.setPhone(phone.getText().toString());
                    model.setAddress(address.getText().toString());
                    model.setGender(gender.getText().toString());
                    try {
                        final Dao<SignUpModel, String> signupDao = getHelper().getSignupmodelDao();
                        signupDao.create(model);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                    else {
                        showMessageDialog("All fields are mandatory !!");
                    }

                    /*Problem in this code*/
                   /* FirstSignup.PlaceholderFragment mmm=new FirstSignup.PlaceholderFragment();
                    Bundle bundle=getArguments();
                    email=bundle.getString(mmm.emaild);
                   */
                    //emailhh=mmm.email.getText().toString();
                    //  m.setText("emailhh");
                    // s.checkSignup(email);
                    //  mmm.getArguments().getString(emaild);
                    //email=((EditText)getActivity().findViewById(R.id.email)).getText().toString();

                    //  m.setText(email);
                    //s.checkSignup(email);
                    //  String email,password,confirmpassword;
                  /* Intent n=new Intent();

                    email=n.getStringExtra("email");
                    password=n.getStringExtra("password");
                    confirmpassword=n.getStringExtra("confirmpassword");*/

                  /*  String sin=s.checkSignup(email);
                    if(sin.equals("right")){
                     Toast.makeText(getContext(),"dd",Toast.LENGTH_SHORT).show();
                    }*/
                }
            });

            return rootView;
        }
        private DatabaseHelper getHelper() {
            if (databaseHelper == null) {
                databaseHelper = OpenHelperManager.getHelper(getContext(),DatabaseHelper.class);
            }
            return databaseHelper;
        }
        private void showMessageDialog(final String message)
        {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setMessage(message);
            final AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            if (databaseHelper != null) {
                OpenHelperManager.releaseHelper();
                databaseHelper = null;
            }
        }
        /*public void setemail(String email){
            //     String n;
            cc=email;
        }*/
    }

}
