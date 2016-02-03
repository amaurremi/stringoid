package com.jiubang.playsdk.views;

import android.os.Handler;
import com.jiubang.playsdk.a.aa;

class c
  implements Runnable
{
  c(DefaultTabLoadingView paramDefaultTabLoadingView) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(300L);
      String str = aa.a().b().a(this.a.getContext(), DefaultTabLoadingView.c(this.a));
      DefaultTabLoadingView.d(this.a).sendMessage(DefaultTabLoadingView.d(this.a).obtainMessage(1, str));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */