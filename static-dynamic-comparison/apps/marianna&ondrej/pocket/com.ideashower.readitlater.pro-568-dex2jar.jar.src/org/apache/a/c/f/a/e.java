package org.apache.a.c.f.a;

import java.io.Writer;
import java.util.HashMap;

public class e
  extends b
{
  private final HashMap a = new HashMap();
  private final int b;
  private final int c;
  
  public e(CharSequence[]... paramVarArgs)
  {
    int j = Integer.MAX_VALUE;
    int i;
    if (paramVarArgs != null)
    {
      int i1 = paramVarArgs.length;
      int k = 0;
      i = 0;
      int m;
      for (j = Integer.MAX_VALUE; k < i1; j = m)
      {
        CharSequence[] arrayOfCharSequence = paramVarArgs[k];
        this.a.put(arrayOfCharSequence[0], arrayOfCharSequence[1]);
        int n = arrayOfCharSequence[0].length();
        m = j;
        if (n < j) {
          m = n;
        }
        if (n <= i) {
          break label119;
        }
        i = n;
        k += 1;
      }
    }
    for (;;)
    {
      this.b = j;
      this.c = i;
      return;
      label119:
      break;
      i = 0;
    }
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    int i = this.c;
    if (this.c + paramInt > paramCharSequence.length()) {
      i = paramCharSequence.length() - paramInt;
    }
    while (i >= this.b)
    {
      CharSequence localCharSequence = paramCharSequence.subSequence(paramInt, paramInt + i);
      localCharSequence = (CharSequence)this.a.get(localCharSequence);
      if (localCharSequence != null)
      {
        paramWriter.write(localCharSequence.toString());
        return i;
      }
      i -= 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */