package com.example.memoirofdrrizal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class  register extends AppCompatActivity {

    EditText username, password, repass, completename;
    RadioGroup gender;
    Button register, login;
    database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        DB = new database(this);

        username = (EditText)findViewById(R.id.r_username);
        password = (EditText)findViewById(R.id.r_password);
        repass= (EditText)findViewById(R.id.r_repass);
        completename = (EditText)findViewById(R.id.r_completename);
        gender = (RadioGroup)findViewById(R.id.gender);
        register = (Button)findViewById(R.id.register);
        login = (Button)findViewById(R.id.btnlogin1);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String repassValue = repass.getText().toString();
                String completenameValue = completename.getText().toString();
                RadioButton checkedbtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedbtn.getText().toString();

                if ( usernameValue.equals("")||passwordValue.equals("")||completenameValue.equals("")||genderValue.equals(""))
                    Toast.makeText(register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                else {
                    if (passwordValue.equals(repassValue)){
                        Boolean checkuser = DB.checkusername(usernameValue);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(usernameValue, passwordValue, completenameValue, genderValue);
                            if (insert==true){
                                Toast.makeText(register.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent int1 = new Intent(getApplicationContext(),home.class);
                                startActivity(int1);
                            }else{
                                Toast.makeText(register.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(register.this, "Username already exist!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(register.this, "User Password not match!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(register.this, loginsignup.class);
                startActivity(int2);
            }
        });


    }

}