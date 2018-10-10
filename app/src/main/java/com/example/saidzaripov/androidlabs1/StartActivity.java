package com.example.saidzaripov.androidlabs1;
import com.example.saidzaripov.androidlabs1.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;


import static android.widget.RelativeLayout.TRUE;


public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "StartActivity";
    Button startButton, chatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        startButton = findViewById(R.id.button);
        chatButton = findViewById(R.id.chat_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent listIntent = new Intent(StartActivity.this, ListItemsActivity.class);
                Bundle listBundle = new Bundle();
                listBundle.putString("title", "Registration Form");
                listIntent.putExtras(listBundle);
                startActivityForResult(listIntent, 50);
            }
        });

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(ACTIVITY_NAME, "User clicked Start Chat");

                Intent startIntent = new Intent(StartActivity.this, ChatWindow.class);
                startActivity(startIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context = getApplicationContext();
        if (requestCode == 50 && resultCode == Activity.RESULT_OK) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
            if (data != null) {
                String messagePassed = data.getStringExtra("Response");
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, messagePassed, duration);
                toast.show(); //display message box
            }
        }
    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}