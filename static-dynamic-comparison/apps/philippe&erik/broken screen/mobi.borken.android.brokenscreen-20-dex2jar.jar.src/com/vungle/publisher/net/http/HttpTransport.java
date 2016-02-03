package com.vungle.publisher.net.http;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.vungle.publisher.bv;
import com.vungle.publisher.ck;
import com.vungle.publisher.log.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HttpTransport
{
  static
  {
    if (Build.VERSION.SDK_INT < 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  public static bv a(HttpRequest paramHttpRequest)
  {
    try
    {
      String str1 = paramHttpRequest.b;
      HttpRequest.a locala = paramHttpRequest.a();
      Logger.d("VungleNetwork", locala + " " + str1);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramHttpRequest.b).openConnection();
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      if (locala != null) {
        localHttpURLConnection.setRequestMethod(locala.toString());
      }
      Bundle localBundle = paramHttpRequest.c;
      int i;
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Object localObject = localBundle.getString(str2);
          if (localObject == null)
          {
            localObject = localBundle.getStringArray(str2);
            int j = localObject.length;
            i = 0;
            while (i < j)
            {
              String str3 = localObject[i];
              Logger.v("VungleNetwork", "request header: " + str2 + ": " + str3);
              localHttpURLConnection.addRequestProperty(str2, str3);
              i += 1;
            }
          }
          else
          {
            Logger.v("VungleNetwork", "request header: " + str2 + ": " + (String)localObject);
            localHttpURLConnection.addRequestProperty(str2, (String)localObject);
          }
        }
      }
      return bv.a(600);
    }
    catch (MalformedURLException paramHttpRequest)
    {
      Logger.d("VungleNetwork", ck.a(paramHttpRequest));
      return bv.a(601);
      paramHttpRequest = paramHttpRequest.d;
      if (!TextUtils.isEmpty(paramHttpRequest))
      {
        Logger.d("VungleNetwork", "request body: " + paramHttpRequest);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.getOutputStream().write(paramHttpRequest.getBytes());
      }
      i = localHttpURLConnection.getResponseCode();
      paramHttpRequest = localHttpURLConnection.getContentType();
      Logger.d("VungleNetwork", "HTTP response code: " + i + ", content-type: " + paramHttpRequest + " for " + locala + " " + str1);
      paramHttpRequest = bv.a(i, localHttpURLConnection);
      return paramHttpRequest;
    }
    catch (ConnectException paramHttpRequest)
    {
      Logger.d("VungleNetwork", ck.a(paramHttpRequest));
      return bv.a(602);
    }
    catch (SocketTimeoutException paramHttpRequest)
    {
      Logger.d("VungleNetwork", ck.a(paramHttpRequest));
      return bv.a(603);
    }
    catch (IOException paramHttpRequest)
    {
      Logger.w("VungleNetwork", ck.a(paramHttpRequest));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */