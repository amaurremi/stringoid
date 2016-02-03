package com.google.ads.internal;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.n;
import com.google.ads.util.i.b;

class c$a
  implements Runnable
{
  private final d a;
  private final WebView b;
  private final f c;
  private final AdRequest.ErrorCode d;
  private final boolean e;
  
  public c$a(d paramd, WebView paramWebView, f paramf, AdRequest.ErrorCode paramErrorCode, boolean paramBoolean)
  {
    this.a = paramd;
    this.b = paramWebView;
    this.c = paramf;
    this.d = paramErrorCode;
    this.e = paramBoolean;
  }
  
  public void run()
  {
    if (this.b != null)
    {
      this.b.stopLoading();
      this.b.destroy();
    }
    if (this.c != null) {
      this.c.a();
    }
    if (this.e)
    {
      this.a.l().stopLoading();
      if (this.a.i().i.a() != null) {
        ((ViewGroup)this.a.i().i.a()).setVisibility(8);
      }
    }
    this.a.a(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */