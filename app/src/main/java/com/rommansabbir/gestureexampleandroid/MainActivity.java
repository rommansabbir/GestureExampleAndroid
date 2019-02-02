package com.rommansabbir.gestureexampleandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewGesture;
    private View fullScreenLayout;
    private View playlistLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreenLayout = findViewById(R.id.fullScreenLayout);
        playlistLayout = findViewById(R.id.playlistLayout);
        playlistLayout.setVisibility(View.GONE);

        textViewGesture = findViewById(R.id.textViewGesture);
        fullScreenLayout.setOnTouchListener(new OnSwipeTouchListner(this){
            public void onSwipeTop() {
                textViewGesture.setText("Swipe Top");
                if(playlistLayout.getVisibility() == View.GONE){
                    playlistLayout.setVisibility(View.VISIBLE);
                }
                else {
                    playlistLayout.setVisibility(View.GONE);
                }
            }

            public void onSwipeRight() {
                textViewGesture.setText("Swipe Right");
            }

            public void onSwipeLeft() {
                textViewGesture.setText("Swipe Left");
            }

            public void onSwipeBottom() {
                textViewGesture.setText("Swipe Bottom");
                if(playlistLayout.getVisibility() == View.VISIBLE){
                    playlistLayout.setVisibility(View.GONE);
                }
                else {
                    playlistLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
