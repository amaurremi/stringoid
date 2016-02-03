package com.jirbo.adcolony;

public abstract class AdColonyAd
{
  static final int status_canceled = 1;
  static final int status_no_fill = 2;
  static final int status_no_request = 0;
  static final int status_shown = 4;
  static final int status_skipped = 3;
  ADCManifest.Ad ad_info;
  int status = 0;
  String zone_id;
  ADCManifest.Zone zone_info;
  
  public boolean canceled()
  {
    return this.status == 1;
  }
  
  public int getAvailableViews()
  {
    if (!isReady()) {}
    while (!set_up_info()) {
      return 0;
    }
    return this.zone_info.get_available_plays();
  }
  
  public abstract boolean isReady();
  
  abstract boolean is_v4vc();
  
  public boolean noFill()
  {
    return this.status == 2;
  }
  
  public boolean notShown()
  {
    return this.status != 4;
  }
  
  abstract void on_video_finished();
  
  boolean set_up_info()
  {
    if (this.status == 4) {}
    do
    {
      return true;
      if (!isReady()) {
        return false;
      }
      this.zone_info = ADC.controller.get_zone_info(this.zone_id);
      this.ad_info = this.zone_info.current_ad();
    } while (this.ad_info != null);
    return false;
  }
  
  public boolean shown()
  {
    return this.status == 4;
  }
  
  public boolean skipped()
  {
    return this.status == 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AdColonyAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */