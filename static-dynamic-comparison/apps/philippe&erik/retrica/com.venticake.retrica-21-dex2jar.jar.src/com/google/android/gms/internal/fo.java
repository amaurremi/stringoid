package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class fo
{
  private static final String[] xZ;
  private static final Map<String, Integer> ya;
  
  static
  {
    int i = 0;
    xZ = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    ya = new HashMap(xZ.length);
    while (i < xZ.length)
    {
      ya.put(xZ[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static String H(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= xZ.length)) {
      return null;
    }
    return xZ[paramInt];
  }
  
  public static int Y(String paramString)
  {
    Integer localInteger = (Integer)ya.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    }
    return localInteger.intValue();
  }
  
  public static int dP()
  {
    return xZ.length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */