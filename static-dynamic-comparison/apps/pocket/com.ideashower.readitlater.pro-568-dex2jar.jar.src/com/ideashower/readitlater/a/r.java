package com.ideashower.readitlater.a;

import java.util.concurrent.FutureTask;

class r
{
  private final int a = q.g();
  private FutureTask b;
  private final Object c = new Object();
  
  /* Error */
  private u a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/ideashower/readitlater/a/r:c	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 30	com/ideashower/readitlater/a/r:b	Ljava/util/concurrent/FutureTask;
    //   11: ifnonnull +30 -> 41
    //   14: aload_0
    //   15: new 32	java/util/concurrent/FutureTask
    //   18: dup
    //   19: new 34	com/ideashower/readitlater/a/s
    //   22: dup
    //   23: aload_0
    //   24: aconst_null
    //   25: invokespecial 37	com/ideashower/readitlater/a/s:<init>	(Lcom/ideashower/readitlater/a/r;Lcom/ideashower/readitlater/a/q$1;)V
    //   28: invokespecial 40	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   31: putfield 30	com/ideashower/readitlater/a/r:b	Ljava/util/concurrent/FutureTask;
    //   34: aload_0
    //   35: getfield 30	com/ideashower/readitlater/a/r:b	Ljava/util/concurrent/FutureTask;
    //   38: invokevirtual 43	java/util/concurrent/FutureTask:run	()V
    //   41: aload_1
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 30	com/ideashower/readitlater/a/r:b	Ljava/util/concurrent/FutureTask;
    //   47: invokevirtual 47	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
    //   50: checkcast 49	com/ideashower/readitlater/a/u
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: astore_2
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 54	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   66: new 49	com/ideashower/readitlater/a/u
    //   69: dup
    //   70: new 56	com/ideashower/readitlater/objects/ErrorReport
    //   73: dup
    //   74: aload_1
    //   75: iconst_m1
    //   76: invokespecial 59	com/ideashower/readitlater/objects/ErrorReport:<init>	(Ljava/lang/Throwable;I)V
    //   79: invokespecial 62	com/ideashower/readitlater/a/u:<init>	(Lcom/ideashower/readitlater/objects/ErrorReport;)V
    //   82: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	r
    //   61	14	1	localThrowable	Throwable
    //   56	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	41	56	finally
    //   41	43	56	finally
    //   57	59	56	finally
    //   0	7	61	java/lang/Throwable
    //   43	54	61	java/lang/Throwable
    //   59	61	61	java/lang/Throwable
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */