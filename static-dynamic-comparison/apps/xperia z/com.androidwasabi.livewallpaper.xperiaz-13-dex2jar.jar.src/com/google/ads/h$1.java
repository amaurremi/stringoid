package com.google.ads;

import com.google.ads.mediation.MediationAdapter;
import com.google.ads.util.a;
import com.google.ads.util.b;

class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public void run()
  {
    if (this.a.l()) {
      a.b(h.a(this.a));
    }
    try
    {
      h.a(this.a).destroy();
      b.a("Called destroy() for adapter with class: " + h.a(this.a).getClass().getName());
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("Error while destroying adapter (" + this.a.h() + "):", localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/h$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */