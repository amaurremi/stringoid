package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class MMWebViewClient
  extends WebViewClient
{
  private ExecutorService cachedExecutor = Executors.newCachedThreadPool();
  boolean isLastMMCommandResize;
  MMWebViewClientListener mmWebViewClientListener;
  HttpRedirection.RedirectionListenerImpl redirectListenerImpl;
  
  MMWebViewClient(MMWebViewClientListener paramMMWebViewClientListener, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl)
  {
    this.mmWebViewClientListener = paramMMWebViewClientListener;
    this.redirectListenerImpl = paramRedirectionListenerImpl;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    MMWebView localMMWebView = (MMWebView)paramWebView;
    if (!localMMWebView.isOriginalUrl(paramString))
    {
      this.mmWebViewClientListener.onPageFinished(paramString);
      MMSDK.Log.d("onPageFinished webview: " + localMMWebView.toString() + "url is " + paramString);
      localMMWebView.setAdProperties(this.redirectListenerImpl.getAdProperties());
      setMraidState(localMMWebView);
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    MMSDK.Log.d("onPageStarted: %s", new Object[] { paramString });
    this.mmWebViewClientListener.onPageStarted(paramString);
    MMWebView localMMWebView = (MMWebView)paramWebView;
    localMMWebView.mraidState = "loading";
    localMMWebView.requiresPreAdSizeFix = false;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    MMSDK.Log.e("Error: %s %s %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  abstract void setMraidState(MMWebView paramMMWebView);
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    MMWebView localMMWebView = (MMWebView)paramWebView;
    if (!localMMWebView.isOriginalUrl(paramString))
    {
      MMSDK.Log.v("@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is " + paramString + " for " + paramWebView);
      if (paramString.substring(0, 6).equalsIgnoreCase("mmsdk:"))
      {
        MMSDK.Log.v("Running JS bridge command: " + paramString);
        paramWebView = new MMCommand((MMWebView)paramWebView, paramString);
        this.isLastMMCommandResize = paramWebView.isResizeCommand();
        this.cachedExecutor.execute(paramWebView);
      }
    }
    else
    {
      return true;
    }
    if (this.redirectListenerImpl.isExpandingToUrl()) {
      return false;
    }
    this.redirectListenerImpl.url = paramString;
    this.redirectListenerImpl.weakContext = new WeakReference(paramWebView.getContext());
    this.redirectListenerImpl.creatorAdImplInternalId = localMMWebView.creatorAdImplId;
    HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
    return true;
  }
  
  static abstract class MMWebViewClientListener
  {
    void onPageFinished(String paramString) {}
    
    void onPageStarted(String paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/MMWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */