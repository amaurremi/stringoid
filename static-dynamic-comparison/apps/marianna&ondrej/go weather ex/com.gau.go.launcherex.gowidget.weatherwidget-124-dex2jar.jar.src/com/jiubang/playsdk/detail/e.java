package com.jiubang.playsdk.detail;

import android.os.Handler;
import android.os.Message;
import android.view.View;

class e
  extends Handler
{
  e(ThemeDetailView paramThemeDetailView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof View))) {
      this.a.b((View)paramMessage.obj);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */