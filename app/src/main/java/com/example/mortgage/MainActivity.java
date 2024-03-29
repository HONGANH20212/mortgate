package com.example.mortgage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import com.example.mortgage.Mortgage;


public class MainActivity extends AppCompatActivity {
    public static Mortgage mortgage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }
    protected void onStart(){
        super.onStart();
        updateView();
    }
    public void updateView(){
        TextView amountTV = (TextView) findViewById(R.id.amount);
        amountTV.setText( mortgage.getFormattedAmount());
        TextView yearsTV = (TextView)  findViewById(R.id.years);
        yearsTV.setText(""+ mortgage.getYears());
        TextView rateTV = (TextView) findViewById(R.id.rate);
        rateTV.setText(100 * mortgage.getRate()+"%");
        TextView monthlyTV = (TextView) findViewById(R.id.payment);
        monthlyTV.setText(mortgage.formattedMonthlyPayment());
        TextView totalTV = (TextView) findViewById(R.id.total);
        totalTV.setText(mortgage.formattedTotalPayment());
    }
    public void modifyData (View v) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.slide_form_left,0);
    }
}