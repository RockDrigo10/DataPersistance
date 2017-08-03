package com.example.admin.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.admin.datapersistance.R.id.tvTextOne;
import static com.example.admin.datapersistance.R.id.tvTextOneB;

public class SecondActivity extends AppCompatActivity {
    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "Second";
    TextView tvTextOneB,tvTextTwoB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvTextOneB = (TextView) findViewById(R.id.tvTextOneB);
        tvTextTwoB = (TextView) findViewById(R.id.tvTextTwoB);

        SharedPreferences sharePreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        tvTextOneB.setText(sharePreferences.getString("value1","default"));
        tvTextTwoB.setText(sharePreferences.getString("value2","default"));
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
