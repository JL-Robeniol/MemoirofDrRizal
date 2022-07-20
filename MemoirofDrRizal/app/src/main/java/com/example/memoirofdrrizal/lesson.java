package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson extends AppCompatActivity {

    Button less1,less2,less3, less4,less5,less6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        less1=findViewById(R.id.lessonlist1);
        less2=findViewById(R.id.lessonlist2);
        less3=findViewById(R.id.lessonlist3);
        less4=findViewById(R.id.lessonlist4);
        less5=findViewById(R.id.lessonlist5);
        less6=findViewById(R.id.lessonlist6);


        less1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,introductionlesson.class);
                startActivity(intent);
            }
        });
        less2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,lesson2.class);
                startActivity(intent);
            }
        });
        less3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,lesson3.class);
                startActivity(intent);
            }
        });
        less4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,lesson4.class);
                startActivity(intent);
            }
        });
        less5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,lesson5.class);
                startActivity(intent);
            }
        });
        less6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(lesson.this,lesson6.class);
                startActivity(intent);
            }
        });


    }


}