package com.jirbo.adcolony;

import android.os.Handler;

class ADCAdManager
  implements ADCDownload.Listener
{
  ADCManifest.App app = new ADCManifest.App();
  boolean attempted_load;
  ADCController controller;
  boolean do_refresh = true;
  Handler h;
  boolean is_configured;
  boolean needs_refresh;
  double next_refresh_time;
  Runnable r;
  boolean try_refresh = false;
  
  ADCAdManager(ADCController paramADCController)
  {
    this.controller = paramADCController;
    this.h = new Handler();
    this.r = new Runnable()
    {
      public void run()
      {
        ADCAdManager.this.do_refresh = true;
        if (ADCAdManager.this.try_refresh) {
          ADCAdManager.this.refresh();
        }
      }
    };
  }
  
  void configure() {}
  
  String find_v4vc_zone()
  {
    Object localObject;
    if (!this.is_configured)
    {
      localObject = null;
      return (String)localObject;
    }
    String str = null;
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= this.app.zones.count()) {
        break;
      }
      localObject = this.app.zones.get(i);
      if (((ADCManifest.Zone)localObject).is_v4vc_zone())
      {
        str = ((ADCManifest.Zone)localObject).uuid;
        if (((ADCManifest.Zone)localObject).is_ad_available()) {
          return ((ADCManifest.Zone)localObject).uuid;
        }
      }
      i += 1;
    }
  }
  
  String find_video_zone()
  {
    Object localObject;
    if (!this.is_configured)
    {
      localObject = null;
      return (String)localObject;
    }
    String str = null;
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= this.app.zones.count()) {
        break;
      }
      localObject = this.app.zones.get(i);
      if (((ADCManifest.Zone)localObject).is_video_zone())
      {
        str = ((ADCManifest.Zone)localObject).uuid;
        if (((ADCManifest.Zone)localObject).is_ad_available()) {
          return ((ADCManifest.Zone)localObject).uuid;
        }
      }
      i += 1;
    }
  }
  
  boolean is_ad_available(String paramString)
  {
    return is_ad_available(paramString, false);
  }
  
  boolean is_ad_available(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return is_ad_available_errorless(paramString, paramBoolean);
    }
    if (!this.is_configured) {
      return ADCLog.info.fail("Ads are not ready to be played, as they are still downloading.");
    }
    if (paramBoolean) {
      return this.app.is_ad_available(paramString, true, false);
    }
    return this.app.is_ad_available(paramString, false, true);
  }
  
  boolean is_ad_available_errorless(String paramString, boolean paramBoolean)
  {
    if (!this.is_configured) {
      return false;
    }
    if (paramBoolean) {
      return this.app.is_ad_available(paramString, true, false);
    }
    return this.app.is_ad_available(paramString, false, true);
  }
  
  boolean is_zone_v4vc(String paramString)
  {
    return is_zone_v4vc(paramString, true);
  }
  
  boolean is_zone_v4vc(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.app.zones.count())
    {
      ADCManifest.Zone localZone = this.app.zones.get(i);
      if ((localZone.is_v4vc_zone(paramBoolean)) && (localZone.uuid.equals(paramString))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void load()
  {
    ADCLog.debug.println("Attempting to load backup manifest from file.");
    ADCDataFile localADCDataFile = new ADCDataFile("manifest.txt");
    ADCData.Table localTable = ADCJSON.load_Table(localADCDataFile);
    if (localTable != null)
    {
      if (parse_manifest(localTable))
      {
        this.is_configured = true;
        this.app.cache_media();
      }
    }
    else {
      return;
    }
    ADCLog.debug.println("Invalid manifest loaded.");
    localADCDataFile.delete();
    this.is_configured = false;
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    ADC.active = true;
    ADCData.Table localTable;
    if (paramADCDownload.success)
    {
      ADCLog.info.println("Finished downloading:");
      ADCLog.info.println(paramADCDownload.url);
      localTable = ADCJSON.parse_Table(paramADCDownload.data);
      if (localTable == null)
      {
        ADCLog.dev.println("Invalid JSON in manifest.  Raw data:");
        ADCLog.dev.println(paramADCDownload.data);
      }
    }
    else
    {
      ADCLog.info.println("Error downloading:");
      ADCLog.info.println(paramADCDownload.url);
      return;
    }
    if (parse_manifest(localTable))
    {
      ADCLog.debug.println("Ad manifest updated.");
      new ADCDataFile("manifest.txt").save(paramADCDownload.data);
      this.is_configured = true;
      this.app.cache_media();
      if ((this.app.view_network_pass_filter == null) || (this.app.view_network_pass_filter.equals(""))) {
        this.app.view_network_pass_filter = "all";
      }
      if ((this.app.cache_network_pass_filter == null) || (this.app.cache_network_pass_filter.equals(""))) {
        this.app.cache_network_pass_filter = "all";
      }
      ADC.has_ad_availability_changed();
      return;
    }
    ADCLog.debug.println("Invalid manifest.");
  }
  
  boolean parse_manifest(ADCData.Table paramTable)
  {
    if (paramTable == null) {}
    while ((!paramTable.get_String("status").equals("success")) || (!this.app.parse(paramTable.get_Table("app")))) {
      return false;
    }
    ADCLog.dev.println("Finished parsing manifest");
    if (!this.app.log_level.equalsIgnoreCase("none"))
    {
      ADCLog.info.println("Enabling debug logging.");
      ADC.set_log_level(1);
    }
    for (;;)
    {
      return true;
      ADC.set_log_level(2);
    }
  }
  
  void perform_refresh()
  {
    ADC.active = true;
    ADCLog.debug.println("Refreshing manifest");
    if (!ADCNetwork.connected())
    {
      ADCLog.debug.println("Not connected to network.");
      ADCLog.dev.print("attempted_load:").print(this.attempted_load).print(" is_configured:").println(this.is_configured);
      if (!this.attempted_load)
      {
        this.attempted_load = true;
        if (!this.is_configured) {
          load();
        }
      }
      return;
    }
    ADCStringBuilder localADCStringBuilder = new ADCStringBuilder();
    Object localObject = this.controller.configuration;
    localADCStringBuilder.print(ADCConfiguration.ad_manifest_url);
    localADCStringBuilder.print("?app_id=");
    localADCStringBuilder.print(this.controller.configuration.app_id);
    localADCStringBuilder.print("&zones=");
    if (this.controller.configuration.zone_ids != null)
    {
      int j = 1;
      localObject = this.controller.configuration.zone_ids;
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        String str = localObject[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          localADCStringBuilder.print(str);
          i += 1;
          break;
          localADCStringBuilder.print(",");
        }
      }
    }
    localADCStringBuilder.print(this.controller.configuration.info_string);
    localADCStringBuilder.print("&carrier=");
    localADCStringBuilder.print(ADCNetwork.url_encoded(this.controller.configuration.carrier_name));
    localADCStringBuilder.print("&network_type=");
    if (ADCNetwork.using_wifi()) {
      localADCStringBuilder.print("wifi");
    }
    for (;;)
    {
      localADCStringBuilder.print("&custom_id=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.controller.configuration.custom_id));
      ADCLog.debug.println("Downloading ad manifest from");
      ADCLog.debug.println(localADCStringBuilder);
      new ADCDownload(this.controller, localADCStringBuilder.toString(), this).start();
      return;
      if (ADCNetwork.using_mobile()) {
        localADCStringBuilder.print("cell");
      } else {
        localADCStringBuilder.print("none");
      }
    }
  }
  
  void refresh()
  {
    if ((this.do_refresh) || (ADC.disable_block))
    {
      this.do_refresh = false;
      this.needs_refresh = true;
      this.try_refresh = false;
      this.h.postDelayed(this.r, 60000L);
      return;
    }
    this.try_refresh = true;
  }
  
  void update()
  {
    if (ADCUtil.current_time() >= this.next_refresh_time) {
      this.needs_refresh = true;
    }
    if (this.needs_refresh)
    {
      this.needs_refresh = false;
      if (ADCDevice.memory_class() >= 32)
      {
        this.next_refresh_time = (ADCUtil.current_time() + 600.0D);
        perform_refresh();
      }
    }
    if (!ADCNetwork.connected())
    {
      if (ADC.connected) {
        ADC.has_ad_availability_changed();
      }
      ADC.connected = false;
      return;
    }
    if (!ADC.connected) {
      ADC.has_ad_availability_changed();
    }
    ADC.connected = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */