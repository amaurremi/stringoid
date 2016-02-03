package com.inmobi.androidsdk.impl.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebviewLoader
{
  static boolean a = false;
  static AtomicBoolean b = null;
  private WebView c = null;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public WebviewLoader(final Context paramContext)
  {
    RequestResponseManager.b.post(new b(paramContext));
  }
  
  public void deinit(int paramInt)
  {
    RequestResponseManager.b.postDelayed(new c(), paramInt);
  }
  
  public void loadInWebview(final String paramString, final HashMap<String, String> paramHashMap)
  {
    RequestResponseManager.b.post(new a(paramString, paramHashMap));
  }
  
  public void stopLoading()
  {
    RequestResponseManager.b.post(new d());
  }
  
  protected static class MyWebViewClient
    extends WebViewClient
  {
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "On page Finished " + paramString);
      if (WebviewLoader.b.compareAndSet(true, false)) {
        RequestResponseManager.c.set(true);
      }
      synchronized (RequestResponseManager.a)
      {
        RequestResponseManager.a.notify();
        super.onPageFinished(paramWebView, paramString);
        return;
      }
    }
    
    public void onReceivedError(WebView arg1, int paramInt, String paramString1, String paramString2)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Processing click in webview error " + paramInt + " Failing url: " + paramString2 + "Error description " + paramString1);
      WebviewLoader.b.set(false);
      RequestResponseManager.c.set(false);
      super.onReceivedError(???, paramInt, paramString1, paramString2);
      synchronized (RequestResponseManager.a)
      {
        RequestResponseManager.a.notify();
        return;
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "SSL Error.Webview will proceed " + paramSslError);
      paramSslErrorHandler.proceed();
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Should override " + paramString);
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
  
  class a
    implements Runnable
  {
    a(String paramString, HashMap paramHashMap) {}
    
    public void run()
    {
      WebviewLoader.b.set(true);
      WebviewLoader.a(WebviewLoader.this).loadUrl(paramString, paramHashMap);
    }
  }
  
  class b
    implements Runnable
  {
    b(Context paramContext) {}
    
    public void run()
    {
      WebviewLoader.a(WebviewLoader.this, new WebView(paramContext));
      WebviewLoader.b = new AtomicBoolean(false);
      WebviewLoader.a(WebviewLoader.this).setWebViewClient(new WebviewLoader.MyWebViewClient());
      WebviewLoader.a(WebviewLoader.this).getSettings().setJavaScriptEnabled(true);
      WebviewLoader.a(WebviewLoader.this).getSettings().setPluginState(WebSettings.PluginState.ON);
      WebviewLoader.a(WebviewLoader.this).getSettings().setCacheMode(2);
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (WebviewLoader.a(WebviewLoader.this) != null)
      {
        WebviewLoader.a(WebviewLoader.this).stopLoading();
        WebviewLoader.a(WebviewLoader.this).destroy();
        WebviewLoader.a(WebviewLoader.this, null);
        WebviewLoader.b.set(false);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      if (WebviewLoader.a(WebviewLoader.this) != null) {
        WebviewLoader.b.set(false);
      }
      WebviewLoader.a(WebviewLoader.this).stopLoading();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/net/WebviewLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */