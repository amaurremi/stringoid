package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okio.Buffer;
import com.squareup.okio.ByteString;
import com.squareup.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final RetryableSink EMPTY_SINK = new RetryableSink(0);
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2)
    throws IOException
  {
    Object localObject = null;
    try
    {
      paramCloseable1.close();
      paramCloseable1 = (Closeable)localObject;
    }
    catch (Throwable paramCloseable1)
    {
      label18:
      for (;;) {}
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
        break label18;
      }
      paramCloseable2 = localThrowable;
      break label18;
      if (!(paramCloseable2 instanceof IOException)) {
        break label51;
      }
      throw ((IOException)paramCloseable2);
      if (!(paramCloseable2 instanceof RuntimeException)) {
        break label63;
      }
      throw ((RuntimeException)paramCloseable2);
      if (!(paramCloseable2 instanceof Error)) {
        break label75;
      }
      throw ((Error)paramCloseable2);
      throw new AssertionError(paramCloseable2);
    }
    if (paramCloseable2 == null) {
      return;
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
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
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException paramServerSocket)
    {
      throw paramServerSocket;
    }
    catch (Exception paramServerSocket) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static void deleteContents(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("not a readable directory: " + paramFile);
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        deleteContents(paramFile);
      }
      if (!paramFile.delete()) {
        throw new IOException("failed to delete file: " + paramFile);
      }
      i += 1;
    }
  }
  
  public static RetryableSink emptySink()
  {
    return EMPTY_SINK;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int getDefaultPort(String paramString)
  {
    if ("http".equals(paramString)) {
      return 80;
    }
    if ("https".equals(paramString)) {
      return 443;
    }
    return -1;
  }
  
  private static int getEffectivePort(String paramString, int paramInt)
  {
    if (paramInt != -1) {
      return paramInt;
    }
    return getDefaultPort(paramString);
  }
  
  public static int getEffectivePort(URI paramURI)
  {
    return getEffectivePort(paramURI.getScheme(), paramURI.getPort());
  }
  
  public static int getEffectivePort(URL paramURL)
  {
    return getEffectivePort(paramURL.getProtocol(), paramURL.getPort());
  }
  
  public static String hash(String paramString)
  {
    try
    {
      paramString = ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static List<Header> headerEntries(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length / 2);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(new Header(paramVarArgs[i], paramVarArgs[(i + 1)]));
      i += 2;
    }
    return localArrayList;
  }
  
  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static boolean skipAll(Source paramSource, int paramInt)
    throws IOException
  {
    long l = System.nanoTime();
    Buffer localBuffer = new Buffer();
    while (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < paramInt)
    {
      if (paramSource.read(localBuffer, 2048L) == -1L) {
        return true;
      }
      localBuffer.clear();
    }
    return false;
  }
  
  public static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, this.val$name);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */