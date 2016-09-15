/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.FunctionCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class StarterApplication extends Application {




    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
//
//        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myAppId786AishwaryPramanik")
                .clientKey("myMasterKey123Ash")
                .server("https://instash.herokuapp.com/parse/")
                .build()
        );

//      ParseObject gameScore = new ParseObject("GameScore");
//      gameScore.put("score", 1337);
//      gameScore.put("playerName", "Sean Plott");
//      gameScore.put("cheatMode", false);
//      gameScore.saveInBackground(new SaveCallback() {
//          public void done(ParseException e) {
//              if (e == null) {
//                  Log.i("Parse", "Save Succeeded");
//              } else {
//                  Log.i("Parse", "Save Failed");
//              }
//          }
//      });

//      ParseObject gameScore=new ParseObject("GameScore");
//      gameScore.put("score",223);
//      gameScore.put("playerName","Tinku Kumar");
//      gameScore.put("cheatMode",true);
//      gameScore.saveEventually();

//      ParseQuery<ParseObject> query=ParseQuery.getQuery("GameScore");
//      query.getInBackground("wvlg8JEsTc", new GetCallback<ParseObject>() {
//          @Override
//          public void done(ParseObject object, ParseException e) {
//              if(e==null) {
//                  object.put("score",1000);
//                  object.saveInBackground();
//                  Log.i("Id ","Updated");
//              }
//              else
//              {
//                  Log.i("Id ","Not Found");
//              }
//          }
//      });


//      ParseQuery<ParseObject> query=ParseQuery.getQuery("GameScore");
//      query.whereEqualTo("playerName","Aishwary Pramanik");
//      query.findInBackground(new FindCallback<ParseObject>() {
//          @Override
//          public void done(List<ParseObject> objects, ParseException e) {
//              if(e==null) {
//                  Log.i("Users ",String.valueOf(objects.size()));
//                  for (int i = 0; i < objects.size(); i++)
//                      Log.i("Name ",objects.get(i).getString("playerName"));
//              }
//              else
//                  Log.i("Error","Not data");
//          }
//      });



/*SIGNUP
        ParseUser user=new ParseUser();
        user.setUsername("Aishwary");
        user.setPassword("rockstar");
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    Log.i("SignUp","Successful");
                else {
                    Log.i("SignUp", "Failed");
                    e.printStackTrace();
                }
            }
        });

*/
      /*VALIDATE LOGIN
        ParseUser.logInInBackground("Aishwary", "rockstar", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user!=null)
                {
                    Log.i("Login","Successful");
                }
                else {
                    Log.i("Login","Unsuccessful");
                    e.printStackTrace();
                }
            }
        });
        */

    /* CHECK IF LOGGED IN

        if(ParseUser.getCurrentUser()!=null)
        {
            Log.i("User","Logged in");
        }
        else
        {
            Log.i("User","Logged not in");
        }
     */


        /* LOGOUT
            ParseUser.logOut();
        */


      ParseUser.enableAutomaticUser();  //To generate user automatically
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);




    }




}
