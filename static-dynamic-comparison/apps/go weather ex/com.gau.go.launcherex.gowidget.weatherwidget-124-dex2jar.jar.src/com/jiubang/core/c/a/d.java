package com.jiubang.core.c.a;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class d
  extends Handler
{
  private WeakReference a;
  
  public d(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    b localb;
    if (this.a != null)
    {
      localb = (b)this.a.get();
      if (localb != null) {
        break label33;
      }
    }
    label33:
    a locala;
    do
    {
      return;
      localb = null;
      break;
      locala = (a)paramMessage.obj;
    } while ((locala == null) || (b.c(localb) == null));
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      b.c(localb).a(locala);
      return;
    case 1: 
      b.c(localb).b(locala);
      return;
    case 2: 
      b.c(localb).c(locala);
      b.d(localb).remove(locala.a);
      return;
    }
    b.c(localb).d(locala);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */