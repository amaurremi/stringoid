package com.appbrain;

import android.content.Context;
import com.appbrain.a.ao;

public class e
{
  public static d a()
  {
    b();
    return ao.a();
  }
  
  public static void a(Context paramContext)
  {
    ao.a().a(paramContext, true);
  }
  
  private static void b()
  {
    if (!ao.a().b()) {
      throw new IllegalStateException("Please call AppBrain.init(context) in the onCreate of your Activity, or AppBrain.initApp() in the onCreate of your Application or Service or as the first thing in a BroadcastReceiver");
    }
  }
  
  public static void b(Context paramContext)
  {
    ao.a().a(paramContext, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */