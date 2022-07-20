package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson4 extends AppCompatActivity {

    Button menu4, quiz4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        menu4=findViewById(R.id.menu4);
        quiz4=findViewById(R.id.quiz4);


        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson4.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(lesson4.this,quizlayout4.class);
                startActivity(intent);
            }
        });
    }
}