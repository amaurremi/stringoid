package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class lr
  extends mc
{
  public void a()
    throws IOException
  {}
  
  public void a(int paramInt)
    throws IOException
  {
    c(paramInt);
  }
  
  public void a(long paramLong)
    throws IOException
  {
    if (paramLong > 0L) {
      b(paramLong);
    }
  }
  
  public void a(nw paramnw)
    throws IOException
  {
    a(paramnw.a(), 0, paramnw.b());
  }
  
  public void a(String paramString)
    throws IOException
  {
    if (paramString.length() == 0)
    {
      g();
      return;
    }
    paramString = paramString.getBytes("UTF-8");
    c(paramString.length);
    b(paramString, 0, paramString.length);
  }
  
  public void a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.arrayOffset();
    int k = paramByteBuffer.limit();
    a(paramByteBuffer.array(), j + i, k - i);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
    {
      g();
      return;
    }
    c(paramInt2);
    b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b()
    throws IOException
  {}
  
  public void b(int paramInt)
    throws IOException
  {
    c(paramInt);
  }
  
  public void c()
    throws IOException
  {}
  
  public void d()
    throws IOException
  {
    g();
  }
  
  public void e()
    throws IOException
  {}
  
  public void f()
    throws IOException
  {
    g();
  }
  
  protected abstract void g()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */