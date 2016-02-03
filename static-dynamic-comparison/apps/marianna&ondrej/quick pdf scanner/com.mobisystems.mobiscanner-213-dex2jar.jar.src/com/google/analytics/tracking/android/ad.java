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

class ad
  implements k
{
  private s iQ;
  private final Context iz;
  private final String lp;
  private final HttpClient lq;
  private URL lr;
  
  ad(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, s.j(paramContext), paramContext);
  }
  
  ad(HttpClient paramHttpClient, s params, Context paramContext)
  {
    this.iz = paramContext.getApplicationContext();
    this.lp = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, ah.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.lq = paramHttpClient;
    this.iQ = params;
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
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
        v.C("Error Writing hit to log...");
      }
    }
    v.C(localStringBuffer.toString());
  }
  
  private HttpEntityEnclosingRequest c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      v.D("Empty hit, discarding.");
      return null;
    }
    String str = paramString2 + "?" + paramString1;
    if (str.length() < 2036) {
      paramString1 = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      paramString1.addHeader("User-Agent", this.lp);
      return paramString1;
      paramString2 = new BasicHttpEntityEnclosingRequest("POST", paramString2);
      try
      {
        paramString2.setEntity(new StringEntity(paramString1));
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        v.D("Encoding error, discarding hit");
      }
    }
    return null;
  }
  
  public int a(List<t> paramList)
  {
    int n = Math.min(paramList.size(), 40);
    int i = 1;
    int k = 0;
    int m = 0;
    Object localObject1;
    Object localObject3;
    int j;
    Object localObject2;
    if (k < n)
    {
      localObject1 = (t)paramList.get(k);
      localObject3 = a((t)localObject1);
      if (localObject3 == null)
      {
        if (v.kf()) {
          v.D("No destination: discarding hit: " + ((t)localObject1).kb());
        }
        for (;;)
        {
          j = m + 1;
          k += 1;
          m = j;
          break;
          v.D("No destination: discarding hit.");
        }
      }
      localObject2 = new HttpHost(((URL)localObject3).getHost(), ((URL)localObject3).getPort(), ((URL)localObject3).getProtocol());
      localObject3 = ((URL)localObject3).getPath();
      if (TextUtils.isEmpty(((t)localObject1).kb())) {}
      for (localObject1 = "";; localObject1 = u.a((t)localObject1, System.currentTimeMillis()))
      {
        localObject3 = c((String)localObject1, (String)localObject3);
        if (localObject3 != null) {
          break label193;
        }
        j = m + 1;
        break;
      }
      label193:
      ((HttpEntityEnclosingRequest)localObject3).addHeader("Host", ((HttpHost)localObject2).toHostString());
      if (v.kf()) {
        a((HttpEntityEnclosingRequest)localObject3);
      }
      if (((String)localObject1).length() > 8192) {
        v.D("Hit too long (> 8192 bytes)--not sent");
      }
      for (;;)
      {
        j = m + 1;
        break;
        if (!this.iQ.jY()) {
          break label264;
        }
        v.B("Dry run enabled. Hit not actually sent.");
      }
      label264:
      if (i == 0) {
        break label437;
      }
    }
    for (;;)
    {
      try
      {
        p.g(this.iz);
        j = 0;
        try
        {
          localObject1 = this.lq.execute((HttpHost)localObject2, (HttpRequest)localObject3);
          int i1 = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
          localObject2 = ((HttpResponse)localObject1).getEntity();
          if (localObject2 != null) {
            ((HttpEntity)localObject2).consumeContent();
          }
          i = j;
          if (i1 == 200) {
            break;
          }
          v.D("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
          i = j;
        }
        catch (ClientProtocolException localClientProtocolException1)
        {
          i = j;
        }
      }
      catch (IOException paramList)
      {
        v.D("Exception sending hit: " + paramList.getClass().getSimpleName());
        v.D(paramList.getMessage());
        return m;
        return m;
      }
      catch (ClientProtocolException localClientProtocolException2)
      {
        continue;
      }
      v.D("ClientProtocolException sending hit; discarding hit...");
      break;
      label437:
      j = i;
    }
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  URL a(t paramt)
  {
    if (this.lr != null) {
      return this.lr;
    }
    for (paramt = paramt.ke();; paramt = "https://ssl.google-analytics.com/collect") {
      try
      {
        if ("http:".equals(paramt))
        {
          paramt = "http://www.google-analytics.com/collect";
          paramt = new URL(paramt);
          return paramt;
        }
      }
      catch (MalformedURLException paramt)
      {
        v.A("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        return null;
      }
    }
  }
  
  public boolean jy()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.iz.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      v.C("...no network connectivity");
      return false;
    }
    return true;
  }
  
  public void s(String paramString)
  {
    try
    {
      this.lr = new URL(paramString);
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.lr = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */