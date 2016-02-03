package com.admob.android.ads;

import android.util.Log;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

final class i
  extends r
{
  private HttpURLConnection m;
  private URL n;
  
  public i(String paramString1, String paramString2, String paramString3, h paramh, int paramInt, Map<String, String> paramMap, String paramString4)
  {
    super(paramString2, paramString3, paramh, paramInt, paramMap, paramString4);
    try
    {
      this.n = new URL(paramString1);
      this.i = this.n;
      this.m = null;
      this.e = 0;
      return;
    }
    catch (MalformedURLException paramString1)
    {
      for (;;)
      {
        this.n = null;
        this.c = paramString1;
      }
    }
  }
  
  private void h()
  {
    if (this.m != null)
    {
      this.m.disconnect();
      this.m = null;
    }
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   4: ifnonnull +58 -> 62
    //   7: aload_0
    //   8: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   11: ifnull +22 -> 33
    //   14: aload_0
    //   15: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   18: aload_0
    //   19: new 49	java/lang/Exception
    //   22: dup
    //   23: ldc 54
    //   25: invokespecial 55	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   28: invokeinterface 60 3 0
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +24 -> 60
    //   39: aload_0
    //   40: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   43: ifnull +17 -> 60
    //   46: aload_0
    //   47: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 35	com/admob/android/ads/i:c	Ljava/lang/Exception;
    //   55: invokeinterface 60 3 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_1
    //   63: invokestatic 64	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   66: iconst_0
    //   67: istore_2
    //   68: aload_0
    //   69: getfield 31	com/admob/android/ads/i:e	I
    //   72: aload_0
    //   73: getfield 67	com/admob/android/ads/i:f	I
    //   76: if_icmpge +642 -> 718
    //   79: iload_2
    //   80: ifne +638 -> 718
    //   83: ldc 69
    //   85: iconst_2
    //   86: invokestatic 75	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   89: ifeq +43 -> 132
    //   92: ldc 69
    //   94: new 77	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   101: ldc 81
    //   103: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 31	com/admob/android/ads/i:e	I
    //   110: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 90
    //   115: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   122: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 101	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_0
    //   133: invokespecial 103	com/admob/android/ads/i:h	()V
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   141: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   144: checkcast 42	java/net/HttpURLConnection
    //   147: putfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   150: aload_0
    //   151: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   154: ifnull +561 -> 715
    //   157: aload_0
    //   158: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   161: ldc 109
    //   163: invokestatic 111	com/admob/android/ads/i:c	()Ljava/lang/String;
    //   166: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 119	com/admob/android/ads/i:g	Ljava/lang/String;
    //   173: ifnull +16 -> 189
    //   176: aload_0
    //   177: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   180: ldc 121
    //   182: aload_0
    //   183: getfield 119	com/admob/android/ads/i:g	Ljava/lang/String;
    //   186: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   193: aload_0
    //   194: getfield 124	com/admob/android/ads/i:b	I
    //   197: invokevirtual 128	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   200: aload_0
    //   201: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   204: aload_0
    //   205: getfield 124	com/admob/android/ads/i:b	I
    //   208: invokevirtual 131	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   211: aload_0
    //   212: getfield 135	com/admob/android/ads/i:d	Ljava/util/Map;
    //   215: ifnull +151 -> 366
    //   218: aload_0
    //   219: getfield 135	com/admob/android/ads/i:d	Ljava/util/Map;
    //   222: invokeinterface 141 1 0
    //   227: invokeinterface 147 1 0
    //   232: astore_3
    //   233: aload_3
    //   234: invokeinterface 152 1 0
    //   239: ifeq +127 -> 366
    //   242: aload_3
    //   243: invokeinterface 156 1 0
    //   248: checkcast 158	java/lang/String
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull -22 -> 233
    //   258: aload_0
    //   259: getfield 135	com/admob/android/ads/i:d	Ljava/util/Map;
    //   262: aload 4
    //   264: invokeinterface 162 2 0
    //   269: checkcast 158	java/lang/String
    //   272: astore 5
    //   274: aload 5
    //   276: ifnull -43 -> 233
    //   279: aload_0
    //   280: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 165	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -57 -> 233
    //   293: astore 5
    //   295: aconst_null
    //   296: astore_3
    //   297: aload_3
    //   298: astore 4
    //   300: ldc 69
    //   302: new 77	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   309: ldc -89
    //   311: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_0
    //   315: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   318: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload 5
    //   326: invokestatic 171	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   329: pop
    //   330: aload_3
    //   331: astore 4
    //   333: aload_0
    //   334: aload 5
    //   336: putfield 35	com/admob/android/ads/i:c	Ljava/lang/Exception;
    //   339: aload_3
    //   340: ifnull +7 -> 347
    //   343: aload_3
    //   344: invokevirtual 176	java/io/BufferedWriter:close	()V
    //   347: aload_0
    //   348: invokespecial 103	com/admob/android/ads/i:h	()V
    //   351: iconst_0
    //   352: istore_2
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 31	com/admob/android/ads/i:e	I
    //   358: iconst_1
    //   359: iadd
    //   360: putfield 31	com/admob/android/ads/i:e	I
    //   363: goto -295 -> 68
    //   366: aload_0
    //   367: getfield 179	com/admob/android/ads/i:l	Ljava/lang/String;
    //   370: ifnull +247 -> 617
    //   373: aload_0
    //   374: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   377: ldc -75
    //   379: invokevirtual 184	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   382: aload_0
    //   383: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   386: iconst_1
    //   387: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   390: aload_0
    //   391: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   394: ldc -67
    //   396: aload_0
    //   397: getfield 191	com/admob/android/ads/i:a	Ljava/lang/String;
    //   400: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_0
    //   404: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   407: ldc -63
    //   409: aload_0
    //   410: getfield 179	com/admob/android/ads/i:l	Ljava/lang/String;
    //   413: invokevirtual 197	java/lang/String:length	()I
    //   416: invokestatic 202	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   419: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: new 173	java/io/BufferedWriter
    //   425: dup
    //   426: new 204	java/io/OutputStreamWriter
    //   429: dup
    //   430: aload_0
    //   431: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   434: invokevirtual 208	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   437: invokespecial 211	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   440: sipush 4096
    //   443: invokespecial 214	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   446: astore_3
    //   447: aload_3
    //   448: astore 4
    //   450: aload_3
    //   451: aload_0
    //   452: getfield 179	com/admob/android/ads/i:l	Ljava/lang/String;
    //   455: invokevirtual 217	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   458: aload_3
    //   459: astore 4
    //   461: aload_3
    //   462: invokevirtual 176	java/io/BufferedWriter:close	()V
    //   465: aload_0
    //   466: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   469: invokevirtual 220	java/net/HttpURLConnection:getResponseCode	()I
    //   472: istore_1
    //   473: ldc 69
    //   475: iconst_2
    //   476: invokestatic 75	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   479: ifeq +38 -> 517
    //   482: aload_0
    //   483: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   486: ldc -34
    //   488: invokevirtual 226	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore_3
    //   492: ldc 69
    //   494: new 77	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   501: ldc -28
    //   503: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_3
    //   507: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 101	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   516: pop
    //   517: iload_1
    //   518: sipush 200
    //   521: if_icmplt +191 -> 712
    //   524: iload_1
    //   525: sipush 300
    //   528: if_icmpge +184 -> 712
    //   531: aload_0
    //   532: aload_0
    //   533: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   536: invokevirtual 232	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   539: putfield 25	com/admob/android/ads/i:i	Ljava/net/URL;
    //   542: aload_0
    //   543: getfield 236	com/admob/android/ads/i:k	Z
    //   546: ifeq +90 -> 636
    //   549: new 238	java/io/BufferedInputStream
    //   552: dup
    //   553: aload_0
    //   554: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   557: invokevirtual 242	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   560: sipush 4096
    //   563: invokespecial 245	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   566: astore_3
    //   567: sipush 4096
    //   570: newarray <illegal type>
    //   572: astore 4
    //   574: new 247	java/io/ByteArrayOutputStream
    //   577: dup
    //   578: sipush 4096
    //   581: invokespecial 249	java/io/ByteArrayOutputStream:<init>	(I)V
    //   584: astore 5
    //   586: aload_3
    //   587: aload 4
    //   589: invokevirtual 253	java/io/BufferedInputStream:read	([B)I
    //   592: istore_1
    //   593: iload_1
    //   594: iconst_m1
    //   595: if_icmpeq +32 -> 627
    //   598: aload 5
    //   600: aload 4
    //   602: iconst_0
    //   603: iload_1
    //   604: invokevirtual 256	java/io/ByteArrayOutputStream:write	([BII)V
    //   607: goto -21 -> 586
    //   610: astore 5
    //   612: aconst_null
    //   613: astore_3
    //   614: goto -317 -> 297
    //   617: aload_0
    //   618: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   621: invokevirtual 259	java/net/HttpURLConnection:connect	()V
    //   624: goto -159 -> 465
    //   627: aload_0
    //   628: aload 5
    //   630: invokevirtual 263	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   633: putfield 267	com/admob/android/ads/i:j	[B
    //   636: aload_0
    //   637: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   640: ifnull +81 -> 721
    //   643: aload_0
    //   644: getfield 52	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   647: aload_0
    //   648: invokeinterface 270 2 0
    //   653: goto +68 -> 721
    //   656: aload_0
    //   657: invokespecial 103	com/admob/android/ads/i:h	()V
    //   660: aload_0
    //   661: invokespecial 103	com/admob/android/ads/i:h	()V
    //   664: goto -311 -> 353
    //   667: astore_3
    //   668: aconst_null
    //   669: astore 4
    //   671: aload 4
    //   673: ifnull +8 -> 681
    //   676: aload 4
    //   678: invokevirtual 176	java/io/BufferedWriter:close	()V
    //   681: aload_0
    //   682: invokespecial 103	com/admob/android/ads/i:h	()V
    //   685: aload_3
    //   686: athrow
    //   687: astore_3
    //   688: goto -341 -> 347
    //   691: astore 4
    //   693: goto -12 -> 681
    //   696: astore_3
    //   697: goto -26 -> 671
    //   700: astore_3
    //   701: aconst_null
    //   702: astore 4
    //   704: goto -33 -> 671
    //   707: astore 5
    //   709: goto -412 -> 297
    //   712: goto -56 -> 656
    //   715: goto -59 -> 656
    //   718: goto -683 -> 35
    //   721: iconst_1
    //   722: istore_2
    //   723: goto -67 -> 656
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	i
    //   472	132	1	i	int
    //   34	689	2	bool	boolean
    //   232	382	3	localObject1	Object
    //   667	19	3	localObject2	Object
    //   687	1	3	localException1	Exception
    //   696	1	3	localObject3	Object
    //   700	1	3	localObject4	Object
    //   251	426	4	localObject5	Object
    //   691	1	4	localException2	Exception
    //   702	1	4	localObject6	Object
    //   272	14	5	str	String
    //   293	42	5	localException3	Exception
    //   584	15	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   610	19	5	localException4	Exception
    //   707	1	5	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   132	189	293	java/lang/Exception
    //   189	233	293	java/lang/Exception
    //   233	253	293	java/lang/Exception
    //   258	274	293	java/lang/Exception
    //   279	290	293	java/lang/Exception
    //   366	447	293	java/lang/Exception
    //   617	624	293	java/lang/Exception
    //   465	517	610	java/lang/Exception
    //   531	586	610	java/lang/Exception
    //   586	593	610	java/lang/Exception
    //   598	607	610	java/lang/Exception
    //   627	636	610	java/lang/Exception
    //   636	653	610	java/lang/Exception
    //   656	660	610	java/lang/Exception
    //   132	189	667	finally
    //   189	233	667	finally
    //   233	253	667	finally
    //   258	274	667	finally
    //   279	290	667	finally
    //   366	447	667	finally
    //   617	624	667	finally
    //   343	347	687	java/lang/Exception
    //   676	681	691	java/lang/Exception
    //   300	330	696	finally
    //   333	339	696	finally
    //   450	458	696	finally
    //   461	465	696	finally
    //   465	517	700	finally
    //   531	586	700	finally
    //   586	593	700	finally
    //   598	607	700	finally
    //   627	636	700	finally
    //   636	653	700	finally
    //   656	660	700	finally
    //   450	458	707	java/lang/Exception
    //   461	465	707	java/lang/Exception
  }
  
  public final void b()
  {
    h();
    this.h = null;
  }
  
  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException)
    {
      while (!Log.isLoggable("AdMobSDK", 6)) {}
      Log.e("AdMobSDK", "exception caught in AdMobURLConnector.run(), " + localException.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */