package com.androidwasabi.livewallpaper.xperiaz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.Window;
import android.webkit.WebViewDatabase;
import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.AdItem;
import com.androidwasabi.ads.ImageLoader;
import com.androidwasabi.ads.NewAppManager;
import com.appbrain.d;
import com.appbrain.e;
import com.google.ads.AdRequest;
import com.google.ads.AdView;
import java.util.ArrayList;

public class Settings
  extends PreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  boolean a = false;
  
  private void a()
  {
    e.a(this);
    if (WebViewDatabase.getInstance(this) != null)
    {
      AdView localAdView = (AdView)findViewById(2131296257);
      AdRequest localAdRequest = new AdRequest();
      localAdRequest.addTestDevice("CF4A70D1C5BE6A662EB6FB0D055C871C");
      localAdRequest.addTestDevice("FBE1F6D6AF7F9E4D0CF767DDCA5F8742");
      localAdRequest.addTestDevice("ECFBB1F1A14F7D3E3EC29DA3EE6C4E0A");
      localAdRequest.addTestDevice("7CD2B9DD1AA9996F17E605715828F699");
      localAdRequest.addTestDevice("637F0DF1F2BD166CF052061DE1409340");
      localAdRequest.addTestDevice("35CED9A0A8306835A874A38ADE57B8E1");
      localAdView.loadAd(localAdRequest);
    }
    AdManager.init(this);
    AdManager.setListener(new o(this));
    AdManager.loadAd(50);
    findPreference("free_apps").setOnPreferenceClickListener(new p(this));
  }
  
  private void b()
  {
    NewAppManager.setListener(new q(this));
    NewAppManager.load(this, 100);
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = AdManager.getAdList();
        if (localArrayList != null)
        {
          Object localObject = (PreferenceScreen)findPreference("settings");
          PreferenceCategory localPreferenceCategory = new PreferenceCategory(this);
          localPreferenceCategory.setTitle(2131099729);
          localPreferenceCategory.setOrder(1);
          ((PreferenceScreen)localObject).addPreference(localPreferenceCategory);
          localObject = AdManager.getImageLoader();
          if (localArrayList.size() == 1)
          {
            i = 1;
            String[] arrayOfString = new String[i];
            int j = 0;
            if (j >= i)
            {
              ((ImageLoader)localObject).saveImageCache(arrayOfString);
              ((ImageLoader)localObject).setCacheListener(new r(this, localArrayList, localPreferenceCategory));
              return;
            }
            arrayOfString[j] = ((AdManager.AdItem)localArrayList.get(j)).image;
            j += 1;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException) {}
      int i = 2;
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.a) && (!AdManager.maybeShowAdActivity(this)) && (AdManager.hasPlayStore())) {
      e.a().a(this);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    getPreferenceManager().setSharedPreferencesName("settings");
    addPreferencesFromResource(2130968576);
    setContentView(2130903044);
    getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    ((PreferenceScreen)findPreference("share_app")).setOnPreferenceClickListener(new m(this));
    ((PreferenceScreen)findPreference("app_wall")).setOnPreferenceClickListener(new n(this));
    a();
  }
  
  protected void onDestroy()
  {
    getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    super.onDestroy();
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */