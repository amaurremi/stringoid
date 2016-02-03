package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import android.os.Handler;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIClickEventList;
import com.inmobi.androidsdk.impl.imai.IMAIUtility;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.re.container.IMWebView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RequestResponseManager
{
  static Thread a;
  static Handler b;
  static AtomicBoolean c = null;
  private static AtomicBoolean f;
  private static AtomicBoolean h = null;
  public static AtomicBoolean isSynced;
  public static IMAIClickEventList mClickEventList = null;
  private AtomicBoolean d = new AtomicBoolean();
  private HttpURLConnection e;
  private WebviewLoader g = null;
  
  static
  {
    f = null;
  }
  
  private Response a(UserInfo paramUserInfo)
    throws AdException, IOException
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "Http Status Code: " + this.e.getResponseCode());
    int i = this.e.getResponseCode();
    paramUserInfo = this.e.getHeaderField("im-id");
    Log.debug("InMobiAndroidSDK_3.7.1", "Im Id: " + paramUserInfo);
    localObject1 = this.e.getHeaderField("im-ec");
    if (localObject1 != null) {
      Log.debug("InMobiAndroidSDK_3.7.1", "Sandbox error Id: " + (String)localObject1);
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
    Log.debug("InMobiAndroidSDK_3.7.1", "Ad Response: " + (String)localObject2);
    paramUserInfo = new Response(paramUserInfo, (String)localObject2);
    this.e.disconnect();
    a((Closeable)localObject1);
    return paramUserInfo;
    if (i == 204)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Server returned No fill");
      throw new AdException("Server did not return 200.", 100, paramUserInfo, i);
    }
    if (i == 400)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Invalid App Id.Please check the app Id in the adrequest is valid and in active state");
      throw new AdException("Server did not return 200.", 400, paramUserInfo, i);
    }
    Log.debug("InMobiAndroidSDK_3.7.1", "Server Error");
    throw new AdException("Server did not return 200.", 200, paramUserInfo, i);
  }
  
  private HttpURLConnection a(String paramString, UserInfo paramUserInfo)
    throws IOException
  {
    this.e = ((HttpURLConnection)new URL(paramString).openConnection());
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
      Log.debug("InMobiAndroidSDK_3.7.1", "Exception closing resource: " + paramCloseable, localIOException);
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
    int i = Initializer.getConfigParams(InternalSDKUtil.getContext()).getFetchTimeOut();
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
      if (mClickEventList != null) {
        mClickEventList.saveClickEvents();
      }
      isSynced.set(false);
      mClickEventList = null;
      return;
    }
    catch (Exception localException)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Request Response Manager init failed", localException);
    }
  }
  
  public void doCancel()
  {
    this.d.set(true);
    if (this.e != null) {
      this.e.disconnect();
    }
  }
  
  public void init()
  {
    try
    {
      if (mClickEventList == null) {
        mClickEventList = IMAIClickEventList.getLoggedClickEvents();
      }
      if (f == null) {
        f = new AtomicBoolean(false);
      }
      h = new AtomicBoolean(true);
      isSynced = new AtomicBoolean(false);
      b = new Handler();
      c = new AtomicBoolean(false);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Request Response Manager init failed", localException);
    }
  }
  
  /* Error */
  public boolean processClickHttpClient(int paramInt1, String paramString, boolean paramBoolean1, Context paramContext, WeakReference<IMWebView> paramWeakReference, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 55
    //   5: new 57	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 320
    //   15: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_2
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 322	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: new 324	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus
    //   31: dup
    //   32: invokespecial 325	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:<init>	()V
    //   35: astore 8
    //   37: aload 8
    //   39: aload_2
    //   40: putfield 328	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:b	Ljava/lang/String;
    //   43: aload 8
    //   45: aload 5
    //   47: putfield 331	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:a	Ljava/lang/ref/WeakReference;
    //   50: invokestatic 233	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   53: invokestatic 239	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   56: invokevirtual 335	com/inmobi/androidsdk/bootstrapper/ConfigParams:getImai	()Lcom/inmobi/androidsdk/bootstrapper/IMAIConfigParams;
    //   59: invokevirtual 340	com/inmobi/androidsdk/bootstrapper/IMAIConfigParams:getPingTimeOut	()I
    //   62: istore_1
    //   63: new 152	java/net/URL
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   74: checkcast 68	java/net/HttpURLConnection
    //   77: astore_2
    //   78: aload_2
    //   79: iload_3
    //   80: invokevirtual 343	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload_2
    //   84: iload_1
    //   85: invokevirtual 248	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   88: aload_2
    //   89: iload_1
    //   90: invokevirtual 251	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   93: aload_2
    //   94: iconst_0
    //   95: invokevirtual 262	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   98: aload_2
    //   99: ldc -3
    //   101: invokestatic 346	com/inmobi/commons/internal/InternalSDKUtil:getSavedUserAgent	()Ljava/lang/String;
    //   104: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_2
    //   108: ldc_w 348
    //   111: invokevirtual 273	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   114: invokestatic 353	com/inmobi/androidsdk/impl/SDKUtil:getQAMode	()Z
    //   117: ifeq +23 -> 140
    //   120: aload_2
    //   121: ldc_w 355
    //   124: ldc_w 357
    //   127: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_2
    //   131: ldc_w 359
    //   134: ldc_w 357
    //   137: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: invokevirtual 72	java/net/HttpURLConnection:getResponseCode	()I
    //   144: istore_1
    //   145: iload_1
    //   146: sipush 400
    //   149: if_icmpge +198 -> 347
    //   152: iconst_1
    //   153: istore_3
    //   154: iconst_1
    //   155: iload_3
    //   156: if_icmpne +40 -> 196
    //   159: getstatic 37	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   162: iconst_1
    //   163: invokevirtual 291	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   166: iload 7
    //   168: ifeq +14 -> 182
    //   171: getstatic 365	com/inmobi/androidsdk/impl/imai/IMAIUtility:mPingReqCallback	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
    //   174: iconst_0
    //   175: aload 8
    //   177: invokeinterface 174 3 0
    //   182: aload_2
    //   183: ifnull +162 -> 345
    //   186: aload_2
    //   187: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   190: iload_3
    //   191: istore 7
    //   193: iload 7
    //   195: ireturn
    //   196: getstatic 37	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   199: iconst_0
    //   200: invokevirtual 291	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   203: iload 7
    //   205: ifeq -23 -> 182
    //   208: getstatic 365	com/inmobi/androidsdk/impl/imai/IMAIUtility:mPingReqCallback	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
    //   211: iconst_1
    //   212: aload 8
    //   214: invokeinterface 174 3 0
    //   219: goto -37 -> 182
    //   222: astore 4
    //   224: aload 8
    //   226: astore 5
    //   228: getstatic 37	com/inmobi/androidsdk/impl/net/RequestResponseManager:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   231: iconst_0
    //   232: invokevirtual 291	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   235: iload 7
    //   237: ifeq +14 -> 251
    //   240: getstatic 365	com/inmobi/androidsdk/impl/imai/IMAIUtility:mPingReqCallback	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
    //   243: iconst_1
    //   244: aload 5
    //   246: invokeinterface 174 3 0
    //   251: ldc 55
    //   253: ldc_w 367
    //   256: aload 4
    //   258: invokestatic 303	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: iload_3
    //   262: istore 7
    //   264: aload_2
    //   265: ifnull -72 -> 193
    //   268: aload_2
    //   269: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   272: iload_3
    //   273: ireturn
    //   274: astore_2
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 121	java/net/HttpURLConnection:disconnect	()V
    //   285: aload_2
    //   286: athrow
    //   287: astore 5
    //   289: aload_2
    //   290: astore 4
    //   292: aload 5
    //   294: astore_2
    //   295: goto -20 -> 275
    //   298: astore 5
    //   300: aload_2
    //   301: astore 4
    //   303: aload 5
    //   305: astore_2
    //   306: goto -31 -> 275
    //   309: astore 4
    //   311: aconst_null
    //   312: astore 5
    //   314: iconst_0
    //   315: istore_3
    //   316: aconst_null
    //   317: astore_2
    //   318: goto -90 -> 228
    //   321: astore 4
    //   323: iconst_0
    //   324: istore_3
    //   325: aconst_null
    //   326: astore_2
    //   327: aload 8
    //   329: astore 5
    //   331: goto -103 -> 228
    //   334: astore 4
    //   336: iconst_0
    //   337: istore_3
    //   338: aload 8
    //   340: astore 5
    //   342: goto -114 -> 228
    //   345: iload_3
    //   346: ireturn
    //   347: iconst_0
    //   348: istore_3
    //   349: goto -195 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	RequestResponseManager
    //   0	352	1	paramInt1	int
    //   0	352	2	paramString	String
    //   0	352	3	paramBoolean1	boolean
    //   0	352	4	paramContext	Context
    //   0	352	5	paramWeakReference	WeakReference<IMWebView>
    //   0	352	6	paramInt2	int
    //   0	352	7	paramBoolean2	boolean
    //   35	304	8	localResponseStatus	HttpRequestCallback.ResponseStatus
    // Exception table:
    //   from	to	target	type
    //   159	166	222	java/lang/Exception
    //   171	182	222	java/lang/Exception
    //   196	203	222	java/lang/Exception
    //   208	219	222	java/lang/Exception
    //   3	37	274	finally
    //   37	78	274	finally
    //   78	140	287	finally
    //   140	145	287	finally
    //   159	166	287	finally
    //   171	182	287	finally
    //   196	203	287	finally
    //   208	219	287	finally
    //   228	235	298	finally
    //   240	251	298	finally
    //   251	261	298	finally
    //   3	37	309	java/lang/Exception
    //   37	78	321	java/lang/Exception
    //   78	140	334	java/lang/Exception
    //   140	145	334	java/lang/Exception
  }
  
  public void processClickInBackground(final Context paramContext)
  {
    if (f.compareAndSet(false, true))
    {
      a = new Thread(new b(paramContext));
      a.setPriority(1);
      a.start();
    }
  }
  
  public boolean processClickUrlInWebview(int paramInt1, String paramString, Context arg3, WeakReference<IMWebView> paramWeakReference, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Processing click in webview " + paramString);
        this.g = new WebviewLoader(InternalSDKUtil.getContext());
        paramInt1 = Initializer.getConfigParams(InternalSDKUtil.getContext()).getImai().getPingTimeOut();
        ??? = null;
        if (SDKUtil.getQAMode())
        {
          ??? = new HashMap();
          ???.put("mk-carrier", "117.97.87.6");
          ???.put("x-real-ip", "117.97.87.6");
        }
        this.g.loadInWebview(paramString, ???);
        synchronized (a)
        {
          try
          {
            a.wait(paramInt1);
            ??? = new HttpRequestCallback.ResponseStatus();
            ???.b = paramString;
            ???.a = paramWeakReference;
            if (true == c.get())
            {
              h.set(true);
              if (paramBoolean) {
                IMAIUtility.mPingWebviewCallback.notifyResult(0, ???);
              }
              this.g.deinit(paramInt1);
              paramBoolean = c.get();
              return paramBoolean;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Network thread wait failure", localInterruptedException);
            continue;
          }
        }
        h.set(false);
      }
      catch (Exception paramString)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "ping in webview exception", paramString);
        return c.get();
      }
      if (paramBoolean) {
        IMAIUtility.mPingWebviewCallback.notifyResult(1, ???);
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
            Log.debug("InMobiAndroidSDK_3.7.1", "Ad Serving URL: " + paramString);
            localObject = HttpRequestBuilder.a(paramUserInfo, (WifiInfo)localObject, paramActionType);
            Log.debug("InMobiAndroidSDK_3.7.1", (String)localObject);
            RequestResponseManager.a(RequestResponseManager.this, RequestResponseManager.a(RequestResponseManager.this, paramString, paramUserInfo));
            RequestResponseManager.a(RequestResponseManager.this, (String)localObject);
            localObject = RequestResponseManager.a(RequestResponseManager.this, paramUserInfo);
            RequestResponseManager.a(RequestResponseManager.this, 0, localObject, paramHttpRequestCallback);
            return;
          }
          catch (Exception localException1)
          {
            Log.debug("InMobiAndroidSDK_3.7.1", "Exception retrieving ad ", localException1);
            RequestResponseManager.a(RequestResponseManager.this, 1, IMAdRequest.ErrorCode.INTERNAL_ERROR, paramHttpRequestCallback);
          }
          localException2 = localException2;
          Log.internal("InMobiAndroidSDK_3.7.1", "No wifi permissions set, unable to send wifi data");
        }
      }
      catch (AdException localAdException)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception retrieving ad ", localAdException);
        RequestResponseManager.a(RequestResponseManager.this, 1, localAdException, paramHttpRequestCallback);
        return;
      }
      catch (IOException localIOException)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception retrieving ad ", localIOException);
        if ((localIOException instanceof SocketTimeoutException))
        {
          Log.internal("InMobiAndroidSDK_3.7.1", "Server Timeout");
          RequestResponseManager.a(RequestResponseManager.this, 1, IMAdRequest.ErrorCode.AD_FETCH_TIMEOUT, paramHttpRequestCallback);
          return;
        }
        RequestResponseManager.a(RequestResponseManager.this, 1, IMAdRequest.ErrorCode.NETWORK_ERROR, paramHttpRequestCallback);
        return;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(Context paramContext) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 34	com/inmobi/androidsdk/impl/net/RequestResponseManager:isSynced	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   3: invokevirtual 40	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   6: ifne +536 -> 542
      //   9: getstatic 34	com/inmobi/androidsdk/impl/net/RequestResponseManager:isSynced	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   12: iconst_1
      //   13: invokevirtual 44	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   16: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   19: ifnull +12 -> 31
      //   22: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   25: invokevirtual 53	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:isEmpty	()Z
      //   28: ifeq +172 -> 200
      //   31: ldc 55
      //   33: ldc 57
      //   35: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   38: aload_0
      //   39: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   42: invokevirtual 66	com/inmobi/androidsdk/impl/net/RequestResponseManager:deinit	()V
      //   45: return
      //   46: aload 9
      //   48: invokevirtual 71	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:isFirstClick	()Z
      //   51: ifne +64 -> 115
      //   54: invokestatic 74	com/inmobi/androidsdk/impl/net/RequestResponseManager:a	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   57: invokevirtual 40	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   60: ifne +55 -> 115
      //   63: ldc 55
      //   65: new 76	java/lang/StringBuilder
      //   68: dup
      //   69: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   72: ldc 79
      //   74: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: iload_3
      //   78: sipush 1000
      //   81: idiv
      //   82: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   85: ldc 88
      //   87: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   96: getstatic 95	com/inmobi/androidsdk/impl/net/RequestResponseManager:a	Ljava/lang/Thread;
      //   99: astore 9
      //   101: aload 9
      //   103: monitorenter
      //   104: getstatic 95	com/inmobi/androidsdk/impl/net/RequestResponseManager:a	Ljava/lang/Thread;
      //   107: iload_3
      //   108: i2l
      //   109: invokevirtual 99	java/lang/Object:wait	(J)V
      //   112: aload 9
      //   114: monitorexit
      //   115: ldc 55
      //   117: new 76	java/lang/StringBuilder
      //   120: dup
      //   121: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   124: ldc 101
      //   126: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: aload 7
      //   131: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   137: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   140: iload 4
      //   142: ifeq +305 -> 447
      //   145: aload_0
      //   146: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   149: iload_2
      //   150: aload 7
      //   152: aload_0
      //   153: getfield 21	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:a	Landroid/content/Context;
      //   156: aload 8
      //   158: iload_1
      //   159: iload 6
      //   161: invokevirtual 105	com/inmobi/androidsdk/impl/net/RequestResponseManager:processClickUrlInWebview	(ILjava/lang/String;Landroid/content/Context;Ljava/lang/ref/WeakReference;IZ)Z
      //   164: ifeq +248 -> 412
      //   167: ldc 55
      //   169: new 76	java/lang/StringBuilder
      //   172: dup
      //   173: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   176: ldc 107
      //   178: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   181: aload 7
      //   183: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   189: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   192: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   195: iload_2
      //   196: invokevirtual 111	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:removeClickEvent	(I)Z
      //   199: pop
      //   200: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   203: invokevirtual 53	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:isEmpty	()Z
      //   206: ifne -206 -> 0
      //   209: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   212: iconst_0
      //   213: invokevirtual 114	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:get	(I)Ljava/lang/Object;
      //   216: checkcast 68	com/inmobi/androidsdk/impl/imai/IMAIClickEvent
      //   219: astore 9
      //   221: aload 9
      //   223: invokevirtual 117	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:getClickURL	()Ljava/lang/String;
      //   226: astore 7
      //   228: aload 9
      //   230: invokevirtual 121	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:getRetryCount	()I
      //   233: istore_1
      //   234: aload 9
      //   236: invokevirtual 124	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:isPingWV	()Z
      //   239: istore 4
      //   241: aload 9
      //   243: invokevirtual 127	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:isFollowRedirects	()Z
      //   246: istore 5
      //   248: aload 9
      //   250: invokevirtual 130	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:getClickId	()I
      //   253: istore_2
      //   254: aload 9
      //   256: invokevirtual 71	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:isFirstClick	()Z
      //   259: istore 6
      //   261: aload 9
      //   263: invokevirtual 134	com/inmobi/androidsdk/impl/imai/IMAIClickEvent:getWebviewRef	()Ljava/lang/ref/WeakReference;
      //   266: astore 8
      //   268: invokestatic 140	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
      //   271: invokestatic 146	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
      //   274: invokevirtual 152	com/inmobi/androidsdk/bootstrapper/ConfigParams:getImai	()Lcom/inmobi/androidsdk/bootstrapper/IMAIConfigParams;
      //   277: invokevirtual 157	com/inmobi/androidsdk/bootstrapper/IMAIConfigParams:getRetryInterval	()I
      //   280: istore_3
      //   281: aload_0
      //   282: getfield 21	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:a	Landroid/content/Context;
      //   285: invokestatic 161	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
      //   288: ifne -242 -> 46
      //   291: ldc 55
      //   293: ldc -93
      //   295: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   298: new 165	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus
      //   301: dup
      //   302: invokespecial 166	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:<init>	()V
      //   305: astore 9
      //   307: aload 9
      //   309: aload 7
      //   311: putfield 169	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:b	Ljava/lang/String;
      //   314: aload 9
      //   316: aload 8
      //   318: putfield 172	com/inmobi/androidsdk/impl/net/HttpRequestCallback$ResponseStatus:a	Ljava/lang/ref/WeakReference;
      //   321: iload 6
      //   323: ifeq +19 -> 342
      //   326: iload 4
      //   328: ifeq +48 -> 376
      //   331: getstatic 178	com/inmobi/androidsdk/impl/imai/IMAIUtility:mPingWebviewCallback	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
      //   334: iconst_1
      //   335: aload 9
      //   337: invokeinterface 184 3 0
      //   342: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   345: iload_2
      //   346: invokevirtual 188	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:resetFirstClick	(I)V
      //   349: aload_0
      //   350: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   353: invokevirtual 66	com/inmobi/androidsdk/impl/net/RequestResponseManager:deinit	()V
      //   356: return
      //   357: astore 7
      //   359: ldc 55
      //   361: ldc -66
      //   363: aload 7
      //   365: invokestatic 193	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   368: aload_0
      //   369: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   372: invokevirtual 66	com/inmobi/androidsdk/impl/net/RequestResponseManager:deinit	()V
      //   375: return
      //   376: getstatic 196	com/inmobi/androidsdk/impl/imai/IMAIUtility:mPingReqCallback	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
      //   379: iconst_1
      //   380: aload 9
      //   382: invokeinterface 184 3 0
      //   387: goto -45 -> 342
      //   390: astore 10
      //   392: ldc 55
      //   394: ldc -58
      //   396: aload 10
      //   398: invokestatic 193	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   401: goto -289 -> 112
      //   404: astore 7
      //   406: aload 9
      //   408: monitorexit
      //   409: aload 7
      //   411: athrow
      //   412: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   415: iload_2
      //   416: invokevirtual 201	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:reduceRetryCount	(I)V
      //   419: ldc 55
      //   421: new 76	java/lang/StringBuilder
      //   424: dup
      //   425: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   428: ldc -53
      //   430: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   433: aload 7
      //   435: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   438: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   441: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   444: goto -244 -> 200
      //   447: aload_0
      //   448: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   451: iload_2
      //   452: aload 7
      //   454: iload 5
      //   456: aload_0
      //   457: getfield 21	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:a	Landroid/content/Context;
      //   460: aload 8
      //   462: iload_1
      //   463: iload 6
      //   465: invokevirtual 207	com/inmobi/androidsdk/impl/net/RequestResponseManager:processClickHttpClient	(ILjava/lang/String;ZLandroid/content/Context;Ljava/lang/ref/WeakReference;IZ)Z
      //   468: ifeq +39 -> 507
      //   471: ldc 55
      //   473: new 76	java/lang/StringBuilder
      //   476: dup
      //   477: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   480: ldc -47
      //   482: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   485: aload 7
      //   487: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   490: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   493: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   496: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   499: iload_2
      //   500: invokevirtual 111	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:removeClickEvent	(I)Z
      //   503: pop
      //   504: goto -304 -> 200
      //   507: getstatic 48	com/inmobi/androidsdk/impl/net/RequestResponseManager:mClickEventList	Lcom/inmobi/androidsdk/impl/imai/IMAIClickEventList;
      //   510: iload_2
      //   511: invokevirtual 201	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:reduceRetryCount	(I)V
      //   514: ldc 55
      //   516: new 76	java/lang/StringBuilder
      //   519: dup
      //   520: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   523: ldc -45
      //   525: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   528: aload 7
      //   530: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   533: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   536: invokestatic 63	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   539: goto -339 -> 200
      //   542: aload_0
      //   543: getfield 19	com/inmobi/androidsdk/impl/net/RequestResponseManager$b:b	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   546: invokevirtual 66	com/inmobi/androidsdk/impl/net/RequestResponseManager:deinit	()V
      //   549: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	550	0	this	b
      //   158	305	1	i	int
      //   149	362	2	j	int
      //   77	204	3	k	int
      //   140	187	4	bool1	boolean
      //   246	209	5	bool2	boolean
      //   159	305	6	bool3	boolean
      //   129	181	7	str1	String
      //   357	7	7	localException	Exception
      //   404	125	7	str2	String
      //   156	305	8	localWeakReference	WeakReference
      //   390	7	10	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   46	104	357	java/lang/Exception
      //   115	140	357	java/lang/Exception
      //   145	200	357	java/lang/Exception
      //   200	321	357	java/lang/Exception
      //   331	342	357	java/lang/Exception
      //   342	356	357	java/lang/Exception
      //   376	387	357	java/lang/Exception
      //   409	412	357	java/lang/Exception
      //   412	444	357	java/lang/Exception
      //   447	504	357	java/lang/Exception
      //   507	539	357	java/lang/Exception
      //   104	112	390	java/lang/InterruptedException
      //   104	112	404	finally
      //   112	115	404	finally
      //   392	401	404	finally
      //   406	409	404	finally
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/net/RequestResponseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */