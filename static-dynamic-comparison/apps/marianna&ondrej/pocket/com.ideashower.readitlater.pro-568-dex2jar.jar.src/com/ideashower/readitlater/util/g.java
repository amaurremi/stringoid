package com.ideashower.readitlater.util;

public class g
{
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    int i = paramString.indexOf("//");
    int j;
    if (i == -1)
    {
      i = 0;
      j = paramString.indexOf('/', i);
      if (j < 0) {
        break label54;
      }
    }
    for (;;)
    {
      return paramString.substring(i, j);
      i += 2;
      break;
      label54:
      j = paramString.length();
    }
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
    int j = 0;
    int i = str.indexOf('.');
    int k = str.lastIndexOf('.');
    while (i < k)
    {
      j = i + 1;
      i = str.indexOf('.', j);
    }
    paramString = str;
    if (j > 0) {
      paramString = str.substring(j);
    }
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */