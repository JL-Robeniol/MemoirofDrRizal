package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {


    Button tolesson,toscore, towork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tolesson=(Button) findViewById(R.id.enterlesson);
        toscore=(Button)findViewById(R.id.score);
        towork=(Button) findViewById(R.id.enterlessonwork);

        tolesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(Home.this, lesson.class);
                startActivity(int3);
            }
        });

        toscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Home.this, score.class);
                startActivity(int2);

            }
        });

        towork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Home.this, artandwork.class);
                startActivity(int2);





            }
        });


    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }
}