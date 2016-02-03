package com.flurry.sdk;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;

public abstract class og
        extends jv {
    protected static final HashMap<String, jk<?>> a = new HashMap();
    protected static final HashMap<String, Class<? extends jk<?>>> b = new HashMap();
    protected static final HashMap<String, jk<?>> c;
    protected ml d = ml.a;

    static {
        a.put(String.class.getName(), new qe());
        Object localObject1 = qg.a;
        a.put(StringBuffer.class.getName(), localObject1);
        a.put(StringBuilder.class.getName(), localObject1);
        a.put(Character.class.getName(), localObject1);
        a.put(Character.TYPE.getName(), localObject1);
        a.put(Boolean.TYPE.getName(), new os.a(true));
        a.put(Boolean.class.getName(), new os.a(false));
        localObject1 = new os.e();
        a.put(Integer.class.getName(), localObject1);
        a.put(Integer.TYPE.getName(), localObject1);
        a.put(Long.class.getName(), os.f.a);
        a.put(Long.TYPE.getName(), os.f.a);
        a.put(Byte.class.getName(), os.d.a);
        a.put(Byte.TYPE.getName(), os.d.a);
        a.put(Short.class.getName(), os.d.a);
        a.put(Short.TYPE.getName(), os.d.a);
        a.put(Float.class.getName(), os.c.a);
        a.put(Float.TYPE.getName(), os.c.a);
        a.put(Double.class.getName(), os.b.a);
        a.put(Double.TYPE.getName(), os.b.a);
        localObject1 = new os.g();
        a.put(BigInteger.class.getName(), localObject1);
        a.put(BigDecimal.class.getName(), localObject1);
        a.put(Calendar.class.getName(), pd.a);
        localObject1 = pg.a;
        a.put(java.util.Date.class.getName(), localObject1);
        a.put(Timestamp.class.getName(), localObject1);
        a.put(java.sql.Date.class.getName(), new os.h());
        a.put(Time.class.getName(), new os.i());
        localObject1 = new qa().a().iterator();
        while (((Iterator) localObject1).hasNext()) {
            Map.Entry localEntry = (Map.Entry) ((Iterator) localObject1).next();
            Object localObject2 = localEntry.getValue();
            if ((localObject2 instanceof jk)) {
                a.put(((Class) localEntry.getKey()).getName(), (jk) localObject2);
            } else if ((localObject2 instanceof Class)) {
                localObject2 = (Class) localObject2;
                b.put(((Class) localEntry.getKey()).getName(), localObject2);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + localEntry.getClass().getName());
            }
        }
        b.put(sq.class.getName(), qh.class);
        c = new HashMap();
        c.put(boolean[].class.getName(), new py.b());
        c.put(byte[].class.getName(), new py.c());
        c.put(char[].class.getName(), new py.d());
        c.put(short[].class.getName(), new py.i());
        c.put(int[].class.getName(), new py.g());
        c.put(long[].class.getName(), new py.h());
        c.put(float[].class.getName(), new py.f());
        c.put(double[].class.getName(), new py.e());
    }

    protected static jk<Object> b(ju paramju, mm parammm, is paramis) {
        iq localiq = paramju.a();
        Class localClass2 = localiq.c(parammm);
        Class localClass1;
        if (localClass2 != null) {
            localClass1 = localClass2;
            if (localClass2 != jk.a.class) {
            }
        } else {
            localClass1 = localClass2;
            if (paramis != null) {
                localClass1 = localiq.c(paramis.b());
            }
        }
        if ((localClass1 != null) && (localClass1 != jk.a.class)) {
            return paramju.a(parammm, localClass1);
        }
        return null;
    }

    /* Error */
    protected static <T extends sh> T b(ju paramju, mm parammm, T paramT) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 248	com/flurry/sdk/ju:a	()Lcom/flurry/sdk/iq;
        //   4: astore 4
        //   6: aload_2
        //   7: astore_3
        //   8: aload_2
        //   9: invokevirtual 273	com/flurry/sdk/sh:f	()Z
        //   12: ifeq +93 -> 105
        //   15: aload 4
        //   17: aload_1
        //   18: aload_2
        //   19: invokevirtual 277	com/flurry/sdk/sh:k	()Lcom/flurry/sdk/sh;
        //   22: invokevirtual 280	com/flurry/sdk/iq:a	(Lcom/flurry/sdk/mm;Lcom/flurry/sdk/sh;)Ljava/lang/Class;
        //   25: astore_3
        //   26: aload_2
        //   27: astore_0
        //   28: aload_3
        //   29: ifnull +53 -> 82
        //   32: aload_2
        //   33: instanceof 282
        //   36: ifne +37 -> 73
        //   39: new 268	java/lang/IllegalArgumentException
        //   42: dup
        //   43: new 47	java/lang/StringBuilder
        //   46: dup
        //   47: invokespecial 170	java/lang/StringBuilder:<init>	()V
        //   50: ldc_w 284
        //   53: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: aload_2
        //   57: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   60: ldc_w 289
        //   63: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   69: invokespecial 290	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
        //   72: athrow
        //   73: aload_2
        //   74: checkcast 282	com/flurry/sdk/qo
        //   77: aload_3
        //   78: invokevirtual 294	com/flurry/sdk/qo:e	(Ljava/lang/Class;)Lcom/flurry/sdk/sh;
        //   81: astore_0
        //   82: aload 4
        //   84: aload_1
        //   85: aload_0
        //   86: invokevirtual 297	com/flurry/sdk/sh:g	()Lcom/flurry/sdk/sh;
        //   89: invokevirtual 299	com/flurry/sdk/iq:b	(Lcom/flurry/sdk/mm;Lcom/flurry/sdk/sh;)Ljava/lang/Class;
        //   92: astore_1
        //   93: aload_0
        //   94: astore_3
        //   95: aload_1
        //   96: ifnull +9 -> 105
        //   99: aload_0
        //   100: aload_1
        //   101: invokevirtual 301	com/flurry/sdk/sh:c	(Ljava/lang/Class;)Lcom/flurry/sdk/sh;
        //   104: astore_3
        //   105: aload_3
        //   106: areturn
        //   107: astore_0
        //   108: new 268	java/lang/IllegalArgumentException
        //   111: dup
        //   112: new 47	java/lang/StringBuilder
        //   115: dup
        //   116: invokespecial 170	java/lang/StringBuilder:<init>	()V
        //   119: ldc_w 303
        //   122: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   125: aload_2
        //   126: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   129: ldc_w 305
        //   132: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   135: aload_3
        //   136: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
        //   139: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: ldc_w 307
        //   145: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_0
        //   149: invokevirtual 310	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
        //   152: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   158: invokespecial 290	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
        //   161: athrow
        //   162: astore_2
        //   163: new 268	java/lang/IllegalArgumentException
        //   166: dup
        //   167: new 47	java/lang/StringBuilder
        //   170: dup
        //   171: invokespecial 170	java/lang/StringBuilder:<init>	()V
        //   174: ldc_w 312
        //   177: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: aload_0
        //   181: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   184: ldc_w 314
        //   187: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: aload_1
        //   191: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
        //   194: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   197: ldc_w 307
        //   200: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: aload_2
        //   204: invokevirtual 310	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
        //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   213: invokespecial 290	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
        //   216: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	217	0	paramju	ju
        //   0	217	1	parammm	mm
        //   0	217	2	paramT	T
        //   7	129	3	localObject	Object
        //   4	79	4	localiq	iq
        // Exception table:
        //   from	to	target	type
        //   73	82	107	java/lang/IllegalArgumentException
        //   99	105	162	java/lang/IllegalArgumentException
    }

    protected static jk<Object> c(ju paramju, mm parammm, is paramis) {
        iq localiq = paramju.a();
        Class localClass2 = localiq.d(parammm);
        Class localClass1;
        if (localClass2 != null) {
            localClass1 = localClass2;
            if (localClass2 != jk.a.class) {
            }
        } else {
            localClass1 = localClass2;
            if (paramis != null) {
                localClass1 = localiq.d(paramis.b());
            }
        }
        if ((localClass1 != null) && (localClass1 != jk.a.class)) {
            return paramju.a(parammm, localClass1);
        }
        return null;
    }

    protected jk<Object> a(ju paramju, mm parammm, is paramis)
            throws jh {
        Object localObject = paramju.a().b(parammm);
        if (localObject == null) {
            parammm = null;
        }
        do {
            do {
                return parammm;
                if (!(localObject instanceof jk)) {
                    break;
                }
                localObject = (jk) localObject;
                parammm = (mm) localObject;
            } while (!(localObject instanceof ix));
            return ((ix) localObject).a(paramju, paramis);
            if (!(localObject instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned value of type " + localObject.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }
            localObject = (Class) localObject;
            if (!jk.class.isAssignableFrom((Class) localObject)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class) localObject).getName() + "; expected Class<JsonSerializer>");
            }
            localObject = paramju.a(parammm, (Class) localObject);
            parammm = (mm) localObject;
        } while (!(localObject instanceof ix));
        return ((ix) localObject).a(paramju, paramis);
    }

    protected jk<?> a(ju paramju, qi paramqi, mw parammw, is paramis, boolean paramBoolean, jz paramjz, jk<Object> paramjk) {
        paramju = paramqi.p();
        if (String[].class == paramju) {
            paramju = new py.j(paramis);
        }
        do {
            return paramju;
            parammw = (jk) c.get(paramju.getName());
            paramju = parammw;
        } while (parammw != null);
        return new pr(paramqi.g(), paramBoolean, paramjz, paramis, paramjk);
    }

    protected jk<?> a(ju paramju, qk paramqk, mw parammw, is paramis, boolean paramBoolean, jz paramjz, jk<Object> paramjk) {
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext()) {
            jk localjk = ((jx) localIterator.next()).a(paramju, paramqk, parammw, paramis, paramjz, paramjk);
            if (localjk != null) {
                return localjk;
            }
        }
        return null;
    }

    protected jk<?> a(ju paramju, ql paramql, mw parammw, is paramis, boolean paramBoolean, jz paramjz, jk<Object> paramjk) {
        Object localObject = b().iterator();
        while (((Iterator) localObject).hasNext()) {
            jk localjk = ((jx) ((Iterator) localObject).next()).a(paramju, paramql, parammw, paramis, paramjz, paramjk);
            if (localjk != null) {
                return localjk;
            }
        }
        localObject = paramql.p();
        if (EnumSet.class.isAssignableFrom((Class) localObject)) {
            return a(paramju, paramql, parammw, paramis, paramBoolean, paramjz, paramjk);
        }
        paramju = paramql.g().p();
        if (a((Class) localObject)) {
            if (paramju == String.class) {
                return new pk(paramis);
            }
            return pz.a(paramql.g(), paramBoolean, paramjz, paramis, paramjk);
        }
        if (paramju == String.class) {
            return new qd(paramis);
        }
        return pz.b(paramql.g(), paramBoolean, paramjz, paramis, paramjk);
    }

    protected jk<?> a(ju paramju, qn paramqn, mw parammw, is paramis, boolean paramBoolean, jk<Object> paramjk1, jz paramjz, jk<Object> paramjk2) {
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext()) {
            jk localjk = ((jx) localIterator.next()).a(paramju, paramqn, parammw, paramis, paramjk1, paramjz, paramjk2);
            if (localjk != null) {
                return localjk;
            }
        }
        return null;
    }

    protected jk<?> a(ju paramju, qo paramqo, mw parammw, is paramis, boolean paramBoolean, jk<Object> paramjk1, jz paramjz, jk<Object> paramjk2) {
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext()) {
            jk localjk = ((jx) localIterator.next()).a(paramju, paramqo, parammw, paramis, paramjk1, paramjz, paramjk2);
            if (localjk != null) {
                return localjk;
            }
        }
        if (EnumMap.class.isAssignableFrom(paramqo.p())) {
            return b(paramju, paramqo, parammw, paramis, paramBoolean, paramjz, paramjk2);
        }
        return po.a(paramju.a().c(parammw.c()), paramqo, paramBoolean, paramjz, paramis, paramjk1, paramjk2);
    }

    public final jk<?> a(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean)
            throws jh {
        Class localClass = paramsh.p();
        if (Iterator.class.isAssignableFrom(localClass)) {
            return c(paramju, paramsh, parammw, paramis, paramBoolean);
        }
        if (Iterable.class.isAssignableFrom(localClass)) {
            return d(paramju, paramsh, parammw, paramis, paramBoolean);
        }
        if (CharSequence.class.isAssignableFrom(localClass)) {
            return qg.a;
        }
        return null;
    }

    protected jk<?> a(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean, jz paramjz, jk<Object> paramjk) {
        paramsh = paramsh.g();
        paramju = paramsh;
        if (!paramsh.r()) {
            paramju = null;
        }
        return pz.a(paramju, paramis);
    }

    public final jk<?> a(sh paramsh, ju paramju, mw parammw, is paramis, boolean paramBoolean) {
        paramsh = paramsh.p().getName();
        paramju = (jk) a.get(paramsh);
        if (paramju != null) {
            return paramju;
        }
        paramsh = (Class) b.get(paramsh);
        if (paramsh != null) {
            try {
                paramju = (jk) paramsh.newInstance();
                return paramju;
            } catch (Exception paramju) {
                throw new IllegalStateException("Failed to instantiate standard serializer (of type " + paramsh.getName() + "): " + paramju.getMessage(), paramju);
            }
        }
        return null;
    }

    protected <T extends sh> T a(ju paramju, mm parammm, T paramT) {
        Class localClass = paramju.a().e(parammm);
        Object localObject = paramT;
        if (localClass != null) {
        }
        try {
            localObject = paramT.h(localClass);
            return b(paramju, parammm, (sh) localObject);
        } catch (IllegalArgumentException paramju) {
            throw new IllegalArgumentException("Failed to widen type " + paramT + " with concrete-type annotation (value " + localClass.getName() + "), method '" + parammm.b() + "': " + paramju.getMessage());
        }
    }

    protected boolean a(ju paramju, mw parammw, jz paramjz, is paramis) {
        if (paramjz != null) {
        }
        do {
            do {
                do {
                    return false;
                    paramjz = paramju.a();
                    parammw = paramjz.f(parammw.c());
                    if (parammw != null) {
                        if (parammw == kg.b.b) {
                            return true;
                        }
                    } else if (paramju.a(ju.a.h)) {
                        return true;
                    }
                } while (paramis == null);
                paramju = paramis.a();
            } while (!paramju.f());
            if (paramjz.b(paramis.b(), paramis.a()) != null) {
                return true;
            }
        } while ((!(paramju instanceof qo)) || (paramjz.a(paramis.b(), paramis.a()) == null));
        return true;
    }

    protected boolean a(Class<?> paramClass) {
        return RandomAccess.class.isAssignableFrom(paramClass);
    }

    public jk<?> b(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean) {
        jz localjz = b(paramju, paramsh.g(), paramis);
        if (localjz != null) {
            paramBoolean = false;
        }
        for (; ; ) {
            jk localjk1 = c(paramju, parammw.c(), paramis);
            if (paramsh.j()) {
                paramsh = (qn) paramsh;
                jk localjk2 = b(paramju, parammw.c(), paramis);
                if (paramsh.l()) {
                    return a(paramju, (qo) paramsh, parammw, paramis, paramBoolean, localjk2, localjz, localjk1);
                    if (!paramBoolean) {
                        paramBoolean = a(paramju, parammw, localjz, paramis);
                    }
                } else {
                    return a(paramju, paramsh, parammw, paramis, paramBoolean, localjk2, localjz, localjk1);
                }
            } else {
                if (paramsh.i()) {
                    paramsh = (qk) paramsh;
                    if (paramsh.a_()) {
                        return a(paramju, (ql) paramsh, parammw, paramis, paramBoolean, localjz, localjk1);
                    }
                    return a(paramju, paramsh, parammw, paramis, paramBoolean, localjz, localjk1);
                }
                if (paramsh.b()) {
                    return a(paramju, (qi) paramsh, parammw, paramis, paramBoolean, localjz, localjk1);
                }
                return null;
            }
        }
    }

    protected jk<?> b(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean, jz paramjz, jk<Object> paramjk) {
        sh localsh = paramsh.k();
        parammw = null;
        if (localsh.r()) {
            parammw = rb.a(localsh.p(), paramju.a());
        }
        return new ph(paramsh.g(), paramBoolean, parammw, paramjz, paramis, paramjk);
    }

    public final jk<?> b(sh paramsh, ju paramju, mw parammw, is paramis, boolean paramBoolean)
            throws jh {
        Class localClass = paramsh.p();
        if (ji.class.isAssignableFrom(localClass)) {
            if (jj.class.isAssignableFrom(localClass)) {
                paramsh = pv.a;
            }
        }
        do {
            return paramsh;
            return pu.a;
            mr localmr = parammw.e();
            if (localmr != null) {
                paramsh = localmr.e();
                if (paramju.a(ju.a.e)) {
                    qy.a(paramsh);
                }
                return new pn(paramsh, a(paramju, localmr, paramis), paramis);
            }
            if (InetAddress.class.isAssignableFrom(localClass)) {
                return pl.a;
            }
            if (TimeZone.class.isAssignableFrom(localClass)) {
                return qf.a;
            }
            if (Charset.class.isAssignableFrom(localClass)) {
                return qg.a;
            }
            paramis = this.d.a(paramju, paramsh);
            paramsh = paramis;
        } while (paramis != null);
        if (Number.class.isAssignableFrom(localClass)) {
            return os.g.a;
        }
        if (Enum.class.isAssignableFrom(localClass)) {
            return pi.a(localClass, paramju, parammw);
        }
        if (Calendar.class.isAssignableFrom(localClass)) {
            return pd.a;
        }
        if (java.util.Date.class.isAssignableFrom(localClass)) {
            return pg.a;
        }
        return null;
    }

    public jz b(ju paramju, sh paramsh, is paramis) {
        Object localObject = ((mw) paramju.c(paramsh.p())).c();
        iq localiq = paramju.a();
        ni localni = localiq.a(paramju, (mn) localObject, paramsh);
        if (localni == null) {
            localni = paramju.d(paramsh);
        }
        for (localObject = null; localni == null; localObject = paramju.l().a((mn) localObject, paramju, localiq)) {
            return null;
        }
        return localni.a(paramju, paramsh, (Collection) localObject, paramis);
    }

    protected abstract Iterable<jx> b();

    protected jk<?> c(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean) {
        Object localObject = paramsh.b(0);
        paramsh = (sh) localObject;
        if (localObject == null) {
            paramsh = qs.b();
        }
        localObject = b(paramju, paramsh, paramis);
        return pz.a(paramsh, a(paramju, parammw, (jz) localObject, paramis), (jz) localObject, paramis);
    }

    protected jk<?> d(ju paramju, sh paramsh, mw parammw, is paramis, boolean paramBoolean) {
        Object localObject = paramsh.b(0);
        paramsh = (sh) localObject;
        if (localObject == null) {
            paramsh = qs.b();
        }
        localObject = b(paramju, paramsh, paramis);
        return pz.b(paramsh, a(paramju, parammw, (jz) localObject, paramis), (jz) localObject, paramis);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/og.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */