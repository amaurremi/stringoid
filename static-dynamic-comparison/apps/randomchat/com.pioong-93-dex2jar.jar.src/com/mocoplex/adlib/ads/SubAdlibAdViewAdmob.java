package com.mocoplex.adlib.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.mocoplex.adlib.SubAdlibAdViewCore;

public class SubAdlibAdViewAdmob
  extends SubAdlibAdViewCore
{
  protected AdView ad = new AdView((Activity)getContext(), AdSize.BANNER, "a14e9da97067aaa");
  protected boolean bGotAd = false;
  private AdRequest request = new AdRequest();
  
  public SubAdlibAdViewAdmob(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubAdlibAdViewAdmob(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setGravity(17);
    this.ad.setAdListener(new AdListener()
    {
      public void onDismissScreen(Ad paramAnonymousAd) {}
      
      public void onFailedToReceiveAd(Ad paramAnonymousAd, AdRequest.ErrorCode paramAnonymousErrorCode)
      {
        if (!SubAdlibAdViewAdmob.this.bGotAd) {
          SubAdlibAdViewAdmob.this.failed();
        }
      }
      
      public void onLeaveApplication(Ad paramAnonymousAd) {}
      
      public void onPresentScreen(Ad paramAnonymousAd) {}
      
      public void onReceiveAd(Ad paramAnonymousAd)
      {
        if (SubAdlibAdViewAdmob.this.bGotAd) {
          return;
        }
        SubAdlibAdViewAdmob.this.bGotAd = true;
        SubAdlibAdViewAdmob.this.gotAd();
      }
    });
    addView(this.ad);
  }
  
  public void clearAdView()
  {
    super.clearAdView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ad != null)
    {
      this.ad.destroy();
      this.ad = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void query()
  {
    this.bGotAd = false;
    this.ad.loadAd(this.request);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/ads/SubAdlibAdViewAdmob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */