package com.e.a.b;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

public final class q
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final Charset c = Charset.forName("ISO-8859-1");
  public static final Charset d = Charset.forName("US-ASCII");
  public static final Charset e = Charset.forName("UTF-8");
  private static AtomicReference f = new AtomicReference();
  
  public static int a(InputStream paramInputStream)
  {
    int i = -1;
    byte[] arrayOfByte = new byte[1];
    if (paramInputStream.read(arrayOfByte, 0, 1) != -1) {
      i = arrayOfByte[0] & 0xFF;
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    if ("http".equalsIgnoreCase(paramString)) {
      return 80;
    }
    if ("https".equalsIgnoreCase(paramString)) {
      return 443;
    }
    return -1;
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (paramInt != -1) {
      return paramInt;
    }
    return a(paramString);
  }
  
  public static int a(URI paramURI)
  {
    return a(paramURI.getScheme(), paramURI.getPort());
  }
  
  public static int a(URL paramURL)
  {
    return a(paramURL.getProtocol(), paramURL.getPort());
  }
  
  public static long a(InputStream paramInputStream, long paramLong)
  {
    long l2 = 0L;
    if (paramLong == 0L) {
      return 0L;
    }
    byte[] arrayOfByte2 = (byte[])f.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    long l1 = l2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte['က'];
      l1 = l2;
    }
    l2 = l1;
    int i;
    int j;
    if (l1 < paramLong)
    {
      i = (int)Math.min(paramLong - l1, arrayOfByte1.length);
      j = paramInputStream.read(arrayOfByte1, 0, i);
      if (j != -1) {
        break label102;
      }
      l2 = l1;
    }
    for (;;)
    {
      f.set(arrayOfByte1);
      return l2;
      label102:
      l2 = l1 + j;
      l1 = l2;
      if (j >= i) {
        break;
      }
    }
  }
  
  public static List a(List paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Closeable paramCloseable1, Closeable paramCloseable2)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramCloseable1.close();
        paramCloseable1 = (Closeable)localObject;
      }
      catch (Throwable paramCloseable1)
      {
        continue;
      }
      try
      {
        paramCloseable2.close();
        paramCloseable2 = paramCloseable1;
      }
      catch (Throwable localThrowable)
      {
        paramCloseable2 = paramCloseable1;
        if (paramCloseable1 != null) {
          continue;
        }
        paramCloseable2 = localThrowable;
        continue;
        if (!(paramCloseable2 instanceof IOException)) {
          continue;
        }
        throw ((IOException)paramCloseable2);
        if (!(paramCloseable2 instanceof RuntimeException)) {
          continue;
        }
        throw ((RuntimeException)paramCloseable2);
        if (!(paramCloseable2 instanceof Error)) {
          continue;
        }
        throw ((Error)paramCloseable2);
        throw new AssertionError(paramCloseable2);
      }
    }
    if (paramCloseable2 == null) {
      return;
    }
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      if (paramInputStream == null) {
        throw new NullPointerException("in == null");
      }
      if (paramArrayOfByte == null) {
        throw new NullPointerException("dst == null");
      }
      a(paramArrayOfByte.length, paramInt1, paramInt2);
      while (paramInt2 > 0)
      {
        int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (i < 0) {
          throw new EOFException();
        }
        paramInt1 += i;
        paramInt2 -= i;
      }
    }
  }
  
  public static void a(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt & 0xFF) });
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static ThreadFactory b(String paramString)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, q.this);
        paramAnonymousRunnable.setDaemon(true);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static void b(InputStream paramInputStream)
  {
    do
    {
      paramInputStream.skip(Long.MAX_VALUE);
    } while (paramInputStream.read() != -1);
  }
  
  public static String c(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        throw new EOFException();
      }
      if (i == 10)
      {
        i = localStringBuilder.length();
        if ((i > 0) && (localStringBuilder.charAt(i - 1) == '\r')) {
          localStringBuilder.setLength(i - 1);
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */