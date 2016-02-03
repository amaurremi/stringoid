package com.go.weatherex.setting;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class e
  extends Handler
{
  final WeakReference a;
  
  public e(c paramc)
  {
    this.a = new WeakReference(paramc);
  }
  
  public void handleMessage(Message paramMessage)
  {
    c localc = (c)this.a.get();
    if (localc == null) {
      return;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 1: 
      c.a(localc, true);
      return;
    }
    c.a(localc, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */