package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gtp.a.a.b.c;

public abstract class an
{
  protected Context a;
  protected int b = -2;
  protected int c = -2;
  protected int d = 720;
  protected int e = 1280;
  protected float f = 1.0F;
  protected int g;
  protected int h;
  private View i;
  private int j;
  private PointF k;
  private boolean l = false;
  
  public an(Context paramContext, int paramInt)
  {
    this.a = paramContext.getApplicationContext();
    this.j = paramInt;
    this.k = new PointF();
  }
  
  public static an a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("I think you need to develop a new style watermark...");
    case 0: 
      return new ac(paramContext);
    case 1: 
      return new ai(paramContext);
    case 2: 
      return new aj(paramContext);
    case 3: 
      return new ak(paramContext);
    case 4: 
      return new al(paramContext);
    }
    return new am(paramContext);
  }
  
  protected View a(int paramInt)
  {
    return this.i.findViewById(paramInt);
  }
  
  public abstract ao a();
  
  public void a(float paramFloat)
  {
    this.k.set(paramFloat, this.k.y);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    c.a("WatermarkView", "referWidth: " + paramInt1 + ", referHeight: " + paramInt2);
    this.b = paramInt1;
    this.c = paramInt2;
    this.h = this.i.getHeight();
    this.g = this.i.getWidth();
    c();
    if (!this.l) {
      b();
    }
  }
  
  protected void a(View paramView)
  {
    this.i = paramView;
    this.i.setTag(this);
  }
  
  public void a(WeatherBean paramWeatherBean, q paramq) {}
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  protected String b(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  protected abstract void b();
  
  public void b(float paramFloat)
  {
    this.k.set(this.k.x, paramFloat);
  }
  
  protected final int c(int paramInt)
  {
    return this.b * paramInt / this.d;
  }
  
  protected void c()
  {
    float f1 = this.c * 1.0F / this.h;
    float f2 = this.b * 1.0F / this.g;
    this.f = Math.min(f1, f2);
    c.a("WatermarkView", "scaleH: " + f1 + ", scaleW: " + f2);
  }
  
  protected final int d(int paramInt)
  {
    return this.c * paramInt / this.e;
  }
  
  public View d()
  {
    return this.i;
  }
  
  public int e()
  {
    return this.j;
  }
  
  public float f()
  {
    return this.k.x;
  }
  
  public float g()
  {
    return this.k.y;
  }
  
  public Context h()
  {
    return this.a;
  }
  
  public int i()
  {
    return (int)(this.g * this.f);
  }
  
  public int j()
  {
    return (int)(this.h * this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */