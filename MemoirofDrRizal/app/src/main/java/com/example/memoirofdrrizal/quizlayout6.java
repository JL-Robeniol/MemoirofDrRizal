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

import java.util.ArrayList;
import java.util.Random;

public class quizlayout6 extends AppCompatActivity {

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
        setContentView(R.layout.activity_quizlayout6);
        lessbask=findViewById(R.id.lessbth_4);
        Ques=findViewById(R.id.qustion1_4);
        score=findViewById(R.id.scorenum_4);
        timers=findViewById(R.id.timerview_4);;
        num=findViewById(R.id.testnumber_4);
        ansA=findViewById(R.id.ansquiz1_4);
        ansB=findViewById(R.id.ansquiz2_4);
        ansC=findViewById(R.id.ansquiz3_4);
        ansD=findViewById(R.id.ansquiz4_4);

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
                Intent intent= new Intent(quizlayout6.this,lesson.class);
                startActivity(intent);
                timer.cancel();
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout6.this);
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
                Intent intent= new Intent(quizlayout6.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout6.this,lesson.class);
                user.putExtra("show6",show);
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
        arraylist.add(new questionanswer("Rizal used this name","Jose Realonda","Jose Protacio", "Jose Mercado","Jose Rizal", "Jose Mercado"));
        arraylist.add(new questionanswer("Rizal departed on board the Spanish streamer Salvadora bound for Singapore","May 8, 1885","May 3, 1882", "May 30, 1887","May 5, 1987", "May 3, 1882"));
        arraylist.add(new questionanswer("the ship captain from Asturias, Spain befriended Rizal","Donito Lecha","Theodor Marquiz", "Roman Dezon","Donato Lecha", "Donato Lecha"));
        arraylist.add(new questionanswer("while the steamer was approaching Singapore, Rizal saw a beautiful island, fascinated by its scenic beauty, he remembered “Talim Island with the Susong Dalaga”","May 3, 1882","May 8, 1892", "May 8, 1882","May 9, 1982", "May 8, 1882"));
        arraylist.add(new questionanswer("the Salvadora docked at Singapore","May 9, 1892","May 3, 1882", "May 9, 1882","May 8, 1882", "May 9, 1882"));
        arraylist.add(new questionanswer("Rizal registered here and spent two days on a sightseeing soiree of the city, which was a colony of England","Hotel de la Paz","Hotel de luna", "Hotel de Lurezo","Hotel de Penia", "Hotel de la Paz"));
        arraylist.add(new questionanswer(".Rizal reached Naples","June 11, 1882","June 14, 1892", "June 21, 1882","June 12, 1882", "June 11, 1882"));
        arraylist.add(new questionanswer("the steamer docked at the French harbor of Marseilles","June 13, 1892","June 12, 1882", "June 17, 1892","June 11, 1882", "June 12, 1882"));
        arraylist.add(new questionanswer("Rizal left Marseilles by train for the last lap of his trip to Spain","May 15, 1832","May 16, 1982", "May 25, 1892","May 15, 1882", "May 15, 1882"));
        arraylist.add(new questionanswer("Rizal finally reached his destination—Barcelona","June 18, 1892","June 16, 1882", "June 26, 1982","June 18, 1892", "June 16, 1882"));
        arraylist.add(new questionanswer("nationalistic essay, Rizal’s first article written on Spain’s soil","Armor Patio","Amor Patrio", "Amor Petrilio","Anor Patriot", "Amor Patrio"));
        arraylist.add(new questionanswer("his pen-name appeared in print in Diariong Tagalog on August 20, 1882","Lam Tan","Laon Taan", "Lakam Padre","Laong Laan", "Laong Laan"));
        arraylist.add(new questionanswer("a friend of Rizal in Manila and the publisher of Diariong Tagalog where Rizal sent this article","Basipo Teodoro ","Basilio Patawad", "Basilio Teodoro Moran","Theodoro Moran", "Basilio Teodoro Moran"));
        arraylist.add(new questionanswer("the first Manila bilingual newspaper","TikTik","Diariong Tagalog", "Diariong Espanyol","Diariong Ilokano", "Diariong Tagalog"));
        arraylist.add(new questionanswer("Rizal’s second article for Diariong Tagalog","Los Angeles","Los Viajes", "Los Vigas","Los Santos", "Los Viajes"));
        arraylist.add(new questionanswer("Rizal’s third article written in Madrid on November 29, 1882","Revista de Madrid","Revisla de Rusia", "Avista de France","Resorte de Madrid", "Revista de Madrid"));
        arraylist.add(new questionanswer("_____ advised his younger brother to finish the medical course in Madrid","Saturnina","Domingo", "Paciano","Jose", "Paciano"));
        arraylist.add(new questionanswer("Another sad news from the Philippines was the chatty letter of ______ recounting the unhappiness of Leonor Rivera","Chengoy","Pechoy", "Unggoy","Enchong", "Chengoy"));
        arraylist.add(new questionanswer("Rizal left Marseilles by ____ for the last lap of his trip to Spain","kotse","train", "boat","kalisa", "train"));
        arraylist.add(new questionanswer("city hotter than Manila","Saudi","Aden", "Eden","Egypt", "Aden"));











    }

    public void onBackPressed() {
        timer.cancel();
    }



}