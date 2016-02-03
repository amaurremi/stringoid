package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.ok.a;

class o
  extends BaseImplementation.AbstractPendingResult<ContainerHolder>
{
  private final Looper IB;
  private final String anR;
  private long anW;
  private final TagManager aod;
  private final d aog;
  private final cg aoh;
  private final int aoi;
  private f aoj;
  private volatile n aok;
  private volatile boolean aol;
  private c.j aom;
  private String aon;
  private e aoo;
  private a aop;
  private final Context mContext;
  private final ju yD;
  
  o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, f paramf, e parame, ju paramju, cg paramcg) {}
  
  public o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new cq(paramContext, paramString), new cp(paramContext, paramString, paramr), jw.hA(), new bf(30, 900000L, 5000L, "refreshing", jw.hA()));
  }
  
  private void T(final boolean paramBoolean)
  {
    this.aoj.a(new b(null));
    this.aoo.a(new c(null));
    cr.c localc = this.aoj.fe(this.aoi);
    if (localc != null) {
      this.aok = new n(this.aod, this.IB, new Container(this.mContext, this.aod.getDataLayer(), this.anR, 0L, localc), this.aog);
    }
    this.aop = new a()
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
    if (nY())
    {
      this.aoo.e(0L, "");
      return;
    }
    this.aoj.oa();
  }
  
  private void a(c.j paramj)
  {
    try
    {
      if (this.aoj != null)
      {
        ok.a locala = new ok.a();
        locala.asg = this.anW;
        locala.gs = new c.f();
        locala.ash = paramj;
        this.aoj.b(locala);
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
        paramBoolean = this.aol;
        if (paramBoolean) {
          return;
        }
        if ((isReady()) && (this.aok == null)) {}
        this.aom = paramj;
        this.anW = paramLong;
        w(Math.max(0L, Math.min(43200000L, this.anW + 43200000L - this.yD.currentTimeMillis())));
        paramj = new Container(this.mContext, this.aod.getDataLayer(), this.anR, paramLong, paramj);
        if (this.aok == null)
        {
          this.aok = new n(this.aod, this.IB, paramj, this.aog);
          if ((!isReady()) && (this.aop.b(paramj))) {
            b(this.aok);
          }
        }
        else
        {
          this.aok.a(paramj);
        }
      }
      finally {}
    }
  }
  
  private boolean nY()
  {
    ce localce = ce.oH();
    return ((localce.oI() == ce.a.apX) || (localce.oI() == ce.a.apY)) && (this.anR.equals(localce.getContainerId()));
  }
  
  /* Error */
  private void w(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/android/gms/tagmanager/o:aoo	Lcom/google/android/gms/tagmanager/o$e;
    //   6: ifnonnull +12 -> 18
    //   9: ldc_w 290
    //   12: invokestatic 295	com/google/android/gms/tagmanager/bh:W	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 83	com/google/android/gms/tagmanager/o:aoo	Lcom/google/android/gms/tagmanager/o$e;
    //   22: lload_1
    //   23: aload_0
    //   24: getfield 95	com/google/android/gms/tagmanager/o:aom	Lcom/google/android/gms/internal/c$j;
    //   27: getfield 298	com/google/android/gms/internal/c$j:gt	Ljava/lang/String;
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
  
  protected ContainerHolder aE(Status paramStatus)
  {
    if (this.aok != null) {
      return this.aok;
    }
    if (paramStatus == Status.Jr) {
      bh.T("timer expired: setting result to failure");
    }
    return new n(paramStatus);
  }
  
  void co(String paramString)
  {
    try
    {
      this.aon = paramString;
      if (this.aoo != null) {
        this.aoo.cr(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String nS()
  {
    try
    {
      String str = this.aon;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void nV()
  {
    Object localObject = this.aoj.fe(this.aoi);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.aod.getDataLayer(), this.anR, 0L, (cr.c)localObject);
      b(new n(this.aod, this.IB, (Container)localObject, new n.a()
      {
        public void co(String paramAnonymousString)
        {
          o.this.co(paramAnonymousString);
        }
        
        public String nS()
        {
          return o.this.nS();
        }
        
        public void nU()
        {
          bh.W("Refresh ignored: container loaded as default only.");
        }
      }));
    }
    for (;;)
    {
      this.aoo = null;
      this.aoj = null;
      return;
      bh.T("Default was requested, but no default container was found");
      b(aE(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void nW()
  {
    T(false);
  }
  
  public void nX()
  {
    T(true);
  }
  
  static abstract interface a
  {
    public abstract boolean b(Container paramContainer);
  }
  
  private class b
    implements bg<ok.a>
  {
    private b() {}
    
    public void a(ok.a parama)
    {
      c.j localj;
      if (parama.ash != null) {
        localj = parama.ash;
      }
      for (;;)
      {
        o.a(o.this, localj, parama.asg, true);
        return;
        c.f localf = parama.gs;
        localj = new c.j();
        localj.gs = localf;
        localj.gr = null;
        localj.gt = localf.version;
      }
    }
    
    public void a(bg.a parama)
    {
      if (!o.b(o.this)) {
        o.a(o.this, 0L);
      }
    }
    
    public void nZ() {}
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
        o.this.b(o.this.aE(Status.Jr));
      }
    }
    
    public void b(c.j paramj)
    {
      synchronized (o.this)
      {
        if (paramj.gs == null)
        {
          if (o.c(o.this).gs == null)
          {
            bh.T("Current resource is null; network resource is also null");
            o.a(o.this, 3600000L);
            return;
          }
          paramj.gs = o.c(o.this).gs;
        }
        o.a(o.this, paramj, o.a(o.this).currentTimeMillis(), false);
        bh.V("setting refresh time to current time: " + o.d(o.this));
        if (!o.e(o.this)) {
          o.a(o.this, paramj);
        }
        return;
      }
    }
    
    public void nZ() {}
  }
  
  private class d
    implements n.a
  {
    private d() {}
    
    public void co(String paramString)
    {
      o.this.co(paramString);
    }
    
    public String nS()
    {
      return o.this.nS();
    }
    
    public void nU()
    {
      if (o.g(o.this).eK()) {
        o.a(o.this, 0L);
      }
    }
  }
  
  static abstract interface e
    extends Releasable
  {
    public abstract void a(bg<c.j> parambg);
    
    public abstract void cr(String paramString);
    
    public abstract void e(long paramLong, String paramString);
  }
  
  static abstract interface f
    extends Releasable
  {
    public abstract void a(bg<ok.a> parambg);
    
    public abstract void b(ok.a parama);
    
    public abstract cr.c fe(int paramInt);
    
    public abstract void oa();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */