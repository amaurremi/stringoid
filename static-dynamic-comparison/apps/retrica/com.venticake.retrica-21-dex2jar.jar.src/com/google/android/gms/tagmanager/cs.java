package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cs
  extends cr
{
  private static final Object a = new Object();
  private static cs n;
  private Context b;
  private ad c;
  private volatile ab d;
  private int e = 1800000;
  private boolean f = true;
  private boolean g = false;
  private boolean h = true;
  private boolean i = true;
  private ae j = new ae()
  {
    public void a(boolean paramAnonymousBoolean)
    {
      cs.this.a(paramAnonymousBoolean, cs.a(cs.this));
    }
  };
  private Handler k;
  private ay l;
  private boolean m = false;
  
  public static cs b()
  {
    if (n == null) {
      n = new cs();
    }
    return n;
  }
  
  private void f()
  {
    this.l = new ay(this);
    this.l.a(this.b);
  }
  
  private void g()
  {
    this.k = new Handler(this.b.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (cs.e().equals(paramAnonymousMessage.obj)))
        {
          cs.this.d();
          if ((cs.b(cs.this) > 0) && (!cs.c(cs.this))) {
            cs.d(cs.this).sendMessageDelayed(cs.d(cs.this).obtainMessage(1, cs.e()), cs.b(cs.this));
          }
        }
        return true;
      }
    });
    if (this.e > 0) {
      this.k.sendMessageDelayed(this.k.obtainMessage(1, a), this.e);
    }
  }
  
  void a()
  {
    try
    {
      if ((!this.m) && (this.h) && (this.e > 0))
      {
        this.k.removeMessages(1, a);
        this.k.sendMessage(this.k.obtainMessage(1, a));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void a(Context paramContext, ab paramab)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/google/android/gms/tagmanager/cs:b	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 121	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 85	com/google/android/gms/tagmanager/cs:b	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 123	com/google/android/gms/tagmanager/cs:d	Lcom/google/android/gms/tagmanager/ab;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 123	com/google/android/gms/tagmanager/cs:d	Lcom/google/android/gms/tagmanager/ab;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	cs
    //   0	42	1	paramContext	Context
    //   0	42	2	paramab	ab
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  void a(boolean paramBoolean)
  {
    try
    {
      a(this.m, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.m == paramBoolean1)
        {
          boolean bool = this.h;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.e > 0)) {
          this.k.removeMessages(1, a);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.e > 0)) {
          this.k.sendMessageDelayed(this.k.obtainMessage(1, a), this.e);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label153;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      as.e(str1);
      this.m = paramBoolean1;
      this.h = paramBoolean2;
      continue;
      label146:
      String str2 = "terminated.";
      continue;
      label153:
      str2 = "initiated.";
    }
  }
  
  ad c()
  {
    try
    {
      if (this.c != null) {
        break label50;
      }
      if (this.b == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.c = new bm(this.j, this.b);
    label50:
    if (this.k == null) {
      g();
    }
    this.g = true;
    if (this.f)
    {
      d();
      this.f = false;
    }
    if ((this.l == null) && (this.i)) {
      f();
    }
    ad localad = this.c;
    return localad;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gms/tagmanager/cs:g	Z
    //   6: ifne +16 -> 22
    //   9: ldc -87
    //   11: invokestatic 145	com/google/android/gms/tagmanager/as:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 50	com/google/android/gms/tagmanager/cs:f	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 123	com/google/android/gms/tagmanager/cs:d	Lcom/google/android/gms/tagmanager/ab;
    //   26: new 10	com/google/android/gms/tagmanager/cs$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 170	com/google/android/gms/tagmanager/cs$3:<init>	(Lcom/google/android/gms/tagmanager/cs;)V
    //   34: invokeinterface 175 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	cs
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */