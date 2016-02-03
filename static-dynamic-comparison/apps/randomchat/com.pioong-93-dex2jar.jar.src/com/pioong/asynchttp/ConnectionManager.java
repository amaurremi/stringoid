package com.pioong.asynchttp;

import java.util.ArrayList;

public class ConnectionManager
{
  public static final int MAX_CONNECTIONS = 5;
  private static ConnectionManager instance;
  private ArrayList<Runnable> active = new ArrayList();
  private ArrayList<Runnable> queue = new ArrayList();
  
  public static ConnectionManager getInstance()
  {
    if (instance == null) {
      instance = new ConnectionManager();
    }
    return instance;
  }
  
  /* Error */
  private void startNext()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/pioong/asynchttp/ConnectionManager:queue	Ljava/util/ArrayList;
    //   6: invokevirtual 37	java/util/ArrayList:isEmpty	()Z
    //   9: ifne +44 -> 53
    //   12: aload_0
    //   13: getfield 24	com/pioong/asynchttp/ConnectionManager:queue	Ljava/util/ArrayList;
    //   16: iconst_0
    //   17: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   20: checkcast 43	java/lang/Runnable
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 24	com/pioong/asynchttp/ConnectionManager:queue	Ljava/util/ArrayList;
    //   28: iconst_0
    //   29: invokevirtual 46	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   32: pop
    //   33: aload_0
    //   34: getfield 22	com/pioong/asynchttp/ConnectionManager:active	Ljava/util/ArrayList;
    //   37: aload_1
    //   38: invokevirtual 50	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   41: pop
    //   42: new 52	java/lang/Thread
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 55	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   50: invokevirtual 58	java/lang/Thread:start	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: goto -9 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	ConnectionManager
    //   23	24	1	localRunnable	Runnable
    //   56	4	1	localObject	Object
    //   61	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	53	56	finally
    //   2	53	61	java/lang/Exception
  }
  
  public void didComplete(Runnable paramRunnable)
  {
    this.active.remove(paramRunnable);
    startNext();
  }
  
  public void push(Runnable paramRunnable)
  {
    this.queue.add(paramRunnable);
    if (this.active.size() < 5) {
      startNext();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/asynchttp/ConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */