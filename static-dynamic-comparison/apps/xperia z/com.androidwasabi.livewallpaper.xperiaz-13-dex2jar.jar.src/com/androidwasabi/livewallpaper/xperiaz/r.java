package com.androidwasabi.livewallpaper.xperiaz;

import android.preference.PreferenceCategory;
import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.AdItem;
import com.androidwasabi.ads.ImageLoader.OnImageCacheListener;
import com.androidwasabi.ads.PreferenceNewApp;
import java.util.ArrayList;

class r
  extends ImageLoader.OnImageCacheListener
{
  r(Settings paramSettings, ArrayList paramArrayList, PreferenceCategory paramPreferenceCategory) {}
  
  public void onImageCacheLoaded()
  {
    AdManager.AdItem localAdItem;
    if (this.b.size() == 1)
    {
      localAdItem = (AdManager.AdItem)this.b.get(0);
      this.c.addPreference(new PreferenceNewApp(this.a, localAdItem.name, localAdItem.description, AdManager.getAdImageFromCache(localAdItem.image), localAdItem.url, localAdItem.directlink));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < 2)
      {
        localAdItem = (AdManager.AdItem)this.b.get(i);
        this.c.addPreference(new PreferenceNewApp(this.a, localAdItem.name, localAdItem.description, AdManager.getAdImageFromCache(localAdItem.image), localAdItem.url, localAdItem.directlink));
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */