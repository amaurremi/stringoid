package com.gtp.nextlauncher.widget.weatherwidget;

import android.os.Handler;
import android.os.Message;

class k
  extends Handler
{
  k(GLDigitalClock paramGLDigitalClock) {}
  
  public void handleMessage(Message paramMessage)
  {
    GLDigitalClock.access$002(this.a, false);
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */