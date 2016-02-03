package com.admob.android.ads;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

final class o
  implements h
{
  private static o a = null;
  private static Context b = null;
  private static Thread c = null;
  private static String d = null;
  private Properties e;
  private Context f;
  
  private o(Context paramContext)
  {
    this.f = paramContext;
    this.e = null;
    d = a();
    if (a != null) {
      a.e = null;
    }
    if ((!b()) && (c == null))
    {
      paramContext = new StringBuilder();
      paramContext.append("http://mm.admob.com/static/android/i18n/20100527");
      paramContext.append("/");
      paramContext.append(d);
      paramContext.append(".properties");
      paramContext = new Thread(e.a(paramContext.toString(), null, AdManager.getUserId(this.f), this, 1));
      c = paramContext;
      paramContext.start();
    }
  }
  
  private static File a(Context paramContext, String paramString)
    throws IOException
  {
    paramContext = new File(paramContext.getCacheDir(), "admob_cache");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    paramContext = new File(paramContext, "20100527");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return new File(paramContext, paramString + ".properties");
  }
  
  public static String a()
  {
    if (d == null)
    {
      String str = Locale.getDefault().getLanguage();
      d = str;
      if (str == null) {
        d = "en";
      }
    }
    return d;
  }
  
  public static void a(Context paramContext)
  {
    if (b == null) {
      b = paramContext.getApplicationContext();
    }
    if (a == null) {
      a = new o(b);
    }
  }
  
  private boolean b()
  {
    if (this.e == null) {}
    try
    {
      Properties localProperties = new Properties();
      File localFile = a(this.f, d);
      if (localFile.exists())
      {
        localProperties.load(new FileInputStream(localFile));
        this.e = localProperties;
      }
      if (this.e != null) {
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.e = null;
      }
    }
    return false;
  }
  
  public final void a(r paramr)
  {
    try
    {
      paramr = paramr.d();
      if (paramr != null)
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(a(this.f, d));
        localFileOutputStream.write(paramr);
        localFileOutputStream.close();
      }
      return;
    }
    catch (Exception paramr)
    {
      while (!Log.isLoggable("AdMobSDK", 3)) {}
      Log.d("AdMobSDK", "Could not store localized strings to cache file.");
    }
  }
  
  public final void a(r paramr, Exception paramException)
  {
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Could not get localized strings from the AdMob servers.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */