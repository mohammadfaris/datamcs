package com.example.user.hobia;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;

import java.util.ArrayList;

public class Registrasi extends AppCompatActivity implements View.OnClickListener {

    EditText emailregis, passwordRegis, phone, firstName, lastName, birthdate;
    Button regis;
    Vectordb User;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        emailregis = (EditText) findViewById(R.id.emailregistrasi);
        passwordRegis =(EditText) findViewById(R.id.passwordregis);
        firstName =(EditText) findViewById(R.id.firstname);
        lastName =(EditText) findViewById(R.id.Secondname);
        phone =(EditText) findViewById(R.id.phone);
        regis =(Button) findViewById(R.id.register);
        birthdate =(EditText) findViewById(R.id.birthdate);

        User = new Vectordb();
        user = new User();

        if(getIntent().getSerializableExtra("database")!=null){
            User=(Vectordb) getIntent().getSerializableExtra("database");
        }


        regis.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String email = emailregis.getText().toString();
        String password = passwordRegis.getText().toString();

        if(v.equals(regis)){

            if(email.isEmpty()){
                Toast.makeText(getApplicationContext(),"email must be filled",Toast.LENGTH_LONG).show();
            }
            else if(email.contains("@.")&&email.contains(".@")){
                Toast.makeText(getApplicationContext(),"Your email cannot contains neither @. nor .@",Toast.LENGTH_LONG).show();
            }
            else if(!email.contains("@")|| !email.contains(".")){
                Toast.makeText(getApplicationContext(),"email must be filled @ and .",Toast.LENGTH_LONG).show();
            }
            else if(password.length()<8 ){
                Toast.makeText(getApplicationContext(),"password must be 8 character or more ",Toast.LENGTH_LONG).show();
            }
            else if(password.isEmpty()){
                Toast.makeText(getApplicationContext(),"password must be filled",Toast.LENGTH_LONG).show();
            }else {
                user.setEmailRegis(emailregis.getText().toString());
                user.setPassword(passwordRegis.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                User.addUser(user);
                Toast.makeText(getApplicationContext(), "Register Sukses", Toast.LENGTH_SHORT).show();
                Intent berikutnya = new Intent(Registrasi.this, Login.class);
                berikutnya.putExtra("database",(Serializable)User);
                startActivity(berikutnya);
            }
        }





    }

}
