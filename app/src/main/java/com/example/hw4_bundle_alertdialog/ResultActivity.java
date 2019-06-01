package com.example.hw4_bundle_alertdialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        tvResult = (TextView)findViewById(R.id.tvResult);
        showResult();
    }
    private void showResult(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int dataStructure = bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("algorithm");
        int sum = programming + dataStructure + algorithm;
        double average = sum/3.0;
        String text = "programming = " + programming +
                "\ndataStructure = " + dataStructure +
                "\nalgorithm = " + algorithm +
                "\nsum = " + sum +
                "\naverage = " + nf.format(average);
        tvResult.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic = 0;
        if(average == 100){
            message = "100";
            title = "PASS";
            pic = R.drawable.tick;
        }
        else if(average >= 80 && average < 100){
            message = "excellent";
            title = "PASS";
            pic = R.drawable.circle;
        }
        else if(average >= 60 && average < 80){
            message = "ordinary";
            title = "PASS";
            pic = R.drawable.circle;
        }else {
            message = "SO BAD";
            title = "FAIL";
            pic = R.drawable.fork;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
        builder.setPositiveButton("OK" ,null);
        builder.setNegativeButton("Cancel" ,null);
        builder.setNegativeButton("Nothing" ,null);
    }
    public void onBackClick(View view){
        finish();
    }
}
