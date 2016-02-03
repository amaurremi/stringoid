package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

class ADCReportingManager
  implements ADCDownload.Listener
{
  int active_submissions = 0;
  ADCController controller;
  ArrayList<Event> culling_list = new ArrayList();
  boolean modified = false;
  ArrayList<Event> pending_events = new ArrayList();
  
  ADCReportingManager(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  void configure()
  {
    load();
    this.active_submissions = 0;
  }
  
  void dispatch_events()
  {
    if (this.pending_events.size() == 0) {}
    label217:
    for (;;)
    {
      return;
      while (this.pending_events.size() > 1000) {
        this.pending_events.remove(this.pending_events.size() - 1);
      }
      if (ADCNetwork.connected())
      {
        double d = ADCUtil.current_time();
        int i = 0;
        for (;;)
        {
          if (i >= this.pending_events.size()) {
            break label217;
          }
          Event localEvent = (Event)this.pending_events.get(i);
          if ((localEvent.next_attempt_time < d) && (!localEvent.submitting))
          {
            if (this.active_submissions == 5) {
              break;
            }
            this.active_submissions += 1;
            localEvent.submitting = true;
            ADCDownload localADCDownload = new ADCDownload(this.controller, localEvent.url, this).with_info(localEvent);
            if (localEvent.third_party) {
              localADCDownload.third_party_tracking = true;
            }
            if (localEvent.payload != null) {
              localADCDownload.with_post_data("application/json", localEvent.payload);
            }
            ADCLog.debug.print("Submitting '").print(localEvent.type).println("' event.");
            localADCDownload.start();
            ADC.active = true;
          }
          i += 1;
        }
      }
    }
  }
  
  void load()
  {
    ADC.active = true;
    ADCData.List localList = ADCJSON.load_List(new ADCDataFile("tracking_info.txt"));
    if (localList != null)
    {
      this.pending_events.clear();
      int i = 0;
      while (i < localList.count())
      {
        ADCData.Table localTable = localList.get_Table(i);
        Event localEvent = new Event();
        localEvent.type = localTable.get_String("type");
        localEvent.url = localTable.get_String("url");
        localEvent.payload = localTable.get_String("payload", null);
        localEvent.attempts = localTable.get_Integer("attempts");
        localEvent.third_party = localTable.get_Logical("third_party");
        if ((localEvent.type.equals("v4vc_callback")) || (localEvent.type.equals("reward_v4vc")))
        {
          localEvent.v4vc_name = localTable.get_String("v4vc_name");
          localEvent.v4vc_amount = localTable.get_Integer("v4vc_amount");
        }
        this.pending_events.add(localEvent);
        i += 1;
      }
    }
    ADCLog.dev.print("Loaded ").print(this.pending_events.size()).println(" events");
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    ADC.active = true;
    this.modified = true;
    this.active_submissions -= 1;
    Event localEvent1 = (Event)paramADCDownload.info;
    ADCLog.dev.print("on_download_finished - event.type = ").println(localEvent1.type);
    localEvent1.submitting = false;
    boolean bool2 = paramADCDownload.success;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (localEvent1.payload != null)
      {
        Object localObject = ADCJSON.parse_Table(paramADCDownload.data);
        if (localObject == null) {
          break label410;
        }
        bool2 = ((ADCData.Table)localObject).get_String("status").equals("success");
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (localEvent1.type.equals("reward_v4vc"))
          {
            if (!((ADCData.Table)localObject).get_Logical("v4vc_status")) {
              break label393;
            }
            localObject = ((ADCData.Table)localObject).get_String("v4vc_callback");
            if (((String)localObject).length() <= 0) {
              break label363;
            }
            Event localEvent2 = new Event();
            localEvent2.type = "v4vc_callback";
            localEvent2.url = ((String)localObject);
            localEvent2.v4vc_name = localEvent1.v4vc_name;
            localEvent2.v4vc_amount = localEvent1.v4vc_amount;
            this.pending_events.add(localEvent2);
            bool1 = bool2;
          }
        }
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (localEvent1.type.equals("v4vc_callback"))
      {
        ADCLog.dev.println("v4vc_callback response:").println(paramADCDownload.data);
        if (paramADCDownload.data.indexOf("vc_success") == -1) {
          break label416;
        }
        if (ADC.current_video != null) {
          ADC.current_video.rewarded = true;
        }
        ADCLog.dev.println("v4vc_callback success");
        this.controller.on_v4vc_result(true, localEvent1.v4vc_name, localEvent1.v4vc_amount);
        bool2 = bool1;
      }
    }
    label316:
    if (bool2)
    {
      ADCLog.dev.print("Event submission SUCCESS for type: ").println(localEvent1.type);
      localEvent1.discard = true;
    }
    for (;;)
    {
      if (!this.controller.session_manager.active) {
        save();
      }
      return;
      label363:
      if (ADC.current_video != null) {
        ADC.current_video.rewarded = true;
      }
      ADCLog.dev.println("Client-side V4VC success");
      bool1 = bool2;
      break;
      label393:
      ADCLog.dev.println("Client-side V4VC failure");
      bool1 = bool2;
      break;
      label410:
      bool1 = false;
      break;
      label416:
      if (paramADCDownload.data.indexOf("vc_decline") != -1)
      {
        ADCLog.info.print("Server-side V4VC failure: ").println(paramADCDownload.url);
        ADCLog.dev.println("v4vc_callback declined");
        this.controller.on_v4vc_result(false, "", 0);
        bool2 = bool1;
        break label316;
      }
      ADCLog.info.print("Server-side V4VC failure: ").println(paramADCDownload.url);
      bool2 = false;
      break label316;
      ADCLog.dev.print("Event submission FAILED for type: ").print(localEvent1.type).print(" on try ").println(localEvent1.attempts + 1);
      localEvent1.attempts += 1;
      if (localEvent1.attempts >= 24)
      {
        ADCLog.error.println("Discarding event after 24 attempts to report.");
        localEvent1.discard = true;
        if (localEvent1.type.equals("v4vc_callback")) {
          this.controller.on_v4vc_result(false, "", 0);
        }
      }
      else
      {
        int i = 20;
        if (localEvent1.next_attempt_delay > 0) {
          i = localEvent1.next_attempt_delay * 3;
        }
        int j = i;
        if (i > 10000) {
          j = 10000;
        }
        ADCLog.dev.print("Retrying in ").print(j).print(" seconds (attempt ").print(localEvent1.attempts).println(")");
        localEvent1.next_attempt_delay = j;
        localEvent1.next_attempt_time = (ADCUtil.current_time() + j);
      }
    }
  }
  
  void save()
  {
    this.culling_list.clear();
    this.culling_list.addAll(this.pending_events);
    this.pending_events.clear();
    ADCData.List localList = new ADCData.List();
    int i = 0;
    while (i < this.culling_list.size())
    {
      Event localEvent = (Event)this.culling_list.get(i);
      if (!localEvent.discard)
      {
        this.pending_events.add(localEvent);
        ADCData.Table localTable = new ADCData.Table();
        localTable.set("type", localEvent.type);
        localTable.set("url", localEvent.url);
        if (localEvent.payload != null) {
          localTable.set("payload", localEvent.payload);
        }
        localTable.set("attempts", localEvent.attempts);
        if (localEvent.v4vc_name != null)
        {
          localTable.set("v4vc_name", localEvent.v4vc_name);
          localTable.set("v4vc_amount", localEvent.v4vc_amount);
        }
        if (localEvent.third_party) {
          localTable.set("third_party", true);
        }
        localList.add(localTable);
      }
      i += 1;
    }
    this.culling_list.clear();
    ADCLog.dev.print("Saving tracking_info (").print(this.pending_events.size()).println(" events)");
    ADCJSON.save(new ADCDataFile("tracking_info.txt"), localList);
  }
  
  void track_ad_event(String paramString)
  {
    track_ad_event(paramString, null);
  }
  
  void track_ad_event(String paramString, ADCData.Table paramTable)
  {
    if (paramString == null)
    {
      ADCLog.error.println("No such event type:").println(paramString);
      return;
    }
    track_adcolony_event(paramString, this.controller.configuration.current_ad.ad_tracking.lookup.get_String(paramString), paramTable);
    track_third_party_event(paramString, (ArrayList)this.controller.configuration.current_ad.third_party_tracking.lookup.get(paramString));
  }
  
  void track_ad_request(String paramString)
  {
    if ((this.controller == null) || (this.controller.ad_manager == null) || (this.controller.ad_manager.app == null) || (this.controller.ad_manager.app.zones == null) || (this.controller.ad_manager.app.zones.find(paramString) == null)) {}
    do
    {
      return;
      ADCLog.dev.print("Ad request for zone ").println(paramString);
      paramString = this.controller.ad_manager.app.zones.find(paramString);
    } while ((paramString == null) || (paramString.zone_tracking == null) || (paramString.zone_tracking.request == null));
    track_adcolony_event("request", paramString.zone_tracking.request, null);
    ADCLog.dev.print("Tracking ad request - URL : ").println(paramString.zone_tracking.request);
  }
  
  void track_adcolony_event(String paramString1, String paramString2, ADCData.Table paramTable)
  {
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ADCData.Table localTable = paramTable;
    if (paramTable == null) {
      localTable = new ADCData.Table();
    }
    paramTable = ADCUtil.create_uuid();
    localTable.set("asi", this.controller.session_manager.current_session_id);
    localTable.set("guid", paramTable);
    localTable.set("guid_key", ADCUtil.calculate_sha1(paramTable + "DUBu6wJ27y6xs7VWmNDw67DD"));
    paramTable = new Event();
    paramTable.type = paramString1;
    paramTable.url = paramString2;
    ADCLog.dev.println("EVENT ----------------------------");
    ADCLog.dev.print("EVENT - TYPE = ").println(paramString1);
    ADCLog.dev.print("EVENT - URL  = ").println(paramString2);
    paramTable.payload = localTable.to_json();
    if (paramString1.equals("reward_v4vc"))
    {
      paramTable.v4vc_name = localTable.get_String("v4vc_name");
      paramTable.v4vc_amount = localTable.get_Integer("v4vc_amount");
    }
    this.pending_events.add(paramTable);
    this.modified = true;
    ADC.active = true;
  }
  
  void track_app_event(String paramString, ADCData.Table paramTable)
  {
    ADCManifest.AppTracking localAppTracking = this.controller.ad_manager.app.app_tracking;
    if (localAppTracking != null) {
      track_adcolony_event(paramString, localAppTracking.lookup.get_String(paramString), paramTable);
    }
    paramTable = this.controller.ad_manager.app.third_party_app_tracking;
    if (paramTable != null) {
      track_third_party_event(paramString, (ArrayList)paramTable.lookup.get(paramString));
    }
  }
  
  void track_third_party_event(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      Event localEvent = new Event();
      localEvent.type = paramString;
      localEvent.url = str;
      localEvent.third_party = true;
      this.pending_events.add(localEvent);
      i += 1;
    }
    this.modified = true;
    ADC.active = true;
  }
  
  void track_video_progress(double paramDouble)
  {
    double d = this.controller.configuration.current_progress;
    if (paramDouble < d) {
      return;
    }
    if ((d < 0.25D) && (paramDouble >= 0.25D)) {
      track_ad_event("first_quartile");
    }
    if ((d < 0.5D) && (paramDouble >= 0.5D)) {
      track_ad_event("midpoint");
    }
    if ((d < 0.75D) && (paramDouble >= 0.75D)) {
      track_ad_event("third_quartile");
    }
    if ((d < 1.0D) && (paramDouble >= 1.0D))
    {
      ADCLog.dev.print("Tracking ad event - complete");
      ADCData.Table localTable = new ADCData.Table();
      localTable.set("ad_slot", ADC.current_ad.zone_info.state.session_play_count);
      track_ad_event("complete", localTable);
    }
    this.controller.configuration.current_progress = paramDouble;
  }
  
  void update()
  {
    if (this.modified)
    {
      this.modified = false;
      save();
    }
    dispatch_events();
  }
  
  static class Event
  {
    int attempts;
    boolean discard;
    int next_attempt_delay;
    double next_attempt_time;
    String payload;
    boolean submitting;
    boolean third_party;
    String type;
    String url;
    int v4vc_amount;
    String v4vc_name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCReportingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */