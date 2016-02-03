package mobi.beyondpod.sync.trackers.bp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class BeyondPodServiceClientV1
{
  private static final int CLIENT_VERSION = 1;
  private static final String TAG = "BeyondPodServiceClientV1";
  private Uri restUrlRoot;
  
  public BeyondPodServiceClientV1()
  {
    this(Configuration.CDSServiceEndpoint());
  }
  
  public BeyondPodServiceClientV1(Uri paramUri)
  {
    setRestUrlRoot(paramUri);
  }
  
  private static String GetHeader(HttpResponse paramHttpResponse, String paramString)
  {
    paramHttpResponse = paramHttpResponse.getHeaders(paramString);
    if (paramHttpResponse.length > 0) {
      return paramHttpResponse[0].getValue();
    }
    return null;
  }
  
  private static Date GetResponseDateFrom(HttpResponse paramHttpResponse)
  {
    return DateTime.TryParseRFC822Time(GetHeader(paramHttpResponse, "Date"), null);
  }
  
  /* Error */
  private AuthenticationResult authenticateUserBeyondPod(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
    throws AuthenticationException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   12: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   15: astore 8
    //   17: aload 8
    //   19: astore 9
    //   21: aload 8
    //   23: astore 7
    //   25: aload 8
    //   27: astore 10
    //   29: new 78	org/apache/http/client/methods/HttpPost
    //   32: dup
    //   33: new 80	java/net/URI
    //   36: dup
    //   37: new 82	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc 91
    //   53: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   62: invokespecial 103	org/apache/http/client/methods/HttpPost:<init>	(Ljava/net/URI;)V
    //   65: astore 11
    //   67: aload 8
    //   69: astore 9
    //   71: aload 8
    //   73: astore 7
    //   75: aload 8
    //   77: astore 10
    //   79: aload 11
    //   81: ldc 105
    //   83: ldc 107
    //   85: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 8
    //   90: astore 9
    //   92: aload 8
    //   94: astore 7
    //   96: aload 8
    //   98: astore 10
    //   100: aload 11
    //   102: ldc 113
    //   104: iconst_1
    //   105: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 8
    //   113: astore 9
    //   115: aload 8
    //   117: astore 7
    //   119: aload 8
    //   121: astore 10
    //   123: aload 11
    //   125: ldc 121
    //   127: aload_0
    //   128: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   131: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 8
    //   136: astore 9
    //   138: aload 8
    //   140: astore 7
    //   142: aload 8
    //   144: astore 10
    //   146: new 126	java/util/ArrayList
    //   149: dup
    //   150: iconst_3
    //   151: invokespecial 129	java/util/ArrayList:<init>	(I)V
    //   154: astore 12
    //   156: aload 8
    //   158: astore 9
    //   160: aload 8
    //   162: astore 7
    //   164: aload 8
    //   166: astore 10
    //   168: aload 12
    //   170: new 131	org/apache/http/message/BasicNameValuePair
    //   173: dup
    //   174: ldc -123
    //   176: aload_1
    //   177: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokeinterface 141 2 0
    //   185: pop
    //   186: aload 8
    //   188: astore 9
    //   190: aload 8
    //   192: astore 7
    //   194: aload 8
    //   196: astore 10
    //   198: aload 12
    //   200: new 131	org/apache/http/message/BasicNameValuePair
    //   203: dup
    //   204: ldc -113
    //   206: aload_2
    //   207: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: invokeinterface 141 2 0
    //   215: pop
    //   216: aload 8
    //   218: astore 9
    //   220: aload 8
    //   222: astore 7
    //   224: aload 8
    //   226: astore 10
    //   228: aload 12
    //   230: new 131	org/apache/http/message/BasicNameValuePair
    //   233: dup
    //   234: ldc -111
    //   236: aload_3
    //   237: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: invokeinterface 141 2 0
    //   245: pop
    //   246: iload 4
    //   248: ifeq +338 -> 586
    //   251: ldc -109
    //   253: astore_1
    //   254: aload 8
    //   256: astore 9
    //   258: aload 8
    //   260: astore 7
    //   262: aload 8
    //   264: astore 10
    //   266: aload 12
    //   268: new 131	org/apache/http/message/BasicNameValuePair
    //   271: dup
    //   272: ldc -107
    //   274: aload_1
    //   275: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: invokeinterface 141 2 0
    //   283: pop
    //   284: iload 5
    //   286: ifeq +677 -> 963
    //   289: ldc -109
    //   291: astore_1
    //   292: aload 8
    //   294: astore 9
    //   296: aload 8
    //   298: astore 7
    //   300: aload 8
    //   302: astore 10
    //   304: aload 12
    //   306: new 131	org/apache/http/message/BasicNameValuePair
    //   309: dup
    //   310: ldc -105
    //   312: aload_1
    //   313: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: invokeinterface 141 2 0
    //   321: pop
    //   322: aload 8
    //   324: astore 9
    //   326: aload 8
    //   328: astore 7
    //   330: aload 8
    //   332: astore 10
    //   334: aload 11
    //   336: new 153	org/apache/http/client/entity/UrlEncodedFormEntity
    //   339: dup
    //   340: aload 12
    //   342: invokespecial 156	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;)V
    //   345: invokevirtual 160	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   348: aload 8
    //   350: astore 9
    //   352: aload 8
    //   354: astore 7
    //   356: aload 8
    //   358: astore 10
    //   360: aload 8
    //   362: aload 11
    //   364: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   367: astore_1
    //   368: aload 8
    //   370: astore 9
    //   372: aload 8
    //   374: astore 7
    //   376: aload 8
    //   378: astore 10
    //   380: new 166	org/json/JSONObject
    //   383: dup
    //   384: aload_1
    //   385: invokeinterface 170 1 0
    //   390: invokestatic 175	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   393: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   396: astore_3
    //   397: aload 8
    //   399: astore 9
    //   401: aload 8
    //   403: astore 7
    //   405: aload 8
    //   407: astore 10
    //   409: aload_3
    //   410: ldc -78
    //   412: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   415: istore 6
    //   417: aload 8
    //   419: astore 9
    //   421: aload 8
    //   423: astore 7
    //   425: aload 8
    //   427: astore 10
    //   429: iload 6
    //   431: getstatic 187	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:AUTH_RESULT_AUTHENTICATED	I
    //   434: if_icmpeq +271 -> 705
    //   437: aload 8
    //   439: astore 9
    //   441: aload 8
    //   443: astore 7
    //   445: aload 8
    //   447: astore 10
    //   449: iload 6
    //   451: getstatic 190	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:AUTH_RESULT_ACCOUNT_CREATED	I
    //   454: if_icmpne +138 -> 592
    //   457: aload 8
    //   459: astore 9
    //   461: aload 8
    //   463: astore 7
    //   465: aload 8
    //   467: astore 10
    //   469: new 184	mobi/beyondpod/sync/trackers/bp/AuthenticationResult
    //   472: dup
    //   473: invokespecial 191	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:<init>	()V
    //   476: astore_2
    //   477: aload 8
    //   479: astore 9
    //   481: aload 8
    //   483: astore 7
    //   485: aload 8
    //   487: astore 10
    //   489: aload_2
    //   490: aconst_null
    //   491: invokevirtual 194	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setToken	(Ljava/lang/String;)V
    //   494: aload 8
    //   496: astore 9
    //   498: aload 8
    //   500: astore 7
    //   502: aload 8
    //   504: astore 10
    //   506: aload_2
    //   507: aconst_null
    //   508: invokevirtual 198	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setTokenExpires	(Ljava/util/Date;)V
    //   511: aload 8
    //   513: astore 9
    //   515: aload 8
    //   517: astore 7
    //   519: aload 8
    //   521: astore 10
    //   523: aload_2
    //   524: iconst_1
    //   525: invokevirtual 202	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setWaitingForEmailVerification	(Z)V
    //   528: aload 8
    //   530: astore 9
    //   532: aload 8
    //   534: astore 7
    //   536: aload 8
    //   538: astore 10
    //   540: aload_2
    //   541: aload_3
    //   542: ldc -52
    //   544: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   547: invokevirtual 211	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setEncryptedPassword	(Ljava/lang/String;)V
    //   550: aload 8
    //   552: astore 9
    //   554: aload 8
    //   556: astore 7
    //   558: aload 8
    //   560: astore 10
    //   562: aload_2
    //   563: aload_1
    //   564: invokestatic 213	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:GetResponseDateFrom	(Lorg/apache/http/HttpResponse;)Ljava/util/Date;
    //   567: invokevirtual 216	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setServerDate	(Ljava/util/Date;)V
    //   570: aload_2
    //   571: astore_1
    //   572: aload 8
    //   574: ifnull +10 -> 584
    //   577: aload 8
    //   579: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   582: aload_2
    //   583: astore_1
    //   584: aload_1
    //   585: areturn
    //   586: ldc -35
    //   588: astore_1
    //   589: goto -335 -> 254
    //   592: aload 8
    //   594: astore 9
    //   596: aload 8
    //   598: astore 7
    //   600: aload 8
    //   602: astore 10
    //   604: iload 6
    //   606: getstatic 224	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:AUTH_RESULT_SERVER_ERROR	I
    //   609: if_icmpne +49 -> 658
    //   612: aload 8
    //   614: astore 9
    //   616: aload 8
    //   618: astore 7
    //   620: aload 8
    //   622: astore 10
    //   624: new 67	java/lang/Exception
    //   627: dup
    //   628: aload_3
    //   629: ldc -30
    //   631: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   634: invokespecial 227	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   637: athrow
    //   638: astore_1
    //   639: aload 9
    //   641: astore 7
    //   643: aload_1
    //   644: athrow
    //   645: astore_1
    //   646: aload 7
    //   648: ifnull +8 -> 656
    //   651: aload 7
    //   653: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   656: aload_1
    //   657: athrow
    //   658: aload 8
    //   660: astore 9
    //   662: aload 8
    //   664: astore 7
    //   666: aload 8
    //   668: astore 10
    //   670: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   673: dup
    //   674: iload 6
    //   676: aload_3
    //   677: ldc -30
    //   679: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   682: aconst_null
    //   683: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: athrow
    //   687: astore_1
    //   688: aload 10
    //   690: astore 7
    //   692: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   695: dup
    //   696: bipush -100
    //   698: ldc -24
    //   700: aload_1
    //   701: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   704: athrow
    //   705: aload 8
    //   707: astore 9
    //   709: aload 8
    //   711: astore 7
    //   713: aload 8
    //   715: astore 10
    //   717: aload_3
    //   718: ldc -21
    //   720: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   723: astore 11
    //   725: aload 11
    //   727: ifnull +25 -> 752
    //   730: aload 8
    //   732: astore 9
    //   734: aload 8
    //   736: astore 7
    //   738: aload 8
    //   740: astore 10
    //   742: ldc -19
    //   744: aload 11
    //   746: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +27 -> 776
    //   752: aload 8
    //   754: astore 9
    //   756: aload 8
    //   758: astore 7
    //   760: aload 8
    //   762: astore 10
    //   764: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   767: dup
    //   768: iconst_m1
    //   769: ldc -14
    //   771: aconst_null
    //   772: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   775: athrow
    //   776: aload 8
    //   778: astore 9
    //   780: aload 8
    //   782: astore 7
    //   784: aload 8
    //   786: astore 10
    //   788: aload_3
    //   789: ldc -12
    //   791: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   794: astore 12
    //   796: aload 12
    //   798: ifnull +25 -> 823
    //   801: aload 8
    //   803: astore 9
    //   805: aload 8
    //   807: astore 7
    //   809: aload 8
    //   811: astore 10
    //   813: ldc -19
    //   815: aload 12
    //   817: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   820: ifeq +27 -> 847
    //   823: aload 8
    //   825: astore 9
    //   827: aload 8
    //   829: astore 7
    //   831: aload 8
    //   833: astore 10
    //   835: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   838: dup
    //   839: iconst_m1
    //   840: ldc -10
    //   842: aconst_null
    //   843: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   846: athrow
    //   847: aload 8
    //   849: astore 9
    //   851: aload 8
    //   853: astore 7
    //   855: aload 8
    //   857: astore 10
    //   859: new 184	mobi/beyondpod/sync/trackers/bp/AuthenticationResult
    //   862: dup
    //   863: invokespecial 191	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:<init>	()V
    //   866: astore_2
    //   867: aload 8
    //   869: astore 9
    //   871: aload 8
    //   873: astore 7
    //   875: aload 8
    //   877: astore 10
    //   879: aload_2
    //   880: aload 11
    //   882: invokevirtual 194	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setToken	(Ljava/lang/String;)V
    //   885: aload 8
    //   887: astore 9
    //   889: aload 8
    //   891: astore 7
    //   893: aload 8
    //   895: astore 10
    //   897: aload_2
    //   898: aload_3
    //   899: ldc -52
    //   901: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   904: invokevirtual 211	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setEncryptedPassword	(Ljava/lang/String;)V
    //   907: aload 8
    //   909: astore 9
    //   911: aload 8
    //   913: astore 7
    //   915: aload 8
    //   917: astore 10
    //   919: aload_2
    //   920: aload_0
    //   921: aload 12
    //   923: invokespecial 250	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:parseDate	(Ljava/lang/String;)Ljava/util/Date;
    //   926: invokevirtual 198	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setTokenExpires	(Ljava/util/Date;)V
    //   929: aload 8
    //   931: astore 9
    //   933: aload 8
    //   935: astore 7
    //   937: aload 8
    //   939: astore 10
    //   941: aload_2
    //   942: aload_1
    //   943: invokestatic 213	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:GetResponseDateFrom	(Lorg/apache/http/HttpResponse;)Ljava/util/Date;
    //   946: invokevirtual 216	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setServerDate	(Ljava/util/Date;)V
    //   949: aload_2
    //   950: astore_1
    //   951: aload 8
    //   953: ifnull -369 -> 584
    //   956: aload 8
    //   958: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   961: aload_2
    //   962: areturn
    //   963: ldc -35
    //   965: astore_1
    //   966: goto -674 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	this	BeyondPodServiceClientV1
    //   0	969	1	paramString1	String
    //   0	969	2	paramString2	String
    //   0	969	3	paramString3	String
    //   0	969	4	paramBoolean1	boolean
    //   0	969	5	paramBoolean2	boolean
    //   415	260	6	i	int
    //   1	935	7	localObject1	Object
    //   15	942	8	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   7	925	9	localObject2	Object
    //   4	936	10	localObject3	Object
    //   65	816	11	localObject4	Object
    //   154	768	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   29	67	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   79	88	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   100	111	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   123	134	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   146	156	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   168	186	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   198	216	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   228	246	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   266	284	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   304	322	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   334	348	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   360	368	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   380	397	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   409	417	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   429	437	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   449	457	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   469	477	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   489	494	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   506	511	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   523	528	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   540	550	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   562	570	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   604	612	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   624	638	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   670	687	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   717	725	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   742	752	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   764	776	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   788	796	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   813	823	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   835	847	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   859	867	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   879	885	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   897	907	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   919	929	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   941	949	638	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   9	17	645	finally
    //   29	67	645	finally
    //   79	88	645	finally
    //   100	111	645	finally
    //   123	134	645	finally
    //   146	156	645	finally
    //   168	186	645	finally
    //   198	216	645	finally
    //   228	246	645	finally
    //   266	284	645	finally
    //   304	322	645	finally
    //   334	348	645	finally
    //   360	368	645	finally
    //   380	397	645	finally
    //   409	417	645	finally
    //   429	437	645	finally
    //   449	457	645	finally
    //   469	477	645	finally
    //   489	494	645	finally
    //   506	511	645	finally
    //   523	528	645	finally
    //   540	550	645	finally
    //   562	570	645	finally
    //   604	612	645	finally
    //   624	638	645	finally
    //   643	645	645	finally
    //   670	687	645	finally
    //   692	705	645	finally
    //   717	725	645	finally
    //   742	752	645	finally
    //   764	776	645	finally
    //   788	796	645	finally
    //   813	823	645	finally
    //   835	847	645	finally
    //   859	867	645	finally
    //   879	885	645	finally
    //   897	907	645	finally
    //   919	929	645	finally
    //   941	949	645	finally
    //   9	17	687	java/lang/Exception
    //   29	67	687	java/lang/Exception
    //   79	88	687	java/lang/Exception
    //   100	111	687	java/lang/Exception
    //   123	134	687	java/lang/Exception
    //   146	156	687	java/lang/Exception
    //   168	186	687	java/lang/Exception
    //   198	216	687	java/lang/Exception
    //   228	246	687	java/lang/Exception
    //   266	284	687	java/lang/Exception
    //   304	322	687	java/lang/Exception
    //   334	348	687	java/lang/Exception
    //   360	368	687	java/lang/Exception
    //   380	397	687	java/lang/Exception
    //   409	417	687	java/lang/Exception
    //   429	437	687	java/lang/Exception
    //   449	457	687	java/lang/Exception
    //   469	477	687	java/lang/Exception
    //   489	494	687	java/lang/Exception
    //   506	511	687	java/lang/Exception
    //   523	528	687	java/lang/Exception
    //   540	550	687	java/lang/Exception
    //   562	570	687	java/lang/Exception
    //   604	612	687	java/lang/Exception
    //   624	638	687	java/lang/Exception
    //   670	687	687	java/lang/Exception
    //   717	725	687	java/lang/Exception
    //   742	752	687	java/lang/Exception
    //   764	776	687	java/lang/Exception
    //   788	796	687	java/lang/Exception
    //   813	823	687	java/lang/Exception
    //   835	847	687	java/lang/Exception
    //   859	867	687	java/lang/Exception
    //   879	885	687	java/lang/Exception
    //   897	907	687	java/lang/Exception
    //   919	929	687	java/lang/Exception
    //   941	949	687	java/lang/Exception
  }
  
  /* Error */
  private AuthenticationResult authenticateUserGoogle(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws AuthenticationException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   12: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   15: astore 8
    //   17: aload 8
    //   19: astore 7
    //   21: aload 8
    //   23: astore 6
    //   25: aload 8
    //   27: astore 9
    //   29: new 78	org/apache/http/client/methods/HttpPost
    //   32: dup
    //   33: new 80	java/net/URI
    //   36: dup
    //   37: new 82	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc -1
    //   53: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   62: invokespecial 103	org/apache/http/client/methods/HttpPost:<init>	(Ljava/net/URI;)V
    //   65: astore 10
    //   67: aload 8
    //   69: astore 7
    //   71: aload 8
    //   73: astore 6
    //   75: aload 8
    //   77: astore 9
    //   79: aload 10
    //   81: ldc 105
    //   83: ldc 107
    //   85: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 8
    //   90: astore 7
    //   92: aload 8
    //   94: astore 6
    //   96: aload 8
    //   98: astore 9
    //   100: aload 10
    //   102: ldc 113
    //   104: iconst_1
    //   105: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 8
    //   113: astore 7
    //   115: aload 8
    //   117: astore 6
    //   119: aload 8
    //   121: astore 9
    //   123: aload 10
    //   125: ldc 121
    //   127: aload_0
    //   128: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   131: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 8
    //   136: astore 7
    //   138: aload 8
    //   140: astore 6
    //   142: aload 8
    //   144: astore 9
    //   146: new 126	java/util/ArrayList
    //   149: dup
    //   150: iconst_3
    //   151: invokespecial 129	java/util/ArrayList:<init>	(I)V
    //   154: astore 11
    //   156: aload 8
    //   158: astore 7
    //   160: aload 8
    //   162: astore 6
    //   164: aload 8
    //   166: astore 9
    //   168: aload 11
    //   170: new 131	org/apache/http/message/BasicNameValuePair
    //   173: dup
    //   174: ldc -123
    //   176: aload_1
    //   177: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokeinterface 141 2 0
    //   185: pop
    //   186: aload 8
    //   188: astore 7
    //   190: aload 8
    //   192: astore 6
    //   194: aload 8
    //   196: astore 9
    //   198: aload 11
    //   200: new 131	org/apache/http/message/BasicNameValuePair
    //   203: dup
    //   204: ldc_w 257
    //   207: aload_2
    //   208: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: invokeinterface 141 2 0
    //   216: pop
    //   217: aload 8
    //   219: astore 7
    //   221: aload 8
    //   223: astore 6
    //   225: aload 8
    //   227: astore 9
    //   229: aload 11
    //   231: new 131	org/apache/http/message/BasicNameValuePair
    //   234: dup
    //   235: ldc -111
    //   237: aload_3
    //   238: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: invokeinterface 141 2 0
    //   246: pop
    //   247: iload 4
    //   249: ifeq +171 -> 420
    //   252: ldc -109
    //   254: astore_1
    //   255: aload 8
    //   257: astore 7
    //   259: aload 8
    //   261: astore 6
    //   263: aload 8
    //   265: astore 9
    //   267: aload 11
    //   269: new 131	org/apache/http/message/BasicNameValuePair
    //   272: dup
    //   273: ldc -107
    //   275: aload_1
    //   276: invokespecial 135	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: invokeinterface 141 2 0
    //   284: pop
    //   285: aload 8
    //   287: astore 7
    //   289: aload 8
    //   291: astore 6
    //   293: aload 8
    //   295: astore 9
    //   297: aload 10
    //   299: new 153	org/apache/http/client/entity/UrlEncodedFormEntity
    //   302: dup
    //   303: aload 11
    //   305: invokespecial 156	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;)V
    //   308: invokevirtual 160	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   311: aload 8
    //   313: astore 7
    //   315: aload 8
    //   317: astore 6
    //   319: aload 8
    //   321: astore 9
    //   323: new 166	org/json/JSONObject
    //   326: dup
    //   327: aload 8
    //   329: aload 10
    //   331: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   334: invokeinterface 170 1 0
    //   339: invokestatic 175	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   342: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   345: astore_2
    //   346: aload 8
    //   348: astore 7
    //   350: aload 8
    //   352: astore 6
    //   354: aload 8
    //   356: astore 9
    //   358: aload_2
    //   359: ldc -78
    //   361: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   364: istore 5
    //   366: iload 5
    //   368: ifeq +58 -> 426
    //   371: aload 8
    //   373: astore 7
    //   375: aload 8
    //   377: astore 6
    //   379: aload 8
    //   381: astore 9
    //   383: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   386: dup
    //   387: iload 5
    //   389: aload_2
    //   390: ldc -30
    //   392: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   395: aconst_null
    //   396: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: athrow
    //   400: astore_1
    //   401: aload 7
    //   403: astore 6
    //   405: aload_1
    //   406: athrow
    //   407: astore_1
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   418: aload_1
    //   419: athrow
    //   420: ldc -35
    //   422: astore_1
    //   423: goto -168 -> 255
    //   426: aload 8
    //   428: astore 7
    //   430: aload 8
    //   432: astore 6
    //   434: aload 8
    //   436: astore 9
    //   438: aload_2
    //   439: ldc -21
    //   441: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +24 -> 470
    //   449: aload 8
    //   451: astore 7
    //   453: aload 8
    //   455: astore 6
    //   457: aload 8
    //   459: astore 9
    //   461: ldc -19
    //   463: aload_1
    //   464: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +45 -> 512
    //   470: aload 8
    //   472: astore 7
    //   474: aload 8
    //   476: astore 6
    //   478: aload 8
    //   480: astore 9
    //   482: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   485: dup
    //   486: iconst_m1
    //   487: ldc -14
    //   489: aconst_null
    //   490: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: athrow
    //   494: astore_1
    //   495: aload 9
    //   497: astore 6
    //   499: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   502: dup
    //   503: bipush -100
    //   505: ldc -24
    //   507: aload_1
    //   508: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   511: athrow
    //   512: aload 8
    //   514: astore 7
    //   516: aload 8
    //   518: astore 6
    //   520: aload 8
    //   522: astore 9
    //   524: aload_2
    //   525: ldc -12
    //   527: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_2
    //   531: aload_2
    //   532: ifnull +24 -> 556
    //   535: aload 8
    //   537: astore 7
    //   539: aload 8
    //   541: astore 6
    //   543: aload 8
    //   545: astore 9
    //   547: ldc -19
    //   549: aload_2
    //   550: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifeq +27 -> 580
    //   556: aload 8
    //   558: astore 7
    //   560: aload 8
    //   562: astore 6
    //   564: aload 8
    //   566: astore 9
    //   568: new 63	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   571: dup
    //   572: iconst_m1
    //   573: ldc -10
    //   575: aconst_null
    //   576: invokespecial 230	mobi/beyondpod/sync/trackers/bp/AuthenticationException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: athrow
    //   580: aload 8
    //   582: astore 7
    //   584: aload 8
    //   586: astore 6
    //   588: aload 8
    //   590: astore 9
    //   592: new 184	mobi/beyondpod/sync/trackers/bp/AuthenticationResult
    //   595: dup
    //   596: invokespecial 191	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:<init>	()V
    //   599: astore_3
    //   600: aload 8
    //   602: astore 7
    //   604: aload 8
    //   606: astore 6
    //   608: aload 8
    //   610: astore 9
    //   612: aload_3
    //   613: aload_1
    //   614: invokevirtual 194	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setToken	(Ljava/lang/String;)V
    //   617: aload 8
    //   619: astore 7
    //   621: aload 8
    //   623: astore 6
    //   625: aload 8
    //   627: astore 9
    //   629: aload_3
    //   630: new 259	java/text/SimpleDateFormat
    //   633: dup
    //   634: ldc_w 261
    //   637: invokespecial 262	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   640: aload_2
    //   641: invokevirtual 265	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   644: invokevirtual 198	mobi/beyondpod/sync/trackers/bp/AuthenticationResult:setTokenExpires	(Ljava/util/Date;)V
    //   647: aload 8
    //   649: ifnull +8 -> 657
    //   652: aload 8
    //   654: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   657: aload_3
    //   658: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	BeyondPodServiceClientV1
    //   0	659	1	paramString1	String
    //   0	659	2	paramString2	String
    //   0	659	3	paramString3	String
    //   0	659	4	paramBoolean	boolean
    //   364	24	5	i	int
    //   1	623	6	localObject1	Object
    //   7	613	7	localObject2	Object
    //   15	638	8	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   4	624	9	localObject3	Object
    //   65	265	10	localHttpPost	org.apache.http.client.methods.HttpPost
    //   154	150	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	17	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   29	67	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   79	88	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   100	111	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   123	134	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   146	156	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   168	186	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   198	217	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   229	247	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   267	285	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   297	311	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   323	346	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   358	366	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   383	400	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   438	445	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   461	470	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   482	494	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   524	531	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   547	556	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   568	580	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   592	600	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   612	617	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   629	647	400	mobi/beyondpod/sync/trackers/bp/AuthenticationException
    //   9	17	407	finally
    //   29	67	407	finally
    //   79	88	407	finally
    //   100	111	407	finally
    //   123	134	407	finally
    //   146	156	407	finally
    //   168	186	407	finally
    //   198	217	407	finally
    //   229	247	407	finally
    //   267	285	407	finally
    //   297	311	407	finally
    //   323	346	407	finally
    //   358	366	407	finally
    //   383	400	407	finally
    //   405	407	407	finally
    //   438	445	407	finally
    //   461	470	407	finally
    //   482	494	407	finally
    //   499	512	407	finally
    //   524	531	407	finally
    //   547	556	407	finally
    //   568	580	407	finally
    //   592	600	407	finally
    //   612	617	407	finally
    //   629	647	407	finally
    //   9	17	494	java/lang/Exception
    //   29	67	494	java/lang/Exception
    //   79	88	494	java/lang/Exception
    //   100	111	494	java/lang/Exception
    //   123	134	494	java/lang/Exception
    //   146	156	494	java/lang/Exception
    //   168	186	494	java/lang/Exception
    //   198	217	494	java/lang/Exception
    //   229	247	494	java/lang/Exception
    //   267	285	494	java/lang/Exception
    //   297	311	494	java/lang/Exception
    //   323	346	494	java/lang/Exception
    //   358	366	494	java/lang/Exception
    //   383	400	494	java/lang/Exception
    //   438	445	494	java/lang/Exception
    //   461	470	494	java/lang/Exception
    //   482	494	494	java/lang/Exception
    //   524	531	494	java/lang/Exception
    //   547	556	494	java/lang/Exception
    //   568	580	494	java/lang/Exception
    //   592	600	494	java/lang/Exception
    //   612	617	494	java/lang/Exception
    //   629	647	494	java/lang/Exception
  }
  
  private List<DeviceActivity> createList(JSONObject paramJSONObject)
    throws ServiceException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int j;
    int i;
    try
    {
      if (paramJSONObject.isNull("DeviceActivities")) {
        break label234;
      }
      paramJSONObject = paramJSONObject.getJSONObject("DeviceActivities");
      if ((paramJSONObject == null) || (paramJSONObject.isNull("DeviceActivity"))) {
        break label234;
      }
      localObject = paramJSONObject.get("DeviceActivity");
      paramJSONObject = null;
      if ((localObject instanceof JSONArray)) {
        paramJSONObject = (JSONArray)localObject;
      }
      for (;;)
      {
        if (paramJSONObject == null) {
          break label234;
        }
        j = paramJSONObject.length();
        i = 0;
        break;
        if ((localObject instanceof JSONObject))
        {
          paramJSONObject = new JSONArray();
          paramJSONObject.put((JSONObject)localObject);
        }
      }
      localObject = paramJSONObject.getJSONObject(i);
    }
    catch (Exception paramJSONObject)
    {
      throw new ServiceException(-1, "Failed to parse service activity records", paramJSONObject);
    }
    do
    {
      DeviceActivity localDeviceActivity = new DeviceActivity();
      try
      {
        localDeviceActivity.setDateTime(parseDate(((JSONObject)localObject).getString("DateTime")));
        localDeviceActivity.setType(((JSONObject)localObject).getString("Type"));
        localDeviceActivity.setData(((JSONObject)localObject).getString("Data"));
        localDeviceActivity.setDevice(((JSONObject)localObject).getString("DeviceMeta"));
        localArrayList.add(localDeviceActivity);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("BeyondPodServices", "error parsing activity date", localException);
        }
      }
    } while (i < j);
    label234:
    return localArrayList;
  }
  
  private String formatDate(Date paramDate)
  {
    if (paramDate == null) {
      paramDate = "";
    }
    String str;
    do
    {
      return paramDate;
      str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(paramDate);
      paramDate = str;
    } while (str.length() <= 3);
    paramDate = new StringBuilder(str);
    paramDate.insert(str.length() - 2, ":");
    return paramDate.toString();
  }
  
  private String getSoftwareVersion()
  {
    try
    {
      Object localObject = BeyondPodApplication.GetInstance();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private Date parseDate(String paramString)
  {
    if (paramString != null) {
      try
      {
        if ("".equals(paramString)) {
          return null;
        }
        SimpleDateFormat localSimpleDateFormat;
        if ((paramString.endsWith("Z")) || (paramString.endsWith("z")))
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          return localSimpleDateFormat.parse(paramString.substring(0, paramString.length() - 1));
        }
        if (paramString.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[-\\+]{0,1}\\d{2}:\\d{2}$"))
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
          localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
          return localSimpleDateFormat.parse(paramString.substring(0, paramString.length() - 3) + paramString.substring(paramString.length() - 2, paramString.length()));
        }
        if (paramString.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[-\\+]{0,1}\\d{4}$"))
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
          localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
          return localSimpleDateFormat.parse(paramString);
        }
        throw new IllegalArgumentException("couldn't parse date: " + paramString);
      }
      catch (Exception localException)
      {
        CoreHelper.LogException("BeyondPodServiceClientV1", "Filed to parse date:" + paramString, localException);
      }
    }
    return null;
  }
  
  public AuthenticationResult authenticateUser(String paramString1, String paramString2, AuthType paramAuthType, String paramString3, boolean paramBoolean)
    throws AuthenticationException, ServiceException
  {
    if (paramAuthType == AuthType.BeyondPod) {
      return authenticateUserBeyondPod(paramString1, paramString2, paramString3, false, paramBoolean);
    }
    if (paramAuthType == AuthType.Google)
    {
      if (paramBoolean) {
        throw new IllegalArgumentException("when authenticating via google, you can NOT use the reAuthenticatingUsingEncryptedPassword feature.");
      }
      return authenticateUserGoogle(paramString1, paramString2, paramString3, false);
    }
    throw new UnsupportedOperationException("invalid authType specified");
  }
  
  /* Error */
  public void gcmBroadcast(String paramString)
    throws InvalidTokenException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 5
    //   11: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   14: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   17: astore 4
    //   19: aload 4
    //   21: astore 5
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: astore 6
    //   30: aload 4
    //   32: astore 7
    //   34: new 451	org/apache/http/client/methods/HttpGet
    //   37: dup
    //   38: new 80	java/net/URI
    //   41: dup
    //   42: new 82	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   49: aload_0
    //   50: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   53: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: ldc_w 453
    //   59: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   68: invokespecial 454	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   71: astore 8
    //   73: aload 4
    //   75: astore 5
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: astore 6
    //   84: aload 4
    //   86: astore 7
    //   88: aload 8
    //   90: ldc 105
    //   92: ldc 107
    //   94: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 4
    //   99: astore 5
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: aload 8
    //   114: ldc_w 457
    //   117: ldc 107
    //   119: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 4
    //   124: astore 5
    //   126: aload 4
    //   128: astore_3
    //   129: aload 4
    //   131: astore 6
    //   133: aload 4
    //   135: astore 7
    //   137: aload 8
    //   139: ldc_w 459
    //   142: aload_1
    //   143: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 4
    //   148: astore 5
    //   150: aload 4
    //   152: astore_3
    //   153: aload 4
    //   155: astore 6
    //   157: aload 4
    //   159: astore 7
    //   161: aload 8
    //   163: ldc 113
    //   165: iconst_1
    //   166: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 4
    //   174: astore 5
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: astore 6
    //   183: aload 4
    //   185: astore 7
    //   187: aload 8
    //   189: ldc 121
    //   191: aload_0
    //   192: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   195: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 4
    //   200: astore 5
    //   202: aload 4
    //   204: astore_3
    //   205: aload 4
    //   207: astore 6
    //   209: aload 4
    //   211: astore 7
    //   213: aload 4
    //   215: aload 8
    //   217: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   220: astore_1
    //   221: aload 4
    //   223: astore 5
    //   225: aload 4
    //   227: astore_3
    //   228: aload 4
    //   230: astore 6
    //   232: aload 4
    //   234: astore 7
    //   236: aload_1
    //   237: invokeinterface 463 1 0
    //   242: invokeinterface 468 1 0
    //   247: sipush 403
    //   250: if_icmpne +47 -> 297
    //   253: aload 4
    //   255: astore 5
    //   257: aload 4
    //   259: astore_3
    //   260: aload 4
    //   262: astore 6
    //   264: aload 4
    //   266: astore 7
    //   268: new 449	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   271: dup
    //   272: ldc_w 470
    //   275: aconst_null
    //   276: invokespecial 473	mobi/beyondpod/sync/trackers/bp/InvalidTokenException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: athrow
    //   280: astore_1
    //   281: aload 5
    //   283: astore_3
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: aload 4
    //   299: astore 5
    //   301: aload 4
    //   303: astore_3
    //   304: aload 4
    //   306: astore 6
    //   308: aload 4
    //   310: astore 7
    //   312: new 166	org/json/JSONObject
    //   315: dup
    //   316: aload_1
    //   317: invokeinterface 170 1 0
    //   322: invokestatic 175	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   325: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   328: astore_1
    //   329: aload 4
    //   331: astore 5
    //   333: aload 4
    //   335: astore_3
    //   336: aload 4
    //   338: astore 6
    //   340: aload 4
    //   342: astore 7
    //   344: aload_1
    //   345: ldc -78
    //   347: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   350: istore_2
    //   351: iload_2
    //   352: ifeq +57 -> 409
    //   355: aload 4
    //   357: astore 5
    //   359: aload 4
    //   361: astore_3
    //   362: aload 4
    //   364: astore 6
    //   366: aload 4
    //   368: astore 7
    //   370: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   373: dup
    //   374: iload_2
    //   375: aload_1
    //   376: ldc -30
    //   378: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   381: aconst_null
    //   382: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   385: athrow
    //   386: astore_1
    //   387: aload 6
    //   389: astore_3
    //   390: aload_1
    //   391: athrow
    //   392: astore_1
    //   393: aload 7
    //   395: astore_3
    //   396: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   399: dup
    //   400: iconst_m1
    //   401: ldc_w 475
    //   404: aload_1
    //   405: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: athrow
    //   409: aload 4
    //   411: ifnull +8 -> 419
    //   414: aload 4
    //   416: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   419: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	BeyondPodServiceClientV1
    //   0	420	1	paramString	String
    //   350	25	2	i	int
    //   1	395	3	localObject1	Object
    //   17	398	4	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   9	349	5	localObject2	Object
    //   3	385	6	localObject3	Object
    //   6	388	7	localObject4	Object
    //   71	145	8	localHttpGet	org.apache.http.client.methods.HttpGet
    // Exception table:
    //   from	to	target	type
    //   11	19	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   34	73	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   88	97	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   112	122	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   137	146	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   161	172	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   187	198	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   213	221	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   236	253	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   268	280	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   312	329	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   344	351	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   370	386	280	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   11	19	286	finally
    //   34	73	286	finally
    //   88	97	286	finally
    //   112	122	286	finally
    //   137	146	286	finally
    //   161	172	286	finally
    //   187	198	286	finally
    //   213	221	286	finally
    //   236	253	286	finally
    //   268	280	286	finally
    //   284	286	286	finally
    //   312	329	286	finally
    //   344	351	286	finally
    //   370	386	286	finally
    //   390	392	286	finally
    //   396	409	286	finally
    //   11	19	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   34	73	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   88	97	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   112	122	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   137	146	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   161	172	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   187	198	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   213	221	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   236	253	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   268	280	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   312	329	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   344	351	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   370	386	386	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   11	19	392	java/lang/Exception
    //   34	73	392	java/lang/Exception
    //   88	97	392	java/lang/Exception
    //   112	122	392	java/lang/Exception
    //   137	146	392	java/lang/Exception
    //   161	172	392	java/lang/Exception
    //   187	198	392	java/lang/Exception
    //   213	221	392	java/lang/Exception
    //   236	253	392	java/lang/Exception
    //   268	280	392	java/lang/Exception
    //   312	329	392	java/lang/Exception
    //   344	351	392	java/lang/Exception
    //   370	386	392	java/lang/Exception
  }
  
  /* Error */
  public void gcmRegister(String paramString1, String paramString2)
    throws InvalidTokenException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   15: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   18: astore 5
    //   20: aload 5
    //   22: astore 6
    //   24: aload 5
    //   26: astore 4
    //   28: aload 5
    //   30: astore 7
    //   32: aload 5
    //   34: astore 8
    //   36: new 451	org/apache/http/client/methods/HttpGet
    //   39: dup
    //   40: new 82	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   47: new 80	java/net/URI
    //   50: dup
    //   51: new 82	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   58: aload_0
    //   59: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   62: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc_w 478
    //   68: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   77: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: ldc_w 480
    //   83: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: ldc_w 482
    //   90: invokestatic 488	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 489	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   102: astore_2
    //   103: aload 5
    //   105: astore 6
    //   107: aload 5
    //   109: astore 4
    //   111: aload 5
    //   113: astore 7
    //   115: aload 5
    //   117: astore 8
    //   119: aload_2
    //   120: ldc 105
    //   122: ldc 107
    //   124: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 5
    //   129: astore 6
    //   131: aload 5
    //   133: astore 4
    //   135: aload 5
    //   137: astore 7
    //   139: aload 5
    //   141: astore 8
    //   143: aload_2
    //   144: ldc_w 457
    //   147: ldc 107
    //   149: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 5
    //   154: astore 6
    //   156: aload 5
    //   158: astore 4
    //   160: aload 5
    //   162: astore 7
    //   164: aload 5
    //   166: astore 8
    //   168: aload_2
    //   169: ldc_w 459
    //   172: aload_1
    //   173: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 5
    //   178: astore 6
    //   180: aload 5
    //   182: astore 4
    //   184: aload 5
    //   186: astore 7
    //   188: aload 5
    //   190: astore 8
    //   192: aload_2
    //   193: ldc 113
    //   195: iconst_1
    //   196: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   199: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 5
    //   204: astore 6
    //   206: aload 5
    //   208: astore 4
    //   210: aload 5
    //   212: astore 7
    //   214: aload 5
    //   216: astore 8
    //   218: aload_2
    //   219: ldc 121
    //   221: aload_0
    //   222: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   225: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 5
    //   230: astore 6
    //   232: aload 5
    //   234: astore 4
    //   236: aload 5
    //   238: astore 7
    //   240: aload 5
    //   242: astore 8
    //   244: aload 5
    //   246: aload_2
    //   247: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   250: astore_1
    //   251: aload 5
    //   253: astore 6
    //   255: aload 5
    //   257: astore 4
    //   259: aload 5
    //   261: astore 7
    //   263: aload 5
    //   265: astore 8
    //   267: aload_1
    //   268: invokeinterface 463 1 0
    //   273: invokeinterface 468 1 0
    //   278: sipush 403
    //   281: if_icmpne +51 -> 332
    //   284: aload 5
    //   286: astore 6
    //   288: aload 5
    //   290: astore 4
    //   292: aload 5
    //   294: astore 7
    //   296: aload 5
    //   298: astore 8
    //   300: new 449	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   303: dup
    //   304: ldc_w 470
    //   307: aconst_null
    //   308: invokespecial 473	mobi/beyondpod/sync/trackers/bp/InvalidTokenException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   311: athrow
    //   312: astore_1
    //   313: aload 6
    //   315: astore 4
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: aload 4
    //   322: ifnull +8 -> 330
    //   325: aload 4
    //   327: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   330: aload_1
    //   331: athrow
    //   332: aload 5
    //   334: astore 6
    //   336: aload 5
    //   338: astore 4
    //   340: aload 5
    //   342: astore 7
    //   344: aload 5
    //   346: astore 8
    //   348: new 166	org/json/JSONObject
    //   351: dup
    //   352: aload_1
    //   353: invokeinterface 170 1 0
    //   358: invokestatic 175	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   361: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   364: astore_1
    //   365: aload 5
    //   367: astore 6
    //   369: aload 5
    //   371: astore 4
    //   373: aload 5
    //   375: astore 7
    //   377: aload 5
    //   379: astore 8
    //   381: aload_1
    //   382: ldc -78
    //   384: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   387: istore_3
    //   388: iload_3
    //   389: ifeq +60 -> 449
    //   392: aload 5
    //   394: astore 6
    //   396: aload 5
    //   398: astore 4
    //   400: aload 5
    //   402: astore 7
    //   404: aload 5
    //   406: astore 8
    //   408: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   411: dup
    //   412: iload_3
    //   413: aload_1
    //   414: ldc -30
    //   416: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: aconst_null
    //   420: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   423: athrow
    //   424: astore_1
    //   425: aload 7
    //   427: astore 4
    //   429: aload_1
    //   430: athrow
    //   431: astore_1
    //   432: aload 8
    //   434: astore 4
    //   436: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   439: dup
    //   440: iconst_m1
    //   441: ldc_w 475
    //   444: aload_1
    //   445: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   448: athrow
    //   449: aload 5
    //   451: ifnull +8 -> 459
    //   454: aload 5
    //   456: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   459: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	BeyondPodServiceClientV1
    //   0	460	1	paramString1	String
    //   0	460	2	paramString2	String
    //   387	26	3	i	int
    //   1	434	4	localObject1	Object
    //   18	437	5	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   10	385	6	localObject2	Object
    //   4	422	7	localObject3	Object
    //   7	426	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   36	103	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   119	127	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   143	152	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   168	176	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   192	202	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   218	228	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   244	251	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   267	284	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   300	312	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   348	365	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   381	388	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   408	424	312	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   12	20	319	finally
    //   36	103	319	finally
    //   119	127	319	finally
    //   143	152	319	finally
    //   168	176	319	finally
    //   192	202	319	finally
    //   218	228	319	finally
    //   244	251	319	finally
    //   267	284	319	finally
    //   300	312	319	finally
    //   317	319	319	finally
    //   348	365	319	finally
    //   381	388	319	finally
    //   408	424	319	finally
    //   429	431	319	finally
    //   436	449	319	finally
    //   12	20	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   36	103	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   119	127	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   143	152	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   168	176	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   192	202	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   218	228	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   244	251	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   267	284	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   300	312	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   348	365	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   381	388	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   408	424	424	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   12	20	431	java/lang/Exception
    //   36	103	431	java/lang/Exception
    //   119	127	431	java/lang/Exception
    //   143	152	431	java/lang/Exception
    //   168	176	431	java/lang/Exception
    //   192	202	431	java/lang/Exception
    //   218	228	431	java/lang/Exception
    //   244	251	431	java/lang/Exception
    //   267	284	431	java/lang/Exception
    //   300	312	431	java/lang/Exception
    //   348	365	431	java/lang/Exception
    //   381	388	431	java/lang/Exception
    //   408	424	431	java/lang/Exception
  }
  
  /* Error */
  public void gcmUnregister(String paramString)
    throws InvalidTokenException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 5
    //   11: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   14: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   17: astore 4
    //   19: aload 4
    //   21: astore 5
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: astore 6
    //   30: aload 4
    //   32: astore 7
    //   34: new 451	org/apache/http/client/methods/HttpGet
    //   37: dup
    //   38: new 82	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   45: new 80	java/net/URI
    //   48: dup
    //   49: new 82	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   56: aload_0
    //   57: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   60: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc_w 492
    //   66: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: ldc_w 480
    //   81: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: ldc_w 482
    //   88: invokestatic 488	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 489	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   100: astore_1
    //   101: aload 4
    //   103: astore 5
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: astore 6
    //   112: aload 4
    //   114: astore 7
    //   116: aload_1
    //   117: ldc 105
    //   119: ldc 107
    //   121: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload 4
    //   126: astore 5
    //   128: aload 4
    //   130: astore_3
    //   131: aload 4
    //   133: astore 6
    //   135: aload 4
    //   137: astore 7
    //   139: aload_1
    //   140: ldc_w 457
    //   143: ldc 107
    //   145: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 4
    //   150: astore 5
    //   152: aload 4
    //   154: astore_3
    //   155: aload 4
    //   157: astore 6
    //   159: aload 4
    //   161: astore 7
    //   163: aload_1
    //   164: ldc_w 459
    //   167: ldc -19
    //   169: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 4
    //   174: astore 5
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: astore 6
    //   183: aload 4
    //   185: astore 7
    //   187: aload_1
    //   188: ldc 113
    //   190: iconst_1
    //   191: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 4
    //   199: astore 5
    //   201: aload 4
    //   203: astore_3
    //   204: aload 4
    //   206: astore 6
    //   208: aload 4
    //   210: astore 7
    //   212: aload_1
    //   213: ldc 121
    //   215: aload_0
    //   216: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   219: invokevirtual 455	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 4
    //   224: astore 5
    //   226: aload 4
    //   228: astore_3
    //   229: aload 4
    //   231: astore 6
    //   233: aload 4
    //   235: astore 7
    //   237: aload 4
    //   239: aload_1
    //   240: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   243: astore_1
    //   244: aload 4
    //   246: astore 5
    //   248: aload 4
    //   250: astore_3
    //   251: aload 4
    //   253: astore 6
    //   255: aload 4
    //   257: astore 7
    //   259: aload_1
    //   260: invokeinterface 463 1 0
    //   265: invokeinterface 468 1 0
    //   270: sipush 403
    //   273: if_icmpne +47 -> 320
    //   276: aload 4
    //   278: astore 5
    //   280: aload 4
    //   282: astore_3
    //   283: aload 4
    //   285: astore 6
    //   287: aload 4
    //   289: astore 7
    //   291: new 449	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   294: dup
    //   295: ldc_w 470
    //   298: aconst_null
    //   299: invokespecial 473	mobi/beyondpod/sync/trackers/bp/InvalidTokenException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: athrow
    //   303: astore_1
    //   304: aload 5
    //   306: astore_3
    //   307: aload_1
    //   308: athrow
    //   309: astore_1
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   318: aload_1
    //   319: athrow
    //   320: aload 4
    //   322: astore 5
    //   324: aload 4
    //   326: astore_3
    //   327: aload 4
    //   329: astore 6
    //   331: aload 4
    //   333: astore 7
    //   335: new 166	org/json/JSONObject
    //   338: dup
    //   339: aload_1
    //   340: invokeinterface 170 1 0
    //   345: invokestatic 175	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   348: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   351: astore_1
    //   352: aload 4
    //   354: astore 5
    //   356: aload 4
    //   358: astore_3
    //   359: aload 4
    //   361: astore 6
    //   363: aload 4
    //   365: astore 7
    //   367: aload_1
    //   368: ldc -78
    //   370: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   373: istore_2
    //   374: iload_2
    //   375: ifeq +57 -> 432
    //   378: aload 4
    //   380: astore 5
    //   382: aload 4
    //   384: astore_3
    //   385: aload 4
    //   387: astore 6
    //   389: aload 4
    //   391: astore 7
    //   393: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   396: dup
    //   397: iload_2
    //   398: aload_1
    //   399: ldc -30
    //   401: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: aconst_null
    //   405: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: athrow
    //   409: astore_1
    //   410: aload 6
    //   412: astore_3
    //   413: aload_1
    //   414: athrow
    //   415: astore_1
    //   416: aload 7
    //   418: astore_3
    //   419: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   422: dup
    //   423: iconst_m1
    //   424: ldc_w 475
    //   427: aload_1
    //   428: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   431: athrow
    //   432: aload 4
    //   434: ifnull +8 -> 442
    //   437: aload 4
    //   439: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   442: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	BeyondPodServiceClientV1
    //   0	443	1	paramString	String
    //   373	25	2	i	int
    //   1	418	3	localObject1	Object
    //   17	421	4	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   9	372	5	localObject2	Object
    //   3	408	6	localObject3	Object
    //   6	411	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	19	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   34	101	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   116	124	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   139	148	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   163	172	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   187	197	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   212	222	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   237	244	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   259	276	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   291	303	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   335	352	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   367	374	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   393	409	303	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   11	19	309	finally
    //   34	101	309	finally
    //   116	124	309	finally
    //   139	148	309	finally
    //   163	172	309	finally
    //   187	197	309	finally
    //   212	222	309	finally
    //   237	244	309	finally
    //   259	276	309	finally
    //   291	303	309	finally
    //   307	309	309	finally
    //   335	352	309	finally
    //   367	374	309	finally
    //   393	409	309	finally
    //   413	415	309	finally
    //   419	432	309	finally
    //   11	19	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   34	101	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   116	124	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   139	148	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   163	172	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   187	197	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   212	222	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   237	244	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   259	276	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   291	303	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   335	352	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   367	374	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   393	409	409	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   11	19	415	java/lang/Exception
    //   34	101	415	java/lang/Exception
    //   116	124	415	java/lang/Exception
    //   139	148	415	java/lang/Exception
    //   163	172	415	java/lang/Exception
    //   187	197	415	java/lang/Exception
    //   212	222	415	java/lang/Exception
    //   237	244	415	java/lang/Exception
    //   259	276	415	java/lang/Exception
    //   291	303	415	java/lang/Exception
    //   335	352	415	java/lang/Exception
    //   367	374	415	java/lang/Exception
    //   393	409	415	java/lang/Exception
  }
  
  public Uri getRestUrlRoot()
  {
    return this.restUrlRoot;
  }
  
  public AuthenticationResult registerUser(String paramString1, String paramString2, AuthType paramAuthType, String paramString3)
    throws AuthenticationException, ServiceException
  {
    if (paramAuthType == AuthType.BeyondPod) {
      return authenticateUserBeyondPod(paramString1, paramString2, paramString3, true, false);
    }
    if (paramAuthType == AuthType.Google) {
      return authenticateUserGoogle(paramString1, paramString2, paramString3, true);
    }
    throw new UnsupportedOperationException("invalid authType specified");
  }
  
  public void setRestUrlRoot(Uri paramUri)
  {
    this.restUrlRoot = paramUri;
  }
  
  /* Error */
  public BPTracker.RemoteActivities storeAndRetrieveActivities(String paramString, List<DeviceActivity> paramList, boolean paramBoolean, Date paramDate)
    throws InvalidTokenException, ServiceException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 8
    //   12: invokestatic 70	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   15: invokestatic 76	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   18: astore 7
    //   20: aload 7
    //   22: astore 8
    //   24: aload 7
    //   26: astore 6
    //   28: aload 7
    //   30: astore 9
    //   32: aload 7
    //   34: astore 10
    //   36: aload 7
    //   38: invokevirtual 501	mobi/beyondpod/downloadengine/BeyondPodHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   41: astore 11
    //   43: aload 7
    //   45: astore 8
    //   47: aload 7
    //   49: astore 6
    //   51: aload 7
    //   53: astore 9
    //   55: aload 7
    //   57: astore 10
    //   59: aload 11
    //   61: sipush 30000
    //   64: invokestatic 507	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   67: aload 7
    //   69: astore 8
    //   71: aload 7
    //   73: astore 6
    //   75: aload 7
    //   77: astore 9
    //   79: aload 7
    //   81: astore 10
    //   83: aload 11
    //   85: ldc_w 508
    //   88: invokestatic 511	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   91: aload 7
    //   93: astore 8
    //   95: aload 7
    //   97: astore 6
    //   99: aload 7
    //   101: astore 9
    //   103: aload 7
    //   105: astore 10
    //   107: aload 11
    //   109: iconst_0
    //   110: invokestatic 514	org/apache/http/params/HttpConnectionParams:setLinger	(Lorg/apache/http/params/HttpParams;I)V
    //   113: aload 7
    //   115: astore 8
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: astore 9
    //   125: aload 7
    //   127: astore 10
    //   129: aload_0
    //   130: aload 4
    //   132: invokespecial 516	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:formatDate	(Ljava/util/Date;)Ljava/lang/String;
    //   135: ldc_w 482
    //   138: invokestatic 488	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 12
    //   143: aload 7
    //   145: astore 8
    //   147: aload 7
    //   149: astore 6
    //   151: aload 7
    //   153: astore 9
    //   155: aload 7
    //   157: astore 10
    //   159: new 82	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   166: aload_0
    //   167: getfield 85	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:restUrlRoot	Landroid/net/Uri;
    //   170: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc_w 518
    //   176: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: astore 13
    //   181: iload_3
    //   182: ifeq +572 -> 754
    //   185: ldc -35
    //   187: astore 11
    //   189: aload 7
    //   191: astore 8
    //   193: aload 7
    //   195: astore 6
    //   197: aload 7
    //   199: astore 9
    //   201: aload 7
    //   203: astore 10
    //   205: aload 13
    //   207: aload 11
    //   209: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: astore 11
    //   214: aload 4
    //   216: ifnonnull +545 -> 761
    //   219: ldc -19
    //   221: astore 4
    //   223: aload 7
    //   225: astore 8
    //   227: aload 7
    //   229: astore 6
    //   231: aload 7
    //   233: astore 9
    //   235: aload 7
    //   237: astore 10
    //   239: new 78	org/apache/http/client/methods/HttpPost
    //   242: dup
    //   243: new 80	java/net/URI
    //   246: dup
    //   247: aload 11
    //   249: aload 4
    //   251: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 100	java/net/URI:<init>	(Ljava/lang/String;)V
    //   260: invokespecial 103	org/apache/http/client/methods/HttpPost:<init>	(Ljava/net/URI;)V
    //   263: astore 4
    //   265: aload 7
    //   267: astore 8
    //   269: aload 7
    //   271: astore 6
    //   273: aload 7
    //   275: astore 9
    //   277: aload 7
    //   279: astore 10
    //   281: aload 4
    //   283: ldc 105
    //   285: ldc 107
    //   287: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload 7
    //   292: astore 8
    //   294: aload 7
    //   296: astore 6
    //   298: aload 7
    //   300: astore 9
    //   302: aload 7
    //   304: astore 10
    //   306: aload 4
    //   308: ldc_w 457
    //   311: ldc 107
    //   313: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 7
    //   318: astore 8
    //   320: aload 7
    //   322: astore 6
    //   324: aload 7
    //   326: astore 9
    //   328: aload 7
    //   330: astore 10
    //   332: aload 4
    //   334: ldc_w 459
    //   337: aload_1
    //   338: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload 7
    //   343: astore 8
    //   345: aload 7
    //   347: astore 6
    //   349: aload 7
    //   351: astore 9
    //   353: aload 7
    //   355: astore 10
    //   357: aload 4
    //   359: ldc 113
    //   361: iconst_1
    //   362: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   365: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 7
    //   370: astore 8
    //   372: aload 7
    //   374: astore 6
    //   376: aload 7
    //   378: astore 9
    //   380: aload 7
    //   382: astore 10
    //   384: aload 4
    //   386: ldc 121
    //   388: aload_0
    //   389: invokespecial 124	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:getSoftwareVersion	()Ljava/lang/String;
    //   392: invokevirtual 111	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 7
    //   397: astore 8
    //   399: aload 7
    //   401: astore 6
    //   403: aload 7
    //   405: astore 9
    //   407: aload 7
    //   409: astore 10
    //   411: new 166	org/json/JSONObject
    //   414: dup
    //   415: invokespecial 519	org/json/JSONObject:<init>	()V
    //   418: astore_1
    //   419: aload 7
    //   421: astore 8
    //   423: aload 7
    //   425: astore 6
    //   427: aload 7
    //   429: astore 9
    //   431: aload 7
    //   433: astore 10
    //   435: new 166	org/json/JSONObject
    //   438: dup
    //   439: invokespecial 519	org/json/JSONObject:<init>	()V
    //   442: astore 12
    //   444: aload 7
    //   446: astore 8
    //   448: aload 7
    //   450: astore 6
    //   452: aload 7
    //   454: astore 9
    //   456: aload 7
    //   458: astore 10
    //   460: aload_1
    //   461: ldc_w 270
    //   464: aload 12
    //   466: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload 7
    //   472: astore 8
    //   474: aload 7
    //   476: astore 6
    //   478: aload 7
    //   480: astore 9
    //   482: aload 7
    //   484: astore 10
    //   486: new 286	org/json/JSONArray
    //   489: dup
    //   490: invokespecial 291	org/json/JSONArray:<init>	()V
    //   493: astore 11
    //   495: aload 7
    //   497: astore 8
    //   499: aload 7
    //   501: astore 6
    //   503: aload 7
    //   505: astore 9
    //   507: aload 7
    //   509: astore 10
    //   511: aload 12
    //   513: ldc_w 280
    //   516: aload 11
    //   518: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   521: pop
    //   522: aload_2
    //   523: ifnull +51 -> 574
    //   526: aload 7
    //   528: astore 8
    //   530: aload 7
    //   532: astore 6
    //   534: aload 7
    //   536: astore 9
    //   538: aload 7
    //   540: astore 10
    //   542: aload_2
    //   543: invokeinterface 526 1 0
    //   548: astore_2
    //   549: aload 7
    //   551: astore 8
    //   553: aload 7
    //   555: astore 6
    //   557: aload 7
    //   559: astore 9
    //   561: aload 7
    //   563: astore 10
    //   565: aload_2
    //   566: invokeinterface 532 1 0
    //   571: ifne +229 -> 800
    //   574: aload 7
    //   576: astore 8
    //   578: aload 7
    //   580: astore 6
    //   582: aload 7
    //   584: astore 9
    //   586: aload 7
    //   588: astore 10
    //   590: new 534	org/apache/http/entity/StringEntity
    //   593: dup
    //   594: aload_1
    //   595: invokevirtual 535	org/json/JSONObject:toString	()Ljava/lang/String;
    //   598: ldc_w 482
    //   601: invokespecial 536	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: astore_1
    //   605: aload 7
    //   607: astore 8
    //   609: aload 7
    //   611: astore 6
    //   613: aload 7
    //   615: astore 9
    //   617: aload 7
    //   619: astore 10
    //   621: aload_1
    //   622: ldc 107
    //   624: invokevirtual 539	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   627: aload 7
    //   629: astore 8
    //   631: aload 7
    //   633: astore 6
    //   635: aload 7
    //   637: astore 9
    //   639: aload 7
    //   641: astore 10
    //   643: aload 4
    //   645: aload_1
    //   646: invokevirtual 160	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   649: aload 7
    //   651: astore 8
    //   653: aload 7
    //   655: astore 6
    //   657: aload 7
    //   659: astore 9
    //   661: aload 7
    //   663: astore 10
    //   665: aload 7
    //   667: aload 4
    //   669: invokevirtual 164	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   672: astore_1
    //   673: aload 7
    //   675: astore 8
    //   677: aload 7
    //   679: astore 6
    //   681: aload 7
    //   683: astore 9
    //   685: aload 7
    //   687: astore 10
    //   689: aload_1
    //   690: invokeinterface 463 1 0
    //   695: invokeinterface 468 1 0
    //   700: sipush 403
    //   703: if_icmpne +277 -> 980
    //   706: aload 7
    //   708: astore 8
    //   710: aload 7
    //   712: astore 6
    //   714: aload 7
    //   716: astore 9
    //   718: aload 7
    //   720: astore 10
    //   722: new 449	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   725: dup
    //   726: ldc_w 470
    //   729: aconst_null
    //   730: invokespecial 473	mobi/beyondpod/sync/trackers/bp/InvalidTokenException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   733: athrow
    //   734: astore_1
    //   735: aload 8
    //   737: astore 6
    //   739: aload_1
    //   740: athrow
    //   741: astore_1
    //   742: aload 6
    //   744: ifnull +8 -> 752
    //   747: aload 6
    //   749: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   752: aload_1
    //   753: athrow
    //   754: ldc -109
    //   756: astore 11
    //   758: goto -569 -> 189
    //   761: aload 7
    //   763: astore 8
    //   765: aload 7
    //   767: astore 6
    //   769: aload 7
    //   771: astore 9
    //   773: aload 7
    //   775: astore 10
    //   777: new 82	java/lang/StringBuilder
    //   780: dup
    //   781: ldc_w 541
    //   784: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   787: aload 12
    //   789: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: astore 4
    //   797: goto -574 -> 223
    //   800: aload 7
    //   802: astore 8
    //   804: aload 7
    //   806: astore 6
    //   808: aload 7
    //   810: astore 9
    //   812: aload 7
    //   814: astore 10
    //   816: aload_2
    //   817: invokeinterface 545 1 0
    //   822: checkcast 302	mobi/beyondpod/sync/trackers/bp/DeviceActivity
    //   825: astore 12
    //   827: aload 7
    //   829: astore 8
    //   831: aload 7
    //   833: astore 6
    //   835: aload 7
    //   837: astore 9
    //   839: aload 7
    //   841: astore 10
    //   843: new 166	org/json/JSONObject
    //   846: dup
    //   847: invokespecial 519	org/json/JSONObject:<init>	()V
    //   850: astore 13
    //   852: aload 7
    //   854: astore 8
    //   856: aload 7
    //   858: astore 6
    //   860: aload 7
    //   862: astore 9
    //   864: aload 7
    //   866: astore 10
    //   868: aload 13
    //   870: ldc_w 305
    //   873: aload_0
    //   874: aload 12
    //   876: invokevirtual 549	mobi/beyondpod/sync/trackers/bp/DeviceActivity:getDateTime	()Ljava/util/Date;
    //   879: invokespecial 516	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:formatDate	(Ljava/util/Date;)Ljava/lang/String;
    //   882: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   885: pop
    //   886: aload 7
    //   888: astore 8
    //   890: aload 7
    //   892: astore 6
    //   894: aload 7
    //   896: astore 9
    //   898: aload 7
    //   900: astore 10
    //   902: aload 13
    //   904: ldc_w 310
    //   907: aload 12
    //   909: invokevirtual 552	mobi/beyondpod/sync/trackers/bp/DeviceActivity:getType	()Ljava/lang/String;
    //   912: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   915: pop
    //   916: aload 7
    //   918: astore 8
    //   920: aload 7
    //   922: astore 6
    //   924: aload 7
    //   926: astore 9
    //   928: aload 7
    //   930: astore 10
    //   932: aload 13
    //   934: ldc_w 315
    //   937: aload 12
    //   939: invokevirtual 555	mobi/beyondpod/sync/trackers/bp/DeviceActivity:getData	()Ljava/lang/String;
    //   942: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   945: pop
    //   946: aload 7
    //   948: astore 8
    //   950: aload 7
    //   952: astore 6
    //   954: aload 7
    //   956: astore 9
    //   958: aload 7
    //   960: astore 10
    //   962: aload 11
    //   964: aload 13
    //   966: invokevirtual 295	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   969: pop
    //   970: goto -421 -> 549
    //   973: astore_1
    //   974: aload 9
    //   976: astore 6
    //   978: aload_1
    //   979: athrow
    //   980: aload 7
    //   982: astore 8
    //   984: aload 7
    //   986: astore 6
    //   988: aload 7
    //   990: astore 9
    //   992: aload 7
    //   994: astore 10
    //   996: new 166	org/json/JSONObject
    //   999: dup
    //   1000: aload_1
    //   1001: invokeinterface 170 1 0
    //   1006: ldc_w 482
    //   1009: invokestatic 558	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   1012: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1015: astore_2
    //   1016: aload 7
    //   1018: astore 8
    //   1020: aload 7
    //   1022: astore 6
    //   1024: aload 7
    //   1026: astore 9
    //   1028: aload 7
    //   1030: astore 10
    //   1032: aload_2
    //   1033: ldc -78
    //   1035: invokevirtual 182	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1038: istore 5
    //   1040: iload 5
    //   1042: ifeq +54 -> 1096
    //   1045: aload 7
    //   1047: astore 8
    //   1049: aload 7
    //   1051: astore 6
    //   1053: aload 7
    //   1055: astore 9
    //   1057: aload 7
    //   1059: astore 10
    //   1061: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   1064: dup
    //   1065: iload 5
    //   1067: aload_2
    //   1068: ldc -30
    //   1070: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1073: aconst_null
    //   1074: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1077: athrow
    //   1078: astore_1
    //   1079: aload 10
    //   1081: astore 6
    //   1083: new 65	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   1086: dup
    //   1087: iconst_m1
    //   1088: ldc_w 475
    //   1091: aload_1
    //   1092: invokespecial 233	mobi/beyondpod/sync/trackers/bp/ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1095: athrow
    //   1096: aload 7
    //   1098: astore 8
    //   1100: aload 7
    //   1102: astore 6
    //   1104: aload 7
    //   1106: astore 9
    //   1108: aload 7
    //   1110: astore 10
    //   1112: new 560	mobi/beyondpod/sync/trackers/bp/BPTracker$RemoteActivities
    //   1115: dup
    //   1116: aload_0
    //   1117: aload_2
    //   1118: invokespecial 562	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:createList	(Lorg/json/JSONObject;)Ljava/util/List;
    //   1121: aload_1
    //   1122: invokestatic 213	mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1:GetResponseDateFrom	(Lorg/apache/http/HttpResponse;)Ljava/util/Date;
    //   1125: invokespecial 565	mobi/beyondpod/sync/trackers/bp/BPTracker$RemoteActivities:<init>	(Ljava/util/List;Ljava/util/Date;)V
    //   1128: astore_1
    //   1129: aload 7
    //   1131: ifnull +8 -> 1139
    //   1134: aload 7
    //   1136: invokevirtual 219	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   1139: aload_1
    //   1140: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1141	0	this	BeyondPodServiceClientV1
    //   0	1141	1	paramString	String
    //   0	1141	2	paramList	List<DeviceActivity>
    //   0	1141	3	paramBoolean	boolean
    //   0	1141	4	paramDate	Date
    //   1038	28	5	i	int
    //   1	1102	6	localObject1	Object
    //   18	1117	7	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   10	1089	8	localObject2	Object
    //   4	1103	9	localObject3	Object
    //   7	1104	10	localObject4	Object
    //   41	922	11	localObject5	Object
    //   141	797	12	localObject6	Object
    //   179	786	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   36	43	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   59	67	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   83	91	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   107	113	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   129	143	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   159	181	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   205	214	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   239	265	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   281	290	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   306	316	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   332	341	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   357	368	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   384	395	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   411	419	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   435	444	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   460	470	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   486	495	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   511	522	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   542	549	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   565	574	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   590	605	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   621	627	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   643	649	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   665	673	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   689	706	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   722	734	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   777	797	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   816	827	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   843	852	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   868	886	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   902	916	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   932	946	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   962	970	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   996	1016	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   1032	1040	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   1061	1078	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   1112	1129	734	mobi/beyondpod/sync/trackers/bp/InvalidTokenException
    //   12	20	741	finally
    //   36	43	741	finally
    //   59	67	741	finally
    //   83	91	741	finally
    //   107	113	741	finally
    //   129	143	741	finally
    //   159	181	741	finally
    //   205	214	741	finally
    //   239	265	741	finally
    //   281	290	741	finally
    //   306	316	741	finally
    //   332	341	741	finally
    //   357	368	741	finally
    //   384	395	741	finally
    //   411	419	741	finally
    //   435	444	741	finally
    //   460	470	741	finally
    //   486	495	741	finally
    //   511	522	741	finally
    //   542	549	741	finally
    //   565	574	741	finally
    //   590	605	741	finally
    //   621	627	741	finally
    //   643	649	741	finally
    //   665	673	741	finally
    //   689	706	741	finally
    //   722	734	741	finally
    //   739	741	741	finally
    //   777	797	741	finally
    //   816	827	741	finally
    //   843	852	741	finally
    //   868	886	741	finally
    //   902	916	741	finally
    //   932	946	741	finally
    //   962	970	741	finally
    //   978	980	741	finally
    //   996	1016	741	finally
    //   1032	1040	741	finally
    //   1061	1078	741	finally
    //   1083	1096	741	finally
    //   1112	1129	741	finally
    //   12	20	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   36	43	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   59	67	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   83	91	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   107	113	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   129	143	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   159	181	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   205	214	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   239	265	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   281	290	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   306	316	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   332	341	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   357	368	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   384	395	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   411	419	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   435	444	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   460	470	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   486	495	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   511	522	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   542	549	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   565	574	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   590	605	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   621	627	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   643	649	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   665	673	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   689	706	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   722	734	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   777	797	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   816	827	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   843	852	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   868	886	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   902	916	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   932	946	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   962	970	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   996	1016	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   1032	1040	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   1061	1078	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   1112	1129	973	mobi/beyondpod/sync/trackers/bp/ServiceException
    //   12	20	1078	java/lang/Exception
    //   36	43	1078	java/lang/Exception
    //   59	67	1078	java/lang/Exception
    //   83	91	1078	java/lang/Exception
    //   107	113	1078	java/lang/Exception
    //   129	143	1078	java/lang/Exception
    //   159	181	1078	java/lang/Exception
    //   205	214	1078	java/lang/Exception
    //   239	265	1078	java/lang/Exception
    //   281	290	1078	java/lang/Exception
    //   306	316	1078	java/lang/Exception
    //   332	341	1078	java/lang/Exception
    //   357	368	1078	java/lang/Exception
    //   384	395	1078	java/lang/Exception
    //   411	419	1078	java/lang/Exception
    //   435	444	1078	java/lang/Exception
    //   460	470	1078	java/lang/Exception
    //   486	495	1078	java/lang/Exception
    //   511	522	1078	java/lang/Exception
    //   542	549	1078	java/lang/Exception
    //   565	574	1078	java/lang/Exception
    //   590	605	1078	java/lang/Exception
    //   621	627	1078	java/lang/Exception
    //   643	649	1078	java/lang/Exception
    //   665	673	1078	java/lang/Exception
    //   689	706	1078	java/lang/Exception
    //   722	734	1078	java/lang/Exception
    //   777	797	1078	java/lang/Exception
    //   816	827	1078	java/lang/Exception
    //   843	852	1078	java/lang/Exception
    //   868	886	1078	java/lang/Exception
    //   902	916	1078	java/lang/Exception
    //   932	946	1078	java/lang/Exception
    //   962	970	1078	java/lang/Exception
    //   996	1016	1078	java/lang/Exception
    //   1032	1040	1078	java/lang/Exception
    //   1061	1078	1078	java/lang/Exception
    //   1112	1129	1078	java/lang/Exception
  }
  
  public static enum AuthType
  {
    BeyondPod,  Google;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/bp/BeyondPodServiceClientV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */