package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.gau.go.launcherex.gowidget.d.f;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b;
import com.gau.go.launcherex.gowidget.weather.model.PluginCameraBean;
import com.gau.go.launcherex.gowidget.weather.model.u;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ai
{
  private ak a;
  private Context b;
  private u c;
  private ArrayList d;
  private am e = null;
  
  public ai(Context paramContext)
  {
    this.b = paramContext;
    this.c = new u();
    this.c.a(0L);
    this.d = new ArrayList();
    this.e = new am(this, paramContext.getContentResolver(), paramContext);
  }
  
  private void a(List paramList)
  {
    b(paramList);
    paramList.add(new BasicNameValuePair("funid", "27"));
    paramList.add(new BasicNameValuePair("timestamp", this.c.b() + ""));
    paramList.add(new BasicNameValuePair("ty", "6"));
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
  
  private void b(List paramList)
  {
    paramList.add(new BasicNameValuePair("vps", b.a(this.b)));
    paramList.add(new BasicNameValuePair("channel", y.f(this.b)));
    paramList.add(new BasicNameValuePair("lang", y.j(this.b)));
    if (y.t(this.b))
    {
      str = "1";
      paramList.add(new BasicNameValuePair("isfee", str));
      paramList.add(new BasicNameValuePair("pversion", "18"));
      paramList.add(new BasicNameValuePair("ps", "30"));
      paramList.add(new BasicNameValuePair("isgmail", "-1"));
      paramList.add(new BasicNameValuePair("appuid", "7"));
      if (!y.h(this.b)) {
        break label208;
      }
    }
    label208:
    for (String str = "1";; str = "0")
    {
      paramList.add(new BasicNameValuePair("offical", str));
      return;
      str = "0";
      break;
    }
  }
  
  private boolean c()
  {
    return this.b.getContentResolver().delete(WeatherContentProvider.h, "theme_type=?", new String[] { "6" }) > 0;
  }
  
  /* Error */
  private boolean c(List paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aconst_null
    //   10: astore 7
    //   12: new 192	org/apache/http/client/methods/HttpPost
    //   15: dup
    //   16: ldc -62
    //   18: invokespecial 197	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   21: astore 9
    //   23: aload 9
    //   25: new 199	org/apache/http/client/entity/UrlEncodedFormEntity
    //   28: dup
    //   29: aload_1
    //   30: ldc -55
    //   32: invokespecial 204	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   35: invokevirtual 210	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   38: new 212	org/apache/http/impl/client/DefaultHttpClient
    //   41: dup
    //   42: invokespecial 213	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 9
    //   51: invokevirtual 217	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   54: astore 10
    //   56: aload 10
    //   58: invokeinterface 223 1 0
    //   63: invokeinterface 229 1 0
    //   68: sipush 200
    //   71: if_icmpne +775 -> 846
    //   74: new 231	java/io/DataInputStream
    //   77: dup
    //   78: aload 10
    //   80: invokeinterface 235 1 0
    //   85: invokeinterface 241 1 0
    //   90: invokespecial 244	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore 7
    //   95: aload 7
    //   97: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   100: pop
    //   101: aload_0
    //   102: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   105: aload 7
    //   107: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   110: invokevirtual 250	com/gau/go/launcherex/gowidget/weather/model/u:a	(I)V
    //   113: aload_0
    //   114: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   117: aload 7
    //   119: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   122: invokevirtual 252	com/gau/go/launcherex/gowidget/weather/model/u:b	(I)V
    //   125: aload_0
    //   126: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   129: invokevirtual 254	com/gau/go/launcherex/gowidget/weather/model/u:a	()I
    //   132: istore_2
    //   133: iload_2
    //   134: ifne +54 -> 188
    //   137: aload 7
    //   139: ifnull +8 -> 147
    //   142: aload 7
    //   144: invokevirtual 257	java/io/DataInputStream:close	()V
    //   147: aload 10
    //   149: ifnull +15 -> 164
    //   152: aload 10
    //   154: invokeinterface 235 1 0
    //   159: invokeinterface 260 1 0
    //   164: aload 8
    //   166: ifnull +19 -> 185
    //   169: aload 8
    //   171: invokevirtual 264	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   174: astore_1
    //   175: aload_1
    //   176: invokeinterface 269 1 0
    //   181: iload 4
    //   183: istore 5
    //   185: iload 5
    //   187: ireturn
    //   188: aload_0
    //   189: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   192: aload 7
    //   194: invokevirtual 272	java/io/DataInputStream:readLong	()J
    //   197: invokevirtual 31	com/gau/go/launcherex/gowidget/weather/model/u:a	(J)V
    //   200: aload_0
    //   201: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   204: aload 7
    //   206: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   209: invokevirtual 274	com/gau/go/launcherex/gowidget/weather/model/u:c	(I)V
    //   212: aload_0
    //   213: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   216: aload 7
    //   218: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   221: invokevirtual 276	com/gau/go/launcherex/gowidget/weather/model/u:d	(I)V
    //   224: aload_0
    //   225: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   228: aload 7
    //   230: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   233: invokevirtual 278	com/gau/go/launcherex/gowidget/weather/model/u:e	(I)V
    //   236: aload_0
    //   237: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   240: aload 7
    //   242: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   245: invokevirtual 280	com/gau/go/launcherex/gowidget/weather/model/u:f	(I)V
    //   248: aload_0
    //   249: getfield 28	com/gau/go/launcherex/gowidget/weather/b/ai:c	Lcom/gau/go/launcherex/gowidget/weather/model/u;
    //   252: invokevirtual 282	com/gau/go/launcherex/gowidget/weather/model/u:c	()I
    //   255: istore_2
    //   256: iload_2
    //   257: ifle +365 -> 622
    //   260: new 284	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean
    //   263: dup
    //   264: invokespecial 285	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:<init>	()V
    //   267: astore_1
    //   268: aload_1
    //   269: aload 7
    //   271: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   274: invokevirtual 286	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:a	(I)V
    //   277: aload_1
    //   278: aload 7
    //   280: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   283: invokevirtual 287	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:b	(I)V
    //   286: aload_1
    //   287: aload 7
    //   289: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   292: invokevirtual 288	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:c	(I)V
    //   295: aload_1
    //   296: aload 7
    //   298: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   301: invokevirtual 293	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:a	(Ljava/lang/String;)V
    //   304: aload_1
    //   305: aload 7
    //   307: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   310: invokevirtual 295	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:b	(Ljava/lang/String;)V
    //   313: aload_1
    //   314: aload 7
    //   316: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   319: invokevirtual 297	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:c	(Ljava/lang/String;)V
    //   322: aload_1
    //   323: aload 7
    //   325: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   328: invokevirtual 299	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:d	(Ljava/lang/String;)V
    //   331: aload_1
    //   332: aload 7
    //   334: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   337: invokevirtual 300	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:d	(I)V
    //   340: aload_1
    //   341: aload 7
    //   343: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   346: invokevirtual 302	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:e	(Ljava/lang/String;)V
    //   349: aload_1
    //   350: aload 7
    //   352: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   355: invokevirtual 303	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:e	(I)V
    //   358: aload_1
    //   359: aload 7
    //   361: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   364: invokevirtual 305	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:f	(Ljava/lang/String;)V
    //   367: aload_1
    //   368: aload 7
    //   370: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   373: invokevirtual 308	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:g	(Ljava/lang/String;)V
    //   376: aload_1
    //   377: aload 7
    //   379: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   382: invokevirtual 310	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:h	(Ljava/lang/String;)V
    //   385: aload_1
    //   386: aload 7
    //   388: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   391: invokevirtual 313	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:i	(Ljava/lang/String;)V
    //   394: aload 7
    //   396: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   399: istore_3
    //   400: iload_3
    //   401: ifle +205 -> 606
    //   404: aload 7
    //   406: invokevirtual 247	java/io/DataInputStream:readInt	()I
    //   409: tableswitch	default:+447->856, 1:+35->444, 2:+100->509, 3:+161->570, 4:+173->582, 5:+185->594
    //   444: aload_1
    //   445: aload 7
    //   447: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   450: invokevirtual 315	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:j	(Ljava/lang/String;)V
    //   453: goto +403 -> 856
    //   456: astore 9
    //   458: aload 8
    //   460: astore_1
    //   461: aload 10
    //   463: astore 8
    //   465: aload 9
    //   467: invokevirtual 316	java/lang/Exception:printStackTrace	()V
    //   470: aload 7
    //   472: ifnull +8 -> 480
    //   475: aload 7
    //   477: invokevirtual 257	java/io/DataInputStream:close	()V
    //   480: aload 8
    //   482: ifnull +15 -> 497
    //   485: aload 8
    //   487: invokeinterface 235 1 0
    //   492: invokeinterface 260 1 0
    //   497: aload_1
    //   498: ifnull -313 -> 185
    //   501: aload_1
    //   502: invokevirtual 264	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   505: astore_1
    //   506: goto -331 -> 175
    //   509: aload_1
    //   510: aload 7
    //   512: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   515: invokevirtual 319	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:k	(Ljava/lang/String;)V
    //   518: goto +338 -> 856
    //   521: astore_1
    //   522: aload 10
    //   524: astore 9
    //   526: aload 7
    //   528: ifnull +8 -> 536
    //   531: aload 7
    //   533: invokevirtual 257	java/io/DataInputStream:close	()V
    //   536: aload 9
    //   538: ifnull +15 -> 553
    //   541: aload 9
    //   543: invokeinterface 235 1 0
    //   548: invokeinterface 260 1 0
    //   553: aload 8
    //   555: ifnull +13 -> 568
    //   558: aload 8
    //   560: invokevirtual 264	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   563: invokeinterface 269 1 0
    //   568: aload_1
    //   569: athrow
    //   570: aload_1
    //   571: aload 7
    //   573: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   576: invokevirtual 322	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:l	(Ljava/lang/String;)V
    //   579: goto +277 -> 856
    //   582: aload_1
    //   583: aload 7
    //   585: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   588: invokevirtual 325	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:m	(Ljava/lang/String;)V
    //   591: goto +265 -> 856
    //   594: aload_1
    //   595: aload 7
    //   597: invokevirtual 291	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   600: invokevirtual 328	com/gau/go/launcherex/gowidget/weather/model/PluginCameraBean:n	(Ljava/lang/String;)V
    //   603: goto +253 -> 856
    //   606: aload_0
    //   607: getfield 36	com/gau/go/launcherex/gowidget/weather/b/ai:d	Ljava/util/ArrayList;
    //   610: aload_1
    //   611: invokevirtual 329	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: iload_2
    //   616: iconst_1
    //   617: isub
    //   618: istore_2
    //   619: goto -363 -> 256
    //   622: iconst_1
    //   623: istore 4
    //   625: aload 7
    //   627: ifnull +8 -> 635
    //   630: aload 7
    //   632: invokevirtual 257	java/io/DataInputStream:close	()V
    //   635: aload 10
    //   637: ifnull +15 -> 652
    //   640: aload 10
    //   642: invokeinterface 235 1 0
    //   647: invokeinterface 260 1 0
    //   652: iload 4
    //   654: istore 5
    //   656: aload 8
    //   658: ifnull -473 -> 185
    //   661: aload 8
    //   663: invokevirtual 264	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   666: astore_1
    //   667: goto -492 -> 175
    //   670: astore 7
    //   672: aload 7
    //   674: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   677: goto -141 -> 536
    //   680: astore 7
    //   682: aload 7
    //   684: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   687: goto -134 -> 553
    //   690: astore 7
    //   692: aload 7
    //   694: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   697: goto -217 -> 480
    //   700: astore 7
    //   702: aload 7
    //   704: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   707: goto -210 -> 497
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   715: goto -568 -> 147
    //   718: astore_1
    //   719: aload_1
    //   720: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   723: goto -559 -> 164
    //   726: astore_1
    //   727: aload_1
    //   728: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   731: goto -96 -> 635
    //   734: astore_1
    //   735: aload_1
    //   736: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   739: goto -87 -> 652
    //   742: astore_1
    //   743: aconst_null
    //   744: astore 9
    //   746: aconst_null
    //   747: astore 8
    //   749: aconst_null
    //   750: astore 7
    //   752: goto -226 -> 526
    //   755: astore_1
    //   756: aconst_null
    //   757: astore 9
    //   759: aconst_null
    //   760: astore 7
    //   762: goto -236 -> 526
    //   765: astore_1
    //   766: aconst_null
    //   767: astore 7
    //   769: aload 10
    //   771: astore 9
    //   773: goto -247 -> 526
    //   776: astore 9
    //   778: aload_1
    //   779: astore 10
    //   781: aload 9
    //   783: astore_1
    //   784: aload 8
    //   786: astore 9
    //   788: aload 10
    //   790: astore 8
    //   792: goto -266 -> 526
    //   795: astore 9
    //   797: aconst_null
    //   798: astore 8
    //   800: aconst_null
    //   801: astore 10
    //   803: aload 7
    //   805: astore_1
    //   806: aload 10
    //   808: astore 7
    //   810: goto -345 -> 465
    //   813: astore 9
    //   815: aconst_null
    //   816: astore 10
    //   818: aconst_null
    //   819: astore 7
    //   821: aload 8
    //   823: astore_1
    //   824: aload 10
    //   826: astore 8
    //   828: goto -363 -> 465
    //   831: astore 9
    //   833: aconst_null
    //   834: astore 7
    //   836: aload 8
    //   838: astore_1
    //   839: aload 10
    //   841: astore 8
    //   843: goto -378 -> 465
    //   846: aconst_null
    //   847: astore 7
    //   849: iload 6
    //   851: istore 4
    //   853: goto -228 -> 625
    //   856: iload_3
    //   857: iconst_1
    //   858: isub
    //   859: istore_3
    //   860: goto -460 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	ai
    //   0	863	1	paramList	List
    //   132	487	2	i	int
    //   399	461	3	j	int
    //   7	845	4	bool1	boolean
    //   1	654	5	bool2	boolean
    //   4	846	6	bool3	boolean
    //   10	621	7	localDataInputStream	java.io.DataInputStream
    //   670	3	7	localIOException1	IOException
    //   680	3	7	localIOException2	IOException
    //   690	3	7	localIOException3	IOException
    //   700	3	7	localIOException4	IOException
    //   750	98	7	localObject1	Object
    //   45	797	8	localObject2	Object
    //   21	29	9	localHttpPost	org.apache.http.client.methods.HttpPost
    //   456	10	9	localException1	Exception
    //   524	248	9	localObject3	Object
    //   776	6	9	localObject4	Object
    //   786	1	9	localObject5	Object
    //   795	1	9	localException2	Exception
    //   813	1	9	localException3	Exception
    //   831	1	9	localException4	Exception
    //   54	786	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   95	133	456	java/lang/Exception
    //   188	256	456	java/lang/Exception
    //   260	400	456	java/lang/Exception
    //   404	444	456	java/lang/Exception
    //   444	453	456	java/lang/Exception
    //   509	518	456	java/lang/Exception
    //   570	579	456	java/lang/Exception
    //   582	591	456	java/lang/Exception
    //   594	603	456	java/lang/Exception
    //   606	615	456	java/lang/Exception
    //   95	133	521	finally
    //   188	256	521	finally
    //   260	400	521	finally
    //   404	444	521	finally
    //   444	453	521	finally
    //   509	518	521	finally
    //   570	579	521	finally
    //   582	591	521	finally
    //   594	603	521	finally
    //   606	615	521	finally
    //   531	536	670	java/io/IOException
    //   541	553	680	java/io/IOException
    //   475	480	690	java/io/IOException
    //   485	497	700	java/io/IOException
    //   142	147	710	java/io/IOException
    //   152	164	718	java/io/IOException
    //   630	635	726	java/io/IOException
    //   640	652	734	java/io/IOException
    //   12	47	742	finally
    //   47	56	755	finally
    //   56	95	765	finally
    //   465	470	776	finally
    //   12	47	795	java/lang/Exception
    //   47	56	813	java/lang/Exception
    //   56	95	831	java/lang/Exception
  }
  
  private boolean d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator3 = this.d.iterator();
    if (localIterator3.hasNext())
    {
      PluginCameraBean localPluginCameraBean = (PluginCameraBean)localIterator3.next();
      ContentValues localContentValues = new ContentValues();
      if (localPluginCameraBean.p() == null)
      {
        localObject = "";
        label56:
        localContentValues.put("app_market_url", (String)localObject);
        localContentValues.put("download", localPluginCameraBean.n());
        if (localPluginCameraBean.o() != null) {
          break label386;
        }
        localObject = "";
        label89:
        localContentValues.put("ftp_url", (String)localObject);
        if (localPluginCameraBean.q() != null) {
          break label395;
        }
        localObject = "";
        label109:
        localContentValues.put("go_boutique_url", (String)localObject);
        if (localPluginCameraBean.s() != null) {
          break label404;
        }
        localObject = "";
        label129:
        localContentValues.put("web_market_url", (String)localObject);
        localContentValues.put("is_all", Integer.valueOf(localPluginCameraBean.b()));
        localContentValues.put("is_sale", Integer.valueOf(localPluginCameraBean.c()));
        localContentValues.put("name", localPluginCameraBean.d());
        if (localPluginCameraBean.r() != null) {
          break label413;
        }
      }
      label386:
      label395:
      label404:
      label413:
      for (localObject = "";; localObject = localPluginCameraBean.r())
      {
        localContentValues.put("other_url", (String)localObject);
        localContentValues.put("package_name", localPluginCameraBean.i());
        localContentValues.put("preview_id", localPluginCameraBean.e());
        localContentValues.put("price", localPluginCameraBean.k());
        localContentValues.put("fee_type", Integer.valueOf(localPluginCameraBean.j()));
        localContentValues.put("size", localPluginCameraBean.l());
        localContentValues.put("summary", localPluginCameraBean.f());
        localContentValues.put("theme_id", Integer.valueOf(localPluginCameraBean.a()));
        localContentValues.put("update_time", localPluginCameraBean.m());
        localContentValues.put("version", localPluginCameraBean.g());
        localContentValues.put("version_num", Integer.valueOf(localPluginCameraBean.h()));
        localContentValues.put("theme_type", Integer.valueOf(6));
        localArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.h).withValues(localContentValues).build());
        break;
        localObject = localPluginCameraBean.p();
        break label56;
        localObject = localPluginCameraBean.o();
        break label89;
        localObject = localPluginCameraBean.q();
        break label109;
        localObject = localPluginCameraBean.s();
        break label129;
      }
    }
    localIterator3 = null;
    Object localObject = localIterator3;
    if (localArrayList.size() > 0) {}
    try
    {
      localObject = this.b.getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
      if ((localArrayList.size() > 0) && (localObject != null) && (localObject.length > 0)) {
        return true;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        Iterator localIterator1 = localIterator3;
      }
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      for (;;)
      {
        localOperationApplicationException.printStackTrace();
        Iterator localIterator2 = localIterator3;
      }
    }
    return false;
  }
  
  private void e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", this.c.b() + "");
    this.e.a(2, null, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "plugin_camera_data_timestamp" });
  }
  
  public void a()
  {
    this.e.a(1, null, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "plugin_camera_data_timestamp" }, null);
  }
  
  public void b()
  {
    this.a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */