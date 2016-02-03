package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import com.google.android.gms.internal.le.a;

class dq
  extends a.a<ContainerHolder>
{
  private final ij a;
  private final du b;
  private final Looper c;
  private final bv d;
  private final int e;
  private final Context f;
  private final TagManager g;
  private final String h;
  private dw i;
  private volatile n j;
  private volatile boolean k;
  private c.j l;
  private long m;
  private String n;
  private dv o;
  private dr p;
  
  dq(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, dw paramdw, dv paramdv, ij paramij, bv parambv) {}
  
  public dq(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, dz paramdz)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new ch(paramContext, paramString), new ce(paramContext, paramString, paramdz), il.gb(), new ar(30, 900000L, 5000L, "refreshing", il.gb()));
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/google/android/gms/tagmanager/dq:o	Lcom/google/android/gms/tagmanager/dv;
    //   6: ifnonnull +11 -> 17
    //   9: ldc -124
    //   11: invokestatic 136	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 65	com/google/android/gms/tagmanager/dq:o	Lcom/google/android/gms/tagmanager/dv;
    //   21: lload_1
    //   22: aload_0
    //   23: getfield 79	com/google/android/gms/tagmanager/dq:l	Lcom/google/android/gms/internal/c$j;
    //   26: getfield 139	com/google/android/gms/internal/c$j:fL	Ljava/lang/String;
    //   29: invokeinterface 144 4 0
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	dq
    //   0	42	1	paramLong	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   17	34	37	finally
  }
  
  private void a(c.j paramj)
  {
    try
    {
      if (this.i != null)
      {
        le.a locala = new le.a();
        locala.aiG = this.m;
        locala.fK = new c.f();
        locala.aiH = paramj;
        this.i.a(locala);
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
        paramBoolean = this.k;
        if (paramBoolean) {
          return;
        }
        if ((isReady()) && (this.j == null)) {}
        this.l = paramj;
        this.m = paramLong;
        a(Math.max(0L, Math.min(43200000L, this.m + 43200000L - this.a.currentTimeMillis())));
        paramj = new Container(this.f, this.g.getDataLayer(), this.h, paramLong, paramj);
        if (this.j == null)
        {
          this.j = new n(this.g, this.c, paramj, this.b);
          if ((!isReady()) && (this.p.a(paramj))) {
            b(this.j);
          }
        }
        else
        {
          this.j.a(paramj);
        }
      }
      finally {}
    }
  }
  
  private void a(final boolean paramBoolean)
  {
    this.i.a(new ds(this, null));
    this.o.a(new dt(this, null));
    cq.c localc = this.i.a(this.e);
    if (localc != null) {
      this.j = new n(this.g, this.c, new Container(this.f, this.g.getDataLayer(), this.h, 0L, localc), this.b);
    }
    this.p = new dr()
    {
      public boolean a(Container paramAnonymousContainer)
      {
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + 43200000L < dq.a(dq.this).currentTimeMillis()) {}
        }
        while (!paramAnonymousContainer.isDefault())
        {
          return true;
          return false;
        }
        return false;
      }
    };
    if (e())
    {
      this.o.a(0L, "");
      return;
    }
    this.i.a();
  }
  
  private boolean e()
  {
    br localbr = br.a();
    return ((localbr.b() == bs.b) || (localbr.b() == bs.c)) && (this.h.equals(localbr.d()));
  }
  
  protected ContainerHolder a(Status paramStatus)
  {
    if (this.j != null) {
      return this.j;
    }
    if (paramStatus == Status.Eq) {
      as.a("timer expired: setting result to failure");
    }
    return new n(paramStatus);
  }
  
  public void a()
  {
    Object localObject = this.i.a(this.e);
    if (localObject != null)
    {
      localObject = new Container(this.f, this.g.getDataLayer(), this.h, 0L, (cq.c)localObject);
      b(new n(this.g, this.c, (Container)localObject, new n.a()
      {
        public void bJ(String paramAnonymousString)
        {
          dq.this.a(paramAnonymousString);
        }
        
        public String lo()
        {
          return dq.this.d();
        }
        
        public void lq()
        {
          as.b("Refresh ignored: container loaded as default only.");
        }
      }));
    }
    for (;;)
    {
      this.o = null;
      this.i = null;
      return;
      as.a("Default was requested, but no default container was found");
      b(a(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  void a(String paramString)
  {
    try
    {
      this.n = paramString;
      if (this.o != null) {
        this.o.a(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void c()
  {
    a(true);
  }
  
  String d()
  {
    try
    {
      String str = this.n;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */