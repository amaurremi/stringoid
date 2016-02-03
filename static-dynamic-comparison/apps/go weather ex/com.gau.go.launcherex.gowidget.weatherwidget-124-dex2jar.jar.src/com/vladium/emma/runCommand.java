package com.vladium.emma;

public final class runCommand
  extends Command
{
  private static final boolean DEFAULT_TO_SYSTEM_CLASSPATH = false;
  private String[] m_appArgs;
  private String[] m_classpath;
  private boolean m_dumpRawData;
  private String[] m_ixpath;
  private boolean m_jarMode;
  private Boolean m_outDataMerge;
  private String m_outFileName;
  private String[] m_reportTypes;
  private boolean m_scanCoveragePath;
  private String[] m_srcpath;
  
  protected runCommand(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString);
  }
  
  /* Error */
  private static String openJarFile(java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 31	java/util/jar/JarFile
    //   7: dup
    //   8: aload_0
    //   9: iconst_0
    //   10: invokespecial 34	java/util/jar/JarFile:<init>	(Ljava/io/File;Z)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 38	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +17 -> 37
    //   23: aload_1
    //   24: astore_0
    //   25: aload_2
    //   26: ifnull +9 -> 35
    //   29: aload_2
    //   30: invokevirtual 42	java/util/jar/JarFile:close	()V
    //   33: aload_1
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 48	java/util/jar/Manifest:getMainAttributes	()Ljava/util/jar/Attributes;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull +18 -> 61
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: ifnull -14 -> 35
    //   52: aload_2
    //   53: invokevirtual 42	java/util/jar/JarFile:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: getstatic 54	java/util/jar/Attributes$Name:MAIN_CLASS	Ljava/util/jar/Attributes$Name;
    //   65: invokevirtual 60	java/util/jar/Attributes:getValue	(Ljava/util/jar/Attributes$Name;)Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: ifnull -37 -> 35
    //   75: aload_2
    //   76: invokevirtual 42	java/util/jar/JarFile:close	()V
    //   79: aload_1
    //   80: areturn
    //   81: astore_0
    //   82: aload_1
    //   83: areturn
    //   84: astore_0
    //   85: aload_3
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 42	java/util/jar/JarFile:close	()V
    //   95: aload_0
    //   96: athrow
    //   97: astore_0
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: goto -6 -> 95
    //   104: astore_0
    //   105: aload_2
    //   106: astore_1
    //   107: goto -20 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramFile	java.io.File
    //   1	91	1	localObject1	Object
    //   100	1	1	localIOException	java.io.IOException
    //   106	1	1	localObject2	Object
    //   13	93	2	localJarFile	java.util.jar.JarFile
    //   3	83	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	58	java/io/IOException
    //   75	79	81	java/io/IOException
    //   4	14	84	finally
    //   29	33	97	java/io/IOException
    //   91	95	100	java/io/IOException
    //   14	19	104	finally
    //   37	42	104	finally
    //   61	69	104	finally
  }
  
  protected void initialize()
  {
    super.initialize();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 75	com/vladium/util/ClassLoaderResolver:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_2
    //   6: aload_0
    //   7: aload_2
    //   8: invokevirtual 79	com/vladium/emma/runCommand:getOptParser	(Ljava/lang/ClassLoader;)Lcom/vladium/util/args/IOptsParser;
    //   11: astore 4
    //   13: aload 4
    //   15: aload_0
    //   16: getfield 82	com/vladium/emma/runCommand:m_args	[Ljava/lang/String;
    //   19: invokeinterface 88 2 0
    //   24: astore 5
    //   26: aload 5
    //   28: invokeinterface 94 1 0
    //   33: istore_1
    //   34: iload_1
    //   35: ifle +26 -> 61
    //   38: aload_0
    //   39: aload 4
    //   41: iload_1
    //   42: aconst_null
    //   43: invokevirtual 98	com/vladium/emma/runCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_0
    //   51: invokevirtual 104	java/lang/Object:getClass	()Ljava/lang/Class;
    //   54: invokevirtual 107	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   57: astore_2
    //   58: goto -52 -> 6
    //   61: aload 5
    //   63: invokeinterface 111 1 0
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +47 -> 119
    //   75: aload 5
    //   77: aload_0
    //   78: getfield 115	com/vladium/emma/runCommand:m_out	Ljava/io/PrintWriter;
    //   81: bipush 80
    //   83: invokeinterface 119 3 0
    //   88: aload_0
    //   89: aload 4
    //   91: iconst_1
    //   92: aconst_null
    //   93: invokevirtual 98	com/vladium/emma/runCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   96: goto -50 -> 46
    //   99: astore_2
    //   100: aload_0
    //   101: iconst_1
    //   102: aload_2
    //   103: invokevirtual 123	com/vladium/emma/EMMARuntimeException:getMessage	()Ljava/lang/String;
    //   106: aload_2
    //   107: iconst_2
    //   108: invokevirtual 127	com/vladium/emma/runCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   111: goto -65 -> 46
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: aload 6
    //   124: arraylength
    //   125: if_icmpge +271 -> 396
    //   128: aload 6
    //   130: iload_1
    //   131: aaload
    //   132: astore_3
    //   133: aload_3
    //   134: invokeinterface 132 1 0
    //   139: astore 7
    //   141: aload_0
    //   142: aload_3
    //   143: invokevirtual 136	com/vladium/emma/runCommand:processOpt	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   146: ifne +625 -> 771
    //   149: ldc -118
    //   151: aload 7
    //   153: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifeq +18 -> 174
    //   159: aload_0
    //   160: aload_3
    //   161: getstatic 147	com/vladium/emma/runCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   164: iconst_1
    //   165: invokestatic 151	com/vladium/emma/runCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   168: putfield 153	com/vladium/emma/runCommand:m_classpath	[Ljava/lang/String;
    //   171: goto +600 -> 771
    //   174: ldc -101
    //   176: aload 7
    //   178: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +36 -> 217
    //   184: aload_0
    //   185: iconst_1
    //   186: putfield 157	com/vladium/emma/runCommand:m_jarMode	Z
    //   189: goto +582 -> 771
    //   192: astore_2
    //   193: new 69	com/vladium/emma/EMMARuntimeException
    //   196: dup
    //   197: ldc -97
    //   199: aload_2
    //   200: invokespecial 162	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: athrow
    //   204: astore_2
    //   205: aload_0
    //   206: iconst_1
    //   207: ldc -92
    //   209: aload_2
    //   210: iconst_2
    //   211: invokevirtual 127	com/vladium/emma/runCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   214: goto -168 -> 46
    //   217: ldc -90
    //   219: aload 7
    //   221: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +14 -> 238
    //   227: aload_0
    //   228: aload_3
    //   229: invokestatic 169	com/vladium/emma/runCommand:getOptionalBooleanOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   232: putfield 171	com/vladium/emma/runCommand:m_scanCoveragePath	Z
    //   235: goto +536 -> 771
    //   238: ldc -83
    //   240: aload 7
    //   242: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +18 -> 263
    //   248: aload_0
    //   249: aload_3
    //   250: getstatic 147	com/vladium/emma/runCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   253: iconst_1
    //   254: invokestatic 151	com/vladium/emma/runCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   257: putfield 175	com/vladium/emma/runCommand:m_srcpath	[Ljava/lang/String;
    //   260: goto +511 -> 771
    //   263: ldc -79
    //   265: aload 7
    //   267: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +14 -> 284
    //   273: aload_0
    //   274: aload_3
    //   275: invokestatic 169	com/vladium/emma/runCommand:getOptionalBooleanOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   278: putfield 179	com/vladium/emma/runCommand:m_dumpRawData	Z
    //   281: goto +490 -> 771
    //   284: ldc -75
    //   286: aload 7
    //   288: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq +16 -> 307
    //   294: aload_0
    //   295: aload_3
    //   296: invokeinterface 184 1 0
    //   301: putfield 186	com/vladium/emma/runCommand:m_outFileName	Ljava/lang/String;
    //   304: goto +467 -> 771
    //   307: ldc -68
    //   309: aload 7
    //   311: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifeq +29 -> 343
    //   317: aload_3
    //   318: invokestatic 169	com/vladium/emma/runCommand:getOptionalBooleanOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   321: ifeq +15 -> 336
    //   324: getstatic 193	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   327: astore_3
    //   328: aload_0
    //   329: aload_3
    //   330: putfield 195	com/vladium/emma/runCommand:m_outDataMerge	Ljava/lang/Boolean;
    //   333: goto +438 -> 771
    //   336: getstatic 198	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   339: astore_3
    //   340: goto -12 -> 328
    //   343: ldc -56
    //   345: aload 7
    //   347: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   350: ifeq +22 -> 372
    //   353: aload_0
    //   354: aload_3
    //   355: invokeinterface 204 1 0
    //   360: ldc -50
    //   362: iconst_1
    //   363: invokestatic 211	com/vladium/util/Strings:merge	([Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/String;
    //   366: putfield 213	com/vladium/emma/runCommand:m_reportTypes	[Ljava/lang/String;
    //   369: goto +402 -> 771
    //   372: ldc -41
    //   374: aload 7
    //   376: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   379: ifeq +392 -> 771
    //   382: aload_0
    //   383: aload_3
    //   384: ldc -50
    //   386: iconst_1
    //   387: invokestatic 151	com/vladium/emma/runCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   390: putfield 217	com/vladium/emma/runCommand:m_ixpath	[Ljava/lang/String;
    //   393: goto +378 -> 771
    //   396: aload_0
    //   397: invokevirtual 221	com/vladium/emma/runCommand:processFilePropertyOverrides	()Z
    //   400: ifeq -354 -> 46
    //   403: aload_0
    //   404: aload 5
    //   406: invokevirtual 225	com/vladium/emma/runCommand:processCmdPropertyOverrides	(Lcom/vladium/util/args/IOptsParser$IOpts;)V
    //   409: aload 5
    //   411: invokeinterface 228 1 0
    //   416: astore_3
    //   417: aload_0
    //   418: getfield 157	com/vladium/emma/runCommand:m_jarMode	Z
    //   421: ifeq +165 -> 586
    //   424: aload_3
    //   425: ifnull +8 -> 433
    //   428: aload_3
    //   429: arraylength
    //   430: ifne +15 -> 445
    //   433: aload_0
    //   434: aload 4
    //   436: iconst_1
    //   437: ldc -26
    //   439: invokevirtual 98	com/vladium/emma/runCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   442: goto -396 -> 46
    //   445: new 232	java/io/File
    //   448: dup
    //   449: aload_3
    //   450: iconst_0
    //   451: aaload
    //   452: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   455: astore 5
    //   457: aload 5
    //   459: invokestatic 237	com/vladium/emma/runCommand:openJarFile	(Ljava/io/File;)Ljava/lang/String;
    //   462: astore 6
    //   464: aload 6
    //   466: ifnonnull +53 -> 519
    //   469: aload_0
    //   470: iconst_1
    //   471: new 239	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   478: ldc -13
    //   480: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 5
    //   485: invokevirtual 250	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   488: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc -4
    //   493: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: aconst_null
    //   500: iconst_2
    //   501: invokevirtual 127	com/vladium/emma/runCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   504: goto -458 -> 46
    //   507: astore_2
    //   508: new 69	com/vladium/emma/EMMARuntimeException
    //   511: dup
    //   512: ldc -97
    //   514: aload_2
    //   515: invokespecial 162	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: athrow
    //   519: aload_0
    //   520: aload_3
    //   521: arraylength
    //   522: anewarray 140	java/lang/String
    //   525: putfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   528: aload_3
    //   529: iconst_1
    //   530: aload_0
    //   531: getfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   534: iconst_1
    //   535: aload_3
    //   536: arraylength
    //   537: iconst_1
    //   538: isub
    //   539: invokestatic 263	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   542: aload_0
    //   543: getfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   546: iconst_0
    //   547: aload 6
    //   549: aastore
    //   550: aload_0
    //   551: iconst_1
    //   552: anewarray 140	java/lang/String
    //   555: dup
    //   556: iconst_0
    //   557: aload 5
    //   559: invokevirtual 266	java/io/File:getPath	()Ljava/lang/String;
    //   562: aastore
    //   563: putfield 153	com/vladium/emma/runCommand:m_classpath	[Ljava/lang/String;
    //   566: aload_0
    //   567: getfield 153	com/vladium/emma/runCommand:m_classpath	[Ljava/lang/String;
    //   570: ifnonnull +46 -> 616
    //   573: aload_0
    //   574: aload 4
    //   576: iconst_1
    //   577: ldc_w 268
    //   580: invokevirtual 98	com/vladium/emma/runCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   583: goto -537 -> 46
    //   586: aload_3
    //   587: ifnull +8 -> 595
    //   590: aload_3
    //   591: arraylength
    //   592: ifne +16 -> 608
    //   595: aload_0
    //   596: aload 4
    //   598: iconst_1
    //   599: ldc_w 270
    //   602: invokevirtual 98	com/vladium/emma/runCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   605: goto -559 -> 46
    //   608: aload_0
    //   609: aload_3
    //   610: putfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   613: goto -47 -> 566
    //   616: aload_0
    //   617: getfield 213	com/vladium/emma/runCommand:m_reportTypes	[Ljava/lang/String;
    //   620: ifnonnull +17 -> 637
    //   623: aload_0
    //   624: iconst_1
    //   625: anewarray 140	java/lang/String
    //   628: dup
    //   629: iconst_0
    //   630: ldc_w 272
    //   633: aastore
    //   634: putfield 213	com/vladium/emma/runCommand:m_reportTypes	[Ljava/lang/String;
    //   637: aload_0
    //   638: getfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   641: arraylength
    //   642: iconst_1
    //   643: isub
    //   644: anewarray 140	java/lang/String
    //   647: astore_3
    //   648: aload_0
    //   649: getfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   652: iconst_1
    //   653: aload_3
    //   654: iconst_0
    //   655: aload_3
    //   656: arraylength
    //   657: invokestatic 263	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   660: aload_2
    //   661: invokestatic 278	com/vladium/emma/rt/AppRunner:create	(Ljava/lang/ClassLoader;)Lcom/vladium/emma/rt/AppRunner;
    //   664: astore_2
    //   665: aload_2
    //   666: ldc_w 280
    //   669: invokevirtual 283	com/vladium/emma/rt/AppRunner:setAppName	(Ljava/lang/String;)V
    //   672: aload_2
    //   673: aload_0
    //   674: getfield 257	com/vladium/emma/runCommand:m_appArgs	[Ljava/lang/String;
    //   677: iconst_0
    //   678: aaload
    //   679: aload_3
    //   680: invokevirtual 286	com/vladium/emma/rt/AppRunner:setAppClass	(Ljava/lang/String;[Ljava/lang/String;)V
    //   683: aload_2
    //   684: aload_0
    //   685: getfield 153	com/vladium/emma/runCommand:m_classpath	[Ljava/lang/String;
    //   688: iconst_1
    //   689: invokevirtual 290	com/vladium/emma/rt/AppRunner:setCoveragePath	([Ljava/lang/String;Z)V
    //   692: aload_2
    //   693: aload_0
    //   694: getfield 171	com/vladium/emma/runCommand:m_scanCoveragePath	Z
    //   697: invokevirtual 294	com/vladium/emma/rt/AppRunner:setScanCoveragePath	(Z)V
    //   700: aload_2
    //   701: aload_0
    //   702: getfield 175	com/vladium/emma/runCommand:m_srcpath	[Ljava/lang/String;
    //   705: invokevirtual 298	com/vladium/emma/rt/AppRunner:setSourcePath	([Ljava/lang/String;)V
    //   708: aload_2
    //   709: aload_0
    //   710: getfield 217	com/vladium/emma/runCommand:m_ixpath	[Ljava/lang/String;
    //   713: invokevirtual 301	com/vladium/emma/rt/AppRunner:setInclExclFilter	([Ljava/lang/String;)V
    //   716: aload_2
    //   717: aload_0
    //   718: getfield 179	com/vladium/emma/runCommand:m_dumpRawData	Z
    //   721: invokevirtual 304	com/vladium/emma/rt/AppRunner:setDumpSessionData	(Z)V
    //   724: aload_2
    //   725: aload_0
    //   726: getfield 186	com/vladium/emma/runCommand:m_outFileName	Ljava/lang/String;
    //   729: invokevirtual 307	com/vladium/emma/rt/AppRunner:setSessionOutFile	(Ljava/lang/String;)V
    //   732: aload_2
    //   733: aload_0
    //   734: getfield 195	com/vladium/emma/runCommand:m_outDataMerge	Ljava/lang/Boolean;
    //   737: invokevirtual 311	com/vladium/emma/rt/AppRunner:setSessionOutMerge	(Ljava/lang/Boolean;)V
    //   740: aload_2
    //   741: aload_0
    //   742: getfield 213	com/vladium/emma/runCommand:m_reportTypes	[Ljava/lang/String;
    //   745: invokevirtual 314	com/vladium/emma/rt/AppRunner:setReportTypes	([Ljava/lang/String;)V
    //   748: aload_2
    //   749: aload_0
    //   750: getfield 318	com/vladium/emma/runCommand:m_propertyOverrides	Ljava/util/Properties;
    //   753: invokevirtual 322	com/vladium/emma/rt/AppRunner:setPropertyOverrides	(Ljava/util/Properties;)V
    //   756: aload_2
    //   757: invokevirtual 324	com/vladium/emma/rt/AppRunner:run	()V
    //   760: aload_0
    //   761: iconst_0
    //   762: aconst_null
    //   763: aconst_null
    //   764: iconst_0
    //   765: invokevirtual 127	com/vladium/emma/runCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   768: goto -722 -> 46
    //   771: iload_1
    //   772: iconst_1
    //   773: iadd
    //   774: istore_1
    //   775: goto -654 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	this	runCommand
    //   33	742	1	i	int
    //   5	3	2	localClassLoader1	ClassLoader
    //   49	1	2	localThrowable1	Throwable
    //   57	1	2	localClassLoader2	ClassLoader
    //   99	8	2	localEMMARuntimeException	EMMARuntimeException
    //   114	4	2	localObject1	Object
    //   192	8	2	localIOException1	java.io.IOException
    //   204	6	2	localThrowable2	Throwable
    //   507	154	2	localIOException2	java.io.IOException
    //   664	93	2	localAppRunner	com.vladium.emma.rt.AppRunner
    //   132	548	3	localObject2	Object
    //   11	586	4	localIOptsParser	com.vladium.util.args.IOptsParser
    //   24	534	5	localObject3	Object
    //   68	480	6	localObject4	Object
    //   139	236	7	str	String
    // Exception table:
    //   from	to	target	type
    //   2	6	49	java/lang/Throwable
    //   6	34	99	com/vladium/emma/EMMARuntimeException
    //   38	46	99	com/vladium/emma/EMMARuntimeException
    //   61	70	99	com/vladium/emma/EMMARuntimeException
    //   75	96	99	com/vladium/emma/EMMARuntimeException
    //   121	128	99	com/vladium/emma/EMMARuntimeException
    //   133	171	99	com/vladium/emma/EMMARuntimeException
    //   174	189	99	com/vladium/emma/EMMARuntimeException
    //   193	204	99	com/vladium/emma/EMMARuntimeException
    //   217	235	99	com/vladium/emma/EMMARuntimeException
    //   238	260	99	com/vladium/emma/EMMARuntimeException
    //   263	281	99	com/vladium/emma/EMMARuntimeException
    //   284	304	99	com/vladium/emma/EMMARuntimeException
    //   307	328	99	com/vladium/emma/EMMARuntimeException
    //   328	333	99	com/vladium/emma/EMMARuntimeException
    //   336	340	99	com/vladium/emma/EMMARuntimeException
    //   343	369	99	com/vladium/emma/EMMARuntimeException
    //   372	393	99	com/vladium/emma/EMMARuntimeException
    //   396	409	99	com/vladium/emma/EMMARuntimeException
    //   409	424	99	com/vladium/emma/EMMARuntimeException
    //   428	433	99	com/vladium/emma/EMMARuntimeException
    //   433	442	99	com/vladium/emma/EMMARuntimeException
    //   445	457	99	com/vladium/emma/EMMARuntimeException
    //   457	464	99	com/vladium/emma/EMMARuntimeException
    //   469	504	99	com/vladium/emma/EMMARuntimeException
    //   508	519	99	com/vladium/emma/EMMARuntimeException
    //   519	566	99	com/vladium/emma/EMMARuntimeException
    //   566	583	99	com/vladium/emma/EMMARuntimeException
    //   590	595	99	com/vladium/emma/EMMARuntimeException
    //   595	605	99	com/vladium/emma/EMMARuntimeException
    //   608	613	99	com/vladium/emma/EMMARuntimeException
    //   616	637	99	com/vladium/emma/EMMARuntimeException
    //   637	760	99	com/vladium/emma/EMMARuntimeException
    //   2	6	114	finally
    //   6	34	114	finally
    //   38	46	114	finally
    //   50	58	114	finally
    //   61	70	114	finally
    //   75	96	114	finally
    //   100	111	114	finally
    //   121	128	114	finally
    //   133	171	114	finally
    //   174	189	114	finally
    //   193	204	114	finally
    //   205	214	114	finally
    //   217	235	114	finally
    //   238	260	114	finally
    //   263	281	114	finally
    //   284	304	114	finally
    //   307	328	114	finally
    //   328	333	114	finally
    //   336	340	114	finally
    //   343	369	114	finally
    //   372	393	114	finally
    //   396	409	114	finally
    //   409	424	114	finally
    //   428	433	114	finally
    //   433	442	114	finally
    //   445	457	114	finally
    //   457	464	114	finally
    //   469	504	114	finally
    //   508	519	114	finally
    //   519	566	114	finally
    //   566	583	114	finally
    //   590	595	114	finally
    //   595	605	114	finally
    //   608	613	114	finally
    //   616	637	114	finally
    //   637	760	114	finally
    //   760	768	114	finally
    //   121	128	192	java/io/IOException
    //   133	171	192	java/io/IOException
    //   174	189	192	java/io/IOException
    //   217	235	192	java/io/IOException
    //   238	260	192	java/io/IOException
    //   263	281	192	java/io/IOException
    //   284	304	192	java/io/IOException
    //   307	328	192	java/io/IOException
    //   328	333	192	java/io/IOException
    //   336	340	192	java/io/IOException
    //   343	369	192	java/io/IOException
    //   372	393	192	java/io/IOException
    //   396	409	192	java/io/IOException
    //   6	34	204	java/lang/Throwable
    //   38	46	204	java/lang/Throwable
    //   61	70	204	java/lang/Throwable
    //   75	96	204	java/lang/Throwable
    //   121	128	204	java/lang/Throwable
    //   133	171	204	java/lang/Throwable
    //   174	189	204	java/lang/Throwable
    //   193	204	204	java/lang/Throwable
    //   217	235	204	java/lang/Throwable
    //   238	260	204	java/lang/Throwable
    //   263	281	204	java/lang/Throwable
    //   284	304	204	java/lang/Throwable
    //   307	328	204	java/lang/Throwable
    //   328	333	204	java/lang/Throwable
    //   336	340	204	java/lang/Throwable
    //   343	369	204	java/lang/Throwable
    //   372	393	204	java/lang/Throwable
    //   396	409	204	java/lang/Throwable
    //   409	424	204	java/lang/Throwable
    //   428	433	204	java/lang/Throwable
    //   433	442	204	java/lang/Throwable
    //   445	457	204	java/lang/Throwable
    //   457	464	204	java/lang/Throwable
    //   469	504	204	java/lang/Throwable
    //   508	519	204	java/lang/Throwable
    //   519	566	204	java/lang/Throwable
    //   566	583	204	java/lang/Throwable
    //   590	595	204	java/lang/Throwable
    //   595	605	204	java/lang/Throwable
    //   608	613	204	java/lang/Throwable
    //   616	637	204	java/lang/Throwable
    //   637	760	204	java/lang/Throwable
    //   457	464	507	java/io/IOException
  }
  
  protected String usageArgsMsg()
  {
    return "[options] class [args...] | -jar [options] jarfile [args...]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/runCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */