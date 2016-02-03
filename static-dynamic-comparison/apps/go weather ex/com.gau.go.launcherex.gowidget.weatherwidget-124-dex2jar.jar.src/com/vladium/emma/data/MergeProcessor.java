package com.vladium.emma.data;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.Processor;
import com.vladium.util.IConstants;
import java.io.File;

public final class MergeProcessor
  extends Processor
  implements IAppErrorCodes
{
  private static final Class[] EXPECTED_FAILURES = { EMMARuntimeException.class, IllegalArgumentException.class, IllegalStateException.class };
  private int m_dataFileCount;
  private File[] m_dataPath = IConstants.EMPTY_FILE_ARRAY;
  private File m_sdataOutFile;
  
  public static MergeProcessor create()
  {
    return new MergeProcessor();
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
    //   1: getfield 57	com/vladium/emma/data/MergeProcessor:m_log	Lcom/vladium/logging/Logger;
    //   4: astore 17
    //   6: aload_0
    //   7: getfield 57	com/vladium/emma/data/MergeProcessor:m_log	Lcom/vladium/logging/Logger;
    //   10: invokevirtual 63	com/vladium/logging/Logger:atVERBOSE	()Z
    //   13: istore 5
    //   15: iload 5
    //   17: ifeq +460 -> 477
    //   20: aload 17
    //   22: ldc 65
    //   24: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   27: aload 17
    //   29: ldc 71
    //   31: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   34: aload 17
    //   36: ldc 73
    //   38: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: aload_0
    //   45: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   48: arraylength
    //   49: if_icmpge +70 -> 119
    //   52: aload_0
    //   53: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   56: iload_2
    //   57: aaload
    //   58: astore 11
    //   60: aload 11
    //   62: invokevirtual 78	java/io/File:exists	()Z
    //   65: ifeq +47 -> 112
    //   68: ldc 80
    //   70: astore 10
    //   72: aload 17
    //   74: new 82	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   81: ldc 85
    //   83: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 10
    //   88: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 11
    //   93: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -66 -> 43
    //   112: ldc 98
    //   114: astore 10
    //   116: goto -44 -> 72
    //   119: aload 17
    //   121: ldc 100
    //   123: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield 102	com/vladium/emma/data/MergeProcessor:m_sdataOutFile	Ljava/io/File;
    //   130: astore 10
    //   132: aload 10
    //   134: astore 14
    //   136: aload 10
    //   138: ifnonnull +22 -> 160
    //   141: new 75	java/io/File
    //   144: dup
    //   145: aload_1
    //   146: ldc 104
    //   148: ldc 106
    //   150: invokeinterface 112 3 0
    //   155: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 14
    //   160: aconst_null
    //   161: astore 16
    //   163: aconst_null
    //   164: astore 12
    //   166: aconst_null
    //   167: astore 13
    //   169: aconst_null
    //   170: astore 15
    //   172: aconst_null
    //   173: astore 11
    //   175: aload 15
    //   177: astore_1
    //   178: aload 12
    //   180: astore 10
    //   182: aload 17
    //   184: invokevirtual 117	com/vladium/logging/Logger:atINFO	()Z
    //   187: ifeq +300 -> 487
    //   190: aload 15
    //   192: astore_1
    //   193: aload 12
    //   195: astore 10
    //   197: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   200: lstore 6
    //   202: goto +1148 -> 1350
    //   205: aload 11
    //   207: astore_1
    //   208: aload 13
    //   210: astore 10
    //   212: iload_2
    //   213: aload_0
    //   214: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   217: arraylength
    //   218: if_icmpge +323 -> 541
    //   221: aload 11
    //   223: astore_1
    //   224: aload 13
    //   226: astore 10
    //   228: aload_0
    //   229: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   232: iload_2
    //   233: aaload
    //   234: astore 12
    //   236: iload 5
    //   238: ifeq +43 -> 281
    //   241: aload 11
    //   243: astore_1
    //   244: aload 13
    //   246: astore 10
    //   248: aload 17
    //   250: new 82	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   257: ldc 125
    //   259: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 12
    //   264: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   267: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 127
    //   272: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   281: aload 11
    //   283: astore_1
    //   284: aload 13
    //   286: astore 10
    //   288: aload 12
    //   290: invokestatic 133	com/vladium/emma/data/DataFactory:load	(Ljava/io/File;)[Lcom/vladium/emma/data/IMergeable;
    //   293: astore 18
    //   295: aload 11
    //   297: astore_1
    //   298: aload 13
    //   300: astore 10
    //   302: aload 18
    //   304: iconst_0
    //   305: aaload
    //   306: checkcast 135	com/vladium/emma/data/IMetaData
    //   309: astore 15
    //   311: aload 13
    //   313: astore 12
    //   315: aload 15
    //   317: ifnull +53 -> 370
    //   320: iload 5
    //   322: ifeq +1033 -> 1355
    //   325: aload 11
    //   327: astore_1
    //   328: aload 13
    //   330: astore 10
    //   332: aload 17
    //   334: new 82	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   341: ldc -119
    //   343: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 15
    //   348: invokeinterface 141 1 0
    //   353: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc -110
    //   358: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   367: goto +988 -> 1355
    //   370: aload 11
    //   372: astore_1
    //   373: aload 12
    //   375: astore 10
    //   377: aload 18
    //   379: iconst_1
    //   380: aaload
    //   381: checkcast 148	com/vladium/emma/data/ICoverageData
    //   384: astore 15
    //   386: aload 11
    //   388: astore 13
    //   390: aload 15
    //   392: ifnull +53 -> 445
    //   395: iload 5
    //   397: ifeq +970 -> 1367
    //   400: aload 11
    //   402: astore_1
    //   403: aload 12
    //   405: astore 10
    //   407: aload 17
    //   409: new 82	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   416: ldc -119
    //   418: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 15
    //   423: invokeinterface 149 1 0
    //   428: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc -105
    //   433: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   442: goto +925 -> 1367
    //   445: aload 13
    //   447: astore_1
    //   448: aload 12
    //   450: astore 10
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 43	com/vladium/emma/data/MergeProcessor:m_dataFileCount	I
    //   457: iconst_1
    //   458: iadd
    //   459: putfield 43	com/vladium/emma/data/MergeProcessor:m_dataFileCount	I
    //   462: iload_2
    //   463: iconst_1
    //   464: iadd
    //   465: istore_2
    //   466: aload 13
    //   468: astore 11
    //   470: aload 12
    //   472: astore 13
    //   474: goto -269 -> 205
    //   477: aload 17
    //   479: ldc -103
    //   481: invokevirtual 156	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   484: goto -358 -> 126
    //   487: lconst_0
    //   488: lstore 6
    //   490: goto +860 -> 1350
    //   493: aload 11
    //   495: astore_1
    //   496: aload 13
    //   498: astore 10
    //   500: aload 13
    //   502: aload 15
    //   504: invokeinterface 160 2 0
    //   509: checkcast 135	com/vladium/emma/data/IMetaData
    //   512: astore 12
    //   514: goto -144 -> 370
    //   517: aload 11
    //   519: astore_1
    //   520: aload 12
    //   522: astore 10
    //   524: aload 11
    //   526: aload 15
    //   528: invokeinterface 161 2 0
    //   533: checkcast 148	com/vladium/emma/data/ICoverageData
    //   536: astore 13
    //   538: goto -93 -> 445
    //   541: aload 11
    //   543: astore_1
    //   544: aload 13
    //   546: astore 10
    //   548: aload 17
    //   550: invokevirtual 117	com/vladium/logging/Logger:atINFO	()Z
    //   553: ifeq +62 -> 615
    //   556: aload 11
    //   558: astore_1
    //   559: aload 13
    //   561: astore 10
    //   563: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   566: lstore 8
    //   568: aload 11
    //   570: astore_1
    //   571: aload 13
    //   573: astore 10
    //   575: aload 17
    //   577: new 82	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: getfield 43	com/vladium/emma/data/MergeProcessor:m_dataFileCount	I
    //   588: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc -93
    //   593: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: lload 8
    //   598: lload 6
    //   600: lsub
    //   601: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   604: ldc -88
    //   606: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokevirtual 156	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   615: aload 13
    //   617: ifnull +28 -> 645
    //   620: aload 11
    //   622: astore_1
    //   623: aload 13
    //   625: astore 10
    //   627: aload 11
    //   629: astore 12
    //   631: aload 13
    //   633: astore 15
    //   635: aload 13
    //   637: invokeinterface 171 1 0
    //   642: ifeq +69 -> 711
    //   645: aload 11
    //   647: ifnull +28 -> 675
    //   650: aload 11
    //   652: astore_1
    //   653: aload 13
    //   655: astore 10
    //   657: aload 11
    //   659: astore 12
    //   661: aload 13
    //   663: astore 15
    //   665: aload 11
    //   667: invokeinterface 172 1 0
    //   672: ifeq +39 -> 711
    //   675: aload 11
    //   677: astore_1
    //   678: aload 13
    //   680: astore 10
    //   682: aload 17
    //   684: ldc -82
    //   686: invokevirtual 177	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   689: aload_0
    //   690: invokespecial 179	com/vladium/emma/data/MergeProcessor:reset	()V
    //   693: return
    //   694: astore 11
    //   696: aload 11
    //   698: getstatic 183	java/lang/System:out	Ljava/io/PrintStream;
    //   701: invokevirtual 187	java/io/IOException:printStackTrace	(Ljava/io/PrintStream;)V
    //   704: aload 10
    //   706: astore 15
    //   708: aload_1
    //   709: astore 12
    //   711: iload 5
    //   713: ifeq +666 -> 1379
    //   716: aload 15
    //   718: ifnull +38 -> 756
    //   721: aload 17
    //   723: new 82	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   730: ldc -67
    //   732: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 15
    //   737: invokeinterface 141 1 0
    //   742: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: ldc -65
    //   747: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   756: aload 12
    //   758: ifnull +621 -> 1379
    //   761: aload 17
    //   763: new 82	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   770: ldc -63
    //   772: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 12
    //   777: invokeinterface 149 1 0
    //   782: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: ldc -65
    //   787: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokevirtual 69	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   796: goto +583 -> 1379
    //   799: iload 5
    //   801: ldc -61
    //   803: invokestatic 201	com/vladium/util/asserts/$assert:ASSERT	(ZLjava/lang/String;)V
    //   806: iconst_0
    //   807: istore 4
    //   809: aconst_null
    //   810: astore_1
    //   811: aload 14
    //   813: invokestatic 207	com/vladium/util/Files:canonicalizeFile	(Ljava/io/File;)Ljava/io/File;
    //   816: astore 11
    //   818: iconst_0
    //   819: istore_2
    //   820: iload 4
    //   822: istore_3
    //   823: iload_2
    //   824: aload_0
    //   825: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   828: arraylength
    //   829: if_icmpge +22 -> 851
    //   832: aload 11
    //   834: aload_0
    //   835: getfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   838: iload_2
    //   839: aaload
    //   840: invokestatic 207	com/vladium/util/Files:canonicalizeFile	(Ljava/io/File;)Ljava/io/File;
    //   843: invokevirtual 211	java/io/File:equals	(Ljava/lang/Object;)Z
    //   846: ifeq +307 -> 1153
    //   849: iconst_1
    //   850: istore_3
    //   851: iload_3
    //   852: ifeq +124 -> 976
    //   855: aload 11
    //   857: invokevirtual 215	java/io/File:getParentFile	()Ljava/io/File;
    //   860: astore 10
    //   862: aload 10
    //   864: astore_1
    //   865: aload 10
    //   867: ifnonnull +13 -> 880
    //   870: new 75	java/io/File
    //   873: dup
    //   874: ldc 80
    //   876: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   879: astore_1
    //   880: new 82	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   887: aload 11
    //   889: invokestatic 219	com/vladium/util/Files:getFileName	(Ljava/io/File;)Ljava/lang/String;
    //   892: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc -35
    //   897: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: astore 10
    //   905: aload_1
    //   906: aload 10
    //   908: ldc -33
    //   910: invokestatic 227	com/vladium/util/Files:createTempFile	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   913: astore_1
    //   914: aload 17
    //   916: new 82	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   923: ldc -27
    //   925: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: aload 11
    //   930: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   933: ldc -22
    //   935: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokevirtual 177	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   944: aload 17
    //   946: new 82	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   953: ldc -20
    //   955: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload_1
    //   959: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   962: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc -22
    //   967: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokevirtual 177	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
    //   976: aload 17
    //   978: invokevirtual 117	com/vladium/logging/Logger:atINFO	()Z
    //   981: ifeq +197 -> 1178
    //   984: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   987: lstore 6
    //   989: aload_1
    //   990: ifnull +194 -> 1184
    //   993: aload_1
    //   994: astore 10
    //   996: aload 15
    //   998: ifnull +13 -> 1011
    //   1001: aload 15
    //   1003: invokeinterface 171 1 0
    //   1008: ifeq +183 -> 1191
    //   1011: aload 12
    //   1013: aload 10
    //   1015: iconst_0
    //   1016: invokestatic 240	com/vladium/emma/data/DataFactory:persist	(Lcom/vladium/emma/data/ICoverageData;Ljava/io/File;Z)V
    //   1019: iload_3
    //   1020: ifeq +259 -> 1279
    //   1023: aload_1
    //   1024: aload 11
    //   1026: iconst_1
    //   1027: invokestatic 244	com/vladium/util/Files:renameFile	(Ljava/io/File;Ljava/io/File;Z)Z
    //   1030: ifne +249 -> 1279
    //   1033: new 20	com/vladium/emma/EMMARuntimeException
    //   1036: dup
    //   1037: new 82	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1044: ldc -10
    //   1046: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: aload_1
    //   1050: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1053: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc -8
    //   1058: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 11
    //   1063: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1066: ldc -6
    //   1068: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokespecial 251	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;)V
    //   1077: athrow
    //   1078: astore_1
    //   1079: new 20	com/vladium/emma/EMMARuntimeException
    //   1082: dup
    //   1083: ldc -3
    //   1085: iconst_1
    //   1086: anewarray 255	java/lang/String
    //   1089: dup
    //   1090: iconst_0
    //   1091: ldc_w 257
    //   1094: aastore
    //   1095: aload_1
    //   1096: invokespecial 260	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1099: astore_1
    //   1100: aload_0
    //   1101: invokespecial 179	com/vladium/emma/data/MergeProcessor:reset	()V
    //   1104: aload_1
    //   1105: ifnull -412 -> 693
    //   1108: aload_1
    //   1109: getstatic 26	com/vladium/emma/data/MergeProcessor:EXPECTED_FAILURES	[Ljava/lang/Class;
    //   1112: invokestatic 266	com/vladium/util/exception/Exceptions:unexpectedFailure	(Ljava/lang/Throwable;[Ljava/lang/Class;)Z
    //   1115: ifeq +233 -> 1348
    //   1118: new 20	com/vladium/emma/EMMARuntimeException
    //   1121: dup
    //   1122: ldc_w 268
    //   1125: iconst_2
    //   1126: anewarray 270	java/lang/Object
    //   1129: dup
    //   1130: iconst_0
    //   1131: aload_1
    //   1132: invokevirtual 271	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1135: aastore
    //   1136: dup
    //   1137: iconst_1
    //   1138: ldc_w 273
    //   1141: aastore
    //   1142: aload_1
    //   1143: invokespecial 260	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1146: athrow
    //   1147: iconst_0
    //   1148: istore 5
    //   1150: goto -351 -> 799
    //   1153: iload_2
    //   1154: iconst_1
    //   1155: iadd
    //   1156: istore_2
    //   1157: goto -337 -> 820
    //   1160: astore_1
    //   1161: new 20	com/vladium/emma/EMMARuntimeException
    //   1164: dup
    //   1165: aload_1
    //   1166: invokespecial 276	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   1169: athrow
    //   1170: astore_1
    //   1171: aload_0
    //   1172: invokespecial 179	com/vladium/emma/data/MergeProcessor:reset	()V
    //   1175: goto -71 -> 1104
    //   1178: lconst_0
    //   1179: lstore 6
    //   1181: goto -192 -> 989
    //   1184: aload 11
    //   1186: astore 10
    //   1188: goto -192 -> 996
    //   1191: aload 12
    //   1193: ifnull +13 -> 1206
    //   1196: aload 12
    //   1198: invokeinterface 172 1 0
    //   1203: ifeq +42 -> 1245
    //   1206: aload 15
    //   1208: aload 10
    //   1210: iconst_0
    //   1211: invokestatic 279	com/vladium/emma/data/DataFactory:persist	(Lcom/vladium/emma/data/IMetaData;Ljava/io/File;Z)V
    //   1214: goto -195 -> 1019
    //   1217: astore_1
    //   1218: aload 10
    //   1220: ifnull +9 -> 1229
    //   1223: aload 10
    //   1225: invokevirtual 282	java/io/File:delete	()Z
    //   1228: pop
    //   1229: new 20	com/vladium/emma/EMMARuntimeException
    //   1232: dup
    //   1233: aload_1
    //   1234: invokespecial 276	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   1237: athrow
    //   1238: astore_1
    //   1239: aload_0
    //   1240: invokespecial 179	com/vladium/emma/data/MergeProcessor:reset	()V
    //   1243: aload_1
    //   1244: athrow
    //   1245: new 284	com/vladium/emma/data/SessionData
    //   1248: dup
    //   1249: aload 15
    //   1251: aload 12
    //   1253: invokespecial 287	com/vladium/emma/data/SessionData:<init>	(Lcom/vladium/emma/data/IMetaData;Lcom/vladium/emma/data/ICoverageData;)V
    //   1256: aload 10
    //   1258: iconst_0
    //   1259: invokestatic 290	com/vladium/emma/data/DataFactory:persist	(Lcom/vladium/emma/data/ISessionData;Ljava/io/File;Z)V
    //   1262: goto -243 -> 1019
    //   1265: astore_1
    //   1266: aload 10
    //   1268: ifnull +9 -> 1277
    //   1271: aload 10
    //   1273: invokevirtual 282	java/io/File:delete	()Z
    //   1276: pop
    //   1277: aload_1
    //   1278: athrow
    //   1279: aload 17
    //   1281: invokevirtual 117	com/vladium/logging/Logger:atINFO	()Z
    //   1284: ifeq +54 -> 1338
    //   1287: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   1290: lstore 8
    //   1292: aload 17
    //   1294: new 82	java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   1301: ldc_w 292
    //   1304: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload 11
    //   1309: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1312: ldc_w 294
    //   1315: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: lload 8
    //   1320: lload 6
    //   1322: lsub
    //   1323: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1326: ldc_w 296
    //   1329: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokevirtual 156	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   1338: aload_0
    //   1339: invokespecial 179	com/vladium/emma/data/MergeProcessor:reset	()V
    //   1342: aload 16
    //   1344: astore_1
    //   1345: goto -241 -> 1104
    //   1348: aload_1
    //   1349: athrow
    //   1350: iconst_0
    //   1351: istore_2
    //   1352: goto -1147 -> 205
    //   1355: aload 13
    //   1357: ifnonnull -864 -> 493
    //   1360: aload 15
    //   1362: astore 12
    //   1364: goto -994 -> 370
    //   1367: aload 11
    //   1369: ifnonnull -852 -> 517
    //   1372: aload 15
    //   1374: astore 13
    //   1376: goto -931 -> 445
    //   1379: aload 14
    //   1381: ifnull -234 -> 1147
    //   1384: iconst_1
    //   1385: istore 5
    //   1387: goto -588 -> 799
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1390	0	this	MergeProcessor
    //   0	1390	1	paramIProperties	com.vladium.util.IProperties
    //   42	1310	2	i	int
    //   822	198	3	j	int
    //   807	14	4	k	int
    //   13	1373	5	bool	boolean
    //   200	1121	6	l1	long
    //   566	753	8	l2	long
    //   70	1202	10	localObject1	Object
    //   58	618	11	localObject2	Object
    //   694	3	11	localIOException	java.io.IOException
    //   816	552	11	localFile	File
    //   164	1199	12	localObject3	Object
    //   167	1208	13	localObject4	Object
    //   134	1246	14	localObject5	Object
    //   170	1203	15	localObject6	Object
    //   161	1182	16	localObject7	Object
    //   4	1289	17	localLogger	com.vladium.logging.Logger
    //   293	85	18	arrayOfIMergeable	IMergeable[]
    // Exception table:
    //   from	to	target	type
    //   182	190	694	java/io/IOException
    //   197	202	694	java/io/IOException
    //   212	221	694	java/io/IOException
    //   228	236	694	java/io/IOException
    //   248	281	694	java/io/IOException
    //   288	295	694	java/io/IOException
    //   302	311	694	java/io/IOException
    //   332	367	694	java/io/IOException
    //   377	386	694	java/io/IOException
    //   407	442	694	java/io/IOException
    //   452	462	694	java/io/IOException
    //   500	514	694	java/io/IOException
    //   524	538	694	java/io/IOException
    //   548	556	694	java/io/IOException
    //   563	568	694	java/io/IOException
    //   575	615	694	java/io/IOException
    //   635	645	694	java/io/IOException
    //   665	675	694	java/io/IOException
    //   682	689	694	java/io/IOException
    //   182	190	1078	java/lang/SecurityException
    //   197	202	1078	java/lang/SecurityException
    //   212	221	1078	java/lang/SecurityException
    //   228	236	1078	java/lang/SecurityException
    //   248	281	1078	java/lang/SecurityException
    //   288	295	1078	java/lang/SecurityException
    //   302	311	1078	java/lang/SecurityException
    //   332	367	1078	java/lang/SecurityException
    //   377	386	1078	java/lang/SecurityException
    //   407	442	1078	java/lang/SecurityException
    //   452	462	1078	java/lang/SecurityException
    //   500	514	1078	java/lang/SecurityException
    //   524	538	1078	java/lang/SecurityException
    //   548	556	1078	java/lang/SecurityException
    //   563	568	1078	java/lang/SecurityException
    //   575	615	1078	java/lang/SecurityException
    //   635	645	1078	java/lang/SecurityException
    //   665	675	1078	java/lang/SecurityException
    //   682	689	1078	java/lang/SecurityException
    //   696	704	1078	java/lang/SecurityException
    //   721	756	1078	java/lang/SecurityException
    //   761	796	1078	java/lang/SecurityException
    //   799	806	1078	java/lang/SecurityException
    //   811	818	1078	java/lang/SecurityException
    //   823	849	1078	java/lang/SecurityException
    //   855	862	1078	java/lang/SecurityException
    //   870	880	1078	java/lang/SecurityException
    //   880	905	1078	java/lang/SecurityException
    //   905	914	1078	java/lang/SecurityException
    //   914	976	1078	java/lang/SecurityException
    //   976	989	1078	java/lang/SecurityException
    //   1001	1011	1078	java/lang/SecurityException
    //   1011	1019	1078	java/lang/SecurityException
    //   1023	1078	1078	java/lang/SecurityException
    //   1161	1170	1078	java/lang/SecurityException
    //   1196	1206	1078	java/lang/SecurityException
    //   1206	1214	1078	java/lang/SecurityException
    //   1223	1229	1078	java/lang/SecurityException
    //   1229	1238	1078	java/lang/SecurityException
    //   1245	1262	1078	java/lang/SecurityException
    //   1271	1277	1078	java/lang/SecurityException
    //   1277	1279	1078	java/lang/SecurityException
    //   1279	1338	1078	java/lang/SecurityException
    //   905	914	1160	java/io/IOException
    //   182	190	1170	java/lang/RuntimeException
    //   197	202	1170	java/lang/RuntimeException
    //   212	221	1170	java/lang/RuntimeException
    //   228	236	1170	java/lang/RuntimeException
    //   248	281	1170	java/lang/RuntimeException
    //   288	295	1170	java/lang/RuntimeException
    //   302	311	1170	java/lang/RuntimeException
    //   332	367	1170	java/lang/RuntimeException
    //   377	386	1170	java/lang/RuntimeException
    //   407	442	1170	java/lang/RuntimeException
    //   452	462	1170	java/lang/RuntimeException
    //   500	514	1170	java/lang/RuntimeException
    //   524	538	1170	java/lang/RuntimeException
    //   548	556	1170	java/lang/RuntimeException
    //   563	568	1170	java/lang/RuntimeException
    //   575	615	1170	java/lang/RuntimeException
    //   635	645	1170	java/lang/RuntimeException
    //   665	675	1170	java/lang/RuntimeException
    //   682	689	1170	java/lang/RuntimeException
    //   696	704	1170	java/lang/RuntimeException
    //   721	756	1170	java/lang/RuntimeException
    //   761	796	1170	java/lang/RuntimeException
    //   799	806	1170	java/lang/RuntimeException
    //   811	818	1170	java/lang/RuntimeException
    //   823	849	1170	java/lang/RuntimeException
    //   855	862	1170	java/lang/RuntimeException
    //   870	880	1170	java/lang/RuntimeException
    //   880	905	1170	java/lang/RuntimeException
    //   905	914	1170	java/lang/RuntimeException
    //   914	976	1170	java/lang/RuntimeException
    //   976	989	1170	java/lang/RuntimeException
    //   1001	1011	1170	java/lang/RuntimeException
    //   1011	1019	1170	java/lang/RuntimeException
    //   1023	1078	1170	java/lang/RuntimeException
    //   1161	1170	1170	java/lang/RuntimeException
    //   1196	1206	1170	java/lang/RuntimeException
    //   1206	1214	1170	java/lang/RuntimeException
    //   1223	1229	1170	java/lang/RuntimeException
    //   1229	1238	1170	java/lang/RuntimeException
    //   1245	1262	1170	java/lang/RuntimeException
    //   1271	1277	1170	java/lang/RuntimeException
    //   1277	1279	1170	java/lang/RuntimeException
    //   1279	1338	1170	java/lang/RuntimeException
    //   1001	1011	1217	java/io/IOException
    //   1011	1019	1217	java/io/IOException
    //   1196	1206	1217	java/io/IOException
    //   1206	1214	1217	java/io/IOException
    //   1245	1262	1217	java/io/IOException
    //   182	190	1238	finally
    //   197	202	1238	finally
    //   212	221	1238	finally
    //   228	236	1238	finally
    //   248	281	1238	finally
    //   288	295	1238	finally
    //   302	311	1238	finally
    //   332	367	1238	finally
    //   377	386	1238	finally
    //   407	442	1238	finally
    //   452	462	1238	finally
    //   500	514	1238	finally
    //   524	538	1238	finally
    //   548	556	1238	finally
    //   563	568	1238	finally
    //   575	615	1238	finally
    //   635	645	1238	finally
    //   665	675	1238	finally
    //   682	689	1238	finally
    //   696	704	1238	finally
    //   721	756	1238	finally
    //   761	796	1238	finally
    //   799	806	1238	finally
    //   811	818	1238	finally
    //   823	849	1238	finally
    //   855	862	1238	finally
    //   870	880	1238	finally
    //   880	905	1238	finally
    //   905	914	1238	finally
    //   914	976	1238	finally
    //   976	989	1238	finally
    //   1001	1011	1238	finally
    //   1011	1019	1238	finally
    //   1023	1078	1238	finally
    //   1079	1100	1238	finally
    //   1161	1170	1238	finally
    //   1196	1206	1238	finally
    //   1206	1214	1238	finally
    //   1223	1229	1238	finally
    //   1229	1238	1238	finally
    //   1245	1262	1238	finally
    //   1271	1277	1238	finally
    //   1277	1279	1238	finally
    //   1279	1338	1238	finally
    //   1001	1011	1265	java/lang/Error
    //   1011	1019	1265	java/lang/Error
    //   1196	1206	1265	java/lang/Error
    //   1206	1214	1265	java/lang/Error
    //   1245	1262	1265	java/lang/Error
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
    //   12: getstatic 35	com/vladium/util/IConstants:EMPTY_FILE_ARRAY	[Ljava/io/File;
    //   15: putfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_1
    //   24: invokestatic 302	com/vladium/util/Files:pathToFiles	([Ljava/lang/String;Z)[Ljava/io/File;
    //   27: putfield 37	com/vladium/emma/data/MergeProcessor:m_dataPath	[Ljava/io/File;
    //   30: goto -12 -> 18
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	MergeProcessor
    //   0	38	1	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   6	11	33	finally
    //   11	18	33	finally
    //   21	30	33	finally
  }
  
  public final void setSessionOutFile(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.m_sdataOutFile = null;
        return;
      }
      finally {}
      paramString = new File(paramString);
      if ((paramString.exists()) && (!paramString.isFile())) {
        throw new IllegalArgumentException("not a file: [" + paramString.getAbsolutePath() + "]");
      }
      this.m_sdataOutFile = paramString;
    }
  }
  
  protected void validateState()
  {
    super.validateState();
    if (this.m_dataPath == null) {
      throw new IllegalStateException("data path not set");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/MergeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */