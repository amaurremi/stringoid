package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.c;
import com.jiubang.core.a.l;

public class h
  extends f
{
  private int b = 495;
  private l c = null;
  private float d = 1.0F;
  private float e = 1.0F;
  private int f;
  private int g;
  
  public h(Context paramContext)
  {
    super(paramContext);
    float f1 = this.a.getResources().getDisplayMetrics().density;
    this.f = ((int)(133.33333F * f1));
    this.g = ((int)(f1 * 133.33333F));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.e = c.b(paramInt1, this.f);
      this.d = c.a(paramInt2, this.g);
    }
  }
  
  private void b()
  {
    this.b -= 1;
    if (this.b < 0) {
      this.b = 0;
    }
  }
  
  public void a(Canvas paramCanvas, View paramView)
  {
    if (this.c != null)
    {
      if (!a())
      {
        this.c.a(System.currentTimeMillis());
        paramCanvas.save();
        paramCanvas.scale(this.e, this.d);
        this.c.a(paramCanvas, this.c.f(), this.c.g(), 0.0F, paramView.getWidth(), 255);
        paramCanvas.restore();
        b();
      }
    }
    else {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.e, this.d);
    this.c.a(paramCanvas, this.c.f(), this.c.g(), 0.0F, paramView.getWidth(), 255);
    paramCanvas.restore();
  }
  
  public void a(View paramView)
  {
    if (this.c != null) {
      this.c.a(0, 0, paramView.getWidth(), paramView.getHeight());
    }
    a(paramView.getWidth(), paramView.getHeight());
  }
  
  public void a(l paraml)
  {
    this.c = paraml;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = 495;
      return;
    }
    this.b = 5;
  }
  
  public boolean a()
  {
    return this.b == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */