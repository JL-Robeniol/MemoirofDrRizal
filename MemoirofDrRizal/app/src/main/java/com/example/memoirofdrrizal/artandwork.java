package com.example.memoirofdrrizal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class artandwork extends AppCompatActivity {

    Button work_1,work_2,work_3,work_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artandwork);
        work_1=findViewById(R.id.work1);
        work_2=findViewById(R.id.work2);
        work_3=findViewById(R.id.work3);
        work_4=findViewById(R.id.work4);

        work_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(artandwork.this, artwork1.class);
                startActivity(intent);

            }
        });
        work_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(artandwork.this, artwork2.class);
                startActivity(intent);

            }
        });
        work_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(artandwork.this, artwork3.class);
                startActivity(intent);

            }
        });
        work_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(artandwork.this, artwork4.class);
                startActivity(intent);

            }
        });
    }
}