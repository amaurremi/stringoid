package com.chartboost.sdk;

import android.app.NativeActivity;
import android.os.Bundle;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract class ChartboostNativeActivity
  extends NativeActivity
  implements ChartboostDelegate
{
  private Chartboost a;
  
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
  
  protected abstract String getChartboostAppID();
  
  protected abstract String getChartboostAppSignature();
  
  public void onBackPressed()
  {
    if (this.a.onBackPressed()) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Chartboost.sharedChartboost();
    CBPreferences.getInstance().setImpressionsUseActivities(true);
    paramBundle = getChartboostAppID();
    String str = getChartboostAppSignature();
    this.a.onCreate(this, paramBundle, str, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.onDestroy(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.onStart(this);
    this.a.startSession();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.a.onStop(this);
  }
  
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/ChartboostNativeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */