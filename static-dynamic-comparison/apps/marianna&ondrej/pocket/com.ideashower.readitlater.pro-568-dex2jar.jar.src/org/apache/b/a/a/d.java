package org.apache.b.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.b.a.b.b;

public class d
{
  private static final Pattern a = Pattern.compile("(.*?)=\\?(.+?)\\?(\\w)\\?(.+?)\\?=", 32);
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c == '_') {
        localStringBuilder.append("=20");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    return "=?" + paramString1 + "?" + paramString2 + "?" + paramString3 + "?=";
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, c paramc)
  {
    Charset localCharset = b.b(paramString1);
    if (localCharset == null)
    {
      a(paramc, paramString1, paramString2, paramString3, "leaving word encoded", new String[] { "Mime charser '", paramString1, "' doesn't have a corresponding Java charset" });
      return null;
    }
    if (paramString3.length() == 0)
    {
      a(paramc, paramString1, paramString2, paramString3, "leaving word encoded", new String[] { "Missing encoded text in encoded word" });
      return null;
    }
    try
    {
      if (paramString2.equalsIgnoreCase("Q")) {
        return b(paramString3, localCharset.name(), paramc);
      }
      if (paramString2.equalsIgnoreCase("B")) {
        return a(paramString3, localCharset.name(), paramc);
      }
      a(paramc, paramString1, paramString2, paramString3, "leaving word encoded", new String[] { "Warning: Unknown encoding in encoded word" });
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      a(paramc, paramString1, paramString2, paramString3, "leaving word encoded", new String[] { "Unsupported encoding (", localUnsupportedEncodingException.getMessage(), ") in encoded word" });
      return null;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(paramc, paramString1, paramString2, paramString3, "leaving word encoded", new String[] { "Could not decode (", localRuntimeException.getMessage(), ") encoded word" });
    }
    return null;
  }
  
  static String a(String paramString1, String paramString2, c paramc)
  {
    return new String(c(paramString1, paramc), paramString2);
  }
  
  public static String a(String paramString, c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = a.matcher(paramString);
    int i = 0;
    int j = 0;
    while (localMatcher.find())
    {
      String str1 = localMatcher.group(1);
      String str2 = a(localMatcher.group(2), localMatcher.group(3), localMatcher.group(4), paramc);
      if (str2 == null) {
        localStringBuilder.append(localMatcher.group(0));
      }
      for (;;)
      {
        j = localMatcher.end();
        if (str2 == null) {
          break label126;
        }
        i = 1;
        break;
        if ((i == 0) || (!b.a(str1))) {
          localStringBuilder.append(str1);
        }
        localStringBuilder.append(str2);
      }
      label126:
      i = 0;
    }
    if (j == 0) {
      return paramString;
    }
    localStringBuilder.append(paramString.substring(j));
    return localStringBuilder.toString();
  }
  
  private static void a(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramc.a())
    {
      paramString1 = a(paramString1, paramString2, paramString3);
      paramString2 = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramString2.append(paramVarArgs[i]);
        i += 1;
      }
      paramString2.append(" (");
      paramString2.append(paramString1);
      paramString2.append(")");
      if (paramc.a(paramString2.toString(), paramString4)) {
        throw new IllegalArgumentException(paramString2.toString());
      }
    }
  }
  
  static String b(String paramString1, String paramString2, c paramc)
  {
    return new String(b(a(paramString1), paramc), paramString2);
  }
  
  private static byte[] b(String paramString, c paramc)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new e(new ByteArrayInputStream(paramString.getBytes("US-ASCII")), paramc);
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  private static byte[] c(String paramString, c paramc)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new a(new ByteArrayInputStream(paramString.getBytes("US-ASCII")), paramc);
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */