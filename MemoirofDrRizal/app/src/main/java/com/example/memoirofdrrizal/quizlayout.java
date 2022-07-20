package com.example.memoirofdrrizal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class quizlayout extends AppCompatActivity {

    ImageView lessbask;
    TextView Ques,score, num,timers;
    Button ansA,ansB,ansC,ansD;
    ArrayList<questionanswer> arraylist;
    Random random;
    int scored =0, currentattemp = 1 , currentpros, prev;
    MediaPlayer wrong,correct;
    CountDownTimer timer;
    int timeremain=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizlayout);

        lessbask=findViewById(R.id.lessbth);
        Ques=findViewById(R.id.qustion1);
        score=findViewById(R.id.scorenum);
        timers=findViewById(R.id.timerview);;
        num=findViewById(R.id.testnumber);
        ansA=findViewById(R.id.ansquiz1);
        ansB=findViewById(R.id.ansquiz2);
        ansC=findViewById(R.id.ansquiz3);
        ansD=findViewById(R.id.ansquiz4);

        correct=MediaPlayer.create(this,R.raw.correctbeep);
        wrong=MediaPlayer.create(this,R.raw.wrongbeep);



        timer= new CountDownTimer(20000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeremain--;
                timers.setText(Integer.toString(timeremain)+ "sec");

            }

            @Override
            public void onFinish() {

                wrong.start();
                currentattemp++;
                currentpros++;
                timeremain=20;
                randomchecker();

            }
        };


        arraylist= new ArrayList<>();
        random= new Random();

        getquestion(arraylist);
        randomchecker();

        lessbask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(quizlayout.this,lesson.class);
                startActivity(intent);
            }
        });



        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arraylist.get(currentpros).getAnswer().trim().toLowerCase().equals(ansA.getText().toString().trim().toLowerCase())){


                    correct.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    scored++;
                    randomchecker();

                }else {

                    wrong.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    randomchecker();

                }

            }

        });

        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arraylist.get(currentpros).getAnswer().trim().toLowerCase().equals(ansB.getText().toString().trim().toLowerCase())){

                    correct.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    scored++;
                    randomchecker();

                }else {

                    wrong.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    randomchecker();

                }
            }
        });
        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arraylist.get(currentpros).getAnswer().trim().toLowerCase().equals(ansC.getText().toString().trim().toLowerCase())){


                    correct.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    scored++;
                    randomchecker();

                }else {


                    wrong.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    randomchecker();
                }
            }
        });
        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arraylist.get(currentpros).getAnswer().trim().toLowerCase().equals(ansD.getText().toString().trim().toLowerCase())){

                    correct.start();
                    currentattemp++;
                    currentpros++;
                    timer.cancel();
                    timeremain=20;
                    scored++;
                    randomchecker();

                }else {


                    wrong.start();
                    timer.cancel();
                    timeremain=20;
                    currentattemp++;
                    currentpros++;
                    randomchecker();
                }
            }
        });


    }

    private  void randomchecker(){

        prev = currentpros;
        currentpros= random.nextInt(arraylist.size());

            if(prev == currentpros)
            {
                currentpros=random.nextInt(arraylist.size());
                setdatatoview(currentpros);
            }else{
                setdatatoview(currentpros);

            }


    }

    private void showbutton(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout.this);
        View bottomview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.showscore,(LinearLayout)findViewById(R.id.showedscore));
        TextView finalscore = bottomview.findViewById(R.id.sshow);
        Button retart=bottomview.findViewById(R.id.retake1);
        Button exittolesson=bottomview.findViewById(R.id.backlesson);

        finalscore.setText("Your score is "+scored +" out of 20");


        retart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpros= random.nextInt(arraylist.size());
                setdatatoview(currentpros);
                currentattemp= 1;
                scored=0;
                timer.cancel();
                timeremain=20;
                bottomSheetDialog.dismiss();
            }
        });
        exittolesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
                Intent intent= new Intent(quizlayout.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout.this,lesson.class);
                user.putExtra("show",show);
                startActivity(user);

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomview);
        bottomSheetDialog.show();
    }

    private void setdatatoview(int currentpros) {



        num.setText(currentattemp+"/20");
        score.setText("Score : "+scored );



        if(currentattemp == 20){
            showbutton();
            timer.cancel();
            timeremain=20;


        }else {

            timer.start();
            Ques.setText(arraylist.get(currentpros).getQuestion());
            ansA.setText(arraylist.get(currentpros).getOption1());
            ansB.setText(arraylist.get(currentpros).getOption2());
            ansC.setText(arraylist.get(currentpros).getOption3());
            ansD.setText(arraylist.get(currentpros).getOption4());
        }


    }

    void getquestion(ArrayList<questionanswer> arraylist) {
        arraylist.add(new questionanswer("What exact day Dr.Jose Rizal born?","June 27, 1961","June 19, 1861", "July 19,1861","June 15, 1889", "June 19, 1861"));
         arraylist.add(new questionanswer("The full name of Dr.Jose Rizal born?","JOSÉ PROTACIO REALONDA RIZAL MERCADO Y ALONSO ","JOSÉ MERCADO PROTACIO RIZAL MERCADO Y ALONSO REALONDA", "JOSÉ PROTACIO RIZAL MERCADO Y ALONSO REALONDA","JOSÉ PROTACIO ALONSO RIZAL MERCADO Y ALONSO REALONDA", "JOSÉ PROTACIO RIZAL MERCADO Y ALONSO REALONDA"));
         arraylist.add(new questionanswer("He became the leader of ______ this are set of communication actions through books, leaflets and newspaper articles by a group of Filipinos who called for political reforms.","Spanish parliament","Spanish and Filipino equality", "Propaganda Movement","abolition of the polo and vandala", "Propaganda Movement"));
         arraylist.add(new questionanswer("Rizal wrote Mi ultimo Adios in other word ______.","My Last Goodbye","My Will Testament", "My Happy Day","My last Farewell", "My last Farewell"));
         arraylist.add(new questionanswer("Contributing numerous articles to its newspaper, La Solidaridad, published in ______.","Barcelona","Spain", "Madrid","Philippines", "Barcelona"));
         arraylist.add(new questionanswer("Against the advice of his parents and friends, Rizal returned to the Philippines in what year?" ,"1898","1842", "1892","1897", "1892"));
        arraylist.add(new questionanswer("A sequel, ______________, 1891, established his reputation as the leading spokesman of the Philippine reform movement.","Sa Aking mga Kabata","San Euistaquio", "Noli Me Tangere","El Filibusterismo", "El Filibusterismo"));
        arraylist.add(new questionanswer("he went to study medicine and liberal arts at the University of_______.","Barcelona","Spain", "Madrid","Philippines", "Madrid"));
        arraylist.add(new questionanswer("He was educated at the Ateneo de Manila and the University of Santo Tomas in Manila. In ______.","1865","1885", "1882","1860", "1882"));
        arraylist.add(new questionanswer("He annotated an edition in ________ on Antonio Morga's Sucesos de las Islas Filipinas","1890","1882", "1880","1870", "1890"));
        arraylist.add(new questionanswer("the ________, a nationalist secret society, launched a revolt against Spain.","Magdalo","Haring Bayang Katagalugan", "Magdiwang","Katipunan", "Katipunan"));
        arraylist.add(new questionanswer("Dr.Jose Rizal died in _______, Philippines.","Manila","Cebu", "Spain","Bulakan", "Manila"));
        arraylist.add(new questionanswer("Dr.Jose Rizal died in _______, 1896.","December 25","December 30", "January 30","November 30", "December 30"));
        arraylist.add(new questionanswer("Rizal was the son of a prosperous landowner and sugar planter of _______ descent on the island of Luzon.","Taiwanese-Filipino","Korean-Filipino", "Chinese-Filipino","Spanish-Filipino", "Chinese-Filipino"));
        arraylist.add(new questionanswer("His mother, ____________ one of the most highly educated women in the Philippines at that time","Teodora Alponso","Theodora Alonso", "Teodora Alonzo","Teodora Alonso", "Teodora Alonso"));
        arraylist.add(new questionanswer("he published his first novel in Spanish, _________, a passionate exposure of the evils of the friar’s rule.","El Canto del Viajero","Kundiman", "Noli Me Tangere","El Filibusterismo", "Noli Me Tangere"));
        arraylist.add(new questionanswer("he publicly executed by a _______ in Manila.","sword squad","firing squad", "swat squad","police squad", "firing squad"));
        arraylist.add(new questionanswer("He found a nonviolent reform society,_________ in Manila.","La Liga Filipina","Kundiman", "Magdalo","Katipunan", "La Liga Filipina"));
        arraylist.add(new questionanswer("Rizal's political program, as expressed in the newspaper, included integration of the Philippines as a province of ______.","Pangasinan","Singapore", "Spain","Madrid", "Spain"));
        arraylist.add(new questionanswer("He found a nonviolent reform society,was deported to _______.","Dapitan","Bagong Bayan", "Manila","Katipuna", "Dapitan"));


    }

    public void onBackPressed() {
       timer.cancel();
    }



}