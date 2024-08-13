package com.ratna.stranger_things;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PlayListActivity extends AppCompatActivity {
    RecyclerView allTimeRecyclerView, season4, season3, season2, season1;

    // set adapters for all the seasons and alltimebestsongs;

    // set a arraylist for all the seasons and alltimebestsongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        allTimeRecyclerView = findViewById(R.id.allTimeRecyclerView);
        season1 = findViewById(R.id.seasononeRecyclerView);
        season2 = findViewById(R.id.seasontwoRecyclerView);
        season3 = findViewById(R.id.seasonthreeRecyclerView);
        season4 = findViewById(R.id.seasonfourRecyclerView);

        // get datas of all season playlist
        // set adapter for all time playlist
        // set into recylverview into horizontal listview (reverse the data optional)

    }
}