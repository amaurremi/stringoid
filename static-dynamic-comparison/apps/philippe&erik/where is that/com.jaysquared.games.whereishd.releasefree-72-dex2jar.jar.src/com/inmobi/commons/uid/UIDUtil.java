package com.inmobi.commons.uid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.inmobi.commons.InMobi;
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
        Log.internal("[InMobi]-4.1.1", "UIDUtil: Unable to bind to JSON for key " + str);
      }
    }
  }
  
  public static String getEncryptedJSON(Map<String, String> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    bindToJSON(paramMap, localJSONObject);
    return UIDHelper.encryptRSA(localJSONObject.toString());
  }
  
  public static String getEncryptedUid(String paramString)
  {
    return UID.getCommonsUid().getDefaultUidMap(1, paramString, null);
  }
  
  public static Map<String, String> getMap(Context paramContext, UID paramUID)
  {
    Map localMap = getUid(paramUID);
    String str = paramContext.getPackageName();
    paramUID = "";
    try
    {
      paramContext = Integer.valueOf(paramContext.getPackageManager().getPackageInfo(str, 0).versionCode).toString();
      localMap.put("u-appbid", str);
      localMap.put("u-appver", paramContext);
      paramUID = InMobi.getAppId();
      paramContext = paramUID;
      if (paramUID == null) {
        paramContext = "";
      }
      localMap.put("mk-siteid", paramContext);
      localMap.put("mk-version", "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.1.1") + "-" + "20140131");
      localMap.put("ua", InternalSDKUtil.getSavedUserAgent());
      return localMap;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Unable to get app version", paramContext);
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
      localHashMap.put("u-id-map", UID.getCommonsUid().getDefaultUidMap(1, str, null));
      return localHashMap;
    }
    localHashMap.put("u-id-map", paramUID.getUidMap(1, str, null));
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/uid/UIDUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */