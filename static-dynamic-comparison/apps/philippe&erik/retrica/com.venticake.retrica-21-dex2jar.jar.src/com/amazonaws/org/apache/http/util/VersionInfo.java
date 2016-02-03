package com.amazonaws.org.apache.http.util;

import java.util.Map;
import java.util.Map<**>;

public class VersionInfo
{
  private final String infoClassloader;
  private final String infoModule;
  private final String infoPackage;
  private final String infoRelease;
  private final String infoTimestamp;
  
  protected VersionInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Package identifier must not be null.");
    }
    this.infoPackage = paramString1;
    if (paramString2 != null)
    {
      this.infoModule = paramString2;
      if (paramString3 == null) {
        break label70;
      }
      label36:
      this.infoRelease = paramString3;
      if (paramString4 == null) {
        break label76;
      }
      label46:
      this.infoTimestamp = paramString4;
      if (paramString5 == null) {
        break label83;
      }
    }
    for (;;)
    {
      this.infoClassloader = paramString5;
      return;
      paramString2 = "UNAVAILABLE";
      break;
      label70:
      paramString3 = "UNAVAILABLE";
      break label36;
      label76:
      paramString4 = "UNAVAILABLE";
      break label46;
      label83:
      paramString5 = "UNAVAILABLE";
    }
  }
  
  protected static final VersionInfo fromMap(String paramString, Map<?, ?> paramMap, ClassLoader paramClassLoader)
  {
    Object localObject4 = null;
    if (paramString == null) {
      throw new IllegalArgumentException("Package identifier must not be null.");
    }
    Object localObject1;
    Object localObject2;
    label87:
    Object localObject3;
    if (paramMap != null)
    {
      localObject1 = (String)paramMap.get("info.module");
      if ((localObject1 != null) && (((String)localObject1).length() < 1))
      {
        localObject1 = null;
        localObject2 = (String)paramMap.get("info.release");
        if ((localObject2 != null) && ((((String)localObject2).length() < 1) || (((String)localObject2).equals("${pom.version}"))))
        {
          localObject2 = null;
          localObject3 = (String)paramMap.get("info.timestamp");
          if ((localObject3 != null) && ((((String)localObject3).length() < 1) || (((String)localObject3).equals("${mvn.timestamp}"))))
          {
            Object localObject5 = null;
            paramMap = (Map<?, ?>)localObject2;
            localObject3 = localObject1;
            localObject2 = localObject5;
            localObject1 = paramMap;
            paramMap = (Map<?, ?>)localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject4;
      if (paramClassLoader != null) {
        localObject3 = paramClassLoader.toString();
      }
      return new VersionInfo(paramString, paramMap, (String)localObject1, (String)localObject2, (String)localObject3);
      paramMap = (Map<?, ?>)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      continue;
      break label87;
      break;
      localObject2 = null;
      localObject1 = null;
      paramMap = null;
    }
  }
  
  /* Error */
  public static final VersionInfo loadVersionInfo(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +13 -> 16
    //   6: new 17	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 19
    //   12: invokespecial 22	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_1
    //   17: astore_2
    //   18: aload_1
    //   19: ifnonnull +10 -> 29
    //   22: invokestatic 81	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 85	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   28: astore_2
    //   29: aload_2
    //   30: new 87	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: bipush 46
    //   40: bipush 47
    //   42: invokevirtual 92	java/lang/String:replace	(CC)Ljava/lang/String;
    //   45: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 98
    //   50: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 100
    //   55: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 107	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +54 -> 122
    //   71: new 109	java/util/Properties
    //   74: dup
    //   75: invokespecial 110	java/util/Properties:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 114	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload 4
    //   87: invokevirtual 119	java/io/InputStream:close	()V
    //   90: aload_1
    //   91: ifnull +10 -> 101
    //   94: aload_0
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic 121	com/amazonaws/org/apache/http/util/VersionInfo:fromMap	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcom/amazonaws/org/apache/http/util/VersionInfo;
    //   100: astore_3
    //   101: aload_3
    //   102: areturn
    //   103: astore_1
    //   104: aload 4
    //   106: invokevirtual 119	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -24 -> 90
    //   117: astore 4
    //   119: goto -29 -> 90
    //   122: aconst_null
    //   123: astore_1
    //   124: goto -34 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   0	127	1	paramClassLoader	ClassLoader
    //   17	80	2	localClassLoader	ClassLoader
    //   1	101	3	localVersionInfo	VersionInfo
    //   64	41	4	localInputStream	java.io.InputStream
    //   117	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   71	85	103	finally
    //   29	66	111	java/io/IOException
    //   104	111	111	java/io/IOException
    //   85	90	117	java/io/IOException
  }
  
  public final String getRelease()
  {
    return this.infoRelease;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
    localStringBuilder.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
    if (!"UNAVAILABLE".equals(this.infoRelease)) {
      localStringBuilder.append(':').append(this.infoRelease);
    }
    if (!"UNAVAILABLE".equals(this.infoTimestamp)) {
      localStringBuilder.append(':').append(this.infoTimestamp);
    }
    localStringBuilder.append(')');
    if (!"UNAVAILABLE".equals(this.infoClassloader)) {
      localStringBuilder.append('@').append(this.infoClassloader);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/util/VersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */