package org.apache.a.c;

import java.io.Writer;
import org.apache.a.c.f.a.b;

class j
  extends b
{
  private static final String a = String.valueOf('"');
  private static final char[] b = { 44, 34, 13, 10 };
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramInt != 0) {
      throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
    }
    if ((paramCharSequence.charAt(0) != '"') || (paramCharSequence.charAt(paramCharSequence.length() - 1) != '"'))
    {
      paramWriter.write(paramCharSequence.toString());
      return paramCharSequence.length();
    }
    String str = paramCharSequence.subSequence(1, paramCharSequence.length() - 1).toString();
    if (k.a(str, b)) {
      paramWriter.write(k.b(str, a + a, a));
    }
    for (;;)
    {
      return paramCharSequence.length();
      paramWriter.write(paramCharSequence.toString());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */