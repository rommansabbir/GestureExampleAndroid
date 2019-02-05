package com.rommansabbir.gestureexampleandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView textViewGesture;
    private View fullScreenLayout;
    private View playlistLayout;
    private FullscreenVideoLayout videoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreenLayout = findViewById(R.id.fullScreenLayout);
        playlistLayout = findViewById(R.id.playlistLayout);
        playlistLayout.setVisibility(View.GONE);


        videoLayout = (FullscreenVideoLayout) findViewById(R.id.videoview);
        videoLayout.setActivity(this);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback);
        try {
            videoLayout.setVideoURI(videoUri);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        textViewGesture = findViewById(R.id.textViewGesture);
        fullScreenLayout.setOnTouchListener(new OnSwipeTouchListner(this){
            public void onSwipeTop() {
//                textViewGesture.setText("Swipe Top");
                if(playlistLayout.getVisibility() == View.GONE){

                    swipeUpAnimation(playlistLayout.getHeight(), 0);

                    playlistLayout.setVisibility(View.VISIBLE);
                }
                else {
                    playlistLayout.setVisibility(View.GONE);
                }
            }

            public void onSwipeRight() {
//                textViewGesture.setText("Swipe Right");
            }

            public void onSwipeLeft() {
//                textViewGesture.setText("Swipe Left");
            }

            public void onSwipeBottom() {
//                textViewGesture.setText("Swipe Bottom");
                if(playlistLayout.getVisibility() == View.VISIBLE){

                    swipeBottomAnimation(0, playlistLayout.getHeight());

                    playlistLayout.setVisibility(View.GONE);

                }
                else {
                    playlistLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void swipeBottomAnimation(int i, int height) {
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                i,
                height);
        animate.setDuration(500);
        animate.setFillAfter(true);
        playlistLayout.startAnimation(animate);
    }

    private void swipeUpAnimation(int height, int i) {
        TranslateAnimation animate = new TranslateAnimation(0, 0, height, i);
        animate.setDuration(500);
        animate.setFillAfter(true);
        playlistLayout.startAnimation(animate);
    }
}
