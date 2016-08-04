package com.rk.myapps.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        toolbar.setCollapsible(true);
//        toolbar.setTitle(getString(R.string.about_header));
//        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
