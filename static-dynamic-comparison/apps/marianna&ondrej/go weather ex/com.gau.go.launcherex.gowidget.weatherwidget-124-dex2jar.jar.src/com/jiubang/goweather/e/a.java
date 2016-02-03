package com.jiubang.goweather.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Locale;

public class a
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale;
      paramContext = paramContext.getLanguage() + "_" + paramContext.getCountry();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "en_US";
  }
  
  public static String a(InputStream paramInputStream)
  {
    return a(paramInputStream, "UTF-8");
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramInputStream.close();
    localByteArrayOutputStream.close();
    return new String(arrayOfByte, paramString);
  }
  
  /* Error */
  public static String a(InputStream paramInputStream, String paramString, f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 28	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload_1
    //   15: ifnonnull +102 -> 117
    //   18: new 93	java/io/InputStreamReader
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 96	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_0
    //   27: new 98	java/io/BufferedReader
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +186 -> 228
    //   45: aload 5
    //   47: aload_3
    //   48: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: ldc 106
    //   56: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -24 -> 36
    //   63: astore 4
    //   65: aload_1
    //   66: astore_3
    //   67: aload 4
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   74: aload_2
    //   75: ifnull +20 -> 95
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   83: aload_2
    //   84: bipush 11
    //   86: invokevirtual 116	com/jiubang/goweather/b/f:b	(I)V
    //   89: aload_2
    //   90: bipush 7
    //   92: invokevirtual 119	com/jiubang/goweather/b/f:c	(I)V
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 120	java/io/BufferedReader:close	()V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 121	java/io/InputStreamReader:close	()V
    //   111: aload 5
    //   113: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: areturn
    //   117: new 93	java/io/InputStreamReader
    //   120: dup
    //   121: aload_0
    //   122: aload_1
    //   123: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   126: astore_0
    //   127: goto -100 -> 27
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -63 -> 70
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload 4
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 120	java/io/BufferedReader:close	()V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 121	java/io/InputStreamReader:close	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   165: aload_2
    //   166: ifnull -16 -> 150
    //   169: aload_2
    //   170: aload_3
    //   171: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   174: goto -24 -> 150
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   182: aload_2
    //   183: ifnull -25 -> 158
    //   186: aload_2
    //   187: aload_0
    //   188: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   191: goto -33 -> 158
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   199: aload_2
    //   200: ifnull -97 -> 103
    //   203: aload_2
    //   204: aload_1
    //   205: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   208: goto -105 -> 103
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   216: aload_2
    //   217: ifnull -106 -> 111
    //   220: aload_2
    //   221: aload_0
    //   222: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   225: goto -114 -> 111
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 120	java/io/BufferedReader:close	()V
    //   236: aload_0
    //   237: ifnull -126 -> 111
    //   240: aload_0
    //   241: invokevirtual 121	java/io/InputStreamReader:close	()V
    //   244: goto -133 -> 111
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   252: aload_2
    //   253: ifnull -142 -> 111
    //   256: goto -36 -> 220
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   264: aload_2
    //   265: ifnull -29 -> 236
    //   268: aload_2
    //   269: aload_1
    //   270: invokevirtual 112	com/jiubang/goweather/b/f:a	(Ljava/lang/Throwable;)V
    //   273: goto -37 -> 236
    //   276: astore_1
    //   277: aload 4
    //   279: astore_3
    //   280: goto -138 -> 142
    //   283: astore 4
    //   285: aload_1
    //   286: astore_3
    //   287: aload 4
    //   289: astore_1
    //   290: goto -148 -> 142
    //   293: astore_1
    //   294: goto -152 -> 142
    //   297: astore_1
    //   298: goto -228 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramInputStream	InputStream
    //   0	301	1	paramString	String
    //   0	301	2	paramf	f
    //   4	143	3	localObject1	Object
    //   160	11	3	localIOException1	IOException
    //   279	8	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   63	215	4	localIOException2	IOException
    //   283	5	4	localObject4	Object
    //   12	100	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	41	63	java/io/IOException
    //   45	60	63	java/io/IOException
    //   18	27	130	java/io/IOException
    //   117	127	130	java/io/IOException
    //   18	27	136	finally
    //   117	127	136	finally
    //   146	150	160	java/io/IOException
    //   154	158	177	java/io/IOException
    //   99	103	194	java/io/IOException
    //   107	111	211	java/io/IOException
    //   240	244	247	java/io/IOException
    //   232	236	259	java/io/IOException
    //   27	36	276	finally
    //   36	41	283	finally
    //   45	60	283	finally
    //   70	74	293	finally
    //   78	95	293	finally
    //   27	36	297	java/io/IOException
  }
  
  public static Proxy a()
  {
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str1, Integer.valueOf(str2).intValue()));
    }
    return null;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 176	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokevirtual 179	java/io/File:isFile	()Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 182	java/io/File:canRead	()Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_1
    //   32: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 176	java/io/File:exists	()Z
    //   38: ifne +11 -> 49
    //   41: aload_1
    //   42: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   45: invokevirtual 189	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 176	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aload_1
    //   57: invokevirtual 192	java/io/File:delete	()Z
    //   60: pop
    //   61: new 194	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 197	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore 11
    //   71: new 199	java/io/FileOutputStream
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 200	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_0
    //   80: aload 11
    //   82: lload_2
    //   83: invokevirtual 204	java/io/FileInputStream:skip	(J)J
    //   86: pop2
    //   87: ldc2_w 205
    //   90: lload 4
    //   92: invokestatic 212	java/lang/Math:min	(JJ)J
    //   95: l2i
    //   96: newarray <illegal type>
    //   98: astore_1
    //   99: lconst_0
    //   100: lstore_2
    //   101: lload_2
    //   102: lload 4
    //   104: lcmp
    //   105: ifge +136 -> 241
    //   108: aload 11
    //   110: aload_1
    //   111: invokevirtual 213	java/io/FileInputStream:read	([B)I
    //   114: istore 6
    //   116: iload 6
    //   118: ifle +123 -> 241
    //   121: aload_0
    //   122: aload_1
    //   123: iconst_0
    //   124: iload 6
    //   126: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   129: lload_2
    //   130: iload 6
    //   132: i2l
    //   133: ladd
    //   134: lstore 7
    //   136: lload 4
    //   138: lload 7
    //   140: lsub
    //   141: lstore 9
    //   143: lload 7
    //   145: lstore_2
    //   146: lload 9
    //   148: aload_1
    //   149: arraylength
    //   150: i2l
    //   151: lcmp
    //   152: ifge -51 -> 101
    //   155: lload 9
    //   157: l2i
    //   158: newarray <illegal type>
    //   160: astore_1
    //   161: lload 7
    //   163: lstore_2
    //   164: goto -63 -> 101
    //   167: astore 11
    //   169: aconst_null
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   176: ifeq +8 -> 184
    //   179: aload 11
    //   181: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 220	java/io/FileInputStream:close	()V
    //   192: aload_0
    //   193: ifnull -182 -> 11
    //   196: aload_0
    //   197: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_0
    //   203: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   206: ifeq -195 -> 11
    //   209: aload_0
    //   210: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   213: iconst_0
    //   214: ireturn
    //   215: astore_1
    //   216: aconst_null
    //   217: astore 11
    //   219: aconst_null
    //   220: astore_0
    //   221: aload 11
    //   223: ifnull +8 -> 231
    //   226: aload 11
    //   228: invokevirtual 220	java/io/FileInputStream:close	()V
    //   231: aload_0
    //   232: ifnull +7 -> 239
    //   235: aload_0
    //   236: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: aload 11
    //   243: ifnull +8 -> 251
    //   246: aload 11
    //   248: invokevirtual 220	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: ifnull +7 -> 259
    //   255: aload_0
    //   256: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   259: iconst_1
    //   260: ireturn
    //   261: astore 11
    //   263: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   266: ifeq -35 -> 231
    //   269: aload 11
    //   271: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   274: goto -43 -> 231
    //   277: astore_0
    //   278: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   281: ifeq -42 -> 239
    //   284: aload_0
    //   285: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   288: goto -49 -> 239
    //   291: astore_1
    //   292: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   295: ifeq -103 -> 192
    //   298: aload_1
    //   299: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   302: goto -110 -> 192
    //   305: astore_1
    //   306: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   309: ifeq -58 -> 251
    //   312: aload_1
    //   313: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   316: goto -65 -> 251
    //   319: astore_0
    //   320: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   323: ifeq -64 -> 259
    //   326: aload_0
    //   327: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   330: goto -71 -> 259
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -115 -> 221
    //   339: astore_1
    //   340: goto -119 -> 221
    //   343: astore 12
    //   345: aload_1
    //   346: astore 11
    //   348: aload 12
    //   350: astore_1
    //   351: goto -130 -> 221
    //   354: astore 12
    //   356: aconst_null
    //   357: astore_0
    //   358: aload 11
    //   360: astore_1
    //   361: aload 12
    //   363: astore 11
    //   365: goto -192 -> 173
    //   368: astore 12
    //   370: aload 11
    //   372: astore_1
    //   373: aload 12
    //   375: astore 11
    //   377: goto -204 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramFile1	java.io.File
    //   0	380	1	paramFile2	java.io.File
    //   0	380	2	paramLong1	long
    //   0	380	4	paramLong2	long
    //   114	17	6	i	int
    //   134	28	7	l1	long
    //   141	15	9	l2	long
    //   69	40	11	localFileInputStream	java.io.FileInputStream
    //   167	13	11	localException1	Exception
    //   217	30	11	localObject1	Object
    //   261	9	11	localIOException	IOException
    //   346	30	11	localObject2	Object
    //   343	6	12	localObject3	Object
    //   354	8	12	localException2	Exception
    //   368	6	12	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   61	71	167	java/lang/Exception
    //   196	200	202	java/io/IOException
    //   61	71	215	finally
    //   226	231	261	java/io/IOException
    //   235	239	277	java/io/IOException
    //   188	192	291	java/io/IOException
    //   246	251	305	java/io/IOException
    //   255	259	319	java/io/IOException
    //   71	80	333	finally
    //   80	99	339	finally
    //   108	116	339	finally
    //   121	129	339	finally
    //   146	161	339	finally
    //   173	184	343	finally
    //   71	80	354	java/lang/Exception
    //   80	99	368	java/lang/Exception
    //   108	116	368	java/lang/Exception
    //   121	129	368	java/lang/Exception
    //   146	161	368	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, Boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 225	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   7: aload_1
    //   8: invokevirtual 225	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +5 -> 19
    //   17: iconst_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokevirtual 176	java/io/File:exists	()Z
    //   23: ifne +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: invokevirtual 179	java/io/File:isFile	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: invokevirtual 182	java/io/File:canRead	()Z
    //   41: ifne +5 -> 46
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   50: invokevirtual 176	java/io/File:exists	()Z
    //   53: ifne +11 -> 64
    //   56: aload_1
    //   57: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   60: invokevirtual 189	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 176	java/io/File:exists	()Z
    //   68: ifeq +15 -> 83
    //   71: aload_2
    //   72: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
    //   75: ifeq +8 -> 83
    //   78: aload_1
    //   79: invokevirtual 192	java/io/File:delete	()Z
    //   82: pop
    //   83: new 194	java/io/FileInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 197	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_2
    //   92: new 199	java/io/FileOutputStream
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 200	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore_0
    //   101: sipush 1024
    //   104: newarray <illegal type>
    //   106: astore_1
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 213	java/io/FileInputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: ifle +127 -> 241
    //   117: aload_0
    //   118: aload_1
    //   119: iconst_0
    //   120: iload_3
    //   121: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   124: goto -17 -> 107
    //   127: astore 4
    //   129: aload_2
    //   130: astore_1
    //   131: aload 4
    //   133: astore_2
    //   134: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   137: ifeq +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 220	java/io/FileInputStream:close	()V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 220	java/io/FileInputStream:close	()V
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_2
    //   186: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   189: ifeq -14 -> 175
    //   192: aload_2
    //   193: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   196: goto -21 -> 175
    //   199: astore_0
    //   200: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   203: ifeq -20 -> 183
    //   206: aload_0
    //   207: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   210: goto -27 -> 183
    //   213: astore_1
    //   214: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   217: ifeq -65 -> 152
    //   220: aload_1
    //   221: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   224: goto -72 -> 152
    //   227: astore_0
    //   228: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   231: ifeq -71 -> 160
    //   234: aload_0
    //   235: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   238: goto -78 -> 160
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 220	java/io/FileInputStream:close	()V
    //   249: aload_0
    //   250: ifnull -233 -> 17
    //   253: aload_0
    //   254: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   257: iconst_1
    //   258: ireturn
    //   259: astore_0
    //   260: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   263: ifeq -246 -> 17
    //   266: aload_0
    //   267: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   270: iconst_1
    //   271: ireturn
    //   272: astore_1
    //   273: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   276: ifeq -27 -> 249
    //   279: aload_1
    //   280: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   283: goto -34 -> 249
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -122 -> 167
    //   292: astore_1
    //   293: goto -126 -> 167
    //   296: astore 4
    //   298: aload_1
    //   299: astore_2
    //   300: aload 4
    //   302: astore_1
    //   303: goto -136 -> 167
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_0
    //   309: aload 4
    //   311: astore_1
    //   312: goto -178 -> 134
    //   315: astore 4
    //   317: aconst_null
    //   318: astore_0
    //   319: aload_2
    //   320: astore_1
    //   321: aload 4
    //   323: astore_2
    //   324: goto -190 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramFile1	java.io.File
    //   0	327	1	paramFile2	java.io.File
    //   0	327	2	paramBoolean	Boolean
    //   112	9	3	i	int
    //   1	1	4	localObject1	Object
    //   127	5	4	localException1	Exception
    //   296	14	4	localObject2	Object
    //   315	7	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   101	107	127	java/lang/Exception
    //   107	113	127	java/lang/Exception
    //   117	124	127	java/lang/Exception
    //   83	92	162	finally
    //   171	175	185	java/io/IOException
    //   179	183	199	java/io/IOException
    //   148	152	213	java/io/IOException
    //   156	160	227	java/io/IOException
    //   253	257	259	java/io/IOException
    //   245	249	272	java/io/IOException
    //   92	101	286	finally
    //   101	107	292	finally
    //   107	113	292	finally
    //   117	124	292	finally
    //   134	144	296	finally
    //   83	92	306	java/lang/Exception
    //   92	101	315	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: ifnull -3 -> 13
    //   19: aload_0
    //   20: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 176	java/io/File:exists	()Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   33: invokevirtual 189	java/io/File:mkdirs	()Z
    //   36: pop
    //   37: new 237	java/net/URL
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 240	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: invokestatic 242	com/jiubang/goweather/e/a:a	()Ljava/net/Proxy;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +141 -> 193
    //   55: aload 7
    //   57: aload_1
    //   58: invokevirtual 246	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   61: checkcast 248	java/net/HttpURLConnection
    //   64: astore_1
    //   65: aload_1
    //   66: ldc -6
    //   68: invokevirtual 253	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual 257	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   76: aload_1
    //   77: sipush 10000
    //   80: invokevirtual 260	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   83: aload_1
    //   84: sipush 10000
    //   87: invokevirtual 263	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   90: aload_1
    //   91: ldc_w 265
    //   94: ldc_w 267
    //   97: invokevirtual 271	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: ldc_w 273
    //   104: ldc 59
    //   106: invokevirtual 271	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w 275
    //   113: ldc_w 277
    //   116: invokevirtual 271	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 280	java/net/HttpURLConnection:connect	()V
    //   123: aload_1
    //   124: invokevirtual 283	java/net/HttpURLConnection:getResponseCode	()I
    //   127: sipush 200
    //   130: if_icmpne +384 -> 514
    //   133: new 285	java/io/BufferedInputStream
    //   136: dup
    //   137: aload_1
    //   138: invokevirtual 289	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   141: invokespecial 290	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: astore 5
    //   146: aload_1
    //   147: invokevirtual 293	java/net/HttpURLConnection:getContentLength	()I
    //   150: istore_2
    //   151: iload_2
    //   152: iconst_1
    //   153: if_icmplt +8 -> 161
    //   156: aload 5
    //   158: ifnonnull +47 -> 205
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   171: iconst_0
    //   172: ifeq +11 -> 183
    //   175: new 296	java/lang/NullPointerException
    //   178: dup
    //   179: invokespecial 297	java/lang/NullPointerException:<init>	()V
    //   182: athrow
    //   183: aload_1
    //   184: ifnull -171 -> 13
    //   187: aload_1
    //   188: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: aload 7
    //   195: invokevirtual 303	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   198: checkcast 248	java/net/HttpURLConnection
    //   201: astore_1
    //   202: goto -137 -> 65
    //   205: new 199	java/io/FileOutputStream
    //   208: dup
    //   209: aload_0
    //   210: invokespecial 200	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: astore_0
    //   214: sipush 1024
    //   217: newarray <illegal type>
    //   219: astore 6
    //   221: aload 5
    //   223: aload 6
    //   225: invokevirtual 304	java/io/BufferedInputStream:read	([B)I
    //   228: istore_2
    //   229: iload_2
    //   230: iconst_m1
    //   231: if_icmpeq +71 -> 302
    //   234: aload_0
    //   235: aload 6
    //   237: iconst_0
    //   238: iload_2
    //   239: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   242: goto -21 -> 221
    //   245: astore 7
    //   247: aload_1
    //   248: astore 6
    //   250: aload_0
    //   251: astore_1
    //   252: aload 6
    //   254: astore_0
    //   255: aload 7
    //   257: astore 6
    //   259: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   262: ifeq +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   270: aload 5
    //   272: ifnull +8 -> 280
    //   275: aload 5
    //   277: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   288: aload_0
    //   289: ifnull +7 -> 296
    //   292: aload_0
    //   293: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   296: iconst_0
    //   297: istore 4
    //   299: iload 4
    //   301: ireturn
    //   302: aload_0
    //   303: invokevirtual 307	java/io/FileOutputStream:flush	()V
    //   306: iconst_1
    //   307: istore_3
    //   308: aload 5
    //   310: ifnull +8 -> 318
    //   313: aload 5
    //   315: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   318: aload_0
    //   319: ifnull +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   326: iload_3
    //   327: istore 4
    //   329: aload_1
    //   330: ifnull -31 -> 299
    //   333: aload_1
    //   334: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   337: iload_3
    //   338: istore 4
    //   340: goto -41 -> 299
    //   343: astore_0
    //   344: aconst_null
    //   345: astore_1
    //   346: aconst_null
    //   347: astore 5
    //   349: aload 5
    //   351: ifnull +8 -> 359
    //   354: aload 5
    //   356: invokevirtual 294	java/io/BufferedInputStream:close	()V
    //   359: aload 6
    //   361: ifnull +8 -> 369
    //   364: aload 6
    //   366: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 300	java/net/HttpURLConnection:disconnect	()V
    //   377: aload_0
    //   378: athrow
    //   379: astore 5
    //   381: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   384: ifeq -15 -> 369
    //   387: aload 5
    //   389: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   392: goto -23 -> 369
    //   395: astore_1
    //   396: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   399: ifeq -111 -> 288
    //   402: aload_1
    //   403: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   406: goto -118 -> 288
    //   409: astore_0
    //   410: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   413: ifeq -230 -> 183
    //   416: aload_0
    //   417: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   420: goto -237 -> 183
    //   423: astore_0
    //   424: invokestatic 218	com/gtp/a/a/b/c:a	()Z
    //   427: ifeq -101 -> 326
    //   430: aload_0
    //   431: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   434: goto -108 -> 326
    //   437: astore_0
    //   438: aconst_null
    //   439: astore 5
    //   441: goto -92 -> 349
    //   444: astore_0
    //   445: goto -96 -> 349
    //   448: astore 7
    //   450: aload_0
    //   451: astore 6
    //   453: aload 7
    //   455: astore_0
    //   456: goto -107 -> 349
    //   459: astore 6
    //   461: aload_0
    //   462: astore 7
    //   464: aload 6
    //   466: astore_0
    //   467: aload_1
    //   468: astore 6
    //   470: aload 7
    //   472: astore_1
    //   473: goto -124 -> 349
    //   476: astore 6
    //   478: aconst_null
    //   479: astore_1
    //   480: aconst_null
    //   481: astore 7
    //   483: aload 5
    //   485: astore_0
    //   486: aload 7
    //   488: astore 5
    //   490: goto -231 -> 259
    //   493: astore 6
    //   495: aconst_null
    //   496: astore 5
    //   498: aload_1
    //   499: astore_0
    //   500: aconst_null
    //   501: astore_1
    //   502: goto -243 -> 259
    //   505: astore 6
    //   507: aload_1
    //   508: astore_0
    //   509: aconst_null
    //   510: astore_1
    //   511: goto -252 -> 259
    //   514: aconst_null
    //   515: astore_0
    //   516: aconst_null
    //   517: astore 5
    //   519: iconst_0
    //   520: istore_3
    //   521: goto -213 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	paramFile	java.io.File
    //   0	524	1	paramString	String
    //   150	89	2	i	int
    //   307	214	3	bool1	boolean
    //   297	42	4	bool2	boolean
    //   4	351	5	localBufferedInputStream	java.io.BufferedInputStream
    //   379	9	5	localException1	Exception
    //   439	79	5	localObject1	Object
    //   1	451	6	localObject2	Object
    //   459	6	6	localObject3	Object
    //   468	1	6	str	String
    //   476	1	6	localException2	Exception
    //   493	1	6	localException3	Exception
    //   505	1	6	localException4	Exception
    //   45	149	7	localURL	java.net.URL
    //   245	11	7	localException5	Exception
    //   448	6	7	localObject4	Object
    //   462	25	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   214	221	245	java/lang/Exception
    //   221	229	245	java/lang/Exception
    //   234	242	245	java/lang/Exception
    //   302	306	245	java/lang/Exception
    //   37	51	343	finally
    //   55	65	343	finally
    //   193	202	343	finally
    //   354	359	379	java/lang/Exception
    //   364	369	379	java/lang/Exception
    //   275	280	395	java/lang/Exception
    //   284	288	395	java/lang/Exception
    //   166	171	409	java/lang/Exception
    //   175	183	409	java/lang/Exception
    //   313	318	423	java/lang/Exception
    //   322	326	423	java/lang/Exception
    //   65	146	437	finally
    //   146	151	444	finally
    //   205	214	444	finally
    //   214	221	448	finally
    //   221	229	448	finally
    //   234	242	448	finally
    //   302	306	448	finally
    //   259	270	459	finally
    //   37	51	476	java/lang/Exception
    //   55	65	476	java/lang/Exception
    //   193	202	476	java/lang/Exception
    //   65	146	493	java/lang/Exception
    //   146	151	505	java/lang/Exception
    //   205	214	505	java/lang/Exception
  }
  
  public static byte[] a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    com.jiubang.goweather.b.c localc;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new e(paramString, "GET");
      localObject3 = new f();
      localc = d.a();
      localObject3 = localc.a(paramString, (e)localObject1, (f)localObject3);
      paramString = localByteArrayOutputStream;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        try
        {
          localByteArrayOutputStream = new ByteArrayOutputStream();
          localObject1 = localObject2;
          paramString = new byte['Ѐ'];
          for (;;)
          {
            localObject1 = localObject2;
            int i = ((InputStream)localObject3).read(paramString);
            if (i <= 0) {
              break;
            }
            localObject1 = localObject2;
            localByteArrayOutputStream.write(paramString, 0, i);
          }
          localc.a();
        }
        catch (IOException localIOException)
        {
          paramString = (String)localObject1;
          if (com.gtp.a.a.b.c.a())
          {
            localIOException.printStackTrace();
            paramString = (String)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramString;
      return (byte[])localObject1;
      localObject1 = localIOException;
      paramString = localByteArrayOutputStream.toByteArray();
      localObject1 = paramString;
      ((InputStream)localObject3).close();
      localObject1 = paramString;
      localByteArrayOutputStream.close();
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static int c(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimState();
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (localObject != null)
      {
        paramContext = (Context)localObject;
        if (((String)localObject).length() >= 0) {}
      }
      else
      {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */