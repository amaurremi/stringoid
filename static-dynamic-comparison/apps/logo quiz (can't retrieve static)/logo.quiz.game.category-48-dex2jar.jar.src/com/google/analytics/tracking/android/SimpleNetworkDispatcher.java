package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher
  implements Dispatcher
{
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
  private final Context ctx;
  private final HttpClientFactory httpClientFactory;
  private final String userAgent;
  
  SimpleNetworkDispatcher(AnalyticsStore paramAnalyticsStore, HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    this(paramHttpClientFactory, paramContext);
  }
  
  SimpleNetworkDispatcher(HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    this.ctx = paramContext.getApplicationContext();
    this.userAgent = createUserAgentString("GoogleAnalytics", "2.0", Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
    this.httpClientFactory = paramHttpClientFactory;
  }
  
  private HttpEntityEnclosingRequest buildRequest(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("Empty hit, discarding.");
      return null;
    }
    String str = paramString2 + "?" + paramString1;
    if (str.length() < 2036) {
      paramString1 = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      paramString1.addHeader("User-Agent", this.userAgent);
      return paramString1;
      paramString2 = new BasicHttpEntityEnclosingRequest("POST", paramString2);
      try
      {
        paramString2.setEntity(new StringEntity(paramString1));
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        Log.w("Encoding error, discarding hit");
      }
    }
    return null;
  }
  
  private URL getUrl(Hit paramHit)
  {
    if (TextUtils.isEmpty(paramHit.getHitUrl())) {
      return null;
    }
    try
    {
      paramHit = new URL(paramHit.getHitUrl());
      return paramHit;
    }
    catch (MalformedURLException paramHit)
    {
      try
      {
        paramHit = new URL("http://www.google-analytics.com/collect");
        return paramHit;
      }
      catch (MalformedURLException paramHit) {}
    }
    return null;
  }
  
  private void logDebugInformation(boolean paramBoolean, HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localStringBuffer = new StringBuffer();
      localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        localStringBuffer.append(localObject[i].toString()).append("\n");
        i += 1;
      }
      localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
      if (paramHttpEntityEnclosingRequest.getEntity() == null) {}
    }
    try
    {
      paramHttpEntityEnclosingRequest = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (paramHttpEntityEnclosingRequest != null)
      {
        i = paramHttpEntityEnclosingRequest.available();
        if (i > 0)
        {
          localObject = new byte[i];
          paramHttpEntityEnclosingRequest.read((byte[])localObject);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String((byte[])localObject)).append("\n");
        }
      }
    }
    catch (IOException paramHttpEntityEnclosingRequest)
    {
      for (;;)
      {
        Log.w("Error Writing hit to log...");
      }
    }
    Log.i(localStringBuffer.toString());
  }
  
  String createUserAgentString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  public int dispatchHits(List<Hit> paramList)
  {
    int i = 0;
    int k = Math.min(paramList.size(), 40);
    int j = 0;
    HttpClient localHttpClient;
    Object localObject1;
    Object localObject2;
    HttpHost localHttpHost;
    if (j < k)
    {
      localHttpClient = this.httpClientFactory.newInstance();
      localObject1 = (Hit)paramList.get(j);
      localObject2 = getUrl((Hit)localObject1);
      if (localObject2 == null)
      {
        if (Log.debugEnabled()) {
          Log.w("No destination: discarding hit: " + ((Hit)localObject1).getHitParams());
        }
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          Log.w("No destination: discarding hit.");
        }
      }
      localHttpHost = new HttpHost(((URL)localObject2).getHost(), ((URL)localObject2).getPort(), ((URL)localObject2).getProtocol());
      localObject2 = ((URL)localObject2).getPath();
      if (TextUtils.isEmpty(((Hit)localObject1).getHitParams())) {}
      for (localObject1 = "";; localObject1 = HitBuilder.postProcessHit((Hit)localObject1, System.currentTimeMillis()))
      {
        localObject2 = buildRequest((String)localObject1, (String)localObject2);
        if (localObject2 != null) {
          break label194;
        }
        i += 1;
        break;
      }
      label194:
      ((HttpEntityEnclosingRequest)localObject2).addHeader("Host", localHttpHost.toHostString());
      logDebugInformation(Log.debugEnabled(), (HttpEntityEnclosingRequest)localObject2);
      if (((String)localObject1).length() > 8192) {
        Log.w("Hit too long (> 8192 bytes)--not sent");
      }
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        localObject1 = localHttpClient.execute(localHttpHost, (HttpRequest)localObject2);
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200)
        {
          Log.w("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
          return i;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        Log.w("ClientProtocolException sending hit; discarding hit...");
      }
      catch (IOException paramList)
      {
        Log.w("Exception sending hit: " + paramList.getClass().getSimpleName());
        Log.w(paramList.getMessage());
      }
    }
    return i;
  }
  
  public boolean okToDispatch()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      Log.vDebug("...no network connectivity");
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/SimpleNetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */