package com.jiubang.playsdk.g;

public class l
{
  public static String a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return a(paramObject.toString(), paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str;
    if ((paramString1 != null) && (paramString1.trim().length() != 0))
    {
      str = paramString1;
      if (!"null".equalsIgnoreCase(paramString1.trim())) {}
    }
    else
    {
      str = paramString2;
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte), "utf-8");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(Object paramObject)
  {
    return (a(paramObject, "").trim().length() == 0) || (a(paramObject, "").equals("null"));
  }
  
  public static String b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "";
    }
    return localObject.toString().trim();
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 57	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 60	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: astore_0
    //   16: aload_0
    //   17: astore_1
    //   18: aload_2
    //   19: astore_3
    //   20: new 62	java/util/zip/GZIPInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 65	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokestatic 70	com/jiubang/playsdk/g/c:a	(Ljava/io/InputStream;)[B
    //   33: astore_1
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 73	java/io/ByteArrayInputStream:close	()V
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 74	java/util/zip/GZIPInputStream:close	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_0
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: astore_1
    //   60: aload_2
    //   61: athrow
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: aload_2
    //   66: astore_1
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 73	java/io/ByteArrayInputStream:close	()V
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 74	java/util/zip/GZIPInputStream:close	()V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_0
    //   88: goto -21 -> 67
    //   91: astore_1
    //   92: aload_2
    //   93: astore_3
    //   94: goto -27 -> 67
    //   97: astore_2
    //   98: aload 4
    //   100: astore_3
    //   101: goto -43 -> 58
    //   104: astore_1
    //   105: aload_2
    //   106: astore_3
    //   107: aload_1
    //   108: astore_2
    //   109: goto -51 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramArrayOfByte	byte[]
    //   17	67	1	localObject1	Object
    //   85	1	1	localObject2	Object
    //   91	1	1	localObject3	Object
    //   104	4	1	localException1	Exception
    //   1	46	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   52	9	2	localException2	Exception
    //   62	31	2	localObject4	Object
    //   97	9	2	localException3	Exception
    //   108	1	2	localObject5	Object
    //   3	104	3	localObject6	Object
    //   5	94	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	52	java/lang/Exception
    //   20	29	62	finally
    //   60	62	62	finally
    //   7	16	85	finally
    //   29	34	91	finally
    //   20	29	97	java/lang/Exception
    //   29	34	104	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */