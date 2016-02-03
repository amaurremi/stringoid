package org.apache.a.c.f.a;

import java.io.Writer;

public class j
  extends b
{
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if ((paramCharSequence.charAt(paramInt) == '\\') && (paramInt + 1 < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt + 1) == 'u'))
    {
      int i = 2;
      while ((paramInt + i < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt + i) == 'u')) {
        i += 1;
      }
      int j = i;
      if (paramInt + i < paramCharSequence.length())
      {
        j = i;
        if (paramCharSequence.charAt(paramInt + i) == '+') {
          j = i + 1;
        }
      }
      if (paramInt + j + 4 <= paramCharSequence.length())
      {
        paramCharSequence = paramCharSequence.subSequence(paramInt + j, paramInt + j + 4);
        try
        {
          paramWriter.write((char)Integer.parseInt(paramCharSequence.toString(), 16));
          return j + 4;
        }
        catch (NumberFormatException paramWriter)
        {
          throw new IllegalArgumentException("Unable to parse unicode value: " + paramCharSequence, paramWriter);
        }
      }
      throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + paramCharSequence.subSequence(paramInt, paramCharSequence.length()) + "' due to end of CharSequence");
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */