package com.inmobi.commons.analytics.net;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.HashMap;
import java.util.Random;

public final class AnalyticsNetworkManager
{
  public static final int MESSAGE_PING = 1001;
  private static Handler a;
  private static AnalyticsNetworkManager b;
  private static AnalyticsConnectivityReceiver.a f = new a();
  private AnalyticsPayloadBuilder c;
  private AnalyticsConnectivityReceiver d;
  private int e = 0;
  
  private AnalyticsNetworkManager()
  {
    new a().start();
    Log.debug("[InMobi]-[Analytics]-4.1.1", "NetworkManager-> Constructor ");
  }
  
  private String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Integer.toString(new Random().nextInt());
    Object localObject = null;
    Long localLong = AnalyticsInitializer.getConfigParams().getLTVId();
    if (paramString1 != null)
    {
      localStringBuilder.append("payload=");
      localStringBuilder.append(AnalyticsCommon.getURLEncoded(paramString1));
    }
    if (paramString2 != null)
    {
      localStringBuilder.append("&app_id=");
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("&c=");
    if (paramBoolean) {
      localStringBuilder.append(1);
    }
    for (;;)
    {
      paramString1 = (String)localObject;
      if (localLong != null)
      {
        paramString1 = new HashMap();
        paramString1.put("LTVID", localLong + "");
      }
      paramString1 = AnalyticsInitializer.getConfigParams().getUID().getUidMap(1, str, paramString1);
      localStringBuilder.append("&u-id-map=");
      localStringBuilder.append(AnalyticsCommon.getURLEncoded(paramString1));
      localStringBuilder.append("&u-id-key=");
      localStringBuilder.append(str);
      localStringBuilder.append("&u-key-ver=");
      localStringBuilder.append(UIDHelper.getRSAKeyVersion());
      paramString1 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.1.1") + "-" + "20140131";
      localStringBuilder.append("&mk-version=");
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
      localStringBuilder.append(0);
    }
  }
  
  /* Error */
  private void a(AnalyticsPayload paramAnalyticsPayload, String paramString)
  {
    // Byte code:
    //   0: ldc 43
    //   2: new 58	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   9: ldc -91
    //   11: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 170	com/inmobi/commons/analytics/util/AnalyticsUtils:getEventUrl	()Ljava/lang/String;
    //   17: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 51	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 175	com/inmobi/commons/analytics/net/AnalyticsPayload:getCompletePayload	()Ljava/lang/String;
    //   30: astore 5
    //   32: invokestatic 78	com/inmobi/commons/analytics/bootstrapper/AnalyticsInitializer:getConfigParams	()Lcom/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams;
    //   35: invokevirtual 178	com/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams:getMinEventsToCompress	()I
    //   38: istore_3
    //   39: ldc 43
    //   41: new 58	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   48: ldc -76
    //   50: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 5
    //   55: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 183	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 186	com/inmobi/commons/analytics/net/AnalyticsPayload:getPayloadSize	()I
    //   68: iload_3
    //   69: if_icmplt +398 -> 467
    //   72: getstatic 191	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 8
    //   77: if_icmplt +390 -> 467
    //   80: ldc 43
    //   82: ldc -63
    //   84: invokestatic 51	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_1
    //   88: istore 4
    //   90: aload 5
    //   92: invokestatic 196	com/inmobi/commons/analytics/util/AnalyticsUtils:compressPayload	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 5
    //   97: invokestatic 78	com/inmobi/commons/analytics/bootstrapper/AnalyticsInitializer:getConfigParams	()Lcom/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams;
    //   100: invokevirtual 199	com/inmobi/commons/analytics/bootstrapper/AnalyticsConfigParams:getMaxAppIdLength	()I
    //   103: istore_3
    //   104: aload_2
    //   105: astore 6
    //   107: aload_2
    //   108: invokevirtual 204	java/lang/String:length	()I
    //   111: iload_3
    //   112: if_icmple +11 -> 123
    //   115: aload_2
    //   116: iconst_0
    //   117: iload_3
    //   118: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   121: astore 6
    //   123: aload_0
    //   124: aload 5
    //   126: aload 6
    //   128: iload 4
    //   130: invokespecial 210	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   133: astore_2
    //   134: ldc 43
    //   136: new 58	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   143: ldc -76
    //   145: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 183	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: new 92	com/inmobi/commons/analytics/net/AnalyticsCommon
    //   161: dup
    //   162: invokespecial 211	com/inmobi/commons/analytics/net/AnalyticsCommon:<init>	()V
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 170	com/inmobi/commons/analytics/util/AnalyticsUtils:getEventUrl	()Ljava/lang/String;
    //   172: invokevirtual 215	com/inmobi/commons/analytics/net/AnalyticsCommon:setupConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   175: astore 6
    //   177: aload 5
    //   179: aload 6
    //   181: aload_2
    //   182: invokevirtual 219	com/inmobi/commons/analytics/net/AnalyticsCommon:postData	(Ljava/net/HttpURLConnection;Ljava/lang/String;)V
    //   185: aload 6
    //   187: invokevirtual 224	java/net/HttpURLConnection:getResponseCode	()I
    //   190: istore_3
    //   191: ldc 43
    //   193: new 58	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   200: ldc -30
    //   202: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload_3
    //   206: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 51	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iload_3
    //   216: sipush 200
    //   219: if_icmpne +87 -> 306
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   227: invokestatic 232	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
    //   230: aload_1
    //   231: invokevirtual 236	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
    //   234: invokevirtual 240	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
    //   237: new 242	java/io/BufferedReader
    //   240: dup
    //   241: new 244	java/io/InputStreamReader
    //   244: dup
    //   245: aload 6
    //   247: invokevirtual 248	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   250: ldc -6
    //   252: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   255: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   258: astore_2
    //   259: new 58	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   266: astore 7
    //   268: aload_2
    //   269: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   272: astore 8
    //   274: aload 8
    //   276: ifnull +146 -> 422
    //   279: aload 7
    //   281: aload 8
    //   283: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 261
    //   289: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: goto -25 -> 268
    //   296: astore_2
    //   297: ldc 43
    //   299: ldc_w 263
    //   302: invokestatic 183	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: return
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   311: iconst_1
    //   312: iadd
    //   313: putfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   316: aload_0
    //   317: getfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   320: invokestatic 266	com/inmobi/commons/analytics/util/AnalyticsUtils:getMaxRetryBeforeDiscard	()I
    //   323: if_icmplt -86 -> 237
    //   326: aload_0
    //   327: iconst_0
    //   328: putfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   331: invokestatic 232	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
    //   334: aload_1
    //   335: invokevirtual 236	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
    //   338: invokevirtual 240	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
    //   341: goto -104 -> 237
    //   344: astore_2
    //   345: ldc 43
    //   347: ldc_w 268
    //   350: aload_2
    //   351: invokestatic 271	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   359: iconst_1
    //   360: iadd
    //   361: putfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   364: aload_0
    //   365: getfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   368: invokestatic 266	com/inmobi/commons/analytics/util/AnalyticsUtils:getMaxRetryBeforeDiscard	()I
    //   371: if_icmplt +102 -> 473
    //   374: aload_0
    //   375: iconst_0
    //   376: putfield 35	com/inmobi/commons/analytics/net/AnalyticsNetworkManager:e	I
    //   379: invokestatic 232	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:getInstance	()Lcom/inmobi/commons/analytics/db/AnalyticsDatabaseManager;
    //   382: aload_1
    //   383: invokevirtual 236	com/inmobi/commons/analytics/net/AnalyticsPayload:getTableIdList	()Ljava/util/List;
    //   386: invokevirtual 240	com/inmobi/commons/analytics/db/AnalyticsDatabaseManager:deleteEvents	(Ljava/util/List;)V
    //   389: return
    //   390: astore_2
    //   391: new 242	java/io/BufferedReader
    //   394: dup
    //   395: new 244	java/io/InputStreamReader
    //   398: dup
    //   399: aload 6
    //   401: invokevirtual 274	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   404: ldc -6
    //   406: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   409: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   412: astore_2
    //   413: goto -154 -> 259
    //   416: astore_2
    //   417: aconst_null
    //   418: astore_2
    //   419: goto -160 -> 259
    //   422: aload 7
    //   424: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: astore 7
    //   429: ldc 43
    //   431: new 58	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 276
    //   441: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 7
    //   446: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 51	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 6
    //   457: invokevirtual 279	java/net/HttpURLConnection:disconnect	()V
    //   460: aload 5
    //   462: aload_2
    //   463: invokevirtual 283	com/inmobi/commons/analytics/net/AnalyticsCommon:closeResource	(Ljava/io/Closeable;)V
    //   466: return
    //   467: iconst_0
    //   468: istore 4
    //   470: goto -373 -> 97
    //   473: return
    //   474: astore_2
    //   475: sipush 401
    //   478: istore_3
    //   479: goto -288 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	AnalyticsNetworkManager
    //   0	482	1	paramAnalyticsPayload	AnalyticsPayload
    //   0	482	2	paramString	String
    //   38	441	3	i	int
    //   88	381	4	bool	boolean
    //   30	431	5	localObject1	Object
    //   105	351	6	localObject2	Object
    //   266	179	7	localObject3	Object
    //   272	10	8	str	String
    // Exception table:
    //   from	to	target	type
    //   259	268	296	java/lang/Exception
    //   268	274	296	java/lang/Exception
    //   279	293	296	java/lang/Exception
    //   422	466	296	java/lang/Exception
    //   0	87	344	java/lang/Exception
    //   90	97	344	java/lang/Exception
    //   97	104	344	java/lang/Exception
    //   107	123	344	java/lang/Exception
    //   123	185	344	java/lang/Exception
    //   185	191	344	java/lang/Exception
    //   191	215	344	java/lang/Exception
    //   222	237	344	java/lang/Exception
    //   297	305	344	java/lang/Exception
    //   306	341	344	java/lang/Exception
    //   237	259	390	java/lang/Exception
    //   391	413	416	java/lang/Exception
    //   185	191	474	java/io/IOException
  }
  
  private void b()
  {
    int j = 1;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (this.d.isConnected())
      {
        i = j;
        if (this.c != null)
        {
          AnalyticsPayload localAnalyticsPayload = this.c.getPayloadList(AnalyticsDatabaseManager.getInstance().getEvents(), InternalSDKUtil.getContext());
          i = j;
          if (localAnalyticsPayload.getCompletePayload() != null)
          {
            a(localAnalyticsPayload, SessionInfo.getAppId(InternalSDKUtil.getContext()));
            i = 0;
          }
        }
      }
    }
    if (i == 0)
    {
      a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
      return;
    }
    AnalyticsUtils.setStartHandle(false);
  }
  
  public static Handler getHandler()
  {
    return a;
  }
  
  public static AnalyticsNetworkManager startInstance()
  {
    try
    {
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
    }
    finally {}
  }
  
  class a
    extends Thread
  {
    a() {}
    
    public void run()
    {
      Looper.prepare();
      AnalyticsNetworkManager.a(new Handler(new a()));
      Looper.loop();
    }
    
    class a
      implements Handler.Callback
    {
      a() {}
      
      public boolean handleMessage(Message paramMessage)
      {
        Log.debug("[InMobi]-[Analytics]-4.1.1", "NetworkManager->handleMessag: msg:" + paramMessage);
        if (paramMessage.what == 1001)
        {
          if ((!AnalyticsInitializer.getConfigParams().getAutomaticCapture().getAutoSessionCapture()) && (!AnalyticsEventsWrapper.isEventsUser())) {
            AnalyticsUtils.setStartHandle(false);
          }
        }
        else {
          return true;
        }
        AnalyticsNetworkManager.a(AnalyticsNetworkManager.this);
        return true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsNetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */