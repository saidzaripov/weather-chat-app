package com.example.saidzaripov.androidlabs1;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    private static String ACTIVITY_NAME = "StartActivity";

    private Button button;
    private Button chatButton;
    private Button weatherButton;
    private Button testToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent,50);
            }
        });

        chatButton = findViewById(R.id.chat_button);
        chatButton.setOnClickListener((v) -> {
            Log.i(ACTIVITY_NAME, "User clicked Start Chat");
            Intent chatIntent = new Intent(StartActivity.this, ChatWindow.class);
            startActivity(chatIntent);
        });

        weatherButton = findViewById(R.id.weather_button);
        weatherButton.setOnClickListener((v -> {
            Log.i(ACTIVITY_NAME, "User clicked Weather button");
            Intent weatherIntent = new Intent(StartActivity.this, WeatherForecast.class);
            startActivity(weatherIntent);
        }));

        testToolbar = findViewById(R.id.lab8_toolbar);
        testToolbar.setOnClickListener((v ->{
            Log.i(ACTIVITY_NAME, "User clicked Toolbar button");
            Intent toolbarIntent = new Intent(StartActivity.this,TestToolbar.class);
            startActivity(toolbarIntent);
        }));
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        if(requestCode == 50){
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }
        if(responseCode == Activity.RESULT_OK){
            Toast.makeText(this , data.getStringExtra("Response"), Toast.LENGTH_LONG).show();
        }
    }
}