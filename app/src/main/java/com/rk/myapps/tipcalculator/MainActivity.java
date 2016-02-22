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

    EditText bill_Amount;
    EditText tip_Percent;
    TextView tip_Amount;
    TextView total_Amount;
    EditText no_Of_Ppl;
    TextView each_Person_Pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill_Amount = (EditText) findViewById(R.id.bill_amount);
        tip_Percent = (EditText) findViewById(R.id.tip_percent);
        tip_Amount = (TextView) findViewById(R.id.tip_amount);
        total_Amount = (TextView) findViewById(R.id.total_amount);
        no_Of_Ppl = (EditText) findViewById(R.id.no_of_ppl);
        each_Person_Pay = (TextView) findViewById(R.id.each_person_pay);

        String default_value1 = "0.0";
        String default_value2 = "0";

        bill_Amount.setText(default_value1);
        tip_Percent.setText(default_value2);
        tip_Amount.setText(default_value1);
        total_Amount.setText(default_value1);
        no_Of_Ppl.setText(default_value2);
        each_Person_Pay.setText(default_value1);
    }

    /**
     * Calculate total tip
     * @param view
     */
    public void calculateTip(View view)
    {
        double billAmount = 0.0;
        double tipPercent = 0.0;
        double tipAmount = 0.0;
        double totalAmount = 0.0;
        double noOfPpl = 0.0;
        double eachPersonpay = 0.0;

        int duration = Toast.LENGTH_LONG;
        CharSequence message = "Please enter valid amount";
        Context context = getApplicationContext();

        Button cal = (Button) findViewById(R.id.calculate);

        if(bill_Amount.getText().equals(""))
        {
            Toast toast = Toast.makeText(context, message, duration);
            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (bill_Amount.getText().length() > 0) {
            billAmount = Integer.parseInt(bill_Amount.getText().toString());
        }

        if(tip_Percent.getText().equals(""))
        {
            Toast toast = Toast.makeText(context, message, duration);
            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (tip_Percent.getText().length() > 0) {
            tipPercent = Integer.parseInt(tip_Percent.getText().toString());
        }

        if(no_Of_Ppl.getText().equals(""))
        {
            Toast toast = Toast.makeText(context, message, duration);
            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (no_Of_Ppl.getText().length() > 0) {
            noOfPpl = Integer.parseInt(no_Of_Ppl.getText().toString());
        }

        tipAmount = (billAmount * tipPercent) / 100;
        tip_Amount.setText(Double.toString(tipAmount));

        totalAmount = billAmount + tipAmount;
        total_Amount.setText(Double.toString(totalAmount));

        eachPersonpay = totalAmount / noOfPpl;
        each_Person_Pay.setText(Double.toString(eachPersonpay));

    }
}
