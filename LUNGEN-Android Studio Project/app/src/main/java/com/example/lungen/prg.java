package com.example.lungen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class prg extends AppCompatActivity {
ProgressBar prg;
int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prg);
        prg=findViewById(R.id.progressBar);
        Timer timer =new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                counter++;
                if(counter==100){
                    timer.cancel();
                }
            }
        };
    }
}