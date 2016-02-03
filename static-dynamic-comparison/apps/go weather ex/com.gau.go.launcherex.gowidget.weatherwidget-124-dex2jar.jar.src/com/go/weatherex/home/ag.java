package com.go.weatherex.home;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ag
  extends Animation
{
  private ag(SidebarIcon paramSidebarIcon) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (SidebarIcon.b(this.a)) {
      return;
    }
    if (paramFloat < 1.0F)
    {
      if (!SidebarIcon.a(this.a))
      {
        SidebarIcon.c(this.a).a(paramFloat * 225.0F);
        SidebarIcon.c(this.a).b(paramFloat * 180.0F);
        SidebarIcon.c(this.a).c(paramFloat * 135.0F);
        SidebarIcon.c(this.a).d(paramFloat);
      }
      for (;;)
      {
        this.a.invalidate();
        return;
        SidebarIcon.c(this.a).a(135.0F * paramFloat + 225.0F);
        SidebarIcon.c(this.a).b(180.0F * paramFloat + 180.0F);
        SidebarIcon.c(this.a).c(225.0F * paramFloat + 135.0F);
        SidebarIcon.c(this.a).d(1.0F - paramFloat);
      }
    }
    if (!SidebarIcon.b(this.a))
    {
      SidebarIcon.a(this.a, true);
      if (SidebarIcon.a(this.a)) {
        break label262;
      }
      SidebarIcon.c(this.a).a(225.0F);
      SidebarIcon.c(this.a).b(180.0F);
      SidebarIcon.c(this.a).c(135.0F);
      SidebarIcon.c(this.a).d(1.0F);
      paramTransformation = this.a;
      if (SidebarIcon.a(this.a)) {
        break label312;
      }
    }
    label262:
    label312:
    for (boolean bool = true;; bool = false)
    {
      SidebarIcon.b(paramTransformation, bool);
      this.a.invalidate();
      return;
      SidebarIcon.c(this.a).a(360.0F);
      SidebarIcon.c(this.a).b(360.0F);
      SidebarIcon.c(this.a).c(360.0F);
      SidebarIcon.c(this.a).d(0.0F);
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */