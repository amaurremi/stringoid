package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class fp
{
  private static final String[] xW;
  private static final Map<String, Integer> xX;
  
  static
  {
    int i = 0;
    xW = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    xX = new HashMap(xW.length);
    while (i < xW.length)
    {
      xX.put(xW[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static String H(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= xW.length)) {
      return null;
    }
    return xW[paramInt];
  }
  
  public static int Y(String paramString)
  {
    Integer localInteger = (Integer)xX.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    }
    return localInteger.intValue();
  }
  
  public static int dK()
  {
    return xW.length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */