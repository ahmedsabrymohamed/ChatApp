package com.example.mine.chatapp;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by moon on 6/25/2017.
 */

public class AppStart extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }


}