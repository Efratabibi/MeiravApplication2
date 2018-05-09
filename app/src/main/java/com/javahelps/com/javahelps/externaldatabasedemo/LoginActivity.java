package com.javahelps.com.javahelps.externaldatabasedemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;



/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    // UI references.

    private EditText mPasswordView,mUserName;
    private View mProgressView;
    private View mLoginFormView;
    private ListView simpleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mUserName = (EditText) findViewById(R.id.txtUserName);
        mPasswordView = (EditText) findViewById(R.id.txtPassword);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> UserNames = databaseAccess.getUserNames();
        final List<String> Passwords = databaseAccess.getPasswords();
        final List<String> issecretary = databaseAccess.getissecretary();
        final List<String> istech = databaseAccess.getistech();
        databaseAccess.close();
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
               String EnteredUserName=mUserName.getText().toString();
                String EnteredPass=mPasswordView.getText().toString();
                if (UserNames.contains(EnteredUserName)) {
                    if (Passwords.indexOf(EnteredPass)==UserNames.indexOf(EnteredUserName)){
                        if (istech.get(UserNames.indexOf(EnteredUserName)).equals("1")) {
                            String empName=databaseAccess.getTechDetails(EnteredUserName);
                            Intent macintoshIntent = new Intent(LoginActivity.this, TechMainActivity.class);
                            startActivity(macintoshIntent);
                            finish();
                        }
                        else {
                            if (issecretary.get(UserNames.indexOf(EnteredUserName)).equals("1")) {
                                String empName=databaseAccess.getTechDetails(EnteredUserName);
                                Intent macintoshIntent2 = new Intent(LoginActivity.this, SecMainActivity.class);
                                startActivity(macintoshIntent2);
                                finish();
                            }
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "הסיסמא שהזנת שגויה", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"שם המשתמש לא קיים במערכת",Toast.LENGTH_LONG).show();
                }
           /*     if (EnteredUserName.equalsIgnoreCase("efrat") && EnteredPass.equals("123"))
                {
                    Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    Toast.makeText(LoginActivity.this,"התחברת בהצלחה למערכת",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"שם המשתמש או הסיסמא לא נכונים",Toast.LENGTH_LONG).show();
                } */
            }
        });
    }

}

