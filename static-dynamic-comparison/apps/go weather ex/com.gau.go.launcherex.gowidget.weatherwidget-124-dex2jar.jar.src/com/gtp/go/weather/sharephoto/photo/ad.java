package com.gtp.go.weather.sharephoto.photo;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.go.weather.sharephoto.a.f;
import com.gtp.go.weather.sharephoto.b.a.d;
import com.gtp.go.weather.sharephoto.b.o;
import com.gtp.go.weather.sharephoto.d.h;
import com.jiubang.core.c.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ad
{
  public static final String a = h.a + "compose";
  private static SparseArray g = new SparseArray();
  private Context b;
  private boolean c = true;
  private boolean d = false;
  private b e;
  private ah f;
  
  public ad(Context paramContext)
  {
    this.b = paramContext;
    this.c = true;
    this.d = false;
    com.gtp.a.a.b.c.a("delete_photos", "mJudgeShouldClearPhotoData = " + this.c);
  }
  
  /* Error */
  private int a(int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 6
    //   3: iload 6
    //   5: istore 8
    //   7: new 72	org/json/JSONObject
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: iload 6
    //   18: istore 8
    //   20: aload_2
    //   21: ldc 77
    //   23: invokevirtual 81	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   26: istore 10
    //   28: iload 10
    //   30: istore 8
    //   32: ldc 83
    //   34: new 21	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   41: ldc 85
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 10
    //   48: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 65	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iload 10
    //   59: istore 8
    //   61: aload_2
    //   62: ldc 90
    //   64: invokevirtual 94	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +943 -> 1012
    //   72: iload 10
    //   74: istore 8
    //   76: aload_2
    //   77: invokevirtual 100	org/json/JSONArray:length	()I
    //   80: istore 11
    //   82: iconst_0
    //   83: istore 7
    //   85: iload 7
    //   87: iload 11
    //   89: if_icmpge +923 -> 1012
    //   92: iload 10
    //   94: istore 8
    //   96: aload_2
    //   97: iload 7
    //   99: invokevirtual 104	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   102: astore 15
    //   104: iload 10
    //   106: istore 8
    //   108: aload 15
    //   110: ldc 106
    //   112: ldc2_w 107
    //   115: invokevirtual 112	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   118: lstore 13
    //   120: iload 10
    //   122: istore 8
    //   124: aload 15
    //   126: ldc 114
    //   128: iconst_m1
    //   129: invokevirtual 117	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   132: istore 12
    //   134: iload 12
    //   136: iconst_m1
    //   137: if_icmpeq +889 -> 1026
    //   140: lload 13
    //   142: ldc2_w 107
    //   145: lcmp
    //   146: ifne +889 -> 1035
    //   149: goto +877 -> 1026
    //   152: iload 6
    //   154: ifeq +143 -> 297
    //   157: iload 10
    //   159: istore 8
    //   161: ldc 83
    //   163: ldc 119
    //   165: invokestatic 65	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto +858 -> 1026
    //   171: astore_2
    //   172: invokestatic 122	com/gtp/a/a/b/c:a	()Z
    //   175: ifeq +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 125	org/json/JSONException:printStackTrace	()V
    //   182: iload 8
    //   184: ireturn
    //   185: iload 10
    //   187: istore 8
    //   189: aload 4
    //   191: invokevirtual 131	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   194: astore 16
    //   196: iload 10
    //   198: istore 8
    //   200: aload 16
    //   202: invokeinterface 136 1 0
    //   207: ifeq +813 -> 1020
    //   210: iload 10
    //   212: istore 8
    //   214: aload 16
    //   216: invokeinterface 140 1 0
    //   221: checkcast 142	com/gtp/go/weather/sharephoto/b/g
    //   224: invokevirtual 145	com/gtp/go/weather/sharephoto/b/g:a	()J
    //   227: lload 13
    //   229: lcmp
    //   230: ifne -34 -> 196
    //   233: iconst_1
    //   234: istore 6
    //   236: goto +835 -> 1071
    //   239: iload 10
    //   241: istore 8
    //   243: aload 5
    //   245: invokevirtual 131	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   248: astore 16
    //   250: iload 9
    //   252: istore 6
    //   254: iload 10
    //   256: istore 8
    //   258: aload 16
    //   260: invokeinterface 136 1 0
    //   265: ifeq -113 -> 152
    //   268: iload 10
    //   270: istore 8
    //   272: aload 16
    //   274: invokeinterface 140 1 0
    //   279: checkcast 142	com/gtp/go/weather/sharephoto/b/g
    //   282: invokevirtual 145	com/gtp/go/weather/sharephoto/b/g:a	()J
    //   285: lload 13
    //   287: lcmp
    //   288: ifne -38 -> 250
    //   291: iconst_1
    //   292: istore 6
    //   294: goto -142 -> 152
    //   297: iload 10
    //   299: istore 8
    //   301: new 142	com/gtp/go/weather/sharephoto/b/g
    //   304: dup
    //   305: invokespecial 146	com/gtp/go/weather/sharephoto/b/g:<init>	()V
    //   308: astore 16
    //   310: iload 10
    //   312: istore 8
    //   314: aload 16
    //   316: iload_3
    //   317: invokevirtual 149	com/gtp/go/weather/sharephoto/b/g:c	(I)V
    //   320: iload_1
    //   321: ifne +389 -> 710
    //   324: iload 11
    //   326: bipush 20
    //   328: if_icmpge +341 -> 669
    //   331: iload 10
    //   333: istore 8
    //   335: aload 16
    //   337: iload 10
    //   339: iconst_1
    //   340: isub
    //   341: invokevirtual 151	com/gtp/go/weather/sharephoto/b/g:d	(I)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload 16
    //   350: lload 13
    //   352: invokevirtual 154	com/gtp/go/weather/sharephoto/b/g:a	(J)V
    //   355: iload 10
    //   357: istore 8
    //   359: aload 16
    //   361: aload 15
    //   363: ldc -100
    //   365: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 162	com/gtp/go/weather/sharephoto/b/g:a	(Ljava/lang/String;)V
    //   371: iload 10
    //   373: istore 8
    //   375: aload 16
    //   377: aload 15
    //   379: ldc -92
    //   381: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   384: invokevirtual 169	com/gtp/go/weather/sharephoto/b/g:a	(I)V
    //   387: iload 10
    //   389: istore 8
    //   391: aload 16
    //   393: aload 15
    //   395: ldc -85
    //   397: invokevirtual 175	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   400: invokevirtual 178	com/gtp/go/weather/sharephoto/b/g:a	(Z)V
    //   403: iload 10
    //   405: istore 8
    //   407: aload 16
    //   409: aload 15
    //   411: ldc -76
    //   413: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   416: invokevirtual 182	com/gtp/go/weather/sharephoto/b/g:b	(Ljava/lang/String;)V
    //   419: iload 10
    //   421: istore 8
    //   423: aload 16
    //   425: aload 15
    //   427: ldc -72
    //   429: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   432: invokevirtual 186	com/gtp/go/weather/sharephoto/b/g:b	(I)V
    //   435: iload 10
    //   437: istore 8
    //   439: aload 16
    //   441: aload 15
    //   443: ldc -68
    //   445: invokevirtual 192	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   448: invokevirtual 194	com/gtp/go/weather/sharephoto/b/g:b	(J)V
    //   451: iload 10
    //   453: istore 8
    //   455: aload 16
    //   457: aload 15
    //   459: ldc -60
    //   461: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   464: invokevirtual 198	com/gtp/go/weather/sharephoto/b/g:c	(Ljava/lang/String;)V
    //   467: iload 10
    //   469: istore 8
    //   471: aload 16
    //   473: iload 12
    //   475: invokevirtual 200	com/gtp/go/weather/sharephoto/b/g:e	(I)V
    //   478: iload 10
    //   480: istore 8
    //   482: aload 16
    //   484: aload 15
    //   486: ldc -54
    //   488: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 207	com/gtp/go/weather/sharephoto/b/g:d	(Ljava/lang/String;)V
    //   494: iload 10
    //   496: istore 8
    //   498: aload 16
    //   500: aload 15
    //   502: ldc -47
    //   504: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   507: invokevirtual 211	com/gtp/go/weather/sharephoto/b/g:e	(Ljava/lang/String;)V
    //   510: iload 10
    //   512: istore 8
    //   514: aload 15
    //   516: ldc -43
    //   518: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 17
    //   523: iload 10
    //   525: istore 8
    //   527: aload 17
    //   529: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   532: ifne +33 -> 565
    //   535: iload 10
    //   537: istore 8
    //   539: aload 16
    //   541: aload 17
    //   543: invokevirtual 221	com/gtp/go/weather/sharephoto/b/g:g	(Ljava/lang/String;)V
    //   546: aload 16
    //   548: new 72	org/json/JSONObject
    //   551: dup
    //   552: aload 17
    //   554: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   557: ldc -33
    //   559: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: invokevirtual 225	com/gtp/go/weather/sharephoto/b/g:f	(Ljava/lang/String;)V
    //   565: iload 10
    //   567: istore 8
    //   569: aload 15
    //   571: ldc 90
    //   573: invokevirtual 228	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   576: astore 15
    //   578: aload 15
    //   580: ifnull +143 -> 723
    //   583: iload 10
    //   585: istore 8
    //   587: aload 15
    //   589: invokevirtual 100	org/json/JSONArray:length	()I
    //   592: istore 6
    //   594: goto +480 -> 1074
    //   597: iload 9
    //   599: iload 6
    //   601: if_icmpge +485 -> 1086
    //   604: iload 10
    //   606: istore 8
    //   608: aload 15
    //   610: iload 9
    //   612: invokevirtual 104	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   615: astore 17
    //   617: iload 10
    //   619: istore 8
    //   621: aload 17
    //   623: ldc -26
    //   625: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   628: istore 12
    //   630: iload 12
    //   632: tableswitch	default:+28->660, 1:+97->729, 2:+183->815, 3:+234->866
    //   660: iload 9
    //   662: iconst_1
    //   663: iadd
    //   664: istore 9
    //   666: goto -69 -> 597
    //   669: iload 11
    //   671: bipush 10
    //   673: isub
    //   674: iload 7
    //   676: isub
    //   677: ifle +17 -> 694
    //   680: iload 10
    //   682: istore 8
    //   684: aload 16
    //   686: iload 10
    //   688: invokevirtual 151	com/gtp/go/weather/sharephoto/b/g:d	(I)V
    //   691: goto -347 -> 344
    //   694: iload 10
    //   696: istore 8
    //   698: aload 16
    //   700: iload 10
    //   702: iconst_1
    //   703: isub
    //   704: invokevirtual 151	com/gtp/go/weather/sharephoto/b/g:d	(I)V
    //   707: goto -363 -> 344
    //   710: iload 10
    //   712: istore 8
    //   714: aload 16
    //   716: iload_1
    //   717: invokevirtual 151	com/gtp/go/weather/sharephoto/b/g:d	(I)V
    //   720: goto -376 -> 344
    //   723: iconst_0
    //   724: istore 6
    //   726: goto +348 -> 1074
    //   729: iload 10
    //   731: istore 8
    //   733: aload 16
    //   735: aload 17
    //   737: ldc -24
    //   739: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   742: invokevirtual 235	com/gtp/go/weather/sharephoto/b/g:h	(Ljava/lang/String;)V
    //   745: iload 10
    //   747: istore 8
    //   749: aload 16
    //   751: aload 17
    //   753: ldc -19
    //   755: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   758: invokevirtual 239	com/gtp/go/weather/sharephoto/b/g:f	(I)V
    //   761: iload 10
    //   763: istore 8
    //   765: aload 16
    //   767: aload 17
    //   769: ldc -15
    //   771: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   774: invokevirtual 243	com/gtp/go/weather/sharephoto/b/g:g	(I)V
    //   777: goto -117 -> 660
    //   780: astore 15
    //   782: iload 10
    //   784: istore 8
    //   786: ldc 83
    //   788: ldc -11
    //   790: invokestatic 65	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: iload 10
    //   795: istore 8
    //   797: invokestatic 122	com/gtp/a/a/b/c:a	()Z
    //   800: ifeq +226 -> 1026
    //   803: iload 10
    //   805: istore 8
    //   807: aload 15
    //   809: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   812: goto +214 -> 1026
    //   815: iload 10
    //   817: istore 8
    //   819: aload 16
    //   821: aload 17
    //   823: ldc -24
    //   825: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   828: invokevirtual 249	com/gtp/go/weather/sharephoto/b/g:j	(Ljava/lang/String;)V
    //   831: iload 10
    //   833: istore 8
    //   835: aload 16
    //   837: aload 17
    //   839: ldc -19
    //   841: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   844: invokevirtual 251	com/gtp/go/weather/sharephoto/b/g:h	(I)V
    //   847: iload 10
    //   849: istore 8
    //   851: aload 16
    //   853: aload 17
    //   855: ldc -15
    //   857: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   860: invokevirtual 254	com/gtp/go/weather/sharephoto/b/g:i	(I)V
    //   863: goto -203 -> 660
    //   866: iload 10
    //   868: istore 8
    //   870: aload 16
    //   872: aload 17
    //   874: ldc -24
    //   876: invokevirtual 160	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   879: invokevirtual 257	com/gtp/go/weather/sharephoto/b/g:l	(Ljava/lang/String;)V
    //   882: iload 10
    //   884: istore 8
    //   886: aload 16
    //   888: aload 17
    //   890: ldc -19
    //   892: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   895: invokevirtual 259	com/gtp/go/weather/sharephoto/b/g:j	(I)V
    //   898: iload 10
    //   900: istore 8
    //   902: aload 16
    //   904: aload 17
    //   906: ldc -15
    //   908: invokevirtual 167	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   911: invokevirtual 262	com/gtp/go/weather/sharephoto/b/g:k	(I)V
    //   914: goto -254 -> 660
    //   917: iload 10
    //   919: istore 8
    //   921: aload 16
    //   923: invokevirtual 264	com/gtp/go/weather/sharephoto/b/g:g	()I
    //   926: iconst_1
    //   927: if_icmpne +18 -> 945
    //   930: iload 10
    //   932: istore 8
    //   934: aload 4
    //   936: aload 16
    //   938: invokevirtual 268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   941: pop
    //   942: goto +84 -> 1026
    //   945: iload 10
    //   947: istore 8
    //   949: aload 16
    //   951: invokevirtual 264	com/gtp/go/weather/sharephoto/b/g:g	()I
    //   954: iconst_2
    //   955: if_icmpne +71 -> 1026
    //   958: iload_1
    //   959: ifne +67 -> 1026
    //   962: aload 5
    //   964: ifnull +62 -> 1026
    //   967: iload 10
    //   969: istore 8
    //   971: aload 5
    //   973: aload 16
    //   975: invokevirtual 268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   978: pop
    //   979: goto +47 -> 1026
    //   982: iload 10
    //   984: istore 8
    //   986: aload 4
    //   988: aload 16
    //   990: invokevirtual 268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   993: pop
    //   994: goto +32 -> 1026
    //   997: iload 10
    //   999: istore 8
    //   1001: ldc 83
    //   1003: ldc_w 270
    //   1006: invokestatic 65	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1009: goto +17 -> 1026
    //   1012: iload 10
    //   1014: ireturn
    //   1015: astore 17
    //   1017: goto -452 -> 565
    //   1020: iconst_0
    //   1021: istore 6
    //   1023: goto +48 -> 1071
    //   1026: iload 7
    //   1028: iconst_1
    //   1029: iadd
    //   1030: istore 7
    //   1032: goto -947 -> 85
    //   1035: iconst_0
    //   1036: istore 9
    //   1038: iload 12
    //   1040: tableswitch	default:+24->1064, 1:+-855->185, 2:+-801->239
    //   1064: iload 9
    //   1066: istore 6
    //   1068: goto -916 -> 152
    //   1071: goto -919 -> 152
    //   1074: iload 6
    //   1076: iconst_2
    //   1077: if_icmplt -80 -> 997
    //   1080: iconst_0
    //   1081: istore 9
    //   1083: goto -486 -> 597
    //   1086: iload_3
    //   1087: tableswitch	default:+25->1112, 1:+-170->917, 2:+-170->917, 3:+-105->982
    //   1112: goto -86 -> 1026
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1115	0	this	ad
    //   0	1115	1	paramInt1	int
    //   0	1115	2	paramString	String
    //   0	1115	3	paramInt2	int
    //   0	1115	4	paramArrayList1	ArrayList
    //   0	1115	5	paramArrayList2	ArrayList
    //   1	1077	6	i	int
    //   83	948	7	j	int
    //   5	995	8	k	int
    //   250	832	9	m	int
    //   26	987	10	n	int
    //   80	594	11	i1	int
    //   132	907	12	i2	int
    //   118	233	13	l	long
    //   102	507	15	localObject1	Object
    //   780	28	15	localException	Exception
    //   194	795	16	localObject2	Object
    //   521	384	17	localObject3	Object
    //   1015	1	17	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   7	16	171	org/json/JSONException
    //   20	28	171	org/json/JSONException
    //   32	57	171	org/json/JSONException
    //   61	68	171	org/json/JSONException
    //   76	82	171	org/json/JSONException
    //   96	104	171	org/json/JSONException
    //   108	120	171	org/json/JSONException
    //   124	134	171	org/json/JSONException
    //   161	168	171	org/json/JSONException
    //   189	196	171	org/json/JSONException
    //   200	210	171	org/json/JSONException
    //   214	233	171	org/json/JSONException
    //   243	250	171	org/json/JSONException
    //   258	268	171	org/json/JSONException
    //   272	291	171	org/json/JSONException
    //   301	310	171	org/json/JSONException
    //   314	320	171	org/json/JSONException
    //   335	344	171	org/json/JSONException
    //   348	355	171	org/json/JSONException
    //   359	371	171	org/json/JSONException
    //   375	387	171	org/json/JSONException
    //   391	403	171	org/json/JSONException
    //   407	419	171	org/json/JSONException
    //   423	435	171	org/json/JSONException
    //   439	451	171	org/json/JSONException
    //   455	467	171	org/json/JSONException
    //   471	478	171	org/json/JSONException
    //   482	494	171	org/json/JSONException
    //   498	510	171	org/json/JSONException
    //   514	523	171	org/json/JSONException
    //   527	535	171	org/json/JSONException
    //   539	546	171	org/json/JSONException
    //   569	578	171	org/json/JSONException
    //   587	594	171	org/json/JSONException
    //   608	617	171	org/json/JSONException
    //   621	630	171	org/json/JSONException
    //   684	691	171	org/json/JSONException
    //   698	707	171	org/json/JSONException
    //   714	720	171	org/json/JSONException
    //   733	745	171	org/json/JSONException
    //   749	761	171	org/json/JSONException
    //   765	777	171	org/json/JSONException
    //   786	793	171	org/json/JSONException
    //   797	803	171	org/json/JSONException
    //   807	812	171	org/json/JSONException
    //   819	831	171	org/json/JSONException
    //   835	847	171	org/json/JSONException
    //   851	863	171	org/json/JSONException
    //   870	882	171	org/json/JSONException
    //   886	898	171	org/json/JSONException
    //   902	914	171	org/json/JSONException
    //   921	930	171	org/json/JSONException
    //   934	942	171	org/json/JSONException
    //   949	958	171	org/json/JSONException
    //   971	979	171	org/json/JSONException
    //   986	994	171	org/json/JSONException
    //   1001	1009	171	org/json/JSONException
    //   348	355	780	java/lang/Exception
    //   359	371	780	java/lang/Exception
    //   375	387	780	java/lang/Exception
    //   391	403	780	java/lang/Exception
    //   407	419	780	java/lang/Exception
    //   423	435	780	java/lang/Exception
    //   439	451	780	java/lang/Exception
    //   455	467	780	java/lang/Exception
    //   471	478	780	java/lang/Exception
    //   482	494	780	java/lang/Exception
    //   498	510	780	java/lang/Exception
    //   514	523	780	java/lang/Exception
    //   527	535	780	java/lang/Exception
    //   539	546	780	java/lang/Exception
    //   546	565	780	java/lang/Exception
    //   569	578	780	java/lang/Exception
    //   587	594	780	java/lang/Exception
    //   608	617	780	java/lang/Exception
    //   621	630	780	java/lang/Exception
    //   733	745	780	java/lang/Exception
    //   749	761	780	java/lang/Exception
    //   765	777	780	java/lang/Exception
    //   819	831	780	java/lang/Exception
    //   835	847	780	java/lang/Exception
    //   851	863	780	java/lang/Exception
    //   870	882	780	java/lang/Exception
    //   886	898	780	java/lang/Exception
    //   902	914	780	java/lang/Exception
    //   921	930	780	java/lang/Exception
    //   934	942	780	java/lang/Exception
    //   949	958	780	java/lang/Exception
    //   971	979	780	java/lang/Exception
    //   986	994	780	java/lang/Exception
    //   1001	1009	780	java/lang/Exception
    //   546	565	1015	org/json/JSONException
  }
  
  private ContentValues a(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("photo_type", Integer.valueOf(paramg.e()));
    localContentValues.put("photo_id", Long.valueOf(paramg.a()));
    localContentValues.put("belong_page", Integer.valueOf(paramg.f()));
    localContentValues.put("image_type", Integer.valueOf(paramg.g()));
    localContentValues.put("user_id", paramg.b());
    localContentValues.put("favour", Integer.valueOf(paramg.c()));
    localContentValues.put("backcount", Integer.valueOf(paramg.d()));
    localContentValues.put("is_myfavourite", Boolean.valueOf(paramg.h()));
    localContentValues.put("city_id", paramg.i());
    localContentValues.put("city", paramg.l());
    localContentValues.put("up_time_long", Long.valueOf(paramg.j()));
    localContentValues.put("up_time_date", paramg.k());
    localContentValues.put("desc", paramg.m());
    localContentValues.put("addr", paramg.o());
    localContentValues.put("latlng", paramg.n());
    localContentValues.put("original_url", paramg.p());
    String str2 = paramg.q();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = h.a(com.gtp.go.weather.sharephoto.d.j.b, paramg.p());
      paramg.i(str1);
    }
    localContentValues.put("original_path", str1);
    localContentValues.put("original_w_h", paramg.r() + "*" + paramg.s());
    localContentValues.put("watermark_url", paramg.t());
    str2 = paramg.u();
    str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      String str3 = paramg.t();
      str1 = str2;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = h.a(com.gtp.go.weather.sharephoto.d.j.c, str3);
        paramg.k(str1);
      }
    }
    localContentValues.put("watermark_path", str1);
    localContentValues.put("watermark_w_h", paramg.v() + "*" + paramg.w());
    localContentValues.put("compose_url", paramg.x());
    str2 = paramg.y();
    str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = h.a(com.gtp.go.weather.sharephoto.d.j.a, paramg.x());
      paramg.m(str1);
    }
    localContentValues.put("compose_path", str1);
    localContentValues.put("compose_w_h", paramg.A() + "*" + paramg.B());
    return localContentValues;
  }
  
  private com.gtp.go.weather.sharephoto.b.g a(String paramString, ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gtp.go.weather.sharephoto.b.g localg = (com.gtp.go.weather.sharephoto.b.g)paramArrayList.next();
      if (paramString.equals(String.valueOf(localg.a()))) {
        return localg;
      }
    }
    return null;
  }
  
  private ArrayList a(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = "photo_type" + "=" + 3;; str = "photo_type" + "=" + 3 + " AND " + "belong_page" + "=" + paramInt) {
      return b(new String[] { "photo_id", "user_id", "photo_type", "favour", "backcount", "belong_page", "is_myfavourite", "city_id", "city", "up_time_long", "up_time_date", "desc", "addr", "latlng", "original_url", "original_path", "original_w_h", "watermark_url", "watermark_path", "watermark_w_h", "compose_url", "compose_path", "compose_w_h" }, str, null);
    }
  }
  
  private void a(ArrayList paramArrayList1, int paramInt, String paramString, ArrayList paramArrayList2)
  {
    if (paramInt == 1) {
      this.b.getContentResolver().delete(WeatherContentProvider.v, "photo_type=? and image_type=?", new String[] { String.valueOf(paramInt), String.valueOf(2) });
    }
    while ((paramArrayList2 != null) && (!paramArrayList2.isEmpty()))
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = a((com.gtp.go.weather.sharephoto.b.g)paramString.next());
        paramArrayList1.add(ContentProviderOperation.newInsert(WeatherContentProvider.v).withValues(paramArrayList2).build());
      }
      if ((paramInt == 2) && (!TextUtils.isEmpty(paramString))) {
        this.b.getContentResolver().delete(WeatherContentProvider.v, "photo_type=? and city_id=? and image_type=?", new String[] { String.valueOf(paramInt), paramString, String.valueOf(2) });
      }
    }
  }
  
  private void a(ArrayList paramArrayList1, int paramInt, String paramString, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if ((paramArrayList2 == null) || (paramArrayList2.isEmpty())) {
      return;
    }
    paramString = null;
    ContentValues localContentValues;
    Iterator localIterator1;
    if ((paramArrayList3 != null) && (!paramArrayList3.isEmpty()))
    {
      localContentValues = new ContentValues();
      localIterator1 = paramArrayList2.iterator();
    }
    label45:
    label170:
    label196:
    label512:
    label522:
    for (;;)
    {
      paramArrayList2 = paramString;
      com.gtp.go.weather.sharephoto.b.g localg;
      int i;
      if (localIterator1.hasNext())
      {
        paramArrayList2 = (com.gtp.go.weather.sharephoto.b.g)localIterator1.next();
        long l = paramArrayList2.a();
        if (l != 0L)
        {
          Iterator localIterator2 = paramArrayList3.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localg = (com.gtp.go.weather.sharephoto.b.g)localIterator2.next();
              if (localg.a() == l)
              {
                localContentValues.clear();
                if (localg.h() != paramArrayList2.h())
                {
                  paramArrayList2.a(localg.h());
                  int j = paramArrayList2.c();
                  if (paramArrayList2.h())
                  {
                    i = 1;
                    i += j;
                    localContentValues.put("favour", Integer.valueOf(i));
                    paramArrayList2.a(i);
                    if (localg.d() != paramArrayList2.d())
                    {
                      localContentValues.put("backcount", Integer.valueOf(paramArrayList2.d()));
                      paramArrayList2.b(paramArrayList2.d());
                    }
                    if (localg.f() != paramArrayList2.f())
                    {
                      localContentValues.put("belong_page", Integer.valueOf(paramArrayList2.f()));
                      paramArrayList2.d(paramArrayList2.f());
                    }
                    if (localContentValues.size() <= 0) {
                      break label512;
                    }
                    paramArrayList1.add(ContentProviderOperation.newUpdate(WeatherContentProvider.v).withValues(localContentValues).withSelection("photo_id=? and image_type=?", new String[] { String.valueOf(paramArrayList2.a()), String.valueOf(1) }).build());
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i != 0) {
            break label522;
          }
          if (paramString == null) {
            paramString = new ArrayList();
          }
          for (;;)
          {
            paramString.add(paramArrayList2);
            break label45;
            i = -1;
            break label170;
            if (localg.c() == paramArrayList2.c()) {
              break label196;
            }
            localContentValues.put("favour", Integer.valueOf(paramArrayList2.c()));
            paramArrayList2.a(paramArrayList2.c());
            break label196;
            if (paramArrayList2 == null) {
              break;
            }
            paramString = paramArrayList2.iterator();
            while (paramString.hasNext())
            {
              paramArrayList3 = a((com.gtp.go.weather.sharephoto.b.g)paramString.next());
              paramArrayList1.add(ContentProviderOperation.newInsert(WeatherContentProvider.v).withValues(paramArrayList3).build());
            }
            com.gtp.a.a.b.c.a("photo", "类型是" + paramInt + "的新图片有" + paramArrayList2.size() + "张");
            return;
          }
          i = 1;
          continue;
          i = 0;
        }
      }
    }
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList2 == null) || (paramArrayList2.isEmpty()) || (paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return;
    }
    paramArrayList1 = paramArrayList1.iterator();
    label28:
    com.gtp.go.weather.sharephoto.b.g localg1;
    int j;
    for (;;)
    {
      if (paramArrayList1.hasNext())
      {
        localg1 = (com.gtp.go.weather.sharephoto.b.g)paramArrayList1.next();
        Object localObject = paramArrayList2.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.gtp.go.weather.sharephoto.b.g localg2 = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject).next();
          if ((localg2 == null) || (localg1 == null) || (localg2.a() != localg1.a())) {
            break;
          }
          if (localg2.p().equals(localg1.p()))
          {
            localObject = localg2.q();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
            {
              localg1.i((String)localObject);
              localg1.b(true);
            }
          }
          if (localg2.t().equals(localg1.t()))
          {
            localObject = localg2.u();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
            {
              localg1.k((String)localObject);
              localg1.c(true);
            }
          }
          if (localg2.x().equals(localg1.x()))
          {
            localObject = localg2.y();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
            {
              localg1.m((String)localObject);
              localg1.d(true);
            }
          }
          if (localg1.h() != localg2.h())
          {
            localg1.a(localg2.h());
            j = localg1.c();
            if (!localg1.h()) {
              break label329;
            }
          }
        }
      }
    }
    label329:
    for (int i = 1;; i = -1)
    {
      localg1.a(i + j);
      break label28;
      break;
    }
  }
  
  private void a(ArrayList paramArrayList, HashMap paramHashMap)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gtp.go.weather.sharephoto.b.g localg = (com.gtp.go.weather.sharephoto.b.g)paramArrayList.next();
      com.gtp.go.weather.sharephoto.b.j localj = (com.gtp.go.weather.sharephoto.b.j)paramHashMap.get(Long.valueOf(localg.a()));
      if (localj != null)
      {
        int i;
        if (localg.h())
        {
          i = 1;
          label57:
          if (i == localj.c()) {
            break label109;
          }
          if (localj.c() != 1) {
            break label111;
          }
        }
        label109:
        label111:
        for (boolean bool = true;; bool = false)
        {
          localg.a(bool);
          i = localg.c();
          localg.a(localj.c() + i);
          break;
          i = -1;
          break label57;
          break;
        }
      }
    }
  }
  
  private boolean a(ak paramak)
  {
    Object localObject = f.a(this.b);
    String str = com.gtp.go.weather.sharephoto.a.g.a(this.b).b().a();
    localObject = ((JSONObject)localObject).toString();
    str = ac.a(this.b, "http://gows.goforandroid.com/goweatherexSns/image/userImageIssued", (String)localObject, str, null, paramak.b);
    if (!TextUtils.isEmpty(str))
    {
      localObject = new ArrayList();
      paramak.a = a(paramak.b, str, 3, (ArrayList)localObject, null);
      if ((!((ArrayList)localObject).isEmpty()) && (paramak.a != -1))
      {
        a((ArrayList)localObject, a(new String[] { "photo_id", "data_type", "data_value" }, "data_type=1", null));
        e((ArrayList)localObject);
        return true;
      }
      return false;
    }
    return false;
  }
  
  private void b()
  {
    this.b.getContentResolver().delete(WeatherContentProvider.v, "photo_type=? or photo_type=?", new String[] { String.valueOf(1), String.valueOf(2) });
  }
  
  private void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (com.gtp.go.weather.sharephoto.b.g)paramArrayList.next();
        if (!((com.gtp.go.weather.sharephoto.b.g)localObject).z())
        {
          com.gtp.a.a.b.c.a("photo_download", "=================》开始下载图片");
          localObject = new com.jiubang.core.c.a.a(((com.gtp.go.weather.sharephoto.b.g)localObject).x(), a, b.a(((com.gtp.go.weather.sharephoto.b.g)localObject).x()) + ".png");
          this.e.a((com.jiubang.core.c.a.a)localObject);
        }
      }
    }
  }
  
  private int c(ArrayList paramArrayList)
  {
    int j;
    if (paramArrayList.isEmpty())
    {
      j = 1;
      return j;
    }
    paramArrayList = paramArrayList.iterator();
    for (int i = Integer.MAX_VALUE;; i = Math.min(i, ((com.gtp.go.weather.sharephoto.b.g)paramArrayList.next()).f()))
    {
      j = i;
      if (!paramArrayList.hasNext()) {
        break;
      }
    }
  }
  
  private List c()
  {
    return d.a(this.b);
  }
  
  private HashSet d(ArrayList paramArrayList)
  {
    HashSet localHashSet = new HashSet();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localHashSet.add(Integer.valueOf(((com.gtp.go.weather.sharephoto.b.g)paramArrayList.next()).f()));
    }
    return localHashSet;
  }
  
  private boolean d()
  {
    long l = GoWidgetApplication.c(this.b.getApplicationContext()).a().getLong("key_check_delete_overtime_photo", 0L);
    l = System.currentTimeMillis() - l;
    return (l <= 0L) || (l >= 43200000L);
  }
  
  private void e(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (!paramArrayList.isEmpty())
    {
      localObject = d(paramArrayList);
      Integer[] arrayOfInteger = (Integer[])((HashSet)localObject).toArray(new Integer[2]);
      if (((HashSet)localObject).size() == 1) {
        localObject = ContentProviderOperation.newDelete(WeatherContentProvider.v).withSelection("photo_type=? AND belong_page=?", new String[] { String.valueOf(3), String.valueOf(arrayOfInteger[0]) });
      }
    }
    for (;;)
    {
      localArrayList.add(((ContentProviderOperation.Builder)localObject).build());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = a((com.gtp.go.weather.sharephoto.b.g)paramArrayList.next());
        localArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.v).withValues((ContentValues)localObject).build());
      }
      localObject = ContentProviderOperation.newDelete(WeatherContentProvider.v).withSelection("photo_type=?", new String[] { String.valueOf(3) });
      continue;
      localObject = ContentProviderOperation.newDelete(WeatherContentProvider.v).withSelection("photo_type = ?", new String[] { String.valueOf(3) });
    }
    try
    {
      this.b.getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
      return;
    }
    catch (Exception paramArrayList)
    {
      while (!com.gtp.a.a.b.c.a()) {}
      paramArrayList.printStackTrace();
    }
  }
  
  private void f(ArrayList paramArrayList)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(h.a + "compose");
    int k;
    int i;
    Object localObject2;
    Iterator localIterator1;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      localObject1 = ((File)localObject1).listFiles();
      k = localObject1.length;
      i = 0;
      if (i < k)
      {
        localObject2 = localObject1[i];
        if ((localObject2 != null) && (((File)localObject2).exists()) && (l - ((File)localObject2).lastModified() > 172800000L))
        {
          localIterator1 = paramArrayList.iterator();
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
          } while (!((com.gtp.go.weather.sharephoto.b.g)localIterator1.next()).y().equals(((File)localObject2).toString()));
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        com.gtp.a.a.b.c.a("delete_photos", "1、删除缩略图的名字为 " + ((File)localObject2).getName());
        ((File)localObject2).delete();
      }
      i += 1;
      break;
      localObject1 = b(new String[] { "original_path", "watermark_path" }, "photo_type=?", new String[] { String.valueOf(3) });
      localObject2 = new File(h.a + "original");
      int m;
      Iterator localIterator2;
      if ((localObject2 != null) && (((File)localObject2).exists()))
      {
        localObject2 = ((File)localObject2).listFiles();
        m = localObject2.length;
        j = 0;
        if (j < m)
        {
          localIterator1 = localObject2[j];
          if ((localIterator1 != null) && (localIterator1.exists()) && (l - localIterator1.lastModified() > 172800000L))
          {
            k = 0;
            localIterator2 = paramArrayList.iterator();
            do
            {
              i = k;
              if (!localIterator2.hasNext()) {
                break;
              }
            } while (!((com.gtp.go.weather.sharephoto.b.g)localIterator2.next()).q().equals(localIterator1.toString()));
            i = 1;
            if ((i != 0) || (((ArrayList)localObject1).isEmpty())) {
              break label758;
            }
            localIterator2 = ((ArrayList)localObject1).iterator();
            while (localIterator2.hasNext()) {
              if (((com.gtp.go.weather.sharephoto.b.g)localIterator2.next()).q().equals(localIterator1.toString())) {
                i = 1;
              }
            }
          }
        }
      }
      label755:
      label758:
      for (;;)
      {
        if (i == 0)
        {
          com.gtp.a.a.b.c.a("delete_photos", "2、删除原图的名字为 " + localIterator1.getName());
          localIterator1.delete();
        }
        j += 1;
        break;
        localObject2 = new File(h.a + "watermark");
        if ((localObject2 != null) && (((File)localObject2).exists()))
        {
          localObject2 = ((File)localObject2).listFiles();
          m = localObject2.length;
          j = 0;
          if (j < m)
          {
            localIterator1 = localObject2[j];
            if ((localIterator1 != null) && (localIterator1.exists()) && (l - localIterator1.lastModified() > 172800000L))
            {
              k = 0;
              localIterator2 = paramArrayList.iterator();
              do
              {
                i = k;
                if (!localIterator2.hasNext()) {
                  break;
                }
              } while (!((com.gtp.go.weather.sharephoto.b.g)localIterator2.next()).u().equals(localIterator1.toString()));
              i = 1;
              if ((i != 0) || (((ArrayList)localObject1).isEmpty())) {
                break label755;
              }
              localIterator2 = ((ArrayList)localObject1).iterator();
              while (localIterator2.hasNext()) {
                if (((com.gtp.go.weather.sharephoto.b.g)localIterator2.next()).u().equals(localIterator1.toString())) {
                  i = 1;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (i == 0)
          {
            com.gtp.a.a.b.c.a("delete_photos", "3、删除水印图的名字为 " + localIterator1.getName());
            localIterator1.delete();
          }
          j += 1;
          break;
          GoWidgetApplication.c(this.b.getApplicationContext()).a().edit().putLong("key_check_delete_overtime_photo", l).commit();
          return;
        }
      }
    }
  }
  
  public HashMap a(String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    HashMap localHashMap = new HashMap();
    paramArrayOfString1 = this.b.getContentResolver().query(WeatherContentProvider.x, paramArrayOfString1, paramString, paramArrayOfString2, null);
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.moveToFirst()))
    {
      int j = paramArrayOfString1.getColumnCount();
      do
      {
        paramString = new com.gtp.go.weather.sharephoto.b.j();
        int i = 0;
        if (i < j)
        {
          paramArrayOfString2 = paramArrayOfString1.getColumnName(i);
          if (paramArrayOfString2.equals("photo_id")) {
            paramString.a(paramArrayOfString1.getLong(i));
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramArrayOfString2.equals("data_type")) {
              paramString.a(paramArrayOfString1.getInt(i));
            } else if (paramArrayOfString2.equals("data_value")) {
              paramString.b(paramArrayOfString1.getInt(i));
            } else if (paramArrayOfString2.equals("user_id")) {
              paramString.a(paramArrayOfString1.getString(i));
            } else if (paramArrayOfString2.equals("city_id")) {
              paramString.b(paramArrayOfString1.getString(i));
            }
          }
        }
        localHashMap.put(Long.valueOf(paramString.a()), paramString);
      } while (paramArrayOfString1.moveToNext());
      if (paramArrayOfString1 == null) {}
    }
    try
    {
      paramArrayOfString1.close();
      return localHashMap;
    }
    catch (Exception paramArrayOfString1)
    {
      paramArrayOfString1.printStackTrace();
    }
    return localHashMap;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList)
  {
    new ai(this, paramInt1, paramInt2, paramString).execute(new ArrayList[] { paramArrayList });
  }
  
  public void a(int paramInt, aj paramaj)
  {
    if (paramaj != null)
    {
      am localam = (am)g.get(paramInt);
      if (localam != null) {
        am.a(localam, paramaj);
      }
    }
    else
    {
      return;
    }
    paramaj = new am(this, paramaj);
    g.put(paramInt, paramaj);
    paramaj.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, String paramString)
  {
    a(false, paramInt, paramString);
  }
  
  public void a(long paramLong, a parama)
  {
    if (paramLong != -1L)
    {
      new ae(this, parama, paramLong).execute(new Long[] { Long.valueOf(paramLong) });
      return;
    }
    parama.a(Long.valueOf(paramLong), null);
  }
  
  public void a(Activity paramActivity, long paramLong)
  {
    new ag(this, paramActivity.getContentResolver(), paramLong).execute(new Void[0]);
  }
  
  public void a(ah paramah)
  {
    this.f = paramah;
  }
  
  public void a(b paramb)
  {
    this.e = paramb;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    File localFile = new File(com.gtp.a.a.c.c.a() + File.separator + "sharephoto");
    if (localFile.exists())
    {
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfString[i];
          com.gtp.go.weather.sharephoto.b.g localg = a((String)localObject, paramArrayList);
          if (localg != null)
          {
            localObject = new File(localFile, (String)localObject);
            h.a(h.a(localg.a()), localg.y());
            h.a(h.b(localg.a()), localg.q());
            String str = localg.u();
            if (!TextUtils.isEmpty(str)) {
              h.a(h.c(localg.a()), str);
            }
            r.a((File)localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    new al(this, paramBoolean, paramInt, paramString).execute(new Object[0]);
  }
  
  public ArrayList b(String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfString1 = this.b.getContentResolver().query(WeatherContentProvider.v, paramArrayOfString1, paramString, paramArrayOfString2, null);
    if (paramArrayOfString1 != null) {
      if (paramArrayOfString1.moveToFirst())
      {
        int j = paramArrayOfString1.getColumnCount();
        paramString = new com.gtp.go.weather.sharephoto.b.g();
        i = 0;
        if (i < j)
        {
          paramArrayOfString2 = paramArrayOfString1.getColumnName(i);
          if (paramArrayOfString2.equals("photo_id")) {
            paramString.a(paramArrayOfString1.getLong(i));
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramArrayOfString2.equals("user_id"))
            {
              paramString.a(paramArrayOfString1.getString(i));
            }
            else if (paramArrayOfString2.equals("photo_type"))
            {
              paramString.c(paramArrayOfString1.getInt(i));
            }
            else if (paramArrayOfString2.equals("belong_page"))
            {
              paramString.d(paramArrayOfString1.getInt(i));
            }
            else if (paramArrayOfString2.equals("image_type"))
            {
              paramString.e(paramArrayOfString1.getInt(i));
            }
            else if (paramArrayOfString2.equals("favour"))
            {
              paramString.a(paramArrayOfString1.getInt(i));
            }
            else if (paramArrayOfString2.equals("backcount"))
            {
              paramString.b(paramArrayOfString1.getInt(i));
            }
            else
            {
              if (paramArrayOfString2.equals("is_myfavourite"))
              {
                if (paramArrayOfString1.getInt(i) == 1) {}
                for (boolean bool = true;; bool = false)
                {
                  paramString.a(bool);
                  break;
                }
              }
              if (paramArrayOfString2.equals("city_id"))
              {
                paramString.b(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("city"))
              {
                paramString.d(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("up_time_long"))
              {
                paramString.b(paramArrayOfString1.getLong(i));
              }
              else if (paramArrayOfString2.equals("up_time_date"))
              {
                paramString.c(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("desc"))
              {
                paramString.e(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("addr"))
              {
                paramString.g(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("latlng"))
              {
                paramString.f(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("original_url"))
              {
                paramString.h(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("original_path"))
              {
                paramString.i(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("original_w_h"))
              {
                paramArrayOfString2 = paramArrayOfString1.getString(i);
                if ((!TextUtils.isEmpty(paramArrayOfString2)) && (paramArrayOfString2.contains("*")))
                {
                  paramArrayOfString2 = paramArrayOfString2.split("\\*");
                  try
                  {
                    paramString.f(Integer.valueOf(paramArrayOfString2[0]).intValue());
                    paramString.g(Integer.valueOf(paramArrayOfString2[1]).intValue());
                  }
                  catch (Exception paramArrayOfString2) {}
                }
              }
              else if (paramArrayOfString2.equals("watermark_url"))
              {
                paramString.j(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("watermark_path"))
              {
                paramString.k(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("watermark_w_h"))
              {
                paramArrayOfString2 = paramArrayOfString1.getString(i);
                if ((!TextUtils.isEmpty(paramArrayOfString2)) && (paramArrayOfString2.contains("*")))
                {
                  paramArrayOfString2 = paramArrayOfString2.split("[*]");
                  try
                  {
                    paramString.h(Integer.valueOf(paramArrayOfString2[0]).intValue());
                    paramString.i(Integer.valueOf(paramArrayOfString2[1]).intValue());
                  }
                  catch (Exception paramArrayOfString2) {}
                }
              }
              else if (paramArrayOfString2.equals("compose_url"))
              {
                paramString.l(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("compose_path"))
              {
                paramString.m(paramArrayOfString1.getString(i));
              }
              else if (paramArrayOfString2.equals("compose_w_h"))
              {
                paramArrayOfString2 = paramArrayOfString1.getString(i);
                if ((!TextUtils.isEmpty(paramArrayOfString2)) && (paramArrayOfString2.contains("*")))
                {
                  paramArrayOfString2 = paramArrayOfString2.split("\\*");
                  try
                  {
                    paramString.j(Integer.valueOf(paramArrayOfString2[0]).intValue());
                    paramString.k(Integer.valueOf(paramArrayOfString2[1]).intValue());
                  }
                  catch (Exception paramArrayOfString2) {}
                }
              }
            }
          }
        }
        paramArrayOfString2 = localArrayList.iterator();
        com.gtp.go.weather.sharephoto.b.g localg;
        do
        {
          if (!paramArrayOfString2.hasNext()) {
            break;
          }
          localg = (com.gtp.go.weather.sharephoto.b.g)paramArrayOfString2.next();
        } while ((localg.a() != paramString.a()) || (localg.e() != paramString.e()));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if ((!TextUtils.isEmpty(paramString.q())) && (new File(paramString.q()).exists())) {
          paramString.b(true);
        }
        if ((!TextUtils.isEmpty(paramString.u())) && (new File(paramString.u()).exists())) {
          paramString.c(true);
        }
        if ((!TextUtils.isEmpty(paramString.y())) && (new File(paramString.y()).exists())) {
          paramString.d(true);
        }
        localArrayList.add(paramString);
      }
      while (!paramArrayOfString1.moveToNext())
      {
        try
        {
          paramArrayOfString1.close();
          return localArrayList;
        }
        catch (Exception paramArrayOfString1)
        {
          paramArrayOfString1.printStackTrace();
          return localArrayList;
        }
        com.gtp.a.a.b.c.a("photo", "疑似出现图片重复数据！");
      }
      break;
    }
  }
  
  public void b(long paramLong, a parama)
  {
    new af(this, paramLong, parama).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */