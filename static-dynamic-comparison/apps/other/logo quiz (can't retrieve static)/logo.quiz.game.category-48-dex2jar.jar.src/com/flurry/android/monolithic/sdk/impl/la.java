package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class la<D>
{
  private final kq a;
  private ji b;
  
  protected la(ji paramji, kq paramkq)
  {
    this(paramkq);
    a(paramji);
  }
  
  protected la(kq paramkq)
  {
    this.a = paramkq;
  }
  
  private void b(ji paramji, Object paramObject)
  {
    throw new jh("Not a " + paramji + ": " + paramObject);
  }
  
  protected int a(ji paramji, Object paramObject)
  {
    return this.a.a(paramji, paramObject);
  }
  
  protected long a(Object paramObject)
  {
    return ((Collection)paramObject).size();
  }
  
  protected NullPointerException a(NullPointerException paramNullPointerException, String paramString)
  {
    paramString = new NullPointerException(paramNullPointerException.getMessage() + paramString);
    if (paramNullPointerException.getCause() == null) {}
    for (;;)
    {
      paramString.initCause(paramNullPointerException);
      return paramString;
      paramNullPointerException = paramNullPointerException.getCause();
    }
  }
  
  public void a(ji paramji)
  {
    this.b = paramji;
  }
  
  protected void a(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    for (;;)
    {
      try
      {
        switch (lb.a[paramji.a().ordinal()])
        {
        case 1: 
          b(paramji, paramObject);
          return;
        }
      }
      catch (NullPointerException paramObject)
      {
        throw a((NullPointerException)paramObject, " of " + paramji.g());
      }
      b(paramji, paramObject, parammc);
      return;
      c(paramji, paramObject, parammc);
      return;
      d(paramji, paramObject, parammc);
      return;
      e(paramji, paramObject, parammc);
      return;
      int i = a(paramji, paramObject);
      parammc.b(i);
      a((ji)paramji.k().get(i), paramObject, parammc);
      return;
      g(paramji, paramObject, parammc);
      return;
      f(paramji, paramObject, parammc);
      return;
      c(paramObject, parammc);
      return;
      parammc.c(((Number)paramObject).intValue());
      return;
      parammc.b(((Long)paramObject).longValue());
      return;
      parammc.a(((Float)paramObject).floatValue());
      return;
      parammc.a(((Double)paramObject).doubleValue());
      return;
      parammc.a(((Boolean)paramObject).booleanValue());
      return;
      parammc.a();
      return;
    }
  }
  
  public void a(D paramD, mc parammc)
    throws IOException
  {
    a(this.b, paramD, parammc);
  }
  
  protected Iterator<? extends Object> b(Object paramObject)
  {
    return ((Collection)paramObject).iterator();
  }
  
  protected void b(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    Object localObject1 = this.a.a(paramObject, paramji);
    Iterator localIterator = paramji.b().iterator();
    while (localIterator.hasNext())
    {
      paramji = (js)localIterator.next();
      Object localObject2 = this.a.b(paramObject, paramji.a(), paramji.b(), localObject1);
      try
      {
        a(paramji.c(), localObject2, parammc);
      }
      catch (NullPointerException paramObject)
      {
        throw a((NullPointerException)paramObject, " in field " + paramji.a());
      }
    }
  }
  
  protected void b(Object paramObject, mc parammc)
    throws IOException
  {
    parammc.a((CharSequence)paramObject);
  }
  
  protected int c(Object paramObject)
  {
    return ((Map)paramObject).size();
  }
  
  protected void c(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    parammc.a(paramji.c(paramObject.toString()));
  }
  
  protected void c(Object paramObject, mc parammc)
    throws IOException
  {
    parammc.a((ByteBuffer)paramObject);
  }
  
  protected Iterable<Map.Entry<Object, Object>> d(Object paramObject)
  {
    return ((Map)paramObject).entrySet();
  }
  
  protected void d(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    paramji = paramji.i();
    long l = a(paramObject);
    parammc.b();
    parammc.a(l);
    paramObject = b(paramObject);
    while (((Iterator)paramObject).hasNext())
    {
      parammc.c();
      a(paramji, ((Iterator)paramObject).next(), parammc);
    }
    parammc.d();
  }
  
  protected void e(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    paramji = paramji.j();
    int i = c(paramObject);
    parammc.e();
    parammc.a(i);
    paramObject = d(paramObject).iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      parammc.c();
      b(localEntry.getKey(), parammc);
      a(paramji, localEntry.getValue(), parammc);
    }
    parammc.f();
  }
  
  protected void f(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    b(paramObject, parammc);
  }
  
  protected void g(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    parammc.b(((ld)paramObject).b(), 0, paramji.l());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */