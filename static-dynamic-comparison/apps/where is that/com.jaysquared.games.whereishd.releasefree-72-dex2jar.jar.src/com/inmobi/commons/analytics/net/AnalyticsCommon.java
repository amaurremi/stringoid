package com.inmobi.commons.analytics.net;

import android.util.Log;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class AnalyticsCommon
{
  private static void a(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.setDoInput(true);
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestMethod("POST");
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    InternalSDKUtil.addCommonPropertiesToConnection(paramHttpURLConnection);
  }
  
  public static String getURLEncoded(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public void closeResource(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.d("[InMobi]-[Analytics]-4.1.1", "Exception closing resource: " + paramCloseable, localIOException);
    }
  }
  
  public void postData(HttpURLConnection paramHttpURLConnection, String paramString)
    throws IOException
  {
    paramHttpURLConnection.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
    try
    {
      localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramHttpURLConnection.getOutputStream()));
      closeResource(paramString);
    }
    finally
    {
      try
      {
        localBufferedWriter.write(paramString);
        closeResource(localBufferedWriter);
        return;
      }
      finally
      {
        BufferedWriter localBufferedWriter;
        paramString = localBufferedWriter;
      }
      paramHttpURLConnection = finally;
      paramString = null;
    }
    throw paramHttpURLConnection;
  }
  
  public HttpURLConnection setupConnection(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    a(paramString);
    return paramString;
  }
  
  public static abstract interface HttpRequestCallback
  {
    public static final int HTTP_FAILURE = 1;
    public static final int HTTP_SUCCESS = 0;
    
    public abstract void notifyResult(int paramInt, Object paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */