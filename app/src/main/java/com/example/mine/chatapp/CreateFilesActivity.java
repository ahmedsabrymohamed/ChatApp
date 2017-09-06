package com.example.mine.chatapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.File;


import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;


public class CreateFilesActivity extends AppCompatActivity implements Login_Fragment.OnFragmentInteractionListener {

    private WriteExcel we;
    private File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfiles);



        SharedPreferences activation_file = getSharedPreferences(getString(R.string.Activation_File), MODE_PRIVATE);


        if (activation_file.getString("FirstRun", "True").equals("True")) {

            checkFilePermissions();

            activation_file.edit().putString("FirstRun", "False").apply();


        }
    }

    @Override
    public void onLogin(String Uid) {

        Toast.makeText(this, "User Loged in", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), MainUserPage.class);

        intent.putExtra("Uid", Uid);

        startActivity(intent);

    }

    @TargetApi(23)
    private void checkFilePermissions() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {

            int permissionCheck = this.checkSelfPermission("Manifest.permission.READ_EXTERNAL_STORAGE");

            permissionCheck += this.checkSelfPermission("Manifest.permission.WRITE_EXTERNAL_STORAGE");

            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001); //Any number
            }
        } else {

            Log.d("TAG", "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1001&&grantResults[0]==PERMISSION_GRANTED&&grantResults[1]==PERMISSION_GRANTED){


            we=new WriteExcel();

            f = new File(Environment.getExternalStorageDirectory(), getResources().getString(R.string.uploadFileChatApp));

            we.setOutputFile(f);
            we.getContext(this);
            we.execute();


        }

    }


}
