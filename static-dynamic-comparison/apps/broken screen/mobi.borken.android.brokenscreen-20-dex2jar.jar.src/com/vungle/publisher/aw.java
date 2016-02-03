package com.vungle.publisher;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;

public final class aw
  extends WebViewClient
{
  a a;
  
  public aw(a parama)
  {
    this.a = parama;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (paramString.toLowerCase().startsWith("javascript:")) {
      return;
    }
    paramString = ((bc)Injector.getInstance().a.a(AndroidDevice.class)).a();
    if (paramString != null) {}
    for (paramString = "javascript:function actionClicked(m,p){ var q = prompt('vungle:'+JSON.stringify({method:m,params:(p?p:null)}));if(q&&typeof q === 'string'){return JSON.parse(q).result;}};function noTapHighlight(){var l=document.getElementsByTagName('*');for(var i=0; i<l.length; i++){l[i].style.webkitTapHighlightColor='rgba(0,0,0,0)';}};noTapHighlight();" + "var _device_id = \"" + paramString.replace("\"", "\\\"") + "\";";; paramString = "javascript:function actionClicked(m,p){ var q = prompt('vungle:'+JSON.stringify({method:m,params:(p?p:null)}));if(q&&typeof q === 'string'){return JSON.parse(q).result;}};function noTapHighlight(){var l=document.getElementsByTagName('*');for(var i=0; i<l.length; i++){l[i].style.webkitTapHighlightColor='rgba(0,0,0,0)';}};noTapHighlight();")
    {
      paramWebView.loadUrl(paramString);
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Logger.e("VungleAd", "failed to load web view: code " + paramInt + ", " + paramString1);
    this.a.a();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */