package com.codetutor.lottiedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
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
