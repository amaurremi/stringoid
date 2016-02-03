package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.nio.ByteBuffer;

public class mi
  extends mg
  implements mk
{
  protected lx c;
  
  mi(mq parammq, lx paramlx)
    throws IOException
  {
    super(parammq);
    a(paramlx);
  }
  
  private void b(int paramInt)
    throws IOException
  {
    this.a.a(mq.k);
    mz localmz = (mz)this.a.c();
    if (paramInt != localmz.A) {
      throw new jh("Incorrect length for fixed binary: expected " + localmz.A + " but received " + paramInt + " bytes.");
    }
  }
  
  public mi a(lx paramlx)
    throws IOException
  {
    this.a.e();
    this.c = paramlx;
    return this;
  }
  
  public mq a(mq parammq1, mq parammq2)
    throws IOException
  {
    return null;
  }
  
  public nw a(nw paramnw)
    throws IOException
  {
    this.a.a(mq.i);
    return this.c.a(paramnw);
  }
  
  public ByteBuffer a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    this.a.a(mq.j);
    return this.c.a(paramByteBuffer);
  }
  
  protected void a()
    throws IOException
  {
    this.a.a(mq.k);
    mz localmz = (mz)this.a.c();
    this.c.a(localmz.A);
  }
  
  public void a(int paramInt)
    throws IOException
  {
    b(paramInt);
    this.c.a(paramInt);
  }
  
  public void b()
    throws IOException
  {
    this.a.a(mq.c);
    this.c.b();
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    b(paramInt2);
    this.c.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean c()
    throws IOException
  {
    this.a.a(mq.d);
    return this.c.c();
  }
  
  public int d()
    throws IOException
  {
    this.a.a(mq.e);
    return this.c.d();
  }
  
  public long e()
    throws IOException
  {
    this.a.a(mq.f);
    return this.c.e();
  }
  
  public float f()
    throws IOException
  {
    this.a.a(mq.g);
    return this.c.f();
  }
  
  public double g()
    throws IOException
  {
    this.a.a(mq.h);
    return this.c.g();
  }
  
  public String h()
    throws IOException
  {
    this.a.a(mq.i);
    return this.c.h();
  }
  
  public void i()
    throws IOException
  {
    this.a.a(mq.i);
    this.c.i();
  }
  
  public void j()
    throws IOException
  {
    this.a.a(mq.j);
    this.c.j();
  }
  
  public int k()
    throws IOException
  {
    this.a.a(mq.l);
    mz localmz = (mz)this.a.c();
    int i = this.c.k();
    if ((i < 0) || (i >= localmz.A)) {
      throw new jh("Enumeration out of range: max is " + localmz.A + " but received " + i);
    }
    return i;
  }
  
  public long m()
    throws IOException
  {
    this.a.a(mq.n);
    long l = this.c.m();
    if (l == 0L) {
      this.a.a(mq.o);
    }
    return l;
  }
  
  public long n()
    throws IOException
  {
    this.a.b();
    long l = this.c.n();
    if (l == 0L) {
      this.a.a(mq.o);
    }
    return l;
  }
  
  public long o()
    throws IOException
  {
    this.a.a(mq.n);
    for (long l = this.c.o(); l != 0L; l = this.c.o()) {
      while (l > 0L)
      {
        this.a.f();
        l -= 1L;
      }
    }
    this.a.a(mq.o);
    return 0L;
  }
  
  public long p()
    throws IOException
  {
    this.a.a(mq.p);
    long l = this.c.p();
    if (l == 0L) {
      this.a.a(mq.q);
    }
    return l;
  }
  
  public long q()
    throws IOException
  {
    this.a.b();
    long l = this.c.q();
    if (l == 0L) {
      this.a.a(mq.q);
    }
    return l;
  }
  
  public long r()
    throws IOException
  {
    this.a.a(mq.p);
    for (long l = this.c.r(); l != 0L; l = this.c.r()) {
      while (l > 0L)
      {
        this.a.f();
        l -= 1L;
      }
    }
    this.a.a(mq.q);
    return 0L;
  }
  
  public int s()
    throws IOException
  {
    this.a.a(mq.m);
    ms localms = (ms)this.a.c();
    int i = this.c.s();
    this.a.c(localms.a(i));
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */