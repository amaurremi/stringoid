package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;

public class m
{
  private int a = -1;
  
  public m(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    if (((this.a == 2) || (3 == this.a)) && (!paramBoolean)) {
      this.a += 7;
    }
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramInt != 2)
    {
      i = paramInt;
      if (3 != paramInt) {}
    }
    else
    {
      i = paramInt;
      if (!paramBoolean) {
        i = paramInt + 7;
      }
    }
    return i;
  }
  
  public Wall a(Context paramContext)
  {
    if ((this.a == 8) || (this.a == 7))
    {
      paramContext = new RainyView(paramContext);
      ((RainyView)paramContext).setHasRain(b());
      ((RainyView)paramContext).setHasThunder(c());
      return paramContext;
    }
    if (this.a == 6) {
      return new Fog(paramContext);
    }
    if (this.a == 5) {
      return new Snowy(paramContext);
    }
    if ((this.a == 2) || (this.a == 3))
    {
      paramContext = new DayWallView(paramContext);
      ((DayWallView)paramContext).setHasCloud(a());
      return paramContext;
    }
    if ((this.a == 9) || (this.a == 10))
    {
      paramContext = new NightWallView(paramContext);
      ((NightWallView)paramContext).setHasCloud(a());
      return paramContext;
    }
    if (this.a == 4) {
      return new OverCast(paramContext);
    }
    return new RainyView(paramContext);
  }
  
  public boolean a()
  {
    return (2 != this.a) && (9 != this.a);
  }
  
  public boolean b()
  {
    return (7 == this.a) || (8 == this.a);
  }
  
  public boolean c()
  {
    return 8 == this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */