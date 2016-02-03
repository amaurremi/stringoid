package com.inmobi.commons.analytics.net;

import android.util.Log;
import com.inmobi.commons.internal.InternalSDKUtil;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AnalyticsCommon {
    private static void a(HttpURLConnection paramHttpURLConnection) {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setDoInput(true);
        paramHttpURLConnection.setConnectTimeout(60000);
        paramHttpURLConnection.setReadTimeout(60000);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        paramHttpURLConnection.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
    }

    public static String getURLEncoded(String paramString) {
        try {
            paramString = URLEncoder.encode(paramString, "UTF-8");
            return paramString;
        } catch (Exception paramString) {
        }
        return "";
    }

    public void closeResource(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException localIOException) {
            Log.d("[InMobi]-[Analytics]-4.5.1", "Exception closing resource: " + paramCloseable, localIOException);
        }
    }

    public void postData(HttpURLConnection paramHttpURLConnection, String paramString) {
        paramHttpURLConnection.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
        try {
            localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramHttpURLConnection.getOutputStream()));
            closeResource(paramString);
        } finally {
            try {
                localBufferedWriter.write(paramString);
                closeResource(localBufferedWriter);
                return;
            } finally {
                BufferedWriter localBufferedWriter;
                paramString = localBufferedWriter;
            }
            paramHttpURLConnection =finally;
            paramString = null;
        }
        throw paramHttpURLConnection;
    }

    public HttpURLConnection setupConnection(String paramString) {
        paramString = (HttpURLConnection) new URL(paramString).openConnection();
        a(paramString);
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */