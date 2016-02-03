package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co
  implements o.e
{
  private final String WJ;
  private String Xg;
  private bg<c.j> Zf;
  private r Zg;
  private final ScheduledExecutorService Zi;
  private final a Zj;
  private ScheduledFuture<?> Zk;
  private boolean mClosed;
  private final Context mContext;
  
  public co(Context paramContext, String paramString, r paramr)
  {
    this(paramContext, paramString, paramr, null, null);
  }
  
  co(Context paramContext, String paramString, r paramr, b paramb, a parama)
  {
    this.Zg = paramr;
    this.mContext = paramContext;
    this.WJ = paramString;
    paramContext = paramb;
    if (paramb == null) {
      paramContext = new b()
      {
        public ScheduledExecutorService la()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.Zi = paramContext.la();
    if (parama == null)
    {
      this.Zj = new a()
      {
        public cn a(r paramAnonymousr)
        {
          return new cn(co.a(co.this), co.b(co.this), paramAnonymousr);
        }
      };
      return;
    }
    this.Zj = parama;
  }
  
  private cn bK(String paramString)
  {
    cn localcn = this.Zj.a(this.Zg);
    localcn.a(this.Zf);
    localcn.bu(this.Xg);
    localcn.bJ(paramString);
    return localcn;
  }
  
  private void kZ()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  public void a(bg<c.j> parambg)
  {
    try
    {
      kZ();
      this.Zf = parambg;
      return;
    }
    finally
    {
      parambg = finally;
      throw parambg;
    }
  }
  
  public void bu(String paramString)
  {
    try
    {
      kZ();
      this.Xg = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(long paramLong, String paramString)
  {
    try
    {
      bh.y("loadAfterDelay: containerId=" + this.WJ + " delay=" + paramLong);
      kZ();
      if (this.Zf == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.Zk != null) {
      this.Zk.cancel(false);
    }
    this.Zk = this.Zi.schedule(bK(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void release()
  {
    try
    {
      kZ();
      if (this.Zk != null) {
        this.Zk.cancel(false);
      }
      this.Zi.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  static abstract interface a
  {
    public abstract cn a(r paramr);
  }
  
  static abstract interface b
  {
    public abstract ScheduledExecutorService la();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */