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
  Rect O = new Rect();
  int P = 0;
  
  public void onConfigurationChanged(final Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getWindowManager().getDefaultDisplay();
    this.t = paramConfiguration.getWidth();
    this.u = paramConfiguration.getHeight();
    a.B = true;
    paramConfiguration = new View(this);
    paramConfiguration.setBackgroundColor(-16777216);
    if ((d) && (this.E.P))
    {
      this.I.setLayoutParams(new FrameLayout.LayoutParams(this.t, this.u - this.E.m, 17));
      this.H.addView(paramConfiguration, new FrameLayout.LayoutParams(this.t, this.u, 17));
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          AdColonyOverlay.this.H.removeView(paramConfiguration);
        }
      }, 1500L);
    }
    this.E.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */