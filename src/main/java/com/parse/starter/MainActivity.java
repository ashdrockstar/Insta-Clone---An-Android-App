/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



public class MainActivity extends AppCompatActivity implements View.OnKeyListener,View.OnClickListener {


    EditText username;
    EditText password;
    TextView label;
    Button button;
    RelativeLayout relativeLayout;
    ImageView logo;

    static boolean signUpMode=true;

    public void proceedFurther()
    {
        Log.i("Inside","Proceed Further");
        Intent intent=new Intent(getApplicationContext(),UserList.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//    ParseAnalytics.trackAppOpenedInBackground(getIntent());


        if(ParseUser.getCurrentUser().getUsername()!=null)
            proceedFurther();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        label = (TextView) findViewById(R.id.label);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
        logo=(ImageView)findViewById(R.id.logo);

        username.setOnKeyListener(this);
        password.setOnKeyListener(this);

        relativeLayout.setOnClickListener(this);
        logo.setOnClickListener(this);

        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signUpMode==true)
                {
                    label.setText("Sign Up");
                    button.setText("Log In");
                    signUpMode=false;
                }
                else
                {
                    label.setText("Log In");
                    button.setText("Sign Up");
                    signUpMode=true;
                }
            }
        });

    }

    public void signUpOrLogIn(View view) {
//        Log.i("Appinfo", username.getText().toString() + " : " + password.getText().toString());

        if(signUpMode==true) {
            ParseUser user = new ParseUser();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null)
                        Log.i("Sign Up", "Successful");
                    else {
                        Log.i("Sign Up", "Unsuccessful");
                        Toast.makeText(getApplicationContext(), e.getMessage().substring(e.getMessage().indexOf(" ")), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(user!=null)
                    {
                        Toast.makeText(getApplicationContext(),"Login: Successful", Toast.LENGTH_SHORT).show();
                        proceedFurther();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Login: Unsuccessful", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });


        }
    }



    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

        if(keyCode==KeyEvent.KEYCODE_ENTER && keyEvent.getAction()==keyEvent.ACTION_DOWN)
            signUpOrLogIn(view);
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.logo || view.getId()==R.id.relativeLayout)
        {
            InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }
}
