package cmn;

import android.os.Handler;
import android.os.Message;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ag
{
  private static final ThreadFactory a = new ah();
  private static final BlockingQueue b = new LinkedBlockingQueue(10);
  public static final Executor c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
  public static final Executor d = Executors.newFixedThreadPool(10);
  public static final Executor e = new c((byte)0);
  private static final b f = new b((byte)0);
  private static volatile Executor g = d;
  private final e h = new ai(this);
  private final FutureTask i = new aj(this, this.h);
  private volatile int j = d.a;
  private final AtomicBoolean k = new AtomicBoolean();
  private final AtomicBoolean l = new AtomicBoolean();
  
  private Object b(Object paramObject)
  {
    f.obtainMessage(1, new a(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  protected static void b() {}
  
  public final ag a(Object... paramVarArgs)
  {
    Executor localExecutor = g;
    if (this.j != d.a) {}
    switch (1.a[(this.j - 1)])
    {
    default: 
      this.j = d.b;
      this.h.b = paramVarArgs;
      localExecutor.execute(this.i);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  protected abstract Object a();
  
  protected void a(Object paramObject) {}
  
  private static final class a
  {
    final ag a;
    final Object[] b;
    
    a(ag paramag, Object... paramVarArgs)
    {
      this.a = paramag;
      this.b = paramVarArgs;
    }
  }
  
  private static final class b
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      ag.a locala = (ag.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        ag.c(locala.a, locala.b[0]);
        return;
      }
      paramMessage = locala.a;
      paramMessage = locala.b;
      ag.b();
    }
  }
  
  private static final class c
    implements Executor
  {
    final LinkedList a = new LinkedList();
    Runnable b;
    
    protected final void a()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.a.poll();
        this.b = localRunnable;
        if (localRunnable != null) {
          ag.c.execute(this.b);
        }
        return;
      }
      finally {}
    }
    
    public final void execute(Runnable paramRunnable)
    {
      try
      {
        this.a.offer(new ak(this, paramRunnable));
        if (this.b == null) {
          a();
        }
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
  
  public static enum d
  {
    public static int[] a()
    {
      return (int[])d.clone();
    }
  }
  
  private static abstract class e
    implements Callable
  {
    Object[] b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */