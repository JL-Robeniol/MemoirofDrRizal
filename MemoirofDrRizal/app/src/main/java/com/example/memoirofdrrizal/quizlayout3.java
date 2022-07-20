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

public class quizlayout3 extends AppCompatActivity {


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
        setContentView(R.layout.activity_quizlayout3);

        lessbask=findViewById(R.id.lessbth_3);
        Ques=findViewById(R.id.qustion1_3);
        score=findViewById(R.id.scorenum_3);
        timers=findViewById(R.id.timerview_3);;
        num=findViewById(R.id.testnumber_3);
        ansA=findViewById(R.id.ansquiz1_3);
        ansB=findViewById(R.id.ansquiz2_3);
        ansC=findViewById(R.id.ansquiz3_3);
        ansD=findViewById(R.id.ansquiz4_3);

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
                Intent intent= new Intent(quizlayout3.this,lesson.class);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout3.this);
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
                Intent intent= new Intent(quizlayout3.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout3.this,lesson.class);
                user.putExtra("show3",show);
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
        arraylist.add(new questionanswer("The first teacher of Rizal was his______,who was remarkable woman of good character and fine culture—her mother","aya","sister", "mother","father", "mother"));
        arraylist.add(new questionanswer("Rizal’s first private tutor.","Leon Monroy","Maestro Celestino", "Maestro Lucas Padua","Andres Salandanan", "Maestro Celestino"));
        arraylist.add(new questionanswer("Rizal’s second tutor","Andres Salandanan","Maestro Lucas Padua", "Maestro Celestino","Leon Monroy", "Maestro Lucas Padua"));
        arraylist.add(new questionanswer("a former classmate of Rizal’s father became Rizal’s tutor that instructed Jose in Spanish and Latin. He died five months later","Leon Monroy","Andres Salandanan", "Maestro Lucas Padua","Maestro Celestino", "Leon Monroy"));
        arraylist.add(new questionanswer("______ afternoon in June, 1869","Friday","Sunday", "Saturday","Monday", "Sunday"));
        arraylist.add(new questionanswer("Rizal left Calamba for Biñan accompanied by ________","Concepcion","Narcisa", "Saturnina","Paciano", "Paciano"));
        arraylist.add(new questionanswer("Maestro Justiniano Aquino Cruz Rizal's_______.","maid","nurse", "teacher","tutor", "teacher"));
        arraylist.add(new questionanswer("Rizal’s teacher in a private school in Biñan","Leon Monroy","Maestro Justiniano Aquino Cruz", "Maestro Lucas Padua","Maestro Celestino", "Maestro Justiniano Aquino Cruz"));
        arraylist.add(new questionanswer("the teacher’s son which Rizal challenged to a fight","Juan","Pedro", "Jose","Peter", "Pedro"));
        arraylist.add(new questionanswer("challenged Rizal to an arm-wrestling match","Lucas Padua","Jose Guevara", "Leon Monroy","Andres Salandanan", "Andres Salandanan"));
        arraylist.add(new questionanswer("“the favorite _____ of the class”","sketches","sculpture", "painters","writers", "painters"));
        arraylist.add(new questionanswer("Christmas in 1870-Rizal received a letter from his sister ______.","Narcisa","Concepcion", "Saturnina","Narcisa", "Saturnina"));
        arraylist.add(new questionanswer("informing him of the arrival of the steamer _____ which would take him from Biñan to Calamba","Ralim","Talim", "Galim","Salim", "Talim"));
        arraylist.add(new questionanswer("Saturday afternoon, December ____, 1870- Rizal left Biñan after one year and a half of schooling","20","18", "17","30", "17"));
        arraylist.add(new questionanswer("a Frenchman friend of Rizal’s father who took care of him on board","Leon Monroy","Andres Salandanan", "Lucas Padua","Arturo Camps", "Arturo Camps"));
        arraylist.add(new questionanswer("Rizal’s classmate who also loved painting, became apprentices of the old painter","Leon Monroy ","Andres Salandanan", "Jose Guevara","Arturo Camps", "Jose Guevara"));
        arraylist.add(new questionanswer("an old painter who was the father-in-law of the school teacher","Leon","Juancho", "Jose","Andres", "Juancho"));
        arraylist.add(new questionanswer("who was remarkable woman of good character and fine culture—her","sister","father", "mother","aya", "mother"));
        arraylist.add(new questionanswer("Rizal left ____ after one year and a half of schooling","Tondo","Laguna", "Biñan","Calamba", "Biñan"));
        arraylist.add(new questionanswer("","Lucas","Juancho", "Andres","Leon", "Juancho"));

    }

    public void onBackPressed() {
        timer.cancel();
    }



}