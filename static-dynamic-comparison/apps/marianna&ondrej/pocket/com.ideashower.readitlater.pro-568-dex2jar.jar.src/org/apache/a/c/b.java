package org.apache.a.c;

public class b
{
  static int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
  }
  
  static boolean a(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
    }
    return paramCharSequence1.toString().regionMatches(paramBoolean, paramInt1, paramCharSequence2.toString(), paramInt2, paramInt3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */