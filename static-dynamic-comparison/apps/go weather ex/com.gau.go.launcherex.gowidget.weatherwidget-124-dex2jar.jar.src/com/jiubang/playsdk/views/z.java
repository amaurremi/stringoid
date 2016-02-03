package com.jiubang.playsdk.views;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.jiubang.playsdk.adapter.n;

class z
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  z(TabView paramTabView) {}
  
  public void onGlobalLayout()
  {
    TabView.b(this.a).a(0, TabView.a(this.a).getHeight(), 0, 0);
    TabView.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */