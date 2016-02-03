package com.vungle.sdk;

final class ax
{
  private static int a = 10000;
  private static Thread b = null;
  private static a c;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 6	com/vungle/sdk/ax$a
    //   18: dup
    //   19: iconst_0
    //   20: invokespecial 23	com/vungle/sdk/ax$a:<init>	(B)V
    //   23: putstatic 25	com/vungle/sdk/ax:c	Lcom/vungle/sdk/ax$a;
    //   26: new 27	java/lang/Thread
    //   29: dup
    //   30: getstatic 25	com/vungle/sdk/ax:c	Lcom/vungle/sdk/ax$a;
    //   33: ldc 29
    //   35: invokespecial 32	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   38: astore_0
    //   39: aload_0
    //   40: putstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 36	java/lang/Thread:setPriority	(I)V
    //   48: getstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   51: iconst_1
    //   52: invokevirtual 40	java/lang/Thread:setDaemon	(Z)V
    //   55: getstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   58: invokevirtual 43	java/lang/Thread:start	()V
    //   61: goto -50 -> 11
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	38	0	localThread	Thread
    //   64	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	64	finally
    //   15	61	64	finally
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 25	com/vungle/sdk/ax:c	Lcom/vungle/sdk/ax$a;
    //   18: invokevirtual 45	com/vungle/sdk/ax$a:a	()V
    //   21: aconst_null
    //   22: putstatic 25	com/vungle/sdk/ax:c	Lcom/vungle/sdk/ax$a;
    //   25: aconst_null
    //   26: putstatic 18	com/vungle/sdk/ax:b	Ljava/lang/Thread;
    //   29: goto -18 -> 11
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localThread	Thread
    //   32	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	32	finally
    //   15	29	32	finally
  }
  
  private static final class a
    implements Runnable
  {
    private boolean a = true;
    
    public final void a()
    {
      this.a = false;
    }
    
    public final void run()
    {
      while (this.a)
      {
        if ((!ak.d()) && (!ak.j) && (!ak.k.booleanValue())) {
          al.d();
        }
        try
        {
          Thread.sleep(ax.c());
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */