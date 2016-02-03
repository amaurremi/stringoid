package cmn;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class g
{
  public static final Executor a = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, e, d);
  public static final Executor b = Executors.newFixedThreadPool(10);
  public static final Executor c = new k((byte)0);
  private static final ThreadFactory d = new n();
  private static final BlockingQueue e = new LinkedBlockingQueue(10);
  private static final j f = new j((byte)0);
  private static volatile Executor g = b;
  private final m h = new o(this);
  private final FutureTask i = new p(this, this.h);
  private volatile l j = l.a;
  private final AtomicBoolean k = new AtomicBoolean();
  private final AtomicBoolean l = new AtomicBoolean();
  
  private Object b(Object paramObject)
  {
    f.obtainMessage(1, new i(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  protected static void b() {}
  
  public final g a(Object... paramVarArgs)
  {
    Executor localExecutor = g;
    if (this.j != l.a) {}
    switch (h.a[this.j.ordinal()])
    {
    default: 
      this.j = l.b;
      this.h.a = paramVarArgs;
      localExecutor.execute(this.i);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  protected abstract Object a();
  
  protected void a(Object paramObject) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */