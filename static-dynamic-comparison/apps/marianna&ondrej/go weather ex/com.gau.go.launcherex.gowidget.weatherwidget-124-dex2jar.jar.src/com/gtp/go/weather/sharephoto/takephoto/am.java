package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.view.LayoutInflater;

public class am
  extends an
{
  public am(Context paramContext)
  {
    super(paramContext, 5);
    a(LayoutInflater.from(this.a).inflate(2130903291, null));
  }
  
  public ao a()
  {
    return new a(this);
  }
  
  public void b()
  {
    int i = this.b - i() - c(20);
    float f = i;
    if (i + i() > this.b) {
      f = this.b - i() / 2;
    }
    a(f / this.b);
    i = d(20);
    f = i;
    if (i + j() > this.c) {
      f = this.c - j() / 2;
    }
    b(f / this.c);
  }
  
  protected void c()
  {
    super.c();
    this.f *= 0.5F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */