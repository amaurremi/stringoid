package com.amazon.device.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class AppEventRegistrationHandler {
    protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
    protected static final long APP_EVENTS_FILE_MAX_SIZE = 1048576L;
    protected static final String APP_EVENT_NAME_KEY = "evtName";
    protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
    private static final String LOG_TAG = AppEventRegistrationHandler.class.getSimpleName();
    protected static AppEventRegistrationHandler instance = new AppEventRegistrationHandler();
    protected final Object appEventsFileLock = new Object();
    protected final Set<String> eventsSent = Collections.synchronizedSet(new HashSet());
    protected final Set<String> newEventsToSave = Collections.synchronizedSet(new HashSet());

    public static AppEventRegistrationHandler getInstance() {
        return instance;
    }

    public void addEventToAppEventsCacheFile(final AppEvent paramAppEvent) {
        ThreadUtils.executeRunnable(new Runnable() {
            public void run() {
                AppEventRegistrationHandler.this.appendAppEventToFile(paramAppEvent);
            }
        });
    }

    /* Error */
    protected void appendAppEventToFile(AppEvent paramAppEvent) {
        // Byte code:
        //   0: invokestatic 84	com/amazon/device/ads/InternalAdRegistration:getInstance	()Lcom/amazon/device/ads/IInternalAdRegistration;
        //   3: invokeinterface 90 1 0
        //   8: astore_2
        //   9: aload_2
        //   10: ifnonnull +4 -> 14
        //   13: return
        //   14: new 92	org/json/JSONObject
        //   17: dup
        //   18: invokespecial 93	org/json/JSONObject:<init>	()V
        //   21: astore_3
        //   22: aload_3
        //   23: ldc 17
        //   25: aload_1
        //   26: invokevirtual 98	com/amazon/device/ads/AppEvent:getEventName	()Ljava/lang/String;
        //   29: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   32: pop
        //   33: aload_3
        //   34: ldc 20
        //   36: aload_1
        //   37: invokevirtual 106	com/amazon/device/ads/AppEvent:getTimestamp	()J
        //   40: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   43: pop
        //   44: aload_1
        //   45: invokevirtual 113	com/amazon/device/ads/AppEvent:getPropertyEntries	()Ljava/util/Set;
        //   48: invokeinterface 119 1 0
        //   53: astore 4
        //   55: aload 4
        //   57: invokeinterface 125 1 0
        //   62: ifeq +61 -> 123
        //   65: aload 4
        //   67: invokeinterface 129 1 0
        //   72: checkcast 131	java/util/Map$Entry
        //   75: astore 5
        //   77: aload_3
        //   78: aload 5
        //   80: invokeinterface 134 1 0
        //   85: checkcast 136	java/lang/String
        //   88: aload 5
        //   90: invokeinterface 139 1 0
        //   95: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   98: pop
        //   99: goto -44 -> 55
        //   102: astore_2
        //   103: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   106: ldc -115
        //   108: iconst_1
        //   109: anewarray 4	java/lang/Object
        //   112: dup
        //   113: iconst_0
        //   114: aload_1
        //   115: invokevirtual 144	com/amazon/device/ads/AppEvent:toString	()Ljava/lang/String;
        //   118: aastore
        //   119: invokestatic 150	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   122: return
        //   123: aload_0
        //   124: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   127: aload_3
        //   128: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
        //   131: invokeinterface 155 2 0
        //   136: pop
        //   137: aload_0
        //   138: getfield 48	com/amazon/device/ads/AppEventRegistrationHandler:appEventsFileLock	Ljava/lang/Object;
        //   141: astore 5
        //   143: aload 5
        //   145: monitorenter
        //   146: new 157	java/lang/StringBuilder
        //   149: dup
        //   150: invokespecial 158	java/lang/StringBuilder:<init>	()V
        //   153: aload_3
        //   154: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
        //   157: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: ldc -92
        //   162: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   165: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: astore 6
        //   170: new 167	java/io/File
        //   173: dup
        //   174: aload_2
        //   175: invokevirtual 173	android/content/Context:getFilesDir	()Ljava/io/File;
        //   178: ldc 10
        //   180: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   183: astore 7
        //   185: aload 7
        //   187: invokevirtual 179	java/io/File:length	()J
        //   190: aload 6
        //   192: invokevirtual 182	java/lang/String:length	()I
        //   195: i2l
        //   196: ladd
        //   197: ldc2_w 13
        //   200: lcmp
        //   201: ifle +32 -> 233
        //   204: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   207: ldc -72
        //   209: iconst_1
        //   210: anewarray 4	java/lang/Object
        //   213: dup
        //   214: iconst_0
        //   215: aload_1
        //   216: invokevirtual 144	com/amazon/device/ads/AppEvent:toString	()Ljava/lang/String;
        //   219: aastore
        //   220: invokestatic 150	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   223: aload 5
        //   225: monitorexit
        //   226: return
        //   227: astore_1
        //   228: aload 5
        //   230: monitorexit
        //   231: aload_1
        //   232: athrow
        //   233: aconst_null
        //   234: astore_2
        //   235: aconst_null
        //   236: astore 4
        //   238: aconst_null
        //   239: astore_3
        //   240: new 186	java/io/FileOutputStream
        //   243: dup
        //   244: aload 7
        //   246: iconst_1
        //   247: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
        //   250: astore 7
        //   252: new 191	java/io/OutputStreamWriter
        //   255: dup
        //   256: aload 7
        //   258: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   261: astore_2
        //   262: aload_2
        //   263: aload 6
        //   265: invokevirtual 198	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
        //   268: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   271: ldc -56
        //   273: iconst_1
        //   274: anewarray 4	java/lang/Object
        //   277: dup
        //   278: iconst_0
        //   279: aload_1
        //   280: invokevirtual 144	com/amazon/device/ads/AppEvent:toString	()Ljava/lang/String;
        //   283: aastore
        //   284: invokestatic 203	com/amazon/device/ads/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   287: aload_2
        //   288: ifnull +7 -> 295
        //   291: aload_2
        //   292: invokevirtual 206	java/io/OutputStreamWriter:close	()V
        //   295: aload 5
        //   297: monitorexit
        //   298: return
        //   299: astore_1
        //   300: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   303: ldc -48
        //   305: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   308: goto -13 -> 295
        //   311: astore_2
        //   312: aload_3
        //   313: astore_2
        //   314: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   317: ldc -43
        //   319: iconst_1
        //   320: anewarray 4	java/lang/Object
        //   323: dup
        //   324: iconst_0
        //   325: aload_1
        //   326: invokevirtual 144	com/amazon/device/ads/AppEvent:toString	()Ljava/lang/String;
        //   329: aastore
        //   330: invokestatic 150	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   333: aload_3
        //   334: ifnull -39 -> 295
        //   337: aload_3
        //   338: invokevirtual 206	java/io/OutputStreamWriter:close	()V
        //   341: goto -46 -> 295
        //   344: astore_1
        //   345: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   348: ldc -48
        //   350: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   353: goto -58 -> 295
        //   356: astore_1
        //   357: aload_2
        //   358: ifnull +7 -> 365
        //   361: aload_2
        //   362: invokevirtual 206	java/io/OutputStreamWriter:close	()V
        //   365: aload_1
        //   366: athrow
        //   367: astore_2
        //   368: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   371: ldc -48
        //   373: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   376: goto -11 -> 365
        //   379: astore_1
        //   380: aload 4
        //   382: astore_2
        //   383: goto -26 -> 357
        //   386: astore_1
        //   387: goto -30 -> 357
        //   390: astore_2
        //   391: goto -79 -> 312
        //   394: astore_3
        //   395: aload_2
        //   396: astore_3
        //   397: goto -85 -> 312
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	400	0	this	AppEventRegistrationHandler
        //   0	400	1	paramAppEvent	AppEvent
        //   8	2	2	localContext	android.content.Context
        //   102	73	2	localJSONException	org.json.JSONException
        //   234	58	2	localOutputStreamWriter	java.io.OutputStreamWriter
        //   311	1	2	localIOException1	java.io.IOException
        //   313	49	2	localObject1	Object
        //   367	1	2	localIOException2	java.io.IOException
        //   382	1	2	localObject2	Object
        //   390	6	2	localIOException3	java.io.IOException
        //   21	317	3	localJSONObject	org.json.JSONObject
        //   394	1	3	localIOException4	java.io.IOException
        //   396	1	3	localIOException5	java.io.IOException
        //   53	328	4	localIterator	java.util.Iterator
        //   75	221	5	localObject3	Object
        //   168	96	6	str	String
        //   183	74	7	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   22	55	102	org/json/JSONException
        //   55	99	102	org/json/JSONException
        //   146	226	227	finally
        //   228	231	227	finally
        //   291	295	227	finally
        //   295	298	227	finally
        //   300	308	227	finally
        //   337	341	227	finally
        //   345	353	227	finally
        //   361	365	227	finally
        //   365	367	227	finally
        //   368	376	227	finally
        //   291	295	299	java/io/IOException
        //   240	252	311	java/io/IOException
        //   337	341	344	java/io/IOException
        //   240	252	356	finally
        //   314	333	356	finally
        //   361	365	367	java/io/IOException
        //   252	262	379	finally
        //   262	287	386	finally
        //   252	262	390	java/io/IOException
        //   262	287	394	java/io/IOException
    }

    /* Error */
    public org.json.JSONArray getAppEventsJSONArray() {
        // Byte code:
        //   0: invokestatic 84	com/amazon/device/ads/InternalAdRegistration:getInstance	()Lcom/amazon/device/ads/IInternalAdRegistration;
        //   3: invokeinterface 90 1 0
        //   8: astore_1
        //   9: aload_1
        //   10: ifnonnull +5 -> 15
        //   13: aconst_null
        //   14: areturn
        //   15: aload_0
        //   16: getfield 48	com/amazon/device/ads/AppEventRegistrationHandler:appEventsFileLock	Ljava/lang/Object;
        //   19: astore 8
        //   21: aload 8
        //   23: monitorenter
        //   24: new 167	java/io/File
        //   27: dup
        //   28: aload_1
        //   29: invokevirtual 173	android/content/Context:getFilesDir	()Ljava/io/File;
        //   32: ldc 10
        //   34: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   37: astore_1
        //   38: aload_1
        //   39: invokevirtual 218	java/io/File:exists	()Z
        //   42: ifne +14 -> 56
        //   45: aload 8
        //   47: monitorexit
        //   48: aconst_null
        //   49: areturn
        //   50: astore_1
        //   51: aload 8
        //   53: monitorexit
        //   54: aload_1
        //   55: athrow
        //   56: aconst_null
        //   57: astore 4
        //   59: aconst_null
        //   60: astore 7
        //   62: aconst_null
        //   63: astore 5
        //   65: aconst_null
        //   66: astore 6
        //   68: aconst_null
        //   69: astore_3
        //   70: new 220	java/io/FileInputStream
        //   73: dup
        //   74: aload_1
        //   75: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   78: astore_1
        //   79: new 225	java/io/BufferedReader
        //   82: dup
        //   83: new 227	java/io/InputStreamReader
        //   86: dup
        //   87: aload_1
        //   88: invokespecial 230	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   91: invokespecial 233	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   94: astore_2
        //   95: aconst_null
        //   96: astore_3
        //   97: aload_2
        //   98: invokevirtual 236	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   101: astore 4
        //   103: aload 4
        //   105: ifnull +260 -> 365
        //   108: aload 4
        //   110: invokestatic 242	com/amazon/device/ads/JSONUtils:getJSONObjectFromString	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   113: astore 4
        //   115: aload 4
        //   117: ifnonnull +30 -> 147
        //   120: aload_0
        //   121: invokevirtual 245	com/amazon/device/ads/AppEventRegistrationHandler:onAppEventsRegistered	()V
        //   124: aconst_null
        //   125: astore_3
        //   126: aload_1
        //   127: ifnull +7 -> 134
        //   130: aload_1
        //   131: invokevirtual 246	java/io/FileInputStream:close	()V
        //   134: aload_2
        //   135: ifnull +7 -> 142
        //   138: aload_2
        //   139: invokevirtual 247	java/io/BufferedReader:close	()V
        //   142: aload 8
        //   144: monitorexit
        //   145: aload_3
        //   146: areturn
        //   147: aload_3
        //   148: ifnonnull +214 -> 362
        //   151: new 249	org/json/JSONArray
        //   154: dup
        //   155: invokespecial 250	org/json/JSONArray:<init>	()V
        //   158: astore_3
        //   159: aload_3
        //   160: aload 4
        //   162: invokevirtual 253	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
        //   165: pop
        //   166: aload_0
        //   167: getfield 61	com/amazon/device/ads/AppEventRegistrationHandler:eventsSent	Ljava/util/Set;
        //   170: aload 4
        //   172: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
        //   175: invokeinterface 155 2 0
        //   180: pop
        //   181: goto -84 -> 97
        //   184: astore_1
        //   185: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   188: ldc -1
        //   190: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   193: goto -59 -> 134
        //   196: astore_1
        //   197: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   200: ldc -1
        //   202: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   205: goto -63 -> 142
        //   208: astore_1
        //   209: aload_3
        //   210: astore_2
        //   211: aload 7
        //   213: astore_1
        //   214: aload_1
        //   215: astore 4
        //   217: aload_2
        //   218: astore 5
        //   220: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   223: ldc_w 257
        //   226: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   229: aconst_null
        //   230: astore 4
        //   232: aload_1
        //   233: ifnull +7 -> 240
        //   236: aload_1
        //   237: invokevirtual 246	java/io/FileInputStream:close	()V
        //   240: aload 4
        //   242: astore_3
        //   243: aload_2
        //   244: ifnull -102 -> 142
        //   247: aload_2
        //   248: invokevirtual 247	java/io/BufferedReader:close	()V
        //   251: aload 4
        //   253: astore_3
        //   254: goto -112 -> 142
        //   257: astore_1
        //   258: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   261: ldc -1
        //   263: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   266: aload 4
        //   268: astore_3
        //   269: goto -127 -> 142
        //   272: astore_1
        //   273: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   276: ldc -1
        //   278: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   281: goto -41 -> 240
        //   284: astore_3
        //   285: aload 5
        //   287: astore_2
        //   288: aload 4
        //   290: astore_1
        //   291: aload_1
        //   292: ifnull +7 -> 299
        //   295: aload_1
        //   296: invokevirtual 246	java/io/FileInputStream:close	()V
        //   299: aload_2
        //   300: ifnull +7 -> 307
        //   303: aload_2
        //   304: invokevirtual 247	java/io/BufferedReader:close	()V
        //   307: aload_3
        //   308: athrow
        //   309: astore_1
        //   310: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   313: ldc -1
        //   315: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   318: goto -19 -> 299
        //   321: astore_1
        //   322: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   325: ldc -1
        //   327: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   330: goto -23 -> 307
        //   333: astore_3
        //   334: aload 6
        //   336: astore_2
        //   337: goto -46 -> 291
        //   340: astore_3
        //   341: goto -50 -> 291
        //   344: astore_3
        //   345: goto -54 -> 291
        //   348: astore_2
        //   349: aload_3
        //   350: astore_2
        //   351: goto -137 -> 214
        //   354: astore_3
        //   355: goto -141 -> 214
        //   358: astore_3
        //   359: goto -145 -> 214
        //   362: goto -203 -> 159
        //   365: goto -239 -> 126
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	368	0	this	AppEventRegistrationHandler
        //   8	31	1	localObject1	Object
        //   50	25	1	localFile	java.io.File
        //   78	53	1	localFileInputStream	java.io.FileInputStream
        //   184	1	1	localIOException1	java.io.IOException
        //   196	1	1	localIOException2	java.io.IOException
        //   208	1	1	localIOException3	java.io.IOException
        //   213	24	1	localObject2	Object
        //   257	1	1	localIOException4	java.io.IOException
        //   272	1	1	localIOException5	java.io.IOException
        //   290	6	1	localObject3	Object
        //   309	1	1	localIOException6	java.io.IOException
        //   321	1	1	localIOException7	java.io.IOException
        //   94	243	2	localObject4	Object
        //   348	1	2	localIOException8	java.io.IOException
        //   350	1	2	localObject5	Object
        //   69	200	3	localObject6	Object
        //   284	24	3	localObject7	Object
        //   333	1	3	localObject8	Object
        //   340	1	3	localObject9	Object
        //   344	6	3	localObject10	Object
        //   354	1	3	localIOException9	java.io.IOException
        //   358	1	3	localIOException10	java.io.IOException
        //   57	232	4	localObject11	Object
        //   63	223	5	localObject12	Object
        //   66	269	6	localObject13	Object
        //   60	152	7	localObject14	Object
        //   19	124	8	localObject15	Object
        // Exception table:
        //   from	to	target	type
        //   24	48	50	finally
        //   51	54	50	finally
        //   130	134	50	finally
        //   138	142	50	finally
        //   142	145	50	finally
        //   185	193	50	finally
        //   197	205	50	finally
        //   236	240	50	finally
        //   247	251	50	finally
        //   258	266	50	finally
        //   273	281	50	finally
        //   295	299	50	finally
        //   303	307	50	finally
        //   307	309	50	finally
        //   310	318	50	finally
        //   322	330	50	finally
        //   130	134	184	java/io/IOException
        //   138	142	196	java/io/IOException
        //   70	79	208	java/io/IOException
        //   247	251	257	java/io/IOException
        //   236	240	272	java/io/IOException
        //   70	79	284	finally
        //   220	229	284	finally
        //   295	299	309	java/io/IOException
        //   303	307	321	java/io/IOException
        //   79	95	333	finally
        //   97	103	340	finally
        //   108	115	340	finally
        //   120	124	340	finally
        //   151	159	340	finally
        //   159	181	344	finally
        //   79	95	348	java/io/IOException
        //   97	103	354	java/io/IOException
        //   108	115	354	java/io/IOException
        //   120	124	354	java/io/IOException
        //   151	159	354	java/io/IOException
        //   159	181	358	java/io/IOException
    }

    /* Error */
    public void onAppEventsRegistered() {
        // Byte code:
        //   0: invokestatic 84	com/amazon/device/ads/InternalAdRegistration:getInstance	()Lcom/amazon/device/ads/IInternalAdRegistration;
        //   3: invokeinterface 90 1 0
        //   8: astore_2
        //   9: aload_2
        //   10: ifnonnull +4 -> 14
        //   13: return
        //   14: aload_0
        //   15: getfield 48	com/amazon/device/ads/AppEventRegistrationHandler:appEventsFileLock	Ljava/lang/Object;
        //   18: astore 4
        //   20: aload 4
        //   22: monitorenter
        //   23: aload_0
        //   24: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   27: aload_0
        //   28: getfield 61	com/amazon/device/ads/AppEventRegistrationHandler:eventsSent	Ljava/util/Set;
        //   31: invokeinterface 261 2 0
        //   36: pop
        //   37: aload_0
        //   38: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   41: invokeinterface 264 1 0
        //   46: ifne +233 -> 279
        //   49: new 157	java/lang/StringBuilder
        //   52: dup
        //   53: invokespecial 158	java/lang/StringBuilder:<init>	()V
        //   56: astore 5
        //   58: aload_0
        //   59: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   62: astore_1
        //   63: aload_1
        //   64: monitorenter
        //   65: aload_0
        //   66: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   69: invokeinterface 119 1 0
        //   74: astore_3
        //   75: aload_3
        //   76: invokeinterface 125 1 0
        //   81: ifeq +37 -> 118
        //   84: aload 5
        //   86: aload_3
        //   87: invokeinterface 129 1 0
        //   92: checkcast 136	java/lang/String
        //   95: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   98: ldc -92
        //   100: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: pop
        //   104: goto -29 -> 75
        //   107: astore_2
        //   108: aload_1
        //   109: monitorexit
        //   110: aload_2
        //   111: athrow
        //   112: astore_1
        //   113: aload 4
        //   115: monitorexit
        //   116: aload_1
        //   117: athrow
        //   118: aload_1
        //   119: monitorexit
        //   120: new 167	java/io/File
        //   123: dup
        //   124: aload_2
        //   125: invokevirtual 173	android/content/Context:getFilesDir	()Ljava/io/File;
        //   128: ldc 10
        //   130: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   133: astore 6
        //   135: aconst_null
        //   136: astore_1
        //   137: aconst_null
        //   138: astore_3
        //   139: aconst_null
        //   140: astore_2
        //   141: new 186	java/io/FileOutputStream
        //   144: dup
        //   145: aload 6
        //   147: iconst_0
        //   148: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
        //   151: astore 6
        //   153: new 266	java/io/BufferedWriter
        //   156: dup
        //   157: new 191	java/io/OutputStreamWriter
        //   160: dup
        //   161: aload 6
        //   163: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   166: invokespecial 269	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   169: astore_1
        //   170: aload_1
        //   171: aload 5
        //   173: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   176: invokevirtual 270	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   179: aload_0
        //   180: getfield 59	com/amazon/device/ads/AppEventRegistrationHandler:newEventsToSave	Ljava/util/Set;
        //   183: invokeinterface 273 1 0
        //   188: aload_0
        //   189: getfield 61	com/amazon/device/ads/AppEventRegistrationHandler:eventsSent	Ljava/util/Set;
        //   192: invokeinterface 273 1 0
        //   197: aload_1
        //   198: ifnull +7 -> 205
        //   201: aload_1
        //   202: invokevirtual 274	java/io/BufferedWriter:close	()V
        //   205: aload 4
        //   207: monitorexit
        //   208: return
        //   209: astore_1
        //   210: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   213: ldc -48
        //   215: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   218: goto -13 -> 205
        //   221: astore_1
        //   222: aload_2
        //   223: astore_1
        //   224: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   227: ldc_w 276
        //   230: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   233: aload_2
        //   234: ifnull -29 -> 205
        //   237: aload_2
        //   238: invokevirtual 274	java/io/BufferedWriter:close	()V
        //   241: goto -36 -> 205
        //   244: astore_1
        //   245: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   248: ldc -48
        //   250: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   253: goto -48 -> 205
        //   256: astore_2
        //   257: aload_1
        //   258: ifnull +7 -> 265
        //   261: aload_1
        //   262: invokevirtual 274	java/io/BufferedWriter:close	()V
        //   265: aload_2
        //   266: athrow
        //   267: astore_1
        //   268: getstatic 39	com/amazon/device/ads/AppEventRegistrationHandler:LOG_TAG	Ljava/lang/String;
        //   271: ldc -48
        //   273: invokestatic 211	com/amazon/device/ads/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   276: goto -11 -> 265
        //   279: aload_2
        //   280: ldc 10
        //   282: invokevirtual 280	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   285: pop
        //   286: aload_0
        //   287: getfield 61	com/amazon/device/ads/AppEventRegistrationHandler:eventsSent	Ljava/util/Set;
        //   290: invokeinterface 273 1 0
        //   295: goto -90 -> 205
        //   298: astore_2
        //   299: aload_3
        //   300: astore_1
        //   301: goto -44 -> 257
        //   304: astore_2
        //   305: goto -48 -> 257
        //   308: astore_1
        //   309: goto -87 -> 222
        //   312: astore_2
        //   313: aload_1
        //   314: astore_2
        //   315: goto -93 -> 222
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	318	0	this	AppEventRegistrationHandler
        //   62	47	1	localSet	Set
        //   112	7	1	localObject1	Object
        //   136	66	1	localBufferedWriter	java.io.BufferedWriter
        //   209	1	1	localIOException1	java.io.IOException
        //   221	1	1	localIOException2	java.io.IOException
        //   223	1	1	localObject2	Object
        //   244	18	1	localIOException3	java.io.IOException
        //   267	1	1	localIOException4	java.io.IOException
        //   300	1	1	localObject3	Object
        //   308	6	1	localIOException5	java.io.IOException
        //   8	2	2	localContext	android.content.Context
        //   107	18	2	localObject4	Object
        //   140	98	2	localObject5	Object
        //   256	24	2	localObject6	Object
        //   298	1	2	localObject7	Object
        //   304	1	2	localObject8	Object
        //   312	1	2	localIOException6	java.io.IOException
        //   314	1	2	localObject9	Object
        //   74	226	3	localIterator	java.util.Iterator
        //   18	188	4	localObject10	Object
        //   56	116	5	localStringBuilder	StringBuilder
        //   133	29	6	localObject11	Object
        // Exception table:
        //   from	to	target	type
        //   65	75	107	finally
        //   75	104	107	finally
        //   108	110	107	finally
        //   118	120	107	finally
        //   23	65	112	finally
        //   110	112	112	finally
        //   113	116	112	finally
        //   120	135	112	finally
        //   201	205	112	finally
        //   205	208	112	finally
        //   210	218	112	finally
        //   237	241	112	finally
        //   245	253	112	finally
        //   261	265	112	finally
        //   265	267	112	finally
        //   268	276	112	finally
        //   279	295	112	finally
        //   201	205	209	java/io/IOException
        //   141	153	221	java/io/IOException
        //   237	241	244	java/io/IOException
        //   141	153	256	finally
        //   224	233	256	finally
        //   261	265	267	java/io/IOException
        //   153	170	298	finally
        //   170	197	304	finally
        //   153	170	308	java/io/IOException
        //   170	197	312	java/io/IOException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AppEventRegistrationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */