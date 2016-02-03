package com.appbrain.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.appbrain.e.aq;
import com.appbrain.e.ar;
import com.appbrain.e.ax;
import com.appbrain.e.ay;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class aa
{
  private static Boolean a = null;
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: ldc 27
    //   7: istore_1
    //   8: invokestatic 32	com/appbrain/a/aw:a	()Lcom/appbrain/a/aw;
    //   11: astore 18
    //   13: aload 18
    //   15: invokevirtual 36	com/appbrain/a/aw:d	()Landroid/content/SharedPreferences;
    //   18: astore 19
    //   20: aload 19
    //   22: invokeinterface 42 1 0
    //   27: astore 11
    //   29: aload 18
    //   31: ldc 44
    //   33: ldc 46
    //   35: invokevirtual 49	com/appbrain/a/aw:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: ldc 46
    //   40: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: istore 7
    //   45: aconst_null
    //   46: astore 10
    //   48: aload_0
    //   49: invokestatic 60	cmn/x:a	(Landroid/content/Context;)Ljava/util/List;
    //   52: astore 12
    //   54: new 62	java/util/HashSet
    //   57: dup
    //   58: aload 12
    //   60: invokeinterface 68 1 0
    //   65: invokespecial 72	java/util/HashSet:<init>	(I)V
    //   68: astore 20
    //   70: aload 12
    //   72: invokeinterface 76 1 0
    //   77: astore 12
    //   79: aload 12
    //   81: invokeinterface 82 1 0
    //   86: ifeq +27 -> 113
    //   89: aload 20
    //   91: aload 12
    //   93: invokeinterface 86 1 0
    //   98: checkcast 88	android/content/pm/PackageInfo
    //   101: getfield 92	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   104: invokeinterface 97 2 0
    //   109: pop
    //   110: goto -31 -> 79
    //   113: aload 11
    //   115: invokeinterface 103 1 0
    //   120: invokeinterface 104 1 0
    //   125: astore 21
    //   127: iload_1
    //   128: istore_2
    //   129: aload 21
    //   131: invokeinterface 82 1 0
    //   136: ifeq +1178 -> 1314
    //   139: aload 21
    //   141: invokeinterface 86 1 0
    //   146: checkcast 51	java/lang/String
    //   149: astore 11
    //   151: aload 11
    //   153: getstatic 110	com/appbrain/e/af:c	Lcom/appbrain/e/af;
    //   156: invokevirtual 114	com/appbrain/e/af:toString	()Ljava/lang/String;
    //   159: invokevirtual 118	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +1237 -> 1399
    //   165: aload 19
    //   167: aload 11
    //   169: aconst_null
    //   170: invokeinterface 121 3 0
    //   175: astore 11
    //   177: iload_2
    //   178: istore_1
    //   179: aload 11
    //   181: ifnull -54 -> 127
    //   184: iload 7
    //   186: ifeq +1210 -> 1396
    //   189: aload 10
    //   191: ifnonnull +1205 -> 1396
    //   194: new 62	java/util/HashSet
    //   197: dup
    //   198: invokespecial 123	java/util/HashSet:<init>	()V
    //   201: astore 10
    //   203: aload 10
    //   205: aload_0
    //   206: invokestatic 126	com/appbrain/a/aa:a	(Ljava/util/Set;Landroid/content/Context;)V
    //   209: aload 10
    //   211: astore 14
    //   213: aload 10
    //   215: astore 15
    //   217: aload 11
    //   219: invokestatic 131	cmn/aa:a	(Ljava/lang/String;)[B
    //   222: invokestatic 136	com/appbrain/e/aw:a	([B)Lcom/appbrain/e/aw;
    //   225: astore 23
    //   227: aload 10
    //   229: astore 14
    //   231: aload 10
    //   233: astore 15
    //   235: aload 23
    //   237: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   240: invokevirtual 145	com/appbrain/e/aq:j	()Ljava/lang/String;
    //   243: astore 22
    //   245: aload 10
    //   247: astore 14
    //   249: aload 10
    //   251: astore 15
    //   253: aload 23
    //   255: invokevirtual 148	com/appbrain/e/aw:l	()I
    //   258: istore 4
    //   260: aload 10
    //   262: astore 14
    //   264: aload 10
    //   266: astore 15
    //   268: new 150	java/lang/StringBuilder
    //   271: dup
    //   272: ldc -104
    //   274: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload 22
    //   279: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc -95
    //   284: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 4
    //   289: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc -90
    //   294: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 23
    //   299: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   302: invokevirtual 169	com/appbrain/e/aq:w	()I
    //   305: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: pop
    //   312: aload 10
    //   314: astore 14
    //   316: aload 10
    //   318: astore 15
    //   320: aload 20
    //   322: aload 22
    //   324: invokeinterface 173 2 0
    //   329: istore 8
    //   331: aconst_null
    //   332: astore 11
    //   334: aload 11
    //   336: astore 12
    //   338: iload 7
    //   340: ifeq +83 -> 423
    //   343: aload 10
    //   345: astore 14
    //   347: aload 10
    //   349: astore 15
    //   351: aload 23
    //   353: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   356: invokevirtual 169	com/appbrain/e/aq:w	()I
    //   359: istore_1
    //   360: aload 10
    //   362: astore 14
    //   364: aload 10
    //   366: astore 15
    //   368: aload 10
    //   370: aload 22
    //   372: invokeinterface 173 2 0
    //   377: ifeq +592 -> 969
    //   380: aload 10
    //   382: astore 14
    //   384: aload 10
    //   386: astore 15
    //   388: aload 23
    //   390: invokevirtual 177	com/appbrain/e/aw:n	()Lcom/appbrain/e/ax;
    //   393: astore 12
    //   395: aload 10
    //   397: astore 14
    //   399: aload 10
    //   401: astore 15
    //   403: aload 12
    //   405: aload 12
    //   407: invokevirtual 180	com/appbrain/e/ax:h	()Lcom/appbrain/e/aq;
    //   410: invokevirtual 184	com/appbrain/e/aq:y	()Lcom/appbrain/e/ar;
    //   413: iload_1
    //   414: iconst_1
    //   415: iadd
    //   416: invokevirtual 189	com/appbrain/e/ar:a	(I)Lcom/appbrain/e/ar;
    //   419: invokevirtual 192	com/appbrain/e/ax:a	(Lcom/appbrain/e/ar;)Lcom/appbrain/e/ax;
    //   422: pop
    //   423: iload 4
    //   425: ifne +627 -> 1052
    //   428: iload 8
    //   430: ifeq +622 -> 1052
    //   433: aload 12
    //   435: astore 16
    //   437: aload 12
    //   439: ifnonnull +18 -> 457
    //   442: aload 10
    //   444: astore 14
    //   446: aload 10
    //   448: astore 15
    //   450: aload 23
    //   452: invokevirtual 177	com/appbrain/e/aw:n	()Lcom/appbrain/e/ax;
    //   455: astore 16
    //   457: aload 10
    //   459: astore 14
    //   461: aload 10
    //   463: astore 15
    //   465: aload 16
    //   467: iload 4
    //   469: iconst_1
    //   470: iadd
    //   471: invokevirtual 195	com/appbrain/e/ax:a	(I)Lcom/appbrain/e/ax;
    //   474: pop
    //   475: aload 10
    //   477: astore 14
    //   479: aload 10
    //   481: astore 15
    //   483: aload 19
    //   485: invokeinterface 199 1 0
    //   490: astore 11
    //   492: aload 10
    //   494: astore 14
    //   496: aload 10
    //   498: astore 15
    //   500: aload 11
    //   502: ldc -55
    //   504: aload 19
    //   506: ldc -55
    //   508: iconst_0
    //   509: invokeinterface 205 3 0
    //   514: iconst_1
    //   515: iadd
    //   516: invokeinterface 211 3 0
    //   521: pop
    //   522: aload 10
    //   524: astore 14
    //   526: aload 10
    //   528: astore 15
    //   530: invokestatic 216	cmn/a:a	()Lcmn/a;
    //   533: aload 11
    //   535: invokevirtual 220	cmn/a:b	(Landroid/content/SharedPreferences$Editor;)V
    //   538: aload 10
    //   540: astore 14
    //   542: aload 10
    //   544: astore 15
    //   546: aload_0
    //   547: aload 16
    //   549: getstatic 222	com/appbrain/e/af:d	Lcom/appbrain/e/af;
    //   552: invokestatic 225	com/appbrain/a/aa:a	(Landroid/content/Context;Lcom/appbrain/e/ax;Lcom/appbrain/e/af;)V
    //   555: aload 10
    //   557: astore 14
    //   559: aload 10
    //   561: astore 15
    //   563: aload 23
    //   565: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   568: invokevirtual 228	com/appbrain/e/aq:s	()Ljava/lang/String;
    //   571: ldc -26
    //   573: invokevirtual 233	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   576: istore 9
    //   578: aload 10
    //   580: astore 11
    //   582: aload 16
    //   584: astore 13
    //   586: iload 9
    //   588: ifeq +232 -> 820
    //   591: aload 10
    //   593: astore 14
    //   595: aload 10
    //   597: astore 15
    //   599: aload 10
    //   601: astore 17
    //   603: aload 18
    //   605: ldc -21
    //   607: sipush 900
    //   610: invokevirtual 237	com/appbrain/a/aw:a	(Ljava/lang/String;I)I
    //   613: istore_1
    //   614: aload 10
    //   616: astore 11
    //   618: aload 16
    //   620: astore 13
    //   622: aload 10
    //   624: astore 14
    //   626: aload 10
    //   628: astore 15
    //   630: aload 10
    //   632: astore 17
    //   634: lload 5
    //   636: aload 23
    //   638: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   641: invokevirtual 240	com/appbrain/e/aq:p	()J
    //   644: lsub
    //   645: iload_1
    //   646: i2l
    //   647: ldc2_w 241
    //   650: lmul
    //   651: lcmp
    //   652: ifge +168 -> 820
    //   655: aload 10
    //   657: astore 12
    //   659: aload 10
    //   661: ifnonnull +34 -> 695
    //   664: aload 10
    //   666: astore 14
    //   668: aload 10
    //   670: astore 15
    //   672: aload 10
    //   674: astore 17
    //   676: new 62	java/util/HashSet
    //   679: dup
    //   680: invokespecial 123	java/util/HashSet:<init>	()V
    //   683: astore 10
    //   685: aload 10
    //   687: aload_0
    //   688: invokestatic 126	com/appbrain/a/aa:a	(Ljava/util/Set;Landroid/content/Context;)V
    //   691: aload 10
    //   693: astore 12
    //   695: aload 12
    //   697: astore 14
    //   699: aload 12
    //   701: astore 15
    //   703: aload 12
    //   705: astore 17
    //   707: aload 12
    //   709: aload 22
    //   711: invokeinterface 173 2 0
    //   716: istore 9
    //   718: aload 12
    //   720: astore 11
    //   722: aload 16
    //   724: astore 13
    //   726: iload 9
    //   728: ifne +92 -> 820
    //   731: aconst_null
    //   732: astore 10
    //   734: aload 12
    //   736: astore 14
    //   738: aload 12
    //   740: astore 15
    //   742: aload 12
    //   744: astore 17
    //   746: aload_0
    //   747: invokevirtual 248	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   750: aload 22
    //   752: invokevirtual 254	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   755: astore 11
    //   757: aload 11
    //   759: astore 10
    //   761: aload 12
    //   763: astore 11
    //   765: aload 16
    //   767: astore 13
    //   769: aload 10
    //   771: ifnull +49 -> 820
    //   774: aload 12
    //   776: astore 14
    //   778: aload 12
    //   780: astore 15
    //   782: aload 12
    //   784: astore 17
    //   786: aload 10
    //   788: ldc -1
    //   790: invokevirtual 261	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   793: pop
    //   794: aload 12
    //   796: astore 14
    //   798: aload 12
    //   800: astore 15
    //   802: aload 12
    //   804: astore 17
    //   806: aload_0
    //   807: aload 10
    //   809: invokevirtual 265	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   812: aload 16
    //   814: astore 13
    //   816: aload 12
    //   818: astore 11
    //   820: aload 11
    //   822: astore 14
    //   824: aload 11
    //   826: astore 15
    //   828: lload 5
    //   830: aload 23
    //   832: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   835: invokevirtual 240	com/appbrain/e/aq:p	()J
    //   838: lsub
    //   839: ldc2_w 241
    //   842: ldiv
    //   843: l2i
    //   844: istore_1
    //   845: ldc 27
    //   847: istore_3
    //   848: iload_1
    //   849: sipush 300
    //   852: if_icmpge +309 -> 1161
    //   855: bipush 30
    //   857: istore_1
    //   858: aload 13
    //   860: astore 10
    //   862: aload 10
    //   864: ifnull +84 -> 948
    //   867: aload 11
    //   869: astore 14
    //   871: aload 11
    //   873: astore 15
    //   875: aload 19
    //   877: invokeinterface 199 1 0
    //   882: astore 12
    //   884: aload 11
    //   886: astore 14
    //   888: aload 11
    //   890: astore 15
    //   892: aload 12
    //   894: new 150	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   901: getstatic 110	com/appbrain/e/af:c	Lcom/appbrain/e/af;
    //   904: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   907: aload 22
    //   909: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: aload 10
    //   917: invokevirtual 272	com/appbrain/e/ax:d	()Lcom/appbrain/e/aw;
    //   920: invokevirtual 275	com/appbrain/e/aw:b	()[B
    //   923: invokestatic 278	cmn/aa:a	([B)Ljava/lang/String;
    //   926: invokeinterface 282 3 0
    //   931: pop
    //   932: aload 11
    //   934: astore 14
    //   936: aload 11
    //   938: astore 15
    //   940: invokestatic 216	cmn/a:a	()Lcmn/a;
    //   943: aload 12
    //   945: invokevirtual 284	cmn/a:a	(Landroid/content/SharedPreferences$Editor;)V
    //   948: aload 11
    //   950: astore 14
    //   952: aload 11
    //   954: astore 15
    //   956: iload_2
    //   957: iload_1
    //   958: invokestatic 290	java/lang/Math:min	(II)I
    //   961: istore_1
    //   962: aload 11
    //   964: astore 10
    //   966: goto -839 -> 127
    //   969: aload 11
    //   971: astore 12
    //   973: aload 10
    //   975: astore 14
    //   977: aload 10
    //   979: astore 15
    //   981: aload 23
    //   983: invokevirtual 140	com/appbrain/e/aw:h	()Lcom/appbrain/e/aq;
    //   986: invokevirtual 293	com/appbrain/e/aq:v	()Z
    //   989: ifne -566 -> 423
    //   992: aload 10
    //   994: astore 14
    //   996: aload 10
    //   998: astore 15
    //   1000: aload 23
    //   1002: invokevirtual 177	com/appbrain/e/aw:n	()Lcom/appbrain/e/ax;
    //   1005: astore 12
    //   1007: aload 10
    //   1009: astore 14
    //   1011: aload 10
    //   1013: astore 15
    //   1015: aload 12
    //   1017: aload 12
    //   1019: invokevirtual 180	com/appbrain/e/ax:h	()Lcom/appbrain/e/aq;
    //   1022: invokevirtual 184	com/appbrain/e/aq:y	()Lcom/appbrain/e/ar;
    //   1025: iconst_0
    //   1026: invokevirtual 189	com/appbrain/e/ar:a	(I)Lcom/appbrain/e/ar;
    //   1029: invokevirtual 192	com/appbrain/e/ax:a	(Lcom/appbrain/e/ar;)Lcom/appbrain/e/ax;
    //   1032: pop
    //   1033: goto -610 -> 423
    //   1036: astore 10
    //   1038: aload 10
    //   1040: invokevirtual 296	com/appbrain/b/o:printStackTrace	()V
    //   1043: aload 14
    //   1045: astore 10
    //   1047: iload_2
    //   1048: istore_1
    //   1049: goto -922 -> 127
    //   1052: aload 10
    //   1054: astore 11
    //   1056: aload 12
    //   1058: astore 13
    //   1060: iload 4
    //   1062: iconst_1
    //   1063: if_icmpne -243 -> 820
    //   1066: aload 10
    //   1068: astore 11
    //   1070: aload 12
    //   1072: astore 13
    //   1074: iload 8
    //   1076: ifne -256 -> 820
    //   1079: aload 12
    //   1081: astore 13
    //   1083: aload 12
    //   1085: ifnonnull +18 -> 1103
    //   1088: aload 10
    //   1090: astore 14
    //   1092: aload 10
    //   1094: astore 15
    //   1096: aload 23
    //   1098: invokevirtual 177	com/appbrain/e/aw:n	()Lcom/appbrain/e/ax;
    //   1101: astore 13
    //   1103: aload 10
    //   1105: astore 14
    //   1107: aload 10
    //   1109: astore 15
    //   1111: aload 13
    //   1113: iload 4
    //   1115: iconst_1
    //   1116: iadd
    //   1117: invokevirtual 195	com/appbrain/e/ax:a	(I)Lcom/appbrain/e/ax;
    //   1120: pop
    //   1121: aload 10
    //   1123: astore 14
    //   1125: aload 10
    //   1127: astore 15
    //   1129: aload_0
    //   1130: aload 13
    //   1132: getstatic 299	com/appbrain/e/af:e	Lcom/appbrain/e/af;
    //   1135: invokestatic 225	com/appbrain/a/aa:a	(Landroid/content/Context;Lcom/appbrain/e/ax;Lcom/appbrain/e/af;)V
    //   1138: aload 10
    //   1140: astore 11
    //   1142: goto -322 -> 820
    //   1145: astore 10
    //   1147: aload 10
    //   1149: invokevirtual 300	java/text/ParseException:printStackTrace	()V
    //   1152: aload 15
    //   1154: astore 10
    //   1156: iload_2
    //   1157: istore_1
    //   1158: goto -1031 -> 127
    //   1161: iload_1
    //   1162: sipush 900
    //   1165: if_icmpge +13 -> 1178
    //   1168: bipush 120
    //   1170: istore_1
    //   1171: aload 13
    //   1173: astore 10
    //   1175: goto -313 -> 862
    //   1178: iload_1
    //   1179: sipush 3600
    //   1182: if_icmpge +14 -> 1196
    //   1185: sipush 300
    //   1188: istore_1
    //   1189: aload 13
    //   1191: astore 10
    //   1193: goto -331 -> 862
    //   1196: iload_1
    //   1197: ldc_w 301
    //   1200: if_icmpge +14 -> 1214
    //   1203: sipush 1800
    //   1206: istore_1
    //   1207: aload 13
    //   1209: astore 10
    //   1211: goto -349 -> 862
    //   1214: iload_3
    //   1215: istore_1
    //   1216: aload 13
    //   1218: astore 10
    //   1220: iload 4
    //   1222: iconst_3
    //   1223: if_icmpeq -361 -> 862
    //   1226: aload 13
    //   1228: astore 10
    //   1230: aload 13
    //   1232: ifnonnull +18 -> 1250
    //   1235: aload 11
    //   1237: astore 14
    //   1239: aload 11
    //   1241: astore 15
    //   1243: aload 23
    //   1245: invokevirtual 177	com/appbrain/e/aw:n	()Lcom/appbrain/e/ax;
    //   1248: astore 10
    //   1250: aload 11
    //   1252: astore 14
    //   1254: aload 11
    //   1256: astore 15
    //   1258: aload 10
    //   1260: aload 10
    //   1262: invokevirtual 180	com/appbrain/e/ax:h	()Lcom/appbrain/e/aq;
    //   1265: invokevirtual 184	com/appbrain/e/aq:y	()Lcom/appbrain/e/ar;
    //   1268: iload 8
    //   1270: invokevirtual 304	com/appbrain/e/ar:a	(Z)Lcom/appbrain/e/ar;
    //   1273: invokevirtual 192	com/appbrain/e/ax:a	(Lcom/appbrain/e/ar;)Lcom/appbrain/e/ax;
    //   1276: pop
    //   1277: aload 11
    //   1279: astore 14
    //   1281: aload 11
    //   1283: astore 15
    //   1285: aload 10
    //   1287: iconst_3
    //   1288: invokevirtual 195	com/appbrain/e/ax:a	(I)Lcom/appbrain/e/ax;
    //   1291: pop
    //   1292: aload 11
    //   1294: astore 14
    //   1296: aload 11
    //   1298: astore 15
    //   1300: aload_0
    //   1301: aload 10
    //   1303: getstatic 307	com/appbrain/e/af:f	Lcom/appbrain/e/af;
    //   1306: invokestatic 225	com/appbrain/a/aa:a	(Landroid/content/Context;Lcom/appbrain/e/ax;Lcom/appbrain/e/af;)V
    //   1309: iload_3
    //   1310: istore_1
    //   1311: goto -449 -> 862
    //   1314: iload_2
    //   1315: istore_1
    //   1316: iload_2
    //   1317: ldc 27
    //   1319: if_icmpne +5 -> 1324
    //   1322: iconst_0
    //   1323: istore_1
    //   1324: iload_1
    //   1325: ireturn
    //   1326: astore 11
    //   1328: aload 10
    //   1330: astore 15
    //   1332: aload 11
    //   1334: astore 10
    //   1336: goto -189 -> 1147
    //   1339: astore 11
    //   1341: aload 10
    //   1343: astore 14
    //   1345: aload 11
    //   1347: astore 10
    //   1349: goto -311 -> 1038
    //   1352: astore 10
    //   1354: aload 17
    //   1356: astore 11
    //   1358: aload 16
    //   1360: astore 13
    //   1362: goto -542 -> 820
    //   1365: astore 11
    //   1367: aload 10
    //   1369: astore 11
    //   1371: aload 16
    //   1373: astore 13
    //   1375: goto -555 -> 820
    //   1378: astore 10
    //   1380: aload 12
    //   1382: astore 11
    //   1384: aload 16
    //   1386: astore 13
    //   1388: goto -568 -> 820
    //   1391: astore 11
    //   1393: goto -632 -> 761
    //   1396: goto -1187 -> 209
    //   1399: aload 10
    //   1401: astore 15
    //   1403: goto -251 -> 1152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	paramContext	Context
    //   7	1318	1	i	int
    //   128	1192	2	j	int
    //   847	463	3	k	int
    //   258	966	4	m	int
    //   3	826	5	l	long
    //   43	296	7	bool1	boolean
    //   329	940	8	bool2	boolean
    //   576	151	9	bool3	boolean
    //   46	966	10	localObject1	Object
    //   1036	3	10	localo1	com.appbrain.b.o
    //   1045	94	10	localObject2	Object
    //   1145	3	10	localParseException1	java.text.ParseException
    //   1154	194	10	localObject3	Object
    //   1352	16	10	localThrowable1	Throwable
    //   1378	22	10	localException1	Exception
    //   27	1270	11	localObject4	Object
    //   1326	7	11	localParseException2	java.text.ParseException
    //   1339	7	11	localo2	com.appbrain.b.o
    //   1356	1	11	localObject5	Object
    //   1365	1	11	localThrowable2	Throwable
    //   1369	14	11	localObject6	Object
    //   1391	1	11	localException2	Exception
    //   52	1329	12	localObject7	Object
    //   584	803	13	localObject8	Object
    //   211	1133	14	localObject9	Object
    //   215	1187	15	localObject10	Object
    //   435	950	16	localObject11	Object
    //   601	754	17	localObject12	Object
    //   11	593	18	localaw	aw
    //   18	858	19	localSharedPreferences	SharedPreferences
    //   68	253	20	localHashSet	java.util.HashSet
    //   125	15	21	localIterator	Iterator
    //   243	665	22	str	String
    //   225	1019	23	localaw1	com.appbrain.e.aw
    // Exception table:
    //   from	to	target	type
    //   217	227	1036	com/appbrain/b/o
    //   235	245	1036	com/appbrain/b/o
    //   253	260	1036	com/appbrain/b/o
    //   268	312	1036	com/appbrain/b/o
    //   320	331	1036	com/appbrain/b/o
    //   351	360	1036	com/appbrain/b/o
    //   368	380	1036	com/appbrain/b/o
    //   388	395	1036	com/appbrain/b/o
    //   403	423	1036	com/appbrain/b/o
    //   450	457	1036	com/appbrain/b/o
    //   465	475	1036	com/appbrain/b/o
    //   483	492	1036	com/appbrain/b/o
    //   500	522	1036	com/appbrain/b/o
    //   530	538	1036	com/appbrain/b/o
    //   546	555	1036	com/appbrain/b/o
    //   563	578	1036	com/appbrain/b/o
    //   603	614	1036	com/appbrain/b/o
    //   634	655	1036	com/appbrain/b/o
    //   676	685	1036	com/appbrain/b/o
    //   707	718	1036	com/appbrain/b/o
    //   746	757	1036	com/appbrain/b/o
    //   786	794	1036	com/appbrain/b/o
    //   806	812	1036	com/appbrain/b/o
    //   828	845	1036	com/appbrain/b/o
    //   875	884	1036	com/appbrain/b/o
    //   892	932	1036	com/appbrain/b/o
    //   940	948	1036	com/appbrain/b/o
    //   956	962	1036	com/appbrain/b/o
    //   981	992	1036	com/appbrain/b/o
    //   1000	1007	1036	com/appbrain/b/o
    //   1015	1033	1036	com/appbrain/b/o
    //   1096	1103	1036	com/appbrain/b/o
    //   1111	1121	1036	com/appbrain/b/o
    //   1129	1138	1036	com/appbrain/b/o
    //   1243	1250	1036	com/appbrain/b/o
    //   1258	1277	1036	com/appbrain/b/o
    //   1285	1292	1036	com/appbrain/b/o
    //   1300	1309	1036	com/appbrain/b/o
    //   217	227	1145	java/text/ParseException
    //   235	245	1145	java/text/ParseException
    //   253	260	1145	java/text/ParseException
    //   268	312	1145	java/text/ParseException
    //   320	331	1145	java/text/ParseException
    //   351	360	1145	java/text/ParseException
    //   368	380	1145	java/text/ParseException
    //   388	395	1145	java/text/ParseException
    //   403	423	1145	java/text/ParseException
    //   450	457	1145	java/text/ParseException
    //   465	475	1145	java/text/ParseException
    //   483	492	1145	java/text/ParseException
    //   500	522	1145	java/text/ParseException
    //   530	538	1145	java/text/ParseException
    //   546	555	1145	java/text/ParseException
    //   563	578	1145	java/text/ParseException
    //   603	614	1145	java/text/ParseException
    //   634	655	1145	java/text/ParseException
    //   676	685	1145	java/text/ParseException
    //   707	718	1145	java/text/ParseException
    //   746	757	1145	java/text/ParseException
    //   786	794	1145	java/text/ParseException
    //   806	812	1145	java/text/ParseException
    //   828	845	1145	java/text/ParseException
    //   875	884	1145	java/text/ParseException
    //   892	932	1145	java/text/ParseException
    //   940	948	1145	java/text/ParseException
    //   956	962	1145	java/text/ParseException
    //   981	992	1145	java/text/ParseException
    //   1000	1007	1145	java/text/ParseException
    //   1015	1033	1145	java/text/ParseException
    //   1096	1103	1145	java/text/ParseException
    //   1111	1121	1145	java/text/ParseException
    //   1129	1138	1145	java/text/ParseException
    //   1243	1250	1145	java/text/ParseException
    //   1258	1277	1145	java/text/ParseException
    //   1285	1292	1145	java/text/ParseException
    //   1300	1309	1145	java/text/ParseException
    //   685	691	1326	java/text/ParseException
    //   685	691	1339	com/appbrain/b/o
    //   603	614	1352	java/lang/Throwable
    //   634	655	1352	java/lang/Throwable
    //   676	685	1352	java/lang/Throwable
    //   707	718	1352	java/lang/Throwable
    //   746	757	1352	java/lang/Throwable
    //   786	794	1352	java/lang/Throwable
    //   806	812	1352	java/lang/Throwable
    //   685	691	1365	java/lang/Throwable
    //   786	794	1378	java/lang/Exception
    //   806	812	1378	java/lang/Exception
    //   746	757	1391	java/lang/Exception
  }
  
  public static void a(Activity paramActivity, WebView paramWebView)
  {
    Object localObject = aw.a().d();
    long l3 = System.currentTimeMillis();
    long l2 = ((SharedPreferences)localObject).getLong("last_cache_clear", 0L);
    long l1;
    if (l2 == 0L) {
      l1 = l3;
    }
    for (;;)
    {
      if (l1 != l2)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("last_cache_clear", l1);
        cmn.a.a().a((SharedPreferences.Editor)localObject);
      }
      localObject = paramWebView.getSettings();
      ((WebSettings)localObject).setSavePassword(false);
      ((WebSettings)localObject).setSaveFormData(false);
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setSupportZoom(false);
      ((WebSettings)localObject).setBlockNetworkImage(false);
      ((WebSettings)localObject).setLoadsImagesAutomatically(true);
      ((WebSettings)localObject).setDefaultTextEncodingName("UTF-8");
      paramWebView.setBackgroundColor(-1);
      paramWebView.addJavascriptInterface(new ab(paramActivity, null), "adApi");
      return;
      l1 = l3;
      if (l3 >= l2) {
        if (l3 > 259200000L + l2)
        {
          paramWebView.clearCache(true);
          l1 = l3;
        }
        else
        {
          l1 = l2;
        }
      }
    }
  }
  
  public static void a(Context paramContext, af paramaf)
  {
    a(paramContext, paramaf.a, paramaf.c, paramaf.b);
  }
  
  private static void a(Context paramContext, ax paramax, com.appbrain.e.af paramaf)
  {
    String str = paramax.h().j();
    long l = paramax.h().n();
    Object localObject = "time=" + l / 1000L + "&delta=" + (System.currentTimeMillis() - l) / 1000L;
    ar localar = paramax.h().y();
    localar.a(paramaf);
    localar.b(SystemClock.elapsedRealtime());
    localar.a(System.currentTimeMillis());
    localar.c((String)localObject);
    localObject = com.appbrain.e.aw.m();
    ((ax)localObject).a(false);
    ((ax)localObject).a(localar);
    ((ax)localObject).a(paramax.l());
    al.a(paramContext, paramaf + str, ((ax)localObject).d());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!b(paramContext, paramString)) {
      a.a(paramContext, paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    com.appbrain.e.af localaf = com.appbrain.e.af.c;
    ar localar = aq.x();
    localar.a(paramString1);
    localar.a(localaf);
    localar.b(SystemClock.elapsedRealtime());
    localar.a(System.currentTimeMillis());
    localar.b(paramString2);
    localar.c(paramString3);
    paramString2 = com.appbrain.e.aw.m();
    paramString2.a(localar);
    paramString2.a(false);
    paramString2.a(0);
    paramString2 = paramString2.d();
    al.a(paramContext, com.appbrain.e.af.c + paramString1, paramString2);
    if (!b(paramContext)) {
      al.a(paramContext);
    }
  }
  
  private static void a(Set paramSet, Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pkgList != null)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            paramSet.add(localObject[i]);
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/appbrain/a/aa:a	Ljava/lang/Boolean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +30 -> 38
    //   11: aload_0
    //   12: invokevirtual 248	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: new 467	android/content/ComponentName
    //   18: dup
    //   19: aload_0
    //   20: ldc_w 469
    //   23: invokespecial 471	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: invokevirtual 475	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   30: pop
    //   31: iconst_1
    //   32: invokestatic 481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: putstatic 10	com/appbrain/a/aa:a	Ljava/lang/Boolean;
    //   38: getstatic 10	com/appbrain/a/aa:a	Ljava/lang/Boolean;
    //   41: invokevirtual 484	java/lang/Boolean:booleanValue	()Z
    //   44: istore_1
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_1
    //   49: ireturn
    //   50: astore_0
    //   51: iconst_0
    //   52: invokestatic 481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: putstatic 10	com/appbrain/a/aa:a	Ljava/lang/Boolean;
    //   58: goto -20 -> 38
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   44	5	1	bool	boolean
    //   6	2	2	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   11	38	50	android/content/pm/PackageManager$NameNotFoundException
    //   3	7	61	finally
    //   11	38	61	finally
    //   38	45	61	finally
    //   51	58	61	finally
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    Intent localIntent1 = new Intent("android.intent.action.VIEW");
    if (!(paramContext instanceof Activity))
    {
      localIntent1.addFlags(268435456);
      localIntent1.addFlags(8388608);
    }
    localIntent1.setData(Uri.parse(paramString));
    try
    {
      Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(localIntent1, 65536).iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (localResolveInfo.activityInfo.packageName.equals("com.android.vending"))
        {
          localIntent1.setClassName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name);
          paramContext.startActivity(localIntent1);
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      if (paramString.startsWith("http://")) {
        break label172;
      }
    }
    if (!paramString.startsWith("https://")) {}
    try
    {
      Intent localIntent2 = new Intent("android.intent.action.VIEW");
      localIntent2.setData(Uri.parse(paramString));
      paramContext.startActivity(localIntent2);
      return true;
      label172:
      return false;
    }
    catch (ActivityNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  private static boolean b(String paramString)
  {
    return (paramString.startsWith("market://")) || (paramString.startsWith("http://play.google.com")) || (paramString.startsWith("https://play.google.com"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */