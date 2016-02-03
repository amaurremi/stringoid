package com.flurry.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class bz
  extends WebViewClient
{
  private bz(bn parambn, byte paramByte) {}
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    new StringBuilder().append("onLoadResource: url = ").append(paramString).toString();
    super.onLoadResource(paramWebView, paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != bn.b(this.dW))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString.equalsIgnoreCase(bn.b(this.dW).getUrl())) {
            bn.c(this.dW);
          }
        } while (bn.d(this.dW));
        paramWebView = Uri.parse(paramString).getLastPathSegment();
      } while ((paramWebView == null) || (!paramWebView.equalsIgnoreCase("mraid.js")));
      bn.a(this.dW, true);
    } while (!bn.e(this.dW));
    bn.f(this.dW);
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    new StringBuilder().append("onPageFinished: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != bn.b(this.dW))) {}
    do
    {
      return;
      bn.c(this.dW);
      bn.h(this.dW);
      if ((!this.dW.a(bn.b(this.dW))) && ((this.dW.ad() == 2) || (this.dW.ad() == 1))) {
        this.dW.addView(bn.b(this.dW));
      }
      bn.b(this.dW, true);
    } while (!bn.d(this.dW));
    bn.f(this.dW);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    new StringBuilder().append("onPageStarted: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != bn.b(this.dW))) {
      return;
    }
    bn.g(this.dW);
    bn.b(this.dW, false);
    bn.a(this.dW, false);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.dW.a("renderFailed", Collections.emptyMap(), this.dW.M, this.dW.L, this.dW.N, 0);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    new StringBuilder().append("shouldOverrideUrlLoading: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != bn.b(this.dW))) {
      return false;
    }
    Object localObject = Uri.parse(paramString);
    if ((((Uri)localObject).getScheme() != null) && (((Uri)localObject).getScheme().equals("flurry")))
    {
      paramWebView = ((Uri)localObject).getQueryParameter("event");
      if (paramWebView != null)
      {
        bn.i(this.dW).add(paramWebView);
        paramString = bd.t(((Uri)localObject).getEncodedQuery());
        if (!paramString.containsKey("guid")) {
          break label173;
        }
        localObject = bn.a(this.dW, (String)paramString.get("guid"));
        cz localcz = bn.b(this.dW, (String)paramString.get("guid"));
        if ((localObject != null) && (localcz != null)) {
          this.dW.a(paramWebView, paramString, (AdUnit)localObject, localcz, 0, 0);
        }
      }
      for (;;)
      {
        return true;
        label173:
        this.dW.a(paramWebView, paramString, this.dW.M, this.dW.L, this.dW.N, 0);
      }
    }
    this.dW.a("clicked", Collections.emptyMap());
    if (this.dW.ag()) {
      return false;
    }
    paramWebView = this.dW.M.getAdSpace().toString();
    localObject = new Intent(bn.j(this.dW), FlurryFullscreenTakeoverActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    if (!this.dW.K.a(bn.j(this.dW), (Intent)localObject, paramWebView))
    {
      db.d(bn.a(this.dW), "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
      this.dW.K.b(bn.j(this.dW), paramString, paramWebView);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */