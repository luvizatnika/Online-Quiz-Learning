package com.luvizatnika1501512.uasmobprog.myonlinequizlearning.ViewHolder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Common.Common;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Model.QuestionScore;
import com.luvizatnika1501512.uasmobprog.myonlinequizlearning.R;


public class PeringkatFragment extends Fragment {

    View myFragment;

    FirebaseDatabase database;
    DatabaseReference questionScore;

    int sum=0;

    public static PeringkatFragment newInstance(){
        PeringkatFragment peringkatFragment = new PeringkatFragment();
        return peringkatFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        questionScore = database.getReference("Question_Score");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_peringkat,container,false);

        return myFragment;
    }



}
