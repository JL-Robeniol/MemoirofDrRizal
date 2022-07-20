package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson3 extends AppCompatActivity {

    Button menu3, quiz3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);


        menu3=findViewById(R.id.menu3);
        quiz3=findViewById(R.id.quiz3);


        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson3.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson3.this,quizlayout3.class);
                startActivity(intent);
            }
        });
    }
}