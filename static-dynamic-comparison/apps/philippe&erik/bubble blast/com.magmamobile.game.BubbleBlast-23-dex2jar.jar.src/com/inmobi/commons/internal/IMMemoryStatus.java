package com.inmobi.commons.internal;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class IMMemoryStatus
{
  private static final int a = -1;
  
  public static boolean externalMemoryAvailable()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String formatSize(long paramLong)
  {
    Object localObject3 = null;
    String str = null;
    if (paramLong == 0L) {
      return str;
    }
    if (paramLong >= 1024L) {
      str = " KB";
    }
    for (;;)
    {
      try
      {
        l = paramLong / 1024L;
        paramLong = l;
        if (l >= 1024L)
        {
          str = " MB";
          paramLong = l / 1024L;
        }
        l = paramLong;
        if (paramLong >= 1024L)
        {
          str = " GB";
          l = paramLong / 1024L;
        }
        str = l + str;
        break;
      }
      finally {}
      Object localObject2 = localObject3;
      long l = paramLong;
    }
  }
  
  /* Error */
  public static long getTotalExternalMemorySize()
  {
    // Byte code:
    //   0: ldc2_w 58
    //   3: lstore_3
    //   4: ldc 2
    //   6: monitorenter
    //   7: lload_3
    //   8: lstore_1
    //   9: invokestatic 61	com/inmobi/commons/internal/IMMemoryStatus:externalMemoryAvailable	()Z
    //   12: ifeq +36 -> 48
    //   15: new 63	android/os/StatFs
    //   18: dup
    //   19: invokestatic 67	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   22: invokevirtual 72	java/io/File:getPath	()Ljava/lang/String;
    //   25: invokespecial 73	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   28: astore 5
    //   30: aload 5
    //   32: invokevirtual 77	android/os/StatFs:getBlockSize	()I
    //   35: i2l
    //   36: lstore_1
    //   37: aload 5
    //   39: invokevirtual 80	android/os/StatFs:getBlockCount	()I
    //   42: istore_0
    //   43: iload_0
    //   44: i2l
    //   45: lload_1
    //   46: lmul
    //   47: lstore_1
    //   48: ldc 2
    //   50: monitorexit
    //   51: lload_1
    //   52: lreturn
    //   53: astore 5
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    //   61: astore 5
    //   63: lload_3
    //   64: lstore_1
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	2	0	i	int
    //   8	57	1	l1	long
    //   3	61	3	l2	long
    //   28	10	5	localStatFs	StatFs
    //   53	6	5	localObject	Object
    //   61	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	43	53	finally
    //   9	43	61	java/lang/Exception
  }
  
  public static long getTotalInternalMemorySize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        long l = -1L;
      }
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/IMMemoryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */