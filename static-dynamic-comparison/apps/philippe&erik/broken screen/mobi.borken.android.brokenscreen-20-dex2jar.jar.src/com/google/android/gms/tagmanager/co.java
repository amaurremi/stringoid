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
  private String aeM;
  private final String aeq;
  private bg<c.j> agK;
  private r agL;
  private final ScheduledExecutorService agN;
  private final a agO;
  private ScheduledFuture<?> agP;
  private boolean mClosed;
  private final Context mContext;
  
  public co(Context paramContext, String paramString, r paramr)
  {
    this(paramContext, paramString, paramr, null, null);
  }
  
  co(Context paramContext, String paramString, r paramr, b paramb, a parama)
  {
    this.agL = paramr;
    this.mContext = paramContext;
    this.aeq = paramString;
    paramContext = paramb;
    if (paramb == null) {
      paramContext = new b()
      {
        public ScheduledExecutorService mf()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.agN = paramContext.mf();
    if (parama == null)
    {
      this.agO = new a()
      {
        public cn a(r paramAnonymousr)
        {
          return new cn(co.a(co.this), co.b(co.this), paramAnonymousr);
        }
      };
      return;
    }
    this.agO = parama;
  }
  
  private cn cc(String paramString)
  {
    cn localcn = this.agO.a(this.agL);
    localcn.a(this.agK);
    localcn.bM(this.aeM);
    localcn.cb(paramString);
    return localcn;
  }
  
  private void me()
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
      me();
      this.agK = parambg;
      return;
    }
    finally
    {
      parambg = finally;
      throw parambg;
    }
  }
  
  public void bM(String paramString)
  {
    try
    {
      me();
      this.aeM = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void e(long paramLong, String paramString)
  {
    try
    {
      bh.C("loadAfterDelay: containerId=" + this.aeq + " delay=" + paramLong);
      me();
      if (this.agK == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.agP != null) {
      this.agP.cancel(false);
    }
    this.agP = this.agN.schedule(cc(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void release()
  {
    try
    {
      me();
      if (this.agP != null) {
        this.agP.cancel(false);
      }
      this.agN.shutdown();
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
    public abstract ScheduledExecutorService mf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */