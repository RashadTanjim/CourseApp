package com.programminghero.courseapp;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.programminghero.courseapp.utils.PrefManager;

public class SplashScreen extends AppCompatActivity {

    private PrefManager prefManager;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            prefManager.setVersionNumber(BuildConfig.VERSION_NAME);
            launchHomeScreen();
            prefManager.setInstalledTime(System.currentTimeMillis());
        } else {
            setContentView(R.layout.activity_splash_screen);
            lottie = findViewById(R.id.lottie);
            lottie.setAnimation(R.raw.splash);
            lottie.playAnimation();
            lottie.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d("SPLASHLOTTIE", "onAnimationStart: ");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d("SPLASHLOTTIE", "onAnimationEnd: ");
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }


    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(SplashScreen.this, LoginActivity.class)
                .putExtra("welcome", 0));
        finishAffinity();
    }

    @Override
    protected void onDestroy() {

        if (prefManager != null) {
            prefManager = null;
        }
        super.onDestroy();
    }

}
