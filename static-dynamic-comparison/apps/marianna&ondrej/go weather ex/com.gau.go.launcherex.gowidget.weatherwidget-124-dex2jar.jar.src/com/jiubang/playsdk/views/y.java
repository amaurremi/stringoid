package com.jiubang.playsdk.views;

import android.os.Handler;

class y
  implements Runnable
{
  y(TabLoadingView paramTabLoadingView) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(TabLoadingView.b(this.a));
      TabLoadingView.c(this.a).sendEmptyMessage(1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */