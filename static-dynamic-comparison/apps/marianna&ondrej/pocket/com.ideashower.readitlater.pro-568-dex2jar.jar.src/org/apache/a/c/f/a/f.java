package org.apache.a.c.f.a;

import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class f
  extends b
{
  private final EnumSet a;
  
  public f(g... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      this.a = EnumSet.copyOf(Arrays.asList(paramVarArgs));
      return;
    }
    this.a = EnumSet.copyOf(Arrays.asList(new g[] { g.a }));
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    int n = 1;
    int k = paramCharSequence.length();
    int i;
    if ((paramCharSequence.charAt(paramInt) == '&') && (paramInt < k - 2) && (paramCharSequence.charAt(paramInt + 1) == '#'))
    {
      paramInt += 2;
      i = paramCharSequence.charAt(paramInt);
      if ((i != 120) && (i != 88)) {
        break label375;
      }
      paramInt += 1;
      if (paramInt != k) {}
    }
    else
    {
      return 0;
    }
    int j = 1;
    label248:
    label299:
    label307:
    label360:
    label366:
    label375:
    for (;;)
    {
      i = paramInt;
      while ((i < k) && (((paramCharSequence.charAt(i) >= '0') && (paramCharSequence.charAt(i) <= '9')) || ((paramCharSequence.charAt(i) >= 'a') && (paramCharSequence.charAt(i) <= 'f')) || ((paramCharSequence.charAt(i) >= 'A') && (paramCharSequence.charAt(i) <= 'F')))) {
        i += 1;
      }
      if ((i != k) && (paramCharSequence.charAt(i) == ';')) {}
      for (k = 1;; k = 0)
      {
        if (k != 0) {
          break label248;
        }
        if (a(g.a)) {
          break;
        }
        if (!a(g.c)) {
          break label248;
        }
        throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
      }
      if (j != 0) {}
      try
      {
        int m = Integer.parseInt(paramCharSequence.subSequence(paramInt, i).toString(), 16);
        if (m > 65535)
        {
          paramCharSequence = Character.toChars(m);
          paramWriter.write(paramCharSequence[0]);
          paramWriter.write(paramCharSequence[1]);
          if (j == 0) {
            break label360;
          }
          j = 1;
          if (k == 0) {
            break label366;
          }
        }
        for (k = n;; k = 0)
        {
          return j + (i + 2 - paramInt) + k;
          m = Integer.parseInt(paramCharSequence.subSequence(paramInt, i).toString(), 10);
          break;
          paramWriter.write(m);
          break label299;
          j = 0;
          break label307;
        }
        j = 0;
      }
      catch (NumberFormatException paramCharSequence)
      {
        return 0;
      }
    }
  }
  
  public boolean a(g paramg)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.contains(paramg);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */