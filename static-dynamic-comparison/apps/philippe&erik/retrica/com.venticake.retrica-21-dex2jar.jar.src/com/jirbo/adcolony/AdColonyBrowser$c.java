package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.reflect.Method;

class AdColonyBrowser$c
  extends View
{
  Paint a = new Paint();
  ADCImage b = new ADCImage(a.j("close_image_normal"));
  ADCImage c = new ADCImage(a.j("close_image_down"));
  
  public AdColonyBrowser$c(AdColonyBrowser paramAdColonyBrowser, Activity paramActivity)
  {
    super(paramActivity);
    try
    {
      getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
      this.a.setColor(-3355444);
      this.a.setStrokeWidth(10.0F);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setShadowLayer(3.0F, 0.0F, 1.0F, -16777216);
      return;
    }
    catch (Exception paramAdColonyBrowser)
    {
      for (;;) {}
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, this.d.l.getWidth(), 10.0F, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */