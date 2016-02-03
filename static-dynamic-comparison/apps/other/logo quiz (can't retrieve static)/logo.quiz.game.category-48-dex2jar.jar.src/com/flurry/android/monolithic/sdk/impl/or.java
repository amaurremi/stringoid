package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class or
  implements Closeable
{
  protected pd a;
  
  public abstract or a();
  
  public or a(int paramInt)
  {
    return this;
  }
  
  public or a(pd parampd)
  {
    this.a = parampd;
    return this;
  }
  
  public or a(pp parampp)
  {
    return this;
  }
  
  public abstract void a(char paramChar)
    throws IOException, oq;
  
  public abstract void a(double paramDouble)
    throws IOException, oq;
  
  public abstract void a(float paramFloat)
    throws IOException, oq;
  
  public abstract void a(long paramLong)
    throws IOException, oq;
  
  public abstract void a(on paramon, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, oq;
  
  public abstract void a(ou paramou)
    throws IOException, oz;
  
  public void a(pe parampe)
    throws IOException, oq
  {
    a(parampe.a());
  }
  
  public void a(pw parampw)
    throws IOException, oq
  {
    a(parampw.a());
  }
  
  public abstract void a(Object paramObject)
    throws IOException, oz;
  
  public abstract void a(String paramString)
    throws IOException, oq;
  
  public final void a(String paramString, int paramInt)
    throws IOException, oq
  {
    a(paramString);
    b(paramInt);
  }
  
  public void a(String paramString1, String paramString2)
    throws IOException, oq
  {
    a(paramString1);
    b(paramString2);
  }
  
  public abstract void a(BigDecimal paramBigDecimal)
    throws IOException, oq;
  
  public abstract void a(BigInteger paramBigInteger)
    throws IOException, oq;
  
  public abstract void a(boolean paramBoolean)
    throws IOException, oq;
  
  public void a(byte[] paramArrayOfByte)
    throws IOException, oq
  {
    a(oo.a(), paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, oq;
  
  public abstract void b()
    throws IOException, oq;
  
  public abstract void b(int paramInt)
    throws IOException, oq;
  
  public void b(pe parampe)
    throws IOException, oq
  {
    b(parampe.a());
  }
  
  public abstract void b(String paramString)
    throws IOException, oq;
  
  public abstract void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, oq;
  
  public abstract void c()
    throws IOException, oq;
  
  public abstract void c(String paramString)
    throws IOException, oq;
  
  public abstract void d()
    throws IOException, oq;
  
  public abstract void d(String paramString)
    throws IOException, oq;
  
  public abstract void e()
    throws IOException, oq;
  
  public abstract void e(String paramString)
    throws IOException, oq, UnsupportedOperationException;
  
  public abstract void f()
    throws IOException, oq;
  
  public final void f(String paramString)
    throws IOException, oq
  {
    a(paramString);
    b();
  }
  
  public abstract void g()
    throws IOException;
  
  public final void g(String paramString)
    throws IOException, oq
  {
    a(paramString);
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */