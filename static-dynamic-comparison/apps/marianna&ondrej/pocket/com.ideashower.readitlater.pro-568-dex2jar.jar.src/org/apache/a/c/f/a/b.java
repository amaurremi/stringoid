package org.apache.a.c.f.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public abstract class b
{
  public static String a(int paramInt)
  {
    return Integer.toHexString(paramInt).toUpperCase(Locale.ENGLISH);
  }
  
  public abstract int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter);
  
  public final String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramCharSequence.length() * 2);
      a(paramCharSequence, localStringWriter);
      paramCharSequence = localStringWriter.toString();
      return paramCharSequence;
    }
    catch (IOException paramCharSequence)
    {
      throw new RuntimeException(paramCharSequence);
    }
  }
  
  public final b a(b... paramVarArgs)
  {
    b[] arrayOfb = new b[paramVarArgs.length + 1];
    arrayOfb[0] = this;
    System.arraycopy(paramVarArgs, 0, arrayOfb, 1, paramVarArgs.length);
    return new a(arrayOfb);
  }
  
  public final void a(CharSequence paramCharSequence, Writer paramWriter)
  {
    if (paramWriter == null) {
      throw new IllegalArgumentException("The Writer must not be null");
    }
    if (paramCharSequence == null) {}
    for (;;)
    {
      return;
      int k = paramCharSequence.length();
      int i = 0;
      while (i < k)
      {
        int m = a(paramCharSequence, i, paramWriter);
        if (m == 0)
        {
          char[] arrayOfChar = Character.toChars(Character.codePointAt(paramCharSequence, i));
          paramWriter.write(arrayOfChar);
          i += arrayOfChar.length;
        }
        else
        {
          int j = 0;
          while (j < m)
          {
            i += Character.charCount(Character.codePointAt(paramCharSequence, i));
            j += 1;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */