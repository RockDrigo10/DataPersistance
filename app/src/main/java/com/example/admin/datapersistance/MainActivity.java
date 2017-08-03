package com.example.admin.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "First";
    EditText etOne,etTwo;
    TextView tvTextTwo,tvTextOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etOne = (EditText) findViewById(R.id.etOne);
        etTwo = (EditText) findViewById(R.id.etTwo);
        tvTextOne = (TextView) findViewById(R.id.tvTextOne);
        tvTextTwo = (TextView) findViewById(R.id.tvTextTwo);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
    }

    //persist data in phone
    public void saveData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1",etOne.getText().toString());
        editor.putString("value2",etTwo.getText().toString());

        boolean success =  editor.commit();
        if(success){
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();}
        else {
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();}
    }

    public void getData(View view) {
        SharedPreferences sharePreferences = getSharedPreferences(MY_PREF_FILE,Context.MODE_PRIVATE);
        tvTextOne.setText(sharePreferences.getString("value1","default"));
        tvTextTwo.setText(sharePreferences.getString("value2","default"));
        Toast.makeText(this, "Data Retriving", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "getData: " +sharePreferences.getString("value1","default"));
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
