package com.example.saidzaripov.androidlabs1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";

    private Button btnLogin;
    private EditText edTEmailAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "onCreate()");

        btnLogin = findViewById(R.id.btnLogin);
        edTEmailAddress = findViewById(R.id.edTEmailAddress);
        final SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.myPrefs), Context.MODE_PRIVATE);
        if (edTEmailAddress != null) {
            edTEmailAddress.setText(sharedPref.getString(getString(R.string.emailAddressKey), "chrischerryholme@gmail.com"));
        }


        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edTEmailAddress != null) {
                        String emailAddress = edTEmailAddress.getText().toString();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.emailAddressKey), emailAddress);
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestory()");
    }
}
