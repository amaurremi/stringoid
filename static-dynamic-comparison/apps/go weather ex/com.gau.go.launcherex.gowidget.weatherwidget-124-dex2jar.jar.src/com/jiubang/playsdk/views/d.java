package com.jiubang.playsdk.views;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.jiubang.playsdk.adapter.e;

class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  d(DefaultTabView paramDefaultTabView) {}
  
  public void onGlobalLayout()
  {
    DefaultTabView.b(this.a).a(0, DefaultTabView.a(this.a).getHeight(), 0, 0);
    DefaultTabView.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */