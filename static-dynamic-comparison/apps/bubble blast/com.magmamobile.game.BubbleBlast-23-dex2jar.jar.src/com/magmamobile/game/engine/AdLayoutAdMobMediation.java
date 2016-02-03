package com.magmamobile.game.engine;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.widget.LinearLayout.LayoutParams;
import com.adwhirl.AdWhirlUtils;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.Date;

final class AdLayoutAdMobMediation
  extends AdLayout
{
  private String adBannerId;
  private AdView adView;
  private Date birthday;
  private AdRequest.Gender gender;
  private Location location;
  private LinearLayout.LayoutParams params;
  private Runnable pending;
  private long rotateTime;
  
  public AdLayoutAdMobMediation(Context paramContext, AdType paramAdType, String paramString)
  {
    super(paramContext);
    setBackgroundColor(0);
    setGravity(49);
    this.rotateTime = Game.getParameters().ADMOB_MEDIATION_REFRESH_TIME;
    this.adType = paramAdType;
    this.adBannerId = paramString;
    if (paramAdType == AdType.BANNER)
    {
      this.theoricalWidth = 320;
      this.theoricalHeight = 50;
      this.params = new LinearLayout.LayoutParams(-2, -2);
      this.adView = new AdView((Activity)getContext(), AdSize.BANNER, this.adBannerId);
    }
    for (;;)
    {
      if (this.adView != null)
      {
        this.adView.setVisibility(0);
        Game.setLayerTypeSofware(this.adView);
        addView(this.adView, this.params);
      }
      return;
      if (paramAdType == AdType.SQUARE)
      {
        this.theoricalWidth = 300;
        this.theoricalHeight = 250;
        this.params = new LinearLayout.LayoutParams(-2, -2);
        this.adView = new AdView((Activity)getContext(), AdSize.IAB_MRECT, this.adBannerId);
      }
    }
  }
  
  private void cancelPendingRequest()
  {
    if (this.pending != null)
    {
      Game.getHandler().removeCallbacks(this.pending);
      this.pending = null;
    }
  }
  
  private void deleteAllView()
  {
    cancelPendingRequest();
    if (this.adView == null) {
      return;
    }
    AdView localAdView = AdWhirlUtils.findAdView(this.adView);
    if (localAdView != null) {
      AdWhirlUtils.killAdsenseAndAdmobWebViewOnDestroy(localAdView);
    }
    removeAllViews();
  }
  
  private void loadAds()
  {
    if ((this.adView != null) && (this.visible))
    {
      deleteAllView();
      AdRequest localAdRequest = new AdRequest();
      this.adView.loadAd(localAdRequest);
      Game.setLayerTypeSofware(this.adView);
      addView(this.adView, this.params);
    }
  }
  
  private void rotateAds()
  {
    cancelPendingRequest();
    if (this.rotateTime == 0L)
    {
      loadAds();
      return;
    }
    loadAds();
    this.pending = new Runnable()
    {
      public void run()
      {
        try
        {
          AdLayoutAdMobMediation.this.rotateAds();
          return;
        }
        catch (Exception localException) {}
      }
    };
    Game.getHandler().postDelayed(this.pending, this.rotateTime);
  }
  
  public Date getRequestBirthday()
  {
    return this.birthday;
  }
  
  public AdRequest.Gender getRequestGender()
  {
    return this.gender;
  }
  
  public Location getRequestLocation()
  {
    return this.location;
  }
  
  public void onDestroy()
  {
    deleteAllView();
    this.adView.destroy();
  }
  
  public void onPause()
  {
    deleteAllView();
  }
  
  public void onResume()
  {
    rotateAds();
  }
  
  protected void onShowCallback()
  {
    super.onShowCallback();
    rotateAds();
  }
  
  public void setRequestBirthday(Date paramDate)
  {
    this.birthday = paramDate;
  }
  
  public void setRequestGender(AdRequest.Gender paramGender)
  {
    this.gender = paramGender;
  }
  
  public void setRequestLocation(Location paramLocation)
  {
    this.location = paramLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdLayoutAdMobMediation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */