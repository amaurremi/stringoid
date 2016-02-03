package com.google.analytics.tracking.android;

class AdHitIdGenerator
{
  private boolean adMobSdkInstalled;
  
  AdHitIdGenerator()
  {
    try
    {
      if (Class.forName("com.google.ads.AdRequest") != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.adMobSdkInstalled = bool;
        return;
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      this.adMobSdkInstalled = false;
    }
  }
  
  AdHitIdGenerator(boolean paramBoolean)
  {
    this.adMobSdkInstalled = paramBoolean;
  }
  
  int getAdHitId()
  {
    if (!this.adMobSdkInstalled) {
      return 0;
    }
    return AdMobInfo.getInstance().generateAdHitId();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/AdHitIdGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */