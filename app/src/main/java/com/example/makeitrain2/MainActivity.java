package com.example.makeitrain2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button makeItRain;
    private Button showBalance;
    private TextView youHave;
    private TextView amount;
    private int moneyCounter = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        makeItRain = findViewById(R.id.makeItRain);
        showBalance = findViewById(R.id.showBalance);
        youHave = findViewById(R.id.youHave);
        amount = findViewById(R.id.amount);

        amount.setText(R.string._2000);

        //amount.setTextColor(getResources().getColor(R.color.orange)); //One Way of Setting color

        amount.setTextColor(ContextCompat.getColor(this,R.color.orange));



        


    }


    public void showMoney(View view) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter+=1000;

        amount.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "showMoney: "+moneyCounter);

        switch (moneyCounter){
            case 5000:
                amount.setTextColor(ContextCompat.getColor(this, R.color.red));
                break;

            case 10000:
                amount.setTextColor(ContextCompat.getColor(this,R.color.white));
                break;

            case 15000:
                amount.setTextColor(Color.GREEN);
                break;

            case 20000:
                amount.setTextColor(Color.BLUE);
                break;

            default:
                amount.setTextColor(Color.BLACK);
        }
    }

    public void showInfo(View view) {
//        Toast.makeText(this, R.string.app_info, Toast.LENGTH_SHORT).show();
        Snackbar.make(amount, R.string.app_info,Snackbar.LENGTH_LONG).setAction("More", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.heloooo, Toast.LENGTH_SHORT).show();
            }
        }).show()
        ;

    }
}
