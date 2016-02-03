package com.go.weatherex.f;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.b;
import java.lang.ref.WeakReference;

class e
  extends Handler
{
  WeakReference a;
  
  e(a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  public void handleMessage(Message paramMessage)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      locala.a(2);
      return;
    case 2: 
      a.j(locala);
      locala.a((b)paramMessage.obj);
      return;
    }
    a.j(locala);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */