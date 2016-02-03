package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import android.os.Handler;
import com.inmobi.androidsdk.AdRequest.ErrorCode;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIClickEventList;
import com.inmobi.androidsdk.impl.imai.db.ClickData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RequestResponseManager
{
  static Thread a;
  static Handler b = new Handler();
  static AtomicBoolean c = null;
  private static AtomicBoolean f;
  private static AtomicBoolean h = null;
  public static AtomicBoolean isSynced;
  public static IMAIClickEventList mDBWriterQueue;
  public static IMAIClickEventList mNetworkQueue = null;
  private AtomicBoolean d = new AtomicBoolean();
  private HttpURLConnection e;
  private WebviewLoader g = null;
  
  static
  {
    mDBWriterQueue = new IMAIClickEventList();
    f = null;
  }
  
  private Response a(UserInfo paramUserInfo)
    throws AdException, IOException
  {
    Log.debug("[InMobi]-[Network]-4.1.1", "Http Status Code: " + this.e.getResponseCode());
    int i = this.e.getResponseCode();
    paramUserInfo = this.e.getHeaderField("im-id");
    Log.debug("[InMobi]-[Network]-4.1.1", "Im Id: " + paramUserInfo);
    localObject1 = this.e.getHeaderField("im-ec");
    if (localObject1 != null) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Sandbox error Id: " + (String)localObject1);
    }
    if (i == 200) {}
    try
    {
      localObject1 = new BufferedReader(new InputStreamReader(this.e.getInputStream(), "UTF-8"));
      try
      {
        localObject2 = new StringBuilder();
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          ((StringBuilder)localObject2).append(str).append("\n");
        }
        this.e.disconnect();
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        localObject1 = null;
      }
    }
    a((Closeable)localObject1);
    throw paramUserInfo;
    localObject2 = ((StringBuilder)localObject2).toString();
    Log.debug("[InMobi]-[Network]-4.1.1", "Ad Response: " + (String)localObject2);
    paramUserInfo = new Response(paramUserInfo, (String)localObject2);
    this.e.disconnect();
    a((Closeable)localObject1);
    return paramUserInfo;
    if (i == 204)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Server returned No fill");
      throw new AdException("Server did not return 200.", 100, paramUserInfo, i);
    }
    if (i == 400)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Invalid App Id.Please check the app Id in the adrequest is valid and in active state");
      throw new AdException("Server did not return 200.", 400, paramUserInfo, i);
    }
    Log.debug("[InMobi]-[Network]-4.1.1", "Server Error");
    throw new AdException("Server did not return 200.", 200, paramUserInfo, i);
  }
  
  private HttpURLConnection a(String paramString, UserInfo paramUserInfo)
    throws IOException
  {
    this.e = ((HttpURLConnection)new URL(paramString).openConnection());
    InternalSDKUtil.addCommonPropertiesToConnection(this.e);
    a(this.e, paramUserInfo);
    return this.e;
  }
  
  private void a(int paramInt, Object paramObject, HttpRequestCallback paramHttpRequestCallback)
  {
    if (this.d.get()) {}
    while (paramHttpRequestCallback == null) {
      return;
    }
    paramHttpRequestCallback.notifyResult(paramInt, paramObject);
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
  
  private void a(String paramString)
    throws IOException
  {
    this.e.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.e.getOutputStream()));
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
  
  private static void a(HttpURLConnection paramHttpURLConnection, UserInfo paramUserInfo)
    throws ProtocolException
  {
    int i = Initializer.getConfigParams().getFetchTimeOut();
    paramHttpURLConnection.setConnectTimeout(i);
    paramHttpURLConnection.setReadTimeout(i);
    paramHttpURLConnection.setRequestProperty("user-agent", paramUserInfo.getPhoneDefaultUserAgent());
    paramHttpURLConnection.setUseCaches(false);
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.setDoInput(true);
    paramHttpURLConnection.setRequestMethod("POST");
    paramHttpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
  }
  
  public void asyncRequestAd(final UserInfo paramUserInfo, final ActionType paramActionType, final String paramString, final HttpRequestCallback paramHttpRequestCallback)
  {
    new a(paramUserInfo, paramString, paramActionType, paramHttpRequestCallback).start();
  }
  
  public void deinit()
  {
    try
    {
      if (f != null) {
        f.set(false);
      }
      if (mDBWriterQueue != null)
      {
        mDBWriterQueue.saveClickEvents();
        mDBWriterQueue.clear();
      }
      isSynced.set(false);
      if (mNetworkQueue != null) {
        mNetworkQueue.clear();
      }
      mNetworkQueue = null;
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Request Response Manager deinit failed", localException);
    }
  }
  
  public void doCancel()
  {
    this.d.set(true);
    if (this.e != null) {
      new c().start();
    }
  }
  
  public void init()
  {
    try
    {
      if (mNetworkQueue == null) {
        mNetworkQueue = IMAIClickEventList.getLoggedClickEvents();
      }
      if (f == null) {
        f = new AtomicBoolean(false);
      }
      h = new AtomicBoolean(true);
      isSynced = new AtomicBoolean(false);
      c = new AtomicBoolean(false);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Request Response Manager init failed", localException);
    }
  }
  
  public void processClick(final Context paramContext, final HttpRequestCallback paramHttpRequestCallback)
  {
    try
    {
      if (f.compareAndSet(false, true))
      {
        a = new Thread(new b(paramContext, paramHttpRequestCallback));
        a.setPriority(1);
        a.start();
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception ping ", paramContext);
    }
  }
  
  /* Error */
  public boolean processClickHttpClient(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 68
    //   5: new 70	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 358
    //   15: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 360	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: invokestatic 253	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	()Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   31: invokevirtual 364	com/inmobi/androidsdk/bootstrapper/ConfigParams:getImai	()Lcom/inmobi/androidsdk/bootstrapper/IMAIConfigParams;
    //   34: invokevirtual 369	com/inmobi/androidsdk/bootstrapper/IMAIConfigParams:getPingTimeOut	()I
    //   37: istore_3
    //   38: new 166	java/net/URL
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 169	java/net/URL:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 173	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   49: checkcast 81	java/net/HttpURLConnection
    //   52: astore_1
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 372	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   58: aload_1
    //   59: invokestatic 179	com/inmobi/commons/internal/InternalSDKUtil:addCommonPropertiesToConnection	(Ljava/net/HttpURLConnection;)V
    //   62: aload_1
    //   63: iload_3
    //   64: invokevirtual 262	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload_1
    //   68: iload_3
    //   69: invokevirtual 265	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   72: aload_1
    //   73: iconst_0
    //   74: invokevirtual 276	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   77: aload_1
    //   78: ldc_w 267
    //   81: invokestatic 375	com/inmobi/commons/internal/InternalSDKUtil:getSavedUserAgent	()Ljava/lang/String;
    //   84: invokevirtual 228	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc_w 377
    //   91: invokevirtual 287	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   94: invokestatic 382	com/inmobi/androidsdk/impl/SDKUtil:getQAMode	()Z
    //   97: ifeq +23 -> 120
    //   100: aload_1
    //   101: ldc_w 384
    //   104: ldc_w 386
    //   107: invokevirtual 228	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc_w 388
    //   114: ldc_w 386
    //   117: invokevirtual 228	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 85	java/net/HttpURLConnection:getResponseCode	()I
    //   124: istore_3
    //   125: iload_3
    //   126: sipush 400
    //   129: if_icmpge +126 -> 255
    //   132: iconst_1
    //   133: istore_2
    //   134: iconst_1
    //   135: iload_2
    //   136: if_icmpne +24 -> 160
    //   139: getstatic 52	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   142: iconst_1
    //   143: invokevirtual 305	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   146: aload_1
    //   147: ifnull +106 -> 253
    //   150: aload_1
    //   151: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   154: iload_2
    //   155: istore 4
    //   157: iload 4
    //   159: ireturn
    //   160: getstatic 52	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   163: iconst_0
    //   164: invokevirtual 305	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   167: goto -21 -> 146
    //   170: astore 5
    //   172: getstatic 52	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   175: iconst_0
    //   176: invokevirtual 305	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   179: ldc 68
    //   181: ldc_w 390
    //   184: aload 5
    //   186: invokestatic 318	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: iload_2
    //   190: istore 4
    //   192: aload_1
    //   193: ifnull -36 -> 157
    //   196: aload_1
    //   197: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   200: iload_2
    //   201: ireturn
    //   202: astore_1
    //   203: aload 5
    //   205: ifnull +8 -> 213
    //   208: aload 5
    //   210: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore 6
    //   217: aload_1
    //   218: astore 5
    //   220: aload 6
    //   222: astore_1
    //   223: goto -20 -> 203
    //   226: astore 6
    //   228: aload_1
    //   229: astore 5
    //   231: aload 6
    //   233: astore_1
    //   234: goto -31 -> 203
    //   237: astore 5
    //   239: iconst_0
    //   240: istore_2
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -71 -> 172
    //   246: astore 5
    //   248: iconst_0
    //   249: istore_2
    //   250: goto -78 -> 172
    //   253: iload_2
    //   254: ireturn
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -123 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	RequestResponseManager
    //   0	260	1	paramString	String
    //   0	260	2	paramBoolean	boolean
    //   37	93	3	i	int
    //   155	36	4	bool	boolean
    //   1	1	5	localObject1	Object
    //   170	39	5	localException1	Exception
    //   218	12	5	str	String
    //   237	1	5	localException2	Exception
    //   246	1	5	localException3	Exception
    //   215	6	6	localObject2	Object
    //   226	6	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   139	146	170	java/lang/Exception
    //   160	167	170	java/lang/Exception
    //   3	53	202	finally
    //   53	120	215	finally
    //   120	125	215	finally
    //   139	146	215	finally
    //   160	167	215	finally
    //   172	189	226	finally
    //   3	53	237	java/lang/Exception
    //   53	120	246	java/lang/Exception
    //   120	125	246	java/lang/Exception
  }
  
  public boolean processClickUrlInWebview(String arg1)
  {
    for (;;)
    {
      try
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Processing click in webview " + ???);
        this.g = new WebviewLoader(InternalSDKUtil.getContext());
        int i = Initializer.getConfigParams().getImai().getPingTimeOut();
        HashMap localHashMap = null;
        if (SDKUtil.getQAMode())
        {
          localHashMap = new HashMap();
          localHashMap.put("mk-carrier", "117.97.87.6");
          localHashMap.put("x-real-ip", "117.97.87.6");
        }
        this.g.loadInWebview(???, localHashMap);
        synchronized (a)
        {
          try
          {
            a.wait(i);
            if (true == c.get())
            {
              h.set(true);
              this.g.deinit(i);
              boolean bool = c.get();
              return bool;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.internal("[InMobi]-[Network]-4.1.1", "Network thread wait failure", localInterruptedException);
            continue;
          }
        }
        h.set(false);
      }
      catch (Exception ???)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "ping in webview exception", ???);
        return c.get();
      }
      WebviewLoader.b.set(false);
    }
  }
  
  public static enum ActionType
  {
    private ActionType() {}
  }
  
  class a
    extends Thread
  {
    a(UserInfo paramUserInfo, String paramString, RequestResponseManager.ActionType paramActionType, HttpRequestCallback paramHttpRequestCallback) {}
    
    public void run()
    {
      Object localObject = null;
      try
      {
        WifiInfo localWifiInfo = IceDataCollector.getConnectedWifiInfo(paramUserInfo.getApplicationContext());
        localObject = localWifiInfo;
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            Log.debug("[InMobi]-[Network]-4.1.1", "Ad Serving URL: " + paramString);
            localObject = HttpRequestBuilder.buildPostBody(paramUserInfo, (WifiInfo)localObject, paramActionType);
            Log.debug("[InMobi]-[Network]-4.1.1", (String)localObject);
            RequestResponseManager.a(RequestResponseManager.this, RequestResponseManager.a(RequestResponseManager.this, paramString, paramUserInfo));
            RequestResponseManager.a(RequestResponseManager.this, (String)localObject);
            localObject = RequestResponseManager.a(RequestResponseManager.this, paramUserInfo);
            RequestResponseManager.a(RequestResponseManager.this, 0, localObject, paramHttpRequestCallback);
            return;
          }
          catch (Exception localException1)
          {
            Log.debug("[InMobi]-[Network]-4.1.1", "Exception retrieving ad ", localException1);
            RequestResponseManager.a(RequestResponseManager.this, 1, AdRequest.ErrorCode.INTERNAL_ERROR, paramHttpRequestCallback);
          }
          localException2 = localException2;
          Log.internal("[InMobi]-[Network]-4.1.1", "No wifi permissions set, unable to send wifi data");
        }
      }
      catch (AdException localAdException)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Exception retrieving ad ", localAdException);
        RequestResponseManager.a(RequestResponseManager.this, 1, localAdException, paramHttpRequestCallback);
        return;
      }
      catch (IOException localIOException)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Exception retrieving ad ", localIOException);
        if ((localIOException instanceof SocketTimeoutException))
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Server Timeout");
          RequestResponseManager.a(RequestResponseManager.this, 1, AdRequest.ErrorCode.AD_FETCH_TIMEOUT, paramHttpRequestCallback);
          return;
        }
        RequestResponseManager.a(RequestResponseManager.this, 1, AdRequest.ErrorCode.NETWORK_ERROR, paramHttpRequestCallback);
        return;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(Context paramContext, HttpRequestCallback paramHttpRequestCallback) {}
    
    public void run()
    {
      String str;
      int i;
      boolean bool1;
      boolean bool2;
      int j;
      try
      {
        for (;;)
        {
          if (RequestResponseManager.isSynced.get()) {
            break label660;
          }
          RequestResponseManager.isSynced.set(true);
          if ((RequestResponseManager.mNetworkQueue == null) || (RequestResponseManager.mNetworkQueue.isEmpty()))
          {
            if ((RequestResponseManager.mDBWriterQueue == null) && (RequestResponseManager.mDBWriterQueue.isEmpty()))
            {
              Log.internal("[InMobi]-[Network]-4.1.1", "Click event list empty");
              RequestResponseManager.this.deinit();
              return;
            }
            RequestResponseManager.mNetworkQueue.addAll(RequestResponseManager.mDBWriterQueue);
            RequestResponseManager.mDBWriterQueue.clear();
          }
          try
          {
            if (!RequestResponseManager.mNetworkQueue.isEmpty())
            {
              ClickData localClickData = (ClickData)RequestResponseManager.mNetworkQueue.remove(0);
              str = localClickData.getClickUrl();
              i = localClickData.getRetryCount();
              bool1 = localClickData.isPingWv();
              bool2 = localClickData.isFollowRedirects();
              j = Initializer.getConfigParams().getImai().getRetryInterval();
              if (!InternalSDKUtil.checkNetworkAvailibility(paramContext))
              {
                Log.internal("[InMobi]-[Network]-4.1.1", "Cannot process click. Network Not available");
                if (i > 1) {
                  RequestResponseManager.mDBWriterQueue.add(localClickData);
                }
                if (paramHttpRequestCallback != null) {
                  paramHttpRequestCallback.notifyResult(1, null);
                }
                RequestResponseManager.this.deinit();
                return;
              }
            }
          }
          catch (Exception localException1)
          {
            Log.internal("[InMobi]-[Network]-4.1.1", "Exception pinging click in background", localException1);
            RequestResponseManager.this.deinit();
            return;
          }
        }
        k = Initializer.getConfigParams().getImai().getMaxRetry();
      }
      catch (Exception localException2)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Exception ping to server ", localException2);
        return;
      }
      int k;
      if ((!RequestResponseManager.a().get()) && (i < k)) {
        Log.internal("[InMobi]-[Network]-4.1.1", "Retrying to ping in background after " + j / 1000 + " secs");
      }
      for (;;)
      {
        synchronized (RequestResponseManager.a)
        {
          try
          {
            RequestResponseManager.a.wait(j);
            Log.internal("[InMobi]-[Network]-4.1.1", "Processing click in background: " + str);
            if (!bool1) {
              break label507;
            }
            if (RequestResponseManager.this.processClickUrlInWebview(str))
            {
              Log.internal("[InMobi]-[Network]-4.1.1", "Ping in webview successful: " + str);
              if (paramHttpRequestCallback != null) {
                paramHttpRequestCallback.notifyResult(0, null);
              }
              if (RequestResponseManager.mDBWriterQueue.size() <= Initializer.getConfigParams().getImai().getmDefaultEventsBatch()) {
                break;
              }
              RequestResponseManager.mDBWriterQueue.saveClickEvents();
              RequestResponseManager.mDBWriterQueue.clear();
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.internal("[InMobi]-[Network]-4.1.1", "Network thread wait failure", localInterruptedException);
            continue;
          }
        }
        ((ClickData)localObject).setRetryCount(i - 1);
        if (i > 1) {
          RequestResponseManager.mDBWriterQueue.add(localObject);
        }
        Log.internal("[InMobi]-[Network]-4.1.1", "Ping in webview failed: " + str);
        if (paramHttpRequestCallback != null)
        {
          paramHttpRequestCallback.notifyResult(1, null);
          continue;
          label507:
          if (RequestResponseManager.this.processClickHttpClient(str, bool2))
          {
            Log.internal("[InMobi]-[Network]-4.1.1", "Ping successful: " + str);
            if (paramHttpRequestCallback != null) {
              paramHttpRequestCallback.notifyResult(0, null);
            }
          }
          else
          {
            ((ClickData)localObject).setRetryCount(i - 1);
            if (i > 1) {
              RequestResponseManager.mDBWriterQueue.add(localObject);
            }
            Log.internal("[InMobi]-[Network]-4.1.1", "Ping  failed: " + str);
            if (paramHttpRequestCallback != null) {
              paramHttpRequestCallback.notifyResult(1, null);
            }
            Log.internal("[InMobi]-[Network]-4.1.1", "Ping failed: " + str);
          }
        }
      }
      label660:
      RequestResponseManager.this.deinit();
    }
  }
  
  class c
    extends Thread
  {
    c() {}
    
    public void run()
    {
      try
      {
        RequestResponseManager.a(RequestResponseManager.this).disconnect();
        return;
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Exception in closing connection ", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/net/RequestResponseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */