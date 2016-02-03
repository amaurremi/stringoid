package org.b.a.a;

import java.util.Arrays;
import org.b.a.a.a.d;
import org.b.a.a.b.h;
import org.b.a.a.d.l;

public class m
  extends b
{
  private static final org.b.a.a.d.m f = new l();
  private org.b.a.a.d.b a = new org.b.a.a.d.b(f);
  private c b;
  private d c = new d();
  private h d = new h();
  private byte[] e = new byte[2];
  
  public m()
  {
    d();
  }
  
  public String a()
  {
    return org.b.a.b.l;
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    paramInt2 = paramInt1;
    int j;
    if (paramInt2 < i)
    {
      j = this.a.a(paramArrayOfByte[paramInt2]);
      if (j != 1) {
        break label92;
      }
    }
    for (this.b = c.c;; this.b = c.b)
    {
      this.e[0] = paramArrayOfByte[(i - 1)];
      if ((this.b == c.a) && (this.c.c()) && (b() > 0.95F)) {
        this.b = c.b;
      }
      return this.b;
      label92:
      if (j != 2) {
        break;
      }
    }
    if (j == 0)
    {
      j = this.a.a();
      if (paramInt2 != paramInt1) {
        break label174;
      }
      this.e[1] = paramArrayOfByte[paramInt1];
      this.c.a(this.e, 2 - j, j);
      this.d.a(this.e, 0, j);
    }
    for (;;)
    {
      paramInt2 += 1;
      break;
      label174:
      this.c.a(paramArrayOfByte, paramInt2 + 1 - j, j);
      this.d.a(paramArrayOfByte, paramInt2 - 1, j);
    }
  }
  
  public float b()
  {
    return Math.max(this.c.a(), this.d.a());
  }
  
  public c c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.a.b();
    this.b = c.a;
    this.c.b();
    this.d.b();
    Arrays.fill(this.e, (byte)0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */