package com.example.lungen;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Details_ extends AppCompatActivity {
    ProgressBar prg;
    int counter=0;
    Button _check;
    EditText _age;
    Spinner _gender;
    Spinner _smoke;
    Spinner _yellow;
    Spinner _anxiety;
    Spinner _peer;
    Spinner _chronic;
    Spinner _fatigue;
    Spinner _allergy;
    Spinner _wheezing;
    Spinner _alcohol;
    Spinner _cough;
    Spinner _breath;
    Spinner _swallow;
    Spinner _chest;
    TextView age_;
    String res="Unable to fetch data";
    String age,gender,smoke,yellow,anxious,peer,chronic,fatigue,allergy,wheezing,alcohol,cough,breath,swallow,chest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.det_activity);
        getSupportActionBar().hide();
        prg=findViewById(R.id.progressBar2);
        age_=findViewById(R.id.age);
        _check=findViewById(R.id.check);
        _gender=findViewById(R.id._gender);
        _age=findViewById(R.id._age);
        _smoke=findViewById(R.id._smocking);
        _yellow=findViewById(R.id._yellow_fingers);
        _anxiety=findViewById(R.id._anxiety);
        _peer=findViewById(R.id._peer_pressure);
        _chronic=findViewById(R.id._chronic);
        _fatigue=findViewById(R.id._fatigue);
        _allergy=findViewById(R.id._allergy);
        _wheezing=findViewById(R.id._wheezing);
        _alcohol=findViewById(R.id._alcohol);
        _cough=findViewById(R.id._cough);
        _breath=findViewById(R.id._breath);
        _swallow=findViewById(R.id._swallow);
        _chest=findViewById(R.id._chest);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence>adap= ArrayAdapter.createFromResource(this, R.array.Choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        _gender.setAdapter(adapter);
        _smoke.setAdapter(adap);
        _yellow.setAdapter(adap);
        _anxiety.setAdapter(adap);
        _peer.setAdapter(adap);
        _chronic.setAdapter(adap);
        _fatigue.setAdapter(adap);
        _allergy.setAdapter(adap);
        _wheezing.setAdapter(adap);
        _alcohol.setAdapter(adap);
        _cough.setAdapter(adap);
        _breath.setAdapter(adap);
        _swallow.setAdapter(adap);
        _chest.setAdapter(adap);



    }

    public void click(View view){
        age=_age.getText().toString();
        gender=_gender.getSelectedItem().toString();
        yellow=_yellow.getSelectedItem().toString();
        anxious=_anxiety.getSelectedItem().toString();
        peer=_peer.getSelectedItem().toString();
        chronic=_chronic.getSelectedItem().toString();
        fatigue=_fatigue.getSelectedItem().toString();
        allergy=_allergy.getSelectedItem().toString();
        wheezing=_wheezing.getSelectedItem().toString();
        alcohol=_alcohol.getSelectedItem().toString();
        cough=_cough.getSelectedItem().toString();
        breath=_breath.getSelectedItem().toString();
        swallow=_swallow.getSelectedItem().toString();
        chest=_chest.getSelectedItem().toString();
        smoke=_smoke.getSelectedItem().toString();
        String ma,fe;
        if(age.isEmpty()||gender.isEmpty()||yellow.isEmpty()||anxious.isEmpty()||peer.isEmpty()||chronic.isEmpty()||fatigue.isEmpty()||allergy.isEmpty()||wheezing.isEmpty()||alcohol.isEmpty()||cough.isEmpty()||breath.isEmpty()||swallow.isEmpty()||chest.isEmpty()||smoke.isEmpty()){
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        else {

            String url="https://lungen-ml.herokuapp.com/predict";
            if(yellow.equals("Yes")){
                yellow="1";
            }
            if(yellow.equals("No")){
                yellow="0";
            }
            if(anxious.equals("Yes")){
                anxious="1";
            }
            if(anxious.equals("No")){
                anxious="0";
            }
            if(peer.equals("Yes")){
                peer="1";
            }
            if(peer.equals("No")){
                peer="0";
            }
            if(chronic.equals("Yes")){
                chronic="1";
            }
            if(chronic.equals("No")){
                chronic="0";
            }
            if(fatigue.equals("Yes")){
                fatigue="1";
            }
            if(fatigue.equals("No")){
                fatigue="0";
            }
            if(allergy.equals("Yes")){
                allergy="1";
            }
            if(allergy.equals("No")){
                allergy="0";
            }
            if(wheezing.equals("Yes")){
                wheezing="1";
            }
            if(wheezing.equals("No")){
                wheezing="0";
            }
            if(alcohol.equals("Yes")){
                alcohol="1";
            }
            if(alcohol.equals("No")){
                alcohol="0";
            }
            if(cough.equals("Yes")){
                cough="1";
            }
            if(cough.equals("No")){
                cough="0";
            }
            if(breath.equals("Yes")){
                breath="1";
            }
            if(breath.equals("No")){
                breath="0";
            }
            if(swallow.equals("Yes")){
                swallow="1";
            }
            if(swallow.equals("No")){
                swallow="0";
            }
            if(chest.equals("Yes")){
                chest="1";
            }
            if(chest.equals("No")){
                chest="0";
            }
            if(smoke.equals("Yes")){
                smoke="1";
            }
            if(smoke.equals("No")){
                smoke="0";
            }
        Log.d("value","here"+(age));
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String data = jsonObject.getString("cancer");
                                if(data.equals("1")){
                                    fin(0);
                                }else{
                                    fin(1);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Details_.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Override
                protected Map getParams(){
                    Map params = new HashMap();
                    params.put("gender", gender);
                    params.put("age", age);
                    params.put("smoke", smoke);
                    params.put("yellow", yellow);
                    params.put("anxiety", anxious);
                    params.put("peer", peer);
                    params.put("chronic", chronic);
                    params.put("fatigue", fatigue);
                    params.put("allergy", allergy);
                    params.put("wheezing", wheezing);
                    params.put("alcohol", alcohol);
                    params.put("cough", cough);
                    params.put("breath", breath);
                    params.put("swallow", swallow);
                    params.put("chest", chest);
                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(Details_.this);
            queue.add(stringRequest);


//            Toast.makeText(this, string[0], Toast.LENGTH_SHORT).show();
            Thread start_=new Thread(){
                public void run() {
                    try {
                        prg.setVisibility(view.VISIBLE);
                        Timer timer =new Timer();
                        TimerTask timerTask =new TimerTask() {
                            @Override
                            public void run() {
                                counter++;
                                prg.setProgress(counter);
                                if(counter==100){
                                    timer.cancel();
                                    Intent intent = new Intent(Details_.this, Result.class);
                                    Log.d("value1","here"+res);
                                    intent.putExtra("result", res);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        };
                        timer.schedule(timerTask,100,100);

                    } catch (Exception e) {
                    }
                }
            };
            start_.start();

        }
    }


    public void fin(int a){
        if(a==0){
            res="You have high probability of having lung cancer";
        }
        else{
            res="You have low probability of having lung cancer";
        }
    }
}