package com.chartboost.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class au
  extends OutputStream
{
  public abstract int a();
  
  public abstract int a(OutputStream paramOutputStream)
    throws IOException;
  
  public void a(double paramDouble)
  {
    a(Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = a();
    a(paramInt1);
    c(paramInt2);
    a(i);
  }
  
  public void a(long paramLong)
  {
    write((byte)(int)(paramLong >> 0 & 0xFF));
    write((byte)(int)(paramLong >> 8 & 0xFF));
    write((byte)(int)(paramLong >> 16 & 0xFF));
    write((byte)(int)(paramLong >> 24 & 0xFF));
    write((byte)(int)(paramLong >> 32 & 0xFF));
    write((byte)(int)(paramLong >> 40 & 0xFF));
    write((byte)(int)(paramLong >> 48 & 0xFF));
    write((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public abstract int b();
  
  public void c(int paramInt)
  {
    write(paramInt >> 0);
    write(paramInt >> 8);
    write(paramInt >> 16);
    write(paramInt >> 24);
  }
  
  public byte[] c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream(b());
      a((OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("should be impossible", localIOException);
    }
  }
  
  public void d(int paramInt)
  {
    write(paramInt >> 24);
    write(paramInt >> 16);
    write(paramInt >> 8);
    write(paramInt);
  }
  
  public String toString()
  {
    return getClass().getName() + " size: " + b() + " pos: " + a();
  }
  
  public abstract void write(int paramInt);
  
  public abstract void write(byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */