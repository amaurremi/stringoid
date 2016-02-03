package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.l;
import com.google.ads.n;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;

class c$c
  implements Runnable
{
  private final String b;
  private final String c;
  private final WebView d;
  
  public c$c(c paramc, WebView paramWebView, String paramString1, String paramString2)
  {
    this.d = paramWebView;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void run()
  {
    c.b(this.a).c.a(Boolean.valueOf(c.a(this.a)));
    ((d)((n)c.b(this.a).a.a()).b.a()).l().a(c.a(this.a));
    ActivationOverlay localActivationOverlay;
    if (((n)c.b(this.a).a.a()).e.a() != null)
    {
      localActivationOverlay = (ActivationOverlay)((n)c.b(this.a).a.a()).e.a();
      if (c.a(this.a)) {
        break label157;
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      localActivationOverlay.setOverlayEnabled(bool);
      if (this.c == null) {
        break;
      }
      this.d.loadDataWithBaseURL(this.b, this.c, "text/html", "utf-8", null);
      return;
    }
    this.d.loadUrl(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/c$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */