package com.everimaging.fotorsdk.algorithms.xml;

public class b {
    /* Error */
    public static com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity a(org.xmlpull.v1.XmlPullParser paramXmlPullParser, com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity paramEffectEntity) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: aload_0
        //   3: invokeinterface 16 1 0
        //   8: istore_2
        //   9: aconst_null
        //   10: astore 6
        //   12: iload_2
        //   13: istore 4
        //   15: aload 6
        //   17: astore 7
        //   19: iload 4
        //   21: iconst_1
        //   22: if_icmpeq +196 -> 218
        //   25: aload 6
        //   27: astore 7
        //   29: iload_3
        //   30: ifne +188 -> 218
        //   33: aload_0
        //   34: invokeinterface 20 1 0
        //   39: astore 7
        //   41: iload 4
        //   43: tableswitch	default:+21->64, 2:+44->87, 3:+366->409
        //   64: iload_3
        //   65: istore_2
        //   66: aload 6
        //   68: astore 8
        //   70: aload 6
        //   72: astore 9
        //   74: aload_0
        //   75: invokeinterface 23 1 0
        //   80: istore 4
        //   82: iload_2
        //   83: istore_3
        //   84: goto -69 -> 15
        //   87: ldc 25
        //   89: aload 7
        //   91: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   94: ifeq +127 -> 221
        //   97: new 33	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity
        //   100: dup
        //   101: invokespecial 37	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:<init>	()V
        //   104: astore 7
        //   106: aload 7
        //   108: astore 8
        //   110: aload 7
        //   112: astore 9
        //   114: aload_0
        //   115: aconst_null
        //   116: ldc 39
        //   118: invokeinterface 43 3 0
        //   123: astore 10
        //   125: aload 7
        //   127: astore 8
        //   129: aload 7
        //   131: astore 9
        //   133: aload 7
        //   135: aload 10
        //   137: invokevirtual 47	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setBaseFilterType	(Ljava/lang/String;)V
        //   140: aload 7
        //   142: astore 6
        //   144: iload_3
        //   145: istore_2
        //   146: aload 7
        //   148: astore 8
        //   150: aload 7
        //   152: astore 9
        //   154: aload 7
        //   156: invokevirtual 51	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:getFilterType	()Lcom/everimaging/fotorsdk/algorithms/parser/RSBaseFilterFactory$BaseFilter;
        //   159: ifnonnull -93 -> 66
        //   162: aload 7
        //   164: astore 8
        //   166: aload 7
        //   168: astore 9
        //   170: ldc 53
        //   172: new 55	java/lang/StringBuilder
        //   175: dup
        //   176: invokespecial 56	java/lang/StringBuilder:<init>	()V
        //   179: ldc 58
        //   181: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   184: aload 10
        //   186: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   192: invokestatic 71	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   195: pop
        //   196: aload 7
        //   198: astore 6
        //   200: iload_3
        //   201: istore_2
        //   202: goto -136 -> 66
        //   205: astore_0
        //   206: aload 8
        //   208: astore 6
        //   210: aload_0
        //   211: invokevirtual 74	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
        //   214: aload 6
        //   216: astore 7
        //   218: aload 7
        //   220: areturn
        //   221: ldc 76
        //   223: aload 7
        //   225: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   228: ifeq +23 -> 251
        //   231: aload 6
        //   233: aload_1
        //   234: aload_0
        //   235: invokeinterface 79 1 0
        //   240: invokevirtual 85	com/everimaging/fotorsdk/algorithms/xml/entity/EffectEntity:getAllocation	(Ljava/lang/String;)Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;
        //   243: invokevirtual 89	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setSrc	(Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;)V
        //   246: iload_3
        //   247: istore_2
        //   248: goto -182 -> 66
        //   251: ldc 91
        //   253: aload 7
        //   255: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   258: ifeq +23 -> 281
        //   261: aload 6
        //   263: aload_1
        //   264: aload_0
        //   265: invokeinterface 79 1 0
        //   270: invokevirtual 85	com/everimaging/fotorsdk/algorithms/xml/entity/EffectEntity:getAllocation	(Ljava/lang/String;)Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;
        //   273: invokevirtual 94	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setDst	(Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;)V
        //   276: iload_3
        //   277: istore_2
        //   278: goto -212 -> 66
        //   281: ldc 96
        //   283: aload 7
        //   285: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   288: ifeq +23 -> 311
        //   291: aload 6
        //   293: aload_1
        //   294: aload_0
        //   295: invokeinterface 79 1 0
        //   300: invokevirtual 85	com/everimaging/fotorsdk/algorithms/xml/entity/EffectEntity:getAllocation	(Ljava/lang/String;)Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;
        //   303: invokevirtual 99	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setTex	(Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;)V
        //   306: iload_3
        //   307: istore_2
        //   308: goto -242 -> 66
        //   311: ldc 101
        //   313: aload 7
        //   315: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   318: ifeq +62 -> 380
        //   321: aload_0
        //   322: invokeinterface 79 1 0
        //   327: astore 7
        //   329: aload_1
        //   330: aload 7
        //   332: invokevirtual 85	com/everimaging/fotorsdk/algorithms/xml/entity/EffectEntity:getAllocation	(Ljava/lang/String;)Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;
        //   335: astore 8
        //   337: aload 8
        //   339: ifnonnull +29 -> 368
        //   342: ldc 53
        //   344: new 55	java/lang/StringBuilder
        //   347: dup
        //   348: invokespecial 56	java/lang/StringBuilder:<init>	()V
        //   351: ldc 103
        //   353: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   356: aload 7
        //   358: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   361: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   364: invokestatic 71	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   367: pop
        //   368: aload 6
        //   370: aload 8
        //   372: invokevirtual 106	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setTableTex	(Lcom/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntity;)V
        //   375: iload_3
        //   376: istore_2
        //   377: goto -311 -> 66
        //   380: ldc 108
        //   382: aload 7
        //   384: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   387: ifeq -323 -> 64
        //   390: aload 6
        //   392: aload 6
        //   394: invokevirtual 51	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:getFilterType	()Lcom/everimaging/fotorsdk/algorithms/parser/RSBaseFilterFactory$BaseFilter;
        //   397: aload_0
        //   398: invokestatic 113	com/everimaging/fotorsdk/algorithms/parser/b:a	(Lcom/everimaging/fotorsdk/algorithms/parser/RSBaseFilterFactory$BaseFilter;Lorg/xmlpull/v1/XmlPullParser;)Lcom/everimaging/fotorsdk/algorithms/params/base/RSBaseParams;
        //   401: invokevirtual 117	com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity:setParams	(Lcom/everimaging/fotorsdk/algorithms/params/base/RSBaseParams;)V
        //   404: iload_3
        //   405: istore_2
        //   406: goto -340 -> 66
        //   409: ldc 25
        //   411: aload 7
        //   413: invokevirtual 31	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   416: istore 5
        //   418: iload 5
        //   420: ifeq -356 -> 64
        //   423: iconst_1
        //   424: istore_2
        //   425: goto -359 -> 66
        //   428: astore_0
        //   429: aconst_null
        //   430: astore 6
        //   432: aload_0
        //   433: invokevirtual 118	java/io/IOException:printStackTrace	()V
        //   436: aload 6
        //   438: areturn
        //   439: astore_0
        //   440: aload 9
        //   442: astore 6
        //   444: goto -12 -> 432
        //   447: astore_0
        //   448: goto -16 -> 432
        //   451: astore_0
        //   452: aconst_null
        //   453: astore 6
        //   455: goto -245 -> 210
        //   458: astore_0
        //   459: goto -249 -> 210
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	462	0	paramXmlPullParser	org.xmlpull.v1.XmlPullParser
        //   0	462	1	paramEffectEntity	com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity
        //   8	417	2	i	int
        //   1	404	3	j	int
        //   13	68	4	k	int
        //   416	3	5	bool	boolean
        //   10	444	6	localObject1	Object
        //   17	395	7	localObject2	Object
        //   68	303	8	localObject3	Object
        //   72	369	9	localObject4	Object
        //   123	62	10	str	String
        // Exception table:
        //   from	to	target	type
        //   74	82	205	org/xmlpull/v1/XmlPullParserException
        //   114	125	205	org/xmlpull/v1/XmlPullParserException
        //   133	140	205	org/xmlpull/v1/XmlPullParserException
        //   154	162	205	org/xmlpull/v1/XmlPullParserException
        //   170	196	205	org/xmlpull/v1/XmlPullParserException
        //   2	9	428	java/io/IOException
        //   74	82	439	java/io/IOException
        //   114	125	439	java/io/IOException
        //   133	140	439	java/io/IOException
        //   154	162	439	java/io/IOException
        //   170	196	439	java/io/IOException
        //   33	41	447	java/io/IOException
        //   87	106	447	java/io/IOException
        //   221	246	447	java/io/IOException
        //   251	276	447	java/io/IOException
        //   281	306	447	java/io/IOException
        //   311	337	447	java/io/IOException
        //   342	368	447	java/io/IOException
        //   368	375	447	java/io/IOException
        //   380	404	447	java/io/IOException
        //   409	418	447	java/io/IOException
        //   2	9	451	org/xmlpull/v1/XmlPullParserException
        //   33	41	458	org/xmlpull/v1/XmlPullParserException
        //   87	106	458	org/xmlpull/v1/XmlPullParserException
        //   221	246	458	org/xmlpull/v1/XmlPullParserException
        //   251	276	458	org/xmlpull/v1/XmlPullParserException
        //   281	306	458	org/xmlpull/v1/XmlPullParserException
        //   311	337	458	org/xmlpull/v1/XmlPullParserException
        //   342	368	458	org/xmlpull/v1/XmlPullParserException
        //   368	375	458	org/xmlpull/v1/XmlPullParserException
        //   380	404	458	org/xmlpull/v1/XmlPullParserException
        //   409	418	458	org/xmlpull/v1/XmlPullParserException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */