package b.a;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class c
{
  private static final com.google.a.a.a.a.a a = new com.google.a.a.a.a.a("-._~", false);
  
  public static b.a.c.a a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (paramInputStream = localBufferedReader.readLine(); paramInputStream != null; paramInputStream = localBufferedReader.readLine()) {
      localStringBuilder.append(paramInputStream);
    }
    return c(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return a.a(paramString);
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    if (paramString.contains("?")) {}
    for (String str = "&";; str = "?")
    {
      paramString = new StringBuilder(paramString + str);
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (i > 0) {
          paramString.append("&");
        }
        paramString.append(a(paramVarArgs[i]) + "=" + a(paramVarArgs[(i + 1)]));
        i += 2;
      }
    }
    return paramString.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (System.getProperty("debug") != null) {
      System.out.println("[SIGNPOST] " + paramString1 + ": " + paramString2);
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString.getMessage(), paramString);
    }
  }
  
  public static b.a.c.a c(String paramString)
  {
    b.a.c.a locala = new b.a.c.a();
    if (d(paramString)) {
      return locala;
    }
    String[] arrayOfString = paramString.split("\\&");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      paramString = arrayOfString[i];
      int k = paramString.indexOf('=');
      String str;
      if (k < 0) {
        str = b(paramString);
      }
      for (paramString = null;; paramString = b(paramString.substring(k + 1)))
      {
        locala.a(str, paramString);
        i += 1;
        break;
        str = b(paramString.substring(0, k));
      }
    }
    return locala;
  }
  
  public static boolean d(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static b.a.c.a e(String paramString)
  {
    b.a.c.a locala = new b.a.c.a();
    if ((paramString == null) || (!paramString.startsWith("OAuth "))) {}
    for (;;)
    {
      return locala;
      paramString = paramString.substring("OAuth ".length()).split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        locala.a(arrayOfString[0].trim(), arrayOfString[1].replace("\"", "").trim());
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */