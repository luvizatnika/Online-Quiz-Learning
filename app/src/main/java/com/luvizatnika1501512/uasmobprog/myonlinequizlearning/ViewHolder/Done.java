package com.luvizatnika1501512.uasmobprog.myonlinequizlearning.ViewHolder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Common.Common;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Model.QuestionScore;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.R;

public class Done extends AppCompatActivity {

    Button btnDone;

    TextView txtResultScore,getTxtResultQuestion,txtResultWrong;
    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference question_score,question_wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

       database = FirebaseDatabase.getInstance();
       question_score = database.getReference("Question_Score");
        question_wrong = database.getReference("Question_Wrong");

       txtResultScore = (TextView)findViewById(R.id.txtTotalScore);
       txtResultWrong = (TextView)findViewById(R.id.txtTotalWrong);
       getTxtResultQuestion = (TextView)findViewById(R.id.txtTotalQuestion);
       progressBar = (ProgressBar)findViewById(R.id.doneProgressBar);
       btnDone = (Button)findViewById(R.id.btnDone);

       btnDone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Done.this,Home.class);
               startActivity(intent);
               finish();
           }
       });

       //get data from bundle and set to view
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            int score = extra.getInt("SCORE");
            int wrong = extra.getInt("WRONG");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            txtResultScore.setText(String.format("BENAR : %d",score));
            txtResultWrong.setText(String.format("SALAH : %d",wrong));
            getTxtResultQuestion.setText(String.format("PERTANYAAN : %d / %d",correctAnswer,totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            //Upload point DB
            question_score.child(String.format("%s_%s", Common.currentUser.getNim(),Common.questionId))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getNim(),Common.questionId),
                            Common.currentUser.getNim(),
                            String.valueOf(score)));

            question_wrong.child(String.format("%s_%s", Common.currentUser.getNim(),Common.questionId))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getNim(),Common.questionId),
                            Common.currentUser.getNim(),
                            String.valueOf(score)));
        }

    }
}
