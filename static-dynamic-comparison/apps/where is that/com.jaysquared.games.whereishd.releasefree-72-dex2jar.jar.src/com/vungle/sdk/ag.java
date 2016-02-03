package com.vungle.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
abstract class ag
  extends v
{
  protected WebView b;
  protected View c;
  protected Object d = null;
  
  public ag(Context paramContext, String paramString, Object paramObject)
    throws v.a
  {
    if ((paramString == null) || (paramString.length() == 0) || ((!paramString.endsWith(".html")) && (!paramString.endsWith(".htm")))) {
      throw new v.a(this);
    }
    this.d = paramObject;
    a(paramContext);
    paramObject = this.b;
    WebSettings localWebSettings = ((WebView)paramObject).getSettings();
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setSavePassword(true);
    localWebSettings.setSaveFormData(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setLoadsImagesAutomatically(true);
    ((WebView)paramObject).setBackgroundColor(0);
    ((WebView)paramObject).setBackgroundResource(0);
    ((WebView)paramObject).setWebChromeClient(d());
    ((WebView)paramObject).setWebViewClient(new b());
    ((Activity)paramContext).setRequestedOrientation(-1);
    this.b.loadUrl(paramString);
  }
  
  public final View a()
  {
    return this.c;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  protected abstract a d();
  
  protected abstract void e();
  
  public abstract class a
    extends WebChromeClient
  {
    public a() {}
    
    public abstract boolean a(String paramString1, String paramString2);
    
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (!paramString2.startsWith("showToast")) {
        return false;
      }
      for (paramWebView = paramString2.substring(9);; paramWebView = null)
      {
        try
        {
          paramString1 = new JSONObject(paramWebView);
          paramWebView = paramString1.getJSONArray("params");
          if (!paramString1.getString("method").equalsIgnoreCase("showToast"))
          {
            paramJsPromptResult.confirm(null);
            return true;
          }
          if (ag.this.d == null)
          {
            paramJsPromptResult.confirm(null);
            return true;
          }
          paramString1 = paramWebView.getString(0).trim().toLowerCase();
          if (paramWebView.length() <= 1) {
            continue;
          }
          paramWebView = paramWebView.getString(1);
          a(paramString1, paramWebView);
        }
        catch (JSONException paramWebView)
        {
          for (;;)
          {
            av.a("JsPrompt", "Callback executed with a bad JSON format.", paramWebView);
          }
        }
        paramJsPromptResult.confirm("{\"result\":0}");
        return true;
      }
    }
  }
  
  public final class b
    extends WebViewClient
  {
    public b() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      if (paramString.toLowerCase().startsWith("javascript:")) {
        return;
      }
      paramWebView = "javascript:function actionClicked(t,u){ var r = prompt('showToast'+JSON.stringify({method:'showToast',params:(u?[t,u]:[t])}));if(r&&typeof r === 'string'){return JSON.parse(r).result;}}; function noTapHighlight() { var l=document.getElementsByTagName('*');for(var i=0; i<l.length; i++) {l[i].style.webkitTapHighlightColor='rgba(0,0,0,0)';}};noTapHighlight();";
      paramString = ba.b(ak.e());
      if (paramString != null) {
        paramWebView = "javascript:function actionClicked(t,u){ var r = prompt('showToast'+JSON.stringify({method:'showToast',params:(u?[t,u]:[t])}));if(r&&typeof r === 'string'){return JSON.parse(r).result;}}; function noTapHighlight() { var l=document.getElementsByTagName('*');for(var i=0; i<l.length; i++) {l[i].style.webkitTapHighlightColor='rgba(0,0,0,0)';}};noTapHighlight();" + "var _device_id = \"" + paramString.replace("\"", "\\\"") + "\";";
      }
      ag.this.b.loadUrl(paramWebView);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      Log.e("StageWeb", "Failed with Error " + paramInt + ": " + paramString1);
      ag.this.e();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */