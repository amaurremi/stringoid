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
  private static final String ID = a.L.toString();
  private static final String anK = b.bl.toString();
  private static final String aot = b.cV.toString();
  private final a aou;
  
  public s(a parama)
  {
    super(ID, new String[] { aot });
    this.aou = parama;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    String str = di.j((d.a)paramMap.get(aot));
    HashMap localHashMap = new HashMap();
    paramMap = (d.a)paramMap.get(anK);
    if (paramMap != null)
    {
      paramMap = di.o(paramMap);
      if (!(paramMap instanceof Map))
      {
        bh.W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return di.pI();
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
      paramMap = di.u(this.aou.b(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      bh.W("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return di.pI();
  }
  
  public boolean nL()
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract Object b(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */