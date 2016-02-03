package com.flurry.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

final class bd
{
  static int a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return Math.round(paramInt / paramContext.density);
  }
  
  static HttpResponse a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Object localObject = new HttpGet(paramString);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 15000);
      localBasicHttpParams.setParameter("http.protocol.handle-redirects", Boolean.valueOf(paramBoolean));
      localObject = cn.a(localBasicHttpParams).execute((HttpUriRequest)localObject);
      return (HttpResponse)localObject;
    }
    catch (UnknownHostException paramString)
    {
      db.c("FlurryAgent", "Unknown host: " + paramString.getMessage());
      return null;
    }
    catch (Exception localException)
    {
      db.a("FlurryAgent", "Failed to hit URL: " + paramString, localException);
    }
    return null;
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  static boolean a(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  static int b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return Math.round(paramContext.density * f);
  }
  
  static boolean b(long paramLong)
  {
    boolean bool = false;
    if (System.currentTimeMillis() <= paramLong) {
      bool = true;
    }
    return bool;
  }
  
  static int l(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  static int m(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  static int n(Context paramContext)
  {
    return a(paramContext, l(paramContext));
  }
  
  static int o(Context paramContext)
  {
    return a(paramContext, m(paramContext));
  }
  
  static String p(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      db.g("FlurryAgent", "Cannot encode '" + paramString + "'");
    }
    return "";
  }
  
  private static String q(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      db.g("FlurryAgent", "Cannot decode '" + paramString + "'");
    }
    return "";
  }
  
  static byte[] r(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      db.d("FlurryAgent", "Unsupported SHA1: " + paramString.getMessage());
    }
    return null;
  }
  
  static String s(String paramString)
  {
    return paramString.replace("'", "\\'").replace("\\n", "").replace("\\r", "").replace("\\t", "");
  }
  
  static String sanitize(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 255);
    return paramString.substring(0, 255);
  }
  
  static Map<String, String> t(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (!arrayOfString[0].equals("event")) {
          localHashMap.put(q(arrayOfString[0]), q(arrayOfString[1]));
        }
        i += 1;
      }
    }
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */