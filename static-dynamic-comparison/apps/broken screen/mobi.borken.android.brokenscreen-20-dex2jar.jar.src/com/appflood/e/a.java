package com.appflood.e;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public final class a
{
  private static byte[] a = new byte[0];
  
  public static InputStream a(URLConnection paramURLConnection)
    throws Exception
  {
    InputStream localInputStream = paramURLConnection.getInputStream();
    paramURLConnection = paramURLConnection.getContentEncoding();
    if ((paramURLConnection != null) && (paramURLConnection.toLowerCase().contains("gzip"))) {
      return new GZIPInputStream(localInputStream);
    }
    if ((paramURLConnection != null) && (paramURLConnection.toLowerCase().contains("deflate"))) {
      return new InflaterInputStream(localInputStream);
    }
    return localInputStream;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return c(paramContext, paramString);
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"), 0, paramString.length());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int j = paramString.length;
      while (i < j)
      {
        ((StringBuffer)localObject).append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  private static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).reset();
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new StringBuilder();
        i = 0;
        if (i < paramArrayOfByte.length)
        {
          String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
          if (str.length() > 1) {
            ((StringBuilder)localObject).append(str);
          } else {
            ((StringBuilder)localObject).append('0').append(str);
          }
        }
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        j.b(paramArrayOfByte, "Failed to compute md5");
        return null;
      }
      paramArrayOfByte = ((StringBuilder)localObject).toString();
      return paramArrayOfByte;
      i += 1;
    }
  }
  
  /* Error */
  private static Map<String, String> a(InputStream paramInputStream, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +170 -> 171
    //   4: new 177	java/util/HashMap
    //   7: dup
    //   8: invokespecial 178	java/util/HashMap:<init>	()V
    //   11: astore_3
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: aload_3
    //   17: areturn
    //   18: new 180	java/io/BufferedReader
    //   21: dup
    //   22: new 182	java/io/InputStreamReader
    //   25: dup
    //   26: aload_0
    //   27: ldc 66
    //   29: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   32: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +97 -> 143
    //   49: aload_1
    //   50: astore_0
    //   51: aload 4
    //   53: invokevirtual 194	java/lang/String:trim	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload_1
    //   59: astore_0
    //   60: aload 4
    //   62: ldc -60
    //   64: invokevirtual 200	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifne -31 -> 36
    //   70: aload_1
    //   71: astore_0
    //   72: aload 4
    //   74: bipush 61
    //   76: invokevirtual 204	java/lang/String:indexOf	(I)I
    //   79: istore_2
    //   80: iload_2
    //   81: iconst_m1
    //   82: if_icmpeq -46 -> 36
    //   85: aload_1
    //   86: astore_0
    //   87: aload_3
    //   88: aload 4
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 206	java/lang/String:substring	(II)Ljava/lang/String;
    //   95: aload 4
    //   97: iload_2
    //   98: iconst_1
    //   99: iadd
    //   100: invokevirtual 96	java/lang/String:substring	(I)Ljava/lang/String;
    //   103: invokeinterface 210 3 0
    //   108: pop
    //   109: goto -73 -> 36
    //   112: astore 4
    //   114: aload_1
    //   115: astore_0
    //   116: new 110	java/lang/StringBuilder
    //   119: dup
    //   120: ldc -44
    //   122: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 220	com/appflood/e/j:c	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   140: pop
    //   141: aload_3
    //   142: areturn
    //   143: aload_1
    //   144: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   147: pop
    //   148: aload_3
    //   149: areturn
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   157: pop
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto -8 -> 153
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -54 -> 114
    //   171: aload_1
    //   172: astore_3
    //   173: goto -161 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramInputStream	InputStream
    //   0	176	1	paramMap	Map<String, String>
    //   79	21	2	i	int
    //   11	162	3	localObject	Object
    //   42	54	4	str	String
    //   112	14	4	localException1	Exception
    //   164	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   38	44	112	java/lang/Exception
    //   51	58	112	java/lang/Exception
    //   60	70	112	java/lang/Exception
    //   72	80	112	java/lang/Exception
    //   87	109	112	java/lang/Exception
    //   18	36	150	finally
    //   38	44	160	finally
    //   51	58	160	finally
    //   60	70	160	finally
    //   72	80	160	finally
    //   87	109	160	finally
    //   116	136	160	finally
    //   18	36	164	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2);
  }
  
  public static boolean a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return true;
    }
    catch (Throwable localThrowable)
    {
      j.a(localThrowable, "Failed to close IO" + paramCloseable.toString());
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: new 243	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 246	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 251	java/io/OutputStream:write	([B)V
    //   26: aload_3
    //   27: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   30: pop
    //   31: iconst_1
    //   32: ireturn
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_1
    //   38: astore_2
    //   39: aload 4
    //   41: new 110	java/lang/StringBuilder
    //   44: dup
    //   45: ldc -3
    //   47: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 258	java/io/File:getPath	()Ljava/lang/String;
    //   54: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   67: pop
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   77: pop
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: goto -8 -> 73
    //   84: astore 4
    //   86: aload_3
    //   87: astore_1
    //   88: goto -51 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramFile	File
    //   0	91	1	paramArrayOfByte	byte[]
    //   20	54	2	localObject	Object
    //   18	69	3	localFileOutputStream	java.io.FileOutputStream
    //   33	7	4	localThrowable1	Throwable
    //   84	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	19	33	java/lang/Throwable
    //   10	19	70	finally
    //   21	26	80	finally
    //   39	63	80	finally
    //   21	26	84	java/lang/Throwable
  }
  
  public static byte[] a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = a(new FileInputStream(paramFile));
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      j.a(localThrowable, "failed to load dataFromFile " + paramFile.getPath());
    }
    return null;
  }
  
  /* Error */
  private static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +7 -> 8
    //   4: getstatic 10	com/appflood/e/a:a	[B
    //   7: areturn
    //   8: new 272	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 273	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_2
    //   16: sipush 1024
    //   19: newarray <illegal type>
    //   21: astore_3
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 279	java/io/InputStream:read	([B)I
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_m1
    //   30: if_icmpeq +30 -> 60
    //   33: aload_2
    //   34: aload_3
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual 281	java/io/ByteArrayOutputStream:write	([BII)V
    //   40: goto -18 -> 22
    //   43: astore_2
    //   44: aload_2
    //   45: ldc_w 283
    //   48: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   51: aload_0
    //   52: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   55: pop
    //   56: getstatic 10	com/appflood/e/a:a	[B
    //   59: areturn
    //   60: aload_2
    //   61: invokevirtual 286	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_2
    //   65: aload_0
    //   66: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   69: pop
    //   70: aload_2
    //   71: areturn
    //   72: astore_2
    //   73: aload_0
    //   74: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   77: pop
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramInputStream	InputStream
    //   27	10	1	i	int
    //   15	19	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   43	18	2	localThrowable	Throwable
    //   64	7	2	arrayOfByte1	byte[]
    //   72	7	2	localObject	Object
    //   21	14	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	28	43	java/lang/Throwable
    //   33	40	43	java/lang/Throwable
    //   60	65	43	java/lang/Throwable
    //   22	28	72	finally
    //   33	40	72	finally
    //   44	51	72	finally
    //   60	65	72	finally
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return d(paramContext, paramString);
  }
  
  /* Error */
  private static int b(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: invokestatic 300	com/appflood/c/f:e	()Ljava/io/File;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: aload 4
    //   22: ifnonnull +18 -> 40
    //   25: aload 4
    //   27: astore_3
    //   28: aload_0
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: ldc_w 302
    //   36: invokevirtual 308	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +25 -> 66
    //   44: new 110	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 310
    //   51: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 220	com/appflood/e/j:c	(Ljava/lang/String;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_3
    //   67: invokevirtual 262	java/io/File:exists	()Z
    //   70: ifne +60 -> 130
    //   73: new 110	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 312
    //   80: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_3
    //   84: invokevirtual 315	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: pop
    //   94: invokestatic 317	com/appflood/e/j:a	()V
    //   97: invokestatic 317	com/appflood/e/j:a	()V
    //   100: aload_3
    //   101: ifnull +24 -> 125
    //   104: aload_3
    //   105: invokevirtual 320	java/io/File:getParentFile	()Ljava/io/File;
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +15 -> 125
    //   113: aload_0
    //   114: invokevirtual 262	java/io/File:exists	()Z
    //   117: ifne +8 -> 125
    //   120: aload_0
    //   121: invokevirtual 323	java/io/File:mkdirs	()Z
    //   124: pop
    //   125: aload_3
    //   126: invokevirtual 326	java/io/File:createNewFile	()Z
    //   129: pop
    //   130: new 177	java/util/HashMap
    //   133: dup
    //   134: invokespecial 178	java/util/HashMap:<init>	()V
    //   137: astore 9
    //   139: new 264	java/io/FileInputStream
    //   142: dup
    //   143: aload_3
    //   144: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: astore 4
    //   149: aload 4
    //   151: astore_0
    //   152: aload 4
    //   154: aload 9
    //   156: invokestatic 328	com/appflood/e/a:a	(Ljava/io/InputStream;Ljava/util/Map;)Ljava/util/Map;
    //   159: pop
    //   160: aload 4
    //   162: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   165: pop
    //   166: aload 9
    //   168: aload_1
    //   169: aload_2
    //   170: invokeinterface 210 3 0
    //   175: pop
    //   176: new 243	java/io/FileOutputStream
    //   179: dup
    //   180: aload_3
    //   181: invokespecial 246	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   184: astore_3
    //   185: aload_3
    //   186: astore_1
    //   187: aload 5
    //   189: astore_0
    //   190: aload 6
    //   192: astore_2
    //   193: aload_3
    //   194: invokevirtual 332	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   197: astore 7
    //   199: aload_3
    //   200: astore_1
    //   201: aload 5
    //   203: astore_0
    //   204: aload 6
    //   206: astore_2
    //   207: aload 7
    //   209: invokevirtual 338	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   212: astore 4
    //   214: aload 4
    //   216: ifnonnull +96 -> 312
    //   219: aload_3
    //   220: astore_1
    //   221: aload 4
    //   223: astore_0
    //   224: aload 4
    //   226: astore_2
    //   227: aload 7
    //   229: invokevirtual 339	java/nio/channels/FileChannel:close	()V
    //   232: aload_3
    //   233: astore_1
    //   234: aload 4
    //   236: astore_0
    //   237: aload 4
    //   239: astore_2
    //   240: aload_3
    //   241: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   244: pop
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   255: aload_3
    //   256: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   259: pop
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: aload_0
    //   264: ldc_w 346
    //   267: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   270: iconst_0
    //   271: ireturn
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_1
    //   276: astore_0
    //   277: aload_2
    //   278: ldc_w 348
    //   281: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   284: aload_1
    //   285: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   288: pop
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   298: pop
    //   299: aload_1
    //   300: athrow
    //   301: astore_0
    //   302: aload_0
    //   303: ldc_w 350
    //   306: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   309: goto -54 -> 255
    //   312: aload_3
    //   313: astore_1
    //   314: aload 4
    //   316: astore_0
    //   317: aload 4
    //   319: astore_2
    //   320: aload_3
    //   321: aload 9
    //   323: invokestatic 352	com/appflood/e/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   326: ldc 66
    //   328: invokevirtual 70	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   331: invokevirtual 353	java/io/FileOutputStream:write	([B)V
    //   334: aload 4
    //   336: ifnull +8 -> 344
    //   339: aload 4
    //   341: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   344: aload_3
    //   345: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   348: pop
    //   349: iconst_1
    //   350: ireturn
    //   351: astore_0
    //   352: aload_0
    //   353: ldc_w 350
    //   356: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   359: goto -15 -> 344
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_3
    //   366: aload 7
    //   368: astore_2
    //   369: aload_3
    //   370: astore_1
    //   371: aload_2
    //   372: astore_0
    //   373: aload 4
    //   375: ldc_w 355
    //   378: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   389: aload_3
    //   390: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   393: pop
    //   394: iconst_0
    //   395: ireturn
    //   396: astore_0
    //   397: aload_0
    //   398: ldc_w 350
    //   401: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   404: goto -15 -> 389
    //   407: astore_2
    //   408: aconst_null
    //   409: astore_1
    //   410: aload 8
    //   412: astore_0
    //   413: aload_0
    //   414: ifnull +7 -> 421
    //   417: aload_0
    //   418: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   421: aload_1
    //   422: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   425: pop
    //   426: aload_2
    //   427: athrow
    //   428: astore_0
    //   429: aload_0
    //   430: ldc_w 350
    //   433: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   436: goto -15 -> 421
    //   439: astore_2
    //   440: goto -27 -> 413
    //   443: astore 4
    //   445: goto -76 -> 369
    //   448: astore_1
    //   449: goto -155 -> 294
    //   452: astore_2
    //   453: aload 4
    //   455: astore_1
    //   456: goto -181 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramContext	Context
    //   0	459	1	paramString1	String
    //   0	459	2	paramString2	String
    //   19	371	3	localObject1	Object
    //   15	325	4	localObject2	Object
    //   362	12	4	localIOException1	java.io.IOException
    //   443	11	4	localIOException2	java.io.IOException
    //   4	198	5	localObject3	Object
    //   7	198	6	localObject4	Object
    //   10	357	7	localFileChannel	java.nio.channels.FileChannel
    //   1	410	8	localObject5	Object
    //   137	185	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   97	100	262	java/io/IOException
    //   104	109	262	java/io/IOException
    //   113	125	262	java/io/IOException
    //   125	130	262	java/io/IOException
    //   139	149	272	java/io/FileNotFoundException
    //   139	149	291	finally
    //   250	255	301	java/io/IOException
    //   339	344	351	java/io/IOException
    //   176	185	362	java/io/IOException
    //   385	389	396	java/io/IOException
    //   176	185	407	finally
    //   417	421	428	java/io/IOException
    //   193	199	439	finally
    //   207	214	439	finally
    //   227	232	439	finally
    //   240	245	439	finally
    //   320	334	439	finally
    //   373	381	439	finally
    //   193	199	443	java/io/IOException
    //   207	214	443	java/io/IOException
    //   227	232	443	java/io/IOException
    //   240	245	443	java/io/IOException
    //   320	334	443	java/io/IOException
    //   152	160	448	finally
    //   277	284	448	finally
    //   152	160	452	java/io/FileNotFoundException
  }
  
  public static String b(String paramString)
  {
    return a(j.b(paramString));
  }
  
  /* Error */
  private static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 300	com/appflood/c/f:e	()Ljava/io/File;
    //   3: astore_3
    //   4: aload_3
    //   5: astore_2
    //   6: aload_3
    //   7: ifnonnull +17 -> 24
    //   10: aload_3
    //   11: astore_2
    //   12: aload_0
    //   13: ifnull +11 -> 24
    //   16: aload_0
    //   17: ldc_w 302
    //   20: invokevirtual 308	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +26 -> 51
    //   28: new 110	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 310
    //   35: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 220	com/appflood/e/j:c	(Ljava/lang/String;)V
    //   48: ldc 107
    //   50: areturn
    //   51: aload_2
    //   52: invokevirtual 262	java/io/File:exists	()Z
    //   55: ifne +6 -> 61
    //   58: ldc 107
    //   60: areturn
    //   61: new 264	java/io/FileInputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_2
    //   70: new 177	java/util/HashMap
    //   73: dup
    //   74: invokespecial 178	java/util/HashMap:<init>	()V
    //   77: astore_0
    //   78: aload_2
    //   79: aload_0
    //   80: invokestatic 328	com/appflood/e/a:a	(Ljava/io/InputStream;Ljava/util/Map;)Ljava/util/Map;
    //   83: pop
    //   84: aload_0
    //   85: aload_1
    //   86: invokeinterface 363 2 0
    //   91: ifeq +30 -> 121
    //   94: aload_0
    //   95: aload_1
    //   96: invokeinterface 367 2 0
    //   101: checkcast 26	java/lang/String
    //   104: astore_0
    //   105: aload_2
    //   106: invokevirtual 368	java/io/InputStream:close	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_1
    //   112: aload_1
    //   113: ldc_w 348
    //   116: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   119: aload_0
    //   120: areturn
    //   121: ldc 107
    //   123: areturn
    //   124: astore_1
    //   125: ldc 107
    //   127: astore_0
    //   128: aload_1
    //   129: ldc_w 370
    //   132: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   135: aload_0
    //   136: areturn
    //   137: astore_1
    //   138: goto -10 -> 128
    //   141: astore_1
    //   142: ldc 107
    //   144: astore_0
    //   145: goto -33 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   0	148	1	paramString	String
    //   5	101	2	localObject	Object
    //   3	8	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	109	111	java/io/FileNotFoundException
    //   61	105	124	java/io/IOException
    //   105	109	137	java/io/IOException
    //   61	105	141	java/io/FileNotFoundException
  }
  
  /* Error */
  private static int d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 300	com/appflood/c/f:e	()Ljava/io/File;
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: ifnonnull +17 -> 36
    //   22: aload_3
    //   23: astore_2
    //   24: aload_0
    //   25: ifnull +11 -> 36
    //   28: aload_0
    //   29: ldc_w 302
    //   32: invokevirtual 308	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnonnull +25 -> 62
    //   40: new 110	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 310
    //   47: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 220	com/appflood/e/j:c	(Ljava/lang/String;)V
    //   60: iconst_0
    //   61: ireturn
    //   62: aload_2
    //   63: invokevirtual 262	java/io/File:exists	()Z
    //   66: ifne +11 -> 77
    //   69: invokestatic 317	com/appflood/e/j:a	()V
    //   72: aload_2
    //   73: invokevirtual 326	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: new 177	java/util/HashMap
    //   80: dup
    //   81: invokespecial 178	java/util/HashMap:<init>	()V
    //   84: astore 8
    //   86: new 264	java/io/FileInputStream
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore_3
    //   95: aload_3
    //   96: astore_0
    //   97: aload_3
    //   98: aload 8
    //   100: invokestatic 328	com/appflood/e/a:a	(Ljava/io/InputStream;Ljava/util/Map;)Ljava/util/Map;
    //   103: pop
    //   104: aload_3
    //   105: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   108: pop
    //   109: aload 8
    //   111: aload_1
    //   112: invokeinterface 363 2 0
    //   117: ifeq +137 -> 254
    //   120: aload 8
    //   122: aload_1
    //   123: invokeinterface 373 2 0
    //   128: pop
    //   129: new 243	java/io/FileOutputStream
    //   132: dup
    //   133: aload_2
    //   134: invokespecial 246	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: aload_3
    //   139: astore_1
    //   140: aload 4
    //   142: astore_0
    //   143: aload 5
    //   145: astore_2
    //   146: aload_3
    //   147: invokevirtual 332	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   150: astore 6
    //   152: aload_3
    //   153: astore_1
    //   154: aload 4
    //   156: astore_0
    //   157: aload 5
    //   159: astore_2
    //   160: aload 6
    //   162: invokevirtual 338	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   165: astore 4
    //   167: aload 4
    //   169: ifnonnull +98 -> 267
    //   172: aload_3
    //   173: astore_1
    //   174: aload 4
    //   176: astore_0
    //   177: aload 4
    //   179: astore_2
    //   180: aload 6
    //   182: invokevirtual 339	java/nio/channels/FileChannel:close	()V
    //   185: aload_3
    //   186: astore_1
    //   187: aload 4
    //   189: astore_0
    //   190: aload 4
    //   192: astore_2
    //   193: aload_3
    //   194: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   197: pop
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   208: aload_3
    //   209: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   212: pop
    //   213: iconst_0
    //   214: ireturn
    //   215: astore_0
    //   216: aload_0
    //   217: ldc_w 346
    //   220: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_2
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_1
    //   229: astore_0
    //   230: aload_2
    //   231: ldc_w 348
    //   234: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   237: aload_1
    //   238: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   241: pop
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_0
    //   247: aload_0
    //   248: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   251: pop
    //   252: aload_1
    //   253: athrow
    //   254: iconst_m1
    //   255: ireturn
    //   256: astore_0
    //   257: aload_0
    //   258: ldc_w 350
    //   261: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   264: goto -56 -> 208
    //   267: aload_3
    //   268: astore_1
    //   269: aload 4
    //   271: astore_0
    //   272: aload 4
    //   274: astore_2
    //   275: aload_3
    //   276: aload 8
    //   278: invokestatic 352	com/appflood/e/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   281: ldc 66
    //   283: invokevirtual 70	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   286: invokevirtual 353	java/io/FileOutputStream:write	([B)V
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   299: aload_3
    //   300: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   303: pop
    //   304: iconst_1
    //   305: ireturn
    //   306: astore_0
    //   307: aload_0
    //   308: ldc_w 350
    //   311: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   314: goto -15 -> 299
    //   317: astore 4
    //   319: aconst_null
    //   320: astore_3
    //   321: aload 6
    //   323: astore_2
    //   324: aload_3
    //   325: astore_1
    //   326: aload_2
    //   327: astore_0
    //   328: aload 4
    //   330: ldc_w 355
    //   333: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   336: aload_2
    //   337: ifnull +7 -> 344
    //   340: aload_2
    //   341: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   344: aload_3
    //   345: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   348: pop
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_0
    //   352: aload_0
    //   353: ldc_w 350
    //   356: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   359: goto -15 -> 344
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_1
    //   365: aload 7
    //   367: astore_0
    //   368: aload_0
    //   369: ifnull +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 344	java/nio/channels/FileLock:release	()V
    //   376: aload_1
    //   377: invokestatic 223	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   380: pop
    //   381: aload_2
    //   382: athrow
    //   383: astore_0
    //   384: aload_0
    //   385: ldc_w 350
    //   388: invokestatic 240	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   391: goto -15 -> 376
    //   394: astore_2
    //   395: goto -27 -> 368
    //   398: astore 4
    //   400: goto -76 -> 324
    //   403: astore_1
    //   404: goto -157 -> 247
    //   407: astore_2
    //   408: aload_3
    //   409: astore_1
    //   410: goto -182 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramContext	Context
    //   0	413	1	paramString	String
    //   17	176	2	localObject1	Object
    //   225	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   274	67	2	localObject2	Object
    //   362	20	2	localObject3	Object
    //   394	1	2	localObject4	Object
    //   407	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   15	394	3	localObject5	Object
    //   4	291	4	localFileLock	java.nio.channels.FileLock
    //   317	12	4	localIOException1	java.io.IOException
    //   398	1	4	localIOException2	java.io.IOException
    //   7	151	5	localObject6	Object
    //   10	312	6	localFileChannel	java.nio.channels.FileChannel
    //   1	365	7	localObject7	Object
    //   84	193	8	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   69	77	215	java/io/IOException
    //   86	95	225	java/io/FileNotFoundException
    //   86	95	244	finally
    //   203	208	256	java/io/IOException
    //   294	299	306	java/io/IOException
    //   129	138	317	java/io/IOException
    //   340	344	351	java/io/IOException
    //   129	138	362	finally
    //   372	376	383	java/io/IOException
    //   146	152	394	finally
    //   160	167	394	finally
    //   180	185	394	finally
    //   193	198	394	finally
    //   275	289	394	finally
    //   328	336	394	finally
    //   146	152	398	java/io/IOException
    //   160	167	398	java/io/IOException
    //   180	185	398	java/io/IOException
    //   193	198	398	java/io/IOException
    //   275	289	398	java/io/IOException
    //   97	104	403	finally
    //   230	237	403	finally
    //   97	104	407	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */