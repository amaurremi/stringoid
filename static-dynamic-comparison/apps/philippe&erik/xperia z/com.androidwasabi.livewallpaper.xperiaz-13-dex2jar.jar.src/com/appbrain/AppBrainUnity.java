package com.appbrain;

import android.app.Activity;
import cmn.Proguard.KeepMembers;
import com.appbrain.a.ao;

public class AppBrainUnity
  implements Proguard.KeepMembers
{
  public static void dontKillWhenDone()
  {
    ao.a().a(null);
  }
  
  public static void killWhenDone(Activity paramActivity)
  {
    ao.a().a(paramActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/AppBrainUnity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */