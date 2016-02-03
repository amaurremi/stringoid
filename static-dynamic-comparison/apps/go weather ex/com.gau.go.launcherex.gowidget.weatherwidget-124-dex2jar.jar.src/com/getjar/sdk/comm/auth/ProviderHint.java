package com.getjar.sdk.comm.auth;

import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProviderHint
{
  private final HashMap<String, String> _data;
  private final String _filter;
  
  public ProviderHint(String paramString, HashMap<String, String> paramHashMap)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'providerFilter' cannot be NULL or empty");
    }
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      throw new IllegalArgumentException("'providerData' cannot be NULL or empty");
    }
    this._filter = paramString;
    this._data = paramHashMap;
  }
  
  public static HashMap<String, String> parseData(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      JSONArray localJSONArray;
      int i;
      if (!StringUtility.isNullOrEmpty(paramString))
      {
        localJSONArray = new JSONArray(paramString);
        localObject1 = new HashMap(localJSONArray.length());
        i = 0;
      }
      return (HashMap<String, String>)localObject1;
    }
    catch (Exception localException2)
    {
      try
      {
        while (i < localJSONArray.length())
        {
          ((HashMap)localObject1).put(localJSONArray.getJSONObject(i).getString("key"), localJSONArray.getJSONObject(i).getString("value"));
          i += 1;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
      Logger.e(Area.AUTH.value(), (Throwable)localObject2, "parseData() failed [%1$s]", new Object[] { paramString });
    }
    return (HashMap<String, String>)localObject1;
  }
  
  public HashMap<String, String> getData()
  {
    return this._data;
  }
  
  public String getFilter()
  {
    return this._filter;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/ProviderHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */