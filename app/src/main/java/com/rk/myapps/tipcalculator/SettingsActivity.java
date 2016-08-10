package com.rk.myapps.tipcalculator;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toolbar;

import java.lang.annotation.Target;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

        //Add toolbar
        setToobar();

    }

    @TargetApi(21)
    void setToobar() {
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
            Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setActionBar(toolbar);
        }
    }
}
