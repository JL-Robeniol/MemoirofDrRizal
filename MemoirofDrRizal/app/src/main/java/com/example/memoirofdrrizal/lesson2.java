package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson2 extends AppCompatActivity {

    Button menu2, quiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);


        menu2=findViewById(R.id.menu2);
        quiz2=findViewById(R.id.quiz2);


        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson2.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson2.this,quizlayout2.class);
                startActivity(intent);
            }
        });
    }
}