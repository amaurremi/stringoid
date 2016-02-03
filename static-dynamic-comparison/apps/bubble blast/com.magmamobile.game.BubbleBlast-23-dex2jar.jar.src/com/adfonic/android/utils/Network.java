package com.adfonic.android.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network
{
  private static HttpURLConnection getUrlConnection(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setInstanceFollowRedirects(false);
    return paramString;
  }
  
  public static String requestDestinationUrl(String paramString)
  {
    try
    {
      paramString = getUrlConnection(paramString);
      paramString.getInputStream();
      paramString = paramString.getHeaderField("location");
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("Error getting ad destination URL", paramString);
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/utils/Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */