package com.jiubang.core.c;

import android.os.Handler;
import android.os.Message;

class g
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    f localf = (f)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      a.a(localf.a, localf.b[0]);
      return;
    case 2: 
      localf.a.b(localf.b);
      return;
    }
    localf.a.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */