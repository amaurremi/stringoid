package com.jirbo.adcolony;

class ADCSessionManager
{
  boolean active;
  boolean allow_resume;
  ADCController controller;
  String current_session_id = "uuid";
  double finish_time;
  double session_time;
  boolean should_submit_app_install_event = false;
  boolean should_submit_session_start_event = false;
  double start_time;
  
  ADCSessionManager(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  void configure() {}
  
  void load()
  {
    ADCData.Table localTable = ADCJSON.load_Table(new ADCDataFile("session_info.txt"));
    if (localTable != null)
    {
      this.allow_resume = localTable.get_Logical("allow_resume");
      this.start_time = localTable.get_Real("start_time");
      this.finish_time = localTable.get_Real("finish_time");
      this.session_time = localTable.get_Real("session_time");
      return;
    }
    this.should_submit_app_install_event = true;
  }
  
  void on_new_session()
  {
    this.should_submit_session_start_event = true;
    this.current_session_id = ADCUtil.create_uuid();
    this.session_time = 0.0D;
    if ((ADC.controller == null) || (ADC.controller.ad_manager == null) || (ADC.controller.ad_manager.app == null) || (ADC.controller.ad_manager.app.zones == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < ADC.controller.ad_manager.app.zones.count())
      {
        ADC.controller.ad_manager.app.zones.get(i).state.session_play_count = 0;
        i += 1;
      }
    }
  }
  
  void on_resume()
  {
    ADCLog.debug.println("AdColony resuming");
    ADC.active = true;
    if (this.active) {
      ADCLog.error.println("AdColony.onResume() called multiple times in succession.");
    }
    this.active = true;
    load();
    double d = ADCUtil.current_time();
    if (this.allow_resume)
    {
      if (d - this.finish_time > this.controller.configuration.session_timeout_seconds)
      {
        submit_session_duration(this.session_time);
        this.start_time = d;
        on_new_session();
      }
      this.allow_resume = false;
      save();
    }
    for (;;)
    {
      ADC.has_ad_availability_changed();
      return;
      this.start_time = d;
      on_new_session();
    }
  }
  
  void on_stop()
  {
    ADCLog.debug.println("AdColony terminating");
    ADC.active = true;
    submit_session_duration(this.session_time);
    this.allow_resume = false;
    save();
  }
  
  void on_suspend()
  {
    ADCLog.debug.println("AdColony suspending");
    ADC.active = true;
    if (!this.active) {
      ADCLog.error.println("AdColony.onPause() called without initial call to onResume().");
    }
    this.active = false;
    this.allow_resume = true;
    this.finish_time = ADCUtil.current_time();
    save();
  }
  
  void save()
  {
    ADCData.Table localTable = new ADCData.Table();
    localTable.set("allow_resume", this.allow_resume);
    localTable.set("start_time", this.start_time);
    localTable.set("finish_time", this.finish_time);
    localTable.set("session_time", this.session_time);
    ADCJSON.save(new ADCDataFile("session_info.txt"), localTable);
  }
  
  void submit_session_duration(double paramDouble)
  {
    ADCLog.dev.print("Submitting session duration ").println(paramDouble);
    ADCData.Table localTable = new ADCData.Table();
    localTable.set("session_length", (int)paramDouble);
    this.controller.reporting_manager.track_app_event("session_end", localTable);
  }
  
  void update()
  {
    if (this.controller.ad_manager.is_configured)
    {
      if (this.should_submit_app_install_event)
      {
        this.should_submit_app_install_event = false;
        this.controller.reporting_manager.track_app_event("install", null);
      }
      if (this.should_submit_session_start_event)
      {
        this.should_submit_session_start_event = false;
        this.controller.reporting_manager.track_app_event("session_start", null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */