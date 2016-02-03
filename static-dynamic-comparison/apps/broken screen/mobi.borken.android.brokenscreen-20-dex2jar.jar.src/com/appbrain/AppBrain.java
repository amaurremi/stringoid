package com.appbrain;

import android.content.Context;
import com.appbrain.a.aa;
import com.appbrain.a.cz;
import com.appbrain.a.h;

public class AppBrain
{
  private static void a()
  {
    if (!cz.a().b()) {
      throw new IllegalStateException("Please call AppBrain.init(context) in the onCreate of your Activity, or AppBrain.initApp() in the onCreate of your Application or Service or as the first thing in a BroadcastReceiver");
    }
  }
  
  public static void addTestDevice(String paramString)
  {
    aa.a().a(paramString);
  }
  
  public static AdService getAds()
  {
    a();
    return cz.a();
  }
  
  public static AdvertiserService getAdvertiserService()
  {
    a();
    return h.a();
  }
  
  public static RemoteSettings getSettings()
  {
    a();
    return aa.a().k();
  }
  
  public static void init(Context paramContext)
  {
    cz.a().a(paramContext, true);
  }
  
  public static void initApp(Context paramContext)
  {
    cz.a().a(paramContext, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AppBrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */