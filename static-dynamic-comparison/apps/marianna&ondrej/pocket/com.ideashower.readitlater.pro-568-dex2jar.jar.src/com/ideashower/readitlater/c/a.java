package com.ideashower.readitlater.c;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ideashower.readitlater.views.BaseWebView;

public class a
  extends WebChromeClient
{
  private final BaseWebView a;
  
  public a(BaseWebView paramBaseWebView)
  {
    this.a = paramBaseWebView;
  }
  
  public boolean a(String paramString, JsResult paramJsResult)
  {
    return true;
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return true;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(paramString2, paramJsPromptResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */