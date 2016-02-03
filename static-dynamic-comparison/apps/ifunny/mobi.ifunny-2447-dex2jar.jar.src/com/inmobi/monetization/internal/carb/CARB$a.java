package com.inmobi.monetization.internal.carb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;

import java.util.Map;

class CARB$a
        implements Runnable {
    int a = 1;

    CARB$a(CARB paramCARB) {
    }

    /* Error */
    private int a(String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: iconst_0
        //   4: istore_3
        //   5: invokestatic 37	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
        //   8: invokestatic 41	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
        //   11: ifne +5 -> 16
        //   14: iconst_m1
        //   15: ireturn
        //   16: new 43	java/net/URL
        //   19: dup
        //   20: invokestatic 49	com/inmobi/monetization/internal/carb/CarbInitializer:getConfigParams	()Lcom/inmobi/monetization/internal/carb/CarbConfigParams;
        //   23: invokevirtual 55	com/inmobi/monetization/internal/carb/CarbConfigParams:getCarbEndpoint	()Ljava/lang/String;
        //   26: invokespecial 58	java/net/URL:<init>	(Ljava/lang/String;)V
        //   29: astore 7
        //   31: aload 7
        //   33: invokevirtual 62	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   36: checkcast 64	java/net/HttpURLConnection
        //   39: astore 8
        //   41: aload 8
        //   43: ldc 66
        //   45: invokestatic 69	com/inmobi/commons/internal/InternalSDKUtil:getUserAgent	()Ljava/lang/String;
        //   48: invokevirtual 73	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: invokestatic 49	com/inmobi/monetization/internal/carb/CarbInitializer:getConfigParams	()Lcom/inmobi/monetization/internal/carb/CarbConfigParams;
        //   54: invokevirtual 77	com/inmobi/monetization/internal/carb/CarbConfigParams:getTimeoutInterval	()J
        //   57: ldc2_w 78
        //   60: lmul
        //   61: lstore 4
        //   63: aload 8
        //   65: lload 4
        //   67: l2i
        //   68: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   71: aload 8
        //   73: lload 4
        //   75: l2i
        //   76: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   79: aload 8
        //   81: ldc 88
        //   83: invokestatic 93	com/inmobi/commons/data/DeviceInfo:getPhoneDefaultUserAgent	()Ljava/lang/String;
        //   86: invokevirtual 73	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   89: aload 8
        //   91: iconst_0
        //   92: invokevirtual 97	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   95: aload 8
        //   97: iconst_1
        //   98: invokevirtual 100	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   101: aload 8
        //   103: iconst_1
        //   104: invokevirtual 103	java/net/HttpURLConnection:setDoInput	(Z)V
        //   107: aload 8
        //   109: ldc 105
        //   111: invokevirtual 108	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   114: aload 8
        //   116: ldc 110
        //   118: ldc 112
        //   120: invokevirtual 73	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   123: aload 8
        //   125: ldc 114
        //   127: aload_1
        //   128: invokevirtual 120	java/lang/String:length	()I
        //   131: invokestatic 126	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   134: invokevirtual 73	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   137: aload 7
        //   139: invokevirtual 129	java/net/URL:getHost	()Ljava/lang/String;
        //   142: invokestatic 135	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
        //   145: pop
        //   146: new 137	java/io/BufferedWriter
        //   149: dup
        //   150: new 139	java/io/OutputStreamWriter
        //   153: dup
        //   154: aload 8
        //   156: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   159: invokespecial 146	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   162: invokespecial 149	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   165: astore 7
        //   167: aload 7
        //   169: aload_1
        //   170: invokevirtual 152	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   173: aload 7
        //   175: ifnull +8 -> 183
        //   178: aload 7
        //   180: invokevirtual 155	java/io/BufferedWriter:close	()V
        //   183: ldc -99
        //   185: new 159	java/lang/StringBuilder
        //   188: dup
        //   189: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   192: ldc -94
        //   194: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   197: aload 8
        //   199: invokevirtual 169	java/net/HttpURLConnection:getResponseCode	()I
        //   202: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   205: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   208: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   211: aload 8
        //   213: invokevirtual 169	java/net/HttpURLConnection:getResponseCode	()I
        //   216: sipush 200
        //   219: if_icmpne +563 -> 782
        //   222: invokestatic 184	com/inmobi/monetization/internal/carb/CARB:a	()Landroid/content/SharedPreferences;
        //   225: invokeinterface 190 1 0
        //   230: astore_1
        //   231: aload_1
        //   232: aload_0
        //   233: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   236: invokestatic 194	com/inmobi/monetization/internal/carb/CARB:e	(Lcom/inmobi/monetization/internal/carb/CARB;)Ljava/lang/String;
        //   239: invokestatic 199	java/lang/System:currentTimeMillis	()J
        //   242: invokeinterface 205 4 0
        //   247: pop
        //   248: aload_1
        //   249: invokeinterface 209 1 0
        //   254: pop
        //   255: new 211	java/io/BufferedReader
        //   258: dup
        //   259: new 213	java/io/InputStreamReader
        //   262: dup
        //   263: aload 8
        //   265: invokevirtual 217	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   268: ldc -37
        //   270: invokespecial 222	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   273: invokespecial 225	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   276: astore_1
        //   277: new 159	java/lang/StringBuilder
        //   280: dup
        //   281: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   284: astore 7
        //   286: aload_1
        //   287: invokevirtual 228	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   290: astore 8
        //   292: aload 8
        //   294: ifnull +150 -> 444
        //   297: aload 7
        //   299: aload 8
        //   301: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   304: ldc -26
        //   306: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   309: pop
        //   310: goto -24 -> 286
        //   313: astore_1
        //   314: ldc -99
        //   316: ldc -24
        //   318: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   321: iconst_m1
        //   322: ireturn
        //   323: astore_1
        //   324: new 23	java/net/MalformedURLException
        //   327: dup
        //   328: new 159	java/lang/StringBuilder
        //   331: dup
        //   332: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   335: ldc -22
        //   337: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   340: aload 7
        //   342: invokevirtual 235	java/net/URL:toString	()Ljava/lang/String;
        //   345: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   348: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   351: invokespecial 236	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
        //   354: athrow
        //   355: astore_1
        //   356: ldc -18
        //   358: new 159	java/lang/StringBuilder
        //   361: dup
        //   362: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   365: ldc -16
        //   367: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   370: aload 7
        //   372: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   375: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   378: aload_1
        //   379: invokestatic 246	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   382: goto -199 -> 183
        //   385: astore_1
        //   386: ldc -99
        //   388: ldc -8
        //   390: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   393: goto -72 -> 321
        //   396: astore_1
        //   397: aconst_null
        //   398: astore 6
        //   400: aload 6
        //   402: ifnull +8 -> 410
        //   405: aload 6
        //   407: invokevirtual 155	java/io/BufferedWriter:close	()V
        //   410: aload_1
        //   411: athrow
        //   412: astore 7
        //   414: ldc -18
        //   416: new 159	java/lang/StringBuilder
        //   419: dup
        //   420: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   423: ldc -16
        //   425: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   428: aload 6
        //   430: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   433: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   436: aload 7
        //   438: invokestatic 246	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   441: goto -31 -> 410
        //   444: aload 7
        //   446: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   449: astore_1
        //   450: ldc -99
        //   452: new 159	java/lang/StringBuilder
        //   455: dup
        //   456: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   459: ldc -6
        //   461: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   464: aload_1
        //   465: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   468: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   471: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   474: new 116	java/lang/String
        //   477: dup
        //   478: aload_1
        //   479: invokevirtual 254	java/lang/String:getBytes	()[B
        //   482: iconst_0
        //   483: invokestatic 260	com/inmobi/commons/internal/Base64:decode	([BI)[B
        //   486: aload_0
        //   487: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   490: invokestatic 264	com/inmobi/monetization/internal/carb/CARB:c	(Lcom/inmobi/monetization/internal/carb/CARB;)[B
        //   493: aload_0
        //   494: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   497: invokestatic 267	com/inmobi/monetization/internal/carb/CARB:d	(Lcom/inmobi/monetization/internal/carb/CARB;)[B
        //   500: invokestatic 273	com/inmobi/commons/internal/EncryptionUtils:DeAe	([B[B[B)[B
        //   503: invokespecial 276	java/lang/String:<init>	([B)V
        //   506: astore_1
        //   507: aload_1
        //   508: ifnull +108 -> 616
        //   511: ldc -99
        //   513: new 159	java/lang/StringBuilder
        //   516: dup
        //   517: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   520: ldc_w 278
        //   523: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   526: aload_1
        //   527: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   530: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   533: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   536: new 280	org/json/JSONObject
        //   539: dup
        //   540: aload_1
        //   541: invokespecial 281	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   544: astore_1
        //   545: aload_1
        //   546: ldc_w 283
        //   549: invokevirtual 287	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
        //   552: ifeq +219 -> 771
        //   555: aload_1
        //   556: ldc_w 289
        //   559: invokevirtual 293	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   562: astore 6
        //   564: aload 6
        //   566: ldc_w 295
        //   569: invokevirtual 299	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   572: astore_1
        //   573: aload 6
        //   575: ldc_w 301
        //   578: invokevirtual 305	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   581: astore 6
        //   583: aload 6
        //   585: invokevirtual 308	org/json/JSONArray:length	()I
        //   588: ifne +214 -> 802
        //   591: aload_0
        //   592: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   595: invokestatic 310	com/inmobi/monetization/internal/carb/CARB:b	(Lcom/inmobi/monetization/internal/carb/CARB;)V
        //   598: iconst_m1
        //   599: ireturn
        //   600: astore_1
        //   601: ldc -99
        //   603: ldc_w 312
        //   606: aload_1
        //   607: invokestatic 246	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   610: aload 6
        //   612: astore_1
        //   613: goto -106 -> 507
        //   616: ldc -99
        //   618: ldc_w 314
        //   621: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   624: aload_0
        //   625: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   628: invokestatic 310	com/inmobi/monetization/internal/carb/CARB:b	(Lcom/inmobi/monetization/internal/carb/CARB;)V
        //   631: iconst_m1
        //   632: ireturn
        //   633: iload_2
        //   634: aload 6
        //   636: invokevirtual 308	org/json/JSONArray:length	()I
        //   639: if_icmpge +114 -> 753
        //   642: aload 6
        //   644: iload_2
        //   645: invokevirtual 317	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
        //   648: astore 8
        //   650: aload 8
        //   652: ldc_w 319
        //   655: invokevirtual 299	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   658: astore 7
        //   660: aload 8
        //   662: ldc_w 321
        //   665: invokevirtual 299	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   668: astore 8
        //   670: aload 8
        //   672: ifnull +135 -> 807
        //   675: ldc_w 323
        //   678: aload 8
        //   680: invokevirtual 327	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   683: ifeq +19 -> 702
        //   686: goto +121 -> 807
        //   689: astore 7
        //   691: ldc -99
        //   693: ldc_w 329
        //   696: invokestatic 179	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   699: goto +108 -> 807
        //   702: new 331	com/inmobi/monetization/internal/carb/CarbInfo
        //   705: dup
        //   706: invokespecial 332	com/inmobi/monetization/internal/carb/CarbInfo:<init>	()V
        //   709: astore 9
        //   711: aload 9
        //   713: aload 7
        //   715: invokevirtual 335	com/inmobi/monetization/internal/carb/CarbInfo:setBid	(Ljava/lang/String;)V
        //   718: aload 9
        //   720: aload 8
        //   722: invokevirtual 338	com/inmobi/monetization/internal/carb/CarbInfo:setInmId	(Ljava/lang/String;)V
        //   725: aload_0
        //   726: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   729: aload 7
        //   731: invokestatic 341	com/inmobi/monetization/internal/carb/CARB:a	(Lcom/inmobi/monetization/internal/carb/CARB;Ljava/lang/String;)Z
        //   734: ifne +73 -> 807
        //   737: aload_0
        //   738: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   741: invokestatic 345	com/inmobi/monetization/internal/carb/CARB:g	(Lcom/inmobi/monetization/internal/carb/CARB;)Ljava/util/ArrayList;
        //   744: aload 9
        //   746: invokevirtual 350	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   749: pop
        //   750: goto +57 -> 807
        //   753: aload_0
        //   754: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   757: aload_0
        //   758: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   761: invokestatic 345	com/inmobi/monetization/internal/carb/CARB:g	(Lcom/inmobi/monetization/internal/carb/CARB;)Ljava/util/ArrayList;
        //   764: aload_1
        //   765: iload_3
        //   766: iconst_1
        //   767: iadd
        //   768: invokestatic 353	com/inmobi/monetization/internal/carb/CARB:a	(Lcom/inmobi/monetization/internal/carb/CARB;Ljava/util/ArrayList;Ljava/lang/String;I)V
        //   771: aload_0
        //   772: getfield 14	com/inmobi/monetization/internal/carb/CARB$a:b	Lcom/inmobi/monetization/internal/carb/CARB;
        //   775: invokestatic 310	com/inmobi/monetization/internal/carb/CARB:b	(Lcom/inmobi/monetization/internal/carb/CARB;)V
        //   778: sipush 200
        //   781: ireturn
        //   782: aload 8
        //   784: invokevirtual 169	java/net/HttpURLConnection:getResponseCode	()I
        //   787: istore_2
        //   788: iload_2
        //   789: ireturn
        //   790: astore_1
        //   791: aload 7
        //   793: astore 6
        //   795: goto -395 -> 400
        //   798: astore_1
        //   799: goto -478 -> 321
        //   802: iconst_0
        //   803: istore_2
        //   804: goto -171 -> 633
        //   807: iload_2
        //   808: istore_3
        //   809: iload_2
        //   810: iconst_1
        //   811: iadd
        //   812: istore_2
        //   813: goto -180 -> 633
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	816	0	this	a
        //   0	816	1	paramString	String
        //   633	180	2	i	int
        //   4	805	3	j	int
        //   61	13	4	l	long
        //   1	793	6	localObject1	Object
        //   29	342	7	localObject2	Object
        //   412	33	7	localIOException	java.io.IOException
        //   658	1	7	str	String
        //   689	103	7	localJSONException	org.json.JSONException
        //   39	744	8	localObject3	Object
        //   709	36	9	localCarbInfo	CarbInfo
        // Exception table:
        //   from	to	target	type
        //   16	137	313	java/net/MalformedURLException
        //   137	146	313	java/net/MalformedURLException
        //   178	183	313	java/net/MalformedURLException
        //   183	286	313	java/net/MalformedURLException
        //   286	292	313	java/net/MalformedURLException
        //   297	310	313	java/net/MalformedURLException
        //   324	355	313	java/net/MalformedURLException
        //   356	382	313	java/net/MalformedURLException
        //   405	410	313	java/net/MalformedURLException
        //   410	412	313	java/net/MalformedURLException
        //   414	441	313	java/net/MalformedURLException
        //   444	474	313	java/net/MalformedURLException
        //   474	507	313	java/net/MalformedURLException
        //   511	598	313	java/net/MalformedURLException
        //   601	610	313	java/net/MalformedURLException
        //   616	631	313	java/net/MalformedURLException
        //   633	650	313	java/net/MalformedURLException
        //   650	670	313	java/net/MalformedURLException
        //   675	686	313	java/net/MalformedURLException
        //   691	699	313	java/net/MalformedURLException
        //   702	750	313	java/net/MalformedURLException
        //   753	771	313	java/net/MalformedURLException
        //   771	778	313	java/net/MalformedURLException
        //   782	788	313	java/net/MalformedURLException
        //   137	146	323	java/net/UnknownHostException
        //   178	183	355	java/io/IOException
        //   16	137	385	org/json/JSONException
        //   137	146	385	org/json/JSONException
        //   178	183	385	org/json/JSONException
        //   183	286	385	org/json/JSONException
        //   286	292	385	org/json/JSONException
        //   297	310	385	org/json/JSONException
        //   324	355	385	org/json/JSONException
        //   356	382	385	org/json/JSONException
        //   405	410	385	org/json/JSONException
        //   410	412	385	org/json/JSONException
        //   414	441	385	org/json/JSONException
        //   444	474	385	org/json/JSONException
        //   474	507	385	org/json/JSONException
        //   511	598	385	org/json/JSONException
        //   601	610	385	org/json/JSONException
        //   616	631	385	org/json/JSONException
        //   633	650	385	org/json/JSONException
        //   675	686	385	org/json/JSONException
        //   691	699	385	org/json/JSONException
        //   702	750	385	org/json/JSONException
        //   753	771	385	org/json/JSONException
        //   771	778	385	org/json/JSONException
        //   782	788	385	org/json/JSONException
        //   146	167	396	finally
        //   405	410	412	java/io/IOException
        //   474	507	600	java/lang/Exception
        //   650	670	689	org/json/JSONException
        //   167	173	790	finally
        //   16	137	798	java/io/IOException
        //   137	146	798	java/io/IOException
        //   183	286	798	java/io/IOException
        //   286	292	798	java/io/IOException
        //   297	310	798	java/io/IOException
        //   324	355	798	java/io/IOException
        //   356	382	798	java/io/IOException
        //   410	412	798	java/io/IOException
        //   414	441	798	java/io/IOException
        //   444	474	798	java/io/IOException
        //   474	507	798	java/io/IOException
        //   511	598	798	java/io/IOException
        //   601	610	798	java/io/IOException
        //   616	631	798	java/io/IOException
        //   633	650	798	java/io/IOException
        //   650	670	798	java/io/IOException
        //   675	686	798	java/io/IOException
        //   691	699	798	java/io/IOException
        //   702	750	798	java/io/IOException
        //   753	771	798	java/io/IOException
        //   771	778	798	java/io/IOException
        //   782	788	798	java/io/IOException
    }

    private void a() {
        CARB.a(this.b);
        CARB.a(this.b, EncryptionUtils.keag());
        this.b.c = PkInitilaizer.getConfigParams().getExponent();
        this.b.d = PkInitilaizer.getConfigParams().getModulus();
        this.b.e = PkInitilaizer.getConfigParams().getVersion();
        if ((this.b.c.equals("")) || (this.b.d.equals("")) || (this.b.e.equals(""))) {
            Log.internal("[InMobi]-[CARB]-4.5.1", "Exception retreiving Carb info due to key problem");
            CARB.b(this.b);
        }
        Object localObject;
        do {
            return;
            localObject = b();
            Log.internal("[InMobi]-[CARB]-4.5.1", "Unencrypted postbody :" + (String) localObject);
            localObject = CARB.a(this.b, (String) localObject, CARB.c(this.b), CARB.d(this.b), this.b.a, this.b.d, this.b.c);
            if (localObject == null) {
                CARB.b(this.b);
                return;
            }
        } while (a((String) localObject) == 200);
        int i = CarbInitializer.getConfigParams().getRetryCount();
        long l = CarbInitializer.getConfigParams().getRetryInterval();
        if (this.a <= i) {
        }
        try {
            Thread.sleep(this.a * (l * 1000L));
            Log.internal("[InMobi]-[CARB]-4.5.1", "Get carb info Failed. Retrying count: " + this.a);
            this.a += 1;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler().postDelayed(this, 0L);
            Looper.loop();
            Looper.myLooper().quit();
            return;
            this.a = 0;
            localObject = CARB.a().edit();
            ((SharedPreferences.Editor) localObject).putLong(CARB.e(this.b), System.currentTimeMillis());
            ((SharedPreferences.Editor) localObject).commit();
            CARB.f(this.b);
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        }
    }

    private String b() {
        StringBuffer localStringBuffer = new StringBuffer();
        CARB.fillCarbInfo();
        localStringBuffer.append("mk-siteid=");
        localStringBuffer.append(CARB.getURLEncoded(InMobi.getAppId()));
        Object localObject = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.1") + "-" + "20140918";
        localStringBuffer.append("&mk-version=");
        localStringBuffer.append(CARB.getURLEncoded((String) localObject));
        localObject = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
        localObject = UID.getInstance().getJSON((Map) localObject);
        localStringBuffer.append("&u-id-map=");
        localStringBuffer.append(CARB.getURLEncoded((String) localObject));
        localStringBuffer.append("&u-appbid=");
        localStringBuffer.append(CARB.getURLEncoded(CARB.getAppBid()));
        localStringBuffer.append("&u-appver=");
        localStringBuffer.append(CARB.getURLEncoded(CARB.getAppVer()));
        localStringBuffer.append("&h-user-agent=");
        localStringBuffer.append(CARB.getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
        localStringBuffer.append("&d-localization=");
        localStringBuffer.append(CARB.getURLEncoded(DeviceInfo.getLocalization()));
        localStringBuffer.append("&d-nettype=");
        localStringBuffer.append(CARB.getURLEncoded(DeviceInfo.getNetworkType()));
        localObject = null;
        try {
            WifiInfo localWifiInfo = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
            localObject = localWifiInfo;
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "No wifi permissions set, unable to send wifi data");
            }
        }
        if (localObject != null) {
            localStringBuffer.append("&c-ap-bssid=");
            localStringBuffer.append(Long.toString(((WifiInfo) localObject).bssid));
        }
        return localStringBuffer.toString();
    }

    public void run() {
        a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/carb/CARB$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */