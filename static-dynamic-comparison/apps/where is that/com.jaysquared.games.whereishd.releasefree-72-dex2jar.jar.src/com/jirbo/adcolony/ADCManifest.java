package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

class ADCManifest
{
  static class Ad
  {
    int ad_campaign_id;
    int ad_group_id;
    int ad_id;
    ADCManifest.AdTracking ad_tracking;
    ADCManifest.CompanionAd companion_ad;
    boolean contracted;
    int cpcv_bid;
    boolean enable_in_app_store;
    int expires;
    boolean fullscreen;
    boolean house_ad;
    ADCManifest.InAppBrowser in_app_browser;
    ADCManifest.Limits limits;
    int net_earnings;
    boolean test_ad;
    ADCManifest.ThirdPartyTracking third_party_tracking;
    String title;
    String uuid;
    ADCManifest.AdV4VC v4vc;
    ADCManifest.Video video;
    boolean video_events_on_replays;
    
    void cache_media()
    {
      this.v4vc.cache_media();
      this.in_app_browser.cache_media();
      this.companion_ad.cache_media();
      this.video.cache_media();
    }
    
    boolean is_ready()
    {
      if (!this.in_app_browser.is_ready()) {}
      while (((this.v4vc.enabled) && (!this.v4vc.is_ready())) || ((this.companion_ad.enabled) && (!this.companion_ad.is_ready())) || (!this.video.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                    this.uuid = paramTable.get_String("uuid");
                    this.title = paramTable.get_String("title");
                    this.ad_campaign_id = paramTable.get_Integer("ad_campaign_id");
                    this.ad_id = paramTable.get_Integer("ad_id");
                    this.ad_group_id = paramTable.get_Integer("ad_group_id");
                    this.cpcv_bid = paramTable.get_Integer("cpcv_bid");
                    this.net_earnings = paramTable.get_Integer("net_earnings");
                    this.expires = paramTable.get_Integer("expires");
                    this.enable_in_app_store = paramTable.get_Logical("enable_in_app_store");
                    this.video_events_on_replays = paramTable.get_Logical("video_events_on_replays");
                    this.test_ad = paramTable.get_Logical("test_ad");
                    this.fullscreen = paramTable.get_Logical("fullscreen");
                    this.house_ad = paramTable.get_Logical("house_ad");
                    this.contracted = paramTable.get_Logical("contracted");
                    this.limits = new ADCManifest.Limits();
                  } while (!this.limits.parse(paramTable.get_Table("limits")));
                  this.third_party_tracking = new ADCManifest.ThirdPartyTracking();
                } while (!this.third_party_tracking.parse(paramTable.get_Table("third_party_tracking")));
                this.in_app_browser = new ADCManifest.InAppBrowser();
              } while (!this.in_app_browser.parse(paramTable.get_Table("in_app_browser")));
              this.v4vc = new ADCManifest.AdV4VC();
            } while (!this.v4vc.parse(paramTable.get_Table("v4vc")));
            this.ad_tracking = new ADCManifest.AdTracking();
          } while (!this.ad_tracking.parse(paramTable.get_Table("ad_tracking")));
          this.companion_ad = new ADCManifest.CompanionAd();
        } while (!this.companion_ad.parse(paramTable.get_Table("companion_ad")));
        this.video = new ADCManifest.Video();
      } while (!this.video.parse(paramTable.get_Table("video")));
      return true;
    }
  }
  
  static class AdTracking
  {
    String _continue;
    String cancel;
    String card_dissolved;
    String card_shown;
    String complete;
    String custom_event;
    String download;
    String first_quartile;
    String html5_interaction;
    String in_video_engagement;
    String info;
    ADCData.Table lookup = new ADCData.Table();
    String midpoint;
    String replay;
    String reward_v4vc;
    String skip;
    String start;
    String third_quartile;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return true;
      }
      this.replay = paramTable.get_String("replay", null);
      this.card_shown = paramTable.get_String("card_shown", null);
      this.html5_interaction = paramTable.get_String("html5_interaction", null);
      this.cancel = paramTable.get_String("cancel", null);
      this.download = paramTable.get_String("download", null);
      this.skip = paramTable.get_String("skip", null);
      this.info = paramTable.get_String("info", null);
      this.custom_event = paramTable.get_String("custom_event", null);
      this.midpoint = paramTable.get_String("midpoint", null);
      this.card_dissolved = paramTable.get_String("card_dissolved", null);
      this.start = paramTable.get_String("start", null);
      this.third_quartile = paramTable.get_String("third_quartile", null);
      this.complete = paramTable.get_String("complete", null);
      this._continue = paramTable.get_String("continue", null);
      this.in_video_engagement = paramTable.get_String("in_video_engagement", null);
      this.reward_v4vc = paramTable.get_String("reward_v4vc", null);
      this.first_quartile = paramTable.get_String("first_quartile", null);
      this.lookup.set("replay", this.replay);
      this.lookup.set("card_shown", this.card_shown);
      this.lookup.set("html5_interaction", this.html5_interaction);
      this.lookup.set("cancel", this.cancel);
      this.lookup.set("download", this.download);
      this.lookup.set("skip", this.skip);
      this.lookup.set("info", this.info);
      this.lookup.set("custom_event", this.custom_event);
      this.lookup.set("midpoint", this.midpoint);
      this.lookup.set("card_dissolved", this.card_dissolved);
      this.lookup.set("start", this.start);
      this.lookup.set("third_quartile", this.third_quartile);
      this.lookup.set("complete", this.complete);
      this.lookup.set("continue", this._continue);
      this.lookup.set("in_video_engagement", this.in_video_engagement);
      this.lookup.set("reward_v4vc", this.reward_v4vc);
      this.lookup.set("first_quartile", this.first_quartile);
      return true;
    }
  }
  
  static class AdV4VC
  {
    boolean enabled;
    ADCManifest.PostPopupInfo post_popup;
    ADCManifest.PrePopupInfo pre_popup;
    
    void cache_media()
    {
      if (!this.enabled) {
        return;
      }
      this.pre_popup.cache_media();
      this.post_popup.cache_media();
    }
    
    boolean is_ready()
    {
      if (!this.pre_popup.is_ready()) {}
      while (!this.post_popup.is_ready()) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          return false;
          this.enabled = paramTable.get_Logical("enabled");
          if (!this.enabled) {
            return true;
          }
          this.pre_popup = new ADCManifest.PrePopupInfo();
        } while (!this.pre_popup.parse(paramTable.get_Table("pre_popup")));
        this.post_popup = new ADCManifest.PostPopupInfo();
      } while (!this.post_popup.parse(paramTable.get_Table("post_popup")));
      return true;
    }
  }
  
  static class Ads
  {
    ArrayList<ADCManifest.Ad> data = new ArrayList();
    
    void add(ADCManifest.Ad paramAd)
    {
      this.data.add(paramAd);
    }
    
    int count()
    {
      return this.data.size();
    }
    
    ADCManifest.Ad find(String paramString)
    {
      int i = 0;
      while (i < this.data.size())
      {
        ADCManifest.Ad localAd = (ADCManifest.Ad)this.data.get(i);
        if (localAd.uuid.equals(paramString)) {
          return localAd;
        }
        i += 1;
      }
      return null;
    }
    
    ADCManifest.Ad first()
    {
      return (ADCManifest.Ad)this.data.get(0);
    }
    
    ADCManifest.Ad get(int paramInt)
    {
      return (ADCManifest.Ad)this.data.get(paramInt);
    }
    
    boolean parse(ADCData.List paramList)
    {
      if (paramList == null) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramList.count()) {
          break label52;
        }
        ADCManifest.Ad localAd = new ADCManifest.Ad();
        if (!localAd.parse(paramList.get_Table(i))) {
          break;
        }
        this.data.add(localAd);
        i += 1;
      }
      label52:
      return true;
    }
  }
  
  static class App
  {
    ADCManifest.AppTracking app_tracking;
    String cache_network_pass_filter;
    boolean collect_iap_enabled;
    ArrayList<String> console_messages;
    boolean enabled;
    boolean hardware_acceleration_disabled = false;
    String last_country;
    String last_ip;
    String log_level;
    boolean log_screen_overlay;
    double media_pool_size;
    ADCManifest.ThirdPartyAppTracking third_party_app_tracking;
    String view_network_pass_filter;
    ADCManifest.Zones zones;
    
    void cache_media()
    {
      ADCLog.dev.println("Caching media");
      if (!this.enabled) {}
      for (;;)
      {
        return;
        int i = 0;
        while (i < this.zones.count())
        {
          this.zones.get(i).cache_media();
          i += 1;
        }
      }
    }
    
    boolean is_ad_available(String paramString)
    {
      return is_ad_available(paramString, false, true);
    }
    
    boolean is_ad_available(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (!this.enabled) {}
      do
      {
        return false;
        paramString = this.zones.find(paramString);
      } while (paramString == null);
      return paramString.is_ad_available(paramBoolean1, paramBoolean2);
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            return false;
            this.enabled = paramTable.get_Logical("enabled");
            this.log_screen_overlay = paramTable.get_Logical("log_screen_overlay");
            this.last_country = paramTable.get_String("last_country");
            this.last_ip = paramTable.get_String("last_ip");
            this.collect_iap_enabled = paramTable.get_Logical("collect_iap_enabled");
            this.media_pool_size = paramTable.get_Real("media_pool_size");
            this.log_level = paramTable.get_String("log_level");
            this.view_network_pass_filter = paramTable.get_String("view_network_pass_filter");
            this.cache_network_pass_filter = paramTable.get_String("cache_network_pass_filter");
            this.hardware_acceleration_disabled = paramTable.get_Logical("hardware_acceleration_disabled");
            if ((this.view_network_pass_filter == null) || (this.view_network_pass_filter.equals(""))) {
              this.view_network_pass_filter = "all";
            }
            if ((this.cache_network_pass_filter == null) || (this.cache_network_pass_filter.equals(""))) {
              this.cache_network_pass_filter = "all";
            }
            this.app_tracking = new ADCManifest.AppTracking();
          } while (!this.app_tracking.parse(paramTable.get_Table("tracking")));
          this.third_party_app_tracking = new ADCManifest.ThirdPartyAppTracking();
        } while (!this.third_party_app_tracking.parse(paramTable.get_Table("third_party_tracking")));
        this.console_messages = paramTable.get_StringList("console_messages");
        ADCLog.dev.println("Parsing zones");
        this.zones = new ADCManifest.Zones();
      } while (!this.zones.parse(paramTable.get_List("zones")));
      ADCLog.dev.println("Finished parsing app info");
      return true;
    }
  }
  
  static class AppTracking
  {
    String dynamic_interests;
    String in_app_purchase;
    String install;
    ADCData.Table lookup;
    String session_end;
    String session_start;
    String update;
    String user_meta_data;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return true;
      }
      this.update = paramTable.get_String("update", null);
      this.install = paramTable.get_String("install", null);
      this.dynamic_interests = paramTable.get_String("dynamic_interests", null);
      this.user_meta_data = paramTable.get_String("user_meta_data", null);
      this.in_app_purchase = paramTable.get_String("in_app_purchase", null);
      this.session_end = paramTable.get_String("session_end", null);
      this.session_start = paramTable.get_String("session_start", null);
      this.lookup = new ADCData.Table();
      this.lookup.set("update", this.update);
      this.lookup.set("install", this.install);
      this.lookup.set("dynamic_interests", this.dynamic_interests);
      this.lookup.set("user_meta_data", this.user_meta_data);
      this.lookup.set("in_app_purchase", this.in_app_purchase);
      this.lookup.set("session_end", this.session_end);
      this.lookup.set("session_start", this.session_start);
      return true;
    }
  }
  
  static class ButtonInfo
  {
    String click_action;
    String click_action_type;
    int delay;
    boolean enabled;
    String event;
    int height;
    String image_down;
    String image_down_last_modified;
    String image_normal;
    String image_normal_last_modified;
    String label;
    String label_html;
    String label_rgba;
    String label_shadow_rgba;
    int scale;
    int width;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.image_normal, this.image_normal_last_modified);
      ADC.controller.media_manager.cache(this.image_down, this.image_down_last_modified);
    }
    
    boolean is_ready()
    {
      if (!this.enabled) {}
      do
      {
        return true;
        if (!ADC.controller.media_manager.is_cached(this.image_normal)) {
          return false;
        }
      } while (ADC.controller.media_manager.is_cached(this.image_down));
      return false;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return false;
      }
      this.enabled = paramTable.get_Logical("enabled", true);
      this.delay = paramTable.get_Integer("delay");
      this.width = paramTable.get_Integer("width");
      this.height = paramTable.get_Integer("height");
      this.scale = paramTable.get_Integer("scale");
      this.image_normal = paramTable.get_String("image_normal");
      this.image_normal_last_modified = paramTable.get_String("image_normal_last_modified");
      this.image_down = paramTable.get_String("image_down");
      this.image_down_last_modified = paramTable.get_String("image_down_last_modified");
      this.click_action = paramTable.get_String("click_action");
      this.click_action_type = paramTable.get_String("click_action_type");
      this.label = paramTable.get_String("label");
      this.label_rgba = paramTable.get_String("label_rgba");
      this.label_shadow_rgba = paramTable.get_String("label_shadow_rgba");
      this.label_html = paramTable.get_String("label_html");
      this.event = paramTable.get_String("event");
      return true;
    }
  }
  
  static class CompanionAd
  {
    ADCManifest.StaticCompanionAdInfo _static;
    int ad_campaign_id;
    int ad_id;
    boolean dissolve;
    double dissolve_delay;
    boolean enable_in_app_store;
    boolean enabled;
    ADCManifest.HTML5CompanionAdInfo html5;
    String uuid;
    
    void cache_media()
    {
      if (!this.enabled) {
        return;
      }
      this._static.cache_media();
      this.html5.cache_media();
    }
    
    boolean is_ready()
    {
      if ((this.html5.enabled) && (!this.html5.is_ready())) {}
      do
      {
        return false;
        if (!this.enabled) {
          return true;
        }
      } while ((!this._static.is_ready()) && (!this.html5.is_ready()));
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          return false;
          this.enabled = paramTable.get_Logical("enabled");
          if (!this.enabled) {
            return true;
          }
          this.uuid = paramTable.get_String("uuid");
          this.ad_id = paramTable.get_Integer("ad_id");
          this.ad_campaign_id = paramTable.get_Integer("ad_campaign_id");
          this.dissolve = paramTable.get_Logical("dissolve");
          this.enable_in_app_store = paramTable.get_Logical("enable_in_app_store");
          this.dissolve_delay = paramTable.get_Real("dissolve_delay");
          this._static = new ADCManifest.StaticCompanionAdInfo();
        } while (!this._static.parse(paramTable.get_Table("static")));
        this.html5 = new ADCManifest.HTML5CompanionAdInfo();
      } while (!this.html5.parse(paramTable.get_Table("html5")));
      return true;
    }
  }
  
  static class HTML5CompanionAdInfo
  {
    String background_color;
    ADCManifest.ImageInfo background_logo;
    ADCManifest.ButtonInfo close;
    boolean enabled;
    String html5_tag;
    boolean load_spinner_enabled;
    double load_timeout;
    boolean load_timeout_enabled;
    ADCManifest.MRAIDJS mraid_js;
    ADCManifest.ButtonInfo replay;
    
    void cache_media()
    {
      if (!this.enabled) {}
      do
      {
        return;
        if (this.mraid_js != null) {
          this.mraid_js.cache_media();
        }
        if (this.background_logo != null) {
          this.background_logo.cache_media();
        }
        if (this.replay != null) {
          this.replay.cache_media();
        }
      } while (this.close == null);
      this.close.cache_media();
    }
    
    boolean is_ready()
    {
      boolean bool2 = false;
      boolean bool1;
      if (!ADCNetwork.connected()) {
        bool1 = ADCLog.info.fail("Ad not ready due to no network connection.");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!this.enabled);
              bool1 = bool2;
            } while (!this.mraid_js.is_ready());
            bool1 = bool2;
          } while (!this.background_logo.is_ready());
          bool1 = bool2;
        } while (!this.replay.is_ready());
        bool1 = bool2;
      } while (!this.close.is_ready());
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.enabled = paramTable.get_Logical("enabled");
              this.load_timeout = paramTable.get_Real("load_timeout");
              this.load_timeout_enabled = paramTable.get_Logical("load_timeout_enabled");
              this.load_spinner_enabled = paramTable.get_Logical("load_spinner_enabled");
              this.background_color = paramTable.get_String("background_color");
              this.html5_tag = paramTable.get_String("html5_tag");
              this.mraid_js = new ADCManifest.MRAIDJS();
            } while (!this.mraid_js.parse(paramTable.get_Table("mraid_js")));
            this.background_logo = new ADCManifest.ImageInfo();
          } while (!this.background_logo.parse(paramTable.get_Table("background_logo")));
          this.replay = new ADCManifest.ButtonInfo();
        } while (!this.replay.parse(paramTable.get_Table("replay")));
        this.close = new ADCManifest.ButtonInfo();
      } while (!this.close.parse(paramTable.get_Table("close")));
      return true;
    }
  }
  
  static class ImageInfo
  {
    int height;
    String image;
    String image_last_modified;
    int scale;
    int width;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.image, this.image_last_modified);
    }
    
    boolean is_ready()
    {
      return ADC.controller.media_manager.is_cached(this.image);
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return false;
      }
      this.width = paramTable.get_Integer("width");
      this.height = paramTable.get_Integer("height");
      this.scale = paramTable.get_Integer("scale");
      this.image = paramTable.get_String("image");
      this.image_last_modified = paramTable.get_String("image_last_modified");
      return true;
    }
  }
  
  static class InAppBrowser
  {
    ADCManifest.ButtonInfo back;
    String background_bar_image;
    String background_bar_image_last_modified;
    String background_color;
    String background_tile_image;
    String background_tile_image_last_modified;
    ADCManifest.ButtonInfo close;
    ADCManifest.ButtonInfo forward;
    ADCManifest.ImageInfo logo;
    ADCManifest.ButtonInfo reload;
    ADCManifest.ButtonInfo stop;
    String tiny_glow_image;
    String tiny_glow_image_last_modified;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.tiny_glow_image, this.tiny_glow_image_last_modified);
      ADC.controller.media_manager.cache(this.background_bar_image, this.background_bar_image_last_modified);
      ADC.controller.media_manager.cache(this.background_tile_image, this.background_tile_image_last_modified);
      this.logo.cache_media();
      this.stop.cache_media();
      this.back.cache_media();
      this.close.cache_media();
      this.forward.cache_media();
      this.reload.cache_media();
    }
    
    boolean is_ready()
    {
      if (!ADC.controller.media_manager.is_cached(this.tiny_glow_image)) {}
      while ((!ADC.controller.media_manager.is_cached(this.background_bar_image)) || (!ADC.controller.media_manager.is_cached(this.background_tile_image)) || (!this.logo.is_ready()) || (!this.stop.is_ready()) || (!this.back.is_ready()) || (!this.close.is_ready()) || (!this.forward.is_ready()) || (!this.reload.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                    this.tiny_glow_image = paramTable.get_String("tiny_glow_image");
                    this.tiny_glow_image_last_modified = paramTable.get_String("tiny_glow_image_last_modified;");
                    this.background_bar_image = paramTable.get_String("background_bar_image");
                    this.background_bar_image_last_modified = paramTable.get_String("background_bar_image_last_modified");
                    this.background_tile_image = paramTable.get_String("background_tile_image");
                    this.background_tile_image_last_modified = paramTable.get_String("background_tile_image_last_modified");
                    this.background_color = paramTable.get_String("background_color");
                    this.logo = new ADCManifest.ImageInfo();
                  } while (!this.logo.parse(paramTable.get_Table("logo")));
                  this.logo = new ADCManifest.ImageInfo();
                } while (!this.logo.parse(paramTable.get_Table("logo")));
                this.stop = new ADCManifest.ButtonInfo();
              } while (!this.stop.parse(paramTable.get_Table("stop")));
              this.back = new ADCManifest.ButtonInfo();
            } while (!this.back.parse(paramTable.get_Table("back")));
            this.close = new ADCManifest.ButtonInfo();
          } while (!this.close.parse(paramTable.get_Table("close")));
          this.forward = new ADCManifest.ButtonInfo();
        } while (!this.forward.parse(paramTable.get_Table("forward")));
        this.reload = new ADCManifest.ButtonInfo();
      } while (!this.reload.parse(paramTable.get_Table("reload")));
      return true;
    }
  }
  
  static class Limits
  {
    int custom_play_cap;
    int custom_play_cap_period;
    int daily_play_cap;
    int monthly_play_cap;
    int total_play_cap;
    int volatile_expiration;
    int volatile_play_cap;
    int weekly_play_cap;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return false;
      }
      this.daily_play_cap = paramTable.get_Integer("daily_play_cap");
      this.custom_play_cap = paramTable.get_Integer("custom_play_cap");
      this.custom_play_cap_period = paramTable.get_Integer("custom_play_cap_period");
      this.total_play_cap = paramTable.get_Integer("total_play_cap");
      this.monthly_play_cap = paramTable.get_Integer("monthly_play_cap");
      this.weekly_play_cap = paramTable.get_Integer("weekly_play_cap");
      this.volatile_expiration = paramTable.get_Integer("volatile_expiration");
      this.volatile_play_cap = paramTable.get_Integer("volatile_play_cap");
      return true;
    }
  }
  
  static class MRAIDJS
  {
    boolean enabled;
    String last_modified;
    String url;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.url, this.last_modified);
    }
    
    boolean is_ready()
    {
      if (!this.enabled) {}
      while (ADC.controller.media_manager.is_cached(this.url)) {
        return true;
      }
      return false;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      boolean bool = true;
      if (paramTable == null) {
        bool = false;
      }
      do
      {
        return bool;
        this.enabled = paramTable.get_Logical("enabled");
      } while (!this.enabled);
      this.url = paramTable.get_String("url");
      this.last_modified = paramTable.get_String("last_modified");
      return true;
    }
  }
  
  static class PostPopupDialogInfo
  {
    int height;
    String image;
    String image_last_modified;
    String label;
    String label_fraction;
    String label_html;
    String label_reward;
    String label_rgba;
    String label_shadow_rgba;
    ADCManifest.ImageInfo logo;
    ADCManifest.ButtonInfo option_done;
    int scale;
    int width;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.image, this.image_last_modified);
      this.logo.cache_media();
      this.option_done.cache_media();
    }
    
    boolean is_ready()
    {
      if (!ADC.controller.media_manager.is_cached(this.image)) {}
      while ((!this.logo.is_ready()) || (!this.option_done.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      this.scale = paramTable.get_Integer("scale");
      this.label_reward = paramTable.get_String("label_reward");
      this.width = paramTable.get_Integer("width");
      this.height = paramTable.get_Integer("height");
      this.image = paramTable.get_String("image");
      this.image_last_modified = paramTable.get_String("image_last_modified");
      this.label = paramTable.get_String("label");
      this.label_rgba = paramTable.get_String("label_rgba");
      this.label_shadow_rgba = paramTable.get_String("label_shadow_rgba");
      this.label_fraction = paramTable.get_String("label_fraction");
      this.label_html = paramTable.get_String("label_html");
      this.logo = new ADCManifest.ImageInfo();
      if (!this.logo.parse(paramTable.get_Table("logo"))) {}
      do
      {
        return false;
        this.option_done = new ADCManifest.ButtonInfo();
      } while (!this.option_done.parse(paramTable.get_Table("option_done")));
      return true;
    }
  }
  
  static class PostPopupInfo
  {
    String background_image;
    String background_image_last_modified;
    ADCManifest.ImageInfo background_logo;
    ADCManifest.PostPopupDialogInfo dialog;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.background_image, this.background_image_last_modified);
      this.dialog.cache_media();
    }
    
    boolean is_ready()
    {
      if (!ADC.controller.media_manager.is_cached(this.background_image)) {}
      while ((!this.background_logo.is_ready()) || (!this.dialog.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      this.background_image = paramTable.get_String("background_image");
      this.background_image_last_modified = paramTable.get_String("background_image_last_modified");
      this.background_logo = new ADCManifest.ImageInfo();
      if (!this.background_logo.parse(paramTable.get_Table("background_logo"))) {}
      do
      {
        return false;
        this.dialog = new ADCManifest.PostPopupDialogInfo();
      } while (!this.dialog.parse(paramTable.get_Table("dialog")));
      return true;
    }
  }
  
  static class PrePopupDialogInfo
  {
    int height;
    String image;
    String image_last_modified;
    String label;
    String label_fraction;
    String label_html;
    String label_reward;
    String label_rgba;
    String label_shadow_rgba;
    ADCManifest.ImageInfo logo;
    ADCManifest.ButtonInfo option_no;
    ADCManifest.ButtonInfo option_yes;
    int scale;
    int width;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.image, this.image_last_modified);
      this.logo.cache_media();
      this.option_yes.cache_media();
      this.option_no.cache_media();
    }
    
    boolean is_ready()
    {
      if (!ADC.controller.media_manager.is_cached(this.image)) {}
      while ((!this.logo.is_ready()) || (!this.option_yes.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      this.scale = paramTable.get_Integer("scale");
      this.label_reward = paramTable.get_String("label_reward");
      this.width = paramTable.get_Integer("width");
      this.height = paramTable.get_Integer("height");
      this.image = paramTable.get_String("image");
      this.image_last_modified = paramTable.get_String("image_last_modified");
      this.label = paramTable.get_String("label");
      this.label_rgba = paramTable.get_String("label_rgba");
      this.label_shadow_rgba = paramTable.get_String("label_shadow_rgba");
      this.label_fraction = paramTable.get_String("label_fraction");
      this.label_html = paramTable.get_String("label_html");
      this.logo = new ADCManifest.ImageInfo();
      if (!this.logo.parse(paramTable.get_Table("logo"))) {}
      do
      {
        do
        {
          return false;
          this.option_yes = new ADCManifest.ButtonInfo();
        } while (!this.option_yes.parse(paramTable.get_Table("option_yes")));
        this.option_no = new ADCManifest.ButtonInfo();
      } while (!this.option_no.parse(paramTable.get_Table("option_no")));
      return true;
    }
  }
  
  static class PrePopupInfo
  {
    String background_image;
    String background_image_last_modified;
    ADCManifest.ImageInfo background_logo;
    ADCManifest.PrePopupDialogInfo dialog;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.background_image, this.background_image_last_modified);
      this.background_logo.cache_media();
      this.dialog.cache_media();
    }
    
    boolean is_ready()
    {
      if (!ADC.controller.media_manager.is_cached(this.background_image)) {}
      while ((!this.background_logo.is_ready()) || (!this.dialog.is_ready())) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      this.background_image = paramTable.get_String("background_image");
      this.background_image_last_modified = paramTable.get_String("background_image_last_modified");
      this.background_logo = new ADCManifest.ImageInfo();
      if (!this.background_logo.parse(paramTable.get_Table("background_logo"))) {}
      do
      {
        return false;
        this.dialog = new ADCManifest.PrePopupDialogInfo();
      } while (!this.dialog.parse(paramTable.get_Table("dialog")));
      return true;
    }
  }
  
  static class StaticCompanionAdInfo
  {
    ADCManifest.ButtonInfo _continue;
    String background_image;
    String background_image_last_modified;
    ADCManifest.ButtonInfo download;
    boolean enabled;
    int height;
    ADCManifest.ButtonInfo info;
    ADCManifest.ButtonInfo replay;
    int width;
    
    void cache_media()
    {
      if (!this.enabled) {
        return;
      }
      ADC.controller.media_manager.cache(this.background_image, this.background_image_last_modified);
      this.replay.cache_media();
      this._continue.cache_media();
      this.download.cache_media();
      this.info.cache_media();
    }
    
    boolean is_ready()
    {
      if (!this.enabled) {}
      do
      {
        return true;
        if (!ADC.controller.media_manager.is_cached(this.background_image)) {
          return false;
        }
        if (!this.replay.is_ready()) {
          return false;
        }
        if (!this._continue.is_ready()) {
          return false;
        }
        if (!this.download.is_ready()) {
          return false;
        }
      } while (this.info.is_ready());
      return false;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              this.enabled = paramTable.get_Logical("enabled");
              if (!this.enabled) {
                return true;
              }
              this.width = paramTable.get_Integer("width");
              this.height = paramTable.get_Integer("height");
              this.background_image = paramTable.get_String("background_image");
              this.background_image_last_modified = paramTable.get_String("background_image_last_modified");
              if (ADC.force_static_url != null) {
                this.background_image = ADC.force_static_url;
              }
              this.replay = new ADCManifest.ButtonInfo();
            } while (!this.replay.parse(paramTable.get_Table("replay")));
            this._continue = new ADCManifest.ButtonInfo();
          } while (!this._continue.parse(paramTable.get_Table("continue")));
          this.download = new ADCManifest.ButtonInfo();
        } while (!this.download.parse(paramTable.get_Table("download")));
        this.info = new ADCManifest.ButtonInfo();
      } while (!this.info.parse(paramTable.get_Table("info")));
      return true;
    }
  }
  
  static class ThirdPartyAppTracking
  {
    ArrayList<String> install = new ArrayList();
    HashMap<String, ArrayList<String>> lookup = new HashMap();
    ArrayList<String> session_start = new ArrayList();
    ArrayList<String> update = new ArrayList();
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            return false;
            localArrayList = paramTable.get_StringList("update");
            this.update = localArrayList;
          } while (localArrayList == null);
          localArrayList = paramTable.get_StringList("install");
          this.install = localArrayList;
        } while (localArrayList == null);
        paramTable = paramTable.get_StringList("session_start");
        this.session_start = paramTable;
      } while (paramTable == null);
      this.lookup.put("update", this.update);
      this.lookup.put("install", this.install);
      this.lookup.put("session_start", this.session_start);
      return true;
    }
  }
  
  static class ThirdPartyTracking
  {
    ArrayList<String> _continue = new ArrayList();
    ArrayList<String> cancel = new ArrayList();
    ArrayList<String> card_dissolved = new ArrayList();
    ArrayList<String> card_shown = new ArrayList();
    ArrayList<String> complete = new ArrayList();
    ArrayList<String> download = new ArrayList();
    ArrayList<String> first_quartile = new ArrayList();
    ArrayList<String> html5_interaction = new ArrayList();
    ArrayList<String> in_video_engagement = new ArrayList();
    ArrayList<String> info = new ArrayList();
    HashMap<String, ArrayList<String>> lookup = new HashMap();
    ArrayList<String> midpoint = new ArrayList();
    ArrayList<String> replay = new ArrayList();
    ArrayList<String> reward_v4vc = new ArrayList();
    ArrayList<String> skip = new ArrayList();
    ArrayList<String> start = new ArrayList();
    ArrayList<String> third_quartile = new ArrayList();
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return false;
      }
      this.replay = paramTable.get_StringList("replay");
      this.card_shown = paramTable.get_StringList("card_shown");
      this.html5_interaction = paramTable.get_StringList("html5_interaction");
      this.cancel = paramTable.get_StringList("cancel");
      this.download = paramTable.get_StringList("download");
      this.skip = paramTable.get_StringList("skip");
      this.info = paramTable.get_StringList("info");
      this.midpoint = paramTable.get_StringList("midpoint");
      this.card_dissolved = paramTable.get_StringList("card_dissolved");
      this.start = paramTable.get_StringList("start");
      this.third_quartile = paramTable.get_StringList("third_quartile");
      this.complete = paramTable.get_StringList("complete");
      this._continue = paramTable.get_StringList("continue");
      this.in_video_engagement = paramTable.get_StringList("in_video_engagement");
      this.reward_v4vc = paramTable.get_StringList("reward_v4vc");
      this.first_quartile = paramTable.get_StringList("first_quartile");
      this.lookup.put("replay", this.replay);
      this.lookup.put("card_shown", this.card_shown);
      this.lookup.put("html5_interaction", this.html5_interaction);
      this.lookup.put("cancel", this.cancel);
      this.lookup.put("download", this.download);
      this.lookup.put("skip", this.skip);
      this.lookup.put("info", this.info);
      this.lookup.put("midpoint", this.midpoint);
      this.lookup.put("card_dissolved", this.card_dissolved);
      this.lookup.put("start", this.start);
      this.lookup.put("third_quartile", this.third_quartile);
      this.lookup.put("complete", this.complete);
      this.lookup.put("continue", this._continue);
      this.lookup.put("in_video_engagement", this.in_video_engagement);
      this.lookup.put("reward_v4vc", this.reward_v4vc);
      this.lookup.put("first_quartile", this.first_quartile);
      return true;
    }
  }
  
  static class V4VCLimits
  {
    int custom_play_cap;
    int custom_play_cap_period;
    int daily_play_cap;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return false;
      }
      this.daily_play_cap = paramTable.get_Integer("daily_play_cap");
      this.custom_play_cap = paramTable.get_Integer("custom_play_cap");
      this.custom_play_cap_period = paramTable.get_Integer("custom_play_cap_period");
      return true;
    }
  }
  
  static class Video
  {
    String audio_channels;
    String audio_codec;
    String audio_sample_rate;
    double duration;
    boolean enabled;
    int height;
    ADCManifest.ButtonInfo in_video_engagement;
    String last_modified;
    ADCManifest.ButtonInfo skip_video;
    String url;
    String video_codec;
    String video_frame_rate;
    int width;
    
    void cache_media()
    {
      ADC.controller.media_manager.cache(this.url, this.last_modified);
      this.in_video_engagement.cache_media();
      this.skip_video.cache_media();
    }
    
    String filepath()
    {
      return ADC.controller.media_manager.local_filepath(this.url);
    }
    
    boolean is_ready()
    {
      if (!this.enabled) {}
      do
      {
        return true;
        if (!ADC.controller.media_manager.is_cached(this.url)) {
          return false;
        }
        if (!this.skip_video.is_ready()) {
          return false;
        }
        if (!this.in_video_engagement.is_ready()) {
          return false;
        }
        if ((ADC.controller.ad_manager.app.view_network_pass_filter.equals("online")) && (!ADCNetwork.connected())) {
          return ADCLog.info.fail("Video not ready due to VIEW_FILTER_ONLINE");
        }
        if ((ADC.controller.ad_manager.app.view_network_pass_filter.equals("wifi")) && (!ADCNetwork.using_wifi())) {
          return ADCLog.info.fail("Video not ready due to VIEW_FILTER_WIFI");
        }
        if ((ADC.controller.ad_manager.app.view_network_pass_filter.equals("cell")) && (!ADCNetwork.using_mobile())) {
          return ADCLog.info.fail("Video not ready due to VIEW_FILTER_CELL");
        }
      } while ((!ADC.controller.ad_manager.app.view_network_pass_filter.equals("offline")) || (!ADCNetwork.connected()));
      return ADCLog.info.fail("Video not ready due to VIEW_FILTER_OFFLINE");
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          return false;
          this.enabled = paramTable.get_Logical("enabled");
          if (!this.enabled) {
            return true;
          }
          this.width = paramTable.get_Integer("width");
          this.height = paramTable.get_Integer("height");
          this.url = paramTable.get_String("url");
          this.last_modified = paramTable.get_String("last_modified");
          this.video_frame_rate = paramTable.get_String("video_frame_rate");
          this.audio_channels = paramTable.get_String("audio_channels");
          this.audio_codec = paramTable.get_String("audio_codec");
          this.audio_sample_rate = paramTable.get_String("audio_sample_rate");
          this.video_codec = paramTable.get_String("video_codec");
          this.duration = paramTable.get_Real("duration");
          this.skip_video = new ADCManifest.ButtonInfo();
        } while (!this.skip_video.parse(paramTable.get_Table("skip_video")));
        this.in_video_engagement = new ADCManifest.ButtonInfo();
      } while (!this.in_video_engagement.parse(paramTable.get_Table("in_video_engagement")));
      return true;
    }
  }
  
  static class Zone
  {
    boolean active;
    ADCManifest.Ads ads;
    int daily_play_cap;
    boolean enabled;
    int play_interval;
    ArrayList<String> play_order;
    int session_play_cap;
    ADCZoneState state;
    String uuid;
    ADCManifest.ZoneV4VC v4vc;
    ADCManifest.ZoneTracking zone_tracking;
    
    void advance_play_index()
    {
      this.state.play_order_index = ((this.state.play_order_index + 1) % this.play_order.size());
    }
    
    void cache_media()
    {
      if ((!this.enabled) || (!this.active)) {}
      for (;;)
      {
        return;
        int i = 0;
        while (i < this.ads.count())
        {
          this.ads.get(i).cache_media();
          i += 1;
        }
      }
    }
    
    boolean check_for_skip_due_to_interval()
    {
      if (this.play_interval <= 1) {}
      int i;
      do
      {
        return false;
        ADC.controller.zone_state_manager.modified = true;
        ADCZoneState localADCZoneState = this.state;
        i = localADCZoneState.skipped_plays;
        localADCZoneState.skipped_plays = (i + 1);
      } while (i == 0);
      if (this.state.skipped_plays >= this.play_interval) {
        this.state.skipped_plays = 0;
      }
      return true;
    }
    
    int combine_results(int paramInt1, int paramInt2)
    {
      int i;
      if (paramInt2 <= 0) {
        i = 0;
      }
      do
      {
        return i;
        i = paramInt2;
      } while (paramInt1 == -1);
      if (paramInt1 < paramInt2) {}
      for (;;)
      {
        return paramInt1;
        paramInt1 = paramInt2;
      }
    }
    
    ADCManifest.Ad current_ad()
    {
      return this.ads.find((String)this.play_order.get(this.state.play_order_index % this.play_order.size()));
    }
    
    int get_available_plays()
    {
      try
      {
        int i = get_available_plays(current_ad());
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    int get_available_plays(ADCManifest.Ad paramAd)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   5: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   8: aload_0
      //   9: getfield 117	com/jirbo/adcolony/ADCManifest$Zone:uuid	Ljava/lang/String;
      //   12: invokevirtual 123	com/jirbo/adcolony/ADCPlayHistory:zone_daily_play_count	(Ljava/lang/String;)I
      //   15: istore 4
      //   17: iconst_m1
      //   18: istore_2
      //   19: aload_1
      //   20: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   23: getfield 132	com/jirbo/adcolony/ADCManifest$Limits:volatile_expiration	I
      //   26: istore_3
      //   27: iload_3
      //   28: ifeq +45 -> 73
      //   31: getstatic 136	com/jirbo/adcolony/ADC:last_config_ms	J
      //   34: lconst_0
      //   35: lcmp
      //   36: ifeq +37 -> 73
      //   39: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   42: getstatic 136	com/jirbo/adcolony/ADC:last_config_ms	J
      //   45: lsub
      //   46: ldc2_w 143
      //   49: ldiv
      //   50: iload_3
      //   51: i2l
      //   52: lcmp
      //   53: iflt +20 -> 73
      //   56: aload_0
      //   57: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   60: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   63: ldc -101
      //   65: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   68: istore_2
      //   69: aload_0
      //   70: monitorexit
      //   71: iload_2
      //   72: ireturn
      //   73: aload_1
      //   74: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   77: getfield 161	com/jirbo/adcolony/ADCManifest$Limits:volatile_play_cap	I
      //   80: istore_3
      //   81: iload_3
      //   82: ifle +36 -> 118
      //   85: aload_0
      //   86: iconst_m1
      //   87: iload_3
      //   88: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   91: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   94: aload_1
      //   95: getfield 164	com/jirbo/adcolony/ADCManifest$Ad:ad_id	I
      //   98: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   101: getstatic 136	com/jirbo/adcolony/ADC:last_config_ms	J
      //   104: lsub
      //   105: ldc2_w 143
      //   108: ldiv
      //   109: l2d
      //   110: invokevirtual 168	com/jirbo/adcolony/ADCPlayHistory:ad_interval_play_count	(ID)I
      //   113: isub
      //   114: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   117: istore_2
      //   118: iload_2
      //   119: ifne +23 -> 142
      //   122: iload_3
      //   123: ifeq +19 -> 142
      //   126: aload_0
      //   127: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   130: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   133: ldc -84
      //   135: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   138: istore_2
      //   139: goto -70 -> 69
      //   142: aload_0
      //   143: getfield 174	com/jirbo/adcolony/ADCManifest$Zone:daily_play_cap	I
      //   146: istore 5
      //   148: iload_2
      //   149: istore_3
      //   150: iload 5
      //   152: ifle +14 -> 166
      //   155: aload_0
      //   156: iload_2
      //   157: iload 5
      //   159: iload 4
      //   161: isub
      //   162: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   165: istore_3
      //   166: iload_3
      //   167: ifne +35 -> 202
      //   170: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   173: new 176	java/lang/StringBuilder
      //   176: dup
      //   177: invokespecial 177	java/lang/StringBuilder:<init>	()V
      //   180: ldc -77
      //   182: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   185: aload_0
      //   186: getfield 117	com/jirbo/adcolony/ADCManifest$Zone:uuid	Ljava/lang/String;
      //   189: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   192: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   195: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   198: istore_2
      //   199: goto -130 -> 69
      //   202: aload_0
      //   203: getfield 189	com/jirbo/adcolony/ADCManifest$Zone:session_play_cap	I
      //   206: istore 5
      //   208: iload_3
      //   209: istore_2
      //   210: iload 5
      //   212: ifle +25 -> 237
      //   215: aload_0
      //   216: iload_3
      //   217: iload 5
      //   219: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   222: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   225: aload_0
      //   226: getfield 117	com/jirbo/adcolony/ADCManifest$Zone:uuid	Ljava/lang/String;
      //   229: invokevirtual 192	com/jirbo/adcolony/ADCPlayHistory:zone_session_play_count	(Ljava/lang/String;)I
      //   232: isub
      //   233: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   236: istore_2
      //   237: iload_2
      //   238: ifne +35 -> 273
      //   241: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   244: new 176	java/lang/StringBuilder
      //   247: dup
      //   248: invokespecial 177	java/lang/StringBuilder:<init>	()V
      //   251: ldc -62
      //   253: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   256: aload_0
      //   257: getfield 117	com/jirbo/adcolony/ADCManifest$Zone:uuid	Ljava/lang/String;
      //   260: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   266: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   269: istore_2
      //   270: goto -201 -> 69
      //   273: iload_2
      //   274: istore_3
      //   275: aload_0
      //   276: getfield 196	com/jirbo/adcolony/ADCManifest$Zone:v4vc	Lcom/jirbo/adcolony/ADCManifest$ZoneV4VC;
      //   279: getfield 199	com/jirbo/adcolony/ADCManifest$ZoneV4VC:enabled	Z
      //   282: ifeq +123 -> 405
      //   285: aload_0
      //   286: getfield 196	com/jirbo/adcolony/ADCManifest$Zone:v4vc	Lcom/jirbo/adcolony/ADCManifest$ZoneV4VC;
      //   289: getfield 202	com/jirbo/adcolony/ADCManifest$ZoneV4VC:limits	Lcom/jirbo/adcolony/ADCManifest$V4VCLimits;
      //   292: getfield 205	com/jirbo/adcolony/ADCManifest$V4VCLimits:daily_play_cap	I
      //   295: istore 5
      //   297: iload_2
      //   298: istore_3
      //   299: iload 5
      //   301: ifle +14 -> 315
      //   304: aload_0
      //   305: iload_2
      //   306: iload 5
      //   308: iload 4
      //   310: isub
      //   311: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   314: istore_3
      //   315: iload_3
      //   316: ifne +15 -> 331
      //   319: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   322: ldc -49
      //   324: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   327: istore_2
      //   328: goto -259 -> 69
      //   331: aload_0
      //   332: getfield 196	com/jirbo/adcolony/ADCManifest$Zone:v4vc	Lcom/jirbo/adcolony/ADCManifest$ZoneV4VC;
      //   335: getfield 202	com/jirbo/adcolony/ADCManifest$ZoneV4VC:limits	Lcom/jirbo/adcolony/ADCManifest$V4VCLimits;
      //   338: getfield 210	com/jirbo/adcolony/ADCManifest$V4VCLimits:custom_play_cap_period	I
      //   341: istore 4
      //   343: aload_0
      //   344: getfield 196	com/jirbo/adcolony/ADCManifest$Zone:v4vc	Lcom/jirbo/adcolony/ADCManifest$ZoneV4VC;
      //   347: getfield 202	com/jirbo/adcolony/ADCManifest$ZoneV4VC:limits	Lcom/jirbo/adcolony/ADCManifest$V4VCLimits;
      //   350: getfield 213	com/jirbo/adcolony/ADCManifest$V4VCLimits:custom_play_cap	I
      //   353: istore 5
      //   355: iload_3
      //   356: istore_2
      //   357: iload 5
      //   359: ifle +28 -> 387
      //   362: aload_0
      //   363: iload_3
      //   364: iload 5
      //   366: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   369: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   372: aload_0
      //   373: getfield 117	com/jirbo/adcolony/ADCManifest$Zone:uuid	Ljava/lang/String;
      //   376: iload 4
      //   378: i2d
      //   379: invokevirtual 217	com/jirbo/adcolony/ADCPlayHistory:zone_interval_play_count	(Ljava/lang/String;D)I
      //   382: isub
      //   383: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   386: istore_2
      //   387: iload_2
      //   388: istore_3
      //   389: iload_2
      //   390: ifne +15 -> 405
      //   393: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   396: ldc -37
      //   398: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   401: istore_2
      //   402: goto -333 -> 69
      //   405: aload_1
      //   406: getfield 164	com/jirbo/adcolony/ADCManifest$Ad:ad_id	I
      //   409: istore 5
      //   411: aload_1
      //   412: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   415: getfield 220	com/jirbo/adcolony/ADCManifest$Limits:daily_play_cap	I
      //   418: istore 4
      //   420: iload_3
      //   421: istore_2
      //   422: iload 4
      //   424: ifle +23 -> 447
      //   427: aload_0
      //   428: iload_3
      //   429: iload 4
      //   431: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   434: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   437: iload 5
      //   439: invokevirtual 224	com/jirbo/adcolony/ADCPlayHistory:ad_daily_play_count	(I)I
      //   442: isub
      //   443: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   446: istore_2
      //   447: iload_2
      //   448: ifne +19 -> 467
      //   451: aload_0
      //   452: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   455: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   458: ldc -30
      //   460: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   463: istore_2
      //   464: goto -395 -> 69
      //   467: aload_1
      //   468: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   471: getfield 229	com/jirbo/adcolony/ADCManifest$Limits:weekly_play_cap	I
      //   474: istore 4
      //   476: iload_2
      //   477: istore_3
      //   478: iload 4
      //   480: ifle +23 -> 503
      //   483: aload_0
      //   484: iload_2
      //   485: iload 4
      //   487: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   490: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   493: iload 5
      //   495: invokevirtual 232	com/jirbo/adcolony/ADCPlayHistory:ad_weekly_play_count	(I)I
      //   498: isub
      //   499: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   502: istore_3
      //   503: iload_3
      //   504: ifne +19 -> 523
      //   507: aload_0
      //   508: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   511: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   514: ldc -22
      //   516: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   519: istore_2
      //   520: goto -451 -> 69
      //   523: aload_1
      //   524: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   527: getfield 237	com/jirbo/adcolony/ADCManifest$Limits:monthly_play_cap	I
      //   530: istore_2
      //   531: iload_3
      //   532: istore 4
      //   534: iload_2
      //   535: ifle +23 -> 558
      //   538: aload_0
      //   539: iload_3
      //   540: iload_2
      //   541: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   544: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   547: iload 5
      //   549: invokevirtual 240	com/jirbo/adcolony/ADCPlayHistory:ad_monthly_play_count	(I)I
      //   552: isub
      //   553: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   556: istore 4
      //   558: iload 4
      //   560: ifne +19 -> 579
      //   563: aload_0
      //   564: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   567: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   570: ldc -14
      //   572: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   575: istore_2
      //   576: goto -507 -> 69
      //   579: aload_1
      //   580: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   583: getfield 245	com/jirbo/adcolony/ADCManifest$Limits:total_play_cap	I
      //   586: istore_3
      //   587: iload 4
      //   589: istore_2
      //   590: iload_3
      //   591: ifle +23 -> 614
      //   594: aload_0
      //   595: iload 4
      //   597: iload_3
      //   598: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   601: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   604: iload 5
      //   606: invokevirtual 248	com/jirbo/adcolony/ADCPlayHistory:ad_half_year_play_count	(I)I
      //   609: isub
      //   610: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   613: istore_2
      //   614: iload_2
      //   615: ifne +19 -> 634
      //   618: aload_0
      //   619: invokevirtual 147	com/jirbo/adcolony/ADCManifest$Zone:try_refresh	()V
      //   622: getstatic 153	com/jirbo/adcolony/ADCLog:info	Lcom/jirbo/adcolony/ADCLog;
      //   625: ldc -6
      //   627: invokevirtual 158	com/jirbo/adcolony/ADCLog:int_fail	(Ljava/lang/String;)I
      //   630: istore_2
      //   631: goto -562 -> 69
      //   634: aload_1
      //   635: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   638: getfield 251	com/jirbo/adcolony/ADCManifest$Limits:custom_play_cap_period	I
      //   641: istore 4
      //   643: aload_1
      //   644: getfield 127	com/jirbo/adcolony/ADCManifest$Ad:limits	Lcom/jirbo/adcolony/ADCManifest$Limits;
      //   647: getfield 252	com/jirbo/adcolony/ADCManifest$Limits:custom_play_cap	I
      //   650: istore 6
      //   652: iload_2
      //   653: istore_3
      //   654: iload 6
      //   656: ifle +26 -> 682
      //   659: aload_0
      //   660: iload_2
      //   661: iload 6
      //   663: getstatic 78	com/jirbo/adcolony/ADC:controller	Lcom/jirbo/adcolony/ADCController;
      //   666: getfield 115	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
      //   669: iload 5
      //   671: iload 4
      //   673: i2d
      //   674: invokevirtual 168	com/jirbo/adcolony/ADCPlayHistory:ad_interval_play_count	(ID)I
      //   677: isub
      //   678: invokevirtual 170	com/jirbo/adcolony/ADCManifest$Zone:combine_results	(II)I
      //   681: istore_3
      //   682: iload_3
      //   683: istore_2
      //   684: goto -615 -> 69
      //   687: astore_1
      //   688: aload_0
      //   689: monitorexit
      //   690: aload_1
      //   691: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	692	0	this	Zone
      //   0	692	1	paramAd	ADCManifest.Ad
      //   18	666	2	i	int
      //   26	657	3	j	int
      //   15	657	4	k	int
      //   146	524	5	m	int
      //   650	28	6	n	int
      // Exception table:
      //   from	to	target	type
      //   2	17	687	finally
      //   19	27	687	finally
      //   31	69	687	finally
      //   73	81	687	finally
      //   85	118	687	finally
      //   126	139	687	finally
      //   142	148	687	finally
      //   155	166	687	finally
      //   170	199	687	finally
      //   202	208	687	finally
      //   215	237	687	finally
      //   241	270	687	finally
      //   275	297	687	finally
      //   304	315	687	finally
      //   319	328	687	finally
      //   331	355	687	finally
      //   362	387	687	finally
      //   393	402	687	finally
      //   405	420	687	finally
      //   427	447	687	finally
      //   451	464	687	finally
      //   467	476	687	finally
      //   483	503	687	finally
      //   507	520	687	finally
      //   523	531	687	finally
      //   538	558	687	finally
      //   563	576	687	finally
      //   579	587	687	finally
      //   594	614	687	finally
      //   618	631	687	finally
      //   634	652	687	finally
      //   659	682	687	finally
    }
    
    boolean is_ad_available()
    {
      return is_ad_available(false, true);
    }
    
    boolean is_ad_available(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (!paramBoolean2) {
        return is_ad_available_errorless(paramBoolean1);
      }
      if ((!this.enabled) || (!this.active)) {
        return ADCLog.info.fail("Ad is not ready to be played, as zone " + this.uuid + " is disabled or inactive.");
      }
      if ((this.ads.count() == 0) || (this.play_order.size() == 0)) {
        return ADCLog.info.fail("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.uuid + ".");
      }
      int j = this.play_order.size();
      Object localObject2 = null;
      int i = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = current_ad();
          if (localObject1 == null) {
            return ADCLog.info.fail("Ad is not ready to be played due to an unknown error.");
          }
          if (!((ADCManifest.Ad)localObject1).is_ready()) {}
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          return ADCLog.info.fail("Ad is not ready to be played as required assets are still downloading or otherwise missing.");
        }
        advance_play_index();
        i += 1;
      }
      return get_available_plays((ADCManifest.Ad)localObject1) != 0;
    }
    
    boolean is_ad_available_errorless(boolean paramBoolean)
    {
      if (!paramBoolean) {
        ADC.has_ad_availability_changed();
      }
      if ((!this.enabled) || (!this.active)) {}
      while ((this.ads.count() == 0) || (this.play_order.size() == 0)) {
        return false;
      }
      int j = this.play_order.size();
      Object localObject2 = null;
      int i = 0;
      for (;;)
      {
        Object localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = current_ad();
          if (localObject1 == null) {
            break;
          }
          if (!((ADCManifest.Ad)localObject1).is_ready()) {
            break label100;
          }
        }
        if ((localObject1 == null) || (get_available_plays((ADCManifest.Ad)localObject1) == 0)) {
          break;
        }
        return true;
        label100:
        advance_play_index();
        i += 1;
      }
    }
    
    boolean is_v4vc_zone()
    {
      return is_v4vc_zone(true);
    }
    
    boolean is_v4vc_zone(boolean paramBoolean)
    {
      if (!paramBoolean) {
        return is_v4vc_zone_errorless();
      }
      if ((!this.enabled) || (!this.active)) {
        return ADCLog.info.fail("Ad is not ready, as zone " + this.uuid + " is disabled or inactive.");
      }
      if (this.ads.count() == 0) {
        return ADCLog.info.fail("Ad is not ready, as there are currently no ads to play in zone " + this.uuid + ".");
      }
      if (this.ads.first().v4vc.enabled) {
        return true;
      }
      return ADCLog.info.fail("Ad is not ready, as zone " + this.uuid + " is not V4VC enabled and must be played using an AdColonyVideoAd object.");
    }
    
    boolean is_v4vc_zone_errorless()
    {
      if ((!this.enabled) || (!this.active)) {}
      while ((this.ads.count() == 0) || (!this.ads.first().v4vc.enabled)) {
        return false;
      }
      return true;
    }
    
    boolean is_video_zone()
    {
      return is_video_zone(true);
    }
    
    boolean is_video_zone(boolean paramBoolean)
    {
      if (!paramBoolean) {
        return is_video_zone_errorless();
      }
      if ((!this.enabled) || (!this.active)) {
        return ADCLog.info.fail("Ad is not ready, as zone " + this.uuid + " is disabled or inactive.");
      }
      if (this.ads.count() == 0) {
        return ADCLog.info.fail("Ad is not ready, as there are currently no ads to play in zone " + this.uuid + ".");
      }
      if (this.ads.first().v4vc.enabled) {
        return ADCLog.info.fail("Ad is not ready, as zone " + this.uuid + " is V4VC enabled and must be played using an AdColonyV4VCAd object.");
      }
      return true;
    }
    
    boolean is_video_zone_errorless()
    {
      if ((!this.enabled) || (!this.active)) {}
      while ((this.ads.count() == 0) || (this.ads.first().v4vc.enabled)) {
        return false;
      }
      return true;
    }
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        do
        {
          do
          {
            ArrayList localArrayList;
            do
            {
              return false;
              this.uuid = paramTable.get_String("uuid");
              this.enabled = paramTable.get_Logical("enabled");
              this.active = paramTable.get_Logical("active");
              if ((!this.enabled) || (!this.active)) {
                return true;
              }
              this.play_interval = paramTable.get_Integer("play_interval");
              this.daily_play_cap = paramTable.get_Integer("daily_play_cap");
              this.session_play_cap = paramTable.get_Integer("session_play_cap");
              this.play_order = new ArrayList();
              localArrayList = paramTable.get_StringList("play_order");
              this.play_order = localArrayList;
            } while (localArrayList == null);
            this.zone_tracking = new ADCManifest.ZoneTracking();
          } while (!this.zone_tracking.parse(paramTable.get_Table("tracking")));
          this.ads = new ADCManifest.Ads();
        } while (!this.ads.parse(paramTable.get_List("ads")));
        this.v4vc = new ADCManifest.ZoneV4VC();
      } while (!this.v4vc.parse(paramTable.get_Table("v4vc")));
      this.state = ADC.controller.zone_state_manager.find(this.uuid);
      return true;
    }
    
    void try_refresh()
    {
      ADC.controller.ad_manager.refresh();
    }
  }
  
  static class ZoneTracking
  {
    String request;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {
        return true;
      }
      this.request = paramTable.get_String("request", null);
      return true;
    }
  }
  
  static class ZoneV4VC
  {
    boolean client_side;
    boolean enabled;
    ADCManifest.V4VCLimits limits;
    int reward_amount;
    String reward_name;
    int videos_per_reward;
    
    boolean parse(ADCData.Table paramTable)
    {
      if (paramTable == null) {}
      do
      {
        return false;
        this.enabled = paramTable.get_Logical("enabled");
        if (!this.enabled) {
          return true;
        }
        this.limits = new ADCManifest.V4VCLimits();
      } while (!this.limits.parse(paramTable.get_Table("limits")));
      this.reward_amount = paramTable.get_Integer("reward_amount");
      this.reward_name = paramTable.get_String("reward_name");
      this.client_side = paramTable.get_Logical("client_side");
      this.videos_per_reward = paramTable.get_Integer("videos_per_reward");
      return true;
    }
  }
  
  static class Zones
  {
    ArrayList<ADCManifest.Zone> data;
    
    int count()
    {
      return this.data.size();
    }
    
    ADCManifest.Zone find(String paramString)
    {
      int i = 0;
      while (i < this.data.size())
      {
        ADCManifest.Zone localZone = (ADCManifest.Zone)this.data.get(i);
        if (localZone.uuid.equals(paramString)) {
          return localZone;
        }
        i += 1;
      }
      ADCLog.dev.print("No such zone: ").println(paramString);
      return null;
    }
    
    ADCManifest.Zone first()
    {
      return (ADCManifest.Zone)this.data.get(0);
    }
    
    ADCManifest.Zone get(int paramInt)
    {
      return (ADCManifest.Zone)this.data.get(paramInt);
    }
    
    boolean parse(ADCData.List paramList)
    {
      this.data = new ArrayList();
      if (paramList == null) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramList.count()) {
          break label63;
        }
        ADCManifest.Zone localZone = new ADCManifest.Zone();
        if (!localZone.parse(paramList.get_Table(i))) {
          break;
        }
        this.data.add(localZone);
        i += 1;
      }
      label63:
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCManifest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */