package com.jiubang.playsdk.views;

import android.os.Handler;
import android.os.Message;
import android.view.View;

class g
  extends Handler
{
  g(HeaderListView paramHeaderListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof View))) {
      HeaderListView.a(this.a, (View)paramMessage.obj);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */