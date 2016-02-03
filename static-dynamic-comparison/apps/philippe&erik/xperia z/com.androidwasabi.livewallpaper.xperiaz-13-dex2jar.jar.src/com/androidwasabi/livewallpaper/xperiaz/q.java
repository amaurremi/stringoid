package com.androidwasabi.livewallpaper.xperiaz;

import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.androidwasabi.ads.NewAppManager.AppItem;
import com.androidwasabi.ads.NewAppManager.OnNewAppListener;
import com.androidwasabi.ads.PreferenceNewApp;

class q
  extends NewAppManager.OnNewAppListener
{
  q(Settings paramSettings) {}
  
  public void loaded(NewAppManager.AppItem[] paramArrayOfAppItem)
  {
    if (paramArrayOfAppItem != null) {
      try
      {
        Object localObject = (PreferenceScreen)this.a.findPreference("settings");
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.a);
        localPreferenceCategory.setTitle(2131099729);
        localPreferenceCategory.setOrder(1);
        ((PreferenceScreen)localObject).addPreference(localPreferenceCategory);
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayOfAppItem.length) {
            return;
          }
          localObject = paramArrayOfAppItem[i];
          localPreferenceCategory.addPreference(new PreferenceNewApp(this.a, ((NewAppManager.AppItem)localObject).name, ((NewAppManager.AppItem)localObject).bitmap, ((NewAppManager.AppItem)localObject).url));
          i += 1;
        }
        return;
      }
      catch (Exception paramArrayOfAppItem) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */