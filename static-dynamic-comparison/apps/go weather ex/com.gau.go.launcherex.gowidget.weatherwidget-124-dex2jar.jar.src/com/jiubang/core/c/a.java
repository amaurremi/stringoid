package com.jiubang.core.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class a
{
  private static final BlockingQueue a = new LinkedBlockingQueue(128);
  public static final ThreadPoolExecutor b = new ThreadPoolExecutor(2, 16, 15L, TimeUnit.SECONDS, a, c);
  private static final ThreadFactory c = new b();
  private static final g d = new g(null);
  private final i e = new c(this);
  private final FutureTask f = new d(this, this.e);
  private volatile h g = h.a;
  
  private void b(Object paramObject)
  {
    if (c()) {
      paramObject = null;
    }
    a(paramObject);
    this.g = h.c;
  }
  
  protected abstract Object a(Object... paramVarArgs);
  
  protected void a() {}
  
  protected void a(Object paramObject) {}
  
  protected void b() {}
  
  protected void b(Object... paramVarArgs) {}
  
  public final a c(Object... paramVarArgs)
  {
    if (this.g != h.a) {}
    switch (e.a[this.g.ordinal()])
    {
    default: 
      this.g = h.b;
      a();
      this.e.b = paramVarArgs;
      b.execute(this.f);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final boolean c()
  {
    return this.f.isCancelled();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */