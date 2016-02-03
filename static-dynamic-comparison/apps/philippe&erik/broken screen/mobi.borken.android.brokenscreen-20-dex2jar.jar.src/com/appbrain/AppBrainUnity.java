package com.appbrain;

import android.app.Activity;
import cmn.Proguard.KeepMembers;
import com.appbrain.a.cz;

public class AppBrainUnity
  implements Proguard.KeepMembers
{
  public static void dontKillWhenDone()
  {
    cz.a().a(null);
  }
  
  public static void killWhenDone(Activity paramActivity)
  {
    cz.a().a(paramActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AppBrainUnity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */