package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class aj
  extends o
{
  private static final Object nD = new Object();
  private static aj nN;
  private Context mContext;
  private Handler mHandler;
  private x mX = new x()
  {
    public void t(boolean paramAnonymousBoolean)
    {
      aj.this.b(paramAnonymousBoolean, aj.a(aj.this));
    }
  };
  private volatile y mk;
  private w nE;
  private int nF = 1800;
  private boolean nG = true;
  private boolean nH;
  private String nI;
  private boolean nJ = true;
  private boolean nK = true;
  private ai nL;
  private boolean nM = false;
  
  public static aj lq()
  {
    if (nN == null) {
      nN = new aj();
    }
    return nN;
  }
  
  private void lr()
  {
    this.nL = new ai(this);
    this.nL.r(this.mContext);
  }
  
  private void ls()
  {
    this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (aj.lu().equals(paramAnonymousMessage.obj)))
        {
          u.lF().u(true);
          aj.this.jG();
          u.lF().u(false);
          if ((aj.b(aj.this) > 0) && (!aj.c(aj.this))) {
            aj.d(aj.this).sendMessageDelayed(aj.d(aj.this).obtainMessage(1, aj.lu()), aj.b(aj.this) * 1000);
          }
        }
        return true;
      }
    });
    if (this.nF > 0) {
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, nD), this.nF * 1000);
    }
  }
  
  /* Error */
  void a(Context paramContext, y paramy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/android/gms/analytics/aj:mContext	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 84	com/google/android/gms/analytics/aj:mContext	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 118	com/google/android/gms/analytics/aj:mk	Lcom/google/android/gms/analytics/y;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 118	com/google/android/gms/analytics/aj:mk	Lcom/google/android/gms/analytics/y;
    //   34: aload_0
    //   35: getfield 49	com/google/android/gms/analytics/aj:nG	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 121	com/google/android/gms/analytics/aj:jG	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 49	com/google/android/gms/analytics/aj:nG	Z
    //   50: aload_0
    //   51: getfield 123	com/google/android/gms/analytics/aj:nH	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 126	com/google/android/gms/analytics/aj:la	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 123	com/google/android/gms/analytics/aj:nH	Z
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aj
    //   0	74	1	paramContext	Context
    //   0	74	2	paramy	y
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   14	50	69	finally
    //   50	66	69	finally
  }
  
  /* Error */
  void aX(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/android/gms/analytics/aj:mHandler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -126
    //   11: invokestatic 136	com/google/android/gms/analytics/j:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 47	com/google/android/gms/analytics/aj:nF	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 142	com/google/android/gms/analytics/u:lF	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 148	com/google/android/gms/analytics/u$a:pw	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 151	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 60	com/google/android/gms/analytics/aj:nM	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 51	com/google/android/gms/analytics/aj:nJ	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 47	com/google/android/gms/analytics/aj:nF	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 69	com/google/android/gms/analytics/aj:mHandler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 43	com/google/android/gms/analytics/aj:nD	Ljava/lang/Object;
    //   60: invokevirtual 155	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 47	com/google/android/gms/analytics/aj:nF	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 60	com/google/android/gms/analytics/aj:nM	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 51	com/google/android/gms/analytics/aj:nJ	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 69	com/google/android/gms/analytics/aj:mHandler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 69	com/google/android/gms/analytics/aj:mHandler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 43	com/google/android/gms/analytics/aj:nD	Ljava/lang/Object;
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
    //   0	119	0	this	aj
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.nM == paramBoolean1)
        {
          boolean bool = this.nJ;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.nF > 0)) {
          this.mHandler.removeMessages(1, nD);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.nF > 0)) {
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, nD), this.nF * 1000);
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
      j.C(str1);
      this.nM = paramBoolean1;
      this.nJ = paramBoolean2;
      continue;
      label150:
      String str2 = "terminated.";
      continue;
      label157:
      str2 = "initiated.";
    }
  }
  
  /* Error */
  void jG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/google/android/gms/analytics/aj:mk	Lcom/google/android/gms/analytics/y;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -81
    //   11: invokestatic 136	com/google/android/gms/analytics/j:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 49	com/google/android/gms/analytics/aj:nG	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 142	com/google/android/gms/analytics/u:lF	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 178	com/google/android/gms/analytics/u$a:pv	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 151	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 118	com/google/android/gms/analytics/aj:mk	Lcom/google/android/gms/analytics/y;
    //   35: invokeinterface 183 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	aj
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  void kZ()
  {
    try
    {
      if ((!this.nM) && (this.nJ) && (this.nF > 0))
      {
        this.mHandler.removeMessages(1, nD);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, nD));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void la()
  {
    if (this.mk == null)
    {
      j.C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.nH = true;
      return;
    }
    u.lF().a(u.a.pI);
    this.mk.la();
  }
  
  w lt()
  {
    try
    {
      if (this.nE != null) {
        break label80;
      }
      if (this.mContext == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.nE = new l(this.mX, this.mContext);
    if (this.nI != null)
    {
      this.nE.kU().ac(this.nI);
      this.nI = null;
    }
    label80:
    if (this.mHandler == null) {
      ls();
    }
    if ((this.nL == null) && (this.nK)) {
      lr();
    }
    w localw = this.nE;
    return localw;
  }
  
  void r(boolean paramBoolean)
  {
    try
    {
      b(this.nM, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */