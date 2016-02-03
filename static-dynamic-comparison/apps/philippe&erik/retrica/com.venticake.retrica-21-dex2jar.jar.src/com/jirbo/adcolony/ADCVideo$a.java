package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

class ADCVideo$a
  extends View
{
  Rect a = new Rect();
  
  public ADCVideo$a(ADCVideo paramADCVideo, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawARGB(255, 0, 0, 0);
    getDrawingRect(this.a);
    this.b.L.a(paramCanvas, (this.a.width() - this.b.L.f) / 2, (this.a.height() - this.b.L.g) / 2);
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCVideo$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */