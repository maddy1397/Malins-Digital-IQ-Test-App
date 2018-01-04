package com.example.madhav.loginandreg;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class resultActivity extends AppCompatActivity {
    TextView t7,t8,t10,t11;
    String info_iq,parent,info_score,comp_iq,comp_score;
    Intent intent;
    DatabaseHelper db;
    String User_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t7=(TextView) findViewById(R.id.textView7);
        t8=(TextView) findViewById(R.id.textView8);
        t10=(TextView) findViewById(R.id.textView10);
        t11=(TextView) findViewById(R.id.textView11);
        intent=getIntent();
        parent=intent.getStringExtra("Parent");
        User_id=intent.getStringExtra("User_id");

        db=new DatabaseHelper(resultActivity.this);
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
        print();

    }
    public void back(View view){
        Intent intent=new Intent(this,activity3.class);
        startActivity(intent);
    }
    public void print(){

        if(parent.equalsIgnoreCase("Information")){

          // String TQ= db.getTQ(User_id,parent);
            info_iq=intent.getStringExtra("IQ");
            info_score=intent.getStringExtra("SCORE");
            t7.setText(info_iq);
           // t7.setText(TQ);
            t8.setText(info_score);
            t11.setText(comp_iq);
            t10.setText(comp_score);
        }
        if(parent.equalsIgnoreCase("Comprehension")){
            comp_iq=intent.getStringExtra("IQ");
            comp_score=intent.getStringExtra("SCORE");
            t11.setText(comp_iq);
            t10.setText(comp_score);
            t7.setText(info_iq);
            t8.setText(info_score);
        }
    }
}
