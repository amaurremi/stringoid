package com.mopub.mobileads.util;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.lang.reflect.Method;

public class WebViews
{
  private static final String LOGTAG = "MoPub - WebViewsUtil";
  
  public static void onPause(WebView paramWebView)
  {
    try
    {
      WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public static void onResume(WebView paramWebView)
  {
    try
    {
      WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public static void setDisableJSChromeClient(WebView paramWebView)
  {
    paramWebView.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        Log.d("MoPub - WebViewsUtil", paramAnonymousString2);
        return true;
      }
      
      public boolean onJsBeforeUnload(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        Log.d("MoPub - WebViewsUtil", paramAnonymousString2);
        return true;
      }
      
      public boolean onJsConfirm(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        Log.d("MoPub - WebViewsUtil", paramAnonymousString2);
        return true;
      }
      
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        Log.d("MoPub - WebViewsUtil", paramAnonymousString2);
        return true;
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/WebViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */