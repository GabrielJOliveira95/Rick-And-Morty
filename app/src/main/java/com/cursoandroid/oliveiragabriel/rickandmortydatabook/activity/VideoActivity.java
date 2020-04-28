package com.cursoandroid.oliveiragabriel.rickandmortydatabook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().hide();

        View view = getWindow().getDecorView();
        int ui = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        view.setSystemUiVisibility(ui);

        videoView = findViewById(R.id.videoView);

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoView.start();
    }
}
