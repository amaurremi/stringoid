package com.jirbo.adcolony;

import android.os.Build.VERSION;

class ADCConfiguration
{
  static String ad_manifest_url;
  String android_id;
  String android_id_sha1;
  String app_id;
  String app_version = "1.0";
  String available_stores;
  String carrier_name;
  boolean configured = false;
  ADCController controller;
  ADCManifest.Ad current_ad;
  double current_progress = 0.0D;
  ADCManifest.Zone current_zone;
  String custom_id = "";
  String device_api;
  String device_id;
  String device_manufacturer;
  String device_model;
  String device_type;
  boolean fatal_error = false;
  String imei;
  String imei_sha1;
  String info_string;
  String language;
  String memory_class;
  String memory_used;
  String open_udid;
  String origin_store = "google";
  String os_name = "android";
  String os_version;
  ADCData.Table properties = new ADCData.Table();
  String sdk_type = "android_native";
  String sdk_version = "2.0.6";
  int session_timeout_seconds = 300;
  boolean skippable = false;
  String[] zone_ids;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (String str = "https://androidads20staging.adcolony.com/configure";; str = "http://androidads20staging.adcolony.com/configure")
    {
      ad_manifest_url = str;
      return;
    }
  }
  
  ADCConfiguration(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  void configure()
  {
    this.controller.zone_state_manager.load();
    this.android_id = either_or(ADCDevice.android_id(), "");
    this.android_id_sha1 = either_or(ADCUtil.calculate_sha1(this.android_id), "");
    this.carrier_name = either_or(ADCDevice.carrier_name(), "");
    if (this.device_id == null) {
      this.device_id = either_or(ADCDevice.device_id(), "");
    }
    this.device_manufacturer = either_or(ADCDevice.manufacturer(), "");
    this.device_model = either_or(ADCDevice.model(), "");
    this.language = either_or(ADCDevice.language(), "en");
    this.open_udid = either_or(ADCDevice.open_udid(), "");
    this.os_version = either_or(ADCDevice.os_version(), "");
    this.device_api = either_or("" + Build.VERSION.SDK_INT, "");
    this.imei = either_or(ADCDevice.imei(), "");
    this.imei_sha1 = either_or(ADCUtil.calculate_sha1(this.imei), "");
    this.memory_class = either_or("" + ADCDevice.memory_class(), "");
    this.memory_used = either_or("" + ADCDevice.memory_used(), "");
    ADC.os_version = this.os_version;
    ADC.sdk_version = this.sdk_version;
    if (ADC.is_tablet) {}
    for (this.device_type = "tablet";; this.device_type = "phone")
    {
      this.available_stores = "";
      if ((ADCUtil.application_exists("com.android.vending")) || (ADCUtil.application_exists("com.android.market"))) {
        this.available_stores = "google";
      }
      if (ADCUtil.application_exists("com.amazon.venezia"))
      {
        if (this.available_stores.length() > 0) {
          this.available_stores += ",";
        }
        this.available_stores += "amazon";
      }
      if (ADCLog.debug.enabled)
      {
        ADCLog.debug.print("sdk_version:").println(this.sdk_version);
        ADCLog.debug.print("ad_manifest_url:").println(ad_manifest_url);
        ADCLog.debug.print("app_id:").println(this.app_id);
        ADCLog.debug.print("zone_ids:").println(this.zone_ids);
        ADCLog.debug.print("os_name:").println(this.os_name);
        ADCLog.debug.print("sdk_type:").println(this.sdk_type);
        ADCLog.debug.print("app_version:").println(this.app_version);
        ADCLog.debug.print("origin_store:").println(this.origin_store);
        ADCLog.debug.print("skippable:").println(this.skippable);
        ADCLog.debug.print("android_id:").println(this.android_id);
        ADCLog.debug.print("android_id_sha1:").println(this.android_id_sha1);
        ADCLog.debug.print("available_stores:").println(this.available_stores);
        ADCLog.debug.print("carrier_name:").println(this.carrier_name);
        ADCLog.debug.print("custom_id:").println(this.custom_id);
        ADCLog.debug.print("device_id:").println(this.device_id);
        ADCLog.debug.print("device_manufacturer:").println(this.device_manufacturer);
        ADCLog.debug.print("device_model:").println(this.device_model);
        ADCLog.debug.print("device_type:").println(this.device_type);
        ADCLog.debug.print("imei:").println(this.imei);
        ADCLog.debug.print("imei_sha1:").println(this.imei_sha1);
        ADCLog.debug.print("language:").println(this.language);
        ADCLog.debug.print("open_udid:").println(this.open_udid);
        ADCLog.debug.print("os_version:").println(this.os_version);
      }
      ADCStringBuilder localADCStringBuilder = new ADCStringBuilder();
      localADCStringBuilder.print("&os_name=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.os_name));
      localADCStringBuilder.print("&os_version=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.os_version));
      localADCStringBuilder.print("&device_api=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.device_api));
      localADCStringBuilder.print("&app_version=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.app_version));
      localADCStringBuilder.print("&android_id_sha1=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.android_id_sha1));
      localADCStringBuilder.print("&device_id=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.device_id));
      localADCStringBuilder.print("&open_udid=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.open_udid));
      localADCStringBuilder.print("&device_type=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.device_type));
      localADCStringBuilder.print("&ln=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.language));
      localADCStringBuilder.print("&device_brand=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.device_manufacturer));
      localADCStringBuilder.print("&device_model=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.device_model));
      localADCStringBuilder.print("&screen_width=");
      localADCStringBuilder.print(ADCNetwork.url_encoded("" + ADCDevice.display_width()));
      localADCStringBuilder.print("&screen_height=");
      localADCStringBuilder.print(ADCNetwork.url_encoded("" + ADCDevice.display_height()));
      localADCStringBuilder.print("&sdk_type=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.sdk_type));
      localADCStringBuilder.print("&sdk_version=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.sdk_version));
      localADCStringBuilder.print("&origin_store=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.origin_store));
      localADCStringBuilder.print("&available_stores=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.available_stores));
      localADCStringBuilder.print("&imei_sha1=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.imei_sha1));
      localADCStringBuilder.print("&memory_class=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.memory_class));
      localADCStringBuilder.print("&memory_used_mb=");
      localADCStringBuilder.print(ADCNetwork.url_encoded(this.memory_used));
      this.info_string = localADCStringBuilder.toString();
      this.controller.storage.configure();
      this.controller.media_manager.configure();
      this.controller.reporting_manager.configure();
      this.controller.ad_manager.configure();
      this.controller.session_manager.configure();
      this.controller.play_history.configure();
      this.configured = true;
      this.controller.ad_manager.refresh();
      if ((this.controller.ad_manager.app.view_network_pass_filter == null) || (this.controller.ad_manager.app.view_network_pass_filter.equals(""))) {
        this.controller.ad_manager.app.view_network_pass_filter = "all";
      }
      if ((this.controller.ad_manager.app.cache_network_pass_filter == null) || (this.controller.ad_manager.app.cache_network_pass_filter.equals(""))) {
        this.controller.ad_manager.app.cache_network_pass_filter = "all";
      }
      return;
    }
  }
  
  String either_or(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  void parse_client_options(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str.split(",");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramString[i].split(":");
      if (localObject.length == 2)
      {
        str = localObject[0];
        localObject = localObject[1];
        if (str.equals("version")) {
          this.app_version = ((String)localObject);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("store"))
        {
          if ((((String)localObject).toLowerCase().equals("google")) || (((String)localObject).toLowerCase().equals("amazon"))) {
            this.origin_store = ((String)localObject);
          } else {
            throw new AdColonyException("Origin store in client options must be set to either 'google' or 'amazon'");
          }
        }
        else if (str.equals("skippable"))
        {
          this.skippable = ((String)localObject).equals("true");
          continue;
          if (localObject[0].equals("skippable")) {
            this.skippable = true;
          }
        }
      }
    }
  }
  
  void prepare_end_card()
  {
    Object localObject = this.current_ad.companion_ad._static;
    ADCManifest.HTML5CompanionAdInfo localHTML5CompanionAdInfo = this.current_ad.companion_ad.html5;
    ADCMediaManager localADCMediaManager = this.controller.media_manager;
    if (!this.current_ad.companion_ad.enabled) {
      return;
    }
    if (localHTML5CompanionAdInfo.is_ready())
    {
      ADC.end_card_is_html5 = true;
      ADC.end_card_url = localHTML5CompanionAdInfo.html5_tag;
      ADC.end_card_mraid_filepath = localADCMediaManager.local_filepath(localHTML5CompanionAdInfo.mraid_js.url);
      this.properties.set("close_image_normal", localADCMediaManager.local_filepath(localHTML5CompanionAdInfo.close.image_normal));
      this.properties.set("close_image_down", localADCMediaManager.local_filepath(localHTML5CompanionAdInfo.close.image_down));
      this.properties.set("reload_image_normal", localADCMediaManager.local_filepath(localHTML5CompanionAdInfo.replay.image_normal));
      this.properties.set("reload_image_down", localADCMediaManager.local_filepath(localHTML5CompanionAdInfo.replay.image_down));
    }
    for (;;)
    {
      localObject = this.current_ad.video;
      this.properties.set("end_card_enabled", this.current_ad.companion_ad.enabled);
      this.properties.set("load_timeout_enabled", this.current_ad.companion_ad.html5.load_timeout_enabled);
      this.properties.set("load_timeout", this.current_ad.companion_ad.html5.load_timeout);
      this.properties.set("hardware_acceleration_disabled", this.controller.ad_manager.app.hardware_acceleration_disabled);
      return;
      ADC.end_card_is_html5 = false;
      this.properties.set("end_card_filepath", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).background_image));
      this.properties.set("info_image_normal", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).info.image_normal));
      this.properties.set("info_image_down", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).info.image_down));
      this.properties.set("info_url", ((ADCManifest.StaticCompanionAdInfo)localObject).info.click_action);
      this.properties.set("replay_image_normal", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).replay.image_normal));
      this.properties.set("replay_image_down", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).replay.image_down));
      this.properties.set("continue_image_normal", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject)._continue.image_normal));
      this.properties.set("continue_image_down", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject)._continue.image_down));
      this.properties.set("download_image_normal", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).download.image_normal));
      this.properties.set("download_image_down", localADCMediaManager.local_filepath(((ADCManifest.StaticCompanionAdInfo)localObject).download.image_down));
      this.properties.set("download_url", ((ADCManifest.StaticCompanionAdInfo)localObject).download.click_action);
    }
  }
  
  void prepare_v4vc_ad(String paramString)
  {
    this.current_zone = this.controller.ad_manager.app.zones.find(paramString);
    this.current_ad = this.current_zone.current_ad();
    paramString = this.controller.media_manager;
    ADCManifest.Video localVideo = this.current_ad.video;
    this.properties.set("video_enabled", localVideo.enabled);
    this.properties.set("video_filepath", localVideo.filepath());
    this.properties.set("video_width", localVideo.width);
    this.properties.set("video_height", localVideo.height);
    this.properties.set("video_duration", localVideo.duration);
    this.properties.set("engagement_delay", localVideo.in_video_engagement.delay);
    this.properties.set("skip_delay", localVideo.skip_video.delay);
    prepare_end_card();
    ADCManifest.AdV4VC localAdV4VC = this.current_ad.v4vc;
    this.properties.set("pre_popup_bg", paramString.local_filepath(localAdV4VC.pre_popup.dialog.image));
    this.properties.set("v4vc_logo", paramString.local_filepath(localAdV4VC.pre_popup.dialog.logo.image));
    this.properties.set("no_button_normal", paramString.local_filepath(localAdV4VC.pre_popup.dialog.option_no.image_normal));
    this.properties.set("no_button_down", paramString.local_filepath(localAdV4VC.pre_popup.dialog.option_no.image_down));
    this.properties.set("yes_button_normal", paramString.local_filepath(localAdV4VC.pre_popup.dialog.option_yes.image_normal));
    this.properties.set("yes_button_down", paramString.local_filepath(localAdV4VC.pre_popup.dialog.option_yes.image_down));
    this.properties.set("done_button_normal", paramString.local_filepath(localAdV4VC.post_popup.dialog.option_done.image_normal));
    this.properties.set("done_button_down", paramString.local_filepath(localAdV4VC.post_popup.dialog.option_done.image_down));
    this.properties.set("browser_close_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.close.image_normal));
    this.properties.set("browser_close_image_down", paramString.local_filepath(this.current_ad.in_app_browser.close.image_down));
    this.properties.set("browser_reload_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.reload.image_normal));
    this.properties.set("browser_reload_image_down", paramString.local_filepath(this.current_ad.in_app_browser.reload.image_down));
    this.properties.set("browser_back_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.back.image_normal));
    this.properties.set("browser_back_image_down", paramString.local_filepath(this.current_ad.in_app_browser.back.image_down));
    this.properties.set("browser_forward_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.forward.image_normal));
    this.properties.set("browser_forward_image_down", paramString.local_filepath(this.current_ad.in_app_browser.forward.image_down));
    this.properties.set("browser_stop_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.stop.image_normal));
    this.properties.set("browser_stop_image_down", paramString.local_filepath(this.current_ad.in_app_browser.stop.image_down));
    this.properties.set("browser_glow_button", paramString.local_filepath(this.current_ad.in_app_browser.tiny_glow_image));
    this.properties.set("browser_icon", paramString.local_filepath(this.current_ad.in_app_browser.logo.image));
    this.properties.set("skip_video_image_normal", paramString.local_filepath(localVideo.skip_video.image_normal));
    this.properties.set("skip_video_image_down", paramString.local_filepath(localVideo.skip_video.image_down));
    this.properties.set("engagement_image_normal", paramString.local_filepath(localVideo.in_video_engagement.image_normal));
    this.properties.set("engagement_image_down", paramString.local_filepath(localVideo.in_video_engagement.image_down));
  }
  
  void prepare_video_ad(String paramString)
  {
    this.current_zone = this.controller.ad_manager.app.zones.find(paramString);
    this.current_ad = this.current_zone.current_ad();
    paramString = this.controller.media_manager;
    ADCManifest.Video localVideo = this.current_ad.video;
    this.properties.set("video_enabled", localVideo.enabled);
    this.properties.set("video_filepath", localVideo.filepath());
    this.properties.set("video_width", localVideo.width);
    this.properties.set("video_height", localVideo.height);
    this.properties.set("video_duration", localVideo.duration);
    this.properties.set("engagement_delay", localVideo.in_video_engagement.delay);
    this.properties.set("skip_delay", localVideo.skip_video.delay);
    this.properties.set("browser_close_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.close.image_normal));
    this.properties.set("browser_close_image_down", paramString.local_filepath(this.current_ad.in_app_browser.close.image_down));
    this.properties.set("browser_reload_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.reload.image_normal));
    this.properties.set("browser_reload_image_down", paramString.local_filepath(this.current_ad.in_app_browser.reload.image_down));
    this.properties.set("browser_back_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.back.image_normal));
    this.properties.set("browser_back_image_down", paramString.local_filepath(this.current_ad.in_app_browser.back.image_down));
    this.properties.set("browser_forward_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.forward.image_normal));
    this.properties.set("browser_forward_image_down", paramString.local_filepath(this.current_ad.in_app_browser.forward.image_down));
    this.properties.set("browser_stop_image_normal", paramString.local_filepath(this.current_ad.in_app_browser.stop.image_normal));
    this.properties.set("browser_stop_image_down", paramString.local_filepath(this.current_ad.in_app_browser.stop.image_down));
    this.properties.set("browser_glow_button", paramString.local_filepath(this.current_ad.in_app_browser.tiny_glow_image));
    this.properties.set("browser_icon", paramString.local_filepath(this.current_ad.in_app_browser.logo.image));
    this.properties.set("skip_video_image_normal", paramString.local_filepath(localVideo.skip_video.image_normal));
    this.properties.set("skip_video_image_down", paramString.local_filepath(localVideo.skip_video.image_down));
    this.properties.set("engagement_image_normal", paramString.local_filepath(localVideo.in_video_engagement.image_normal));
    this.properties.set("engagement_image_down", paramString.local_filepath(localVideo.in_video_engagement.image_down));
    prepare_end_card();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */