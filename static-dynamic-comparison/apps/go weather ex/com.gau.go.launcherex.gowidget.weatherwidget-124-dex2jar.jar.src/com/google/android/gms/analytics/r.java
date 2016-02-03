package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class r
  extends af
{
  private static final Object sF = new Object();
  private static r sR;
  private Context mContext;
  private Handler mHandler;
  private d sG;
  private volatile f sH;
  private int sI = 1800;
  private boolean sJ = true;
  private boolean sK;
  private String sL;
  private boolean sM = true;
  private boolean sN = true;
  private e sO = new e()
  {
    public void r(boolean paramAnonymousBoolean)
    {
      r.this.a(paramAnonymousBoolean, r.a(r.this));
    }
  };
  private q sP;
  private boolean sQ = false;
  
  public static r ci()
  {
    if (sR == null) {
      sR = new r();
    }
    return sR;
  }
  
  private void cj()
  {
    this.sP = new q(this);
    this.sP.o(this.mContext);
  }
  
  private void ck()
  {
    this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (r.cn().equals(paramAnonymousMessage.obj)))
        {
          u.cy().t(true);
          r.this.dispatchLocalHits();
          u.cy().t(false);
          if ((r.b(r.this) > 0) && (!r.c(r.this))) {
            r.d(r.this).sendMessageDelayed(r.d(r.this).obtainMessage(1, r.cn()), r.b(r.this) * 1000);
          }
        }
        return true;
      }
    });
    if (this.sI > 0) {
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), this.sI * 1000);
    }
  }
  
  /* Error */
  void a(Context paramContext, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 80	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 118	com/google/android/gms/analytics/r:sH	Lcom/google/android/gms/analytics/f;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 118	com/google/android/gms/analytics/r:sH	Lcom/google/android/gms/analytics/f;
    //   34: aload_0
    //   35: getfield 49	com/google/android/gms/analytics/r:sJ	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 121	com/google/android/gms/analytics/r:dispatchLocalHits	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 49	com/google/android/gms/analytics/r:sJ	Z
    //   50: aload_0
    //   51: getfield 123	com/google/android/gms/analytics/r:sK	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 126	com/google/android/gms/analytics/r:bY	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 123	com/google/android/gms/analytics/r:sK	Z
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	r
    //   0	74	1	paramContext	Context
    //   0	74	2	paramf	f
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
        if (this.sQ == paramBoolean1)
        {
          boolean bool = this.sM;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.sI > 0)) {
          this.mHandler.removeMessages(1, sF);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.sI > 0)) {
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), this.sI * 1000);
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
      aa.y(str1);
      this.sQ = paramBoolean1;
      this.sM = paramBoolean2;
      continue;
      label150:
      String str2 = "terminated.";
      continue;
      label157:
      str2 = "initiated.";
    }
  }
  
  void bY()
  {
    if (this.sH == null)
    {
      aa.y("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.sK = true;
      return;
    }
    u.cy().a(u.a.uN);
    this.sH.bY();
  }
  
  d cl()
  {
    try
    {
      if (this.sG != null) {
        break label80;
      }
      if (this.mContext == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.sG = new ac(this.sO, this.mContext);
    if (this.sL != null)
    {
      this.sG.bX().F(this.sL);
      this.sL = null;
    }
    label80:
    if (this.mHandler == null) {
      ck();
    }
    if ((this.sP == null) && (this.sN)) {
      cj();
    }
    d locald = this.sG;
    return locald;
  }
  
  void cm()
  {
    try
    {
      if ((!this.sQ) && (this.sM) && (this.sI > 0))
      {
        this.mHandler.removeMessages(1, sF);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, sF));
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
  void dispatchLocalHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/google/android/gms/analytics/r:sH	Lcom/google/android/gms/analytics/f;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -43
    //   11: invokestatic 150	com/google/android/gms/analytics/aa:y	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 49	com/google/android/gms/analytics/r:sJ	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 162	com/google/android/gms/analytics/u:cy	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 216	com/google/android/gms/analytics/u$a:uA	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 171	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 118	com/google/android/gms/analytics/r:sH	Lcom/google/android/gms/analytics/f;
    //   35: invokeinterface 219 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	r
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  void s(boolean paramBoolean)
  {
    try
    {
      a(this.sQ, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void setLocalDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -29
    //   11: invokestatic 150	com/google/android/gms/analytics/aa:y	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 47	com/google/android/gms/analytics/r:sI	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 162	com/google/android/gms/analytics/u:cy	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 230	com/google/android/gms/analytics/u$a:uB	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 171	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 60	com/google/android/gms/analytics/r:sQ	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 51	com/google/android/gms/analytics/r:sM	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 47	com/google/android/gms/analytics/r:sI	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 99	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 43	com/google/android/gms/analytics/r:sF	Ljava/lang/Object;
    //   60: invokevirtual 131	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 47	com/google/android/gms/analytics/r:sI	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 60	com/google/android/gms/analytics/r:sQ	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 51	com/google/android/gms/analytics/r:sM	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 99	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 99	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 43	com/google/android/gms/analytics/r:sF	Ljava/lang/Object;
    //   98: invokevirtual 103	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 107	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	r
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */