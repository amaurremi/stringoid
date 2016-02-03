package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class e
  extends WebChromeClient
{
  e(MessageCenterWebView paramMessageCenterWebView) {}
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    MessageCenterWebView.f(this.a).post(new f(this, paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */