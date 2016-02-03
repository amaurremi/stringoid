package com.vladium.emma.instr;

import com.vladium.emma.Command;

public final class instrCommand
  extends Command
{
  private String[] m_instrpath;
  private String[] m_ixpath;
  private Boolean m_outDataMerge;
  private String m_outDirName;
  private String m_outFileName;
  private InstrProcessor.OutMode m_outMode = InstrProcessor.OutMode.OUT_MODE_COPY;
  
  public instrCommand(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString);
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
    //   2: invokestatic 43	com/vladium/util/ClassLoaderResolver:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_3
    //   6: aload_0
    //   7: aload_3
    //   8: invokevirtual 47	com/vladium/emma/instr/instrCommand:getOptParser	(Ljava/lang/ClassLoader;)Lcom/vladium/util/args/IOptsParser;
    //   11: astore 4
    //   13: aload 4
    //   15: aload_0
    //   16: getfield 50	com/vladium/emma/instr/instrCommand:m_args	[Ljava/lang/String;
    //   19: invokeinterface 56 2 0
    //   24: astore 5
    //   26: aload 5
    //   28: invokeinterface 62 1 0
    //   33: istore_1
    //   34: iload_1
    //   35: ifle +26 -> 61
    //   38: aload_0
    //   39: aload 4
    //   41: iload_1
    //   42: aconst_null
    //   43: invokevirtual 66	com/vladium/emma/instr/instrCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_3
    //   50: aload_0
    //   51: invokevirtual 72	java/lang/Object:getClass	()Ljava/lang/Class;
    //   54: invokevirtual 75	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   57: astore_3
    //   58: goto -52 -> 6
    //   61: aload 5
    //   63: invokeinterface 79 1 0
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +47 -> 119
    //   75: aload 5
    //   77: aload_0
    //   78: getfield 83	com/vladium/emma/instr/instrCommand:m_out	Ljava/io/PrintWriter;
    //   81: bipush 80
    //   83: invokeinterface 87 3 0
    //   88: aload_0
    //   89: aload 4
    //   91: iconst_1
    //   92: aconst_null
    //   93: invokevirtual 66	com/vladium/emma/instr/instrCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   96: goto -50 -> 46
    //   99: astore_3
    //   100: aload_0
    //   101: iconst_1
    //   102: aload_3
    //   103: invokevirtual 91	com/vladium/emma/EMMARuntimeException:getMessage	()Ljava/lang/String;
    //   106: aload_3
    //   107: iconst_2
    //   108: invokevirtual 95	com/vladium/emma/instr/instrCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   111: goto -65 -> 46
    //   114: astore_3
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_3
    //   118: athrow
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: aload 6
    //   124: arraylength
    //   125: if_icmpge +263 -> 388
    //   128: aload 6
    //   130: iload_1
    //   131: aaload
    //   132: astore_3
    //   133: aload_3
    //   134: invokeinterface 100 1 0
    //   139: astore 7
    //   141: aload_0
    //   142: aload_3
    //   143: invokevirtual 104	com/vladium/emma/instr/instrCommand:processOpt	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   146: ifne +411 -> 557
    //   149: ldc 106
    //   151: aload 7
    //   153: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifeq +18 -> 174
    //   159: aload_0
    //   160: aload_3
    //   161: getstatic 115	com/vladium/emma/instr/instrCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   164: iconst_1
    //   165: invokestatic 119	com/vladium/emma/instr/instrCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   168: putfield 121	com/vladium/emma/instr/instrCommand:m_instrpath	[Ljava/lang/String;
    //   171: goto +386 -> 557
    //   174: ldc 123
    //   176: aload 7
    //   178: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +41 -> 222
    //   184: aload_0
    //   185: aload_3
    //   186: invokeinterface 126 1 0
    //   191: putfield 128	com/vladium/emma/instr/instrCommand:m_outDirName	Ljava/lang/String;
    //   194: goto +363 -> 557
    //   197: astore_3
    //   198: new 35	com/vladium/emma/EMMARuntimeException
    //   201: dup
    //   202: ldc -126
    //   204: aload_3
    //   205: invokespecial 133	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: athrow
    //   209: astore_3
    //   210: aload_0
    //   211: iconst_1
    //   212: ldc -121
    //   214: aload_3
    //   215: iconst_2
    //   216: invokevirtual 95	com/vladium/emma/instr/instrCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   219: goto -173 -> 46
    //   222: ldc -119
    //   224: aload 7
    //   226: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +16 -> 245
    //   232: aload_0
    //   233: aload_3
    //   234: invokeinterface 126 1 0
    //   239: putfield 139	com/vladium/emma/instr/instrCommand:m_outFileName	Ljava/lang/String;
    //   242: goto +315 -> 557
    //   245: ldc -115
    //   247: aload 7
    //   249: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: ifeq +29 -> 281
    //   255: aload_3
    //   256: invokestatic 144	com/vladium/emma/instr/instrCommand:getOptionalBooleanOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   259: ifeq +15 -> 274
    //   262: getstatic 149	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   265: astore_3
    //   266: aload_0
    //   267: aload_3
    //   268: putfield 151	com/vladium/emma/instr/instrCommand:m_outDataMerge	Ljava/lang/Boolean;
    //   271: goto +286 -> 557
    //   274: getstatic 154	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   277: astore_3
    //   278: goto -12 -> 266
    //   281: ldc -100
    //   283: aload 7
    //   285: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifeq +17 -> 305
    //   291: aload_0
    //   292: aload_3
    //   293: ldc -98
    //   295: iconst_1
    //   296: invokestatic 119	com/vladium/emma/instr/instrCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   299: putfield 160	com/vladium/emma/instr/instrCommand:m_ixpath	[Ljava/lang/String;
    //   302: goto +255 -> 557
    //   305: ldc -94
    //   307: aload 7
    //   309: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +245 -> 557
    //   315: aload_3
    //   316: invokeinterface 126 1 0
    //   321: astore_3
    //   322: aload_3
    //   323: invokestatic 166	com/vladium/emma/instr/InstrProcessor$OutMode:nameToMode	(Ljava/lang/String;)Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   326: astore 7
    //   328: aload 7
    //   330: ifnonnull +49 -> 379
    //   333: aload_0
    //   334: aload 4
    //   336: iconst_1
    //   337: new 168	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   344: ldc -84
    //   346: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 6
    //   351: iload_1
    //   352: aaload
    //   353: invokeinterface 179 1 0
    //   358: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc -75
    //   363: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_3
    //   367: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokevirtual 66	com/vladium/emma/instr/instrCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   376: goto -330 -> 46
    //   379: aload_0
    //   380: aload 7
    //   382: putfield 25	com/vladium/emma/instr/instrCommand:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   385: goto +172 -> 557
    //   388: aload_0
    //   389: invokevirtual 188	com/vladium/emma/instr/instrCommand:processFilePropertyOverrides	()Z
    //   392: ifeq -346 -> 46
    //   395: aload_0
    //   396: aload 5
    //   398: invokevirtual 192	com/vladium/emma/instr/instrCommand:processCmdPropertyOverrides	(Lcom/vladium/util/args/IOptsParser$IOpts;)V
    //   401: aload_0
    //   402: getfield 25	com/vladium/emma/instr/instrCommand:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   405: getstatic 195	com/vladium/emma/instr/InstrProcessor$OutMode:OUT_MODE_OVERWRITE	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   408: if_acmpeq +47 -> 455
    //   411: aload_0
    //   412: getfield 128	com/vladium/emma/instr/instrCommand:m_outDirName	Ljava/lang/String;
    //   415: ifnonnull +40 -> 455
    //   418: aload_0
    //   419: aload 4
    //   421: iconst_1
    //   422: new 168	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   429: ldc -59
    //   431: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 25	com/vladium/emma/instr/instrCommand:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   438: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: ldc -54
    //   443: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 66	com/vladium/emma/instr/instrCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   452: goto -406 -> 46
    //   455: invokestatic 208	com/vladium/emma/instr/InstrProcessor:create	()Lcom/vladium/emma/instr/InstrProcessor;
    //   458: astore_3
    //   459: aload_3
    //   460: ldc -46
    //   462: invokevirtual 214	com/vladium/emma/instr/InstrProcessor:setAppName	(Ljava/lang/String;)V
    //   465: aload_3
    //   466: aload_0
    //   467: getfield 121	com/vladium/emma/instr/instrCommand:m_instrpath	[Ljava/lang/String;
    //   470: iconst_1
    //   471: invokevirtual 218	com/vladium/emma/instr/InstrProcessor:setInstrPath	([Ljava/lang/String;Z)V
    //   474: aload_3
    //   475: aload_0
    //   476: getfield 160	com/vladium/emma/instr/instrCommand:m_ixpath	[Ljava/lang/String;
    //   479: invokevirtual 222	com/vladium/emma/instr/InstrProcessor:setInclExclFilter	([Ljava/lang/String;)V
    //   482: aload_0
    //   483: getfield 25	com/vladium/emma/instr/instrCommand:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   486: ifnull +66 -> 552
    //   489: iconst_1
    //   490: istore_2
    //   491: iload_2
    //   492: ldc -32
    //   494: invokestatic 230	com/vladium/util/asserts/$assert:ASSERT	(ZLjava/lang/String;)V
    //   497: aload_3
    //   498: aload_0
    //   499: getfield 25	com/vladium/emma/instr/instrCommand:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   502: invokevirtual 234	com/vladium/emma/instr/InstrProcessor:setOutMode	(Lcom/vladium/emma/instr/InstrProcessor$OutMode;)V
    //   505: aload_3
    //   506: aload_0
    //   507: getfield 128	com/vladium/emma/instr/instrCommand:m_outDirName	Ljava/lang/String;
    //   510: invokevirtual 237	com/vladium/emma/instr/InstrProcessor:setInstrOutDir	(Ljava/lang/String;)V
    //   513: aload_3
    //   514: aload_0
    //   515: getfield 139	com/vladium/emma/instr/instrCommand:m_outFileName	Ljava/lang/String;
    //   518: invokevirtual 240	com/vladium/emma/instr/InstrProcessor:setMetaOutFile	(Ljava/lang/String;)V
    //   521: aload_3
    //   522: aload_0
    //   523: getfield 151	com/vladium/emma/instr/instrCommand:m_outDataMerge	Ljava/lang/Boolean;
    //   526: invokevirtual 244	com/vladium/emma/instr/InstrProcessor:setMetaOutMerge	(Ljava/lang/Boolean;)V
    //   529: aload_3
    //   530: aload_0
    //   531: getfield 248	com/vladium/emma/instr/instrCommand:m_propertyOverrides	Ljava/util/Properties;
    //   534: invokevirtual 252	com/vladium/emma/instr/InstrProcessor:setPropertyOverrides	(Ljava/util/Properties;)V
    //   537: aload_3
    //   538: invokevirtual 254	com/vladium/emma/instr/InstrProcessor:run	()V
    //   541: aload_0
    //   542: iconst_0
    //   543: aconst_null
    //   544: aconst_null
    //   545: iconst_0
    //   546: invokevirtual 95	com/vladium/emma/instr/instrCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   549: goto -503 -> 46
    //   552: iconst_0
    //   553: istore_2
    //   554: goto -63 -> 491
    //   557: iload_1
    //   558: iconst_1
    //   559: iadd
    //   560: istore_1
    //   561: goto -440 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	instrCommand
    //   33	528	1	i	int
    //   490	64	2	bool	boolean
    //   5	3	3	localClassLoader1	ClassLoader
    //   49	1	3	localThrowable1	Throwable
    //   57	1	3	localClassLoader2	ClassLoader
    //   99	8	3	localEMMARuntimeException	com.vladium.emma.EMMARuntimeException
    //   114	4	3	localObject1	Object
    //   132	54	3	localIOpt	com.vladium.util.args.IOptsParser.IOpt
    //   197	8	3	localIOException	java.io.IOException
    //   209	47	3	localThrowable2	Throwable
    //   265	273	3	localObject2	Object
    //   11	409	4	localIOptsParser	com.vladium.util.args.IOptsParser
    //   24	373	5	localIOpts	com.vladium.util.args.IOptsParser.IOpts
    //   68	282	6	arrayOfIOpt	com.vladium.util.args.IOptsParser.IOpt[]
    //   139	242	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	49	java/lang/Throwable
    //   6	34	99	com/vladium/emma/EMMARuntimeException
    //   38	46	99	com/vladium/emma/EMMARuntimeException
    //   61	70	99	com/vladium/emma/EMMARuntimeException
    //   75	96	99	com/vladium/emma/EMMARuntimeException
    //   121	128	99	com/vladium/emma/EMMARuntimeException
    //   133	171	99	com/vladium/emma/EMMARuntimeException
    //   174	194	99	com/vladium/emma/EMMARuntimeException
    //   198	209	99	com/vladium/emma/EMMARuntimeException
    //   222	242	99	com/vladium/emma/EMMARuntimeException
    //   245	266	99	com/vladium/emma/EMMARuntimeException
    //   266	271	99	com/vladium/emma/EMMARuntimeException
    //   274	278	99	com/vladium/emma/EMMARuntimeException
    //   281	302	99	com/vladium/emma/EMMARuntimeException
    //   305	328	99	com/vladium/emma/EMMARuntimeException
    //   333	376	99	com/vladium/emma/EMMARuntimeException
    //   379	385	99	com/vladium/emma/EMMARuntimeException
    //   388	401	99	com/vladium/emma/EMMARuntimeException
    //   401	452	99	com/vladium/emma/EMMARuntimeException
    //   455	489	99	com/vladium/emma/EMMARuntimeException
    //   491	541	99	com/vladium/emma/EMMARuntimeException
    //   2	6	114	finally
    //   6	34	114	finally
    //   38	46	114	finally
    //   50	58	114	finally
    //   61	70	114	finally
    //   75	96	114	finally
    //   100	111	114	finally
    //   121	128	114	finally
    //   133	171	114	finally
    //   174	194	114	finally
    //   198	209	114	finally
    //   210	219	114	finally
    //   222	242	114	finally
    //   245	266	114	finally
    //   266	271	114	finally
    //   274	278	114	finally
    //   281	302	114	finally
    //   305	328	114	finally
    //   333	376	114	finally
    //   379	385	114	finally
    //   388	401	114	finally
    //   401	452	114	finally
    //   455	489	114	finally
    //   491	541	114	finally
    //   541	549	114	finally
    //   121	128	197	java/io/IOException
    //   133	171	197	java/io/IOException
    //   174	194	197	java/io/IOException
    //   222	242	197	java/io/IOException
    //   245	266	197	java/io/IOException
    //   266	271	197	java/io/IOException
    //   274	278	197	java/io/IOException
    //   281	302	197	java/io/IOException
    //   305	328	197	java/io/IOException
    //   333	376	197	java/io/IOException
    //   379	385	197	java/io/IOException
    //   388	401	197	java/io/IOException
    //   6	34	209	java/lang/Throwable
    //   38	46	209	java/lang/Throwable
    //   61	70	209	java/lang/Throwable
    //   75	96	209	java/lang/Throwable
    //   121	128	209	java/lang/Throwable
    //   133	171	209	java/lang/Throwable
    //   174	194	209	java/lang/Throwable
    //   198	209	209	java/lang/Throwable
    //   222	242	209	java/lang/Throwable
    //   245	266	209	java/lang/Throwable
    //   266	271	209	java/lang/Throwable
    //   274	278	209	java/lang/Throwable
    //   281	302	209	java/lang/Throwable
    //   305	328	209	java/lang/Throwable
    //   333	376	209	java/lang/Throwable
    //   379	385	209	java/lang/Throwable
    //   388	401	209	java/lang/Throwable
    //   401	452	209	java/lang/Throwable
    //   455	489	209	java/lang/Throwable
    //   491	541	209	java/lang/Throwable
  }
  
  protected String usageArgsMsg()
  {
    return "[options]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/instr/instrCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */