package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class nn
  extends kq
{
  private static final nn a = new nn();
  private static final Class<?>[] c = new Class[0];
  private static final Class<?>[] d = { ji.class };
  private static final Map<Class, Constructor> e = new ConcurrentHashMap();
  private static final Class g = new no().getClass();
  private static final ji h = ji.a(kj.n);
  private final ClassLoader b;
  private Map<String, Class> f = new ConcurrentHashMap();
  private final WeakHashMap<Type, ji> i = new WeakHashMap();
  
  protected nn()
  {
    this(nn.class.getClassLoader());
  }
  
  public nn(ClassLoader paramClassLoader)
  {
    this.b = paramClassLoader;
  }
  
  /* Error */
  public static Object a(Class paramClass, ji paramji)
  {
    // Byte code:
    //   0: ldc 89
    //   2: aload_0
    //   3: invokevirtual 93	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   6: istore_2
    //   7: getstatic 44	com/flurry/android/monolithic/sdk/impl/nn:e	Ljava/util/Map;
    //   10: aload_0
    //   11: invokeinterface 99 2 0
    //   16: checkcast 101	java/lang/reflect/Constructor
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: ifnonnull +33 -> 59
    //   29: iload_2
    //   30: ifeq +48 -> 78
    //   33: getstatic 39	com/flurry/android/monolithic/sdk/impl/nn:d	[Ljava/lang/Class;
    //   36: astore_3
    //   37: aload_0
    //   38: aload_3
    //   39: invokevirtual 105	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   42: astore_3
    //   43: aload_3
    //   44: iconst_1
    //   45: invokevirtual 109	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   48: getstatic 44	com/flurry/android/monolithic/sdk/impl/nn:e	Ljava/util/Map;
    //   51: aload_0
    //   52: aload_3
    //   53: invokeinterface 113 3 0
    //   58: pop
    //   59: iload_2
    //   60: ifeq +25 -> 85
    //   63: iconst_1
    //   64: anewarray 49	java/lang/Object
    //   67: astore_0
    //   68: aload_0
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 117	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   77: areturn
    //   78: getstatic 35	com/flurry/android/monolithic/sdk/impl/nn:c	[Ljava/lang/Class;
    //   81: astore_3
    //   82: goto -45 -> 37
    //   85: aconst_null
    //   86: checkcast 119	[Ljava/lang/Object;
    //   89: astore_0
    //   90: goto -18 -> 72
    //   93: astore_0
    //   94: new 121	java/lang/RuntimeException
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 124	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramClass	Class
    //   0	103	1	paramji	ji
    //   6	54	2	bool	boolean
    //   23	59	3	localObject	Object
    //   19	6	4	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   7	21	93	java/lang/Exception
    //   33	37	93	java/lang/Exception
    //   37	59	93	java/lang/Exception
    //   63	68	93	java/lang/Exception
    //   72	78	93	java/lang/Exception
    //   78	82	93	java/lang/Exception
    //   85	90	93	java/lang/Exception
  }
  
  public static nn b()
  {
    return a;
  }
  
  public static String c(ji paramji)
  {
    String str1 = paramji.f();
    String str2 = paramji.d();
    if ((str1 == null) || ("".equals(str1))) {
      return str2;
    }
    if (str1.endsWith("$")) {}
    for (paramji = "";; paramji = ".") {
      return str1 + paramji + str2;
    }
  }
  
  protected int a(Object paramObject1, Object paramObject2, ji paramji, boolean paramBoolean)
  {
    switch (np.a[paramji.a().ordinal()])
    {
    }
    do
    {
      return super.a(paramObject1, paramObject2, paramji, paramBoolean);
    } while (!(paramObject1 instanceof Enum));
    return ((Enum)paramObject1).ordinal() - ((Enum)paramObject2).ordinal();
  }
  
  public ji a(Type paramType)
  {
    ji localji2 = (ji)this.i.get(paramType);
    ji localji1 = localji2;
    if (localji2 == null)
    {
      localji1 = a(paramType, new LinkedHashMap());
      this.i.put(paramType, localji1);
    }
    return localji1;
  }
  
  protected ji a(Type paramType, Map<String, ji> paramMap)
  {
    if (((paramType instanceof Class)) && (CharSequence.class.isAssignableFrom((Class)paramType))) {
      return ji.a(kj.g);
    }
    if (paramType == ByteBuffer.class) {
      return ji.a(kj.h);
    }
    if ((paramType == Integer.class) || (paramType == Integer.TYPE)) {
      return ji.a(kj.i);
    }
    if ((paramType == Long.class) || (paramType == Long.TYPE)) {
      return ji.a(kj.j);
    }
    if ((paramType == Float.class) || (paramType == Float.TYPE)) {
      return ji.a(kj.k);
    }
    if ((paramType == Double.class) || (paramType == Double.TYPE)) {
      return ji.a(kj.l);
    }
    if ((paramType == Boolean.class) || (paramType == Boolean.TYPE)) {
      return ji.a(kj.m);
    }
    if ((paramType == Void.class) || (paramType == Void.TYPE)) {
      return ji.a(kj.n);
    }
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof ParameterizedType))
    {
      localObject2 = (ParameterizedType)paramType;
      localObject1 = (Class)((ParameterizedType)localObject2).getRawType();
      localObject2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      if (Collection.class.isAssignableFrom((Class)localObject1))
      {
        if (localObject2.length != 1) {
          throw new jh("No array type specified.");
        }
        return ji.a(a(localObject2[0], paramMap));
      }
      if (Map.class.isAssignableFrom((Class)localObject1))
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if ((!(paramType instanceof Class)) || (!CharSequence.class.isAssignableFrom((Class)paramType))) {
          throw new jh("Map key class not CharSequence: " + localObject1);
        }
        return ji.b(a((Type)localObject2, paramMap));
      }
      return a((Type)localObject1, paramMap);
    }
    if ((paramType instanceof Class))
    {
      localObject2 = (Class)paramType;
      String str = ((Class)localObject2).getName();
      localObject1 = (ji)paramMap.get(str);
      paramType = (Type)localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject1 = (ji)((Class)localObject2).getDeclaredField("SCHEMA$").get(null);
        paramType = (Type)localObject1;
        if (!str.equals(c((ji)localObject1))) {
          paramType = ji.f(((ji)localObject1).toString().replace(((ji)localObject1).f(), ((Class)localObject2).getPackage().getName()));
        }
        paramMap.put(str, paramType);
        return paramType;
      }
      catch (NoSuchFieldException paramType)
      {
        throw new jg("Not a Specific class: " + localObject2);
      }
      catch (IllegalAccessException paramType)
      {
        throw new jg(paramType);
      }
    }
    throw new jh("Unknown type: " + paramType);
  }
  
  public lw a(ji paramji)
  {
    return new nr(paramji, paramji, this);
  }
  
  public Class b(ji paramji)
  {
    switch (np.a[paramji.a().ordinal()])
    {
    default: 
      throw new jg("Unknown type: " + paramji);
    case 1: 
    case 2: 
    case 3: 
      String str = paramji.g();
      if (str == null) {
        return null;
      }
      Class localClass2 = (Class)this.f.get(str);
      Class localClass1 = localClass2;
      if (localClass2 == null) {}
      try
      {
        localClass1 = this.b.loadClass(c(paramji));
        this.f.put(str, localClass1);
        paramji = localClass1;
        if (localClass1 == g) {
          paramji = null;
        }
        return paramji;
      }
      catch (ClassNotFoundException paramji)
      {
        for (;;)
        {
          localClass1 = g;
        }
      }
    case 4: 
      return List.class;
    case 5: 
      return Map.class;
    case 6: 
      paramji = paramji.k();
      if ((paramji.size() == 2) && (paramji.contains(h)))
      {
        if (((ji)paramji.get(0)).equals(h)) {}
        for (int j = 1;; j = 0) {
          return b((ji)paramji.get(j));
        }
      }
      return Object.class;
    case 7: 
      if ("String".equals(paramji.a("avro.java.string"))) {
        return String.class;
      }
      return CharSequence.class;
    case 8: 
      return ByteBuffer.class;
    case 9: 
      return Integer.TYPE;
    case 10: 
      return Long.TYPE;
    case 11: 
      return Float.TYPE;
    case 12: 
      return Double.TYPE;
    case 13: 
      return Boolean.TYPE;
    }
    return Void.TYPE;
  }
  
  public Object c(Object paramObject, ji paramji)
  {
    Class localClass = b().b(paramji);
    Object localObject;
    if (localClass == null) {
      localObject = super.c(paramObject, paramji);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (localClass.isInstance(paramObject));
    return a(localClass, paramji);
  }
  
  public Object d(Object paramObject, ji paramji)
  {
    Class localClass = b().b(paramji);
    Object localObject;
    if (localClass == null) {
      localObject = super.d(paramObject, paramji);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (localClass.isInstance(paramObject));
    return a(localClass, paramji);
  }
  
  protected boolean f(Object paramObject)
  {
    return ((paramObject instanceof Enum)) || (super.f(paramObject));
  }
  
  protected ji g(Object paramObject)
  {
    if ((paramObject instanceof Enum)) {
      return a(paramObject.getClass());
    }
    return super.g(paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */