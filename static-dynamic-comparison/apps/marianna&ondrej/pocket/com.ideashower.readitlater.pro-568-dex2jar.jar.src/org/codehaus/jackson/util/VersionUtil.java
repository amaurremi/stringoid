package org.codehaus.jackson.util;

import java.util.regex.Pattern;
import org.codehaus.jackson.Version;

public class VersionUtil
{
  public static final String VERSION_FILE = "VERSION.txt";
  private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
  
  public static Version parseVersion(String paramString)
  {
    int i = 0;
    Object localObject = null;
    if (paramString == null) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return null;
        paramString = paramString.trim();
      } while (paramString.length() == 0);
      arrayOfString = VERSION_SEPARATOR.split(paramString);
    } while (arrayOfString.length < 2);
    int j = parseVersionPart(arrayOfString[0]);
    int k = parseVersionPart(arrayOfString[1]);
    if (arrayOfString.length > 2) {
      i = parseVersionPart(arrayOfString[2]);
    }
    paramString = (String)localObject;
    if (arrayOfString.length > 3) {
      paramString = arrayOfString[3];
    }
    return new Version(j, k, i, paramString);
  }
  
  protected static int parseVersionPart(String paramString)
  {
    int i = 0;
    paramString = paramString.toString();
    int k = paramString.length();
    int j = 0;
    for (;;)
    {
      int m;
      if (i < k)
      {
        m = paramString.charAt(i);
        if ((m <= 57) && (m >= 48)) {}
      }
      else
      {
        return j;
      }
      j = j * 10 + (m - 48);
      i += 1;
    }
  }
  
  /* Error */
  public static Version versionFor(Class paramClass)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: aload_0
    //   7: ldc 8
    //   9: invokevirtual 68	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 4
    //   14: aload_3
    //   15: astore_0
    //   16: aload 4
    //   18: ifnull +33 -> 51
    //   21: new 70	java/io/BufferedReader
    //   24: dup
    //   25: new 72	java/io/InputStreamReader
    //   28: dup
    //   29: aload 4
    //   31: ldc 74
    //   33: invokespecial 77	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   36: invokespecial 80	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: invokevirtual 83	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: invokestatic 85	org/codehaus/jackson/util/VersionUtil:parseVersion	(Ljava/lang/String;)Lorg/codehaus/jackson/Version;
    //   45: astore_0
    //   46: aload 4
    //   48: invokevirtual 90	java/io/InputStream:close	()V
    //   51: aload_0
    //   52: astore_1
    //   53: aload_0
    //   54: ifnonnull +7 -> 61
    //   57: invokestatic 94	org/codehaus/jackson/Version:unknownVersion	()Lorg/codehaus/jackson/Version;
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_2
    //   64: aload_0
    //   65: astore_1
    //   66: new 96	java/lang/RuntimeException
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   74: athrow
    //   75: astore_0
    //   76: aload_1
    //   77: astore_0
    //   78: goto -27 -> 51
    //   81: astore_0
    //   82: aload 4
    //   84: invokevirtual 90	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: astore_1
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: astore_1
    //   94: new 96	java/lang/RuntimeException
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramClass	Class
    //   5	89	1	localObject1	Object
    //   1	4	2	localObject2	Object
    //   63	30	2	localIOException	java.io.IOException
    //   3	12	3	localObject3	Object
    //   12	71	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   46	51	63	java/io/IOException
    //   6	14	75	java/io/IOException
    //   66	75	75	java/io/IOException
    //   89	91	75	java/io/IOException
    //   94	103	75	java/io/IOException
    //   21	46	81	finally
    //   82	87	91	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/VersionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */