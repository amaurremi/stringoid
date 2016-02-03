package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

class f
{
  private final Map<String, String> a = new HashMap();
  private final Map<String, String> b = new HashMap();
  private final Map<String, Integer> c = new HashMap();
  
  public f a(String paramString1, String paramString2, int paramInt)
  {
    this.a.put(paramString1, paramString2);
    this.b.put(paramString2, paramString1);
    this.c.put(paramString1, Integer.valueOf(paramInt));
    return this;
  }
  
  public String a(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  public String b(String paramString)
  {
    return (String)this.b.get(paramString);
  }
  
  public int c(String paramString)
  {
    paramString = (Integer)this.c.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */