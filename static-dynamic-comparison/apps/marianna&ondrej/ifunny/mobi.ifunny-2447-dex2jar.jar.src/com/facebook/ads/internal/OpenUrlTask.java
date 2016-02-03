package com.facebook.ads.internal;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class OpenUrlTask
        extends AsyncTask<String, Void, Void> {
    private static final String INVALID_ADDRESS = "#";
    private static final String TAG = OpenUrlTask.class.getSimpleName();

    private String addAnalogInfo(String paramString) {
        if (StringUtils.isNullOrEmpty(paramString)) {
            return paramString;
        }
        String str = URLEncoder.encode(AdUtilities.jsonEncode(AdAnalogData.getAnalogInfo()));
        if (paramString.contains("?")) {
            return paramString + "&analog=" + str;
        }
        return paramString + "?analog=" + str;
    }

    protected Void doInBackground(String... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        if ((StringUtils.isNullOrEmpty(paramVarArgs)) || (paramVarArgs.equals("#"))) {
            return null;
        }
        paramVarArgs = addAnalogInfo(paramVarArgs);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpGet localHttpGet = new HttpGet(paramVarArgs);
        try {
            localDefaultHttpClient.execute(localHttpGet);
            return null;
        } catch (Exception localException) {
            Log.e(TAG, "Error opening url: " + paramVarArgs, localException);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/OpenUrlTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */