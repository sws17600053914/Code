package com.example.admin.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.admin.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = (ImageView) findViewById(R.id.imageview_start);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        animation.setDuration(2000);

        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {



                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
