package com.vladium.emma.report;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.Processor;
import com.vladium.util.Files;
import com.vladium.util.IConstants;
import com.vladium.util.Strings;
import java.io.File;

public final class ReportProcessor
  extends Processor
  implements IAppErrorCodes
{
  private static final Class[] EXPECTED_FAILURES = { EMMARuntimeException.class, IllegalArgumentException.class, IllegalStateException.class };
  private int m_dataFileCount;
  private File[] m_dataPath = IConstants.EMPTY_FILE_ARRAY;
  private IReportGenerator[] m_reportGenerators;
  private File[] m_sourcePath;
  
  public static ReportProcessor create()
  {
    return new ReportProcessor();
  }
  
  private void reset()
  {
    this.m_dataFileCount = 0;
  }
  
  /* Error */
  protected void _run(com.vladium.util.IProperties paramIProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/vladium/emma/report/ReportProcessor:m_log	Lcom/vladium/logging/Logger;
    //   4: astore 13
    //   6: aload_0
    //   7: getfield 58	com/vladium/emma/report/ReportProcessor:m_log	Lcom/vladium/logging/Logger;
    //   10: invokevirtual 64	com/vladium/logging/Logger:atVERBOSE	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +463 -> 478
    //   18: aload 13
    //   20: ldc 66
    //   22: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   25: aload 13
    //   27: ldc 72
    //   29: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   32: aload 13
    //   34: ldc 74
    //   36: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: aload_0
    //   43: getfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   46: arraylength
    //   47: if_icmpge +70 -> 117
    //   50: aload_0
    //   51: getfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   54: iload_2
    //   55: aaload
    //   56: astore 9
    //   58: aload 9
    //   60: invokevirtual 79	java/io/File:exists	()Z
    //   63: ifeq +47 -> 110
    //   66: ldc 81
    //   68: astore 8
    //   70: aload 13
    //   72: new 83	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   79: ldc 86
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   94: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -66 -> 41
    //   110: ldc 99
    //   112: astore 8
    //   114: goto -44 -> 70
    //   117: aload 13
    //   119: ldc 101
    //   121: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   128: ifnull +11 -> 139
    //   131: aload_0
    //   132: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   135: arraylength
    //   136: ifne +240 -> 376
    //   139: aload 13
    //   141: ldc 105
    //   143: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   146: aconst_null
    //   147: astore 11
    //   149: aload 13
    //   151: invokevirtual 108	com/vladium/logging/Logger:atINFO	()Z
    //   154: ifeq +334 -> 488
    //   157: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   160: lstore 4
    //   162: aconst_null
    //   163: astore 9
    //   165: aconst_null
    //   166: astore 10
    //   168: iconst_0
    //   169: istore_2
    //   170: iload_2
    //   171: aload_0
    //   172: getfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   175: arraylength
    //   176: if_icmpge +352 -> 528
    //   179: aload_0
    //   180: getfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   183: iload_2
    //   184: aaload
    //   185: astore 8
    //   187: iload_3
    //   188: ifeq +36 -> 224
    //   191: aload 13
    //   193: new 83	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   200: ldc 116
    //   202: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 8
    //   207: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   210: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 118
    //   215: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   224: aload 8
    //   226: invokestatic 124	com/vladium/emma/data/DataFactory:load	(Ljava/io/File;)[Lcom/vladium/emma/data/IMergeable;
    //   229: astore 14
    //   231: aload 14
    //   233: iconst_0
    //   234: aaload
    //   235: checkcast 126	com/vladium/emma/data/IMetaData
    //   238: astore 12
    //   240: aload 9
    //   242: astore 8
    //   244: aload 12
    //   246: ifnull +45 -> 291
    //   249: iload_3
    //   250: ifeq +691 -> 941
    //   253: aload 13
    //   255: new 83	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   262: ldc -128
    //   264: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 12
    //   269: invokeinterface 132 1 0
    //   274: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc -119
    //   279: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   288: goto +653 -> 941
    //   291: aload 14
    //   293: iconst_1
    //   294: aaload
    //   295: checkcast 139	com/vladium/emma/data/ICoverageData
    //   298: astore 12
    //   300: aload 10
    //   302: astore 9
    //   304: aload 12
    //   306: ifnull +45 -> 351
    //   309: iload_3
    //   310: ifeq +643 -> 953
    //   313: aload 13
    //   315: new 83	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   322: ldc -128
    //   324: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 12
    //   329: invokeinterface 140 1 0
    //   334: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc -114
    //   339: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   348: goto +605 -> 953
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 44	com/vladium/emma/report/ReportProcessor:m_dataFileCount	I
    //   356: iconst_1
    //   357: iadd
    //   358: putfield 44	com/vladium/emma/report/ReportProcessor:m_dataFileCount	I
    //   361: iload_2
    //   362: iconst_1
    //   363: iadd
    //   364: istore_2
    //   365: aload 9
    //   367: astore 10
    //   369: aload 8
    //   371: astore 9
    //   373: goto -203 -> 170
    //   376: aload 13
    //   378: ldc -112
    //   380: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   383: aload 13
    //   385: ldc 74
    //   387: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   390: iconst_0
    //   391: istore_2
    //   392: iload_2
    //   393: aload_0
    //   394: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   397: arraylength
    //   398: if_icmpge +70 -> 468
    //   401: aload_0
    //   402: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   405: iload_2
    //   406: aaload
    //   407: astore 9
    //   409: aload 9
    //   411: invokevirtual 79	java/io/File:exists	()Z
    //   414: ifeq +47 -> 461
    //   417: ldc 81
    //   419: astore 8
    //   421: aload 13
    //   423: new 83	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   430: ldc 86
    //   432: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 8
    //   437: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 9
    //   442: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   445: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -66 -> 392
    //   461: ldc 99
    //   463: astore 8
    //   465: goto -44 -> 421
    //   468: aload 13
    //   470: ldc 101
    //   472: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   475: goto -329 -> 146
    //   478: aload 13
    //   480: ldc -110
    //   482: invokevirtual 149	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   485: goto -339 -> 146
    //   488: lconst_0
    //   489: lstore 4
    //   491: goto -329 -> 162
    //   494: aload 9
    //   496: aload 12
    //   498: invokeinterface 153 2 0
    //   503: checkcast 126	com/vladium/emma/data/IMetaData
    //   506: astore 8
    //   508: goto -217 -> 291
    //   511: aload 10
    //   513: aload 12
    //   515: invokeinterface 154 2 0
    //   520: checkcast 139	com/vladium/emma/data/ICoverageData
    //   523: astore 9
    //   525: goto -174 -> 351
    //   528: aload 13
    //   530: invokevirtual 108	com/vladium/logging/Logger:atINFO	()Z
    //   533: ifeq +48 -> 581
    //   536: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   539: lstore 6
    //   541: aload 13
    //   543: new 83	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 44	com/vladium/emma/report/ReportProcessor:m_dataFileCount	I
    //   554: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: ldc -100
    //   559: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: lload 6
    //   564: lload 4
    //   566: lsub
    //   567: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: ldc -95
    //   572: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokevirtual 149	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   581: aload 9
    //   583: ifnull +13 -> 596
    //   586: aload 9
    //   588: invokeinterface 164 1 0
    //   593: ifeq +15 -> 608
    //   596: aload 13
    //   598: ldc -90
    //   600: invokevirtual 169	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   603: aload_0
    //   604: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   607: return
    //   608: aload 10
    //   610: ifnonnull +15 -> 625
    //   613: aload 13
    //   615: ldc -83
    //   617: invokevirtual 169	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   620: aload_0
    //   621: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   624: return
    //   625: aload 10
    //   627: invokeinterface 174 1 0
    //   632: ifeq +10 -> 642
    //   635: aload 13
    //   637: ldc -80
    //   639: invokevirtual 169	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   642: iload_3
    //   643: ifeq +83 -> 726
    //   646: aload 9
    //   648: ifnull +38 -> 686
    //   651: aload 13
    //   653: new 83	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   660: ldc -78
    //   662: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 9
    //   667: invokeinterface 132 1 0
    //   672: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: ldc -76
    //   677: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   686: aload 10
    //   688: ifnull +38 -> 726
    //   691: aload 13
    //   693: new 83	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   700: ldc -74
    //   702: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 10
    //   707: invokeinterface 140 1 0
    //   712: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   715: ldc -76
    //   717: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokevirtual 70	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   726: aconst_null
    //   727: astore 8
    //   729: aload_0
    //   730: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   733: ifnull +232 -> 965
    //   736: new 184	com/vladium/emma/report/SourcePathCache
    //   739: dup
    //   740: aload_0
    //   741: getfield 103	com/vladium/emma/report/ReportProcessor:m_sourcePath	[Ljava/io/File;
    //   744: iconst_1
    //   745: invokespecial 187	com/vladium/emma/report/SourcePathCache:<init>	([Ljava/io/File;Z)V
    //   748: astore 8
    //   750: goto +215 -> 965
    //   753: iload_2
    //   754: aload_0
    //   755: getfield 189	com/vladium/emma/report/ReportProcessor:m_reportGenerators	[Lcom/vladium/emma/report/IReportGenerator;
    //   758: arraylength
    //   759: if_icmpge +54 -> 813
    //   762: aload_0
    //   763: getfield 189	com/vladium/emma/report/ReportProcessor:m_reportGenerators	[Lcom/vladium/emma/report/IReportGenerator;
    //   766: iload_2
    //   767: aaload
    //   768: astore 12
    //   770: aload 12
    //   772: aload 9
    //   774: aload 10
    //   776: aload 8
    //   778: aload_1
    //   779: invokeinterface 195 5 0
    //   784: aload 12
    //   786: invokeinterface 198 1 0
    //   791: iload_2
    //   792: iconst_1
    //   793: iadd
    //   794: istore_2
    //   795: goto -42 -> 753
    //   798: astore_1
    //   799: aload_1
    //   800: getstatic 202	java/lang/System:out	Ljava/io/PrintStream;
    //   803: invokevirtual 206	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   806: aload 12
    //   808: invokeinterface 198 1 0
    //   813: aload_0
    //   814: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   817: aload 11
    //   819: astore_1
    //   820: aload_1
    //   821: ifnull -214 -> 607
    //   824: aload_1
    //   825: getstatic 27	com/vladium/emma/report/ReportProcessor:EXPECTED_FAILURES	[Ljava/lang/Class;
    //   828: invokestatic 212	com/vladium/util/exception/Exceptions:unexpectedFailure	(Ljava/lang/Throwable;[Ljava/lang/Class;)Z
    //   831: ifeq +94 -> 925
    //   834: new 21	com/vladium/emma/EMMARuntimeException
    //   837: dup
    //   838: ldc -42
    //   840: iconst_2
    //   841: anewarray 216	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: aload_1
    //   847: invokevirtual 217	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: ldc -37
    //   855: aastore
    //   856: aload_1
    //   857: invokespecial 222	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   860: athrow
    //   861: astore_1
    //   862: aload 12
    //   864: invokeinterface 198 1 0
    //   869: aload_1
    //   870: athrow
    //   871: astore_1
    //   872: aload_1
    //   873: getstatic 202	java/lang/System:out	Ljava/io/PrintStream;
    //   876: invokevirtual 223	java/io/IOException:printStackTrace	(Ljava/io/PrintStream;)V
    //   879: goto -66 -> 813
    //   882: astore_1
    //   883: new 21	com/vladium/emma/EMMARuntimeException
    //   886: dup
    //   887: ldc -31
    //   889: iconst_1
    //   890: anewarray 227	java/lang/String
    //   893: dup
    //   894: iconst_0
    //   895: ldc -27
    //   897: aastore
    //   898: aload_1
    //   899: invokespecial 222	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   902: astore_1
    //   903: aload_0
    //   904: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   907: goto -87 -> 820
    //   910: astore_1
    //   911: aload_0
    //   912: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   915: goto -95 -> 820
    //   918: astore_1
    //   919: aload_0
    //   920: invokespecial 171	com/vladium/emma/report/ReportProcessor:reset	()V
    //   923: aload_1
    //   924: athrow
    //   925: aload_1
    //   926: athrow
    //   927: astore 12
    //   929: goto -138 -> 791
    //   932: astore_1
    //   933: goto -120 -> 813
    //   936: astore 8
    //   938: goto -69 -> 869
    //   941: aload 9
    //   943: ifnonnull -449 -> 494
    //   946: aload 12
    //   948: astore 8
    //   950: goto -659 -> 291
    //   953: aload 10
    //   955: ifnonnull -444 -> 511
    //   958: aload 12
    //   960: astore 9
    //   962: goto -611 -> 351
    //   965: iconst_0
    //   966: istore_2
    //   967: goto -214 -> 753
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	ReportProcessor
    //   0	970	1	paramIProperties	com.vladium.util.IProperties
    //   40	927	2	i	int
    //   13	630	3	bool	boolean
    //   160	405	4	l1	long
    //   539	24	6	l2	long
    //   68	709	8	localObject1	Object
    //   936	1	8	localThrowable1	Throwable
    //   948	1	8	localObject2	Object
    //   56	905	9	localObject3	Object
    //   166	788	10	localObject4	Object
    //   147	671	11	localObject5	Object
    //   238	625	12	localObject6	Object
    //   927	32	12	localThrowable2	Throwable
    //   4	688	13	localLogger	com.vladium.logging.Logger
    //   229	63	14	arrayOfIMergeable	com.vladium.emma.data.IMergeable[]
    // Exception table:
    //   from	to	target	type
    //   770	784	798	java/lang/Throwable
    //   770	784	861	finally
    //   799	806	861	finally
    //   170	187	871	java/io/IOException
    //   191	224	871	java/io/IOException
    //   224	240	871	java/io/IOException
    //   253	288	871	java/io/IOException
    //   291	300	871	java/io/IOException
    //   313	348	871	java/io/IOException
    //   351	361	871	java/io/IOException
    //   494	508	871	java/io/IOException
    //   511	525	871	java/io/IOException
    //   528	581	871	java/io/IOException
    //   586	596	871	java/io/IOException
    //   596	603	871	java/io/IOException
    //   613	620	871	java/io/IOException
    //   625	642	871	java/io/IOException
    //   651	686	871	java/io/IOException
    //   691	726	871	java/io/IOException
    //   729	750	871	java/io/IOException
    //   753	770	871	java/io/IOException
    //   784	791	871	java/io/IOException
    //   806	813	871	java/io/IOException
    //   862	869	871	java/io/IOException
    //   869	871	871	java/io/IOException
    //   149	162	882	java/lang/SecurityException
    //   170	187	882	java/lang/SecurityException
    //   191	224	882	java/lang/SecurityException
    //   224	240	882	java/lang/SecurityException
    //   253	288	882	java/lang/SecurityException
    //   291	300	882	java/lang/SecurityException
    //   313	348	882	java/lang/SecurityException
    //   351	361	882	java/lang/SecurityException
    //   494	508	882	java/lang/SecurityException
    //   511	525	882	java/lang/SecurityException
    //   528	581	882	java/lang/SecurityException
    //   586	596	882	java/lang/SecurityException
    //   596	603	882	java/lang/SecurityException
    //   613	620	882	java/lang/SecurityException
    //   625	642	882	java/lang/SecurityException
    //   651	686	882	java/lang/SecurityException
    //   691	726	882	java/lang/SecurityException
    //   729	750	882	java/lang/SecurityException
    //   753	770	882	java/lang/SecurityException
    //   784	791	882	java/lang/SecurityException
    //   806	813	882	java/lang/SecurityException
    //   862	869	882	java/lang/SecurityException
    //   869	871	882	java/lang/SecurityException
    //   872	879	882	java/lang/SecurityException
    //   149	162	910	java/lang/RuntimeException
    //   170	187	910	java/lang/RuntimeException
    //   191	224	910	java/lang/RuntimeException
    //   224	240	910	java/lang/RuntimeException
    //   253	288	910	java/lang/RuntimeException
    //   291	300	910	java/lang/RuntimeException
    //   313	348	910	java/lang/RuntimeException
    //   351	361	910	java/lang/RuntimeException
    //   494	508	910	java/lang/RuntimeException
    //   511	525	910	java/lang/RuntimeException
    //   528	581	910	java/lang/RuntimeException
    //   586	596	910	java/lang/RuntimeException
    //   596	603	910	java/lang/RuntimeException
    //   613	620	910	java/lang/RuntimeException
    //   625	642	910	java/lang/RuntimeException
    //   651	686	910	java/lang/RuntimeException
    //   691	726	910	java/lang/RuntimeException
    //   729	750	910	java/lang/RuntimeException
    //   753	770	910	java/lang/RuntimeException
    //   784	791	910	java/lang/RuntimeException
    //   806	813	910	java/lang/RuntimeException
    //   862	869	910	java/lang/RuntimeException
    //   869	871	910	java/lang/RuntimeException
    //   872	879	910	java/lang/RuntimeException
    //   149	162	918	finally
    //   170	187	918	finally
    //   191	224	918	finally
    //   224	240	918	finally
    //   253	288	918	finally
    //   291	300	918	finally
    //   313	348	918	finally
    //   351	361	918	finally
    //   494	508	918	finally
    //   511	525	918	finally
    //   528	581	918	finally
    //   586	596	918	finally
    //   596	603	918	finally
    //   613	620	918	finally
    //   625	642	918	finally
    //   651	686	918	finally
    //   691	726	918	finally
    //   729	750	918	finally
    //   753	770	918	finally
    //   784	791	918	finally
    //   806	813	918	finally
    //   862	869	918	finally
    //   869	871	918	finally
    //   872	879	918	finally
    //   883	903	918	finally
    //   784	791	927	java/lang/Throwable
    //   806	813	932	java/lang/Throwable
    //   862	869	936	java/lang/Throwable
  }
  
  /* Error */
  public final void setDataPath(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +8 -> 11
    //   6: aload_1
    //   7: arraylength
    //   8: ifne +13 -> 21
    //   11: aload_0
    //   12: getstatic 36	com/vladium/util/IConstants:EMPTY_FILE_ARRAY	[Ljava/io/File;
    //   15: putfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_1
    //   24: invokestatic 237	com/vladium/util/Files:pathToFiles	([Ljava/lang/String;Z)[Ljava/io/File;
    //   27: putfield 38	com/vladium/emma/report/ReportProcessor:m_dataPath	[Ljava/io/File;
    //   30: goto -12 -> 18
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ReportProcessor
    //   0	38	1	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   6	11	33	finally
    //   11	18	33	finally
    //   21	30	33	finally
  }
  
  public void setReportTypes(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      try
      {
        throw new IllegalArgumentException("null input: types");
      }
      finally {}
    }
    paramArrayOfString = Strings.removeDuplicates(paramArrayOfString, true);
    if (paramArrayOfString.length == 0) {
      throw new IllegalArgumentException("empty input: types");
    }
    IReportGenerator[] arrayOfIReportGenerator = new IReportGenerator[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfIReportGenerator[i] = AbstractReportGenerator.create(paramArrayOfString[i]);
      i += 1;
    }
    this.m_reportGenerators = arrayOfIReportGenerator;
  }
  
  public void setSourcePath(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      try
      {
        this.m_sourcePath = null;
        return;
      }
      finally {}
      this.m_sourcePath = Files.pathToFiles(paramArrayOfString, true);
    }
  }
  
  protected void validateState()
  {
    super.validateState();
    if (this.m_dataPath == null) {
      throw new IllegalStateException("data path not set");
    }
    if ((this.m_reportGenerators == null) || (this.m_reportGenerators.length == 0)) {
      throw new IllegalStateException("report types not set");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/ReportProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */