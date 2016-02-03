package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class l
{
  private static final Map<Field, l> adc = new WeakHashMap();
  private final boolean adN;
  private final Field adO;
  private final String name;
  
  l(Field paramField, String paramString)
  {
    this.adO = paramField;
    if (paramString == null) {}
    for (paramField = null;; paramField = paramString.intern())
    {
      this.name = paramField;
      this.adN = i.a(getType());
      return;
    }
  }
  
  /* Error */
  public static l a(Enum<?> paramEnum)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   6: aload_0
    //   7: invokevirtual 57	java/lang/Enum:name	()Ljava/lang/String;
    //   10: invokevirtual 63	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   13: invokestatic 66	com/google/api/client/util/l:a	(Ljava/lang/reflect/Field;)Lcom/google/api/client/util/l;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +19 -> 37
    //   21: iload_1
    //   22: ldc 68
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: aastore
    //   32: invokestatic 74	com/google/api/client/util/x:b	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_2
    //   36: areturn
    //   37: iconst_0
    //   38: istore_1
    //   39: goto -18 -> 21
    //   42: astore_0
    //   43: new 76	java/lang/RuntimeException
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 79	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramEnum	Enum<?>
    //   1	38	1	bool	boolean
    //   16	20	2	locall	l
    // Exception table:
    //   from	to	target	type
    //   2	17	42	java/lang/NoSuchFieldException
    //   21	35	42	java/lang/NoSuchFieldException
  }
  
  public static l a(Field paramField)
  {
    if (paramField == null) {
      return null;
    }
    for (;;)
    {
      Object localObject;
      synchronized (adc)
      {
        localObject = (l)adc.get(paramField);
        boolean bool = paramField.isEnumConstant();
        if ((localObject != null) || ((!bool) && (Modifier.isStatic(paramField.getModifiers())))) {
          break label176;
        }
        if (!bool) {
          break label140;
        }
        localObject = (af)paramField.getAnnotation(af.class);
        if (localObject != null)
        {
          localObject = ((af)localObject).yS();
          if (!"##default".equals(localObject)) {
            break label173;
          }
          localObject = paramField.getName();
          localObject = new l(paramField, (String)localObject);
          adc.put(paramField, localObject);
          paramField = (Field)localObject;
          return paramField;
        }
      }
      if ((u)paramField.getAnnotation(u.class) != null)
      {
        localObject = null;
      }
      else
      {
        return null;
        label140:
        localObject = (o)paramField.getAnnotation(o.class);
        if (localObject == null) {
          return null;
        }
        localObject = ((o)localObject).yS();
        paramField.setAccessible(true);
        continue;
        label173:
        continue;
        label176:
        paramField = (Field)localObject;
      }
    }
  }
  
  public static Object a(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public static void a(Field paramField, Object paramObject1, Object paramObject2)
  {
    if (Modifier.isFinal(paramField.getModifiers()))
    {
      Object localObject = a(paramField, paramObject1);
      if (paramObject2 == null)
      {
        if (localObject == null) {}
      }
      else {
        while (!paramObject2.equals(localObject)) {
          throw new IllegalArgumentException("expected final value <" + localObject + "> but was <" + paramObject2 + "> on " + paramField.getName() + " field in " + paramObject1.getClass().getName());
        }
      }
      return;
    }
    try
    {
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (SecurityException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public Object aj(Object paramObject)
  {
    return a(this.adO, paramObject);
  }
  
  public Type getGenericType()
  {
    return this.adO.getGenericType();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Class<?> getType()
  {
    return this.adO.getType();
  }
  
  public boolean isPrimitive()
  {
    return this.adN;
  }
  
  public void j(Object paramObject1, Object paramObject2)
  {
    a(this.adO, paramObject1, paramObject2);
  }
  
  public Field yP()
  {
    return this.adO;
  }
  
  public boolean yQ()
  {
    return Modifier.isFinal(this.adO.getModifiers());
  }
  
  public <T extends Enum<T>> T yR()
  {
    return Enum.valueOf(this.adO.getDeclaringClass(), this.adO.getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */