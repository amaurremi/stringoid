package com.androidwasabi.livewallpaper.xperiaz;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.androidwasabi.ads.AdManager;
import com.appbrain.d;
import com.appbrain.e;

class n
  implements Preference.OnPreferenceClickListener
{
  n(Settings paramSettings) {}
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    if ((!AdManager.showAdActivity(this.a)) && (AdManager.hasPlayStore())) {
      e.a().b(this.a);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */