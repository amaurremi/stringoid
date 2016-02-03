package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class afz
  extends or
{
  protected static final int b = ;
  protected pc c;
  protected int d;
  protected boolean e;
  protected agc f;
  protected agc g;
  protected int h;
  protected pl i;
  
  public afz(pc parampc)
  {
    this.c = parampc;
    this.d = b;
    this.i = pl.g();
    parampc = new agc();
    this.g = parampc;
    this.f = parampc;
    this.h = 0;
  }
  
  public or a()
  {
    return this;
  }
  
  public ow a(ow paramow)
  {
    agb localagb = new agb(this.f, paramow.a());
    localagb.a(paramow.h());
    return localagb;
  }
  
  public ow a(pc parampc)
  {
    return new agb(this.f, parampc);
  }
  
  public void a(char paramChar)
    throws IOException, oq
  {
    i();
  }
  
  public void a(double paramDouble)
    throws IOException, oq
  {
    a(pb.j, Double.valueOf(paramDouble));
  }
  
  public void a(float paramFloat)
    throws IOException, oq
  {
    a(pb.j, Float.valueOf(paramFloat));
  }
  
  public void a(long paramLong)
    throws IOException, oq
  {
    a(pb.i, Long.valueOf(paramLong));
  }
  
  public void a(on paramon, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, oq
  {
    paramon = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, paramon, 0, paramInt2);
    a(paramon);
  }
  
  public void a(or paramor)
    throws IOException, oq
  {
    agc localagc = this.f;
    int j = -1;
    j += 1;
    if (j >= 16)
    {
      localagc = localagc.a();
      if (localagc == null) {
        label26:
        return;
      }
      j = 0;
    }
    for (;;)
    {
      Object localObject = localagc.a(j);
      if (localObject == null) {
        break label26;
      }
      switch (aga.a[localObject.ordinal()])
      {
      default: 
        throw new RuntimeException("Internal error: should never end up through this code path");
      case 1: 
        paramor.d();
      }
      for (;;)
      {
        break;
        paramor.e();
        continue;
        paramor.b();
        continue;
        paramor.c();
        continue;
        localObject = localagc.b(j);
        if ((localObject instanceof pe))
        {
          paramor.a((pe)localObject);
        }
        else
        {
          paramor.a((String)localObject);
          continue;
          localObject = localagc.b(j);
          if ((localObject instanceof pe))
          {
            paramor.b((pe)localObject);
          }
          else
          {
            paramor.b((String)localObject);
            continue;
            localObject = (Number)localagc.b(j);
            if ((localObject instanceof BigInteger))
            {
              paramor.a((BigInteger)localObject);
            }
            else if ((localObject instanceof Long))
            {
              paramor.a(((Number)localObject).longValue());
            }
            else
            {
              paramor.b(((Number)localObject).intValue());
              continue;
              localObject = localagc.b(j);
              if ((localObject instanceof BigDecimal))
              {
                paramor.a((BigDecimal)localObject);
              }
              else if ((localObject instanceof Float))
              {
                paramor.a(((Float)localObject).floatValue());
              }
              else if ((localObject instanceof Double))
              {
                paramor.a(((Double)localObject).doubleValue());
              }
              else if (localObject == null)
              {
                paramor.f();
              }
              else if ((localObject instanceof String))
              {
                paramor.e((String)localObject);
              }
              else
              {
                throw new oq("Unrecognized value type for VALUE_NUMBER_FLOAT: " + localObject.getClass().getName() + ", can not serialize");
                paramor.a(true);
                continue;
                paramor.a(false);
                continue;
                paramor.f();
                continue;
                paramor.a(localagc.b(j));
              }
            }
          }
        }
      }
    }
  }
  
  public void a(ou paramou)
    throws IOException, oz
  {
    a(pb.g, paramou);
  }
  
  protected final void a(pb parampb)
  {
    parampb = this.g.a(this.h, parampb);
    if (parampb == null)
    {
      this.h += 1;
      return;
    }
    this.g = parampb;
    this.h = 1;
  }
  
  protected final void a(pb parampb, Object paramObject)
  {
    parampb = this.g.a(this.h, parampb, paramObject);
    if (parampb == null)
    {
      this.h += 1;
      return;
    }
    this.g = parampb;
    this.h = 1;
  }
  
  public void a(pe parampe)
    throws IOException, oq
  {
    a(pb.f, parampe);
    this.i.a(parampe.a());
  }
  
  public void a(pw parampw)
    throws IOException, oq
  {
    a(pb.f, parampw);
    this.i.a(parampw.a());
  }
  
  public void a(Object paramObject)
    throws IOException, oz
  {
    a(pb.g, paramObject);
  }
  
  public final void a(String paramString)
    throws IOException, oq
  {
    a(pb.f, paramString);
    this.i.a(paramString);
  }
  
  public void a(BigDecimal paramBigDecimal)
    throws IOException, oq
  {
    if (paramBigDecimal == null)
    {
      f();
      return;
    }
    a(pb.j, paramBigDecimal);
  }
  
  public void a(BigInteger paramBigInteger)
    throws IOException, oq
  {
    if (paramBigInteger == null)
    {
      f();
      return;
    }
    a(pb.i, paramBigInteger);
  }
  
  public void a(boolean paramBoolean)
    throws IOException, oq
  {
    if (paramBoolean) {}
    for (pb localpb = pb.k;; localpb = pb.l)
    {
      a(localpb);
      return;
    }
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, oq
  {
    b(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public final void b()
    throws IOException, oq
  {
    a(pb.d);
    this.i = this.i.h();
  }
  
  public void b(int paramInt)
    throws IOException, oq
  {
    a(pb.i, Integer.valueOf(paramInt));
  }
  
  public void b(ow paramow)
    throws IOException, oz
  {
    switch (aga.a[paramow.e().ordinal()])
    {
    default: 
      throw new RuntimeException("Internal error: should never end up through this code path");
    case 1: 
      d();
      return;
    case 2: 
      e();
      return;
    case 3: 
      b();
      return;
    case 4: 
      c();
      return;
    case 5: 
      a(paramow.g());
      return;
    case 6: 
      if (paramow.o())
      {
        a(paramow.l(), paramow.n(), paramow.m());
        return;
      }
      b(paramow.k());
      return;
    case 7: 
      switch (aga.b[paramow.q().ordinal()])
      {
      default: 
        a(paramow.u());
        return;
      case 1: 
        b(paramow.t());
        return;
      }
      a(paramow.v());
      return;
    case 8: 
      switch (aga.b[paramow.q().ordinal()])
      {
      default: 
        a(paramow.x());
        return;
      case 3: 
        a(paramow.y());
        return;
      }
      a(paramow.w());
      return;
    case 9: 
      a(true);
      return;
    case 10: 
      a(false);
      return;
    case 11: 
      f();
      return;
    }
    a(paramow.z());
  }
  
  public void b(pe parampe)
    throws IOException, oq
  {
    if (parampe == null)
    {
      f();
      return;
    }
    a(pb.h, parampe);
  }
  
  public void b(String paramString)
    throws IOException, oq
  {
    if (paramString == null)
    {
      f();
      return;
    }
    a(pb.h, paramString);
  }
  
  public void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, oq
  {
    i();
  }
  
  public final void c()
    throws IOException, oq
  {
    a(pb.e);
    pl localpl = this.i.j();
    if (localpl != null) {
      this.i = localpl;
    }
  }
  
  public void c(ow paramow)
    throws IOException, oz
  {
    pb localpb2 = paramow.e();
    pb localpb1 = localpb2;
    if (localpb2 == pb.f)
    {
      a(paramow.g());
      localpb1 = paramow.b();
    }
    switch (aga.a[localpb1.ordinal()])
    {
    case 2: 
    default: 
      b(paramow);
      return;
    case 3: 
      b();
      while (paramow.b() != pb.e) {
        c(paramow);
      }
      c();
      return;
    }
    d();
    while (paramow.b() != pb.c) {
      c(paramow);
    }
    e();
  }
  
  public void c(String paramString)
    throws IOException, oq
  {
    i();
  }
  
  public void close()
    throws IOException
  {
    this.e = true;
  }
  
  public final void d()
    throws IOException, oq
  {
    a(pb.b);
    this.i = this.i.i();
  }
  
  public void d(String paramString)
    throws IOException, oq
  {
    i();
  }
  
  public final void e()
    throws IOException, oq
  {
    a(pb.c);
    pl localpl = this.i.j();
    if (localpl != null) {
      this.i = localpl;
    }
  }
  
  public void e(String paramString)
    throws IOException, oq
  {
    a(pb.j, paramString);
  }
  
  public void f()
    throws IOException, oq
  {
    a(pb.m);
  }
  
  public void g()
    throws IOException
  {}
  
  public ow h()
  {
    return a(this.c);
  }
  
  protected void i()
  {
    throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TokenBuffer: ");
    ow localow = h();
    int j = 0;
    for (;;)
    {
      pb localpb;
      try
      {
        localpb = localow.b();
        if (localpb == null)
        {
          if (j >= 100) {
            localStringBuilder.append(" ... (truncated ").append(j - 100).append(" entries)");
          }
          localStringBuilder.append(']');
          return localStringBuilder.toString();
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
      if (j < 100)
      {
        if (j > 0) {
          localIOException.append(", ");
        }
        localIOException.append(localpb.toString());
      }
      j += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */