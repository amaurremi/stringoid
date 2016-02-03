package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

class n
  implements ContainerHolder
{
  private final Looper a;
  private Container b;
  private Container c;
  private Status d;
  private dp e;
  private n.a f;
  private boolean g;
  private TagManager h;
  
  public n(Status paramStatus)
  {
    this.d = paramStatus;
    this.a = null;
  }
  
  public n(TagManager paramTagManager, Looper paramLooper, Container paramContainer, n.a parama)
  {
    this.h = paramTagManager;
    if (paramLooper != null) {}
    for (;;)
    {
      this.a = paramLooper;
      this.b = paramContainer;
      this.f = parama;
      this.d = Status.En;
      paramTagManager.a(this);
      return;
      paramLooper = Looper.getMainLooper();
    }
  }
  
  private void c()
  {
    if (this.e != null) {
      this.e.a(this.c.lm());
    }
  }
  
  String a()
  {
    if (this.g)
    {
      as.a("getContainerId called on a released ContainerHolder.");
      return "";
    }
    return this.b.getContainerId();
  }
  
  public void a(Container paramContainer)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.g;
        if (bool) {
          return;
        }
        if (paramContainer == null)
        {
          as.a("Unexpected null container.");
          continue;
        }
        this.c = paramContainer;
      }
      finally {}
      c();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/android/gms/tagmanager/n:g	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 36	com/google/android/gms/tagmanager/n:b	Lcom/google/android/gms/tagmanager/Container;
    //   18: aload_1
    //   19: invokevirtual 89	com/google/android/gms/tagmanager/Container:bH	(Ljava/lang/String;)V
    //   22: goto -11 -> 11
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	n
    //   0	30	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  String b()
  {
    if (this.g)
    {
      as.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return "";
    }
    return this.f.lo();
  }
  
  void b(String paramString)
  {
    if (this.g)
    {
      as.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return;
    }
    this.f.bJ(paramString);
  }
  
  /* Error */
  public Container getContainer()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 71	com/google/android/gms/tagmanager/n:g	Z
    //   8: ifeq +12 -> 20
    //   11: ldc 103
    //   13: invokestatic 76	com/google/android/gms/tagmanager/as:a	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 58	com/google/android/gms/tagmanager/n:c	Lcom/google/android/gms/tagmanager/Container;
    //   24: ifnull +16 -> 40
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 58	com/google/android/gms/tagmanager/n:c	Lcom/google/android/gms/tagmanager/Container;
    //   32: putfield 36	com/google/android/gms/tagmanager/n:b	Lcom/google/android/gms/tagmanager/Container;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 58	com/google/android/gms/tagmanager/n:c	Lcom/google/android/gms/tagmanager/Container;
    //   40: aload_0
    //   41: getfield 36	com/google/android/gms/tagmanager/n:b	Lcom/google/android/gms/tagmanager/Container;
    //   44: astore_1
    //   45: goto -29 -> 16
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	n
    //   1	44	1	localContainer	Container
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	48	finally
    //   20	40	48	finally
    //   40	45	48	finally
  }
  
  public Status getStatus()
  {
    return this.d;
  }
  
  /* Error */
  public void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/android/gms/tagmanager/n:g	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 108
    //   11: invokestatic 76	com/google/android/gms/tagmanager/as:a	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 38	com/google/android/gms/tagmanager/n:f	Lcom/google/android/gms/tagmanager/n$a;
    //   21: invokeinterface 111 1 0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	n
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/android/gms/tagmanager/n:g	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 114
    //   11: invokestatic 76	com/google/android/gms/tagmanager/as:a	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 71	com/google/android/gms/tagmanager/n:g	Z
    //   22: aload_0
    //   23: getfield 34	com/google/android/gms/tagmanager/n:h	Lcom/google/android/gms/tagmanager/TagManager;
    //   26: aload_0
    //   27: invokevirtual 117	com/google/android/gms/tagmanager/TagManager:b	(Lcom/google/android/gms/tagmanager/n;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 36	com/google/android/gms/tagmanager/n:b	Lcom/google/android/gms/tagmanager/Container;
    //   35: invokevirtual 119	com/google/android/gms/tagmanager/Container:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 36	com/google/android/gms/tagmanager/n:b	Lcom/google/android/gms/tagmanager/Container;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 58	com/google/android/gms/tagmanager/n:c	Lcom/google/android/gms/tagmanager/Container;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 38	com/google/android/gms/tagmanager/n:f	Lcom/google/android/gms/tagmanager/n$a;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 56	com/google/android/gms/tagmanager/n:e	Lcom/google/android/gms/tagmanager/dp;
    //   58: goto -44 -> 14
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	n
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   17	58	61	finally
  }
  
  public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener)
  {
    for (;;)
    {
      try
      {
        if (this.g)
        {
          as.a("ContainerHolder is released.");
          return;
        }
        if (paramContainerAvailableListener == null)
        {
          this.e = null;
          continue;
        }
        this.e = new dp(this, paramContainerAvailableListener, this.a);
      }
      finally {}
      if (this.c != null) {
        c();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */