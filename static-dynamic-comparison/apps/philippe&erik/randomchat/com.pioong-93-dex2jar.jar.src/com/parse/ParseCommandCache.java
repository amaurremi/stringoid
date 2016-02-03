package com.parse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

class ParseCommandCache
{
  private static final String TAG = "com.parse.ParseCommandCache";
  private static int filenameCounter = 0;
  private static Object lock = new Object();
  private File cachePath;
  private boolean connected = false;
  private ConnectivityNotifier.ConnectivityListener connectivityListener = new ConnectivityNotifier.ConnectivityListener()
  {
    public void networkConnectivityStatusChanged(Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getBooleanExtra("noConnectivity", false))
      {
        ParseCommandCache.this.setConnected(false);
        return;
      }
      ParseCommandCache.this.setConnected(ConnectivityNotifier.getNotifier().isConnected());
    }
  };
  private Logger log;
  private int maxCacheSizeBytes = 10485760;
  private HashMap<File, Task<Object>.TaskCompletionSource> pendingTasks = new HashMap();
  private boolean running = false;
  private Object runningLock;
  private boolean shouldStop = false;
  private TestHelper testHelper = null;
  private int timeoutMaxRetries = 5;
  private double timeoutRetryWaitSeconds = 600.0D;
  
  public ParseCommandCache(Context paramContext)
  {
    lock = new Object();
    this.runningLock = new Object();
    this.log = Logger.getLogger("com.parse.ParseCommandCache");
    this.cachePath = new File(Parse.getParseDir(), "CommandCache");
    this.cachePath.mkdirs();
    if (!Parse.hasPermission("android.permission.ACCESS_NETWORK_STATE")) {
      return;
    }
    setConnected(ConnectivityNotifier.getNotifier().isConnected());
    ConnectivityNotifier.getNotifier().addListener(this.connectivityListener, paramContext);
    resume();
  }
  
  /* Error */
  private void maybeRunAllCommandsNow(int paramInt)
  {
    // Byte code:
    //   0: getstatic 52	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   3: astore 16
    //   5: aload 16
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 77	com/parse/ParseCommandCache:connected	Z
    //   12: ifne +7 -> 19
    //   15: aload 16
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 106	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   23: invokevirtual 158	java/io/File:list	()[Ljava/lang/String;
    //   26: astore 17
    //   28: aload 17
    //   30: ifnull +9 -> 39
    //   33: aload 17
    //   35: arraylength
    //   36: ifne +15 -> 51
    //   39: aload 16
    //   41: monitorexit
    //   42: return
    //   43: astore 11
    //   45: aload 16
    //   47: monitorexit
    //   48: aload 11
    //   50: athrow
    //   51: aload 17
    //   53: invokestatic 164	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   56: aload 17
    //   58: arraylength
    //   59: istore_3
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iload_3
    //   64: if_icmplt +7 -> 71
    //   67: aload 16
    //   69: monitorexit
    //   70: return
    //   71: aload 17
    //   73: iload_2
    //   74: aaload
    //   75: astore 11
    //   77: new 93	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: getfield 106	com/parse/ParseCommandCache:cachePath	Ljava/io/File;
    //   85: aload 11
    //   87: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 18
    //   92: aconst_null
    //   93: astore 13
    //   95: aconst_null
    //   96: astore 15
    //   98: aconst_null
    //   99: astore 11
    //   101: aconst_null
    //   102: astore 14
    //   104: new 166	java/io/BufferedInputStream
    //   107: dup
    //   108: new 168	java/io/FileInputStream
    //   111: dup
    //   112: aload 18
    //   114: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore 12
    //   122: new 176	java/io/ByteArrayOutputStream
    //   125: dup
    //   126: invokespecial 177	java/io/ByteArrayOutputStream:<init>	()V
    //   129: astore 11
    //   131: sipush 1024
    //   134: newarray <illegal type>
    //   136: astore 13
    //   138: aload 12
    //   140: aload 13
    //   142: invokevirtual 183	java/io/InputStream:read	([B)I
    //   145: istore 4
    //   147: iload 4
    //   149: ifgt +141 -> 290
    //   152: new 185	org/json/JSONObject
    //   155: dup
    //   156: aload 11
    //   158: ldc -69
    //   160: invokevirtual 191	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokespecial 194	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   166: astore 13
    //   168: aload 12
    //   170: ifnull +8 -> 178
    //   173: aload 12
    //   175: invokevirtual 197	java/io/InputStream:close	()V
    //   178: aload_0
    //   179: getfield 68	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   182: aload 18
    //   184: invokevirtual 201	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   187: ifeq +642 -> 829
    //   190: aload_0
    //   191: getfield 68	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   194: aload 18
    //   196: invokevirtual 205	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 207	com/parse/Task$TaskCompletionSource
    //   202: astore 11
    //   204: new 209	com/parse/ParseCommand
    //   207: dup
    //   208: aload 13
    //   210: invokespecial 212	com/parse/ParseCommand:<init>	(Lorg/json/JSONObject;)V
    //   213: astore 12
    //   215: aload 12
    //   217: invokevirtual 216	com/parse/ParseCommand:getLocalId	()Ljava/lang/String;
    //   220: astore 13
    //   222: aload_0
    //   223: aload 12
    //   225: invokevirtual 220	com/parse/ParseCommand:performAsync	()Lcom/parse/Task;
    //   228: new 12	com/parse/ParseCommandCache$4
    //   231: dup
    //   232: aload_0
    //   233: aload 11
    //   235: aload 13
    //   237: invokespecial 223	com/parse/ParseCommandCache$4:<init>	(Lcom/parse/ParseCommandCache;Lcom/parse/Task$TaskCompletionSource;Ljava/lang/String;)V
    //   240: invokevirtual 229	com/parse/Task:onSuccess	(Lcom/parse/Continuation;)Lcom/parse/Task;
    //   243: invokespecial 233	com/parse/ParseCommandCache:waitForTaskWithoutLock	(Lcom/parse/Task;)Ljava/lang/Object;
    //   246: pop
    //   247: aload 11
    //   249: ifnull +13 -> 262
    //   252: aload_0
    //   253: aload 11
    //   255: invokevirtual 236	com/parse/Task$TaskCompletionSource:getTask	()Lcom/parse/Task;
    //   258: invokespecial 233	com/parse/ParseCommandCache:waitForTaskWithoutLock	(Lcom/parse/Task;)Ljava/lang/Object;
    //   261: pop
    //   262: aload_0
    //   263: aload 18
    //   265: invokespecial 239	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   268: aload_0
    //   269: getfield 70	com/parse/ParseCommandCache:testHelper	Lcom/parse/ParseCommandCache$TestHelper;
    //   272: ifnull +512 -> 784
    //   275: aload_0
    //   276: getfield 70	com/parse/ParseCommandCache:testHelper	Lcom/parse/ParseCommandCache$TestHelper;
    //   279: iconst_1
    //   280: invokevirtual 242	com/parse/ParseCommandCache$TestHelper:notify	(I)V
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: goto -225 -> 62
    //   290: aload 11
    //   292: aload 13
    //   294: iconst_0
    //   295: iload 4
    //   297: invokevirtual 246	java/io/ByteArrayOutputStream:write	([BII)V
    //   300: goto -162 -> 138
    //   303: astore 13
    //   305: aload 12
    //   307: astore 11
    //   309: bipush 6
    //   311: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   314: if_icmplt +22 -> 336
    //   317: aload 12
    //   319: astore 11
    //   321: aload_0
    //   322: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   325: getstatic 256	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   328: ldc_w 258
    //   331: aload 13
    //   333: invokevirtual 261	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload 12
    //   338: ifnull -55 -> 283
    //   341: aload 12
    //   343: invokevirtual 197	java/io/InputStream:close	()V
    //   346: goto -63 -> 283
    //   349: astore 11
    //   351: goto -68 -> 283
    //   354: astore 11
    //   356: aload 13
    //   358: astore 12
    //   360: aload 11
    //   362: astore 13
    //   364: aload 12
    //   366: astore 11
    //   368: bipush 6
    //   370: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   373: if_icmplt +22 -> 395
    //   376: aload 12
    //   378: astore 11
    //   380: aload_0
    //   381: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   384: getstatic 256	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   387: ldc_w 263
    //   390: aload 13
    //   392: invokevirtual 261	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 12
    //   397: astore 11
    //   399: aload_0
    //   400: aload 18
    //   402: invokespecial 239	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   405: aload 12
    //   407: ifnull -124 -> 283
    //   410: aload 12
    //   412: invokevirtual 197	java/io/InputStream:close	()V
    //   415: goto -132 -> 283
    //   418: astore 11
    //   420: goto -137 -> 283
    //   423: astore 13
    //   425: aload 15
    //   427: astore 12
    //   429: aload 12
    //   431: astore 11
    //   433: bipush 6
    //   435: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   438: if_icmplt +22 -> 460
    //   441: aload 12
    //   443: astore 11
    //   445: aload_0
    //   446: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   449: getstatic 256	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   452: ldc_w 265
    //   455: aload 13
    //   457: invokevirtual 261	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   460: aload 12
    //   462: astore 11
    //   464: aload_0
    //   465: aload 18
    //   467: invokespecial 239	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   470: aload 12
    //   472: ifnull -189 -> 283
    //   475: aload 12
    //   477: invokevirtual 197	java/io/InputStream:close	()V
    //   480: goto -197 -> 283
    //   483: astore 11
    //   485: goto -202 -> 283
    //   488: astore 12
    //   490: aload 11
    //   492: ifnull +8 -> 500
    //   495: aload 11
    //   497: invokevirtual 197	java/io/InputStream:close	()V
    //   500: aload 12
    //   502: athrow
    //   503: astore 11
    //   505: bipush 6
    //   507: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   510: if_icmplt +18 -> 528
    //   513: aload_0
    //   514: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   517: getstatic 256	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   520: ldc_w 267
    //   523: aload 11
    //   525: invokevirtual 261	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   528: aload_0
    //   529: aload 18
    //   531: invokespecial 239	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   534: goto -251 -> 283
    //   537: astore 11
    //   539: aload 11
    //   541: invokevirtual 270	com/parse/ParseException:getCode	()I
    //   544: bipush 100
    //   546: if_icmpne +194 -> 740
    //   549: iload_1
    //   550: ifle +234 -> 784
    //   553: iconst_4
    //   554: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   557: if_icmplt +46 -> 603
    //   560: aload_0
    //   561: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   564: new 272	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 274
    //   571: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: getfield 60	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   578: invokevirtual 279	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   581: ldc_w 281
    //   584: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: iload_1
    //   588: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc_w 289
    //   594: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokevirtual 294	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   603: invokestatic 300	java/lang/System:currentTimeMillis	()J
    //   606: lstore 5
    //   608: lload 5
    //   610: aload_0
    //   611: getfield 60	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   614: ldc2_w 301
    //   617: dmul
    //   618: d2l
    //   619: ladd
    //   620: lstore 9
    //   622: lload 5
    //   624: lload 9
    //   626: lcmp
    //   627: iflt +13 -> 640
    //   630: aload_0
    //   631: iload_1
    //   632: iconst_1
    //   633: isub
    //   634: invokespecial 304	com/parse/ParseCommandCache:maybeRunAllCommandsNow	(I)V
    //   637: goto -354 -> 283
    //   640: aload_0
    //   641: getfield 77	com/parse/ParseCommandCache:connected	Z
    //   644: ifeq +10 -> 654
    //   647: aload_0
    //   648: getfield 79	com/parse/ParseCommandCache:shouldStop	Z
    //   651: ifeq +24 -> 675
    //   654: iconst_4
    //   655: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   658: if_icmplt +13 -> 671
    //   661: aload_0
    //   662: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   665: ldc_w 306
    //   668: invokevirtual 294	java/util/logging/Logger:info	(Ljava/lang/String;)V
    //   671: aload 16
    //   673: monitorexit
    //   674: return
    //   675: getstatic 52	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   678: lload 9
    //   680: lload 5
    //   682: lsub
    //   683: invokevirtual 310	java/lang/Object:wait	(J)V
    //   686: invokestatic 300	java/lang/System:currentTimeMillis	()J
    //   689: lstore 7
    //   691: lload 7
    //   693: lstore 5
    //   695: lload 7
    //   697: lload 9
    //   699: aload_0
    //   700: getfield 60	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   703: ldc2_w 301
    //   706: dmul
    //   707: d2l
    //   708: lsub
    //   709: lcmp
    //   710: ifge -88 -> 622
    //   713: lload 9
    //   715: aload_0
    //   716: getfield 60	com/parse/ParseCommandCache:timeoutRetryWaitSeconds	D
    //   719: ldc2_w 301
    //   722: dmul
    //   723: d2l
    //   724: lsub
    //   725: lstore 5
    //   727: goto -105 -> 622
    //   730: astore 11
    //   732: aload_0
    //   733: iconst_1
    //   734: putfield 79	com/parse/ParseCommandCache:shouldStop	Z
    //   737: goto -51 -> 686
    //   740: bipush 6
    //   742: invokestatic 250	com/parse/Parse:getLogLevel	()I
    //   745: if_icmplt +18 -> 763
    //   748: aload_0
    //   749: getfield 91	com/parse/ParseCommandCache:log	Ljava/util/logging/Logger;
    //   752: getstatic 256	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   755: ldc_w 312
    //   758: aload 11
    //   760: invokevirtual 261	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   763: aload_0
    //   764: aload 18
    //   766: invokespecial 239	com/parse/ParseCommandCache:removeFile	(Ljava/io/File;)V
    //   769: aload_0
    //   770: getfield 70	com/parse/ParseCommandCache:testHelper	Lcom/parse/ParseCommandCache$TestHelper;
    //   773: ifnull +11 -> 784
    //   776: aload_0
    //   777: getfield 70	com/parse/ParseCommandCache:testHelper	Lcom/parse/ParseCommandCache$TestHelper;
    //   780: iconst_2
    //   781: invokevirtual 242	com/parse/ParseCommandCache$TestHelper:notify	(I)V
    //   784: goto -501 -> 283
    //   787: astore 11
    //   789: goto -289 -> 500
    //   792: astore 11
    //   794: goto -616 -> 178
    //   797: astore 13
    //   799: aload 12
    //   801: astore 11
    //   803: aload 13
    //   805: astore 12
    //   807: goto -317 -> 490
    //   810: astore 13
    //   812: goto -383 -> 429
    //   815: astore 13
    //   817: goto -453 -> 364
    //   820: astore 13
    //   822: aload 14
    //   824: astore 12
    //   826: goto -521 -> 305
    //   829: aconst_null
    //   830: astore 11
    //   832: goto -628 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	this	ParseCommandCache
    //   0	835	1	paramInt	int
    //   61	226	2	i	int
    //   59	6	3	j	int
    //   145	151	4	k	int
    //   606	120	5	l1	long
    //   689	7	7	l2	long
    //   620	94	9	l3	long
    //   43	6	11	localObject1	Object
    //   75	245	11	localObject2	Object
    //   349	1	11	localIOException1	IOException
    //   354	7	11	localIOException2	IOException
    //   366	32	11	localObject3	Object
    //   418	1	11	localIOException3	IOException
    //   431	32	11	localObject4	Object
    //   483	13	11	localIOException4	IOException
    //   503	21	11	localJSONException1	org.json.JSONException
    //   537	3	11	localParseException	ParseException
    //   730	29	11	localInterruptedException	InterruptedException
    //   787	1	11	localIOException5	IOException
    //   792	1	11	localIOException6	IOException
    //   801	30	11	localObject5	Object
    //   120	356	12	localObject6	Object
    //   488	312	12	localObject7	Object
    //   805	20	12	localObject8	Object
    //   93	200	13	localObject9	Object
    //   303	54	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   362	29	13	localIOException7	IOException
    //   423	33	13	localJSONException2	org.json.JSONException
    //   797	7	13	localObject10	Object
    //   810	1	13	localJSONException3	org.json.JSONException
    //   815	1	13	localIOException8	IOException
    //   820	1	13	localFileNotFoundException2	java.io.FileNotFoundException
    //   102	721	14	localObject11	Object
    //   96	330	15	localObject12	Object
    //   3	669	16	localObject13	Object
    //   26	46	17	arrayOfString	String[]
    //   90	675	18	localFile	File
    // Exception table:
    //   from	to	target	type
    //   8	18	43	finally
    //   19	28	43	finally
    //   33	39	43	finally
    //   39	42	43	finally
    //   45	48	43	finally
    //   51	60	43	finally
    //   67	70	43	finally
    //   77	92	43	finally
    //   173	178	43	finally
    //   178	204	43	finally
    //   204	215	43	finally
    //   215	247	43	finally
    //   252	262	43	finally
    //   262	283	43	finally
    //   341	346	43	finally
    //   410	415	43	finally
    //   475	480	43	finally
    //   495	500	43	finally
    //   500	503	43	finally
    //   505	528	43	finally
    //   528	534	43	finally
    //   539	549	43	finally
    //   553	603	43	finally
    //   603	622	43	finally
    //   630	637	43	finally
    //   640	654	43	finally
    //   654	671	43	finally
    //   671	674	43	finally
    //   675	686	43	finally
    //   686	691	43	finally
    //   695	727	43	finally
    //   732	737	43	finally
    //   740	763	43	finally
    //   763	784	43	finally
    //   122	138	303	java/io/FileNotFoundException
    //   138	147	303	java/io/FileNotFoundException
    //   152	168	303	java/io/FileNotFoundException
    //   290	300	303	java/io/FileNotFoundException
    //   341	346	349	java/io/IOException
    //   104	122	354	java/io/IOException
    //   410	415	418	java/io/IOException
    //   104	122	423	org/json/JSONException
    //   475	480	483	java/io/IOException
    //   104	122	488	finally
    //   309	317	488	finally
    //   321	336	488	finally
    //   368	376	488	finally
    //   380	395	488	finally
    //   399	405	488	finally
    //   433	441	488	finally
    //   445	460	488	finally
    //   464	470	488	finally
    //   204	215	503	org/json/JSONException
    //   215	247	537	com/parse/ParseException
    //   252	262	537	com/parse/ParseException
    //   262	283	537	com/parse/ParseException
    //   675	686	730	java/lang/InterruptedException
    //   495	500	787	java/io/IOException
    //   173	178	792	java/io/IOException
    //   122	138	797	finally
    //   138	147	797	finally
    //   152	168	797	finally
    //   290	300	797	finally
    //   122	138	810	org/json/JSONException
    //   138	147	810	org/json/JSONException
    //   152	168	810	org/json/JSONException
    //   290	300	810	org/json/JSONException
    //   122	138	815	java/io/IOException
    //   138	147	815	java/io/IOException
    //   152	168	815	java/io/IOException
    //   290	300	815	java/io/IOException
    //   104	122	820	java/io/FileNotFoundException
  }
  
  /* Error */
  private void removeFile(File paramFile)
  {
    // Byte code:
    //   0: getstatic 52	com/parse/ParseCommandCache:lock	Ljava/lang/Object;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 68	com/parse/ParseCommandCache:pendingTasks	Ljava/util/HashMap;
    //   12: aload_1
    //   13: invokevirtual 317	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: new 166	java/io/BufferedInputStream
    //   26: dup
    //   27: new 168	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_3
    //   39: new 176	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 177	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: sipush 1024
    //   51: newarray <illegal type>
    //   53: astore 5
    //   55: aload_3
    //   56: aload 5
    //   58: invokevirtual 183	java/io/InputStream:read	([B)I
    //   61: istore_2
    //   62: iload_2
    //   63: ifgt +48 -> 111
    //   66: new 185	org/json/JSONObject
    //   69: dup
    //   70: aload 4
    //   72: ldc -69
    //   74: invokevirtual 191	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokespecial 194	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: new 209	com/parse/ParseCommand
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 212	com/parse/ParseCommand:<init>	(Lorg/json/JSONObject;)V
    //   91: invokevirtual 320	com/parse/ParseCommand:releaseLocalIds	()V
    //   94: aload_3
    //   95: ifnull +105 -> 200
    //   98: aload_3
    //   99: invokevirtual 197	java/io/InputStream:close	()V
    //   102: aload_1
    //   103: invokevirtual 323	java/io/File:delete	()Z
    //   106: pop
    //   107: aload 6
    //   109: monitorexit
    //   110: return
    //   111: aload 4
    //   113: aload 5
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 246	java/io/ByteArrayOutputStream:write	([BII)V
    //   120: goto -65 -> 55
    //   123: astore 4
    //   125: aload_3
    //   126: ifnull -24 -> 102
    //   129: aload_3
    //   130: invokevirtual 197	java/io/InputStream:close	()V
    //   133: goto -31 -> 102
    //   136: astore_3
    //   137: goto -35 -> 102
    //   140: astore_3
    //   141: aload 4
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 197	java/io/InputStream:close	()V
    //   152: aload_3
    //   153: athrow
    //   154: astore_1
    //   155: aload 6
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    //   160: astore_3
    //   161: goto -59 -> 102
    //   164: astore_1
    //   165: goto -13 -> 152
    //   168: astore 4
    //   170: aload_3
    //   171: astore_1
    //   172: aload 4
    //   174: astore_3
    //   175: goto -31 -> 144
    //   178: astore 4
    //   180: aload_3
    //   181: astore_1
    //   182: aload 4
    //   184: astore_3
    //   185: goto -41 -> 144
    //   188: astore_3
    //   189: aload 5
    //   191: astore_3
    //   192: goto -67 -> 125
    //   195: astore 4
    //   197: goto -72 -> 125
    //   200: goto -98 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	ParseCommandCache
    //   0	203	1	paramFile	File
    //   61	56	2	i	int
    //   38	92	3	localBufferedInputStream	java.io.BufferedInputStream
    //   136	1	3	localIOException1	IOException
    //   140	13	3	localObject1	Object
    //   160	11	3	localIOException2	IOException
    //   174	11	3	localObject2	Object
    //   188	1	3	localException1	Exception
    //   191	1	3	arrayOfByte1	byte[]
    //   18	94	4	localObject3	Object
    //   123	19	4	localException2	Exception
    //   168	5	4	localObject4	Object
    //   178	5	4	localObject5	Object
    //   195	1	4	localException3	Exception
    //   21	169	5	arrayOfByte2	byte[]
    //   3	153	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   39	55	123	java/lang/Exception
    //   55	62	123	java/lang/Exception
    //   66	82	123	java/lang/Exception
    //   111	120	123	java/lang/Exception
    //   129	133	136	java/io/IOException
    //   23	39	140	finally
    //   8	17	154	finally
    //   98	102	154	finally
    //   102	110	154	finally
    //   129	133	154	finally
    //   148	152	154	finally
    //   152	154	154	finally
    //   155	158	154	finally
    //   98	102	160	java/io/IOException
    //   148	152	164	java/io/IOException
    //   39	55	168	finally
    //   55	62	168	finally
    //   66	82	168	finally
    //   111	120	168	finally
    //   82	94	178	finally
    //   23	39	188	java/lang/Exception
    //   82	94	195	java/lang/Exception
  }
  
  private Task<Object> runEventuallyInternalAsync(ParseCommand paramParseCommand, boolean paramBoolean, ParseObject paramParseObject)
  {
    Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    if (paramParseObject != null) {}
    byte[] arrayOfByte;
    try
    {
      if (paramParseObject.getObjectId() == null) {
        paramParseCommand.setLocalId(paramParseObject.getOrCreateLocalId());
      }
      arrayOfByte = paramParseCommand.toJSONObject().toString().getBytes("UTF-8");
      if (arrayOfByte.length > this.maxCacheSizeBytes)
      {
        if (5 >= Parse.getLogLevel()) {
          this.log.warning("Unable to save command for later because it's too big.");
        }
        if (this.testHelper != null) {
          this.testHelper.notify(4);
        }
        return Task.forResult(null);
      }
    }
    catch (UnsupportedEncodingException paramParseCommand)
    {
      if (5 >= Parse.getLogLevel()) {
        this.log.log(Level.WARNING, "UTF-8 isn't supported.  This shouldn't happen.", paramParseCommand);
      }
      if (this.testHelper != null) {
        this.testHelper.notify(4);
      }
      return Task.forResult(null);
    }
    Object localObject2 = lock;
    for (;;)
    {
      try
      {
        paramParseObject = this.cachePath.list();
        if (paramParseObject != null)
        {
          Arrays.sort(paramParseObject);
          j = 0;
          int k = paramParseObject.length;
          i = 0;
          if (i >= k)
          {
            j += arrayOfByte.length;
            if (j <= this.maxCacheSizeBytes) {
              continue;
            }
            if (!paramBoolean) {
              continue;
            }
            if (5 >= Parse.getLogLevel()) {
              this.log.warning("Unable to save command for later because storage is full.");
            }
            paramParseCommand = Task.forResult(null);
            try
            {
              return paramParseCommand;
            }
            finally {}
          }
          localObject1 = paramParseObject[i];
          j += (int)new File(this.cachePath, (String)localObject1).length();
          i += 1;
          continue;
          if (5 < Parse.getLogLevel()) {
            break label646;
          }
          this.log.warning("Deleting old commands to make room in command cache.");
          break label646;
          if ((j > this.maxCacheSizeBytes) && (i < paramParseObject.length)) {
            continue;
          }
        }
        localObject1 = Long.toHexString(System.currentTimeMillis());
        paramParseObject = (ParseObject)localObject1;
        if (((String)localObject1).length() < 16)
        {
          paramParseObject = new char[16 - ((String)localObject1).length()];
          Arrays.fill(paramParseObject, '0');
          paramParseObject = new String(paramParseObject) + (String)localObject1;
        }
        i = filenameCounter;
        filenameCounter = i + 1;
        String str = Integer.toHexString(i);
        localObject1 = str;
        if (str.length() < 8)
        {
          localObject1 = new char[8 - str.length()];
          Arrays.fill((char[])localObject1, '0');
          localObject1 = new String((char[])localObject1) + str;
        }
        paramParseObject = File.createTempFile("CachedCommand_" + paramParseObject + "_" + (String)localObject1 + "_", "", this.cachePath);
        this.pendingTasks.put(paramParseObject, localTaskCompletionSource);
        paramParseCommand.retainLocalIds();
        paramParseCommand = new BufferedOutputStream(new FileOutputStream(paramParseObject));
        paramParseCommand.write(arrayOfByte);
        paramParseCommand.close();
        if (this.testHelper != null) {
          this.testHelper.notify(3);
        }
      }
      catch (IOException paramParseCommand)
      {
        int j;
        Object localObject1;
        if (5 < Parse.getLogLevel()) {
          continue;
        }
        this.log.log(Level.WARNING, "Unable to save command for later.", paramParseCommand);
        lock.notify();
        continue;
      }
      finally
      {
        lock.notify();
      }
      return localTaskCompletionSource.getTask();
      localObject1 = new File(this.cachePath, paramParseObject[i]);
      j -= (int)((File)localObject1).length();
      removeFile((File)localObject1);
      i += 1;
      continue;
      label646:
      int i = 0;
    }
  }
  
  private void runLoop()
  {
    if (4 >= Parse.getLogLevel()) {
      this.log.info("Parse command cache has started processing queued commands.");
    }
    int i;
    for (;;)
    {
      synchronized (this.runningLock)
      {
        if (this.running) {
          return;
        }
        this.running = true;
        this.runningLock.notifyAll();
        synchronized (lock)
        {
          if (this.shouldStop) {
            break label259;
          }
          if (Thread.interrupted())
          {
            break label259;
            if (i != 0) {
              break label134;
            }
          }
        }
      }
      label134:
      label163:
      label219:
      synchronized (this.runningLock)
      {
        this.running = false;
        this.runningLock.notifyAll();
        if (4 >= Parse.getLogLevel())
        {
          this.log.info("saveEventually thread has stopped processing commands.");
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
          i = 1;
          continue;
          localObject3 = finally;
          throw ((Throwable)localObject3);
          ??? = lock;
          try
          {
            maybeRunAllCommandsNow(this.timeoutMaxRetries);
            boolean bool = this.shouldStop;
            if (bool) {}
          }
          catch (Exception localException)
          {
            if (6 < Parse.getLogLevel()) {
              break label219;
            }
            this.log.log(Level.SEVERE, "saveEventually thread had an error.", localException);
            if (!this.shouldStop) {
              break;
            }
            i = 0;
          }
          finally
          {
            for (;;)
            {
              if (this.shouldStop) {}
              for (;;)
              {
                throw ((Throwable)localObject5);
              }
              i = 1;
            }
          }
          try
          {
            lock.wait();
            try
            {
              if (this.shouldStop)
              {
                i = 0;
                continue;
              }
            }
            finally {}
          }
          catch (InterruptedException localInterruptedException)
          {
            this.shouldStop = true;
            break label163;
          }
        }
      }
      return;
      label259:
      i = 0;
    }
    for (;;)
    {
      break;
      i = 1;
    }
  }
  
  private <T> T waitForTaskWithoutLock(Task<T> paramTask)
    throws ParseException
  {
    synchronized (lock)
    {
      final Capture localCapture = new Capture(Boolean.valueOf(false));
      paramTask.continueWith(new Continuation()
      {
        public Void then(Task<T> arg1)
          throws Exception
        {
          localCapture.set(Boolean.valueOf(true));
          synchronized (ParseCommandCache.lock)
          {
            ParseCommandCache.lock.notifyAll();
            return null;
          }
        }
      }, ParseCommand.networkThreadPool);
      for (;;)
      {
        if (((Boolean)localCapture.get()).booleanValue())
        {
          paramTask = Parse.waitForTask(paramTask);
          return paramTask;
        }
        try
        {
          lock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          this.shouldStop = true;
        }
      }
    }
  }
  
  public void clear()
  {
    for (;;)
    {
      int i;
      synchronized (lock)
      {
        File[] arrayOfFile = this.cachePath.listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = arrayOfFile.length;
        i = 0;
        if (i >= j)
        {
          this.pendingTasks.clear();
          return;
        }
      }
      removeFile(localObject2[i]);
      i += 1;
    }
  }
  
  public TestHelper getTestHelper()
  {
    if (this.testHelper == null) {
      this.testHelper = new TestHelper(null);
    }
    return this.testHelper;
  }
  
  public void pause()
  {
    for (;;)
    {
      synchronized (this.runningLock)
      {
        if (this.running) {}
        synchronized (lock)
        {
          this.shouldStop = true;
          lock.notify();
          if (!this.running) {
            return;
          }
        }
      }
      try
      {
        this.runningLock.wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public int pendingCount()
  {
    synchronized (lock)
    {
      String[] arrayOfString = this.cachePath.list();
      if (arrayOfString == null)
      {
        i = 0;
        return i;
      }
      int i = arrayOfString.length;
    }
  }
  
  public void resume()
  {
    synchronized (this.runningLock)
    {
      if (!this.running) {
        new Thread("ParseCommandCache.runLoop()")
        {
          public void run()
          {
            ParseCommandCache.this.runLoop();
          }
        }.start();
      }
      try
      {
        this.runningLock.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (lock)
        {
          this.shouldStop = true;
          lock.notify();
        }
      }
    }
  }
  
  public Task<Object> runEventuallyAsync(ParseCommand paramParseCommand, ParseObject paramParseObject)
  {
    Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
    return runEventuallyInternalAsync(paramParseCommand, false, paramParseObject);
  }
  
  public void setConnected(boolean paramBoolean)
  {
    synchronized (lock)
    {
      if (this.connected != paramBoolean)
      {
        this.connected = paramBoolean;
        if (paramBoolean) {
          lock.notify();
        }
      }
      return;
    }
  }
  
  public void setMaxCacheSizeBytes(int paramInt)
  {
    synchronized (lock)
    {
      this.maxCacheSizeBytes = paramInt;
      return;
    }
  }
  
  public void setTimeoutMaxRetries(int paramInt)
  {
    synchronized (lock)
    {
      this.timeoutMaxRetries = paramInt;
      return;
    }
  }
  
  public void setTimeoutRetryWaitSeconds(double paramDouble)
  {
    synchronized (lock)
    {
      this.timeoutRetryWaitSeconds = paramDouble;
      return;
    }
  }
  
  void simulateReboot()
  {
    synchronized (lock)
    {
      this.pendingTasks.clear();
      return;
    }
  }
  
  public class TestHelper
  {
    public static final int COMMAND_ENQUEUED = 3;
    public static final int COMMAND_FAILED = 2;
    public static final int COMMAND_NOT_ENQUEUED = 4;
    public static final int COMMAND_SUCCESSFUL = 1;
    private static final int MAX_EVENTS = 1000;
    public static final int OBJECT_REMOVED = 6;
    public static final int OBJECT_UPDATED = 5;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Semaphore> events = new HashMap();
    
    private TestHelper()
    {
      clear();
    }
    
    public void clear()
    {
      this.events.clear();
      this.events.put(Integer.valueOf(1), new Semaphore(1000));
      this.events.put(Integer.valueOf(2), new Semaphore(1000));
      this.events.put(Integer.valueOf(3), new Semaphore(1000));
      this.events.put(Integer.valueOf(4), new Semaphore(1000));
      this.events.put(Integer.valueOf(5), new Semaphore(1000));
      this.events.put(Integer.valueOf(6), new Semaphore(1000));
      Iterator localIterator = this.events.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        int i = ((Integer)localIterator.next()).intValue();
        ((Semaphore)this.events.get(Integer.valueOf(i))).acquireUninterruptibly(1000);
      }
    }
    
    public void notify(int paramInt)
    {
      ((Semaphore)this.events.get(Integer.valueOf(paramInt))).release();
    }
    
    public int unexpectedEvents()
    {
      int i = 0;
      Iterator localIterator = this.events.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        int j = ((Integer)localIterator.next()).intValue();
        i += ((Semaphore)this.events.get(Integer.valueOf(j))).availablePermits();
      }
    }
    
    public boolean waitFor(int paramInt)
    {
      try
      {
        boolean bool = ((Semaphore)this.events.get(Integer.valueOf(paramInt))).tryAcquire(5000L, TimeUnit.MILLISECONDS);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseCommandCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */