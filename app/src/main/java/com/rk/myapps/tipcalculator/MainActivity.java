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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    EditText bill_amount_edittext;
    EditText tip_percent_edittext;
    EditText no_of_ppl_edittext;
    TextView tip_amount_textview;
    TextView total_amount_textview;
    TextView each_person_pay_textview;
    Button calculate_tip;

    final String DEFAULT_VALUE1 = "0.0";
    final String DEFAULT_VALUE2 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill_amount_edittext = (EditText) findViewById(R.id.bill_amount);
        tip_percent_edittext = (EditText) findViewById(R.id.tip_percent);
        tip_amount_textview = (TextView) findViewById(R.id.tip_amount);
        total_amount_textview = (TextView) findViewById(R.id.total_amount);
        no_of_ppl_edittext = (EditText) findViewById(R.id.no_of_ppl);
        each_person_pay_textview = (TextView) findViewById(R.id.each_person_pay);

        calculate_tip = (Button) findViewById(R.id.calculate);

        bill_amount_edittext.setText(DEFAULT_VALUE2);
        tip_percent_edittext.setText(DEFAULT_VALUE2);
        tip_amount_textview.setText(DEFAULT_VALUE2);
        total_amount_textview.setText(DEFAULT_VALUE2);
        no_of_ppl_edittext.setText(DEFAULT_VALUE2);
        each_person_pay_textview.setText(DEFAULT_VALUE2);
    }

    /**
     * Calculate total tip
     *
     * @param view
     */
    public void calculateTip(View view) {
        double billAmount = 0.0;
        double tipPercent = 0.0;
        double tipAmount = 0.0;
        double totalAmount = 0.0;
        double noOfPpl = 0.0;
        double eachPersonPay = 0.0;

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        if (bill_amount_edittext.getText().equals("")) {
            showToast();
//            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (bill_amount_edittext.getText().length() > 0) {
            billAmount = Double.parseDouble(bill_amount_edittext.getText().toString());
        }

        if (tip_percent_edittext.getText().equals("")) {
            showToast();
//            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (tip_percent_edittext.getText().length() > 0) {
            tipPercent = Double.parseDouble(tip_percent_edittext.getText().toString());
        }

        if (no_of_ppl_edittext.getText().equals("")) {
            showToast();
//            Log.e(LOG_TAG, "Toast shown on screen");
        } else if (no_of_ppl_edittext.getText().length() > 0) {
            noOfPpl = Integer.parseInt(no_of_ppl_edittext.getText().toString());
        }

        tipAmount = (billAmount * tipPercent) / 100;
        tip_amount_textview.setText(numberFormat.format(tipAmount));

        totalAmount = billAmount + tipAmount;
        total_amount_textview.setText(numberFormat.format(totalAmount));

        if (noOfPpl > 1) {
            eachPersonPay = totalAmount / noOfPpl;
            each_person_pay_textview.setText(Double.toString(eachPersonPay));
        } else {
            each_person_pay_textview.setText(numberFormat.format(totalAmount));
        }
    }

    public void showToast() {
        Toast.makeText(getApplicationContext(), getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
    }
}
