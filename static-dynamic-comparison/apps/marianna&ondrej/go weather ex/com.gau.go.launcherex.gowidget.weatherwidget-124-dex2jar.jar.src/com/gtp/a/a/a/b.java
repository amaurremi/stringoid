package com.gtp.a.a.a;

public class b
{
  public static String a = "application/zip";
  private static String b = "/mnt/sdcard/.android_secure";
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 35	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 38	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_1
    //   18: new 40	java/io/BufferedInputStream
    //   21: dup
    //   22: new 42	java/io/DataInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 45	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 50	java/io/File:length	()J
    //   38: l2i
    //   39: newarray <illegal type>
    //   41: astore_0
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 54	java/io/BufferedInputStream:read	([B)I
    //   47: pop
    //   48: aload_1
    //   49: invokevirtual 57	java/io/FileInputStream:close	()V
    //   52: aload_0
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 60	java/io/FileNotFoundException:printStackTrace	()V
    //   61: aload_0
    //   62: areturn
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_1
    //   67: invokevirtual 61	java/lang/SecurityException:printStackTrace	()V
    //   70: aload_0
    //   71: areturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_1
    //   76: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_1
    //   85: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   88: aload_0
    //   89: areturn
    //   90: astore_1
    //   91: goto -7 -> 84
    //   94: astore_1
    //   95: goto -20 -> 75
    //   98: astore_1
    //   99: goto -33 -> 66
    //   102: astore_1
    //   103: goto -46 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramString	String
    //   17	32	1	localFileInputStream	java.io.FileInputStream
    //   54	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   63	4	1	localSecurityException1	SecurityException
    //   72	4	1	localIOException1	java.io.IOException
    //   81	4	1	localException1	Exception
    //   90	1	1	localException2	Exception
    //   94	1	1	localIOException2	java.io.IOException
    //   98	1	1	localSecurityException2	SecurityException
    //   102	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   33	10	2	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   0	42	54	java/io/FileNotFoundException
    //   0	42	63	java/lang/SecurityException
    //   0	42	72	java/io/IOException
    //   0	42	81	java/lang/Exception
    //   42	52	90	java/lang/Exception
    //   42	52	94	java/io/IOException
    //   42	52	98	java/lang/SecurityException
    //   42	52	102	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */