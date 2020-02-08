package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play);
        Button pauseButton = (Button) findViewById(R.id.pause);
        Button up = (Button) findViewById(R.id.upVolume);
        Button down = (Button) findViewById(R.id.downVolume);

        final int test = 1;
        final int testt = -1;
        final int testOne = test + 1;
        final int testTwo = test - 1;

        final int maxVolume  = 50;
        final int currVolume = 1;
        final float log1=(float)(Math.log(maxVolume-currVolume)/Math.log(maxVolume));


        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I`m done", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVolume(log1,log1);

            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVolume(testt, testt);
            }
        });

//        up.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
//                    mediaPlayer.setVolume(test, test);
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        down.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
//                    mediaPlayer.setVolume(testt, testt);
//                    return true;
//                }
//                return false;
//            }
//        });


    }
}
