package com.e.a.b;

import java.io.Closeable;
import java.io.InputStream;

public final class g
  implements Closeable
{
  private final String b;
  private final long c;
  private final InputStream[] d;
  private final long[] e;
  
  private g(c paramc, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramArrayOfInputStream;
    this.e = paramArrayOfLong;
  }
  
  public InputStream a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.d;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      q.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */