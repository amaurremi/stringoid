package com.admob.android.ads;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class r
  implements Runnable
{
  private static Executor m = null;
  private static String n;
  protected String a;
  protected int b;
  protected Exception c = null;
  protected Map<String, String> d;
  protected int e;
  protected int f;
  protected String g;
  protected h h;
  protected URL i;
  protected byte[] j;
  protected boolean k;
  protected String l;
  private String o;
  
  protected r(String paramString1, String paramString2, h paramh, int paramInt, Map<String, String> paramMap, String paramString3)
  {
    this.o = paramString1;
    this.g = paramString2;
    this.h = paramh;
    this.b = paramInt;
    this.d = paramMap;
    this.k = true;
    this.e = 0;
    this.f = 3;
    if (paramString3 != null)
    {
      this.l = paramString3;
      this.a = "application/x-www-form-urlencoded";
      return;
    }
    this.l = null;
    this.a = null;
  }
  
  public static String c()
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (n == null)
    {
      localStringBuffer = new StringBuffer();
      localObject = Build.VERSION.RELEASE;
      if (((String)localObject).length() <= 0) {
        break label194;
      }
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("; ");
      localObject = Locale.getDefault();
      String str = ((Locale)localObject).getLanguage();
      if (str == null) {
        break label204;
      }
      localStringBuffer.append(str.toLowerCase());
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
    }
    for (;;)
    {
      localObject = Build.MODEL;
      if (((String)localObject).length() > 0)
      {
        localStringBuffer.append("; ");
        localStringBuffer.append((String)localObject);
      }
      localObject = Build.ID;
      if (((String)localObject).length() > 0)
      {
        localStringBuffer.append(" Build/");
        localStringBuffer.append((String)localObject);
      }
      n = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2 (AdMob-ANDROID-%s)", new Object[] { localStringBuffer, "20100527" });
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "Phone's user-agent is:  " + n);
      }
      return n;
      label194:
      localStringBuffer.append("1.0");
      break;
      label204:
      localStringBuffer.append("en");
    }
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(h paramh)
  {
    this.h = paramh;
  }
  
  protected final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public abstract boolean a();
  
  public abstract void b();
  
  public final byte[] d()
  {
    return this.j;
  }
  
  public final String e()
  {
    return this.o;
  }
  
  public final URL f()
  {
    return this.i;
  }
  
  public final void g()
  {
    if (m == null) {
      m = Executors.newCachedThreadPool();
    }
    m.execute(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */