package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetricEndPoint {
    public static void sendData(String paramString1, String paramString2) {
        paramString1 = (HttpURLConnection) new URL(paramString1).openConnection();
        paramString1.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        paramString1.setDoOutput(true);
        paramString1.setDoInput(false);
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramString1.getOutputStream());
        localOutputStreamWriter.write(paramString2);
        localOutputStreamWriter.flush();
        localOutputStreamWriter.close();
        paramString1.getResponseCode();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/metric/MetricEndPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */