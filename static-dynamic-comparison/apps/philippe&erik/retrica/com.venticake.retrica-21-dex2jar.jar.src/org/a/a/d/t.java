package org.a.a.d;

public class t
{
  private static final double a = Math.log(10.0D);
  
  static int a(String paramString, int paramInt)
  {
    int i = paramString.charAt(paramInt) - '0';
    return (i << 1) + (i << 3) + paramString.charAt(paramInt + 1) - 48;
  }
  
  public static void a(StringBuffer paramStringBuffer, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      paramStringBuffer.append('-');
      if (paramInt != Integer.MIN_VALUE) {
        i = -paramInt;
      }
    }
    else
    {
      if (i >= 10) {
        break label47;
      }
      paramStringBuffer.append((char)(i + 48));
      return;
    }
    paramStringBuffer.append("2147483648");
    return;
    label47:
    if (i < 100)
    {
      paramInt = (i + 1) * 13421772 >> 27;
      paramStringBuffer.append((char)(paramInt + 48));
      paramStringBuffer.append((char)(i - (paramInt << 3) - (paramInt << 1) + 48));
      return;
    }
    paramStringBuffer.append(Integer.toString(i));
  }
  
  public static void a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0)
    {
      paramStringBuffer.append('-');
      i = paramInt2;
      if (paramInt1 != Integer.MIN_VALUE) {
        i = -paramInt1;
      }
    }
    else
    {
      if (i >= 10) {
        break label88;
      }
      while (paramInt2 > 1)
      {
        paramStringBuffer.append('0');
        paramInt2 -= 1;
      }
    }
    while (i > 10)
    {
      paramStringBuffer.append('0');
      i -= 1;
    }
    paramStringBuffer.append("2147483648");
    return;
    paramStringBuffer.append((char)(i + 48));
    return;
    label88:
    if (i < 100)
    {
      while (paramInt2 > 2)
      {
        paramStringBuffer.append('0');
        paramInt2 -= 1;
      }
      paramInt1 = (i + 1) * 13421772 >> 27;
      paramStringBuffer.append((char)(paramInt1 + 48));
      paramStringBuffer.append((char)(i - (paramInt1 << 3) - (paramInt1 << 1) + 48));
      return;
    }
    if (i < 1000) {
      paramInt1 = 3;
    }
    while (paramInt2 > paramInt1)
    {
      paramStringBuffer.append('0');
      paramInt2 -= 1;
      continue;
      if (i < 10000) {
        paramInt1 = 4;
      } else {
        paramInt1 = (int)(Math.log(i) / a) + 1;
      }
    }
    paramStringBuffer.append(Integer.toString(i));
  }
  
  static String b(String paramString, int paramInt)
  {
    int i = paramInt + 32;
    if (paramString.length() <= i + 3) {}
    for (String str = paramString; paramInt <= 0; str = paramString.substring(0, i).concat("...")) {
      return "Invalid format: \"" + str + '"';
    }
    if (paramInt >= paramString.length()) {
      return "Invalid format: \"" + str + "\" is too short";
    }
    return "Invalid format: \"" + str + "\" is malformed at \"" + str.substring(paramInt) + '"';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */