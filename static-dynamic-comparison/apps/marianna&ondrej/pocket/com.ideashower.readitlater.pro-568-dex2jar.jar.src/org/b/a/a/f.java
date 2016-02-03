package org.b.a.a;

import java.util.Arrays;
import org.b.a.a.d.m;

public class f
  extends b
{
  private static final m e = new org.b.a.a.d.e();
  private org.b.a.a.d.b a = new org.b.a.a.d.b(e);
  private c b;
  private org.b.a.a.b.e c = new org.b.a.a.b.e();
  private byte[] d = new byte[2];
  
  public f()
  {
    d();
  }
  
  public String a()
  {
    return org.b.a.b.k;
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
      this.d[0] = paramArrayOfByte[(i - 1)];
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
        break label157;
      }
      this.d[1] = paramArrayOfByte[paramInt1];
      this.c.a(this.d, 0, j);
    }
    for (;;)
    {
      paramInt2 += 1;
      break;
      label157:
      this.c.a(paramArrayOfByte, paramInt2 - 1, j);
    }
  }
  
  public float b()
  {
    return this.c.a();
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
    Arrays.fill(this.d, (byte)0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */