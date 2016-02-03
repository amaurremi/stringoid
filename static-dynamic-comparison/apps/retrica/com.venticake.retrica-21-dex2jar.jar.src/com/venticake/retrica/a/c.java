package com.venticake.retrica.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static b a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      String str2 = ((JSONObject)localObject).getString("requestId");
      int i = ((JSONObject)localObject).getInt("requestState");
      paramString = ((JSONObject)localObject).optString("purchaseToken");
      String str1 = ((JSONObject)localObject).optString("sku");
      boolean bool = ((JSONObject)localObject).optBoolean("purchaseTokenFulfilled");
      localObject = new b(str2);
      ((b)localObject).a(h.a(i));
      ((b)localObject).b(paramString);
      ((b)localObject).c(str1);
      if (bool) {
        ((b)localObject).g();
      }
      return (b)localObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(b paramb)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("requestId", paramb.a());
      localJSONObject.put("requestState", paramb.d());
      if (paramb.e() != null) {
        localJSONObject.put("purchaseToken", paramb.e());
      }
      if (paramb.f() != null) {
        localJSONObject.put("sku", paramb.f());
      }
      if (paramb.h()) {
        localJSONObject.put("purchaseTokenFulfilled", true);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("amazon_iap", "toJSON: ERROR serializing: " + paramb);
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */