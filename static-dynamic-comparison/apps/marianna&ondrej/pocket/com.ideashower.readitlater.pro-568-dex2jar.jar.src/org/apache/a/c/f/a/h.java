package org.apache.a.c.f.a;

import java.io.Writer;

public class h
  extends b
{
  private static int a = 377;
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if ((paramCharSequence.charAt(paramInt) == '\\') && (paramInt < paramCharSequence.length() - 1) && (Character.isDigit(paramCharSequence.charAt(paramInt + 1))))
    {
      int j = paramInt + 1;
      paramInt += 2;
      int i;
      do
      {
        i = paramInt;
        if (paramInt >= paramCharSequence.length()) {
          break;
        }
        i = paramInt;
        if (!Character.isDigit(paramCharSequence.charAt(paramInt))) {
          break;
        }
        i = paramInt + 1;
        paramInt = i;
      } while (Integer.parseInt(paramCharSequence.subSequence(j, i).toString(), 10) <= a);
      i -= 1;
      paramWriter.write(Integer.parseInt(paramCharSequence.subSequence(j, i).toString(), 8));
      return i + 1 - j;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */