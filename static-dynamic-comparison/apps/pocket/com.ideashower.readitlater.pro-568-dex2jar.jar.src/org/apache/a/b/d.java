package org.apache.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.a.b.a.b;

public class d
{
  public static final char a = File.separatorChar;
  public static final String b;
  
  static
  {
    b localb = new b(4);
    PrintWriter localPrintWriter = new PrintWriter(localb);
    localPrintWriter.println();
    b = localb.toString();
    localPrintWriter.close();
  }
  
  public static int a(Reader paramReader, Writer paramWriter)
  {
    long l = b(paramReader, paramWriter);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static long a(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
    return l;
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    return a(paramInputStream, a.a(paramString));
  }
  
  public static String a(InputStream paramInputStream, Charset paramCharset)
  {
    b localb = new b();
    a(paramInputStream, localb, paramCharset);
    return localb.toString();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(InputStream paramInputStream)
  {
    a(paramInputStream);
  }
  
  public static void a(InputStream paramInputStream, Writer paramWriter, Charset paramCharset)
  {
    a(new InputStreamReader(paramInputStream, a.a(paramCharset)), paramWriter);
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    a(paramOutputStream);
  }
  
  public static long b(Reader paramReader, Writer paramWriter)
  {
    return a(paramReader, paramWriter, new char['က']);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */