package com.google.ads;

import android.net.Uri;
import android.net.Uri.Builder;
import java.lang.reflect.Method;

public class AFMAUtil
{
  private static final String fff = "ms";
  static final int ggg = 32;
  static final String hhh = "QMpJHSQqW-Nl0lXdTyh6UkCLuNtwIik_GjmqQjvH-1tGyVab4_xcP0xFw1ORcskIBCjJ4BC7BrIwpWE_CmeNtWLJJzCTCD_gDg8bHqM284SUj3obxwnIEKVenqY8ZNgX2JJx7TrbfimEnUvxcyJfN6EEexCvxcL079JthIJai8-9ciIoA0DXBUhoDS5qBaBClLvqVhzUCl-kkW8dESwZq0AzXeZJ8ZBg-QyBDnM_De4Jl7CKso8AOyyPkAxjzQMSSZ2PTpOGJIBvGI-vpw_TFEf9h4X5OU_JC_7l404fotUpqJFRjDjjyPRs2mHhX5IvqIoL7TZZAw5cMq1Uu3g5YA";
  private static final String lll = "AFMAUtil";
  private static final boolean uuu = false;
  
  /* Error */
  public static Uri a(Uri paramUri)
  {
    // Byte code:
    //   0: ldc 33
    //   2: ldc 14
    //   4: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +5 -> 14
    //   12: aload_0
    //   13: areturn
    //   14: ldc 14
    //   16: bipush 11
    //   18: invokestatic 45	com/google/ads/util/Base64:decode	(Ljava/lang/String;I)[B
    //   21: astore_2
    //   22: aload_0
    //   23: invokestatic 49	com/google/ads/AFMAUtil:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -16 -> 12
    //   31: invokestatic 53	com/google/ads/AFMAUtil:f	()Z
    //   34: ifne -22 -> 12
    //   37: aload_0
    //   38: aload_2
    //   39: aload_3
    //   40: invokevirtual 57	java/lang/String:getBytes	()[B
    //   43: invokestatic 61	com/google/ads/AFMAUtil:c	([B[B)[B
    //   46: bipush 11
    //   48: invokestatic 65	com/google/ads/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   51: ldc 8
    //   53: invokestatic 69	com/google/ads/AFMAUtil:d	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   56: astore_2
    //   57: aload_2
    //   58: areturn
    //   59: astore_2
    //   60: ldc 70
    //   62: i2b
    //   63: bipush 9
    //   65: irem
    //   66: ifeq +5 -> 71
    //   69: aconst_null
    //   70: athrow
    //   71: ldc 17
    //   73: new 72	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   80: ldc 75
    //   82: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramUri	Uri
    //   7	2	1	bool	boolean
    //   21	37	2	localObject	Object
    //   59	27	2	localIllegalArgumentException	IllegalArgumentException
    //   26	14	3	str	String
    // Exception table:
    //   from	to	target	type
    //   14	27	59	java/lang/IllegalArgumentException
    //   31	57	59	java/lang/IllegalArgumentException
    //   0	8	98	java/lang/Throwable
  }
  
  /* Error */
  static String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +39 -> 40
    //   4: new 31	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 96
    //   10: invokespecial 99	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: astore_0
    //   15: ldc 100
    //   17: i2b
    //   18: iconst_3
    //   19: irem
    //   20: ifeq +5 -> 25
    //   23: aconst_null
    //   24: athrow
    //   25: new 31	java/lang/IllegalArgumentException
    //   28: dup
    //   29: ldc 102
    //   31: invokespecial 99	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   34: astore_0
    //   35: aload_0
    //   36: athrow
    //   37: astore_0
    //   38: aload_0
    //   39: athrow
    //   40: aload_0
    //   41: ldc 104
    //   43: invokevirtual 110	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_0
    //   47: aload_0
    //   48: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramUri	Uri
    // Exception table:
    //   from	to	target	type
    //   40	47	14	java/lang/UnsupportedOperationException
    //   35	37	37	java/lang/Throwable
  }
  
  static byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null) {}
    try
    {
      int i = paramArrayOfByte1.length;
      if ((i != 0) && (paramArrayOfByte2 != null))
      {
        i = paramArrayOfByte2.length;
        if ((byte)987996205 % 9 != 0) {
          throw null;
        }
        if (i != 0) {}
      }
      else
      {
        throw new IllegalArgumentException("Malformed input (4)");
      }
      i = Math.min(32, paramArrayOfByte2.length);
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 0, i);
      return e(paramArrayOfByte1, arrayOfByte);
    }
    catch (Throwable paramArrayOfByte1)
    {
      throw paramArrayOfByte1;
    }
  }
  
  static Uri d(Uri paramUri, String paramString1, String paramString2)
  {
    if ((paramUri != null) && (paramString1 != null))
    {
      int i = paramString1.length();
      if ((byte)1248063151 % 9 != 0) {
        throw null;
      }
      if ((i != 0) && (paramString2 != null) && (paramString2.length() != 0)) {}
    }
    else
    {
      throw new IllegalArgumentException("Malformed input (5)");
    }
    return paramUri.buildUpon().appendQueryParameter(paramString2, paramString1).build();
  }
  
  static byte[] e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    if (paramArrayOfByte1 != null) {}
    try
    {
      int j = paramArrayOfByte1.length;
      if (j == 0) {
        throw new IllegalArgumentException("Malformed input (6)");
      }
      for (;;)
      {
        paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
        j = 0;
        int k = 0;
        int i;
        while (j < paramArrayOfByte1.length)
        {
          m = m + 1 & 0xFF;
          k = k + (arrayOfByte[m] & 0xFF) & 0xFF;
          i = arrayOfByte[m];
          arrayOfByte[m] = arrayOfByte[k];
          arrayOfByte[k] = i;
          int n = arrayOfByte[m];
          if ((byte)1516459969 % 9 != 0) {
            throw null;
          }
          int i1 = arrayOfByte[k];
          int i2 = paramArrayOfByte1[j];
          paramArrayOfByte2[j] = ((byte)(arrayOfByte[((n & 0xFF) + (i1 & 0xFF) & 0xFF)] ^ i2));
          j += 1;
        }
        if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte2.length > 256)) {
          throw new IllegalArgumentException("Malformed input (7)");
        }
        byte[] arrayOfByte = new byte['Ā'];
        j = 0;
        while (j < 256)
        {
          arrayOfByte[j] = ((byte)j);
          j += 1;
        }
        k = 0;
        j = 0;
        while (j < 256)
        {
          k = k + ((paramArrayOfByte2[(j % paramArrayOfByte2.length)] & 0xFF) + (arrayOfByte[j] & 0xFF)) & 0xFF;
          i = arrayOfByte[j];
          arrayOfByte[j] = arrayOfByte[k];
          arrayOfByte[k] = i;
          j += 1;
        }
      }
      return paramArrayOfByte2;
    }
    catch (Throwable paramArrayOfByte1)
    {
      throw paramArrayOfByte1;
    }
  }
  
  static boolean f()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i == 0) {
        i = 2;
      }
      try
      {
        Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
        localMethod.setAccessible(true);
        bool1 = "1".equals(localMethod.invoke(null, new Object[] { "ro.kernel.qemu" }));
        return bool1;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AFMAUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */