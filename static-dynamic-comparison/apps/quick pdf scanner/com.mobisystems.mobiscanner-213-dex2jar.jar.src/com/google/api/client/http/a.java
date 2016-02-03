package com.google.api.client.http;

import com.google.api.client.util.g;
import com.google.api.client.util.m;
import java.nio.charset.Charset;

public abstract class a
  implements j
{
  private p aaN;
  private long aaO = -1L;
  
  protected a(p paramp)
  {
    this.aaN = paramp;
  }
  
  protected a(String paramString) {}
  
  public static long b(j paramj)
  {
    if (!paramj.xl()) {
      return -1L;
    }
    return m.b(paramj);
  }
  
  public long getLength()
  {
    if (this.aaO == -1L) {
      this.aaO = xk();
    }
    return this.aaO;
  }
  
  public String getType()
  {
    if (this.aaN == null) {
      return null;
    }
    return this.aaN.xo();
  }
  
  public final p xi()
  {
    return this.aaN;
  }
  
  protected final Charset xj()
  {
    if ((this.aaN == null) || (this.aaN.xw() == null)) {
      return g.UTF_8;
    }
    return this.aaN.xw();
  }
  
  protected long xk()
  {
    return b(this);
  }
  
  public boolean xl()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */