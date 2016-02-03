package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher
  implements Dispatcher
{
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
  private final Context ctx;
  private GoogleAnalytics gaInstance;
  private final HttpClient httpClient;
  private URL mOverrideHostUrl;
  private final String userAgent;
  
  SimpleNetworkDispatcher(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, GoogleAnalytics.getInstance(paramContext), paramContext);
  }
  
  @VisibleForTesting
  SimpleNetworkDispatcher(HttpClient paramHttpClient, GoogleAnalytics paramGoogleAnalytics, Context paramContext)
  {
    this.ctx = paramContext.getApplicationContext();
    this.userAgent = createUserAgentString("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
    this.httpClient = paramHttpClient;
    this.gaInstance = paramGoogleAnalytics;
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
  
  private void logDebugInformation(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(localObject[i].toString()).append("\n");
      i += 1;
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
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
        Log.v("Error Writing hit to log...");
      }
    }
    Log.v(localStringBuffer.toString());
  }
  
  public void close()
  {
    this.httpClient.getConnectionManager().shutdown();
  }
  
  String createUserAgentString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  public int dispatchHits(List<Hit> paramList)
  {
    int m = 0;
    int n = Math.min(paramList.size(), 40);
    int i = 1;
    int k = 0;
    if (k < n)
    {
      Object localObject1 = (Hit)paramList.get(k);
      Object localObject3 = getUrl((Hit)localObject1);
      int j;
      if (localObject3 == null)
      {
        if (Log.isVerbose()) {
          Log.w("No destination: discarding hit: " + ((Hit)localObject1).getHitParams());
        }
        for (;;)
        {
          j = m + 1;
          k += 1;
          m = j;
          break;
          Log.w("No destination: discarding hit.");
        }
      }
      Object localObject2 = new HttpHost(((URL)localObject3).getHost(), ((URL)localObject3).getPort(), ((URL)localObject3).getProtocol());
      localObject3 = ((URL)localObject3).getPath();
      if (TextUtils.isEmpty(((Hit)localObject1).getHitParams())) {}
      for (localObject1 = "";; localObject1 = HitBuilder.postProcessHit((Hit)localObject1, System.currentTimeMillis()))
      {
        localObject3 = buildRequest((String)localObject1, (String)localObject3);
        if (localObject3 != null) {
          break label194;
        }
        j = m + 1;
        break;
      }
      label194:
      ((HttpEntityEnclosingRequest)localObject3).addHeader("Host", ((HttpHost)localObject2).toHostString());
      if (Log.isVerbose()) {
        logDebugInformation((HttpEntityEnclosingRequest)localObject3);
      }
      if (((String)localObject1).length() > 8192) {
        Log.w("Hit too long (> 8192 bytes)--not sent");
      }
      for (;;)
      {
        j = m + 1;
        break;
        if (this.gaInstance.isDryRunEnabled())
        {
          Log.i("Dry run enabled. Hit not actually sent.");
        }
        else
        {
          j = i;
          if (i != 0) {}
          try
          {
            GANetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
            j = 0;
            i = j;
            localObject1 = this.httpClient.execute((HttpHost)localObject2, (HttpRequest)localObject3);
            i = j;
            int i1 = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
            i = j;
            localObject2 = ((HttpResponse)localObject1).getEntity();
            if (localObject2 != null)
            {
              i = j;
              ((HttpEntity)localObject2).consumeContent();
            }
            i = j;
            if (i1 != 200)
            {
              i = j;
              Log.w("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
              i = j;
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
      }
    }
    return m;
  }
  
  @VisibleForTesting
  URL getUrl(Hit paramHit)
  {
    if (this.mOverrideHostUrl != null) {
      return this.mOverrideHostUrl;
    }
    for (paramHit = paramHit.getHitUrlScheme();; paramHit = "https://ssl.google-analytics.com/collect") {
      try
      {
        if ("http:".equals(paramHit))
        {
          paramHit = "http://www.google-analytics.com/collect";
          paramHit = new URL(paramHit);
          return paramHit;
        }
      }
      catch (MalformedURLException paramHit)
      {
        Log.e("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        return null;
      }
    }
  }
  
  public boolean okToDispatch()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      Log.v("...no network connectivity");
      return false;
    }
    return true;
  }
  
  @VisibleForTesting
  public void overrideHostUrl(String paramString)
  {
    try
    {
      this.mOverrideHostUrl = new URL(paramString);
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.mOverrideHostUrl = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/SimpleNetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */