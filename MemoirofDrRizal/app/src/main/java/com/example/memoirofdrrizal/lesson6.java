package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson6 extends AppCompatActivity {

    Button menu6, quiz6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);

        menu6=findViewById(R.id.menu6);
        quiz6=findViewById(R.id.quiz6);


        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson6.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson6.this,quizlayout6.class);
                startActivity(intent);
            }
        });
    }
}