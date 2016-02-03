package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class q
  extends ab
{
  private static q iK;
  private static final Object iy = new Object();
  private boolean connected = true;
  private Handler handler;
  private c iA;
  private volatile e iB;
  private int iC = 1800;
  private boolean iD = true;
  private boolean iE;
  private String iF;
  private boolean iG = true;
  private d iH = new d()
  {
    public void m(boolean paramAnonymousBoolean)
    {
      q.this.a(paramAnonymousBoolean, q.a(q.this));
    }
  };
  private p iI;
  private boolean iJ = false;
  private Context iz;
  
  public static q jC()
  {
    if (iK == null) {
      iK = new q();
    }
    return iK;
  }
  
  private void jD()
  {
    this.iI = new p(this);
    this.iI.f(this.iz);
  }
  
  private void jE()
  {
    this.handler = new Handler(this.iz.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (q.jI().equals(paramAnonymousMessage.obj)))
        {
          GAUsage.jU().o(true);
          q.this.jG();
          GAUsage.jU().o(false);
          if ((q.b(q.this) > 0) && (!q.c(q.this))) {
            q.d(q.this).sendMessageDelayed(q.d(q.this).obtainMessage(1, q.jI()), q.b(q.this) * 1000);
          }
        }
        return true;
      }
    });
    if (this.iC > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, iy), this.iC * 1000);
    }
  }
  
  /* Error */
  void a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/analytics/tracking/android/q:iz	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 84	com/google/analytics/tracking/android/q:iz	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 118	com/google/analytics/tracking/android/q:iB	Lcom/google/analytics/tracking/android/e;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 118	com/google/analytics/tracking/android/q:iB	Lcom/google/analytics/tracking/android/e;
    //   34: aload_0
    //   35: getfield 49	com/google/analytics/tracking/android/q:iD	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 121	com/google/analytics/tracking/android/q:jG	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 49	com/google/analytics/tracking/android/q:iD	Z
    //   50: aload_0
    //   51: getfield 123	com/google/analytics/tracking/android/q:iE	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 126	com/google/analytics/tracking/android/q:jp	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 123	com/google/analytics/tracking/android/q:iE	Z
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramContext	Context
    //   0	74	2	parame	e
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   14	50	69	finally
    //   50	66	69	finally
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.iJ == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.iC > 0)) {
          this.handler.removeMessages(1, iy);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.iC > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, iy), this.iC * 1000);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label157;
        }
        if (paramBoolean2) {
          break label150;
        }
      }
      finally {}
      v.C(str1);
      this.iJ = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label150:
      String str2 = "terminated.";
      continue;
      label157:
      str2 = "initiated.";
    }
  }
  
  /* Error */
  @Deprecated
  public void aX(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/analytics/tracking/android/q:handler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -97
    //   11: invokestatic 150	com/google/analytics/tracking/android/v:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 47	com/google/analytics/tracking/android/q:iC	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 165	com/google/analytics/tracking/android/GAUsage:jU	()Lcom/google/analytics/tracking/android/GAUsage;
    //   25: getstatic 171	com/google/analytics/tracking/android/GAUsage$Field:kv	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   28: invokevirtual 174	com/google/analytics/tracking/android/GAUsage:a	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   31: aload_0
    //   32: getfield 60	com/google/analytics/tracking/android/q:iJ	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 51	com/google/analytics/tracking/android/q:connected	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 47	com/google/analytics/tracking/android/q:iC	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 69	com/google/analytics/tracking/android/q:handler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 43	com/google/analytics/tracking/android/q:iy	Ljava/lang/Object;
    //   60: invokevirtual 131	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 47	com/google/analytics/tracking/android/q:iC	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 60	com/google/analytics/tracking/android/q:iJ	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 51	com/google/analytics/tracking/android/q:connected	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 69	com/google/analytics/tracking/android/q:handler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 69	com/google/analytics/tracking/android/q:handler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 43	com/google/analytics/tracking/android/q:iy	Ljava/lang/Object;
    //   98: invokevirtual 105	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 109	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	q
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
  
  c jF()
  {
    try
    {
      if (this.iA != null) {
        break label80;
      }
      if (this.iz == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.iA = new z(this.iH, this.iz);
    if (this.iF != null)
    {
      this.iA.jo().s(this.iF);
      this.iF = null;
    }
    label80:
    if (this.handler == null) {
      jE();
    }
    if ((this.iI == null) && (this.iG)) {
      jD();
    }
    c localc = this.iA;
    return localc;
  }
  
  /* Error */
  @Deprecated
  public void jG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/google/analytics/tracking/android/q:iB	Lcom/google/analytics/tracking/android/e;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -47
    //   11: invokestatic 150	com/google/analytics/tracking/android/v:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 49	com/google/analytics/tracking/android/q:iD	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 165	com/google/analytics/tracking/android/GAUsage:jU	()Lcom/google/analytics/tracking/android/GAUsage;
    //   25: getstatic 212	com/google/analytics/tracking/android/GAUsage$Field:kt	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   28: invokevirtual 174	com/google/analytics/tracking/android/GAUsage:a	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   31: aload_0
    //   32: getfield 118	com/google/analytics/tracking/android/q:iB	Lcom/google/analytics/tracking/android/e;
    //   35: invokeinterface 217 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	q
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  void jH()
  {
    try
    {
      if ((!this.iJ) && (this.connected) && (this.iC > 0))
      {
        this.handler.removeMessages(1, iy);
        this.handler.sendMessage(this.handler.obtainMessage(1, iy));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  public void jp()
  {
    if (this.iB == null)
    {
      v.C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.iE = true;
      return;
    }
    GAUsage.jU().a(GAUsage.Field.kH);
    this.iB.jp();
  }
  
  void n(boolean paramBoolean)
  {
    try
    {
      a(this.iJ, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */