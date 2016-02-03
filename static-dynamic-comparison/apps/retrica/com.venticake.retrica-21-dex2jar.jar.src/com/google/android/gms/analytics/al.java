package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.fd;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class al
  implements c.b, c.c, n
{
  private volatile long a;
  private volatile am b;
  private volatile v c;
  private x d;
  private x e;
  private final GoogleAnalytics f;
  private final z g;
  private final Context h;
  private final Queue<ap> i = new ConcurrentLinkedQueue();
  private volatile int j;
  private volatile Timer k;
  private volatile Timer l;
  private volatile Timer m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private ad r;
  private long s = 300000L;
  
  al(Context paramContext, z paramz)
  {
    this(paramContext, paramz, null, GoogleAnalytics.getInstance(paramContext));
  }
  
  al(Context paramContext, z paramz, x paramx, GoogleAnalytics paramGoogleAnalytics)
  {
    this.e = paramx;
    this.h = paramContext;
    this.g = paramz;
    this.f = paramGoogleAnalytics;
    this.r = new ad()
    {
      public long a()
      {
        return System.currentTimeMillis();
      }
    };
    this.j = 0;
    this.b = am.g;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void e()
  {
    this.k = a(this.k);
    this.l = a(this.l);
    this.m = a(this.m);
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.g.e()))
        {
          this.g.d().add(new Runnable()
          {
            public void run()
            {
              al.a(al.this);
            }
          });
          return;
        }
        if (this.o) {
          a();
        }
        switch (3.a[this.b.ordinal()])
        {
        case 1: 
          if (!this.i.isEmpty())
          {
            ap localap1 = (ap)this.i.poll();
            aa.C("Sending hit to store  " + localap1);
            this.d.a(localap1.a(), localap1.b(), localap1.c(), localap1.d());
            continue;
          }
          if (!this.n) {
            continue;
          }
        }
      }
      finally {}
      g();
      continue;
      if (!this.i.isEmpty())
      {
        ap localap2 = (ap)this.i.peek();
        aa.C("Sending hit to service   " + localap2);
        if (!this.f.isDryRunEnabled()) {
          this.c.a(localap2.a(), localap2.b(), localap2.c(), localap2.d());
        }
        for (;;)
        {
          this.i.poll();
          break;
          aa.C("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.a = this.r.a();
      continue;
      aa.C("Need to reconnect");
      if (!this.i.isEmpty()) {
        i();
      }
    }
  }
  
  private void g()
  {
    this.d.c();
    this.n = false;
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        am localam1 = this.b;
        am localam2 = am.c;
        if (localam1 == localam2) {
          return;
        }
        e();
        aa.C("falling back to local store");
        if (this.e != null)
        {
          this.d = this.e;
          this.b = am.c;
          f();
          continue;
        }
        localak = ak.c();
      }
      finally {}
      ak localak;
      localak.a(this.h, this.g);
      this.d = localak.d();
    }
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        if ((!this.q) && (this.c != null))
        {
          am localam1 = this.b;
          am localam2 = am.c;
          if (localam1 != localam2) {
            try
            {
              this.j += 1;
              a(this.l);
              this.b = am.a;
              this.l = new Timer("Failed Connect");
              this.l.schedule(new ao(this, null), 3000L);
              aa.C("connecting to Analytics service");
              this.c.b();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              aa.D("security exception on connectToService");
              h();
              continue;
            }
          }
        }
        aa.D("client not initialized.");
      }
      finally {}
      h();
    }
  }
  
  private void j()
  {
    try
    {
      if ((this.c != null) && (this.b == am.b))
      {
        this.b = am.f;
        this.c.c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void k()
  {
    this.k = a(this.k);
    this.k = new Timer("Service Reconnect");
    this.k.schedule(new aq(this, null), 5000L);
  }
  
  public void a()
  {
    aa.C("clearHits called");
    this.i.clear();
    switch (3.a[this.b.ordinal()])
    {
    default: 
      this.o = true;
      return;
    case 1: 
      this.d.a(0L);
      this.o = false;
      return;
    }
    this.c.a();
    this.o = false;
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 308	com/google/android/gms/analytics/am:e	Lcom/google/android/gms/analytics/am;
    //   6: putfield 93	com/google/android/gms/analytics/al:b	Lcom/google/android/gms/analytics/am;
    //   9: aload_0
    //   10: getfield 87	com/google/android/gms/analytics/al:j	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 166	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 310
    //   27: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 315
    //   37: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 280	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 317	com/google/android/gms/analytics/al:k	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 166	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 310
    //   63: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 319
    //   73: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 280	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 104	com/google/android/gms/analytics/al:h	()V
    //   86: goto -36 -> 50
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	al
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<fd> paramList)
  {
    aa.C("putHit called");
    this.i.add(new ap(paramMap, paramLong, paramString, paramList));
    f();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.q;
        if (bool) {
          return;
        }
        aa.C("setForceLocalDispatch called.");
        this.q = true;
        switch (3.a[this.b.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          j();
          break;
        case 3: 
          this.p = true;
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    switch (3.a[this.b.ordinal()])
    {
    default: 
      this.n = true;
    case 2: 
      return;
    }
    g();
  }
  
  public void d()
  {
    if (this.c != null) {
      return;
    }
    this.c = new c(this.h, this, this);
    i();
  }
  
  /* Error */
  public void onConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_0
    //   5: getfield 113	com/google/android/gms/analytics/al:l	Ljava/util/Timer;
    //   8: invokespecial 111	com/google/android/gms/analytics/al:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 113	com/google/android/gms/analytics/al:l	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 87	com/google/android/gms/analytics/al:j	I
    //   19: ldc_w 338
    //   22: invokestatic 186	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 286	com/google/android/gms/analytics/am:b	Lcom/google/android/gms/analytics/am;
    //   29: putfield 93	com/google/android/gms/analytics/al:b	Lcom/google/android/gms/analytics/am;
    //   32: aload_0
    //   33: getfield 330	com/google/android/gms/analytics/al:p	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 284	com/google/android/gms/analytics/al:j	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 330	com/google/android/gms/analytics/al:p	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 101	com/google/android/gms/analytics/al:f	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 115	com/google/android/gms/analytics/al:m	Ljava/util/Timer;
    //   61: invokespecial 111	com/google/android/gms/analytics/al:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 115	com/google/android/gms/analytics/al:m	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 96	java/util/Timer
    //   71: dup
    //   72: ldc_w 340
    //   75: invokespecial 260	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 115	com/google/android/gms/analytics/al:m	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 115	com/google/android/gms/analytics/al:m	Ljava/util/Timer;
    //   85: new 342	com/google/android/gms/analytics/an
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 343	com/google/android/gms/analytics/an:<init>	(Lcom/google/android/gms/analytics/al;Lcom/google/android/gms/analytics/al$1;)V
    //   94: aload_0
    //   95: getfield 72	com/google/android/gms/analytics/al:s	J
    //   98: invokevirtual 271	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	al
    //   104	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	104	finally
    //   51	101	104	finally
  }
  
  public void onDisconnected()
  {
    for (;;)
    {
      try
      {
        if (this.b == am.f)
        {
          aa.C("Disconnected from service");
          e();
          this.b = am.g;
          return;
        }
        aa.C("Unexpected disconnect.");
        this.b = am.e;
        if (this.j < 2) {
          k();
        } else {
          h();
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */