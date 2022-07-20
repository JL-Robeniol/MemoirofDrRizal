package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson5 extends AppCompatActivity {

    Button menu5, quiz5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        menu5=findViewById(R.id.menu5);
        quiz5=findViewById(R.id.quiz5);


        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson5.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson5.this,quizlayout5.class);
                startActivity(intent);
            }
        });
    }
}