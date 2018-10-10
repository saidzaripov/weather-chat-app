package com.example.saidzaripov.androidlabs1;

import com.example.saidzaripov.androidlabs1.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ListItemsActivity extends Activity {

    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView pictureImage;
    Switch itemSwitch;
    CheckBox itemCheck;


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    private void setOnCheckedChanged() {

        CharSequence text = "Switch is On";// "Switch is Off"
        int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

        Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
        toast.show(); //display your message box

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            pictureImage.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        pictureImage = findViewById(R.id.list_items_image_button);
        itemSwitch = findViewById(R.id.switch1);
        itemCheck = findViewById(R.id.list_items_checkbox);

        pictureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        itemSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Context context = getApplicationContext();
                if (isChecked) {
                    // The toggle is enabled

                    CharSequence text = "Switch is On";// "Switch is Off"
                    int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
                    Toast toast = Toast.makeText(context, text, duration); //this is the ListActivity
                    toast.show(); //display your message box
                } else {
                    // The toggle is disabled
                    CharSequence text = "Switch is Off";// "Switch is Off"
                    int duration = Toast.LENGTH_LONG; //= Toast.LENGTH_LONG if Off
                    Toast toast = Toast.makeText(context, text, duration); //this is the ListActivity
                    toast.show(); //display your message box
                }
            }
        });

        itemCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Context context = getApplicationContext();
                if (isChecked) {
                    // The box is checked

                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", "Closed by the checkbox");
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish();
                                }
                            })

                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                }
                            })
                            .show();
                }
            }
        });
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