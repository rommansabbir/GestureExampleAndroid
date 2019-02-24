package com.rommansabbir.gestureexampleandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;
import com.rommansabbir.swipeeventlistener.SwipeEventListener;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SwipeEventListener.SwipeEventListenerInterface {
    private TextView textViewGesture;
    private View fullScreenLayout;
    private View playlistLayout;
    private FullscreenVideoLayout videoLayout;
    private static final String TAG = "MainActivity";
    private SwipeEventListener touchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchListener = new SwipeEventListener(this);
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

        fullScreenLayout.setOnTouchListener(touchListener);
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

    @Override
    public void onSwipeRight() {
        Log.d(TAG, "onSwipeRight: ");
    }

    @Override
    public void onSwipeLeft() {
        Log.d(TAG, "onSwipeLeft: ");
    }

    @Override
    public void onSwipeTop() {
        Log.d(TAG, "onSwipeTop: ");
        if(playlistLayout.getVisibility() == View.GONE){

            swipeUpAnimation(playlistLayout.getHeight(), 0);

            playlistLayout.setVisibility(View.VISIBLE);
        }
        else {
            playlistLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSwipeBottom() {
        Log.d(TAG, "onSwipeBottom: ");
        if(playlistLayout.getVisibility() == View.VISIBLE){

            swipeBottomAnimation(0, playlistLayout.getHeight());

            playlistLayout.setVisibility(View.GONE);

        }
        else {
            playlistLayout.setVisibility(View.VISIBLE);
        }
    }
}
