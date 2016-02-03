package mobi.ifunny.util;

import java.io.OutputStream;

public final class ab {
    private static final String a = ab.class.getSimpleName();

    /* Error */
    private static int a(String paramString1, int paramInt1, String paramString2, int paramInt2, OutputStream paramOutputStream, ae paramae) {
        // Byte code:
        //   0: getstatic 16	mobi/ifunny/util/ab:a	Ljava/lang/String;
        //   3: new 29	java/lang/StringBuilder
        //   6: dup
        //   7: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   10: aload_0
        //   11: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: ldc 36
        //   16: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: iload_1
        //   20: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   23: ldc 41
        //   25: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: aload_2
        //   29: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: ldc 43
        //   34: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: iload_3
        //   38: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   41: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   44: invokestatic 52	mobi/ifunny/d:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   47: new 54	java/net/URL
        //   50: dup
        //   51: aload_0
        //   52: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
        //   55: astore 17
        //   57: iconst_0
        //   58: istore 7
        //   60: iconst_0
        //   61: istore 6
        //   63: iconst_0
        //   64: istore 8
        //   66: aload_2
        //   67: astore 13
        //   69: iload 8
        //   71: iconst_1
        //   72: iadd
        //   73: istore 9
        //   75: iload 8
        //   77: iload_1
        //   78: if_icmpge +697 -> 775
        //   81: iload_3
        //   82: iload 7
        //   84: iadd
        //   85: istore 11
        //   87: aconst_null
        //   88: astore 15
        //   90: aconst_null
        //   91: astore 16
        //   93: aconst_null
        //   94: astore 14
        //   96: aload 17
        //   98: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   101: checkcast 63	java/net/HttpURLConnection
        //   104: astore_2
        //   105: aload_2
        //   106: sipush 30000
        //   109: invokevirtual 67	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   112: aload_2
        //   113: sipush 15000
        //   116: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   119: aload_2
        //   120: iconst_1
        //   121: invokevirtual 74	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   124: iload 11
        //   126: ifle +50 -> 176
        //   129: aload_2
        //   130: ldc 76
        //   132: ldc 78
        //   134: invokevirtual 81	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   137: aload_2
        //   138: ldc 83
        //   140: aload 13
        //   142: invokevirtual 81	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   145: aload_2
        //   146: ldc 85
        //   148: new 29	java/lang/StringBuilder
        //   151: dup
        //   152: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   155: ldc 87
        //   157: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: iload 11
        //   162: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   165: ldc 89
        //   167: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   173: invokevirtual 81	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   176: aload_2
        //   177: iconst_1
        //   178: invokevirtual 92	java/net/HttpURLConnection:setDoInput	(Z)V
        //   181: aload_2
        //   182: invokevirtual 95	java/net/HttpURLConnection:connect	()V
        //   185: iload 11
        //   187: ifne +698 -> 885
        //   190: aload_2
        //   191: ldc 97
        //   193: invokevirtual 101	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   196: astore 14
        //   198: aload_2
        //   199: ldc 103
        //   201: invokevirtual 101	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   204: astore 15
        //   206: aload 15
        //   208: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   211: istore 12
        //   213: iload 12
        //   215: ifeq +114 -> 329
        //   218: aload 14
        //   220: astore 13
        //   222: aload_2
        //   223: invokevirtual 113	java/net/HttpURLConnection:getResponseCode	()I
        //   226: istore 8
        //   228: iload 8
        //   230: lookupswitch	default:+658->888, 200:+106->336, 206:+227->457
        //   256: new 25	java/io/IOException
        //   259: dup
        //   260: new 29	java/lang/StringBuilder
        //   263: dup
        //   264: invokespecial 30	java/lang/StringBuilder:<init>	()V
        //   267: ldc 115
        //   269: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: iload 8
        //   274: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   277: ldc 117
        //   279: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: iload 9
        //   284: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   287: ldc 119
        //   289: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   292: iload 11
        //   294: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   297: ldc 121
        //   299: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   302: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   305: invokespecial 122	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   308: athrow
        //   309: astore_0
        //   310: aload_2
        //   311: astore 15
        //   313: aload_0
        //   314: athrow
        //   315: astore_0
        //   316: aload 15
        //   318: astore_2
        //   319: aload_2
        //   320: ifnull +7 -> 327
        //   323: aload_2
        //   324: invokevirtual 125	java/net/HttpURLConnection:disconnect	()V
        //   327: aload_0
        //   328: athrow
        //   329: aload 15
        //   331: astore 13
        //   333: goto -111 -> 222
        //   336: iload 11
        //   338: ifle +134 -> 472
        //   341: new 25	java/io/IOException
        //   344: dup
        //   345: ldc 127
        //   347: invokespecial 122	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   350: athrow
        //   351: astore 14
        //   353: aload_2
        //   354: astore 15
        //   356: aload 13
        //   358: astore_2
        //   359: aload 15
        //   361: astore 13
        //   363: aload 13
        //   365: astore 15
        //   367: getstatic 16	mobi/ifunny/util/ab:a	Ljava/lang/String;
        //   370: aload_0
        //   371: aload 14
        //   373: invokestatic 131	mobi/ifunny/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   376: aload 13
        //   378: ifnull +49 -> 427
        //   381: aload 13
        //   383: astore 15
        //   385: aload 13
        //   387: invokevirtual 135	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   390: astore 14
        //   392: aload 14
        //   394: ifnull +33 -> 427
        //   397: sipush 8192
        //   400: newarray <illegal type>
        //   402: astore 15
        //   404: aload 14
        //   406: aload 15
        //   408: invokevirtual 141	java/io/InputStream:read	([B)I
        //   411: istore 8
        //   413: iload 8
        //   415: ifgt -11 -> 404
        //   418: aload 13
        //   420: astore 15
        //   422: aload 14
        //   424: invokevirtual 144	java/io/InputStream:close	()V
        //   427: aload 13
        //   429: astore 15
        //   431: ldc2_w 145
        //   434: invokestatic 152	android/os/SystemClock:sleep	(J)V
        //   437: aload 13
        //   439: ifnull +433 -> 872
        //   442: aload 13
        //   444: invokevirtual 125	java/net/HttpURLConnection:disconnect	()V
        //   447: iload 9
        //   449: istore 8
        //   451: aload_2
        //   452: astore 13
        //   454: goto -385 -> 69
        //   457: iload 11
        //   459: ifne +13 -> 472
        //   462: new 25	java/io/IOException
        //   465: dup
        //   466: ldc -102
        //   468: invokespecial 122	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   471: athrow
        //   472: aload_2
        //   473: invokevirtual 157	java/net/HttpURLConnection:getContentLength	()I
        //   476: istore 8
        //   478: iload 11
        //   480: iload 8
        //   482: iadd
        //   483: istore 10
        //   485: iload 6
        //   487: ifne +395 -> 882
        //   490: iload 10
        //   492: istore 6
        //   494: aconst_null
        //   495: astore 15
        //   497: aconst_null
        //   498: astore 14
        //   500: iload 7
        //   502: istore 8
        //   504: aload_2
        //   505: invokevirtual 160	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   508: astore 16
        //   510: aload 16
        //   512: astore 14
        //   514: aload 16
        //   516: astore 15
        //   518: iload 7
        //   520: istore 8
        //   522: aload 16
        //   524: aload 4
        //   526: new 162	mobi/ifunny/util/ac
        //   529: dup
        //   530: aload 5
        //   532: iload 11
        //   534: iload 10
        //   536: invokespecial 165	mobi/ifunny/util/ac:<init>	(Lmobi/ifunny/util/ae;II)V
        //   539: invokestatic 170	mobi/ifunny/util/s:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lmobi/ifunny/util/u;)I
        //   542: istore 11
        //   544: iload 7
        //   546: iload 11
        //   548: iadd
        //   549: istore 7
        //   551: aload 16
        //   553: ifnull +8 -> 561
        //   556: aload 16
        //   558: invokevirtual 144	java/io/InputStream:close	()V
        //   561: aload_2
        //   562: ifnull +7 -> 569
        //   565: aload_2
        //   566: invokevirtual 125	java/net/HttpURLConnection:disconnect	()V
        //   569: iload 7
        //   571: ireturn
        //   572: astore 16
        //   574: aload 14
        //   576: astore 15
        //   578: iload 7
        //   580: istore 8
        //   582: iload 7
        //   584: aload 16
        //   586: getfield 174	mobi/ifunny/util/t:bytesTransferred	I
        //   589: iadd
        //   590: istore 7
        //   592: aload 14
        //   594: astore 15
        //   596: iload 7
        //   598: istore 8
        //   600: aload 16
        //   602: getfield 177	mobi/ifunny/util/t:a	Z
        //   605: ifeq +124 -> 729
        //   608: aload 14
        //   610: astore 15
        //   612: iload 7
        //   614: istore 8
        //   616: new 23	mobi/ifunny/util/ad
        //   619: dup
        //   620: invokespecial 178	mobi/ifunny/util/ad:<init>	()V
        //   623: astore 16
        //   625: aload 14
        //   627: astore 15
        //   629: iload 7
        //   631: istore 8
        //   633: aload 16
        //   635: iload 7
        //   637: putfield 179	mobi/ifunny/util/ad:bytesTransferred	I
        //   640: aload 14
        //   642: astore 15
        //   644: iload 7
        //   646: istore 8
        //   648: aload 16
        //   650: iload 10
        //   652: putfield 181	mobi/ifunny/util/ad:a	I
        //   655: aload 14
        //   657: astore 15
        //   659: iload 7
        //   661: istore 8
        //   663: aload 16
        //   665: aload 13
        //   667: putfield 183	mobi/ifunny/util/ad:b	Ljava/lang/String;
        //   670: aload 14
        //   672: astore 15
        //   674: iload 7
        //   676: istore 8
        //   678: aload 16
        //   680: iconst_1
        //   681: putfield 185	mobi/ifunny/util/ad:c	Z
        //   684: aload 14
        //   686: astore 15
        //   688: iload 7
        //   690: istore 8
        //   692: aload 16
        //   694: athrow
        //   695: astore 14
        //   697: aload 15
        //   699: ifnull +8 -> 707
        //   702: aload 15
        //   704: invokevirtual 144	java/io/InputStream:close	()V
        //   707: aload 14
        //   709: athrow
        //   710: astore 14
        //   712: iload 8
        //   714: istore 7
        //   716: aload 13
        //   718: astore 15
        //   720: aload_2
        //   721: astore 13
        //   723: aload 15
        //   725: astore_2
        //   726: goto -363 -> 363
        //   729: aload 14
        //   731: astore 15
        //   733: iload 7
        //   735: istore 8
        //   737: aload 16
        //   739: athrow
        //   740: astore 15
        //   742: aload 13
        //   744: astore 15
        //   746: aload 14
        //   748: invokevirtual 144	java/io/InputStream:close	()V
        //   751: goto -324 -> 427
        //   754: astore 14
        //   756: goto -329 -> 427
        //   759: astore_0
        //   760: aload 13
        //   762: astore 15
        //   764: aload 14
        //   766: invokevirtual 144	java/io/InputStream:close	()V
        //   769: aload 13
        //   771: astore 15
        //   773: aload_0
        //   774: athrow
        //   775: new 23	mobi/ifunny/util/ad
        //   778: dup
        //   779: invokespecial 178	mobi/ifunny/util/ad:<init>	()V
        //   782: astore_0
        //   783: aload_0
        //   784: iload 7
        //   786: putfield 179	mobi/ifunny/util/ad:bytesTransferred	I
        //   789: aload_0
        //   790: iload 6
        //   792: putfield 181	mobi/ifunny/util/ad:a	I
        //   795: aload_0
        //   796: aload 13
        //   798: putfield 183	mobi/ifunny/util/ad:b	Ljava/lang/String;
        //   801: aload_0
        //   802: iconst_0
        //   803: putfield 185	mobi/ifunny/util/ad:c	Z
        //   806: aload_0
        //   807: iconst_1
        //   808: putfield 188	mobi/ifunny/util/ad:d	Z
        //   811: aload_0
        //   812: athrow
        //   813: astore 14
        //   815: goto -388 -> 427
        //   818: astore_2
        //   819: goto -50 -> 769
        //   822: astore 14
        //   824: aload 13
        //   826: astore_2
        //   827: aload 16
        //   829: astore 13
        //   831: goto -468 -> 363
        //   834: astore 14
        //   836: aload 13
        //   838: astore 15
        //   840: aload_2
        //   841: astore 13
        //   843: aload 15
        //   845: astore_2
        //   846: goto -483 -> 363
        //   849: astore 14
        //   851: aload 13
        //   853: astore 15
        //   855: aload_2
        //   856: astore 13
        //   858: aload 15
        //   860: astore_2
        //   861: goto -498 -> 363
        //   864: astore_0
        //   865: aload 14
        //   867: astore 15
        //   869: goto -556 -> 313
        //   872: iload 9
        //   874: istore 8
        //   876: aload_2
        //   877: astore 13
        //   879: goto -810 -> 69
        //   882: goto -388 -> 494
        //   885: goto -663 -> 222
        //   888: goto -632 -> 256
        //   891: astore_0
        //   892: goto -573 -> 319
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	895	0	paramString1	String
        //   0	895	1	paramInt1	int
        //   0	895	2	paramString2	String
        //   0	895	3	paramInt2	int
        //   0	895	4	paramOutputStream	OutputStream
        //   0	895	5	paramae	ae
        //   61	730	6	i	int
        //   58	727	7	j	int
        //   64	811	8	k	int
        //   73	800	9	m	int
        //   483	168	10	n	int
        //   85	464	11	i1	int
        //   211	3	12	bool	boolean
        //   67	811	13	localObject1	Object
        //   94	125	14	str	String
        //   351	21	14	localIOException1	java.io.IOException
        //   390	295	14	localInputStream1	java.io.InputStream
        //   695	13	14	localObject2	Object
        //   710	37	14	localIOException2	java.io.IOException
        //   754	11	14	localIOException3	java.io.IOException
        //   813	1	14	localIOException4	java.io.IOException
        //   822	1	14	localIOException5	java.io.IOException
        //   834	1	14	localIOException6	java.io.IOException
        //   849	17	14	localIOException7	java.io.IOException
        //   88	644	15	localObject3	Object
        //   740	1	15	localIOException8	java.io.IOException
        //   744	124	15	localObject4	Object
        //   91	466	16	localInputStream2	java.io.InputStream
        //   572	29	16	localt	t
        //   623	205	16	localad	ad
        //   55	42	17	localURL	java.net.URL
        // Exception table:
        //   from	to	target	type
        //   105	124	309	mobi/ifunny/util/ad
        //   129	176	309	mobi/ifunny/util/ad
        //   176	185	309	mobi/ifunny/util/ad
        //   190	213	309	mobi/ifunny/util/ad
        //   222	228	309	mobi/ifunny/util/ad
        //   256	309	309	mobi/ifunny/util/ad
        //   341	351	309	mobi/ifunny/util/ad
        //   462	472	309	mobi/ifunny/util/ad
        //   472	478	309	mobi/ifunny/util/ad
        //   556	561	309	mobi/ifunny/util/ad
        //   702	707	309	mobi/ifunny/util/ad
        //   707	710	309	mobi/ifunny/util/ad
        //   96	105	315	finally
        //   313	315	315	finally
        //   367	376	315	finally
        //   385	392	315	finally
        //   422	427	315	finally
        //   431	437	315	finally
        //   746	751	315	finally
        //   764	769	315	finally
        //   773	775	315	finally
        //   222	228	351	java/io/IOException
        //   256	309	351	java/io/IOException
        //   341	351	351	java/io/IOException
        //   462	472	351	java/io/IOException
        //   472	478	351	java/io/IOException
        //   504	510	572	mobi/ifunny/util/t
        //   522	544	572	mobi/ifunny/util/t
        //   504	510	695	finally
        //   522	544	695	finally
        //   582	592	695	finally
        //   600	608	695	finally
        //   616	625	695	finally
        //   633	640	695	finally
        //   648	655	695	finally
        //   663	670	695	finally
        //   678	684	695	finally
        //   692	695	695	finally
        //   737	740	695	finally
        //   702	707	710	java/io/IOException
        //   707	710	710	java/io/IOException
        //   397	404	740	java/io/IOException
        //   404	413	740	java/io/IOException
        //   746	751	754	java/io/IOException
        //   397	404	759	finally
        //   404	413	759	finally
        //   422	427	813	java/io/IOException
        //   764	769	818	java/io/IOException
        //   96	105	822	java/io/IOException
        //   105	124	834	java/io/IOException
        //   129	176	834	java/io/IOException
        //   176	185	834	java/io/IOException
        //   190	213	834	java/io/IOException
        //   556	561	849	java/io/IOException
        //   96	105	864	mobi/ifunny/util/ad
        //   105	124	891	finally
        //   129	176	891	finally
        //   176	185	891	finally
        //   190	213	891	finally
        //   222	228	891	finally
        //   256	309	891	finally
        //   341	351	891	finally
        //   462	472	891	finally
        //   472	478	891	finally
        //   556	561	891	finally
        //   702	707	891	finally
        //   707	710	891	finally
    }

    public static int a(String paramString, OutputStream paramOutputStream, ae paramae) {
        return a(paramString, 3, null, 0, paramOutputStream, paramae);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */