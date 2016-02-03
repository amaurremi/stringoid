package com.androidwasabi.livewallpaper.xperiaz;

import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.OnAdListener;
import com.appbrain.d;
import com.appbrain.e;
import java.util.Random;

class a
  extends AdManager.OnAdListener
{
  a(AppLauncher paramAppLauncher) {}
  
  public void adNotShowed()
  {
    this.a.a = false;
    AppLauncher.a(this.a);
  }
  
  public void adShowed()
  {
    this.a.a = true;
    if (new Random().nextInt(3) == 0)
    {
      if (AdManager.hasPlayStore())
      {
        AppLauncher.b(this.a);
        return;
      }
      AppLauncher.a(this.a);
      return;
    }
    AppLauncher.a(this.a);
  }
  
  public void adWallShowed()
  {
    this.a.a = true;
    if (new Random().nextInt(3) == 0)
    {
      if (AdManager.hasPlayStore())
      {
        AppLauncher.b(this.a);
        return;
      }
      AppLauncher.a(this.a);
      return;
    }
    AppLauncher.a(this.a);
  }
  
  public void failToLoad()
  {
    this.a.a = true;
    if (AdManager.hasPlayStore()) {
      e.a().b(this.a);
    }
  }
  
  public void loadThirdPartyAd()
  {
    this.a.a = true;
    if (AdManager.hasPlayStore()) {
      e.a().b(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */