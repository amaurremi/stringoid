package com.amazonaws.auth;

public class PropertiesCredentials
  implements AWSCredentials
{
  private final String accessKey;
  private final String secretAccessKey;
  
  /* Error */
  public PropertiesCredentials(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	java/lang/Object:<init>	()V
    //   4: aload_1
    //   5: invokevirtual 22	java/io/File:exists	()Z
    //   8: ifne +33 -> 41
    //   11: new 24	java/io/FileNotFoundException
    //   14: dup
    //   15: new 26	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   22: ldc 29
    //   24: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   31: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 43	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: new 45	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore_2
    //   50: new 49	java/util/Properties
    //   53: dup
    //   54: invokespecial 50	java/util/Properties:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 54	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_3
    //   64: ldc 55
    //   66: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   69: ifnull +12 -> 81
    //   72: aload_3
    //   73: ldc 61
    //   75: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   78: ifnonnull +50 -> 128
    //   81: new 63	java/lang/IllegalArgumentException
    //   84: dup
    //   85: new 26	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   92: ldc 65
    //   94: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 67
    //   106: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 69
    //   111: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 70	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_1
    //   122: aload_2
    //   123: invokevirtual 73	java/io/FileInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: aload_0
    //   129: aload_3
    //   130: ldc 55
    //   132: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: putfield 75	com/amazonaws/auth/PropertiesCredentials:accessKey	Ljava/lang/String;
    //   138: aload_0
    //   139: aload_3
    //   140: ldc 61
    //   142: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   145: putfield 77	com/amazonaws/auth/PropertiesCredentials:secretAccessKey	Ljava/lang/String;
    //   148: aload_2
    //   149: invokevirtual 73	java/io/FileInputStream:close	()V
    //   152: return
    //   153: astore_1
    //   154: return
    //   155: astore_2
    //   156: goto -30 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	PropertiesCredentials
    //   0	159	1	paramFile	java.io.File
    //   49	100	2	localFileInputStream	java.io.FileInputStream
    //   155	1	2	localIOException	java.io.IOException
    //   57	83	3	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   50	81	121	finally
    //   81	121	121	finally
    //   128	148	121	finally
    //   148	152	153	java/io/IOException
    //   122	126	155	java/io/IOException
  }
  
  /* Error */
  public PropertiesCredentials(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	java/lang/Object:<init>	()V
    //   4: new 49	java/util/Properties
    //   7: dup
    //   8: invokespecial 50	java/util/Properties:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokevirtual 54	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   17: aload_1
    //   18: invokevirtual 83	java/io/InputStream:close	()V
    //   21: aload_2
    //   22: ldc 55
    //   24: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   27: ifnull +12 -> 39
    //   30: aload_2
    //   31: ldc 61
    //   33: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   36: ifnonnull +20 -> 56
    //   39: new 63	java/lang/IllegalArgumentException
    //   42: dup
    //   43: ldc 85
    //   45: invokespecial 70	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 83	java/io/InputStream:close	()V
    //   54: aload_2
    //   55: athrow
    //   56: aload_0
    //   57: aload_2
    //   58: ldc 55
    //   60: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 75	com/amazonaws/auth/PropertiesCredentials:accessKey	Ljava/lang/String;
    //   66: aload_0
    //   67: aload_2
    //   68: ldc 61
    //   70: invokevirtual 59	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   73: putfield 77	com/amazonaws/auth/PropertiesCredentials:secretAccessKey	Ljava/lang/String;
    //   76: return
    //   77: astore_1
    //   78: goto -57 -> 21
    //   81: astore_1
    //   82: goto -28 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	PropertiesCredentials
    //   0	85	1	paramInputStream	java.io.InputStream
    //   11	20	2	localProperties	java.util.Properties
    //   49	19	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	17	49	finally
    //   17	21	77	java/lang/Exception
    //   50	54	81	java/lang/Exception
  }
  
  public String getAWSAccessKeyId()
  {
    return this.accessKey;
  }
  
  public String getAWSSecretKey()
  {
    return this.secretAccessKey;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/PropertiesCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */