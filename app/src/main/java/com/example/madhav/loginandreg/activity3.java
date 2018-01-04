package com.example.madhav.loginandreg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class activity3 extends Activity {
    Intent intent;
    String username;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        intent=getIntent();
        username=intent.getStringExtra("User_id");
    }
    public void information(View view){
    Intent intent = new Intent(this,information.class);
        intent.putExtra("User_id",username);
        startActivity(intent);
    }

    public void comprehension(View view){
        Intent intent = new Intent(this,comprehension.class);
        intent.putExtra("User_id",username);
        startActivity(intent);
    }
    public void arithmetic(View view){
        Intent intent = new Intent(this,Arithmetic.class);
        intent.putExtra("User_id",username);
        startActivity(intent);
    }
    public void vocabulary(View view){
        Intent intent=new Intent(this,Vocabulary.class);
        intent.putExtra("User_id",username);
        startActivity(intent);
    }
}
