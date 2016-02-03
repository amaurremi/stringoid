package com.appbrain.a;

import android.content.Context;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;

final class ch
  extends AsyncTask
{
  ch(String paramString, Context paramContext) {}
  
  private String a()
  {
    int i = 0;
    String str = this.a;
    for (;;)
    {
      if (i < 5) {}
      try
      {
        if (cg.a(str)) {
          return str;
        }
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
        localHttpURLConnection.setInstanceFollowRedirects(false);
        if ((localHttpURLConnection.getResponseCode() >= 300) && (localHttpURLConnection.getResponseCode() < 400))
        {
          str = localHttpURLConnection.getHeaderField("Location");
          i += 1;
        }
        else
        {
          return str;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */