package com.flurry.android.monolithic.sdk.impl;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ei
{
  private static final String a = ei.class.getSimpleName();
  private File b;
  
  public ei(File paramFile)
  {
    this.b = paramFile;
    ja.a(3, a, "Referrer file Name if it exists:  " + this.b);
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 50	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 5
    //   13: aload 5
    //   15: astore_3
    //   16: new 54	java/lang/StringBuffer
    //   19: dup
    //   20: invokespecial 55	java/lang/StringBuffer:<init>	()V
    //   23: astore_1
    //   24: aload 5
    //   26: astore_3
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore 4
    //   34: aload 5
    //   36: astore_3
    //   37: aload 5
    //   39: aload 4
    //   41: invokevirtual 59	java/io/FileInputStream:read	([B)I
    //   44: istore_2
    //   45: iload_2
    //   46: ifle +61 -> 107
    //   49: aload 5
    //   51: astore_3
    //   52: aload_1
    //   53: new 61	java/lang/String
    //   56: dup
    //   57: aload 4
    //   59: iconst_0
    //   60: iload_2
    //   61: invokespecial 64	java/lang/String:<init>	([BII)V
    //   64: invokevirtual 67	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: pop
    //   68: goto -34 -> 34
    //   71: astore 4
    //   73: aload 5
    //   75: astore_3
    //   76: bipush 6
    //   78: getstatic 18	com/flurry/android/monolithic/sdk/impl/ei:a	Ljava/lang/String;
    //   81: ldc 69
    //   83: aload 4
    //   85: invokestatic 72	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload 5
    //   90: invokestatic 77	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   93: aload 6
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +8 -> 105
    //   100: aload_1
    //   101: invokevirtual 78	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: areturn
    //   107: aload 5
    //   109: invokestatic 77	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   112: goto -19 -> 93
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: invokestatic 77	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -7 -> 118
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_1
    //   132: aconst_null
    //   133: astore 5
    //   135: goto -62 -> 73
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_1
    //   142: goto -69 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	ei
    //   0	145	1	paramFile	File
    //   44	17	2	i	int
    //   15	104	3	localObject1	Object
    //   32	26	4	arrayOfByte	byte[]
    //   71	13	4	localThrowable1	Throwable
    //   128	1	4	localThrowable2	Throwable
    //   138	1	4	localThrowable3	Throwable
    //   11	123	5	localFileInputStream	java.io.FileInputStream
    //   1	93	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	34	71	java/lang/Throwable
    //   37	45	71	java/lang/Throwable
    //   52	68	71	java/lang/Throwable
    //   3	13	115	finally
    //   16	24	124	finally
    //   27	34	124	finally
    //   37	45	124	finally
    //   52	68	124	finally
    //   76	88	124	finally
    //   3	13	128	java/lang/Throwable
    //   16	24	138	java/lang/Throwable
  }
  
  private Map<String, List<String>> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("&");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i].split("=");
      if (localObject.length != 2) {
        ja.a(3, a, "Invalid referrer Element: " + arrayOfString[i] + " in referrer tag " + paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        String str = URLDecoder.decode(localObject[0]);
        localObject = URLDecoder.decode(localObject[1]);
        if (localHashMap.get(str) == null) {
          localHashMap.put(str, new ArrayList());
        }
        ((List)localHashMap.get(str)).add(localObject);
      }
    }
    paramString = new StringBuilder();
    if (localHashMap.get("utm_source") == null) {
      paramString.append("Campaign Source is missing.\n");
    }
    if (localHashMap.get("utm_medium") == null) {
      paramString.append("Campaign Medium is missing.\n");
    }
    if (localHashMap.get("utm_campaign") == null) {
      paramString.append("Campaign Name is missing.\n");
    }
    if (paramString.length() > 0) {
      ja.a(5, "Detected missing referrer keys", paramString.toString());
    }
    return localHashMap;
  }
  
  public Map<String, List<String>> a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b.exists())
    {
      ja.a(4, a, "Loading referrer info from file:  " + this.b.getAbsolutePath());
      String str = a(this.b);
      localObject1 = localObject2;
      if (str != null)
      {
        ja.a(3, a, "Parsing referrer map");
        localObject1 = a(str);
      }
    }
    return (Map<String, List<String>>)localObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */