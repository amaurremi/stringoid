package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

public class AdColony
{
  boolean block = false;
  
  public static Activity activity()
  {
    return ADC.activity();
  }
  
  public static void addAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    if (ADC.ad_availability_listener_list.contains(paramAdColonyAdAvailabilityListener)) {
      return;
    }
    ADC.ad_availability_listener_list.add(paramAdColonyAdAvailabilityListener);
  }
  
  public static void addV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    if (ADC.v4vc_listener_list.contains(paramAdColonyV4VCListener)) {
      return;
    }
    ADC.v4vc_listener_list.add(paramAdColonyV4VCListener);
  }
  
  public static void cancelVideo()
  {
    if (ADC.current_video != null)
    {
      ADC.current_video.finish();
      ADC.end_card_finished_handler.notify_canceled();
    }
  }
  
  public static void configure(Activity paramActivity, String paramString1, String paramString2, String... paramVarArgs)
  {
    Handler localHandler = new Handler();
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        ADC.block = false;
      }
    };
    if ((!ADC.block) || (ADC.disable_block)) {
      if (!ADC.user_disabled) {}
    }
    for (;;)
    {
      return;
      if (paramString2 == null)
      {
        ADC.on_fatal_error("Null App ID - disabling AdColony.");
        return;
      }
      if (paramVarArgs == null)
      {
        ADC.on_fatal_error("Null Zone IDs array - disabling AdColony.");
        return;
      }
      if (paramVarArgs.length == 0)
      {
        ADC.on_fatal_error("No Zone IDs provided - disabling AdColony.");
        return;
      }
      ADC.initialize(paramActivity);
      ADC.controller.configure(paramString1, paramString2, paramVarArgs);
      ADC.initialized = true;
      ADC.block = true;
      localHandler.postDelayed(local1, 120000L);
      if (ADC.current_video == null) {
        ADC.show = true;
      }
      ADC.v4vc_listener_list.clear();
      ADC.ad_availability_listener_list.clear();
      ADC.ad_availability_map = new HashMap();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        ADC.ad_availability_map.put(paramVarArgs[i], Boolean.valueOf(false));
        i += 1;
      }
    }
  }
  
  public static void disable()
  {
    ADC.user_disabled = true;
  }
  
  public static void disableDECOverride()
  {
    ADC.force_dec_url = null;
  }
  
  public static String getCustomID()
  {
    return ADC.controller.configuration.custom_id;
  }
  
  public static String getDeviceID()
  {
    return ADC.controller.configuration.device_id;
  }
  
  public static void get_images(String paramString)
  {
    ADC.controller.configuration.prepare_video_ad(paramString);
  }
  
  public static boolean isTablet()
  {
    return ADCDevice.is_tablet();
  }
  
  public static boolean isZoneV4VC(String paramString)
  {
    if (ADC.controller == null) {}
    while ((ADC.controller.ad_manager == null) || (ADC.controller.ad_manager.app == null) || (ADC.controller.ad_manager.app.zones == null)) {
      return false;
    }
    return ADC.controller.ad_manager.is_zone_v4vc(paramString, false);
  }
  
  public static void pause() {}
  
  public static void removeAdAvailabilityListener(AdColonyAdAvailabilityListener paramAdColonyAdAvailabilityListener)
  {
    ADC.ad_availability_listener_list.remove(paramAdColonyAdAvailabilityListener);
  }
  
  public static void removeV4VCListener(AdColonyV4VCListener paramAdColonyV4VCListener)
  {
    ADC.v4vc_listener_list.remove(paramAdColonyV4VCListener);
  }
  
  public static void resume(Activity paramActivity)
  {
    ADC.set_activity(paramActivity);
  }
  
  public static void setCustomID(String paramString)
  {
    if (!paramString.equals(ADC.controller.configuration.custom_id))
    {
      ADC.controller.configuration.custom_id = paramString;
      ADC.block = false;
      ADC.controller.ad_manager.attempted_load = true;
      ADC.controller.ad_manager.is_configured = false;
      ADC.controller.ad_manager.needs_refresh = true;
    }
  }
  
  public static void setDeviceID(String paramString)
  {
    if (!paramString.equals(ADC.controller.configuration.device_id))
    {
      ADC.controller.configuration.device_id = paramString;
      ADC.block = false;
      ADC.controller.ad_manager.attempted_load = true;
      ADC.controller.ad_manager.is_configured = false;
      ADC.controller.ad_manager.needs_refresh = true;
    }
  }
  
  public static String statusForZone(String paramString)
  {
    if ((ADC.controller == null) || (ADC.controller.ad_manager == null) || (ADC.controller.ad_manager.app == null) || (ADC.controller.ad_manager.app.zones == null)) {
      return "unknown";
    }
    ADCManifest.Zone localZone = ADC.controller.ad_manager.app.zones.find(paramString);
    if (localZone != null)
    {
      if (!localZone.enabled) {
        return "off";
      }
      if ((localZone.active) && (ADC.controller.ad_manager.is_ad_available_errorless(paramString, true))) {
        return "active";
      }
      return "loading";
    }
    if (!ADC.configured) {
      return "unknown";
    }
    return "invalid";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AdColony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */