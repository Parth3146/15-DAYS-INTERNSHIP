package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btnSubmit;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnSubmit = findViewById(R.id.subbt);
        tv = findViewById(R.id.tv);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = et1.getText().toString();
                String n2 = et2.getText().toString();
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                int sum =  num1 + num2;
                tv.setText(sum);
                //Toast.makeText(getApplicationContext(), sum, Toast.LENGTH_SHORT).show();
            }
        });

    }
}