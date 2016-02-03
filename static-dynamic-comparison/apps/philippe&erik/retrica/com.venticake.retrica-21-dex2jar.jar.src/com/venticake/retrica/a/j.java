package com.venticake.retrica.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  public static i a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("sku");
      int i = paramString.getInt("fulfilledCount");
      paramString = new i(str);
      paramString.a(i);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(i parami)
  {
    if (parami == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sku", parami.c());
      localJSONObject.put("fulfilledCount", parami.d());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("amazon_iap", "toJSON: ERROR serializing: " + parami);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */