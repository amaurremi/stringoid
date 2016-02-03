package com.vungle.publisher;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class dc
{
  public static Map<db<?>, Object> a(cz paramcz, Object[] paramArrayOfObject)
  {
    Object localObject1 = new LinkedHashMap(paramArrayOfObject.length);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] instanceof Class))
      {
        localObject2 = paramcz.a((Class)paramArrayOfObject[i]);
        ((Map)localObject1).put(localObject2, ((db)localObject2).a());
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject1).put(paramcz.a(paramArrayOfObject[i].getClass()), paramArrayOfObject[i]);
      }
    }
    paramArrayOfObject = new LinkedHashMap((Map)localObject1);
    Object localObject2 = new LinkedHashMap();
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      a(paramcz, (db)((Iterator)localObject1).next(), (Map)localObject2);
    }
    paramcz = ((Map)localObject2).values().iterator();
    while (paramcz.hasNext())
    {
      localObject1 = (db)paramcz.next();
      if (!paramArrayOfObject.containsKey(localObject1)) {
        paramArrayOfObject.put(localObject1, ((db)localObject1).a());
      }
    }
    return paramArrayOfObject;
  }
  
  private static void a(cz paramcz, db<?> paramdb, Map<Class<?>, db<?>> paramMap)
  {
    paramdb = paramdb.e;
    int j = paramdb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramdb[i];
      if (!paramMap.containsKey(localObject))
      {
        db localdb = paramcz.a((Class)localObject);
        paramMap.put(localObject, localdb);
        a(paramcz, localdb, paramMap);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */