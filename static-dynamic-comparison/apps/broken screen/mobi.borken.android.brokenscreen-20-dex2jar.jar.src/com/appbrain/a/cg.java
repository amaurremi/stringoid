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
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cmn.Proguard.KeepMembers;
import cmn.h;
import com.appbrain.e.j.a;
import com.appbrain.e.j.k;
import com.appbrain.e.j.k.a;
import com.appbrain.e.j.o;
import com.appbrain.e.j.o.a;
import com.appbrain.e.j.p;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cg
{
  private static Boolean a = null;
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 28	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: ldc 29
    //   7: istore_1
    //   8: invokestatic 34	com/appbrain/a/aa:a	()Lcom/appbrain/a/aa;
    //   11: astore 18
    //   13: aload 18
    //   15: invokevirtual 38	com/appbrain/a/aa:e	()Landroid/content/SharedPreferences;
    //   18: astore 19
    //   20: aload 19
    //   22: invokeinterface 44 1 0
    //   27: astore 11
    //   29: aload 18
    //   31: ldc 46
    //   33: ldc 48
    //   35: invokevirtual 51	com/appbrain/a/aa:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: ldc 48
    //   40: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: istore 7
    //   45: aconst_null
    //   46: astore 10
    //   48: aload_0
    //   49: invokestatic 62	cmn/h:a	(Landroid/content/Context;)Ljava/util/List;
    //   52: astore 12
    //   54: new 64	java/util/HashSet
    //   57: dup
    //   58: aload 12
    //   60: invokeinterface 70 1 0
    //   65: invokespecial 74	java/util/HashSet:<init>	(I)V
    //   68: astore 20
    //   70: aload 12
    //   72: invokeinterface 78 1 0
    //   77: astore 12
    //   79: aload 12
    //   81: invokeinterface 84 1 0
    //   86: ifeq +27 -> 113
    //   89: aload 20
    //   91: aload 12
    //   93: invokeinterface 88 1 0
    //   98: checkcast 90	android/content/pm/PackageInfo
    //   101: getfield 94	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   104: invokeinterface 99 2 0
    //   109: pop
    //   110: goto -31 -> 79
    //   113: aload 11
    //   115: invokeinterface 105 1 0
    //   120: invokeinterface 106 1 0
    //   125: astore 21
    //   127: iload_1
    //   128: istore_2
    //   129: aload 21
    //   131: invokeinterface 84 1 0
    //   136: ifeq +1176 -> 1312
    //   139: aload 21
    //   141: invokeinterface 88 1 0
    //   146: checkcast 53	java/lang/String
    //   149: astore 11
    //   151: aload 11
    //   153: getstatic 112	com/appbrain/e/j$a:c	Lcom/appbrain/e/j$a;
    //   156: invokevirtual 116	com/appbrain/e/j$a:toString	()Ljava/lang/String;
    //   159: invokevirtual 120	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +1235 -> 1397
    //   165: aload 19
    //   167: aload 11
    //   169: aconst_null
    //   170: invokeinterface 123 3 0
    //   175: astore 11
    //   177: iload_2
    //   178: istore_1
    //   179: aload 11
    //   181: ifnull -54 -> 127
    //   184: iload 7
    //   186: ifeq +1208 -> 1394
    //   189: aload 10
    //   191: ifnonnull +1203 -> 1394
    //   194: new 64	java/util/HashSet
    //   197: dup
    //   198: invokespecial 125	java/util/HashSet:<init>	()V
    //   201: astore 10
    //   203: aload 10
    //   205: aload_0
    //   206: invokestatic 128	com/appbrain/a/cg:a	(Ljava/util/Set;Landroid/content/Context;)V
    //   209: aload 10
    //   211: astore 14
    //   213: aload 10
    //   215: astore 15
    //   217: aload 11
    //   219: invokestatic 133	cmn/k:a	(Ljava/lang/String;)[B
    //   222: invokestatic 138	com/appbrain/e/j$o:a	([B)Lcom/appbrain/e/j$o;
    //   225: astore 23
    //   227: aload 10
    //   229: astore 14
    //   231: aload 10
    //   233: astore 15
    //   235: aload 23
    //   237: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   240: invokevirtual 147	com/appbrain/e/j$k:j	()Ljava/lang/String;
    //   243: astore 22
    //   245: aload 10
    //   247: astore 14
    //   249: aload 10
    //   251: astore 15
    //   253: aload 23
    //   255: invokevirtual 150	com/appbrain/e/j$o:l	()I
    //   258: istore 4
    //   260: aload 10
    //   262: astore 14
    //   264: aload 10
    //   266: astore 15
    //   268: new 152	java/lang/StringBuilder
    //   271: dup
    //   272: ldc -102
    //   274: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload 22
    //   279: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc -93
    //   284: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 4
    //   289: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc -88
    //   294: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 23
    //   299: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   302: invokevirtual 171	com/appbrain/e/j$k:w	()I
    //   305: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 10
    //   311: astore 14
    //   313: aload 10
    //   315: astore 15
    //   317: aload 20
    //   319: aload 22
    //   321: invokeinterface 174 2 0
    //   326: istore 8
    //   328: aconst_null
    //   329: astore 11
    //   331: aload 11
    //   333: astore 12
    //   335: iload 7
    //   337: ifeq +83 -> 420
    //   340: aload 10
    //   342: astore 14
    //   344: aload 10
    //   346: astore 15
    //   348: aload 23
    //   350: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   353: invokevirtual 171	com/appbrain/e/j$k:w	()I
    //   356: istore_1
    //   357: aload 10
    //   359: astore 14
    //   361: aload 10
    //   363: astore 15
    //   365: aload 10
    //   367: aload 22
    //   369: invokeinterface 174 2 0
    //   374: ifeq +593 -> 967
    //   377: aload 10
    //   379: astore 14
    //   381: aload 10
    //   383: astore 15
    //   385: aload 23
    //   387: invokevirtual 178	com/appbrain/e/j$o:n	()Lcom/appbrain/e/j$o$a;
    //   390: astore 12
    //   392: aload 10
    //   394: astore 14
    //   396: aload 10
    //   398: astore 15
    //   400: aload 12
    //   402: aload 12
    //   404: invokevirtual 181	com/appbrain/e/j$o$a:h	()Lcom/appbrain/e/j$k;
    //   407: invokevirtual 185	com/appbrain/e/j$k:y	()Lcom/appbrain/e/j$k$a;
    //   410: iload_1
    //   411: iconst_1
    //   412: iadd
    //   413: invokevirtual 190	com/appbrain/e/j$k$a:a	(I)Lcom/appbrain/e/j$k$a;
    //   416: invokevirtual 193	com/appbrain/e/j$o$a:a	(Lcom/appbrain/e/j$k$a;)Lcom/appbrain/e/j$o$a;
    //   419: pop
    //   420: iload 4
    //   422: ifne +628 -> 1050
    //   425: iload 8
    //   427: ifeq +623 -> 1050
    //   430: aload 12
    //   432: astore 16
    //   434: aload 12
    //   436: ifnonnull +18 -> 454
    //   439: aload 10
    //   441: astore 14
    //   443: aload 10
    //   445: astore 15
    //   447: aload 23
    //   449: invokevirtual 178	com/appbrain/e/j$o:n	()Lcom/appbrain/e/j$o$a;
    //   452: astore 16
    //   454: aload 10
    //   456: astore 14
    //   458: aload 10
    //   460: astore 15
    //   462: aload 16
    //   464: iload 4
    //   466: iconst_1
    //   467: iadd
    //   468: invokevirtual 196	com/appbrain/e/j$o$a:a	(I)Lcom/appbrain/e/j$o$a;
    //   471: pop
    //   472: aload 10
    //   474: astore 14
    //   476: aload 10
    //   478: astore 15
    //   480: aload 19
    //   482: invokeinterface 200 1 0
    //   487: astore 11
    //   489: aload 10
    //   491: astore 14
    //   493: aload 10
    //   495: astore 15
    //   497: aload 11
    //   499: ldc -54
    //   501: aload 19
    //   503: ldc -54
    //   505: iconst_0
    //   506: invokeinterface 206 3 0
    //   511: iconst_1
    //   512: iadd
    //   513: invokeinterface 212 3 0
    //   518: pop
    //   519: aload 10
    //   521: astore 14
    //   523: aload 10
    //   525: astore 15
    //   527: invokestatic 217	cmn/a:a	()Lcmn/a;
    //   530: aload 11
    //   532: invokevirtual 221	cmn/a:b	(Landroid/content/SharedPreferences$Editor;)V
    //   535: aload 10
    //   537: astore 14
    //   539: aload 10
    //   541: astore 15
    //   543: aload_0
    //   544: aload 16
    //   546: getstatic 224	com/appbrain/e/j$a:d	Lcom/appbrain/e/j$a;
    //   549: invokestatic 227	com/appbrain/a/cg:a	(Landroid/content/Context;Lcom/appbrain/e/j$o$a;Lcom/appbrain/e/j$a;)V
    //   552: aload 10
    //   554: astore 14
    //   556: aload 10
    //   558: astore 15
    //   560: aload 23
    //   562: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   565: invokevirtual 230	com/appbrain/e/j$k:s	()Ljava/lang/String;
    //   568: ldc -24
    //   570: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   573: istore 9
    //   575: aload 10
    //   577: astore 11
    //   579: aload 16
    //   581: astore 13
    //   583: iload 9
    //   585: ifeq +233 -> 818
    //   588: aload 10
    //   590: astore 14
    //   592: aload 10
    //   594: astore 15
    //   596: aload 10
    //   598: astore 17
    //   600: aload 18
    //   602: ldc -19
    //   604: sipush 900
    //   607: invokevirtual 239	com/appbrain/a/aa:a	(Ljava/lang/String;I)I
    //   610: istore_1
    //   611: aload 10
    //   613: astore 11
    //   615: aload 16
    //   617: astore 13
    //   619: aload 10
    //   621: astore 14
    //   623: aload 10
    //   625: astore 15
    //   627: aload 10
    //   629: astore 17
    //   631: lload 5
    //   633: aload 23
    //   635: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   638: invokevirtual 242	com/appbrain/e/j$k:p	()J
    //   641: lsub
    //   642: iload_1
    //   643: i2l
    //   644: ldc2_w 243
    //   647: lmul
    //   648: lcmp
    //   649: ifge +169 -> 818
    //   652: aload 10
    //   654: astore 12
    //   656: aload 10
    //   658: ifnonnull +34 -> 692
    //   661: aload 10
    //   663: astore 14
    //   665: aload 10
    //   667: astore 15
    //   669: aload 10
    //   671: astore 17
    //   673: new 64	java/util/HashSet
    //   676: dup
    //   677: invokespecial 125	java/util/HashSet:<init>	()V
    //   680: astore 10
    //   682: aload 10
    //   684: aload_0
    //   685: invokestatic 128	com/appbrain/a/cg:a	(Ljava/util/Set;Landroid/content/Context;)V
    //   688: aload 10
    //   690: astore 12
    //   692: aload 12
    //   694: astore 14
    //   696: aload 12
    //   698: astore 15
    //   700: aload 12
    //   702: astore 17
    //   704: aload 12
    //   706: aload 22
    //   708: invokeinterface 174 2 0
    //   713: istore 9
    //   715: aload 12
    //   717: astore 11
    //   719: aload 16
    //   721: astore 13
    //   723: iload 9
    //   725: ifne +93 -> 818
    //   728: aconst_null
    //   729: astore 10
    //   731: aload 12
    //   733: astore 14
    //   735: aload 12
    //   737: astore 15
    //   739: aload 12
    //   741: astore 17
    //   743: aload_0
    //   744: invokevirtual 250	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   747: aload 22
    //   749: invokevirtual 256	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   752: astore 11
    //   754: aload 11
    //   756: astore 10
    //   758: aload 12
    //   760: astore 11
    //   762: aload 16
    //   764: astore 13
    //   766: aload 10
    //   768: ifnull +50 -> 818
    //   771: aload 12
    //   773: astore 14
    //   775: aload 12
    //   777: astore 15
    //   779: aload 12
    //   781: astore 17
    //   783: aload 10
    //   785: ldc_w 257
    //   788: invokevirtual 263	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   791: pop
    //   792: aload 12
    //   794: astore 14
    //   796: aload 12
    //   798: astore 15
    //   800: aload 12
    //   802: astore 17
    //   804: aload_0
    //   805: aload 10
    //   807: invokevirtual 267	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   810: aload 16
    //   812: astore 13
    //   814: aload 12
    //   816: astore 11
    //   818: aload 11
    //   820: astore 14
    //   822: aload 11
    //   824: astore 15
    //   826: lload 5
    //   828: aload 23
    //   830: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   833: invokevirtual 242	com/appbrain/e/j$k:p	()J
    //   836: lsub
    //   837: ldc2_w 243
    //   840: ldiv
    //   841: l2i
    //   842: istore_1
    //   843: ldc 29
    //   845: istore_3
    //   846: iload_1
    //   847: sipush 300
    //   850: if_icmpge +309 -> 1159
    //   853: bipush 30
    //   855: istore_1
    //   856: aload 13
    //   858: astore 10
    //   860: aload 10
    //   862: ifnull +84 -> 946
    //   865: aload 11
    //   867: astore 14
    //   869: aload 11
    //   871: astore 15
    //   873: aload 19
    //   875: invokeinterface 200 1 0
    //   880: astore 12
    //   882: aload 11
    //   884: astore 14
    //   886: aload 11
    //   888: astore 15
    //   890: aload 12
    //   892: new 152	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   899: getstatic 112	com/appbrain/e/j$a:c	Lcom/appbrain/e/j$a;
    //   902: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   905: aload 22
    //   907: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: aload 10
    //   915: invokevirtual 275	com/appbrain/e/j$o$a:d	()Lcom/appbrain/e/j$o;
    //   918: invokevirtual 278	com/appbrain/e/j$o:b	()[B
    //   921: invokestatic 281	cmn/k:a	([B)Ljava/lang/String;
    //   924: invokeinterface 285 3 0
    //   929: pop
    //   930: aload 11
    //   932: astore 14
    //   934: aload 11
    //   936: astore 15
    //   938: invokestatic 217	cmn/a:a	()Lcmn/a;
    //   941: aload 12
    //   943: invokevirtual 287	cmn/a:a	(Landroid/content/SharedPreferences$Editor;)V
    //   946: aload 11
    //   948: astore 14
    //   950: aload 11
    //   952: astore 15
    //   954: iload_2
    //   955: iload_1
    //   956: invokestatic 293	java/lang/Math:min	(II)I
    //   959: istore_1
    //   960: aload 11
    //   962: astore 10
    //   964: goto -837 -> 127
    //   967: aload 11
    //   969: astore 12
    //   971: aload 10
    //   973: astore 14
    //   975: aload 10
    //   977: astore 15
    //   979: aload 23
    //   981: invokevirtual 142	com/appbrain/e/j$o:h	()Lcom/appbrain/e/j$k;
    //   984: invokevirtual 296	com/appbrain/e/j$k:v	()Z
    //   987: ifne -567 -> 420
    //   990: aload 10
    //   992: astore 14
    //   994: aload 10
    //   996: astore 15
    //   998: aload 23
    //   1000: invokevirtual 178	com/appbrain/e/j$o:n	()Lcom/appbrain/e/j$o$a;
    //   1003: astore 12
    //   1005: aload 10
    //   1007: astore 14
    //   1009: aload 10
    //   1011: astore 15
    //   1013: aload 12
    //   1015: aload 12
    //   1017: invokevirtual 181	com/appbrain/e/j$o$a:h	()Lcom/appbrain/e/j$k;
    //   1020: invokevirtual 185	com/appbrain/e/j$k:y	()Lcom/appbrain/e/j$k$a;
    //   1023: iconst_0
    //   1024: invokevirtual 190	com/appbrain/e/j$k$a:a	(I)Lcom/appbrain/e/j$k$a;
    //   1027: invokevirtual 193	com/appbrain/e/j$o$a:a	(Lcom/appbrain/e/j$k$a;)Lcom/appbrain/e/j$o$a;
    //   1030: pop
    //   1031: goto -611 -> 420
    //   1034: astore 10
    //   1036: aload 10
    //   1038: invokevirtual 299	com/appbrain/b/i:printStackTrace	()V
    //   1041: aload 14
    //   1043: astore 10
    //   1045: iload_2
    //   1046: istore_1
    //   1047: goto -920 -> 127
    //   1050: aload 10
    //   1052: astore 11
    //   1054: aload 12
    //   1056: astore 13
    //   1058: iload 4
    //   1060: iconst_1
    //   1061: if_icmpne -243 -> 818
    //   1064: aload 10
    //   1066: astore 11
    //   1068: aload 12
    //   1070: astore 13
    //   1072: iload 8
    //   1074: ifne -256 -> 818
    //   1077: aload 12
    //   1079: astore 13
    //   1081: aload 12
    //   1083: ifnonnull +18 -> 1101
    //   1086: aload 10
    //   1088: astore 14
    //   1090: aload 10
    //   1092: astore 15
    //   1094: aload 23
    //   1096: invokevirtual 178	com/appbrain/e/j$o:n	()Lcom/appbrain/e/j$o$a;
    //   1099: astore 13
    //   1101: aload 10
    //   1103: astore 14
    //   1105: aload 10
    //   1107: astore 15
    //   1109: aload 13
    //   1111: iload 4
    //   1113: iconst_1
    //   1114: iadd
    //   1115: invokevirtual 196	com/appbrain/e/j$o$a:a	(I)Lcom/appbrain/e/j$o$a;
    //   1118: pop
    //   1119: aload 10
    //   1121: astore 14
    //   1123: aload 10
    //   1125: astore 15
    //   1127: aload_0
    //   1128: aload 13
    //   1130: getstatic 301	com/appbrain/e/j$a:e	Lcom/appbrain/e/j$a;
    //   1133: invokestatic 227	com/appbrain/a/cg:a	(Landroid/content/Context;Lcom/appbrain/e/j$o$a;Lcom/appbrain/e/j$a;)V
    //   1136: aload 10
    //   1138: astore 11
    //   1140: goto -322 -> 818
    //   1143: astore 10
    //   1145: aload 10
    //   1147: invokevirtual 302	java/text/ParseException:printStackTrace	()V
    //   1150: aload 15
    //   1152: astore 10
    //   1154: iload_2
    //   1155: istore_1
    //   1156: goto -1029 -> 127
    //   1159: iload_1
    //   1160: sipush 900
    //   1163: if_icmpge +13 -> 1176
    //   1166: bipush 120
    //   1168: istore_1
    //   1169: aload 13
    //   1171: astore 10
    //   1173: goto -313 -> 860
    //   1176: iload_1
    //   1177: sipush 3600
    //   1180: if_icmpge +14 -> 1194
    //   1183: sipush 300
    //   1186: istore_1
    //   1187: aload 13
    //   1189: astore 10
    //   1191: goto -331 -> 860
    //   1194: iload_1
    //   1195: ldc_w 303
    //   1198: if_icmpge +14 -> 1212
    //   1201: sipush 1800
    //   1204: istore_1
    //   1205: aload 13
    //   1207: astore 10
    //   1209: goto -349 -> 860
    //   1212: iload_3
    //   1213: istore_1
    //   1214: aload 13
    //   1216: astore 10
    //   1218: iload 4
    //   1220: iconst_3
    //   1221: if_icmpeq -361 -> 860
    //   1224: aload 13
    //   1226: astore 10
    //   1228: aload 13
    //   1230: ifnonnull +18 -> 1248
    //   1233: aload 11
    //   1235: astore 14
    //   1237: aload 11
    //   1239: astore 15
    //   1241: aload 23
    //   1243: invokevirtual 178	com/appbrain/e/j$o:n	()Lcom/appbrain/e/j$o$a;
    //   1246: astore 10
    //   1248: aload 11
    //   1250: astore 14
    //   1252: aload 11
    //   1254: astore 15
    //   1256: aload 10
    //   1258: aload 10
    //   1260: invokevirtual 181	com/appbrain/e/j$o$a:h	()Lcom/appbrain/e/j$k;
    //   1263: invokevirtual 185	com/appbrain/e/j$k:y	()Lcom/appbrain/e/j$k$a;
    //   1266: iload 8
    //   1268: invokevirtual 306	com/appbrain/e/j$k$a:a	(Z)Lcom/appbrain/e/j$k$a;
    //   1271: invokevirtual 193	com/appbrain/e/j$o$a:a	(Lcom/appbrain/e/j$k$a;)Lcom/appbrain/e/j$o$a;
    //   1274: pop
    //   1275: aload 11
    //   1277: astore 14
    //   1279: aload 11
    //   1281: astore 15
    //   1283: aload 10
    //   1285: iconst_3
    //   1286: invokevirtual 196	com/appbrain/e/j$o$a:a	(I)Lcom/appbrain/e/j$o$a;
    //   1289: pop
    //   1290: aload 11
    //   1292: astore 14
    //   1294: aload 11
    //   1296: astore 15
    //   1298: aload_0
    //   1299: aload 10
    //   1301: getstatic 309	com/appbrain/e/j$a:f	Lcom/appbrain/e/j$a;
    //   1304: invokestatic 227	com/appbrain/a/cg:a	(Landroid/content/Context;Lcom/appbrain/e/j$o$a;Lcom/appbrain/e/j$a;)V
    //   1307: iload_3
    //   1308: istore_1
    //   1309: goto -449 -> 860
    //   1312: iload_2
    //   1313: istore_1
    //   1314: iload_2
    //   1315: ldc 29
    //   1317: if_icmpne +5 -> 1322
    //   1320: iconst_0
    //   1321: istore_1
    //   1322: iload_1
    //   1323: ireturn
    //   1324: astore 11
    //   1326: aload 10
    //   1328: astore 15
    //   1330: aload 11
    //   1332: astore 10
    //   1334: goto -189 -> 1145
    //   1337: astore 11
    //   1339: aload 10
    //   1341: astore 14
    //   1343: aload 11
    //   1345: astore 10
    //   1347: goto -311 -> 1036
    //   1350: astore 10
    //   1352: aload 17
    //   1354: astore 11
    //   1356: aload 16
    //   1358: astore 13
    //   1360: goto -542 -> 818
    //   1363: astore 11
    //   1365: aload 10
    //   1367: astore 11
    //   1369: aload 16
    //   1371: astore 13
    //   1373: goto -555 -> 818
    //   1376: astore 10
    //   1378: aload 12
    //   1380: astore 11
    //   1382: aload 16
    //   1384: astore 13
    //   1386: goto -568 -> 818
    //   1389: astore 11
    //   1391: goto -633 -> 758
    //   1394: goto -1185 -> 209
    //   1397: aload 10
    //   1399: astore 15
    //   1401: goto -251 -> 1150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1404	0	paramContext	Context
    //   7	1316	1	i	int
    //   128	1190	2	j	int
    //   845	463	3	k	int
    //   258	964	4	m	int
    //   3	824	5	l	long
    //   43	293	7	bool1	boolean
    //   326	941	8	bool2	boolean
    //   573	151	9	bool3	boolean
    //   46	964	10	localObject1	Object
    //   1034	3	10	locali1	com.appbrain.b.i
    //   1043	94	10	localObject2	Object
    //   1143	3	10	localParseException1	java.text.ParseException
    //   1152	194	10	localObject3	Object
    //   1350	16	10	localThrowable1	Throwable
    //   1376	22	10	localException1	Exception
    //   27	1268	11	localObject4	Object
    //   1324	7	11	localParseException2	java.text.ParseException
    //   1337	7	11	locali2	com.appbrain.b.i
    //   1354	1	11	localObject5	Object
    //   1363	1	11	localThrowable2	Throwable
    //   1367	14	11	localObject6	Object
    //   1389	1	11	localException2	Exception
    //   52	1327	12	localObject7	Object
    //   581	804	13	localObject8	Object
    //   211	1131	14	localObject9	Object
    //   215	1185	15	localObject10	Object
    //   432	951	16	localObject11	Object
    //   598	755	17	localObject12	Object
    //   11	590	18	localaa	aa
    //   18	856	19	localSharedPreferences	SharedPreferences
    //   68	250	20	localHashSet	java.util.HashSet
    //   125	15	21	localIterator	Iterator
    //   243	663	22	str	String
    //   225	1017	23	localo	j.o
    // Exception table:
    //   from	to	target	type
    //   217	227	1034	com/appbrain/b/i
    //   235	245	1034	com/appbrain/b/i
    //   253	260	1034	com/appbrain/b/i
    //   268	309	1034	com/appbrain/b/i
    //   317	328	1034	com/appbrain/b/i
    //   348	357	1034	com/appbrain/b/i
    //   365	377	1034	com/appbrain/b/i
    //   385	392	1034	com/appbrain/b/i
    //   400	420	1034	com/appbrain/b/i
    //   447	454	1034	com/appbrain/b/i
    //   462	472	1034	com/appbrain/b/i
    //   480	489	1034	com/appbrain/b/i
    //   497	519	1034	com/appbrain/b/i
    //   527	535	1034	com/appbrain/b/i
    //   543	552	1034	com/appbrain/b/i
    //   560	575	1034	com/appbrain/b/i
    //   600	611	1034	com/appbrain/b/i
    //   631	652	1034	com/appbrain/b/i
    //   673	682	1034	com/appbrain/b/i
    //   704	715	1034	com/appbrain/b/i
    //   743	754	1034	com/appbrain/b/i
    //   783	792	1034	com/appbrain/b/i
    //   804	810	1034	com/appbrain/b/i
    //   826	843	1034	com/appbrain/b/i
    //   873	882	1034	com/appbrain/b/i
    //   890	930	1034	com/appbrain/b/i
    //   938	946	1034	com/appbrain/b/i
    //   954	960	1034	com/appbrain/b/i
    //   979	990	1034	com/appbrain/b/i
    //   998	1005	1034	com/appbrain/b/i
    //   1013	1031	1034	com/appbrain/b/i
    //   1094	1101	1034	com/appbrain/b/i
    //   1109	1119	1034	com/appbrain/b/i
    //   1127	1136	1034	com/appbrain/b/i
    //   1241	1248	1034	com/appbrain/b/i
    //   1256	1275	1034	com/appbrain/b/i
    //   1283	1290	1034	com/appbrain/b/i
    //   1298	1307	1034	com/appbrain/b/i
    //   217	227	1143	java/text/ParseException
    //   235	245	1143	java/text/ParseException
    //   253	260	1143	java/text/ParseException
    //   268	309	1143	java/text/ParseException
    //   317	328	1143	java/text/ParseException
    //   348	357	1143	java/text/ParseException
    //   365	377	1143	java/text/ParseException
    //   385	392	1143	java/text/ParseException
    //   400	420	1143	java/text/ParseException
    //   447	454	1143	java/text/ParseException
    //   462	472	1143	java/text/ParseException
    //   480	489	1143	java/text/ParseException
    //   497	519	1143	java/text/ParseException
    //   527	535	1143	java/text/ParseException
    //   543	552	1143	java/text/ParseException
    //   560	575	1143	java/text/ParseException
    //   600	611	1143	java/text/ParseException
    //   631	652	1143	java/text/ParseException
    //   673	682	1143	java/text/ParseException
    //   704	715	1143	java/text/ParseException
    //   743	754	1143	java/text/ParseException
    //   783	792	1143	java/text/ParseException
    //   804	810	1143	java/text/ParseException
    //   826	843	1143	java/text/ParseException
    //   873	882	1143	java/text/ParseException
    //   890	930	1143	java/text/ParseException
    //   938	946	1143	java/text/ParseException
    //   954	960	1143	java/text/ParseException
    //   979	990	1143	java/text/ParseException
    //   998	1005	1143	java/text/ParseException
    //   1013	1031	1143	java/text/ParseException
    //   1094	1101	1143	java/text/ParseException
    //   1109	1119	1143	java/text/ParseException
    //   1127	1136	1143	java/text/ParseException
    //   1241	1248	1143	java/text/ParseException
    //   1256	1275	1143	java/text/ParseException
    //   1283	1290	1143	java/text/ParseException
    //   1298	1307	1143	java/text/ParseException
    //   682	688	1324	java/text/ParseException
    //   682	688	1337	com/appbrain/b/i
    //   600	611	1350	java/lang/Throwable
    //   631	652	1350	java/lang/Throwable
    //   673	682	1350	java/lang/Throwable
    //   704	715	1350	java/lang/Throwable
    //   743	754	1350	java/lang/Throwable
    //   783	792	1350	java/lang/Throwable
    //   804	810	1350	java/lang/Throwable
    //   682	688	1363	java/lang/Throwable
    //   783	792	1376	java/lang/Exception
    //   804	810	1376	java/lang/Exception
    //   743	754	1389	java/lang/Exception
  }
  
  public static void a(Activity paramActivity, WebView paramWebView)
  {
    Object localObject = aa.a().e();
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
      paramWebView.addJavascriptInterface(new a(paramActivity, null), "adApi");
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
  
  public static void a(Context paramContext, ck paramck)
  {
    a(paramContext, paramck.a, paramck.c, paramck.b);
  }
  
  private static void a(Context paramContext, j.o.a parama, j.a parama1)
  {
    String str = parama.h().j();
    long l = parama.h().n();
    Object localObject = "time=" + l / 1000L + "&delta=" + (System.currentTimeMillis() - l) / 1000L;
    j.k.a locala = parama.h().y();
    locala.a(parama1);
    locala.b(SystemClock.elapsedRealtime());
    locala.a(System.currentTimeMillis());
    locala.c((String)localObject);
    localObject = j.o.m();
    ((j.o.a)localObject).a(false);
    ((j.o.a)localObject).a(locala);
    ((j.o.a)localObject).a(parama.l());
    cq.a(paramContext, parama1 + str, ((j.o.a)localObject).d());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!b(paramContext, paramString)) {
      a.a(paramContext, paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    j.a locala1 = j.a.c;
    j.k.a locala = j.k.x();
    locala.a(paramString1);
    locala.a(locala1);
    locala.b(SystemClock.elapsedRealtime());
    locala.a(System.currentTimeMillis());
    locala.b(paramString2);
    locala.c(paramString3);
    paramString2 = j.o.m();
    paramString2.a(locala);
    paramString2.a(false);
    paramString2.a(0);
    paramString2 = paramString2.d();
    cq.a(paramContext, j.a.c + paramString1, paramString2);
    if (!b(paramContext)) {
      cq.a(paramContext);
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
    //   3: getstatic 12	com/appbrain/a/cg:a	Ljava/lang/Boolean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +30 -> 38
    //   11: aload_0
    //   12: invokevirtual 250	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
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
    //   35: putstatic 12	com/appbrain/a/cg:a	Ljava/lang/Boolean;
    //   38: getstatic 12	com/appbrain/a/cg:a	Ljava/lang/Boolean;
    //   41: invokevirtual 484	java/lang/Boolean:booleanValue	()Z
    //   44: istore_1
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_1
    //   49: ireturn
    //   50: astore_0
    //   51: iconst_0
    //   52: invokestatic 481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: putstatic 12	com/appbrain/a/cg:a	Ljava/lang/Boolean;
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
        break label173;
      }
    }
    if (!paramString.startsWith("https://")) {}
    try
    {
      Intent localIntent2 = new Intent("android.intent.action.VIEW");
      localIntent2.setData(Uri.parse(paramString));
      paramContext.startActivity(localIntent2);
      return true;
      label173:
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
  
  static class a
    implements Proguard.KeepMembers
  {
    final ck a;
    private final Activity b;
    
    public a(Activity paramActivity, ck paramck)
    {
      this.a = paramck;
      this.b = paramActivity;
    }
    
    @JavascriptInterface
    public void click()
    {
      if (this.a != null)
      {
        cg.a(this.b, this.a);
        SharedPreferences localSharedPreferences = aa.a().e();
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.putInt("ow_click", localSharedPreferences.getInt("ow_click", 0) + 1);
        cmn.a.a().b(localEditor);
      }
    }
    
    @JavascriptInterface
    public void close()
    {
      this.b.finish();
    }
    
    @JavascriptInterface
    public boolean isPackageInstalled(String paramString)
    {
      return h.a(this.b, paramString);
    }
    
    @JavascriptInterface
    public void openUrl(String paramString, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        cg.c(this.b, paramString);
        return;
      }
      cg.a(this.b, paramString);
    }
    
    @JavascriptInterface
    public void reportSelected(String paramString1, String paramString2, String paramString3)
    {
      new Thread(new ci(this, paramString1, paramString2, paramString3)).start();
      paramString1 = aa.a().e();
      paramString2 = paramString1.edit();
      paramString2.putInt("ow_imp", paramString1.getInt("ow_imp", 0) + 1);
      cmn.a.a().b(paramString2);
    }
    
    @JavascriptInterface
    public void trackClick(String paramString1, String paramString2, String paramString3)
    {
      cg.a(this.b, paramString1, paramString2, paramString3);
      paramString1 = aa.a().e();
      paramString2 = paramString1.edit();
      paramString2.putInt("ow_click", paramString1.getInt("ow_click", 0) + 1);
      cmn.a.a().b(paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */