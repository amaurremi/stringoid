package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx
  extends cw
{
  private static cx aam;
  private static final Object sF = new Object();
  private Context aac;
  private at aad;
  private volatile ar aae;
  private int aaf = 1800000;
  private boolean aag = true;
  private boolean aah = false;
  private boolean aai = true;
  private au aaj = new au()
  {
    public void r(boolean paramAnonymousBoolean)
    {
      cx.this.a(paramAnonymousBoolean, cx.a(cx.this));
    }
  };
  private bn aak;
  private boolean aal = false;
  private boolean connected = true;
  private Handler handler;
  
  private void cj()
  {
    this.aak = new bn(this);
    this.aak.o(this.aac);
  }
  
  private void ck()
  {
    this.handler = new Handler(this.aac.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (cx.cn().equals(paramAnonymousMessage.obj)))
        {
          cx.this.bW();
          if ((cx.b(cx.this) > 0) && (!cx.c(cx.this))) {
            cx.d(cx.this).sendMessageDelayed(cx.d(cx.this).obtainMessage(1, cx.cn()), cx.b(cx.this));
          }
        }
        return true;
      }
    });
    if (this.aaf > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), this.aaf);
    }
  }
  
  public static cx lG()
  {
    if (aam == null) {
      aam = new cx();
    }
    return aam;
  }
  
  /* Error */
  void a(Context paramContext, ar paramar)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/android/gms/tagmanager/cx:aac	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 123	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 78	com/google/android/gms/tagmanager/cx:aac	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 125	com/google/android/gms/tagmanager/cx:aae	Lcom/google/android/gms/tagmanager/ar;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 125	com/google/android/gms/tagmanager/cx:aae	Lcom/google/android/gms/tagmanager/ar;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	cx
    //   0	42	1	paramContext	Context
    //   0	42	2	paramar	ar
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.aal == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.aaf > 0)) {
          this.handler.removeMessages(1, sF);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.aaf > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), this.aaf);
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
      bh.y(str1);
      this.aal = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label146:
      String str2 = "terminated.";
      continue;
      label153:
      str2 = "initiated.";
    }
  }
  
  /* Error */
  public void bW()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gms/tagmanager/cx:aah	Z
    //   6: ifne +16 -> 22
    //   9: ldc -100
    //   11: invokestatic 149	com/google/android/gms/tagmanager/bh:y	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 50	com/google/android/gms/tagmanager/cx:aag	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 125	com/google/android/gms/tagmanager/cx:aae	Lcom/google/android/gms/tagmanager/ar;
    //   26: new 10	com/google/android/gms/tagmanager/cx$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 157	com/google/android/gms/tagmanager/cx$3:<init>	(Lcom/google/android/gms/tagmanager/cx;)V
    //   34: invokeinterface 162 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	cx
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  void cm()
  {
    try
    {
      if ((!this.aal) && (this.connected) && (this.aaf > 0))
      {
        this.handler.removeMessages(1, sF);
        this.handler.sendMessage(this.handler.obtainMessage(1, sF));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  at lH()
  {
    try
    {
      if (this.aad != null) {
        break label50;
      }
      if (this.aac == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.aad = new ca(this.aaj, this.aac);
    label50:
    if (this.handler == null) {
      ck();
    }
    this.aah = true;
    if (this.aag)
    {
      bW();
      this.aag = false;
    }
    if ((this.aak == null) && (this.aai)) {
      cj();
    }
    at localat = this.aad;
    return localat;
  }
  
  void s(boolean paramBoolean)
  {
    try
    {
      a(this.aal, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */