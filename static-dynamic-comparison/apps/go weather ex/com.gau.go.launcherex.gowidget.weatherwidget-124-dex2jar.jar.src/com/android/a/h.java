package com.android.a;

import android.os.Handler;
import java.util.concurrent.Executor;

class h
  implements Executor
{
  h(g paramg, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.b.post(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */