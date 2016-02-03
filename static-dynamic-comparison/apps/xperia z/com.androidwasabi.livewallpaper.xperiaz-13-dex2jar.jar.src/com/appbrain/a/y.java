package com.appbrain.a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class y
  extends WebChromeClient
{
  y(x paramx) {}
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramJsResult.confirm();
    return true;
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((paramInt > 20) && (x.d(this.a).getVisibility() != 8)) {
      x.d(this.a).setVisibility(8);
    }
    ProgressDialog localProgressDialog;
    if ((paramInt > 20) && (x.e(this.a).isShowing()))
    {
      localProgressDialog = x.e(this.a);
      if (localProgressDialog != null)
      {
        boolean bool = true;
        if ((localProgressDialog instanceof Dialog)) {
          bool = ((Dialog)localProgressDialog).isShowing();
        }
        if (!bool) {}
      }
    }
    try
    {
      localProgressDialog.dismiss();
      super.onProgressChanged(paramWebView, paramInt);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */