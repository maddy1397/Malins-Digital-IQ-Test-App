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

public class information extends AppCompatActivity {
    RadioGroup[] rp= new RadioGroup[11] ;
    int score=0;
    DatabaseHelper db;
    Intent intent;
    String User_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
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


        rp[0]=(RadioGroup) findViewById(R.id.q1);
        rp[0]=(RadioGroup) findViewById(R.id.q1);
        rp[1]=(RadioGroup) findViewById(R.id.q2);
        rp[2]=(RadioGroup) findViewById(R.id.q3);
        rp[3]=(RadioGroup) findViewById(R.id.q4);
        rp[4]=(RadioGroup) findViewById(R.id.q5);
        rp[5]=(RadioGroup) findViewById(R.id.q6);
        rp[6]=(RadioGroup) findViewById(R.id.q7);
        rp[7]=(RadioGroup) findViewById(R.id.q8);
        rp[8]=(RadioGroup) findViewById(R.id.q9);
        rp[9]=(RadioGroup) findViewById(R.id.q10);
        rp[10]=(RadioGroup) findViewById(R.id.q11);

        intent = getIntent();
        User_id=intent.getStringExtra("User_id");

    }
    public void submit(View view){
        db=new DatabaseHelper(information.this);
        opendatabase();
        for(int i=0 ; i<11 ; i++){
        String  id= String.valueOf(rp[i].getCheckedRadioButtonId());
           int idi;
            try{
                idi=rp[i].getCheckedRadioButtonId();
                RadioButton r=(RadioButton) findViewById(idi);
                String a= (String) r.getText();
                if(a.equalsIgnoreCase("1           ")){
                    score++;
                }
            }catch (Exception e){
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT);
            }
        }

        Toast.makeText(this,String.valueOf(score),Toast.LENGTH_SHORT).show();
        int a=Integer.valueOf(score);

        String iq= db.getiqscore(a,"VinfoRs","age10","VinfoTq");
        Toast.makeText(this,iq,Toast.LENGTH_SHORT).show();
        opendatabase();
//        db.putinDatabase(User_id,iq,"InfoTQ");
        Intent intent=new Intent(this,resultActivity.class);
        intent.putExtra("IQ",iq);
        intent.putExtra("Parent","InfoTQ");
        intent.putExtra("SCORE",String.valueOf(score));
        intent.putExtra("User_id",User_id);

        startActivity(intent);

    }

public void opendatabase(){
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
}

}
