package com.inmobi.commons.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.uid.UIDUtil;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalSDKUtil
{
  public static final String DEBUG_TAG = "IMCOMMONS_3.7.1";
  public static final String INMOBI_SDK_RELEASE_VERSION = "3.7.1";
  public static final String PRODUCT_COMMONS = "commons";
  static CommonsConfig a = new CommonsConfig();
  static Context b = null;
  static CacheController.Validator c = new b();
  private static String d;
  private static Map<String, String> e = new HashMap();
  
  static String a(String paramString)
  {
    
    try
    {
      paramString = new JSONObject(paramString);
      a.setFromJSON(paramString);
      ThinICE.a(a.getTic());
      a();
      return null;
    }
    catch (Exception paramString)
    {
      try
      {
        paramString = a.toJSON().toString();
        return paramString;
      }
      catch (JSONException paramString) {}
      paramString = paramString;
      Log.debug("IMCOMMONS_3.7.1", "Unable to parse JSON for commons. Reverting to default");
      return null;
    }
  }
  
  private static void a()
  {
    e = UIDUtil.getMap(getContext(), null);
  }
  
  public static boolean checkNetworkAvailibility(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext.getActiveNetworkInfo() == null) {
        return false;
      }
      boolean bool = paramContext.getActiveNetworkInfo().isConnected();
      return bool;
    }
    catch (Exception paramContext)
    {
      Log.internal("IMCOMMONS_3.7.1", "Cannot check network state", paramContext);
    }
    return false;
  }
  
  public static boolean getBooleanFromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramBoolean);
        return paramBoolean;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramBoolean;
  }
  
  public static CommonsConfig getConfig()
  {
    return a;
  }
  
  public static String getConnectivityType(Context paramContext)
  {
    int j;
    label79:
    label83:
    do
    {
      try
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
          break label79;
        }
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          break label79;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        int i = paramContext.getType();
        j = paramContext.getSubtype();
        if (i == 1) {
          return "wifi";
        }
        if (i != 0) {
          break label79;
        }
        paramContext = "carrier";
        if (j != 1) {
          break label83;
        }
        return "gprs";
      }
      catch (Exception paramContext)
      {
        Log.internal("IMCOMMONS_3.7.1", "Error getting the network info", paramContext);
        return null;
      }
      if (j == 0)
      {
        return "carrier";
        paramContext = null;
      }
      return paramContext;
      if (j == 2) {
        return "edge";
      }
    } while (j != 3);
    return "umts";
  }
  
  public static Context getContext()
  {
    return b;
  }
  
  public static int getDisplayRotation(Display paramDisplay)
  {
    Object localObject = null;
    try
    {
      Method localMethod1 = Display.class.getMethod("getRotation", (Class[])null);
      localObject = localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          int i = ((Integer)((Method)localObject).invoke(paramDisplay, (Object[])null)).intValue();
          return i;
          localNoSuchMethodException1 = localNoSuchMethodException1;
        }
        catch (Exception paramDisplay)
        {
          try
          {
            Method localMethod2 = Display.class.getMethod("getOrientation", (Class[])null);
            localObject = localMethod2;
          }
          catch (NoSuchMethodException localNoSuchMethodException2) {}
          paramDisplay = paramDisplay;
          return 64537;
        }
      }
    }
    if (localObject != null) {}
    return 64537;
  }
  
  public static String getFinalRedirectedUrl(String paramString)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("GET");
      if (localHttpURLConnection.getResponseCode() == 200) {
        paramString = localHttpURLConnection.getURL().toString();
      }
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        localHttpURLConnection.disconnect();
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramString = null;
      Log.internal("IMCOMMONS_3.7.1", "Cannot get redirect url", localException1);
      return paramString;
    }
  }
  
  public static int getIntFromJSON(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramInt);
        return paramInt;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramInt;
  }
  
  public static int getIntFromJSON(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      if ((i > paramInt3) || (i < paramInt2)) {
        return paramInt1;
      }
      return i;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramInt1);
        return paramInt1;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramInt1;
  }
  
  public static long getLongFromJSON(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramLong);
        return paramLong;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramLong;
  }
  
  public static long getLongFromJSON(JSONObject paramJSONObject, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      if ((l > paramLong3) || (l < paramLong2)) {
        return paramLong1;
      }
      return l;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramLong1);
        return paramLong1;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramLong1;
  }
  
  public static String getSavedUserAgent()
  {
    return d;
  }
  
  public static String getStringFromJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      String str = paramJSONObject.getString(paramString1);
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        Log.debug("IMCOMMONS_3.7.1", "JSON with property " + paramString1 + " found but has bad datatype(" + paramJSONObject.get(paramString1).getClass() + "). Reverting to " + paramString2);
        return paramString2;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramString2;
  }
  
  public static String getUserAgent(Context paramContext)
  {
    try
    {
      if (d == null) {
        if (Build.VERSION.SDK_INT < 17) {
          break label25;
        }
      }
      label25:
      for (d = a.a(paramContext);; d = new WebView(paramContext).getSettings().getUserAgentString()) {
        return d;
      }
      return d;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      Log.internal("IMCOMMONS_3.7.1", "Cannot get user agent", paramContext);
    }
  }
  
  public static void initialize(Context paramContext)
  {
    if (getContext() == null)
    {
      if (paramContext == null) {
        throw new NullPointerException();
      }
      b = paramContext;
    }
    try
    {
      CacheController.getConfig("commons", paramContext, e, c);
      return;
    }
    catch (CommonsException paramContext)
    {
      Log.debug("IMCOMMONS_3.7.1", "IMCommonsException caught with code " + paramContext.getCode());
    }
  }
  
  public static boolean isDefOrientationLandscape(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 > paramInt3) && ((paramInt1 == 0) || (paramInt1 == 2))) {}
    while ((paramInt2 < paramInt3) && ((paramInt1 == 1) || (paramInt1 == 3))) {
      return true;
    }
    return false;
  }
  
  public static boolean isTablet(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    double d1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
    double d2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
    return Math.sqrt(d2 * d2 + d1 * d1) > 7.0D;
  }
  
  public static void populate(JSONObject paramJSONObject1, JSONObject paramJSONObject2, boolean paramBoolean)
    throws JSONException
  {
    Iterator localIterator = paramJSONObject1.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2;
      try
      {
        paramJSONObject2.get(str);
        try
        {
          Object localObject1 = paramJSONObject1.get(str);
          localObject2 = paramJSONObject2.get(str);
          if ((!(localObject1 instanceof JSONObject)) || (!(localObject2 instanceof JSONObject))) {
            break label120;
          }
          if (paramBoolean) {
            break label103;
          }
          paramJSONObject2.put(str, localObject1);
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        paramJSONObject2.put(localJSONException1, paramJSONObject1.get(localJSONException1));
      }
      continue;
      label103:
      populate((JSONObject)localJSONException2, (JSONObject)localObject2, true);
      continue;
      label120:
      paramJSONObject2.put(localJSONException1, localJSONException2);
    }
  }
  
  public static JSONObject populateToNewJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2, boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    populate(paramJSONObject2, localJSONObject, false);
    populate(paramJSONObject1, localJSONObject, paramBoolean);
    return localJSONObject;
  }
  
  public static void setContext(Context paramContext)
  {
    if (b == null)
    {
      b = paramContext.getApplicationContext();
      a();
    }
    try
    {
      a(CacheController.getConfig("commons", paramContext, e, c).getData());
      return;
    }
    catch (CommonsException paramContext) {}
  }
  
  public static boolean validateAppId(String paramString)
  {
    if (paramString == null)
    {
      Log.debug("IMCOMMONS_3.7.1", "appId is null");
      return false;
    }
    if (paramString.matches("(x)+"))
    {
      Log.debug("IMCOMMONS_3.7.1", "appId is all xxxxxxx");
      return false;
    }
    if ("".equals(paramString.trim()))
    {
      Log.debug("IMCOMMONS_3.7.1", "appId is all blank");
      return false;
    }
    return true;
  }
  
  @TargetApi(17)
  static class a
  {
    static String a(Context paramContext)
    {
      return WebSettings.getDefaultUserAgent(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/InternalSDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */