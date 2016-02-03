package org.apache.a.c.f.a;

import java.io.Writer;

public abstract class c
  extends b
{
  public final int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (a(Character.codePointAt(paramCharSequence, paramInt), paramWriter)) {
      return 1;
    }
    return 0;
  }
  
  public abstract boolean a(int paramInt, Writer paramWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */