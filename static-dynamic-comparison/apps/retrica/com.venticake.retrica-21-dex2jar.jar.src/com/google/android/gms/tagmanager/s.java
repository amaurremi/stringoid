package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class s
  extends t
{
  private static final String a = a.J.toString();
  private static final String b = b.cy.toString();
  private static final String c = b.aX.toString();
  private final s.a d;
  
  public s(s.a parama)
  {
    super(a, new String[] { b });
    this.d = parama;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    String str = de.a((d.a)paramMap.get(b));
    HashMap localHashMap = new HashMap();
    paramMap = (d.a)paramMap.get(c);
    if (paramMap != null)
    {
      paramMap = de.f(paramMap);
      if (!(paramMap instanceof Map))
      {
        as.b("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return de.g();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = de.f(this.d.b(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      as.b("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return de.g();
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */