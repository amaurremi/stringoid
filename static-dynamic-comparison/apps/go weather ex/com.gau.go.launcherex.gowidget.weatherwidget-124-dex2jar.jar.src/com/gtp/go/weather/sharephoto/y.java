package com.gtp.go.weather.sharephoto;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

class y
  extends WebChromeClient
{
  y(TermsAndPrivacyActivity paramTermsAndPrivacyActivity) {}
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt == 100)
    {
      TermsAndPrivacyActivity.a(this.a).setVisibility(8);
      TermsAndPrivacyActivity.b(this.a).setVisibility(8);
      return;
    }
    TermsAndPrivacyActivity.a(this.a).setText(paramInt + "%");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */