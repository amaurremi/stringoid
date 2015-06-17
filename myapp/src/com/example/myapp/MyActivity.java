package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class  MyActivity extends Activity {

    public final static String EXTRA_URL = "com.example.myapp.URL";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayUrlActivity.class);
        EditText editUrl = (EditText) findViewById(R.id.edit_url);
        String url = editUrl.getText().toString();
        intent.putExtra(EXTRA_URL, url);
        startActivity(intent);
    }
}
