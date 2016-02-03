package com.uservoice.uservoicesdk.babayaga;

import android.os.AsyncTask;

import java.util.Map;

public class BabayagaTask
        extends AsyncTask<String, String, Void> {
    private final String event;
    private final Map<String, Object> eventProps;
    private final Map<String, Object> traits;
    private final String uvts;

    public BabayagaTask(String paramString1, String paramString2, Map<String, Object> paramMap1, Map<String, Object> paramMap2) {
        this.event = paramString1;
        this.uvts = paramString2;
        this.traits = paramMap1;
        this.eventProps = paramMap2;
    }

    /* Error */
    protected Void doInBackground(String... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: iconst_0
        //   4: istore_2
        //   5: new 41	org/json/JSONObject
        //   8: dup
        //   9: invokespecial 42	org/json/JSONObject:<init>	()V
        //   12: astore 6
        //   14: aload_0
        //   15: getfield 23	com/uservoice/uservoicesdk/babayaga/BabayagaTask:traits	Ljava/util/Map;
        //   18: ifnull +34 -> 52
        //   21: aload_0
        //   22: getfield 23	com/uservoice/uservoicesdk/babayaga/BabayagaTask:traits	Ljava/util/Map;
        //   25: invokeinterface 48 1 0
        //   30: ifne +22 -> 52
        //   33: aload 6
        //   35: ldc 50
        //   37: new 41	org/json/JSONObject
        //   40: dup
        //   41: aload_0
        //   42: getfield 23	com/uservoice/uservoicesdk/babayaga/BabayagaTask:traits	Ljava/util/Map;
        //   45: invokespecial 53	org/json/JSONObject:<init>	(Ljava/util/Map;)V
        //   48: invokevirtual 57	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   51: pop
        //   52: aload_0
        //   53: getfield 25	com/uservoice/uservoicesdk/babayaga/BabayagaTask:eventProps	Ljava/util/Map;
        //   56: ifnull +27 -> 83
        //   59: aload_0
        //   60: getfield 25	com/uservoice/uservoicesdk/babayaga/BabayagaTask:eventProps	Ljava/util/Map;
        //   63: invokeinterface 48 1 0
        //   68: ifne +15 -> 83
        //   71: aload 6
        //   73: ldc 59
        //   75: aload_0
        //   76: getfield 25	com/uservoice/uservoicesdk/babayaga/BabayagaTask:eventProps	Ljava/util/Map;
        //   79: invokevirtual 57	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   82: pop
        //   83: invokestatic 65	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   86: invokevirtual 69	com/uservoice/uservoicesdk/Session:getClientConfig	()Lcom/uservoice/uservoicesdk/model/ClientConfig;
        //   89: ifnull +290 -> 379
        //   92: invokestatic 65	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   95: invokevirtual 69	com/uservoice/uservoicesdk/Session:getClientConfig	()Lcom/uservoice/uservoicesdk/model/ClientConfig;
        //   98: invokevirtual 75	com/uservoice/uservoicesdk/model/ClientConfig:getSubdomainId	()Ljava/lang/String;
        //   101: astore_3
        //   102: ldc 77
        //   104: astore_1
        //   105: aload_0
        //   106: getfield 19	com/uservoice/uservoicesdk/babayaga/BabayagaTask:event	Ljava/lang/String;
        //   109: getstatic 83	com/uservoice/uservoicesdk/babayaga/Babayaga$Event:VIEW_APP	Lcom/uservoice/uservoicesdk/babayaga/Babayaga$Event;
        //   112: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   115: ifeq +287 -> 402
        //   118: getstatic 94	com/uservoice/uservoicesdk/babayaga/Babayaga:EXTERNAL_CHANNEL	Ljava/lang/String;
        //   121: astore 4
        //   123: new 96	java/lang/StringBuilder
        //   126: dup
        //   127: ldc 98
        //   129: iconst_5
        //   130: anewarray 100	java/lang/Object
        //   133: dup
        //   134: iconst_0
        //   135: getstatic 103	com/uservoice/uservoicesdk/babayaga/Babayaga:DOMAIN	Ljava/lang/String;
        //   138: aastore
        //   139: dup
        //   140: iconst_1
        //   141: aload_1
        //   142: aastore
        //   143: dup
        //   144: iconst_2
        //   145: aload_3
        //   146: aastore
        //   147: dup
        //   148: iconst_3
        //   149: aload 4
        //   151: aastore
        //   152: dup
        //   153: iconst_4
        //   154: aload_0
        //   155: getfield 19	com/uservoice/uservoicesdk/babayaga/BabayagaTask:event	Ljava/lang/String;
        //   158: aastore
        //   159: invokestatic 107	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   162: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   165: astore_1
        //   166: aload_0
        //   167: getfield 21	com/uservoice/uservoicesdk/babayaga/BabayagaTask:uvts	Ljava/lang/String;
        //   170: ifnull +19 -> 189
        //   173: aload_1
        //   174: ldc 112
        //   176: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: pop
        //   180: aload_1
        //   181: aload_0
        //   182: getfield 21	com/uservoice/uservoicesdk/babayaga/BabayagaTask:uvts	Ljava/lang/String;
        //   185: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: pop
        //   189: aload_1
        //   190: ldc 118
        //   192: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   195: pop
        //   196: aload_1
        //   197: new 120	java/util/Date
        //   200: dup
        //   201: invokespecial 121	java/util/Date:<init>	()V
        //   204: invokevirtual 125	java/util/Date:getTime	()J
        //   207: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   210: pop
        //   211: aload_1
        //   212: ldc -126
        //   214: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   217: pop
        //   218: aload 6
        //   220: invokevirtual 134	org/json/JSONObject:length	()I
        //   223: ifeq +32 -> 255
        //   226: aload_1
        //   227: ldc -120
        //   229: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: pop
        //   233: aload_1
        //   234: aload 6
        //   236: invokevirtual 139	org/json/JSONObject:toString	()Ljava/lang/String;
        //   239: invokevirtual 143	java/lang/String:getBytes	()[B
        //   242: iconst_2
        //   243: invokestatic 149	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
        //   246: ldc -105
        //   248: invokestatic 157	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   251: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   254: pop
        //   255: ldc -97
        //   257: aload_1
        //   258: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   261: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   264: pop
        //   265: new 168	org/apache/http/client/methods/HttpGet
        //   268: dup
        //   269: invokespecial 169	org/apache/http/client/methods/HttpGet:<init>	()V
        //   272: astore 4
        //   274: aload 4
        //   276: new 171	java/net/URI
        //   279: dup
        //   280: aload_1
        //   281: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   284: invokespecial 172	java/net/URI:<init>	(Ljava/lang/String;)V
        //   287: invokevirtual 178	org/apache/http/client/methods/HttpRequestBase:setURI	(Ljava/net/URI;)V
        //   290: ldc -76
        //   292: iconst_1
        //   293: anewarray 100	java/lang/Object
        //   296: dup
        //   297: iconst_0
        //   298: invokestatic 185	com/uservoice/uservoicesdk/UserVoice:getVersion	()Ljava/lang/String;
        //   301: aastore
        //   302: invokestatic 107	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   305: invokestatic 65	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   308: invokevirtual 189	com/uservoice/uservoicesdk/Session:getContext	()Landroid/content/Context;
        //   311: invokestatic 195	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;Landroid/content/Context;)Landroid/net/http/AndroidHttpClient;
        //   314: astore_1
        //   315: aload_1
        //   316: astore_3
        //   317: aload_1
        //   318: aload 4
        //   320: invokevirtual 199	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   323: astore 5
        //   325: aload_1
        //   326: astore_3
        //   327: aload 5
        //   329: invokeinterface 205 1 0
        //   334: astore 4
        //   336: aload_1
        //   337: astore_3
        //   338: aload 5
        //   340: invokeinterface 209 1 0
        //   345: astore 5
        //   347: aload 5
        //   349: ifnull +13 -> 362
        //   352: aload_1
        //   353: astore_3
        //   354: aload 5
        //   356: invokeinterface 214 1 0
        //   361: istore_2
        //   362: iload_2
        //   363: sipush 200
        //   366: if_icmpeq +111 -> 477
        //   369: aload_1
        //   370: ifnull +7 -> 377
        //   373: aload_1
        //   374: invokevirtual 217	android/net/http/AndroidHttpClient:close	()V
        //   377: aconst_null
        //   378: areturn
        //   379: invokestatic 65	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   382: invokevirtual 221	com/uservoice/uservoicesdk/Session:getConfig	()Lcom/uservoice/uservoicesdk/Config;
        //   385: invokevirtual 226	com/uservoice/uservoicesdk/Config:getSite	()Ljava/lang/String;
        //   388: ldc -28
        //   390: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   393: iconst_0
        //   394: aaload
        //   395: astore_3
        //   396: ldc -22
        //   398: astore_1
        //   399: goto -294 -> 105
        //   402: getstatic 237	com/uservoice/uservoicesdk/babayaga/Babayaga:CHANNEL	Ljava/lang/String;
        //   405: astore 4
        //   407: goto -284 -> 123
        //   410: astore_1
        //   411: new 239	java/lang/RuntimeException
        //   414: dup
        //   415: aload_1
        //   416: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   419: athrow
        //   420: astore 4
        //   422: aconst_null
        //   423: astore_1
        //   424: aload_1
        //   425: astore_3
        //   426: aload 4
        //   428: invokevirtual 245	java/lang/Exception:printStackTrace	()V
        //   431: aload_1
        //   432: astore_3
        //   433: ldc -97
        //   435: ldc -9
        //   437: iconst_2
        //   438: anewarray 100	java/lang/Object
        //   441: dup
        //   442: iconst_0
        //   443: aload 4
        //   445: invokevirtual 251	java/lang/Object:getClass	()Ljava/lang/Class;
        //   448: invokevirtual 256	java/lang/Class:getName	()Ljava/lang/String;
        //   451: aastore
        //   452: dup
        //   453: iconst_1
        //   454: aload 4
        //   456: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   459: aastore
        //   460: invokestatic 107	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   463: invokestatic 261	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   466: pop
        //   467: aload_1
        //   468: ifnull -91 -> 377
        //   471: aload_1
        //   472: invokevirtual 217	android/net/http/AndroidHttpClient:close	()V
        //   475: aconst_null
        //   476: areturn
        //   477: aload 4
        //   479: ifnull +68 -> 547
        //   482: aload_1
        //   483: astore_3
        //   484: aload 4
        //   486: invokestatic 266	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   489: astore 4
        //   491: aload 4
        //   493: ifnull +44 -> 537
        //   496: aload_1
        //   497: astore_3
        //   498: aload 4
        //   500: invokevirtual 267	java/lang/String:length	()I
        //   503: ifle +34 -> 537
        //   506: aload_1
        //   507: astore_3
        //   508: new 41	org/json/JSONObject
        //   511: dup
        //   512: aload 4
        //   514: iconst_2
        //   515: aload 4
        //   517: invokevirtual 267	java/lang/String:length	()I
        //   520: iconst_2
        //   521: isub
        //   522: invokevirtual 271	java/lang/String:substring	(II)Ljava/lang/String;
        //   525: invokespecial 272	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   528: ldc_w 273
        //   531: invokevirtual 277	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   534: invokestatic 280	com/uservoice/uservoicesdk/babayaga/Babayaga:setUvts	(Ljava/lang/String;)V
        //   537: aload_1
        //   538: ifnull -161 -> 377
        //   541: aload_1
        //   542: invokevirtual 217	android/net/http/AndroidHttpClient:close	()V
        //   545: aconst_null
        //   546: areturn
        //   547: aconst_null
        //   548: astore 4
        //   550: goto -59 -> 491
        //   553: astore_1
        //   554: aload 5
        //   556: astore_3
        //   557: aload_3
        //   558: ifnull +7 -> 565
        //   561: aload_3
        //   562: invokevirtual 217	android/net/http/AndroidHttpClient:close	()V
        //   565: aload_1
        //   566: athrow
        //   567: astore_1
        //   568: goto -11 -> 557
        //   571: astore 4
        //   573: goto -149 -> 424
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	576	0	this	BabayagaTask
        //   0	576	1	paramVarArgs	String[]
        //   4	363	2	i	int
        //   101	461	3	localObject1	Object
        //   121	285	4	localObject2	Object
        //   420	65	4	localException1	Exception
        //   489	60	4	str	String
        //   571	1	4	localException2	Exception
        //   1	554	5	localObject3	Object
        //   12	223	6	localJSONObject	org.json.JSONObject
        // Exception table:
        //   from	to	target	type
        //   233	255	410	java/io/UnsupportedEncodingException
        //   5	52	420	java/lang/Exception
        //   52	83	420	java/lang/Exception
        //   83	102	420	java/lang/Exception
        //   105	123	420	java/lang/Exception
        //   123	189	420	java/lang/Exception
        //   189	233	420	java/lang/Exception
        //   233	255	420	java/lang/Exception
        //   255	315	420	java/lang/Exception
        //   379	396	420	java/lang/Exception
        //   402	407	420	java/lang/Exception
        //   411	420	420	java/lang/Exception
        //   5	52	553	finally
        //   52	83	553	finally
        //   83	102	553	finally
        //   105	123	553	finally
        //   123	189	553	finally
        //   189	233	553	finally
        //   233	255	553	finally
        //   255	315	553	finally
        //   379	396	553	finally
        //   402	407	553	finally
        //   411	420	553	finally
        //   317	325	567	finally
        //   327	336	567	finally
        //   338	347	567	finally
        //   354	362	567	finally
        //   426	431	567	finally
        //   433	467	567	finally
        //   484	491	567	finally
        //   498	506	567	finally
        //   508	537	567	finally
        //   317	325	571	java/lang/Exception
        //   327	336	571	java/lang/Exception
        //   338	347	571	java/lang/Exception
        //   354	362	571	java/lang/Exception
        //   484	491	571	java/lang/Exception
        //   498	506	571	java/lang/Exception
        //   508	537	571	java/lang/Exception
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/babayaga/BabayagaTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */