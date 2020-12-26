package com.programminghero.courseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.programminghero.courseapp.adapter.RecycleAdapter;
import com.programminghero.courseapp.model.PlayListModelClass;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<PlayListModelClass> playListModelClasses;
    private RecyclerView recyclerView;
    private RecycleAdapter courseRecyAdapter;

    private String number[] = {"Module 1", "Module 2", "Module 3", "Module 4"};
    private String title[] = {"HTML", "CSS", "JS", "React"};
    private String time[] = {"20:23", "10.00", "20:50", "30.00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.rvBlessing);
        playListModelClasses = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            PlayListModelClass beanClassForRecyclerView_contacts = new PlayListModelClass(number[i], title[i], time[i]);
            playListModelClasses.add(beanClassForRecyclerView_contacts);
        }

        courseRecyAdapter = new RecycleAdapter(SecondActivity.this, playListModelClasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(SecondActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(courseRecyAdapter);
    }
}
