package org.b.a.a;

public class k
  extends b
{
  private c a;
  private b[] b = new b[7];
  private boolean[] c = new boolean[7];
  private int d;
  private int e;
  
  public k()
  {
    this.b[0] = new o();
    this.b[1] = new m();
    this.b[2] = new d();
    this.b[3] = new h();
    this.b[4] = new e();
    this.b[5] = new a();
    this.b[6] = new f();
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
    byte[] arrayOfByte = new byte[paramInt2];
    int i = 0;
    int j = 1;
    int k = paramInt1;
    int m;
    if (k < paramInt1 + paramInt2) {
      if ((paramArrayOfByte[k] & 0x80) != 0)
      {
        m = i + 1;
        arrayOfByte[i] = paramArrayOfByte[k];
        j = 1;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      if (j != 0)
      {
        j = i + 1;
        arrayOfByte[i] = paramArrayOfByte[k];
        m = 0;
        i = j;
        j = m;
        continue;
        paramInt1 = 0;
        while (paramInt1 < this.b.length) {
          if (this.c[paramInt1] == 0)
          {
            paramInt1 += 1;
          }
          else
          {
            paramArrayOfByte = this.b[paramInt1].a(arrayOfByte, 0, i);
            if (paramArrayOfByte != c.b) {
              break label164;
            }
            this.d = paramInt1;
          }
        }
        for (this.a = c.b;; this.a = c.c)
        {
          return this.a;
          label164:
          if (paramArrayOfByte != c.c) {
            break;
          }
          this.c[paramInt1] = false;
          this.e -= 1;
          if (this.e > 0) {
            break;
          }
        }
      }
    }
  }
  
  public float b()
  {
    float f1 = 0.0F;
    float f2;
    if (this.a == c.b) {
      f2 = 0.99F;
    }
    int i;
    do
    {
      return f2;
      if (this.a == c.c) {
        return 0.01F;
      }
      i = 0;
      f2 = f1;
    } while (i >= this.b.length);
    if (this.c[i] == 0) {
      f2 = f1;
    }
    for (;;)
    {
      i += 1;
      f1 = f2;
      break;
      float f3 = this.b[i].b();
      f2 = f1;
      if (f1 < f3)
      {
        this.d = i;
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
    int i = 0;
    this.e = 0;
    while (i < this.b.length)
    {
      this.b[i].d();
      this.c[i] = true;
      this.e += 1;
      i += 1;
    }
    this.d = -1;
    this.a = c.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */