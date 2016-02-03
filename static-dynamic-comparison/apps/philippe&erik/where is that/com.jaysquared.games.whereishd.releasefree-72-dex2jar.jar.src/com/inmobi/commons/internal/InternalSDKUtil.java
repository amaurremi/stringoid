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
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UIDUtil;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalSDKUtil
{
  public static final String BASE_LOG_TAG = "[InMobi]";
  public static final String INMOBI_SDK_RELEASE_DATE = "20140131";
  public static final String INMOBI_SDK_RELEASE_VERSION = "4.1.1";
  public static final String LOGGING_TAG = "[InMobi]-4.1.1";
  public static final String PRODUCT_COMMONS = "commons";
  private static CommonsConfig a = new CommonsConfig();
  private static String b;
  private static Context c = null;
  private static Map<String, String> d = new HashMap();
  private static CacheController.Validator e = new d();
  private static boolean f = true;
  
  private static void a()
  {
    d = UIDUtil.getMap(getContext(), null);
  }
  
  static boolean a(Map<String, Object> paramMap)
  {
    
    try
    {
      CommonsConfig localCommonsConfig = new CommonsConfig();
      localCommonsConfig.setFromMap(paramMap);
      a = localCommonsConfig;
      ApiStatCollector.getLogger().setMetricConfigParams(localCommonsConfig.getApiStatsConfig());
      return true;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
    return false;
  }
  
  public static void addCommonPropertiesToConnection(HttpURLConnection paramHttpURLConnection)
  {
    String str = getUserAgent(getContext());
    if (str != null) {
      paramHttpURLConnection.setRequestProperty("User-Agent", str);
    }
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
      Log.internal("[InMobi]-4.1.1", "Cannot check network state", paramContext);
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
        Log.debug("[InMobi]-4.1.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramBoolean);
        return paramBoolean;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramBoolean;
  }
  
  public static boolean getBooleanFromMap(Map<String, Object> paramMap, String paramString)
  {
    paramMap = paramMap.get(paramString);
    if ((paramMap instanceof Boolean)) {
      return ((Boolean)paramMap).booleanValue();
    }
    Log.internal("[InMobi]-4.1.1", "Key " + paramString + " has illegal value");
    throw new IllegalArgumentException();
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
        Log.internal("[InMobi]-4.1.1", "Error getting the network info", paramContext);
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
    return c;
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
        }
        catch (Exception paramDisplay)
        {
          Log.internal("commons", "Unable to access display rotation");
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        try
        {
          Method localMethod2 = Display.class.getMethod("getOrientation", (Class[])null);
          localObject = localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Log.internal("commons", "Unable to access getOrientation method via reflection");
        }
      }
    }
    if (localObject != null) {}
    return 64537;
  }
  
  public static String getFinalRedirectedUrl(String paramString)
  {
    int i = 0;
    String str2;
    label133:
    for (;;)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        addCommonPropertiesToConnection(localHttpURLConnection);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestMethod("GET");
        j = localHttpURLConnection.getResponseCode();
        if ((j < 300) || (j >= 400)) {
          break label133;
        }
        str1 = localHttpURLConnection.getHeaderField("Location");
        if (str1 == null) {
          str2 = paramString;
        }
      }
      catch (Exception localException1)
      {
        HttpURLConnection localHttpURLConnection;
        int j;
        String str1;
        Log.internal("[InMobi]-4.1.1", "Cannot get redirect url", localException1);
        return paramString;
      }
      try
      {
        localHttpURLConnection.disconnect();
        return paramString;
      }
      catch (Exception localException2)
      {
        paramString = str2;
        continue;
      }
      str2 = str1;
      j = localHttpURLConnection.getResponseCode();
      paramString = str1;
      if (j != 200)
      {
        paramString = str1;
        if (i < 5)
        {
          i += 1;
          paramString = str1;
        }
      }
    }
  }
  
  public static String getInMobiInternalVersion(String paramString)
  {
    paramString = paramString.split("[.]");
    StringBuffer localStringBuffer = new StringBuffer("");
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        int j = Integer.valueOf(paramString[i]).intValue();
        localStringBuffer.append("T").append((char)(j + 65));
        i += 1;
        continue;
        if (localStringBuffer.equals("")) {
          return "";
        }
        return localStringBuffer.substring(1).toString();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
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
        Log.debug("[InMobi]-4.1.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramInt);
        return paramInt;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramInt;
  }
  
  public static int getIntFromMap(Map<String, Object> paramMap, String paramString, int paramInt, long paramLong)
  {
    paramMap = paramMap.get(paramString);
    if ((paramMap instanceof Integer))
    {
      int i = ((Integer)paramMap).intValue();
      if ((i <= paramLong) && (i >= paramInt)) {
        return i;
      }
    }
    Log.internal("[InMobi]-4.1.1", "Key " + paramString + " has illegal value");
    throw new IllegalArgumentException();
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
        Log.debug("[InMobi]-4.1.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramLong);
        return paramLong;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramLong;
  }
  
  public static long getLongFromMap(Map<String, Object> paramMap, String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = paramMap.get(paramString);
    if ((localObject instanceof Long))
    {
      l = ((Long)localObject).longValue();
      if ((l <= paramLong2) && (l >= paramLong1)) {
        return l;
      }
    }
    long l = paramLong1;
    if (paramLong1 < -2147483648L) {
      l = -2147483648L;
    }
    int i = (int)l;
    paramLong1 = paramLong2;
    if (paramLong2 > 2147483647L) {
      paramLong1 = 2147483647L;
    }
    return getIntFromMap(paramMap, paramString, i, (int)paramLong1);
  }
  
  public static String getSavedUserAgent()
  {
    return b;
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
        Log.debug("[InMobi]-4.1.1", "JSON with property " + paramString1 + " found but has bad datatype(" + paramJSONObject.get(paramString1).getClass() + "). Reverting to " + paramString2);
        return paramString2;
      }
      catch (JSONException paramJSONObject) {}
    }
    return paramString2;
  }
  
  public static String getStringFromMap(Map<String, Object> paramMap, String paramString)
  {
    paramMap = paramMap.get(paramString);
    if ((paramMap instanceof String)) {
      return (String)paramMap;
    }
    Log.internal("[InMobi]-4.1.1", "Key " + paramString + " has illegal value");
    throw new IllegalArgumentException();
  }
  
  public static String getUserAgent(Context paramContext)
  {
    try
    {
      if (b == null) {
        if (Build.VERSION.SDK_INT < 17) {
          break label25;
        }
      }
      label25:
      for (b = a.a(paramContext);; b = new WebView(paramContext).getSettings().getUserAgentString()) {
        return b;
      }
      return b;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-4.1.1", "Cannot get user agent", paramContext);
    }
  }
  
  public static void initialize(Context paramContext)
  {
    if (getContext() == null)
    {
      if (paramContext != null) {
        break label24;
      }
      c.getApplicationContext();
    }
    while (InMobi.getAppId() == null)
    {
      return;
      label24:
      c = paramContext.getApplicationContext();
    }
    if (f)
    {
      f = false;
      a();
    }
    try
    {
      a(CacheController.getConfig("commons", paramContext, d, e).getData());
      return;
    }
    catch (CommonsException paramContext)
    {
      Log.debug("[InMobi]-4.1.1", "IMCommons config init: IMCommonsException caught. Reason: " + paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      Log.debug("[InMobi]-4.1.1", "Exception while getting commons config data.");
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
  
  public static boolean isInitializedSuccessfully()
  {
    return isInitializedSuccessfully(true);
  }
  
  public static boolean isInitializedSuccessfully(boolean paramBoolean)
  {
    if ((getContext() == null) || (InMobi.getAppId() == null))
    {
      if (paramBoolean) {
        Log.debug("[InMobi]-4.1.1", "InMobi not initialized. Call InMobi.initialize before using any InMobi API");
      }
      return false;
    }
    return true;
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
  
  public static void populate(Map<String, Object> paramMap1, Map<String, Object> paramMap2, boolean paramBoolean)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramMap2.get(str) == null) {
        paramMap2.put(str, paramMap1.get(str));
      }
      Object localObject1 = paramMap1.get(str);
      Object localObject2 = paramMap2.get(str);
      if (((localObject1 instanceof Map)) && ((localObject2 instanceof Map)))
      {
        if (!paramBoolean) {
          paramMap2.put(str, localObject1);
        } else {
          populate((Map)localObject1, (Map)localObject2, true);
        }
      }
      else {
        paramMap2.put(str, localObject1);
      }
    }
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
            break label130;
          }
          if (paramBoolean) {
            break label113;
          }
          paramJSONObject2.put(str, localObject1);
        }
        catch (JSONException localJSONException1)
        {
          Log.internal("[InMobi]-4.1.1", "Cannot populate to json exception", localJSONException1);
        }
      }
      catch (JSONException localJSONException2)
      {
        paramJSONObject2.put(localJSONException1, paramJSONObject1.get(localJSONException1));
      }
      continue;
      label113:
      populate((JSONObject)localJSONException2, (JSONObject)localObject2, true);
      continue;
      label130:
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
  
  public static Map<String, Object> populateToNewMap(Map<String, Object> paramMap1, Map<String, Object> paramMap2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    populate(paramMap2, localHashMap, false);
    populate(paramMap1, localHashMap, paramBoolean);
    return localHashMap;
  }
  
  public static void setContext(Context paramContext)
  {
    if (c == null)
    {
      c = paramContext.getApplicationContext();
      if (InMobi.getAppId() != null) {}
    }
    else
    {
      return;
    }
    a();
    try
    {
      CacheController.getConfig("commons", paramContext, d, e);
      return;
    }
    catch (CommonsException paramContext)
    {
      Log.internal("commons", "Unable retrive config for commons product");
    }
  }
  
  public static boolean validateAppId(String paramString)
  {
    if (paramString == null)
    {
      Log.debug("[InMobi]-4.1.1", "appId is null");
      return false;
    }
    if (paramString.matches("(x)+"))
    {
      Log.debug("[InMobi]-4.1.1", "appId is all xxxxxxx");
      return false;
    }
    if ("".equals(paramString.trim()))
    {
      Log.debug("[InMobi]-4.1.1", "appId is all blank");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/InternalSDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */