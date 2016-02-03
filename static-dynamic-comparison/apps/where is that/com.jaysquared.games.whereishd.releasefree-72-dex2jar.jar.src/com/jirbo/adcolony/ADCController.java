package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;

class ADCController
{
  ADCAdManager ad_manager = new ADCAdManager(this);
  ADCConfiguration configuration = new ADCConfiguration(this);
  boolean dispatching_events;
  ArrayList<ADCEvent> event_queue = new ArrayList();
  ADCMediaManager media_manager = new ADCMediaManager(this);
  volatile boolean monitor_thread_active;
  ArrayList<ADCEvent> pending_events = new ArrayList();
  ADCPlayHistory play_history = new ADCPlayHistory(this);
  ADCReportingManager reporting_manager = new ADCReportingManager(this);
  ADCSessionManager session_manager = new ADCSessionManager(this);
  ADCStorage storage = new ADCStorage(this);
  ADCUtil.Stopwatch time_waiting_for_open_udid = new ADCUtil.Stopwatch();
  ADCZoneStateManager zone_state_manager = new ADCZoneStateManager(this);
  
  void configure(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      set_log_level(ADC.log_level);
      ADCLog.info.print("==== Configuring AdColony ").print(this.configuration.sdk_version).println(" ====");
      ADCLog.dev.print("package name: ").println(ADCUtil.package_name());
      this.configuration.app_id = paramString2;
      this.configuration.zone_ids = paramArrayOfString;
      this.configuration.parse_client_options(paramString1);
      this.time_waiting_for_open_udid.restart();
      return;
    }
    catch (RuntimeException paramString1)
    {
      for (;;)
      {
        ADC.on_fatal_error(paramString1);
      }
    }
    finally {}
  }
  
  void dispatch_events()
  {
    if (this.dispatching_events) {}
    while (!ADC.is_ready()) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((!this.dispatching_events) || ((!this.monitor_thread_active) && (this.event_queue.size() > 0)))
        {
          this.dispatching_events = true;
          this.pending_events.addAll(this.event_queue);
          this.event_queue.clear();
          i = 0;
          if (i < this.pending_events.size())
          {
            if (this.pending_events.get(i) == null) {
              break label144;
            }
            ((ADCEvent)this.pending_events.get(i)).dispatch();
            break label144;
          }
          this.pending_events.clear();
          continue;
        }
        this.dispatching_events = false;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.dispatching_events = false;
        this.pending_events.clear();
        this.event_queue.clear();
        ADC.on_fatal_error(localRuntimeException);
        return;
      }
      return;
      label144:
      i += 1;
    }
  }
  
  String find_v4vc_zone()
  {
    try
    {
      String str = this.ad_manager.find_v4vc_zone();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  String find_video_zone()
  {
    try
    {
      String str = this.ad_manager.find_video_zone();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int get_Integer(String paramString)
  {
    try
    {
      i = this.configuration.properties.get_Integer(paramString);
      return i;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        ADC.on_fatal_error(paramString);
        int i = 0;
      }
    }
    finally {}
  }
  
  boolean get_Logical(String paramString)
  {
    try
    {
      bool = this.configuration.properties.get_Logical(paramString);
      return bool;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        ADC.on_fatal_error(paramString);
        boolean bool = false;
      }
    }
    finally {}
  }
  
  double get_Real(String paramString)
  {
    try
    {
      d = this.configuration.properties.get_Real(paramString);
      return d;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        ADC.on_fatal_error(paramString);
        double d = 0.0D;
      }
    }
    finally {}
  }
  
  String get_String(String paramString)
  {
    try
    {
      paramString = this.configuration.properties.get_String(paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        ADC.on_fatal_error(paramString);
        paramString = null;
      }
    }
    finally {}
  }
  
  int get_reward_credit(String paramString)
  {
    try
    {
      int i = this.play_history.get_reward_credit(paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  ADCManifest.Zone get_zone_info(String paramString)
  {
    try
    {
      paramString = this.ad_manager.app.zones.find(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean is_v4vc_ad_available(String paramString)
  {
    try
    {
      boolean bool = is_v4vc_ad_available(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean is_v4vc_ad_available(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = ADC.is_ready();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        ADC.on_fatal_error(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.ad_manager.is_ad_available(paramString, paramBoolean1)) {
        bool1 = this.ad_manager.app.zones.find(paramString).is_v4vc_zone(paramBoolean2);
      }
    }
  }
  
  boolean is_video_ad_available(String paramString)
  {
    try
    {
      boolean bool = is_video_ad_available(paramString, false, true);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean is_video_ad_available(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = ADC.is_ready();
        if (bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (RuntimeException paramString)
      {
        ADC.on_fatal_error(paramString);
        boolean bool1 = bool2;
        continue;
      }
      finally {}
      return bool1;
      bool1 = bool2;
      if (this.ad_manager.is_ad_available(paramString, paramBoolean1)) {
        bool1 = this.ad_manager.app.zones.find(paramString).is_video_zone(paramBoolean2);
      }
    }
  }
  
  boolean launch_video()
  {
    for (;;)
    {
      try
      {
        if (this.configuration.current_zone.check_for_skip_due_to_interval())
        {
          ADC.current_ad.status = 3;
          bool = false;
          return bool;
        }
        on_video_start();
        ADCVideo.reset();
        if (ADC.is_tablet)
        {
          ADCLog.dev.println("Launching AdColonyOverlay");
          ADC.activity().startActivity(new Intent(ADC.activity(), AdColonyOverlay.class));
        }
        else
        {
          ADCLog.dev.println("Launching AdColonyFullscreen");
          ADC.activity().startActivity(new Intent(ADC.activity(), AdColonyFullscreen.class));
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  void on_resume()
  {
    this.monitor_thread_active = true;
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.session_manager.on_resume();
      }
    };
  }
  
  void on_stop()
  {
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.session_manager.on_stop();
      }
    };
  }
  
  void on_suspend()
  {
    this.monitor_thread_active = false;
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.session_manager.on_suspend();
      }
    };
  }
  
  void on_v4vc_result(boolean paramBoolean, String paramString, int paramInt)
  {
    try
    {
      ADC.v4vc_results_handler.notify_listeners(paramBoolean, paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  void on_video_finish(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: dconst_1
    //   4: invokevirtual 342	com/jirbo/adcolony/ADCController:on_video_progress	(D)V
    //   7: iload_1
    //   8: ifne +167 -> 175
    //   11: getstatic 278	com/jirbo/adcolony/ADC:current_ad	Lcom/jirbo/adcolony/AdColonyAd;
    //   14: invokevirtual 345	com/jirbo/adcolony/AdColonyAd:is_v4vc	()Z
    //   17: ifeq +158 -> 175
    //   20: getstatic 278	com/jirbo/adcolony/ADC:current_ad	Lcom/jirbo/adcolony/AdColonyAd;
    //   23: astore 6
    //   25: aload 6
    //   27: getfield 348	com/jirbo/adcolony/AdColonyAd:zone_info	Lcom/jirbo/adcolony/ADCManifest$Zone;
    //   30: invokevirtual 351	com/jirbo/adcolony/ADCManifest$Zone:advance_play_index	()V
    //   33: aload_0
    //   34: getfield 91	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
    //   37: aload 6
    //   39: getfield 354	com/jirbo/adcolony/AdColonyAd:zone_id	Ljava/lang/String;
    //   42: aload 6
    //   44: getfield 358	com/jirbo/adcolony/AdColonyAd:ad_info	Lcom/jirbo/adcolony/ADCManifest$Ad;
    //   47: getfield 363	com/jirbo/adcolony/ADCManifest$Ad:ad_id	I
    //   50: invokevirtual 367	com/jirbo/adcolony/ADCPlayHistory:add_play_event	(Ljava/lang/String;I)V
    //   53: getstatic 278	com/jirbo/adcolony/ADC:current_ad	Lcom/jirbo/adcolony/AdColonyAd;
    //   56: checkcast 369	com/jirbo/adcolony/AdColonyV4VCAd
    //   59: astore 6
    //   61: aload 6
    //   63: invokevirtual 372	com/jirbo/adcolony/AdColonyV4VCAd:getRewardName	()Ljava/lang/String;
    //   66: astore 7
    //   68: aload 6
    //   70: invokevirtual 375	com/jirbo/adcolony/AdColonyV4VCAd:getRewardAmount	()I
    //   73: istore 5
    //   75: iconst_1
    //   76: istore_2
    //   77: iconst_1
    //   78: istore_3
    //   79: aload 6
    //   81: invokevirtual 378	com/jirbo/adcolony/AdColonyV4VCAd:getViewsPerReward	()I
    //   84: istore 4
    //   86: iload 4
    //   88: iconst_1
    //   89: if_icmple +45 -> 134
    //   92: aload_0
    //   93: getfield 91	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
    //   96: aload 6
    //   98: invokevirtual 372	com/jirbo/adcolony/AdColonyV4VCAd:getRewardName	()Ljava/lang/String;
    //   101: invokevirtual 229	com/jirbo/adcolony/ADCPlayHistory:get_reward_credit	(Ljava/lang/String;)I
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: iload_2
    //   108: iload 4
    //   110: if_icmplt +68 -> 178
    //   113: iconst_0
    //   114: istore 4
    //   116: iload_3
    //   117: istore_2
    //   118: iload 4
    //   120: istore_3
    //   121: aload_0
    //   122: getfield 91	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
    //   125: aload 6
    //   127: invokevirtual 372	com/jirbo/adcolony/AdColonyV4VCAd:getRewardName	()Ljava/lang/String;
    //   130: iload_3
    //   131: invokevirtual 381	com/jirbo/adcolony/ADCPlayHistory:set_reward_credit	(Ljava/lang/String;I)V
    //   134: iload_2
    //   135: ifeq +40 -> 175
    //   138: aload 6
    //   140: getfield 382	com/jirbo/adcolony/AdColonyV4VCAd:zone_info	Lcom/jirbo/adcolony/ADCManifest$Zone;
    //   143: getfield 386	com/jirbo/adcolony/ADCManifest$Zone:v4vc	Lcom/jirbo/adcolony/ADCManifest$ZoneV4VC;
    //   146: getfield 391	com/jirbo/adcolony/ADCManifest$ZoneV4VC:client_side	Z
    //   149: ifeq +12 -> 161
    //   152: aload_0
    //   153: iconst_1
    //   154: aload 7
    //   156: iload 5
    //   158: invokevirtual 393	com/jirbo/adcolony/ADCController:on_v4vc_result	(ZLjava/lang/String;I)V
    //   161: new 16	com/jirbo/adcolony/ADCController$6
    //   164: dup
    //   165: aload_0
    //   166: aload_0
    //   167: aload 7
    //   169: iload 5
    //   171: invokespecial 396	com/jirbo/adcolony/ADCController$6:<init>	(Lcom/jirbo/adcolony/ADCController;Lcom/jirbo/adcolony/ADCController;Ljava/lang/String;I)V
    //   174: pop
    //   175: aload_0
    //   176: monitorexit
    //   177: return
    //   178: iconst_0
    //   179: istore 4
    //   181: iload_2
    //   182: istore_3
    //   183: iload 4
    //   185: istore_2
    //   186: goto -65 -> 121
    //   189: astore 6
    //   191: aload_0
    //   192: monitorexit
    //   193: aload 6
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	ADCController
    //   0	196	1	paramBoolean	boolean
    //   76	110	2	i	int
    //   78	105	3	j	int
    //   84	100	4	k	int
    //   73	97	5	m	int
    //   23	116	6	localObject1	Object
    //   189	5	6	localObject2	Object
    //   66	102	7	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	189	finally
    //   11	75	189	finally
    //   79	86	189	finally
    //   92	107	189	finally
    //   121	134	189	finally
    //   138	161	189	finally
    //   161	175	189	finally
  }
  
  void on_video_progress(final double paramDouble)
  {
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.reporting_manager.track_video_progress(paramDouble);
      }
    };
  }
  
  void on_video_start()
  {
    try
    {
      this.configuration.current_progress = 0.0D;
      ADCLog.dev.println("Tracking ad event - start");
      final AdColonyAd localAdColonyAd = ADC.current_ad;
      ADCZoneState localADCZoneState = localAdColonyAd.zone_info.state;
      localADCZoneState.session_play_count += 1;
      if (!ADC.current_ad.is_v4vc())
      {
        localAdColonyAd.zone_info.advance_play_index();
        this.play_history.add_play_event(localAdColonyAd.zone_id, localAdColonyAd.ad_info.ad_id);
      }
      new ADCEvent(this)
      {
        void dispatch()
        {
          ADCController.this.track_ad_event("start", "{\"ad_slot\":" + localAdColonyAd.zone_info.state.session_play_count + "}");
        }
      };
      return;
    }
    finally {}
  }
  
  void prepare_v4vc_ad(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    try
    {
      this.configuration.prepare_v4vc_ad(paramAdColonyV4VCAd.zone_id);
      return;
    }
    finally
    {
      paramAdColonyV4VCAd = finally;
      throw paramAdColonyV4VCAd;
    }
  }
  
  void prepare_video_ad(AdColonyVideoAd paramAdColonyVideoAd)
  {
    try
    {
      this.configuration.prepare_video_ad(paramAdColonyVideoAd.zone_id);
      return;
    }
    finally
    {
      paramAdColonyVideoAd = finally;
      throw paramAdColonyVideoAd;
    }
  }
  
  void queue_event(ADCEvent paramADCEvent)
  {
    synchronized (this.event_queue)
    {
      if (!ADC.is_ready()) {
        return;
      }
      this.event_queue.add(paramADCEvent);
      if (!this.monitor_thread_active) {
        update();
      }
      return;
    }
  }
  
  void set_log_level(int paramInt)
  {
    ADC.set_log_level(paramInt);
  }
  
  void set_reward_credit(String paramString, int paramInt)
  {
    try
    {
      this.play_history.set_reward_credit(paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  boolean show_v4vc_ad(AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        ADC.current_ad = paramAdColonyV4VCAd;
        str = paramAdColonyV4VCAd.zone_id;
        bool2 = is_v4vc_ad_available(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyV4VCAd)
      {
        String str;
        boolean bool2;
        ADC.on_fatal_error(paramAdColonyV4VCAd);
        continue;
      }
      finally {}
      return bool1;
      ADCLog.dev.print("Showing v4vc for zone ").println(str);
      prepare_v4vc_ad(paramAdColonyV4VCAd);
      bool2 = launch_video();
      bool1 = bool2;
    }
  }
  
  boolean show_video_ad(AdColonyVideoAd paramAdColonyVideoAd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        ADC.current_ad = paramAdColonyVideoAd;
        str = paramAdColonyVideoAd.zone_id;
        bool2 = is_video_ad_available(str);
        if (bool2) {
          continue;
        }
      }
      catch (RuntimeException paramAdColonyVideoAd)
      {
        String str;
        boolean bool2;
        ADC.on_fatal_error(paramAdColonyVideoAd);
        continue;
      }
      finally {}
      return bool1;
      ADCLog.dev.print("Showing ad for zone ").println(str);
      prepare_video_ad(paramAdColonyVideoAd);
      bool2 = launch_video();
      bool1 = bool2;
    }
  }
  
  void track_ad_event(final String paramString1, final String paramString2)
  {
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.reporting_manager.track_ad_event(paramString1, ADCJSON.parse_Table(paramString2));
      }
    };
  }
  
  void track_app_event(final String paramString1, final String paramString2)
  {
    new ADCEvent(this)
    {
      void dispatch()
      {
        this.controller.reporting_manager.track_app_event(paramString1, ADCJSON.parse_Table(paramString2));
      }
    };
  }
  
  /* Error */
  void update()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 467	com/jirbo/adcolony/ADC:disabled	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 469	com/jirbo/adcolony/ADCController:dispatch_events	()V
    //   17: getstatic 472	com/jirbo/adcolony/ADC:configured	Z
    //   20: ifne +38 -> 58
    //   23: invokestatic 477	com/jirbo/adcolony/ADCDevice:open_udid	()Ljava/lang/String;
    //   26: ifnonnull +17 -> 43
    //   29: aload_0
    //   30: getfield 103	com/jirbo/adcolony/ADCController:time_waiting_for_open_udid	Lcom/jirbo/adcolony/ADCUtil$Stopwatch;
    //   33: invokevirtual 481	com/jirbo/adcolony/ADCUtil$Stopwatch:elapsed_seconds	()D
    //   36: ldc2_w 482
    //   39: dcmpl
    //   40: ifle +14 -> 54
    //   43: aload_0
    //   44: getfield 56	com/jirbo/adcolony/ADCController:configuration	Lcom/jirbo/adcolony/ADCConfiguration;
    //   47: invokevirtual 485	com/jirbo/adcolony/ADCConfiguration:configure	()V
    //   50: iconst_1
    //   51: putstatic 472	com/jirbo/adcolony/ADC:configured	Z
    //   54: iconst_1
    //   55: putstatic 488	com/jirbo/adcolony/ADC:active	Z
    //   58: aload_0
    //   59: getfield 61	com/jirbo/adcolony/ADCController:ad_manager	Lcom/jirbo/adcolony/ADCAdManager;
    //   62: invokevirtual 489	com/jirbo/adcolony/ADCAdManager:update	()V
    //   65: aload_0
    //   66: getfield 66	com/jirbo/adcolony/ADCController:media_manager	Lcom/jirbo/adcolony/ADCMediaManager;
    //   69: invokevirtual 490	com/jirbo/adcolony/ADCMediaManager:update	()V
    //   72: aload_0
    //   73: getfield 76	com/jirbo/adcolony/ADCController:session_manager	Lcom/jirbo/adcolony/ADCSessionManager;
    //   76: invokevirtual 491	com/jirbo/adcolony/ADCSessionManager:update	()V
    //   79: aload_0
    //   80: getfield 71	com/jirbo/adcolony/ADCController:reporting_manager	Lcom/jirbo/adcolony/ADCReportingManager;
    //   83: invokevirtual 492	com/jirbo/adcolony/ADCReportingManager:update	()V
    //   86: aload_0
    //   87: getfield 91	com/jirbo/adcolony/ADCController:play_history	Lcom/jirbo/adcolony/ADCPlayHistory;
    //   90: invokevirtual 493	com/jirbo/adcolony/ADCPlayHistory:update	()V
    //   93: aload_0
    //   94: getfield 86	com/jirbo/adcolony/ADCController:zone_state_manager	Lcom/jirbo/adcolony/ADCZoneStateManager;
    //   97: invokevirtual 494	com/jirbo/adcolony/ADCZoneStateManager:update	()V
    //   100: goto -90 -> 10
    //   103: astore_2
    //   104: aload_2
    //   105: invokestatic 169	com/jirbo/adcolony/ADC:on_fatal_error	(Ljava/lang/RuntimeException;)V
    //   108: goto -98 -> 10
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	ADCController
    //   5	2	1	bool	boolean
    //   103	2	2	localRuntimeException	RuntimeException
    //   111	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	43	103	java/lang/RuntimeException
    //   43	54	103	java/lang/RuntimeException
    //   54	58	103	java/lang/RuntimeException
    //   58	100	103	java/lang/RuntimeException
    //   2	6	111	finally
    //   13	43	111	finally
    //   43	54	111	finally
    //   54	58	111	finally
    //   58	100	111	finally
    //   104	108	111	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */