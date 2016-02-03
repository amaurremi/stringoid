package com.appbrain.e;

import com.appbrain.b.d;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.p;
import com.appbrain.b.q;
import com.appbrain.b.t;
import com.appbrain.b.w;
import java.util.Collections;
import java.util.List;

public final class ag
  extends k
  implements ai
{
  public static w a = new ba();
  private static final ag b;
  private int c;
  private q d;
  private q e;
  private q f;
  private q g;
  private q h;
  private q i;
  private List j;
  private Object k;
  private boolean l;
  private q m;
  private List n;
  private byte o = -1;
  private int p = -1;
  
  static
  {
    ag localag = new ag((byte)0);
    b = localag;
    localag.n();
  }
  
  private ag()
  {
    super((byte)0);
  }
  
  private ag(byte paramByte) {}
  
  /* Error */
  private ag(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 50	com/appbrain/e/ag:o	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 52	com/appbrain/e/ag:p	I
    //   14: aload_0
    //   15: invokespecial 46	com/appbrain/e/ag:n	()V
    //   18: iconst_0
    //   19: istore 7
    //   21: iconst_0
    //   22: istore_3
    //   23: iload 7
    //   25: ifne +1220 -> 1245
    //   28: iload_3
    //   29: istore 5
    //   31: iload_3
    //   32: istore 6
    //   34: iload_3
    //   35: istore 8
    //   37: aload_1
    //   38: invokevirtual 65	com/appbrain/b/g:a	()I
    //   41: istore 4
    //   43: iload 4
    //   45: lookupswitch	default:+1468->1513, 0:+1471->1516, 10:+139->184, 18:+201->246, 26:+263->308, 34:+325->370, 42:+390->435, 50:+455->500, 56:+520->565, 58:+589->634, 66:+950->995, 72:+989->1034, 82:+1048->1093, 90:+1116->1161
    //   160: iload_3
    //   161: istore 5
    //   163: iload_3
    //   164: istore 6
    //   166: iload_3
    //   167: istore 8
    //   169: aload_1
    //   170: iload 4
    //   172: invokevirtual 68	com/appbrain/b/g:b	(I)Z
    //   175: ifne -152 -> 23
    //   178: iconst_1
    //   179: istore 7
    //   181: goto -158 -> 23
    //   184: iload_3
    //   185: iconst_1
    //   186: iand
    //   187: iconst_1
    //   188: if_icmpeq +1319 -> 1507
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: iload_3
    //   198: istore 8
    //   200: aload_0
    //   201: new 70	com/appbrain/b/p
    //   204: dup
    //   205: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   208: putfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   211: iload_3
    //   212: iconst_1
    //   213: ior
    //   214: istore 6
    //   216: iload 6
    //   218: istore 4
    //   220: iload 6
    //   222: istore_3
    //   223: iload 6
    //   225: istore 5
    //   227: aload_0
    //   228: getfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   231: aload_1
    //   232: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   235: invokeinterface 81 2 0
    //   240: iload 6
    //   242: istore_3
    //   243: goto -220 -> 23
    //   246: iload_3
    //   247: iconst_2
    //   248: iand
    //   249: iconst_2
    //   250: if_icmpeq +1251 -> 1501
    //   253: iload_3
    //   254: istore 5
    //   256: iload_3
    //   257: istore 6
    //   259: iload_3
    //   260: istore 8
    //   262: aload_0
    //   263: new 70	com/appbrain/b/p
    //   266: dup
    //   267: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   270: putfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   273: iload_3
    //   274: iconst_2
    //   275: ior
    //   276: istore 6
    //   278: iload 6
    //   280: istore 4
    //   282: iload 6
    //   284: istore_3
    //   285: iload 6
    //   287: istore 5
    //   289: aload_0
    //   290: getfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   293: aload_1
    //   294: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   297: invokeinterface 81 2 0
    //   302: iload 6
    //   304: istore_3
    //   305: goto -282 -> 23
    //   308: iload_3
    //   309: iconst_4
    //   310: iand
    //   311: iconst_4
    //   312: if_icmpeq +1183 -> 1495
    //   315: iload_3
    //   316: istore 5
    //   318: iload_3
    //   319: istore 6
    //   321: iload_3
    //   322: istore 8
    //   324: aload_0
    //   325: new 70	com/appbrain/b/p
    //   328: dup
    //   329: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   332: putfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   335: iload_3
    //   336: iconst_4
    //   337: ior
    //   338: istore 6
    //   340: iload 6
    //   342: istore 4
    //   344: iload 6
    //   346: istore_3
    //   347: iload 6
    //   349: istore 5
    //   351: aload_0
    //   352: getfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   355: aload_1
    //   356: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   359: invokeinterface 81 2 0
    //   364: iload 6
    //   366: istore_3
    //   367: goto -344 -> 23
    //   370: iload_3
    //   371: bipush 8
    //   373: iand
    //   374: bipush 8
    //   376: if_icmpeq +1113 -> 1489
    //   379: iload_3
    //   380: istore 5
    //   382: iload_3
    //   383: istore 6
    //   385: iload_3
    //   386: istore 8
    //   388: aload_0
    //   389: new 70	com/appbrain/b/p
    //   392: dup
    //   393: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   396: putfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   399: iload_3
    //   400: bipush 8
    //   402: ior
    //   403: istore 6
    //   405: iload 6
    //   407: istore 4
    //   409: iload 6
    //   411: istore_3
    //   412: iload 6
    //   414: istore 5
    //   416: aload_0
    //   417: getfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   420: aload_1
    //   421: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   424: invokeinterface 81 2 0
    //   429: iload 6
    //   431: istore_3
    //   432: goto -409 -> 23
    //   435: iload_3
    //   436: bipush 16
    //   438: iand
    //   439: bipush 16
    //   441: if_icmpeq +1042 -> 1483
    //   444: iload_3
    //   445: istore 5
    //   447: iload_3
    //   448: istore 6
    //   450: iload_3
    //   451: istore 8
    //   453: aload_0
    //   454: new 70	com/appbrain/b/p
    //   457: dup
    //   458: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   461: putfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   464: iload_3
    //   465: bipush 16
    //   467: ior
    //   468: istore 6
    //   470: iload 6
    //   472: istore 4
    //   474: iload 6
    //   476: istore_3
    //   477: iload 6
    //   479: istore 5
    //   481: aload_0
    //   482: getfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   485: aload_1
    //   486: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   489: invokeinterface 81 2 0
    //   494: iload 6
    //   496: istore_3
    //   497: goto -474 -> 23
    //   500: iload_3
    //   501: bipush 32
    //   503: iand
    //   504: bipush 32
    //   506: if_icmpeq +971 -> 1477
    //   509: iload_3
    //   510: istore 5
    //   512: iload_3
    //   513: istore 6
    //   515: iload_3
    //   516: istore 8
    //   518: aload_0
    //   519: new 70	com/appbrain/b/p
    //   522: dup
    //   523: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   526: putfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   529: iload_3
    //   530: bipush 32
    //   532: ior
    //   533: istore 6
    //   535: iload 6
    //   537: istore 4
    //   539: iload 6
    //   541: istore_3
    //   542: iload 6
    //   544: istore 5
    //   546: aload_0
    //   547: getfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   550: aload_1
    //   551: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   554: invokeinterface 81 2 0
    //   559: iload 6
    //   561: istore_3
    //   562: goto -539 -> 23
    //   565: iload_3
    //   566: bipush 64
    //   568: iand
    //   569: bipush 64
    //   571: if_icmpeq +900 -> 1471
    //   574: iload_3
    //   575: istore 5
    //   577: iload_3
    //   578: istore 6
    //   580: iload_3
    //   581: istore 8
    //   583: aload_0
    //   584: new 93	java/util/ArrayList
    //   587: dup
    //   588: invokespecial 94	java/util/ArrayList:<init>	()V
    //   591: putfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   594: iload_3
    //   595: bipush 64
    //   597: ior
    //   598: istore 6
    //   600: iload 6
    //   602: istore 4
    //   604: iload 6
    //   606: istore_3
    //   607: iload 6
    //   609: istore 5
    //   611: aload_0
    //   612: getfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   615: aload_1
    //   616: invokevirtual 98	com/appbrain/b/g:c	()I
    //   619: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: invokeinterface 110 2 0
    //   627: pop
    //   628: iload 6
    //   630: istore_3
    //   631: goto -608 -> 23
    //   634: iload_3
    //   635: istore 5
    //   637: iload_3
    //   638: istore 6
    //   640: iload_3
    //   641: istore 8
    //   643: aload_1
    //   644: aload_1
    //   645: invokevirtual 112	com/appbrain/b/g:g	()I
    //   648: invokevirtual 115	com/appbrain/b/g:c	(I)I
    //   651: istore 9
    //   653: iload_3
    //   654: bipush 64
    //   656: iand
    //   657: bipush 64
    //   659: if_icmpeq +806 -> 1465
    //   662: iload_3
    //   663: istore 5
    //   665: iload_3
    //   666: istore 6
    //   668: iload_3
    //   669: istore 8
    //   671: aload_1
    //   672: invokevirtual 117	com/appbrain/b/g:h	()I
    //   675: ifle +790 -> 1465
    //   678: iload_3
    //   679: istore 5
    //   681: iload_3
    //   682: istore 6
    //   684: iload_3
    //   685: istore 8
    //   687: aload_0
    //   688: new 93	java/util/ArrayList
    //   691: dup
    //   692: invokespecial 94	java/util/ArrayList:<init>	()V
    //   695: putfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   698: iload_3
    //   699: bipush 64
    //   701: ior
    //   702: istore 6
    //   704: iload 6
    //   706: istore 4
    //   708: iload 6
    //   710: istore_3
    //   711: iload 6
    //   713: istore 5
    //   715: aload_1
    //   716: invokevirtual 117	com/appbrain/b/g:h	()I
    //   719: ifle +253 -> 972
    //   722: iload 6
    //   724: istore 4
    //   726: iload 6
    //   728: istore_3
    //   729: iload 6
    //   731: istore 5
    //   733: aload_0
    //   734: getfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   737: aload_1
    //   738: invokevirtual 98	com/appbrain/b/g:c	()I
    //   741: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: invokeinterface 110 2 0
    //   749: pop
    //   750: goto -46 -> 704
    //   753: astore_1
    //   754: iload 4
    //   756: istore_3
    //   757: aload_1
    //   758: aload_0
    //   759: invokevirtual 120	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   762: athrow
    //   763: astore_1
    //   764: iload_3
    //   765: iconst_1
    //   766: iand
    //   767: iconst_1
    //   768: if_icmpne +18 -> 786
    //   771: aload_0
    //   772: new 122	com/appbrain/b/ac
    //   775: dup
    //   776: aload_0
    //   777: getfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   780: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   783: putfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   786: iload_3
    //   787: iconst_2
    //   788: iand
    //   789: iconst_2
    //   790: if_icmpne +18 -> 808
    //   793: aload_0
    //   794: new 122	com/appbrain/b/ac
    //   797: dup
    //   798: aload_0
    //   799: getfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   802: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   805: putfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   808: iload_3
    //   809: iconst_4
    //   810: iand
    //   811: iconst_4
    //   812: if_icmpne +18 -> 830
    //   815: aload_0
    //   816: new 122	com/appbrain/b/ac
    //   819: dup
    //   820: aload_0
    //   821: getfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   824: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   827: putfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   830: iload_3
    //   831: bipush 8
    //   833: iand
    //   834: bipush 8
    //   836: if_icmpne +18 -> 854
    //   839: aload_0
    //   840: new 122	com/appbrain/b/ac
    //   843: dup
    //   844: aload_0
    //   845: getfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   848: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   851: putfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   854: iload_3
    //   855: bipush 16
    //   857: iand
    //   858: bipush 16
    //   860: if_icmpne +18 -> 878
    //   863: aload_0
    //   864: new 122	com/appbrain/b/ac
    //   867: dup
    //   868: aload_0
    //   869: getfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   872: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   875: putfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   878: iload_3
    //   879: bipush 32
    //   881: iand
    //   882: bipush 32
    //   884: if_icmpne +18 -> 902
    //   887: aload_0
    //   888: new 122	com/appbrain/b/ac
    //   891: dup
    //   892: aload_0
    //   893: getfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   896: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   899: putfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   902: iload_3
    //   903: bipush 64
    //   905: iand
    //   906: bipush 64
    //   908: if_icmpne +14 -> 922
    //   911: aload_0
    //   912: aload_0
    //   913: getfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   916: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   919: putfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   922: iload_3
    //   923: sipush 512
    //   926: iand
    //   927: sipush 512
    //   930: if_icmpne +18 -> 948
    //   933: aload_0
    //   934: new 122	com/appbrain/b/ac
    //   937: dup
    //   938: aload_0
    //   939: getfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   942: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   945: putfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   948: iload_3
    //   949: sipush 1024
    //   952: iand
    //   953: sipush 1024
    //   956: if_icmpne +14 -> 970
    //   959: aload_0
    //   960: aload_0
    //   961: getfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   964: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   967: putfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   970: aload_1
    //   971: athrow
    //   972: iload 6
    //   974: istore 4
    //   976: iload 6
    //   978: istore_3
    //   979: iload 6
    //   981: istore 5
    //   983: aload_1
    //   984: iload 9
    //   986: invokevirtual 138	com/appbrain/b/g:d	(I)V
    //   989: iload 6
    //   991: istore_3
    //   992: goto -969 -> 23
    //   995: iload_3
    //   996: istore 5
    //   998: iload_3
    //   999: istore 6
    //   1001: iload_3
    //   1002: istore 8
    //   1004: aload_0
    //   1005: aload_0
    //   1006: getfield 140	com/appbrain/e/ag:c	I
    //   1009: iconst_1
    //   1010: ior
    //   1011: putfield 140	com/appbrain/e/ag:c	I
    //   1014: iload_3
    //   1015: istore 5
    //   1017: iload_3
    //   1018: istore 6
    //   1020: iload_3
    //   1021: istore 8
    //   1023: aload_0
    //   1024: aload_1
    //   1025: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   1028: putfield 142	com/appbrain/e/ag:k	Ljava/lang/Object;
    //   1031: goto -1008 -> 23
    //   1034: iload_3
    //   1035: istore 5
    //   1037: iload_3
    //   1038: istore 6
    //   1040: iload_3
    //   1041: istore 8
    //   1043: aload_0
    //   1044: aload_0
    //   1045: getfield 140	com/appbrain/e/ag:c	I
    //   1048: iconst_2
    //   1049: ior
    //   1050: putfield 140	com/appbrain/e/ag:c	I
    //   1053: iload_3
    //   1054: istore 5
    //   1056: iload_3
    //   1057: istore 6
    //   1059: iload_3
    //   1060: istore 8
    //   1062: aload_0
    //   1063: aload_1
    //   1064: invokevirtual 145	com/appbrain/b/g:d	()Z
    //   1067: putfield 147	com/appbrain/e/ag:l	Z
    //   1070: goto -1047 -> 23
    //   1073: astore_1
    //   1074: iload 5
    //   1076: istore_3
    //   1077: new 58	com/appbrain/b/o
    //   1080: dup
    //   1081: aload_1
    //   1082: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1085: invokespecial 154	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   1088: aload_0
    //   1089: invokevirtual 120	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   1092: athrow
    //   1093: iload_3
    //   1094: sipush 512
    //   1097: iand
    //   1098: sipush 512
    //   1101: if_icmpeq +358 -> 1459
    //   1104: iload_3
    //   1105: istore 5
    //   1107: iload_3
    //   1108: istore 6
    //   1110: iload_3
    //   1111: istore 8
    //   1113: aload_0
    //   1114: new 70	com/appbrain/b/p
    //   1117: dup
    //   1118: invokespecial 71	com/appbrain/b/p:<init>	()V
    //   1121: putfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   1124: iload_3
    //   1125: sipush 512
    //   1128: ior
    //   1129: istore 6
    //   1131: iload 6
    //   1133: istore 4
    //   1135: iload 6
    //   1137: istore_3
    //   1138: iload 6
    //   1140: istore 5
    //   1142: aload_0
    //   1143: getfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   1146: aload_1
    //   1147: invokevirtual 76	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   1150: invokeinterface 81 2 0
    //   1155: iload 6
    //   1157: istore_3
    //   1158: goto -1135 -> 23
    //   1161: iload_3
    //   1162: istore 4
    //   1164: iload_3
    //   1165: sipush 1024
    //   1168: iand
    //   1169: sipush 1024
    //   1172: if_icmpeq +30 -> 1202
    //   1175: iload_3
    //   1176: istore 5
    //   1178: iload_3
    //   1179: istore 6
    //   1181: iload_3
    //   1182: istore 8
    //   1184: aload_0
    //   1185: new 93	java/util/ArrayList
    //   1188: dup
    //   1189: invokespecial 94	java/util/ArrayList:<init>	()V
    //   1192: putfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   1195: iload_3
    //   1196: sipush 1024
    //   1199: ior
    //   1200: istore 4
    //   1202: iload 4
    //   1204: istore 5
    //   1206: iload 4
    //   1208: istore 6
    //   1210: iload 4
    //   1212: istore 8
    //   1214: aload_0
    //   1215: getfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   1218: aload_1
    //   1219: getstatic 157	com/appbrain/e/aj:a	Lcom/appbrain/b/w;
    //   1222: aload_2
    //   1223: invokevirtual 160	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   1226: invokeinterface 110 2 0
    //   1231: pop
    //   1232: iload 4
    //   1234: istore_3
    //   1235: goto -1212 -> 23
    //   1238: astore_1
    //   1239: iload 6
    //   1241: istore_3
    //   1242: goto -478 -> 764
    //   1245: iload_3
    //   1246: iconst_1
    //   1247: iand
    //   1248: iconst_1
    //   1249: if_icmpne +18 -> 1267
    //   1252: aload_0
    //   1253: new 122	com/appbrain/b/ac
    //   1256: dup
    //   1257: aload_0
    //   1258: getfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   1261: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1264: putfield 73	com/appbrain/e/ag:d	Lcom/appbrain/b/q;
    //   1267: iload_3
    //   1268: iconst_2
    //   1269: iand
    //   1270: iconst_2
    //   1271: if_icmpne +18 -> 1289
    //   1274: aload_0
    //   1275: new 122	com/appbrain/b/ac
    //   1278: dup
    //   1279: aload_0
    //   1280: getfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   1283: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1286: putfield 83	com/appbrain/e/ag:e	Lcom/appbrain/b/q;
    //   1289: iload_3
    //   1290: iconst_4
    //   1291: iand
    //   1292: iconst_4
    //   1293: if_icmpne +18 -> 1311
    //   1296: aload_0
    //   1297: new 122	com/appbrain/b/ac
    //   1300: dup
    //   1301: aload_0
    //   1302: getfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   1305: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1308: putfield 85	com/appbrain/e/ag:f	Lcom/appbrain/b/q;
    //   1311: iload_3
    //   1312: bipush 8
    //   1314: iand
    //   1315: bipush 8
    //   1317: if_icmpne +18 -> 1335
    //   1320: aload_0
    //   1321: new 122	com/appbrain/b/ac
    //   1324: dup
    //   1325: aload_0
    //   1326: getfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   1329: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1332: putfield 87	com/appbrain/e/ag:g	Lcom/appbrain/b/q;
    //   1335: iload_3
    //   1336: bipush 16
    //   1338: iand
    //   1339: bipush 16
    //   1341: if_icmpne +18 -> 1359
    //   1344: aload_0
    //   1345: new 122	com/appbrain/b/ac
    //   1348: dup
    //   1349: aload_0
    //   1350: getfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   1353: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1356: putfield 89	com/appbrain/e/ag:h	Lcom/appbrain/b/q;
    //   1359: iload_3
    //   1360: bipush 32
    //   1362: iand
    //   1363: bipush 32
    //   1365: if_icmpne +18 -> 1383
    //   1368: aload_0
    //   1369: new 122	com/appbrain/b/ac
    //   1372: dup
    //   1373: aload_0
    //   1374: getfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   1377: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1380: putfield 91	com/appbrain/e/ag:i	Lcom/appbrain/b/q;
    //   1383: iload_3
    //   1384: bipush 64
    //   1386: iand
    //   1387: bipush 64
    //   1389: if_icmpne +14 -> 1403
    //   1392: aload_0
    //   1393: aload_0
    //   1394: getfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   1397: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1400: putfield 96	com/appbrain/e/ag:j	Ljava/util/List;
    //   1403: iload_3
    //   1404: sipush 512
    //   1407: iand
    //   1408: sipush 512
    //   1411: if_icmpne +18 -> 1429
    //   1414: aload_0
    //   1415: new 122	com/appbrain/b/ac
    //   1418: dup
    //   1419: aload_0
    //   1420: getfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   1423: invokespecial 125	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   1426: putfield 133	com/appbrain/e/ag:m	Lcom/appbrain/b/q;
    //   1429: iload_3
    //   1430: sipush 1024
    //   1433: iand
    //   1434: sipush 1024
    //   1437: if_icmpne +14 -> 1451
    //   1440: aload_0
    //   1441: aload_0
    //   1442: getfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   1445: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1448: putfield 135	com/appbrain/e/ag:n	Ljava/util/List;
    //   1451: return
    //   1452: astore_1
    //   1453: iload 5
    //   1455: istore_3
    //   1456: goto -379 -> 1077
    //   1459: iload_3
    //   1460: istore 6
    //   1462: goto -331 -> 1131
    //   1465: iload_3
    //   1466: istore 6
    //   1468: goto -764 -> 704
    //   1471: iload_3
    //   1472: istore 6
    //   1474: goto -874 -> 600
    //   1477: iload_3
    //   1478: istore 6
    //   1480: goto -945 -> 535
    //   1483: iload_3
    //   1484: istore 6
    //   1486: goto -1016 -> 470
    //   1489: iload_3
    //   1490: istore 6
    //   1492: goto -1087 -> 405
    //   1495: iload_3
    //   1496: istore 6
    //   1498: goto -1158 -> 340
    //   1501: iload_3
    //   1502: istore 6
    //   1504: goto -1226 -> 278
    //   1507: iload_3
    //   1508: istore 6
    //   1510: goto -1294 -> 216
    //   1513: goto -1353 -> 160
    //   1516: iconst_1
    //   1517: istore 7
    //   1519: goto -1496 -> 23
    //   1522: astore_1
    //   1523: iload 8
    //   1525: istore_3
    //   1526: goto -769 -> 757
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1529	0	this	ag
    //   0	1529	1	paramg	com.appbrain.b.g
    //   0	1529	2	paramj	com.appbrain.b.j
    //   22	1504	3	i1	int
    //   41	1192	4	i2	int
    //   29	1425	5	i3	int
    //   32	1477	6	i4	int
    //   19	1499	7	i5	int
    //   35	1489	8	i6	int
    //   651	334	9	i7	int
    // Exception table:
    //   from	to	target	type
    //   227	240	753	com/appbrain/b/o
    //   289	302	753	com/appbrain/b/o
    //   351	364	753	com/appbrain/b/o
    //   416	429	753	com/appbrain/b/o
    //   481	494	753	com/appbrain/b/o
    //   546	559	753	com/appbrain/b/o
    //   611	628	753	com/appbrain/b/o
    //   715	722	753	com/appbrain/b/o
    //   733	750	753	com/appbrain/b/o
    //   983	989	753	com/appbrain/b/o
    //   1142	1155	753	com/appbrain/b/o
    //   227	240	763	finally
    //   289	302	763	finally
    //   351	364	763	finally
    //   416	429	763	finally
    //   481	494	763	finally
    //   546	559	763	finally
    //   611	628	763	finally
    //   715	722	763	finally
    //   733	750	763	finally
    //   757	763	763	finally
    //   983	989	763	finally
    //   1077	1093	763	finally
    //   1142	1155	763	finally
    //   37	43	1073	java/io/IOException
    //   169	178	1073	java/io/IOException
    //   200	211	1073	java/io/IOException
    //   262	273	1073	java/io/IOException
    //   324	335	1073	java/io/IOException
    //   388	399	1073	java/io/IOException
    //   453	464	1073	java/io/IOException
    //   518	529	1073	java/io/IOException
    //   583	594	1073	java/io/IOException
    //   643	653	1073	java/io/IOException
    //   671	678	1073	java/io/IOException
    //   687	698	1073	java/io/IOException
    //   1004	1014	1073	java/io/IOException
    //   1023	1031	1073	java/io/IOException
    //   1043	1053	1073	java/io/IOException
    //   1062	1070	1073	java/io/IOException
    //   1113	1124	1073	java/io/IOException
    //   1184	1195	1073	java/io/IOException
    //   1214	1232	1073	java/io/IOException
    //   37	43	1238	finally
    //   169	178	1238	finally
    //   200	211	1238	finally
    //   262	273	1238	finally
    //   324	335	1238	finally
    //   388	399	1238	finally
    //   453	464	1238	finally
    //   518	529	1238	finally
    //   583	594	1238	finally
    //   643	653	1238	finally
    //   671	678	1238	finally
    //   687	698	1238	finally
    //   1004	1014	1238	finally
    //   1023	1031	1238	finally
    //   1043	1053	1238	finally
    //   1062	1070	1238	finally
    //   1113	1124	1238	finally
    //   1184	1195	1238	finally
    //   1214	1232	1238	finally
    //   227	240	1452	java/io/IOException
    //   289	302	1452	java/io/IOException
    //   351	364	1452	java/io/IOException
    //   416	429	1452	java/io/IOException
    //   481	494	1452	java/io/IOException
    //   546	559	1452	java/io/IOException
    //   611	628	1452	java/io/IOException
    //   715	722	1452	java/io/IOException
    //   733	750	1452	java/io/IOException
    //   983	989	1452	java/io/IOException
    //   1142	1155	1452	java/io/IOException
    //   37	43	1522	com/appbrain/b/o
    //   169	178	1522	com/appbrain/b/o
    //   200	211	1522	com/appbrain/b/o
    //   262	273	1522	com/appbrain/b/o
    //   324	335	1522	com/appbrain/b/o
    //   388	399	1522	com/appbrain/b/o
    //   453	464	1522	com/appbrain/b/o
    //   518	529	1522	com/appbrain/b/o
    //   583	594	1522	com/appbrain/b/o
    //   643	653	1522	com/appbrain/b/o
    //   671	678	1522	com/appbrain/b/o
    //   687	698	1522	com/appbrain/b/o
    //   1004	1014	1522	com/appbrain/b/o
    //   1023	1031	1522	com/appbrain/b/o
    //   1043	1053	1522	com/appbrain/b/o
    //   1062	1070	1522	com/appbrain/b/o
    //   1113	1124	1522	com/appbrain/b/o
    //   1184	1195	1522	com/appbrain/b/o
    //   1214	1232	1522	com/appbrain/b/o
  }
  
  public static ag f()
  {
    return b;
  }
  
  private d m()
  {
    Object localObject = this.k;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.k = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private void n()
  {
    this.d = p.a;
    this.e = p.a;
    this.f = p.a;
    this.g = p.a;
    this.h = p.a;
    this.i = p.a;
    this.j = Collections.emptyList();
    this.k = "";
    this.l = false;
    this.m = p.a;
    this.n = Collections.emptyList();
  }
  
  public final String a(int paramInt)
  {
    return (String)this.d.get(paramInt);
  }
  
  public final void a(h paramh)
  {
    int i3 = 0;
    c();
    int i1 = 0;
    while (i1 < this.d.size())
    {
      paramh.a(1, this.d.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.e.size())
    {
      paramh.a(2, this.e.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.f.size())
    {
      paramh.a(3, this.f.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.g.size())
    {
      paramh.a(4, this.g.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.h.size())
    {
      paramh.a(5, this.h.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.i.size())
    {
      paramh.a(6, this.i.a(i1));
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.j.size())
    {
      paramh.a(7, ((Integer)this.j.get(i1)).intValue());
      i1 += 1;
    }
    if ((this.c & 0x1) == 1) {
      paramh.a(8, m());
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(9, this.l);
    }
    i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.m.size()) {
        break;
      }
      paramh.a(10, this.m.a(i1));
      i1 += 1;
    }
    while (i2 < this.n.size())
    {
      paramh.a(11, (t)this.n.get(i2));
      i2 += 1;
    }
  }
  
  public final String b(int paramInt)
  {
    return (String)this.e.get(paramInt);
  }
  
  public final int c()
  {
    int i9 = 0;
    int i1 = this.p;
    if (i1 != -1) {
      return i1;
    }
    int i2 = 0;
    i1 = 0;
    while (i2 < this.d.size())
    {
      i1 += h.a(this.d.a(i2));
      i2 += 1;
    }
    int i10 = this.d.size();
    int i3 = 0;
    i2 = 0;
    while (i3 < this.e.size())
    {
      i2 += h.a(this.e.a(i3));
      i3 += 1;
    }
    int i11 = this.e.size();
    int i4 = 0;
    i3 = 0;
    while (i4 < this.f.size())
    {
      i3 += h.a(this.f.a(i4));
      i4 += 1;
    }
    int i12 = this.f.size();
    int i5 = 0;
    i4 = 0;
    while (i5 < this.g.size())
    {
      i4 += h.a(this.g.a(i5));
      i5 += 1;
    }
    int i13 = this.g.size();
    int i6 = 0;
    i5 = 0;
    while (i6 < this.h.size())
    {
      i5 += h.a(this.h.a(i6));
      i6 += 1;
    }
    int i14 = this.h.size();
    int i7 = 0;
    i6 = 0;
    while (i7 < this.i.size())
    {
      i6 += h.a(this.i.a(i7));
      i7 += 1;
    }
    int i15 = this.i.size();
    i7 = 0;
    int i8 = 0;
    while (i7 < this.j.size())
    {
      i8 += h.b(((Integer)this.j.get(i7)).intValue());
      i7 += 1;
    }
    i2 = i1 + 0 + i10 * 1 + i2 + i11 * 1 + i3 + i12 * 1 + i4 + i13 * 1 + i5 + i14 * 1 + i6 + i15 * 1 + i8 + this.j.size() * 1;
    i1 = i2;
    if ((this.c & 0x1) == 1) {
      i1 = i2 + h.b(8, m());
    }
    i2 = i1;
    if ((this.c & 0x2) == 2)
    {
      boolean bool = this.l;
      i2 = i1 + h.a(9);
    }
    i1 = 0;
    i3 = 0;
    while (i1 < this.m.size())
    {
      i3 += h.a(this.m.a(i1));
      i1 += 1;
    }
    i1 = i2 + i3 + this.m.size() * 1;
    i2 = i9;
    while (i2 < this.n.size())
    {
      i3 = h.b(11, (t)this.n.get(i2));
      i2 += 1;
      i1 = i3 + i1;
    }
    this.p = i1;
    return i1;
  }
  
  public final String c(int paramInt)
  {
    return (String)this.f.get(paramInt);
  }
  
  public final String d(int paramInt)
  {
    return (String)this.g.get(paramInt);
  }
  
  public final String e(int paramInt)
  {
    return (String)this.h.get(paramInt);
  }
  
  public final boolean e()
  {
    int i1 = this.o;
    if (i1 != -1) {
      return i1 == 1;
    }
    this.o = 1;
    return true;
  }
  
  public final String f(int paramInt)
  {
    return (String)this.i.get(paramInt);
  }
  
  public final int g()
  {
    return this.d.size();
  }
  
  public final int g(int paramInt)
  {
    return ((Integer)this.j.get(paramInt)).intValue();
  }
  
  public final String h(int paramInt)
  {
    return (String)this.m.get(paramInt);
  }
  
  public final boolean h()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final String i()
  {
    Object localObject = this.k;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (d)localObject;
    String str = ((d)localObject).e();
    if (((d)localObject).f()) {
      this.k = str;
    }
    return str;
  }
  
  public final boolean j()
  {
    return (this.c & 0x2) == 2;
  }
  
  public final boolean k()
  {
    return this.l;
  }
  
  public final int l()
  {
    return this.m.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */