package com.go.weatherex.f;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.b;
import java.lang.ref.WeakReference;

class y
  extends Handler
{
  WeakReference a;
  
  y(t paramt)
  {
    this.a = new WeakReference(paramt);
  }
  
  public void handleMessage(Message paramMessage)
  {
    t localt = (t)this.a.get();
    if (localt == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      t.a(localt, 2);
      return;
    case 2: 
      t.n(localt);
      t.b(localt, (b)paramMessage.obj);
      return;
    }
    t.n(localt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */