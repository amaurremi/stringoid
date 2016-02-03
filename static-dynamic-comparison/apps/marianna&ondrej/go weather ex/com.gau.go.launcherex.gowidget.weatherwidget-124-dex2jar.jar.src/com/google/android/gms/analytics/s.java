package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.ef;
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
  implements ag, c.b, c.c
{
  private final Context mContext;
  private d sG;
  private final f sH;
  private boolean sJ;
  private volatile long sT;
  private volatile a sU;
  private volatile b sV;
  private d sW;
  private final GoogleAnalytics sX;
  private final Queue<d> sY = new ConcurrentLinkedQueue();
  private volatile int sZ;
  private volatile Timer ta;
  private volatile Timer tb;
  private volatile Timer tc;
  private boolean td;
  private boolean te;
  private boolean tf;
  private i tg;
  private long th = 300000L;
  
  s(Context paramContext, f paramf)
  {
    this(paramContext, paramf, null, GoogleAnalytics.getInstance(paramContext));
  }
  
  s(Context paramContext, f paramf, d paramd, GoogleAnalytics paramGoogleAnalytics)
  {
    this.sW = paramd;
    this.mContext = paramContext;
    this.sH = paramf;
    this.sX = paramGoogleAnalytics;
    this.tg = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.sZ = 0;
    this.sU = a.tq;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void be()
  {
    try
    {
      if ((this.sV != null) && (this.sU == a.tl))
      {
        this.sU = a.tp;
        this.sV.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void co()
  {
    this.ta = a(this.ta);
    this.tb = a(this.tb);
    this.tc = a(this.tc);
  }
  
  private void cq()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.sH.getThread()))
        {
          this.sH.bZ().add(new Runnable()
          {
            public void run()
            {
              s.a(s.this);
            }
          });
          return;
        }
        if (this.td) {
          bR();
        }
        switch (3.tj[this.sU.ordinal()])
        {
        case 1: 
          if (!this.sY.isEmpty())
          {
            d locald1 = (d)this.sY.poll();
            aa.y("Sending hit to store  " + locald1);
            this.sG.a(locald1.cv(), locald1.cw(), locald1.getPath(), locald1.cx());
            continue;
          }
          if (!this.sJ) {
            continue;
          }
        }
      }
      finally {}
      cr();
      continue;
      if (!this.sY.isEmpty())
      {
        d locald2 = (d)this.sY.peek();
        aa.y("Sending hit to service   " + locald2);
        if (!this.sX.isDryRunEnabled()) {
          this.sV.a(locald2.cv(), locald2.cw(), locald2.getPath(), locald2.cx());
        }
        for (;;)
        {
          this.sY.poll();
          break;
          aa.y("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.sT = this.tg.currentTimeMillis();
      continue;
      aa.y("Need to reconnect");
      if (!this.sY.isEmpty()) {
        ct();
      }
    }
  }
  
  private void cr()
  {
    this.sG.bW();
    this.sJ = false;
  }
  
  private void cs()
  {
    for (;;)
    {
      try
      {
        a locala1 = this.sU;
        a locala2 = a.tm;
        if (locala1 == locala2) {
          return;
        }
        co();
        aa.y("falling back to local store");
        if (this.sW != null)
        {
          this.sG = this.sW;
          this.sU = a.tm;
          cq();
          continue;
        }
        localr = r.ci();
      }
      finally {}
      r localr;
      localr.a(this.mContext, this.sH);
      this.sG = localr.cl();
    }
  }
  
  private void ct()
  {
    for (;;)
    {
      try
      {
        if ((!this.tf) && (this.sV != null))
        {
          a locala1 = this.sU;
          a locala2 = a.tm;
          if (locala1 != locala2) {
            try
            {
              this.sZ += 1;
              a(this.tb);
              this.sU = a.tk;
              this.tb = new Timer("Failed Connect");
              this.tb.schedule(new c(null), 3000L);
              aa.y("connecting to Analytics service");
              this.sV.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              aa.z("security exception on connectToService");
              cs();
              continue;
            }
          }
        }
        aa.z("client not initialized.");
      }
      finally {}
      cs();
    }
  }
  
  private void cu()
  {
    this.ta = a(this.ta);
    this.ta = new Timer("Service Reconnect");
    this.ta.schedule(new e(null), 5000L);
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 340	com/google/android/gms/analytics/s$a:to	Lcom/google/android/gms/analytics/s$a;
    //   6: putfield 107	com/google/android/gms/analytics/s:sU	Lcom/google/android/gms/analytics/s$a;
    //   9: aload_0
    //   10: getfield 102	com/google/android/gms/analytics/s:sZ	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 193	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 342
    //   27: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 347
    //   37: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 317	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 349	com/google/android/gms/analytics/s:cu	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 193	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 342
    //   63: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 351
    //   73: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 317	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 134	com/google/android/gms/analytics/s:cs	()V
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
  
  public void b(Map<String, String> paramMap, long paramLong, String paramString, List<ef> paramList)
  {
    aa.y("putHit called");
    this.sY.add(new d(paramMap, paramLong, paramString, paramList));
    cq();
  }
  
  public void bR()
  {
    aa.y("clearHits called");
    this.sY.clear();
    switch (3.tj[this.sU.ordinal()])
    {
    default: 
      this.td = true;
      return;
    case 1: 
      this.sG.j(0L);
      this.td = false;
      return;
    }
    this.sV.bR();
    this.td = false;
  }
  
  public void bW()
  {
    switch (3.tj[this.sU.ordinal()])
    {
    default: 
      this.sJ = true;
    case 2: 
      return;
    }
    cr();
  }
  
  public void bY()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.tf;
        if (bool) {
          return;
        }
        aa.y("setForceLocalDispatch called.");
        this.tf = true;
        switch (3.tj[this.sU.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          be();
          break;
        case 3: 
          this.te = true;
        }
      }
      finally {}
    }
  }
  
  public void cp()
  {
    if (this.sV != null) {
      return;
    }
    this.sV = new c(this.mContext, this, this);
    ct();
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
    //   5: getfield 141	com/google/android/gms/analytics/s:tb	Ljava/util/Timer;
    //   8: invokespecial 139	com/google/android/gms/analytics/s:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 141	com/google/android/gms/analytics/s:tb	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 102	com/google/android/gms/analytics/s:sZ	I
    //   19: ldc_w 381
    //   22: invokestatic 213	com/google/android/gms/analytics/aa:y	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 123	com/google/android/gms/analytics/s$a:tl	Lcom/google/android/gms/analytics/s$a;
    //   29: putfield 107	com/google/android/gms/analytics/s:sU	Lcom/google/android/gms/analytics/s$a;
    //   32: aload_0
    //   33: getfield 372	com/google/android/gms/analytics/s:te	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 334	com/google/android/gms/analytics/s:be	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 372	com/google/android/gms/analytics/s:te	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 116	com/google/android/gms/analytics/s:cq	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 143	com/google/android/gms/analytics/s:tc	Ljava/util/Timer;
    //   61: invokespecial 139	com/google/android/gms/analytics/s:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 143	com/google/android/gms/analytics/s:tc	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 110	java/util/Timer
    //   71: dup
    //   72: ldc_w 383
    //   75: invokespecial 298	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 143	com/google/android/gms/analytics/s:tc	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 143	com/google/android/gms/analytics/s:tc	Ljava/util/Timer;
    //   85: new 21	com/google/android/gms/analytics/s$b
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 384	com/google/android/gms/analytics/s$b:<init>	(Lcom/google/android/gms/analytics/s;Lcom/google/android/gms/analytics/s$1;)V
    //   94: aload_0
    //   95: getfield 87	com/google/android/gms/analytics/s:th	J
    //   98: invokevirtual 307	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
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
        if (this.sU == a.tp)
        {
          aa.y("Disconnected from service");
          co();
          this.sU = a.tq;
          return;
        }
        aa.y("Unexpected disconnect.");
        this.sU = a.to;
        if (this.sZ < 2) {
          cu();
        } else {
          cs();
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
      if ((s.b(s.this) == s.a.tl) && (s.e(s.this).isEmpty()) && (s.f(s.this) + s.g(s.this) < s.h(s.this).currentTimeMillis()))
      {
        aa.y("Disconnecting due to inactivity");
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
      if (s.b(s.this) == s.a.tk) {
        s.c(s.this);
      }
    }
  }
  
  private static class d
  {
    private final Map<String, String> ts;
    private final long tt;
    private final String tu;
    private final List<ef> tv;
    
    public d(Map<String, String> paramMap, long paramLong, String paramString, List<ef> paramList)
    {
      this.ts = paramMap;
      this.tt = paramLong;
      this.tu = paramString;
      this.tv = paramList;
    }
    
    public Map<String, String> cv()
    {
      return this.ts;
    }
    
    public long cw()
    {
      return this.tt;
    }
    
    public List<ef> cx()
    {
      return this.tv;
    }
    
    public String getPath()
    {
      return this.tu;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.tu);
      if (this.ts != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.ts.entrySet().iterator();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */