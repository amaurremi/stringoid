package com.getjar.sdk.comm.auth;

import com.getjar.sdk.comm.Result;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.config.SettingsValue;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthUtilities
{
  protected static final String KeyPrefixCaps = "capabilities.";
  protected static final String KeyPrefixClaims = "claims.";
  
  private static void addClaimsToMap(JSONArray paramJSONArray, String paramString, Map<String, String> paramMap)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("key");
          localObject = ((JSONObject)localObject).getString("value");
          if ((!StringUtility.isNullOrEmpty(str)) && (!StringUtility.isNullOrEmpty((String)localObject)))
          {
            str = String.format(Locale.US, "%1$s%2$s", new Object[] { paramString, str });
            paramMap.put(str, localObject);
            Logger.v(Area.AUTH.value(), "AuthFlow: claim found [key:%1$s  value:%2$s]", new Object[] { str, localObject });
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e(Area.AUTH.value(), localException, "AuthFlow: addClaimsToMap() failed", new Object[0]);
          }
        }
      }
    }
  }
  
  protected static String getAuthTokenFromHeaders(Result paramResult)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Map localMap = paramResult.getHeaders();
    if (localMap != null)
    {
      localObject2 = (List)localMap.get("Authorization");
      paramResult = (Result)localObject1;
      if (localObject2 != null)
      {
        paramResult = (Result)localObject1;
        if (((List)localObject2).size() > 0) {
          paramResult = (String)((List)localObject2).get(0);
        }
      }
      localObject2 = paramResult;
      if (StringUtility.isNullOrEmpty(paramResult))
      {
        localObject2 = (List)localMap.get("authorization");
        localObject1 = paramResult;
        if (localObject2 != null)
        {
          localObject1 = paramResult;
          if (((List)localObject2).size() > 0) {
            localObject1 = (String)((List)localObject2).get(0);
          }
        }
        localObject2 = localObject1;
        if (StringUtility.isNullOrEmpty((String)localObject1))
        {
          localObject2 = (List)localMap.get("AUTHORIZATION");
          paramResult = (Result)localObject1;
          if (localObject2 != null)
          {
            paramResult = (Result)localObject1;
            if (((List)localObject2).size() > 0) {
              paramResult = (String)((List)localObject2).get(0);
            }
          }
          localObject2 = paramResult;
          if (!StringUtility.isNullOrEmpty(paramResult)) {
            return paramResult;
          }
        }
      }
    }
    return (String)localObject2;
  }
  
  protected static Map<String, String> getClaimsFromResult(Result paramResult)
  {
    if (paramResult == null) {
      throw new IllegalArgumentException("'result' cannot be NULL");
    }
    if (!paramResult.isSuccessfulResponse()) {
      throw new IllegalArgumentException("getClaimsFromResult() can only be called for a successful response");
    }
    if (paramResult.getResponseJson() == null) {
      throw new IllegalArgumentException("getClaimsFromResult() can only be called for a result with a response body");
    }
    HashMap localHashMap = new HashMap();
    if (paramResult != null) {}
    try
    {
      if ((paramResult.isSuccessfulResponse()) && (paramResult.getResponseJson() != null) && (paramResult.getResponseJson().has("return")))
      {
        if (paramResult.getResponseJson().getJSONObject("return").has("claims"))
        {
          JSONArray localJSONArray = paramResult.getResponseJson().getJSONObject("return").getJSONArray("claims");
          if (localJSONArray != null) {
            addClaimsToMap(localJSONArray, "claims.", localHashMap);
          }
        }
        if (paramResult.getResponseJson().getJSONObject("return").has("capabilities"))
        {
          paramResult = paramResult.getResponseJson().getJSONObject("return").getJSONArray("capabilities");
          if (paramResult != null) {
            addClaimsToMap(paramResult, "capabilities.", localHashMap);
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramResult)
    {
      Logger.e(Area.AUTH.value(), paramResult, "AuthFlow: getClaimsFromResult() failed", new Object[0]);
    }
    return localHashMap;
  }
  
  public static Map<String, SettingsValue> getSettingsFromResult(Result paramResult)
  {
    if (paramResult == null) {
      throw new IllegalArgumentException("'result' cannot be NULL");
    }
    if (!paramResult.isSuccessfulResponse()) {
      throw new IllegalArgumentException("setSettingsFromResult() can only be called for a successful response");
    }
    if (paramResult.getResponseJson() == null) {
      throw new IllegalArgumentException("setSettingsFromResult() can only be called for a result with a response body");
    }
    String str1 = null;
    JSONObject localJSONObject = null;
    Object localObject = str1;
    if (paramResult != null) {
      localObject = str1;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramResult.isSuccessfulResponse())
        {
          localObject = str1;
          if (paramResult.getResponseJson() != null)
          {
            localObject = str1;
            if (paramResult.getResponseJson().has("return"))
            {
              localObject = str1;
              if (paramResult.getResponseJson().getJSONObject("return").has("settings"))
              {
                localObject = paramResult.getResponseJson().getJSONObject("return").getJSONArray("settings");
                paramResult = new HashMap(((JSONArray)localObject).length());
                i = 0;
                try
                {
                  if (i >= ((JSONArray)localObject).length()) {
                    continue;
                  }
                  localJSONObject = ((JSONArray)localObject).getJSONObject(i);
                  str1 = localJSONObject.getString("name");
                  String str2 = localJSONObject.getString("value");
                  str3 = localJSONObject.getString("type");
                  try
                  {
                    localScope = SettingsManager.Scope.valueOf(localJSONObject.getString("scope"));
                    if (!StringUtility.isNullOrEmpty(str1)) {
                      continue;
                    }
                    Logger.w(Area.AUTH.value(), "Invalid setting name!", new Object[0]);
                  }
                  catch (IllegalArgumentException localIllegalArgumentException2)
                  {
                    Logger.w(Area.CONFIG.value(), "AuthUtilities: Invalid scope[%1$s] received for %2$s", new Object[] { localJSONObject.getString("scope"), str1 });
                  }
                  Logger.e(Area.AUTH.value(), paramResult, "AuthFlow: getSettingsFromResult() failed", new Object[0]);
                }
                catch (Exception localException)
                {
                  localObject = paramResult;
                  paramResult = localException;
                }
              }
            }
          }
        }
      }
      catch (Exception paramResult)
      {
        String str3;
        SettingsManager.Scope localScope;
        localObject = localIllegalArgumentException1;
        continue;
        localObject = paramResult;
        continue;
      }
      paramResult = (Result)localObject;
      if (localObject == null) {
        paramResult = new HashMap(0);
      }
      return paramResult;
      try
      {
        paramResult.put(str1, new SettingsValue(localIllegalArgumentException2, str3, localScope));
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        Logger.w(Area.AUTH.value(), localIllegalArgumentException1, "Invalid setting", new Object[0]);
      }
      i += 1;
    }
  }
  
  protected static long getTTLFromClaims(Map<String, String> paramMap, long paramLong)
  {
    l = paramLong;
    Object localObject4 = null;
    localObject3 = null;
    Long localLong = null;
    localObject2 = null;
    paramLong = l;
    for (;;)
    {
      try
      {
        str2 = String.format(Locale.US, "%1$sExpiresIn", new Object[] { "claims." });
        paramLong = l;
        str1 = String.format(Locale.US, "%1$sExpiresOn", new Object[] { "claims." });
        paramLong = l;
        bool = paramMap.containsKey(str2);
        if (!bool) {}
      }
      catch (Exception paramMap)
      {
        String str2;
        String str1;
        boolean bool;
        Object localObject1;
        Logger.e(Area.AUTH.value(), paramMap, "AuthFlow: getTTLFromClaims() failed", new Object[0]);
        continue;
      }
      try
      {
        paramLong = Long.parseLong((String)paramMap.get(str2));
        localLong = Long.valueOf(paramLong);
      }
      catch (Exception localException)
      {
        paramLong = l;
        Logger.e(Area.AUTH.value(), localException.getMessage(), new Object[0]);
        localObject1 = localObject2;
      }
    }
    paramLong = l;
    Logger.i(Area.AUTH.value(), "AuthFlow: getTTLFromClaims() found expiresInSecs of %1$d", new Object[] { localLong });
    localObject2 = localObject4;
    if (localLong == null)
    {
      paramLong = l;
      bool = paramMap.containsKey(str1);
      localObject2 = localObject4;
      if (!bool) {}
    }
    try
    {
      paramLong = Long.parseLong((String)paramMap.get(str1));
      paramMap = Long.valueOf(paramLong);
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        paramLong = l;
        Logger.e(Area.AUTH.value(), paramMap.getMessage(), new Object[0]);
        paramMap = (Map<String, String>)localObject3;
        continue;
        paramLong = l;
        if (localObject2 != null)
        {
          paramLong = l;
          l = ((Long)localObject2).longValue() - System.currentTimeMillis();
          paramLong = l;
          if (l <= 0L)
          {
            paramLong = l;
            Logger.w(Area.AUTH.value(), "AuthFlow: getTTLFromClaims() parsed an ExpiresOn resulting in a TTL of %1$d", new Object[] { Long.valueOf(l) });
            paramLong = 0L;
          }
        }
      }
    }
    paramLong = l;
    Logger.i(Area.AUTH.value(), "AuthFlow: getTTLFromClaims() found expiresOnEpoch of %1$d", new Object[] { paramMap });
    localObject2 = paramMap;
    if (localLong != null)
    {
      paramLong = l;
      l = localLong.longValue() * 60000L;
      paramLong = l;
      if (l <= 0L)
      {
        paramLong = l;
        Logger.w(Area.AUTH.value(), "AuthFlow: getTTLFromClaims() parsed an ExpiresIn resulting in a TTL of %1$d", new Object[] { Long.valueOf(l) });
        paramLong = 0L;
      }
      Logger.i(Area.AUTH.value(), "AuthFlow: getTTLFromClaims() returning a TTL of %1$d", new Object[] { Long.valueOf(paramLong) });
      return paramLong;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AuthUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */