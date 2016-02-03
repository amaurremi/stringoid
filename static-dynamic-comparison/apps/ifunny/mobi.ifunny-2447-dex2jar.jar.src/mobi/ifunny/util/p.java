package mobi.ifunny.util;

public class p {
    /* Error */
    public static int a(String paramString1, String paramString2, float paramFloat, android.graphics.Rect paramRect, int[] paramArrayOfInt, int paramInt, q paramq) {
        // Byte code:
        //   0: new 12	mobi/ifunny/video/GifVideo
        //   3: dup
        //   4: aload_0
        //   5: aload_3
        //   6: invokespecial 16	mobi/ifunny/video/GifVideo:<init>	(Ljava/lang/String;Landroid/graphics/Rect;)V
        //   9: astore_3
        //   10: aload_3
        //   11: invokevirtual 20	mobi/ifunny/video/GifVideo:openFile	()Z
        //   14: istore 10
        //   16: iload 10
        //   18: ifne +14 -> 32
        //   21: ldc 21
        //   23: istore 5
        //   25: iload 5
        //   27: ireturn
        //   28: astore_0
        //   29: ldc 22
        //   31: ireturn
        //   32: aload_3
        //   33: astore_0
        //   34: aload_3
        //   35: invokevirtual 26	mobi/ifunny/video/GifVideo:allocBuffer	()[I
        //   38: astore 13
        //   40: aload_3
        //   41: astore_0
        //   42: aload_3
        //   43: invokevirtual 30	mobi/ifunny/video/GifVideo:getWidth	()I
        //   46: istore 8
        //   48: aload_3
        //   49: astore_0
        //   50: aload_3
        //   51: invokevirtual 33	mobi/ifunny/video/GifVideo:getHeight	()I
        //   54: istore 9
        //   56: aload_3
        //   57: astore_0
        //   58: aload_3
        //   59: invokevirtual 36	mobi/ifunny/video/GifVideo:getFrameCount	()I
        //   62: istore 7
        //   64: aload_3
        //   65: astore_0
        //   66: new 38	mobi/ifunny/video/encode/GifEncoder
        //   69: dup
        //   70: aload_1
        //   71: iload 8
        //   73: iload 9
        //   75: iload 5
        //   77: iadd
        //   78: bipush 70
        //   80: invokespecial 41	mobi/ifunny/video/encode/GifEncoder:<init>	(Ljava/lang/String;III)V
        //   83: astore_1
        //   84: aload 6
        //   86: ifnull +12 -> 98
        //   89: aload_3
        //   90: astore_0
        //   91: aload 6
        //   93: invokeinterface 46 1 0
        //   98: aload_3
        //   99: astore_0
        //   100: aload_1
        //   101: fload_2
        //   102: invokevirtual 49	mobi/ifunny/video/encode/GifEncoder:a	(F)V
        //   105: iconst_1
        //   106: istore 5
        //   108: aload_3
        //   109: astore_0
        //   110: aload_3
        //   111: invokevirtual 52	mobi/ifunny/video/GifVideo:readFrame	()Z
        //   114: ifeq +121 -> 235
        //   117: aload_3
        //   118: astore_0
        //   119: aload_3
        //   120: lconst_0
        //   121: invokevirtual 56	mobi/ifunny/video/GifVideo:decodeCurrentFrame	(J)Z
        //   124: pop
        //   125: aload_3
        //   126: astore_0
        //   127: aload_3
        //   128: aload 13
        //   130: invokevirtual 60	mobi/ifunny/video/GifVideo:getBuffer	([I)Z
        //   133: pop
        //   134: aload_3
        //   135: astore_0
        //   136: aload_3
        //   137: invokevirtual 63	mobi/ifunny/video/GifVideo:getCurrentFrameColorsCount	()I
        //   140: istore 8
        //   142: aload_3
        //   143: astore_0
        //   144: aload_3
        //   145: invokevirtual 67	mobi/ifunny/video/GifVideo:getCurrentFrameDuration	()J
        //   148: lstore 11
        //   150: aload_3
        //   151: astore_0
        //   152: aload_1
        //   153: iload 8
        //   155: invokevirtual 70	mobi/ifunny/video/encode/GifEncoder:a	(I)V
        //   158: aload_3
        //   159: astore_0
        //   160: aload_1
        //   161: lload 11
        //   163: invokevirtual 73	mobi/ifunny/video/encode/GifEncoder:a	(J)V
        //   166: aload_3
        //   167: astore_0
        //   168: aload_1
        //   169: aload 4
        //   171: aload 13
        //   173: invokevirtual 76	mobi/ifunny/video/encode/GifEncoder:a	([I[I)V
        //   176: aload 6
        //   178: ifnull +16 -> 194
        //   181: aload_3
        //   182: astore_0
        //   183: aload 6
        //   185: iload 5
        //   187: iload 7
        //   189: invokeinterface 79 3 0
        //   194: iload 5
        //   196: iconst_1
        //   197: iadd
        //   198: istore 5
        //   200: goto -92 -> 108
        //   203: astore_0
        //   204: ldc 80
        //   206: istore 5
        //   208: aload_3
        //   209: ifnull -184 -> 25
        //   212: aload_3
        //   213: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   216: ldc 80
        //   218: ireturn
        //   219: astore_0
        //   220: ldc 84
        //   222: istore 5
        //   224: aload_3
        //   225: ifnull -200 -> 25
        //   228: aload_3
        //   229: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   232: ldc 84
        //   234: ireturn
        //   235: aload_3
        //   236: astore_0
        //   237: aload_3
        //   238: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   241: aload_1
        //   242: iconst_1
        //   243: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   246: iconst_0
        //   247: ifeq +11 -> 258
        //   250: new 89	java/lang/NullPointerException
        //   253: dup
        //   254: invokespecial 91	java/lang/NullPointerException:<init>	()V
        //   257: athrow
        //   258: iconst_m1
        //   259: ireturn
        //   260: astore_0
        //   261: aload_3
        //   262: astore_0
        //   263: aload_1
        //   264: iconst_0
        //   265: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   268: ldc 80
        //   270: istore 5
        //   272: aload_3
        //   273: ifnull -248 -> 25
        //   276: aload_3
        //   277: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   280: ldc 80
        //   282: ireturn
        //   283: astore_0
        //   284: aload_3
        //   285: astore_0
        //   286: aload_1
        //   287: iconst_0
        //   288: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   291: ldc 21
        //   293: istore 5
        //   295: aload_3
        //   296: ifnull -271 -> 25
        //   299: aload_3
        //   300: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   303: ldc 21
        //   305: ireturn
        //   306: astore_1
        //   307: aload_0
        //   308: ifnull +7 -> 315
        //   311: aload_0
        //   312: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   315: aload_1
        //   316: athrow
        //   317: astore_1
        //   318: aconst_null
        //   319: astore_0
        //   320: goto -13 -> 307
        //   323: astore_0
        //   324: aconst_null
        //   325: astore_3
        //   326: goto -42 -> 284
        //   329: astore_0
        //   330: aconst_null
        //   331: astore_3
        //   332: goto -71 -> 261
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	335	0	paramString1	String
        //   0	335	1	paramString2	String
        //   0	335	2	paramFloat	float
        //   0	335	3	paramRect	android.graphics.Rect
        //   0	335	4	paramArrayOfInt	int[]
        //   0	335	5	paramInt	int
        //   0	335	6	paramq	q
        //   62	126	7	i	int
        //   46	108	8	j	int
        //   54	24	9	k	int
        //   14	3	10	bool	boolean
        //   148	14	11	l	long
        //   38	134	13	arrayOfInt	int[]
        // Exception table:
        //   from	to	target	type
        //   0	16	28	java/lang/UnsatisfiedLinkError
        //   66	84	203	java/lang/UnsatisfiedLinkError
        //   66	84	219	java/lang/Exception
        //   100	105	260	java/lang/UnsatisfiedLinkError
        //   110	117	260	java/lang/UnsatisfiedLinkError
        //   119	125	260	java/lang/UnsatisfiedLinkError
        //   127	134	260	java/lang/UnsatisfiedLinkError
        //   136	142	260	java/lang/UnsatisfiedLinkError
        //   144	150	260	java/lang/UnsatisfiedLinkError
        //   152	158	260	java/lang/UnsatisfiedLinkError
        //   160	166	260	java/lang/UnsatisfiedLinkError
        //   168	176	260	java/lang/UnsatisfiedLinkError
        //   183	194	260	java/lang/UnsatisfiedLinkError
        //   237	241	260	java/lang/UnsatisfiedLinkError
        //   100	105	283	java/lang/Exception
        //   110	117	283	java/lang/Exception
        //   119	125	283	java/lang/Exception
        //   127	134	283	java/lang/Exception
        //   136	142	283	java/lang/Exception
        //   144	150	283	java/lang/Exception
        //   152	158	283	java/lang/Exception
        //   160	166	283	java/lang/Exception
        //   168	176	283	java/lang/Exception
        //   183	194	283	java/lang/Exception
        //   237	241	283	java/lang/Exception
        //   34	40	306	finally
        //   42	48	306	finally
        //   50	56	306	finally
        //   58	64	306	finally
        //   66	84	306	finally
        //   91	98	306	finally
        //   100	105	306	finally
        //   110	117	306	finally
        //   119	125	306	finally
        //   127	134	306	finally
        //   136	142	306	finally
        //   144	150	306	finally
        //   152	158	306	finally
        //   160	166	306	finally
        //   168	176	306	finally
        //   183	194	306	finally
        //   237	241	306	finally
        //   263	268	306	finally
        //   286	291	306	finally
        //   241	246	317	finally
        //   241	246	323	java/lang/Exception
        //   241	246	329	java/lang/UnsatisfiedLinkError
    }

    /* Error */
    public static int a(String paramString1, String paramString2, android.graphics.Rect paramRect, q paramq) {
        // Byte code:
        //   0: ldc 21
        //   2: istore 5
        //   4: iconst_1
        //   5: istore 6
        //   7: new 12	mobi/ifunny/video/GifVideo
        //   10: dup
        //   11: aload_0
        //   12: aload_2
        //   13: invokespecial 16	mobi/ifunny/video/GifVideo:<init>	(Ljava/lang/String;Landroid/graphics/Rect;)V
        //   16: astore_2
        //   17: aload_2
        //   18: invokevirtual 20	mobi/ifunny/video/GifVideo:openFile	()Z
        //   21: istore 9
        //   23: iload 9
        //   25: ifne +14 -> 39
        //   28: iload 5
        //   30: istore 4
        //   32: iload 4
        //   34: ireturn
        //   35: astore_0
        //   36: ldc 22
        //   38: ireturn
        //   39: aload_2
        //   40: astore_0
        //   41: aload_2
        //   42: invokevirtual 26	mobi/ifunny/video/GifVideo:allocBuffer	()[I
        //   45: astore 13
        //   47: aload_2
        //   48: astore_0
        //   49: aload_2
        //   50: invokevirtual 30	mobi/ifunny/video/GifVideo:getWidth	()I
        //   53: istore 4
        //   55: aload_2
        //   56: astore_0
        //   57: aload_2
        //   58: invokevirtual 33	mobi/ifunny/video/GifVideo:getHeight	()I
        //   61: istore 8
        //   63: aload_2
        //   64: astore_0
        //   65: aload_2
        //   66: invokevirtual 36	mobi/ifunny/video/GifVideo:getFrameCount	()I
        //   69: istore 7
        //   71: aload_2
        //   72: astore_0
        //   73: new 38	mobi/ifunny/video/encode/GifEncoder
        //   76: dup
        //   77: aload_1
        //   78: iload 4
        //   80: iload 8
        //   82: bipush 70
        //   84: invokespecial 41	mobi/ifunny/video/encode/GifEncoder:<init>	(Ljava/lang/String;III)V
        //   87: astore 12
        //   89: iload 6
        //   91: istore 4
        //   93: aload_3
        //   94: ifnull +15 -> 109
        //   97: aload_2
        //   98: astore_0
        //   99: aload_3
        //   100: invokeinterface 46 1 0
        //   105: iload 6
        //   107: istore 4
        //   109: aload_2
        //   110: astore_1
        //   111: aload_2
        //   112: astore_0
        //   113: aload_2
        //   114: invokevirtual 52	mobi/ifunny/video/GifVideo:readFrame	()Z
        //   117: ifeq +132 -> 249
        //   120: aload_2
        //   121: astore_1
        //   122: aload_2
        //   123: astore_0
        //   124: aload_2
        //   125: lconst_0
        //   126: invokevirtual 56	mobi/ifunny/video/GifVideo:decodeCurrentFrame	(J)Z
        //   129: pop
        //   130: aload_2
        //   131: astore_1
        //   132: aload_2
        //   133: astore_0
        //   134: aload_2
        //   135: aload 13
        //   137: invokevirtual 60	mobi/ifunny/video/GifVideo:getBuffer	([I)Z
        //   140: pop
        //   141: aload_2
        //   142: astore_1
        //   143: aload_2
        //   144: astore_0
        //   145: aload_2
        //   146: invokevirtual 63	mobi/ifunny/video/GifVideo:getCurrentFrameColorsCount	()I
        //   149: istore 6
        //   151: aload_2
        //   152: astore_1
        //   153: aload_2
        //   154: astore_0
        //   155: aload_2
        //   156: invokevirtual 67	mobi/ifunny/video/GifVideo:getCurrentFrameDuration	()J
        //   159: lstore 10
        //   161: aload_2
        //   162: astore_1
        //   163: aload_2
        //   164: astore_0
        //   165: aload 12
        //   167: iload 6
        //   169: invokevirtual 70	mobi/ifunny/video/encode/GifEncoder:a	(I)V
        //   172: aload_2
        //   173: astore_1
        //   174: aload_2
        //   175: astore_0
        //   176: aload 12
        //   178: lload 10
        //   180: invokevirtual 73	mobi/ifunny/video/encode/GifEncoder:a	(J)V
        //   183: aload_2
        //   184: astore_1
        //   185: aload_2
        //   186: astore_0
        //   187: aload 12
        //   189: aload 13
        //   191: invokevirtual 96	mobi/ifunny/video/encode/GifEncoder:a	([I)V
        //   194: aload_3
        //   195: ifnull +17 -> 212
        //   198: aload_2
        //   199: astore_1
        //   200: aload_2
        //   201: astore_0
        //   202: aload_3
        //   203: iload 4
        //   205: iload 7
        //   207: invokeinterface 79 3 0
        //   212: iload 4
        //   214: iconst_1
        //   215: iadd
        //   216: istore 4
        //   218: goto -109 -> 109
        //   221: astore_0
        //   222: aload_2
        //   223: ifnull +7 -> 230
        //   226: aload_2
        //   227: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   230: ldc 80
        //   232: ireturn
        //   233: astore_0
        //   234: ldc 84
        //   236: istore 4
        //   238: aload_2
        //   239: ifnull -207 -> 32
        //   242: aload_2
        //   243: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   246: ldc 84
        //   248: ireturn
        //   249: aload_2
        //   250: astore_1
        //   251: aload_2
        //   252: astore_0
        //   253: aload_2
        //   254: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   257: aconst_null
        //   258: astore_0
        //   259: aconst_null
        //   260: astore_1
        //   261: aload 12
        //   263: iconst_1
        //   264: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   267: iconst_0
        //   268: ifeq +11 -> 279
        //   271: new 89	java/lang/NullPointerException
        //   274: dup
        //   275: invokespecial 91	java/lang/NullPointerException:<init>	()V
        //   278: athrow
        //   279: iconst_m1
        //   280: ireturn
        //   281: astore_0
        //   282: aload_2
        //   283: astore_0
        //   284: aload 12
        //   286: iconst_0
        //   287: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   290: aload_0
        //   291: ifnull +7 -> 298
        //   294: aload_0
        //   295: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   298: ldc 80
        //   300: ireturn
        //   301: astore_0
        //   302: aload_1
        //   303: astore_0
        //   304: aload 12
        //   306: iconst_0
        //   307: invokevirtual 87	mobi/ifunny/video/encode/GifEncoder:a	(Z)V
        //   310: iload 5
        //   312: istore 4
        //   314: aload_1
        //   315: ifnull -283 -> 32
        //   318: aload_1
        //   319: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   322: ldc 21
        //   324: ireturn
        //   325: astore_1
        //   326: aload_0
        //   327: ifnull +7 -> 334
        //   330: aload_0
        //   331: invokevirtual 83	mobi/ifunny/video/GifVideo:destroyCodec	()V
        //   334: aload_1
        //   335: athrow
        //   336: astore_1
        //   337: goto -11 -> 326
        //   340: astore_0
        //   341: aconst_null
        //   342: astore_0
        //   343: goto -59 -> 284
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	346	0	paramString1	String
        //   0	346	1	paramString2	String
        //   0	346	2	paramRect	android.graphics.Rect
        //   0	346	3	paramq	q
        //   30	283	4	i	int
        //   2	309	5	j	int
        //   5	163	6	k	int
        //   69	137	7	m	int
        //   61	20	8	n	int
        //   21	3	9	bool	boolean
        //   159	20	10	l	long
        //   87	218	12	localGifEncoder	mobi.ifunny.video.encode.GifEncoder
        //   45	145	13	arrayOfInt	int[]
        // Exception table:
        //   from	to	target	type
        //   7	23	35	java/lang/UnsatisfiedLinkError
        //   73	89	221	java/lang/UnsatisfiedLinkError
        //   73	89	233	java/lang/Exception
        //   113	120	281	java/lang/UnsatisfiedLinkError
        //   124	130	281	java/lang/UnsatisfiedLinkError
        //   134	141	281	java/lang/UnsatisfiedLinkError
        //   145	151	281	java/lang/UnsatisfiedLinkError
        //   155	161	281	java/lang/UnsatisfiedLinkError
        //   165	172	281	java/lang/UnsatisfiedLinkError
        //   176	183	281	java/lang/UnsatisfiedLinkError
        //   187	194	281	java/lang/UnsatisfiedLinkError
        //   202	212	281	java/lang/UnsatisfiedLinkError
        //   253	257	281	java/lang/UnsatisfiedLinkError
        //   113	120	301	java/lang/Exception
        //   124	130	301	java/lang/Exception
        //   134	141	301	java/lang/Exception
        //   145	151	301	java/lang/Exception
        //   155	161	301	java/lang/Exception
        //   165	172	301	java/lang/Exception
        //   176	183	301	java/lang/Exception
        //   187	194	301	java/lang/Exception
        //   202	212	301	java/lang/Exception
        //   253	257	301	java/lang/Exception
        //   261	267	301	java/lang/Exception
        //   41	47	325	finally
        //   49	55	325	finally
        //   57	63	325	finally
        //   65	71	325	finally
        //   73	89	325	finally
        //   99	105	325	finally
        //   113	120	325	finally
        //   124	130	325	finally
        //   134	141	325	finally
        //   145	151	325	finally
        //   155	161	325	finally
        //   165	172	325	finally
        //   176	183	325	finally
        //   187	194	325	finally
        //   202	212	325	finally
        //   253	257	325	finally
        //   261	267	325	finally
        //   304	310	325	finally
        //   284	290	336	finally
        //   261	267	340	java/lang/UnsatisfiedLinkError
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */