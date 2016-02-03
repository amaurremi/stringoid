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
  public static cr.c cD(String paramString)
    throws JSONException
  {
    paramString = n(new JSONObject(paramString));
    cr.d locald = cr.c.oV();
    int i = 0;
    while (i < paramString.gx.length)
    {
      locald.a(cr.a.oR().b(b.df.toString(), paramString.gx[i]).b(b.cU.toString(), di.cU(m.nO())).b(m.nP(), paramString.gy[i]).oU());
      i += 1;
    }
    return locald.oY();
  }
  
  private static d.a n(Object paramObject)
    throws JSONException
  {
    return di.u(o(paramObject));
  }
  
  static Object o(Object paramObject)
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
        ((Map)localObject).put(str, o(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */