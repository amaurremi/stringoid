package com.amazonaws.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class VersionInfoUtils
{
  private static final Log log = LogFactory.getLog(VersionInfoUtils.class);
  private static volatile String platform;
  private static volatile String userAgent;
  private static volatile String version;
  
  public static String getPlatform()
  {
    if (platform == null) {}
    try
    {
      if (platform == null) {
        initializeVersion();
      }
      return platform;
    }
    finally {}
  }
  
  public static String getUserAgent()
  {
    if (userAgent == null) {}
    try
    {
      if (userAgent == null) {
        initializeUserAgent();
      }
      return userAgent;
    }
    finally {}
  }
  
  public static String getVersion()
  {
    if (version == null) {}
    try
    {
      if (version == null) {
        initializeVersion();
      }
      return version;
    }
    finally {}
  }
  
  private static void initializeUserAgent()
  {
    userAgent = userAgent();
  }
  
  /* Error */
  private static void initializeVersion()
  {
    // Byte code:
    //   0: ldc 47
    //   2: iconst_1
    //   3: iconst_1
    //   4: anewarray 49	java/lang/Class
    //   7: dup
    //   8: iconst_0
    //   9: ldc 2
    //   11: aastore
    //   12: invokestatic 55	com/amazonaws/util/ClassLoaderHelper:getResourceAsStream	(Ljava/lang/String;Z[Ljava/lang/Class;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: new 57	java/util/Properties
    //   19: dup
    //   20: invokespecial 58	java/util/Properties:<init>	()V
    //   23: astore_1
    //   24: aload_0
    //   25: ifnonnull +59 -> 84
    //   28: new 45	java/lang/Exception
    //   31: dup
    //   32: ldc 60
    //   34: invokespecial 63	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   37: athrow
    //   38: astore_1
    //   39: getstatic 21	com/amazonaws/util/VersionInfoUtils:log	Lorg/apache/commons/logging/Log;
    //   42: new 65	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   49: ldc 68
    //   51: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 75	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokeinterface 84 2 0
    //   69: ldc 86
    //   71: putstatic 41	com/amazonaws/util/VersionInfoUtils:version	Ljava/lang/String;
    //   74: ldc 88
    //   76: putstatic 29	com/amazonaws/util/VersionInfoUtils:platform	Ljava/lang/String;
    //   79: aload_0
    //   80: invokevirtual 93	java/io/InputStream:close	()V
    //   83: return
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_1
    //   90: ldc 98
    //   92: invokevirtual 102	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: putstatic 41	com/amazonaws/util/VersionInfoUtils:version	Ljava/lang/String;
    //   98: aload_1
    //   99: ldc 103
    //   101: invokevirtual 102	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: putstatic 29	com/amazonaws/util/VersionInfoUtils:platform	Ljava/lang/String;
    //   107: aload_0
    //   108: invokevirtual 93	java/io/InputStream:close	()V
    //   111: return
    //   112: astore_0
    //   113: return
    //   114: astore_1
    //   115: aload_0
    //   116: invokevirtual 93	java/io/InputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: return
    //   123: astore_0
    //   124: goto -5 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	93	0	localInputStream	java.io.InputStream
    //   112	4	0	localException1	Exception
    //   121	1	0	localException2	Exception
    //   123	1	0	localException3	Exception
    //   23	1	1	localProperties	java.util.Properties
    //   38	61	1	localException4	Exception
    //   114	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	38	38	java/lang/Exception
    //   84	107	38	java/lang/Exception
    //   107	111	112	java/lang/Exception
    //   28	38	114	finally
    //   39	79	114	finally
    //   84	107	114	finally
    //   79	83	121	java/lang/Exception
    //   115	119	123	java/lang/Exception
  }
  
  private static String replaceSpaces(String paramString)
  {
    return paramString.replace(' ', '_');
  }
  
  static String userAgent()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("aws-sdk-");
    localStringBuilder.append(getPlatform().toLowerCase());
    localStringBuilder.append("/");
    localStringBuilder.append(getVersion());
    localStringBuilder.append(" ");
    localStringBuilder.append(replaceSpaces(System.getProperty("os.name")));
    localStringBuilder.append("/");
    localStringBuilder.append(replaceSpaces(System.getProperty("os.version")));
    localStringBuilder.append(" ");
    localStringBuilder.append(replaceSpaces(System.getProperty("java.vm.name")));
    localStringBuilder.append("/");
    localStringBuilder.append(replaceSpaces(System.getProperty("java.vm.version")));
    localStringBuilder.append("/");
    localStringBuilder.append(replaceSpaces(System.getProperty("java.version")));
    String str1 = System.getProperty("user.language");
    String str2 = System.getProperty("user.region");
    if ((str1 != null) && (str2 != null))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(replaceSpaces(str1));
      localStringBuilder.append("_");
      localStringBuilder.append(replaceSpaces(str2));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/VersionInfoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */