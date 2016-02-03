package com.bluebird.bubble.adserwer.tools.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class AppAd
  extends Ad
{
  public AppAd(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, Activity paramActivity)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString1, paramString2, paramActivity);
  }
  
  private String getPackageName()
  {
    int i = getAdUrl().indexOf('&');
    String str = getAdUrl();
    int j = getAdUrl().indexOf('=');
    if (i != -1) {}
    for (;;)
    {
      return str.substring(j + 1, i);
      i = getAdUrl().length();
    }
  }
  
  private boolean isPackageExists(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public boolean collectPrize()
  {
    boolean bool = false;
    if (isPackageExists(getPackageName(), this.activity)) {
      bool = super.collectPrize();
    }
    return bool;
  }
  
  public boolean isActive()
  {
    return (this.enable) && (!isCollected()) && (!isPackageExists(getPackageName(), this.activity));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/bubble/adserwer/tools/ads/AppAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */