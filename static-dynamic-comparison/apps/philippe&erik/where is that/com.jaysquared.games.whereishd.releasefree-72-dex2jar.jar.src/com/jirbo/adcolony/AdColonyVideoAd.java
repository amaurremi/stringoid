package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class AdColonyVideoAd
  extends AdColonyAd
{
  AdColonyAdListener listener;
  
  public AdColonyVideoAd()
  {
    ADC.show_post_popup = false;
    ADC.ensure_configured();
  }
  
  public AdColonyVideoAd(String paramString)
  {
    ADC.ensure_configured();
    this.zone_id = paramString;
  }
  
  public boolean isReady()
  {
    if (this.zone_id == null)
    {
      this.zone_id = ADC.controller.find_video_zone();
      if (this.zone_id == null) {
        return false;
      }
    }
    return ADC.controller.is_video_ad_available(this.zone_id);
  }
  
  boolean is_v4vc()
  {
    return false;
  }
  
  void on_video_finished()
  {
    if (this.listener != null) {
      this.listener.onAdColonyAdAttemptFinished(this);
    }
    ADC.has_ad_availability_changed();
    System.gc();
    if ((!ADC.show_post_popup) && (!AdColonyBrowser.is_open))
    {
      int i = 0;
      while (i < ADC.bitmaps.size())
      {
        ((Bitmap)ADC.bitmaps.get(i)).recycle();
        i += 1;
      }
      ADC.bitmaps.clear();
    }
    ADC.current_video = null;
    ADC.show = true;
  }
  
  public void show()
  {
    if (!isReady())
    {
      new ADCEvent(ADC.controller)
      {
        void dispatch()
        {
          if (AdColonyVideoAd.this.zone_id != null) {
            this.controller.reporting_manager.track_ad_request(AdColonyVideoAd.this.zone_id);
          }
        }
      };
      this.status = 2;
      if (this.listener != null) {
        this.listener.onAdColonyAdAttemptFinished(this);
      }
      return;
    }
    if (ADC.show)
    {
      new ADCEvent(ADC.controller)
      {
        void dispatch()
        {
          this.controller.reporting_manager.track_ad_request(AdColonyVideoAd.this.zone_id);
        }
      };
      ADC.show = false;
      set_up_info();
      if (!ADC.controller.show_video_ad(this))
      {
        if (this.listener != null) {
          this.listener.onAdColonyAdAttemptFinished(this);
        }
        ADC.show = true;
        return;
      }
      if (this.listener != null) {
        this.listener.onAdColonyAdStarted(this);
      }
    }
    this.status = 4;
  }
  
  public AdColonyVideoAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.listener = paramAdColonyAdListener;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AdColonyVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */