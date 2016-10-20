package com.annuity.ilya.fursa.annuitycalculator.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.annuity.ilya.fursa.annuitycalculator.R;
import com.annuity.ilya.fursa.annuitycalculator.math.AnnuityCalculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCalc, btnClear;
    private EditText etCreditSum, etPeriod, etPerRate, etMonPay, etOverPay, etMonPerRate, etCommSum, etComPay;
    private AnnuityCalculator annuityCalculator;
    private double mPerRate, monCreditPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = (Button)findViewById(R.id.btnCalc);

        etCreditSum = (EditText)findViewById(R.id.etCreditSum);
        etPeriod = (EditText)findViewById(R.id.etPeriod);
        etPerRate = (EditText)findViewById(R.id.etPerRate);
        etMonPay = (EditText)findViewById(R.id.etMonPay);
        etOverPay = (EditText)findViewById(R.id.etOverPay);
        etMonPerRate = (EditText)findViewById(R.id.etMonPerRate);
        etCommSum = (EditText)findViewById(R.id.etCommSum);
        etComPay = (EditText)findViewById(R.id.etCommPay);

        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


            annuityCalculator = new AnnuityCalculator();

            double perRate = Double.parseDouble(String.valueOf(etPerRate.getText()));
            double creditSum = Double.parseDouble(String.valueOf(etCreditSum.getText()));
            int period = Integer.parseInt(String.valueOf(etPeriod.getText()));

            mPerRate = annuityCalculator.calculatePercentRate(perRate);
            etMonPerRate.setText(String.format("%.2f", mPerRate) + " %");

            monCreditPay = annuityCalculator.calculateMonthPayment(creditSum, mPerRate, period);
            etMonPay.setText(String.format("%.2f", monCreditPay) + " руб");

            double overPay = annuityCalculator.overPay(monCreditPay, period, creditSum);
            etOverPay.setText(String.format("%.2f", overPay) + " руб");

            double comSum = annuityCalculator.sumWithOverPay(monCreditPay, period);
            etCommSum.setText(String.format("%.2f", comSum) + " руб");

            double comPay = annuityCalculator.comPayCalc(comSum, overPay);
            etComPay.setText(String.format("%.2f", comPay));

         //   annuityCalculator.printPaymentInfo(period, creditSum, perRate, monCreditPay);
            showSnackbar(view);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showSnackbar(View view) {


    }
}
