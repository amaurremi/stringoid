package com.androidwasabi.livewallpaper.xperiaz;

import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.OnAdListener;
import com.appbrain.d;
import com.appbrain.e;
import java.util.Random;

class o
  extends AdManager.OnAdListener
{
  o(Settings paramSettings) {}
  
  public void adNotShowed()
  {
    this.a.a = false;
    Settings.a(this.a);
  }
  
  public void adShowed()
  {
    this.a.a = true;
    if (new Random().nextInt(2) == 0)
    {
      if (AdManager.hasPlayStore())
      {
        Settings.b(this.a);
        return;
      }
      Settings.a(this.a);
      return;
    }
    Settings.a(this.a);
  }
  
  public void adWallShowed()
  {
    this.a.a = true;
    if (new Random().nextInt(2) == 0)
    {
      if (AdManager.hasPlayStore())
      {
        Settings.b(this.a);
        return;
      }
      Settings.a(this.a);
      return;
    }
    Settings.a(this.a);
  }
  
  public void failToLoad()
  {
    this.a.a = true;
    if (AdManager.hasPlayStore())
    {
      Settings.b(this.a);
      e.a().b(this.a);
    }
  }
  
  public void loadThirdPartyAd()
  {
    this.a.a = true;
    if (AdManager.hasPlayStore())
    {
      Settings.b(this.a);
      e.a().b(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */