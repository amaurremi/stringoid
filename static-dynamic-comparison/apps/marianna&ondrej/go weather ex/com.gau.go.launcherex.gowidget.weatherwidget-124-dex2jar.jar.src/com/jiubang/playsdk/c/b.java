package com.jiubang.playsdk.c;

import android.util.Log;

class b
  implements Thread.UncaughtExceptionHandler
{
  b(a parama) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.w("KittyPlayThread", "ThreadName: " + paramThread.getName(), paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */