package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class kn
        extends jb {
    static final HashMap<qj, jg<Object>> b = ;
    static final HashMap<sh, jl> c = mb.a();
    static final HashMap<String, Class<? extends Map>> d = new HashMap();
    static final HashMap<String, Class<? extends Collection>> e;
    protected static final HashMap<sh, jg<Object>> f;
    protected ml g = ml.a;

    static {
        d.put(Map.class.getName(), LinkedHashMap.class);
        d.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        d.put(SortedMap.class.getName(), TreeMap.class);
        d.put("java.util.NavigableMap", TreeMap.class);
        try {
            Class localClass1 = Class.forName("java.util.ConcurrentNavigableMap");
            Class localClass2 = Class.forName("java.util.ConcurrentSkipListMap");
            d.put(localClass1.getName(), localClass2);
            e = new HashMap();
            e.put(Collection.class.getName(), ArrayList.class);
            e.put(List.class.getName(), ArrayList.class);
            e.put(Set.class.getName(), HashSet.class);
            e.put(SortedSet.class.getName(), TreeSet.class);
            e.put(Queue.class.getName(), LinkedList.class);
            e.put("java.util.Deque", LinkedList.class);
            e.put("java.util.NavigableSet", TreeSet.class);
            f = ly.a();
            return;
        } catch (ClassNotFoundException localClassNotFoundException) {
            for (; ; ) {
            }
        }
    }

    public jg<?> a(iy paramiy, jc paramjc, qi paramqi, is paramis)
            throws jh {
        sh localsh = paramqi.g();
        jg localjg1 = (jg) localsh.n();
        Object localObject;
        if (localjg1 == null) {
            localObject = (jg) f.get(localsh);
            if (localObject != null) {
                paramiy = a(paramqi, paramiy, paramjc, paramis, null, null);
                if (paramiy != null) {
                    localObject = paramiy;
                }
                return (jg<?>) localObject;
            }
            if (localsh.t()) {
                throw new IllegalArgumentException("Internal error: primitive type (" + paramqi + ") passed, no array deserializer found");
            }
        }
        jy localjy = (jy) localsh.o();
        if (localjy == null) {
            localjy = b(paramiy, localsh, paramis);
        }
        for (; ; ) {
            jg localjg2 = a(paramqi, paramiy, paramjc, paramis, localjy, localjg1);
            localObject = localjg2;
            if (localjg2 != null) {
                break;
            }
            localObject = localjg1;
            if (localjg1 == null) {
                localObject = paramjc.a(paramiy, localsh, paramis);
            }
            return new lx(paramqi, (jg) localObject, localjy);
        }
    }

    public jg<?> a(iy paramiy, jc paramjc, qk paramqk, is paramis)
            throws jh {
        paramqk = (qk) a(paramiy, paramqk);
        mw localmw = (mw) paramiy.c(paramqk.p());
        Object localObject = a(paramiy, localmw.c(), paramis);
        if (localObject != null) {
            return (jg<?>) localObject;
        }
        localObject = (qk) a(paramiy, localmw.c(), paramqk, null);
        sh localsh = ((qk) localObject).g();
        jg localjg = (jg) localsh.n();
        paramqk = (jy) localsh.o();
        if (paramqk == null) {
            paramqk = b(paramiy, localsh, paramis);
        }
        for (; ; ) {
            return a((qk) localObject, paramiy, paramjc, localmw, paramis, paramqk, localjg);
        }
    }

    public jg<?> a(iy paramiy, jc paramjc, ql paramql, is paramis)
            throws jh {
        paramql = (ql) a(paramiy, paramql);
        Class localClass = paramql.p();
        mw localmw = (mw) paramiy.c(paramql);
        Object localObject = a(paramiy, localmw.c(), paramis);
        if (localObject != null) {
            return (jg<?>) localObject;
        }
        ql localql = (ql) a(paramiy, localmw.c(), paramql, null);
        sh localsh = localql.g();
        jg localjg1 = (jg) localsh.n();
        paramql = (jy) localsh.o();
        if (paramql == null) {
            paramql = b(paramiy, localsh, paramis);
        }
        for (; ; ) {
            jg localjg2 = a(localql, paramiy, paramjc, localmw, paramis, paramql, localjg1);
            localObject = localjg2;
            if (localjg2 != null) {
                break;
            }
            localObject = localjg1;
            if (localjg1 == null) {
                if (EnumSet.class.isAssignableFrom(localClass)) {
                    return new ls(localsh.p(), b(paramiy, paramjc, localsh, paramis));
                }
                localObject = paramjc.a(paramiy, localsh, paramis);
            }
            if (!localql.s()) {
                paramjc = localql;
                paramis = localmw;
                if (!localql.c()) {
                }
            } else {
                paramjc = (Class) e.get(localClass.getName());
                if (paramjc == null) {
                    throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + localql);
                }
                paramjc = (ql) paramiy.a(localql, paramjc);
                paramis = (mw) paramiy.c(paramjc);
            }
            paramiy = a(paramiy, paramis);
            if (localsh.p() == String.class) {
                return new me(paramjc, (jg) localObject, paramiy);
            }
            return new ln(paramjc, (jg) localObject, paramql, paramiy);
        }
    }

    public jg<?> a(iy paramiy, jc paramjc, qn paramqn, is paramis)
            throws jh {
        paramqn = (qn) a(paramiy, paramqn);
        mw localmw = (mw) paramiy.c(paramqn);
        Object localObject = a(paramiy, localmw.c(), paramis);
        if (localObject != null) {
            return (jg<?>) localObject;
        }
        qn localqn = (qn) a(paramiy, localmw.c(), paramqn, null);
        localObject = localqn.k();
        sh localsh = localqn.g();
        jg localjg = (jg) localsh.n();
        paramqn = (jl) ((sh) localObject).n();
        if (paramqn == null) {
            paramqn = paramjc.c(paramiy, (sh) localObject, paramis);
        }
        for (; ; ) {
            localObject = (jy) localsh.o();
            if (localObject == null) {
                localObject = b(paramiy, localsh, paramis);
            }
            for (; ; ) {
                return a(localqn, paramiy, paramjc, localmw, paramis, paramqn, (jy) localObject, localjg);
            }
        }
    }

    public jg<?> a(iy paramiy, jc paramjc, qo paramqo, is paramis)
            throws jh {
        paramqo = (qo) a(paramiy, paramqo);
        mw localmw = (mw) paramiy.c(paramqo);
        Object localObject1 = a(paramiy, localmw.c(), paramis);
        if (localObject1 != null) {
            return (jg<?>) localObject1;
        }
        qo localqo = (qo) a(paramiy, localmw.c(), paramqo, null);
        sh localsh1 = localqo.k();
        sh localsh2 = localqo.g();
        Object localObject2 = (jg) localsh2.n();
        paramqo = (jl) localsh1.n();
        if (paramqo == null) {
            paramqo = paramjc.c(paramiy, localsh1, paramis);
        }
        for (; ; ) {
            jy localjy = (jy) localsh2.o();
            if (localjy == null) {
                localjy = b(paramiy, localsh2, paramis);
            }
            for (; ; ) {
                jg localjg = a(localqo, paramiy, paramjc, localmw, paramis, paramqo, localjy, (jg) localObject2);
                localObject1 = localjg;
                if (localjg != null) {
                    break;
                }
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = paramjc.a(paramiy, localsh2, paramis);
                }
                localObject2 = localqo.p();
                if (EnumMap.class.isAssignableFrom((Class) localObject2)) {
                    paramqo = localsh1.p();
                    if ((paramqo == null) || (!paramqo.isEnum())) {
                        throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                    }
                    return new lr(localsh1.p(), b(paramiy, paramjc, localsh1, paramis), (jg) localObject1);
                }
                if ((localqo.s()) || (localqo.c())) {
                    paramjc = (Class) d.get(((Class) localObject2).getName());
                    if (paramjc == null) {
                        throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + localqo);
                    }
                    paramis = (qo) paramiy.a(localqo, paramjc);
                    paramjc = (mw) paramiy.c(paramis);
                }
                for (; ; ) {
                    paramqo = new lw(paramis, a(paramiy, paramjc), paramqo, (jg) localObject1, localjy);
                    paramqo.a(paramiy.a().c(paramjc.c()));
                    return paramqo;
                    paramjc = localmw;
                    paramis = localqo;
                }
            }
        }
    }

    protected jg<Object> a(iy paramiy, mm parammm, is paramis)
            throws jh {
        Object localObject = paramiy.a().h(parammm);
        if (localObject != null) {
            return a(paramiy, parammm, paramis, localObject);
        }
        return null;
    }

    jg<Object> a(iy paramiy, mm parammm, is paramis, Object paramObject)
            throws jh {
        if ((paramObject instanceof jg)) {
            paramObject = (jg) paramObject;
            parammm = (mm) paramObject;
            if ((paramObject instanceof iv)) {
                parammm = ((iv) paramObject).a(paramiy, paramis);
            }
            return parammm;
        }
        if (!(paramObject instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
        }
        paramObject = (Class) paramObject;
        if (!jg.class.isAssignableFrom((Class) paramObject)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class) paramObject).getName() + "; expected Class<JsonDeserializer>");
        }
        paramObject = paramiy.a(parammm, (Class) paramObject);
        parammm = (mm) paramObject;
        if ((paramObject instanceof iv)) {
            parammm = ((iv) paramObject).a(paramiy, paramis);
        }
        return parammm;
    }

    protected abstract jg<?> a(qi paramqi, iy paramiy, jc paramjc, is paramis, jy paramjy, jg<?> paramjg)
            throws jh;

    protected abstract jg<?> a(qk paramqk, iy paramiy, jc paramjc, mw parammw, is paramis, jy paramjy, jg<?> paramjg)
            throws jh;

    protected abstract jg<?> a(ql paramql, iy paramiy, jc paramjc, mw parammw, is paramis, jy paramjy, jg<?> paramjg)
            throws jh;

    protected abstract jg<?> a(qn paramqn, iy paramiy, jc paramjc, mw parammw, is paramis, jl paramjl, jy paramjy, jg<?> paramjg)
            throws jh;

    protected abstract jg<?> a(qo paramqo, iy paramiy, jc paramjc, mw parammw, is paramis, jl paramjl, jy paramjy, jg<?> paramjg)
            throws jh;

    protected abstract jg<?> a(Class<? extends hh> paramClass, iy paramiy, is paramis)
            throws jh;

    protected abstract jg<?> a(Class<?> paramClass, iy paramiy, mw parammw, is paramis)
            throws jh;

    public jy a(iy paramiy, sh paramsh, mq parammq, is paramis)
            throws jh {
        iq localiq = paramiy.a();
        ni localni = localiq.a(paramiy, parammq, paramsh);
        if (localni == null) {
            return b(paramiy, paramsh, paramis);
        }
        return localni.a(paramiy, paramsh, paramiy.l().a(parammq, paramiy, localiq), paramis);
    }

    public abstract kx a(iy paramiy, mw parammw)
            throws jh;

    protected ra<?> a(Class<?> paramClass, iy paramiy) {
        if (paramiy.a(iy.a.j)) {
            return ra.b(paramClass);
        }
        return ra.b(paramClass, paramiy.a());
    }

    /* Error */
    protected <T extends sh> T a(iy paramiy, mm parammm, T paramT, String paramString)
            throws jh {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 312	com/flurry/sdk/iy:a	()Lcom/flurry/sdk/iq;
        //   4: astore 6
        //   6: aload 6
        //   8: aload_2
        //   9: aload_3
        //   10: aload 4
        //   12: invokevirtual 396	com/flurry/sdk/iq:a	(Lcom/flurry/sdk/mm;Lcom/flurry/sdk/sh;Ljava/lang/String;)Ljava/lang/Class;
        //   15: astore 7
        //   17: aload 7
        //   19: ifnull +428 -> 447
        //   22: aload_3
        //   23: aload 7
        //   25: invokevirtual 399	com/flurry/sdk/sh:f	(Ljava/lang/Class;)Lcom/flurry/sdk/sh;
        //   28: astore 5
        //   30: aload 5
        //   32: astore_3
        //   33: aload_3
        //   34: astore 5
        //   36: aload_3
        //   37: invokevirtual 401	com/flurry/sdk/sh:f	()Z
        //   40: ifeq +287 -> 327
        //   43: aload 6
        //   45: aload_2
        //   46: aload_3
        //   47: invokevirtual 402	com/flurry/sdk/sh:k	()Lcom/flurry/sdk/sh;
        //   50: aload 4
        //   52: invokevirtual 404	com/flurry/sdk/iq:b	(Lcom/flurry/sdk/mm;Lcom/flurry/sdk/sh;Ljava/lang/String;)Ljava/lang/Class;
        //   55: astore 7
        //   57: aload_3
        //   58: astore 5
        //   60: aload 7
        //   62: ifnull +126 -> 188
        //   65: aload_3
        //   66: instanceof 266
        //   69: ifne +108 -> 177
        //   72: new 113	com/flurry/sdk/jh
        //   75: dup
        //   76: new 141	java/lang/StringBuilder
        //   79: dup
        //   80: invokespecial 142	java/lang/StringBuilder:<init>	()V
        //   83: ldc_w 406
        //   86: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: aload_3
        //   90: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   93: ldc_w 408
        //   96: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   102: invokespecial 409	com/flurry/sdk/jh:<init>	(Ljava/lang/String;)V
        //   105: athrow
        //   106: astore_1
        //   107: new 113	com/flurry/sdk/jh
        //   110: dup
        //   111: new 141	java/lang/StringBuilder
        //   114: dup
        //   115: invokespecial 142	java/lang/StringBuilder:<init>	()V
        //   118: ldc_w 411
        //   121: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: aload_3
        //   125: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   128: ldc_w 413
        //   131: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: aload 7
        //   136: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
        //   139: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: ldc_w 415
        //   145: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_2
        //   149: invokevirtual 419	com/flurry/sdk/mm:b	()Ljava/lang/String;
        //   152: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: ldc_w 421
        //   158: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: aload_1
        //   162: invokevirtual 424	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
        //   165: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   171: aconst_null
        //   172: aload_1
        //   173: invokespecial 427	com/flurry/sdk/jh:<init>	(Ljava/lang/String;Lcom/flurry/sdk/hg;Ljava/lang/Throwable;)V
        //   176: athrow
        //   177: aload_3
        //   178: checkcast 266	com/flurry/sdk/qn
        //   181: aload 7
        //   183: invokevirtual 429	com/flurry/sdk/qn:d	(Ljava/lang/Class;)Lcom/flurry/sdk/sh;
        //   186: astore 5
        //   188: aload 5
        //   190: invokevirtual 402	com/flurry/sdk/sh:k	()Lcom/flurry/sdk/sh;
        //   193: astore_3
        //   194: aload_3
        //   195: ifnull +42 -> 237
        //   198: aload_3
        //   199: invokevirtual 124	com/flurry/sdk/sh:n	()Ljava/lang/Object;
        //   202: ifnonnull +35 -> 237
        //   205: aload 6
        //   207: aload_2
        //   208: invokevirtual 433	com/flurry/sdk/iq:i	(Lcom/flurry/sdk/mm;)Ljava/lang/Class;
        //   211: astore 7
        //   213: aload 7
        //   215: ifnull +22 -> 237
        //   218: aload 7
        //   220: ldc_w 435
        //   223: if_acmpeq +14 -> 237
        //   226: aload_3
        //   227: aload_1
        //   228: aload_2
        //   229: aload 7
        //   231: invokevirtual 438	com/flurry/sdk/iy:b	(Lcom/flurry/sdk/mm;Ljava/lang/Class;)Lcom/flurry/sdk/jl;
        //   234: invokevirtual 441	com/flurry/sdk/sh:j	(Ljava/lang/Object;)V
        //   237: aload 6
        //   239: aload_2
        //   240: aload 5
        //   242: invokevirtual 442	com/flurry/sdk/sh:g	()Lcom/flurry/sdk/sh;
        //   245: aload 4
        //   247: invokevirtual 444	com/flurry/sdk/iq:c	(Lcom/flurry/sdk/mm;Lcom/flurry/sdk/sh;Ljava/lang/String;)Ljava/lang/Class;
        //   250: astore 4
        //   252: aload 5
        //   254: astore_3
        //   255: aload 4
        //   257: ifnull +11 -> 268
        //   260: aload 5
        //   262: aload 4
        //   264: invokevirtual 446	com/flurry/sdk/sh:b	(Ljava/lang/Class;)Lcom/flurry/sdk/sh;
        //   267: astore_3
        //   268: aload_3
        //   269: astore 5
        //   271: aload_3
        //   272: invokevirtual 442	com/flurry/sdk/sh:g	()Lcom/flurry/sdk/sh;
        //   275: invokevirtual 124	com/flurry/sdk/sh:n	()Ljava/lang/Object;
        //   278: ifnonnull +49 -> 327
        //   281: aload 6
        //   283: aload_2
        //   284: invokevirtual 448	com/flurry/sdk/iq:j	(Lcom/flurry/sdk/mm;)Ljava/lang/Class;
        //   287: astore 4
        //   289: aload_3
        //   290: astore 5
        //   292: aload 4
        //   294: ifnull +33 -> 327
        //   297: aload_3
        //   298: astore 5
        //   300: aload 4
        //   302: ldc_w 450
        //   305: if_acmpeq +22 -> 327
        //   308: aload_1
        //   309: aload_2
        //   310: aload 4
        //   312: invokevirtual 353	com/flurry/sdk/iy:a	(Lcom/flurry/sdk/mm;Ljava/lang/Class;)Lcom/flurry/sdk/jg;
        //   315: astore_1
        //   316: aload_3
        //   317: invokevirtual 442	com/flurry/sdk/sh:g	()Lcom/flurry/sdk/sh;
        //   320: aload_1
        //   321: invokevirtual 441	com/flurry/sdk/sh:j	(Ljava/lang/Object;)V
        //   324: aload_3
        //   325: astore 5
        //   327: aload 5
        //   329: areturn
        //   330: astore_1
        //   331: new 113	com/flurry/sdk/jh
        //   334: dup
        //   335: new 141	java/lang/StringBuilder
        //   338: dup
        //   339: invokespecial 142	java/lang/StringBuilder:<init>	()V
        //   342: ldc_w 452
        //   345: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   348: aload_3
        //   349: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   352: ldc_w 454
        //   355: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   358: aload 7
        //   360: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
        //   363: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   366: ldc_w 456
        //   369: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   372: aload_1
        //   373: invokevirtual 424	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
        //   376: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   382: aconst_null
        //   383: aload_1
        //   384: invokespecial 427	com/flurry/sdk/jh:<init>	(Ljava/lang/String;Lcom/flurry/sdk/hg;Ljava/lang/Throwable;)V
        //   387: athrow
        //   388: astore_1
        //   389: new 113	com/flurry/sdk/jh
        //   392: dup
        //   393: new 141	java/lang/StringBuilder
        //   396: dup
        //   397: invokespecial 142	java/lang/StringBuilder:<init>	()V
        //   400: ldc_w 458
        //   403: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   406: aload 5
        //   408: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   411: ldc_w 460
        //   414: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   417: aload 4
        //   419: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
        //   422: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   425: ldc_w 456
        //   428: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   431: aload_1
        //   432: invokevirtual 424	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
        //   435: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   438: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   441: aconst_null
        //   442: aload_1
        //   443: invokespecial 427	com/flurry/sdk/jh:<init>	(Ljava/lang/String;Lcom/flurry/sdk/hg;Ljava/lang/Throwable;)V
        //   446: athrow
        //   447: goto -414 -> 33
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	450	0	this	kn
        //   0	450	1	paramiy	iy
        //   0	450	2	parammm	mm
        //   0	450	3	paramT	T
        //   0	450	4	paramString	String
        //   28	379	5	localObject	Object
        //   4	278	6	localiq	iq
        //   15	344	7	localClass	Class
        // Exception table:
        //   from	to	target	type
        //   22	30	106	java/lang/IllegalArgumentException
        //   177	188	330	java/lang/IllegalArgumentException
        //   260	268	388	java/lang/IllegalArgumentException
    }

    protected sh a(iy paramiy, mw parammw, sh paramsh, mq parammq, is paramis)
            throws jh {
        parammw = paramsh;
        if (paramsh.f()) {
            parammw = paramiy.a();
            Object localObject = paramsh.k();
            if (localObject != null) {
                Class localClass = parammw.i(parammq);
                if ((localClass != null) && (localClass != jl.a.class)) {
                    ((sh) localObject).j(paramiy.b(parammq, localClass));
                }
            }
            parammw = parammw.j(parammq);
            if ((parammw != null) && (parammw != jg.a.class)) {
                parammw = paramiy.a(parammq, parammw);
                paramsh.g().j(parammw);
            }
            parammw = paramsh;
            if ((parammq instanceof mq)) {
                localObject = b(paramiy, paramsh, parammq, paramis);
                parammw = paramsh;
                if (localObject != null) {
                    parammw = paramsh.e(localObject);
                }
            }
        }
        if ((parammq instanceof mq)) {
        }
        for (paramiy = a(paramiy, parammw, parammq, paramis); ; paramiy = b(paramiy, parammw, null)) {
            paramsh = parammw;
            if (paramiy != null) {
                paramsh = parammw.f(paramiy);
            }
            return paramsh;
        }
    }

    public abstract sh a(iy paramiy, sh paramsh)
            throws jh;

    public jg<?> b(iy paramiy, jc paramjc, sh paramsh, is paramis)
            throws jh {
        paramjc = (mw) paramiy.c(paramsh);
        jg localjg = a(paramiy, paramjc.c(), paramis);
        if (localjg != null) {
            return localjg;
        }
        paramsh = paramsh.p();
        paramis = a(paramsh, paramiy, paramjc, paramis);
        if (paramis != null) {
            return paramis;
        }
        paramjc = paramjc.o().iterator();
        while (paramjc.hasNext()) {
            paramis = (mr) paramjc.next();
            if (paramiy.a().k(paramis)) {
                if ((paramis.f() == 1) && (paramis.d().isAssignableFrom(paramsh))) {
                    return lq.a(paramiy, paramsh, paramis);
                }
                throw new IllegalArgumentException("Unsuitable method (" + paramis + ") decorated with @JsonCreator (for Enum type " + paramsh.getName() + ")");
            }
        }
        return new lq(a(paramsh, paramiy));
    }

    public jy b(iy paramiy, sh paramsh, is paramis)
            throws jh {
        Object localObject1 = ((mw) paramiy.c(paramsh.p())).c();
        Object localObject2 = paramiy.a();
        ni localni = ((iq) localObject2).a(paramiy, (mn) localObject1, paramsh);
        if (localni == null) {
            localni = paramiy.d(paramsh);
            if (localni != null) {
                break label151;
            }
            return null;
        }
        label151:
        for (localObject1 = paramiy.l().a((mn) localObject1, paramiy, (iq) localObject2); ; localObject1 = null) {
            localObject2 = localni;
            if (localni.a() == null) {
                localObject2 = localni;
                if (paramsh.c()) {
                    sh localsh = a(paramiy, paramsh);
                    localObject2 = localni;
                    if (localsh != null) {
                        localObject2 = localni;
                        if (localsh.p() != paramsh.p()) {
                            localObject2 = localni.a(localsh.p());
                        }
                    }
                }
            }
            return ((ni) localObject2).a(paramiy, paramsh, (Collection) localObject1, paramis);
        }
    }

    public jy b(iy paramiy, sh paramsh, mq parammq, is paramis)
            throws jh {
        iq localiq = paramiy.a();
        ni localni = localiq.b(paramiy, parammq, paramsh);
        paramsh = paramsh.g();
        if (localni == null) {
            return b(paramiy, paramsh, paramis);
        }
        return localni.a(paramiy, paramsh, paramiy.l().a(parammq, paramiy, localiq), paramis);
    }

    public jg<?> c(iy paramiy, jc paramjc, sh paramsh, is paramis)
            throws jh {
        paramjc = paramsh.p();
        paramiy = a(paramjc, paramiy, paramis);
        if (paramiy != null) {
            return paramiy;
        }
        return lv.a(paramjc);
    }

    protected jg<Object> d(iy paramiy, jc paramjc, sh paramsh, is paramis)
            throws jh {
        Class localClass = paramsh.p();
        jg localjg = (jg) b.get(new qj(localClass));
        if (localjg != null) {
            paramiy = localjg;
        }
        do {
            return paramiy;
            if (AtomicReference.class.isAssignableFrom(localClass)) {
                paramiy = paramiy.m().b(paramsh, AtomicReference.class);
                if ((paramiy == null) || (paramiy.length < 1)) {
                }
                for (paramiy = qs.b(); ; paramiy = paramiy[0]) {
                    return new lj(paramiy, paramis);
                }
            }
            paramjc = this.g.a(paramsh, paramiy, paramjc);
            paramiy = paramjc;
        } while (paramjc != null);
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */