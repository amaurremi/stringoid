package com.magmamobile.game.engine;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlTargeting;
import com.adwhirl.adapters.AdWhirlAdapter;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

final class AdLayoutAdWhirl
  extends AdLayout
{
  private RelativeLayout ads;
  private LinearLayout.LayoutParams params;
  
  public AdLayoutAdWhirl(Context paramContext, AdType paramAdType, String paramString)
  {
    super(paramContext);
    this.adType = paramAdType;
    paramContext = Game.getParameters();
    float f = getResources().getDisplayMetrics().density;
    AdWhirlAdapter.setGoogleAdSenseCompanyName(paramContext.GGADS_COMPANY_NAME);
    AdWhirlAdapter.setGoogleAdSenseAppName(paramContext.GGADS_APP_NAME);
    AdWhirlAdapter.setGoogleAdSenseChannel(paramContext.GGADS_CHANNEL_ID);
    AdWhirlAdapter.setGoogleAdSenseExpandDirection(paramContext.GGADS_EXPAND_DIRECTION);
    AdWhirlTargeting.setKeywords(paramContext.GGADS_KEYWORDS);
    if (this.adType == AdType.BANNER)
    {
      this.theoricalWidth = 320;
      this.theoricalHeight = 50;
      if (paramContext.ADWHIRL_DIP_HEIGHT != 0) {
        break label224;
      }
    }
    label224:
    for (int i = -2;; i = (int)(paramContext.ADWHIRL_DIP_HEIGHT * f))
    {
      this.params = new LinearLayout.LayoutParams(-1, i);
      this.ads = new AdWhirlLayout((Activity)getContext(), paramString);
      if (this.adType == AdType.SQUARE)
      {
        this.theoricalWidth = 300;
        this.theoricalHeight = 250;
        this.params = new LinearLayout.LayoutParams(-2, -2);
        this.ads = new AdView((Activity)getContext(), AdSize.IAB_MRECT, paramString);
      }
      if (this.ads != null)
      {
        this.ads.setVisibility(0);
        Game.setLayerTypeSofware(this.ads);
        addView(this.ads, this.params);
      }
      return;
    }
  }
  
  private void sendRequest()
  {
    if ((this.ads != null) && (this.visible) && (this.adType == AdType.SQUARE)) {
      ((AdView)this.ads).loadAd(new AdRequest());
    }
  }
  
  public void killAdsenseAndAdmobWebViewOnDestroy()
  {
    if ((this.ads != null) && (this.adType == AdType.BANNER)) {
      ((AdWhirlLayout)this.ads).killAdsenseAndAdmobWebViewOnDestroy(null);
    }
  }
  
  public void onDestroy() {}
  
  public void onPause()
  {
    removeAllViews();
  }
  
  public void onResume()
  {
    if (this.ads != null)
    {
      removeAllViews();
      sendRequest();
      Game.setLayerTypeSofware(this.ads);
      addView(this.ads, this.params);
    }
  }
  
  protected void onShowCallback()
  {
    super.onShowCallback();
    sendRequest();
  }
  
  public void setVisibility(int paramInt)
  {
    try
    {
      super.setVisibility(paramInt);
      if ((this.ads != null) && (this.adType == AdType.BANNER)) {
        ((AdWhirlLayout)this.ads).onWindowVisibilityChanged2(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdLayoutAdWhirl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */