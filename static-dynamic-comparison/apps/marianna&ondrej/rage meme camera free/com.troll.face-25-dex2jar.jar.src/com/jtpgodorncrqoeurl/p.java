package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class p
  implements Runnable
{
  p(AdController paramAdController) {}
  
  public final void run()
  {
    if (AdController.l(this.a) != null) {}
    for (Object localObject = AdController.l(this.a);; localObject = this.a.a)
    {
      localObject = ((Context)localObject).getSharedPreferences("Preference", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("SD_IS_AUDIOTRACK_" + AdController.r(this.a), true);
      ((SharedPreferences.Editor)localObject).commit();
      this.a.loadAudioAd();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */