package com.example.prk.pert10mcs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by prk on 12/15/2016.
 */
public class Httphandler {

        public String makeRequest(String url)
        {
            String response = null;


            try {
                URL reqUrl = new URL(url);
                HttpURLConnection connect = (HttpURLConnection) reqUrl.openConnection();
                connect.setRequestMethod("GET");

                InputStream is = new BufferedInputStream(connect.getInputStream());
                response = inputStreamToString(is);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }
    String inputStreamToString(InputStream is)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String temp;
        try {
            while((temp = br.readLine()) != null)
            {
                sb.append(temp).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
