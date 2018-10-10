package com.example.saidzaripov.androidlabs1;

import com.example.saidzaripov.androidlabs1.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    TextView emailText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(ACTIVITY_NAME, "In onCreate()");


        emailText = findViewById(R.id.email_edit_text);
        loginButton = findViewById(R.id.login_button);

        final SharedPreferences reader = getSharedPreferences("", MODE_PRIVATE);
        String emailString = reader.getString("DefaultEmail", "email@domain.com");
        emailText.setText(emailString);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String input = emailText.getText().toString();
                final SharedPreferences.Editor editor = reader.edit();
                editor.putString("DefaultEmail", input);
                editor.apply();

                Intent startIntent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(startIntent);
            }
        });

    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
        getEmail();
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
        saveEmail();

    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    private void saveEmail() {
        String email = emailText.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("app_state", MODE_PRIVATE).edit();
        editor.putString("Email", email);
        editor.commit();
    }

    private void getEmail() {
        SharedPreferences reader = getSharedPreferences("", MODE_PRIVATE);
        String emailString = reader.getString("Default Email", emailText.getText().toString());
        emailText.setText(emailString);
    }

}