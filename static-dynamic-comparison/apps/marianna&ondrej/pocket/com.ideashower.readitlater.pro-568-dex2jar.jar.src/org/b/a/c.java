package org.b.a;

import org.b.a.a.g;
import org.b.a.a.j;
import org.b.a.a.k;
import org.b.a.a.l;

public class c
{
  private d a;
  private boolean b;
  private boolean c;
  private boolean d;
  private byte e;
  private String f;
  private org.b.a.a.b[] g;
  private org.b.a.a.b h;
  private a i;
  
  public c(a parama)
  {
    this.i = parama;
    this.h = null;
    this.g = new org.b.a.a.b[3];
    int j = 0;
    while (j < this.g.length)
    {
      this.g[j] = null;
      j += 1;
    }
    d();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 0;
    if (this.b) {}
    for (;;)
    {
      return;
      if (paramInt2 > 0) {
        this.d = true;
      }
      int m;
      if (this.c)
      {
        this.c = false;
        if (paramInt2 > 3)
        {
          j = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[(paramInt1 + 1)] & 0xFF;
          int n = paramArrayOfByte[(paramInt1 + 2)] & 0xFF;
          int i1 = paramArrayOfByte[(paramInt1 + 3)] & 0xFF;
          switch (j & 0xFF)
          {
          }
          while (this.f != null)
          {
            this.b = true;
            return;
            if ((m == 187) && (n == 191))
            {
              this.f = b.u;
              continue;
              if ((m == 255) && (n == 0) && (i1 == 0))
              {
                this.f = b.A;
              }
              else if (m == 255)
              {
                this.f = b.v;
                continue;
                if ((m == 0) && (n == 254) && (i1 == 255))
                {
                  this.f = b.x;
                }
                else if ((m == 0) && (n == 255) && (i1 == 254))
                {
                  this.f = b.B;
                  continue;
                  if ((m == 254) && (n == 0) && (i1 == 0)) {
                    this.f = b.y;
                  } else if (m == 254) {
                    this.f = b.w;
                  }
                }
              }
            }
          }
        }
      }
      int j = paramInt1;
      if (j < paramInt1 + paramInt2)
      {
        m = paramArrayOfByte[j] & 0xFF;
        if (((m & 0x80) != 0) && (m != 160)) {
          if (this.a != d.c)
          {
            this.a = d.c;
            if (this.h != null) {
              this.h = null;
            }
            if (this.g[0] == null) {
              this.g[0] = new k();
            }
            if (this.g[1] == null) {
              this.g[1] = new l();
            }
            if (this.g[2] == null) {
              this.g[2] = new j();
            }
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if ((this.a == d.a) && ((m == 27) || ((m == 123) && (this.e == 126)))) {
            this.a = d.b;
          }
          this.e = paramArrayOfByte[j];
        }
      }
      if (this.a == d.b)
      {
        if (this.h == null) {
          this.h = new g();
        }
        if (this.h.a(paramArrayOfByte, paramInt1, paramInt2) == org.b.a.a.c.b)
        {
          this.b = true;
          this.f = this.h.a();
        }
      }
      else if (this.a == d.c)
      {
        j = k;
        while (j < this.g.length)
        {
          if (this.g[j].a(paramArrayOfByte, paramInt1, paramInt2) == org.b.a.a.c.b)
          {
            this.b = true;
            this.f = this.g[j].a();
            return;
          }
          j += 1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void c()
  {
    int j = 0;
    if (!this.d) {}
    do
    {
      do
      {
        float f1;
        int k;
        do
        {
          do
          {
            return;
            if (this.f == null) {
              break;
            }
            this.b = true;
          } while (this.i == null);
          this.i.a(this.f);
          return;
          if (this.a != d.c) {
            break;
          }
          f1 = 0.0F;
          k = 0;
          while (j < this.g.length)
          {
            float f3 = this.g[j].b();
            float f2 = f1;
            if (f3 > f1)
            {
              k = j;
              f2 = f3;
            }
            j += 1;
            f1 = f2;
          }
        } while (f1 <= 0.2F);
        this.f = this.g[k].a();
      } while (this.i == null);
      this.i.a(this.f);
      return;
    } while (this.a != d.b);
  }
  
  public void d()
  {
    int k = 0;
    this.b = false;
    this.c = true;
    this.f = null;
    this.d = false;
    this.a = d.a;
    this.e = 0;
    int j = k;
    if (this.h != null)
    {
      this.h.d();
      j = k;
    }
    while (j < this.g.length)
    {
      if (this.g[j] != null) {
        this.g[j].d();
      }
      j += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */