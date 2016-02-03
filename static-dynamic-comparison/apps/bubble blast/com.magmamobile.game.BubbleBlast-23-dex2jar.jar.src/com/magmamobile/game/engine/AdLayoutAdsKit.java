package com.magmamobile.game.engine;

public final class AdLayoutAdsKit
  extends AdLayout
{
  private AdLayout ads;
  private AdProvider provider = AdProvider.NONE;
  
  public AdLayoutAdsKit(AdType paramAdType, String paramString1, String paramString2)
  {
    super(Game.getContext());
    this.adType = paramAdType;
    if (paramAdType == AdType.BANNER)
    {
      addRule(Game.getParameters().ADS_ALIGNEMENT);
      addRule(14);
    }
    if (Game.isDebuggable)
    {
      this.provider = AdProvider.DEBUG;
      this.ads = new AdLayoutDebug(getContext(), paramAdType);
    }
    for (;;)
    {
      if (this.ads != null)
      {
        this.theoricalWidth = this.ads.theoricalWidth;
        this.theoricalHeight = this.ads.theoricalHeight;
        this.ads.setVisibility(0);
        addView(this.ads);
      }
      return;
      if ((paramString1 != null) && (paramString2 != null))
      {
        if (Game.getAndroidSDKVersion() > 4)
        {
          this.provider = AdProvider.ADMOBMEDIATION;
          this.ads = new AdLayoutAdMobMediation(getContext(), paramAdType, paramString1);
        }
        else
        {
          this.provider = AdProvider.ADWHIRL;
          this.ads = new AdLayoutAdWhirl(getContext(), paramAdType, paramString2);
        }
      }
      else if (paramString1 != null)
      {
        this.provider = AdProvider.ADMOBMEDIATION;
        this.ads = new AdLayoutAdMobMediation(getContext(), paramAdType, paramString1);
      }
      else if (paramString2 != null)
      {
        this.provider = AdProvider.ADWHIRL;
        this.ads = new AdLayoutAdWhirl(getContext(), paramAdType, paramString2);
      }
    }
  }
  
  public AdLayout getAdLayout()
  {
    return this.ads;
  }
  
  public AdProvider getProvider()
  {
    return this.provider;
  }
  
  public void hide()
  {
    if (this.ads != null) {
      this.ads.visible = false;
    }
    super.hide();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.ads != null) {
      this.ads.onCreate();
    }
  }
  
  public void onDestroy()
  {
    if (this.ads != null) {
      this.ads.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onHideCallback()
  {
    super.onHideCallback();
    if (this.ads != null) {
      this.ads.onHideCallback();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.ads != null) {
      this.ads.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.ads != null) {
      this.ads.onResume();
    }
  }
  
  protected void onShowCallback()
  {
    GameLayout.LayoutParams localLayoutParams = (GameLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.setLeft(this.marginLeft);
      localLayoutParams.setTop(this.marginTop);
    }
    super.onShowCallback();
    if (this.ads != null) {
      this.ads.onShowCallback();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.ads != null) {
      this.ads.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.ads != null) {
      this.ads.onStop();
    }
  }
  
  public void show()
  {
    if (this.ads != null) {
      this.ads.visible = true;
    }
    super.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdLayoutAdsKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */