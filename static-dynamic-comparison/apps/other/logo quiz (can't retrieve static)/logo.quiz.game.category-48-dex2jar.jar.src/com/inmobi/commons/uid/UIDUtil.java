package com.inmobi.commons.uid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.inmobi.commons.IMCommonUtil;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class UIDUtil
{
  private static Random a = new Random();
  
  static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new UnsupportedOperationException(paramString);
    }
  }
  
  public static void bindToConnection(Map<String, String> paramMap, URLConnection paramURLConnection)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramURLConnection.addRequestProperty(str, (String)paramMap.get(str));
    }
  }
  
  public static String bindToGetParam(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(String.format("%s=%s", new Object[] { a(str), a((String)paramMap.get(str)) }));
    }
    return localStringBuilder.toString();
  }
  
  public static void bindToJSON(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject.put(str, paramMap.get(str));
      }
      catch (JSONException localJSONException)
      {
        Log.internal("IMCOMMONS_3.7.1", "UIDUtil: Unable to bind to JSON for key " + str);
      }
    }
  }
  
  public static Map<String, String> getMap(Context paramContext, UID paramUID)
  {
    Map localMap = getUid(paramUID);
    String str = paramContext.getPackageName();
    paramUID = "";
    try
    {
      paramContext = Integer.valueOf(paramContext.getPackageManager().getPackageInfo(str, 0).versionCode).toString();
      localMap.put("a-bid", str);
      localMap.put("a-ver", paramContext);
      localMap.put("s-ver", IMCommonUtil.getReleaseVersion());
      localMap.put("i-aid", UIDHelper.getIMAppId());
      localMap.put("ua", InternalSDKUtil.getSavedUserAgent());
      return localMap;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.internal("IMCOMMONS_3.7.1", "Unable to get app version", paramContext);
        paramContext = paramUID;
      }
    }
  }
  
  public static Map<String, String> getUid(UID paramUID)
  {
    HashMap localHashMap = new HashMap();
    String str = Integer.toString(a.nextInt());
    localHashMap.put("u-id-key", str);
    localHashMap.put("u-key-ver", UIDHelper.getRSAKeyVersion());
    if (paramUID == null)
    {
      localHashMap.put("u-id-map", UID.commons.getUidMapNoReinit(null, null, 1, str));
      return localHashMap;
    }
    localHashMap.put("u-id-map", paramUID.getUidMap(null, null, 1, str));
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/uid/UIDUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */