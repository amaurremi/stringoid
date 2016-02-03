package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.util.b;

class CustomEventAdapter$a
  implements CustomEventBannerListener
{
  private View b;
  private final MediationBannerListener c;
  
  public CustomEventAdapter$a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
  {
    this.c = paramMediationBannerListener;
  }
  
  private String b()
  {
    return "Banner custom event labeled '" + CustomEventAdapter.a(this.a) + "'";
  }
  
  public View a()
  {
    try
    {
      View localView = this.b;
      return localView;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onClick()
  {
    b.a(b() + " called onClick().");
    this.c.onClick(this.a);
  }
  
  public void onDismissScreen()
  {
    b.a(b() + " called onDismissScreen().");
    this.c.onDismissScreen(this.a);
  }
  
  public void onFailedToReceiveAd()
  {
    b.a(b() + " called onFailedToReceiveAd().");
    this.c.onFailedToReceiveAd(this.a, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    try
    {
      b.a(b() + " called onLeaveApplication().");
      this.c.onLeaveApplication(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onPresentScreen()
  {
    b.a(b() + " called onPresentScreen().");
    this.c.onPresentScreen(this.a);
  }
  
  public void onReceivedAd(View paramView)
  {
    try
    {
      b.a(b() + " called onReceivedAd.");
      this.b = paramView;
      this.c.onReceivedAd(this.a);
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */