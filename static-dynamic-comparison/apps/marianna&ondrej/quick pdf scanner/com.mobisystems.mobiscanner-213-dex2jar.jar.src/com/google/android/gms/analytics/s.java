package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.di;
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

class s
  implements p, v.b, v.c
{
  private final Context mContext;
  private ab mH;
  private final y mk;
  private w nE;
  private boolean nG;
  private volatile long nP;
  private volatile a nQ;
  private volatile t nR;
  private w nS;
  private final Queue<d> nT = new ConcurrentLinkedQueue();
  private volatile int nU;
  private volatile Timer nV;
  private volatile Timer nW;
  private volatile Timer nY;
  private boolean nZ;
  private final c ni;
  private boolean oa;
  private boolean ob;
  private long oc = 300000L;
  
  s(Context paramContext, y paramy)
  {
    this(paramContext, paramy, null, c.o(paramContext));
  }
  
  s(Context paramContext, y paramy, w paramw, c paramc)
  {
    this.nS = paramw;
    this.mContext = paramContext;
    this.mk = paramy;
    this.ni = paramc;
    this.mH = new ab()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.nU = 0;
    this.nQ = a.ol;
  }
  
  private Timer b(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void lA()
  {
    try
    {
      if ((this.nR != null) && (this.nQ == a.og))
      {
        this.nQ = a.ok;
        this.nR.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void lB()
  {
    this.nV = b(this.nV);
    this.nV = new Timer("Service Reconnect");
    this.nV.schedule(new e(null), 5000L);
  }
  
  private void lv()
  {
    this.nV = b(this.nV);
    this.nW = b(this.nW);
    this.nY = b(this.nY);
  }
  
  private void lw()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.mk.getThread()))
        {
          this.mk.li().add(new Runnable()
          {
            public void run()
            {
              s.a(s.this);
            }
          });
          return;
        }
        if (this.nZ) {
          ld();
        }
        switch (3.oe[this.nQ.ordinal()])
        {
        case 1: 
          if (!this.nT.isEmpty())
          {
            d locald1 = (d)this.nT.poll();
            j.C("Sending hit to store  " + locald1);
            this.nE.b(locald1.lC(), locald1.lD(), locald1.getPath(), locald1.lE());
            continue;
          }
          if (!this.nG) {
            continue;
          }
        }
      }
      finally {}
      lx();
      continue;
      if (!this.nT.isEmpty())
      {
        d locald2 = (d)this.nT.peek();
        j.C("Sending hit to service   " + locald2);
        if (!this.ni.jY()) {
          this.nR.d(locald2.lC(), locald2.lD(), locald2.getPath(), locald2.lE());
        }
        for (;;)
        {
          this.nT.poll();
          break;
          j.C("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.nP = this.mH.currentTimeMillis();
      continue;
      j.C("Need to reconnect");
      if (!this.nT.isEmpty()) {
        lz();
      }
    }
  }
  
  private void lx()
  {
    this.nE.kT();
    this.nG = false;
  }
  
  private void ly()
  {
    for (;;)
    {
      try
      {
        a locala1 = this.nQ;
        a locala2 = a.oh;
        if (locala1 == locala2) {
          return;
        }
        lv();
        j.C("falling back to local store");
        if (this.nS != null)
        {
          this.nE = this.nS;
          this.nQ = a.oh;
          lw();
          continue;
        }
        localaj = aj.lq();
      }
      finally {}
      aj localaj;
      localaj.a(this.mContext, this.mk);
      this.nE = localaj.lt();
    }
  }
  
  private void lz()
  {
    for (;;)
    {
      try
      {
        if ((!this.ob) && (this.nR != null))
        {
          a locala1 = this.nQ;
          a locala2 = a.oh;
          if (locala1 != locala2) {
            try
            {
              this.nU += 1;
              b(this.nW);
              this.nQ = a.of;
              this.nW = new Timer("Failed Connect");
              this.nW.schedule(new c(null), 3000L);
              j.C("connecting to Analytics service");
              this.nR.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              j.D("security exception on connectToService");
              ly();
              continue;
            }
          }
        }
        j.D("client not initialized.");
      }
      finally {}
      ly();
    }
  }
  
  /* Error */
  public void b(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 340	com/google/android/gms/analytics/s$a:oj	Lcom/google/android/gms/analytics/s$a;
    //   6: putfield 107	com/google/android/gms/analytics/s:nQ	Lcom/google/android/gms/analytics/s$a;
    //   9: aload_0
    //   10: getfield 102	com/google/android/gms/analytics/s:nU	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 224	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 342
    //   27: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 347
    //   37: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 334	com/google/android/gms/analytics/j:D	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 349	com/google/android/gms/analytics/s:lB	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 224	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 342
    //   63: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 351
    //   73: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 334	com/google/android/gms/analytics/j:D	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 120	com/google/android/gms/analytics/s:ly	()V
    //   86: goto -36 -> 50
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	s
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void c(Map<String, String> paramMap, long paramLong, String paramString, List<di> paramList)
  {
    j.C("putHit called");
    this.nT.add(new d(paramMap, paramLong, paramString, paramList));
    lw();
  }
  
  public void kT()
  {
    switch (3.oe[this.nQ.ordinal()])
    {
    default: 
      this.nG = true;
    case 2: 
      return;
    }
    lx();
  }
  
  public void la()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.ob;
        if (bool) {
          return;
        }
        j.C("setForceLocalDispatch called.");
        this.ob = true;
        switch (3.oe[this.nQ.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          lA();
          break;
        case 3: 
          this.oa = true;
        }
      }
      finally {}
    }
  }
  
  public void lb()
  {
    if (this.nR != null) {
      return;
    }
    this.nR = new v(this.mContext, this, this);
    lz();
  }
  
  public void ld()
  {
    j.C("clearHits called");
    this.nT.clear();
    switch (3.oe[this.nQ.ordinal()])
    {
    default: 
      this.nZ = true;
      return;
    case 1: 
      this.nE.d(0L);
      this.nZ = false;
      return;
    }
    this.nR.ld();
    this.nZ = false;
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
    //   5: getfield 174	com/google/android/gms/analytics/s:nW	Ljava/util/Timer;
    //   8: invokespecial 157	com/google/android/gms/analytics/s:b	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 174	com/google/android/gms/analytics/s:nW	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 102	com/google/android/gms/analytics/s:nU	I
    //   19: ldc_w 381
    //   22: invokestatic 243	com/google/android/gms/analytics/j:C	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 144	com/google/android/gms/analytics/s$a:og	Lcom/google/android/gms/analytics/s$a;
    //   29: putfield 107	com/google/android/gms/analytics/s:nQ	Lcom/google/android/gms/analytics/s$a;
    //   32: aload_0
    //   33: getfield 363	com/google/android/gms/analytics/s:oa	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 135	com/google/android/gms/analytics/s:lA	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 363	com/google/android/gms/analytics/s:oa	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 110	com/google/android/gms/analytics/s:lw	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 139	com/google/android/gms/analytics/s:nY	Ljava/util/Timer;
    //   61: invokespecial 157	com/google/android/gms/analytics/s:b	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 139	com/google/android/gms/analytics/s:nY	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 114	java/util/Timer
    //   71: dup
    //   72: ldc_w 383
    //   75: invokespecial 162	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 139	com/google/android/gms/analytics/s:nY	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 139	com/google/android/gms/analytics/s:nY	Ljava/util/Timer;
    //   85: new 21	com/google/android/gms/analytics/s$b
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 384	com/google/android/gms/analytics/s$b:<init>	(Lcom/google/android/gms/analytics/s;Lcom/google/android/gms/analytics/s$1;)V
    //   94: aload_0
    //   95: getfield 87	com/google/android/gms/analytics/s:oc	J
    //   98: invokevirtual 171	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	s
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
        if (this.nQ == a.ok)
        {
          j.C("Disconnected from service");
          lv();
          this.nQ = a.ol;
          return;
        }
        j.C("Unexpected disconnect.");
        this.nQ = a.oj;
        if (this.nU < 2) {
          lB();
        } else {
          ly();
        }
      }
      finally {}
    }
  }
  
  private static enum a
  {
    private a() {}
  }
  
  private class b
    extends TimerTask
  {
    private b() {}
    
    public void run()
    {
      if ((s.b(s.this) == s.a.og) && (s.e(s.this).isEmpty()) && (s.f(s.this) + s.g(s.this) < s.h(s.this).currentTimeMillis()))
      {
        j.C("Disconnecting due to inactivity");
        s.i(s.this);
        return;
      }
      s.j(s.this).schedule(new b(s.this), s.g(s.this));
    }
  }
  
  private class c
    extends TimerTask
  {
    private c() {}
    
    public void run()
    {
      if (s.b(s.this) == s.a.of) {
        s.c(s.this);
      }
    }
  }
  
  private static class d
  {
    private final Map<String, String> on;
    private final long oo;
    private final String op;
    private final List<di> oq;
    
    public d(Map<String, String> paramMap, long paramLong, String paramString, List<di> paramList)
    {
      this.on = paramMap;
      this.oo = paramLong;
      this.op = paramString;
      this.oq = paramList;
    }
    
    public String getPath()
    {
      return this.op;
    }
    
    public Map<String, String> lC()
    {
      return this.on;
    }
    
    public long lD()
    {
      return this.oo;
    }
    
    public List<di> lE()
    {
      return this.oq;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.op);
      if (this.on != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.on.entrySet().iterator();
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
  
  private class e
    extends TimerTask
  {
    private e() {}
    
    public void run()
    {
      s.d(s.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */