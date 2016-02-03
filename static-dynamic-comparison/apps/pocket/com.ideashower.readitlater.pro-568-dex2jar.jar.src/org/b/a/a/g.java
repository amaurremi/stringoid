package org.b.a.a;

import org.b.a.a.d.h;
import org.b.a.a.d.i;
import org.b.a.a.d.j;

public class g
  extends b
{
  private static final org.b.a.a.d.g e = new org.b.a.a.d.g();
  private static final h f = new h();
  private static final i g = new i();
  private static final j h = new j();
  private org.b.a.a.d.b[] a = new org.b.a.a.d.b[4];
  private int b;
  private c c;
  private String d;
  
  public g()
  {
    this.a[0] = new org.b.a.a.d.b(e);
    this.a[1] = new org.b.a.a.d.b(f);
    this.a[2] = new org.b.a.a.d.b(g);
    this.a[3] = new org.b.a.a.d.b(h);
    d();
  }
  
  public String a()
  {
    return this.d;
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1;; i = j + 1)
    {
      j = i;
      if ((j >= paramInt1 + paramInt2) || (this.c != c.a)) {
        break;
      }
      i = this.b - 1;
      if (i >= 0)
      {
        int k = this.a[i].a(paramArrayOfByte[j]);
        if (k == 1)
        {
          this.b -= 1;
          if (this.b <= 0)
          {
            this.c = c.c;
            return this.c;
          }
          if (i != this.b)
          {
            localb = this.a[this.b];
            this.a[this.b] = this.a[i];
            this.a[i] = localb;
          }
        }
        while (k != 2)
        {
          org.b.a.a.d.b localb;
          i -= 1;
          break;
        }
        this.c = c.b;
        this.d = this.a[i].c();
        return this.c;
      }
    }
    return this.c;
  }
  
  public float b()
  {
    return 0.99F;
  }
  
  public c c()
  {
    return this.c;
  }
  
  public void d()
  {
    this.c = c.a;
    int i = 0;
    while (i < this.a.length)
    {
      this.a[i].b();
      i += 1;
    }
    this.b = this.a.length;
    this.d = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */