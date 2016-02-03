package com.flurry.android.monolithic.sdk.impl;

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

public abstract class zd
  extends rs
{
  protected static final HashMap<String, ra<?>> a = new HashMap();
  protected static final HashMap<String, Class<? extends ra<?>>> b = new HashMap();
  protected static final HashMap<String, ra<?>> c;
  protected xf d = xf.a;
  
  static
  {
    a.put(String.class.getName(), new acw());
    Object localObject1 = acy.a;
    a.put(StringBuffer.class.getName(), localObject1);
    a.put(StringBuilder.class.getName(), localObject1);
    a.put(Character.class.getName(), localObject1);
    a.put(Character.TYPE.getName(), localObject1);
    a.put(Boolean.TYPE.getName(), new zz(true));
    a.put(Boolean.class.getName(), new zz(false));
    localObject1 = new aad();
    a.put(Integer.class.getName(), localObject1);
    a.put(Integer.TYPE.getName(), localObject1);
    a.put(Long.class.getName(), aae.a);
    a.put(Long.TYPE.getName(), aae.a);
    a.put(Byte.class.getName(), aac.a);
    a.put(Byte.TYPE.getName(), aac.a);
    a.put(Short.class.getName(), aac.a);
    a.put(Short.TYPE.getName(), aac.a);
    a.put(Float.class.getName(), aab.a);
    a.put(Float.TYPE.getName(), aab.a);
    a.put(Double.class.getName(), aaa.a);
    a.put(Double.TYPE.getName(), aaa.a);
    localObject1 = new aaf();
    a.put(BigInteger.class.getName(), localObject1);
    a.put(BigDecimal.class.getName(), localObject1);
    a.put(Calendar.class.getName(), aba.a);
    localObject1 = abd.a;
    a.put(java.util.Date.class.getName(), localObject1);
    a.put(Timestamp.class.getName(), localObject1);
    a.put(java.sql.Date.class.getName(), new aag());
    a.put(Time.class.getName(), new aah());
    localObject1 = new acj().a().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = localEntry.getValue();
      if ((localObject2 instanceof ra))
      {
        a.put(((Class)localEntry.getKey()).getName(), (ra)localObject2);
      }
      else if ((localObject2 instanceof Class))
      {
        localObject2 = (Class)localObject2;
        b.put(((Class)localEntry.getKey()).getName(), localObject2);
      }
      else
      {
        throw new IllegalStateException("Internal error: unrecognized value of type " + localEntry.getClass().getName());
      }
    }
    b.put(afz.class.getName(), acz.class);
    c = new HashMap();
    c.put(boolean[].class.getName(), new abx());
    c.put(byte[].class.getName(), new aby());
    c.put(char[].class.getName(), new abz());
    c.put(short[].class.getName(), new ace());
    c.put(int[].class.getName(), new acc());
    c.put(long[].class.getName(), new acd());
    c.put(float[].class.getName(), new acb());
    c.put(double[].class.getName(), new aca());
  }
  
  /* Error */
  protected static <T extends afm> T b(rq paramrq, xg paramxg, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 250	com/flurry/android/monolithic/sdk/impl/rq:a	()Lcom/flurry/android/monolithic/sdk/impl/py;
    //   4: astore 4
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: invokevirtual 255	com/flurry/android/monolithic/sdk/impl/afm:f	()Z
    //   12: ifeq +93 -> 105
    //   15: aload 4
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 259	com/flurry/android/monolithic/sdk/impl/afm:k	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   22: invokevirtual 264	com/flurry/android/monolithic/sdk/impl/py:a	(Lcom/flurry/android/monolithic/sdk/impl/xg;Lcom/flurry/android/monolithic/sdk/impl/afm;)Ljava/lang/Class;
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +53 -> 82
    //   32: aload_2
    //   33: instanceof 266
    //   36: ifne +37 -> 73
    //   39: new 245	java/lang/IllegalArgumentException
    //   42: dup
    //   43: new 47	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 268
    //   53: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: ldc_w 273
    //   63: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 274	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: aload_2
    //   74: checkcast 266	com/flurry/android/monolithic/sdk/impl/adg
    //   77: aload_3
    //   78: invokevirtual 278	com/flurry/android/monolithic/sdk/impl/adg:e	(Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   81: astore_0
    //   82: aload 4
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 281	com/flurry/android/monolithic/sdk/impl/afm:g	()Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   89: invokevirtual 283	com/flurry/android/monolithic/sdk/impl/py:b	(Lcom/flurry/android/monolithic/sdk/impl/xg;Lcom/flurry/android/monolithic/sdk/impl/afm;)Ljava/lang/Class;
    //   92: astore_1
    //   93: aload_0
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull +9 -> 105
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 285	com/flurry/android/monolithic/sdk/impl/afm:c	(Ljava/lang/Class;)Lcom/flurry/android/monolithic/sdk/impl/afm;
    //   104: astore_3
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: new 245	java/lang/IllegalArgumentException
    //   111: dup
    //   112: new 47	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 287
    //   122: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: ldc_w 289
    //   132: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 291
    //   145: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 294	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 274	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_2
    //   163: new 245	java/lang/IllegalArgumentException
    //   166: dup
    //   167: new 47	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 296
    //   177: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w 298
    //   187: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
    //   194: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 291
    //   200: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 294	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 274	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramrq	rq
    //   0	217	1	paramxg	xg
    //   0	217	2	paramT	T
    //   7	129	3	localObject	Object
    //   4	79	4	localpy	py
    // Exception table:
    //   from	to	target	type
    //   73	82	107	java/lang/IllegalArgumentException
    //   99	105	162	java/lang/IllegalArgumentException
  }
  
  protected static ra<Object> b(rq paramrq, xg paramxg, qc paramqc)
  {
    py localpy = paramrq.a();
    Class localClass2 = localpy.c(paramxg);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != rb.class) {}
    }
    else
    {
      localClass1 = localClass2;
      if (paramqc != null) {
        localClass1 = localpy.c(paramqc.b());
      }
    }
    if ((localClass1 != null) && (localClass1 != rb.class)) {
      return paramrq.a(paramxg, localClass1);
    }
    return null;
  }
  
  protected static ra<Object> c(rq paramrq, xg paramxg, qc paramqc)
  {
    py localpy = paramrq.a();
    Class localClass2 = localpy.d(paramxg);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != rb.class) {}
    }
    else
    {
      localClass1 = localClass2;
      if (paramqc != null) {
        localClass1 = localpy.d(paramqc.b());
      }
    }
    if ((localClass1 != null) && (localClass1 != rb.class)) {
      return paramrq.a(paramxg, localClass1);
    }
    return null;
  }
  
  protected <T extends afm> T a(rq paramrq, xg paramxg, T paramT)
  {
    Class localClass = paramrq.a().e(paramxg);
    Object localObject = paramT;
    if (localClass != null) {}
    try
    {
      localObject = paramT.h(localClass);
      return b(paramrq, paramxg, (afm)localObject);
    }
    catch (IllegalArgumentException paramrq)
    {
      throw new IllegalArgumentException("Failed to widen type " + paramT + " with concrete-type annotation (value " + localClass.getName() + "), method '" + paramxg.b() + "': " + paramrq.getMessage());
    }
  }
  
  public final ra<?> a(afm paramafm, rq paramrq, xq paramxq, qc paramqc, boolean paramBoolean)
  {
    paramafm = paramafm.p().getName();
    paramrq = (ra)a.get(paramafm);
    if (paramrq != null) {
      return paramrq;
    }
    paramafm = (Class)b.get(paramafm);
    if (paramafm != null) {
      try
      {
        paramrq = (ra)paramafm.newInstance();
        return paramrq;
      }
      catch (Exception paramrq)
      {
        throw new IllegalStateException("Failed to instantiate standard serializer (of type " + paramafm.getName() + "): " + paramrq.getMessage(), paramrq);
      }
    }
    return null;
  }
  
  protected ra<?> a(rq paramrq, ada paramada, xq paramxq, qc paramqc, boolean paramBoolean, rx paramrx, ra<Object> paramra)
  {
    paramrq = paramada.p();
    if (String[].class == paramrq) {
      paramrq = new acf(paramqc);
    }
    do
    {
      return paramrq;
      paramxq = (ra)c.get(paramrq.getName());
      paramrq = paramxq;
    } while (paramxq != null);
    return new abo(paramada.g(), paramBoolean, paramrx, paramqc, paramra);
  }
  
  protected ra<?> a(rq paramrq, adc paramadc, xq paramxq, qc paramqc, boolean paramBoolean, rx paramrx, ra<Object> paramra)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ra localra = ((rv)localIterator.next()).a(paramrq, paramadc, paramxq, paramqc, paramrx, paramra);
      if (localra != null) {
        return localra;
      }
    }
    return null;
  }
  
  protected ra<?> a(rq paramrq, add paramadd, xq paramxq, qc paramqc, boolean paramBoolean, rx paramrx, ra<Object> paramra)
  {
    Object localObject = a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ra localra = ((rv)((Iterator)localObject).next()).a(paramrq, paramadd, paramxq, paramqc, paramrx, paramra);
      if (localra != null) {
        return localra;
      }
    }
    localObject = paramadd.p();
    if (EnumSet.class.isAssignableFrom((Class)localObject)) {
      return a(paramrq, paramadd, paramxq, paramqc, paramBoolean, paramrx, paramra);
    }
    paramrq = paramadd.g().p();
    if (a((Class)localObject))
    {
      if (paramrq == String.class) {
        return new abh(paramqc);
      }
      return acg.a(paramadd.g(), paramBoolean, paramrx, paramqc, paramra);
    }
    if (paramrq == String.class) {
      return new acv(paramqc);
    }
    return acg.b(paramadd.g(), paramBoolean, paramrx, paramqc, paramra);
  }
  
  protected ra<?> a(rq paramrq, adf paramadf, xq paramxq, qc paramqc, boolean paramBoolean, ra<Object> paramra1, rx paramrx, ra<Object> paramra2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ra localra = ((rv)localIterator.next()).a(paramrq, paramadf, paramxq, paramqc, paramra1, paramrx, paramra2);
      if (localra != null) {
        return localra;
      }
    }
    return null;
  }
  
  protected ra<?> a(rq paramrq, adg paramadg, xq paramxq, qc paramqc, boolean paramBoolean, ra<Object> paramra1, rx paramrx, ra<Object> paramra2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ra localra = ((rv)localIterator.next()).a(paramrq, paramadg, paramxq, paramqc, paramra1, paramrx, paramra2);
      if (localra != null) {
        return localra;
      }
    }
    if (EnumMap.class.isAssignableFrom(paramadg.p())) {
      return b(paramrq, paramadg, paramxq, paramqc, paramBoolean, paramrx, paramra2);
    }
    return abl.a(paramrq.a().c(paramxq.c()), paramadg, paramBoolean, paramrx, paramqc, paramra1, paramra2);
  }
  
  public final ra<?> a(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean)
    throws qw
  {
    Class localClass = paramafm.p();
    if (Iterator.class.isAssignableFrom(localClass)) {
      return c(paramrq, paramafm, paramxq, paramqc, paramBoolean);
    }
    if (Iterable.class.isAssignableFrom(localClass)) {
      return d(paramrq, paramafm, paramxq, paramqc, paramBoolean);
    }
    if (CharSequence.class.isAssignableFrom(localClass)) {
      return acy.a;
    }
    return null;
  }
  
  protected ra<?> a(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean, rx paramrx, ra<Object> paramra)
  {
    paramafm = paramafm.g();
    paramrq = paramafm;
    if (!paramafm.r()) {
      paramrq = null;
    }
    return acg.a(paramrq, paramqc);
  }
  
  protected ra<Object> a(rq paramrq, xg paramxg, qc paramqc)
    throws qw
  {
    Object localObject = paramrq.a().b(paramxg);
    if (localObject == null) {
      paramxg = null;
    }
    do
    {
      do
      {
        return paramxg;
        if (!(localObject instanceof ra)) {
          break;
        }
        localObject = (ra)localObject;
        paramxg = (xg)localObject;
      } while (!(localObject instanceof qj));
      return ((qj)localObject).a(paramrq, paramqc);
      if (!(localObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned value of type " + localObject.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      localObject = (Class)localObject;
      if (!ra.class.isAssignableFrom((Class)localObject)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)localObject).getName() + "; expected Class<JsonSerializer>");
      }
      localObject = paramrq.a(paramxg, (Class)localObject);
      paramxg = (xg)localObject;
    } while (!(localObject instanceof qj));
    return ((qj)localObject).a(paramrq, paramqc);
  }
  
  protected abstract Iterable<rv> a();
  
  protected boolean a(rq paramrq, xq paramxq, rx paramrx, qc paramqc)
  {
    if (paramrx != null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramrx = paramrq.a();
          paramxq = paramrx.f(paramxq.c());
          if (paramxq != null)
          {
            if (paramxq == sg.b) {
              return true;
            }
          }
          else if (paramrq.a(rr.h)) {
            return true;
          }
        } while (paramqc == null);
        paramrq = paramqc.a();
      } while (!paramrq.f());
      if (paramrx.b(paramqc.b(), paramqc.a()) != null) {
        return true;
      }
    } while ((!(paramrq instanceof adg)) || (paramrx.a(paramqc.b(), paramqc.a()) == null));
    return true;
  }
  
  protected boolean a(Class<?> paramClass)
  {
    return RandomAccess.class.isAssignableFrom(paramClass);
  }
  
  public final ra<?> b(afm paramafm, rq paramrq, xq paramxq, qc paramqc, boolean paramBoolean)
    throws qw
  {
    Class localClass = paramafm.p();
    if (qy.class.isAssignableFrom(localClass)) {
      if (qz.class.isAssignableFrom(localClass)) {
        paramafm = abs.a;
      }
    }
    do
    {
      return paramafm;
      return abr.a;
      xl localxl = paramxq.e();
      if (localxl != null)
      {
        paramafm = localxl.e();
        if (paramrq.a(rr.e)) {
          adz.a(paramafm);
        }
        return new abk(paramafm, a(paramrq, localxl, paramqc), paramqc);
      }
      if (InetAddress.class.isAssignableFrom(localClass)) {
        return abi.a;
      }
      if (TimeZone.class.isAssignableFrom(localClass)) {
        return acx.a;
      }
      if (Charset.class.isAssignableFrom(localClass)) {
        return acy.a;
      }
      paramqc = this.d.a(paramrq, paramafm);
      paramafm = paramqc;
    } while (paramqc != null);
    if (Number.class.isAssignableFrom(localClass)) {
      return aaf.a;
    }
    if (Enum.class.isAssignableFrom(localClass)) {
      return abf.a(localClass, paramrq, paramxq);
    }
    if (Calendar.class.isAssignableFrom(localClass)) {
      return aba.a;
    }
    if (java.util.Date.class.isAssignableFrom(localClass)) {
      return abd.a;
    }
    return null;
  }
  
  public ra<?> b(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean)
  {
    rx localrx = b(paramrq, paramafm.g(), paramqc);
    if (localrx != null) {
      paramBoolean = false;
    }
    for (;;)
    {
      ra localra1 = c(paramrq, paramxq.c(), paramqc);
      if (paramafm.j())
      {
        paramafm = (adf)paramafm;
        ra localra2 = b(paramrq, paramxq.c(), paramqc);
        if (paramafm.l())
        {
          return a(paramrq, (adg)paramafm, paramxq, paramqc, paramBoolean, localra2, localrx, localra1);
          if (!paramBoolean) {
            paramBoolean = a(paramrq, paramxq, localrx, paramqc);
          }
        }
        else
        {
          return a(paramrq, paramafm, paramxq, paramqc, paramBoolean, localra2, localrx, localra1);
        }
      }
      else
      {
        if (paramafm.i())
        {
          paramafm = (adc)paramafm;
          if (paramafm.a_()) {
            return a(paramrq, (add)paramafm, paramxq, paramqc, paramBoolean, localrx, localra1);
          }
          return a(paramrq, paramafm, paramxq, paramqc, paramBoolean, localrx, localra1);
        }
        if (paramafm.b()) {
          return a(paramrq, (ada)paramafm, paramxq, paramqc, paramBoolean, localrx, localra1);
        }
        return null;
      }
    }
  }
  
  protected ra<?> b(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean, rx paramrx, ra<Object> paramra)
  {
    afm localafm = paramafm.k();
    paramxq = null;
    if (localafm.r()) {
      paramxq = aee.a(localafm.p(), paramrq.a());
    }
    return new abe(paramafm.g(), paramBoolean, paramxq, paramrx, paramqc, paramra);
  }
  
  public rx b(rq paramrq, afm paramafm, qc paramqc)
  {
    Object localObject = ((xq)paramrq.c(paramafm.p())).c();
    py localpy = paramrq.a();
    yj localyj = localpy.a(paramrq, (xh)localObject, paramafm);
    if (localyj == null) {
      localyj = paramrq.d(paramafm);
    }
    for (localObject = null; localyj == null; localObject = paramrq.l().a((xh)localObject, paramrq, localpy)) {
      return null;
    }
    return localyj.a(paramrq, paramafm, (Collection)localObject, paramqc);
  }
  
  protected ra<?> c(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean)
  {
    Object localObject = paramafm.b(0);
    paramafm = (afm)localObject;
    if (localObject == null) {
      paramafm = adk.b();
    }
    localObject = b(paramrq, paramafm, paramqc);
    return acg.a(paramafm, a(paramrq, paramxq, (rx)localObject, paramqc), (rx)localObject, paramqc);
  }
  
  protected ra<?> d(rq paramrq, afm paramafm, xq paramxq, qc paramqc, boolean paramBoolean)
  {
    Object localObject = paramafm.b(0);
    paramafm = (afm)localObject;
    if (localObject == null) {
      paramafm = adk.b();
    }
    localObject = b(paramrq, paramafm, paramqc);
    return acg.b(paramafm, a(paramrq, paramxq, (rx)localObject, paramqc), (rx)localObject, paramqc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */