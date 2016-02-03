package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

class AdColonyBrowser$b
  extends View
{
  Rect a = new Rect();
  
  public AdColonyBrowser$b(AdColonyBrowser paramAdColonyBrowser, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!AdColonyBrowser.y)
    {
      paramCanvas.drawARGB(255, 0, 0, 0);
      getDrawingRect(this.a);
      this.b.i.a(paramCanvas, (this.a.width() - this.b.i.f) / 2, (this.a.height() - this.b.i.g) / 2);
      invalidate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */