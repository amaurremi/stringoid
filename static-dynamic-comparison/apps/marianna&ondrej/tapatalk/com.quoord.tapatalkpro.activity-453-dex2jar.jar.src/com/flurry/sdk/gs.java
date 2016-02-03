package com.flurry.sdk;

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

public class gs
        extends ft {
    private static final gs a = new gs();
    private static final Class<?>[] c = new Class[0];
    private static final Class<?>[] d = {fn.class};
    private static final Map<Class, Constructor> e = new ConcurrentHashMap();
    private static final Class g = new Object() {
    }.getClass();
    private static final fn h = fn.a(fn.v.n);
    private final ClassLoader b;
    private Map<String, Class> f = new ConcurrentHashMap();
    private final WeakHashMap<Type, fn> i = new WeakHashMap();

    protected gs() {
        this(gs.class.getClassLoader());
    }

    public gs(ClassLoader paramClassLoader) {
        this.b = paramClassLoader;
    }

    /* Error */
    public static Object a(Class paramClass, fn paramfn) {
        // Byte code:
        //   0: ldc 10
        //   2: aload_0
        //   3: invokevirtual 95	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
        //   6: istore_2
        //   7: getstatic 50	com/flurry/sdk/gs:e	Ljava/util/Map;
        //   10: aload_0
        //   11: invokeinterface 101 2 0
        //   16: checkcast 103	java/lang/reflect/Constructor
        //   19: astore 4
        //   21: aload 4
        //   23: astore_3
        //   24: aload 4
        //   26: ifnonnull +33 -> 59
        //   29: iload_2
        //   30: ifeq +48 -> 78
        //   33: getstatic 45	com/flurry/sdk/gs:d	[Ljava/lang/Class;
        //   36: astore_3
        //   37: aload_0
        //   38: aload_3
        //   39: invokevirtual 107	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   42: astore_3
        //   43: aload_3
        //   44: iconst_1
        //   45: invokevirtual 111	java/lang/reflect/Constructor:setAccessible	(Z)V
        //   48: getstatic 50	com/flurry/sdk/gs:e	Ljava/util/Map;
        //   51: aload_0
        //   52: aload_3
        //   53: invokeinterface 115 3 0
        //   58: pop
        //   59: iload_2
        //   60: ifeq +25 -> 85
        //   63: iconst_1
        //   64: anewarray 53	java/lang/Object
        //   67: astore_0
        //   68: aload_0
        //   69: iconst_0
        //   70: aload_1
        //   71: aastore
        //   72: aload_3
        //   73: aload_0
        //   74: invokevirtual 119	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
        //   77: areturn
        //   78: getstatic 41	com/flurry/sdk/gs:c	[Ljava/lang/Class;
        //   81: astore_3
        //   82: goto -45 -> 37
        //   85: aconst_null
        //   86: checkcast 121	[Ljava/lang/Object;
        //   89: astore_0
        //   90: goto -18 -> 72
        //   93: astore_0
        //   94: new 123	java/lang/RuntimeException
        //   97: dup
        //   98: aload_0
        //   99: invokespecial 126	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	paramClass	Class
        //   0	103	1	paramfn	fn
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

    public static gs b() {
        return a;
    }

    public static String c(fn paramfn) {
        String str1 = paramfn.f();
        String str2 = paramfn.d();
        if ((str1 == null) || ("".equals(str1))) {
            return str2;
        }
        if (str1.endsWith("$")) {
        }
        for (paramfn = ""; ; paramfn = ".") {
            return str1 + paramfn + str2;
        }
    }

    protected int a(Object paramObject1, Object paramObject2, fn paramfn, boolean paramBoolean) {
        switch (2. a[paramfn.a().ordinal()])
        {
        }
        do {
            return super.a(paramObject1, paramObject2, paramfn, paramBoolean);
        } while (!(paramObject1 instanceof Enum));
        return ((Enum) paramObject1).ordinal() - ((Enum) paramObject2).ordinal();
    }

    public fn a(Type paramType) {
        fn localfn2 = (fn) this.i.get(paramType);
        fn localfn1 = localfn2;
        if (localfn2 == null) {
            localfn1 = a(paramType, new LinkedHashMap());
            this.i.put(paramType, localfn1);
        }
        return localfn1;
    }

    protected fn a(Type paramType, Map<String, fn> paramMap) {
        if (((paramType instanceof Class)) && (CharSequence.class.isAssignableFrom((Class) paramType))) {
            return fn.a(fn.v.g);
        }
        if (paramType == ByteBuffer.class) {
            return fn.a(fn.v.h);
        }
        if ((paramType == Integer.class) || (paramType == Integer.TYPE)) {
            return fn.a(fn.v.i);
        }
        if ((paramType == Long.class) || (paramType == Long.TYPE)) {
            return fn.a(fn.v.j);
        }
        if ((paramType == Float.class) || (paramType == Float.TYPE)) {
            return fn.a(fn.v.k);
        }
        if ((paramType == Double.class) || (paramType == Double.TYPE)) {
            return fn.a(fn.v.l);
        }
        if ((paramType == Boolean.class) || (paramType == Boolean.TYPE)) {
            return fn.a(fn.v.m);
        }
        if ((paramType == Void.class) || (paramType == Void.TYPE)) {
            return fn.a(fn.v.n);
        }
        Object localObject2;
        Object localObject1;
        if ((paramType instanceof ParameterizedType)) {
            localObject2 = (ParameterizedType) paramType;
            localObject1 = (Class) ((ParameterizedType) localObject2).getRawType();
            localObject2 = ((ParameterizedType) localObject2).getActualTypeArguments();
            if (Collection.class.isAssignableFrom((Class) localObject1)) {
                if (localObject2.length != 1) {
                    throw new fl("No array type specified.");
                }
                return fn.a(a(localObject2[0], paramMap));
            }
            if (Map.class.isAssignableFrom((Class) localObject1)) {
                localObject1 = localObject2[0];
                localObject2 = localObject2[1];
                if ((!(paramType instanceof Class)) || (!CharSequence.class.isAssignableFrom((Class) paramType))) {
                    throw new fl("Map key class not CharSequence: " + localObject1);
                }
                return fn.b(a((Type) localObject2, paramMap));
            }
            return a((Type) localObject1, paramMap);
        }
        if ((paramType instanceof Class)) {
            localObject2 = (Class) paramType;
            String str = ((Class) localObject2).getName();
            localObject1 = (fn) paramMap.get(str);
            paramType = (Type) localObject1;
            if (localObject1 == null) {
            }
            try {
                localObject1 = (fn) ((Class) localObject2).getDeclaredField("SCHEMA$").get(null);
                paramType = (Type) localObject1;
                if (!str.equals(c((fn) localObject1))) {
                    paramType = fn.f(((fn) localObject1).toString().replace(((fn) localObject1).f(), ((Class) localObject2).getPackage().getName()));
                }
                paramMap.put(str, paramType);
                return paramType;
            } catch (NoSuchFieldException paramType) {
                throw new fk("Not a Specific class: " + localObject2);
            } catch (IllegalAccessException paramType) {
                throw new fk(paramType);
            }
        }
        throw new fl("Unknown type: " + paramType);
    }

    public ge a(fn paramfn) {
        return new gt(paramfn, paramfn, this);
    }

    public Class b(fn paramfn) {
        switch (2. a[paramfn.a().ordinal()])
        {
            default:
                throw new fk("Unknown type: " + paramfn);
            case 1:
            case 2:
            case 3:
                String str = paramfn.g();
                if (str == null) {
                    return null;
                }
                Class localClass2 = (Class) this.f.get(str);
                Class localClass1 = localClass2;
                if (localClass2 == null) {
                }
                try {
                    localClass1 = this.b.loadClass(c(paramfn));
                    this.f.put(str, localClass1);
                    paramfn = localClass1;
                    if (localClass1 == g) {
                        paramfn = null;
                    }
                    return paramfn;
                } catch (ClassNotFoundException paramfn) {
                    for (; ; ) {
                        localClass1 = g;
                    }
                }
            case 4:
                return List.class;
            case 5:
                return Map.class;
            case 6:
                paramfn = paramfn.k();
                if ((paramfn.size() == 2) && (paramfn.contains(h))) {
                    if (((fn) paramfn.get(0)).equals(h)) {
                    }
                    for (int j = 1; ; j = 0) {
                        return b((fn) paramfn.get(j));
                    }
                }
                return Object.class;
            case 7:
                if ("String".equals(paramfn.a("avro.java.string"))) {
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

    public Object c(Object paramObject, fn paramfn) {
        Class localClass = b().b(paramfn);
        Object localObject;
        if (localClass == null) {
            localObject = super.c(paramObject, paramfn);
        }
        do {
            return localObject;
            localObject = paramObject;
        } while (localClass.isInstance(paramObject));
        return a(localClass, paramfn);
    }

    public Object d(Object paramObject, fn paramfn) {
        Class localClass = b().b(paramfn);
        Object localObject;
        if (localClass == null) {
            localObject = super.d(paramObject, paramfn);
        }
        do {
            return localObject;
            localObject = paramObject;
        } while (localClass.isInstance(paramObject));
        return a(localClass, paramfn);
    }

    protected boolean f(Object paramObject) {
        return ((paramObject instanceof Enum)) || (super.f(paramObject));
    }

    protected fn g(Object paramObject) {
        if ((paramObject instanceof Enum)) {
            return a(paramObject.getClass());
        }
        return super.g(paramObject);
    }

    public static abstract interface a {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */