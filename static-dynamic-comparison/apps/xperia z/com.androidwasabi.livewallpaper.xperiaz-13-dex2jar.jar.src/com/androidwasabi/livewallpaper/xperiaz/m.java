package com.androidwasabi.livewallpaper.xperiaz;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;

class m
  implements Preference.OnPreferenceClickListener
{
  m(Settings paramSettings) {}
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = new Intent("android.intent.action.SEND");
    paramPreference.setType("text/plain");
    paramPreference.putExtra("android.intent.extra.SUBJECT", this.a.getString(2131099793));
    paramPreference.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.xperiaz");
    try
    {
      this.a.startActivity(Intent.createChooser(paramPreference, this.a.getString(2131099772)));
      return true;
    }
    catch (ActivityNotFoundException paramPreference)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */