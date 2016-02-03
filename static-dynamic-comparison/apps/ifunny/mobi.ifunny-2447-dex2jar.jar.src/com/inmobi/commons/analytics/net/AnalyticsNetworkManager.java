package com.inmobi.commons.analytics.net;

import android.os.Handler;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;

public final class AnalyticsNetworkManager {
    public static final int MESSAGE_PING = 1001;
    private static Handler a;
    private static AnalyticsNetworkManager b;
    private static AnalyticsConnectivityReceiver.a f = new a();
    private AnalyticsPayloadBuilder c;
    private AnalyticsConnectivityReceiver d;
    private int e = 0;

    private AnalyticsNetworkManager() {
        new AnalyticsNetworkManager.a(this).start();
        Log.debug("[InMobi]-[Analytics]-4.5.1", "NetworkManager-> Constructor ");
    }

    private String a(String paramString1, String paramString2, boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramString1 != null) {
            localStringBuilder.append("payload=");
            localStringBuilder.append(AnalyticsCommon.getURLEncoded(paramString1));
        }
        if (paramString2 != null) {
            localStringBuilder.append("&mk-siteid=");
            localStringBuilder.append(paramString2);
        }
        localStringBuilder.append("&c=");
        if (paramBoolean) {
            localStringBuilder.append(1);
            paramString1 = AnalyticsInitializer.getConfigParams().getDeviceIdMaskMap();
            paramString1 = InternalSDKUtil.encodeMapAndconvertToDelimitedString(UID.getInstance().getMapForEncryption(paramString1), "&");
            localStringBuilder.append("&");
            localStringBuilder.append(paramString1);
            paramString1 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.1") + "-" + "20140918";
            localStringBuilder.append("&mk-version=");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("&u-id-adt=");
            if (!UID.getInstance().isLimitAdTrackingEnabled()) {
                break label193;
            }
            localStringBuilder.append(1);
        }
        for (; ; ) {
            return localStringBuilder.toString();
            localStringBuilder.append(0);
            break;
            label193:
            localStringBuilder.append(0);
        }
    }

    /* Error */
    private void a(AnalyticsPayload paramAnalyticsPayload, String paramString) {
        // Byte code:
        //   0: ldc 41
        //   2: new 56	java/lang/StringBuilder
        //   5: dup
        //   6: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   9: ldc -118
        //   11: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: invokestatic 143	com/inmobi/commons/analytics/util/AnalyticsUtils:getEventUrl	()Ljava/lang/String;
        //   17: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   23: invokestatic 146	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   26: aload_1
        //   27: invokevirtual 151	com/inmobi/commons/analytics/net/AnalyticsPayload:getCompletePayload	()Ljava/lang/String;
        //   30: astore 5
        //   32: invokestatic 82	com/inmobi/commons/analytics/bootstrapper/AnalyticsInitializer:getConfigParams	()Lcom/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams;
        //   35: invokevirtual 155	com/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams:getMinEventsToCompress	()I
        //   38: istore_3
        //   39: ldc 41
        //   41: new 56	java/lang/StringBuilder
        //   44: dup
        //   45: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   48: ldc -99
        //   50: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   53: aload 5
        //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   58: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   61: invokestatic 146	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   64: aload_1
        //   65: invokevirtual 160	com/inmobi/commons/analytics/net/AnalyticsPayload:getPayloadSize	()I
        //   68: iload_3
        //   69: if_icmplt +394 -> 463
        //   72: getstatic 165	android/os/Build$VERSION:SDK_INT	I
        //   75: bipush 8
        //   77: if_icmplt +386 -> 463
        //   80: ldc 41
        //   82: ldc -89
        //   84: invokestatic 49	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   87: iconst_1
        //   88: istore 4
        //   90: aload 5
        //   92: invokestatic 170	com/inmobi/commons/analytics/util/AnalyticsUtils:compressPayload	(Ljava/lang/String;)Ljava/lang/String;
        //   95: astore 5
        //   97: invokestatic 82	com/inmobi/commons/analytics/bootstrapper/AnalyticsInitializer:getConfigParams	()Lcom/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams;
        //   100: invokevirtual 173	com/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams:getMaxAppIdLength	()I
        //   103: istore_3
        //   104: aload_2
        //   105: astore 6
        //   107: aload_2
        //   108: invokevirtual 178	java/lang/String:length	()I
        //   111: iload_3
        //   112: if_icmple +11 -> 123
        //   115: aload_2
        //   116: iconst_0
        //   117: iload_3
        //   118: invokevirtual 182	java/lang/String:substring	(II)Ljava/lang/String;
        //   121: astore 6
        //   123: aload_0
        //   124: aload 5
        //   126: aload 6
        //   128: iload 4
        //   130: invokespecial 184	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
        //   133: astore_2
        //   134: ldc 41
        //   136: new 56	java/lang/StringBuilder
        //   139: dup
        //   140: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   143: ldc -99
        //   145: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_2
        //   149: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   155: invokestatic 49	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   158: new 65	com/inmobi/commons/analytics/net/AnalyticsCommon
        //   161: dup
        //   162: invokespecial 185	com/inmobi/commons/analytics/net/AnalyticsCommon:<init>	()V
        //   165: astore 5
        //   167: aload 5
        //   169: invokestatic 143	com/inmobi/commons/analytics/util/AnalyticsUtils:getEventUrl	()Ljava/lang/String;
        //   172: invokevirtual 189	com/inmobi/commons/analytics/net/AnalyticsCommon:setupConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
        //   175: astore 6
        //   177: aload 5
        //   179: aload 6
        //   181: aload_2
        //   182: invokevirtual 193	com/inmobi/commons/analytics/net/AnalyticsCommon:postData	(Ljava/net/HttpURLConnection;Ljava/lang/String;)V
        //   185: aload 6
        //   187: invokevirtual 198	java/net/HttpURLConnection:getResponseCode	()I
        //   190: istore_3
        //   191: ldc 41
        //   193: new 56	java/lang/StringBuilder
        //   196: dup
        //   197: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   200: ldc -56
        //   202: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: iload_3
        //   206: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   209: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   212: invokestatic 49	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   215: iload_3
        //   216: sipush 200
        //   219: if_icmpne +85 -> 304
        //   222: aload_0
        //   223: iconst_0
        //   224: putfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   227: invokestatic 205	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        //   230: aload_1
        //   231: invokevirtual 209	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
        //   234: invokevirtual 213	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
        //   237: new 215	java/io/BufferedReader
        //   240: dup
        //   241: new 217	java/io/InputStreamReader
        //   244: dup
        //   245: aload 6
        //   247: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   250: ldc -33
        //   252: invokespecial 226	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   255: invokespecial 229	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   258: astore_2
        //   259: new 56	java/lang/StringBuilder
        //   262: dup
        //   263: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   266: astore 7
        //   268: aload_2
        //   269: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   272: astore 8
        //   274: aload 8
        //   276: ifnull +143 -> 419
        //   279: aload 7
        //   281: aload 8
        //   283: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   286: ldc -22
        //   288: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   291: pop
        //   292: goto -24 -> 268
        //   295: astore_2
        //   296: ldc 41
        //   298: ldc -20
        //   300: invokestatic 146	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   303: return
        //   304: aload_0
        //   305: aload_0
        //   306: getfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   309: iconst_1
        //   310: iadd
        //   311: putfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   314: aload_0
        //   315: getfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   318: invokestatic 239	com/inmobi/commons/analytics/util/AnalyticsUtils:getMaxRetryBeforeDiscard	()I
        //   321: if_icmplt -84 -> 237
        //   324: aload_0
        //   325: iconst_0
        //   326: putfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   329: invokestatic 205	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        //   332: aload_1
        //   333: invokevirtual 209	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
        //   336: invokevirtual 213	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
        //   339: goto -102 -> 237
        //   342: astore_2
        //   343: ldc 41
        //   345: ldc -15
        //   347: aload_2
        //   348: invokestatic 244	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   351: aload_0
        //   352: aload_0
        //   353: getfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   356: iconst_1
        //   357: iadd
        //   358: putfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   361: aload_0
        //   362: getfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   365: invokestatic 239	com/inmobi/commons/analytics/util/AnalyticsUtils:getMaxRetryBeforeDiscard	()I
        //   368: if_icmplt +101 -> 469
        //   371: aload_0
        //   372: iconst_0
        //   373: putfield 31	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
        //   376: invokestatic 205	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
        //   379: aload_1
        //   380: invokevirtual 209	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
        //   383: invokevirtual 213	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
        //   386: return
        //   387: astore_2
        //   388: new 215	java/io/BufferedReader
        //   391: dup
        //   392: new 217	java/io/InputStreamReader
        //   395: dup
        //   396: aload 6
        //   398: invokevirtual 247	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   401: ldc -33
        //   403: invokespecial 226	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   406: invokespecial 229	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   409: astore_2
        //   410: goto -151 -> 259
        //   413: astore_2
        //   414: aconst_null
        //   415: astore_2
        //   416: goto -157 -> 259
        //   419: aload 7
        //   421: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   424: astore 7
        //   426: ldc 41
        //   428: new 56	java/lang/StringBuilder
        //   431: dup
        //   432: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   435: ldc -7
        //   437: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   440: aload 7
        //   442: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   445: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   448: invokestatic 49	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   451: aload 6
        //   453: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
        //   456: aload 5
        //   458: aload_2
        //   459: invokevirtual 256	com/inmobi/commons/analytics/net/AnalyticsCommon:closeResource	(Ljava/io/Closeable;)V
        //   462: return
        //   463: iconst_0
        //   464: istore 4
        //   466: goto -369 -> 97
        //   469: return
        //   470: astore_2
        //   471: sipush 401
        //   474: istore_3
        //   475: goto -284 -> 191
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	478	0	this	AnalyticsNetworkManager
        //   0	478	1	paramAnalyticsPayload	AnalyticsPayload
        //   0	478	2	paramString	String
        //   38	437	3	i	int
        //   88	377	4	bool	boolean
        //   30	427	5	localObject1	Object
        //   105	347	6	localObject2	Object
        //   266	175	7	localObject3	Object
        //   272	10	8	str	String
        // Exception table:
        //   from	to	target	type
        //   259	268	295	java/lang/Exception
        //   268	274	295	java/lang/Exception
        //   279	292	295	java/lang/Exception
        //   419	462	295	java/lang/Exception
        //   0	87	342	java/lang/Exception
        //   90	97	342	java/lang/Exception
        //   97	104	342	java/lang/Exception
        //   107	123	342	java/lang/Exception
        //   123	185	342	java/lang/Exception
        //   185	191	342	java/lang/Exception
        //   191	215	342	java/lang/Exception
        //   222	237	342	java/lang/Exception
        //   296	303	342	java/lang/Exception
        //   304	339	342	java/lang/Exception
        //   237	259	387	java/lang/Exception
        //   388	410	413	java/lang/Exception
        //   185	191	470	java/io/IOException
    }

    private void b() {
        int j = 1;
        int i = j;
        if (this.d != null) {
            i = j;
            if (this.d.isConnected()) {
                i = j;
                if (this.c != null) {
                    AnalyticsPayload localAnalyticsPayload = this.c.getPayloadList(AnalyticsDatabaseManager.getInstance().getEvents(), InternalSDKUtil.getContext());
                    i = j;
                    if (localAnalyticsPayload.getCompletePayload() != null) {
                        a(localAnalyticsPayload, SessionInfo.getAppId(InternalSDKUtil.getContext()));
                        i = 0;
                    }
                }
            }
        }
        if (i == 0) {
            a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
            return;
        }
        AnalyticsUtils.setStartHandle(false);
    }

    public static Handler getHandler() {
        return a;
    }

    public static AnalyticsNetworkManager startInstance() {
        try {
            if (b == null) {
                b = new AnalyticsNetworkManager();
            }
            if (b.c == null) {
                b.c = new AnalyticsPayloadBuilder();
            }
            if (b.d == null) {
                b.d = new AnalyticsConnectivityReceiver(InternalSDKUtil.getContext(), f);
            }
            AnalyticsNetworkManager localAnalyticsNetworkManager = b;
            return localAnalyticsNetworkManager;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsNetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */