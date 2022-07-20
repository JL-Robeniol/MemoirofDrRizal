package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class introductionlesson extends AppCompatActivity {

    Button menu, quiz1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductionlesson);

        menu=findViewById(R.id.menu1);
        quiz1=findViewById(R.id.quiz1);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(introductionlesson.this,lesson.class);
                startActivity(intent);
            }
        });

        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(introductionlesson.this,quizlayout.class);
                startActivity(intent);
            }
        });



    }

}