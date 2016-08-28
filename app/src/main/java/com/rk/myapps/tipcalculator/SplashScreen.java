package com.rk.myapps.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class SplashScreen extends Activity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;
    private HTextView splashHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // HTextView to show animated text
        splashHeader = (HTextView) findViewById(R.id.splash_header);
        splashHeader.setTypeface(FontManager.getInstance(getAssets()).getFont("fonts/PoiretOne-Regular.ttf"));

        splashHeader.setAnimateType(HTextViewType.LINE);
        splashHeader.animateText(getString(R.string.app_name));

        //Full-Screen window
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //To show full screen
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

