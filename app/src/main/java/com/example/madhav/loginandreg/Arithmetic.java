package com.example.madhav.loginandreg;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class Arithmetic extends AppCompatActivity {
    Intent intent;
    int wrong_attempt;
    String User_id;
    int score;
    RadioGroup rp[]=new RadioGroup[16];
    public boolean running=false;
    Chronometer mp[]=new Chronometer[16];
    long startTime, stopTime=0;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        db=new DatabaseHelper(this);

        rp[0] = (RadioGroup) findViewById(R.id.q1);
        rp[0] = (RadioGroup) findViewById(R.id.q1);
        rp[1] = (RadioGroup) findViewById(R.id.q2);
        rp[2] = (RadioGroup) findViewById(R.id.q3);
        rp[3] = (RadioGroup) findViewById(R.id.q4);
        rp[4] = (RadioGroup) findViewById(R.id.q5);
        rp[5] = (RadioGroup) findViewById(R.id.q6);
        rp[6] = (RadioGroup) findViewById(R.id.q7);
        rp[7] = (RadioGroup) findViewById(R.id.q8);
        rp[8] = (RadioGroup) findViewById(R.id.q9);
        rp[9] = (RadioGroup) findViewById(R.id.q10);
        rp[10] = (RadioGroup) findViewById(R.id.q11);
        rp[11] = (RadioGroup) findViewById(R.id.q12);
        rp[12] = (RadioGroup) findViewById(R.id.q13);
        rp[13] = (RadioGroup) findViewById(R.id.q14);
        rp[14] = (RadioGroup) findViewById(R.id.q15);
        rp[15] = (RadioGroup) findViewById(R.id.q15);

        mp[15] = (Chronometer) findViewById(R.id.time16);
        mp[14] = (Chronometer) findViewById(R.id.time15);
        mp[13] = (Chronometer) findViewById(R.id.time14);
        mp[12] = (Chronometer) findViewById(R.id.time13);
        mp[11] = (Chronometer) findViewById(R.id.time12);
        mp[10] = (Chronometer) findViewById(R.id.time11);
        mp[9] = (Chronometer) findViewById(R.id.time10);
        mp[8] = (Chronometer) findViewById(R.id.time9);
        mp[7] = (Chronometer) findViewById(R.id.time8);
        mp[6] = (Chronometer) findViewById(R.id.time7);
        mp[5] = (Chronometer) findViewById(R.id.time6);
        mp[4] = (Chronometer) findViewById(R.id.time5);
        mp[3] = (Chronometer) findViewById(R.id.time4);
        mp[2] = (Chronometer) findViewById(R.id.time3);
        mp[1] = (Chronometer) findViewById(R.id.time2);
        mp[0] = (Chronometer) findViewById(R.id.time1);



    }


    public void startchrono(View view){

        int id=view.getId();
        Toast.makeText(this,"in startchrono",Toast.LENGTH_SHORT).show();
        Button b = (Button) findViewById(id);
        switch (id)
        {
            case R.id.chrono1: {
                if (!running) {

                    b.setText("Click to Stop Time");
                    mp[0].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[0].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                break;
            }
            case R.id.chrono2:
                {
                    if (!running) {

                        b.setText("Click to Stop Time");
                        mp[1].start();
                        startTime = System.currentTimeMillis();
                        running = true;
                    } else {
                        mp[1].stop();
                        b.setText("Click to Start Time");
                        running=false;
                    }
                    break;
                }
            case R.id.chrono3:
                {
                    if (!running) {

                        b.setText("Click to Stop Time");
                        mp[2].start();
                        startTime = System.currentTimeMillis();
                        running = true;
                    } else {
                        mp[2].stop();
                        b.setText("Click to Start Time");
                        running=false;
                    }
                    break;
                }
            case R.id.chrono4:
                {
                    if (!running) {

                        b.setText("Click to Stop Time");
                        mp[3].start();
                        startTime = System.currentTimeMillis();
                        running = true;
                    } else {
                        mp[3].stop();
                        b.setText("Click to Start Time");
                        running=false;
                    }
                    break;
                }
            case R.id.chrono5:
                {
                    if (!running) {

                        b.setText("Click to Stop Time");
                        mp[4].start();
                        startTime = System.currentTimeMillis();
                        running = true;
                    } else {
                        mp[4].stop();
                        b.setText("Click to Start Time");
                        running=false;
                    }
                    break;
                }
            case R.id.chrono6:
                {
                    if (!running) {

                        b.setText("Click to Stop Time");
                        mp[5].start();
                        startTime = System.currentTimeMillis();
                        running = true;
                    } else {
                        mp[5].stop();
                        b.setText("Click to Start Time");
                        running=false;
                    }
                    break;
                }
            case R.id.chrono7:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[6].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[6].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono8:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[7].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[7].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono9:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[8].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[8].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono10:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[9].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[9].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono11:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[10].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[10].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono12:
            { if (!running) {

                b.setText("Click to Stop Time");
                mp[11].start();
                startTime = System.currentTimeMillis();
                running = true;
            } else {
                mp[11].stop();
                b.setText("Click to Start Time");
                running=false;
            }
                break;
            }

            case R.id.chrono13:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[12].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[12].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono14:
                { if (!running) {

                    b.setText("Click to Stop Time");
                    mp[13].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[13].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                    break;
                }
            case R.id.chrono15:
            { if (!running) {

                b.setText("Click to Stop Time");
                mp[14].start();
                startTime = System.currentTimeMillis();
                running = true;
            } else {
                mp[14].stop();
                b.setText("Click to Start Time");
                running=false;
            }
                break;
            }
            case R.id.chrono16:
            {
                if (!running) {

                    b.setText("Click to Stop Time");
                    mp[15].start();
                    startTime = System.currentTimeMillis();
                    running = true;
                } else {
                    mp[15].stop();
                    b.setText("Click to Start Time");
                    running=false;
                }
                break;
            }

        }



    }
    public void zero (View view){
        ++wrong_attempt;
        if(wrong_attempt==3){
            wrong_attempt=0;
            Toast.makeText(this,"STOP TEST 3 Consecutive Wrong Attempts",Toast.LENGTH_LONG).show();
        }
    }
    public void nonzero(View view){
        wrong_attempt=0;
    }

    public void Submit(View view) {
        try {
            db.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            db.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        for (int i = 0; i < 14; i++) {
            String a;
            String id = String.valueOf(rp[i].getCheckedRadioButtonId());
            try{
                int idi = rp[i].getCheckedRadioButtonId();
                RadioButton r = (RadioButton) findViewById(idi);
                a = (String) r.getText();

                if (a.equalsIgnoreCase("1           ")) {
                    score++;
                }

            }
            catch (Exception e){
                Toast.makeText(this,"Button Left Unchecked",Toast.LENGTH_LONG).show();
            }
        }
        Toast.makeText(this,String.valueOf(score),Toast.LENGTH_SHORT).show();
        int a=Integer.valueOf(score);
        String iq= db.getiqscore(a,"VcompRs","age10","VcompTq");
        Toast.makeText(this,iq,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,resultActivity.class);
        intent.putExtra("IQ",iq);
        intent.putExtra("SCORE",String.valueOf(score));
        intent.putExtra("Parent","Comprehension");
        startActivity(intent);

    }
}
