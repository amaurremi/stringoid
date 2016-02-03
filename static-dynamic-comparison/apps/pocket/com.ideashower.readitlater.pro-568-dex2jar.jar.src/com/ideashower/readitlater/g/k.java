package com.ideashower.readitlater.g;

import com.ideashower.readitlater.d.a;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k
  implements a, Runnable
{
  private l a;
  private boolean b;
  protected int i;
  protected final AtomicInteger j = new AtomicInteger(1);
  protected final AtomicBoolean k = new AtomicBoolean(false);
  protected FutureTask l;
  protected final boolean m;
  protected i n;
  protected long o;
  
  public k()
  {
    this(2);
  }
  
  public k(int paramInt)
  {
    this.i = paramInt;
    this.m = b();
  }
  
  public void D()
  {
    this.k.set(true);
  }
  
  public void E()
  {
    a(null, null, 0L);
    run();
  }
  
  public boolean F()
  {
    return (this.n != null) && (this.n.a(this.o));
  }
  
  protected void G()
  {
    this.j.set(-2);
  }
  
  public boolean H()
  {
    return this.j.get() == -2;
  }
  
  protected void I() {}
  
  protected abstract void a();
  
  public void a(i parami, FutureTask paramFutureTask, long paramLong)
  {
    this.j.compareAndSet(1, 2);
    this.n = parami;
    this.l = paramFutureTask;
    this.o = paramLong;
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    this.a = paraml;
    this.b = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable) {}
  
  public boolean a_()
  {
    return (this.k.get()) || (this.j.get() == -1) || ((this.l != null) && (this.l.isCancelled())) || ((this.n != null) && ((this.n.d()) || (this.n.a(this.o))));
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable) {}
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public int d()
  {
    if (this.l == null) {
      throw new NullPointerException();
    }
    try
    {
      this.l.get();
      return this.j.get();
    }
    catch (Throwable localThrowable) {}
    return -2;
  }
  
  public void h(int paramInt)
  {
    this.i = paramInt;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: bipush 10
    //   4: invokestatic 124	android/os/Process:setThreadPriority	(I)V
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: invokevirtual 126	com/ideashower/readitlater/g/k:a_	()Z
    //   14: ifne +111 -> 125
    //   17: aload_0
    //   18: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   21: iconst_2
    //   22: iconst_3
    //   23: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   26: ifeq +99 -> 125
    //   29: aload_0
    //   30: invokevirtual 128	com/ideashower/readitlater/g/k:a	()V
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_3
    //   36: istore_2
    //   37: iload_1
    //   38: ifeq +18 -> 56
    //   41: iload_3
    //   42: istore_2
    //   43: aload_0
    //   44: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   47: invokevirtual 88	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   50: iconst_3
    //   51: if_icmpne +5 -> 56
    //   54: iconst_1
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 56	com/ideashower/readitlater/g/k:m	Z
    //   60: ifeq +78 -> 138
    //   63: new 10	com/ideashower/readitlater/g/k$1
    //   66: dup
    //   67: aload_0
    //   68: iload_2
    //   69: aload 4
    //   71: invokespecial 131	com/ideashower/readitlater/g/k$1:<init>	(Lcom/ideashower/readitlater/g/k;ZLjava/lang/Throwable;)V
    //   74: invokestatic 136	com/ideashower/readitlater/a/g:a	(Ljava/lang/Runnable;)V
    //   77: aload_0
    //   78: getfield 59	com/ideashower/readitlater/g/k:a	Lcom/ideashower/readitlater/g/l;
    //   81: ifnull +12 -> 93
    //   84: aload_0
    //   85: getfield 59	com/ideashower/readitlater/g/k:a	Lcom/ideashower/readitlater/g/l;
    //   88: invokeinterface 139 1 0
    //   93: aload_0
    //   94: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: iconst_3
    //   98: iconst_4
    //   99: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   102: pop
    //   103: return
    //   104: astore 4
    //   106: aload_0
    //   107: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   110: bipush -2
    //   112: invokevirtual 83	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   115: aload 4
    //   117: invokestatic 144	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -87 -> 35
    //   125: aload_0
    //   126: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   129: iconst_m1
    //   130: invokevirtual 83	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   133: aload_0
    //   134: invokevirtual 146	com/ideashower/readitlater/g/k:I	()V
    //   137: return
    //   138: aload_0
    //   139: iload_2
    //   140: aload 4
    //   142: invokevirtual 148	com/ideashower/readitlater/g/k:b	(ZLjava/lang/Throwable;)V
    //   145: aload_0
    //   146: getfield 59	com/ideashower/readitlater/g/k:a	Lcom/ideashower/readitlater/g/l;
    //   149: ifnull -72 -> 77
    //   152: aload_0
    //   153: getfield 97	com/ideashower/readitlater/g/k:b	Z
    //   156: ifeq +38 -> 194
    //   159: new 12	com/ideashower/readitlater/g/k$2
    //   162: dup
    //   163: aload_0
    //   164: iload_2
    //   165: invokespecial 151	com/ideashower/readitlater/g/k$2:<init>	(Lcom/ideashower/readitlater/g/k;Z)V
    //   168: invokestatic 136	com/ideashower/readitlater/a/g:a	(Ljava/lang/Runnable;)V
    //   171: goto -94 -> 77
    //   174: astore 4
    //   176: aload_0
    //   177: getfield 42	com/ideashower/readitlater/g/k:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   180: bipush -2
    //   182: invokevirtual 83	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   185: aload 4
    //   187: iconst_1
    //   188: invokestatic 154	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;Z)V
    //   191: goto -114 -> 77
    //   194: aload_0
    //   195: getfield 59	com/ideashower/readitlater/g/k:a	Lcom/ideashower/readitlater/g/l;
    //   198: aload_0
    //   199: iload_2
    //   200: invokeinterface 156 3 0
    //   205: goto -128 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	k
    //   34	88	1	i1	int
    //   36	164	2	bool1	boolean
    //   1	41	3	bool2	boolean
    //   8	62	4	localThrowable1	Throwable
    //   104	37	4	localThrowable2	Throwable
    //   174	12	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	33	104	java/lang/Throwable
    //   56	77	174	java/lang/Throwable
    //   138	171	174	java/lang/Throwable
    //   194	205	174	java/lang/Throwable
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */