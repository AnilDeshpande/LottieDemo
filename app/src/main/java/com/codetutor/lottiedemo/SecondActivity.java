package com.codetutor.lottiedemo;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    LottieAnimationView busyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView);
        busyAnimation = (LottieAnimationView) findViewById(R.id.loadinAnimation);

        busyAnimation.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    SecondActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            busyAnimation.setVisibility(View.INVISIBLE);
                            textView.setVisibility(View.VISIBLE);
                        }
                    });
                }catch (InterruptedException e){

                }
            }
        }).start();

    }

}
