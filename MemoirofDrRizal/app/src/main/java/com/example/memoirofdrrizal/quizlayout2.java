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

public class quizlayout2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_quizlayout2);
        lessbask=findViewById(R.id.lessbth_2);
        Ques=findViewById(R.id.qustion1_2);
        score=findViewById(R.id.scorenum_2);
        timers=findViewById(R.id.timerview_2);;
        num=findViewById(R.id.testnumber_2);
        ansA=findViewById(R.id.ansquiz1_2);
        ansB=findViewById(R.id.ansquiz2_2);
        ansC=findViewById(R.id.ansquiz3_2);
        ansD=findViewById(R.id.ansquiz4_2);

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
                Intent intent= new Intent(quizlayout2.this,lesson.class);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout2.this);
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
                Intent intent= new Intent(quizlayout2.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout2.this,lesson.class);
                user.putExtra("show2",show);
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
        arraylist.add(new questionanswer("The Rizal Family was one of wealthiest families, in _____.","Paris","Spain", "Calamaba","Manila", "Calamaba"));
        arraylist.add(new questionanswer("The hero's mother ran a _______ in town that sold a variety of trade goods .","Loan","store", "street food","Pharmacy", "store"));
        arraylist.add(new questionanswer("the Hero's Father, was born on______.","May 11, 1818","June 25, 1896", "September 11, 1818","January 30, 1810", "May 11, 1818"));
        arraylist.add(new questionanswer("the Hero's Father was a well-educated farmer who had studied _____________ at Manila's College of San Jose.","Latin and Phonology","Spanish and Philosophy", "Latin and Philosophy","Latin and Psychology", "Latin and Philosophy"));
        arraylist.add(new questionanswer("Francisco moved to Calamba and became a tenant-farmer in the __________.","Barcelona","Spain", "Dominican Republic","Philippines", "Dominican Republic"));
        arraylist.add(new questionanswer("Francisco died in what age ?" ,"90","70", "80","85", "80"));
        arraylist.add(new questionanswer("Dr. Jose Rizal mother died in what age?","90","70", "80","85", "85"));
        arraylist.add(new questionanswer("The Hero's mother, Teodora graduated, in ________?","Santa Mesa College","Santa Rosa College", "Ateneo Manila College","Calamba Laguna College", "Santa Rosa College"));
        arraylist.add(new questionanswer("She was the eldest of the Rizal siblings.","Concepcion","Saturnina", "Soledad","Narcisa", "Saturnina"));
        arraylist.add(new questionanswer("She was the youngest and married Pantaleon Quintero of Calamba, Laguna.","Concepcion","Narcisa", "Saturnina","Soledad", "Soledad"));
        arraylist.add(new questionanswer("Rizal's paternal great grandfather, was a Chinese guy from Chinchey.","Domingo Lamco","Domingo Tingco", "Benigno Lamco","Domingo Alonso", "Domingo Lamco"));
        arraylist.add(new questionanswer("Saturnina husband name was ________.","Maguel Hidalgo","Manuel Lamco", "Manuel Hidalgo","Manuel Quezon", "Manuel Hidalgo"));
        arraylist.add(new questionanswer("He was Jose Rizal's older brother. Following his younger brother's execution, he joined the revolution and rose to the rank of general.","Paciano","Saturnina", "Jose","Soledad", "Paciano"));
        arraylist.add(new questionanswer("She married Antonio Lopez, a schoolteacher from Morong, Rizal","Concepcion","Narcisa", "Saturnina","Soledad", "Narcisa"));
        arraylist.add(new questionanswer("Jose married _________,a lovely Irish woman from Hong Kong","Josephine Bracken","Leonor Rivera", "Suzanne Jacoby","Consuelo Ortiga", "Josephine Bracken"));
        arraylist.add(new questionanswer("She died at the age of three.","Concepcion","Saturnina", "Soledad","Narcisa", "Concepcion"));
        arraylist.add(new questionanswer("She was the youngest and married Pantaleon Quintero of Calamba, Laguna.","Concepcion","Narcisa", "Soledad","Saturnina", "Soledad"));
        arraylist.add(new questionanswer("Name of the last Malayan King of Tondo, was Rizal's maternal ancestor?","Eugenio Alonso","Eugenio Ursua", "Eugenio Ursau","Eugen Ursua", "Eugenio Ursua"));
        arraylist.add(new questionanswer("n engineer who received the prestigious (‘Knight of the Grand Order of Isabela the Catholic’) title from Spain.","Domingo Lamco","Cipriano Alonso", "Lorenzo Alberto Alonso","Eugenio Ursua", "Lorenzo Alberto Alonso"));
        arraylist.add(new questionanswer("_________, a notable Manila lawyer, was her maternal grandfather.","Domingo Lamco","Manuel De Quintos", "Lorenzo Alberto Alonso","Eugenio Ursua", "Manuel De Quintos"));


    }

    public void onBackPressed() {
        timer.cancel();
    }



}