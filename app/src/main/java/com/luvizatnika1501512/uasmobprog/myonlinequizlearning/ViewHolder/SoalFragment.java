package com.luvizatnika1501512.uasmobprog.myonlinequizlearning.ViewHolder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Common.Common;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Model.Question;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.R;

import java.util.Collection;
import java.util.Collections;

import static com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Common.Common.questionId;


public class SoalFragment extends Fragment {

    private Button btnPlay;

    View myFragment;
    FirebaseDatabase database;
    DatabaseReference questions;

    public static SoalFragment newInstance(){
        SoalFragment soalFragment = new SoalFragment();
        return soalFragment;
    }

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soal, container,false);
    }*/



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnPlay = (Button) view.findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MulaiSoal.class);
                startActivity(intent);
            }
        });
    }

    //press ctrl+o

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Questions");

        loadQuestion(questionId);

        //View rootView = inflater.inflate(R.layout.fragment_soal, false);
        //return rootView;
    }

    private void loadQuestion(String questionId){

        //First , clear List if have old question

        if(Common.questionList.size() > 0)
            Common.questionList.clear();

        questions.orderByChild("questionId").equalTo(questionId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                            Question ques = postSnapshot.getValue(Question.class);
                            Common.questionList.add(ques);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        //Random List
        Collections.shuffle(Common.questionList);
    }

    public void btnPlay(View v)
    {
        Intent intent = new Intent(getActivity(), MulaiSoal.class);
        startActivity(intent);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       myFragment = inflater.inflate(R.layout.fragment_soal,container,false);

       return myFragment;
    }


}
