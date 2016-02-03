package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.l;
import com.google.ads.n;
import com.google.ads.util.i.b;

class c$2
  implements Runnable
{
  c$2(c paramc, com.google.ads.c paramc1) {}
  
  public void run()
  {
    if (c.d(this.b) != null)
    {
      c.d(this.b).stopLoading();
      c.d(this.b).destroy();
    }
    ((d)((n)c.b(this.b).a.a()).b.a()).a(c.e(this.b));
    if (c.f(this.b) != null) {
      ((h)((n)c.b(this.b).a.a()).g.a()).b(c.f(this.b));
    }
    ((d)((n)c.b(this.b).a.a()).b.a()).a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/c$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */