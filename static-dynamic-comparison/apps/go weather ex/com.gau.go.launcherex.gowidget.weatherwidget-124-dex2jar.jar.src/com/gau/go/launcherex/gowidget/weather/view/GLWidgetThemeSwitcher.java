package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import com.go.gl.widget.GLImageView;

public class GLWidgetThemeSwitcher
  extends GLImageView
{
  private int a;
  private boolean b;
  private final int[] c = { 2130839021, 2130839022, 2130839023, 2130839024, 2130839025, 2130839026, 2130839025, 2130839024, 2130839023, 2130839022, 2130839021 };
  private final int[] d = { 2130839027, 2130839028, 2130839029, 2130839030, 2130839031, 2130839032, 2130839031, 2130839030, 2130839029, 2130839028, 2130839027 };
  private boolean e = true;
  private Runnable f = new v(this);
  
  public GLWidgetThemeSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setImageResource(a(0));
  }
  
  private int a(int paramInt)
  {
    if (this.e) {
      return this.d[paramInt];
    }
    return this.c[paramInt];
  }
  
  public boolean isAnimating()
  {
    return this.b;
  }
  
  public void playAnimation()
  {
    this.b = true;
    this.a = 0;
    removeCallbacks(this.f);
    post(this.f);
  }
  
  public void setColorType(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a >= this.c.length) {
      this.a = (this.c.length - 1);
    }
    setImageResource(a(this.a));
  }
  
  public void stopAnimation()
  {
    removeCallbacks(this.f);
    this.a = 0;
    setImageResource(a(0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/GLWidgetThemeSwitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */