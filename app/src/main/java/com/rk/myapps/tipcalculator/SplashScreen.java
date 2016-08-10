package com.rk.myapps.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class SplashScreen extends Activity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;
    private HTextView splashHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashHeader = (HTextView) findViewById(R.id.splash_header);
        splashHeader.setTypeface(FontManager.getInstance(getAssets()).getFont("fonts/PoiretOne-Regular.ttf"));

        splashHeader.setAnimateType(HTextViewType.LINE);
        splashHeader.animateText(getString(R.string.app_name));

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}

