package com.inmobi.androidsdk;

import android.graphics.Bitmap;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;

class g
  extends WebViewClient
{
  g(IMBrowserActivity paramIMBrowserActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (IMBrowserActivity.b(this.a) != null)
    {
      if (!paramWebView.canGoForward()) {
        break label53;
      }
      IMBrowserActivity.b(this.a).setSwitchInt(CustomView.SwitchIconType.FORWARD_ACTIVE);
      IMBrowserActivity.b(this.a).invalidate();
    }
    for (;;)
    {
      CookieSyncManager.getInstance().sync();
      return;
      label53:
      IMBrowserActivity.b(this.a).setSwitchInt(CustomView.SwitchIconType.FORWARD_INACTIVE);
      IMBrowserActivity.b(this.a).invalidate();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (IMBrowserActivity.b(this.a) != null)
    {
      IMBrowserActivity.b(this.a).setSwitchInt(CustomView.SwitchIconType.FORWARD_INACTIVE);
      IMBrowserActivity.b(this.a).invalidate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */