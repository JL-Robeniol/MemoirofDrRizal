package com.example.memoirofdrrizal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginsignup extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnRegister;
    database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsignup);
        getSupportActionBar().hide();

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        DB = new database(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent( loginsignup.this, register.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userValue = username.getText().toString();
                String passValue = password.getText().toString();

                if (userValue.equals("")||passValue.equals("")) {
                    Toast.makeText(loginsignup.this, "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuserpass = DB.checkusernamepassword(userValue,passValue);
                    if (checkuserpass==true){
                        Toast.makeText(loginsignup.this, "Sign in Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(loginsignup.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}