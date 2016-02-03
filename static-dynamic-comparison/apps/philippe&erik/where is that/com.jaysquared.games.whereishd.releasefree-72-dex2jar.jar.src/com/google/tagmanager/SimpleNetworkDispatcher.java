package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher
  implements Dispatcher
{
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
  private final Context ctx;
  private DispatchListener dispatchListener;
  private final HttpClient httpClient;
  private final String userAgent;
  
  @VisibleForTesting
  SimpleNetworkDispatcher(HttpClient paramHttpClient, Context paramContext, DispatchListener paramDispatchListener)
  {
    this.ctx = paramContext.getApplicationContext();
    this.userAgent = createUserAgentString("GoogleTagManager", "3.01", Build.VERSION.RELEASE, getUserAgentLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
    this.httpClient = paramHttpClient;
    this.dispatchListener = paramDispatchListener;
  }
  
  private HttpEntityEnclosingRequest constructGtmRequest(URL paramURL)
  {
    localObject = null;
    try
    {
      paramURL = new BasicHttpEntityEnclosingRequest("GET", paramURL.toURI().toString());
      Log.w("Exception sending hit: " + paramURL.getClass().getSimpleName());
    }
    catch (URISyntaxException paramURL)
    {
      try
      {
        paramURL.addHeader("User-Agent", this.userAgent);
        return paramURL;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          localObject = paramURL;
          paramURL = localURISyntaxException;
        }
      }
      paramURL = paramURL;
    }
    Log.w(paramURL.getMessage());
    return (HttpEntityEnclosingRequest)localObject;
  }
  
  static String getUserAgentLanguage(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while ((paramLocale.getLanguage() == null) || (paramLocale.getLanguage().length() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
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
  
  public void dispatchHits(List<Hit> paramList)
  {
    int n = Math.min(paramList.size(), 40);
    int j = 1;
    int m = 0;
    if (m < n)
    {
      Hit localHit = (Hit)paramList.get(m);
      Object localObject2 = getUrl(localHit);
      int i;
      if (localObject2 == null)
      {
        Log.w("No destination: discarding hit.");
        this.dispatchListener.onHitPermanentDispatchFailure(localHit);
        i = j;
      }
      for (;;)
      {
        m += 1;
        j = i;
        break;
        Object localObject1 = constructGtmRequest((URL)localObject2);
        if (localObject1 == null)
        {
          this.dispatchListener.onHitPermanentDispatchFailure(localHit);
          i = j;
        }
        else
        {
          localObject2 = new HttpHost(((URL)localObject2).getHost(), ((URL)localObject2).getPort(), ((URL)localObject2).getProtocol());
          ((HttpEntityEnclosingRequest)localObject1).addHeader("Host", ((HttpHost)localObject2).toHostString());
          logDebugInformation((HttpEntityEnclosingRequest)localObject1);
          i = j;
          int k;
          if (j != 0) {
            k = j;
          }
          try
          {
            NetworkReceiver.sendRadioPoweredBroadcast(this.ctx);
            i = 0;
            k = i;
            j = i;
            localObject1 = this.httpClient.execute((HttpHost)localObject2, (HttpRequest)localObject1);
            k = i;
            j = i;
            int i1 = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
            k = i;
            j = i;
            localObject2 = ((HttpResponse)localObject1).getEntity();
            if (localObject2 != null)
            {
              k = i;
              j = i;
              ((HttpEntity)localObject2).consumeContent();
            }
            if (i1 != 200)
            {
              k = i;
              j = i;
              Log.w("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
              k = i;
              j = i;
              this.dispatchListener.onHitTransientDispatchFailure(localHit);
            }
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            Log.w("ClientProtocolException sending hit; discarding hit...");
            this.dispatchListener.onHitPermanentDispatchFailure(localHit);
            i = k;
            continue;
            k = i;
            j = i;
            this.dispatchListener.onHitDispatched(localHit);
          }
          catch (IOException localIOException)
          {
            Log.w("Exception sending hit: " + localIOException.getClass().getSimpleName());
            Log.w(localIOException.getMessage());
            this.dispatchListener.onHitTransientDispatchFailure(localHit);
            i = j;
          }
        }
      }
    }
  }
  
  @VisibleForTesting
  URL getUrl(Hit paramHit)
  {
    paramHit = paramHit.getHitUrl();
    try
    {
      paramHit = new URL(paramHit);
      return paramHit;
    }
    catch (MalformedURLException paramHit)
    {
      Log.e("Error trying to parse the GTM url.");
    }
    return null;
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
  
  public static abstract interface DispatchListener
  {
    public abstract void onHitDispatched(Hit paramHit);
    
    public abstract void onHitPermanentDispatchFailure(Hit paramHit);
    
    public abstract void onHitTransientDispatchFailure(Hit paramHit);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/SimpleNetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */