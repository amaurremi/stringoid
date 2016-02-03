package com.google.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class f
  implements Runnable
{
  private final c a;
  private final d b;
  private final a c;
  private volatile boolean d;
  private boolean e;
  private String f;
  private Thread g = null;
  
  f(c paramc, d paramd)
  {
    this(paramc, paramd, new a()
    {
      public HttpURLConnection a(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    });
  }
  
  f(c paramc, d paramd, a parama)
  {
    this.a = paramc;
    this.b = paramd;
    this.c = parama;
  }
  
  private void a(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("drt", "");
    if ((this.e) && (!TextUtils.isEmpty(paramContext)))
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
    e(paramHttpURLConnection);
    i(paramHttpURLConnection);
    j(paramHttpURLConnection);
    k(paramHttpURLConnection);
    d(paramHttpURLConnection);
    c(paramHttpURLConnection);
    l(paramHttpURLConnection);
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
        this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
        a();
        return;
      }
      a(paramHttpURLConnection);
      this.f = str;
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
        this.a.a(AdRequest.ErrorCode.NO_FILL);
        a();
        return;
      }
      this.a.a(paramHttpURLConnection, this.f);
      a();
      return;
    }
    if (paramInt == 400)
    {
      b.c("Bad request");
      this.a.a(AdRequest.ErrorCode.INVALID_REQUEST);
      a();
      return;
    }
    b.c("Invalid response code: " + paramInt);
    this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
    a();
  }
  
  /* Error */
  private void b()
    throws MalformedURLException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 198	com/google/ads/internal/f:d	Z
    //   4: ifne +99 -> 103
    //   7: new 200	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: getfield 158	com/google/ads/internal/f:f	Ljava/lang/String;
    //   15: invokespecial 202	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 41	com/google/ads/internal/f:c	Lcom/google/ads/internal/f$a;
    //   23: aload_1
    //   24: invokeinterface 205 2 0
    //   29: astore_1
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 39	com/google/ads/internal/f:b	Lcom/google/ads/internal/d;
    //   35: invokevirtual 210	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   38: getfield 215	com/google/ads/m:f	Lcom/google/ads/util/i$b;
    //   41: invokevirtual 220	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   44: checkcast 222	android/content/Context
    //   47: aload_1
    //   48: invokespecial 224	com/google/ads/internal/f:a	(Landroid/content/Context;Ljava/net/HttpURLConnection;)V
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 39	com/google/ads/internal/f:b	Lcom/google/ads/internal/d;
    //   56: invokevirtual 210	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   59: getfield 215	com/google/ads/m:f	Lcom/google/ads/util/i$b;
    //   62: invokevirtual 220	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   65: checkcast 222	android/content/Context
    //   68: invokestatic 227	com/google/ads/util/AdUtil:a	(Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual 231	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   76: aload_1
    //   77: invokevirtual 234	java/net/HttpURLConnection:connect	()V
    //   80: aload_0
    //   81: aload_1
    //   82: aload_1
    //   83: invokevirtual 238	java/net/HttpURLConnection:getResponseCode	()I
    //   86: invokespecial 240	com/google/ads/internal/f:a	(Ljava/net/HttpURLConnection;I)V
    //   89: aload_1
    //   90: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   93: goto -93 -> 0
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   101: aload_2
    //   102: athrow
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	f
    //   18	80	1	localObject1	Object
    //   96	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	89	96	finally
  }
  
  private void b(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      this.a.e(paramHttpURLConnection);
    }
  }
  
  private void c(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Type");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      this.a.b(paramHttpURLConnection);
    }
  }
  
  private void d(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Mediation");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      this.a.a(Boolean.valueOf(paramHttpURLConnection).booleanValue());
    }
  }
  
  private void e(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {}
    try
    {
      float f1 = Float.parseFloat(paramHttpURLConnection);
      this.b.a((f1 * 1000.0F));
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
        this.b.b(str);
        i += 1;
      }
    }
  }
  
  private void g(HttpURLConnection paramHttpURLConnection)
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
        this.a.a(str);
        i += 1;
      }
    }
  }
  
  private void h(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {}
    do
    {
      try
      {
        float f1 = Float.parseFloat(paramHttpURLConnection);
        if (f1 > 0.0F)
        {
          this.b.a(f1);
          if (!this.b.s()) {
            this.b.f();
          }
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.d("Could not get refresh value: " + paramHttpURLConnection, localNumberFormatException);
        return;
      }
    } while (!this.b.s());
    this.b.e();
  }
  
  private void i(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("X-Afma-Orientation");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      if (!paramHttpURLConnection.equals("portrait")) {
        break label36;
      }
      this.a.a(AdUtil.b());
    }
    label36:
    while (!paramHttpURLConnection.equals("landscape")) {
      return;
    }
    this.a.a(AdUtil.a());
  }
  
  private void j(HttpURLConnection paramHttpURLConnection)
  {
    if (!TextUtils.isEmpty(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {}
    try
    {
      long l = Long.parseLong(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"));
      this.b.b(l);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      b.e("Got bad value of Doritos cookie cache life from header: " + paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
    }
  }
  
  private void k(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (!TextUtils.isEmpty(paramHttpURLConnection)) {
      this.a.c(paramHttpURLConnection);
    }
  }
  
  private void l(HttpURLConnection paramHttpURLConnection)
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
        this.a.a(new AdSize(i, j));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.e("Could not parse size header: " + paramHttpURLConnection);
      }
    }
  }
  
  void a()
  {
    this.d = true;
  }
  
  void a(String paramString)
  {
    try
    {
      if (this.g == null)
      {
        this.f = paramString;
        this.d = false;
        this.g = new Thread(this);
        this.g.start();
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
    this.e = paramBoolean;
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
      this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    catch (IOException localIOException)
    {
      b.d("IOException connecting to ad url.", localIOException);
      this.a.a(AdRequest.ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("An unknown error occurred in AdResponseLoader.", localThrowable);
      this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
    }
  }
  
  public static abstract interface a
  {
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */