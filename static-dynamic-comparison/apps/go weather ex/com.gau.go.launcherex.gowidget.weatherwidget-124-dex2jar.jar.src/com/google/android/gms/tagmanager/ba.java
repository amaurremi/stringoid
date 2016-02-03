package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba
{
  public static cq.c bG(String paramString)
    throws JSONException
  {
    paramString = k(new JSONObject(paramString));
    cq.d locald = cq.c.lh();
    int i = 0;
    while (i < paramString.fP.length)
    {
      locald.a(cq.a.ld().b(b.cI.toString(), paramString.fP[i]).b(b.cx.toString(), dh.bX(m.ka())).b(m.kb(), paramString.fQ[i]).lg());
      i += 1;
    }
    return locald.lk();
  }
  
  private static d.a k(Object paramObject)
    throws JSONException
  {
    return dh.r(l(paramObject));
  }
  
  static Object l(Object paramObject)
    throws JSONException
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
        ((Map)localObject).put(str, l(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */