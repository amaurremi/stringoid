package org.apache.b.a.b;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class b
{
  public static final Charset a = Charset.forName("US-ASCII");
  public static final Charset b = Charset.forName("ISO-8859-1");
  public static final Charset c = Charset.forName("UTF-8");
  public static final Charset d = a;
  
  public static boolean a(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\t') || (paramChar == '\r') || (paramChar == '\n');
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("String may not be null");
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static Charset b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Charset.forName(paramString);
      return paramString;
    }
    catch (IllegalCharsetNameException paramString)
    {
      return null;
    }
    catch (UnsupportedCharsetException paramString) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */