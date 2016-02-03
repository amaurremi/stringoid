package com.google.ads.internal;

import android.content.Context;
import com.google.ads.m;
import com.google.ads.m.a;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class j
  implements Runnable
{
  private String a;
  private Context b;
  
  public j(String paramString, Context paramContext)
  {
    this.a = paramString;
    this.b = paramContext;
  }
  
  protected BufferedOutputStream a(HttpURLConnection paramHttpURLConnection)
  {
    return new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setDoOutput(true);
    paramURL.setInstanceFollowRedirects(true);
    AdUtil.a(paramURL, this.b);
    paramURL.setRequestProperty("Accept", "application/json");
    paramURL.setRequestProperty("Content-Type", "application/json");
    return paramURL;
  }
  
  public void run()
  {
    Object localObject1 = (String)((m.a)m.a().b.a()).h.a();
    try
    {
      localObject1 = a(new URL((String)localObject1));
      byte[] arrayOfByte = new j.a(this.a).a().toString().getBytes();
      ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(arrayOfByte.length);
      try
      {
        BufferedOutputStream localBufferedOutputStream = a((HttpURLConnection)localObject1);
        localBufferedOutputStream.write(arrayOfByte);
        localBufferedOutputStream.close();
        if (((HttpURLConnection)localObject1).getResponseCode() != 200) {
          b.b("Got error response from BadAd backend: " + ((HttpURLConnection)localObject1).getResponseMessage());
        }
        return;
      }
      finally
      {
        ((HttpURLConnection)localObject1).disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      b.b("Error reporting bad ad.", localIOException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */