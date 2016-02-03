package com.vungle.publisher;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class dq
{
  private static final Map<String, List<dp>> a = new HashMap();
  private static final Map<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static List<dp> a(Class<?> arg0, String paramString)
  {
    String str1 = ???.getName() + '.' + paramString;
    synchronized (a)
    {
      localObject2 = (List)a.get(str1);
      if (localObject2 != null) {
        return (List<dp>)localObject2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    for (Object localObject2 = ???; localObject2 != null; localObject2 = ((Class)localObject2).getSuperclass())
    {
      ??? = ((Class)localObject2).getName();
      if ((((String)???).startsWith("java.")) || (((String)???).startsWith("javax.")) || (((String)???).startsWith("android."))) {
        break;
      }
      Method[] arrayOfMethod = ((Class)localObject2).getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      if (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        String str2 = localMethod.getName();
        if (str2.startsWith(paramString))
        {
          int k = localMethod.getModifiers();
          if (((k & 0x1) == 0) || ((k & 0x408) != 0)) {
            break label410;
          }
          Object localObject3 = localMethod.getParameterTypes();
          if (localObject3.length == 1)
          {
            ??? = str2.substring(paramString.length());
            if (((String)???).length() != 0) {
              break label318;
            }
            ??? = ds.a;
            label241:
            localObject3 = localObject3[0];
            localStringBuilder.setLength(0);
            localStringBuilder.append(str2);
            localStringBuilder.append('>').append(((Class)localObject3).getName());
            if (localHashSet.add(localStringBuilder.toString())) {
              localArrayList.add(new dp(localMethod, (ds)???, (Class)localObject3));
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label318:
          if (((String)???).equals("MainThread"))
          {
            ??? = ds.b;
            break label241;
          }
          if (((String)???).equals("BackgroundThread"))
          {
            ??? = ds.c;
            break label241;
          }
          if (((String)???).equals("Async"))
          {
            ??? = ds.d;
            break label241;
          }
          if (!b.containsKey(localObject2))
          {
            throw new dj("Illegal onEvent method, check for typos: " + localMethod);
            label410:
            if (!b.containsKey(localObject2)) {
              Log.d(di.b, "Skipping method (not public, static or abstract): " + localObject2 + "." + str2);
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty()) {
      throw new dj("Subscriber " + ??? + " has no public methods called " + paramString);
    }
    synchronized (a)
    {
      a.put(str1, localArrayList);
      return localArrayList;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */