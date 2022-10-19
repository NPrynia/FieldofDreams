package com.example.gamepolechudec;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class LoadActivity extends AppCompatActivity
{

    ImageView iv;
    TextView tv;
    Animation anim;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_layout);
        iv = findViewById(R.id.imageViewLoad);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_load);

        RotateAnimation rotate = new RotateAnimation(200,900,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        rotate.setDuration(3600);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new DecelerateInterpolator());
        iv.startAnimation(rotate);
        anim = AnimationUtils.loadAnimation(this,R.anim.anim_text_load);
        tv = (TextView) findViewById(R.id.textViewLoad);
        tv.startAnimation(anim);
        mp.start();


        Thread thread = new Thread(){
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(3);
                    Intent i = new Intent(LoadActivity.this, MainActivity.class);
                    startActivity(i);
                    mp.stop();
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };thread.start();


    }
}
