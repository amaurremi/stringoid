package com.mocoplex.adlib.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.mocoplex.adlib.SubAdlibAdViewCore;
import com.skplanet.tad.AdListener;
import com.skplanet.tad.AdListener.ErrorCode;
import com.skplanet.tad.AdView;
import com.skplanet.tad.AdView.AnimationType;
import java.util.Timer;
import java.util.TimerTask;

public class SubAdlibAdViewTAD
  extends SubAdlibAdViewCore
{
  protected AdView ad = null;
  protected boolean bGotAd = false;
  
  public SubAdlibAdViewTAD(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubAdlibAdViewTAD(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setGravity(17);
  }
  
  public void clearAdView()
  {
    super.clearAdView();
    if (this.ad != null)
    {
      removeView(this.ad);
      this.ad.destroyAd();
      this.ad = null;
      this.bGotAd = false;
    }
  }
  
  public void initTadView()
  {
    this.ad = new AdView(getContext());
    this.ad.setClientId("AX0000596");
    this.ad.setSlotNo(2);
    this.ad.setAnimationType(AdView.AnimationType.NONE);
    this.ad.setRefreshInterval(20L);
    this.ad.setUseBackFill(true);
    this.ad.setTestMode(false);
    this.ad.setListener(new AdListener()
    {
      public void onAdClicked() {}
      
      public void onAdExpandClosed() {}
      
      public void onAdExpanded() {}
      
      public void onAdFailed(AdListener.ErrorCode paramAnonymousErrorCode)
      {
        SubAdlibAdViewTAD.this.failed();
      }
      
      public void onAdLoaded() {}
      
      public void onAdReceived()
      {
        SubAdlibAdViewTAD.this.bGotAd = true;
      }
      
      public void onAdResizeClosed() {}
      
      public void onAdResized() {}
      
      public void onAdWillLoad() {}
      
      public void onAdWillReceive() {}
    });
    addView(this.ad);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ad != null)
    {
      this.ad.destroyAd();
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
    gotAd();
    if (this.ad == null) {
      initTadView();
    }
    this.ad.startAd();
    if (!this.bGotAd)
    {
      TimerTask local2 = new TimerTask()
      {
        public void run()
        {
          if (SubAdlibAdViewTAD.this.bGotAd) {
            return;
          }
          SubAdlibAdViewTAD.this.failed();
        }
      };
      new Timer().schedule(local2, 3000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/ads/SubAdlibAdViewTAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */