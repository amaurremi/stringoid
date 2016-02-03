package com.flurry.sdk;

public class dh
{
  private static final String b = dh.class.getSimpleName();
  byte[] a;
  
  /* Error */
  public dh(di paramdi)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/lang/Object:<init>	()V
    //   4: aconst_null
    //   5: astore 6
    //   7: new 27	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 28	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore 7
    //   16: new 30	java/io/DataOutputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 33	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore 5
    //   27: aload 5
    //   29: iconst_3
    //   30: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   33: aload 5
    //   35: aload_1
    //   36: invokevirtual 41	com/flurry/sdk/di:a	()Ljava/lang/String;
    //   39: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   42: aload 5
    //   44: aload_1
    //   45: invokevirtual 48	com/flurry/sdk/di:b	()J
    //   48: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 55	com/flurry/sdk/di:c	()J
    //   57: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   60: aload 5
    //   62: aload_1
    //   63: invokevirtual 58	com/flurry/sdk/di:d	()J
    //   66: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   69: aload_1
    //   70: invokevirtual 62	com/flurry/sdk/di:e	()Ljava/util/Map;
    //   73: astore 6
    //   75: aload 6
    //   77: ifnonnull +256 -> 333
    //   80: aload 5
    //   82: iconst_0
    //   83: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   86: aload 5
    //   88: aload_1
    //   89: invokevirtual 65	com/flurry/sdk/di:f	()Ljava/lang/String;
    //   92: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   95: aload 5
    //   97: aload_1
    //   98: invokevirtual 68	com/flurry/sdk/di:g	()Ljava/lang/String;
    //   101: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   104: aload 5
    //   106: aload_1
    //   107: invokevirtual 72	com/flurry/sdk/di:h	()I
    //   110: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   113: aload 5
    //   115: aload_1
    //   116: invokevirtual 78	com/flurry/sdk/di:i	()Ljava/lang/String;
    //   119: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   126: ifnonnull +333 -> 459
    //   129: aload 5
    //   131: iconst_0
    //   132: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   135: aload 5
    //   137: aload_1
    //   138: invokevirtual 89	com/flurry/sdk/di:k	()I
    //   141: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   144: aload 5
    //   146: iconst_m1
    //   147: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   150: aload 5
    //   152: iconst_m1
    //   153: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   156: aload 5
    //   158: aload_1
    //   159: invokevirtual 96	com/flurry/sdk/di:l	()B
    //   162: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   165: aload_1
    //   166: invokevirtual 100	com/flurry/sdk/di:m	()Ljava/lang/Long;
    //   169: ifnonnull +343 -> 512
    //   172: aload 5
    //   174: iconst_0
    //   175: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   178: aload_1
    //   179: invokevirtual 103	com/flurry/sdk/di:n	()Ljava/util/Map;
    //   182: astore 6
    //   184: aload 6
    //   186: ifnonnull +347 -> 533
    //   189: aload 5
    //   191: iconst_0
    //   192: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   195: aload_1
    //   196: invokevirtual 107	com/flurry/sdk/di:o	()Ljava/util/List;
    //   199: astore 6
    //   201: aload 6
    //   203: ifnonnull +414 -> 617
    //   206: aload 5
    //   208: iconst_0
    //   209: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   212: aload 5
    //   214: aload_1
    //   215: invokevirtual 111	com/flurry/sdk/di:p	()Z
    //   218: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   221: aload_1
    //   222: invokevirtual 114	com/flurry/sdk/di:r	()Ljava/util/List;
    //   225: astore 6
    //   227: aload 6
    //   229: ifnull +497 -> 726
    //   232: iconst_0
    //   233: istore_3
    //   234: iconst_0
    //   235: istore 4
    //   237: iconst_0
    //   238: istore_2
    //   239: iload_3
    //   240: aload 6
    //   242: invokeinterface 119 1 0
    //   247: if_icmpge +476 -> 723
    //   250: iload 4
    //   252: aload 6
    //   254: iload_3
    //   255: invokeinterface 123 2 0
    //   260: checkcast 125	com/flurry/sdk/da
    //   263: invokevirtual 127	com/flurry/sdk/da:a	()I
    //   266: iadd
    //   267: istore 4
    //   269: iload 4
    //   271: ldc -128
    //   273: if_icmple +462 -> 735
    //   276: iconst_5
    //   277: getstatic 18	com/flurry/sdk/dh:b	Ljava/lang/String;
    //   280: ldc -126
    //   282: invokestatic 135	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   285: aload 5
    //   287: aload_1
    //   288: invokevirtual 138	com/flurry/sdk/di:q	()I
    //   291: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   294: aload 5
    //   296: iload_2
    //   297: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   300: iconst_0
    //   301: istore_3
    //   302: iload_3
    //   303: iload_2
    //   304: if_icmpge +365 -> 669
    //   307: aload 5
    //   309: aload 6
    //   311: iload_3
    //   312: invokeinterface 123 2 0
    //   317: checkcast 125	com/flurry/sdk/da
    //   320: invokevirtual 141	com/flurry/sdk/da:b	()[B
    //   323: invokevirtual 145	java/io/DataOutputStream:write	([B)V
    //   326: iload_3
    //   327: iconst_1
    //   328: iadd
    //   329: istore_3
    //   330: goto -28 -> 302
    //   333: aload 5
    //   335: aload 6
    //   337: invokeinterface 148 1 0
    //   342: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   345: aload 6
    //   347: invokeinterface 152 1 0
    //   352: invokeinterface 158 1 0
    //   357: astore 6
    //   359: aload 6
    //   361: invokeinterface 163 1 0
    //   366: ifeq -280 -> 86
    //   369: aload 6
    //   371: invokeinterface 167 1 0
    //   376: checkcast 169	java/util/Map$Entry
    //   379: astore 8
    //   381: aload 5
    //   383: aload 8
    //   385: invokeinterface 172 1 0
    //   390: checkcast 174	java/lang/String
    //   393: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   396: aload 5
    //   398: aload 8
    //   400: invokeinterface 177 1 0
    //   405: checkcast 174	java/lang/String
    //   408: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   411: aload 5
    //   413: iconst_0
    //   414: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   417: goto -58 -> 359
    //   420: astore 6
    //   422: aload 5
    //   424: astore_1
    //   425: aload 6
    //   427: astore 5
    //   429: bipush 6
    //   431: getstatic 18	com/flurry/sdk/dh:b	Ljava/lang/String;
    //   434: ldc -77
    //   436: aload 5
    //   438: invokestatic 182	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 5
    //   443: athrow
    //   444: astore 6
    //   446: aload_1
    //   447: astore 5
    //   449: aload 6
    //   451: astore_1
    //   452: aload 5
    //   454: invokestatic 187	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   457: aload_1
    //   458: athrow
    //   459: aload 5
    //   461: iconst_1
    //   462: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   465: aload 5
    //   467: aload_0
    //   468: aload_1
    //   469: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   472: invokevirtual 193	android/location/Location:getLatitude	()D
    //   475: invokevirtual 196	com/flurry/sdk/dh:a	(D)D
    //   478: invokevirtual 200	java/io/DataOutputStream:writeDouble	(D)V
    //   481: aload 5
    //   483: aload_0
    //   484: aload_1
    //   485: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   488: invokevirtual 203	android/location/Location:getLongitude	()D
    //   491: invokevirtual 196	com/flurry/sdk/dh:a	(D)D
    //   494: invokevirtual 200	java/io/DataOutputStream:writeDouble	(D)V
    //   497: aload 5
    //   499: aload_1
    //   500: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   503: invokevirtual 207	android/location/Location:getAccuracy	()F
    //   506: invokevirtual 211	java/io/DataOutputStream:writeFloat	(F)V
    //   509: goto -374 -> 135
    //   512: aload 5
    //   514: iconst_1
    //   515: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   518: aload 5
    //   520: aload_1
    //   521: invokevirtual 100	com/flurry/sdk/di:m	()Ljava/lang/Long;
    //   524: invokevirtual 216	java/lang/Long:longValue	()J
    //   527: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   530: goto -352 -> 178
    //   533: aload 5
    //   535: aload 6
    //   537: invokeinterface 148 1 0
    //   542: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   545: aload 6
    //   547: invokeinterface 152 1 0
    //   552: invokeinterface 158 1 0
    //   557: astore 6
    //   559: aload 6
    //   561: invokeinterface 163 1 0
    //   566: ifeq -371 -> 195
    //   569: aload 6
    //   571: invokeinterface 167 1 0
    //   576: checkcast 169	java/util/Map$Entry
    //   579: astore 8
    //   581: aload 5
    //   583: aload 8
    //   585: invokeinterface 172 1 0
    //   590: checkcast 174	java/lang/String
    //   593: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   596: aload 5
    //   598: aload 8
    //   600: invokeinterface 177 1 0
    //   605: checkcast 218	com/flurry/sdk/cx$a
    //   608: getfield 221	com/flurry/sdk/cx$a:a	I
    //   611: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   614: goto -55 -> 559
    //   617: aload 5
    //   619: aload 6
    //   621: invokeinterface 119 1 0
    //   626: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   629: aload 6
    //   631: invokeinterface 222 1 0
    //   636: astore 6
    //   638: aload 6
    //   640: invokeinterface 163 1 0
    //   645: ifeq -433 -> 212
    //   648: aload 5
    //   650: aload 6
    //   652: invokeinterface 167 1 0
    //   657: checkcast 224	com/flurry/sdk/db
    //   660: invokevirtual 226	com/flurry/sdk/db:e	()[B
    //   663: invokevirtual 145	java/io/DataOutputStream:write	([B)V
    //   666: goto -28 -> 638
    //   669: aload 5
    //   671: iconst_m1
    //   672: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   675: aload 5
    //   677: iconst_0
    //   678: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   681: aload 5
    //   683: iconst_0
    //   684: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   687: aload 5
    //   689: iconst_0
    //   690: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   693: aload_0
    //   694: aload 7
    //   696: invokevirtual 229	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   699: putfield 231	com/flurry/sdk/dh:a	[B
    //   702: aload 5
    //   704: invokestatic 187	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   707: return
    //   708: astore_1
    //   709: aconst_null
    //   710: astore 5
    //   712: goto -260 -> 452
    //   715: astore 5
    //   717: aload 6
    //   719: astore_1
    //   720: goto -291 -> 429
    //   723: goto -438 -> 285
    //   726: iconst_0
    //   727: istore_2
    //   728: goto -443 -> 285
    //   731: astore_1
    //   732: goto -280 -> 452
    //   735: iload_2
    //   736: iconst_1
    //   737: iadd
    //   738: istore_2
    //   739: iload_3
    //   740: iconst_1
    //   741: iadd
    //   742: istore_3
    //   743: goto -504 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	dh
    //   0	746	1	paramdi	di
    //   238	501	2	i	int
    //   233	510	3	j	int
    //   235	39	4	k	int
    //   25	686	5	localObject1	Object
    //   715	1	5	localIOException1	java.io.IOException
    //   5	365	6	localObject2	Object
    //   420	6	6	localIOException2	java.io.IOException
    //   444	102	6	localObject3	Object
    //   557	161	6	localIterator	java.util.Iterator
    //   14	681	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   379	220	8	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   27	75	420	java/io/IOException
    //   80	86	420	java/io/IOException
    //   86	135	420	java/io/IOException
    //   135	178	420	java/io/IOException
    //   178	184	420	java/io/IOException
    //   189	195	420	java/io/IOException
    //   195	201	420	java/io/IOException
    //   206	212	420	java/io/IOException
    //   212	227	420	java/io/IOException
    //   239	269	420	java/io/IOException
    //   276	285	420	java/io/IOException
    //   285	300	420	java/io/IOException
    //   307	326	420	java/io/IOException
    //   333	359	420	java/io/IOException
    //   359	417	420	java/io/IOException
    //   459	509	420	java/io/IOException
    //   512	530	420	java/io/IOException
    //   533	559	420	java/io/IOException
    //   559	614	420	java/io/IOException
    //   617	638	420	java/io/IOException
    //   638	666	420	java/io/IOException
    //   669	702	420	java/io/IOException
    //   429	444	444	finally
    //   7	27	708	finally
    //   7	27	715	java/io/IOException
    //   27	75	731	finally
    //   80	86	731	finally
    //   86	135	731	finally
    //   135	178	731	finally
    //   178	184	731	finally
    //   189	195	731	finally
    //   195	201	731	finally
    //   206	212	731	finally
    //   212	227	731	finally
    //   239	269	731	finally
    //   276	285	731	finally
    //   285	300	731	finally
    //   307	326	731	finally
    //   333	359	731	finally
    //   359	417	731	finally
    //   459	509	731	finally
    //   512	530	731	finally
    //   533	559	731	finally
    //   559	614	731	finally
    //   617	638	731	finally
    //   638	666	731	finally
    //   669	702	731	finally
  }
  
  public dh(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  double a(double paramDouble)
  {
    return Math.round(paramDouble * 1000.0D) / 1000.0D;
  }
  
  public byte[] a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */