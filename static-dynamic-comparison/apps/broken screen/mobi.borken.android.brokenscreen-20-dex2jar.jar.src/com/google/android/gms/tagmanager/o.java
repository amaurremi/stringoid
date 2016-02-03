package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.lf.a;

class o
  extends a.a<ContainerHolder>
{
  private final Looper DC;
  private final TagManager aeC;
  private final d aeF;
  private final cf aeG;
  private final int aeH;
  private f aeI;
  private volatile n aeJ;
  private volatile boolean aeK;
  private c.j aeL;
  private String aeM;
  private e aeN;
  private a aeO;
  private final ik aec;
  private final String aeq;
  private long aev;
  private final Context mContext;
  
  o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, f paramf, e parame, ik paramik, cf paramcf) {}
  
  public o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new cp(paramContext, paramString), new co(paramContext, paramString, paramr), im.fW(), new bf(30, 900000L, 5000L, "refreshing", im.fW()));
  }
  
  private void H(final boolean paramBoolean)
  {
    this.aeI.a(new b(null));
    this.aeN.a(new c(null));
    cq.c localc = this.aeI.dn(this.aeH);
    if (localc != null) {
      this.aeJ = new n(this.aeC, this.DC, new Container(this.mContext, this.aeC.getDataLayer(), this.aeq, 0L, localc), this.aeF);
    }
    this.aeO = new a()
    {
      public boolean b(Container paramAnonymousContainer)
      {
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + 43200000L < o.a(o.this).currentTimeMillis()) {}
        }
        while (!paramAnonymousContainer.isDefault())
        {
          return true;
          return false;
        }
        return false;
      }
    };
    if (lp())
    {
      this.aeN.e(0L, "");
      return;
    }
    this.aeI.lr();
  }
  
  private void a(c.j paramj)
  {
    try
    {
      if (this.aeI != null)
      {
        lf.a locala = new lf.a();
        locala.aiD = this.aev;
        locala.fK = new c.f();
        locala.aiE = paramj;
        this.aeI.b(locala);
      }
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  private void a(c.j paramj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.aeK;
        if (paramBoolean) {
          return;
        }
        if ((isReady()) && (this.aeJ == null)) {}
        this.aeL = paramj;
        this.aev = paramLong;
        w(Math.max(0L, Math.min(43200000L, this.aev + 43200000L - this.aec.currentTimeMillis())));
        paramj = new Container(this.mContext, this.aeC.getDataLayer(), this.aeq, paramLong, paramj);
        if (this.aeJ == null)
        {
          this.aeJ = new n(this.aeC, this.DC, paramj, this.aeF);
          if ((!isReady()) && (this.aeO.b(paramj))) {
            b(this.aeJ);
          }
        }
        else
        {
          this.aeJ.a(paramj);
        }
      }
      finally {}
    }
  }
  
  private boolean lp()
  {
    cd localcd = cd.lY();
    return ((localcd.lZ() == cd.a.agz) || (localcd.lZ() == cd.a.agA)) && (this.aeq.equals(localcd.getContainerId()));
  }
  
  /* Error */
  private void w(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/android/gms/tagmanager/o:aeN	Lcom/google/android/gms/tagmanager/o$e;
    //   6: ifnonnull +12 -> 18
    //   9: ldc_w 290
    //   12: invokestatic 295	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 83	com/google/android/gms/tagmanager/o:aeN	Lcom/google/android/gms/tagmanager/o$e;
    //   22: lload_1
    //   23: aload_0
    //   24: getfield 95	com/google/android/gms/tagmanager/o:aeL	Lcom/google/android/gms/internal/c$j;
    //   27: getfield 298	com/google/android/gms/internal/c$j:fL	Ljava/lang/String;
    //   30: invokeinterface 188 4 0
    //   35: goto -20 -> 15
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	o
    //   0	43	1	paramLong	long
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	38	finally
    //   18	35	38	finally
  }
  
  protected ContainerHolder ap(Status paramStatus)
  {
    if (this.aeJ != null) {
      return this.aeJ;
    }
    if (paramStatus == Status.En) {
      bh.A("timer expired: setting result to failure");
    }
    return new n(paramStatus);
  }
  
  void bJ(String paramString)
  {
    try
    {
      this.aeM = paramString;
      if (this.aeN != null) {
        this.aeN.bM(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String lj()
  {
    try
    {
      String str = this.aeM;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void lm()
  {
    Object localObject = this.aeI.dn(this.aeH);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.aeC.getDataLayer(), this.aeq, 0L, (cq.c)localObject);
      b(new n(this.aeC, this.DC, (Container)localObject, new n.a()
      {
        public void bJ(String paramAnonymousString)
        {
          o.this.bJ(paramAnonymousString);
        }
        
        public String lj()
        {
          return o.this.lj();
        }
        
        public void ll()
        {
          bh.D("Refresh ignored: container loaded as default only.");
        }
      }));
    }
    for (;;)
    {
      this.aeN = null;
      this.aeI = null;
      return;
      bh.A("Default was requested, but no default container was found");
      b(ap(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void ln()
  {
    H(false);
  }
  
  public void lo()
  {
    H(true);
  }
  
  static abstract interface a
  {
    public abstract boolean b(Container paramContainer);
  }
  
  private class b
    implements bg<lf.a>
  {
    private b() {}
    
    public void a(lf.a parama)
    {
      c.j localj;
      if (parama.aiE != null) {
        localj = parama.aiE;
      }
      for (;;)
      {
        o.a(o.this, localj, parama.aiD, true);
        return;
        c.f localf = parama.fK;
        localj = new c.j();
        localj.fK = localf;
        localj.fJ = null;
        localj.fL = localf.fg;
      }
    }
    
    public void a(bg.a parama)
    {
      if (!o.b(o.this)) {
        o.a(o.this, 0L);
      }
    }
    
    public void lq() {}
  }
  
  private class c
    implements bg<c.j>
  {
    private c() {}
    
    public void a(bg.a parama)
    {
      if (o.f(o.this) != null) {
        o.this.b(o.f(o.this));
      }
      for (;;)
      {
        o.a(o.this, 3600000L);
        return;
        o.this.b(o.this.ap(Status.En));
      }
    }
    
    public void b(c.j paramj)
    {
      synchronized (o.this)
      {
        if (paramj.fK == null)
        {
          if (o.c(o.this).fK == null)
          {
            bh.A("Current resource is null; network resource is also null");
            o.a(o.this, 3600000L);
            return;
          }
          paramj.fK = o.c(o.this).fK;
        }
        o.a(o.this, paramj, o.a(o.this).currentTimeMillis(), false);
        bh.C("setting refresh time to current time: " + o.d(o.this));
        if (!o.e(o.this)) {
          o.a(o.this, paramj);
        }
        return;
      }
    }
    
    public void lq() {}
  }
  
  private class d
    implements n.a
  {
    private d() {}
    
    public void bJ(String paramString)
    {
      o.this.bJ(paramString);
    }
    
    public String lj()
    {
      return o.this.lj();
    }
    
    public void ll()
    {
      if (o.g(o.this).dj()) {
        o.a(o.this, 0L);
      }
    }
  }
  
  static abstract interface e
    extends Releasable
  {
    public abstract void a(bg<c.j> parambg);
    
    public abstract void bM(String paramString);
    
    public abstract void e(long paramLong, String paramString);
  }
  
  static abstract interface f
    extends Releasable
  {
    public abstract void a(bg<lf.a> parambg);
    
    public abstract void b(lf.a parama);
    
    public abstract cq.c dn(int paramInt);
    
    public abstract void lr();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */