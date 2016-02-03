package org.b.a.a;

import org.b.a.a.d.m;
import org.b.a.a.d.n;

public class o
  extends b
{
  private static final m d = new n();
  private org.b.a.a.d.b a = new org.b.a.a.d.b(d);
  private c b;
  private int c = 0;
  
  public o()
  {
    d();
  }
  
  public String a()
  {
    return org.b.a.b.u;
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int j;
      if (i < paramInt1 + paramInt2)
      {
        j = this.a.a(paramArrayOfByte[i]);
        if (j != 1) {
          break label69;
        }
      }
      for (this.b = c.c;; this.b = c.b)
      {
        if ((this.b == c.a) && (b() > 0.95F)) {
          this.b = c.b;
        }
        return this.b;
        label69:
        if (j != 2) {
          break;
        }
      }
      if ((j == 0) && (this.a.a() >= 2)) {
        this.c += 1;
      }
      i += 1;
    }
  }
  
  public float b()
  {
    float f1 = 0.99F;
    float f2 = f1;
    if (this.c < 6)
    {
      int i = 0;
      while (i < this.c)
      {
        f1 *= 0.5F;
        i += 1;
      }
      f2 = 1.0F - f1;
    }
    return f2;
  }
  
  public c c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.a.b();
    this.c = 0;
    this.b = c.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */