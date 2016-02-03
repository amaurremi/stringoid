package com.flurry.android.monolithic.sdk.impl;

public class ez
{
  private static final String b = ez.class.getSimpleName();
  byte[] a;
  
  /* Error */
  public ez(fa paramfa)
    throws java.io.IOException
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
    //   29: iconst_1
    //   30: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   33: aload 5
    //   35: aload_1
    //   36: invokevirtual 41	com/flurry/android/monolithic/sdk/impl/fa:a	()Ljava/lang/String;
    //   39: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   42: aload 5
    //   44: aload_1
    //   45: invokevirtual 48	com/flurry/android/monolithic/sdk/impl/fa:b	()J
    //   48: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 55	com/flurry/android/monolithic/sdk/impl/fa:c	()J
    //   57: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   60: aload 5
    //   62: aload_1
    //   63: invokevirtual 58	com/flurry/android/monolithic/sdk/impl/fa:d	()J
    //   66: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   69: aload 5
    //   71: aload_1
    //   72: invokevirtual 61	com/flurry/android/monolithic/sdk/impl/fa:e	()Ljava/lang/String;
    //   75: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 64	com/flurry/android/monolithic/sdk/impl/fa:f	()Ljava/lang/String;
    //   84: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   87: aload 5
    //   89: aload_1
    //   90: invokevirtual 68	com/flurry/android/monolithic/sdk/impl/fa:g	()I
    //   93: invokevirtual 71	java/io/DataOutputStream:writeByte	(I)V
    //   96: aload 5
    //   98: aload_1
    //   99: invokevirtual 74	com/flurry/android/monolithic/sdk/impl/fa:h	()Ljava/lang/String;
    //   102: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   105: aload_1
    //   106: invokevirtual 78	com/flurry/android/monolithic/sdk/impl/fa:i	()Landroid/location/Location;
    //   109: ifnonnull +181 -> 290
    //   112: aload 5
    //   114: iconst_0
    //   115: invokevirtual 82	java/io/DataOutputStream:writeBoolean	(Z)V
    //   118: aload 5
    //   120: aload_1
    //   121: invokevirtual 85	com/flurry/android/monolithic/sdk/impl/fa:j	()I
    //   124: invokevirtual 88	java/io/DataOutputStream:writeInt	(I)V
    //   127: aload 5
    //   129: iconst_m1
    //   130: invokevirtual 71	java/io/DataOutputStream:writeByte	(I)V
    //   133: aload 5
    //   135: iconst_m1
    //   136: invokevirtual 71	java/io/DataOutputStream:writeByte	(I)V
    //   139: aload 5
    //   141: aload_1
    //   142: invokevirtual 92	com/flurry/android/monolithic/sdk/impl/fa:k	()B
    //   145: invokevirtual 71	java/io/DataOutputStream:writeByte	(I)V
    //   148: aload_1
    //   149: invokevirtual 96	com/flurry/android/monolithic/sdk/impl/fa:l	()Ljava/lang/Long;
    //   152: ifnonnull +191 -> 343
    //   155: aload 5
    //   157: iconst_0
    //   158: invokevirtual 82	java/io/DataOutputStream:writeBoolean	(Z)V
    //   161: aload_1
    //   162: invokevirtual 100	com/flurry/android/monolithic/sdk/impl/fa:p	()Ljava/util/Map;
    //   165: astore 6
    //   167: aload 5
    //   169: aload 6
    //   171: invokeinterface 105 1 0
    //   176: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   179: aload 6
    //   181: invokeinterface 109 1 0
    //   186: invokeinterface 115 1 0
    //   191: astore 6
    //   193: aload 6
    //   195: invokeinterface 121 1 0
    //   200: ifeq +164 -> 364
    //   203: aload 6
    //   205: invokeinterface 125 1 0
    //   210: checkcast 127	java/util/Map$Entry
    //   213: astore 8
    //   215: aload 5
    //   217: aload 8
    //   219: invokeinterface 130 1 0
    //   224: checkcast 132	java/lang/String
    //   227: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   230: aload 5
    //   232: aload 8
    //   234: invokeinterface 135 1 0
    //   239: checkcast 137	com/flurry/android/monolithic/sdk/impl/eh
    //   242: getfield 140	com/flurry/android/monolithic/sdk/impl/eh:a	I
    //   245: invokevirtual 88	java/io/DataOutputStream:writeInt	(I)V
    //   248: goto -55 -> 193
    //   251: astore 6
    //   253: aload 5
    //   255: astore_1
    //   256: aload 6
    //   258: astore 5
    //   260: bipush 6
    //   262: getstatic 18	com/flurry/android/monolithic/sdk/impl/ez:b	Ljava/lang/String;
    //   265: ldc -114
    //   267: aload 5
    //   269: invokestatic 147	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 5
    //   274: athrow
    //   275: astore 6
    //   277: aload_1
    //   278: astore 5
    //   280: aload 6
    //   282: astore_1
    //   283: aload 5
    //   285: invokestatic 152	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   288: aload_1
    //   289: athrow
    //   290: aload 5
    //   292: iconst_1
    //   293: invokevirtual 82	java/io/DataOutputStream:writeBoolean	(Z)V
    //   296: aload 5
    //   298: aload_0
    //   299: aload_1
    //   300: invokevirtual 78	com/flurry/android/monolithic/sdk/impl/fa:i	()Landroid/location/Location;
    //   303: invokevirtual 158	android/location/Location:getLatitude	()D
    //   306: invokespecial 161	com/flurry/android/monolithic/sdk/impl/ez:a	(D)D
    //   309: invokevirtual 165	java/io/DataOutputStream:writeDouble	(D)V
    //   312: aload 5
    //   314: aload_0
    //   315: aload_1
    //   316: invokevirtual 78	com/flurry/android/monolithic/sdk/impl/fa:i	()Landroid/location/Location;
    //   319: invokevirtual 168	android/location/Location:getLongitude	()D
    //   322: invokespecial 161	com/flurry/android/monolithic/sdk/impl/ez:a	(D)D
    //   325: invokevirtual 165	java/io/DataOutputStream:writeDouble	(D)V
    //   328: aload 5
    //   330: aload_1
    //   331: invokevirtual 78	com/flurry/android/monolithic/sdk/impl/fa:i	()Landroid/location/Location;
    //   334: invokevirtual 172	android/location/Location:getAccuracy	()F
    //   337: invokevirtual 176	java/io/DataOutputStream:writeFloat	(F)V
    //   340: goto -222 -> 118
    //   343: aload 5
    //   345: iconst_1
    //   346: invokevirtual 82	java/io/DataOutputStream:writeBoolean	(Z)V
    //   349: aload 5
    //   351: aload_1
    //   352: invokevirtual 96	com/flurry/android/monolithic/sdk/impl/fa:l	()Ljava/lang/Long;
    //   355: invokevirtual 181	java/lang/Long:longValue	()J
    //   358: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   361: goto -200 -> 161
    //   364: aload_1
    //   365: invokevirtual 185	com/flurry/android/monolithic/sdk/impl/fa:n	()Ljava/util/List;
    //   368: astore 6
    //   370: aload 5
    //   372: aload 6
    //   374: invokeinterface 188 1 0
    //   379: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   382: aload 6
    //   384: invokeinterface 189 1 0
    //   389: astore 6
    //   391: aload 6
    //   393: invokeinterface 121 1 0
    //   398: ifeq +24 -> 422
    //   401: aload 5
    //   403: aload 6
    //   405: invokeinterface 125 1 0
    //   410: checkcast 191	com/flurry/android/monolithic/sdk/impl/ek
    //   413: invokevirtual 194	com/flurry/android/monolithic/sdk/impl/ek:e	()[B
    //   416: invokevirtual 198	java/io/DataOutputStream:write	([B)V
    //   419: goto -28 -> 391
    //   422: aload 5
    //   424: aload_1
    //   425: invokevirtual 201	com/flurry/android/monolithic/sdk/impl/fa:q	()Z
    //   428: invokevirtual 82	java/io/DataOutputStream:writeBoolean	(Z)V
    //   431: aload_1
    //   432: invokevirtual 204	com/flurry/android/monolithic/sdk/impl/fa:o	()Ljava/util/List;
    //   435: astore 6
    //   437: iconst_0
    //   438: istore_3
    //   439: iconst_0
    //   440: istore 4
    //   442: iconst_0
    //   443: istore_2
    //   444: iload_3
    //   445: aload 6
    //   447: invokeinterface 188 1 0
    //   452: if_icmpge +38 -> 490
    //   455: iload 4
    //   457: aload 6
    //   459: iload_3
    //   460: invokeinterface 208 2 0
    //   465: checkcast 210	com/flurry/android/monolithic/sdk/impl/ej
    //   468: invokevirtual 212	com/flurry/android/monolithic/sdk/impl/ej:a	()I
    //   471: iadd
    //   472: istore 4
    //   474: iload 4
    //   476: ldc -43
    //   478: if_icmple +106 -> 584
    //   481: iconst_5
    //   482: getstatic 18	com/flurry/android/monolithic/sdk/impl/ez:b	Ljava/lang/String;
    //   485: ldc -41
    //   487: invokestatic 218	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   490: aload 5
    //   492: aload_1
    //   493: invokevirtual 221	com/flurry/android/monolithic/sdk/impl/fa:m	()I
    //   496: invokevirtual 88	java/io/DataOutputStream:writeInt	(I)V
    //   499: aload 5
    //   501: iload_2
    //   502: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   505: iconst_0
    //   506: istore_3
    //   507: iload_3
    //   508: iload_2
    //   509: if_icmpge +29 -> 538
    //   512: aload 5
    //   514: aload 6
    //   516: iload_3
    //   517: invokeinterface 208 2 0
    //   522: checkcast 210	com/flurry/android/monolithic/sdk/impl/ej
    //   525: invokevirtual 223	com/flurry/android/monolithic/sdk/impl/ej:b	()[B
    //   528: invokevirtual 198	java/io/DataOutputStream:write	([B)V
    //   531: iload_3
    //   532: iconst_1
    //   533: iadd
    //   534: istore_3
    //   535: goto -28 -> 507
    //   538: aload 5
    //   540: iconst_0
    //   541: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   544: aload 5
    //   546: iconst_0
    //   547: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   550: aload_0
    //   551: aload 7
    //   553: invokevirtual 226	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   556: putfield 228	com/flurry/android/monolithic/sdk/impl/ez:a	[B
    //   559: aload 5
    //   561: invokestatic 152	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   564: return
    //   565: astore_1
    //   566: aconst_null
    //   567: astore 5
    //   569: goto -286 -> 283
    //   572: astore 5
    //   574: aload 6
    //   576: astore_1
    //   577: goto -317 -> 260
    //   580: astore_1
    //   581: goto -298 -> 283
    //   584: iload_2
    //   585: iconst_1
    //   586: iadd
    //   587: istore_2
    //   588: iload_3
    //   589: iconst_1
    //   590: iadd
    //   591: istore_3
    //   592: goto -148 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	ez
    //   0	595	1	paramfa	fa
    //   443	145	2	i	int
    //   438	154	3	j	int
    //   440	39	4	k	int
    //   25	543	5	localObject1	Object
    //   572	1	5	localIOException1	java.io.IOException
    //   5	199	6	localObject2	Object
    //   251	6	6	localIOException2	java.io.IOException
    //   275	6	6	localObject3	Object
    //   368	207	6	localObject4	Object
    //   14	538	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   213	20	8	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   27	118	251	java/io/IOException
    //   118	161	251	java/io/IOException
    //   161	193	251	java/io/IOException
    //   193	248	251	java/io/IOException
    //   290	340	251	java/io/IOException
    //   343	361	251	java/io/IOException
    //   364	391	251	java/io/IOException
    //   391	419	251	java/io/IOException
    //   422	437	251	java/io/IOException
    //   444	474	251	java/io/IOException
    //   481	490	251	java/io/IOException
    //   490	505	251	java/io/IOException
    //   512	531	251	java/io/IOException
    //   538	559	251	java/io/IOException
    //   260	275	275	finally
    //   7	27	565	finally
    //   7	27	572	java/io/IOException
    //   27	118	580	finally
    //   118	161	580	finally
    //   161	193	580	finally
    //   193	248	580	finally
    //   290	340	580	finally
    //   343	361	580	finally
    //   364	391	580	finally
    //   391	419	580	finally
    //   422	437	580	finally
    //   444	474	580	finally
    //   481	490	580	finally
    //   490	505	580	finally
    //   512	531	580	finally
    //   538	559	580	finally
  }
  
  public ez(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  private double a(double paramDouble)
  {
    return Math.round(paramDouble * 1000.0D) / 1000.0D;
  }
  
  public byte[] a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */