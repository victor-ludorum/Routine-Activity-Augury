package minorproject.knowmyself.Other;



import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.Toast;

// Ref : https://androidexample.com/Android_Session_Management_Using_SharedPreferences_-_Android_Example/index.php?view=article_discription&aid=127
public class UserSessionManager {

    // Shared Preferences reference
    protected SharedPreferences pref;

    // Editor reference for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    public static final String PREFER_NAME = "AndroidExamplePref";
    public static final String KEY_USERID = "userid";
    // User name (make variable public to access from outside)
    public static final String KEY_PASSWORD = "password";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // Constructor
    public UserSessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString(KEY_EMAIL, " ");
    }

    //Create login session
    public void createUserLoginSession(String userid,String email, String password){
        // Storing name in pref
        editor.putString(KEY_USERID,userid);
        editor.putString(KEY_PASSWORD, password);
        editor.putString("PREVLAT","25.5938");
        editor.putString("PREVLONG","85.1605");


        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        // commit changes
        editor.commit();
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else do anything
     * */
    /*public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn()){

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, UsersListActivity.class);//ToDo

            // Closing all the Activities from stack
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);

            return true;
        }
        return false;
    }*/



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){

        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();


        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // user password
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));


        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

       /* // After logout redirect user to Login Activity //ToDo
        Intent i = new Intent(_context, LoginActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);*/
    }


    // Check for login
    /*public boolean isUserLoggedIn(){
        boolean val = pref.getBoolean(IS_USER_LOGIN, false);
        Log.d("continue","val is"+val);
            return pref.getBoolean(IS_USER_LOGIN, false);
    }*/
}