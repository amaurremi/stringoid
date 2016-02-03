package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kx<D>
  implements lw<D>
{
  private static final ThreadLocal<Map<ji, Map<ji, mh>>> f = new ky();
  private final kq a;
  private ji b;
  private ji c;
  private mh d = null;
  private final Thread e;
  
  public kx()
  {
    this(null, null, kq.a());
  }
  
  protected kx(ji paramji1, ji paramji2, kq paramkq)
  {
    this.b = paramji1;
    this.c = paramji2;
    this.a = paramkq;
    this.e = Thread.currentThread();
  }
  
  public kq a()
  {
    return this.a;
  }
  
  protected final mh a(ji paramji1, ji paramji2)
    throws IOException
  {
    Thread localThread = Thread.currentThread();
    if ((localThread == this.e) && (this.d != null))
    {
      paramji1 = this.d;
      return paramji1;
    }
    Object localObject = (Map)((Map)f.get()).get(paramji1);
    if (localObject == null)
    {
      localObject = new nx();
      ((Map)f.get()).put(paramji1, localObject);
    }
    for (;;)
    {
      mh localmh2 = (mh)((Map)localObject).get(paramji2);
      mh localmh1 = localmh2;
      if (localmh2 == null)
      {
        localmh1 = ly.a().a(ji.a(paramji1, paramji2), paramji2, null);
        ((Map)localObject).put(paramji2, localmh1);
      }
      paramji1 = localmh1;
      if (localThread != this.e) {
        break;
      }
      this.d = localmh1;
      return localmh1;
    }
  }
  
  protected Object a(ji paramji, lx paramlx)
    throws IOException
  {
    return a((String)paramji.c().get(paramlx.k()), paramji);
  }
  
  protected Object a(Object paramObject)
  {
    if ((paramObject instanceof ko)) {
      return ((ko)paramObject).b();
    }
    return null;
  }
  
  protected Object a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Map))
    {
      ((Map)paramObject).clear();
      return paramObject;
    }
    return new HashMap(paramInt);
  }
  
  protected Object a(Object paramObject, int paramInt, ji paramji)
  {
    if ((paramObject instanceof Collection))
    {
      ((Collection)paramObject).clear();
      return paramObject;
    }
    return new ks(paramInt, paramji);
  }
  
  protected Object a(Object paramObject, ji paramji, lx paramlx)
    throws IOException
  {
    paramObject = (ld)this.a.c(paramObject, paramji);
    paramlx.b(((ld)paramObject).b(), 0, paramji.l());
    return paramObject;
  }
  
  protected Object a(Object paramObject, ji paramji, mh parammh)
    throws IOException
  {
    switch (kz.a[paramji.a().ordinal()])
    {
    default: 
      throw new jg("Unknown type: " + paramji);
    case 1: 
      return b(paramObject, paramji, parammh);
    case 2: 
      return a(paramji, parammh);
    case 3: 
      return c(paramObject, paramji, parammh);
    case 4: 
      return d(paramObject, paramji, parammh);
    case 5: 
      return a(paramObject, (ji)paramji.k().get(parammh.s()), parammh);
    case 6: 
      return a(paramObject, paramji, parammh);
    case 7: 
      return b(paramObject, paramji, parammh);
    case 8: 
      return c(paramObject, parammh);
    case 9: 
      return c(paramObject, paramji, parammh);
    case 10: 
      return Long.valueOf(parammh.e());
    case 11: 
      return Float.valueOf(parammh.f());
    case 12: 
      return Double.valueOf(parammh.g());
    case 13: 
      return Boolean.valueOf(parammh.c());
    }
    parammh.b();
    return null;
  }
  
  public D a(D paramD, lx paramlx)
    throws IOException
  {
    mh localmh = a(this.b, this.c);
    localmh.a(paramlx);
    paramD = a(paramD, this.c, localmh);
    localmh.v();
    return paramD;
  }
  
  protected Object a(String paramString, ji paramji)
  {
    return new ku(paramji, paramString);
  }
  
  protected void a(Object paramObject1, long paramLong, Object paramObject2)
  {
    ((Collection)paramObject1).add(paramObject2);
  }
  
  protected void a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    ((Map)paramObject1).put(paramObject2, paramObject3);
  }
  
  protected Object b(Object paramObject, ji paramji, lx paramlx)
    throws IOException
  {
    kq localkq = this.a;
    localkq = this.a;
    if ("String".equals(paramji.a("avro.java.string"))) {
      return paramlx.h();
    }
    return b(paramObject, paramlx);
  }
  
  protected Object b(Object paramObject, ji paramji, mh parammh)
    throws IOException
  {
    Object localObject1 = this.a.d(paramObject, paramji);
    Object localObject2 = this.a.a(localObject1, paramji);
    js[] arrayOfjs = parammh.u();
    int j = arrayOfjs.length;
    int i = 0;
    if (i < j)
    {
      js localjs = arrayOfjs[i];
      int k = localjs.b();
      String str = localjs.a();
      if (paramObject != null) {}
      for (paramji = this.a.b(localObject1, str, k, localObject2);; paramji = null)
      {
        this.a.a(localObject1, str, k, a(paramji, localjs.c(), parammh), localObject2);
        i += 1;
        break;
      }
    }
    return localObject1;
  }
  
  protected Object b(Object paramObject, lx paramlx)
    throws IOException
  {
    if ((paramObject instanceof nw)) {}
    for (paramObject = (nw)paramObject;; paramObject = null) {
      return paramlx.a((nw)paramObject);
    }
  }
  
  protected Object c(Object paramObject, ji paramji, lx paramlx)
    throws IOException
  {
    return Integer.valueOf(paramlx.d());
  }
  
  protected Object c(Object paramObject, ji paramji, mh parammh)
    throws IOException
  {
    ji localji = paramji.i();
    long l1 = parammh.m();
    long l2 = 0L;
    if (l1 > 0L)
    {
      paramObject = a(paramObject, (int)l1, paramji);
      long l3;
      do
      {
        for (l3 = 0L; l3 < l1; l3 += 1L) {
          a(paramObject, l2 + l3, a(a(paramObject), localji, parammh));
        }
        l2 += l1;
        l3 = parammh.n();
        l1 = l3;
      } while (l3 > 0L);
      return paramObject;
    }
    return a(paramObject, 0, paramji);
  }
  
  protected Object c(Object paramObject, lx paramlx)
    throws IOException
  {
    if ((paramObject instanceof ByteBuffer)) {}
    for (paramObject = (ByteBuffer)paramObject;; paramObject = null) {
      return paramlx.a((ByteBuffer)paramObject);
    }
  }
  
  protected Object d(Object paramObject, ji paramji, mh parammh)
    throws IOException
  {
    ji localji = paramji.j();
    long l1 = parammh.p();
    paramObject = a(paramObject, (int)l1);
    if (l1 > 0L)
    {
      long l2;
      do
      {
        int i = 0;
        while (i < l1)
        {
          a(paramObject, b(null, paramji, parammh), a(null, localji, parammh));
          i += 1;
        }
        l2 = parammh.q();
        l1 = l2;
      } while (l2 > 0L);
    }
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */