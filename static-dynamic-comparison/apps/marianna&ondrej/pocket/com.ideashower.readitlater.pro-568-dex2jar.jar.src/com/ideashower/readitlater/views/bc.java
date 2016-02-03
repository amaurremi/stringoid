package com.ideashower.readitlater.views;

import android.annotation.TargetApi;
import android.webkit.WebSettings;

@TargetApi(11)
public class bc
  extends ba
{
  public bc(BaseWebView paramBaseWebView)
  {
    super(paramBaseWebView);
    paramBaseWebView.getSettings().setEnableSmoothTransition(false);
    if (!paramBaseWebView.a()) {
      paramBaseWebView.setLayerType(1, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    WebSettings localWebSettings = this.a.getSettings();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWebSettings.setEnableSmoothTransition(paramBoolean);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */