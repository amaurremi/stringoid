package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

class p$a
  extends Handler
{
  p$a()
  {
    sendMessageDelayed(obtainMessage(), 1000L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (a.b().isFinishing())
    {
      a.b("Monitor pinger exiting.");
      return;
    }
    if (a.b().hasWindowFocus()) {
      p.a();
    }
    sendMessageDelayed(obtainMessage(), 1000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/p$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */