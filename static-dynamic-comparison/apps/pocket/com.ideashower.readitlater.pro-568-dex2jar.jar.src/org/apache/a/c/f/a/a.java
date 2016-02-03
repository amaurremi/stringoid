package org.apache.a.c.f.a;

import java.io.Writer;

public class a
  extends b
{
  private final b[] a;
  
  public a(b... paramVarArgs)
  {
    this.a = ((b[])org.apache.a.c.a.a(paramVarArgs));
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    b[] arrayOfb = this.a;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfb[i].a(paramCharSequence, paramInt, paramWriter);
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */