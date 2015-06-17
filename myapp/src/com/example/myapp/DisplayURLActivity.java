package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DisplayUrlActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String url = intent.getStringExtra(MyActivity.EXTRA_URL);
        try {
            String response = new ReceiveUrlCountTask().execute(url).get();
            JSONObject json = new JSONObject(response);
            String count = json.getString("count");
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText("The URL " + url + " was retweeted " + count + " times.");
            setContentView(textView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ReceiveUrlCountTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(
                    "http://urls.api.twitter.com/1/urls/count.json?url=" + urls[0]
                ).openConnection();
                try {
                    StringWriter writer = new StringWriter();
                    IOUtils.copy(connection.getInputStream(), writer);
                    return writer.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    connection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}