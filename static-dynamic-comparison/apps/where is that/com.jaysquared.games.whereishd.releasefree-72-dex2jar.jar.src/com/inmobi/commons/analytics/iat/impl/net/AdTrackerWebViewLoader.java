package com.inmobi.commons.analytics.iat.impl.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLDecoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class AdTrackerWebViewLoader
{
  private static WebView a = null;
  private static AtomicBoolean b;
  private long c = 0L;
  private long d = 0L;
  private Goal e;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public AdTrackerWebViewLoader()
  {
    AdTrackerNetworkInterface.getUIHandler().post(new e());
  }
  
  private d a(String paramString)
  {
    d locald = new d();
    try
    {
      arrayOfString1 = paramString.split("&");
      k = 0;
      paramString = null;
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String[] arrayOfString1;
        int k;
        int m;
        int n;
        int j = 0;
        continue;
        m += 1;
        int i = n;
        continue;
        k += 1;
      }
    }
    j = i;
    try
    {
      if (k < arrayOfString1.length)
      {
        j = i;
        String[] arrayOfString2 = arrayOfString1[k].split("=");
        m = 0;
        j = i;
        if (m >= arrayOfString2.length) {
          break label407;
        }
        j = i;
        if ("err".equals(arrayOfString2[m]))
        {
          j = i;
          n = Integer.parseInt(arrayOfString2[(m + 1)]);
          break label395;
        }
        j = i;
        n = i;
        if (!"res".equals(arrayOfString2[m])) {
          break label395;
        }
        paramString = arrayOfString2[(m + 1)];
        n = i;
        break label395;
      }
      j = i;
      d.a(locald, i);
      j = i;
      d.a(locald, paramString);
      if (5003 == i)
      {
        j = i;
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Webview Timeout " + paramString);
      }
      else if (5001 == i)
      {
        j = i;
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Invalid params passed " + paramString);
      }
    }
    catch (Exception paramString)
    {
      AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, j, null);
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Check content Exception", paramString);
      return null;
    }
    if (5002 == i)
    {
      j = i;
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "XMLHTTP request not supported " + paramString);
    }
    else if (5005 == i)
    {
      j = i;
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Invalid JSON Response " + paramString);
    }
    else if (5004 == i)
    {
      j = i;
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Webview Server Error " + paramString);
    }
    else if (5000 == i)
    {
      j = i;
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Webview response " + URLDecoder.decode(paramString, "utf-8"));
    }
    label395:
    label407:
    return locald;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      paramString = new JSONObject(URLDecoder.decode(paramString, "utf-8"));
      JSONObject localJSONObject = paramString.getJSONObject("iat_ids");
      String str = paramString.getString("errmsg");
      int i = paramString.getInt("timetoLive");
      int j = paramString.getInt("errcode");
      if (j != 6000)
      {
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, j, null);
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Failed to upload goal in webview" + str);
        return false;
      }
      AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, this.e, 0, this.d, 0, null);
      paramString = localJSONObject.toString();
      if (j == 6001) {
        paramString = null;
      }
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", paramString);
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive", Integer.toString(i));
      return true;
    }
    catch (Exception paramString)
    {
      AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, 424, paramString.getMessage());
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to upload goal in webview", paramString);
    }
    return false;
  }
  
  public static WebView getWebview()
  {
    return a;
  }
  
  public static boolean isWebviewLoading()
  {
    return b.get();
  }
  
  public void deinit(int paramInt)
  {
    AdTrackerNetworkInterface.getUIHandler().postDelayed(new a(), paramInt);
  }
  
  public boolean loadWebview(Goal paramGoal)
  {
    this.e = paramGoal;
    try
    {
      AdTrackerNetworkInterface.getUIHandler().post(new b());
      return true;
    }
    catch (Exception paramGoal)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", paramGoal.toString());
    }
    return false;
  }
  
  public void stopLoading()
  {
    AdTrackerNetworkInterface.getUIHandler().post(new c());
  }
  
  protected static class JSInterface
  {
    @JavascriptInterface
    public String getParams()
    {
      String str3 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
      String str2 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
      String str1 = str2;
      if (str3 != null) {
        str1 = str2 + "&referrer=" + str3;
      }
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Request param for webview" + str1);
      return str1;
    }
  }
  
  protected class MyWebViewClient
    extends WebViewClient
  {
    protected MyWebViewClient() {}
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      for (;;)
      {
        try
        {
          if (AdTrackerWebViewLoader.b().compareAndSet(true, false)) {
            AdTrackerNetworkInterface.setWebviewUploadStatus(false);
          }
        }
        catch (Exception localException)
        {
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Exception onReceived Error", localException);
          continue;
        }
        synchronized (AdTrackerNetworkInterface.getNetworkThread())
        {
          AdTrackerNetworkInterface.getNetworkThread().notify();
          AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(AdTrackerWebViewLoader.this), 0, 0L, paramInt, null);
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Webview Received Error");
          super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
          return;
        }
      }
    }
    
    @TargetApi(8)
    public void onReceivedSslError(WebView arg1, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "SSL Error. Proceeding" + paramSslError);
      for (;;)
      {
        try
        {
          if (AdTrackerWebViewLoader.b().compareAndSet(true, false)) {
            AdTrackerNetworkInterface.setWebviewUploadStatus(false);
          }
        }
        catch (Exception ???)
        {
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Exception onReceived SSL Error", ???);
          continue;
        }
        synchronized (AdTrackerNetworkInterface.getNetworkThread())
        {
          AdTrackerNetworkInterface.getNetworkThread().notify();
          AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(AdTrackerWebViewLoader.this), 0, 0L, paramSslError.getPrimaryError(), null);
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Webview Received SSL Error");
          paramSslErrorHandler.proceed();
          return;
        }
      }
    }
    
    /* Error */
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      // Byte code:
      //   0: invokestatic 25	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   3: iconst_1
      //   4: iconst_0
      //   5: invokevirtual 31	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   8: ifeq +69 -> 77
      //   11: aload_0
      //   12: getfield 13	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
      //   15: invokestatic 123	java/lang/System:currentTimeMillis	()J
      //   18: aload_0
      //   19: getfield 13	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
      //   22: invokestatic 126	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;)J
      //   25: lsub
      //   26: invokestatic 129	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;J)J
      //   29: pop2
      //   30: aload_2
      //   31: ldc -125
      //   33: invokevirtual 137	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   36: ifeq +27 -> 63
      //   39: aload_2
      //   40: bipush 7
      //   42: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
      //   45: astore_3
      //   46: aload_0
      //   47: getfield 13	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
      //   50: aload_3
      //   51: invokestatic 144	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;Ljava/lang/String;)Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;
      //   54: astore_3
      //   55: aload_3
      //   56: ifnonnull +28 -> 84
      //   59: iconst_0
      //   60: invokestatic 37	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
      //   63: invokestatic 41	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:getNetworkThread	()Ljava/lang/Thread;
      //   66: astore_3
      //   67: aload_3
      //   68: monitorenter
      //   69: invokestatic 41	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:getNetworkThread	()Ljava/lang/Thread;
      //   72: invokevirtual 46	java/lang/Object:notify	()V
      //   75: aload_3
      //   76: monitorexit
      //   77: aload_1
      //   78: aload_2
      //   79: invokevirtual 150	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
      //   82: iconst_1
      //   83: ireturn
      //   84: invokestatic 156	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
      //   87: ldc -98
      //   89: ldc -96
      //   91: aload_3
      //   92: invokestatic 165	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
      //   95: invokestatic 169	java/lang/Integer:toString	(I)Ljava/lang/String;
      //   98: invokestatic 175	com/inmobi/commons/internal/FileOperations:setPreferences	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
      //   101: pop
      //   102: sipush 5000
      //   105: aload_3
      //   106: invokestatic 165	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
      //   109: if_icmpeq +41 -> 150
      //   112: iconst_0
      //   113: invokestatic 37	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
      //   116: getstatic 52	com/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType:GOAL_FAILURE	Lcom/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType;
      //   119: aload_0
      //   120: getfield 13	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
      //   123: invokestatic 55	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;)Lcom/inmobi/commons/analytics/iat/impl/Goal;
      //   126: iconst_0
      //   127: lconst_0
      //   128: aload_3
      //   129: invokestatic 165	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
      //   132: aconst_null
      //   133: invokestatic 61	com/inmobi/commons/analytics/iat/impl/AdTrackerUtils:reportMetric	(Lcom/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType;Lcom/inmobi/commons/analytics/iat/impl/Goal;IJILjava/lang/String;)V
      //   136: goto -73 -> 63
      //   139: astore_1
      //   140: ldc 63
      //   142: ldc -79
      //   144: aload_1
      //   145: invokestatic 78	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   148: iconst_1
      //   149: ireturn
      //   150: aload_0
      //   151: getfield 13	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
      //   154: aload_3
      //   155: invokestatic 180	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)Ljava/lang/String;
      //   158: invokestatic 183	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;Ljava/lang/String;)Z
      //   161: ifeq +10 -> 171
      //   164: iconst_1
      //   165: invokestatic 37	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
      //   168: goto -105 -> 63
      //   171: iconst_0
      //   172: invokestatic 37	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
      //   175: goto -112 -> 63
      //   178: astore_1
      //   179: aload_3
      //   180: monitorexit
      //   181: aload_1
      //   182: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	183	0	this	MyWebViewClient
      //   0	183	1	paramWebView	WebView
      //   0	183	2	paramString	String
      // Exception table:
      //   from	to	target	type
      //   0	55	139	java/lang/Exception
      //   59	63	139	java/lang/Exception
      //   63	69	139	java/lang/Exception
      //   77	82	139	java/lang/Exception
      //   84	136	139	java/lang/Exception
      //   150	168	139	java/lang/Exception
      //   171	175	139	java/lang/Exception
      //   181	183	139	java/lang/Exception
      //   69	77	178	finally
      //   179	181	178	finally
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (AdTrackerWebViewLoader.a() != null)
      {
        AdTrackerWebViewLoader.a().stopLoading();
        AdTrackerWebViewLoader.a().destroy();
        AdTrackerWebViewLoader.a(null);
        AdTrackerWebViewLoader.b().set(false);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      AdTrackerWebViewLoader.b(AdTrackerWebViewLoader.this, System.currentTimeMillis());
      AdTrackerWebViewLoader.b().set(true);
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Load Webview: " + AdTrackerNetworkInterface.b());
      AdTrackerWebViewLoader.a().loadUrl(AdTrackerNetworkInterface.b());
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (AdTrackerWebViewLoader.a() != null) {
        AdTrackerWebViewLoader.b().set(false);
      }
      AdTrackerWebViewLoader.a().stopLoading();
    }
  }
  
  private static class d
  {
    private int a = 0;
    private String b = null;
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      AdTrackerWebViewLoader.a(new AtomicBoolean(false));
      AdTrackerWebViewLoader.a(new WebView(InternalSDKUtil.getContext()));
      AdTrackerWebViewLoader.a().setWebViewClient(new AdTrackerWebViewLoader.MyWebViewClient(AdTrackerWebViewLoader.this));
      AdTrackerWebViewLoader.a().getSettings().setJavaScriptEnabled(true);
      AdTrackerWebViewLoader.a().getSettings().setCacheMode(2);
      AdTrackerWebViewLoader.a().addJavascriptInterface(new AdTrackerWebViewLoader.JSInterface(), "iatsdk");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */