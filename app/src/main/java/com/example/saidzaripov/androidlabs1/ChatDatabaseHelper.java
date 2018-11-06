package com.example.saidzaripov.androidlabs1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ChatDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "chathelper.db";
    private static final int VERSION_NUM = 7;

    public static final String KEY_MESSAGE_TABLE = "Messages";
    public static final String KEY_ID = "id";
    public static final String KEY_MESSAGE = "msg";
    public static final String TAG = "ChatDatabaseHelper";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Calling onCreate");
        db.execSQL("CREATE TABLE " + KEY_MESSAGE_TABLE + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_MESSAGE + " text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Calling onUpgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME + ";");
        onCreate(db);
    }
}