package org.b.a.a;

import java.nio.ByteBuffer;

public class j
  extends b
{
  private static final byte[] d = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7 };
  private static final byte[] e = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3 };
  private c a;
  private byte b;
  private int[] c = new int[4];
  
  public j()
  {
    d();
  }
  
  public String a()
  {
    return org.b.a.b.r;
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = c(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = ((ByteBuffer)localObject).array();
    paramInt2 = ((ByteBuffer)localObject).position();
    paramInt1 = 0;
    for (;;)
    {
      int j;
      int i;
      if (paramInt1 < paramInt2)
      {
        j = paramArrayOfByte[paramInt1];
        i = d[(j & 0xFF)];
        j = e[(this.b * 8 + i)];
        if (j == 0) {
          this.a = c.c;
        }
      }
      else
      {
        return this.a;
      }
      localObject = this.c;
      localObject[j] += 1;
      this.b = i;
      paramInt1 += 1;
    }
  }
  
  public float b()
  {
    int i = 0;
    if (this.a == c.c) {
      return 0.01F;
    }
    int j = 0;
    while (i < this.c.length)
    {
      j += this.c[i];
      i += 1;
    }
    if (j <= 0) {}
    for (float f1 = 0.0F;; f1 = this.c[3] * 1.0F / j - this.c[1] * 20.0F / j)
    {
      float f2 = f1;
      if (f1 < 0.0F) {
        f2 = 0.0F;
      }
      return f2 * 0.5F;
    }
  }
  
  public c c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.a = c.a;
    this.b = 1;
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = 0;
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */