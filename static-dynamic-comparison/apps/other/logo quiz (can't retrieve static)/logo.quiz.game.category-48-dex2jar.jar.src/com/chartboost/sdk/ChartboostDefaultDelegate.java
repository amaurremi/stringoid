package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract class ChartboostDefaultDelegate
  implements ChartboostDelegate
{
  public void didCacheInterstitial(String paramString) {}
  
  public void didCacheMoreApps() {}
  
  public void didClickInterstitial(String paramString) {}
  
  public void didClickMoreApps() {}
  
  public void didCloseInterstitial(String paramString) {}
  
  public void didCloseMoreApps() {}
  
  public void didDismissInterstitial(String paramString) {}
  
  public void didDismissMoreApps() {}
  
  public void didFailToLoadInterstitial(String paramString, CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToLoadMoreApps(CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToRecordClick(String paramString, CBError.CBClickError paramCBClickError) {}
  
  public void didShowInterstitial(String paramString) {}
  
  public void didShowMoreApps() {}
  
  public boolean shouldDisplayInterstitial(String paramString)
  {
    return true;
  }
  
  public boolean shouldDisplayLoadingViewForMoreApps()
  {
    return true;
  }
  
  public boolean shouldDisplayMoreApps()
  {
    return true;
  }
  
  public boolean shouldPauseClickForConfirmation(Chartboost.CBAgeGateConfirmation paramCBAgeGateConfirmation)
  {
    return false;
  }
  
  public boolean shouldRequestInterstitial(String paramString)
  {
    return true;
  }
  
  public boolean shouldRequestInterstitialsInFirstSession()
  {
    return true;
  }
  
  public boolean shouldRequestMoreApps()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/ChartboostDefaultDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */