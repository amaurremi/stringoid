package com.gau.go.launcherex.gowidget.weather.service.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b
  implements Handler.Callback
{
  private static b a;
  private final Executor b = Executors.newFixedThreadPool(1);
  private final Handler c = new Handler(Looper.getMainLooper(), this);
  private final List d = new ArrayList();
  private final List e = new ArrayList();
  
  public static void a(a parama)
  {
    a(new c(parama));
  }
  
  public static void a(a parama, Executor paramExecutor)
  {
    a(new d(parama, paramExecutor));
  }
  
  public static void a(g paramg)
  {
    a(new e(paramg));
  }
  
  public static final void a(Runnable paramRunnable)
  {
    if (c())
    {
      paramRunnable.run();
      return;
    }
    h.a().post(paramRunnable);
  }
  
  private static b b()
  {
    if (!c()) {
      throw new IllegalStateException("should call on UI thread...");
    }
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  private void b(a parama)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = parama;
    this.c.sendMessage(localMessage);
  }
  
  private void b(a parama, Executor paramExecutor)
  {
    if (parama == null) {}
    while (this.e.contains(parama)) {
      return;
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((a)((Iterator)localObject).next()).a(parama)) {
        return;
      }
    }
    this.e.add(parama);
    c(parama);
    localObject = paramExecutor;
    if (paramExecutor == null) {
      localObject = this.b;
    }
    ((Executor)localObject).execute(new i(this, parama));
  }
  
  public static void b(g paramg)
  {
    a(new f(paramg));
  }
  
  private void c(a parama)
  {
    Iterator localIterator = new ArrayList(this.d).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(parama);
    }
  }
  
  private void c(g paramg)
  {
    if (this.d.contains(paramg)) {
      throw new IllegalStateException(paramg.toString() + "had be added before, did you forget to call removeObserver()?");
    }
    this.d.add(paramg);
  }
  
  private static boolean c()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  private void d(a parama)
  {
    Iterator localIterator = new ArrayList(this.d).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).c(parama);
    }
  }
  
  private void d(g paramg)
  {
    this.d.remove(paramg);
  }
  
  private void e(a parama)
  {
    Iterator localIterator = new ArrayList(this.d).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).b(parama);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      d((a)paramMessage.obj);
      return true;
    }
    paramMessage = (a)paramMessage.obj;
    this.e.remove(paramMessage);
    e(paramMessage);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */