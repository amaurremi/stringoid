package com.appbrain.e;

import com.appbrain.b.c;
import com.appbrain.b.d;
import com.appbrain.b.e;
import com.appbrain.b.g;
import com.appbrain.b.g.a;
import com.appbrain.b.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class j
{
  public static enum a
  {
    private static com.appbrain.b.h.a g = new k();
    private final int h;
    
    private a(int paramInt1)
    {
      this.h = paramInt1;
    }
    
    public static a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return a;
      case 2: 
        return b;
      case 3: 
        return c;
      case 4: 
        return d;
      case 5: 
        return e;
      }
      return f;
    }
    
    public final int a()
    {
      return this.h;
    }
  }
  
  public static final class b
    extends g
    implements j.c
  {
    public static com.appbrain.b.o a = new l();
    private static final b b;
    private int c;
    private com.appbrain.b.k d;
    private com.appbrain.b.k e;
    private com.appbrain.b.k f;
    private com.appbrain.b.k g;
    private com.appbrain.b.k h;
    private com.appbrain.b.k i;
    private List j;
    private Object k;
    private boolean l;
    private com.appbrain.b.k m;
    private List n;
    private byte o = -1;
    private int p = -1;
    
    static
    {
      b localb = new b((byte)0);
      b = localb;
      localb.o();
    }
    
    private b()
    {
      super();
    }
    
    private b(byte paramByte) {}
    
    /* Error */
    private b(d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 57	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 54	com/appbrain/e/j$b:o	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 56	com/appbrain/e/j$b:p	I
      //   14: aload_0
      //   15: invokespecial 50	com/appbrain/e/j$b:o	()V
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
      //   38: invokevirtual 69	com/appbrain/b/d:a	()I
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
      //   172: invokevirtual 72	com/appbrain/b/d:b	(I)Z
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
      //   201: new 74	com/appbrain/b/j
      //   204: dup
      //   205: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   208: putfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
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
      //   228: getfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
      //   231: aload_1
      //   232: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   235: invokeinterface 85 2 0
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
      //   263: new 74	com/appbrain/b/j
      //   266: dup
      //   267: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   270: putfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
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
      //   290: getfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
      //   293: aload_1
      //   294: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   297: invokeinterface 85 2 0
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
      //   325: new 74	com/appbrain/b/j
      //   328: dup
      //   329: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   332: putfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
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
      //   352: getfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
      //   355: aload_1
      //   356: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   359: invokeinterface 85 2 0
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
      //   389: new 74	com/appbrain/b/j
      //   392: dup
      //   393: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   396: putfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
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
      //   417: getfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
      //   420: aload_1
      //   421: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   424: invokeinterface 85 2 0
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
      //   454: new 74	com/appbrain/b/j
      //   457: dup
      //   458: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   461: putfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
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
      //   482: getfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
      //   485: aload_1
      //   486: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   489: invokeinterface 85 2 0
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
      //   519: new 74	com/appbrain/b/j
      //   522: dup
      //   523: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   526: putfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
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
      //   547: getfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
      //   550: aload_1
      //   551: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   554: invokeinterface 85 2 0
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
      //   584: new 97	java/util/ArrayList
      //   587: dup
      //   588: invokespecial 98	java/util/ArrayList:<init>	()V
      //   591: putfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
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
      //   612: getfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   615: aload_1
      //   616: invokevirtual 102	com/appbrain/b/d:c	()I
      //   619: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   622: invokeinterface 114 2 0
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
      //   645: invokevirtual 116	com/appbrain/b/d:g	()I
      //   648: invokevirtual 119	com/appbrain/b/d:c	(I)I
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
      //   672: invokevirtual 121	com/appbrain/b/d:h	()I
      //   675: ifle +790 -> 1465
      //   678: iload_3
      //   679: istore 5
      //   681: iload_3
      //   682: istore 6
      //   684: iload_3
      //   685: istore 8
      //   687: aload_0
      //   688: new 97	java/util/ArrayList
      //   691: dup
      //   692: invokespecial 98	java/util/ArrayList:<init>	()V
      //   695: putfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
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
      //   716: invokevirtual 121	com/appbrain/b/d:h	()I
      //   719: ifle +253 -> 972
      //   722: iload 6
      //   724: istore 4
      //   726: iload 6
      //   728: istore_3
      //   729: iload 6
      //   731: istore 5
      //   733: aload_0
      //   734: getfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   737: aload_1
      //   738: invokevirtual 102	com/appbrain/b/d:c	()I
      //   741: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   744: invokeinterface 114 2 0
      //   749: pop
      //   750: goto -46 -> 704
      //   753: astore_1
      //   754: iload 4
      //   756: istore_3
      //   757: aload_1
      //   758: aload_0
      //   759: invokevirtual 124	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   762: athrow
      //   763: astore_1
      //   764: iload_3
      //   765: iconst_1
      //   766: iand
      //   767: iconst_1
      //   768: if_icmpne +18 -> 786
      //   771: aload_0
      //   772: new 126	com/appbrain/b/r
      //   775: dup
      //   776: aload_0
      //   777: getfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
      //   780: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   783: putfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
      //   786: iload_3
      //   787: iconst_2
      //   788: iand
      //   789: iconst_2
      //   790: if_icmpne +18 -> 808
      //   793: aload_0
      //   794: new 126	com/appbrain/b/r
      //   797: dup
      //   798: aload_0
      //   799: getfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
      //   802: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   805: putfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
      //   808: iload_3
      //   809: iconst_4
      //   810: iand
      //   811: iconst_4
      //   812: if_icmpne +18 -> 830
      //   815: aload_0
      //   816: new 126	com/appbrain/b/r
      //   819: dup
      //   820: aload_0
      //   821: getfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
      //   824: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   827: putfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
      //   830: iload_3
      //   831: bipush 8
      //   833: iand
      //   834: bipush 8
      //   836: if_icmpne +18 -> 854
      //   839: aload_0
      //   840: new 126	com/appbrain/b/r
      //   843: dup
      //   844: aload_0
      //   845: getfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
      //   848: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   851: putfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
      //   854: iload_3
      //   855: bipush 16
      //   857: iand
      //   858: bipush 16
      //   860: if_icmpne +18 -> 878
      //   863: aload_0
      //   864: new 126	com/appbrain/b/r
      //   867: dup
      //   868: aload_0
      //   869: getfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
      //   872: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   875: putfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
      //   878: iload_3
      //   879: bipush 32
      //   881: iand
      //   882: bipush 32
      //   884: if_icmpne +18 -> 902
      //   887: aload_0
      //   888: new 126	com/appbrain/b/r
      //   891: dup
      //   892: aload_0
      //   893: getfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
      //   896: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   899: putfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
      //   902: iload_3
      //   903: bipush 64
      //   905: iand
      //   906: bipush 64
      //   908: if_icmpne +14 -> 922
      //   911: aload_0
      //   912: aload_0
      //   913: getfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   916: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   919: putfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   922: iload_3
      //   923: sipush 512
      //   926: iand
      //   927: sipush 512
      //   930: if_icmpne +18 -> 948
      //   933: aload_0
      //   934: new 126	com/appbrain/b/r
      //   937: dup
      //   938: aload_0
      //   939: getfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
      //   942: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   945: putfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
      //   948: iload_3
      //   949: sipush 1024
      //   952: iand
      //   953: sipush 1024
      //   956: if_icmpne +14 -> 970
      //   959: aload_0
      //   960: aload_0
      //   961: getfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
      //   964: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   967: putfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
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
      //   986: invokevirtual 142	com/appbrain/b/d:d	(I)V
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
      //   1006: getfield 144	com/appbrain/e/j$b:c	I
      //   1009: iconst_1
      //   1010: ior
      //   1011: putfield 144	com/appbrain/e/j$b:c	I
      //   1014: iload_3
      //   1015: istore 5
      //   1017: iload_3
      //   1018: istore 6
      //   1020: iload_3
      //   1021: istore 8
      //   1023: aload_0
      //   1024: aload_1
      //   1025: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   1028: putfield 146	com/appbrain/e/j$b:k	Ljava/lang/Object;
      //   1031: goto -1008 -> 23
      //   1034: iload_3
      //   1035: istore 5
      //   1037: iload_3
      //   1038: istore 6
      //   1040: iload_3
      //   1041: istore 8
      //   1043: aload_0
      //   1044: aload_0
      //   1045: getfield 144	com/appbrain/e/j$b:c	I
      //   1048: iconst_2
      //   1049: ior
      //   1050: putfield 144	com/appbrain/e/j$b:c	I
      //   1053: iload_3
      //   1054: istore 5
      //   1056: iload_3
      //   1057: istore 6
      //   1059: iload_3
      //   1060: istore 8
      //   1062: aload_0
      //   1063: aload_1
      //   1064: invokevirtual 149	com/appbrain/b/d:d	()Z
      //   1067: putfield 151	com/appbrain/e/j$b:l	Z
      //   1070: goto -1047 -> 23
      //   1073: astore_1
      //   1074: iload 5
      //   1076: istore_3
      //   1077: new 62	com/appbrain/b/i
      //   1080: dup
      //   1081: aload_1
      //   1082: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1085: invokespecial 158	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   1088: aload_0
      //   1089: invokevirtual 124	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
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
      //   1114: new 74	com/appbrain/b/j
      //   1117: dup
      //   1118: invokespecial 75	com/appbrain/b/j:<init>	()V
      //   1121: putfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
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
      //   1143: getfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
      //   1146: aload_1
      //   1147: invokevirtual 80	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   1150: invokeinterface 85 2 0
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
      //   1185: new 97	java/util/ArrayList
      //   1188: dup
      //   1189: invokespecial 98	java/util/ArrayList:<init>	()V
      //   1192: putfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
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
      //   1215: getfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
      //   1218: aload_1
      //   1219: getstatic 161	com/appbrain/e/j$d:a	Lcom/appbrain/b/o;
      //   1222: aload_2
      //   1223: invokevirtual 164	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   1226: invokeinterface 114 2 0
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
      //   1253: new 126	com/appbrain/b/r
      //   1256: dup
      //   1257: aload_0
      //   1258: getfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
      //   1261: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1264: putfield 77	com/appbrain/e/j$b:d	Lcom/appbrain/b/k;
      //   1267: iload_3
      //   1268: iconst_2
      //   1269: iand
      //   1270: iconst_2
      //   1271: if_icmpne +18 -> 1289
      //   1274: aload_0
      //   1275: new 126	com/appbrain/b/r
      //   1278: dup
      //   1279: aload_0
      //   1280: getfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
      //   1283: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1286: putfield 87	com/appbrain/e/j$b:e	Lcom/appbrain/b/k;
      //   1289: iload_3
      //   1290: iconst_4
      //   1291: iand
      //   1292: iconst_4
      //   1293: if_icmpne +18 -> 1311
      //   1296: aload_0
      //   1297: new 126	com/appbrain/b/r
      //   1300: dup
      //   1301: aload_0
      //   1302: getfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
      //   1305: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1308: putfield 89	com/appbrain/e/j$b:f	Lcom/appbrain/b/k;
      //   1311: iload_3
      //   1312: bipush 8
      //   1314: iand
      //   1315: bipush 8
      //   1317: if_icmpne +18 -> 1335
      //   1320: aload_0
      //   1321: new 126	com/appbrain/b/r
      //   1324: dup
      //   1325: aload_0
      //   1326: getfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
      //   1329: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1332: putfield 91	com/appbrain/e/j$b:g	Lcom/appbrain/b/k;
      //   1335: iload_3
      //   1336: bipush 16
      //   1338: iand
      //   1339: bipush 16
      //   1341: if_icmpne +18 -> 1359
      //   1344: aload_0
      //   1345: new 126	com/appbrain/b/r
      //   1348: dup
      //   1349: aload_0
      //   1350: getfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
      //   1353: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1356: putfield 93	com/appbrain/e/j$b:h	Lcom/appbrain/b/k;
      //   1359: iload_3
      //   1360: bipush 32
      //   1362: iand
      //   1363: bipush 32
      //   1365: if_icmpne +18 -> 1383
      //   1368: aload_0
      //   1369: new 126	com/appbrain/b/r
      //   1372: dup
      //   1373: aload_0
      //   1374: getfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
      //   1377: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1380: putfield 95	com/appbrain/e/j$b:i	Lcom/appbrain/b/k;
      //   1383: iload_3
      //   1384: bipush 64
      //   1386: iand
      //   1387: bipush 64
      //   1389: if_icmpne +14 -> 1403
      //   1392: aload_0
      //   1393: aload_0
      //   1394: getfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   1397: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1400: putfield 100	com/appbrain/e/j$b:j	Ljava/util/List;
      //   1403: iload_3
      //   1404: sipush 512
      //   1407: iand
      //   1408: sipush 512
      //   1411: if_icmpne +18 -> 1429
      //   1414: aload_0
      //   1415: new 126	com/appbrain/b/r
      //   1418: dup
      //   1419: aload_0
      //   1420: getfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
      //   1423: invokespecial 129	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   1426: putfield 137	com/appbrain/e/j$b:m	Lcom/appbrain/b/k;
      //   1429: iload_3
      //   1430: sipush 1024
      //   1433: iand
      //   1434: sipush 1024
      //   1437: if_icmpne +14 -> 1451
      //   1440: aload_0
      //   1441: aload_0
      //   1442: getfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
      //   1445: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1448: putfield 139	com/appbrain/e/j$b:n	Ljava/util/List;
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
      //   0	1529	0	this	b
      //   0	1529	1	paramd	d
      //   0	1529	2	paramf	com.appbrain.b.f
      //   22	1504	3	i1	int
      //   41	1192	4	i2	int
      //   29	1425	5	i3	int
      //   32	1477	6	i4	int
      //   19	1499	7	i5	int
      //   35	1489	8	i6	int
      //   651	334	9	i7	int
      // Exception table:
      //   from	to	target	type
      //   227	240	753	com/appbrain/b/i
      //   289	302	753	com/appbrain/b/i
      //   351	364	753	com/appbrain/b/i
      //   416	429	753	com/appbrain/b/i
      //   481	494	753	com/appbrain/b/i
      //   546	559	753	com/appbrain/b/i
      //   611	628	753	com/appbrain/b/i
      //   715	722	753	com/appbrain/b/i
      //   733	750	753	com/appbrain/b/i
      //   983	989	753	com/appbrain/b/i
      //   1142	1155	753	com/appbrain/b/i
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
      //   37	43	1522	com/appbrain/b/i
      //   169	178	1522	com/appbrain/b/i
      //   200	211	1522	com/appbrain/b/i
      //   262	273	1522	com/appbrain/b/i
      //   324	335	1522	com/appbrain/b/i
      //   388	399	1522	com/appbrain/b/i
      //   453	464	1522	com/appbrain/b/i
      //   518	529	1522	com/appbrain/b/i
      //   583	594	1522	com/appbrain/b/i
      //   643	653	1522	com/appbrain/b/i
      //   671	678	1522	com/appbrain/b/i
      //   687	698	1522	com/appbrain/b/i
      //   1004	1014	1522	com/appbrain/b/i
      //   1023	1031	1522	com/appbrain/b/i
      //   1043	1053	1522	com/appbrain/b/i
      //   1062	1070	1522	com/appbrain/b/i
      //   1113	1124	1522	com/appbrain/b/i
      //   1184	1195	1522	com/appbrain/b/i
      //   1214	1232	1522	com/appbrain/b/i
    }
    
    public static b f()
    {
      return b;
    }
    
    private c n()
    {
      Object localObject = this.k;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.k = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void o()
    {
      this.d = com.appbrain.b.j.a;
      this.e = com.appbrain.b.j.a;
      this.f = com.appbrain.b.j.a;
      this.g = com.appbrain.b.j.a;
      this.h = com.appbrain.b.j.a;
      this.i = com.appbrain.b.j.a;
      this.j = Collections.emptyList();
      this.k = "";
      this.l = false;
      this.m = com.appbrain.b.j.a;
      this.n = Collections.emptyList();
    }
    
    public final String a(int paramInt)
    {
      return (String)this.d.get(paramInt);
    }
    
    public final void a(e parame)
    {
      int i3 = 0;
      c();
      int i1 = 0;
      while (i1 < this.d.size())
      {
        parame.a(1, this.d.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.e.size())
      {
        parame.a(2, this.e.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.f.size())
      {
        parame.a(3, this.f.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.g.size())
      {
        parame.a(4, this.g.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.h.size())
      {
        parame.a(5, this.h.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.i.size())
      {
        parame.a(6, this.i.a(i1));
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.j.size())
      {
        parame.a(7, ((Integer)this.j.get(i1)).intValue());
        i1 += 1;
      }
      if ((this.c & 0x1) == 1) {
        parame.a(8, n());
      }
      if ((this.c & 0x2) == 2) {
        parame.a(9, this.l);
      }
      i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.m.size()) {
          break;
        }
        parame.a(10, this.m.a(i1));
        i1 += 1;
      }
      while (i2 < this.n.size())
      {
        parame.a(11, (com.appbrain.b.m)this.n.get(i2));
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
        i1 += e.a(this.d.a(i2));
        i2 += 1;
      }
      int i10 = this.d.size();
      int i3 = 0;
      i2 = 0;
      while (i3 < this.e.size())
      {
        i2 += e.a(this.e.a(i3));
        i3 += 1;
      }
      int i11 = this.e.size();
      int i4 = 0;
      i3 = 0;
      while (i4 < this.f.size())
      {
        i3 += e.a(this.f.a(i4));
        i4 += 1;
      }
      int i12 = this.f.size();
      int i5 = 0;
      i4 = 0;
      while (i5 < this.g.size())
      {
        i4 += e.a(this.g.a(i5));
        i5 += 1;
      }
      int i13 = this.g.size();
      int i6 = 0;
      i5 = 0;
      while (i6 < this.h.size())
      {
        i5 += e.a(this.h.a(i6));
        i6 += 1;
      }
      int i14 = this.h.size();
      int i7 = 0;
      i6 = 0;
      while (i7 < this.i.size())
      {
        i6 += e.a(this.i.a(i7));
        i7 += 1;
      }
      int i15 = this.i.size();
      i7 = 0;
      int i8 = 0;
      while (i7 < this.j.size())
      {
        i8 += e.b(((Integer)this.j.get(i7)).intValue());
        i7 += 1;
      }
      i2 = i1 + 0 + i10 * 1 + i2 + i11 * 1 + i3 + i12 * 1 + i4 + i13 * 1 + i5 + i14 * 1 + i6 + i15 * 1 + i8 + this.j.size() * 1;
      i1 = i2;
      if ((this.c & 0x1) == 1) {
        i1 = i2 + e.b(8, n());
      }
      i2 = i1;
      if ((this.c & 0x2) == 2)
      {
        boolean bool = this.l;
        i2 = i1 + e.a(9);
      }
      i1 = 0;
      i3 = 0;
      while (i1 < this.m.size())
      {
        i3 += e.a(this.m.a(i1));
        i1 += 1;
      }
      i1 = i2 + i3 + this.m.size() * 1;
      i2 = i9;
      while (i2 < this.n.size())
      {
        i3 = e.b(11, (com.appbrain.b.m)this.n.get(i2));
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
    
    public final j.d i(int paramInt)
    {
      return (j.d)this.n.get(paramInt);
    }
    
    public final String i()
    {
      Object localObject = this.k;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
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
    
    public final int m()
    {
      return this.n.size();
    }
    
    public static final class a
      extends g.a
      implements j.c
    {
      private int a;
      private com.appbrain.b.k b = com.appbrain.b.j.a;
      private com.appbrain.b.k c = com.appbrain.b.j.a;
      private com.appbrain.b.k d = com.appbrain.b.j.a;
      private com.appbrain.b.k e = com.appbrain.b.j.a;
      private com.appbrain.b.k f = com.appbrain.b.j.a;
      private com.appbrain.b.k g = com.appbrain.b.j.a;
      private List h = Collections.emptyList();
      private Object i = "";
      private boolean j;
      private com.appbrain.b.k k = com.appbrain.b.j.a;
      private List l = Collections.emptyList();
      
      private a f()
      {
        return new a().a(g());
      }
      
      private j.b g()
      {
        int m = 1;
        j.b localb = new j.b('\000');
        int i1 = this.a;
        if ((this.a & 0x1) == 1)
        {
          this.b = new com.appbrain.b.r(this.b);
          this.a &= 0xFFFFFFFE;
        }
        j.b.a(localb, this.b);
        if ((this.a & 0x2) == 2)
        {
          this.c = new com.appbrain.b.r(this.c);
          this.a &= 0xFFFFFFFD;
        }
        j.b.b(localb, this.c);
        if ((this.a & 0x4) == 4)
        {
          this.d = new com.appbrain.b.r(this.d);
          this.a &= 0xFFFFFFFB;
        }
        j.b.c(localb, this.d);
        if ((this.a & 0x8) == 8)
        {
          this.e = new com.appbrain.b.r(this.e);
          this.a &= 0xFFFFFFF7;
        }
        j.b.d(localb, this.e);
        if ((this.a & 0x10) == 16)
        {
          this.f = new com.appbrain.b.r(this.f);
          this.a &= 0xFFFFFFEF;
        }
        j.b.e(localb, this.f);
        if ((this.a & 0x20) == 32)
        {
          this.g = new com.appbrain.b.r(this.g);
          this.a &= 0xFFFFFFDF;
        }
        j.b.f(localb, this.g);
        if ((this.a & 0x40) == 64)
        {
          this.h = Collections.unmodifiableList(this.h);
          this.a &= 0xFFFFFFBF;
        }
        j.b.a(localb, this.h);
        if ((i1 & 0x80) == 128) {}
        for (;;)
        {
          j.b.a(localb, this.i);
          int n = m;
          if ((i1 & 0x100) == 256) {
            n = m | 0x2;
          }
          j.b.a(localb, this.j);
          if ((this.a & 0x200) == 512)
          {
            this.k = new com.appbrain.b.r(this.k);
            this.a &= 0xFDFF;
          }
          j.b.g(localb, this.k);
          if ((this.a & 0x400) == 1024)
          {
            this.l = Collections.unmodifiableList(this.l);
            this.a &= 0xFBFF;
          }
          j.b.b(localb, this.l);
          j.b.a(localb, n);
          return localb;
          m = 0;
        }
      }
      
      public final a a(j.b paramb)
      {
        if (paramb == j.b.f()) {}
        label95:
        label138:
        label181:
        label224:
        label267:
        label310:
        label508:
        label560:
        label612:
        label667:
        label722:
        label777:
        label832:
        label888:
        for (;;)
        {
          return this;
          if (!j.b.a(paramb).isEmpty())
          {
            if (this.b.isEmpty())
            {
              this.b = j.b.a(paramb);
              this.a &= 0xFFFFFFFE;
            }
          }
          else
          {
            if (!j.b.b(paramb).isEmpty())
            {
              if (!this.c.isEmpty()) {
                break label508;
              }
              this.c = j.b.b(paramb);
              this.a &= 0xFFFFFFFD;
            }
            if (!j.b.c(paramb).isEmpty())
            {
              if (!this.d.isEmpty()) {
                break label560;
              }
              this.d = j.b.c(paramb);
              this.a &= 0xFFFFFFFB;
            }
            if (!j.b.d(paramb).isEmpty())
            {
              if (!this.e.isEmpty()) {
                break label612;
              }
              this.e = j.b.d(paramb);
              this.a &= 0xFFFFFFF7;
            }
            if (!j.b.e(paramb).isEmpty())
            {
              if (!this.f.isEmpty()) {
                break label667;
              }
              this.f = j.b.e(paramb);
              this.a &= 0xFFFFFFEF;
            }
            if (!j.b.f(paramb).isEmpty())
            {
              if (!this.g.isEmpty()) {
                break label722;
              }
              this.g = j.b.f(paramb);
              this.a &= 0xFFFFFFDF;
            }
            if (!j.b.g(paramb).isEmpty())
            {
              if (!this.h.isEmpty()) {
                break label777;
              }
              this.h = j.b.g(paramb);
              this.a &= 0xFFFFFFBF;
            }
            if (paramb.h())
            {
              this.a |= 0x80;
              this.i = j.b.h(paramb);
            }
            if (paramb.j())
            {
              boolean bool = paramb.k();
              this.a |= 0x100;
              this.j = bool;
            }
            if (!j.b.i(paramb).isEmpty())
            {
              if (!this.k.isEmpty()) {
                break label832;
              }
              this.k = j.b.i(paramb);
              this.a &= 0xFDFF;
            }
          }
          for (;;)
          {
            if (j.b.j(paramb).isEmpty()) {
              break label888;
            }
            if (!this.l.isEmpty()) {
              break label890;
            }
            this.l = j.b.j(paramb);
            this.a &= 0xFBFF;
            return this;
            if ((this.a & 0x1) != 1)
            {
              this.b = new com.appbrain.b.j(this.b);
              this.a |= 0x1;
            }
            this.b.addAll(j.b.a(paramb));
            break;
            if ((this.a & 0x2) != 2)
            {
              this.c = new com.appbrain.b.j(this.c);
              this.a |= 0x2;
            }
            this.c.addAll(j.b.b(paramb));
            break label95;
            if ((this.a & 0x4) != 4)
            {
              this.d = new com.appbrain.b.j(this.d);
              this.a |= 0x4;
            }
            this.d.addAll(j.b.c(paramb));
            break label138;
            if ((this.a & 0x8) != 8)
            {
              this.e = new com.appbrain.b.j(this.e);
              this.a |= 0x8;
            }
            this.e.addAll(j.b.d(paramb));
            break label181;
            if ((this.a & 0x10) != 16)
            {
              this.f = new com.appbrain.b.j(this.f);
              this.a |= 0x10;
            }
            this.f.addAll(j.b.e(paramb));
            break label224;
            if ((this.a & 0x20) != 32)
            {
              this.g = new com.appbrain.b.j(this.g);
              this.a |= 0x20;
            }
            this.g.addAll(j.b.f(paramb));
            break label267;
            if ((this.a & 0x40) != 64)
            {
              this.h = new ArrayList(this.h);
              this.a |= 0x40;
            }
            this.h.addAll(j.b.g(paramb));
            break label310;
            if ((this.a & 0x200) != 512)
            {
              this.k = new com.appbrain.b.j(this.k);
              this.a |= 0x200;
            }
            this.k.addAll(j.b.i(paramb));
          }
        }
        label890:
        if ((this.a & 0x400) != 1024)
        {
          this.l = new ArrayList(this.l);
          this.a |= 0x400;
        }
        this.l.addAll(j.b.j(paramb));
        return this;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface c
    extends com.appbrain.b.n
  {}
  
  public static final class d
    extends g
    implements j.e
  {
    public static com.appbrain.b.o a = new m();
    private static final d b;
    private int c;
    private Object d;
    private long e;
    private com.appbrain.b.k f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      d locald = new d((byte)0);
      b = locald;
      locald.l();
    }
    
    private d()
    {
      super();
    }
    
    private d(byte paramByte) {}
    
    private d(d paramd)
    {
      l();
      for (int k = 0;; k = 1)
      {
        label23:
        int m;
        int n;
        int i1;
        if (k == 0)
        {
          m = i;
          n = i;
          i1 = i;
        }
        for (;;)
        {
          try
          {
            j = paramd.a();
            switch (j)
            {
            case 10: 
              m = i;
              n = i;
              i1 = i;
              if (paramd.b(j)) {
                break label23;
              }
              k = 1;
              break label23;
              m = i;
              n = i;
              i1 = i;
              this.c |= 0x1;
              m = i;
              n = i;
              i1 = i;
              this.d = paramd.e();
              break label23;
            }
          }
          catch (i paramd)
          {
            i = m;
            try
            {
              throw paramd.a(this);
            }
            finally {}
            if ((i & 0x4) == 4) {
              this.f = new com.appbrain.b.r(this.f);
            }
            throw paramd;
            m = i;
            n = i;
            i1 = i;
            this.c |= 0x2;
            m = i;
            n = i;
            i1 = i;
            this.e = paramd.b();
            break;
          }
          catch (IOException paramd)
          {
            i = n;
            throw new i(paramd.getMessage()).a(this);
            j = i;
            if ((i & 0x4) != 4)
            {
              m = i;
              n = i;
              i1 = i;
              this.f = new com.appbrain.b.j();
              j = i | 0x4;
            }
            m = j;
            n = j;
            i1 = j;
            this.f.a(paramd.e());
          }
          finally
          {
            int j;
            i = i1;
            continue;
          }
          if ((i & 0x4) == 4) {
            this.f = new com.appbrain.b.r(this.f);
          }
          return;
        }
      }
    }
    
    public static d f()
    {
      return b;
    }
    
    private c k()
    {
      Object localObject = this.d;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.d = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void l()
    {
      this.d = "";
      this.e = 0L;
      this.f = com.appbrain.b.j.a;
    }
    
    public final void a(e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, k());
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, this.e);
      }
      int i = 0;
      while (i < this.f.size())
      {
        parame.a(3, this.f.a(i));
        i += 1;
      }
    }
    
    public final int c()
    {
      int m = 0;
      int i = this.h;
      if (i != -1) {
        return i;
      }
      if ((this.c & 0x1) == 1) {}
      for (i = e.b(1, k()) + 0;; i = 0)
      {
        int j = i;
        if ((this.c & 0x2) == 2) {
          j = i + e.b(2, this.e);
        }
        int k = 0;
        i = m;
        while (i < this.f.size())
        {
          k += e.a(this.f.a(i));
          i += 1;
        }
        i = j + k + this.f.size() * 1;
        this.h = i;
        return i;
      }
    }
    
    public final boolean e()
    {
      int i = this.g;
      if (i != -1) {
        return i == 1;
      }
      this.g = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final String h()
    {
      Object localObject = this.d;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.d = str;
      }
      return str;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final long j()
    {
      return this.e;
    }
    
    public static final class a
      extends g.a
      implements j.e
    {
      private int a;
      private Object b = "";
      private long c;
      private com.appbrain.b.k d = com.appbrain.b.j.a;
      
      private a f()
      {
        return new a().a(g());
      }
      
      private j.d g()
      {
        int i = 1;
        j.d locald = new j.d('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          j.d.a(locald, this.b);
          int j = i;
          if ((k & 0x2) == 2) {
            j = i | 0x2;
          }
          j.d.a(locald, this.c);
          if ((this.a & 0x4) == 4)
          {
            this.d = new com.appbrain.b.r(this.d);
            this.a &= 0xFFFFFFFB;
          }
          j.d.a(locald, this.d);
          j.d.a(locald, j);
          return locald;
          i = 0;
        }
      }
      
      public final a a(j.d paramd)
      {
        if (paramd == j.d.f()) {}
        do
        {
          return this;
          if (paramd.g())
          {
            this.a |= 0x1;
            this.b = j.d.a(paramd);
          }
          if (paramd.i())
          {
            long l = paramd.j();
            this.a |= 0x2;
            this.c = l;
          }
        } while (j.d.b(paramd).isEmpty());
        if (this.d.isEmpty())
        {
          this.d = j.d.b(paramd);
          this.a &= 0xFFFFFFFB;
          return this;
        }
        if ((this.a & 0x4) != 4)
        {
          this.d = new com.appbrain.b.j(this.d);
          this.a |= 0x4;
        }
        this.d.addAll(j.d.b(paramd));
        return this;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface e
    extends com.appbrain.b.n
  {}
  
  public static final class f
    extends g
    implements j.g
  {
    public static com.appbrain.b.o a = new n();
    private static final f b;
    private int c;
    private h.a d;
    private int e;
    private int f;
    private j.h g;
    private int h;
    private boolean i;
    private Object j;
    private byte k = -1;
    private int l = -1;
    
    static
    {
      f localf = new f((byte)0);
      b = localf;
      localf.v();
    }
    
    private f()
    {
      super();
    }
    
    private f(byte paramByte) {}
    
    /* Error */
    private f(d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 54	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 51	com/appbrain/e/j$f:k	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 53	com/appbrain/e/j$f:l	I
      //   14: aload_0
      //   15: invokespecial 47	com/appbrain/e/j$f:v	()V
      //   18: iconst_0
      //   19: istore_3
      //   20: iload_3
      //   21: ifne +341 -> 362
      //   24: aload_1
      //   25: invokevirtual 66	com/appbrain/b/d:a	()I
      //   28: istore 4
      //   30: iload 4
      //   32: lookupswitch	default:+337->369, 0:+340->372, 10:+90->122, 32:+171->203, 40:+209->241, 48:+230->262, 56:+264->296, 64:+286->318, 74:+308->340
      //   108: aload_1
      //   109: iload 4
      //   111: invokevirtual 69	com/appbrain/b/d:b	(I)Z
      //   114: ifne -94 -> 20
      //   117: iconst_1
      //   118: istore_3
      //   119: goto -99 -> 20
      //   122: aload_0
      //   123: getfield 71	com/appbrain/e/j$f:c	I
      //   126: iconst_1
      //   127: iand
      //   128: iconst_1
      //   129: if_icmpne +234 -> 363
      //   132: aload_0
      //   133: getfield 73	com/appbrain/e/j$f:d	Lcom/appbrain/e/h$a;
      //   136: invokevirtual 79	com/appbrain/e/h$a:at	()Lcom/appbrain/e/h$a$a;
      //   139: astore 5
      //   141: aload_0
      //   142: aload_1
      //   143: getstatic 80	com/appbrain/e/h$a:a	Lcom/appbrain/b/o;
      //   146: aload_2
      //   147: invokevirtual 83	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   150: checkcast 75	com/appbrain/e/h$a
      //   153: putfield 73	com/appbrain/e/j$f:d	Lcom/appbrain/e/h$a;
      //   156: aload 5
      //   158: ifnull +22 -> 180
      //   161: aload 5
      //   163: aload_0
      //   164: getfield 73	com/appbrain/e/j$f:d	Lcom/appbrain/e/h$a;
      //   167: invokevirtual 88	com/appbrain/e/h$a$a:a	(Lcom/appbrain/e/h$a;)Lcom/appbrain/e/h$a$a;
      //   170: pop
      //   171: aload_0
      //   172: aload 5
      //   174: invokevirtual 91	com/appbrain/e/h$a$a:f	()Lcom/appbrain/e/h$a;
      //   177: putfield 73	com/appbrain/e/j$f:d	Lcom/appbrain/e/h$a;
      //   180: aload_0
      //   181: aload_0
      //   182: getfield 71	com/appbrain/e/j$f:c	I
      //   185: iconst_1
      //   186: ior
      //   187: putfield 71	com/appbrain/e/j$f:c	I
      //   190: goto -170 -> 20
      //   193: astore_1
      //   194: aload_1
      //   195: aload_0
      //   196: invokevirtual 94	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   199: athrow
      //   200: astore_1
      //   201: aload_1
      //   202: athrow
      //   203: aload_0
      //   204: aload_0
      //   205: getfield 71	com/appbrain/e/j$f:c	I
      //   208: iconst_2
      //   209: ior
      //   210: putfield 71	com/appbrain/e/j$f:c	I
      //   213: aload_0
      //   214: aload_1
      //   215: invokevirtual 96	com/appbrain/b/d:c	()I
      //   218: putfield 98	com/appbrain/e/j$f:e	I
      //   221: goto -201 -> 20
      //   224: astore_1
      //   225: new 59	com/appbrain/b/i
      //   228: dup
      //   229: aload_1
      //   230: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
      //   233: invokespecial 105	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   236: aload_0
      //   237: invokevirtual 94	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   240: athrow
      //   241: aload_0
      //   242: aload_0
      //   243: getfield 71	com/appbrain/e/j$f:c	I
      //   246: iconst_4
      //   247: ior
      //   248: putfield 71	com/appbrain/e/j$f:c	I
      //   251: aload_0
      //   252: aload_1
      //   253: invokevirtual 96	com/appbrain/b/d:c	()I
      //   256: putfield 107	com/appbrain/e/j$f:f	I
      //   259: goto -239 -> 20
      //   262: aload_1
      //   263: invokevirtual 109	com/appbrain/b/d:f	()I
      //   266: invokestatic 114	com/appbrain/e/j$h:a	(I)Lcom/appbrain/e/j$h;
      //   269: astore 5
      //   271: aload 5
      //   273: ifnull -253 -> 20
      //   276: aload_0
      //   277: aload_0
      //   278: getfield 71	com/appbrain/e/j$f:c	I
      //   281: bipush 8
      //   283: ior
      //   284: putfield 71	com/appbrain/e/j$f:c	I
      //   287: aload_0
      //   288: aload 5
      //   290: putfield 116	com/appbrain/e/j$f:g	Lcom/appbrain/e/j$h;
      //   293: goto -273 -> 20
      //   296: aload_0
      //   297: aload_0
      //   298: getfield 71	com/appbrain/e/j$f:c	I
      //   301: bipush 16
      //   303: ior
      //   304: putfield 71	com/appbrain/e/j$f:c	I
      //   307: aload_0
      //   308: aload_1
      //   309: invokevirtual 96	com/appbrain/b/d:c	()I
      //   312: putfield 118	com/appbrain/e/j$f:h	I
      //   315: goto -295 -> 20
      //   318: aload_0
      //   319: aload_0
      //   320: getfield 71	com/appbrain/e/j$f:c	I
      //   323: bipush 32
      //   325: ior
      //   326: putfield 71	com/appbrain/e/j$f:c	I
      //   329: aload_0
      //   330: aload_1
      //   331: invokevirtual 121	com/appbrain/b/d:d	()Z
      //   334: putfield 123	com/appbrain/e/j$f:i	Z
      //   337: goto -317 -> 20
      //   340: aload_0
      //   341: aload_0
      //   342: getfield 71	com/appbrain/e/j$f:c	I
      //   345: bipush 64
      //   347: ior
      //   348: putfield 71	com/appbrain/e/j$f:c	I
      //   351: aload_0
      //   352: aload_1
      //   353: invokevirtual 126	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   356: putfield 128	com/appbrain/e/j$f:j	Ljava/lang/Object;
      //   359: goto -339 -> 20
      //   362: return
      //   363: aconst_null
      //   364: astore 5
      //   366: goto -225 -> 141
      //   369: goto -261 -> 108
      //   372: iconst_1
      //   373: istore_3
      //   374: goto -354 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	377	0	this	f
      //   0	377	1	paramd	d
      //   0	377	2	paramf	com.appbrain.b.f
      //   19	355	3	m	int
      //   28	82	4	n	int
      //   139	226	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   24	30	193	com/appbrain/b/i
      //   108	117	193	com/appbrain/b/i
      //   122	141	193	com/appbrain/b/i
      //   141	156	193	com/appbrain/b/i
      //   161	180	193	com/appbrain/b/i
      //   180	190	193	com/appbrain/b/i
      //   203	221	193	com/appbrain/b/i
      //   241	259	193	com/appbrain/b/i
      //   262	271	193	com/appbrain/b/i
      //   276	293	193	com/appbrain/b/i
      //   296	315	193	com/appbrain/b/i
      //   318	337	193	com/appbrain/b/i
      //   340	359	193	com/appbrain/b/i
      //   24	30	200	finally
      //   108	117	200	finally
      //   122	141	200	finally
      //   141	156	200	finally
      //   161	180	200	finally
      //   180	190	200	finally
      //   194	200	200	finally
      //   203	221	200	finally
      //   225	241	200	finally
      //   241	259	200	finally
      //   262	271	200	finally
      //   276	293	200	finally
      //   296	315	200	finally
      //   318	337	200	finally
      //   340	359	200	finally
      //   24	30	224	java/io/IOException
      //   108	117	224	java/io/IOException
      //   122	141	224	java/io/IOException
      //   141	156	224	java/io/IOException
      //   161	180	224	java/io/IOException
      //   180	190	224	java/io/IOException
      //   203	221	224	java/io/IOException
      //   241	259	224	java/io/IOException
      //   262	271	224	java/io/IOException
      //   276	293	224	java/io/IOException
      //   296	315	224	java/io/IOException
      //   318	337	224	java/io/IOException
      //   340	359	224	java/io/IOException
    }
    
    public static f f()
    {
      return b;
    }
    
    public static a t()
    {
      return a.f();
    }
    
    private c u()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.j = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void v()
    {
      this.d = h.a.f();
      this.e = 0;
      this.f = 0;
      this.g = j.h.a;
      this.h = 0;
      this.i = false;
      this.j = "";
    }
    
    public final void a(e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(4, this.e);
      }
      if ((this.c & 0x4) == 4) {
        parame.a(5, this.f);
      }
      if ((this.c & 0x8) == 8) {
        parame.b(6, this.g.a());
      }
      if ((this.c & 0x10) == 16) {
        parame.a(7, this.h);
      }
      if ((this.c & 0x20) == 32) {
        parame.a(8, this.i);
      }
      if ((this.c & 0x40) == 64) {
        parame.a(9, u());
      }
    }
    
    public final int c()
    {
      int m = this.l;
      if (m != -1) {
        return m;
      }
      int n = 0;
      if ((this.c & 0x1) == 1) {
        n = e.b(1, this.d) + 0;
      }
      m = n;
      if ((this.c & 0x2) == 2) {
        m = n + e.c(4, this.e);
      }
      n = m;
      if ((this.c & 0x4) == 4) {
        n = m + e.c(5, this.f);
      }
      m = n;
      if ((this.c & 0x8) == 8) {
        m = n + e.d(6, this.g.a());
      }
      n = m;
      if ((this.c & 0x10) == 16) {
        n = m + e.c(7, this.h);
      }
      m = n;
      if ((this.c & 0x20) == 32)
      {
        boolean bool = this.i;
        m = n + e.a(8);
      }
      n = m;
      if ((this.c & 0x40) == 64) {
        n = m + e.b(9, u());
      }
      this.l = n;
      return n;
    }
    
    public final boolean e()
    {
      int m = this.k;
      if (m != -1) {
        return m == 1;
      }
      this.k = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final h.a h()
    {
      return this.d;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final int j()
    {
      return this.e;
    }
    
    public final boolean k()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final int l()
    {
      return this.f;
    }
    
    public final boolean m()
    {
      return (this.c & 0x8) == 8;
    }
    
    public final j.h n()
    {
      return this.g;
    }
    
    public final boolean o()
    {
      return (this.c & 0x10) == 16;
    }
    
    public final int p()
    {
      return this.h;
    }
    
    public final boolean q()
    {
      return (this.c & 0x20) == 32;
    }
    
    public final boolean r()
    {
      return this.i;
    }
    
    public final boolean s()
    {
      return (this.c & 0x40) == 64;
    }
    
    public static final class a
      extends g.a
      implements j.g
    {
      private int a;
      private h.a b = h.a.f();
      private int c;
      private int d;
      private j.h e = j.h.a;
      private int f;
      private boolean g;
      private Object h = "";
      
      private a g()
      {
        return new a().a(h());
      }
      
      private j.f h()
      {
        int j = 1;
        j.f localf = new j.f('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          j.f.a(localf, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          j.f.a(localf, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          j.f.b(localf, this.d);
          i = j;
          if ((k & 0x8) == 8) {
            i = j | 0x8;
          }
          j.f.a(localf, this.e);
          j = i;
          if ((k & 0x10) == 16) {
            j = i | 0x10;
          }
          j.f.c(localf, this.f);
          i = j;
          if ((k & 0x20) == 32) {
            i = j | 0x20;
          }
          j.f.a(localf, this.g);
          j = i;
          if ((k & 0x40) == 64) {
            j = i | 0x40;
          }
          j.f.a(localf, this.h);
          j.f.d(localf, j);
          return localf;
          j = 0;
        }
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x2;
        this.c = paramInt;
        return this;
      }
      
      public final a a(h.a parama)
      {
        if (parama == null) {
          throw new NullPointerException();
        }
        this.b = parama;
        this.a |= 0x1;
        return this;
      }
      
      public final a a(j.f paramf)
      {
        if (paramf == j.f.f()) {
          return this;
        }
        h.a locala;
        if (paramf.g())
        {
          locala = paramf.h();
          if (((this.a & 0x1) != 1) || (this.b == h.a.f())) {
            break label177;
          }
        }
        label177:
        for (this.b = h.a.a(this.b).a(locala).f();; this.b = locala)
        {
          this.a |= 0x1;
          if (paramf.i()) {
            a(paramf.j());
          }
          if (paramf.k()) {
            b(paramf.l());
          }
          if (paramf.m()) {
            a(paramf.n());
          }
          if (paramf.o()) {
            c(paramf.p());
          }
          if (paramf.q()) {
            a(paramf.r());
          }
          if (!paramf.s()) {
            break;
          }
          this.a |= 0x40;
          this.h = j.f.a(paramf);
          return this;
        }
      }
      
      public final a a(j.h paramh)
      {
        if (paramh == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.e = paramh;
        return this;
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x40;
        this.h = paramString;
        return this;
      }
      
      public final a a(boolean paramBoolean)
      {
        this.a |= 0x20;
        this.g = paramBoolean;
        return this;
      }
      
      public final a b(int paramInt)
      {
        this.a |= 0x4;
        this.d = paramInt;
        return this;
      }
      
      public final a c(int paramInt)
      {
        this.a |= 0x10;
        this.f = paramInt;
        return this;
      }
      
      public final j.f d()
      {
        j.f localf = h();
        if (!localf.e()) {
          throw new com.appbrain.b.q();
        }
        return localf;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface g
    extends com.appbrain.b.n
  {}
  
  public static enum h
  {
    private static com.appbrain.b.h.a l = new o();
    private final int m;
    
    private h(int paramInt1)
    {
      this.m = paramInt1;
    }
    
    public static h a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case -1: 
        return a;
      case 0: 
        return b;
      case 1: 
        return c;
      case 2: 
        return d;
      case 3: 
        return e;
      case 4: 
        return f;
      case 5: 
        return g;
      case 6: 
        return h;
      case 7: 
        return i;
      case 8: 
        return j;
      }
      return k;
    }
    
    public final int a()
    {
      return this.m;
    }
  }
  
  public static final class i
    extends g
    implements j.j
  {
    public static com.appbrain.b.o a = new p();
    private static final i b;
    private int c;
    private int d;
    private Object e;
    private Object f;
    private Object g;
    private Object h;
    private a i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private byte n = -1;
    private int o = -1;
    
    static
    {
      i locali = new i((byte)0);
      b = locali;
      locali.E();
    }
    
    private i()
    {
      super();
    }
    
    private i(byte paramByte) {}
    
    /* Error */
    private i(d paramd)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 58	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 55	com/appbrain/e/j$i:n	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 57	com/appbrain/e/j$i:o	I
      //   14: aload_0
      //   15: invokespecial 51	com/appbrain/e/j$i:E	()V
      //   18: iconst_0
      //   19: istore_2
      //   20: iload_2
      //   21: ifne +379 -> 400
      //   24: aload_1
      //   25: invokevirtual 70	com/appbrain/b/d:a	()I
      //   28: istore_3
      //   29: iload_3
      //   30: lookupswitch	default:+371->401, 0:+374->404, 8:+111->141, 18:+142->172, 26:+180->210, 34:+201->231, 42:+223->253, 48:+245->275, 56:+279->309, 64:+301->331, 72:+324->354, 80:+347->377
      //   128: aload_1
      //   129: iload_3
      //   130: invokevirtual 73	com/appbrain/b/d:b	(I)Z
      //   133: ifne -113 -> 20
      //   136: iconst_1
      //   137: istore_2
      //   138: goto -118 -> 20
      //   141: aload_0
      //   142: aload_0
      //   143: getfield 75	com/appbrain/e/j$i:c	I
      //   146: iconst_1
      //   147: ior
      //   148: putfield 75	com/appbrain/e/j$i:c	I
      //   151: aload_0
      //   152: aload_1
      //   153: invokevirtual 77	com/appbrain/b/d:c	()I
      //   156: putfield 79	com/appbrain/e/j$i:d	I
      //   159: goto -139 -> 20
      //   162: astore_1
      //   163: aload_1
      //   164: aload_0
      //   165: invokevirtual 82	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   168: athrow
      //   169: astore_1
      //   170: aload_1
      //   171: athrow
      //   172: aload_0
      //   173: aload_0
      //   174: getfield 75	com/appbrain/e/j$i:c	I
      //   177: iconst_2
      //   178: ior
      //   179: putfield 75	com/appbrain/e/j$i:c	I
      //   182: aload_0
      //   183: aload_1
      //   184: invokevirtual 85	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   187: putfield 87	com/appbrain/e/j$i:e	Ljava/lang/Object;
      //   190: goto -170 -> 20
      //   193: astore_1
      //   194: new 63	com/appbrain/b/i
      //   197: dup
      //   198: aload_1
      //   199: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
      //   202: invokespecial 94	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   205: aload_0
      //   206: invokevirtual 82	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   209: athrow
      //   210: aload_0
      //   211: aload_0
      //   212: getfield 75	com/appbrain/e/j$i:c	I
      //   215: iconst_4
      //   216: ior
      //   217: putfield 75	com/appbrain/e/j$i:c	I
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual 85	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   225: putfield 96	com/appbrain/e/j$i:f	Ljava/lang/Object;
      //   228: goto -208 -> 20
      //   231: aload_0
      //   232: aload_0
      //   233: getfield 75	com/appbrain/e/j$i:c	I
      //   236: bipush 8
      //   238: ior
      //   239: putfield 75	com/appbrain/e/j$i:c	I
      //   242: aload_0
      //   243: aload_1
      //   244: invokevirtual 85	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   247: putfield 98	com/appbrain/e/j$i:g	Ljava/lang/Object;
      //   250: goto -230 -> 20
      //   253: aload_0
      //   254: aload_0
      //   255: getfield 75	com/appbrain/e/j$i:c	I
      //   258: bipush 16
      //   260: ior
      //   261: putfield 75	com/appbrain/e/j$i:c	I
      //   264: aload_0
      //   265: aload_1
      //   266: invokevirtual 85	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   269: putfield 100	com/appbrain/e/j$i:h	Ljava/lang/Object;
      //   272: goto -252 -> 20
      //   275: aload_1
      //   276: invokevirtual 102	com/appbrain/b/d:f	()I
      //   279: invokestatic 105	com/appbrain/e/j$i$a:a	(I)Lcom/appbrain/e/j$i$a;
      //   282: astore 4
      //   284: aload 4
      //   286: ifnull -266 -> 20
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 75	com/appbrain/e/j$i:c	I
      //   294: bipush 32
      //   296: ior
      //   297: putfield 75	com/appbrain/e/j$i:c	I
      //   300: aload_0
      //   301: aload 4
      //   303: putfield 107	com/appbrain/e/j$i:i	Lcom/appbrain/e/j$i$a;
      //   306: goto -286 -> 20
      //   309: aload_0
      //   310: aload_0
      //   311: getfield 75	com/appbrain/e/j$i:c	I
      //   314: bipush 64
      //   316: ior
      //   317: putfield 75	com/appbrain/e/j$i:c	I
      //   320: aload_0
      //   321: aload_1
      //   322: invokevirtual 77	com/appbrain/b/d:c	()I
      //   325: putfield 109	com/appbrain/e/j$i:j	I
      //   328: goto -308 -> 20
      //   331: aload_0
      //   332: aload_0
      //   333: getfield 75	com/appbrain/e/j$i:c	I
      //   336: sipush 128
      //   339: ior
      //   340: putfield 75	com/appbrain/e/j$i:c	I
      //   343: aload_0
      //   344: aload_1
      //   345: invokevirtual 112	com/appbrain/b/d:d	()Z
      //   348: putfield 114	com/appbrain/e/j$i:k	Z
      //   351: goto -331 -> 20
      //   354: aload_0
      //   355: aload_0
      //   356: getfield 75	com/appbrain/e/j$i:c	I
      //   359: sipush 256
      //   362: ior
      //   363: putfield 75	com/appbrain/e/j$i:c	I
      //   366: aload_0
      //   367: aload_1
      //   368: invokevirtual 77	com/appbrain/b/d:c	()I
      //   371: putfield 116	com/appbrain/e/j$i:l	I
      //   374: goto -354 -> 20
      //   377: aload_0
      //   378: aload_0
      //   379: getfield 75	com/appbrain/e/j$i:c	I
      //   382: sipush 512
      //   385: ior
      //   386: putfield 75	com/appbrain/e/j$i:c	I
      //   389: aload_0
      //   390: aload_1
      //   391: invokevirtual 112	com/appbrain/b/d:d	()Z
      //   394: putfield 118	com/appbrain/e/j$i:m	Z
      //   397: goto -377 -> 20
      //   400: return
      //   401: goto -273 -> 128
      //   404: iconst_1
      //   405: istore_2
      //   406: goto -386 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	409	0	this	i
      //   0	409	1	paramd	d
      //   19	387	2	i1	int
      //   28	102	3	i2	int
      //   282	20	4	locala	a
      // Exception table:
      //   from	to	target	type
      //   24	29	162	com/appbrain/b/i
      //   128	136	162	com/appbrain/b/i
      //   141	159	162	com/appbrain/b/i
      //   172	190	162	com/appbrain/b/i
      //   210	228	162	com/appbrain/b/i
      //   231	250	162	com/appbrain/b/i
      //   253	272	162	com/appbrain/b/i
      //   275	284	162	com/appbrain/b/i
      //   289	306	162	com/appbrain/b/i
      //   309	328	162	com/appbrain/b/i
      //   331	351	162	com/appbrain/b/i
      //   354	374	162	com/appbrain/b/i
      //   377	397	162	com/appbrain/b/i
      //   24	29	169	finally
      //   128	136	169	finally
      //   141	159	169	finally
      //   163	169	169	finally
      //   172	190	169	finally
      //   194	210	169	finally
      //   210	228	169	finally
      //   231	250	169	finally
      //   253	272	169	finally
      //   275	284	169	finally
      //   289	306	169	finally
      //   309	328	169	finally
      //   331	351	169	finally
      //   354	374	169	finally
      //   377	397	169	finally
      //   24	29	193	java/io/IOException
      //   128	136	193	java/io/IOException
      //   141	159	193	java/io/IOException
      //   172	190	193	java/io/IOException
      //   210	228	193	java/io/IOException
      //   231	250	193	java/io/IOException
      //   253	272	193	java/io/IOException
      //   275	284	193	java/io/IOException
      //   289	306	193	java/io/IOException
      //   309	328	193	java/io/IOException
      //   331	351	193	java/io/IOException
      //   354	374	193	java/io/IOException
      //   377	397	193	java/io/IOException
    }
    
    private c A()
    {
      Object localObject = this.e;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.e = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private c B()
    {
      Object localObject = this.f;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.f = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private c C()
    {
      Object localObject = this.g;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.g = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private c D()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.h = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void E()
    {
      this.d = 0;
      this.e = "";
      this.f = "";
      this.g = "";
      this.h = "";
      this.i = a.a;
      this.j = 0;
      this.k = false;
      this.l = 0;
      this.m = false;
    }
    
    public static i a(byte[] paramArrayOfByte)
    {
      return (i)a.a(paramArrayOfByte);
    }
    
    public static i f()
    {
      return b;
    }
    
    public final void a(e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, A());
      }
      if ((this.c & 0x4) == 4) {
        parame.a(3, B());
      }
      if ((this.c & 0x8) == 8) {
        parame.a(4, C());
      }
      if ((this.c & 0x10) == 16) {
        parame.a(5, D());
      }
      if ((this.c & 0x20) == 32) {
        parame.b(6, this.i.a());
      }
      if ((this.c & 0x40) == 64) {
        parame.a(7, this.j);
      }
      if ((this.c & 0x80) == 128) {
        parame.a(8, this.k);
      }
      if ((this.c & 0x100) == 256) {
        parame.a(9, this.l);
      }
      if ((this.c & 0x200) == 512) {
        parame.a(10, this.m);
      }
    }
    
    public final int c()
    {
      int i1 = this.o;
      if (i1 != -1) {
        return i1;
      }
      int i2 = 0;
      if ((this.c & 0x1) == 1) {
        i2 = e.c(1, this.d) + 0;
      }
      i1 = i2;
      if ((this.c & 0x2) == 2) {
        i1 = i2 + e.b(2, A());
      }
      i2 = i1;
      if ((this.c & 0x4) == 4) {
        i2 = i1 + e.b(3, B());
      }
      i1 = i2;
      if ((this.c & 0x8) == 8) {
        i1 = i2 + e.b(4, C());
      }
      i2 = i1;
      if ((this.c & 0x10) == 16) {
        i2 = i1 + e.b(5, D());
      }
      i1 = i2;
      if ((this.c & 0x20) == 32) {
        i1 = i2 + e.d(6, this.i.a());
      }
      i2 = i1;
      if ((this.c & 0x40) == 64) {
        i2 = i1 + e.c(7, this.j);
      }
      i1 = i2;
      boolean bool;
      if ((this.c & 0x80) == 128)
      {
        bool = this.k;
        i1 = i2 + e.a(8);
      }
      i2 = i1;
      if ((this.c & 0x100) == 256) {
        i2 = i1 + e.c(9, this.l);
      }
      i1 = i2;
      if ((this.c & 0x200) == 512)
      {
        bool = this.m;
        i1 = i2 + e.a(10);
      }
      this.o = i1;
      return i1;
    }
    
    public final boolean e()
    {
      int i1 = this.n;
      if (i1 != -1) {
        return i1 == 1;
      }
      this.n = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final int h()
    {
      return this.d;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final String j()
    {
      Object localObject = this.e;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.e = str;
      }
      return str;
    }
    
    public final boolean k()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final String l()
    {
      Object localObject = this.f;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.f = str;
      }
      return str;
    }
    
    public final boolean m()
    {
      return (this.c & 0x8) == 8;
    }
    
    public final String n()
    {
      Object localObject = this.g;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.g = str;
      }
      return str;
    }
    
    public final boolean o()
    {
      return (this.c & 0x10) == 16;
    }
    
    public final String p()
    {
      Object localObject = this.h;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.h = str;
      }
      return str;
    }
    
    public final boolean q()
    {
      return (this.c & 0x20) == 32;
    }
    
    public final a r()
    {
      return this.i;
    }
    
    public final boolean s()
    {
      return (this.c & 0x40) == 64;
    }
    
    public final int t()
    {
      return this.j;
    }
    
    public final boolean u()
    {
      return (this.c & 0x80) == 128;
    }
    
    public final boolean v()
    {
      return this.k;
    }
    
    public final boolean w()
    {
      return (this.c & 0x100) == 256;
    }
    
    public final int x()
    {
      return this.l;
    }
    
    public final boolean y()
    {
      return (this.c & 0x200) == 512;
    }
    
    public final boolean z()
    {
      return this.m;
    }
    
    public static enum a
    {
      private static com.appbrain.b.h.a e = new q();
      private final int f;
      
      private a(int paramInt1)
      {
        this.f = paramInt1;
      }
      
      public static a a(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return a;
        case 1: 
          return b;
        case 2: 
          return c;
        }
        return d;
      }
      
      public final int a()
      {
        return this.f;
      }
    }
    
    public static final class b
      extends g.a
      implements j.j
    {
      private int a;
      private int b;
      private Object c = "";
      private Object d = "";
      private Object e = "";
      private Object f = "";
      private j.i.a g = j.i.a.a;
      private int h;
      private boolean i;
      private int j;
      private boolean k;
      
      private b f()
      {
        return new b().a(g());
      }
      
      private j.i g()
      {
        int n = 1;
        j.i locali = new j.i('\000');
        int i1 = this.a;
        if ((i1 & 0x1) == 1) {}
        for (;;)
        {
          j.i.a(locali, this.b);
          int m = n;
          if ((i1 & 0x2) == 2) {
            m = n | 0x2;
          }
          j.i.a(locali, this.c);
          n = m;
          if ((i1 & 0x4) == 4) {
            n = m | 0x4;
          }
          j.i.b(locali, this.d);
          m = n;
          if ((i1 & 0x8) == 8) {
            m = n | 0x8;
          }
          j.i.c(locali, this.e);
          n = m;
          if ((i1 & 0x10) == 16) {
            n = m | 0x10;
          }
          j.i.d(locali, this.f);
          m = n;
          if ((i1 & 0x20) == 32) {
            m = n | 0x20;
          }
          j.i.a(locali, this.g);
          n = m;
          if ((i1 & 0x40) == 64) {
            n = m | 0x40;
          }
          j.i.b(locali, this.h);
          m = n;
          if ((i1 & 0x80) == 128) {
            m = n | 0x80;
          }
          j.i.a(locali, this.i);
          n = m;
          if ((i1 & 0x100) == 256) {
            n = m | 0x100;
          }
          j.i.c(locali, this.j);
          m = n;
          if ((i1 & 0x200) == 512) {
            m = n | 0x200;
          }
          j.i.b(locali, this.k);
          j.i.d(locali, m);
          return locali;
          n = 0;
        }
      }
      
      public final b a(j.i parami)
      {
        if (parami == j.i.f()) {}
        do
        {
          return this;
          int m;
          if (parami.g())
          {
            m = parami.h();
            this.a |= 0x1;
            this.b = m;
          }
          if (parami.i())
          {
            this.a |= 0x2;
            this.c = j.i.a(parami);
          }
          if (parami.k())
          {
            this.a |= 0x4;
            this.d = j.i.b(parami);
          }
          if (parami.m())
          {
            this.a |= 0x8;
            this.e = j.i.c(parami);
          }
          if (parami.o())
          {
            this.a |= 0x10;
            this.f = j.i.d(parami);
          }
          if (parami.q())
          {
            j.i.a locala = parami.r();
            if (locala == null) {
              throw new NullPointerException();
            }
            this.a |= 0x20;
            this.g = locala;
          }
          if (parami.s())
          {
            m = parami.t();
            this.a |= 0x40;
            this.h = m;
          }
          if (parami.u())
          {
            bool = parami.v();
            this.a |= 0x80;
            this.i = bool;
          }
          if (parami.w())
          {
            m = parami.x();
            this.a |= 0x100;
            this.j = m;
          }
        } while (!parami.y());
        boolean bool = parami.z();
        this.a |= 0x200;
        this.k = bool;
        return this;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface j
    extends com.appbrain.b.n
  {}
  
  public static final class k
    extends g
    implements j.l
  {
    public static com.appbrain.b.o a = new r();
    private static final k b;
    private int c;
    private h.a d;
    private Object e;
    private j.a f;
    private long g;
    private long h;
    private Object i;
    private Object j;
    private boolean k;
    private int l;
    private byte m = -1;
    private int n = -1;
    
    static
    {
      k localk = new k((byte)0);
      b = localk;
      localk.C();
    }
    
    private k()
    {
      super();
    }
    
    private k(byte paramByte) {}
    
    /* Error */
    private k(d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 57	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 54	com/appbrain/e/j$k:m	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 56	com/appbrain/e/j$k:n	I
      //   14: aload_0
      //   15: invokespecial 50	com/appbrain/e/j$k:C	()V
      //   18: iconst_0
      //   19: istore_3
      //   20: iload_3
      //   21: ifne +403 -> 424
      //   24: aload_1
      //   25: invokevirtual 69	com/appbrain/b/d:a	()I
      //   28: istore 4
      //   30: iload 4
      //   32: lookupswitch	default:+399->431, 0:+402->434, 10:+106->138, 18:+187->219, 32:+225->257, 40:+258->290, 48:+280->312, 58:+302->334, 66:+324->356, 72:+346->378, 80:+369->401
      //   124: aload_1
      //   125: iload 4
      //   127: invokevirtual 72	com/appbrain/b/d:b	(I)Z
      //   130: ifne -110 -> 20
      //   133: iconst_1
      //   134: istore_3
      //   135: goto -115 -> 20
      //   138: aload_0
      //   139: getfield 74	com/appbrain/e/j$k:c	I
      //   142: iconst_1
      //   143: iand
      //   144: iconst_1
      //   145: if_icmpne +280 -> 425
      //   148: aload_0
      //   149: getfield 76	com/appbrain/e/j$k:d	Lcom/appbrain/e/h$a;
      //   152: invokevirtual 82	com/appbrain/e/h$a:at	()Lcom/appbrain/e/h$a$a;
      //   155: astore 5
      //   157: aload_0
      //   158: aload_1
      //   159: getstatic 83	com/appbrain/e/h$a:a	Lcom/appbrain/b/o;
      //   162: aload_2
      //   163: invokevirtual 86	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   166: checkcast 78	com/appbrain/e/h$a
      //   169: putfield 76	com/appbrain/e/j$k:d	Lcom/appbrain/e/h$a;
      //   172: aload 5
      //   174: ifnull +22 -> 196
      //   177: aload 5
      //   179: aload_0
      //   180: getfield 76	com/appbrain/e/j$k:d	Lcom/appbrain/e/h$a;
      //   183: invokevirtual 91	com/appbrain/e/h$a$a:a	(Lcom/appbrain/e/h$a;)Lcom/appbrain/e/h$a$a;
      //   186: pop
      //   187: aload_0
      //   188: aload 5
      //   190: invokevirtual 94	com/appbrain/e/h$a$a:f	()Lcom/appbrain/e/h$a;
      //   193: putfield 76	com/appbrain/e/j$k:d	Lcom/appbrain/e/h$a;
      //   196: aload_0
      //   197: aload_0
      //   198: getfield 74	com/appbrain/e/j$k:c	I
      //   201: iconst_1
      //   202: ior
      //   203: putfield 74	com/appbrain/e/j$k:c	I
      //   206: goto -186 -> 20
      //   209: astore_1
      //   210: aload_1
      //   211: aload_0
      //   212: invokevirtual 97	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   215: athrow
      //   216: astore_1
      //   217: aload_1
      //   218: athrow
      //   219: aload_0
      //   220: aload_0
      //   221: getfield 74	com/appbrain/e/j$k:c	I
      //   224: iconst_2
      //   225: ior
      //   226: putfield 74	com/appbrain/e/j$k:c	I
      //   229: aload_0
      //   230: aload_1
      //   231: invokevirtual 100	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   234: putfield 102	com/appbrain/e/j$k:e	Ljava/lang/Object;
      //   237: goto -217 -> 20
      //   240: astore_1
      //   241: new 62	com/appbrain/b/i
      //   244: dup
      //   245: aload_1
      //   246: invokevirtual 106	java/io/IOException:getMessage	()Ljava/lang/String;
      //   249: invokespecial 109	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   252: aload_0
      //   253: invokevirtual 97	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   256: athrow
      //   257: aload_1
      //   258: invokevirtual 111	com/appbrain/b/d:f	()I
      //   261: invokestatic 116	com/appbrain/e/j$a:a	(I)Lcom/appbrain/e/j$a;
      //   264: astore 5
      //   266: aload 5
      //   268: ifnull -248 -> 20
      //   271: aload_0
      //   272: aload_0
      //   273: getfield 74	com/appbrain/e/j$k:c	I
      //   276: iconst_4
      //   277: ior
      //   278: putfield 74	com/appbrain/e/j$k:c	I
      //   281: aload_0
      //   282: aload 5
      //   284: putfield 118	com/appbrain/e/j$k:f	Lcom/appbrain/e/j$a;
      //   287: goto -267 -> 20
      //   290: aload_0
      //   291: aload_0
      //   292: getfield 74	com/appbrain/e/j$k:c	I
      //   295: bipush 8
      //   297: ior
      //   298: putfield 74	com/appbrain/e/j$k:c	I
      //   301: aload_0
      //   302: aload_1
      //   303: invokevirtual 121	com/appbrain/b/d:b	()J
      //   306: putfield 123	com/appbrain/e/j$k:g	J
      //   309: goto -289 -> 20
      //   312: aload_0
      //   313: aload_0
      //   314: getfield 74	com/appbrain/e/j$k:c	I
      //   317: bipush 16
      //   319: ior
      //   320: putfield 74	com/appbrain/e/j$k:c	I
      //   323: aload_0
      //   324: aload_1
      //   325: invokevirtual 121	com/appbrain/b/d:b	()J
      //   328: putfield 125	com/appbrain/e/j$k:h	J
      //   331: goto -311 -> 20
      //   334: aload_0
      //   335: aload_0
      //   336: getfield 74	com/appbrain/e/j$k:c	I
      //   339: bipush 32
      //   341: ior
      //   342: putfield 74	com/appbrain/e/j$k:c	I
      //   345: aload_0
      //   346: aload_1
      //   347: invokevirtual 100	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   350: putfield 127	com/appbrain/e/j$k:i	Ljava/lang/Object;
      //   353: goto -333 -> 20
      //   356: aload_0
      //   357: aload_0
      //   358: getfield 74	com/appbrain/e/j$k:c	I
      //   361: bipush 64
      //   363: ior
      //   364: putfield 74	com/appbrain/e/j$k:c	I
      //   367: aload_0
      //   368: aload_1
      //   369: invokevirtual 100	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   372: putfield 129	com/appbrain/e/j$k:j	Ljava/lang/Object;
      //   375: goto -355 -> 20
      //   378: aload_0
      //   379: aload_0
      //   380: getfield 74	com/appbrain/e/j$k:c	I
      //   383: sipush 128
      //   386: ior
      //   387: putfield 74	com/appbrain/e/j$k:c	I
      //   390: aload_0
      //   391: aload_1
      //   392: invokevirtual 132	com/appbrain/b/d:d	()Z
      //   395: putfield 134	com/appbrain/e/j$k:k	Z
      //   398: goto -378 -> 20
      //   401: aload_0
      //   402: aload_0
      //   403: getfield 74	com/appbrain/e/j$k:c	I
      //   406: sipush 256
      //   409: ior
      //   410: putfield 74	com/appbrain/e/j$k:c	I
      //   413: aload_0
      //   414: aload_1
      //   415: invokevirtual 136	com/appbrain/b/d:c	()I
      //   418: putfield 138	com/appbrain/e/j$k:l	I
      //   421: goto -401 -> 20
      //   424: return
      //   425: aconst_null
      //   426: astore 5
      //   428: goto -271 -> 157
      //   431: goto -307 -> 124
      //   434: iconst_1
      //   435: istore_3
      //   436: goto -416 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	439	0	this	k
      //   0	439	1	paramd	d
      //   0	439	2	paramf	com.appbrain.b.f
      //   19	417	3	i1	int
      //   28	98	4	i2	int
      //   155	272	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   24	30	209	com/appbrain/b/i
      //   124	133	209	com/appbrain/b/i
      //   138	157	209	com/appbrain/b/i
      //   157	172	209	com/appbrain/b/i
      //   177	196	209	com/appbrain/b/i
      //   196	206	209	com/appbrain/b/i
      //   219	237	209	com/appbrain/b/i
      //   257	266	209	com/appbrain/b/i
      //   271	287	209	com/appbrain/b/i
      //   290	309	209	com/appbrain/b/i
      //   312	331	209	com/appbrain/b/i
      //   334	353	209	com/appbrain/b/i
      //   356	375	209	com/appbrain/b/i
      //   378	398	209	com/appbrain/b/i
      //   401	421	209	com/appbrain/b/i
      //   24	30	216	finally
      //   124	133	216	finally
      //   138	157	216	finally
      //   157	172	216	finally
      //   177	196	216	finally
      //   196	206	216	finally
      //   210	216	216	finally
      //   219	237	216	finally
      //   241	257	216	finally
      //   257	266	216	finally
      //   271	287	216	finally
      //   290	309	216	finally
      //   312	331	216	finally
      //   334	353	216	finally
      //   356	375	216	finally
      //   378	398	216	finally
      //   401	421	216	finally
      //   24	30	240	java/io/IOException
      //   124	133	240	java/io/IOException
      //   138	157	240	java/io/IOException
      //   157	172	240	java/io/IOException
      //   177	196	240	java/io/IOException
      //   196	206	240	java/io/IOException
      //   219	237	240	java/io/IOException
      //   257	266	240	java/io/IOException
      //   271	287	240	java/io/IOException
      //   290	309	240	java/io/IOException
      //   312	331	240	java/io/IOException
      //   334	353	240	java/io/IOException
      //   356	375	240	java/io/IOException
      //   378	398	240	java/io/IOException
      //   401	421	240	java/io/IOException
    }
    
    private c A()
    {
      Object localObject = this.i;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.i = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private c B()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.j = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void C()
    {
      this.d = h.a.f();
      this.e = "";
      this.f = j.a.a;
      this.g = 0L;
      this.h = 0L;
      this.i = "";
      this.j = "";
      this.k = false;
      this.l = 0;
    }
    
    public static a a(k paramk)
    {
      return a.g().a(paramk);
    }
    
    public static k f()
    {
      return b;
    }
    
    public static a x()
    {
      return a.g();
    }
    
    private c z()
    {
      Object localObject = this.e;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.e = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    public final void a(e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, z());
      }
      if ((this.c & 0x4) == 4) {
        parame.b(4, this.f.a());
      }
      if ((this.c & 0x8) == 8) {
        parame.a(5, this.g);
      }
      if ((this.c & 0x10) == 16) {
        parame.a(6, this.h);
      }
      if ((this.c & 0x20) == 32) {
        parame.a(7, A());
      }
      if ((this.c & 0x40) == 64) {
        parame.a(8, B());
      }
      if ((this.c & 0x80) == 128) {
        parame.a(9, this.k);
      }
      if ((this.c & 0x100) == 256) {
        parame.a(10, this.l);
      }
    }
    
    public final int c()
    {
      int i1 = this.n;
      if (i1 != -1) {
        return i1;
      }
      int i2 = 0;
      if ((this.c & 0x1) == 1) {
        i2 = e.b(1, this.d) + 0;
      }
      i1 = i2;
      if ((this.c & 0x2) == 2) {
        i1 = i2 + e.b(2, z());
      }
      i2 = i1;
      if ((this.c & 0x4) == 4) {
        i2 = i1 + e.d(4, this.f.a());
      }
      i1 = i2;
      if ((this.c & 0x8) == 8) {
        i1 = i2 + e.b(5, this.g);
      }
      i2 = i1;
      if ((this.c & 0x10) == 16) {
        i2 = i1 + e.b(6, this.h);
      }
      i1 = i2;
      if ((this.c & 0x20) == 32) {
        i1 = i2 + e.b(7, A());
      }
      i2 = i1;
      if ((this.c & 0x40) == 64) {
        i2 = i1 + e.b(8, B());
      }
      i1 = i2;
      if ((this.c & 0x80) == 128)
      {
        boolean bool = this.k;
        i1 = i2 + e.a(9);
      }
      i2 = i1;
      if ((this.c & 0x100) == 256) {
        i2 = i1 + e.c(10, this.l);
      }
      this.n = i2;
      return i2;
    }
    
    public final boolean e()
    {
      int i1 = this.m;
      if (i1 != -1) {
        return i1 == 1;
      }
      this.m = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final h.a h()
    {
      return this.d;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final String j()
    {
      Object localObject = this.e;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.e = str;
      }
      return str;
    }
    
    public final boolean k()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final j.a l()
    {
      return this.f;
    }
    
    public final boolean m()
    {
      return (this.c & 0x8) == 8;
    }
    
    public final long n()
    {
      return this.g;
    }
    
    public final boolean o()
    {
      return (this.c & 0x10) == 16;
    }
    
    public final long p()
    {
      return this.h;
    }
    
    public final boolean q()
    {
      return (this.c & 0x20) == 32;
    }
    
    public final boolean r()
    {
      return (this.c & 0x40) == 64;
    }
    
    public final String s()
    {
      Object localObject = this.j;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (c)localObject;
      String str = ((c)localObject).d();
      if (((c)localObject).e()) {
        this.j = str;
      }
      return str;
    }
    
    public final boolean t()
    {
      return (this.c & 0x80) == 128;
    }
    
    public final boolean u()
    {
      return this.k;
    }
    
    public final boolean v()
    {
      return (this.c & 0x100) == 256;
    }
    
    public final int w()
    {
      return this.l;
    }
    
    public final a y()
    {
      return a.g().a(this);
    }
    
    public static final class a
      extends g.a
      implements j.l
    {
      private int a;
      private h.a b = h.a.f();
      private Object c = "";
      private j.a d = j.a.a;
      private long e;
      private long f;
      private Object g = "";
      private Object h = "";
      private boolean i;
      private int j;
      
      private a h()
      {
        return new a().a(f());
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x100;
        this.j = paramInt;
        return this;
      }
      
      public final a a(long paramLong)
      {
        this.a |= 0x8;
        this.e = paramLong;
        return this;
      }
      
      public final a a(h.a parama)
      {
        if (parama == null) {
          throw new NullPointerException();
        }
        this.b = parama;
        this.a |= 0x1;
        return this;
      }
      
      public final a a(j.a parama)
      {
        if (parama == null) {
          throw new NullPointerException();
        }
        this.a |= 0x4;
        this.d = parama;
        return this;
      }
      
      public final a a(j.k paramk)
      {
        if (paramk == j.k.f()) {
          return this;
        }
        h.a locala;
        if (paramk.g())
        {
          locala = paramk.h();
          if (((this.a & 0x1) != 1) || (this.b == h.a.f())) {
            break label228;
          }
        }
        label228:
        for (this.b = h.a.a(this.b).a(locala).f();; this.b = locala)
        {
          this.a |= 0x1;
          if (paramk.i())
          {
            this.a |= 0x2;
            this.c = j.k.b(paramk);
          }
          if (paramk.k()) {
            a(paramk.l());
          }
          if (paramk.m()) {
            a(paramk.n());
          }
          if (paramk.o()) {
            b(paramk.p());
          }
          if (paramk.q())
          {
            this.a |= 0x20;
            this.g = j.k.c(paramk);
          }
          if (paramk.r())
          {
            this.a |= 0x40;
            this.h = j.k.d(paramk);
          }
          if (paramk.t()) {
            a(paramk.u());
          }
          if (!paramk.v()) {
            break;
          }
          a(paramk.w());
          return this;
        }
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x2;
        this.c = paramString;
        return this;
      }
      
      public final a a(boolean paramBoolean)
      {
        this.a |= 0x80;
        this.i = paramBoolean;
        return this;
      }
      
      public final a b(long paramLong)
      {
        this.a |= 0x10;
        this.f = paramLong;
        return this;
      }
      
      public final a b(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x20;
        this.g = paramString;
        return this;
      }
      
      public final a c(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x40;
        this.h = paramString;
        return this;
      }
      
      public final j.k d()
      {
        j.k localk = f();
        if (!localk.e()) {
          throw new com.appbrain.b.q();
        }
        return localk;
      }
      
      public final boolean e()
      {
        return true;
      }
      
      public final j.k f()
      {
        int m = 1;
        j.k localk = new j.k('\000');
        int n = this.a;
        if ((n & 0x1) == 1) {}
        for (;;)
        {
          j.k.a(localk, this.b);
          int k = m;
          if ((n & 0x2) == 2) {
            k = m | 0x2;
          }
          j.k.a(localk, this.c);
          m = k;
          if ((n & 0x4) == 4) {
            m = k | 0x4;
          }
          j.k.a(localk, this.d);
          k = m;
          if ((n & 0x8) == 8) {
            k = m | 0x8;
          }
          j.k.a(localk, this.e);
          m = k;
          if ((n & 0x10) == 16) {
            m = k | 0x10;
          }
          j.k.b(localk, this.f);
          k = m;
          if ((n & 0x20) == 32) {
            k = m | 0x20;
          }
          j.k.b(localk, this.g);
          m = k;
          if ((n & 0x40) == 64) {
            m = k | 0x40;
          }
          j.k.c(localk, this.h);
          k = m;
          if ((n & 0x80) == 128) {
            k = m | 0x80;
          }
          j.k.a(localk, this.i);
          m = k;
          if ((n & 0x100) == 256) {
            m = k | 0x100;
          }
          j.k.a(localk, this.j);
          j.k.b(localk, m);
          return localk;
          m = 0;
        }
      }
    }
  }
  
  public static abstract interface l
    extends com.appbrain.b.n
  {}
  
  public static final class m
    extends g
    implements j.n
  {
    public static com.appbrain.b.o a = new s();
    private static final m b;
    private int c;
    private h.a d;
    private com.appbrain.b.k e;
    private com.appbrain.b.k f;
    private Object g;
    private byte h = -1;
    private int i = -1;
    
    static
    {
      m localm = new m((byte)0);
      b = localm;
      localm.l();
    }
    
    private m()
    {
      super();
    }
    
    private m(byte paramByte) {}
    
    /* Error */
    private m(d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 51	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 48	com/appbrain/e/j$m:h	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 50	com/appbrain/e/j$m:i	I
      //   14: aload_0
      //   15: invokespecial 44	com/appbrain/e/j$m:l	()V
      //   18: iconst_0
      //   19: istore 8
      //   21: iconst_0
      //   22: istore_3
      //   23: iload 8
      //   25: ifne +472 -> 497
      //   28: iload_3
      //   29: istore 6
      //   31: iload_3
      //   32: istore 4
      //   34: iload_3
      //   35: istore 7
      //   37: aload_1
      //   38: invokevirtual 63	com/appbrain/b/d:a	()I
      //   41: istore 5
      //   43: iload 5
      //   45: lookupswitch	default:+503->548, 0:+506->551, 10:+75->120, 18:+260->305, 26:+347->392, 34:+413->458
      //   96: iload_3
      //   97: istore 6
      //   99: iload_3
      //   100: istore 4
      //   102: iload_3
      //   103: istore 7
      //   105: aload_1
      //   106: iload 5
      //   108: invokevirtual 66	com/appbrain/b/d:b	(I)Z
      //   111: ifne -88 -> 23
      //   114: iconst_1
      //   115: istore 8
      //   117: goto -94 -> 23
      //   120: iload_3
      //   121: istore 6
      //   123: iload_3
      //   124: istore 4
      //   126: iload_3
      //   127: istore 7
      //   129: aload_0
      //   130: getfield 68	com/appbrain/e/j$m:c	I
      //   133: iconst_1
      //   134: iand
      //   135: iconst_1
      //   136: if_icmpne +406 -> 542
      //   139: iload_3
      //   140: istore 6
      //   142: iload_3
      //   143: istore 4
      //   145: iload_3
      //   146: istore 7
      //   148: aload_0
      //   149: getfield 70	com/appbrain/e/j$m:d	Lcom/appbrain/e/h$a;
      //   152: invokevirtual 76	com/appbrain/e/h$a:at	()Lcom/appbrain/e/h$a$a;
      //   155: astore 9
      //   157: iload_3
      //   158: istore 6
      //   160: iload_3
      //   161: istore 4
      //   163: iload_3
      //   164: istore 7
      //   166: aload_0
      //   167: aload_1
      //   168: getstatic 77	com/appbrain/e/h$a:a	Lcom/appbrain/b/o;
      //   171: aload_2
      //   172: invokevirtual 80	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   175: checkcast 72	com/appbrain/e/h$a
      //   178: putfield 70	com/appbrain/e/j$m:d	Lcom/appbrain/e/h$a;
      //   181: aload 9
      //   183: ifnull +40 -> 223
      //   186: iload_3
      //   187: istore 6
      //   189: iload_3
      //   190: istore 4
      //   192: iload_3
      //   193: istore 7
      //   195: aload 9
      //   197: aload_0
      //   198: getfield 70	com/appbrain/e/j$m:d	Lcom/appbrain/e/h$a;
      //   201: invokevirtual 85	com/appbrain/e/h$a$a:a	(Lcom/appbrain/e/h$a;)Lcom/appbrain/e/h$a$a;
      //   204: pop
      //   205: iload_3
      //   206: istore 6
      //   208: iload_3
      //   209: istore 4
      //   211: iload_3
      //   212: istore 7
      //   214: aload_0
      //   215: aload 9
      //   217: invokevirtual 88	com/appbrain/e/h$a$a:f	()Lcom/appbrain/e/h$a;
      //   220: putfield 70	com/appbrain/e/j$m:d	Lcom/appbrain/e/h$a;
      //   223: iload_3
      //   224: istore 6
      //   226: iload_3
      //   227: istore 4
      //   229: iload_3
      //   230: istore 7
      //   232: aload_0
      //   233: aload_0
      //   234: getfield 68	com/appbrain/e/j$m:c	I
      //   237: iconst_1
      //   238: ior
      //   239: putfield 68	com/appbrain/e/j$m:c	I
      //   242: goto -219 -> 23
      //   245: astore_1
      //   246: iload 6
      //   248: istore 4
      //   250: aload_1
      //   251: aload_0
      //   252: invokevirtual 91	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   255: athrow
      //   256: astore_1
      //   257: iload 4
      //   259: iconst_2
      //   260: iand
      //   261: iconst_2
      //   262: if_icmpne +18 -> 280
      //   265: aload_0
      //   266: new 93	com/appbrain/b/r
      //   269: dup
      //   270: aload_0
      //   271: getfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   274: invokespecial 98	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   277: putfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   280: iload 4
      //   282: iconst_4
      //   283: iand
      //   284: iconst_4
      //   285: if_icmpne +18 -> 303
      //   288: aload_0
      //   289: new 93	com/appbrain/b/r
      //   292: dup
      //   293: aload_0
      //   294: getfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   297: invokespecial 98	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   300: putfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   303: aload_1
      //   304: athrow
      //   305: iload_3
      //   306: istore 5
      //   308: iload_3
      //   309: iconst_2
      //   310: iand
      //   311: iconst_2
      //   312: if_icmpeq +28 -> 340
      //   315: iload_3
      //   316: istore 6
      //   318: iload_3
      //   319: istore 4
      //   321: iload_3
      //   322: istore 7
      //   324: aload_0
      //   325: new 102	com/appbrain/b/j
      //   328: dup
      //   329: invokespecial 103	com/appbrain/b/j:<init>	()V
      //   332: putfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   335: iload_3
      //   336: iconst_2
      //   337: ior
      //   338: istore 5
      //   340: iload 5
      //   342: istore 6
      //   344: iload 5
      //   346: istore 4
      //   348: iload 5
      //   350: istore 7
      //   352: aload_0
      //   353: getfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   356: aload_1
      //   357: invokevirtual 106	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   360: invokeinterface 111 2 0
      //   365: iload 5
      //   367: istore_3
      //   368: goto -345 -> 23
      //   371: astore_1
      //   372: iload 7
      //   374: istore 4
      //   376: new 56	com/appbrain/b/i
      //   379: dup
      //   380: aload_1
      //   381: invokevirtual 115	java/io/IOException:getMessage	()Ljava/lang/String;
      //   384: invokespecial 118	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   387: aload_0
      //   388: invokevirtual 91	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   391: athrow
      //   392: iload_3
      //   393: istore 5
      //   395: iload_3
      //   396: iconst_4
      //   397: iand
      //   398: iconst_4
      //   399: if_icmpeq +28 -> 427
      //   402: iload_3
      //   403: istore 6
      //   405: iload_3
      //   406: istore 4
      //   408: iload_3
      //   409: istore 7
      //   411: aload_0
      //   412: new 102	com/appbrain/b/j
      //   415: dup
      //   416: invokespecial 103	com/appbrain/b/j:<init>	()V
      //   419: putfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   422: iload_3
      //   423: iconst_4
      //   424: ior
      //   425: istore 5
      //   427: iload 5
      //   429: istore 6
      //   431: iload 5
      //   433: istore 4
      //   435: iload 5
      //   437: istore 7
      //   439: aload_0
      //   440: getfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   443: aload_1
      //   444: invokevirtual 106	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   447: invokeinterface 111 2 0
      //   452: iload 5
      //   454: istore_3
      //   455: goto -432 -> 23
      //   458: iload_3
      //   459: istore 6
      //   461: iload_3
      //   462: istore 4
      //   464: iload_3
      //   465: istore 7
      //   467: aload_0
      //   468: aload_0
      //   469: getfield 68	com/appbrain/e/j$m:c	I
      //   472: iconst_2
      //   473: ior
      //   474: putfield 68	com/appbrain/e/j$m:c	I
      //   477: iload_3
      //   478: istore 6
      //   480: iload_3
      //   481: istore 4
      //   483: iload_3
      //   484: istore 7
      //   486: aload_0
      //   487: aload_1
      //   488: invokevirtual 106	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   491: putfield 120	com/appbrain/e/j$m:g	Ljava/lang/Object;
      //   494: goto -471 -> 23
      //   497: iload_3
      //   498: iconst_2
      //   499: iand
      //   500: iconst_2
      //   501: if_icmpne +18 -> 519
      //   504: aload_0
      //   505: new 93	com/appbrain/b/r
      //   508: dup
      //   509: aload_0
      //   510: getfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   513: invokespecial 98	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   516: putfield 95	com/appbrain/e/j$m:e	Lcom/appbrain/b/k;
      //   519: iload_3
      //   520: iconst_4
      //   521: iand
      //   522: iconst_4
      //   523: if_icmpne +18 -> 541
      //   526: aload_0
      //   527: new 93	com/appbrain/b/r
      //   530: dup
      //   531: aload_0
      //   532: getfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   535: invokespecial 98	com/appbrain/b/r:<init>	(Lcom/appbrain/b/k;)V
      //   538: putfield 100	com/appbrain/e/j$m:f	Lcom/appbrain/b/k;
      //   541: return
      //   542: aconst_null
      //   543: astore 9
      //   545: goto -388 -> 157
      //   548: goto -452 -> 96
      //   551: iconst_1
      //   552: istore 8
      //   554: goto -531 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	557	0	this	m
      //   0	557	1	paramd	d
      //   0	557	2	paramf	com.appbrain.b.f
      //   22	500	3	j	int
      //   32	450	4	k	int
      //   41	412	5	m	int
      //   29	450	6	n	int
      //   35	450	7	i1	int
      //   19	534	8	i2	int
      //   155	389	9	locala	h.a.a
      // Exception table:
      //   from	to	target	type
      //   37	43	245	com/appbrain/b/i
      //   105	114	245	com/appbrain/b/i
      //   129	139	245	com/appbrain/b/i
      //   148	157	245	com/appbrain/b/i
      //   166	181	245	com/appbrain/b/i
      //   195	205	245	com/appbrain/b/i
      //   214	223	245	com/appbrain/b/i
      //   232	242	245	com/appbrain/b/i
      //   324	335	245	com/appbrain/b/i
      //   352	365	245	com/appbrain/b/i
      //   411	422	245	com/appbrain/b/i
      //   439	452	245	com/appbrain/b/i
      //   467	477	245	com/appbrain/b/i
      //   486	494	245	com/appbrain/b/i
      //   37	43	256	finally
      //   105	114	256	finally
      //   129	139	256	finally
      //   148	157	256	finally
      //   166	181	256	finally
      //   195	205	256	finally
      //   214	223	256	finally
      //   232	242	256	finally
      //   250	256	256	finally
      //   324	335	256	finally
      //   352	365	256	finally
      //   376	392	256	finally
      //   411	422	256	finally
      //   439	452	256	finally
      //   467	477	256	finally
      //   486	494	256	finally
      //   37	43	371	java/io/IOException
      //   105	114	371	java/io/IOException
      //   129	139	371	java/io/IOException
      //   148	157	371	java/io/IOException
      //   166	181	371	java/io/IOException
      //   195	205	371	java/io/IOException
      //   214	223	371	java/io/IOException
      //   232	242	371	java/io/IOException
      //   324	335	371	java/io/IOException
      //   352	365	371	java/io/IOException
      //   411	422	371	java/io/IOException
      //   439	452	371	java/io/IOException
      //   467	477	371	java/io/IOException
      //   486	494	371	java/io/IOException
    }
    
    public static m f()
    {
      return b;
    }
    
    public static a j()
    {
      return a.f();
    }
    
    private c k()
    {
      Object localObject = this.g;
      if ((localObject instanceof String))
      {
        localObject = c.a((String)localObject);
        this.g = localObject;
        return (c)localObject;
      }
      return (c)localObject;
    }
    
    private void l()
    {
      this.d = h.a.f();
      this.e = com.appbrain.b.j.a;
      this.f = com.appbrain.b.j.a;
      this.g = "";
    }
    
    public final void a(e parame)
    {
      int m = 0;
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      int j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= this.e.size()) {
          break;
        }
        parame.a(2, this.e.a(j));
        j += 1;
      }
      while (k < this.f.size())
      {
        parame.a(3, this.f.a(k));
        k += 1;
      }
      if ((this.c & 0x2) == 2) {
        parame.a(4, k());
      }
    }
    
    public final int c()
    {
      int n = 0;
      int j = this.i;
      if (j != -1) {
        return j;
      }
      if ((this.c & 0x1) == 1) {}
      for (j = e.b(1, this.d) + 0;; j = 0)
      {
        int m = 0;
        int k = 0;
        while (m < this.e.size())
        {
          k += e.a(this.e.a(m));
          m += 1;
        }
        int i2 = this.e.size();
        int i1 = 0;
        m = n;
        n = i1;
        while (m < this.f.size())
        {
          n += e.a(this.f.a(m));
          m += 1;
        }
        k = n + (i2 * 1 + (j + k)) + this.f.size() * 1;
        j = k;
        if ((this.c & 0x2) == 2) {
          j = k + e.b(4, k());
        }
        this.i = j;
        return j;
      }
    }
    
    public final boolean e()
    {
      int j = this.h;
      if (j != -1) {
        return j == 1;
      }
      this.h = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final h.a h()
    {
      return this.d;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public static final class a
      extends g.a
      implements j.n
    {
      private int a;
      private h.a b = h.a.f();
      private com.appbrain.b.k c = com.appbrain.b.j.a;
      private com.appbrain.b.k d = com.appbrain.b.j.a;
      private Object e = "";
      
      private a g()
      {
        return new a().a(h());
      }
      
      private j.m h()
      {
        int i = 1;
        j.m localm = new j.m('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          j.m.a(localm, this.b);
          if ((this.a & 0x2) == 2)
          {
            this.c = new com.appbrain.b.r(this.c);
            this.a &= 0xFFFFFFFD;
          }
          j.m.a(localm, this.c);
          if ((this.a & 0x4) == 4)
          {
            this.d = new com.appbrain.b.r(this.d);
            this.a &= 0xFFFFFFFB;
          }
          j.m.b(localm, this.d);
          int j = i;
          if ((k & 0x8) == 8) {
            j = i | 0x2;
          }
          j.m.a(localm, this.e);
          j.m.a(localm, j);
          return localm;
          i = 0;
        }
      }
      
      private void i()
      {
        if ((this.a & 0x2) != 2)
        {
          this.c = new com.appbrain.b.j(this.c);
          this.a |= 0x2;
        }
      }
      
      private void j()
      {
        if ((this.a & 0x4) != 4)
        {
          this.d = new com.appbrain.b.j(this.d);
          this.a |= 0x4;
        }
      }
      
      public final a a(h.a parama)
      {
        if (parama == null) {
          throw new NullPointerException();
        }
        this.b = parama;
        this.a |= 0x1;
        return this;
      }
      
      public final a a(j.m paramm)
      {
        if (paramm == j.m.f()) {}
        label112:
        label191:
        label212:
        label231:
        for (;;)
        {
          return this;
          h.a locala;
          if (paramm.g())
          {
            locala = paramm.h();
            if (((this.a & 0x1) == 1) && (this.b != h.a.f()))
            {
              this.b = h.a.a(this.b).a(locala).f();
              this.a |= 0x1;
            }
          }
          else
          {
            if (!j.m.a(paramm).isEmpty())
            {
              if (!this.c.isEmpty()) {
                break label191;
              }
              this.c = j.m.a(paramm);
              this.a &= 0xFFFFFFFD;
            }
            if (!j.m.b(paramm).isEmpty())
            {
              if (!this.d.isEmpty()) {
                break label212;
              }
              this.d = j.m.b(paramm);
              this.a &= 0xFFFFFFFB;
            }
          }
          for (;;)
          {
            if (!paramm.i()) {
              break label231;
            }
            this.a |= 0x8;
            this.e = j.m.c(paramm);
            return this;
            this.b = locala;
            break;
            i();
            this.c.addAll(j.m.a(paramm));
            break label112;
            j();
            this.d.addAll(j.m.b(paramm));
          }
        }
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        i();
        this.c.add(paramString);
        return this;
      }
      
      public final a b(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        j();
        this.d.add(paramString);
        return this;
      }
      
      public final a c(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.e = paramString;
        return this;
      }
      
      public final j.m d()
      {
        j.m localm = h();
        if (!localm.e()) {
          throw new com.appbrain.b.q();
        }
        return localm;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface n
    extends com.appbrain.b.n
  {}
  
  public static final class o
    extends g
    implements j.p
  {
    public static com.appbrain.b.o a = new t();
    private static final o b;
    private int c;
    private j.k d;
    private boolean e;
    private int f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      o localo = new o((byte)0);
      b = localo;
      localo.o();
    }
    
    private o()
    {
      super();
    }
    
    private o(byte paramByte) {}
    
    /* Error */
    private o(d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 48	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 45	com/appbrain/e/j$o:g	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 47	com/appbrain/e/j$o:h	I
      //   14: aload_0
      //   15: invokespecial 41	com/appbrain/e/j$o:o	()V
      //   18: iconst_0
      //   19: istore_3
      //   20: iload_3
      //   21: ifne +209 -> 230
      //   24: aload_1
      //   25: invokevirtual 60	com/appbrain/b/d:a	()I
      //   28: istore 4
      //   30: iload 4
      //   32: lookupswitch	default:+205->237, 0:+208->240, 10:+58->90, 16:+139->171, 24:+177->209
      //   76: aload_1
      //   77: iload 4
      //   79: invokevirtual 63	com/appbrain/b/d:b	(I)Z
      //   82: ifne -62 -> 20
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -67 -> 20
      //   90: aload_0
      //   91: getfield 65	com/appbrain/e/j$o:c	I
      //   94: iconst_1
      //   95: iand
      //   96: iconst_1
      //   97: if_icmpne +134 -> 231
      //   100: aload_0
      //   101: getfield 67	com/appbrain/e/j$o:d	Lcom/appbrain/e/j$k;
      //   104: invokevirtual 73	com/appbrain/e/j$k:y	()Lcom/appbrain/e/j$k$a;
      //   107: astore 5
      //   109: aload_0
      //   110: aload_1
      //   111: getstatic 74	com/appbrain/e/j$k:a	Lcom/appbrain/b/o;
      //   114: aload_2
      //   115: invokevirtual 77	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   118: checkcast 69	com/appbrain/e/j$k
      //   121: putfield 67	com/appbrain/e/j$o:d	Lcom/appbrain/e/j$k;
      //   124: aload 5
      //   126: ifnull +22 -> 148
      //   129: aload 5
      //   131: aload_0
      //   132: getfield 67	com/appbrain/e/j$o:d	Lcom/appbrain/e/j$k;
      //   135: invokevirtual 82	com/appbrain/e/j$k$a:a	(Lcom/appbrain/e/j$k;)Lcom/appbrain/e/j$k$a;
      //   138: pop
      //   139: aload_0
      //   140: aload 5
      //   142: invokevirtual 85	com/appbrain/e/j$k$a:f	()Lcom/appbrain/e/j$k;
      //   145: putfield 67	com/appbrain/e/j$o:d	Lcom/appbrain/e/j$k;
      //   148: aload_0
      //   149: aload_0
      //   150: getfield 65	com/appbrain/e/j$o:c	I
      //   153: iconst_1
      //   154: ior
      //   155: putfield 65	com/appbrain/e/j$o:c	I
      //   158: goto -138 -> 20
      //   161: astore_1
      //   162: aload_1
      //   163: aload_0
      //   164: invokevirtual 88	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   167: athrow
      //   168: astore_1
      //   169: aload_1
      //   170: athrow
      //   171: aload_0
      //   172: aload_0
      //   173: getfield 65	com/appbrain/e/j$o:c	I
      //   176: iconst_2
      //   177: ior
      //   178: putfield 65	com/appbrain/e/j$o:c	I
      //   181: aload_0
      //   182: aload_1
      //   183: invokevirtual 91	com/appbrain/b/d:d	()Z
      //   186: putfield 93	com/appbrain/e/j$o:e	Z
      //   189: goto -169 -> 20
      //   192: astore_1
      //   193: new 53	com/appbrain/b/i
      //   196: dup
      //   197: aload_1
      //   198: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
      //   201: invokespecial 100	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   204: aload_0
      //   205: invokevirtual 88	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   208: athrow
      //   209: aload_0
      //   210: aload_0
      //   211: getfield 65	com/appbrain/e/j$o:c	I
      //   214: iconst_4
      //   215: ior
      //   216: putfield 65	com/appbrain/e/j$o:c	I
      //   219: aload_0
      //   220: aload_1
      //   221: invokevirtual 102	com/appbrain/b/d:c	()I
      //   224: putfield 104	com/appbrain/e/j$o:f	I
      //   227: goto -207 -> 20
      //   230: return
      //   231: aconst_null
      //   232: astore 5
      //   234: goto -125 -> 109
      //   237: goto -161 -> 76
      //   240: iconst_1
      //   241: istore_3
      //   242: goto -222 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	245	0	this	o
      //   0	245	1	paramd	d
      //   0	245	2	paramf	com.appbrain.b.f
      //   19	223	3	i	int
      //   28	50	4	j	int
      //   107	126	5	locala	j.k.a
      // Exception table:
      //   from	to	target	type
      //   24	30	161	com/appbrain/b/i
      //   76	85	161	com/appbrain/b/i
      //   90	109	161	com/appbrain/b/i
      //   109	124	161	com/appbrain/b/i
      //   129	148	161	com/appbrain/b/i
      //   148	158	161	com/appbrain/b/i
      //   171	189	161	com/appbrain/b/i
      //   209	227	161	com/appbrain/b/i
      //   24	30	168	finally
      //   76	85	168	finally
      //   90	109	168	finally
      //   109	124	168	finally
      //   129	148	168	finally
      //   148	158	168	finally
      //   162	168	168	finally
      //   171	189	168	finally
      //   193	209	168	finally
      //   209	227	168	finally
      //   24	30	192	java/io/IOException
      //   76	85	192	java/io/IOException
      //   90	109	192	java/io/IOException
      //   109	124	192	java/io/IOException
      //   129	148	192	java/io/IOException
      //   148	158	192	java/io/IOException
      //   171	189	192	java/io/IOException
      //   209	227	192	java/io/IOException
    }
    
    public static o a(byte[] paramArrayOfByte)
    {
      return (o)a.a(paramArrayOfByte);
    }
    
    public static o f()
    {
      return b;
    }
    
    public static a m()
    {
      return a.f();
    }
    
    private void o()
    {
      this.d = j.k.f();
      this.e = false;
      this.f = 0;
    }
    
    public final void a(e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, this.e);
      }
      if ((this.c & 0x4) == 4) {
        parame.a(3, this.f);
      }
    }
    
    public final int c()
    {
      int i = this.h;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.c & 0x1) == 1) {
        j = e.b(1, this.d) + 0;
      }
      i = j;
      if ((this.c & 0x2) == 2)
      {
        boolean bool = this.e;
        i = j + e.a(2);
      }
      j = i;
      if ((this.c & 0x4) == 4) {
        j = i + e.c(3, this.f);
      }
      this.h = j;
      return j;
    }
    
    public final boolean e()
    {
      int i = this.g;
      if (i != -1) {
        return i == 1;
      }
      this.g = 1;
      return true;
    }
    
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    public final j.k h()
    {
      return this.d;
    }
    
    public final boolean i()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final boolean j()
    {
      return this.e;
    }
    
    public final boolean k()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final int l()
    {
      return this.f;
    }
    
    public final a n()
    {
      return a.f().a(this);
    }
    
    public static final class a
      extends g.a
      implements j.p
    {
      private int a;
      private j.k b = j.k.f();
      private boolean c;
      private int d;
      
      private a g()
      {
        return new a().a(i());
      }
      
      private j.o i()
      {
        int j = 1;
        j.o localo = new j.o('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          j.o.a(localo, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          j.o.a(localo, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          j.o.a(localo, this.d);
          j.o.b(localo, j);
          return localo;
          j = 0;
        }
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x4;
        this.d = paramInt;
        return this;
      }
      
      public final a a(j.k.a parama)
      {
        this.b = parama.d();
        this.a |= 0x1;
        return this;
      }
      
      public final a a(j.o paramo)
      {
        if (paramo == j.o.f()) {
          return this;
        }
        j.k localk;
        if (paramo.g())
        {
          localk = paramo.h();
          if (((this.a & 0x1) != 1) || (this.b == j.k.f())) {
            break label103;
          }
        }
        label103:
        for (this.b = j.k.a(this.b).a(localk).f();; this.b = localk)
        {
          this.a |= 0x1;
          if (paramo.i()) {
            a(paramo.j());
          }
          if (!paramo.k()) {
            break;
          }
          a(paramo.l());
          return this;
        }
      }
      
      public final a a(boolean paramBoolean)
      {
        this.a |= 0x2;
        this.c = paramBoolean;
        return this;
      }
      
      public final j.o d()
      {
        j.o localo = i();
        if (!localo.e()) {
          throw new com.appbrain.b.q();
        }
        return localo;
      }
      
      public final boolean e()
      {
        return true;
      }
      
      public final j.k h()
      {
        return this.b;
      }
      
      public final int l()
      {
        return this.d;
      }
    }
  }
  
  public static abstract interface p
    extends com.appbrain.b.n
  {
    public abstract j.k h();
    
    public abstract int l();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */