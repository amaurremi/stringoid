package com.e.a.b.a;

import com.e.a.b.a;
import com.e.a.b.q;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class i
  extends a
{
  private static final byte[] b = { 13, 10 };
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final byte[] d = { 48, 13, 10, 13, 10 };
  private final byte[] e = { 0, 0, 0, 0, 0, 0, 0, 0, 13, 10 };
  private final OutputStream f;
  private final int g;
  private final ByteArrayOutputStream h;
  
  private i(OutputStream paramOutputStream, int paramInt)
  {
    this.f = paramOutputStream;
    this.g = Math.max(1, a(paramInt));
    this.h = new ByteArrayOutputStream(paramInt);
  }
  
  private int a(int paramInt)
  {
    int j = 4;
    int i = paramInt - 4;
    while (i > 0)
    {
      j += 1;
      i >>= 4;
    }
    return paramInt - j;
  }
  
  private void b(int paramInt)
  {
    int i = 8;
    int j;
    int k;
    do
    {
      byte[] arrayOfByte = this.e;
      j = i - 1;
      arrayOfByte[j] = c[(paramInt & 0xF)];
      k = paramInt >>> 4;
      i = j;
      paramInt = k;
    } while (k != 0);
    this.f.write(this.e, j, this.e.length - j);
  }
  
  private void c()
  {
    int i = this.h.size();
    if (i <= 0) {
      return;
    }
    b(i);
    this.h.writeTo(this.f);
    this.h.reset();
    this.f.write(b);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/e/a/b/a/i:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 99	com/e/a/b/a/i:a	Z
    //   19: aload_0
    //   20: invokespecial 101	com/e/a/b/a/i:c	()V
    //   23: aload_0
    //   24: getfield 51	com/e/a/b/a/i:f	Ljava/io/OutputStream;
    //   27: getstatic 41	com/e/a/b/a/i:d	[B
    //   30: invokevirtual 95	java/io/OutputStream:write	([B)V
    //   33: goto -22 -> 11
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	i
    //   6	2	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/e/a/b/a/i:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 101	com/e/a/b/a/i:c	()V
    //   18: aload_0
    //   19: getfield 51	com/e/a/b/a/i:f	Ljava/io/OutputStream;
    //   22: invokevirtual 104	java/io/OutputStream:flush	()V
    //   25: goto -14 -> 11
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	i
    //   6	2	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      try
      {
        a();
        q.a(paramArrayOfByte.length, paramInt1, paramInt2);
        if (paramInt2 > 0) {
          if ((this.h.size() > 0) || (paramInt2 < this.g))
          {
            int j = Math.min(paramInt2, this.g - this.h.size());
            this.h.write(paramArrayOfByte, paramInt1, j);
            i = j;
            if (this.h.size() == this.g)
            {
              c();
              i = j;
            }
          }
          else
          {
            i = this.g;
            b(i);
            this.f.write(paramArrayOfByte, paramInt1, i);
            this.f.write(b);
          }
        }
      }
      finally {}
      return;
      paramInt1 += i;
      paramInt2 -= i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */