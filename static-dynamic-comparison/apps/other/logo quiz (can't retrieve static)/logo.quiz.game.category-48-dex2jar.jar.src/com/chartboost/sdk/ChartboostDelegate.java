package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract interface ChartboostDelegate
{
  public abstract void didCacheInterstitial(String paramString);
  
  public abstract void didCacheMoreApps();
  
  public abstract void didClickInterstitial(String paramString);
  
  public abstract void didClickMoreApps();
  
  public abstract void didCloseInterstitial(String paramString);
  
  public abstract void didCloseMoreApps();
  
  public abstract void didDismissInterstitial(String paramString);
  
  public abstract void didDismissMoreApps();
  
  public abstract void didFailToLoadInterstitial(String paramString, CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToLoadMoreApps(CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToRecordClick(String paramString, CBError.CBClickError paramCBClickError);
  
  public abstract void didShowInterstitial(String paramString);
  
  public abstract void didShowMoreApps();
  
  public abstract boolean shouldDisplayInterstitial(String paramString);
  
  public abstract boolean shouldDisplayLoadingViewForMoreApps();
  
  public abstract boolean shouldDisplayMoreApps();
  
  public abstract boolean shouldPauseClickForConfirmation(Chartboost.CBAgeGateConfirmation paramCBAgeGateConfirmation);
  
  public abstract boolean shouldRequestInterstitial(String paramString);
  
  public abstract boolean shouldRequestInterstitialsInFirstSession();
  
  public abstract boolean shouldRequestMoreApps();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/ChartboostDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */