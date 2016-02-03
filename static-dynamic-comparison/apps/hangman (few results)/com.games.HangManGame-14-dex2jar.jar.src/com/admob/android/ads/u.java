package com.admob.android.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

final class u
{
  private static String a = "http://r.admob.com/ad_source.php";
  private static int b;
  private static long c;
  private static String d = null;
  
  static d a(d.a parama, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, g paramg, int paramInt4)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
      AdManager.clientError("Cannot request an ad without Internet permissions!  Open manifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"android.permission.INTERNET\" />");
    }
    o.a(paramContext);
    long l1 = SystemClock.uptimeMillis();
    paramString1 = a(paramContext, paramString1, paramString2, paramInt4);
    paramContext = e.a(a, null, AdManager.getUserId(paramContext), null, 3000, null, paramString1);
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Requesting an ad with POST params:  " + paramString1);
    }
    boolean bool = paramContext.a();
    if (bool) {}
    for (paramContext = new String(paramContext.d());; paramContext = null)
    {
      if (bool)
      {
        if (Log.isLoggable("AdMobSDK", 3)) {
          Log.d("AdMobSDK", "Ad response: ");
        }
        if (!paramContext.equals("")) {
          paramContext = new JSONTokener(paramContext);
        }
      }
      for (;;)
      {
        try
        {
          paramContext = new JSONObject(paramContext);
          if (Log.isLoggable("AdMobSDK", 3)) {
            Log.d("AdMobSDK", paramContext.toString(4));
          }
          parama = d.a(parama, paramContext, paramInt1, paramInt2, paramInt3, paramg);
          if (Log.isLoggable("AdMobSDK", 4))
          {
            long l2 = SystemClock.uptimeMillis();
            if (parama == null) {
              Log.i("AdMobSDK", "No fill.  Server replied that no ads are available (" + (l2 - l1) + "ms)");
            }
          }
          return parama;
        }
        catch (JSONException parama)
        {
          Log.w("AdMobSDK", "Problem decoding ad response.  Cannot display ad.", parama);
        }
        parama = null;
      }
    }
  }
  
  static String a()
  {
    return a;
  }
  
  static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Ad request:");
    }
    AdManager.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    localStringBuilder.append("z").append("=").append(l / 1000L).append(".").append(l % 1000L);
    a(localStringBuilder, "rt", "0");
    Object localObject = AdManager.getPublisherId(paramContext);
    if (localObject == null) {
      throw new IllegalStateException("Publisher ID is not set!  To serve ads you must set your publisher ID assigned from www.admob.com.  Either add it to AndroidManifest.xml under the <application> tag or call AdManager.setPublisherId().");
    }
    a(localStringBuilder, "s", (String)localObject);
    a(localStringBuilder, "l", o.a());
    a(localStringBuilder, "f", "jsonp");
    a(localStringBuilder, "client_sdk", "1");
    a(localStringBuilder, "ex", "1");
    a(localStringBuilder, "v", "20100527-ANDROID-3312276cc1406347");
    a(localStringBuilder, "isu", AdManager.getUserId(paramContext));
    a(localStringBuilder, "so", AdManager.getOrientation(paramContext));
    if (paramInt > 0) {
      a(localStringBuilder, "screen_width", String.valueOf(paramInt));
    }
    a(localStringBuilder, "d[coord]", AdManager.b(paramContext));
    a(localStringBuilder, "d[coord_timestamp]", AdManager.a());
    a(localStringBuilder, "d[pc]", AdManager.getPostalCode());
    a(localStringBuilder, "d[dob]", AdManager.b());
    a(localStringBuilder, "d[gender]", AdManager.c());
    a(localStringBuilder, "k", paramString1);
    a(localStringBuilder, "search", paramString2);
    a(localStringBuilder, "density", String.valueOf(g.c()));
    if (AdManager.isTestDevice(paramContext))
    {
      if (Log.isLoggable("AdMobSDK", 4)) {
        Log.i("AdMobSDK", "Making ad request in test mode");
      }
      a(localStringBuilder, "m", "test");
      a(localStringBuilder, "test_action", AdManager.getTestAction());
    }
    if (d == null)
    {
      paramString1 = new StringBuilder();
      paramString2 = paramContext.getPackageManager();
      localObject = paramString2.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        paramString1.append("m");
      }
      localObject = paramString2.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.admob")), 65536);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (paramString1.length() > 0) {
          paramString1.append(",");
        }
        paramString1.append("a");
      }
      paramString2 = paramString2.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tel://6509313940")), 65536);
      if ((paramString2 == null) || (paramString2.size() == 0))
      {
        if (paramString1.length() > 0) {
          paramString1.append(",");
        }
        paramString1.append("t");
      }
      d = paramString1.toString();
    }
    paramString1 = d;
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      a(localStringBuilder, "ic", paramString1);
    }
    paramInt = b + 1;
    b = paramInt;
    if (paramInt == 1)
    {
      c = System.currentTimeMillis();
      a(localStringBuilder, "pub_data[identifier]", AdManager.getApplicationPackageName(paramContext));
      a(localStringBuilder, "pub_data[version]", String.valueOf(AdManager.getApplicationVersion(paramContext)));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      a(localStringBuilder, "stats[reqs]", String.valueOf(b));
      a(localStringBuilder, "stats[time]", String.valueOf((System.currentTimeMillis() - c) / 1000L));
    }
  }
  
  static void a(String paramString)
  {
    if (paramString == null) {
      paramString = "http://r.admob.com/ad_source.php";
    }
    for (;;)
    {
      if (!"http://r.admob.com/ad_source.php".equals(paramString)) {
        Log.w("AdMobSDK", "NOT USING PRODUCTION AD SERVER!  Using " + paramString);
      }
      a = paramString;
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {}
    try
    {
      paramStringBuilder.append("&").append(URLEncoder.encode(paramString1, "UTF-8")).append("=").append(URLEncoder.encode(paramString2, "UTF-8"));
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "    " + paramString1 + ": " + paramString2);
      }
      return;
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      Log.e("AdMobSDK", "UTF-8 encoding is not supported on this device.  Ad requests are impossible.", paramStringBuilder);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */