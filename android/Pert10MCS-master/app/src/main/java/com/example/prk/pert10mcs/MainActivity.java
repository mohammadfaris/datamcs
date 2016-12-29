package com.example.prk.pert10mcs;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.txtView);
        new GetJSON().execute();
    }

    class GetJSON extends AsyncTask<Void, Void, Void>
    {
        String str;
        String name;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "get json", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Httphandler handler = new Httphandler();
            String url = "http://api.androidhive.info/contacts/";
            str = handler.makeRequest(url);

            try {
                JSONObject jobj = new JSONObject(str);
                JSONArray kontak = jobj.getJSONArray("contacts");   //contacts ikutin yang ada di JSON (link)
                                                                    //Contacts dimulai dengan '[' 'kurung siku' sehingga JSONArray
                for(int i=0; i<kontak.length();i++){
                    name += kontak.getJSONObject(i).getString("name")+"\n";
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtView.setText(name);
        }
    }
}
