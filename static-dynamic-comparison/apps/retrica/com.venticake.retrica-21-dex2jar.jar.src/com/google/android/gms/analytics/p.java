package com.google.android.gms.analytics;

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

class p
  implements ah
{
  private final String a;
  private final HttpClient b;
  private final Context c;
  private GoogleAnalytics d;
  private URL e;
  
  p(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, GoogleAnalytics.getInstance(paramContext), paramContext);
  }
  
  p(HttpClient paramHttpClient, GoogleAnalytics paramGoogleAnalytics, Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, t.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.b = paramHttpClient;
    this.d = paramGoogleAnalytics;
  }
  
  private HttpEntityEnclosingRequest a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      aa.D("Empty hit, discarding.");
      return null;
    }
    String str = paramString2 + "?" + paramString1;
    if (str.length() < 2036) {
      paramString1 = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      paramString1.addHeader("User-Agent", this.a);
      return paramString1;
      paramString2 = new BasicHttpEntityEnclosingRequest("POST", paramString2);
      try
      {
        paramString2.setEntity(new StringEntity(paramString1));
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        aa.D("Encoding error, discarding hit");
      }
    }
    return null;
  }
  
  /* Error */
  private void a(g paramg, URL paramURL, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 149	com/google/android/gms/analytics/g:a	()Ljava/lang/String;
    //   4: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 152	com/google/android/gms/analytics/p:b	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: ifnonnull +231 -> 250
    //   22: aload_0
    //   23: getfield 154	com/google/android/gms/analytics/p:e	Ljava/net/URL;
    //   26: ifnull +172 -> 198
    //   29: aload_0
    //   30: getfield 154	com/google/android/gms/analytics/p:e	Ljava/net/URL;
    //   33: astore_2
    //   34: new 156	org/apache/http/HttpHost
    //   37: dup
    //   38: aload_2
    //   39: invokevirtual 161	java/net/URL:getHost	()Ljava/lang/String;
    //   42: aload_2
    //   43: invokevirtual 164	java/net/URL:getPort	()I
    //   46: aload_2
    //   47: invokevirtual 167	java/net/URL:getProtocol	()Ljava/lang/String;
    //   50: invokespecial 170	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: astore 5
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 149	com/google/android/gms/analytics/g:a	()Ljava/lang/String;
    //   60: aload_2
    //   61: invokevirtual 173	java/net/URL:getPath	()Ljava/lang/String;
    //   64: invokespecial 175	com/google/android/gms/analytics/p:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpEntityEnclosingRequest;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull -52 -> 17
    //   72: aload_1
    //   73: ldc -79
    //   75: aload 5
    //   77: invokevirtual 180	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   80: invokeinterface 126 3 0
    //   85: invokestatic 183	com/google/android/gms/analytics/aa:dp	()Z
    //   88: ifeq +8 -> 96
    //   91: aload_0
    //   92: aload_1
    //   93: invokespecial 186	com/google/android/gms/analytics/p:a	(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    //   96: iload_3
    //   97: ifeq +10 -> 107
    //   100: aload_0
    //   101: getfield 39	com/google/android/gms/analytics/p:c	Landroid/content/Context;
    //   104: invokestatic 191	com/google/android/gms/analytics/aj:b	(Landroid/content/Context;)V
    //   107: aload_0
    //   108: getfield 74	com/google/android/gms/analytics/p:b	Lorg/apache/http/client/HttpClient;
    //   111: aload 5
    //   113: aload_1
    //   114: invokeinterface 197 3 0
    //   119: astore_1
    //   120: aload_1
    //   121: invokeinterface 203 1 0
    //   126: invokeinterface 208 1 0
    //   131: istore 4
    //   133: aload_1
    //   134: invokeinterface 212 1 0
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: invokeinterface 217 1 0
    //   150: iload 4
    //   152: sipush 200
    //   155: if_icmpeq -138 -> 17
    //   158: new 95	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   165: ldc -37
    //   167: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokeinterface 203 1 0
    //   176: invokeinterface 208 1 0
    //   181: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 93	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   190: return
    //   191: astore_1
    //   192: ldc -32
    //   194: invokestatic 93	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   197: return
    //   198: new 158	java/net/URL
    //   201: dup
    //   202: ldc -30
    //   204: invokespecial 227	java/net/URL:<init>	(Ljava/lang/String;)V
    //   207: astore_2
    //   208: goto -174 -> 34
    //   211: astore_1
    //   212: return
    //   213: astore_1
    //   214: new 95	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   221: ldc -27
    //   223: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   230: invokevirtual 238	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   233: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 93	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: invokevirtual 241	java/io/IOException:getMessage	()Ljava/lang/String;
    //   246: invokestatic 93	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   249: return
    //   250: goto -216 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	p
    //   0	253	1	paramg	g
    //   0	253	2	paramURL	URL
    //   0	253	3	paramBoolean	boolean
    //   131	25	4	i	int
    //   53	59	5	localHttpHost	HttpHost
    // Exception table:
    //   from	to	target	type
    //   55	68	191	org/apache/http/client/ClientProtocolException
    //   72	96	191	org/apache/http/client/ClientProtocolException
    //   100	107	191	org/apache/http/client/ClientProtocolException
    //   107	140	191	org/apache/http/client/ClientProtocolException
    //   144	150	191	org/apache/http/client/ClientProtocolException
    //   158	190	191	org/apache/http/client/ClientProtocolException
    //   22	34	211	java/net/MalformedURLException
    //   198	208	211	java/net/MalformedURLException
    //   55	68	213	java/io/IOException
    //   72	96	213	java/io/IOException
    //   100	107	213	java/io/IOException
    //   107	140	213	java/io/IOException
    //   144	150	213	java/io/IOException
    //   158	190	213	java/io/IOException
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
        aa.C("Error Writing hit to log...");
      }
    }
    aa.C(localStringBuffer.toString());
  }
  
  public int a(List<av> paramList, g paramg, boolean paramBoolean)
  {
    int m = 0;
    int n = Math.min(paramList.size(), 40);
    paramg.a("_hr", paramList.size());
    int i = 0;
    Object localObject1 = null;
    boolean bool1 = true;
    int k = 0;
    if (k < n)
    {
      av localav = (av)paramList.get(k);
      URL localURL = a(localav);
      int j;
      if (localURL == null)
      {
        if (aa.dp()) {
          aa.D("No destination: discarding hit: " + localav.a());
        }
        for (;;)
        {
          i += 1;
          j = m + 1;
          k += 1;
          m = j;
          break;
          aa.D("No destination: discarding hit.");
        }
      }
      Object localObject2 = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
      Object localObject3 = localURL.getPath();
      if (TextUtils.isEmpty(localav.a())) {}
      for (localObject1 = "";; localObject1 = aw.a(localav, System.currentTimeMillis()))
      {
        localObject3 = a((String)localObject1, (String)localObject3);
        if (localObject3 != null) {
          break label235;
        }
        i += 1;
        j = m + 1;
        localObject1 = localURL;
        break;
      }
      label235:
      ((HttpEntityEnclosingRequest)localObject3).addHeader("Host", ((HttpHost)localObject2).toHostString());
      if (aa.dp()) {
        a((HttpEntityEnclosingRequest)localObject3);
      }
      if (((String)localObject1).length() > 8192)
      {
        aa.D("Hit too long (> 8192 bytes)--not sent");
        j = i + 1;
      }
      for (;;)
      {
        paramg.a("_td", ((String)localObject1).getBytes().length);
        m += 1;
        localObject1 = localURL;
        i = j;
        j = m;
        break;
        if (this.d.isDryRunEnabled())
        {
          aa.B("Dry run enabled. Hit not actually sent.");
          j = i;
        }
        else
        {
          boolean bool2 = bool1;
          boolean bool3;
          if (bool1) {
            bool3 = bool1;
          }
          try
          {
            aj.b(this.c);
            bool2 = false;
            bool3 = bool2;
            bool1 = bool2;
            localObject2 = this.b.execute((HttpHost)localObject2, (HttpRequest)localObject3);
            bool3 = bool2;
            bool1 = bool2;
            int i1 = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
            bool3 = bool2;
            bool1 = bool2;
            localObject3 = ((HttpResponse)localObject2).getEntity();
            if (localObject3 != null)
            {
              bool3 = bool2;
              bool1 = bool2;
              ((HttpEntity)localObject3).consumeContent();
            }
            bool1 = bool2;
            j = i;
            if (i1 != 200)
            {
              bool3 = bool2;
              bool1 = bool2;
              aa.D("Bad response: " + ((HttpResponse)localObject2).getStatusLine().getStatusCode());
              bool1 = bool2;
              j = i;
            }
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            aa.D("ClientProtocolException sending hit; discarding hit...");
            paramg.a("_hd", i);
            bool1 = bool3;
            j = i;
          }
          catch (IOException paramList)
          {
            aa.D("Exception sending hit: " + paramList.getClass().getSimpleName());
            aa.D(paramList.getMessage());
            paramg.a("_de", 1);
            paramg.a("_hd", i);
            paramg.a("_hs", m);
            a(paramg, localURL, bool1);
            return m;
          }
        }
      }
    }
    paramg.a("_hd", i);
    paramg.a("_hs", m);
    if (paramBoolean) {
      a(paramg, (URL)localObject1, bool1);
    }
    return m;
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  URL a(av paramav)
  {
    if (this.e != null) {
      return this.e;
    }
    for (paramav = paramav.d();; paramav = "https://ssl.google-analytics.com/collect") {
      try
      {
        if ("http:".equals(paramav))
        {
          paramav = "http://www.google-analytics.com/collect";
          paramav = new URL(paramav);
          return paramav;
        }
      }
      catch (MalformedURLException paramav)
      {
        aa.A("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        return null;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.e = new URL(paramString);
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.e = null;
    }
  }
  
  public boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      aa.C("...no network connectivity");
      return false;
    }
    return true;
  }
  
  boolean b()
  {
    return Math.random() * 100.0D <= 1.0D;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */