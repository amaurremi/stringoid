package com.jiubang.pla.internal;

import android.view.View;

class a
  implements Runnable
{
  a(PLA_AbsListView paramPLA_AbsListView, View paramView, f paramf) {}
  
  public void run()
  {
    this.a.setPressed(false);
    this.c.setPressed(false);
    if (!this.c.L) {
      this.c.post(this.b);
    }
    this.c.t = -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */