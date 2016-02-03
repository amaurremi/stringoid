package com.android.a;

import java.util.concurrent.BlockingQueue;

public class k
  extends Thread
{
  private final BlockingQueue a;
  private final j b;
  private final b c;
  private final w d;
  private volatile boolean e = false;
  
  public k(BlockingQueue paramBlockingQueue, j paramj, b paramb, w paramw)
  {
    this.a = paramBlockingQueue;
    this.b = paramj;
    this.c = paramb;
    this.d = paramw;
  }
  
  private void a(p paramp, aa paramaa)
  {
    paramaa = paramp.a(paramaa);
    this.d.a(paramp, paramaa);
  }
  
  public void a()
  {
    this.e = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 56	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 23	com/android/a/k:a	Ljava/util/concurrent/BlockingQueue;
    //   9: invokeinterface 62 1 0
    //   14: checkcast 33	com/android/a/p
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 64
    //   21: invokevirtual 67	com/android/a/p:a	(Ljava/lang/String;)V
    //   24: aload_2
    //   25: invokevirtual 71	com/android/a/p:h	()Z
    //   28: ifeq +31 -> 59
    //   31: aload_2
    //   32: ldc 73
    //   34: invokevirtual 75	com/android/a/p:b	(Ljava/lang/String;)V
    //   37: goto -32 -> 5
    //   40: astore_3
    //   41: aload_0
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 76	com/android/a/k:a	(Lcom/android/a/p;Lcom/android/a/aa;)V
    //   47: goto -42 -> 5
    //   50: astore_2
    //   51: aload_0
    //   52: getfield 21	com/android/a/k:e	Z
    //   55: ifeq -50 -> 5
    //   58: return
    //   59: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   62: istore_1
    //   63: aload_0
    //   64: getfield 25	com/android/a/k:b	Lcom/android/a/j;
    //   67: aload_2
    //   68: invokeinterface 87 2 0
    //   73: astore_3
    //   74: aload_2
    //   75: ldc 89
    //   77: invokevirtual 67	com/android/a/p:a	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: getfield 93	com/android/a/m:d	Z
    //   84: ifeq +58 -> 142
    //   87: aload_2
    //   88: invokevirtual 96	com/android/a/p:w	()Z
    //   91: ifeq +51 -> 142
    //   94: aload_2
    //   95: ldc 98
    //   97: invokevirtual 75	com/android/a/p:b	(Ljava/lang/String;)V
    //   100: goto -95 -> 5
    //   103: astore_3
    //   104: aload_3
    //   105: ldc 100
    //   107: iconst_1
    //   108: anewarray 102	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_3
    //   114: invokevirtual 106	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 111	com/android/a/ab:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_0
    //   122: getfield 29	com/android/a/k:d	Lcom/android/a/w;
    //   125: aload_2
    //   126: new 48	com/android/a/aa
    //   129: dup
    //   130: aload_3
    //   131: invokespecial 114	com/android/a/aa:<init>	(Ljava/lang/Throwable;)V
    //   134: invokeinterface 40 3 0
    //   139: goto -134 -> 5
    //   142: aload_2
    //   143: aload_3
    //   144: invokevirtual 117	com/android/a/p:a	(Lcom/android/a/m;)Lcom/android/a/t;
    //   147: astore_3
    //   148: aload_2
    //   149: ldc 119
    //   151: invokevirtual 67	com/android/a/p:a	(Ljava/lang/String;)V
    //   154: aload_2
    //   155: invokevirtual 122	com/android/a/p:r	()Z
    //   158: ifeq +33 -> 191
    //   161: aload_3
    //   162: getfield 127	com/android/a/t:b	Lcom/android/a/c;
    //   165: ifnull +26 -> 191
    //   168: aload_0
    //   169: getfield 27	com/android/a/k:c	Lcom/android/a/b;
    //   172: aload_2
    //   173: invokevirtual 129	com/android/a/p:e	()Ljava/lang/String;
    //   176: aload_3
    //   177: getfield 127	com/android/a/t:b	Lcom/android/a/c;
    //   180: invokeinterface 134 3 0
    //   185: aload_2
    //   186: ldc -120
    //   188: invokevirtual 67	com/android/a/p:a	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: invokevirtual 139	com/android/a/p:v	()V
    //   195: aload_0
    //   196: getfield 29	com/android/a/k:d	Lcom/android/a/w;
    //   199: aload_2
    //   200: aload_3
    //   201: invokeinterface 142 3 0
    //   206: goto -201 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	k
    //   62	1	1	i	int
    //   17	26	2	localp	p
    //   50	150	2	localInterruptedException	InterruptedException
    //   40	4	3	localaa	aa
    //   73	8	3	localm	m
    //   103	41	3	localException	Exception
    //   147	54	3	localt	t
    // Exception table:
    //   from	to	target	type
    //   18	37	40	com/android/a/aa
    //   59	100	40	com/android/a/aa
    //   142	191	40	com/android/a/aa
    //   191	206	40	com/android/a/aa
    //   5	18	50	java/lang/InterruptedException
    //   18	37	103	java/lang/Exception
    //   59	100	103	java/lang/Exception
    //   142	191	103	java/lang/Exception
    //   191	206	103	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */