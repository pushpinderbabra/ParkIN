package com.example.prachi.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimpageFirst extends AppCompatActivity {

    private static int SPLASH_TIME=2000;
    ImageView parklogo;
    TextView parkin,quote;
    Animation uptodown,fadein,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animpage_first);
        parklogo=findViewById(R.id.parklogo);
        parkin=findViewById(R.id.parkin);
        quote=findViewById(R.id.quote);
        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this,R.anim.downtoup);
        fadein= AnimationUtils.loadAnimation(this,R.anim.fadein);
        parklogo.setAnimation(uptodown);
        parkin.setAnimation(downtoup);
        quote.setAnimation(downtoup);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(AnimpageFirst.this, MainActivity.class);
                startActivity(mySuperIntent);
                finish();
            }
        }, SPLASH_TIME);
    }

}
