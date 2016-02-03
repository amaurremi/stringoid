package com.vungle.sdk.a.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.vungle.sdk.av;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern a = Pattern.compile("\\bcharset=([\\w\\-]+)\\b");
  private static final e b = new e();
  
  static
  {
    if (Build.VERSION.SDK_INT < 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  public static e a()
  {
    return b;
  }
  
  /* Error */
  public static i a(g paramg)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_3
    //   12: astore 4
    //   14: aload_0
    //   15: invokevirtual 56	com/vungle/sdk/a/a/g:h	()V
    //   18: aload_3
    //   19: astore 4
    //   21: aload_0
    //   22: invokevirtual 60	com/vungle/sdk/a/a/g:c	()Ljava/lang/String;
    //   25: astore 8
    //   27: aload_3
    //   28: astore 4
    //   30: aload_0
    //   31: invokevirtual 63	com/vungle/sdk/a/a/g:b	()Lcom/vungle/sdk/a/a/g$a;
    //   34: astore 9
    //   36: aload_3
    //   37: astore 4
    //   39: new 65	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   46: aload 9
    //   48: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc 72
    //   53: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 8
    //   58: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: astore 4
    //   65: new 77	java/net/URL
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 60	com/vungle/sdk/a/a/g:c	()Ljava/lang/String;
    //   73: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   76: invokevirtual 84	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   79: checkcast 86	java/net/HttpURLConnection
    //   82: astore_3
    //   83: aload_3
    //   84: sipush 30000
    //   87: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   90: aload_3
    //   91: sipush 30000
    //   94: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   97: aload_3
    //   98: iconst_0
    //   99: invokevirtual 97	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   102: aload 9
    //   104: ifnull +12 -> 116
    //   107: aload_3
    //   108: aload 9
    //   110: invokevirtual 102	com/vungle/sdk/a/a/g$a:toString	()Ljava/lang/String;
    //   113: invokevirtual 105	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 109	com/vungle/sdk/a/a/g:e	()Landroid/os/Bundle;
    //   120: astore 4
    //   122: aload 4
    //   124: ifnull +178 -> 302
    //   127: aload 4
    //   129: invokevirtual 115	android/os/Bundle:keySet	()Ljava/util/Set;
    //   132: invokeinterface 121 1 0
    //   137: astore 6
    //   139: aload 6
    //   141: invokeinterface 127 1 0
    //   146: ifeq +156 -> 302
    //   149: aload 6
    //   151: invokeinterface 131 1 0
    //   156: checkcast 133	java/lang/String
    //   159: astore 7
    //   161: aload 4
    //   163: aload 7
    //   165: invokevirtual 137	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 10
    //   170: aload 10
    //   172: ifnonnull +69 -> 241
    //   175: aload 4
    //   177: aload 7
    //   179: invokevirtual 141	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   182: astore 10
    //   184: aload 10
    //   186: arraylength
    //   187: istore_2
    //   188: iconst_0
    //   189: istore_1
    //   190: iload_1
    //   191: iload_2
    //   192: if_icmpge -53 -> 139
    //   195: aload 10
    //   197: iload_1
    //   198: aaload
    //   199: astore 11
    //   201: new 65	java/lang/StringBuilder
    //   204: dup
    //   205: ldc -113
    //   207: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload 7
    //   212: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -110
    //   217: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 11
    //   222: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_3
    //   227: aload 7
    //   229: aload 11
    //   231: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: iload_1
    //   235: iconst_1
    //   236: iadd
    //   237: istore_1
    //   238: goto -48 -> 190
    //   241: new 65	java/lang/StringBuilder
    //   244: dup
    //   245: ldc -113
    //   247: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 7
    //   252: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc -110
    //   257: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 10
    //   262: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_3
    //   267: aload 7
    //   269: aload 10
    //   271: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -135 -> 139
    //   277: astore_0
    //   278: sipush 601
    //   281: invokestatic 155	com/vungle/sdk/a/a/i:a	(I)Lcom/vungle/sdk/a/a/i;
    //   284: astore 4
    //   286: aload 4
    //   288: astore_0
    //   289: aload_3
    //   290: ifnull +10 -> 300
    //   293: aload_3
    //   294: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   297: aload 4
    //   299: astore_0
    //   300: aload_0
    //   301: areturn
    //   302: aload_0
    //   303: invokevirtual 161	com/vungle/sdk/a/a/g:g	()Ljava/lang/String;
    //   306: astore_0
    //   307: aload_0
    //   308: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +19 -> 330
    //   314: aload_3
    //   315: iconst_1
    //   316: invokevirtual 170	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   319: aload_3
    //   320: invokevirtual 174	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   323: aload_0
    //   324: invokevirtual 178	java/lang/String:getBytes	()[B
    //   327: invokevirtual 184	java/io/OutputStream:write	([B)V
    //   330: aload_3
    //   331: invokevirtual 188	java/net/HttpURLConnection:getResponseCode	()I
    //   334: istore_2
    //   335: aload_3
    //   336: invokevirtual 191	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   339: astore 4
    //   341: aload 5
    //   343: astore_0
    //   344: aload 4
    //   346: ifnull +31 -> 377
    //   349: getstatic 20	com/vungle/sdk/a/a/e:a	Ljava/util/regex/Pattern;
    //   352: aload 4
    //   354: invokevirtual 195	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   357: astore 6
    //   359: aload 5
    //   361: astore_0
    //   362: aload 6
    //   364: invokevirtual 200	java/util/regex/Matcher:find	()Z
    //   367: ifeq +10 -> 377
    //   370: aload 6
    //   372: iconst_1
    //   373: invokevirtual 204	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   376: astore_0
    //   377: new 65	java/lang/StringBuilder
    //   380: dup
    //   381: ldc -50
    //   383: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: iload_2
    //   387: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: ldc -45
    //   392: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload 4
    //   397: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc -43
    //   402: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc -41
    //   411: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 9
    //   416: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: ldc 72
    //   421: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 8
    //   426: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc -39
    //   431: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: iload_2
    //   436: bipush 100
    //   438: idiv
    //   439: iconst_3
    //   440: if_icmpgt +36 -> 476
    //   443: iconst_1
    //   444: istore_1
    //   445: iload_1
    //   446: ifeq +35 -> 481
    //   449: aload_3
    //   450: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   453: astore 4
    //   455: iload_2
    //   456: aload 4
    //   458: aload_0
    //   459: invokestatic 224	com/vungle/sdk/a/a/e:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   462: invokestatic 227	com/vungle/sdk/a/a/i:a	(ILjava/lang/String;)Lcom/vungle/sdk/a/a/i;
    //   465: astore_0
    //   466: aload_3
    //   467: ifnull +126 -> 593
    //   470: aload_3
    //   471: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   474: aload_0
    //   475: areturn
    //   476: iconst_0
    //   477: istore_1
    //   478: goto -33 -> 445
    //   481: aload_3
    //   482: invokevirtual 230	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   485: astore 4
    //   487: goto -32 -> 455
    //   490: astore_0
    //   491: aload 6
    //   493: astore_3
    //   494: aload_3
    //   495: astore 4
    //   497: sipush 602
    //   500: invokestatic 155	com/vungle/sdk/a/a/i:a	(I)Lcom/vungle/sdk/a/a/i;
    //   503: astore_0
    //   504: aload_0
    //   505: astore 4
    //   507: aload 4
    //   509: astore_0
    //   510: aload_3
    //   511: ifnull -211 -> 300
    //   514: aload_3
    //   515: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   518: aload 4
    //   520: areturn
    //   521: astore_0
    //   522: aload 7
    //   524: astore_3
    //   525: aload_3
    //   526: astore 4
    //   528: sipush 600
    //   531: invokestatic 155	com/vungle/sdk/a/a/i:a	(I)Lcom/vungle/sdk/a/a/i;
    //   534: astore_0
    //   535: aload_0
    //   536: astore 4
    //   538: aload 4
    //   540: astore_0
    //   541: aload_3
    //   542: ifnull -242 -> 300
    //   545: aload_3
    //   546: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   549: aload 4
    //   551: areturn
    //   552: astore_0
    //   553: aload 4
    //   555: ifnull +8 -> 563
    //   558: aload 4
    //   560: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   563: aload_0
    //   564: athrow
    //   565: astore_0
    //   566: aload_3
    //   567: astore 4
    //   569: goto -16 -> 553
    //   572: astore_0
    //   573: aload_3
    //   574: astore 4
    //   576: goto -23 -> 553
    //   579: astore_0
    //   580: goto -55 -> 525
    //   583: astore_0
    //   584: goto -90 -> 494
    //   587: astore_0
    //   588: aconst_null
    //   589: astore_3
    //   590: goto -312 -> 278
    //   593: aload_0
    //   594: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	paramg	g
    //   189	289	1	i	int
    //   187	269	2	j	int
    //   7	583	3	localObject1	Object
    //   12	563	4	localObject2	Object
    //   9	351	5	localObject3	Object
    //   1	491	6	localObject4	Object
    //   4	519	7	str1	String
    //   25	400	8	str2	String
    //   34	381	9	locala	g.a
    //   168	102	10	localObject5	Object
    //   199	31	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   83	102	277	java/net/MalformedURLException
    //   107	116	277	java/net/MalformedURLException
    //   116	122	277	java/net/MalformedURLException
    //   127	139	277	java/net/MalformedURLException
    //   139	170	277	java/net/MalformedURLException
    //   175	188	277	java/net/MalformedURLException
    //   201	234	277	java/net/MalformedURLException
    //   241	274	277	java/net/MalformedURLException
    //   302	330	277	java/net/MalformedURLException
    //   330	341	277	java/net/MalformedURLException
    //   349	359	277	java/net/MalformedURLException
    //   362	377	277	java/net/MalformedURLException
    //   377	443	277	java/net/MalformedURLException
    //   449	455	277	java/net/MalformedURLException
    //   455	466	277	java/net/MalformedURLException
    //   481	487	277	java/net/MalformedURLException
    //   14	18	490	java/net/SocketTimeoutException
    //   21	27	490	java/net/SocketTimeoutException
    //   30	36	490	java/net/SocketTimeoutException
    //   39	62	490	java/net/SocketTimeoutException
    //   65	83	490	java/net/SocketTimeoutException
    //   14	18	521	java/io/IOException
    //   21	27	521	java/io/IOException
    //   30	36	521	java/io/IOException
    //   39	62	521	java/io/IOException
    //   65	83	521	java/io/IOException
    //   14	18	552	finally
    //   21	27	552	finally
    //   30	36	552	finally
    //   39	62	552	finally
    //   65	83	552	finally
    //   497	504	552	finally
    //   528	535	552	finally
    //   83	102	565	finally
    //   107	116	565	finally
    //   116	122	565	finally
    //   127	139	565	finally
    //   139	170	565	finally
    //   175	188	565	finally
    //   201	234	565	finally
    //   241	274	565	finally
    //   302	330	565	finally
    //   330	341	565	finally
    //   349	359	565	finally
    //   362	377	565	finally
    //   377	443	565	finally
    //   449	455	565	finally
    //   455	466	565	finally
    //   481	487	565	finally
    //   278	286	572	finally
    //   83	102	579	java/io/IOException
    //   107	116	579	java/io/IOException
    //   116	122	579	java/io/IOException
    //   127	139	579	java/io/IOException
    //   139	170	579	java/io/IOException
    //   175	188	579	java/io/IOException
    //   201	234	579	java/io/IOException
    //   241	274	579	java/io/IOException
    //   302	330	579	java/io/IOException
    //   330	341	579	java/io/IOException
    //   349	359	579	java/io/IOException
    //   362	377	579	java/io/IOException
    //   377	443	579	java/io/IOException
    //   449	455	579	java/io/IOException
    //   455	466	579	java/io/IOException
    //   481	487	579	java/io/IOException
    //   83	102	583	java/net/SocketTimeoutException
    //   107	116	583	java/net/SocketTimeoutException
    //   116	122	583	java/net/SocketTimeoutException
    //   127	139	583	java/net/SocketTimeoutException
    //   139	170	583	java/net/SocketTimeoutException
    //   175	188	583	java/net/SocketTimeoutException
    //   201	234	583	java/net/SocketTimeoutException
    //   241	274	583	java/net/SocketTimeoutException
    //   302	330	583	java/net/SocketTimeoutException
    //   330	341	583	java/net/SocketTimeoutException
    //   349	359	583	java/net/SocketTimeoutException
    //   362	377	583	java/net/SocketTimeoutException
    //   377	443	583	java/net/SocketTimeoutException
    //   449	455	583	java/net/SocketTimeoutException
    //   455	466	583	java/net/SocketTimeoutException
    //   481	487	583	java/net/SocketTimeoutException
    //   14	18	587	java/net/MalformedURLException
    //   21	27	587	java/net/MalformedURLException
    //   30	36	587	java/net/MalformedURLException
    //   39	62	587	java/net/MalformedURLException
    //   65	83	587	java/net/MalformedURLException
  }
  
  private static String a(InputStream paramInputStream, String paramString)
    throws IOException
  {
    Object localObject = null;
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramInputStream = new InputStreamReader(paramInputStream);
        paramString = new BufferedReader(paramInputStream);
        try
        {
          paramInputStream = new StringBuilder();
          for (;;)
          {
            int i = paramString.read();
            if (i == -1) {
              break;
            }
            paramInputStream.append((char)i);
          }
          if (paramString == null) {}
        }
        finally {}
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          paramString.close();
          throw paramInputStream;
          paramInputStream = new InputStreamReader(paramInputStream, paramString);
          continue;
          paramInputStream = finally;
          paramString = (String)localObject;
        }
        paramInputStream = paramInputStream.toString();
        try
        {
          paramString.close();
          return paramInputStream;
        }
        catch (IOException paramString)
        {
          av.a("VungleNetwork", "Error closing input stream", paramString);
          return paramInputStream;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          av.a("VungleNetwork", "Error closing input stream", paramString);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */