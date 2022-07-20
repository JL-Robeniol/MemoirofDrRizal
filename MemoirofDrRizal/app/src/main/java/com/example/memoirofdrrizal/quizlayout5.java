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

public class quizlayout5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_quizlayout5);
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
                Intent intent= new Intent(quizlayout5.this,lesson.class);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout5.this);
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
                Intent intent= new Intent(quizlayout5.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout5.this,lesson.class);
                user.putExtra("show5",show);
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
        arraylist.add(new questionanswer("Rizal transferred to the _____ course.","artist","medical", "teacher","law", "medical"));
        arraylist.add(new questionanswer("After finishing the first year of a course in _____ and Letters","Geographic","Physician", "Psychology","Philosophy ", "Philosophy "));
        arraylist.add(new questionanswer("Don’t send him to Manila again; he knows enough. If he gets to know more, the Spaniards will cut off his head","Doña Teodora","Doña Teresa", "Doña Marry","Doña Karen", "Doña Teodora"));
        arraylist.add(new questionanswer("vigorously opposed the idea that Rizal pursue higher learning in the university","Doña Teresa","Doña Marry", "Doña Karen","Doña Teodora", "Doña Teodora"));
        arraylist.add(new questionanswer("Rizal who was then nearly ___ years old, matriculated in the University of Santo Tomas","14","19", "16","18", "16"));
        arraylist.add(new questionanswer("who had been good to him during his student days in that college","Father Lleonart","Father Jose Vilaclar", "Father Pablo Ramon","Father Magin Ferrando", "Father Pablo Ramon"));
        arraylist.add(new questionanswer("He took the vocational course leading to the title of _______.","perito agrimento","perito auricular", "perito agrimensor","ripeto agrimensor", "perito agrimensor"));
        arraylist.add(new questionanswer("obtaining ____ medals in agriculture and topography.","diamond","pilak", "silver","gold", "gold"));
        arraylist.add(new questionanswer("the title was issued to Rizal for passing the final examination in the surveying course","November 15, 1899","November 25, 1881", "November 19, 1878","November 29, 1881", "November 25, 1881"));
        arraylist.add(new questionanswer("a society of literary men and artists, held a literary contest in the year 1879","Liteo Literario-Artistico","Liteo Artistico-Literario", "Liceo Artistico-Literario","Liceo Literario-Artistico", "Liceo Artistico-Literario"));
        arraylist.add(new questionanswer("Rizal, who was then 18 years old, submitted this poem","Junto al Pasig","D.N. del Puzo", "El Consejo de los Dioses","A La Juventud Filipina", "A La Juventud Filipina"));
        arraylist.add(new questionanswer("an allegorical drama written by Rizal which he entered in the literary contest of Artistic-Literary Lyceum in 1880 to commemorate the fourth centennial of the death of Cervantes","perito agrimensor","A La Juventud Filipina", "El Consejo de los Dioses","Junto al Pasig", "El Consejo de los Dioses"));
        arraylist.add(new questionanswer("The prize was awarded to Rizal, a ______ ring on which was engraved the bust of Cervantes","gold","emerald", "diamond","silver", "gold"));
        arraylist.add(new questionanswer("a Spanish writer, who won the second prize","Lleonart","Vicenta Ybardolaza", "D.N. del Puzo","Junto al Pasig", "D.N. del Puzo"));
        arraylist.add(new questionanswer("a zarzuela which was staged by the Ateneans on December 8, 1880, on the occasion of the annual celebration of the Feats Day of the Immaculate Conception, Patroness of the Ateneo","Junto al Pasig","Liceo Artistico", "Pablo Ramon","D.N. del Puzo", "Junto al Pasig"));
        arraylist.add(new questionanswer("a sonnet written by Rizal for the album of the Society of Sculptors; in this sonnet, he urged all Filipino artists to glorify the Philippines","A Kapang-Pangan","A Filipinas", "A Spanish","A European", "A Filipinas"));
        arraylist.add(new questionanswer("Rizal composed a poem in 1879 which was declaimed by an Atenean, Manuel Fernandez, on the night of December 8, 1879, in honor of the Ateneo’s Patroness","Junto al Pasig","Vicenta Ybardolaza", "Abd-el-Azis y Mahoma","Al M.R.P. Pablo Ramon", "Abd-el-Azis y Mahoma"));
        arraylist.add(new questionanswer("Rizal composed a poem in 1881, as an expression of affection to Father Pablo Ramon, the Ateneo rector, who had been so kind and helpful to him","Junto al Pasig","Abd-el-Azis y Mahoma", "Al M.R.P. Pablo Ramon","Vicenta Ybardolaza", "Al M.R.P. Pablo Ramon"));
        arraylist.add(new questionanswer("a pretty girl colegiala who skillfully played the harp at the Regalado home, whom Rizal was infatuated in Pakil","Abd-el-Azis y Mahoma","None of the choice", "Vicenta Ybardolaza","Junto al Pasig", "Vicenta Ybardolaza"));
        arraylist.add(new questionanswer("Rizal founded a secret society of Filipino students in University of Santo Tomas in 1880","Kompañerismo","Compañeritico", "Compañerismo","Composers", "Compañerismo"));










    }

    public void onBackPressed() {
        timer.cancel();
    }



}