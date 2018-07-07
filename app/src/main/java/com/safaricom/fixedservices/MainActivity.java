package com.safaricom.fixedservices;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

/**
 * MainActivity
 * The main entry to the application from the launcher application
 * Created by Victor Rwanda <vrwanda@safaricom.co.ke> on 3/13/18.
 */

public class MainActivity extends Activity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btLogin = findViewById(R.id.login);

    }

    /**
     * Sets user data for authentication
     *
     * @param username
     * @param password
     */
    public void setViewData(String username, String password) {
        etUsername.setText(username);
        etPassword.setText(password);
    }

    /**
     * Clears user data after authentication
     */
    public void clearViewData() {
        etUsername.setText("");
        etPassword.setText("");
    }

    /**
     * Authenticates a user
     *
     * @return
     */
    public boolean loginUser() {
        return authenticateUser(etUsername.getText().toString(), etPassword.getText().toString());
    }

    /**
     * Authenticate user if any data was provided
     *
     * @param username
     * @param password
     * @return
     */
    public boolean authenticateUser(String username, String password) {
        return username.length() > 0 && password.length() > 0;
    }
}
