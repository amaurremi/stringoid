package com.google.ads;

import android.view.View;
import com.google.ads.internal.d;
import com.google.ads.util.b;

class e$8
  implements Runnable
{
  e$8(e parame, h paramh, View paramView, f paramf) {}
  
  public void run()
  {
    if (e.a(this.d, this.a))
    {
      b.a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
      return;
    }
    e.b(this.d).a(this.b, this.a, this.c, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/e$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */