package com.google.android.apps.analytics;

public class AdHitIdGenerator
{
  private boolean adMobSdkInstalled;
  
  public AdHitIdGenerator()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/AdHitIdGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */