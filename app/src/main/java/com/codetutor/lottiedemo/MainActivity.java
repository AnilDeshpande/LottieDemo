package com.codetutor.lottiedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAniView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAniView = (LottieAnimationView) findViewById(R.id.lottieAniView);
        lottieAniView.setRepeatCount(LottieDrawable.INFINITE);

        Log.i("Lottie","Animation Duration: "+lottieAniView.getDuration());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            navigateToNextActivity();
                        }
                    });
                }catch (InterruptedException e){

                }
            }
        }).start();

    }

    private void navigateToNextActivity(){
        Intent intent =new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
