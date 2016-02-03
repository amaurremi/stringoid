package com.flurry.android.monolithic.sdk.impl;

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

public abstract class so
  extends qo
{
  static final HashMap<adb, qu<Object>> b = ;
  static final HashMap<afm, rc> c = wu.a();
  static final HashMap<String, Class<? extends Map>> d = new HashMap();
  static final HashMap<String, Class<? extends Collection>> e;
  protected static final HashMap<afm, qu<Object>> f;
  protected xf g = xf.a;
  
  static
  {
    d.put(Map.class.getName(), LinkedHashMap.class);
    d.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
    d.put(SortedMap.class.getName(), TreeMap.class);
    d.put("java.util.NavigableMap", TreeMap.class);
    try
    {
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
      f = vd.a();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  protected aed<?> a(Class<?> paramClass, qk paramqk)
  {
    if (paramqk.a(ql.j)) {
      return aed.b(paramClass);
    }
    return aed.b(paramClass, paramqk.a());
  }
  
  public abstract afm a(qk paramqk, afm paramafm)
    throws qw;
  
  /* Error */
  protected <T extends afm> T a(qk paramqk, xg paramxg, T paramT, String paramString)
    throws qw
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 130	com/flurry/android/monolithic/sdk/impl/qk:a	()Lcom/flurry/android/monolithic/sdk/impl/py;
    //   4: astore 6
    //   6: aload 6
    //   8: aload_2
    //   9: aload_3
    //   10: aload 4
    //   12: invokevirtual 146	com/flurry/android/monolithic/sdk/impl/py:a	(Lcom/flurry/android/monolithic/sdk/impl/xg;Lcom/flurry/android/monolithic/sdk/impl/afm;Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnull +414 -> 433
    //   22: aload_3
    //   23: aload 7
    //   25: invokevirtual 151	com/flurry/android/monolithic/sdk/impl/afm:f	(Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   28: astore 5
    //   30: aload 5
    //   32: astore_3
    //   33: aload_3
    //   34: astore 5
    //   36: aload_3
    //   37: invokevirtual 154	com/flurry/android/monolithic/sdk/impl/afm:f	()Z
    //   40: ifeq +279 -> 319
    //   43: aload 6
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 158	com/flurry/android/monolithic/sdk/impl/afm:k	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   50: aload 4
    //   52: invokevirtual 160	com/flurry/android/monolithic/sdk/impl/py:b	(Lcom/flurry/android/monolithic/sdk/impl/xg;Lcom/flurry/android/monolithic/sdk/impl/afm;Ljava/lang/String;)Ljava/lang/Class;
    //   55: astore 7
    //   57: aload_3
    //   58: astore 5
    //   60: aload 7
    //   62: ifnull +120 -> 182
    //   65: aload_3
    //   66: instanceof 162
    //   69: ifne +102 -> 171
    //   72: new 138	com/flurry/android/monolithic/sdk/impl/qw
    //   75: dup
    //   76: new 164	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   83: ldc -89
    //   85: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: ldc -80
    //   94: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 182	com/flurry/android/monolithic/sdk/impl/qw:<init>	(Ljava/lang/String;)V
    //   103: athrow
    //   104: astore_1
    //   105: new 138	com/flurry/android/monolithic/sdk/impl/qw
    //   108: dup
    //   109: new 164	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   116: ldc -72
    //   118: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: ldc -70
    //   127: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 7
    //   132: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
    //   135: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc -68
    //   140: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 192	com/flurry/android/monolithic/sdk/impl/xg:b	()Ljava/lang/String;
    //   147: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc -62
    //   152: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 197	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: aconst_null
    //   166: aload_1
    //   167: invokespecial 200	com/flurry/android/monolithic/sdk/impl/qw:<init>	(Ljava/lang/String;Lcom/flurry/android/monolithic/sdk/impl/ot;Ljava/lang/Throwable;)V
    //   170: athrow
    //   171: aload_3
    //   172: checkcast 162	com/flurry/android/monolithic/sdk/impl/adf
    //   175: aload 7
    //   177: invokevirtual 202	com/flurry/android/monolithic/sdk/impl/adf:d	(Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   180: astore 5
    //   182: aload 5
    //   184: invokevirtual 158	com/flurry/android/monolithic/sdk/impl/afm:k	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +41 -> 230
    //   192: aload_3
    //   193: invokevirtual 206	com/flurry/android/monolithic/sdk/impl/afm:n	()Ljava/lang/Object;
    //   196: ifnonnull +34 -> 230
    //   199: aload 6
    //   201: aload_2
    //   202: invokevirtual 210	com/flurry/android/monolithic/sdk/impl/py:i	(Lcom/flurry/android/monolithic/sdk/impl/xg;)Ljava/lang/Class;
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +21 -> 230
    //   212: aload 7
    //   214: ldc -44
    //   216: if_acmpeq +14 -> 230
    //   219: aload_3
    //   220: aload_1
    //   221: aload_2
    //   222: aload 7
    //   224: invokevirtual 215	com/flurry/android/monolithic/sdk/impl/qk:b	(Lcom/flurry/android/monolithic/sdk/impl/xg;Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/rc;
    //   227: invokevirtual 218	com/flurry/android/monolithic/sdk/impl/afm:j	(Ljava/lang/Object;)V
    //   230: aload 6
    //   232: aload_2
    //   233: aload 5
    //   235: invokevirtual 220	com/flurry/android/monolithic/sdk/impl/afm:g	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   238: aload 4
    //   240: invokevirtual 222	com/flurry/android/monolithic/sdk/impl/py:c	(Lcom/flurry/android/monolithic/sdk/impl/xg;Lcom/flurry/android/monolithic/sdk/impl/afm;Ljava/lang/String;)Ljava/lang/Class;
    //   243: astore 4
    //   245: aload 5
    //   247: astore_3
    //   248: aload 4
    //   250: ifnull +11 -> 261
    //   253: aload 5
    //   255: aload 4
    //   257: invokevirtual 224	com/flurry/android/monolithic/sdk/impl/afm:b	(Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   260: astore_3
    //   261: aload_3
    //   262: astore 5
    //   264: aload_3
    //   265: invokevirtual 220	com/flurry/android/monolithic/sdk/impl/afm:g	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   268: invokevirtual 206	com/flurry/android/monolithic/sdk/impl/afm:n	()Ljava/lang/Object;
    //   271: ifnonnull +48 -> 319
    //   274: aload 6
    //   276: aload_2
    //   277: invokevirtual 226	com/flurry/android/monolithic/sdk/impl/py:j	(Lcom/flurry/android/monolithic/sdk/impl/xg;)Ljava/lang/Class;
    //   280: astore 4
    //   282: aload_3
    //   283: astore 5
    //   285: aload 4
    //   287: ifnull +32 -> 319
    //   290: aload_3
    //   291: astore 5
    //   293: aload 4
    //   295: ldc -28
    //   297: if_acmpeq +22 -> 319
    //   300: aload_1
    //   301: aload_2
    //   302: aload 4
    //   304: invokevirtual 231	com/flurry/android/monolithic/sdk/impl/qk:a	(Lcom/flurry/android/monolithic/sdk/impl/xg;Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/qu;
    //   307: astore_1
    //   308: aload_3
    //   309: invokevirtual 220	com/flurry/android/monolithic/sdk/impl/afm:g	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   312: aload_1
    //   313: invokevirtual 218	com/flurry/android/monolithic/sdk/impl/afm:j	(Ljava/lang/Object;)V
    //   316: aload_3
    //   317: astore 5
    //   319: aload 5
    //   321: areturn
    //   322: astore_1
    //   323: new 138	com/flurry/android/monolithic/sdk/impl/qw
    //   326: dup
    //   327: new 164	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   334: ldc -23
    //   336: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_3
    //   340: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: ldc -21
    //   345: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 7
    //   350: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
    //   353: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc -19
    //   358: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_1
    //   362: invokevirtual 197	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: aconst_null
    //   372: aload_1
    //   373: invokespecial 200	com/flurry/android/monolithic/sdk/impl/qw:<init>	(Ljava/lang/String;Lcom/flurry/android/monolithic/sdk/impl/ot;Ljava/lang/Throwable;)V
    //   376: athrow
    //   377: astore_1
    //   378: new 138	com/flurry/android/monolithic/sdk/impl/qw
    //   381: dup
    //   382: new 164	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   389: ldc -17
    //   391: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 5
    //   396: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   399: ldc -15
    //   401: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload 4
    //   406: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
    //   409: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc -19
    //   414: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 197	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: aconst_null
    //   428: aload_1
    //   429: invokespecial 200	com/flurry/android/monolithic/sdk/impl/qw:<init>	(Ljava/lang/String;Lcom/flurry/android/monolithic/sdk/impl/ot;Ljava/lang/Throwable;)V
    //   432: athrow
    //   433: goto -400 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	so
    //   0	436	1	paramqk	qk
    //   0	436	2	paramxg	xg
    //   0	436	3	paramT	T
    //   0	436	4	paramString	String
    //   28	367	5	localObject	Object
    //   4	271	6	localpy	py
    //   15	334	7	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   22	30	104	java/lang/IllegalArgumentException
    //   171	182	322	java/lang/IllegalArgumentException
    //   253	261	377	java/lang/IllegalArgumentException
  }
  
  protected afm a(qk paramqk, xq paramxq, afm paramafm, xk paramxk, qc paramqc)
    throws qw
  {
    paramxq = paramafm;
    if (paramafm.f())
    {
      paramxq = paramqk.a();
      Object localObject = paramafm.k();
      if (localObject != null)
      {
        Class localClass = paramxq.i(paramxk);
        if ((localClass != null) && (localClass != rd.class)) {
          ((afm)localObject).j(paramqk.b(paramxk, localClass));
        }
      }
      paramxq = paramxq.j(paramxk);
      if ((paramxq != null) && (paramxq != qv.class))
      {
        paramxq = paramqk.a(paramxk, paramxq);
        paramafm.g().j(paramxq);
      }
      paramxq = paramafm;
      if ((paramxk instanceof xk))
      {
        localObject = b(paramqk, paramafm, paramxk, paramqc);
        paramxq = paramafm;
        if (localObject != null) {
          paramxq = paramafm.e(localObject);
        }
      }
    }
    if ((paramxk instanceof xk)) {}
    for (paramqk = a(paramqk, paramxq, paramxk, paramqc);; paramqk = b(paramqk, paramxq, null))
    {
      paramafm = paramxq;
      if (paramqk != null) {
        paramafm = paramxq.f(paramqk);
      }
      return paramafm;
    }
  }
  
  protected abstract qu<?> a(ada paramada, qk paramqk, qq paramqq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw;
  
  protected abstract qu<?> a(adc paramadc, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw;
  
  protected abstract qu<?> a(add paramadd, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rw paramrw, qu<?> paramqu)
    throws qw;
  
  protected abstract qu<?> a(adf paramadf, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rc paramrc, rw paramrw, qu<?> paramqu)
    throws qw;
  
  protected abstract qu<?> a(adg paramadg, qk paramqk, qq paramqq, xq paramxq, qc paramqc, rc paramrc, rw paramrw, qu<?> paramqu)
    throws qw;
  
  public qu<?> a(qk paramqk, qq paramqq, ada paramada, qc paramqc)
    throws qw
  {
    afm localafm = paramada.g();
    qu localqu1 = (qu)localafm.n();
    Object localObject;
    if (localqu1 == null)
    {
      localObject = (qu)f.get(localafm);
      if (localObject != null)
      {
        paramqk = a(paramada, paramqk, paramqq, paramqc, null, null);
        if (paramqk != null) {
          localObject = paramqk;
        }
        return (qu<?>)localObject;
      }
      if (localafm.t()) {
        throw new IllegalArgumentException("Internal error: primitive type (" + paramada + ") passed, no array deserializer found");
      }
    }
    rw localrw = (rw)localafm.o();
    if (localrw == null) {
      localrw = b(paramqk, localafm, paramqc);
    }
    for (;;)
    {
      qu localqu2 = a(paramada, paramqk, paramqq, paramqc, localrw, localqu1);
      localObject = localqu2;
      if (localqu2 != null) {
        break;
      }
      localObject = localqu1;
      if (localqu1 == null) {
        localObject = paramqq.a(paramqk, localafm, paramqc);
      }
      return new vc(paramada, (qu)localObject, localrw);
    }
  }
  
  public qu<?> a(qk paramqk, qq paramqq, adc paramadc, qc paramqc)
    throws qw
  {
    paramadc = (adc)a(paramqk, paramadc);
    xq localxq = (xq)paramqk.c(paramadc.p());
    Object localObject = a(paramqk, localxq.c(), paramqc);
    if (localObject != null) {
      return (qu<?>)localObject;
    }
    localObject = (adc)a(paramqk, localxq.c(), paramadc, null);
    afm localafm = ((adc)localObject).g();
    qu localqu = (qu)localafm.n();
    paramadc = (rw)localafm.o();
    if (paramadc == null) {
      paramadc = b(paramqk, localafm, paramqc);
    }
    for (;;)
    {
      return a((adc)localObject, paramqk, paramqq, localxq, paramqc, paramadc, localqu);
    }
  }
  
  public qu<?> a(qk paramqk, qq paramqq, add paramadd, qc paramqc)
    throws qw
  {
    paramadd = (add)a(paramqk, paramadd);
    Class localClass = paramadd.p();
    xq localxq = (xq)paramqk.c(paramadd);
    Object localObject = a(paramqk, localxq.c(), paramqc);
    if (localObject != null) {
      return (qu<?>)localObject;
    }
    add localadd = (add)a(paramqk, localxq.c(), paramadd, null);
    afm localafm = localadd.g();
    qu localqu1 = (qu)localafm.n();
    paramadd = (rw)localafm.o();
    if (paramadd == null) {
      paramadd = b(paramqk, localafm, paramqc);
    }
    for (;;)
    {
      qu localqu2 = a(localadd, paramqk, paramqq, localxq, paramqc, paramadd, localqu1);
      localObject = localqu2;
      if (localqu2 != null) {
        break;
      }
      localObject = localqu1;
      if (localqu1 == null)
      {
        if (EnumSet.class.isAssignableFrom(localClass)) {
          return new ul(localafm.p(), b(paramqk, paramqq, localafm, paramqc));
        }
        localObject = paramqq.a(paramqk, localafm, paramqc);
      }
      if (!localadd.s())
      {
        paramqq = localadd;
        paramqc = localxq;
        if (!localadd.c()) {}
      }
      else
      {
        paramqq = (Class)e.get(localClass.getName());
        if (paramqq == null) {
          throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + localadd);
        }
        paramqq = (add)paramqk.a(localadd, paramqq);
        paramqc = (xq)paramqk.c(paramqq);
      }
      paramqk = a(paramqk, paramqc);
      if (localafm.p() == String.class) {
        return new wx(paramqq, (qu)localObject, paramqk);
      }
      return new uf(paramqq, (qu)localObject, paramadd, paramqk);
    }
  }
  
  public qu<?> a(qk paramqk, qq paramqq, adf paramadf, qc paramqc)
    throws qw
  {
    paramadf = (adf)a(paramqk, paramadf);
    xq localxq = (xq)paramqk.c(paramadf);
    Object localObject = a(paramqk, localxq.c(), paramqc);
    if (localObject != null) {
      return (qu<?>)localObject;
    }
    adf localadf = (adf)a(paramqk, localxq.c(), paramadf, null);
    localObject = localadf.k();
    afm localafm = localadf.g();
    qu localqu = (qu)localafm.n();
    paramadf = (rc)((afm)localObject).n();
    if (paramadf == null) {
      paramadf = paramqq.c(paramqk, (afm)localObject, paramqc);
    }
    for (;;)
    {
      localObject = (rw)localafm.o();
      if (localObject == null) {
        localObject = b(paramqk, localafm, paramqc);
      }
      for (;;)
      {
        return a(localadf, paramqk, paramqq, localxq, paramqc, paramadf, (rw)localObject, localqu);
      }
    }
  }
  
  public qu<?> a(qk paramqk, qq paramqq, adg paramadg, qc paramqc)
    throws qw
  {
    paramadg = (adg)a(paramqk, paramadg);
    xq localxq = (xq)paramqk.c(paramadg);
    Object localObject1 = a(paramqk, localxq.c(), paramqc);
    if (localObject1 != null) {
      return (qu<?>)localObject1;
    }
    adg localadg = (adg)a(paramqk, localxq.c(), paramadg, null);
    afm localafm1 = localadg.k();
    afm localafm2 = localadg.g();
    Object localObject2 = (qu)localafm2.n();
    paramadg = (rc)localafm1.n();
    if (paramadg == null) {
      paramadg = paramqq.c(paramqk, localafm1, paramqc);
    }
    for (;;)
    {
      rw localrw = (rw)localafm2.o();
      if (localrw == null) {
        localrw = b(paramqk, localafm2, paramqc);
      }
      for (;;)
      {
        qu localqu = a(localadg, paramqk, paramqq, localxq, paramqc, paramadg, localrw, (qu)localObject2);
        localObject1 = localqu;
        if (localqu != null) {
          break;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramqq.a(paramqk, localafm2, paramqc);
        }
        localObject2 = localadg.p();
        if (EnumMap.class.isAssignableFrom((Class)localObject2))
        {
          paramadg = localafm1.p();
          if ((paramadg == null) || (!paramadg.isEnum())) {
            throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
          }
          return new uk(localafm1.p(), b(paramqk, paramqq, localafm1, paramqc), (qu)localObject1);
        }
        if ((localadg.s()) || (localadg.c()))
        {
          paramqq = (Class)d.get(((Class)localObject2).getName());
          if (paramqq == null) {
            throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + localadg);
          }
          paramqc = (adg)paramqk.a(localadg, paramqq);
          paramqq = (xq)paramqk.c(paramqc);
        }
        for (;;)
        {
          paramadg = new vb(paramqc, a(paramqk, paramqq), paramadg, (qu)localObject1, localrw);
          paramadg.a(paramqk.a().c(paramqq.c()));
          return paramadg;
          paramqq = localxq;
          paramqc = localadg;
        }
      }
    }
  }
  
  protected qu<Object> a(qk paramqk, xg paramxg, qc paramqc)
    throws qw
  {
    Object localObject = paramqk.a().h(paramxg);
    if (localObject != null) {
      return a(paramqk, paramxg, paramqc, localObject);
    }
    return null;
  }
  
  qu<Object> a(qk paramqk, xg paramxg, qc paramqc, Object paramObject)
    throws qw
  {
    if ((paramObject instanceof qu))
    {
      paramObject = (qu)paramObject;
      paramxg = (xg)paramObject;
      if ((paramObject instanceof qh)) {
        paramxg = ((qh)paramObject).a(paramqk, paramqc);
      }
      return paramxg;
    }
    if (!(paramObject instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
    }
    paramObject = (Class)paramObject;
    if (!qu.class.isAssignableFrom((Class)paramObject)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)paramObject).getName() + "; expected Class<JsonDeserializer>");
    }
    paramObject = paramqk.a(paramxg, (Class)paramObject);
    paramxg = (xg)paramObject;
    if ((paramObject instanceof qh)) {
      paramxg = ((qh)paramObject).a(paramqk, paramqc);
    }
    return paramxg;
  }
  
  protected abstract qu<?> a(Class<? extends ou> paramClass, qk paramqk, qc paramqc)
    throws qw;
  
  protected abstract qu<?> a(Class<?> paramClass, qk paramqk, xq paramxq, qc paramqc)
    throws qw;
  
  public rw a(qk paramqk, afm paramafm, xk paramxk, qc paramqc)
    throws qw
  {
    py localpy = paramqk.a();
    yj localyj = localpy.a(paramqk, paramxk, paramafm);
    if (localyj == null) {
      return b(paramqk, paramafm, paramqc);
    }
    return localyj.a(paramqk, paramafm, paramqk.l().a(paramxk, paramqk, localpy), paramqc);
  }
  
  public abstract th a(qk paramqk, xq paramxq)
    throws qw;
  
  public qu<?> b(qk paramqk, qq paramqq, afm paramafm, qc paramqc)
    throws qw
  {
    paramqq = (xq)paramqk.c(paramafm);
    qu localqu = a(paramqk, paramqq.c(), paramqc);
    if (localqu != null) {
      return localqu;
    }
    paramafm = paramafm.p();
    paramqc = a(paramafm, paramqk, paramqq, paramqc);
    if (paramqc != null) {
      return paramqc;
    }
    paramqq = paramqq.o().iterator();
    while (paramqq.hasNext())
    {
      paramqc = (xl)paramqq.next();
      if (paramqk.a().k(paramqc))
      {
        if ((paramqc.f() == 1) && (paramqc.d().isAssignableFrom(paramafm))) {
          return ui.a(paramqk, paramafm, paramqc);
        }
        throw new IllegalArgumentException("Unsuitable method (" + paramqc + ") decorated with @JsonCreator (for Enum type " + paramafm.getName() + ")");
      }
    }
    return new ui(a(paramafm, paramqk));
  }
  
  public rw b(qk paramqk, afm paramafm, qc paramqc)
    throws qw
  {
    Object localObject1 = ((xq)paramqk.c(paramafm.p())).c();
    Object localObject2 = paramqk.a();
    yj localyj = ((py)localObject2).a(paramqk, (xh)localObject1, paramafm);
    if (localyj == null)
    {
      localyj = paramqk.d(paramafm);
      if (localyj != null) {
        break label151;
      }
      return null;
    }
    label151:
    for (localObject1 = paramqk.l().a((xh)localObject1, paramqk, (py)localObject2);; localObject1 = null)
    {
      localObject2 = localyj;
      if (localyj.a() == null)
      {
        localObject2 = localyj;
        if (paramafm.c())
        {
          afm localafm = a(paramqk, paramafm);
          localObject2 = localyj;
          if (localafm != null)
          {
            localObject2 = localyj;
            if (localafm.p() != paramafm.p()) {
              localObject2 = localyj.a(localafm.p());
            }
          }
        }
      }
      return ((yj)localObject2).a(paramqk, paramafm, (Collection)localObject1, paramqc);
    }
  }
  
  public rw b(qk paramqk, afm paramafm, xk paramxk, qc paramqc)
    throws qw
  {
    py localpy = paramqk.a();
    yj localyj = localpy.b(paramqk, paramxk, paramafm);
    paramafm = paramafm.g();
    if (localyj == null) {
      return b(paramqk, paramafm, paramqc);
    }
    return localyj.a(paramqk, paramafm, paramqk.l().a(paramxk, paramqk, localpy), paramqc);
  }
  
  public qu<?> c(qk paramqk, qq paramqq, afm paramafm, qc paramqc)
    throws qw
  {
    paramqq = paramafm.p();
    paramqk = a(paramqq, paramqk, paramqc);
    if (paramqk != null) {
      return paramqk;
    }
    return ux.a(paramqq);
  }
  
  protected qu<Object> d(qk paramqk, qq paramqq, afm paramafm, qc paramqc)
    throws qw
  {
    Class localClass = paramafm.p();
    qu localqu = (qu)b.get(new adb(localClass));
    if (localqu != null) {
      paramqk = localqu;
    }
    do
    {
      return paramqk;
      if (AtomicReference.class.isAssignableFrom(localClass))
      {
        paramqk = paramqk.m().b(paramafm, AtomicReference.class);
        if ((paramqk == null) || (paramqk.length < 1)) {}
        for (paramqk = adk.b();; paramqk = paramqk[0]) {
          return new ua(paramqk, paramqc);
        }
      }
      paramqq = this.g.a(paramafm, paramqk, paramqq);
      paramqk = paramqq;
    } while (paramqq != null);
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/so.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */