package com.scoreloop.client.android.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTTPUtils
{
  public static InputStream a(String paramString)
    throws URISyntaxException, ClientProtocolException, IOException
  {
    return a(new URL(paramString));
  }
  
  public static InputStream a(URL paramURL)
    throws URISyntaxException, ClientProtocolException, IOException
  {
    paramURL = new HttpGet(paramURL.toURI());
    return b(new DefaultHttpClient().execute(paramURL));
  }
  
  public static String a(HttpResponse paramHttpResponse)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpResponse.getEntity().getContent()));
    String str;
    for (paramHttpResponse = "";; paramHttpResponse = paramHttpResponse + str)
    {
      str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
    }
    localBufferedReader.close();
    return paramHttpResponse;
  }
  
  public static InputStream b(HttpResponse paramHttpResponse)
    throws IOException
  {
    return paramHttpResponse.getEntity().getContent();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/utils/HTTPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */