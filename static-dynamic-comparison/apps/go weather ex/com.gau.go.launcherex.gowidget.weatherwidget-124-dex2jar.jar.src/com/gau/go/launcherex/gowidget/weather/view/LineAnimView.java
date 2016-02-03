package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LineAnimView
  extends ImageView
{
  private boolean a;
  private Rect b = new Rect();
  private float c = 0.0F;
  
  public LineAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.b);
    paramCanvas.save();
    if (this.c != 1.0F)
    {
      if (!this.a) {
        break label78;
      }
      float f1 = this.b.width();
      float f2 = this.c;
      paramCanvas.clipRect(0.0F, this.b.top, f1 * f2, this.b.bottom);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
      label78:
      paramCanvas.clipRect(this.b.width() * (1.0F - this.c), this.b.top, this.b.right, this.b.bottom);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/LineAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */