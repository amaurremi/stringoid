package com.jirbo.adcolony;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class AdColonyOverlay
  extends ADCVideo
{
  Rect bounds = new Rect();
  int old_seek = 0;
  
  public void onConfigurationChanged(final Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getWindowManager().getDefaultDisplay();
    this.display_width = paramConfiguration.getWidth();
    this.display_height = paramConfiguration.getHeight();
    ADC.layout_changed = true;
    paramConfiguration = new View(this);
    paramConfiguration.setBackgroundColor(-16777216);
    if ((video_finished) && (this.hud.is_html5))
    {
      this.web_layout.setLayoutParams(new FrameLayout.LayoutParams(this.display_width, this.display_height - this.hud.offset, 17));
      this.layout.addView(paramConfiguration, new FrameLayout.LayoutParams(this.display_width, this.display_height, 17));
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          AdColonyOverlay.this.layout.removeView(paramConfiguration);
        }
      }, 1500L);
    }
    this.hud.adjust_size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AdColonyOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */