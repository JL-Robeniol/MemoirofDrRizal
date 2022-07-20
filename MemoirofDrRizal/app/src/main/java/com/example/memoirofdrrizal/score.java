package com.example.memoirofdrrizal;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class score extends AppCompatActivity {
    TextView  src1,src2,src3,src4,src5,src6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        src1=findViewById(R.id.sc1);
        src2=findViewById(R.id.sc2);
        src3=findViewById(R.id.sc3);
        src4=findViewById(R.id.sc4);
        src5=findViewById(R.id.sc5);
        src6=findViewById(R.id.sc6);





    }
}