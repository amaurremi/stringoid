package org.apache.a.c;

import java.io.Writer;
import org.apache.a.c.f.a.b;

class i
  extends b
{
  private static final String a = String.valueOf('"');
  private static final char[] b = { 44, 34, 13, 10 };
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramInt != 0) {
      throw new IllegalStateException("CsvEscaper should never reach the [1] index");
    }
    if (k.b(paramCharSequence.toString(), b)) {
      paramWriter.write(paramCharSequence.toString());
    }
    for (;;)
    {
      return paramCharSequence.length();
      paramWriter.write(34);
      paramWriter.write(k.b(paramCharSequence.toString(), a, a + a));
      paramWriter.write(34);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */