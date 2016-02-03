package com.e.a.b.a;

final class b
{
  public static int a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public static int a(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)) {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static void a(String paramString, c paramc)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = a(paramString, i, "=,");
      String str2 = paramString.substring(i, j).trim();
      if ((j == paramString.length()) || (paramString.charAt(j) == ','))
      {
        i = j + 1;
        paramc.a(str2, null);
      }
      else
      {
        j = a(paramString, j + 1);
        String str1;
        if ((j < paramString.length()) && (paramString.charAt(j) == '"'))
        {
          i = j + 1;
          j = a(paramString, i, "\"");
          str1 = paramString.substring(i, j);
          i = j + 1;
        }
        for (;;)
        {
          paramc.a(str2, str1);
          break;
          i = a(paramString, j, ",");
          str1 = paramString.substring(j, i).trim();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */