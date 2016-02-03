package com.ideashower.readitlater.util.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.util.e;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import org.apache.a.b.d;

public class c
{
  @TargetApi(10)
  private static Bitmap a(BitmapRegionDecoder paramBitmapRegionDecoder, Rect paramRect, BitmapFactory.Options paramOptions, int paramInt)
  {
    try
    {
      localBitmap = paramBitmapRegionDecoder.decodeRegion(paramRect, paramOptions);
      bool = false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      boolean bool;
      for (;;)
      {
        Bitmap localBitmap;
        bool = a(localOutOfMemoryError, paramInt);
        Object localObject = null;
      }
      if (!bool) {
        break label54;
      }
      a(paramInt);
      return a(paramBitmapRegionDecoder, paramRect, paramOptions, paramInt + 1);
    }
    if (localBitmap != null) {
      return localBitmap;
    }
    label54:
    return null;
  }
  
  @TargetApi(10)
  public static Bitmap a(Rect paramRect, BitmapRegionDecoder paramBitmapRegionDecoder, BitmapFactory.Options paramOptions)
  {
    return a(paramBitmapRegionDecoder, paramRect, paramOptions, 1);
  }
  
  public static Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions)
  {
    return a(paramFileDescriptor, paramOptions, 1);
  }
  
  private static Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions, int paramInt)
  {
    try
    {
      localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
      bool = false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      boolean bool;
      for (;;)
      {
        Bitmap localBitmap;
        bool = a(localOutOfMemoryError, paramInt);
        Object localObject = null;
      }
      if (!bool) {
        break label50;
      }
      a(paramInt);
      return a(paramFileDescriptor, paramOptions, paramInt + 1);
    }
    if (localBitmap != null) {
      return localBitmap;
    }
    label50:
    return null;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    try
    {
      paramString = b(paramString, paramOptions);
      return paramString;
    }
    catch (IOException paramString)
    {
      e.a(paramString);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;) {}
    }
  }
  
  public static Bitmap a(URL paramURL, BitmapFactory.Options paramOptions)
  {
    return a(paramURL, paramOptions, 1);
  }
  
  /* Error */
  private static Bitmap a(URL paramURL, BitmapFactory.Options paramOptions, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: invokevirtual 59	java/net/URL:getContent	()Ljava/lang/Object;
    //   9: checkcast 61	java/io/InputStream
    //   12: astore 4
    //   14: aload 4
    //   16: aconst_null
    //   17: aload_1
    //   18: invokestatic 65	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: astore 5
    //   23: aload 4
    //   25: invokestatic 70	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   28: aload 5
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +39 -> 73
    //   37: aload 4
    //   39: areturn
    //   40: astore 5
    //   42: aconst_null
    //   43: astore 4
    //   45: aload 5
    //   47: iload_2
    //   48: invokestatic 20	com/ideashower/readitlater/util/a/c:a	(Ljava/lang/OutOfMemoryError;I)Z
    //   51: istore_3
    //   52: aload 4
    //   54: invokestatic 70	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   57: aconst_null
    //   58: astore 4
    //   60: goto -28 -> 32
    //   63: astore_0
    //   64: aload 5
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 70	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   71: aload_0
    //   72: athrow
    //   73: iload_3
    //   74: ifeq +16 -> 90
    //   77: iload_2
    //   78: invokestatic 23	com/ideashower/readitlater/util/a/c:a	(I)V
    //   81: aload_0
    //   82: aload_1
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: invokestatic 53	com/ideashower/readitlater/util/a/c:a	(Ljava/net/URL;Landroid/graphics/BitmapFactory$Options;I)Landroid/graphics/Bitmap;
    //   89: areturn
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: aload 4
    //   95: astore_1
    //   96: goto -29 -> 67
    //   99: astore_0
    //   100: aload 4
    //   102: astore_1
    //   103: goto -36 -> 67
    //   106: astore 5
    //   108: goto -63 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramURL	URL
    //   0	111	1	paramOptions	BitmapFactory.Options
    //   0	111	2	paramInt	int
    //   4	70	3	bool	boolean
    //   12	89	4	localObject	Object
    //   1	28	5	localBitmap	Bitmap
    //   40	25	5	localOutOfMemoryError1	OutOfMemoryError
    //   106	1	5	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	14	40	java/lang/OutOfMemoryError
    //   5	14	63	finally
    //   14	23	92	finally
    //   45	52	99	finally
    //   14	23	106	java/lang/OutOfMemoryError
  }
  
  private static void a(int paramInt)
  {
    SystemClock.sleep(paramInt * 1000);
  }
  
  private static boolean a(OutOfMemoryError paramOutOfMemoryError, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw paramOutOfMemoryError;
    case 1: 
      e.a(paramOutOfMemoryError);
      System.gc();
      return true;
    }
    e.a(paramOutOfMemoryError);
    x.d();
    System.gc();
    return true;
  }
  
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      d.a(paramOptions);
    }
    finally
    {
      try
      {
        paramString = a(localFileInputStream.getFD(), paramOptions, 1);
        d.a(localFileInputStream);
        return paramString;
      }
      finally
      {
        FileInputStream localFileInputStream;
        paramOptions = localFileInputStream;
      }
      paramString = finally;
      paramOptions = null;
    }
    throw paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */