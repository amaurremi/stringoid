package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class av
  extends au
{
  private static bm<byte[]> g = new bm(640)
  {
    protected byte[] a()
    {
      return new byte['䀀'];
    }
  };
  final byte[] a = new byte['䀀'];
  final char[] b = new char['䀀'];
  final List<byte[]> c = new ArrayList();
  final aw d = new aw();
  private final a e = new a();
  private final a f = new a();
  
  public av()
  {
    d();
  }
  
  public int a()
  {
    return this.e.b();
  }
  
  public int a(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("out is null");
    }
    int i = -1;
    int j = 0;
    while (i < this.c.size())
    {
      byte[] arrayOfByte = b(i);
      int k = this.f.c(i);
      paramOutputStream.write(arrayOfByte, 0, k);
      j += k;
      i += 1;
    }
    return j;
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public int b()
  {
    return this.f.b();
  }
  
  byte[] b(int paramInt)
  {
    if (paramInt < 0) {
      return this.a;
    }
    return (byte[])this.c.get(paramInt);
  }
  
  public void d()
  {
    this.e.a();
    this.f.a();
    int i = 0;
    while (i < this.c.size())
    {
      g.b(this.c.get(i));
      i += 1;
    }
    this.c.clear();
  }
  
  void e()
  {
    if (this.e.b() < this.f.b()) {
      if (this.e.b == 16384) {
        this.e.d();
      }
    }
    do
    {
      return;
      this.f.a(this.e);
    } while (this.f.b < 16384);
    this.c.add(g.c());
    this.f.d();
    this.e.a(this.f);
  }
  
  byte[] f()
  {
    return b(this.e.a);
  }
  
  public void write(int paramInt)
  {
    f()[this.e.c()] = ((byte)(paramInt & 0xFF));
    e();
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      byte[] arrayOfByte = f();
      int i = Math.min(arrayOfByte.length - this.e.b, paramInt2);
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.e.b, i);
      this.e.b(i);
      paramInt2 -= i;
      paramInt1 += i;
      e();
    }
  }
  
  static class a
  {
    int a;
    int b;
    
    a()
    {
      a();
    }
    
    void a()
    {
      this.a = -1;
      this.b = 0;
    }
    
    void a(int paramInt)
    {
      this.a = (paramInt / 16384 - 1);
      this.b = (paramInt % 16384);
    }
    
    void a(a parama)
    {
      this.a = parama.a;
      this.b = parama.b;
    }
    
    int b()
    {
      return (this.a + 1) * 16384 + this.b;
    }
    
    void b(int paramInt)
    {
      this.b += paramInt;
      if (this.b > 16384) {
        throw new IllegalArgumentException("something is wrong");
      }
    }
    
    int c()
    {
      int i = this.b;
      this.b = (i + 1);
      return i;
    }
    
    int c(int paramInt)
    {
      if (paramInt < this.a) {
        return 16384;
      }
      return this.b;
    }
    
    void d()
    {
      if (this.b != 16384) {
        throw new IllegalArgumentException("broken");
      }
      this.a += 1;
      this.b = 0;
    }
    
    public String toString()
    {
      return this.a + "," + this.b;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */