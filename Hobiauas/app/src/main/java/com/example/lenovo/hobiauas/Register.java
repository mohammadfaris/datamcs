package com.example.lenovo.hobiauas;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.drm.ProcessedData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.hobiauas.database.UserDBHelper;

public class Register extends AppCompatActivity implements View.OnClickListener{
EditText namapertama;
    EditText namakedua;
    EditText email;
    EditText pswd;
    Button register;
UserDBHelper userDbHelper;
    SQLiteDatabase sqlitedatabase;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    namapertama = (EditText) findViewById(R.id.firstname);
        namakedua = (EditText) findViewById(R.id.Secondname);
        email =(EditText) findViewById(R.id.emailregistrasi);
        pswd =(EditText) findViewById(R.id.passwordregis);
        register= (Button) findViewById(R.id.register);

        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
String firstname = namapertama.getText().toString();
        String lastname = namakedua.getText().toString();
        String Email = email.getText().toString();
        String password = pswd.getText().toString();
        userDbHelper = new UserDBHelper(context);
        sqlitedatabase= userDbHelper.getWritableDatabase();
        if(v.equals(register)){
            if(firstname.isEmpty()){
            Toast.makeText(getApplicationContext(),"nama pertama harus di isi",Toast.LENGTH_SHORT).show();
            }
            else if(lastname.isEmpty()){
                Toast.makeText(getApplicationContext(),"nama kedua harus di isi",Toast.LENGTH_SHORT).show();
            }
            else if(Email.isEmpty()){
                Toast.makeText(getApplicationContext(),"email wajib di isi",Toast.LENGTH_SHORT).show();
            }
            else  if(Email.contains("@.") && Email.contains(".@")){
                Toast.makeText(getApplicationContext(),"Your email cannot contains neither @. nor .@",Toast.LENGTH_SHORT).show();
            }
                else if(!Email.contains("@")|| !Email.contains(".")){
                Toast.makeText(getApplicationContext(),"email must be filled @ and .",Toast.LENGTH_SHORT).show();
            }
            else if(password.length()<8 ){
                Toast.makeText(getApplicationContext(),"password must be 8 character or more ",Toast.LENGTH_SHORT).show();
            }
            else if(password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "password must be filled", Toast.LENGTH_SHORT).show();
            }
            else {
                userDbHelper.addData(firstname,lastname,Email,password,sqlitedatabase);
                Toast.makeText(getApplicationContext(),"User registered sucessfully",Toast.LENGTH_SHORT).show();
                userDbHelper.close();
                namapertama.setText("");
                namakedua.setText("");
                email.setText("");
                pswd.setText("");
            }

        }


}
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itemkedua, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent selanjutnya = new Intent(Register.this, MainActivity.class);
                startActivity(selanjutnya);
                Toast.makeText(getApplicationContext(), "Menu  login dipilih", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }




    }
}
