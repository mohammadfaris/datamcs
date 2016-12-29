package com.example.user.hobia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.halamanawal, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.activity_main:
                Intent selanjutnya =new Intent(MainActivity.this,Registrasi.class);
                startActivity(selanjutnya);
                Toast.makeText(getApplicationContext(),"Menu  registrasi dipilih",Toast.LENGTH_LONG).show();
                return true;
            case R.id.activity_login:
                Intent pindah =new Intent(MainActivity.this,Login.class);
                startActivity(pindah);
                Toast.makeText(getBaseContext(),"Menu Login dipilih",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
