package com.google.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

final class at$1
  implements Runnable
{
  at$1(Context paramContext) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.getApplicationContext()).edit();
    localEditor.putString("drt", "");
    localEditor.putLong("drt_ts", 0L);
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/at$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */