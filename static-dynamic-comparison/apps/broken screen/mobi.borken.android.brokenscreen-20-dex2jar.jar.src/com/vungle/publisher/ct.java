package com.vungle.publisher;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ct
{
  final Map<String, cs<?>> b = new LinkedHashMap();
  
  public final cs<?> a(String paramString, cs<?> paramcs)
  {
    cs localcs = (cs)this.b.put(paramString, paramcs);
    if (localcs != null)
    {
      this.b.put(paramString, localcs);
      throw new IllegalArgumentException("Duplicate:\n    " + localcs + "\n    " + paramcs);
    }
    return null;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + this.b.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */