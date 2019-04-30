package com.example.sqliteproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dao.MySqliiteOpenHelper;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        MySqliiteOpenHelper mySqliiteOpenHelper;
    }
}
