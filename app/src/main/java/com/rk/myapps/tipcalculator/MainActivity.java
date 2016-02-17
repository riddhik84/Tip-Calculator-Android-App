package com.rk.myapps.tipcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateTip(View view)
    {
        int duration = Toast.LENGTH_LONG;
        CharSequence message = "Please enter valid amount";
        Context context = getApplicationContext();

        EditText billAmount = (EditText) findViewById(R.id.bill_amount);
        EditText tipPercent = (EditText) findViewById(R.id.tip_percent);
        TextView tipAmount = (TextView) findViewById(R.id.tip_amount);
        TextView totalAmount = (TextView) findViewById(R.id.total_amount);
        EditText noOfPpl = (EditText) findViewById(R.id.no_of_ppl);
        TextView eachPersonPay = (TextView) findViewById(R.id.each_person_pay);

        Button cal = (Button) findViewById(R.id.calculate);

        if(billAmount.getText().equals(null))
        {
            Toast toast = Toast.makeText(context, message, duration);
            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (billAmount.getText() != null) {
            totalAmount.setText(billAmount.getText());
        }
    }
}
