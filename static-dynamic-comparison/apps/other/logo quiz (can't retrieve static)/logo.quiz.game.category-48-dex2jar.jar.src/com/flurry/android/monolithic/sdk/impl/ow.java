package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ow
  implements Closeable
{
  protected int a;
  protected pb b;
  protected pb c;
  
  protected ow() {}
  
  protected ow(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected ov a(String paramString)
  {
    return new ov(paramString, i());
  }
  
  public abstract pc a();
  
  public boolean a(ox paramox)
  {
    return (this.a & paramox.c()) != 0;
  }
  
  public abstract byte[] a(on paramon)
    throws IOException, ov;
  
  public abstract pb b()
    throws IOException, ov;
  
  public pb c()
    throws IOException, ov
  {
    pb localpb2 = b();
    pb localpb1 = localpb2;
    if (localpb2 == pb.f) {
      localpb1 = b();
    }
    return localpb1;
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract ow d()
    throws IOException, ov;
  
  public pb e()
  {
    return this.b;
  }
  
  public void f()
  {
    if (this.b != null)
    {
      this.c = this.b;
      this.b = null;
    }
  }
  
  public abstract String g()
    throws IOException, ov;
  
  public abstract ot h();
  
  public abstract ot i();
  
  public boolean j()
  {
    return e() == pb.d;
  }
  
  public abstract String k()
    throws IOException, ov;
  
  public abstract char[] l()
    throws IOException, ov;
  
  public abstract int m()
    throws IOException, ov;
  
  public abstract int n()
    throws IOException, ov;
  
  public boolean o()
  {
    return false;
  }
  
  public abstract Number p()
    throws IOException, ov;
  
  public abstract oy q()
    throws IOException, ov;
  
  public byte r()
    throws IOException, ov
  {
    int i = t();
    if ((i < -128) || (i > 127)) {
      throw a("Numeric value (" + k() + ") out of range of Java byte");
    }
    return (byte)i;
  }
  
  public short s()
    throws IOException, ov
  {
    int i = t();
    if ((i < 32768) || (i > 32767)) {
      throw a("Numeric value (" + k() + ") out of range of Java short");
    }
    return (short)i;
  }
  
  public abstract int t()
    throws IOException, ov;
  
  public abstract long u()
    throws IOException, ov;
  
  public abstract BigInteger v()
    throws IOException, ov;
  
  public abstract float w()
    throws IOException, ov;
  
  public abstract double x()
    throws IOException, ov;
  
  public abstract BigDecimal y()
    throws IOException, ov;
  
  public Object z()
    throws IOException, ov
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */