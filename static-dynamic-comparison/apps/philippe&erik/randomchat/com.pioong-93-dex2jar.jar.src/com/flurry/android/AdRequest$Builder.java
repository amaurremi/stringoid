package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;
import java.util.Map;

public class AdRequest$Builder
  extends SpecificRecordBuilderBase<AdRequest>
  implements RecordBuilder<AdRequest>
{
  private long bU;
  private CharSequence bX;
  private CharSequence bY;
  private CharSequence bZ;
  private List<AdReportedId> ca;
  private Location cb;
  private boolean cc;
  private List<Integer> cd;
  private AdViewContainer ce;
  private CharSequence cf;
  private CharSequence cg;
  private CharSequence ch;
  private CharSequence ci;
  private TestAds cj;
  private Map<CharSequence, CharSequence> ck;
  private boolean cl;
  private int cm;
  private boolean cn;
  private List<FrequencyCapInfo> co;
  
  private AdRequest$Builder(byte paramByte)
  {
    super(AdRequest.SCHEMA$);
  }
  
  /* Error */
  public AdRequest build()
  {
    // Byte code:
    //   0: new 47	com/flurry/android/AdRequest
    //   3: dup
    //   4: invokespecial 60	com/flurry/android/AdRequest:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +424 -> 439
    //   18: aload_0
    //   19: getfield 66	com/flurry/android/AdRequest$Builder:bX	Ljava/lang/CharSequence;
    //   22: astore 5
    //   24: aload 6
    //   26: aload 5
    //   28: putfield 67	com/flurry/android/AdRequest:bX	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +420 -> 457
    //   40: aload_0
    //   41: getfield 69	com/flurry/android/AdRequest$Builder:bY	Ljava/lang/CharSequence;
    //   44: astore 5
    //   46: aload 6
    //   48: aload 5
    //   50: putfield 70	com/flurry/android/AdRequest:bY	Ljava/lang/CharSequence;
    //   53: aload_0
    //   54: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   57: iconst_2
    //   58: baload
    //   59: ifeq +416 -> 475
    //   62: aload_0
    //   63: getfield 72	com/flurry/android/AdRequest$Builder:bZ	Ljava/lang/CharSequence;
    //   66: astore 5
    //   68: aload 6
    //   70: aload 5
    //   72: putfield 73	com/flurry/android/AdRequest:bZ	Ljava/lang/CharSequence;
    //   75: aload_0
    //   76: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   79: iconst_3
    //   80: baload
    //   81: ifeq +412 -> 493
    //   84: aload_0
    //   85: getfield 75	com/flurry/android/AdRequest$Builder:bU	J
    //   88: lstore_2
    //   89: aload 6
    //   91: lload_2
    //   92: putfield 76	com/flurry/android/AdRequest:bU	J
    //   95: aload_0
    //   96: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   99: iconst_4
    //   100: baload
    //   101: ifeq +412 -> 513
    //   104: aload_0
    //   105: getfield 78	com/flurry/android/AdRequest$Builder:ca	Ljava/util/List;
    //   108: astore 5
    //   110: aload 6
    //   112: aload 5
    //   114: putfield 79	com/flurry/android/AdRequest:ca	Ljava/util/List;
    //   117: aload_0
    //   118: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   121: iconst_5
    //   122: baload
    //   123: ifeq +408 -> 531
    //   126: aload_0
    //   127: getfield 81	com/flurry/android/AdRequest$Builder:cb	Lcom/flurry/android/Location;
    //   130: astore 5
    //   132: aload 6
    //   134: aload 5
    //   136: putfield 82	com/flurry/android/AdRequest:cb	Lcom/flurry/android/Location;
    //   139: aload_0
    //   140: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   143: bipush 6
    //   145: baload
    //   146: ifeq +403 -> 549
    //   149: aload_0
    //   150: getfield 84	com/flurry/android/AdRequest$Builder:cc	Z
    //   153: istore 4
    //   155: aload 6
    //   157: iload 4
    //   159: putfield 85	com/flurry/android/AdRequest:cc	Z
    //   162: aload_0
    //   163: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   166: bipush 7
    //   168: baload
    //   169: ifeq +402 -> 571
    //   172: aload_0
    //   173: getfield 87	com/flurry/android/AdRequest$Builder:cd	Ljava/util/List;
    //   176: astore 5
    //   178: aload 6
    //   180: aload 5
    //   182: putfield 88	com/flurry/android/AdRequest:cd	Ljava/util/List;
    //   185: aload_0
    //   186: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   189: bipush 8
    //   191: baload
    //   192: ifeq +398 -> 590
    //   195: aload_0
    //   196: getfield 90	com/flurry/android/AdRequest$Builder:ce	Lcom/flurry/android/AdViewContainer;
    //   199: astore 5
    //   201: aload 6
    //   203: aload 5
    //   205: putfield 91	com/flurry/android/AdRequest:ce	Lcom/flurry/android/AdViewContainer;
    //   208: aload_0
    //   209: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   212: bipush 9
    //   214: baload
    //   215: ifeq +394 -> 609
    //   218: aload_0
    //   219: getfield 93	com/flurry/android/AdRequest$Builder:cf	Ljava/lang/CharSequence;
    //   222: astore 5
    //   224: aload 6
    //   226: aload 5
    //   228: putfield 94	com/flurry/android/AdRequest:cf	Ljava/lang/CharSequence;
    //   231: aload_0
    //   232: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   235: bipush 10
    //   237: baload
    //   238: ifeq +390 -> 628
    //   241: aload_0
    //   242: getfield 96	com/flurry/android/AdRequest$Builder:cg	Ljava/lang/CharSequence;
    //   245: astore 5
    //   247: aload 6
    //   249: aload 5
    //   251: putfield 97	com/flurry/android/AdRequest:cg	Ljava/lang/CharSequence;
    //   254: aload_0
    //   255: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   258: bipush 11
    //   260: baload
    //   261: ifeq +386 -> 647
    //   264: aload_0
    //   265: getfield 99	com/flurry/android/AdRequest$Builder:ch	Ljava/lang/CharSequence;
    //   268: astore 5
    //   270: aload 6
    //   272: aload 5
    //   274: putfield 100	com/flurry/android/AdRequest:ch	Ljava/lang/CharSequence;
    //   277: aload_0
    //   278: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   281: bipush 12
    //   283: baload
    //   284: ifeq +382 -> 666
    //   287: aload_0
    //   288: getfield 102	com/flurry/android/AdRequest$Builder:ci	Ljava/lang/CharSequence;
    //   291: astore 5
    //   293: aload 6
    //   295: aload 5
    //   297: putfield 103	com/flurry/android/AdRequest:ci	Ljava/lang/CharSequence;
    //   300: aload_0
    //   301: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   304: bipush 13
    //   306: baload
    //   307: ifeq +378 -> 685
    //   310: aload_0
    //   311: getfield 105	com/flurry/android/AdRequest$Builder:cj	Lcom/flurry/android/TestAds;
    //   314: astore 5
    //   316: aload 6
    //   318: aload 5
    //   320: putfield 106	com/flurry/android/AdRequest:cj	Lcom/flurry/android/TestAds;
    //   323: aload_0
    //   324: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   327: bipush 14
    //   329: baload
    //   330: ifeq +374 -> 704
    //   333: aload_0
    //   334: getfield 108	com/flurry/android/AdRequest$Builder:ck	Ljava/util/Map;
    //   337: astore 5
    //   339: aload 6
    //   341: aload 5
    //   343: putfield 109	com/flurry/android/AdRequest:ck	Ljava/util/Map;
    //   346: aload_0
    //   347: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   350: bipush 15
    //   352: baload
    //   353: ifeq +370 -> 723
    //   356: aload_0
    //   357: getfield 111	com/flurry/android/AdRequest$Builder:cl	Z
    //   360: istore 4
    //   362: aload 6
    //   364: iload 4
    //   366: putfield 112	com/flurry/android/AdRequest:cl	Z
    //   369: aload_0
    //   370: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   373: bipush 16
    //   375: baload
    //   376: ifeq +369 -> 745
    //   379: aload_0
    //   380: getfield 114	com/flurry/android/AdRequest$Builder:cm	I
    //   383: istore_1
    //   384: aload 6
    //   386: iload_1
    //   387: putfield 115	com/flurry/android/AdRequest:cm	I
    //   390: aload_0
    //   391: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   394: bipush 17
    //   396: baload
    //   397: ifeq +369 -> 766
    //   400: aload_0
    //   401: getfield 117	com/flurry/android/AdRequest$Builder:cn	Z
    //   404: istore 4
    //   406: aload 6
    //   408: iload 4
    //   410: putfield 118	com/flurry/android/AdRequest:cn	Z
    //   413: aload_0
    //   414: invokevirtual 64	com/flurry/android/AdRequest$Builder:fieldSetFlags	()[Z
    //   417: bipush 18
    //   419: baload
    //   420: ifeq +368 -> 788
    //   423: aload_0
    //   424: getfield 120	com/flurry/android/AdRequest$Builder:co	Ljava/util/List;
    //   427: astore 5
    //   429: aload 6
    //   431: aload 5
    //   433: putfield 121	com/flurry/android/AdRequest:co	Ljava/util/List;
    //   436: aload 6
    //   438: areturn
    //   439: aload_0
    //   440: aload_0
    //   441: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   444: iconst_0
    //   445: aaload
    //   446: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   449: checkcast 131	java/lang/CharSequence
    //   452: astore 5
    //   454: goto -430 -> 24
    //   457: aload_0
    //   458: aload_0
    //   459: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   462: iconst_1
    //   463: aaload
    //   464: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   467: checkcast 131	java/lang/CharSequence
    //   470: astore 5
    //   472: goto -426 -> 46
    //   475: aload_0
    //   476: aload_0
    //   477: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   480: iconst_2
    //   481: aaload
    //   482: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   485: checkcast 131	java/lang/CharSequence
    //   488: astore 5
    //   490: goto -422 -> 68
    //   493: aload_0
    //   494: aload_0
    //   495: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   498: iconst_3
    //   499: aaload
    //   500: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   503: checkcast 133	java/lang/Long
    //   506: invokevirtual 137	java/lang/Long:longValue	()J
    //   509: lstore_2
    //   510: goto -421 -> 89
    //   513: aload_0
    //   514: aload_0
    //   515: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   518: iconst_4
    //   519: aaload
    //   520: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   523: checkcast 139	java/util/List
    //   526: astore 5
    //   528: goto -418 -> 110
    //   531: aload_0
    //   532: aload_0
    //   533: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   536: iconst_5
    //   537: aaload
    //   538: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   541: checkcast 141	com/flurry/android/Location
    //   544: astore 5
    //   546: goto -414 -> 132
    //   549: aload_0
    //   550: aload_0
    //   551: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   554: bipush 6
    //   556: aaload
    //   557: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   560: checkcast 143	java/lang/Boolean
    //   563: invokevirtual 147	java/lang/Boolean:booleanValue	()Z
    //   566: istore 4
    //   568: goto -413 -> 155
    //   571: aload_0
    //   572: aload_0
    //   573: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   576: bipush 7
    //   578: aaload
    //   579: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   582: checkcast 139	java/util/List
    //   585: astore 5
    //   587: goto -409 -> 178
    //   590: aload_0
    //   591: aload_0
    //   592: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   595: bipush 8
    //   597: aaload
    //   598: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   601: checkcast 149	com/flurry/android/AdViewContainer
    //   604: astore 5
    //   606: goto -405 -> 201
    //   609: aload_0
    //   610: aload_0
    //   611: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   614: bipush 9
    //   616: aaload
    //   617: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   620: checkcast 131	java/lang/CharSequence
    //   623: astore 5
    //   625: goto -401 -> 224
    //   628: aload_0
    //   629: aload_0
    //   630: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   633: bipush 10
    //   635: aaload
    //   636: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   639: checkcast 131	java/lang/CharSequence
    //   642: astore 5
    //   644: goto -397 -> 247
    //   647: aload_0
    //   648: aload_0
    //   649: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   652: bipush 11
    //   654: aaload
    //   655: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   658: checkcast 131	java/lang/CharSequence
    //   661: astore 5
    //   663: goto -393 -> 270
    //   666: aload_0
    //   667: aload_0
    //   668: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   671: bipush 12
    //   673: aaload
    //   674: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   677: checkcast 131	java/lang/CharSequence
    //   680: astore 5
    //   682: goto -389 -> 293
    //   685: aload_0
    //   686: aload_0
    //   687: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   690: bipush 13
    //   692: aaload
    //   693: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   696: checkcast 151	com/flurry/android/TestAds
    //   699: astore 5
    //   701: goto -385 -> 316
    //   704: aload_0
    //   705: aload_0
    //   706: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   709: bipush 14
    //   711: aaload
    //   712: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   715: checkcast 153	java/util/Map
    //   718: astore 5
    //   720: goto -381 -> 339
    //   723: aload_0
    //   724: aload_0
    //   725: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   728: bipush 15
    //   730: aaload
    //   731: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   734: checkcast 143	java/lang/Boolean
    //   737: invokevirtual 147	java/lang/Boolean:booleanValue	()Z
    //   740: istore 4
    //   742: goto -380 -> 362
    //   745: aload_0
    //   746: aload_0
    //   747: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   750: bipush 16
    //   752: aaload
    //   753: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   756: checkcast 155	java/lang/Integer
    //   759: invokevirtual 159	java/lang/Integer:intValue	()I
    //   762: istore_1
    //   763: goto -379 -> 384
    //   766: aload_0
    //   767: aload_0
    //   768: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   771: bipush 17
    //   773: aaload
    //   774: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   777: checkcast 143	java/lang/Boolean
    //   780: invokevirtual 147	java/lang/Boolean:booleanValue	()Z
    //   783: istore 4
    //   785: goto -379 -> 406
    //   788: aload_0
    //   789: aload_0
    //   790: invokevirtual 125	com/flurry/android/AdRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   793: bipush 18
    //   795: aaload
    //   796: invokevirtual 129	com/flurry/android/AdRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   799: checkcast 139	java/util/List
    //   802: astore 5
    //   804: goto -375 -> 429
    //   807: astore 5
    //   809: new 161	com/flurry/org/apache/avro/AvroRuntimeException
    //   812: dup
    //   813: aload 5
    //   815: invokespecial 164	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   818: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	Builder
    //   383	380	1	i	int
    //   88	422	2	l	long
    //   153	631	4	bool	boolean
    //   22	781	5	localObject	Object
    //   807	7	5	localException	Exception
    //   7	430	6	localAdRequest	AdRequest
    // Exception table:
    //   from	to	target	type
    //   0	24	807	java/lang/Exception
    //   24	46	807	java/lang/Exception
    //   46	68	807	java/lang/Exception
    //   68	89	807	java/lang/Exception
    //   89	110	807	java/lang/Exception
    //   110	132	807	java/lang/Exception
    //   132	155	807	java/lang/Exception
    //   155	178	807	java/lang/Exception
    //   178	201	807	java/lang/Exception
    //   201	224	807	java/lang/Exception
    //   224	247	807	java/lang/Exception
    //   247	270	807	java/lang/Exception
    //   270	293	807	java/lang/Exception
    //   293	316	807	java/lang/Exception
    //   316	339	807	java/lang/Exception
    //   339	362	807	java/lang/Exception
    //   362	384	807	java/lang/Exception
    //   384	406	807	java/lang/Exception
    //   406	429	807	java/lang/Exception
    //   429	436	807	java/lang/Exception
    //   439	454	807	java/lang/Exception
    //   457	472	807	java/lang/Exception
    //   475	490	807	java/lang/Exception
    //   493	510	807	java/lang/Exception
    //   513	528	807	java/lang/Exception
    //   531	546	807	java/lang/Exception
    //   549	568	807	java/lang/Exception
    //   571	587	807	java/lang/Exception
    //   590	606	807	java/lang/Exception
    //   609	625	807	java/lang/Exception
    //   628	644	807	java/lang/Exception
    //   647	663	807	java/lang/Exception
    //   666	682	807	java/lang/Exception
    //   685	701	807	java/lang/Exception
    //   704	720	807	java/lang/Exception
    //   723	742	807	java/lang/Exception
    //   745	763	807	java/lang/Exception
    //   766	785	807	java/lang/Exception
    //   788	804	807	java/lang/Exception
  }
  
  public Builder clearAdReportedIds()
  {
    this.ca = null;
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public Builder clearAdSpaceName()
  {
    this.bZ = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearAdViewContainer()
  {
    this.ce = null;
    fieldSetFlags()[8] = 0;
    return this;
  }
  
  public Builder clearAgentVersion()
  {
    this.bY = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearApiKey()
  {
    this.bX = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearBindings()
  {
    this.cd = null;
    fieldSetFlags()[7] = 0;
    return this;
  }
  
  public Builder clearCanDoSKAppStore()
  {
    fieldSetFlags()[17] = 0;
    return this;
  }
  
  public Builder clearDevicePlatform()
  {
    this.ci = null;
    fieldSetFlags()[12] = 0;
    return this;
  }
  
  public Builder clearFrequencyCapInfos()
  {
    this.co = null;
    fieldSetFlags()[18] = 0;
    return this;
  }
  
  public Builder clearKeywords()
  {
    this.ck = null;
    fieldSetFlags()[14] = 0;
    return this;
  }
  
  public Builder clearLocale()
  {
    this.cf = null;
    fieldSetFlags()[9] = 0;
    return this;
  }
  
  public Builder clearLocation()
  {
    this.cb = null;
    fieldSetFlags()[5] = 0;
    return this;
  }
  
  public Builder clearNetworkStatus()
  {
    fieldSetFlags()[16] = 0;
    return this;
  }
  
  public Builder clearOsVersion()
  {
    this.ch = null;
    fieldSetFlags()[11] = 0;
    return this;
  }
  
  public Builder clearRefresh()
  {
    fieldSetFlags()[15] = 0;
    return this;
  }
  
  public Builder clearSessionId()
  {
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Builder clearTestAds()
  {
    this.cj = null;
    fieldSetFlags()[13] = 0;
    return this;
  }
  
  public Builder clearTestDevice()
  {
    fieldSetFlags()[6] = 0;
    return this;
  }
  
  public Builder clearTimezone()
  {
    this.cg = null;
    fieldSetFlags()[10] = 0;
    return this;
  }
  
  public List<AdReportedId> getAdReportedIds()
  {
    return this.ca;
  }
  
  public CharSequence getAdSpaceName()
  {
    return this.bZ;
  }
  
  public AdViewContainer getAdViewContainer()
  {
    return this.ce;
  }
  
  public CharSequence getAgentVersion()
  {
    return this.bY;
  }
  
  public CharSequence getApiKey()
  {
    return this.bX;
  }
  
  public List<Integer> getBindings()
  {
    return this.cd;
  }
  
  public Boolean getCanDoSKAppStore()
  {
    return Boolean.valueOf(this.cn);
  }
  
  public CharSequence getDevicePlatform()
  {
    return this.ci;
  }
  
  public List<FrequencyCapInfo> getFrequencyCapInfos()
  {
    return this.co;
  }
  
  public Map<CharSequence, CharSequence> getKeywords()
  {
    return this.ck;
  }
  
  public CharSequence getLocale()
  {
    return this.cf;
  }
  
  public Location getLocation()
  {
    return this.cb;
  }
  
  public Integer getNetworkStatus()
  {
    return Integer.valueOf(this.cm);
  }
  
  public CharSequence getOsVersion()
  {
    return this.ch;
  }
  
  public Boolean getRefresh()
  {
    return Boolean.valueOf(this.cl);
  }
  
  public Long getSessionId()
  {
    return Long.valueOf(this.bU);
  }
  
  public TestAds getTestAds()
  {
    return this.cj;
  }
  
  public Boolean getTestDevice()
  {
    return Boolean.valueOf(this.cc);
  }
  
  public CharSequence getTimezone()
  {
    return this.cg;
  }
  
  public boolean hasAdReportedIds()
  {
    return fieldSetFlags()[4];
  }
  
  public boolean hasAdSpaceName()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasAdViewContainer()
  {
    return fieldSetFlags()[8];
  }
  
  public boolean hasAgentVersion()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasApiKey()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasBindings()
  {
    return fieldSetFlags()[7];
  }
  
  public boolean hasCanDoSKAppStore()
  {
    return fieldSetFlags()[17];
  }
  
  public boolean hasDevicePlatform()
  {
    return fieldSetFlags()[12];
  }
  
  public boolean hasFrequencyCapInfos()
  {
    return fieldSetFlags()[18];
  }
  
  public boolean hasKeywords()
  {
    return fieldSetFlags()[14];
  }
  
  public boolean hasLocale()
  {
    return fieldSetFlags()[9];
  }
  
  public boolean hasLocation()
  {
    return fieldSetFlags()[5];
  }
  
  public boolean hasNetworkStatus()
  {
    return fieldSetFlags()[16];
  }
  
  public boolean hasOsVersion()
  {
    return fieldSetFlags()[11];
  }
  
  public boolean hasRefresh()
  {
    return fieldSetFlags()[15];
  }
  
  public boolean hasSessionId()
  {
    return fieldSetFlags()[3];
  }
  
  public boolean hasTestAds()
  {
    return fieldSetFlags()[13];
  }
  
  public boolean hasTestDevice()
  {
    return fieldSetFlags()[6];
  }
  
  public boolean hasTimezone()
  {
    return fieldSetFlags()[10];
  }
  
  public Builder setAdReportedIds(List<AdReportedId> paramList)
  {
    validate(fields()[4], paramList);
    this.ca = paramList;
    fieldSetFlags()[4] = 1;
    return this;
  }
  
  public Builder setAdSpaceName(CharSequence paramCharSequence)
  {
    validate(fields()[2], paramCharSequence);
    this.bZ = paramCharSequence;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setAdViewContainer(AdViewContainer paramAdViewContainer)
  {
    validate(fields()[8], paramAdViewContainer);
    this.ce = paramAdViewContainer;
    fieldSetFlags()[8] = 1;
    return this;
  }
  
  public Builder setAgentVersion(CharSequence paramCharSequence)
  {
    validate(fields()[1], paramCharSequence);
    this.bY = paramCharSequence;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setApiKey(CharSequence paramCharSequence)
  {
    validate(fields()[0], paramCharSequence);
    this.bX = paramCharSequence;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setBindings(List<Integer> paramList)
  {
    validate(fields()[7], paramList);
    this.cd = paramList;
    fieldSetFlags()[7] = 1;
    return this;
  }
  
  public Builder setCanDoSKAppStore(boolean paramBoolean)
  {
    validate(fields()[17], Boolean.valueOf(paramBoolean));
    this.cn = paramBoolean;
    fieldSetFlags()[17] = 1;
    return this;
  }
  
  public Builder setDevicePlatform(CharSequence paramCharSequence)
  {
    validate(fields()[12], paramCharSequence);
    this.ci = paramCharSequence;
    fieldSetFlags()[12] = 1;
    return this;
  }
  
  public Builder setFrequencyCapInfos(List<FrequencyCapInfo> paramList)
  {
    validate(fields()[18], paramList);
    this.co = paramList;
    fieldSetFlags()[18] = 1;
    return this;
  }
  
  public Builder setKeywords(Map<CharSequence, CharSequence> paramMap)
  {
    validate(fields()[14], paramMap);
    this.ck = paramMap;
    fieldSetFlags()[14] = 1;
    return this;
  }
  
  public Builder setLocale(CharSequence paramCharSequence)
  {
    validate(fields()[9], paramCharSequence);
    this.cf = paramCharSequence;
    fieldSetFlags()[9] = 1;
    return this;
  }
  
  public Builder setLocation(Location paramLocation)
  {
    validate(fields()[5], paramLocation);
    this.cb = paramLocation;
    fieldSetFlags()[5] = 1;
    return this;
  }
  
  public Builder setNetworkStatus(int paramInt)
  {
    validate(fields()[16], Integer.valueOf(paramInt));
    this.cm = paramInt;
    fieldSetFlags()[16] = 1;
    return this;
  }
  
  public Builder setOsVersion(CharSequence paramCharSequence)
  {
    validate(fields()[11], paramCharSequence);
    this.ch = paramCharSequence;
    fieldSetFlags()[11] = 1;
    return this;
  }
  
  public Builder setRefresh(boolean paramBoolean)
  {
    validate(fields()[15], Boolean.valueOf(paramBoolean));
    this.cl = paramBoolean;
    fieldSetFlags()[15] = 1;
    return this;
  }
  
  public Builder setSessionId(long paramLong)
  {
    validate(fields()[3], Long.valueOf(paramLong));
    this.bU = paramLong;
    fieldSetFlags()[3] = 1;
    return this;
  }
  
  public Builder setTestAds(TestAds paramTestAds)
  {
    validate(fields()[13], paramTestAds);
    this.cj = paramTestAds;
    fieldSetFlags()[13] = 1;
    return this;
  }
  
  public Builder setTestDevice(boolean paramBoolean)
  {
    validate(fields()[6], Boolean.valueOf(paramBoolean));
    this.cc = paramBoolean;
    fieldSetFlags()[6] = 1;
    return this;
  }
  
  public Builder setTimezone(CharSequence paramCharSequence)
  {
    validate(fields()[10], paramCharSequence);
    this.cg = paramCharSequence;
    fieldSetFlags()[10] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */