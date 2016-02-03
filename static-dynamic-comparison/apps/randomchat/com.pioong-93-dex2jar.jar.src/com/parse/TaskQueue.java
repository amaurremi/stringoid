package com.parse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue
{
  private final Lock lock = new ReentrantLock();
  private Task<Void> tail;
  
  /* Error */
  private Task<Void> getTaskToAwait()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 31 1 0
    //   9: aload_0
    //   10: getfield 33	com/parse/TaskQueue:tail	Lcom/parse/Task;
    //   13: ifnull +32 -> 45
    //   16: aload_0
    //   17: getfield 33	com/parse/TaskQueue:tail	Lcom/parse/Task;
    //   20: astore_1
    //   21: aload_1
    //   22: new 6	com/parse/TaskQueue$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 36	com/parse/TaskQueue$1:<init>	(Lcom/parse/TaskQueue;)V
    //   30: invokevirtual 42	com/parse/Task:continueWith	(Lcom/parse/Continuation;)Lcom/parse/Task;
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   38: invokeinterface 45 1 0
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: invokestatic 49	com/parse/Task:forResult	(Ljava/lang/Object;)Lcom/parse/Task;
    //   49: astore_1
    //   50: goto -29 -> 21
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 45 1 0
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TaskQueue
    //   20	30	1	localTask	Task
    //   53	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	53	finally
    //   21	34	53	finally
    //   45	50	53	finally
  }
  
  static <T> Continuation<T, Task<T>> waitFor(Task<Void> paramTask)
  {
    new Continuation()
    {
      public Task<T> then(final Task<T> paramAnonymousTask)
        throws Exception
      {
        TaskQueue.this.continueWithTask(new Continuation()
        {
          public Task<T> then(Task<Void> paramAnonymous2Task)
            throws Exception
          {
            return paramAnonymousTask;
          }
        });
      }
    };
  }
  
  /* Error */
  <T> Task<T> enqueue(Continuation<Void, Task<T>> paramContinuation)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 31 1 0
    //   9: aload_0
    //   10: getfield 33	com/parse/TaskQueue:tail	Lcom/parse/Task;
    //   13: ifnull +55 -> 68
    //   16: aload_0
    //   17: getfield 33	com/parse/TaskQueue:tail	Lcom/parse/Task;
    //   20: astore_2
    //   21: aload_1
    //   22: aload_0
    //   23: invokespecial 64	com/parse/TaskQueue:getTaskToAwait	()Lcom/parse/Task;
    //   26: invokeinterface 70 2 0
    //   31: checkcast 38	com/parse/Task
    //   34: astore_1
    //   35: aload_0
    //   36: iconst_2
    //   37: anewarray 38	com/parse/Task
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 76	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   51: invokestatic 80	com/parse/Task:whenAll	(Ljava/util/Collection;)Lcom/parse/Task;
    //   54: putfield 33	com/parse/TaskQueue:tail	Lcom/parse/Task;
    //   57: aload_0
    //   58: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 45 1 0
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: invokestatic 49	com/parse/Task:forResult	(Ljava/lang/Object;)Lcom/parse/Task;
    //   72: astore_2
    //   73: goto -52 -> 21
    //   76: astore_1
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 45 1 0
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: new 60	java/lang/RuntimeException
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TaskQueue
    //   0	101	1	paramContinuation	Continuation<Void, Task<T>>
    //   20	53	2	localTask	Task
    // Exception table:
    //   from	to	target	type
    //   21	35	76	java/lang/RuntimeException
    //   9	21	79	finally
    //   21	35	79	finally
    //   35	57	79	finally
    //   68	73	79	finally
    //   77	79	79	finally
    //   92	101	79	finally
    //   21	35	91	java/lang/Exception
  }
  
  Lock getLock()
  {
    return this.lock;
  }
  
  void waitUntilFinished()
    throws InterruptedException
  {
    this.lock.lock();
    try
    {
      Task localTask = this.tail;
      if (localTask == null) {
        return;
      }
      this.tail.waitForCompletion();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/TaskQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */