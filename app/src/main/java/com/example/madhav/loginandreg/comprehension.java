package com.example.madhav.loginandreg;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class comprehension extends AppCompatActivity {

    DatabaseHelper db;
    final int max_marks=22;
    int score,wrong_attempt=0;
    RadioGroup[] rp = new RadioGroup[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehension);
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

    public void submit(View view) {
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
            if (a.equalsIgnoreCase("2           ")) {
                score=score +2;

            }
           }
           catch (Exception e){
               Toast.makeText(this,"Button Left Unchecked",Toast.LENGTH_LONG).show();
           }
        }
        Toast.makeText(this,String.valueOf(score),Toast.LENGTH_SHORT).show();
        int a=Integer.valueOf(score);
        String iq;
        iq= db.getiqscore(a,"VcompRs","age10","VcompTq");
        Toast.makeText(this,iq,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,resultActivity.class);
        intent.putExtra("IQ",iq);
        intent.putExtra("SCORE",String.valueOf(score));
        intent.putExtra("Parent","Comprehension");
        startActivity(intent);

    }
}