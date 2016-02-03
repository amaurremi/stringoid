package com.chartboost.sdk.impl;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ai
{
  public static final char a = File.separatorChar;
  public static final String b;
  
  static
  {
    ak localak = new ak(4);
    PrintWriter localPrintWriter = new PrintWriter(localak);
    localPrintWriter.println();
    b = localak.toString();
    localPrintWriter.close();
  }
  
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = b(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
    return l;
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
  
  public static void a(OutputStream paramOutputStream)
  {
    a(paramOutputStream);
  }
  
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    aj localaj = new aj();
    a(paramInputStream, localaj);
    return localaj.a();
  }
  
  public static long b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return a(paramInputStream, paramOutputStream, new byte['က']);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */