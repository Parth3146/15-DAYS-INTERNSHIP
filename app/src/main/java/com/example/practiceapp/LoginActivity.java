package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnLogin, btnSignup;

    public static final String main_key = "myPref";
    public static final String email_key = "emailKey";
    public static final String password_key = "passwordKey";
    public static final String name_key = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etEmail.getText().toString();
                String userPassword = etPass.getText().toString();

                SharedPreferences preferences = getSharedPreferences(main_key,MODE_PRIVATE);

                String email = preferences.getString(email_key,"");
                String password = preferences.getString(password_key,"");
                String name = preferences.getString(name_key,"");
                if (email.equals(userEmail) && password.equals(userPassword)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("username",name);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Login Details !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}