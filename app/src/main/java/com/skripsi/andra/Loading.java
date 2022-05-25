package com.skripsi.andra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Loading extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        iv = findViewById(R.id.imageView);

        Animation startAnimation = AnimationUtils.loadAnimation(Loading.this, R.anim.ani);
        iv.startAnimation(startAnimation);
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                startActivity( new Intent(Loading.this , main.class));
                Loading.this.finish();
            }
        }.start();
    }
}