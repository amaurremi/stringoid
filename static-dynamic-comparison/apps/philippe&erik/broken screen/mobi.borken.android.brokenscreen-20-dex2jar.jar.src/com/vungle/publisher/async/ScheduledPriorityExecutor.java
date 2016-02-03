package com.vungle.publisher.async;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vungle.publisher.log.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ScheduledPriorityExecutor
{
  public final a a;
  private final Executor b;
  private final Executor c;
  private final BlockingQueue<Runnable> d = new PriorityBlockingQueue();
  
  @Inject
  ScheduledPriorityExecutor()
  {
    HandlerThread localHandlerThread = new HandlerThread("VungleAsyncMasterThread");
    localHandlerThread.start();
    this.b = new c(Integer.MAX_VALUE, new SynchronousQueue(), "VungleAsyncClientEventThread-");
    this.a = new a(localHandlerThread.getLooper());
    this.c = new c(3, this.d, "VungleAsyncMainThread-");
  }
  
  public final void a(Runnable paramRunnable, b paramb)
  {
    this.a.sendMessage(b(paramRunnable, paramb));
  }
  
  public final Message b(Runnable paramRunnable, b paramb)
  {
    a locala = this.a;
    int i = paramb.ordinal();
    locala.getClass();
    return locala.obtainMessage(i, new ScheduledPriorityExecutor.a.a(locala, paramRunnable, paramb));
  }
  
  public final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Object localObject = paramMessage.obj;
      if ((localObject != null) && ((localObject instanceof a)))
      {
        paramMessage = a.a((a)localObject);
        if (paramMessage != null) {
          switch (ScheduledPriorityExecutor.1.a[paramMessage.ordinal()])
          {
          }
        }
        for (paramMessage = ScheduledPriorityExecutor.a(ScheduledPriorityExecutor.this);; paramMessage = ScheduledPriorityExecutor.b(ScheduledPriorityExecutor.this))
        {
          Logger.d("VungleAsync", "processing " + localObject);
          paramMessage.execute((Runnable)localObject);
          return;
        }
      }
      Logger.w("VungleAsync", "unhandled message " + paramMessage);
    }
    
    final class a
      implements Comparable<a>, Runnable
    {
      private final Runnable b;
      private final long c;
      private final ScheduledPriorityExecutor.b d;
      
      a(Runnable paramRunnable, ScheduledPriorityExecutor.b paramb)
      {
        this(paramRunnable, paramb, (byte)0);
      }
      
      private a(Runnable paramRunnable, ScheduledPriorityExecutor.b paramb, byte paramByte)
      {
        this.b = paramRunnable;
        this.c = -1L;
        this.d = paramb;
      }
      
      public final boolean equals(Object paramObject)
      {
        if ((paramObject != null) && ((paramObject instanceof a)))
        {
          paramObject = (a)paramObject;
          if (this.b.equals(((a)paramObject).b)) {
            return true;
          }
        }
        return false;
      }
      
      public final int hashCode()
      {
        return this.b.hashCode();
      }
      
      public final void run()
      {
        for (;;)
        {
          try
          {
            this.b.run();
          }
          catch (Exception localException2)
          {
            localException2 = localException2;
            Logger.e("VungleAsync", "error executing " + this, localException2);
            try
            {
              if (this.c <= 0L) {
                continue;
              }
              ScheduledPriorityExecutor.a.this.postDelayed(this, this.c);
              return;
            }
            catch (Exception localException3)
            {
              Logger.e("VungleAsync", "error rescheduling " + this, localException3);
              return;
            }
          }
          finally {}
          try
          {
            if (this.c > 0L) {
              ScheduledPriorityExecutor.a.this.postDelayed(this, this.c);
            }
            return;
          }
          catch (Exception localException1)
          {
            Logger.e("VungleAsync", "error rescheduling " + this, localException1);
            return;
          }
        }
        try
        {
          if (this.c > 0L) {
            ScheduledPriorityExecutor.a.this.postDelayed(this, this.c);
          }
          throw ((Throwable)localObject);
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            Logger.e("VungleAsync", "error rescheduling " + this, localException4);
          }
        }
      }
      
      public final String toString()
      {
        return "{PriorityRunnable:: taskType: " + this.d + ", repeatMillis: " + this.c + "}";
      }
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  final class c
    extends ThreadPoolExecutor
  {
    c(int paramInt, String paramString)
    {
      super(paramInt, 30L, TimeUnit.SECONDS, paramString, new ThreadFactory()
      {
        int a = 0;
        
        public final Thread newThread(Runnable paramAnonymousRunnable)
        {
          Object localObject = new StringBuilder().append(str);
          int i = this.a;
          this.a = (i + 1);
          localObject = i;
          Logger.v("VungleAsync", "starting " + (String)localObject);
          return new Thread(paramAnonymousRunnable, (String)localObject);
        }
      });
    }
    
    protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      super.afterExecute(paramRunnable, paramThrowable);
      if (paramThrowable != null) {
        Logger.e("VungleAsync", paramThrowable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/async/ScheduledPriorityExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */