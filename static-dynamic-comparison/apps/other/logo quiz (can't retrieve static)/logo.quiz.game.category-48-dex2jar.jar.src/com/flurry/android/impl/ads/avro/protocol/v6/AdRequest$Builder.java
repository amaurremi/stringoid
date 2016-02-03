package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.nv;
import java.util.List;
import java.util.Map;

public class AdRequest$Builder
  extends nv<AdRequest>
{
  private CharSequence a;
  private CharSequence b;
  private CharSequence c;
  private long d;
  private List<AdReportedId> e;
  private Location f;
  private boolean g;
  private List<Integer> h;
  private AdViewContainer i;
  private CharSequence j;
  private CharSequence k;
  private CharSequence l;
  private CharSequence m;
  private TestAds n;
  private Map<CharSequence, CharSequence> o;
  private boolean p;
  private boolean q;
  private int r;
  private List<FrequencyCapInfo> s;
  private boolean t;
  private CharSequence u;
  private List<CharSequence> v;
  
  private AdRequest$Builder()
  {
    super(AdRequest.SCHEMA$);
  }
  
  public Builder a(int paramInt)
  {
    a(b()[17], Integer.valueOf(paramInt));
    this.r = paramInt;
    c()[17] = 1;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    a(b()[3], Long.valueOf(paramLong));
    this.d = paramLong;
    c()[3] = 1;
    return this;
  }
  
  public Builder a(AdViewContainer paramAdViewContainer)
  {
    a(b()[8], paramAdViewContainer);
    this.i = paramAdViewContainer;
    c()[8] = 1;
    return this;
  }
  
  public Builder a(Location paramLocation)
  {
    a(b()[5], paramLocation);
    this.f = paramLocation;
    c()[5] = 1;
    return this;
  }
  
  public Builder a(CharSequence paramCharSequence)
  {
    a(b()[0], paramCharSequence);
    this.a = paramCharSequence;
    c()[0] = 1;
    return this;
  }
  
  public Builder a(List<AdReportedId> paramList)
  {
    a(b()[4], paramList);
    this.e = paramList;
    c()[4] = 1;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    a(b()[6], Boolean.valueOf(paramBoolean));
    this.g = paramBoolean;
    c()[6] = 1;
    return this;
  }
  
  /* Error */
  public AdRequest a()
  {
    // Byte code:
    //   0: new 45	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest
    //   3: dup
    //   4: invokespecial 108	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +493 -> 508
    //   18: aload_0
    //   19: getfield 91	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	Ljava/lang/CharSequence;
    //   22: astore 5
    //   24: aload 6
    //   26: aload 5
    //   28: putfield 109	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:a	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +489 -> 526
    //   40: aload_0
    //   41: getfield 111	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	Ljava/lang/CharSequence;
    //   44: astore 5
    //   46: aload 6
    //   48: aload 5
    //   50: putfield 112	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:b	Ljava/lang/CharSequence;
    //   53: aload_0
    //   54: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   57: iconst_2
    //   58: baload
    //   59: ifeq +485 -> 544
    //   62: aload_0
    //   63: getfield 114	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	Ljava/lang/CharSequence;
    //   66: astore 5
    //   68: aload 6
    //   70: aload 5
    //   72: putfield 115	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:c	Ljava/lang/CharSequence;
    //   75: aload_0
    //   76: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   79: iconst_3
    //   80: baload
    //   81: ifeq +481 -> 562
    //   84: aload_0
    //   85: getfield 82	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:d	J
    //   88: lstore_2
    //   89: aload 6
    //   91: lload_2
    //   92: putfield 116	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:d	J
    //   95: aload_0
    //   96: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   99: iconst_4
    //   100: baload
    //   101: ifeq +481 -> 582
    //   104: aload_0
    //   105: getfield 94	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:e	Ljava/util/List;
    //   108: astore 5
    //   110: aload 6
    //   112: aload 5
    //   114: putfield 117	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:e	Ljava/util/List;
    //   117: aload_0
    //   118: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   121: iconst_5
    //   122: baload
    //   123: ifeq +477 -> 600
    //   126: aload_0
    //   127: getfield 88	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:f	Lcom/flurry/android/impl/ads/avro/protocol/v6/Location;
    //   130: astore 5
    //   132: aload 6
    //   134: aload 5
    //   136: putfield 118	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:f	Lcom/flurry/android/impl/ads/avro/protocol/v6/Location;
    //   139: aload_0
    //   140: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   143: bipush 6
    //   145: baload
    //   146: ifeq +472 -> 618
    //   149: aload_0
    //   150: getfield 104	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:g	Z
    //   153: istore 4
    //   155: aload 6
    //   157: iload 4
    //   159: putfield 119	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:g	Z
    //   162: aload_0
    //   163: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   166: bipush 7
    //   168: baload
    //   169: ifeq +471 -> 640
    //   172: aload_0
    //   173: getfield 121	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:h	Ljava/util/List;
    //   176: astore 5
    //   178: aload 6
    //   180: aload 5
    //   182: putfield 122	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:h	Ljava/util/List;
    //   185: aload_0
    //   186: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   189: bipush 8
    //   191: baload
    //   192: ifeq +467 -> 659
    //   195: aload_0
    //   196: getfield 85	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:i	Lcom/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer;
    //   199: astore 5
    //   201: aload 6
    //   203: aload 5
    //   205: putfield 123	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:i	Lcom/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer;
    //   208: aload_0
    //   209: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   212: bipush 9
    //   214: baload
    //   215: ifeq +463 -> 678
    //   218: aload_0
    //   219: getfield 125	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:j	Ljava/lang/CharSequence;
    //   222: astore 5
    //   224: aload 6
    //   226: aload 5
    //   228: putfield 126	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:j	Ljava/lang/CharSequence;
    //   231: aload_0
    //   232: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   235: bipush 10
    //   237: baload
    //   238: ifeq +459 -> 697
    //   241: aload_0
    //   242: getfield 128	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:k	Ljava/lang/CharSequence;
    //   245: astore 5
    //   247: aload 6
    //   249: aload 5
    //   251: putfield 129	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:k	Ljava/lang/CharSequence;
    //   254: aload_0
    //   255: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   258: bipush 11
    //   260: baload
    //   261: ifeq +455 -> 716
    //   264: aload_0
    //   265: getfield 131	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:l	Ljava/lang/CharSequence;
    //   268: astore 5
    //   270: aload 6
    //   272: aload 5
    //   274: putfield 132	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:l	Ljava/lang/CharSequence;
    //   277: aload_0
    //   278: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   281: bipush 12
    //   283: baload
    //   284: ifeq +451 -> 735
    //   287: aload_0
    //   288: getfield 134	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:m	Ljava/lang/CharSequence;
    //   291: astore 5
    //   293: aload 6
    //   295: aload 5
    //   297: putfield 135	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:m	Ljava/lang/CharSequence;
    //   300: aload_0
    //   301: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   304: bipush 13
    //   306: baload
    //   307: ifeq +447 -> 754
    //   310: aload_0
    //   311: getfield 137	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:n	Lcom/flurry/android/impl/ads/avro/protocol/v6/TestAds;
    //   314: astore 5
    //   316: aload 6
    //   318: aload 5
    //   320: putfield 138	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:n	Lcom/flurry/android/impl/ads/avro/protocol/v6/TestAds;
    //   323: aload_0
    //   324: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   327: bipush 14
    //   329: baload
    //   330: ifeq +443 -> 773
    //   333: aload_0
    //   334: getfield 140	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:o	Ljava/util/Map;
    //   337: astore 5
    //   339: aload 6
    //   341: aload 5
    //   343: putfield 141	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:o	Ljava/util/Map;
    //   346: aload_0
    //   347: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   350: bipush 15
    //   352: baload
    //   353: ifeq +439 -> 792
    //   356: aload_0
    //   357: getfield 143	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:p	Z
    //   360: istore 4
    //   362: aload 6
    //   364: iload 4
    //   366: putfield 144	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:p	Z
    //   369: aload_0
    //   370: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   373: bipush 16
    //   375: baload
    //   376: ifeq +438 -> 814
    //   379: aload_0
    //   380: getfield 146	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:q	Z
    //   383: istore 4
    //   385: aload 6
    //   387: iload 4
    //   389: putfield 147	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:q	Z
    //   392: aload_0
    //   393: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   396: bipush 17
    //   398: baload
    //   399: ifeq +437 -> 836
    //   402: aload_0
    //   403: getfield 71	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:r	I
    //   406: istore_1
    //   407: aload 6
    //   409: iload_1
    //   410: putfield 148	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:r	I
    //   413: aload_0
    //   414: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   417: bipush 18
    //   419: baload
    //   420: ifeq +437 -> 857
    //   423: aload_0
    //   424: getfield 150	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:s	Ljava/util/List;
    //   427: astore 5
    //   429: aload 6
    //   431: aload 5
    //   433: putfield 151	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:s	Ljava/util/List;
    //   436: aload_0
    //   437: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   440: bipush 19
    //   442: baload
    //   443: ifeq +433 -> 876
    //   446: aload_0
    //   447: getfield 153	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:t	Z
    //   450: istore 4
    //   452: aload 6
    //   454: iload 4
    //   456: putfield 154	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:t	Z
    //   459: aload_0
    //   460: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   463: bipush 20
    //   465: baload
    //   466: ifeq +432 -> 898
    //   469: aload_0
    //   470: getfield 156	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:u	Ljava/lang/CharSequence;
    //   473: astore 5
    //   475: aload 6
    //   477: aload 5
    //   479: putfield 157	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:u	Ljava/lang/CharSequence;
    //   482: aload_0
    //   483: invokevirtual 74	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:c	()[Z
    //   486: bipush 21
    //   488: baload
    //   489: ifeq +428 -> 917
    //   492: aload_0
    //   493: getfield 159	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:v	Ljava/util/List;
    //   496: astore 5
    //   498: aload 6
    //   500: aload 5
    //   502: putfield 160	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest:v	Ljava/util/List;
    //   505: aload 6
    //   507: areturn
    //   508: aload_0
    //   509: aload_0
    //   510: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   513: iconst_0
    //   514: aaload
    //   515: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   518: checkcast 165	java/lang/CharSequence
    //   521: astore 5
    //   523: goto -499 -> 24
    //   526: aload_0
    //   527: aload_0
    //   528: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   531: iconst_1
    //   532: aaload
    //   533: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   536: checkcast 165	java/lang/CharSequence
    //   539: astore 5
    //   541: goto -495 -> 46
    //   544: aload_0
    //   545: aload_0
    //   546: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   549: iconst_2
    //   550: aaload
    //   551: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   554: checkcast 165	java/lang/CharSequence
    //   557: astore 5
    //   559: goto -491 -> 68
    //   562: aload_0
    //   563: aload_0
    //   564: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   567: iconst_3
    //   568: aaload
    //   569: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   572: checkcast 77	java/lang/Long
    //   575: invokevirtual 169	java/lang/Long:longValue	()J
    //   578: lstore_2
    //   579: goto -490 -> 89
    //   582: aload_0
    //   583: aload_0
    //   584: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   587: iconst_4
    //   588: aaload
    //   589: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   592: checkcast 171	java/util/List
    //   595: astore 5
    //   597: goto -487 -> 110
    //   600: aload_0
    //   601: aload_0
    //   602: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   605: iconst_5
    //   606: aaload
    //   607: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   610: checkcast 173	com/flurry/android/impl/ads/avro/protocol/v6/Location
    //   613: astore 5
    //   615: goto -483 -> 132
    //   618: aload_0
    //   619: aload_0
    //   620: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   623: bipush 6
    //   625: aaload
    //   626: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   629: checkcast 99	java/lang/Boolean
    //   632: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   635: istore 4
    //   637: goto -482 -> 155
    //   640: aload_0
    //   641: aload_0
    //   642: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   645: bipush 7
    //   647: aaload
    //   648: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   651: checkcast 171	java/util/List
    //   654: astore 5
    //   656: goto -478 -> 178
    //   659: aload_0
    //   660: aload_0
    //   661: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   664: bipush 8
    //   666: aaload
    //   667: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   670: checkcast 179	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer
    //   673: astore 5
    //   675: goto -474 -> 201
    //   678: aload_0
    //   679: aload_0
    //   680: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   683: bipush 9
    //   685: aaload
    //   686: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   689: checkcast 165	java/lang/CharSequence
    //   692: astore 5
    //   694: goto -470 -> 224
    //   697: aload_0
    //   698: aload_0
    //   699: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   702: bipush 10
    //   704: aaload
    //   705: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   708: checkcast 165	java/lang/CharSequence
    //   711: astore 5
    //   713: goto -466 -> 247
    //   716: aload_0
    //   717: aload_0
    //   718: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   721: bipush 11
    //   723: aaload
    //   724: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   727: checkcast 165	java/lang/CharSequence
    //   730: astore 5
    //   732: goto -462 -> 270
    //   735: aload_0
    //   736: aload_0
    //   737: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   740: bipush 12
    //   742: aaload
    //   743: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   746: checkcast 165	java/lang/CharSequence
    //   749: astore 5
    //   751: goto -458 -> 293
    //   754: aload_0
    //   755: aload_0
    //   756: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   759: bipush 13
    //   761: aaload
    //   762: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   765: checkcast 181	com/flurry/android/impl/ads/avro/protocol/v6/TestAds
    //   768: astore 5
    //   770: goto -454 -> 316
    //   773: aload_0
    //   774: aload_0
    //   775: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   778: bipush 14
    //   780: aaload
    //   781: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   784: checkcast 183	java/util/Map
    //   787: astore 5
    //   789: goto -450 -> 339
    //   792: aload_0
    //   793: aload_0
    //   794: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   797: bipush 15
    //   799: aaload
    //   800: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   803: checkcast 99	java/lang/Boolean
    //   806: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   809: istore 4
    //   811: goto -449 -> 362
    //   814: aload_0
    //   815: aload_0
    //   816: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   819: bipush 16
    //   821: aaload
    //   822: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   825: checkcast 99	java/lang/Boolean
    //   828: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   831: istore 4
    //   833: goto -448 -> 385
    //   836: aload_0
    //   837: aload_0
    //   838: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   841: bipush 17
    //   843: aaload
    //   844: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   847: checkcast 62	java/lang/Integer
    //   850: invokevirtual 187	java/lang/Integer:intValue	()I
    //   853: istore_1
    //   854: goto -447 -> 407
    //   857: aload_0
    //   858: aload_0
    //   859: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   862: bipush 18
    //   864: aaload
    //   865: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   868: checkcast 171	java/util/List
    //   871: astore 5
    //   873: goto -444 -> 429
    //   876: aload_0
    //   877: aload_0
    //   878: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   881: bipush 19
    //   883: aaload
    //   884: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   887: checkcast 99	java/lang/Boolean
    //   890: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   893: istore 4
    //   895: goto -443 -> 452
    //   898: aload_0
    //   899: aload_0
    //   900: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   903: bipush 20
    //   905: aaload
    //   906: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   909: checkcast 165	java/lang/CharSequence
    //   912: astore 5
    //   914: goto -439 -> 475
    //   917: aload_0
    //   918: aload_0
    //   919: invokevirtual 60	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   922: bipush 21
    //   924: aaload
    //   925: invokevirtual 163	com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   928: checkcast 171	java/util/List
    //   931: astore 5
    //   933: goto -435 -> 498
    //   936: astore 5
    //   938: new 189	com/flurry/android/monolithic/sdk/impl/jg
    //   941: dup
    //   942: aload 5
    //   944: invokespecial 192	com/flurry/android/monolithic/sdk/impl/jg:<init>	(Ljava/lang/Throwable;)V
    //   947: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	Builder
    //   406	448	1	i1	int
    //   88	491	2	l1	long
    //   153	741	4	bool	boolean
    //   22	910	5	localObject	Object
    //   936	7	5	localException	Exception
    //   7	499	6	localAdRequest	AdRequest
    // Exception table:
    //   from	to	target	type
    //   0	24	936	java/lang/Exception
    //   24	46	936	java/lang/Exception
    //   46	68	936	java/lang/Exception
    //   68	89	936	java/lang/Exception
    //   89	110	936	java/lang/Exception
    //   110	132	936	java/lang/Exception
    //   132	155	936	java/lang/Exception
    //   155	178	936	java/lang/Exception
    //   178	201	936	java/lang/Exception
    //   201	224	936	java/lang/Exception
    //   224	247	936	java/lang/Exception
    //   247	270	936	java/lang/Exception
    //   270	293	936	java/lang/Exception
    //   293	316	936	java/lang/Exception
    //   316	339	936	java/lang/Exception
    //   339	362	936	java/lang/Exception
    //   362	385	936	java/lang/Exception
    //   385	407	936	java/lang/Exception
    //   407	429	936	java/lang/Exception
    //   429	452	936	java/lang/Exception
    //   452	475	936	java/lang/Exception
    //   475	498	936	java/lang/Exception
    //   498	505	936	java/lang/Exception
    //   508	523	936	java/lang/Exception
    //   526	541	936	java/lang/Exception
    //   544	559	936	java/lang/Exception
    //   562	579	936	java/lang/Exception
    //   582	597	936	java/lang/Exception
    //   600	615	936	java/lang/Exception
    //   618	637	936	java/lang/Exception
    //   640	656	936	java/lang/Exception
    //   659	675	936	java/lang/Exception
    //   678	694	936	java/lang/Exception
    //   697	713	936	java/lang/Exception
    //   716	732	936	java/lang/Exception
    //   735	751	936	java/lang/Exception
    //   754	770	936	java/lang/Exception
    //   773	789	936	java/lang/Exception
    //   792	811	936	java/lang/Exception
    //   814	833	936	java/lang/Exception
    //   836	854	936	java/lang/Exception
    //   857	873	936	java/lang/Exception
    //   876	895	936	java/lang/Exception
    //   898	914	936	java/lang/Exception
    //   917	933	936	java/lang/Exception
  }
  
  public Builder b(CharSequence paramCharSequence)
  {
    a(b()[1], paramCharSequence);
    this.b = paramCharSequence;
    c()[1] = 1;
    return this;
  }
  
  public Builder b(List<Integer> paramList)
  {
    a(b()[7], paramList);
    this.h = paramList;
    c()[7] = 1;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    a(b()[16], Boolean.valueOf(paramBoolean));
    this.q = paramBoolean;
    c()[16] = 1;
    return this;
  }
  
  public Builder c(CharSequence paramCharSequence)
  {
    a(b()[2], paramCharSequence);
    this.c = paramCharSequence;
    c()[2] = 1;
    return this;
  }
  
  public Builder c(List<FrequencyCapInfo> paramList)
  {
    a(b()[18], paramList);
    this.s = paramList;
    c()[18] = 1;
    return this;
  }
  
  public Builder d(CharSequence paramCharSequence)
  {
    a(b()[9], paramCharSequence);
    this.j = paramCharSequence;
    c()[9] = 1;
    return this;
  }
  
  public Builder d(List<CharSequence> paramList)
  {
    a(b()[21], paramList);
    this.v = paramList;
    c()[21] = 1;
    return this;
  }
  
  public Builder e(CharSequence paramCharSequence)
  {
    a(b()[10], paramCharSequence);
    this.k = paramCharSequence;
    c()[10] = 1;
    return this;
  }
  
  public Builder f(CharSequence paramCharSequence)
  {
    a(b()[11], paramCharSequence);
    this.l = paramCharSequence;
    c()[11] = 1;
    return this;
  }
  
  public Builder g(CharSequence paramCharSequence)
  {
    a(b()[12], paramCharSequence);
    this.m = paramCharSequence;
    c()[12] = 1;
    return this;
  }
  
  public Builder h(CharSequence paramCharSequence)
  {
    a(b()[20], paramCharSequence);
    this.u = paramCharSequence;
    c()[20] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */