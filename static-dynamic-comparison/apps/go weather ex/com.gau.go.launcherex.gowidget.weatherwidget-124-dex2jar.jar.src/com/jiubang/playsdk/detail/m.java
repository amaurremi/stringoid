package com.jiubang.playsdk.detail;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ScrollView;

class m
  extends Handler
{
  m(ThemeLocalDetailView paramThemeLocalDetailView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 1)
    {
      i = ThemeLocalDetailView.a(this.a).getChildAt(0).getMeasuredHeight();
      if ((ThemeLocalDetailView.a(this.a).getScrollY() + ThemeLocalDetailView.a(this.a).getHeight() >= i) && (ThemeLocalDetailView.a(this.a).getScrollY() != 0)) {
        ThemeLocalDetailView.a(this.a, false);
      }
    }
    while ((i != 2) || (!(paramMessage.obj instanceof View)))
    {
      return;
      ThemeLocalDetailView.a(this.a, true);
      return;
    }
    ThemeLocalDetailView.a(this.a, (View)paramMessage.obj);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */