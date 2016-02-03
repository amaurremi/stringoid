package org.b.a.a;

import java.nio.ByteBuffer;
import org.b.a.a.c.d;
import org.b.a.a.c.e;
import org.b.a.a.c.f;
import org.b.a.a.c.g;
import org.b.a.a.c.h;
import org.b.a.a.c.j;
import org.b.a.a.c.k;
import org.b.a.a.c.m;
import org.b.a.a.c.o;

public class l
  extends b
{
  private static final org.b.a.a.c.l f = new org.b.a.a.c.n();
  private static final org.b.a.a.c.l g = new g();
  private static final org.b.a.a.c.l h = new org.b.a.a.c.i();
  private static final org.b.a.a.c.l i = new k();
  private static final org.b.a.a.c.l j = new f();
  private static final org.b.a.a.c.l k = new e();
  private static final org.b.a.a.c.l l = new j();
  private static final org.b.a.a.c.l m = new o();
  private static final org.b.a.a.c.l n = new h();
  private static final org.b.a.a.c.l o = new m();
  private static final org.b.a.a.c.l p = new d();
  private c a;
  private b[] b = new b[13];
  private boolean[] c = new boolean[13];
  private int d;
  private int e;
  
  public l()
  {
    this.b[0] = new n(f);
    this.b[1] = new n(g);
    this.b[2] = new n(h);
    this.b[3] = new n(i);
    this.b[4] = new n(j);
    this.b[5] = new n(k);
    this.b[6] = new n(l);
    this.b[7] = new n(m);
    this.b[8] = new n(n);
    this.b[9] = new n(o);
    i locali = new i();
    this.b[10] = locali;
    this.b[11] = new n(p, false, locali);
    this.b[12] = new n(p, true, locali);
    locali.a(this.b[11], this.b[12]);
    d();
  }
  
  public String a()
  {
    if (this.d == -1)
    {
      b();
      if (this.d == -1) {
        this.d = 0;
      }
    }
    return this.b[this.d].a();
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2);
    if (paramArrayOfByte.position() == 0) {}
    for (;;)
    {
      return this.a;
      paramInt1 = 0;
      label22:
      if (paramInt1 < this.b.length) {
        if (this.c[paramInt1] != 0) {
          break label47;
        }
      }
      label47:
      do
      {
        c localc;
        do
        {
          paramInt1 += 1;
          break label22;
          break;
          localc = this.b[paramInt1].a(paramArrayOfByte.array(), 0, paramArrayOfByte.position());
          if (localc == c.b)
          {
            this.d = paramInt1;
            this.a = c.b;
            break;
          }
        } while (localc != c.c);
        this.c[paramInt1] = false;
        this.e -= 1;
      } while (this.e > 0);
      this.a = c.c;
    }
  }
  
  public float b()
  {
    float f1 = 0.0F;
    float f2;
    if (this.a == c.b) {
      f2 = 0.99F;
    }
    int i1;
    do
    {
      return f2;
      if (this.a == c.c) {
        return 0.01F;
      }
      i1 = 0;
      f2 = f1;
    } while (i1 >= this.b.length);
    if (this.c[i1] == 0) {
      f2 = f1;
    }
    for (;;)
    {
      i1 += 1;
      f1 = f2;
      break;
      float f3 = this.b[i1].b();
      f2 = f1;
      if (f1 < f3)
      {
        this.d = i1;
        f2 = f3;
      }
    }
  }
  
  public c c()
  {
    return this.a;
  }
  
  public void d()
  {
    int i1 = 0;
    this.e = 0;
    while (i1 < this.b.length)
    {
      this.b[i1].d();
      this.c[i1] = true;
      this.e += 1;
      i1 += 1;
    }
    this.d = -1;
    this.a = c.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */