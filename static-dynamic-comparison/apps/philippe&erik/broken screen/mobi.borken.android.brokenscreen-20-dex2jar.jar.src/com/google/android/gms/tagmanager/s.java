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
  extends aj
{
  private static final String ID = a.J.toString();
  private static final String aeT = b.cy.toString();
  private static final String aej = b.aX.toString();
  private final a aeU;
  
  public s(a parama)
  {
    super(ID, new String[] { aeT });
    this.aeU = parama;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    String str = dh.j((d.a)paramMap.get(aeT));
    HashMap localHashMap = new HashMap();
    paramMap = (d.a)paramMap.get(aej);
    if (paramMap != null)
    {
      paramMap = dh.o(paramMap);
      if (!(paramMap instanceof Map))
      {
        bh.D("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return dh.mY();
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
      paramMap = dh.r(this.aeU.b(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      bh.D("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return dh.mY();
  }
  
  public static abstract interface a
  {
    public abstract Object b(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */