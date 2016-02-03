package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.d.f;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import com.gtp.a.a.b.c;
import com.jiubang.core.b.a;
import java.io.IOException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class x
{
  private static x d;
  private Context a;
  private String b = null;
  private SharedPreferences c;
  private boolean e = false;
  private boolean f = false;
  
  private x(Context paramContext)
  {
    this.a = paramContext;
    this.b = d.a(this.a).d();
    if (TextUtils.isEmpty(this.b)) {
      this.b = "en";
    }
    this.c = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
  }
  
  /* Error */
  private android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 12
    //   9: new 77	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 78	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_0
    //   19: aload 6
    //   21: aload_1
    //   22: invokespecial 81	com/gau/go/launcherex/gowidget/weather/b/x:a	(Ljava/util/List;Ljava/lang/String;)V
    //   25: new 83	org/apache/http/client/methods/HttpPost
    //   28: dup
    //   29: ldc 85
    //   31: invokespecial 88	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   34: astore 5
    //   36: aload 5
    //   38: new 90	org/apache/http/client/entity/UrlEncodedFormEntity
    //   41: dup
    //   42: aload 6
    //   44: ldc 92
    //   46: invokespecial 94	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   49: invokevirtual 100	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   52: new 102	org/apache/http/impl/client/DefaultHttpClient
    //   55: dup
    //   56: invokespecial 103	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   59: astore 7
    //   61: aload 7
    //   63: aload 5
    //   65: invokevirtual 107	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   68: astore 6
    //   70: aload 6
    //   72: invokeinterface 113 1 0
    //   77: invokeinterface 119 1 0
    //   82: sipush 200
    //   85: if_icmpne +698 -> 783
    //   88: new 121	java/io/DataInputStream
    //   91: dup
    //   92: aload 6
    //   94: invokeinterface 125 1 0
    //   99: invokeinterface 131 1 0
    //   104: invokespecial 134	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 5
    //   109: aload 5
    //   111: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   114: pop
    //   115: aload 5
    //   117: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   120: pop
    //   121: aload 5
    //   123: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   126: istore_2
    //   127: iload_2
    //   128: ifne +74 -> 202
    //   131: aload 5
    //   133: ifnull +8 -> 141
    //   136: aload 5
    //   138: invokevirtual 140	java/io/DataInputStream:close	()V
    //   141: iconst_0
    //   142: ifeq +11 -> 153
    //   145: new 142	java/lang/NullPointerException
    //   148: dup
    //   149: invokespecial 143	java/lang/NullPointerException:<init>	()V
    //   152: athrow
    //   153: aload 6
    //   155: ifnull +15 -> 170
    //   158: aload 6
    //   160: invokeinterface 125 1 0
    //   165: invokeinterface 146 1 0
    //   170: aload 13
    //   172: astore 4
    //   174: aload 7
    //   176: ifnull +23 -> 199
    //   179: aload 7
    //   181: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   184: astore 4
    //   186: aload 12
    //   188: astore_1
    //   189: aload 4
    //   191: invokeinterface 155 1 0
    //   196: aload_1
    //   197: astore 4
    //   199: aload 4
    //   201: areturn
    //   202: aload 5
    //   204: invokevirtual 158	java/io/DataInputStream:readLong	()J
    //   207: pop2
    //   208: aload 5
    //   210: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   213: istore_2
    //   214: iload_2
    //   215: ifle +555 -> 770
    //   218: aload 5
    //   220: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   223: aload_1
    //   224: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +263 -> 490
    //   230: aload 5
    //   232: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   235: istore_3
    //   236: new 169	java/io/ByteArrayOutputStream
    //   239: dup
    //   240: invokespecial 170	java/io/ByteArrayOutputStream:<init>	()V
    //   243: astore_1
    //   244: aload 6
    //   246: astore 11
    //   248: aload 7
    //   250: astore 10
    //   252: aload_1
    //   253: astore 9
    //   255: aload 5
    //   257: astore 8
    //   259: sipush 1024
    //   262: newarray <illegal type>
    //   264: astore 4
    //   266: aload 6
    //   268: astore 11
    //   270: aload 7
    //   272: astore 10
    //   274: aload_1
    //   275: astore 9
    //   277: aload 5
    //   279: astore 8
    //   281: aload 5
    //   283: aload 4
    //   285: invokevirtual 174	java/io/DataInputStream:read	([B)I
    //   288: istore_2
    //   289: iload_2
    //   290: iconst_m1
    //   291: if_icmpeq +108 -> 399
    //   294: aload 6
    //   296: astore 11
    //   298: aload 7
    //   300: astore 10
    //   302: aload_1
    //   303: astore 9
    //   305: aload 5
    //   307: astore 8
    //   309: aload_1
    //   310: aload 4
    //   312: iconst_0
    //   313: iload_2
    //   314: invokevirtual 178	java/io/ByteArrayOutputStream:write	([BII)V
    //   317: goto -51 -> 266
    //   320: astore 4
    //   322: aload 6
    //   324: astore 11
    //   326: aload 7
    //   328: astore 10
    //   330: aload_1
    //   331: astore 9
    //   333: aload 5
    //   335: astore 8
    //   337: aload 4
    //   339: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   342: aload 5
    //   344: ifnull +8 -> 352
    //   347: aload 5
    //   349: invokevirtual 140	java/io/DataInputStream:close	()V
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   360: aload 6
    //   362: ifnull +15 -> 377
    //   365: aload 6
    //   367: invokeinterface 125 1 0
    //   372: invokeinterface 146 1 0
    //   377: aload 13
    //   379: astore 4
    //   381: aload 7
    //   383: ifnull -184 -> 199
    //   386: aload 7
    //   388: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   391: astore 4
    //   393: aload 12
    //   395: astore_1
    //   396: goto -207 -> 189
    //   399: aload 6
    //   401: astore 11
    //   403: aload 7
    //   405: astore 10
    //   407: aload_1
    //   408: astore 9
    //   410: aload 5
    //   412: astore 8
    //   414: aload_1
    //   415: invokevirtual 186	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   418: iconst_0
    //   419: iload_3
    //   420: invokestatic 192	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   423: astore 4
    //   425: aload 4
    //   427: astore 8
    //   429: aload_1
    //   430: astore 4
    //   432: aload 8
    //   434: astore_1
    //   435: aload 5
    //   437: ifnull +8 -> 445
    //   440: aload 5
    //   442: invokevirtual 140	java/io/DataInputStream:close	()V
    //   445: aload 4
    //   447: ifnull +8 -> 455
    //   450: aload 4
    //   452: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   455: aload 6
    //   457: ifnull +15 -> 472
    //   460: aload 6
    //   462: invokeinterface 125 1 0
    //   467: invokeinterface 146 1 0
    //   472: aload_1
    //   473: astore 4
    //   475: aload 7
    //   477: ifnull -278 -> 199
    //   480: aload 7
    //   482: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   485: astore 4
    //   487: goto -298 -> 189
    //   490: iload_2
    //   491: iconst_1
    //   492: isub
    //   493: istore_2
    //   494: goto -280 -> 214
    //   497: astore 4
    //   499: aload 4
    //   501: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   504: aload 7
    //   506: ifnull +13 -> 519
    //   509: aload 7
    //   511: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   514: invokeinterface 155 1 0
    //   519: aload_1
    //   520: athrow
    //   521: astore_1
    //   522: aconst_null
    //   523: astore 6
    //   525: aconst_null
    //   526: astore 7
    //   528: aconst_null
    //   529: astore 4
    //   531: aconst_null
    //   532: astore 5
    //   534: aload 5
    //   536: ifnull +8 -> 544
    //   539: aload 5
    //   541: invokevirtual 140	java/io/DataInputStream:close	()V
    //   544: aload 4
    //   546: ifnull +8 -> 554
    //   549: aload 4
    //   551: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   554: aload 6
    //   556: ifnull -52 -> 504
    //   559: aload 6
    //   561: invokeinterface 125 1 0
    //   566: invokeinterface 146 1 0
    //   571: goto -67 -> 504
    //   574: astore 5
    //   576: aload 5
    //   578: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   581: goto -37 -> 544
    //   584: astore 4
    //   586: aload 4
    //   588: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   591: goto -37 -> 554
    //   594: astore 4
    //   596: aload 4
    //   598: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   601: goto -249 -> 352
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   609: goto -249 -> 360
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   617: goto -240 -> 377
    //   620: astore_1
    //   621: aload_1
    //   622: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   625: goto -484 -> 141
    //   628: astore_1
    //   629: aload_1
    //   630: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   633: goto -480 -> 153
    //   636: astore_1
    //   637: aload_1
    //   638: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   641: goto -471 -> 170
    //   644: astore 5
    //   646: aload 5
    //   648: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   651: goto -206 -> 445
    //   654: astore 4
    //   656: aload 4
    //   658: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   661: goto -206 -> 455
    //   664: astore 4
    //   666: aload 4
    //   668: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   671: goto -199 -> 472
    //   674: astore_1
    //   675: aconst_null
    //   676: astore 6
    //   678: aconst_null
    //   679: astore 4
    //   681: aconst_null
    //   682: astore 5
    //   684: goto -150 -> 534
    //   687: astore_1
    //   688: aconst_null
    //   689: astore 4
    //   691: aconst_null
    //   692: astore 5
    //   694: goto -160 -> 534
    //   697: astore_1
    //   698: aconst_null
    //   699: astore 4
    //   701: goto -167 -> 534
    //   704: astore_1
    //   705: aload 11
    //   707: astore 6
    //   709: aload 10
    //   711: astore 7
    //   713: aload 9
    //   715: astore 4
    //   717: aload 8
    //   719: astore 5
    //   721: goto -187 -> 534
    //   724: astore 4
    //   726: aconst_null
    //   727: astore 6
    //   729: aconst_null
    //   730: astore 7
    //   732: aconst_null
    //   733: astore_1
    //   734: aconst_null
    //   735: astore 5
    //   737: goto -415 -> 322
    //   740: astore 4
    //   742: aconst_null
    //   743: astore 6
    //   745: aconst_null
    //   746: astore_1
    //   747: aconst_null
    //   748: astore 5
    //   750: goto -428 -> 322
    //   753: astore 4
    //   755: aconst_null
    //   756: astore_1
    //   757: aconst_null
    //   758: astore 5
    //   760: goto -438 -> 322
    //   763: astore 4
    //   765: aconst_null
    //   766: astore_1
    //   767: goto -445 -> 322
    //   770: aconst_null
    //   771: astore 8
    //   773: aload 4
    //   775: astore_1
    //   776: aload 8
    //   778: astore 4
    //   780: goto -345 -> 435
    //   783: aconst_null
    //   784: astore 8
    //   786: aconst_null
    //   787: astore 5
    //   789: aload 4
    //   791: astore_1
    //   792: aload 8
    //   794: astore 4
    //   796: goto -361 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	x
    //   0	799	1	paramString	String
    //   126	368	2	i	int
    //   235	185	3	j	int
    //   4	307	4	localObject1	Object
    //   320	18	4	localException1	Exception
    //   379	107	4	localObject2	Object
    //   497	3	4	localIOException1	IOException
    //   529	21	4	localObject3	Object
    //   584	3	4	localIOException2	IOException
    //   594	3	4	localIOException3	IOException
    //   654	3	4	localIOException4	IOException
    //   664	3	4	localIOException5	IOException
    //   679	37	4	localObject4	Object
    //   724	1	4	localException2	Exception
    //   740	1	4	localException3	Exception
    //   753	1	4	localException4	Exception
    //   763	11	4	localException5	Exception
    //   778	17	4	localObject5	Object
    //   34	506	5	localObject6	Object
    //   574	3	5	localIOException6	IOException
    //   644	3	5	localIOException7	IOException
    //   682	106	5	localObject7	Object
    //   16	728	6	localObject8	Object
    //   59	672	7	localObject9	Object
    //   257	536	8	localObject10	Object
    //   253	461	9	str	String
    //   250	460	10	localObject11	Object
    //   246	460	11	localObject12	Object
    //   7	387	12	localObject13	Object
    //   1	377	13	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   259	266	320	java/lang/Exception
    //   281	289	320	java/lang/Exception
    //   309	317	320	java/lang/Exception
    //   414	425	320	java/lang/Exception
    //   559	571	497	java/io/IOException
    //   25	61	521	finally
    //   539	544	574	java/io/IOException
    //   549	554	584	java/io/IOException
    //   347	352	594	java/io/IOException
    //   356	360	604	java/io/IOException
    //   365	377	612	java/io/IOException
    //   136	141	620	java/io/IOException
    //   145	153	628	java/io/IOException
    //   158	170	636	java/io/IOException
    //   440	445	644	java/io/IOException
    //   450	455	654	java/io/IOException
    //   460	472	664	java/io/IOException
    //   61	70	674	finally
    //   70	109	687	finally
    //   109	127	697	finally
    //   202	214	697	finally
    //   218	244	697	finally
    //   259	266	704	finally
    //   281	289	704	finally
    //   309	317	704	finally
    //   337	342	704	finally
    //   414	425	704	finally
    //   25	61	724	java/lang/Exception
    //   61	70	740	java/lang/Exception
    //   70	109	753	java/lang/Exception
    //   109	127	763	java/lang/Exception
    //   202	214	763	java/lang/Exception
    //   218	244	763	java/lang/Exception
  }
  
  public static x a(Context paramContext)
  {
    if (d == null) {
      d = new x(paramContext);
    }
    return d;
  }
  
  /* Error */
  private java.util.ArrayList a(List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 11
    //   12: new 83	org/apache/http/client/methods/HttpPost
    //   15: dup
    //   16: ldc 85
    //   18: invokespecial 88	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload 5
    //   25: new 90	org/apache/http/client/entity/UrlEncodedFormEntity
    //   28: dup
    //   29: aload_1
    //   30: ldc 92
    //   32: invokespecial 94	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   35: invokevirtual 100	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   38: new 102	org/apache/http/impl/client/DefaultHttpClient
    //   41: dup
    //   42: invokespecial 103	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   45: astore 7
    //   47: aload 7
    //   49: aload 5
    //   51: invokevirtual 107	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   54: astore 5
    //   56: aload 5
    //   58: invokeinterface 113 1 0
    //   63: invokeinterface 119 1 0
    //   68: sipush 200
    //   71: if_icmpne +1219 -> 1290
    //   74: new 121	java/io/DataInputStream
    //   77: dup
    //   78: aload 5
    //   80: invokeinterface 125 1 0
    //   85: invokeinterface 131 1 0
    //   90: invokespecial 134	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore 4
    //   95: aload 5
    //   97: astore 8
    //   99: aload 7
    //   101: astore 9
    //   103: aload 4
    //   105: astore 10
    //   107: new 201	com/gau/go/launcherex/gowidget/weather/model/u
    //   110: dup
    //   111: invokespecial 202	com/gau/go/launcherex/gowidget/weather/model/u:<init>	()V
    //   114: astore 13
    //   116: aload 5
    //   118: astore 8
    //   120: aload 7
    //   122: astore 9
    //   124: aload 4
    //   126: astore 10
    //   128: aload 4
    //   130: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   133: pop
    //   134: aload 5
    //   136: astore 8
    //   138: aload 7
    //   140: astore 9
    //   142: aload 4
    //   144: astore 10
    //   146: aload 13
    //   148: aload 4
    //   150: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   153: invokevirtual 205	com/gau/go/launcherex/gowidget/weather/model/u:a	(I)V
    //   156: aload 5
    //   158: astore 8
    //   160: aload 7
    //   162: astore 9
    //   164: aload 4
    //   166: astore 10
    //   168: aload 13
    //   170: aload 4
    //   172: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   175: invokevirtual 207	com/gau/go/launcherex/gowidget/weather/model/u:b	(I)V
    //   178: aload 5
    //   180: astore 8
    //   182: aload 7
    //   184: astore 9
    //   186: aload 4
    //   188: astore 10
    //   190: aload 13
    //   192: invokevirtual 209	com/gau/go/launcherex/gowidget/weather/model/u:a	()I
    //   195: ifne +79 -> 274
    //   198: aload 5
    //   200: astore 8
    //   202: aload 7
    //   204: astore 9
    //   206: aload 4
    //   208: astore 10
    //   210: aload_0
    //   211: iconst_1
    //   212: putfield 26	com/gau/go/launcherex/gowidget/weather/b/x:f	Z
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 140	java/io/DataInputStream:close	()V
    //   225: aload 5
    //   227: ifnull +15 -> 242
    //   230: aload 5
    //   232: invokeinterface 125 1 0
    //   237: invokeinterface 146 1 0
    //   242: aload 12
    //   244: astore 4
    //   246: aload 7
    //   248: ifnull +23 -> 271
    //   251: aload 7
    //   253: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   256: astore 4
    //   258: aload 11
    //   260: astore_1
    //   261: aload 4
    //   263: invokeinterface 155 1 0
    //   268: aload_1
    //   269: astore 4
    //   271: aload 4
    //   273: areturn
    //   274: aload 5
    //   276: astore 8
    //   278: aload 7
    //   280: astore 9
    //   282: aload 4
    //   284: astore 10
    //   286: aload 13
    //   288: aload 4
    //   290: invokevirtual 158	java/io/DataInputStream:readLong	()J
    //   293: invokevirtual 212	com/gau/go/launcherex/gowidget/weather/model/u:a	(J)V
    //   296: aload 5
    //   298: astore 8
    //   300: aload 7
    //   302: astore 9
    //   304: aload 4
    //   306: astore 10
    //   308: aload 13
    //   310: aload 4
    //   312: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   315: invokevirtual 214	com/gau/go/launcherex/gowidget/weather/model/u:c	(I)V
    //   318: aload 5
    //   320: astore 8
    //   322: aload 7
    //   324: astore 9
    //   326: aload 4
    //   328: astore 10
    //   330: aload 13
    //   332: aload 4
    //   334: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   337: invokevirtual 216	com/gau/go/launcherex/gowidget/weather/model/u:d	(I)V
    //   340: aload 5
    //   342: astore 8
    //   344: aload 7
    //   346: astore 9
    //   348: aload 4
    //   350: astore 10
    //   352: aload 13
    //   354: aload 4
    //   356: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   359: invokevirtual 218	com/gau/go/launcherex/gowidget/weather/model/u:e	(I)V
    //   362: aload 5
    //   364: astore 8
    //   366: aload 7
    //   368: astore 9
    //   370: aload 4
    //   372: astore 10
    //   374: aload 13
    //   376: aload 4
    //   378: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   381: invokevirtual 220	com/gau/go/launcherex/gowidget/weather/model/u:f	(I)V
    //   384: aload 5
    //   386: astore 8
    //   388: aload 7
    //   390: astore 9
    //   392: aload 4
    //   394: astore 10
    //   396: new 77	java/util/ArrayList
    //   399: dup
    //   400: invokespecial 78	java/util/ArrayList:<init>	()V
    //   403: astore_1
    //   404: aload 5
    //   406: astore 8
    //   408: aload 7
    //   410: astore 9
    //   412: aload 4
    //   414: astore 10
    //   416: aload 13
    //   418: invokevirtual 222	com/gau/go/launcherex/gowidget/weather/model/u:c	()I
    //   421: istore_2
    //   422: iload_2
    //   423: ifle +738 -> 1161
    //   426: aload 5
    //   428: astore 8
    //   430: aload 7
    //   432: astore 9
    //   434: aload 4
    //   436: astore 10
    //   438: new 224	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean
    //   441: dup
    //   442: invokespecial 225	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:<init>	()V
    //   445: astore 6
    //   447: aload 5
    //   449: astore 8
    //   451: aload 7
    //   453: astore 9
    //   455: aload 4
    //   457: astore 10
    //   459: aload 6
    //   461: aload 4
    //   463: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   466: invokevirtual 226	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:a	(I)V
    //   469: aload 5
    //   471: astore 8
    //   473: aload 7
    //   475: astore 9
    //   477: aload 4
    //   479: astore 10
    //   481: aload 6
    //   483: aload 4
    //   485: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   488: invokevirtual 227	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:b	(I)V
    //   491: aload 5
    //   493: astore 8
    //   495: aload 7
    //   497: astore 9
    //   499: aload 4
    //   501: astore 10
    //   503: aload 6
    //   505: aload 4
    //   507: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   510: invokevirtual 228	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:c	(I)V
    //   513: aload 5
    //   515: astore 8
    //   517: aload 7
    //   519: astore 9
    //   521: aload 4
    //   523: astore 10
    //   525: aload 6
    //   527: aload 4
    //   529: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   532: invokevirtual 230	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:a	(Ljava/lang/String;)V
    //   535: aload 5
    //   537: astore 8
    //   539: aload 7
    //   541: astore 9
    //   543: aload 4
    //   545: astore 10
    //   547: aload 6
    //   549: aload 4
    //   551: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   554: invokevirtual 232	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:b	(Ljava/lang/String;)V
    //   557: aload 5
    //   559: astore 8
    //   561: aload 7
    //   563: astore 9
    //   565: aload 4
    //   567: astore 10
    //   569: aload 6
    //   571: aload 4
    //   573: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   576: invokevirtual 234	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:c	(Ljava/lang/String;)V
    //   579: aload 5
    //   581: astore 8
    //   583: aload 7
    //   585: astore 9
    //   587: aload 4
    //   589: astore 10
    //   591: aload 6
    //   593: aload 4
    //   595: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   598: invokevirtual 236	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:d	(Ljava/lang/String;)V
    //   601: aload 5
    //   603: astore 8
    //   605: aload 7
    //   607: astore 9
    //   609: aload 4
    //   611: astore 10
    //   613: aload 6
    //   615: aload 4
    //   617: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   620: invokevirtual 237	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:d	(I)V
    //   623: aload 5
    //   625: astore 8
    //   627: aload 7
    //   629: astore 9
    //   631: aload 4
    //   633: astore 10
    //   635: aload 6
    //   637: aload 4
    //   639: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   642: invokevirtual 239	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:e	(Ljava/lang/String;)V
    //   645: aload 5
    //   647: astore 8
    //   649: aload 7
    //   651: astore 9
    //   653: aload 4
    //   655: astore 10
    //   657: aload 6
    //   659: aload 4
    //   661: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   664: invokevirtual 240	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:e	(I)V
    //   667: aload 5
    //   669: astore 8
    //   671: aload 7
    //   673: astore 9
    //   675: aload 4
    //   677: astore 10
    //   679: aload 6
    //   681: aload 4
    //   683: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   686: invokevirtual 242	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:f	(Ljava/lang/String;)V
    //   689: aload 5
    //   691: astore 8
    //   693: aload 7
    //   695: astore 9
    //   697: aload 4
    //   699: astore 10
    //   701: aload 6
    //   703: aload 4
    //   705: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   708: invokevirtual 245	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:g	(Ljava/lang/String;)V
    //   711: aload 5
    //   713: astore 8
    //   715: aload 7
    //   717: astore 9
    //   719: aload 4
    //   721: astore 10
    //   723: aload 6
    //   725: aload 4
    //   727: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   730: invokevirtual 248	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:h	(Ljava/lang/String;)V
    //   733: aload 5
    //   735: astore 8
    //   737: aload 7
    //   739: astore 9
    //   741: aload 4
    //   743: astore 10
    //   745: aload 6
    //   747: aload 4
    //   749: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   752: invokevirtual 251	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:i	(Ljava/lang/String;)V
    //   755: aload 5
    //   757: astore 8
    //   759: aload 7
    //   761: astore 9
    //   763: aload 4
    //   765: astore 10
    //   767: aload 4
    //   769: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   772: istore_3
    //   773: iload_3
    //   774: ifle +309 -> 1083
    //   777: aload 5
    //   779: astore 8
    //   781: aload 7
    //   783: astore 9
    //   785: aload 4
    //   787: astore 10
    //   789: aload 4
    //   791: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   794: tableswitch	default:+509->1303, 1:+34->828, 2:+132->926, 3:+214->1008, 4:+239->1033, 5:+264->1058
    //   828: aload 5
    //   830: astore 8
    //   832: aload 7
    //   834: astore 9
    //   836: aload 4
    //   838: astore 10
    //   840: aload 6
    //   842: aload 4
    //   844: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   847: invokevirtual 254	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:j	(Ljava/lang/String;)V
    //   850: goto +453 -> 1303
    //   853: astore 8
    //   855: aload_1
    //   856: astore 6
    //   858: aload 8
    //   860: astore_1
    //   861: aload 5
    //   863: astore 8
    //   865: aload 7
    //   867: astore 9
    //   869: aload 4
    //   871: astore 10
    //   873: aload_1
    //   874: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   877: aload 4
    //   879: ifnull +8 -> 887
    //   882: aload 4
    //   884: invokevirtual 140	java/io/DataInputStream:close	()V
    //   887: aload 5
    //   889: ifnull +15 -> 904
    //   892: aload 5
    //   894: invokeinterface 125 1 0
    //   899: invokeinterface 146 1 0
    //   904: aload 6
    //   906: astore 4
    //   908: aload 7
    //   910: ifnull -639 -> 271
    //   913: aload 7
    //   915: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   918: astore 4
    //   920: aload 6
    //   922: astore_1
    //   923: goto -662 -> 261
    //   926: aload 5
    //   928: astore 8
    //   930: aload 7
    //   932: astore 9
    //   934: aload 4
    //   936: astore 10
    //   938: aload 6
    //   940: aload 4
    //   942: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   945: invokevirtual 257	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:k	(Ljava/lang/String;)V
    //   948: goto +355 -> 1303
    //   951: astore_1
    //   952: aload 10
    //   954: astore 4
    //   956: aload 9
    //   958: astore 7
    //   960: aload 8
    //   962: astore 5
    //   964: aload 4
    //   966: ifnull +8 -> 974
    //   969: aload 4
    //   971: invokevirtual 140	java/io/DataInputStream:close	()V
    //   974: aload 5
    //   976: ifnull +15 -> 991
    //   979: aload 5
    //   981: invokeinterface 125 1 0
    //   986: invokeinterface 146 1 0
    //   991: aload 7
    //   993: ifnull +13 -> 1006
    //   996: aload 7
    //   998: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   1001: invokeinterface 155 1 0
    //   1006: aload_1
    //   1007: athrow
    //   1008: aload 5
    //   1010: astore 8
    //   1012: aload 7
    //   1014: astore 9
    //   1016: aload 4
    //   1018: astore 10
    //   1020: aload 6
    //   1022: aload 4
    //   1024: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   1027: invokevirtual 260	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:l	(Ljava/lang/String;)V
    //   1030: goto +273 -> 1303
    //   1033: aload 5
    //   1035: astore 8
    //   1037: aload 7
    //   1039: astore 9
    //   1041: aload 4
    //   1043: astore 10
    //   1045: aload 6
    //   1047: aload 4
    //   1049: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   1052: invokevirtual 263	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:m	(Ljava/lang/String;)V
    //   1055: goto +248 -> 1303
    //   1058: aload 5
    //   1060: astore 8
    //   1062: aload 7
    //   1064: astore 9
    //   1066: aload 4
    //   1068: astore 10
    //   1070: aload 6
    //   1072: aload 4
    //   1074: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   1077: invokevirtual 266	com/gau/go/launcherex/gowidget/weather/model/ThemeDataBean:n	(Ljava/lang/String;)V
    //   1080: goto +223 -> 1303
    //   1083: aload 5
    //   1085: astore 8
    //   1087: aload 7
    //   1089: astore 9
    //   1091: aload 4
    //   1093: astore 10
    //   1095: aload_1
    //   1096: aload 6
    //   1098: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1101: pop
    //   1102: iload_2
    //   1103: iconst_1
    //   1104: isub
    //   1105: istore_2
    //   1106: goto -684 -> 422
    //   1109: astore 4
    //   1111: aload 4
    //   1113: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1116: goto -142 -> 974
    //   1119: astore 4
    //   1121: aload 4
    //   1123: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1126: goto -135 -> 991
    //   1129: astore_1
    //   1130: aload_1
    //   1131: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1134: goto -247 -> 887
    //   1137: astore_1
    //   1138: aload_1
    //   1139: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1142: goto -238 -> 904
    //   1145: astore_1
    //   1146: aload_1
    //   1147: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1150: goto -925 -> 225
    //   1153: astore_1
    //   1154: aload_1
    //   1155: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1158: goto -916 -> 242
    //   1161: aload 4
    //   1163: ifnull +8 -> 1171
    //   1166: aload 4
    //   1168: invokevirtual 140	java/io/DataInputStream:close	()V
    //   1171: aload 5
    //   1173: ifnull +15 -> 1188
    //   1176: aload 5
    //   1178: invokeinterface 125 1 0
    //   1183: invokeinterface 146 1 0
    //   1188: aload_1
    //   1189: astore 4
    //   1191: aload 7
    //   1193: ifnull -922 -> 271
    //   1196: aload 7
    //   1198: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   1201: astore 4
    //   1203: goto -942 -> 261
    //   1206: astore 4
    //   1208: aload 4
    //   1210: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1213: goto -42 -> 1171
    //   1216: astore 4
    //   1218: aload 4
    //   1220: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   1223: goto -35 -> 1188
    //   1226: astore_1
    //   1227: aconst_null
    //   1228: astore 5
    //   1230: aconst_null
    //   1231: astore 7
    //   1233: aconst_null
    //   1234: astore 4
    //   1236: goto -272 -> 964
    //   1239: astore_1
    //   1240: aconst_null
    //   1241: astore 5
    //   1243: aconst_null
    //   1244: astore 4
    //   1246: goto -282 -> 964
    //   1249: astore_1
    //   1250: aconst_null
    //   1251: astore 4
    //   1253: goto -289 -> 964
    //   1256: astore_1
    //   1257: aconst_null
    //   1258: astore 5
    //   1260: aconst_null
    //   1261: astore 7
    //   1263: aconst_null
    //   1264: astore 4
    //   1266: goto -405 -> 861
    //   1269: astore_1
    //   1270: aconst_null
    //   1271: astore 5
    //   1273: aconst_null
    //   1274: astore 4
    //   1276: goto -415 -> 861
    //   1279: astore_1
    //   1280: aconst_null
    //   1281: astore 4
    //   1283: goto -422 -> 861
    //   1286: astore_1
    //   1287: goto -426 -> 861
    //   1290: aconst_null
    //   1291: astore 6
    //   1293: aload 4
    //   1295: astore_1
    //   1296: aload 6
    //   1298: astore 4
    //   1300: goto -139 -> 1161
    //   1303: iload_3
    //   1304: iconst_1
    //   1305: isub
    //   1306: istore_3
    //   1307: goto -534 -> 773
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1310	0	this	x
    //   0	1310	1	paramList	List
    //   421	685	2	i	int
    //   772	535	3	j	int
    //   7	1085	4	localObject1	Object
    //   1109	3	4	localIOException1	IOException
    //   1119	48	4	localIOException2	IOException
    //   1189	13	4	localObject2	Object
    //   1206	3	4	localIOException3	IOException
    //   1216	3	4	localIOException4	IOException
    //   1234	65	4	localObject3	Object
    //   21	1251	5	localObject4	Object
    //   4	1293	6	localObject5	Object
    //   45	1217	7	localObject6	Object
    //   97	734	8	localObject7	Object
    //   853	6	8	localException	Exception
    //   863	223	8	localObject8	Object
    //   101	989	9	localObject9	Object
    //   105	989	10	localObject10	Object
    //   10	249	11	localObject11	Object
    //   1	242	12	localObject12	Object
    //   114	303	13	localu	com.gau.go.launcherex.gowidget.weather.model.u
    // Exception table:
    //   from	to	target	type
    //   416	422	853	java/lang/Exception
    //   438	447	853	java/lang/Exception
    //   459	469	853	java/lang/Exception
    //   481	491	853	java/lang/Exception
    //   503	513	853	java/lang/Exception
    //   525	535	853	java/lang/Exception
    //   547	557	853	java/lang/Exception
    //   569	579	853	java/lang/Exception
    //   591	601	853	java/lang/Exception
    //   613	623	853	java/lang/Exception
    //   635	645	853	java/lang/Exception
    //   657	667	853	java/lang/Exception
    //   679	689	853	java/lang/Exception
    //   701	711	853	java/lang/Exception
    //   723	733	853	java/lang/Exception
    //   745	755	853	java/lang/Exception
    //   767	773	853	java/lang/Exception
    //   789	828	853	java/lang/Exception
    //   840	850	853	java/lang/Exception
    //   938	948	853	java/lang/Exception
    //   1020	1030	853	java/lang/Exception
    //   1045	1055	853	java/lang/Exception
    //   1070	1080	853	java/lang/Exception
    //   1095	1102	853	java/lang/Exception
    //   107	116	951	finally
    //   128	134	951	finally
    //   146	156	951	finally
    //   168	178	951	finally
    //   190	198	951	finally
    //   210	215	951	finally
    //   286	296	951	finally
    //   308	318	951	finally
    //   330	340	951	finally
    //   352	362	951	finally
    //   374	384	951	finally
    //   396	404	951	finally
    //   416	422	951	finally
    //   438	447	951	finally
    //   459	469	951	finally
    //   481	491	951	finally
    //   503	513	951	finally
    //   525	535	951	finally
    //   547	557	951	finally
    //   569	579	951	finally
    //   591	601	951	finally
    //   613	623	951	finally
    //   635	645	951	finally
    //   657	667	951	finally
    //   679	689	951	finally
    //   701	711	951	finally
    //   723	733	951	finally
    //   745	755	951	finally
    //   767	773	951	finally
    //   789	828	951	finally
    //   840	850	951	finally
    //   873	877	951	finally
    //   938	948	951	finally
    //   1020	1030	951	finally
    //   1045	1055	951	finally
    //   1070	1080	951	finally
    //   1095	1102	951	finally
    //   969	974	1109	java/io/IOException
    //   979	991	1119	java/io/IOException
    //   882	887	1129	java/io/IOException
    //   892	904	1137	java/io/IOException
    //   220	225	1145	java/io/IOException
    //   230	242	1153	java/io/IOException
    //   1166	1171	1206	java/io/IOException
    //   1176	1188	1216	java/io/IOException
    //   12	47	1226	finally
    //   47	56	1239	finally
    //   56	95	1249	finally
    //   12	47	1256	java/lang/Exception
    //   47	56	1269	java/lang/Exception
    //   56	95	1279	java/lang/Exception
    //   107	116	1286	java/lang/Exception
    //   128	134	1286	java/lang/Exception
    //   146	156	1286	java/lang/Exception
    //   168	178	1286	java/lang/Exception
    //   190	198	1286	java/lang/Exception
    //   210	215	1286	java/lang/Exception
    //   286	296	1286	java/lang/Exception
    //   308	318	1286	java/lang/Exception
    //   330	340	1286	java/lang/Exception
    //   352	362	1286	java/lang/Exception
    //   374	384	1286	java/lang/Exception
    //   396	404	1286	java/lang/Exception
  }
  
  private void a(List paramList, ThemeDataBean paramThemeDataBean)
  {
    c(paramList);
    paramList.add(new BasicNameValuePair("funid", "5"));
    paramList.add(new BasicNameValuePair("id", paramThemeDataBean.a() + ""));
    paramList.add(new BasicNameValuePair("pkgname", paramThemeDataBean.i()));
  }
  
  private void a(List paramList, String paramString)
  {
    c(paramList);
    paramList.add(new BasicNameValuePair("funid", "6"));
    paramList.add(new BasicNameValuePair("imgids", paramString));
  }
  
  private long b()
  {
    return this.c.getLong("key_synchronou_launch_image_timestamp", 0L);
  }
  
  /* Error */
  private com.gau.go.launcherex.gowidget.weather.model.t b(List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: new 83	org/apache/http/client/methods/HttpPost
    //   15: dup
    //   16: ldc 85
    //   18: invokespecial 88	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_3
    //   23: new 90	org/apache/http/client/entity/UrlEncodedFormEntity
    //   26: dup
    //   27: aload_1
    //   28: ldc 92
    //   30: invokespecial 94	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   33: invokevirtual 100	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   36: new 102	org/apache/http/impl/client/DefaultHttpClient
    //   39: dup
    //   40: invokespecial 103	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   43: astore 6
    //   45: aload 6
    //   47: aload_3
    //   48: invokevirtual 107	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   51: astore_3
    //   52: aload_3
    //   53: invokeinterface 113 1 0
    //   58: invokeinterface 119 1 0
    //   63: sipush 200
    //   66: if_icmpne +899 -> 965
    //   69: new 121	java/io/DataInputStream
    //   72: dup
    //   73: aload_3
    //   74: invokeinterface 125 1 0
    //   79: invokeinterface 131 1 0
    //   84: invokespecial 134	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore 7
    //   89: aload_3
    //   90: astore 10
    //   92: aload 6
    //   94: astore 9
    //   96: aload 7
    //   98: astore 8
    //   100: new 201	com/gau/go/launcherex/gowidget/weather/model/u
    //   103: dup
    //   104: invokespecial 202	com/gau/go/launcherex/gowidget/weather/model/u:<init>	()V
    //   107: astore_1
    //   108: aload_3
    //   109: astore 10
    //   111: aload 6
    //   113: astore 9
    //   115: aload 7
    //   117: astore 8
    //   119: aload 7
    //   121: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   124: pop
    //   125: aload_3
    //   126: astore 10
    //   128: aload 6
    //   130: astore 9
    //   132: aload 7
    //   134: astore 8
    //   136: aload_1
    //   137: aload 7
    //   139: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   142: invokevirtual 205	com/gau/go/launcherex/gowidget/weather/model/u:a	(I)V
    //   145: aload_3
    //   146: astore 10
    //   148: aload 6
    //   150: astore 9
    //   152: aload 7
    //   154: astore 8
    //   156: aload_1
    //   157: aload 7
    //   159: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   162: invokevirtual 207	com/gau/go/launcherex/gowidget/weather/model/u:b	(I)V
    //   165: aload_3
    //   166: astore 10
    //   168: aload 6
    //   170: astore 9
    //   172: aload 7
    //   174: astore 8
    //   176: aload_1
    //   177: invokevirtual 209	com/gau/go/launcherex/gowidget/weather/model/u:a	()I
    //   180: istore_2
    //   181: iload_2
    //   182: ifne +55 -> 237
    //   185: aload 7
    //   187: ifnull +8 -> 195
    //   190: aload 7
    //   192: invokevirtual 140	java/io/DataInputStream:close	()V
    //   195: aload_3
    //   196: ifnull +14 -> 210
    //   199: aload_3
    //   200: invokeinterface 125 1 0
    //   205: invokeinterface 146 1 0
    //   210: aload 11
    //   212: astore_3
    //   213: aload 6
    //   215: ifnull +20 -> 235
    //   218: aload 6
    //   220: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   223: astore_3
    //   224: aload 5
    //   226: astore_1
    //   227: aload_3
    //   228: invokeinterface 155 1 0
    //   233: aload_1
    //   234: astore_3
    //   235: aload_3
    //   236: areturn
    //   237: aload_3
    //   238: astore 10
    //   240: aload 6
    //   242: astore 9
    //   244: aload 7
    //   246: astore 8
    //   248: aload_1
    //   249: aload 7
    //   251: invokevirtual 158	java/io/DataInputStream:readLong	()J
    //   254: invokevirtual 212	com/gau/go/launcherex/gowidget/weather/model/u:a	(J)V
    //   257: aload_3
    //   258: astore 10
    //   260: aload 6
    //   262: astore 9
    //   264: aload 7
    //   266: astore 8
    //   268: new 330	com/gau/go/launcherex/gowidget/weather/model/t
    //   271: dup
    //   272: invokespecial 331	com/gau/go/launcherex/gowidget/weather/model/t:<init>	()V
    //   275: astore_1
    //   276: aload_3
    //   277: astore 10
    //   279: aload 6
    //   281: astore 9
    //   283: aload 7
    //   285: astore 8
    //   287: aload_1
    //   288: aload 7
    //   290: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   293: invokevirtual 332	com/gau/go/launcherex/gowidget/weather/model/t:a	(I)V
    //   296: aload_3
    //   297: astore 10
    //   299: aload 6
    //   301: astore 9
    //   303: aload 7
    //   305: astore 8
    //   307: aload_1
    //   308: aload 7
    //   310: invokevirtual 336	java/io/DataInputStream:readByte	()B
    //   313: invokevirtual 339	com/gau/go/launcherex/gowidget/weather/model/t:a	(B)V
    //   316: aload_3
    //   317: astore 10
    //   319: aload 6
    //   321: astore 9
    //   323: aload 7
    //   325: astore 8
    //   327: aload_1
    //   328: aload 7
    //   330: invokevirtual 336	java/io/DataInputStream:readByte	()B
    //   333: invokevirtual 341	com/gau/go/launcherex/gowidget/weather/model/t:b	(B)V
    //   336: aload_3
    //   337: astore 10
    //   339: aload 6
    //   341: astore 9
    //   343: aload 7
    //   345: astore 8
    //   347: aload_1
    //   348: aload 7
    //   350: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   353: invokevirtual 342	com/gau/go/launcherex/gowidget/weather/model/t:a	(Ljava/lang/String;)V
    //   356: aload_3
    //   357: astore 10
    //   359: aload 6
    //   361: astore 9
    //   363: aload 7
    //   365: astore 8
    //   367: aload_1
    //   368: aload 7
    //   370: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   373: invokevirtual 343	com/gau/go/launcherex/gowidget/weather/model/t:b	(Ljava/lang/String;)V
    //   376: aload_3
    //   377: astore 10
    //   379: aload 6
    //   381: astore 9
    //   383: aload 7
    //   385: astore 8
    //   387: aload_1
    //   388: aload 7
    //   390: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   393: invokevirtual 344	com/gau/go/launcherex/gowidget/weather/model/t:c	(Ljava/lang/String;)V
    //   396: aload_3
    //   397: astore 10
    //   399: aload 6
    //   401: astore 9
    //   403: aload 7
    //   405: astore 8
    //   407: aload_1
    //   408: aload 7
    //   410: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   413: invokevirtual 345	com/gau/go/launcherex/gowidget/weather/model/t:d	(Ljava/lang/String;)V
    //   416: aload_3
    //   417: astore 10
    //   419: aload 6
    //   421: astore 9
    //   423: aload 7
    //   425: astore 8
    //   427: aload_1
    //   428: aload 7
    //   430: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   433: invokevirtual 346	com/gau/go/launcherex/gowidget/weather/model/t:e	(Ljava/lang/String;)V
    //   436: aload_3
    //   437: astore 10
    //   439: aload 6
    //   441: astore 9
    //   443: aload 7
    //   445: astore 8
    //   447: aload_1
    //   448: aload 7
    //   450: invokevirtual 137	java/io/DataInputStream:readInt	()I
    //   453: invokevirtual 347	com/gau/go/launcherex/gowidget/weather/model/t:b	(I)V
    //   456: aload_3
    //   457: astore 10
    //   459: aload 6
    //   461: astore 9
    //   463: aload 7
    //   465: astore 8
    //   467: aload_1
    //   468: aload 7
    //   470: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   473: invokevirtual 348	com/gau/go/launcherex/gowidget/weather/model/t:f	(Ljava/lang/String;)V
    //   476: aload_3
    //   477: astore 10
    //   479: aload 6
    //   481: astore 9
    //   483: aload 7
    //   485: astore 8
    //   487: aload_1
    //   488: aload 7
    //   490: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   493: invokevirtual 349	com/gau/go/launcherex/gowidget/weather/model/t:g	(Ljava/lang/String;)V
    //   496: aload_3
    //   497: astore 10
    //   499: aload 6
    //   501: astore 9
    //   503: aload 7
    //   505: astore 8
    //   507: aload_1
    //   508: aload 7
    //   510: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   513: invokevirtual 350	com/gau/go/launcherex/gowidget/weather/model/t:h	(Ljava/lang/String;)V
    //   516: aload_3
    //   517: astore 10
    //   519: aload 6
    //   521: astore 9
    //   523: aload 7
    //   525: astore 8
    //   527: aload_1
    //   528: aload 7
    //   530: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   533: invokevirtual 351	com/gau/go/launcherex/gowidget/weather/model/t:i	(Ljava/lang/String;)V
    //   536: aload_3
    //   537: astore 10
    //   539: aload 6
    //   541: astore 9
    //   543: aload 7
    //   545: astore 8
    //   547: aload_1
    //   548: aload 7
    //   550: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   553: invokevirtual 352	com/gau/go/launcherex/gowidget/weather/model/t:j	(Ljava/lang/String;)V
    //   556: aload_3
    //   557: astore 10
    //   559: aload 6
    //   561: astore 9
    //   563: aload 7
    //   565: astore 8
    //   567: aload_1
    //   568: aload 7
    //   570: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   573: invokevirtual 353	com/gau/go/launcherex/gowidget/weather/model/t:k	(Ljava/lang/String;)V
    //   576: aload_3
    //   577: astore 10
    //   579: aload 6
    //   581: astore 9
    //   583: aload 7
    //   585: astore 8
    //   587: aload_1
    //   588: aload 7
    //   590: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   593: invokevirtual 354	com/gau/go/launcherex/gowidget/weather/model/t:l	(Ljava/lang/String;)V
    //   596: aload_3
    //   597: astore 10
    //   599: aload 6
    //   601: astore 9
    //   603: aload 7
    //   605: astore 8
    //   607: aload_1
    //   608: aload 7
    //   610: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   613: invokevirtual 355	com/gau/go/launcherex/gowidget/weather/model/t:m	(Ljava/lang/String;)V
    //   616: aload_3
    //   617: astore 10
    //   619: aload 6
    //   621: astore 9
    //   623: aload 7
    //   625: astore 8
    //   627: aload_1
    //   628: aload 7
    //   630: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   633: invokevirtual 356	com/gau/go/launcherex/gowidget/weather/model/t:n	(Ljava/lang/String;)V
    //   636: aload_3
    //   637: astore 10
    //   639: aload 6
    //   641: astore 9
    //   643: aload 7
    //   645: astore 8
    //   647: aload_1
    //   648: aload 7
    //   650: invokevirtual 161	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   653: invokevirtual 359	com/gau/go/launcherex/gowidget/weather/model/t:o	(Ljava/lang/String;)V
    //   656: aload 7
    //   658: ifnull +8 -> 666
    //   661: aload 7
    //   663: invokevirtual 140	java/io/DataInputStream:close	()V
    //   666: aload_3
    //   667: ifnull +14 -> 681
    //   670: aload_3
    //   671: invokeinterface 125 1 0
    //   676: invokeinterface 146 1 0
    //   681: aload_1
    //   682: astore_3
    //   683: aload 6
    //   685: ifnull -450 -> 235
    //   688: aload 6
    //   690: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   693: astore_3
    //   694: goto -467 -> 227
    //   697: astore_1
    //   698: aconst_null
    //   699: astore 5
    //   701: aconst_null
    //   702: astore 6
    //   704: aconst_null
    //   705: astore_3
    //   706: aload 5
    //   708: astore 10
    //   710: aload 6
    //   712: astore 9
    //   714: aload_3
    //   715: astore 8
    //   717: aload_1
    //   718: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   721: aload_3
    //   722: ifnull +7 -> 729
    //   725: aload_3
    //   726: invokevirtual 140	java/io/DataInputStream:close	()V
    //   729: aload 5
    //   731: ifnull +15 -> 746
    //   734: aload 5
    //   736: invokeinterface 125 1 0
    //   741: invokeinterface 146 1 0
    //   746: aload 4
    //   748: astore_3
    //   749: aload 6
    //   751: ifnull -516 -> 235
    //   754: aload 6
    //   756: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   759: astore_3
    //   760: aload 4
    //   762: astore_1
    //   763: goto -536 -> 227
    //   766: astore_3
    //   767: aload_3
    //   768: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   771: aload 6
    //   773: ifnull +13 -> 786
    //   776: aload 6
    //   778: invokevirtual 150	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   781: invokeinterface 155 1 0
    //   786: aload_1
    //   787: athrow
    //   788: astore_1
    //   789: aconst_null
    //   790: astore_3
    //   791: aconst_null
    //   792: astore 6
    //   794: aconst_null
    //   795: astore 4
    //   797: aload 4
    //   799: ifnull +8 -> 807
    //   802: aload 4
    //   804: invokevirtual 140	java/io/DataInputStream:close	()V
    //   807: aload_3
    //   808: ifnull -37 -> 771
    //   811: aload_3
    //   812: invokeinterface 125 1 0
    //   817: invokeinterface 146 1 0
    //   822: goto -51 -> 771
    //   825: astore 4
    //   827: aload 4
    //   829: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   832: goto -25 -> 807
    //   835: astore_1
    //   836: aload_1
    //   837: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   840: goto -111 -> 729
    //   843: astore_1
    //   844: aload_1
    //   845: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   848: goto -102 -> 746
    //   851: astore_1
    //   852: aload_1
    //   853: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   856: goto -661 -> 195
    //   859: astore_1
    //   860: aload_1
    //   861: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   864: goto -654 -> 210
    //   867: astore 4
    //   869: aload 4
    //   871: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   874: goto -208 -> 666
    //   877: astore_3
    //   878: aload_3
    //   879: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   882: goto -201 -> 681
    //   885: astore_1
    //   886: aconst_null
    //   887: astore_3
    //   888: aconst_null
    //   889: astore 4
    //   891: goto -94 -> 797
    //   894: astore_1
    //   895: aconst_null
    //   896: astore 4
    //   898: goto -101 -> 797
    //   901: astore_1
    //   902: aload 10
    //   904: astore_3
    //   905: aload 9
    //   907: astore 6
    //   909: aload 8
    //   911: astore 4
    //   913: goto -116 -> 797
    //   916: astore_1
    //   917: aconst_null
    //   918: astore 5
    //   920: aconst_null
    //   921: astore_3
    //   922: goto -216 -> 706
    //   925: astore_1
    //   926: aconst_null
    //   927: astore 7
    //   929: aload_3
    //   930: astore 5
    //   932: aload 7
    //   934: astore_3
    //   935: goto -229 -> 706
    //   938: astore_1
    //   939: aload_3
    //   940: astore 5
    //   942: aload 7
    //   944: astore_3
    //   945: goto -239 -> 706
    //   948: astore 5
    //   950: aload_1
    //   951: astore 4
    //   953: aload 5
    //   955: astore_1
    //   956: aload_3
    //   957: astore 5
    //   959: aload 7
    //   961: astore_3
    //   962: goto -256 -> 706
    //   965: aconst_null
    //   966: astore 4
    //   968: aload 7
    //   970: astore_1
    //   971: aload 4
    //   973: astore 7
    //   975: goto -319 -> 656
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	x
    //   0	978	1	paramList	List
    //   180	2	2	i	int
    //   21	739	3	localObject1	Object
    //   766	2	3	localIOException1	IOException
    //   790	22	3	localObject2	Object
    //   877	2	3	localIOException2	IOException
    //   887	75	3	localObject3	Object
    //   7	796	4	localObject4	Object
    //   825	3	4	localIOException3	IOException
    //   867	3	4	localIOException4	IOException
    //   889	83	4	localObject5	Object
    //   10	931	5	localObject6	Object
    //   948	6	5	localException	Exception
    //   957	1	5	localObject7	Object
    //   43	865	6	localObject8	Object
    //   4	970	7	localObject9	Object
    //   98	812	8	localObject10	Object
    //   94	812	9	localObject11	Object
    //   90	813	10	localObject12	Object
    //   1	210	11	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   12	45	697	java/lang/Exception
    //   811	822	766	java/io/IOException
    //   12	45	788	finally
    //   802	807	825	java/io/IOException
    //   725	729	835	java/io/IOException
    //   734	746	843	java/io/IOException
    //   190	195	851	java/io/IOException
    //   199	210	859	java/io/IOException
    //   661	666	867	java/io/IOException
    //   670	681	877	java/io/IOException
    //   45	52	885	finally
    //   52	89	894	finally
    //   100	108	901	finally
    //   119	125	901	finally
    //   136	145	901	finally
    //   156	165	901	finally
    //   176	181	901	finally
    //   248	257	901	finally
    //   268	276	901	finally
    //   287	296	901	finally
    //   307	316	901	finally
    //   327	336	901	finally
    //   347	356	901	finally
    //   367	376	901	finally
    //   387	396	901	finally
    //   407	416	901	finally
    //   427	436	901	finally
    //   447	456	901	finally
    //   467	476	901	finally
    //   487	496	901	finally
    //   507	516	901	finally
    //   527	536	901	finally
    //   547	556	901	finally
    //   567	576	901	finally
    //   587	596	901	finally
    //   607	616	901	finally
    //   627	636	901	finally
    //   647	656	901	finally
    //   717	721	901	finally
    //   45	52	916	java/lang/Exception
    //   52	89	925	java/lang/Exception
    //   100	108	938	java/lang/Exception
    //   119	125	938	java/lang/Exception
    //   136	145	938	java/lang/Exception
    //   156	165	938	java/lang/Exception
    //   176	181	938	java/lang/Exception
    //   248	257	938	java/lang/Exception
    //   268	276	938	java/lang/Exception
    //   287	296	948	java/lang/Exception
    //   307	316	948	java/lang/Exception
    //   327	336	948	java/lang/Exception
    //   347	356	948	java/lang/Exception
    //   367	376	948	java/lang/Exception
    //   387	396	948	java/lang/Exception
    //   407	416	948	java/lang/Exception
    //   427	436	948	java/lang/Exception
    //   447	456	948	java/lang/Exception
    //   467	476	948	java/lang/Exception
    //   487	496	948	java/lang/Exception
    //   507	516	948	java/lang/Exception
    //   527	536	948	java/lang/Exception
    //   547	556	948	java/lang/Exception
    //   567	576	948	java/lang/Exception
    //   587	596	948	java/lang/Exception
    //   607	616	948	java/lang/Exception
    //   627	636	948	java/lang/Exception
    //   647	656	948	java/lang/Exception
  }
  
  public static void b(Context paramContext)
  {
    paramContext = GoWidgetApplication.c(paramContext).a().edit();
    paramContext.putLong("key_synchronou_launch_image_timestamp", 0L);
    paramContext.commit();
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putLong("key_synchronou_launch_image_timestamp", System.currentTimeMillis());
    localEditor.commit();
  }
  
  private void c(List paramList)
  {
    paramList.add(new BasicNameValuePair("vps", b.a(this.a)));
    paramList.add(new BasicNameValuePair("channel", y.f(this.a)));
    paramList.add(new BasicNameValuePair("lang", y.j(this.a)));
    if (y.t(this.a))
    {
      str = "1";
      paramList.add(new BasicNameValuePair("isfee", str));
      paramList.add(new BasicNameValuePair("pversion", "18"));
      paramList.add(new BasicNameValuePair("ps", "30"));
      paramList.add(new BasicNameValuePair("isgmail", "-1"));
      paramList.add(new BasicNameValuePair("appuid", "7"));
      if (!y.h(this.a)) {
        break label224;
      }
    }
    label224:
    for (String str = "1";; str = "0")
    {
      paramList.add(new BasicNameValuePair("offical", str));
      return;
      str = "0";
      break;
    }
  }
  
  private void d(List paramList)
  {
    c(paramList);
    paramList.add(new BasicNameValuePair("funid", "27"));
    paramList.add(new BasicNameValuePair("timestamp", "0"));
    paramList.add(new BasicNameValuePair("ty", "5"));
    try
    {
      paramList.add(new BasicNameValuePair("owns", f.a("", "ISO-8859-1")));
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void a()
  {
    c.a("LJL", "startSyncLaunchImage--------------------");
    if (!this.e)
    {
      this.e = true;
      new z(this, null).execute(new Void[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */