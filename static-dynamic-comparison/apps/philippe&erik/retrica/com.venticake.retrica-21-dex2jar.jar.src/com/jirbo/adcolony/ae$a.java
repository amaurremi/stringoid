package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

class ae$a
  extends View
{
  Rect a = new Rect();
  
  public ae$a(ae paramae, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawARGB(255, 0, 0, 0);
    getDrawingRect(this.a);
    this.b.ao.a(paramCanvas, (this.a.width() - this.b.ao.f) / 2, (this.a.height() - this.b.ao.g) / 2);
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ae$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */