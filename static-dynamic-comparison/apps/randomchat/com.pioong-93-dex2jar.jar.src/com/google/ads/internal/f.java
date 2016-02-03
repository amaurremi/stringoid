package com.google.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.l;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class f
  implements Runnable
{
  private final l a;
  private final a b;
  private volatile boolean c;
  private boolean d;
  private String e;
  private Thread f = null;
  
  f(l paraml)
  {
    this(paraml, new a()
    {
      public HttpURLConnection a(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    });
  }
  
  f(l paraml, a parama)
  {
    this.a = paraml;
    this.b = parama;
  }
  
  private void a(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("drt", "");
    if ((this.d) && (!TextUtils.isEmpty(paramContext)))
    {
      if (AdUtil.a == 8) {
        paramHttpURLConnection.addRequestProperty("X-Afma-drt-Cookie", paramContext);
      }
    }
    else {
      return;
    }
    paramHttpURLConnection.addRequestProperty("Cookie", paramContext);
  }
  
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    b(paramHttpURLConnection);
    f(paramHttpURLConnection);
    g(paramHttpURLConnection);
    h(paramHttpURLConnection);
    i(paramHttpURLConnection);
    e(paramHttpURLConnection);
    j(paramHttpURLConnection);
    k(paramHttpURLConnection);
    l(paramHttpURLConnection);
    d(paramHttpURLConnection);
    c(paramHttpURLConnection);
    m(paramHttpURLConnection);
    n(paramHttpURLConnection);
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, int paramInt)
    throws IOException
  {
    if ((300 <= paramInt) && (paramInt < 400))
    {
      String str = paramHttpURLConnection.getHeaderField("Location");
      if (str == null)
      {
        b.c("Could not get redirect location from a " + paramInt + " redirect.");
        ((c)this.a.b.a()).a(AdRequest.ErrorCode.INTERNAL_ERROR);
        a();
        return;
      }
      a(paramHttpURLConnection);
      this.e = str;
      return;
    }
    if (paramInt == 200)
    {
      a(paramHttpURLConnection);
      paramHttpURLConnection = AdUtil.a(new InputStreamReader(paramHttpURLConnection.getInputStream())).trim();
      b.a("Response content is: " + paramHttpURLConnection);
      if (TextUtils.isEmpty(paramHttpURLConnection))
      {
        b.a("Response message is null or zero length: " + paramHttpURLConnection);
        ((c)this.a.b.a()).a(AdRequest.ErrorCode.NO_FILL);
        a();
        return;
      }
      ((c)this.a.b.a()).a(paramHttpURLConnection, this.e);
      a();
      return;
    }
    if (paramInt == 400)
    {
      b.c("Bad request");
      ((c)this.a.b.a()).a(AdRequest.ErrorCode.INVALID_REQUEST);
      a();
      return;
    }
    b.c("Invalid response code: " + paramInt);
    ((c)this.a.b.a()).a(AdRequest.ErrorCode.INTERNAL_ERROR);
    a();
  }
  
  /* Error */
  private void b()
    throws MalformedURLException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 211	com/google/ads/internal/f:c	Z
    //   4: ifne +111 -> 115
    //   7: new 213	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: getfield 171	com/google/ads/internal/f:e	Ljava/lang/String;
    //   15: invokespecial 215	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 37	com/google/ads/internal/f:b	Lcom/google/ads/internal/f$a;
    //   23: aload_1
    //   24: invokeinterface 218 2 0
    //   29: astore_1
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 35	com/google/ads/internal/f:a	Lcom/google/ads/l;
    //   35: getfield 221	com/google/ads/l:a	Lcom/google/ads/util/i$b;
    //   38: invokevirtual 224	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   41: checkcast 226	com/google/ads/n
    //   44: getfield 228	com/google/ads/n:f	Lcom/google/ads/util/i$b;
    //   47: invokevirtual 224	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   50: checkcast 230	android/content/Context
    //   53: aload_1
    //   54: invokespecial 232	com/google/ads/internal/f:a	(Landroid/content/Context;Ljava/net/HttpURLConnection;)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 35	com/google/ads/internal/f:a	Lcom/google/ads/l;
    //   62: getfield 221	com/google/ads/l:a	Lcom/google/ads/util/i$b;
    //   65: invokevirtual 224	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   68: checkcast 226	com/google/ads/n
    //   71: getfield 228	com/google/ads/n:f	Lcom/google/ads/util/i$b;
    //   74: invokevirtual 224	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   77: checkcast 230	android/content/Context
    //   80: invokestatic 235	com/google/ads/util/AdUtil:a	(Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    //   83: aload_1
    //   84: iconst_0
    //   85: invokevirtual 239	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   88: aload_1
    //   89: invokevirtual 242	java/net/HttpURLConnection:connect	()V
    //   92: aload_0
    //   93: aload_1
    //   94: aload_1
    //   95: invokevirtual 246	java/net/HttpURLConnection:getResponseCode	()I
    //   98: invokespecial 248	com/google/ads/internal/f:a	(Ljava/net/HttpURLConnection;I)V
    //   101: aload_1
    //   102: invokevirtual 251	java/net/HttpURLConnection:disconnect	()V
    //   105: goto -105 -> 0
    //   108: astore_2
    //   109: aload_1
    //   110: invokevirtual 251	java/net/HttpURLConnection:disconnect	()V
    //   113: aload_2
    //   114: athrow
    //   115: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	f
    //   18	92	1	localObject1	Object
    //   108	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	101	108	finally
  }
  
  private void b(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      ((c)this.a.b.a()).f(paramHttpURLConnection);
    }
  }
  
  private void c(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Type");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      ((c)this.a.b.a()).b(paramHttpURLConnection);
    }
  }
  
  private void d(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Mediation");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      ((c)this.a.b.a()).b(Boolean.valueOf(paramHttpURLConnection).booleanValue());
    }
  }
  
  private void e(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {}
    try
    {
      float f1 = Float.parseFloat(paramHttpURLConnection);
      ((d)((n)this.a.a.a()).b.a()).a((f1 * 1000.0F));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      b.d("Could not get timeout value: " + paramHttpURLConnection, localNumberFormatException);
    }
  }
  
  private void f(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      paramHttpURLConnection = paramHttpURLConnection.trim().split("\\s+");
      int j = paramHttpURLConnection.length;
      int i = 0;
      while (i < j)
      {
        String str = paramHttpURLConnection[i];
        ((d)((n)this.a.a.a()).b.a()).b(str);
        i += 1;
      }
    }
  }
  
  private void g(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Manual-Tracking-Urls");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      paramHttpURLConnection = paramHttpURLConnection.trim().split("\\s+");
      int j = paramHttpURLConnection.length;
      int i = 0;
      while (i < j)
      {
        String str = paramHttpURLConnection[i];
        ((d)((n)this.a.a.a()).b.a()).c(str);
        i += 1;
      }
    }
  }
  
  private void h(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      paramHttpURLConnection = paramHttpURLConnection.trim().split("\\s+");
      int j = paramHttpURLConnection.length;
      int i = 0;
      while (i < j)
      {
        String str = paramHttpURLConnection[i];
        ((c)this.a.b.a()).a(str);
        i += 1;
      }
    }
  }
  
  private void i(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {}
    do
    {
      try
      {
        float f1 = Float.parseFloat(paramHttpURLConnection);
        paramHttpURLConnection = (d)((n)this.a.a.a()).b.a();
        if (f1 > 0.0F)
        {
          paramHttpURLConnection.a(f1);
          if (!paramHttpURLConnection.t()) {
            paramHttpURLConnection.g();
          }
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.d("Could not get refresh value: " + paramHttpURLConnection, localNumberFormatException);
        return;
      }
    } while (!paramHttpURLConnection.t());
    paramHttpURLConnection.f();
  }
  
  private void j(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Orientation");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      if (!paramHttpURLConnection.equals("portrait")) {
        break label45;
      }
      ((c)this.a.b.a()).a(AdUtil.b());
    }
    label45:
    while (!paramHttpURLConnection.equals("landscape")) {
      return;
    }
    ((c)this.a.b.a()).a(AdUtil.a());
  }
  
  private void k(HttpURLConnection paramHttpURLConnection)
  {
    if (!TextUtils.isEmpty(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {}
    try
    {
      long l = Long.parseLong(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"));
      ((d)((n)this.a.a.a()).b.a()).b(l);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      b.e("Got bad value of Doritos cookie cache life from header: " + paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
    }
  }
  
  private void l(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      ((c)this.a.b.a()).c(paramHttpURLConnection);
    }
  }
  
  private void m(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Ad-Size");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      try
      {
        String[] arrayOfString = paramHttpURLConnection.split("x", 2);
        if (arrayOfString.length != 2)
        {
          b.e("Could not parse size header: " + paramHttpURLConnection);
          return;
        }
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        ((c)this.a.b.a()).a(new AdSize(i, j));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.e("Could not parse size header: " + paramHttpURLConnection);
      }
    }
  }
  
  private void n(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Disable-Activation-And-Scroll");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      ((c)this.a.b.a()).a(paramHttpURLConnection.equals("1"));
    }
  }
  
  void a()
  {
    this.c = true;
  }
  
  void a(String paramString)
  {
    try
    {
      if (this.f == null)
      {
        this.e = paramString;
        this.c = false;
        this.f = new Thread(this);
        this.f.start();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void run()
  {
    try
    {
      b();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      b.b("Received malformed ad url from javascript.", localMalformedURLException);
      ((c)this.a.b.a()).a(AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    catch (IOException localIOException)
    {
      b.b("IOException connecting to ad url.", localIOException);
      ((c)this.a.b.a()).a(AdRequest.ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("An unknown error occurred in AdResponseLoader.", localThrowable);
      ((c)this.a.b.a()).a(AdRequest.ErrorCode.INTERNAL_ERROR);
    }
  }
  
  public static abstract interface a
  {
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */