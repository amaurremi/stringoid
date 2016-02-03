package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.cc.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ab
{
  private static final Object XN = null;
  private static Long XO = new Long(0L);
  private static Double XP = new Double(0.0D);
  private static dh XQ = dh.w(0L);
  private static String XR = new String("");
  private static Boolean XS = new Boolean(false);
  private static List<Object> XT = new ArrayList(0);
  private static Map<Object, Object> XU = new HashMap();
  private static cc.a XV = R(XR);
  
  public static String P(Object paramObject)
  {
    if (paramObject == null) {
      return XR;
    }
    return paramObject.toString();
  }
  
  public static Boolean Q(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return bt(P(paramObject));
  }
  
  public static cc.a R(Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new cc.a();
    if ((paramObject instanceof cc.a)) {
      return (cc.a)paramObject;
    }
    if ((paramObject instanceof String))
    {
      ((cc.a)localObject1).type = 1;
      ((cc.a)localObject1).Fy = ((String)paramObject);
    }
    for (;;)
    {
      ((cc.a)localObject1).FI = bool;
      return (cc.a)localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramObject instanceof List))
      {
        ((cc.a)localObject1).type = 2;
        localObject2 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = R(((Iterator)localObject2).next());
          if (localObject3 == XV) {
            return XV;
          }
          if ((bool) || (((cc.a)localObject3).FI)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        ((cc.a)localObject1).Fz = ((cc.a[])((List)paramObject).toArray(new cc.a[0]));
      }
      else if ((paramObject instanceof Map))
      {
        ((cc.a)localObject1).type = 3;
        localObject3 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject3).size());
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        bool = false;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
          cc.a locala = R(((Map.Entry)localObject4).getKey());
          localObject4 = R(((Map.Entry)localObject4).getValue());
          if ((locala == XV) || (localObject4 == XV)) {
            return XV;
          }
          if ((bool) || (locala.FI) || (((cc.a)localObject4).FI)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(locala);
            ((List)localObject2).add(localObject4);
            break;
          }
        }
        ((cc.a)localObject1).FA = ((cc.a[])((List)paramObject).toArray(new cc.a[0]));
        ((cc.a)localObject1).FB = ((cc.a[])((List)localObject2).toArray(new cc.a[0]));
      }
      else if (S(paramObject))
      {
        ((cc.a)localObject1).type = 1;
        ((cc.a)localObject1).Fy = paramObject.toString();
      }
      else if (T(paramObject))
      {
        ((cc.a)localObject1).type = 6;
        ((cc.a)localObject1).FE = U(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((cc.a)localObject1).type = 8;
        ((cc.a)localObject1).FF = ((Boolean)paramObject).booleanValue();
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      j.Z((String)paramObject);
      return XV;
    }
  }
  
  private static boolean S(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof dh)) && (((dh)paramObject).ws()));
  }
  
  private static boolean T(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof dh)) && (((dh)paramObject).wt()));
  }
  
  private static long U(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    j.Z("getInt64 received non-Number");
    return 0L;
  }
  
  private static Boolean bt(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return XS;
  }
  
  public static String e(cc.a parama)
  {
    return P(g(parama));
  }
  
  public static Boolean f(cc.a parama)
  {
    return Q(g(parama));
  }
  
  public static Object g(cc.a parama)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (parama == null) {
      return XN;
    }
    Object localObject1;
    Object localObject2;
    switch (parama.type)
    {
    default: 
      j.Z("Failed to convert a value of type: " + parama.type);
      return XN;
    case 1: 
      return parama.Fy;
    case 2: 
      localObject1 = new ArrayList(parama.Fz.length);
      parama = parama.Fz;
      j = parama.length;
      while (i < j)
      {
        localObject2 = g(parama[i]);
        if (localObject2 == XN) {
          return XN;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 3: 
      if (parama.FA.length != parama.FB.length)
      {
        j.Z("Converting an invalid value to object: " + parama.toString());
        return XN;
      }
      localObject1 = new HashMap(parama.FB.length);
      i = k;
      while (i < parama.FA.length)
      {
        localObject2 = g(parama.FA[i]);
        Object localObject3 = g(parama.FB[i]);
        if ((localObject2 == XN) || (localObject3 == XN)) {
          return XN;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      j.Z("Trying to convert a macro reference to object");
      return XN;
    case 5: 
      j.Z("Trying to convert a function id to object");
      return XN;
    case 6: 
      return Long.valueOf(parama.FE);
    case 7: 
      localObject1 = new StringBuffer();
      parama = parama.FG;
      k = parama.length;
      i = j;
      while (i < k)
      {
        localObject2 = e(parama[i]);
        if (localObject2 == XR) {
          return XN;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(parama.FF);
  }
  
  public static cc.a wx()
  {
    return XV;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */