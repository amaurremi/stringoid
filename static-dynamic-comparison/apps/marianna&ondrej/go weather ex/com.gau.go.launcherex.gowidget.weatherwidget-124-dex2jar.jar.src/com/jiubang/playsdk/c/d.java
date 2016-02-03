package com.jiubang.playsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  private static HandlerThread a = new HandlerThread("sdk-handler");
  private static Handler b = new e(a.getLooper());
  private static ExecutorService c = Executors.newCachedThreadPool(new c());
  
  static
  {
    a.start();
  }
  
  public static void a(Runnable paramRunnable)
  {
    b.post(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */