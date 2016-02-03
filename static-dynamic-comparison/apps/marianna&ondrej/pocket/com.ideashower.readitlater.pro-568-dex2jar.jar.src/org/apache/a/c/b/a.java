package org.apache.a.c.b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class a
  implements ThreadFactory
{
  private final AtomicLong a;
  private final ThreadFactory b;
  private final Thread.UncaughtExceptionHandler c;
  private final String d;
  private final Integer e;
  private final Boolean f;
  
  private a(b paramb)
  {
    if (b.a(paramb) == null) {}
    for (this.b = Executors.defaultThreadFactory();; this.b = b.a(paramb))
    {
      this.d = b.b(paramb);
      this.e = b.c(paramb);
      this.f = b.d(paramb);
      this.c = b.e(paramb);
      this.a = new AtomicLong();
      return;
    }
  }
  
  private void a(Thread paramThread)
  {
    if (b() != null)
    {
      long l = this.a.incrementAndGet();
      paramThread.setName(String.format(b(), new Object[] { Long.valueOf(l) }));
    }
    if (e() != null) {
      paramThread.setUncaughtExceptionHandler(e());
    }
    if (d() != null) {
      paramThread.setPriority(d().intValue());
    }
    if (c() != null) {
      paramThread.setDaemon(c().booleanValue());
    }
  }
  
  public final ThreadFactory a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final Boolean c()
  {
    return this.f;
  }
  
  public final Integer d()
  {
    return this.e;
  }
  
  public final Thread.UncaughtExceptionHandler e()
  {
    return this.c;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = a().newThread(paramRunnable);
    a(paramRunnable);
    return paramRunnable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */