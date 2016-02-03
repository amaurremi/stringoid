package com.millennialmedia.android;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

final class Utils$HttpUtils$1
        implements Runnable {
    Utils$HttpUtils$1(String paramString) {
    }

    public void run() {
        try {
            new DefaultHttpClient().execute(new HttpGet(this.a));
            MMLog.b("Utils", "Executed Url :\"" + this.a + "\"");
            return;
        } catch (IOException localIOException) {
            MMLog.a("Utils", "Exception with HttpUtils: ", localIOException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/Utils$HttpUtils$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */