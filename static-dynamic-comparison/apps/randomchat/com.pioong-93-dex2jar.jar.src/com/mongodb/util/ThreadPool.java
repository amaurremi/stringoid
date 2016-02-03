package com.mongodb.util;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public abstract class ThreadPool<T>
{
  private final AtomicInteger _inProgress = new AtomicInteger(0);
  final int _maxThreads;
  private final ThreadPool<T>.MyThreadGroup _myThreadGroup;
  final String _name;
  private final BlockingQueue<T> _queue;
  private final List<ThreadPool<T>.MyThread> _threads = new Vector();
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, Integer.MAX_VALUE);
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2)
  {
    this._name = paramString;
    this._maxThreads = paramInt1;
    this._queue = new LinkedBlockingQueue(paramInt2);
    this._myThreadGroup = new MyThreadGroup();
    this._threads.add(new MyThread());
  }
  
  public abstract void handle(T paramT)
    throws Exception;
  
  public abstract void handleError(T paramT, Exception paramException);
  
  public int inProgress()
  {
    return this._inProgress.get();
  }
  
  public int numThreads()
  {
    return this._threads.size();
  }
  
  public boolean offer(T paramT)
  {
    if (((this._queue.size() > 0) || (this._inProgress.get() == this._threads.size())) && (this._threads.size() < this._maxThreads)) {
      this._threads.add(new MyThread());
    }
    return this._queue.offer(paramT);
  }
  
  public int queueSize()
  {
    return this._queue.size();
  }
  
  class MyThread
    extends Thread
  {
    MyThread()
    {
      super("ThreadPool.MyThread:" + ThreadPool.this._name + ":" + ThreadPool.this._threads.size());
      setDaemon(true);
      start();
    }
    
    public void run()
    {
      for (;;)
      {
        Object localObject1 = null;
        try
        {
          Object localObject3 = ThreadPool.this._queue.take();
          localObject1 = localObject3;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ThreadPool.this._inProgress.incrementAndGet();
          ThreadPool.this.handle(localObject1);
          ThreadPool.this._inProgress.decrementAndGet();
        }
        catch (Exception localException)
        {
          ThreadPool.this.handleError(localObject1, localException);
          ThreadPool.this._inProgress.decrementAndGet();
        }
        finally
        {
          ThreadPool.this._inProgress.decrementAndGet();
        }
      }
    }
  }
  
  class MyThreadGroup
    extends ThreadGroup
  {
    MyThreadGroup()
    {
      super();
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      int i = 0;
      for (;;)
      {
        if (i < ThreadPool.this._threads.size())
        {
          if (ThreadPool.this._threads.get(i) == paramThread) {
            ThreadPool.this._threads.remove(i);
          }
        }
        else {
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/ThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */