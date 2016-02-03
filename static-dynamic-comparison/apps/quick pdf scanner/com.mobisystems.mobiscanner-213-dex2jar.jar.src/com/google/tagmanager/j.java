package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class j
{
  private static final Object aiS = null;
  private static Long aiT = new Long(0L);
  private static Double aiU = new Double(0.0D);
  private static TypedNumber aiV = TypedNumber.D(0L);
  private static String aiW = new String("");
  private static Boolean aiX = new Boolean(false);
  private static List<Object> aiY = new ArrayList(0);
  private static Map<Object, Object> aiZ = new HashMap();
  private static TypeSystem.Value aja = ap(aiW);
  
  public static TypeSystem.Value AD()
  {
    return aja;
  }
  
  public static TypeSystem.Value ap(Object paramObject)
  {
    int i = 0;
    Object localObject1 = TypeSystem.Value.iU();
    if ((paramObject instanceof TypeSystem.Value)) {
      return (TypeSystem.Value)paramObject;
    }
    if ((paramObject instanceof String)) {
      ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hA).m((String)paramObject);
    }
    for (;;)
    {
      if (i != 0) {
        ((TypeSystem.Value.a)localObject1).l(true);
      }
      return ((TypeSystem.Value.a)localObject1).iZ();
      TypeSystem.Value localValue;
      if ((paramObject instanceof List))
      {
        ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hB);
        paramObject = ((List)paramObject).iterator();
        i = 0;
        if (((Iterator)paramObject).hasNext())
        {
          localValue = ap(((Iterator)paramObject).next());
          if (localValue == aja) {
            return aja;
          }
          if ((i != 0) || (localValue.iT())) {}
          for (i = 1;; i = 0)
          {
            ((TypeSystem.Value.a)localObject1).l(localValue);
            break;
          }
        }
      }
      else if ((paramObject instanceof Map))
      {
        ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hC);
        paramObject = ((Map)paramObject).entrySet().iterator();
        i = 0;
        if (((Iterator)paramObject).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)paramObject).next();
          localValue = ap(((Map.Entry)localObject2).getKey());
          localObject2 = ap(((Map.Entry)localObject2).getValue());
          if ((localValue == aja) || (localObject2 == aja)) {
            return aja;
          }
          if ((i != 0) || (localValue.iT()) || (((TypeSystem.Value)localObject2).iT())) {}
          for (i = 1;; i = 0)
          {
            ((TypeSystem.Value.a)localObject1).m(localValue);
            ((TypeSystem.Value.a)localObject1).n((TypeSystem.Value)localObject2);
            break;
          }
        }
      }
      else if (aq(paramObject))
      {
        ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hA).m(paramObject.toString());
      }
      else if (ar(paramObject))
      {
        ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hF).a(as(paramObject));
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((TypeSystem.Value.a)localObject1).a(TypeSystem.Value.Type.hH).k(((Boolean)paramObject).booleanValue());
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      f.A((String)paramObject);
      return aja;
    }
  }
  
  private static boolean aq(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof TypedNumber)) && (((TypedNumber)paramObject).Ay()));
  }
  
  private static boolean ar(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof TypedNumber)) && (((TypedNumber)paramObject).Az()));
  }
  
  private static long as(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    f.A("getInt64 received non-Number");
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */