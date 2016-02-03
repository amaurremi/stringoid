package org.b.d;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.b.d.a.o;
import org.b.d.a.p;
import org.b.e.ae;

public class al {
    Map<Type, aj<Type>> a;
    private al b = null;
    private p c;
    private Map<Type, v> d;

    private al() {
        this.b = null;
        this.c = a();
        this.d = new HashMap();
        this.a = new HashMap();
        c();
        this.a = Collections.unmodifiableMap(this.a);
    }

    public al(al paramal) {
        if (paramal != null) {
        }
        for (this.b = paramal; ; this.b = new al()) {
            this.c = a();
            this.a = new HashMap();
            this.d = new HashMap();
            b();
            return;
        }
    }

    private <T> aj<T> a(Class<T> paramClass) {
        aj localaj = null;
        o localo = this.c.a(paramClass, true);
        if (localo != null) {
            localaj = this.c.a().b(paramClass);
            if (localaj != null) {
                a(paramClass, localaj);
            }
        } else {
            return localaj;
        }
        return a(localo, paramClass, true, null);
    }

    private aj a(GenericArrayType paramGenericArrayType) {
        Object localObject1 = "" + paramGenericArrayType;
        int j = ((String) localObject1).split("\\[").length - 1;
        if (j <= 0) {
            throw new org.b.c(String.format("fatal error: type=", new Object[]{localObject1}));
        }
        if (j > 1) {
            throw new UnsupportedOperationException(String.format("Not implemented template generation of %s", new Object[]{localObject1}));
        }
        paramGenericArrayType = "" + paramGenericArrayType.getGenericComponentType();
        boolean bool = a(paramGenericArrayType);
        localObject1 = new StringBuffer();
        int i = 0;
        while (i < j) {
            ((StringBuffer) localObject1).append('[');
            i += 1;
        }
        if (!bool) {
            ((StringBuffer) localObject1).append('L');
            ((StringBuffer) localObject1).append(b(paramGenericArrayType));
            ((StringBuffer) localObject1).append(';');
        }
        for (; ; ) {
            paramGenericArrayType = ((StringBuffer) localObject1).toString();
            try {
                localObject1 = Thread.currentThread().getContextClassLoader();
                if (localObject1 == null) {
                    break;
                }
                localObject1 = ((ClassLoader) localObject1).loadClass(paramGenericArrayType);
                if (localObject1 == null) {
                    break;
                }
                localObject1 = a((Class) localObject1);
                return (aj) localObject1;
            } catch (ClassNotFoundException localClassNotFoundException1) {
                try {
                    Object localObject2 = getClass().getClassLoader();
                    if (localObject2 == null) {
                        break label276;
                    }
                    localObject2 = ((ClassLoader) localObject2).loadClass(paramGenericArrayType);
                    if (localObject2 == null) {
                        break label276;
                    }
                    localObject2 = a((Class) localObject2);
                    return (aj) localObject2;
                } catch (ClassNotFoundException localClassNotFoundException2) {
                    try {
                        Object localObject3 = Class.forName(paramGenericArrayType);
                        if (localObject3 == null) {
                            break label300;
                        }
                        localObject3 = a((Class) localObject3);
                        return (aj) localObject3;
                    } catch (ClassNotFoundException localClassNotFoundException3) {
                        throw new org.b.c(String.format("cannot find template of %s", new Object[]{paramGenericArrayType}));
                    }
                }
            }
            ((StringBuffer) localObject1).append(c(paramGenericArrayType));
        }
    }

    private aj<Type> a(ParameterizedType paramParameterizedType) {
        Object localObject = b(paramParameterizedType);
        if (localObject != null) {
        }
        do {
            do {
                for (; ; ) {
                    return (aj<Type>) localObject;
                    try {
                        localaj = this.b.b(paramParameterizedType);
                        localObject = localaj;
                        if (localaj != null) {
                        }
                    } catch (NullPointerException localNullPointerException) {
                        aj localaj;
                        for (; ; ) {
                        }
                    }
                }
                localaj = c(paramParameterizedType);
                localObject = localaj;
            } while (localaj != null);
            paramParameterizedType = d(paramParameterizedType);
            localObject = paramParameterizedType;
        } while (paramParameterizedType != null);
        return null;
    }

    private aj a(ParameterizedType paramParameterizedType, Type paramType) {
        paramType = (v) this.d.get(paramType);
        if (paramType == null) {
            return null;
        }
        paramParameterizedType = paramParameterizedType.getActualTypeArguments();
        aj[] arrayOfaj = new aj[paramParameterizedType.length];
        int i = 0;
        while (i < paramParameterizedType.length) {
            arrayOfaj[i] = a(paramParameterizedType[i]);
            i += 1;
        }
        return paramType.a(arrayOfaj);
    }

    /* Error */
    private aj a(o paramo, Class paramClass, boolean paramBoolean, o paramo1) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 9
        //   3: aload_0
        //   4: monitorenter
        //   5: aload_0
        //   6: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   9: aload_2
        //   10: invokeinterface 203 2 0
        //   15: ifeq +246 -> 261
        //   18: aload_0
        //   19: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   22: aload_2
        //   23: invokeinterface 182 2 0
        //   28: checkcast 192	org/b/d/aj
        //   31: astore 5
        //   33: new 205	org/b/d/ak
        //   36: dup
        //   37: aload_0
        //   38: aload_2
        //   39: invokespecial 208	org/b/d/ak:<init>	(Lorg/b/d/al;Ljava/lang/reflect/Type;)V
        //   42: astore 7
        //   44: aload 7
        //   46: astore 6
        //   48: aload_0
        //   49: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   52: aload_2
        //   53: aload 7
        //   55: invokeinterface 212 3 0
        //   60: pop
        //   61: aload_1
        //   62: astore 8
        //   64: aload_1
        //   65: ifnonnull +18 -> 83
        //   68: aload 7
        //   70: astore 6
        //   72: aload_0
        //   73: getfield 24	org/b/d/al:c	Lorg/b/d/a/p;
        //   76: aload_2
        //   77: iload_3
        //   78: invokevirtual 50	org/b/d/a/p:a	(Ljava/lang/reflect/Type;Z)Lorg/b/d/a/o;
        //   81: astore 8
        //   83: aload 4
        //   85: ifnull +38 -> 123
        //   88: aload 7
        //   90: astore 6
        //   92: aload 8
        //   94: aload_2
        //   95: aload 4
        //   97: invokeinterface 215 3 0
        //   102: astore_1
        //   103: aload_1
        //   104: ifnull +15 -> 119
        //   107: aload_0
        //   108: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   111: aload_2
        //   112: aload_1
        //   113: invokeinterface 212 3 0
        //   118: pop
        //   119: aload_0
        //   120: monitorexit
        //   121: aload_1
        //   122: areturn
        //   123: aload 7
        //   125: astore 6
        //   127: aload 8
        //   129: aload_2
        //   130: invokeinterface 216 2 0
        //   135: astore_1
        //   136: goto -33 -> 103
        //   139: astore 4
        //   141: aconst_null
        //   142: astore 5
        //   144: aconst_null
        //   145: astore_1
        //   146: aload 5
        //   148: ifnull +63 -> 211
        //   151: aload_1
        //   152: astore 6
        //   154: aload_0
        //   155: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   158: aload_2
        //   159: aload 5
        //   161: invokeinterface 212 3 0
        //   166: pop
        //   167: aload 4
        //   169: instanceof 95
        //   172: ifeq +64 -> 236
        //   175: aload 4
        //   177: checkcast 95	org/b/c
        //   180: athrow
        //   181: astore_1
        //   182: aload 9
        //   184: astore 4
        //   186: aload 4
        //   188: ifnull +16 -> 204
        //   191: aload_0
        //   192: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   195: aload_2
        //   196: aload 4
        //   198: invokeinterface 212 3 0
        //   203: pop
        //   204: aload_1
        //   205: athrow
        //   206: astore_1
        //   207: aload_0
        //   208: monitorexit
        //   209: aload_1
        //   210: athrow
        //   211: aload_1
        //   212: astore 6
        //   214: aload_0
        //   215: getfield 31	org/b/d/al:a	Ljava/util/Map;
        //   218: aload_2
        //   219: invokeinterface 219 2 0
        //   224: pop
        //   225: goto -58 -> 167
        //   228: astore_1
        //   229: aload 6
        //   231: astore 4
        //   233: goto -47 -> 186
        //   236: new 95	org/b/c
        //   239: dup
        //   240: aload 4
        //   242: invokespecial 222	org/b/c:<init>	(Ljava/lang/Throwable;)V
        //   245: athrow
        //   246: astore 4
        //   248: aconst_null
        //   249: astore_1
        //   250: goto -104 -> 146
        //   253: astore 4
        //   255: aload 7
        //   257: astore_1
        //   258: goto -112 -> 146
        //   261: aconst_null
        //   262: astore 5
        //   264: goto -231 -> 33
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	267	0	this	al
        //   0	267	1	paramo	o
        //   0	267	2	paramClass	Class
        //   0	267	3	paramBoolean	boolean
        //   0	267	4	paramo1	o
        //   31	232	5	localaj	aj
        //   46	184	6	localObject1	Object
        //   42	214	7	localak	ak
        //   62	66	8	localo	o
        //   1	182	9	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   5	33	139	java/lang/Exception
        //   5	33	181	finally
        //   33	44	181	finally
        //   167	181	181	finally
        //   236	246	181	finally
        //   107	119	206	finally
        //   191	204	206	finally
        //   204	206	206	finally
        //   48	61	228	finally
        //   72	83	228	finally
        //   92	103	228	finally
        //   127	136	228	finally
        //   154	167	228	finally
        //   214	225	228	finally
        //   33	44	246	java/lang/Exception
        //   48	61	253	java/lang/Exception
        //   72	83	253	java/lang/Exception
        //   92	103	253	java/lang/Exception
        //   127	136	253	java/lang/Exception
    }

    private static boolean a(String paramString) {
        return (paramString.equals("byte")) || (paramString.equals("short")) || (paramString.equals("int")) || (paramString.equals("long")) || (paramString.equals("float")) || (paramString.equals("double")) || (paramString.equals("boolean")) || (paramString.equals("char"));
    }

    private static String b(String paramString) {
        return paramString.substring(6);
    }

    private <T> aj<T> b(Class<T> paramClass) {
        Class[] arrayOfClass = paramClass.getInterfaces();
        int j = arrayOfClass.length;
        Object localObject1 = null;
        int i = 0;
        for (; ; ) {
            Object localObject2;
            if (i < j) {
                localObject2 = arrayOfClass[i];
                localObject1 = (aj) this.a.get(localObject2);
                if (localObject1 != null) {
                    a(paramClass, (aj) localObject1);
                }
            } else {
                return (aj<T>) localObject1;
            }
            try {
                localObject2 = this.b.c((Type) localObject2);
                localObject1 = localObject2;
                if (localObject2 != null) {
                    localObject1 = localObject2;
                    a(paramClass, (aj) localObject2);
                    return (aj<T>) localObject2;
                }
            } catch (NullPointerException localNullPointerException) {
                i += 1;
            }
        }
    }

    private aj b(ParameterizedType paramParameterizedType) {
        return a(paramParameterizedType, paramParameterizedType.getRawType());
    }

    private aj<Type> b(Type paramType) {
        if (!(paramType instanceof GenericArrayType)) {
        }
        for (; ; ) {
            return null;
            paramType = (GenericArrayType) paramType;
            aj localaj = a(paramType);
            if (localaj != null) {
                return localaj;
            }
            try {
                paramType = this.b.a(paramType);
                if (paramType != null) {
                    return paramType;
                }
            } catch (NullPointerException paramType) {
            }
        }
        return null;
    }

    private static String c(String paramString) {
        if (paramString.equals("byte")) {
            return "B";
        }
        if (paramString.equals("short")) {
            return "S";
        }
        if (paramString.equals("int")) {
            return "I";
        }
        if (paramString.equals("long")) {
            return "J";
        }
        if (paramString.equals("float")) {
            return "F";
        }
        if (paramString.equals("double")) {
            return "D";
        }
        if (paramString.equals("boolean")) {
            return "Z";
        }
        if (paramString.equals("char")) {
            return "C";
        }
        throw new org.b.c(String.format("fatal error: type=%s", new Object[]{paramString}));
    }

    private <T> aj<T> c(Class<T> paramClass) {
        Class localClass = paramClass.getSuperclass();
        Object localObject = null;
        aj localaj = null;
        if (localClass != null) {
            localObject = localaj;
        }
        for (; ; ) {
            if (localClass != Object.class) {
                localObject = (aj) this.a.get(localClass);
                if (localObject != null) {
                    a(paramClass, (aj) localObject);
                }
            } else {
                return (aj<T>) localObject;
            }
            try {
                localaj = this.b.c(localClass);
                localObject = localaj;
                if (localaj != null) {
                    localObject = localaj;
                    a(paramClass, localaj);
                    return localaj;
                }
            } catch (NullPointerException localNullPointerException) {
                localClass = localClass.getSuperclass();
            }
        }
    }

    private <T> aj<T> c(ParameterizedType paramParameterizedType) {
        Object localObject1 = paramParameterizedType.getRawType();
        try {
            arrayOfClass = ((Class) localObject1).getInterfaces();
            j = arrayOfClass.length;
            localObject1 = null;
            i = 0;
        } catch (ClassCastException paramParameterizedType) {
            try {
                Class[] arrayOfClass;
                int j;
                int i;
                Object localObject2 = a(paramParameterizedType, arrayOfClass[i]);
                localObject1 = localObject2;
                if (localObject1 != null) {
                    localObject2 = localObject1;
                    return (aj<T>) localObject2;
                }
                i += 1;
            } catch (ClassCastException paramParameterizedType) {
            }
            paramParameterizedType = paramParameterizedType;
            return null;
        }
        localObject2 = localObject1;
        if (i < j) {
        }
        return (aj<T>) localObject1;
    }

    private aj<Type> c(Type paramType) {
        aj localaj = (aj) this.a.get(paramType);
        if (localaj != null) {
            return localaj;
        }
        try {
            paramType = this.b.c(paramType);
            return paramType;
        } catch (NullPointerException paramType) {
        }
        return localaj;
    }

    private void c() {
        a(Boolean.TYPE, f.a());
        a(Boolean.class, f.a());
        a(Byte.TYPE, i.a());
        a(Byte.class, i.a());
        a(Short.TYPE, ah.a());
        a(Short.class, ah.a());
        a(Integer.TYPE, x.a());
        a(Integer.class, x.a());
        a(Long.TYPE, aa.a());
        a(Long.class, aa.a());
        a(Float.TYPE, s.a());
        a(Float.class, s.a());
        a(Double.TYPE, n.a());
        a(Double.class, n.a());
        a(BigInteger.class, d.a());
        a(Character.TYPE, j.a());
        a(Character.class, j.a());
        a(boolean[].class, e.a());
        a(short[].class, ag.a());
        a(int[].class, w.a());
        a(long[].class, z.a());
        a(float[].class, r.a());
        a(double[].class, m.a());
        a(String.class, ai.a());
        a(byte[].class, g.a());
        a(ByteBuffer.class, h.a());
        a(ae.class, am.a());
        a(BigDecimal.class, c.a());
        a(Date.class, l.a());
        b();
    }

    private <T> aj<T> d(Class<T> paramClass) {
        Class localClass = paramClass.getSuperclass();
        Object localObject = null;
        aj localaj = null;
        if (localClass != null) {
            localObject = localaj;
        }
        for (; ; ) {
            if (localClass != Object.class) {
                localObject = b(localClass);
                if (localObject != null) {
                    a(paramClass, (aj) localObject);
                }
            } else {
                return (aj<T>) localObject;
            }
            try {
                localaj = this.b.c(localClass);
                localObject = localaj;
                if (localaj != null) {
                    localObject = localaj;
                    a(paramClass, localaj);
                    return localaj;
                }
            } catch (NullPointerException localNullPointerException) {
                localClass = localClass.getSuperclass();
            }
        }
    }

    private <T> aj<T> d(ParameterizedType paramParameterizedType) {
        Object localObject1 = paramParameterizedType.getRawType();
        try {
            localClass = ((Class) localObject1).getSuperclass();
            if (localClass == null) {
                localObject2 = null;
                return (aj<T>) localObject2;
            }
        } catch (ClassCastException paramParameterizedType) {
            Class localClass;
            Object localObject2;
            label25:
            return null;
        }
        for (localObject1 = localObject2; ; localObject1 = null) {
            try {
                localClass = localClass.getSuperclass();
                localObject1 = localObject2;
                localObject2 = localObject1;
                if (localClass == Object.class) {
                    break;
                }
                localObject2 = a(paramParameterizedType, localClass);
                if (localObject2 == null) {
                    break label25;
                }
                localObject1 = localObject2;
                a(paramParameterizedType, (aj) localObject2);
                return (aj<T>) localObject2;
            } catch (ClassCastException paramParameterizedType) {
                return (aj<T>) localObject1;
            }
        }
    }

    protected p a() {
        return new p(this);
    }

    public aj a(Type paramType) {
        for (; ; ) {
            Object localObject1;
            Object localObject2;
            try {
                if (!(paramType instanceof ParameterizedType)) {
                    break label246;
                }
                localObject1 = (ParameterizedType) paramType;
                paramType = a((ParameterizedType) localObject1);
                if (paramType != null) {
                    return paramType;
                }
                localObject1 = ((ParameterizedType) localObject1).getRawType();
                localObject2 = b((Type) localObject1);
                paramType = (Type) localObject2;
                if (localObject2 != null) {
                    continue;
                }
                localObject2 = c((Type) localObject1);
                paramType = (Type) localObject2;
                if (localObject2 != null) {
                    continue;
                }
                if (((localObject1 instanceof WildcardType)) || ((localObject1 instanceof TypeVariable))) {
                    paramType = new b(this);
                    a((Type) localObject1, paramType);
                    continue;
                }
                localObject2 = (Class) localObject1;
            } finally {
            }
            if (org.b.b.class.isAssignableFrom((Class) localObject2)) {
                paramType = new ac((Class) localObject2);
                a((Type) localObject2, paramType);
            } else if (((Class) localObject2).isInterface()) {
                paramType = new b(this);
                a((Type) localObject1, paramType);
            } else {
                paramType = a((Class) localObject2);
                if (paramType == null) {
                    paramType = b((Class) localObject2);
                    if (paramType == null) {
                        paramType = c((Class) localObject2);
                        if (paramType == null) {
                            paramType = d((Class) localObject2);
                            if (paramType == null) {
                                throw new org.b.c("Cannot find template for " + localObject2 + " class.  " + "Try to add @Message annotation to the class or call MessagePack.register(Type).");
                                label246:
                                localObject1 = paramType;
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(Type paramType, aj paramaj) {
        if (paramaj == null) {
            try {
                throw new NullPointerException("Template object is null");
            } finally {
            }
        }
        if ((paramType instanceof ParameterizedType)) {
            this.a.put(((ParameterizedType) paramType).getRawType(), paramaj);
        }
        for (; ; ) {
            return;
            this.a.put(paramType, paramaj);
        }
    }

    /* Error */
    public void a(Type paramType, v paramv) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: instanceof 186
        //   6: ifeq +26 -> 32
        //   9: aload_0
        //   10: getfield 29	org/b/d/al:d	Ljava/util/Map;
        //   13: aload_1
        //   14: checkcast 186	java/lang/reflect/ParameterizedType
        //   17: invokeinterface 254 1 0
        //   22: aload_2
        //   23: invokeinterface 212 3 0
        //   28: pop
        //   29: aload_0
        //   30: monitorexit
        //   31: return
        //   32: aload_0
        //   33: getfield 29	org/b/d/al:d	Ljava/util/Map;
        //   36: aload_1
        //   37: aload_2
        //   38: invokeinterface 212 3 0
        //   43: pop
        //   44: goto -15 -> 29
        //   47: astore_1
        //   48: aload_0
        //   49: monitorexit
        //   50: aload_1
        //   51: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	52	0	this	al
        //   0	52	1	paramType	Type
        //   0	52	2	paramv	v
        // Exception table:
        //   from	to	target	type
        //   2	29	47	finally
        //   32	44	47	finally
    }

    protected void b() {
        b localb = new b(this);
        a(List.class, new y(localb));
        a(Set.class, new af(localb));
        a(Collection.class, new k(localb));
        a(Map.class, new ab(localb, localb));
        a(List.class, new t(this, y.class));
        a(Set.class, new t(this, af.class));
        a(Collection.class, new t(this, k.class));
        a(Map.class, new u(this, ab.class));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */