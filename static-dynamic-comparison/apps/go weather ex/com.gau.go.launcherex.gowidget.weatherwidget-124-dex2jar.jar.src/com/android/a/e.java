package com.android.a;

import java.util.concurrent.BlockingQueue;

class e
  implements Runnable
{
  e(d paramd, p paramp) {}
  
  public void run()
  {
    try
    {
      d.a(this.a).put(this.b);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */