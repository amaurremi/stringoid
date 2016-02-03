package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class GAServiceProxy
  implements ac, b.b, b.c
{
  private c iA;
  private final e iB;
  private boolean iD;
  private volatile long iM;
  private volatile ConnectState iN;
  private volatile a iO;
  private c iP;
  private final s iQ;
  private final Queue<c> iR = new ConcurrentLinkedQueue();
  private volatile int iS;
  private volatile Timer iT;
  private volatile Timer iU;
  private volatile Timer iV;
  private boolean iW;
  private boolean iX;
  private boolean iY;
  private h iZ;
  private final Context iz;
  private long ja = 300000L;
  
  GAServiceProxy(Context paramContext, e parame)
  {
    this(paramContext, parame, null, s.j(paramContext));
  }
  
  GAServiceProxy(Context paramContext, e parame, c paramc, s params)
  {
    this.iP = paramc;
    this.iz = paramContext;
    this.iB = parame;
    this.iQ = params;
    this.iZ = new h()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.iS = 0;
    this.iN = ConnectState.jj;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void jJ()
  {
    this.iT = a(this.iT);
    this.iU = a(this.iU);
    this.iV = a(this.iV);
  }
  
  private void jL()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.iB.getThread()))
        {
          this.iB.jq().add(new Runnable()
          {
            public void run()
            {
              GAServiceProxy.a(GAServiceProxy.this);
            }
          });
          return;
        }
        if (this.iW) {
          ji();
        }
        switch (3.jc[this.iN.ordinal()])
        {
        case 1: 
          if (!this.iR.isEmpty())
          {
            c localc1 = (c)this.iR.poll();
            v.C("Sending hit to store  " + localc1);
            this.iA.a(localc1.jR(), localc1.jS(), localc1.getPath(), localc1.jT());
            continue;
          }
          if (!this.iD) {
            continue;
          }
        }
      }
      finally {}
      jM();
      continue;
      if (!this.iR.isEmpty())
      {
        c localc2 = (c)this.iR.peek();
        v.C("Sending hit to service   " + localc2);
        if (!this.iQ.jY()) {
          this.iO.a(localc2.jR(), localc2.jS(), localc2.getPath(), localc2.jT());
        }
        for (;;)
        {
          this.iR.poll();
          break;
          v.C("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.iM = this.iZ.currentTimeMillis();
      continue;
      v.C("Need to reconnect");
      if (!this.iR.isEmpty()) {
        jO();
      }
    }
  }
  
  private void jM()
  {
    this.iA.jn();
    this.iD = false;
  }
  
  private void jN()
  {
    for (;;)
    {
      try
      {
        ConnectState localConnectState1 = this.iN;
        ConnectState localConnectState2 = ConnectState.jf;
        if (localConnectState1 == localConnectState2) {
          return;
        }
        jJ();
        v.C("falling back to local store");
        if (this.iP != null)
        {
          this.iA = this.iP;
          this.iN = ConnectState.jf;
          jL();
          continue;
        }
        localq = q.jC();
      }
      finally {}
      q localq;
      localq.a(this.iz, this.iB);
      this.iA = localq.jF();
    }
  }
  
  private void jO()
  {
    for (;;)
    {
      try
      {
        if ((!this.iY) && (this.iO != null))
        {
          ConnectState localConnectState1 = this.iN;
          ConnectState localConnectState2 = ConnectState.jf;
          if (localConnectState1 != localConnectState2) {
            try
            {
              this.iS += 1;
              a(this.iU);
              this.iN = ConnectState.jd;
              this.iU = new Timer("Failed Connect");
              this.iU.schedule(new b(null), 3000L);
              v.C("connecting to Analytics service");
              this.iO.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              v.D("security exception on connectToService");
              jN();
              continue;
            }
          }
        }
        v.D("client not initialized.");
      }
      finally {}
      jN();
    }
  }
  
  private void jP()
  {
    try
    {
      if ((this.iO != null) && (this.iN == ConnectState.je))
      {
        this.iN = ConnectState.ji;
        this.iO.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void jQ()
  {
    this.iT = a(this.iT);
    this.iT = new Timer("Service Reconnect");
    this.iT.schedule(new d(null), 5000L);
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 339	com/google/analytics/tracking/android/GAServiceProxy$ConnectState:jh	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   6: putfield 107	com/google/analytics/tracking/android/GAServiceProxy:iN	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   9: aload_0
    //   10: getfield 102	com/google/analytics/tracking/android/GAServiceProxy:iS	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 196	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 341
    //   27: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 346
    //   37: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 319	com/google/analytics/tracking/android/v:D	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 348	com/google/analytics/tracking/android/GAServiceProxy:jQ	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 196	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 341
    //   63: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 350
    //   73: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 319	com/google/analytics/tracking/android/v:D	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 120	com/google/analytics/tracking/android/GAServiceProxy:jN	()V
    //   86: goto -36 -> 50
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	GAServiceProxy
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void b(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    v.C("putHit called");
    this.iR.add(new c(paramMap, paramLong, paramString, paramList));
    jL();
  }
  
  public void jK()
  {
    if (this.iO != null) {
      return;
    }
    this.iO = new b(this.iz, this, this);
    jO();
  }
  
  public void ji()
  {
    v.C("clearHits called");
    this.iR.clear();
    switch (3.jc[this.iN.ordinal()])
    {
    default: 
      this.iW = true;
      return;
    case 1: 
      this.iA.b(0L);
      this.iW = false;
      return;
    }
    this.iO.ji();
    this.iW = false;
  }
  
  public void jn()
  {
    switch (3.jc[this.iN.ordinal()])
    {
    default: 
      this.iD = true;
    case 2: 
      return;
    }
    jM();
  }
  
  public void jp()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.iY;
        if (bool) {
          return;
        }
        v.C("setForceLocalDispatch called.");
        this.iY = true;
        switch (3.jc[this.iN.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          jP();
          break;
        case 3: 
          this.iX = true;
        }
      }
      finally {}
    }
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
    //   5: getfield 146	com/google/analytics/tracking/android/GAServiceProxy:iU	Ljava/util/Timer;
    //   8: invokespecial 144	com/google/analytics/tracking/android/GAServiceProxy:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 146	com/google/analytics/tracking/android/GAServiceProxy:iU	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 102	com/google/analytics/tracking/android/GAServiceProxy:iS	I
    //   19: ldc_w 380
    //   22: invokestatic 216	com/google/analytics/tracking/android/v:C	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 324	com/google/analytics/tracking/android/GAServiceProxy$ConnectState:je	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   29: putfield 107	com/google/analytics/tracking/android/GAServiceProxy:iN	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   32: aload_0
    //   33: getfield 377	com/google/analytics/tracking/android/GAServiceProxy:iX	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 136	com/google/analytics/tracking/android/GAServiceProxy:jP	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 377	com/google/analytics/tracking/android/GAServiceProxy:iX	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 116	com/google/analytics/tracking/android/GAServiceProxy:jL	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 139	com/google/analytics/tracking/android/GAServiceProxy:iV	Ljava/util/Timer;
    //   61: invokespecial 144	com/google/analytics/tracking/android/GAServiceProxy:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 139	com/google/analytics/tracking/android/GAServiceProxy:iV	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 110	java/util/Timer
    //   71: dup
    //   72: ldc_w 382
    //   75: invokespecial 300	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 139	com/google/analytics/tracking/android/GAServiceProxy:iV	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 139	com/google/analytics/tracking/android/GAServiceProxy:iV	Ljava/util/Timer;
    //   85: new 21	com/google/analytics/tracking/android/GAServiceProxy$a
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 383	com/google/analytics/tracking/android/GAServiceProxy$a:<init>	(Lcom/google/analytics/tracking/android/GAServiceProxy;Lcom/google/analytics/tracking/android/GAServiceProxy$1;)V
    //   94: aload_0
    //   95: getfield 87	com/google/analytics/tracking/android/GAServiceProxy:ja	J
    //   98: invokevirtual 309	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	GAServiceProxy
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
        if (this.iN == ConnectState.ji)
        {
          v.C("Disconnected from service");
          jJ();
          this.iN = ConnectState.jj;
          return;
        }
        v.C("Unexpected disconnect.");
        this.iN = ConnectState.jh;
        if (this.iS < 2) {
          jQ();
        } else {
          jN();
        }
      }
      finally {}
    }
  }
  
  private static enum ConnectState
  {
    private ConnectState() {}
  }
  
  private class a
    extends TimerTask
  {
    private a() {}
    
    public void run()
    {
      if ((GAServiceProxy.b(GAServiceProxy.this) == GAServiceProxy.ConnectState.je) && (GAServiceProxy.e(GAServiceProxy.this).isEmpty()) && (GAServiceProxy.f(GAServiceProxy.this) + GAServiceProxy.g(GAServiceProxy.this) < GAServiceProxy.h(GAServiceProxy.this).currentTimeMillis()))
      {
        v.C("Disconnecting due to inactivity");
        GAServiceProxy.i(GAServiceProxy.this);
        return;
      }
      GAServiceProxy.j(GAServiceProxy.this).schedule(new a(GAServiceProxy.this), GAServiceProxy.g(GAServiceProxy.this));
    }
  }
  
  private class b
    extends TimerTask
  {
    private b() {}
    
    public void run()
    {
      if (GAServiceProxy.b(GAServiceProxy.this) == GAServiceProxy.ConnectState.jd) {
        GAServiceProxy.c(GAServiceProxy.this);
      }
    }
  }
  
  private static class c
  {
    private final Map<String, String> jl;
    private final long jm;
    private final String jn;
    private final List<Command> jo;
    
    public c(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
    {
      this.jl = paramMap;
      this.jm = paramLong;
      this.jn = paramString;
      this.jo = paramList;
    }
    
    public String getPath()
    {
      return this.jn;
    }
    
    public Map<String, String> jR()
    {
      return this.jl;
    }
    
    public long jS()
    {
      return this.jm;
    }
    
    public List<Command> jT()
    {
      return this.jo;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.jn);
      if (this.jl != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.jl.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("=");
          localStringBuilder.append((String)localEntry.getValue());
          localStringBuilder.append(",  ");
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  private class d
    extends TimerTask
  {
    private d() {}
    
    public void run()
    {
      GAServiceProxy.d(GAServiceProxy.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/GAServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */