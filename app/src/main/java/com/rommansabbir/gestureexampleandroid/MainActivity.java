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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreenLayout = findViewById(R.id.fullScreenLayout);
        textViewGesture = findViewById(R.id.textViewGesture);
        fullScreenLayout.setOnTouchListener(new OnSwipeTouchListner(this){
            public void onSwipeTop() {
                textViewGesture.setText("Swipe Top");
            }

            public void onSwipeRight() {
                textViewGesture.setText("Swipe Right");
            }

            public void onSwipeLeft() {
                textViewGesture.setText("Swipe Left");
            }

            public void onSwipeBottom() {
                textViewGesture.setText("Swipe Bottom");
            }
        });
    }
}
