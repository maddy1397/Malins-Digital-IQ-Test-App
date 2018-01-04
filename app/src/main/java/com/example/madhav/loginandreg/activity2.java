package com.example.madhav.loginandreg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity2 extends AppCompatActivity {
    String user,pass;
    EditText e1,e2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        e1=(EditText) findViewById(R.id.email);
        e2=(EditText) findViewById(R.id.Password);
        db=new DatabaseHelper(this);
        Toast.makeText(this,"ON CREATE",Toast.LENGTH_SHORT).show();
    }
    public void signupClicked(View view){
        Intent intent=new Intent(this,activity1.class);
        startActivity(intent);
    }

    public void SigninClicked(View view)
    {
        Intent intent=new Intent(this,activity3.class);
        startActivity(intent);
        String s1=e1.getText().toString();

        String s2=e2.getText().toString();
//       try {
//           pass = db.getpass(s1);
//       }catch (Exception e){
//           Toast.makeText(this,"Wrong Input",Toast.LENGTH_SHORT).show();
//       }
//       if (s2.equals(pass)) {
//             Intent intent = new Intent(this, activity3.class);
//            intent.putExtra("User_id",s1);
//            startActivity(intent);
//        }
//        else {
//            Log.d("Information Not Valid", "In Else Of SIgn In");
//            Toast.makeText(activity2.this, "Invalid Input", Toast.LENGTH_SHORT).show();
//        }

    }

}

