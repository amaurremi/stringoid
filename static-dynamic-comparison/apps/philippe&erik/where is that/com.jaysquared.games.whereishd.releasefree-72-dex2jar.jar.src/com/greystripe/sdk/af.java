package com.greystripe.sdk;

import android.graphics.Bitmap;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class af
  extends WebViewClient
{
  private GSAdErrorCode b = null;
  private boolean c = false;
  private boolean d = false;
  
  private af(aa paramaa) {}
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    bd.b("onLoadResource(): " + paramString, new Object[0]);
    if (!paramString.equals(aa.f(this.a))) {
      this.c = true;
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    bd.b("onPageFinished()", new Object[0]);
    this.d = false;
    this.a.a();
    aa.d(this.a);
    CookieSyncManager.getInstance().sync();
    if (aa.e(this.a))
    {
      bd.b("Page finished loading, but ad timed out.", new Object[0]);
      return;
    }
    if ((this.b == null) && (this.c)) {
      bd.b("Page finished with no errors, and fetched at least one resource.", new Object[0]);
    }
    for (;;)
    {
      this.a.b("if(typeof gsTimeout == 'undefined') { var gsTimeout = -1; } if(typeof gsStatus != 'undefined') { ResponseStatus.setResponseStatusAndTimeout(gsStatus, gsTimeout); } else { ResponseStatus.setResponseStatusAndTimeout(-1, gsTimeout); }");
      return;
      if (this.b == null)
      {
        bd.b("Page finished with no errors, but fetched no resources. Ad may be 100% embedded Javscript?", new Object[0]);
      }
      else
      {
        bd.b("Page finished with an error.", new Object[0]);
        aa.a(this.a).a(this.b);
      }
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    bd.b("Page started: " + paramWebView.toString() + " " + paramString, new Object[0]);
    aa.c(this.a);
    if (!this.d)
    {
      this.d = true;
      this.b = null;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    bd.e("ERROR: " + paramInt + " " + paramString1 + " on url " + paramString2, new Object[0]);
    this.b = GSAdErrorCode.SERVER_ERROR;
    try
    {
      paramWebView.stopLoading();
    }
    catch (Exception paramString1)
    {
      try
      {
        for (;;)
        {
          paramWebView.clearView();
          this.c = false;
          return;
          paramString1 = paramString1;
        }
      }
      catch (Exception paramWebView)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */