package com.go.weatherex.setting;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class y
  extends Handler
{
  final WeakReference a;
  
  public y(w paramw)
  {
    this.a = new WeakReference(paramw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    w localw = (w)this.a.get();
    if (localw == null) {
      return;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 1: 
      w.a(localw, true);
      return;
    }
    w.a(localw, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */