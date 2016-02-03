package com.go.weatherex.sidebar;

import android.view.View;
import com.gtp.a.a.b.c;

class f
  implements h
{
  f(SidebarDrawerLayout paramSidebarDrawerLayout) {}
  
  public void a(int paramInt)
  {
    c.a("SidebarDrawerLayout", "onDrawerStateChanged:" + paramInt);
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
      } while (SidebarDrawerLayout.c(this.a));
      SidebarDrawerLayout.a(this.a, true);
      if (this.a.h(3))
      {
        SidebarDrawerLayout.b(this.a).d_();
        return;
      }
      SidebarDrawerLayout.b(this.a).c_();
      return;
    }
    SidebarDrawerLayout.a(this.a, false);
    SidebarDrawerLayout.b(this.a).a(this.a.h(3));
  }
  
  public void a(View paramView)
  {
    SidebarDrawerLayout.b(this.a).e_();
  }
  
  public void a(View paramView, float paramFloat)
  {
    SidebarDrawerLayout.b(this.a).a(paramFloat);
  }
  
  public void b(View paramView)
  {
    SidebarDrawerLayout.b(this.a).f_();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */