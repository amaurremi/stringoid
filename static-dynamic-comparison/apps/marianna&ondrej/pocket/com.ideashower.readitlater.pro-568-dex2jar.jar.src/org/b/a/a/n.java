package org.b.a.a;

import org.b.a.a.c.l;

public class n
  extends b
{
  private c a;
  private l b;
  private boolean c;
  private short d;
  private int e;
  private int[] f;
  private int g;
  private int h;
  private b i;
  
  public n(l paraml)
  {
    this.b = paraml;
    this.c = false;
    this.i = null;
    this.f = new int[4];
    d();
  }
  
  public n(l paraml, boolean paramBoolean, b paramb)
  {
    this.b = paraml;
    this.c = paramBoolean;
    this.i = paramb;
    this.f = new int[4];
    d();
  }
  
  public String a()
  {
    if (this.i == null) {
      return this.b.b();
    }
    return this.i.a();
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramInt1;
    if (k < paramInt1 + paramInt2)
    {
      int j = this.b.a(paramArrayOfByte[k]);
      if (j < 250) {
        this.g += 1;
      }
      int[] arrayOfInt;
      int m;
      if (j < 64)
      {
        this.h += 1;
        if (this.d < 64)
        {
          this.e += 1;
          if (this.c) {
            break label137;
          }
          arrayOfInt = this.f;
          m = this.b.a(this.d * 64 + j);
          arrayOfInt[m] += 1;
        }
      }
      for (;;)
      {
        this.d = j;
        k += 1;
        break;
        label137:
        arrayOfInt = this.f;
        m = this.b.a(j * 64 + this.d);
        arrayOfInt[m] += 1;
      }
    }
    float f1;
    if ((this.a == c.a) && (this.e > 1024))
    {
      f1 = b();
      if (f1 <= 0.95F) {
        break label223;
      }
      this.a = c.b;
    }
    for (;;)
    {
      return this.a;
      label223:
      if (f1 < 0.05F) {
        this.a = c.c;
      }
    }
  }
  
  public float b()
  {
    if (this.e > 0)
    {
      float f2 = this.f[3] * 1.0F / this.e / this.b.a() * this.h / this.g;
      float f1 = f2;
      if (f2 >= 1.0F) {
        f1 = 0.99F;
      }
      return f1;
    }
    return 0.01F;
  }
  
  public c c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.a = c.a;
    this.d = 255;
    int j = 0;
    while (j < 4)
    {
      this.f[j] = 0;
      j += 1;
    }
    this.e = 0;
    this.g = 0;
    this.h = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */