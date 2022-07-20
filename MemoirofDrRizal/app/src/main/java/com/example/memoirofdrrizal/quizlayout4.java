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

public class quizlayout4 extends AppCompatActivity {
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
        setContentView(R.layout.activity_quizlayout4);
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
                Intent intent= new Intent(quizlayout4.this,lesson.class);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(quizlayout4.this);
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
                Intent intent= new Intent(quizlayout4.this,lesson.class);
                startActivity(intent);
                timer.cancel();
                timeremain=20;
                String show = String.valueOf(scored);
                Intent user= new Intent(quizlayout4.this,lesson.class);
                user.putExtra("show4",show);
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
        arraylist.add(new questionanswer("a college under the supervision of the Spanish Jesuits","Manila Municipal","Ateneo Municipal", "Pangasinan Municipal","San Juan Municipal", "Ateneo Municipal"));
        arraylist.add(new questionanswer("formerly name of Ateneo, a school for poor boys in Manila which was established by the city government in 1817","Cescuela Piay","Tescuela Pia", "Escuela Pia ","Escuela Piay", "Escuela Pia "));
        arraylist.add(new questionanswer("Rizal accompanied by Paciano went to Manila","June 10, 1872","June 19, 1882", "June 10, 1875","June 15, 1872", "June 10, 1872"));
        arraylist.add(new questionanswer("was the college registrar, refused to admit Rizal in Ateneo","Father Jose Vilaclar","Father Lleonart", "Father Magin Ferrando","Manuel Xerez Burgos", "Father Magin Ferrando"));
        arraylist.add(new questionanswer("because of his intercession, nephew of Father Burgos, Rizal was reluctantly admitted at the Ateneo","Manuel Xerez Burgos","Father Magin Ferrando", "Father Lleonart","Father Jose Vilaclar", "Manuel Xerez Burgos"));
        arraylist.add(new questionanswer("Consisting of internos (boarders); red banner","Centurion","Roman Empire", "Emperor","Carthaginian Empire", "Roman Empire"));
        arraylist.add(new questionanswer("composed of the externos (non-boarders); blue banner","Roman Empire","Centurion", "Carthaginian Empire","Emperor", "Carthaginian Empire"));
        arraylist.add(new questionanswer("the best student in each “empire”","Emperor","Centurion", "Roman Empire","Carthaginian Empire", "Emperor"));
        arraylist.add(new questionanswer("Rizal’s first prize for being the brightest pupil in the whole class","Religious picture","Medal", "Certificate","Uniform", "Religious picture"));
        arraylist.add(new questionanswer("impressed by Rizal’s sculptural talent, requested him to carve for him an image of Sacred Heart of Jesus","Manuel Xerez Burgos","Father Magin Ferrando", "Father Lleonart","Father Jose Vilaclar", "Father Lleonart"));
        arraylist.add(new questionanswer("advised Rizal to stop communing with the Muse and pay more attention to more practical studies","Manuel Xerez Burgos","Father Lleonart", "Father Magin Ferrando","Father Jose Vilaclara", "Father Jose Vilaclara"));
        arraylist.add(new questionanswer("a religious society wherein Rizal was an active member and later became the secretary","Father Magin Ferrando","Marian Congregation", "Father Lleonart","Manuel Xerez Burgos", "Marian Congregation"));
        arraylist.add(new questionanswer("Commencement Day, Rizal, who was 16 years old, received from his Alma Mater, Ateneo Municipal, the degree of Bachelor of Arts, with highest honors","March 23, 1899","March 25, 1877", "March 23, 1877","March 23, 1878", "March 23, 1877"));
        arraylist.add(new questionanswer("a German scientist-traveler who visited the Philippines in 1859-1860 who wrote Travels in the Philippines","Dr.","Dr. Feodor Jago", "Dr.","Dr.", "Dr. Feodor Jago"));
        arraylist.add(new questionanswer("Rizal topped all his classmates in all subjects and won ____ medals at the end of the school term.","four","eight", "five","six", "five"));
        arraylist.add(new questionanswer("Rizal returned to ______ for the summer vacation.","Bicol","Laguna", "Calamba","Binan", "Calamba"));
        arraylist.add(new questionanswer("he fifth best"," Tribune","Decurion", "Stand-bearer","Centurio", "Stand-bearer"));
        arraylist.add(new questionanswer("the fourth best","Tribune","Centurion", "Stand-bearer","Decurion", "Centurion"));
        arraylist.add(new questionanswer("the third best","Decurion","Tribune", "Stand-bearer","Centurion", "Decurion"));
        arraylist.add(new questionanswer("the second best","Centurion","Stand-bearer", " Tribune","Decurion", " Tribune"));






    }

    public void onBackPressed() {
        timer.cancel();
    }



}