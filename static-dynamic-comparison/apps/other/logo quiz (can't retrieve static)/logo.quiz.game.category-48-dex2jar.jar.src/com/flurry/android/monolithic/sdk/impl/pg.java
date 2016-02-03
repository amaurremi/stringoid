package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class pg
  extends or
{
  protected pc b;
  protected int c;
  protected boolean d;
  protected pl e;
  protected boolean f;
  
  protected pg(int paramInt, pc parampc)
  {
    this.c = paramInt;
    this.e = pl.g();
    this.b = parampc;
    this.d = a(os.e);
  }
  
  public or a()
  {
    return a(new afs());
  }
  
  public void a(ou paramou)
    throws IOException, oz
  {
    if (paramou == null)
    {
      f();
      return;
    }
    if (this.b == null) {
      throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
    }
    this.b.a(this, paramou);
  }
  
  public void a(Object paramObject)
    throws IOException, oz
  {
    if (paramObject == null)
    {
      f();
      return;
    }
    if (this.b != null)
    {
      this.b.a(this, paramObject);
      return;
    }
    b(paramObject);
  }
  
  public final boolean a(os paramos)
  {
    return (this.c & paramos.c()) != 0;
  }
  
  public void b()
    throws IOException, oq
  {
    h("start an array");
    this.e = this.e.h();
    if (this.a != null)
    {
      this.a.e(this);
      return;
    }
    i();
  }
  
  protected void b(Object paramObject)
    throws IOException, oq
  {
    if (paramObject == null)
    {
      f();
      return;
    }
    if ((paramObject instanceof String))
    {
      b((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      Number localNumber = (Number)paramObject;
      if ((localNumber instanceof Integer))
      {
        b(localNumber.intValue());
        return;
      }
      if ((localNumber instanceof Long))
      {
        a(localNumber.longValue());
        return;
      }
      if ((localNumber instanceof Double))
      {
        a(localNumber.doubleValue());
        return;
      }
      if ((localNumber instanceof Float))
      {
        a(localNumber.floatValue());
        return;
      }
      if ((localNumber instanceof Short))
      {
        b(localNumber.shortValue());
        return;
      }
      if ((localNumber instanceof Byte))
      {
        b(localNumber.byteValue());
        return;
      }
      if ((localNumber instanceof BigInteger))
      {
        a((BigInteger)localNumber);
        return;
      }
      if ((localNumber instanceof BigDecimal))
      {
        a((BigDecimal)localNumber);
        return;
      }
      if ((localNumber instanceof AtomicInteger))
      {
        b(((AtomicInteger)localNumber).get());
        return;
      }
      if ((localNumber instanceof AtomicLong)) {
        a(((AtomicLong)localNumber).get());
      }
    }
    else
    {
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        a(((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof AtomicBoolean))
      {
        a(((AtomicBoolean)paramObject).get());
        return;
      }
    }
    throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + paramObject.getClass().getName() + ")");
  }
  
  public void c()
    throws IOException, oq
  {
    if (!this.e.a()) {
      i("Current context not an ARRAY but " + this.e.d());
    }
    if (this.a != null) {
      this.a.b(this, this.e.e());
    }
    for (;;)
    {
      this.e = this.e.j();
      return;
      j();
    }
  }
  
  public void close()
    throws IOException
  {
    this.f = true;
  }
  
  public void d()
    throws IOException, oq
  {
    h("start an object");
    this.e = this.e.i();
    if (this.a != null)
    {
      this.a.b(this);
      return;
    }
    k();
  }
  
  public void d(String paramString)
    throws IOException, oq
  {
    h("write raw value");
    c(paramString);
  }
  
  public void e()
    throws IOException, oq
  {
    if (!this.e.c()) {
      i("Current context not an object but " + this.e.d());
    }
    this.e = this.e.j();
    if (this.a != null)
    {
      this.a.a(this, this.e.e());
      return;
    }
    l();
  }
  
  public final pl h()
  {
    return this.e;
  }
  
  protected abstract void h(String paramString)
    throws IOException, oq;
  
  @Deprecated
  protected void i()
    throws IOException, oq
  {}
  
  protected void i(String paramString)
    throws oq
  {
    throw new oq(paramString);
  }
  
  @Deprecated
  protected void j()
    throws IOException, oq
  {}
  
  @Deprecated
  protected void k()
    throws IOException, oq
  {}
  
  @Deprecated
  protected void l()
    throws IOException, oq
  {}
  
  protected void m()
  {
    throw new RuntimeException("Internal error: should never end up through this code path");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */