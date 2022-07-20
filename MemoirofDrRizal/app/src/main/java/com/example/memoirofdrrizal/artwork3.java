package com.example.memoirofdrrizal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class artwork3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork3);
        PDFView pdfView=findViewById(R.id.pdfreader3);

        pdfView.fromAsset("makamisa.pdf").load();
    }
}