package com.vungle.sdk;

import android.content.Context;
import com.vungle.publisher.AdConfig;
import com.vungle.publisher.Demographic;
import com.vungle.publisher.Demographic.Gender;
import com.vungle.publisher.EventListener;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.inject.Injector;

public final class VunglePub
{
  private static final com.vungle.publisher.VunglePub a = ;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  
  public static boolean displayAdvert()
  {
    boolean bool = isVideoAvailable();
    AdConfig localAdConfig = new AdConfig();
    localAdConfig.setBackButtonImmediatelyEnabled(c);
    a.playAd(localAdConfig);
    return bool;
  }
  
  public static boolean displayIncentivizedAdvert(String paramString, boolean paramBoolean)
  {
    paramBoolean = isVideoAvailable();
    paramString = new AdConfig();
    paramString.setBackButtonImmediatelyEnabled(d);
    a.playAd(paramString);
    return paramBoolean;
  }
  
  public static boolean displayIncentivizedAdvert(boolean paramBoolean)
  {
    return displayIncentivizedAdvert(null, paramBoolean);
  }
  
  public static boolean getSoundEnabled()
  {
    boolean bool = false;
    AdConfig localAdConfig = a.getGlobalAdConfig();
    if (localAdConfig != null) {
      bool = localAdConfig.isSoundEnabled();
    }
    return bool;
  }
  
  public static String getVersionString()
  {
    return "VungleDroid/3.0.7";
  }
  
  public static void init(Context paramContext, String paramString)
  {
    init(paramContext, paramString, 0, -1);
  }
  
  public static void init(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (!b)
    {
      Injector localInjector = Injector.getInstance();
      localInjector.a(VungleAdvert.class);
      localInjector.b(VungleIntentService.class);
    }
    a.init(paramContext, paramString);
    if (!b) {
      if (paramInt1 <= 0) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      paramContext = Gender.a(paramInt2);
      paramInt2 = j;
      if (paramContext != null) {
        paramInt2 = 1;
      }
      if ((i != 0) || (paramInt2 != 0))
      {
        paramString = a.getDemographic();
        if (i != 0) {
          paramString.setAge(Integer.valueOf(paramInt1));
        }
        if (paramInt2 != 0) {
          paramString.setGender(paramContext);
        }
        b = true;
      }
      return;
    }
  }
  
  public static boolean isVideoAvailable()
  {
    return isVideoAvailable(false);
  }
  
  public static boolean isVideoAvailable(boolean paramBoolean)
  {
    return a.isCachedAdAvailable();
  }
  
  public static void onPause()
  {
    a.onPause();
  }
  
  public static void onResume()
  {
    a.onResume();
  }
  
  public static void setAutoRotation(boolean paramBoolean)
  {
    AdConfig localAdConfig = a.getGlobalAdConfig();
    if (localAdConfig != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (Orientation localOrientation = Orientation.autoRotate;; localOrientation = Orientation.matchVideo)
    {
      localAdConfig.setOrientation(localOrientation);
      return;
    }
  }
  
  public static void setBackButtonEnabled(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void setEventListener(EventListener paramEventListener)
  {
    com.vungle.publisher.VunglePub localVunglePub = a;
    if (paramEventListener == null) {}
    for (paramEventListener = null;; paramEventListener = new a(paramEventListener))
    {
      localVunglePub.setEventListener(paramEventListener);
      return;
    }
  }
  
  public static void setIncentivizedBackButtonEnabled(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static void setSoundEnabled(boolean paramBoolean)
  {
    AdConfig localAdConfig = a.getGlobalAdConfig();
    if (localAdConfig != null) {
      localAdConfig.setSoundEnabled(paramBoolean);
    }
  }
  
  public static abstract interface EventListener
  {
    public abstract void onVungleAdEnd();
    
    public abstract void onVungleAdStart();
    
    public abstract void onVungleView(double paramDouble1, double paramDouble2);
  }
  
  public static final class Gender
  {
    public static final int FEMALE = 1;
    public static final int MALE = 0;
    public static final int UNKNOWN = -1;
    
    static Demographic.Gender a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return Demographic.Gender.female;
      }
      return Demographic.Gender.male;
    }
    
    public static String toString(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 1: 
        return "female";
      }
      return "male";
    }
  }
  
  static final class a
    implements EventListener
  {
    private VunglePub.EventListener a;
    
    a(VunglePub.EventListener paramEventListener)
    {
      this.a = paramEventListener;
    }
    
    public final void onAdEnd()
    {
      this.a.onVungleAdEnd();
    }
    
    public final void onAdStart()
    {
      this.a.onVungleAdStart();
    }
    
    public final void onAdUnavailable(String paramString) {}
    
    public final void onCachedAdAvailable() {}
    
    public final void onVideoView(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.a.onVungleView(paramInt1 / 1000.0D, paramInt2 / 1000.0D);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/sdk/VunglePub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */