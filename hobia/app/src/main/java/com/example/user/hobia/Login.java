package com.example.user.hobia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText emailinput;
    EditText passinput;
    Button btnsubmit;
    User user;
    Vectordb User;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailinput = (EditText) findViewById(R.id.emailinput);
        passinput = (EditText) findViewById(R.id.passinput);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);


//        Bundle b = getIntent().getExtras().getBundle();

        btnsubmit.setOnClickListener(this);
    }






    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String user = emailinput.getText().toString();
        String pass = passinput.getText().toString();
        if (v.equals(btnsubmit)) {
            Intent pindah = new Intent(Login.this,shop.class);
//            pindah.putExtra("database",(Serializable)User);
            startActivity(pindah);

            Toast.makeText(getApplicationContext(),"login sukses",Toast.LENGTH_LONG).show();


        } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }


    }
}





