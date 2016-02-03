package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdUtil
{
  public static final int a = a(Build.VERSION.SDK);
  private static Boolean b = null;
  private static String c = null;
  private static String d;
  private static String e = null;
  private static AudioManager f;
  private static boolean g = true;
  private static boolean h = false;
  private static String i = null;
  
  public static int a()
  {
    if (a >= 9) {
      return 6;
    }
    return 0;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int a(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    if (a >= 4) {
      return e.a(paramContext, paramDisplayMetrics);
    }
    return paramDisplayMetrics.heightPixels;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      return j;
    }
    catch (NumberFormatException paramString)
    {
      b.e("The Android SDK version couldn't be parsed to an int: " + Build.VERSION.SDK);
      b.e("Defaulting to Android SDK version 3.");
    }
    return 3;
  }
  
  public static DisplayMetrics a(Activity paramActivity)
  {
    if (paramActivity.getWindowManager() == null) {
      return null;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static String a(Context paramContext)
  {
    if (c == null)
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if ((paramContext == null) || (c())) {}
      for (paramContext = b("emulator"); paramContext == null; paramContext = b(paramContext)) {
        return null;
      }
      c = paramContext.toUpperCase(Locale.US);
    }
    return c;
  }
  
  public static String a(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    for (;;)
    {
      int j = paramReadable.read(localCharBuffer);
      if (j == -1) {
        break;
      }
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, j);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = b(paramMap).toString();
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      b.d("JsonException in serialization: ", paramMap);
    }
    return null;
  }
  
  public static HashMap<String, Object> a(Location paramLocation)
  {
    if (paramLocation == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("time", Long.valueOf(paramLocation.getTime() * 1000L));
    localHashMap.put("lat", Long.valueOf((paramLocation.getLatitude() * 1.0E7D)));
    localHashMap.put("long", Long.valueOf((paramLocation.getLongitude() * 1.0E7D)));
    localHashMap.put("radius", Long.valueOf((paramLocation.getAccuracy() * 1000.0F)));
    return localHashMap;
  }
  
  public static JSONArray a(Set<Object> paramSet)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return localJSONArray;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if (((localObject instanceof String)) || ((localObject instanceof Integer)) || ((localObject instanceof Double)) || ((localObject instanceof Long)) || ((localObject instanceof Float))) {
        localJSONArray.put(localObject);
      } else if ((localObject instanceof Map)) {
        try
        {
          localJSONArray.put(b((Map)localObject));
        }
        catch (ClassCastException localClassCastException1)
        {
          b.d("Unknown map type in json serialization: ", localClassCastException1);
        }
      } else if ((localClassCastException1 instanceof Set)) {
        try
        {
          localJSONArray.put(a((Set)localClassCastException1));
        }
        catch (ClassCastException localClassCastException2)
        {
          b.d("Unknown map type in json serialization: ", localClassCastException2);
        }
      } else {
        b.e("Unknown value in json serialization: " + localClassCastException2);
      }
    }
    return localJSONArray;
  }
  
  public static void a(WebView paramWebView)
  {
    String str = i(paramWebView.getContext().getApplicationContext());
    paramWebView.getSettings().setUserAgentString(str);
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, Context paramContext)
  {
    paramHttpURLConnection.setRequestProperty("User-Agent", i(paramContext));
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == 0)
    {
      b.b("The android:configChanges value of the com.google.ads.AdActivity must include " + paramString + ".");
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(Intent paramIntent, Context paramContext)
  {
    return paramContext.getPackageManager().resolveActivity(paramIntent, 65536) != null;
  }
  
  public static boolean a(Uri paramUri)
  {
    if (paramUri == null) {}
    do
    {
      return false;
      paramUri = paramUri.getScheme();
    } while ((!"http".equalsIgnoreCase(paramUri)) && (!"https".equalsIgnoreCase(paramUri)));
    return true;
  }
  
  static boolean a(d paramd)
  {
    d locald = paramd;
    if (paramd == null) {
      locald = d.d;
    }
    return (locald.equals(d.e)) || (locald.equals(d.f));
  }
  
  public static int b()
  {
    if (a >= 9) {
      return 7;
    }
    return 1;
  }
  
  public static int b(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    if (a >= 4) {
      return e.b(paramContext, paramDisplayMetrics);
    }
    return paramDisplayMetrics.widthPixels;
  }
  
  public static String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString.getBytes(), 0, paramString.length());
      localObject1 = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject1).digest()) });
      return (String)localObject1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return paramString.substring(0, 32);
  }
  
  public static HashMap<String, String> b(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramUri = paramUri.getEncodedQuery();
    if (paramUri != null)
    {
      paramUri = paramUri.split("&");
      int k = paramUri.length;
      int j = 0;
      if (j < k)
      {
        String str = paramUri[j];
        int m = str.indexOf("=");
        if (m < 0) {
          localHashMap.put(Uri.decode(str), null);
        }
        for (;;)
        {
          j += 1;
          break;
          localHashMap.put(Uri.decode(str.substring(0, m)), Uri.decode(str.substring(m + 1, str.length())));
        }
      }
    }
    return localHashMap;
  }
  
  public static JSONObject b(Map<String, Object> paramMap)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return localJSONObject;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if (((localObject instanceof String)) || ((localObject instanceof Integer)) || ((localObject instanceof Double)) || ((localObject instanceof Long)) || ((localObject instanceof Float))) {
        localJSONObject.put(str, localObject);
      } else if ((localObject instanceof Map)) {
        try
        {
          localJSONObject.put(str, b((Map)localObject));
        }
        catch (ClassCastException localClassCastException1)
        {
          b.d("Unknown map type in json serialization: ", localClassCastException1);
        }
      } else if ((localObject instanceof Set)) {
        try
        {
          localJSONObject.put(localClassCastException1, a((Set)localObject));
        }
        catch (ClassCastException localClassCastException2)
        {
          b.d("Unknown map type in json serialization: ", localClassCastException2);
        }
      } else {
        b.e("Unknown value in json serialization: " + localObject);
      }
    }
    return localJSONObject;
  }
  
  public static boolean b(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    if (localPackageManager.checkPermission("android.permission.INTERNET", paramContext) == -1)
    {
      b.b("INTERNET permissions must be enabled in AndroidManifest.xml.");
      return false;
    }
    if (localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext) == -1)
    {
      b.b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
      return false;
    }
    return true;
  }
  
  public static boolean c()
  {
    return a(null);
  }
  
  public static boolean c(Context paramContext)
  {
    if (b != null) {
      return b.booleanValue();
    }
    paramContext = paramContext.getPackageManager().resolveActivity(new Intent(paramContext, AdActivity.class), 65536);
    b = Boolean.valueOf(true);
    if ((paramContext == null) || (paramContext.activityInfo == null))
    {
      b.b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
      b = Boolean.valueOf(false);
    }
    for (;;)
    {
      return b.booleanValue();
      if (!a(paramContext.activityInfo.configChanges, 16, "keyboard")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 32, "keyboardHidden")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 128, "orientation")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 256, "screenLayout")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 512, "uiMode")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 1024, "screenSize")) {
        b = Boolean.valueOf(false);
      }
      if (!a(paramContext.activityInfo.configChanges, 2048, "smallestScreenSize")) {
        b = Boolean.valueOf(false);
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return null;
    }
    switch (paramContext.getType())
    {
    default: 
      return "unknown";
    case 0: 
      return "ed";
    }
    return "wi";
  }
  
  public static boolean d()
  {
    return g;
  }
  
  public static String e(Context paramContext)
  {
    if (d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramContext = paramContext.getPackageManager();
      List localList = paramContext.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
      if ((localList == null) || (localList.isEmpty())) {
        localStringBuilder.append("m");
      }
      paramContext = paramContext.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("a");
      }
      d = localStringBuilder.toString();
    }
    return d;
  }
  
  public static String f(Context paramContext)
  {
    Object localObject1 = null;
    if (e != null) {
      paramContext = e;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        Object localObject2 = paramContext.getPackageManager();
        Object localObject3 = ((PackageManager)localObject2).resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
        paramContext = (Context)localObject1;
        if (localObject3 != null)
        {
          localObject3 = ((ResolveInfo)localObject3).activityInfo;
          paramContext = (Context)localObject1;
          if (localObject3 != null)
          {
            localObject2 = ((PackageManager)localObject2).getPackageInfo(((ActivityInfo)localObject3).packageName, 0);
            paramContext = (Context)localObject1;
            if (localObject2 != null)
            {
              e = ((PackageInfo)localObject2).versionCode + "." + ((ActivityInfo)localObject3).packageName;
              paramContext = e;
              return paramContext;
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return null;
  }
  
  public static a g(Context paramContext)
  {
    if (f == null) {
      f = (AudioManager)paramContext.getSystemService("audio");
    }
    paramContext = a.f;
    int j = f.getMode();
    if (c()) {
      return a.e;
    }
    if ((f.isMusicActive()) || (f.isSpeakerphoneOn()) || (j == 2) || (j == 1)) {
      return a.d;
    }
    j = f.getRingerMode();
    if ((j == 0) || (j == 1)) {
      return a.d;
    }
    return a.b;
  }
  
  public static void h(Context paramContext)
  {
    if (h) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new UserActivityReceiver(), localIntentFilter);
    h = true;
  }
  
  public static String i(Context paramContext)
  {
    if (i == null)
    {
      Object localObject1 = new WebView(paramContext).getSettings().getUserAgentString();
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        paramContext = (Context)localObject1;
        if (!((String)localObject1).equals("Java0")) {}
      }
      else
      {
        String str1 = System.getProperty("os.name", "Linux");
        String str2 = "Android " + Build.VERSION.RELEASE;
        Object localObject2 = Locale.getDefault();
        localObject1 = ((Locale)localObject2).getLanguage().toLowerCase(Locale.US);
        paramContext = (Context)localObject1;
        if (((String)localObject1).length() == 0) {
          paramContext = "en";
        }
        localObject2 = ((Locale)localObject2).getCountry().toLowerCase(Locale.US);
        localObject1 = paramContext;
        if (((String)localObject2).length() > 0) {
          localObject1 = paramContext + "-" + (String)localObject2;
        }
        paramContext = Build.MODEL + " Build/" + Build.ID;
        paramContext = "Mozilla/5.0 (" + str1 + "; U; " + str2 + "; " + (String)localObject1 + "; " + paramContext + ") AppleWebKit/0.0 (KHTML, like " + "Gecko) Version/0.0 Mobile Safari/0.0";
      }
      i = paramContext + " (Mobile; " + "afma-sdk-a-v" + "6.4.1" + ")";
    }
    return i;
  }
  
  public static class UserActivityReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.USER_PRESENT")) {
        AdUtil.a(true);
      }
      while (!paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
        return;
      }
      AdUtil.a(false);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/util/AdUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */