package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText name,email,password;
    Button signup;

    public static final String main_key = "myPref";
    public static final String email_key = "emailKey";
    public static final String password_key = "passwordKey";
    public static final String name_key = "nameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name =  findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPass);
        signup = findViewById(R.id.btnSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String username,userEmail,userPassword;

                username = name.getText().toString();
                userEmail = email.getText().toString();
                userPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(name_key,username);
                editor.putString(email_key,userEmail);
                editor.putString(password_key,userPassword);

                editor.commit();

                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}