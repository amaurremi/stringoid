package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class op
{
  static final int a = ;
  static final int b = os.a();
  protected static final ThreadLocal<SoftReference<afn>> c = new ThreadLocal();
  protected afj d = afj.a();
  protected afh e = afh.a();
  protected pc f;
  protected int g = a;
  protected int h = b;
  protected pp i;
  protected pr j;
  protected pv k;
  
  public op()
  {
    this(null);
  }
  
  public op(pc parampc)
  {
    this.f = parampc;
  }
  
  public op a(ox paramox)
  {
    this.g |= paramox.c();
    return this;
  }
  
  public op a(pc parampc)
  {
    this.f = parampc;
    return this;
  }
  
  public or a(Writer paramWriter)
    throws IOException
  {
    pq localpq = a(paramWriter, false);
    Writer localWriter = paramWriter;
    if (this.k != null) {
      localWriter = this.k.a(localpq, paramWriter);
    }
    return a(localWriter, localpq);
  }
  
  protected or a(Writer paramWriter, pq parampq)
    throws IOException
  {
    paramWriter = new po(parampq, this.h, this.f, paramWriter);
    if (this.i != null) {
      paramWriter.a(this.i);
    }
    return paramWriter;
  }
  
  public ow a(Reader paramReader)
    throws IOException, ov
  {
    pq localpq = a(paramReader, false);
    Reader localReader = paramReader;
    if (this.j != null) {
      localReader = this.j.a(localpq, paramReader);
    }
    return a(localReader, localpq);
  }
  
  protected ow a(Reader paramReader, pq parampq)
    throws IOException, ov
  {
    return new pm(parampq, this.g, paramReader, this.f, this.d.a(b(ox.j), b(ox.i)));
  }
  
  public pc a()
  {
    return this.f;
  }
  
  protected pq a(Object paramObject, boolean paramBoolean)
  {
    return new pq(b(), paramObject, paramBoolean);
  }
  
  public afn b()
  {
    Object localObject1 = (SoftReference)c.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (afn)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new afn();
        c.set(new SoftReference(localObject2));
      }
      return (afn)localObject2;
    }
  }
  
  public final boolean b(ox paramox)
  {
    return (this.g & paramox.c()) != 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */