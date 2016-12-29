package com.example.user.hobia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class shop extends AppCompatActivity implements View.OnClickListener {

    ListView lv;
    Context context;
Button btn;
    ArrayList prgmName;
    public static int[] Images = {R.drawable.headgear, R.drawable.dobox, R.drawable.suling};
    public static String[] NameList = {"Headgear", "Dobox","suling"};

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        context = this;

        lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new CustomAdapter(getApplicationContext(), NameList, Images));
btn=(Button)findViewById(R.id.btnlanjut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent lanjut = new Intent(shop.this, Shoppingcart.class);
                Toast.makeText(getApplicationContext(),"Buy",Toast.LENGTH_SHORT).show();
                startActivity(lanjut);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onClick(View v) {

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    }



