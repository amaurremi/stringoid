package org.apache.a.c.f;

import org.apache.a.c.k;

public class a
{
  public static String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static String a(String paramString, char... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (int i = -1; (k.a(paramString)) || (i == 0); i = paramVarArgs.length) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int j = 0;
    int k = 1;
    if (j < paramString.length)
    {
      char c = paramString[j];
      if (a(c, paramVarArgs)) {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (k != 0)
        {
          paramString[j] = Character.toTitleCase(c);
          i = 0;
        }
      }
    }
    return new String(paramString);
  }
  
  private static boolean a(char paramChar, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfChar == null)
    {
      bool1 = Character.isWhitespace(paramChar);
      return bool1;
    }
    int j = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (paramChar == paramArrayOfChar[i]) {
        return true;
      }
      i += 1;
    }
  }
  
  public static String b(String paramString)
  {
    return b(paramString, null);
  }
  
  public static String b(String paramString, char... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (int i = -1; (k.a(paramString)) || (i == 0); i = paramVarArgs.length) {
      return paramString;
    }
    return a(paramString.toLowerCase(), paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */