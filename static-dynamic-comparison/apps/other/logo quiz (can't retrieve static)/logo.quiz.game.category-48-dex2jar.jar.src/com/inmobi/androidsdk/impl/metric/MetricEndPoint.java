package com.inmobi.androidsdk.impl.metric;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetricEndPoint
{
  public static void sendData(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    paramString1.setDoOutput(true);
    paramString1.setDoInput(false);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramString1.getOutputStream());
    localOutputStreamWriter.write(paramString2);
    localOutputStreamWriter.flush();
    localOutputStreamWriter.close();
    paramString1.getResponseCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/MetricEndPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */