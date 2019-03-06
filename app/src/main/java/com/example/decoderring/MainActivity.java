package com.example.decoderring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buildTable(View view) {
        int padding = (int)(getResources().getDimension(R.dimen.passing)/getResources().getDisplayMetrics().density);
        float tablefont = getResources().getDimension(R.dimen.table_text);
        CheckBox square = findViewById(R.id.square);
        CheckBox cube = findViewById(R.id.cube);
        CheckBox sqrt = findViewById(R.id.sqrt);
        CheckBox fact = findViewById(R.id.factorial);
        EditText min = findViewById(R.id.min);
        EditText max = findViewById(R.id.max);
        int minVal, maxVal;
        try {
            minVal = Integer.parseInt(min.getText().toString());
            maxVal = Integer.parseInt(max.getText().toString());
        } catch (InputMismatchException e) {
            minVal = 0;
            maxVal =0;
        }
        TableLayout table = findViewById(R.id.table);
        table.removeAllViews();
        for (int i = minVal; i<=maxVal; i++){
            TableRow newRow = new TableRow(this);
            TextView n = new TextView(this);
            setTextView(n, "" + i ,padding);
            TextView n2 = new TextView(this);
            setTextView(n2, "" + (i*i) ,padding);
            TextView n3 = new TextView(this);
            setTextView(n3, "" + (i*i*i) ,padding);
            TextView _2n = new TextView(this);
            setTextView(_2n, "" + (Math.sqrt(i)) ,padding);
            TextView nfact = new TextView(this);
            int temp = 1;
            for (int j = 1; j <= i; j++){
                temp*=j;
            }
            setTextView(nfact, "" + temp ,padding);
            table.addView(newRow);
            newRow.addView(n);
            if (square.isChecked()){
                newRow.addView(n2);
            }
            if (cube.isChecked()){
                newRow.addView(n3);
            }
            if (sqrt.isChecked()){
                newRow.addView(_2n);
            }
            if (fact.isChecked()){
                newRow.addView(nfact);
            }
        }



    }
    public void setTextView(TextView t, String s, int pad){
        t.setText(s);
        t.setTextSize(12);
        t.setPadding(0,0, pad,0);
    }
}
