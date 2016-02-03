package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.fe;
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
  private d tR;
  private final f tS;
  private boolean tU;
  private volatile long ue;
  private volatile a uf;
  private volatile b ug;
  private d uh;
  private final GoogleAnalytics ui;
  private final Queue<d> uj = new ConcurrentLinkedQueue();
  private volatile int uk;
  private volatile Timer ul;
  private volatile Timer um;
  private volatile Timer un;
  private boolean uo;
  private boolean up;
  private boolean uq;
  private i ur;
  private long us = 300000L;
  
  s(Context paramContext, f paramf)
  {
    this(paramContext, paramf, null, GoogleAnalytics.getInstance(paramContext));
  }
  
  s(Context paramContext, f paramf, d paramd, GoogleAnalytics paramGoogleAnalytics)
  {
    this.uh = paramd;
    this.mContext = paramContext;
    this.tS = paramf;
    this.ui = paramGoogleAnalytics;
    this.ur = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.uk = 0;
    this.uf = a.uB;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void bn()
  {
    try
    {
      if ((this.ug != null) && (this.uf == a.uw))
      {
        this.uf = a.uA;
        this.ug.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void cF()
  {
    this.ul = a(this.ul);
    this.um = a(this.um);
    this.un = a(this.un);
  }
  
  private void cH()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.tS.getThread()))
        {
          this.tS.co().add(new Runnable()
          {
            public void run()
            {
              s.a(s.this);
            }
          });
          return;
        }
        if (this.uo) {
          cg();
        }
        switch (3.uu[this.uf.ordinal()])
        {
        case 1: 
          if (!this.uj.isEmpty())
          {
            d locald1 = (d)this.uj.poll();
            aa.C("Sending hit to store  " + locald1);
            this.tR.a(locald1.cM(), locald1.cN(), locald1.getPath(), locald1.cO());
            continue;
          }
          if (!this.tU) {
            continue;
          }
        }
      }
      finally {}
      cI();
      continue;
      if (!this.uj.isEmpty())
      {
        d locald2 = (d)this.uj.peek();
        aa.C("Sending hit to service   " + locald2);
        if (!this.ui.isDryRunEnabled()) {
          this.ug.a(locald2.cM(), locald2.cN(), locald2.getPath(), locald2.cO());
        }
        for (;;)
        {
          this.uj.poll();
          break;
          aa.C("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.ue = this.ur.currentTimeMillis();
      continue;
      aa.C("Need to reconnect");
      if (!this.uj.isEmpty()) {
        cK();
      }
    }
  }
  
  private void cI()
  {
    this.tR.cl();
    this.tU = false;
  }
  
  private void cJ()
  {
    for (;;)
    {
      try
      {
        a locala1 = this.uf;
        a locala2 = a.ux;
        if (locala1 == locala2) {
          return;
        }
        cF();
        aa.C("falling back to local store");
        if (this.uh != null)
        {
          this.tR = this.uh;
          this.uf = a.ux;
          cH();
          continue;
        }
        localr = r.cz();
      }
      finally {}
      r localr;
      localr.a(this.mContext, this.tS);
      this.tR = localr.cC();
    }
  }
  
  private void cK()
  {
    for (;;)
    {
      try
      {
        if ((!this.uq) && (this.ug != null))
        {
          a locala1 = this.uf;
          a locala2 = a.ux;
          if (locala1 != locala2) {
            try
            {
              this.uk += 1;
              a(this.um);
              this.uf = a.uv;
              this.um = new Timer("Failed Connect");
              this.um.schedule(new c(null), 3000L);
              aa.C("connecting to Analytics service");
              this.ug.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              aa.D("security exception on connectToService");
              cJ();
              continue;
            }
          }
        }
        aa.D("client not initialized.");
      }
      finally {}
      cJ();
    }
  }
  
  private void cL()
  {
    this.ul = a(this.ul);
    this.ul = new Timer("Service Reconnect");
    this.ul.schedule(new e(null), 5000L);
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 340	com/google/android/gms/analytics/s$a:uz	Lcom/google/android/gms/analytics/s$a;
    //   6: putfield 107	com/google/android/gms/analytics/s:uf	Lcom/google/android/gms/analytics/s$a;
    //   9: aload_0
    //   10: getfield 102	com/google/android/gms/analytics/s:uk	I
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
    //   43: invokestatic 317	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 349	com/google/android/gms/analytics/s:cL	()V
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
    //   79: invokestatic 317	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 134	com/google/android/gms/analytics/s:cJ	()V
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
  
  public void b(Map<String, String> paramMap, long paramLong, String paramString, List<fe> paramList)
  {
    aa.C("putHit called");
    this.uj.add(new d(paramMap, paramLong, paramString, paramList));
    cH();
  }
  
  public void cG()
  {
    if (this.ug != null) {
      return;
    }
    this.ug = new c(this.mContext, this, this);
    cK();
  }
  
  public void cg()
  {
    aa.C("clearHits called");
    this.uj.clear();
    switch (3.uu[this.uf.ordinal()])
    {
    default: 
      this.uo = true;
      return;
    case 1: 
      this.tR.l(0L);
      this.uo = false;
      return;
    }
    this.ug.cg();
    this.uo = false;
  }
  
  public void cl()
  {
    switch (3.uu[this.uf.ordinal()])
    {
    default: 
      this.tU = true;
    case 2: 
      return;
    }
    cI();
  }
  
  public void cn()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.uq;
        if (bool) {
          return;
        }
        aa.C("setForceLocalDispatch called.");
        this.uq = true;
        switch (3.uu[this.uf.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          bn();
          break;
        case 3: 
          this.up = true;
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
    //   5: getfield 141	com/google/android/gms/analytics/s:um	Ljava/util/Timer;
    //   8: invokespecial 139	com/google/android/gms/analytics/s:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 141	com/google/android/gms/analytics/s:um	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 102	com/google/android/gms/analytics/s:uk	I
    //   19: ldc_w 382
    //   22: invokestatic 213	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 123	com/google/android/gms/analytics/s$a:uw	Lcom/google/android/gms/analytics/s$a;
    //   29: putfield 107	com/google/android/gms/analytics/s:uf	Lcom/google/android/gms/analytics/s$a;
    //   32: aload_0
    //   33: getfield 379	com/google/android/gms/analytics/s:up	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 334	com/google/android/gms/analytics/s:bn	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 379	com/google/android/gms/analytics/s:up	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 116	com/google/android/gms/analytics/s:cH	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 143	com/google/android/gms/analytics/s:un	Ljava/util/Timer;
    //   61: invokespecial 139	com/google/android/gms/analytics/s:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 143	com/google/android/gms/analytics/s:un	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 110	java/util/Timer
    //   71: dup
    //   72: ldc_w 384
    //   75: invokespecial 298	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 143	com/google/android/gms/analytics/s:un	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 143	com/google/android/gms/analytics/s:un	Ljava/util/Timer;
    //   85: new 21	com/google/android/gms/analytics/s$b
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 385	com/google/android/gms/analytics/s$b:<init>	(Lcom/google/android/gms/analytics/s;Lcom/google/android/gms/analytics/s$1;)V
    //   94: aload_0
    //   95: getfield 87	com/google/android/gms/analytics/s:us	J
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
        if (this.uf == a.uA)
        {
          aa.C("Disconnected from service");
          cF();
          this.uf = a.uB;
          return;
        }
        aa.C("Unexpected disconnect.");
        this.uf = a.uz;
        if (this.uk < 2) {
          cL();
        } else {
          cJ();
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
      if ((s.b(s.this) == s.a.uw) && (s.e(s.this).isEmpty()) && (s.f(s.this) + s.g(s.this) < s.h(s.this).currentTimeMillis()))
      {
        aa.C("Disconnecting due to inactivity");
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
      if (s.b(s.this) == s.a.uv) {
        s.c(s.this);
      }
    }
  }
  
  private static class d
  {
    private final Map<String, String> uD;
    private final long uE;
    private final String uF;
    private final List<fe> uG;
    
    public d(Map<String, String> paramMap, long paramLong, String paramString, List<fe> paramList)
    {
      this.uD = paramMap;
      this.uE = paramLong;
      this.uF = paramString;
      this.uG = paramList;
    }
    
    public Map<String, String> cM()
    {
      return this.uD;
    }
    
    public long cN()
    {
      return this.uE;
    }
    
    public List<fe> cO()
    {
      return this.uG;
    }
    
    public String getPath()
    {
      return this.uF;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.uF);
      if (this.uD != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.uD.entrySet().iterator();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */