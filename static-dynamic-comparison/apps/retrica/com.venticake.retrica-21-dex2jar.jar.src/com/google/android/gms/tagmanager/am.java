package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class am
{
  public static cq.c a(String paramString)
  {
    paramString = b(new JSONObject(paramString));
    cq.d locald = cq.c.mr();
    int i = 0;
    while (i < paramString.fP.length)
    {
      locald.a(cq.a.mn().b(b.cI.toString(), paramString.fP[i]).b(b.cx.toString(), de.a(do.d())).b(do.e(), paramString.fQ[i]).mq());
      i += 1;
    }
    return locald.mu();
  }
  
  static Object a(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = ((JSONObject)paramObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, a(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
  
  private static d.a b(Object paramObject)
  {
    return de.f(a(paramObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */