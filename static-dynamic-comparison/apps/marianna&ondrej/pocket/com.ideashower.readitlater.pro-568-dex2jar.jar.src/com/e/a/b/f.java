package com.e.a.b;

import java.io.File;

final class f
{
  private final String b;
  private final long[] c;
  private boolean d;
  private d e;
  private long f;
  
  private f(c paramc, String paramString)
  {
    this.b = paramString;
    this.c = new long[c.e(paramc)];
  }
  
  public File a(int paramInt)
  {
    return new File(c.f(this.a), this.b + "." + paramInt);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.c;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public File b(int paramInt)
  {
    return new File(c.f(this.a), this.b + "." + paramInt + ".tmp");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */