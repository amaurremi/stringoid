package com.google.ads.internal;

import android.os.Handler;
import com.google.ads.m;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import java.lang.ref.WeakReference;

class AdVideoView$a
  implements Runnable
{
  private final WeakReference<AdVideoView> a;
  
  public AdVideoView$a(AdVideoView paramAdVideoView)
  {
    this.a = new WeakReference(paramAdVideoView);
  }
  
  public void a()
  {
    ((Handler)m.a().c.a()).postDelayed(this, 250L);
  }
  
  public void run()
  {
    AdVideoView localAdVideoView = (AdVideoView)this.a.get();
    if (localAdVideoView == null)
    {
      b.d("The video must be gone, so cancelling the timeupdate task.");
      return;
    }
    localAdVideoView.f();
    ((Handler)m.a().c.a()).postDelayed(this, 250L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/AdVideoView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */