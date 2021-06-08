package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        et1=findViewById(R.id.etNum1);
        et2=findViewById(R.id.etNum2);

        btnAdd=findViewById(R.id.btnAdd);
        btnDiv=findViewById(R.id.btnDiv);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);

        tv=findViewById(R.id.tvAns);

        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String num1,num2;

        num1 = et1.getText().toString();
        num2 = et2.getText().toString();

        int n1,n2,ans;

        n1 = Integer.parseInt(num1);
        n2 = Integer.parseInt(num2);

        switch (v.getId())
        {
            case R.id.btnAdd:
                ans = n1+n2;
                break;

            case R.id.btnSub:
                ans = n1-n2;
                break;

            case R.id.btnMul:
                ans = n1*n2;
                break;

            case R.id.btnDiv:
                ans = n1/n2;
                break;

            default:
                ans = 0;
        }

        tv.setText("Answer is "+ans);

    }
}
