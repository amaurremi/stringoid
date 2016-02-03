package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CurveAnimView
  extends ImageView
{
  private Drawable a;
  private Drawable b;
  private float c = 0.0F;
  private Rect d = new Rect();
  private float e = 0.0F;
  
  public CurveAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(float paramFloat)
  {
    if ((0.0F <= paramFloat) && (paramFloat < 0.15F))
    {
      this.e = 0.0F;
      return;
    }
    if (paramFloat < 0.3F)
    {
      this.e = 0.15F;
      return;
    }
    if (paramFloat < 0.5D)
    {
      this.e = 0.3F;
      return;
    }
    if (paramFloat < 0.75D)
    {
      this.e = 0.5F;
      return;
    }
    if (paramFloat < 1.0F)
    {
      this.e = 0.75F;
      return;
    }
    this.e = 1.0F;
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.a = paramContext.getDrawable(2130837538);
    this.b = paramContext.getDrawable(2130837539);
  }
  
  public void a()
  {
    this.c = 0.0F;
    this.e = 0.0F;
    clearAnimation();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.d);
    this.a.setBounds(this.d);
    this.b.setBounds(this.d);
    if (this.c != 1.0F)
    {
      int i = (int)(this.d.width() * this.c);
      paramCanvas.save();
      paramCanvas.clipRect(0, this.d.top, i, this.d.bottom);
      this.a.draw(paramCanvas);
      paramCanvas.restore();
      i = (int)(this.d.width() * this.e);
      paramCanvas.save();
      paramCanvas.clipRect(0, this.d.top, i, this.d.bottom);
      this.b.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    this.a.draw(paramCanvas);
    this.b.draw(paramCanvas);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/CurveAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */