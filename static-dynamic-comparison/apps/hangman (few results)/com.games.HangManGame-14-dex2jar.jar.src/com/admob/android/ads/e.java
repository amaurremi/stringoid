package com.admob.android.ads;

import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private static boolean a = false;
  
  public static r a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, null);
  }
  
  public static r a(String paramString1, String paramString2, String paramString3, h paramh)
  {
    return a(paramString1, paramString2, paramString3, paramh, 5000, null, null);
  }
  
  public static r a(String paramString1, String paramString2, String paramString3, h paramh, int paramInt)
  {
    paramString1 = a(paramString1, null, paramString3, paramh, 5000, null, null);
    if (paramString1 != null) {
      paramString1.a(1);
    }
    return paramString1;
  }
  
  public static r a(String paramString1, String paramString2, String paramString3, h paramh, int paramInt, Map<String, String> paramMap, String paramString4)
  {
    return new i(paramString1, paramString2, paramString3, paramh, paramInt, null, paramString4);
  }
  
  public static r a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, h paramh)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.toString())
    {
      paramString1 = a(paramString1, paramString2, paramString3, paramh, 5000, null, paramJSONObject);
      paramString1.a("application/json");
      return paramString1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */