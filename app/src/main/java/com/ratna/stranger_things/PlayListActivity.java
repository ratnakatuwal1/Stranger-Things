package com.ratna.stranger_things;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ratna.stranger_things.adapters.StrangerThingsTrackAdapter;
import com.ratna.stranger_things.datas.StrangerThingsTrack;
import com.ratna.stranger_things.datas.TrackDatas;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {
    RecyclerView allTimeRecyclerView, season4, season3, season2, season1;
    ArrayList<StrangerThingsTrack> getAllTime, seasonOneTrack, seasonTwoTrack, seasonThreeTrack, seasonFourTrack;
    StrangerThingsTrackAdapter allTimeAdapter, seasonOneAdapter, seasonTwoAdapter, seasonThreeAdapter, seasonFourAdapter, seasonFiveAdapter;
    RecyclerView.LayoutManager allTimeLayoutManager, seasonOneLayoutManager, seasonTwoLayoutManager, seasonThreeLayoutManager, seasonFourLayoutManager, seasonFiveLayoutManager;

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

        TrackDatas trackDatas = new TrackDatas();
        getAllTime = trackDatas.getAllTime();
        allTimeLayoutManager = new LinearLayoutManager(PlayListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        allTimeRecyclerView.setLayoutManager(allTimeLayoutManager);
        allTimeAdapter = new StrangerThingsTrackAdapter(getAllTime, PlayListActivity.this);
        allTimeRecyclerView.setAdapter(allTimeAdapter);

        seasonOneTrack = trackDatas.getSeasonOne();
        seasonOneLayoutManager = new LinearLayoutManager(PlayListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        season1.setLayoutManager(seasonOneLayoutManager);
        seasonOneAdapter = new StrangerThingsTrackAdapter(seasonOneTrack, PlayListActivity.this);
        season1.setAdapter(seasonOneAdapter);

        seasonTwoTrack = trackDatas.getSeasonTwo();
        seasonTwoLayoutManager = new LinearLayoutManager(PlayListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        season2.setLayoutManager(seasonTwoLayoutManager);

        seasonTwoAdapter = new StrangerThingsTrackAdapter(seasonTwoTrack, PlayListActivity.this);
        season2.setAdapter(seasonTwoAdapter);

        seasonThreeTrack = trackDatas.getSeasonThree();
        seasonThreeLayoutManager = new LinearLayoutManager(PlayListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        season3.setLayoutManager(seasonThreeLayoutManager);

        seasonThreeAdapter = new StrangerThingsTrackAdapter(seasonThreeTrack, PlayListActivity.this);
        season3.setAdapter(seasonThreeAdapter);
        seasonFourLayoutManager = new LinearLayoutManager(PlayListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        season4.setLayoutManager(seasonFourLayoutManager);

        seasonFourAdapter = new StrangerThingsTrackAdapter(seasonFourTrack, PlayListActivity.this);
        season4.setAdapter(seasonTwoAdapter);
        // get datas of all season playlist
        // set adapter for all time playlist
        // set into recylverview into horizontal listview (reverse the data optional)

    }
}