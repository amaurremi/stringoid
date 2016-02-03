package com.flurry.android.monolithic.sdk.impl;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class afq
  extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final afn b;
  private final LinkedList<byte[]> c = new LinkedList();
  private int d;
  private byte[] e;
  private int f;
  
  public afq()
  {
    this(null);
  }
  
  public afq(int paramInt)
  {
    this(null, paramInt);
  }
  
  public afq(afn paramafn)
  {
    this(paramafn, 500);
  }
  
  public afq(afn paramafn, int paramInt)
  {
    this.b = paramafn;
    if (paramafn == null)
    {
      this.e = new byte[paramInt];
      return;
    }
    this.e = paramafn.a(afo.c);
  }
  
  private void c()
  {
    int i = 262144;
    this.d += this.e.length;
    int j = Math.max(this.d >> 1, 1000);
    if (j > 262144) {}
    for (;;)
    {
      this.c.add(this.e);
      this.e = new byte[i];
      this.f = 0;
      return;
      i = j;
    }
  }
  
  public void a()
  {
    this.d = 0;
    this.f = 0;
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.f >= this.e.length) {
      c();
    }
    byte[] arrayOfByte = this.e;
    int i = this.f;
    this.f = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void b(int paramInt)
  {
    if (this.f + 1 < this.e.length)
    {
      byte[] arrayOfByte = this.e;
      int i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = this.e;
      i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    a(paramInt >> 8);
    a(paramInt);
  }
  
  public byte[] b()
  {
    int j = this.d + this.f;
    if (j == 0) {
      return a;
    }
    byte[] arrayOfByte1 = new byte[j];
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte2 = (byte[])localIterator.next();
      int k = arrayOfByte2.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
      i += k;
    }
    System.arraycopy(this.e, 0, arrayOfByte1, i, this.f);
    i = this.f + i;
    if (i != j) {
      throw new RuntimeException("Internal error: total len assumed to be " + j + ", copied " + i + " bytes");
    }
    if (!this.c.isEmpty()) {
      a();
    }
    return arrayOfByte1;
  }
  
  public void c(int paramInt)
  {
    if (this.f + 2 < this.e.length)
    {
      byte[] arrayOfByte = this.e;
      int i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16));
      arrayOfByte = this.e;
      i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = this.e;
      i = this.f;
      this.f = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    a(paramInt >> 16);
    a(paramInt >> 8);
    a(paramInt);
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
  {
    a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int k = Math.min(this.e.length - this.f, paramInt2);
      int j = i;
      paramInt1 = paramInt2;
      if (k > 0)
      {
        System.arraycopy(paramArrayOfByte, i, this.e, this.f, k);
        j = i + k;
        this.f += k;
        paramInt1 = paramInt2 - k;
      }
      if (paramInt1 <= 0) {
        return;
      }
      c();
      i = j;
      paramInt2 = paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */