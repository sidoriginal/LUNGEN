package com.example.lungen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView s;
    Button again_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        again_=findViewById(R.id.agn);
        setContentView(R.layout.activity_result);
        s=findViewById(R.id.textView);
        Intent intent =getIntent();
        String h=intent.getStringExtra("result");
        s.append(h);
    }
    public void oclick(View view){
        Intent i=new Intent(Result.this,Details_.class);
        startActivity(i);
        finish();
    }


}