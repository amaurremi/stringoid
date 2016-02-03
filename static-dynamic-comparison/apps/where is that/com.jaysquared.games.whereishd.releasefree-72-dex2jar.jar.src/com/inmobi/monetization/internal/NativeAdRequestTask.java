package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class NativeAdRequestTask
  implements Runnable
{
  private NativeAdRequest a;
  private INativeAdController b;
  private HttpURLConnection c;
  
  NativeAdRequestTask(NativeAdRequest paramNativeAdRequest, INativeAdController paramINativeAdController)
  {
    this.a = paramNativeAdRequest;
    this.b = paramINativeAdController;
  }
  
  private HttpURLConnection a(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    a(paramString);
    return paramString;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: ldc 46
    //   2: new 48	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   9: ldc 51
    //   11: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   18: invokevirtual 61	java/net/HttpURLConnection:getResponseCode	()I
    //   21: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   34: invokevirtual 61	java/net/HttpURLConnection:getResponseCode	()I
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   42: ldc 76
    //   44: invokevirtual 80	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_3
    //   48: ldc 46
    //   50: new 48	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   57: ldc 82
    //   59: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   76: ldc 84
    //   78: invokevirtual 80	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +27 -> 110
    //   86: ldc 46
    //   88: new 48	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   95: ldc 86
    //   97: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: iload_1
    //   111: sipush 200
    //   114: if_icmpne +432 -> 546
    //   117: new 88	java/io/BufferedReader
    //   120: dup
    //   121: new 90	java/io/InputStreamReader
    //   124: dup
    //   125: aload_0
    //   126: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   129: invokevirtual 94	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   132: ldc 96
    //   134: invokespecial 99	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   137: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   140: astore_3
    //   141: new 48	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   148: astore 4
    //   150: aload_3
    //   151: invokevirtual 105	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   154: astore 5
    //   156: aload 5
    //   158: ifnull +62 -> 220
    //   161: aload 4
    //   163: aload 5
    //   165: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: goto -19 -> 150
    //   172: astore_3
    //   173: aload_0
    //   174: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   177: invokevirtual 108	java/net/HttpURLConnection:disconnect	()V
    //   180: aload_0
    //   181: aconst_null
    //   182: invokespecial 111	com/inmobi/monetization/internal/NativeAdRequestTask:a	(Ljava/io/Closeable;)V
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: ldc 113
    //   190: ldc 115
    //   192: aload_3
    //   193: invokestatic 119	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_0
    //   197: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   200: ifnull +19 -> 219
    //   203: aload_0
    //   204: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   207: aload_0
    //   208: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   211: getstatic 125	com/inmobi/monetization/IMErrorCode:INTERNAL_ERROR	Lcom/inmobi/monetization/IMErrorCode;
    //   214: invokeinterface 131 3 0
    //   219: return
    //   220: new 133	org/json/JSONObject
    //   223: dup
    //   224: aload 4
    //   226: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   232: ldc -120
    //   234: invokevirtual 140	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull +40 -> 279
    //   242: aload_3
    //   243: invokevirtual 145	org/json/JSONArray:length	()I
    //   246: ifne +79 -> 325
    //   249: ldc 46
    //   251: ldc -109
    //   253: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   260: ifnull +19 -> 279
    //   263: aload_0
    //   264: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   267: aload_0
    //   268: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   271: getstatic 150	com/inmobi/monetization/IMErrorCode:NO_FILL	Lcom/inmobi/monetization/IMErrorCode;
    //   274: invokeinterface 131 3 0
    //   279: aload_0
    //   280: getfield 57	com/inmobi/monetization/internal/NativeAdRequestTask:c	Ljava/net/HttpURLConnection;
    //   283: invokevirtual 108	java/net/HttpURLConnection:disconnect	()V
    //   286: aload_0
    //   287: aconst_null
    //   288: invokespecial 111	com/inmobi/monetization/internal/NativeAdRequestTask:a	(Ljava/io/Closeable;)V
    //   291: return
    //   292: astore_3
    //   293: ldc 113
    //   295: ldc -104
    //   297: aload_3
    //   298: invokestatic 119	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_0
    //   302: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   305: ifnull -86 -> 219
    //   308: aload_0
    //   309: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   312: aload_0
    //   313: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   316: getstatic 125	com/inmobi/monetization/IMErrorCode:INTERNAL_ERROR	Lcom/inmobi/monetization/IMErrorCode;
    //   319: invokeinterface 131 3 0
    //   324: return
    //   325: new 154	java/util/ArrayList
    //   328: dup
    //   329: invokespecial 155	java/util/ArrayList:<init>	()V
    //   332: astore 4
    //   334: aload_3
    //   335: invokevirtual 145	org/json/JSONArray:length	()I
    //   338: istore_2
    //   339: invokestatic 161	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	()Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   342: invokevirtual 167	com/inmobi/androidsdk/bootstrapper/ConfigParams:getNativeSdkConfigParams	()Lcom/inmobi/androidsdk/bootstrapper/NativeConfigParams;
    //   345: invokevirtual 172	com/inmobi/androidsdk/bootstrapper/NativeConfigParams:getmFetchLimit	()I
    //   348: istore_1
    //   349: iload_2
    //   350: iload_1
    //   351: if_icmple +268 -> 619
    //   354: iconst_0
    //   355: istore_2
    //   356: iload_2
    //   357: iload_1
    //   358: if_icmpge +122 -> 480
    //   361: aload_3
    //   362: iload_2
    //   363: invokevirtual 176	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   366: astore 5
    //   368: aload 5
    //   370: ldc -78
    //   372: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 6
    //   377: aload 5
    //   379: ldc -73
    //   381: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 7
    //   386: aload 5
    //   388: ldc -71
    //   390: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 8
    //   395: aload 6
    //   397: ifnull +227 -> 624
    //   400: ldc -69
    //   402: aload 6
    //   404: invokevirtual 192	java/lang/String:trim	()Ljava/lang/String;
    //   407: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   410: ifeq +6 -> 416
    //   413: goto +211 -> 624
    //   416: aload 7
    //   418: ifnull +206 -> 624
    //   421: ldc -69
    //   423: aload 7
    //   425: invokevirtual 192	java/lang/String:trim	()Ljava/lang/String;
    //   428: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifne +193 -> 624
    //   434: aload 8
    //   436: ifnull +188 -> 624
    //   439: ldc -69
    //   441: aload 8
    //   443: invokevirtual 192	java/lang/String:trim	()Ljava/lang/String;
    //   446: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifne +175 -> 624
    //   452: aload 4
    //   454: aload 5
    //   456: invokevirtual 197	org/json/JSONObject:toString	()Ljava/lang/String;
    //   459: invokevirtual 200	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   462: pop
    //   463: goto +161 -> 624
    //   466: astore 5
    //   468: ldc 113
    //   470: ldc -54
    //   472: aload 5
    //   474: invokestatic 119	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto +147 -> 624
    //   480: aload_0
    //   481: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   484: ifnull -205 -> 279
    //   487: aload 4
    //   489: invokevirtual 205	java/util/ArrayList:size	()I
    //   492: ifle +28 -> 520
    //   495: aload_0
    //   496: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   499: aload_0
    //   500: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   503: new 207	com/inmobi/monetization/internal/NativeAdResponse
    //   506: dup
    //   507: aload 4
    //   509: invokespecial 210	com/inmobi/monetization/internal/NativeAdResponse:<init>	(Ljava/util/List;)V
    //   512: invokeinterface 214 3 0
    //   517: goto -238 -> 279
    //   520: ldc 46
    //   522: ldc -40
    //   524: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_0
    //   528: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   531: aload_0
    //   532: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   535: getstatic 125	com/inmobi/monetization/IMErrorCode:INTERNAL_ERROR	Lcom/inmobi/monetization/IMErrorCode;
    //   538: invokeinterface 131 3 0
    //   543: goto -264 -> 279
    //   546: iload_1
    //   547: sipush 400
    //   550: if_icmpne +36 -> 586
    //   553: ldc 46
    //   555: ldc -38
    //   557: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: aload_0
    //   561: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   564: ifnull -285 -> 279
    //   567: aload_0
    //   568: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   571: aload_0
    //   572: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   575: getstatic 221	com/inmobi/monetization/IMErrorCode:INVALID_REQUEST	Lcom/inmobi/monetization/IMErrorCode;
    //   578: invokeinterface 131 3 0
    //   583: goto -304 -> 279
    //   586: ldc 46
    //   588: ldc -40
    //   590: invokestatic 74	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload_0
    //   594: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   597: ifnull -318 -> 279
    //   600: aload_0
    //   601: getfield 21	com/inmobi/monetization/internal/NativeAdRequestTask:b	Lcom/inmobi/monetization/internal/abstraction/INativeAdController;
    //   604: aload_0
    //   605: getfield 19	com/inmobi/monetization/internal/NativeAdRequestTask:a	Lcom/inmobi/monetization/internal/NativeAdRequest;
    //   608: getstatic 125	com/inmobi/monetization/IMErrorCode:INTERNAL_ERROR	Lcom/inmobi/monetization/IMErrorCode;
    //   611: invokeinterface 131 3 0
    //   616: goto -337 -> 279
    //   619: iload_2
    //   620: istore_1
    //   621: goto -267 -> 354
    //   624: iload_2
    //   625: iconst_1
    //   626: iadd
    //   627: istore_2
    //   628: goto -272 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	NativeAdRequestTask
    //   37	584	1	i	int
    //   338	290	2	j	int
    //   47	104	3	localObject1	Object
    //   172	14	3	localObject2	Object
    //   187	6	3	localException1	Exception
    //   237	6	3	localJSONArray	org.json.JSONArray
    //   292	70	3	localOutOfMemoryError	OutOfMemoryError
    //   148	360	4	localObject3	Object
    //   154	301	5	localObject4	Object
    //   466	7	5	localException2	Exception
    //   375	28	6	str1	String
    //   384	40	7	str2	String
    //   393	49	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   117	150	172	finally
    //   150	156	172	finally
    //   161	169	172	finally
    //   220	238	172	finally
    //   242	279	172	finally
    //   325	349	172	finally
    //   361	395	172	finally
    //   400	413	172	finally
    //   421	434	172	finally
    //   439	463	172	finally
    //   468	477	172	finally
    //   480	517	172	finally
    //   520	543	172	finally
    //   553	583	172	finally
    //   586	616	172	finally
    //   0	82	187	java/lang/Exception
    //   86	110	187	java/lang/Exception
    //   173	187	187	java/lang/Exception
    //   279	291	187	java/lang/Exception
    //   0	82	292	java/lang/OutOfMemoryError
    //   86	110	292	java/lang/OutOfMemoryError
    //   173	187	292	java/lang/OutOfMemoryError
    //   279	291	292	java/lang/OutOfMemoryError
    //   361	395	466	java/lang/Exception
    //   400	413	466	java/lang/Exception
    //   421	434	466	java/lang/Exception
    //   439	463	466	java/lang/Exception
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Exception closing resource: " + paramCloseable, localIOException);
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    int i = Initializer.getConfigParams().getFetchTimeOut();
    paramHttpURLConnection.setConnectTimeout(i);
    paramHttpURLConnection.setReadTimeout(i);
    paramHttpURLConnection.setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
    paramHttpURLConnection.setUseCaches(false);
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.setDoInput(true);
    paramHttpURLConnection.setRequestMethod("POST");
    paramHttpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
  }
  
  private void b(String paramString)
    throws IOException
  {
    this.c.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.getOutputStream()));
      a(localBufferedWriter);
    }
    finally
    {
      try
      {
        localBufferedWriter.write(paramString);
        a(localBufferedWriter);
        return;
      }
      finally {}
      paramString = finally;
      localBufferedWriter = null;
    }
    throw paramString;
  }
  
  public void run()
  {
    try
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Ad Serving URL: http://i.w.inmobi.com/showad.asm");
      String str = this.a.buildPostBody();
      Log.debug("[InMobi]-[Network]-4.1.1", "Post body:" + str);
      this.c = a("http://i.w.inmobi.com/showad.asm");
      b(this.a.buildPostBody());
      a();
      return;
    }
    catch (Exception localException)
    {
      if (this.b != null) {
        this.b.onAdRequestFailed(this.a, IMErrorCode.NETWORK_ERROR);
      }
      Log.debug("[InMobi]-[Monetization]", "Failed to get native ads", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/NativeAdRequestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */