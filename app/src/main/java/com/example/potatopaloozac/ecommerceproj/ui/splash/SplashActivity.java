package com.example.potatopaloozac.ecommerceproj.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.ui.MainActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    Animation rotate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.iv_splash);

        rotate = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.rotate);


        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    imageView.startAnimation(rotate);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        };

        t1.start();
    }
}
