package com.gtp.nextlauncher.widget.nextpanel;

import java.util.concurrent.ThreadFactory;

class k
  implements ThreadFactory
{
  k(Wall paramWall) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setPriority(1);
    return paramRunnable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */