package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dq
{
  private static final Object px = new Object();
  private static boolean re = true;
  private static String rf;
  private static boolean rg = false;
  
  public static String a(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    for (;;)
    {
      int i = paramReadable.read(localCharBuffer);
      if (i == -1) {
        break;
      }
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  private static JSONArray a(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  static JSONArray a(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      a(localJSONArray, paramArrayOfObject[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  private static JSONObject a(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  public static void a(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(b(paramContext, paramString));
  }
  
  public static void a(Context paramContext, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new du(paramContext, paramString, (String)paramList.next()).start();
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", b(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public static void a(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ds.a(paramWebView);
    }
  }
  
  private static void a(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(a((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(p((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(a((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(a((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, a((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, p((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, a((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, a(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public static boolean a(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable paramClassLoader) {}
    return false;
  }
  
  private static String b(Context paramContext, String paramString)
  {
    for (;;)
    {
      synchronized (px)
      {
        if (rf != null)
        {
          paramContext = rf;
          return paramContext;
        }
        if (Build.VERSION.SDK_INT >= 17)
        {
          rf = dt.getDefaultUserAgent(paramContext);
          rf = rf + " (Mobile; " + paramString + ")";
          paramContext = rf;
          return paramContext;
        }
      }
      if (!dv.bD())
      {
        dv.rp.post(new Runnable()
        {
          public void run()
          {
            synchronized ()
            {
              dq.s(dq.k(this.pB));
              dq.bB().notifyAll();
              return;
            }
          }
        });
        for (;;)
        {
          paramContext = rf;
          if (paramContext != null) {
            break;
          }
          try
          {
            px.wait();
          }
          catch (InterruptedException paramContext)
          {
            paramContext = rf;
            return paramContext;
          }
        }
      }
      rf = j(paramContext);
    }
  }
  
  public static Map<String, String> b(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Object localObject = new UrlQuerySanitizer();
    ((UrlQuerySanitizer)localObject).setAllowUnregisteredParamaters(true);
    ((UrlQuerySanitizer)localObject).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
    ((UrlQuerySanitizer)localObject).parseUrl(paramUri.toString());
    paramUri = ((UrlQuerySanitizer)localObject).getParameterList().iterator();
    while (paramUri.hasNext())
    {
      localObject = (UrlQuerySanitizer.ParameterValuePair)paramUri.next();
      localHashMap.put(((UrlQuerySanitizer.ParameterValuePair)localObject).mParameter, ((UrlQuerySanitizer.ParameterValuePair)localObject).mValue);
    }
    return localHashMap;
  }
  
  public static void b(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ds.b(paramWebView);
    }
  }
  
  public static int bA()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return 7;
    }
    return 1;
  }
  
  public static boolean by()
  {
    return re;
  }
  
  public static int bz()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return 6;
    }
    return 0;
  }
  
  public static boolean h(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((paramContext == null) || (paramContext.activityInfo == null))
    {
      dw.z("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((paramContext.activityInfo.configChanges & 0x10) == 0) {
      dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    }
    for (boolean bool = false;; bool = true)
    {
      if ((paramContext.activityInfo.configChanges & 0x20) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((paramContext.activityInfo.configChanges & 0x80) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((paramContext.activityInfo.configChanges & 0x100) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((paramContext.activityInfo.configChanges & 0x200) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((paramContext.activityInfo.configChanges & 0x400) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((paramContext.activityInfo.configChanges & 0x800) == 0)
      {
        dw.z(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }
  
  public static void i(Context paramContext)
  {
    if (rg) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new a(null), localIntentFilter);
    rg = true;
  }
  
  private static String j(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public static JSONObject p(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      throw new JSONException("Could not convert map to JSON: " + paramMap.getMessage());
    }
  }
  
  public static String r(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  private static final class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        dq.o(true);
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
        return;
      }
      dq.o(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */