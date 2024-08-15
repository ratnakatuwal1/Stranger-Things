package com.ratna.stranger_things;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playlist, allCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_index);
        mediaPlayer = MediaPlayer.create(this, R.raw.running_up_the_hill);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        playlist = findViewById(R.id.playListBtn);
        allCharacter = findViewById(R.id.characterBtn);

        playlist.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PlayListActivity.class);
            startActivity(intent);
        });

        allCharacter.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AllCharacters.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}