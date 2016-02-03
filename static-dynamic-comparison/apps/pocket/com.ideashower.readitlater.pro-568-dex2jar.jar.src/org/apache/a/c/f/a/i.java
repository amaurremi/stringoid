package org.apache.a.c.f.a;

import java.io.Writer;

public class i
  extends c
{
  private final int a;
  private final int b;
  private final boolean c;
  
  public i()
  {
    this(0, Integer.MAX_VALUE, true);
  }
  
  private i(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }
  
  public static i a(int paramInt1, int paramInt2)
  {
    return new i(paramInt1, paramInt2, false);
  }
  
  public boolean a(int paramInt, Writer paramWriter)
  {
    if (this.c)
    {
      if ((paramInt >= this.a) && (paramInt <= this.b)) {}
    }
    else {
      while ((paramInt >= this.a) && (paramInt <= this.b)) {
        return false;
      }
    }
    if (paramInt > 65535) {
      paramWriter.write("\\u" + a(paramInt));
    }
    for (;;)
    {
      return true;
      if (paramInt > 4095) {
        paramWriter.write("\\u" + a(paramInt));
      } else if (paramInt > 255) {
        paramWriter.write("\\u0" + a(paramInt));
      } else if (paramInt > 15) {
        paramWriter.write("\\u00" + a(paramInt));
      } else {
        paramWriter.write("\\u000" + a(paramInt));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */