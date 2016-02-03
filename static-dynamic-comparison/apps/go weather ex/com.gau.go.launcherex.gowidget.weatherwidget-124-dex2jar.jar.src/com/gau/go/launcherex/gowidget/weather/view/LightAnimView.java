package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LightAnimView
  extends ImageView
{
  private Rect a = new Rect();
  private float b = 0.0F;
  
  public LightAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.a);
    paramCanvas.save();
    if (this.b != 1.0F) {
      paramCanvas.clipRect(0.0F, this.a.top + this.a.height() * (1.0F - this.b), this.a.right, this.a.bottom);
    }
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/LightAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */