package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class de
{
  private static final Object a = null;
  private static Long b = new Long(0L);
  private static Double c = new Double(0.0D);
  private static dd d = dd.a(0L);
  private static String e = new String("");
  private static Boolean f = new Boolean(false);
  private static List<Object> g = new ArrayList(0);
  private static Map<Object, Object> h = new HashMap();
  private static d.a i = f(e);
  
  public static d.a a(String paramString)
  {
    d.a locala = new d.a();
    locala.type = 5;
    locala.fS = paramString;
    return locala;
  }
  
  public static Object a()
  {
    return a;
  }
  
  public static String a(d.a parama)
  {
    return a(f(parama));
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      return e;
    }
    return paramObject.toString();
  }
  
  public static dd b(d.a parama)
  {
    return b(f(parama));
  }
  
  public static dd b(Object paramObject)
  {
    if ((paramObject instanceof dd)) {
      return (dd)paramObject;
    }
    if (i(paramObject)) {
      return dd.a(j(paramObject));
    }
    if (g(paramObject)) {
      return dd.a(Double.valueOf(h(paramObject)));
    }
    return b(a(paramObject));
  }
  
  private static dd b(String paramString)
  {
    try
    {
      dd localdd = dd.a(paramString);
      return localdd;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      as.a("Failed to convert '" + paramString + "' to a number.");
    }
    return d;
  }
  
  public static Long b()
  {
    return b;
  }
  
  public static Double c()
  {
    return c;
  }
  
  public static Long c(d.a parama)
  {
    return c(f(parama));
  }
  
  public static Long c(Object paramObject)
  {
    if (i(paramObject)) {
      return Long.valueOf(j(paramObject));
    }
    return c(a(paramObject));
  }
  
  private static Long c(String paramString)
  {
    paramString = b(paramString);
    if (paramString == d) {
      return b;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  public static Boolean d()
  {
    return f;
  }
  
  public static Double d(d.a parama)
  {
    return d(f(parama));
  }
  
  public static Double d(Object paramObject)
  {
    if (g(paramObject)) {
      return Double.valueOf(h(paramObject));
    }
    return d(a(paramObject));
  }
  
  private static Double d(String paramString)
  {
    paramString = b(paramString);
    if (paramString == d) {
      return c;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  public static dd e()
  {
    return d;
  }
  
  public static Boolean e(d.a parama)
  {
    return e(f(parama));
  }
  
  public static Boolean e(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return e(a(paramObject));
  }
  
  private static Boolean e(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return f;
  }
  
  public static d.a f(Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new d.a();
    if ((paramObject instanceof d.a)) {
      return (d.a)paramObject;
    }
    if ((paramObject instanceof String))
    {
      ((d.a)localObject1).type = 1;
      ((d.a)localObject1).fN = ((String)paramObject);
    }
    for (;;)
    {
      ((d.a)localObject1).fX = bool;
      return (d.a)localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramObject instanceof List))
      {
        ((d.a)localObject1).type = 2;
        localObject2 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = f(((Iterator)localObject2).next());
          if (localObject3 == i) {
            return i;
          }
          if ((bool) || (((d.a)localObject3).fX)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        ((d.a)localObject1).fO = ((d.a[])((List)paramObject).toArray(new d.a[0]));
      }
      else if ((paramObject instanceof Map))
      {
        ((d.a)localObject1).type = 3;
        localObject3 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject3).size());
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        bool = false;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
          d.a locala = f(((Map.Entry)localObject4).getKey());
          localObject4 = f(((Map.Entry)localObject4).getValue());
          if ((locala == i) || (localObject4 == i)) {
            return i;
          }
          if ((bool) || (locala.fX) || (((d.a)localObject4).fX)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(locala);
            ((List)localObject2).add(localObject4);
            break;
          }
        }
        ((d.a)localObject1).fP = ((d.a[])((List)paramObject).toArray(new d.a[0]));
        ((d.a)localObject1).fQ = ((d.a[])((List)localObject2).toArray(new d.a[0]));
      }
      else if (g(paramObject))
      {
        ((d.a)localObject1).type = 1;
        ((d.a)localObject1).fN = paramObject.toString();
      }
      else if (i(paramObject))
      {
        ((d.a)localObject1).type = 6;
        ((d.a)localObject1).fT = j(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((d.a)localObject1).type = 8;
        ((d.a)localObject1).fU = ((Boolean)paramObject).booleanValue();
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      as.a((String)paramObject);
      return i;
    }
  }
  
  public static Object f(d.a parama)
  {
    int m = 0;
    int k = 0;
    int j = 0;
    if (parama == null) {
      return a;
    }
    Object localObject1;
    Object localObject2;
    switch (parama.type)
    {
    default: 
      as.a("Failed to convert a value of type: " + parama.type);
      return a;
    case 1: 
      return parama.fN;
    case 2: 
      localObject1 = new ArrayList(parama.fO.length);
      parama = parama.fO;
      k = parama.length;
      while (j < k)
      {
        localObject2 = f(parama[j]);
        if (localObject2 == a) {
          return a;
        }
        ((ArrayList)localObject1).add(localObject2);
        j += 1;
      }
      return localObject1;
    case 3: 
      if (parama.fP.length != parama.fQ.length)
      {
        as.a("Converting an invalid value to object: " + parama.toString());
        return a;
      }
      localObject1 = new HashMap(parama.fQ.length);
      j = m;
      while (j < parama.fP.length)
      {
        localObject2 = f(parama.fP[j]);
        Object localObject3 = f(parama.fQ[j]);
        if ((localObject2 == a) || (localObject3 == a)) {
          return a;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        j += 1;
      }
      return localObject1;
    case 4: 
      as.a("Trying to convert a macro reference to object");
      return a;
    case 5: 
      as.a("Trying to convert a function id to object");
      return a;
    case 6: 
      return Long.valueOf(parama.fT);
    case 7: 
      localObject1 = new StringBuffer();
      parama = parama.fV;
      m = parama.length;
      j = k;
      while (j < m)
      {
        localObject2 = a(parama[j]);
        if (localObject2 == e) {
          return a;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        j += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(parama.fU);
  }
  
  public static String f()
  {
    return e;
  }
  
  public static d.a g()
  {
    return i;
  }
  
  private static boolean g(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof dd)) && (((dd)paramObject).a()));
  }
  
  private static double h(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    as.a("getDouble received non-Number");
    return 0.0D;
  }
  
  private static boolean i(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof dd)) && (((dd)paramObject).b()));
  }
  
  private static long j(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    as.a("getInt64 received non-Number");
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */