package com.go.weatherex.viewex;

import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.gau.go.launcherex.gowidget.weather.util.t;

public class d
  extends e
{
  protected float a;
  private Animation c;
  private final Transformation d = new Transformation();
  private boolean e = false;
  private final RectF f = new RectF();
  private final PaintFlagsDrawFilter g = new PaintFlagsDrawFilter(0, 3);
  private boolean h = false;
  
  public d(c paramc, Animation paramAnimation)
  {
    super(paramc);
    this.c = paramAnimation;
  }
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(View paramView, Canvas paramCanvas)
  {
    this.c.initialize(paramView.getWidth(), paramView.getHeight(), paramView.getWidth(), paramView.getHeight());
    this.c.setStartTime(0L);
    long l = ((float)this.c.getDuration() * this.a);
    this.c.getTransformation(l, this.d);
    paramCanvas.concat(this.d.getMatrix());
    if (Build.VERSION.SDK_INT >= 11) {
      t.a(paramView, this.d.getAlpha());
    }
    for (;;)
    {
      if (this.h) {
        paramCanvas.setDrawFilter(this.g);
      }
      return true;
      this.f.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      this.f.set(paramCanvas.getClipBounds());
      paramCanvas.saveLayerAlpha(this.f, (int)(this.d.getAlpha() * 255.0F), 31);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */