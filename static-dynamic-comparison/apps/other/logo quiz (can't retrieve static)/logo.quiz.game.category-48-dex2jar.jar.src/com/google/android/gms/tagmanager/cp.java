package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp
  implements o.e
{
  private final String anR;
  private String aon;
  private bg<c.j> aqi;
  private r aqj;
  private final ScheduledExecutorService aql;
  private final a aqm;
  private ScheduledFuture<?> aqn;
  private boolean mClosed;
  private final Context mContext;
  
  public cp(Context paramContext, String paramString, r paramr)
  {
    this(paramContext, paramString, paramr, null, null);
  }
  
  cp(Context paramContext, String paramString, r paramr, b paramb, a parama)
  {
    this.aqj = paramr;
    this.mContext = paramContext;
    this.anR = paramString;
    paramContext = paramb;
    if (paramb == null) {
      paramContext = new b()
      {
        public ScheduledExecutorService oO()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.aql = paramContext.oO();
    if (parama == null)
    {
      this.aqm = new a()
      {
        public co a(r paramAnonymousr)
        {
          return new co(cp.a(cp.this), cp.b(cp.this), paramAnonymousr);
        }
      };
      return;
    }
    this.aqm = parama;
  }
  
  private co cH(String paramString)
  {
    co localco = this.aqm.a(this.aqj);
    localco.a(this.aqi);
    localco.cr(this.aon);
    localco.cG(paramString);
    return localco;
  }
  
  private void oN()
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
      oN();
      this.aqi = parambg;
      return;
    }
    finally
    {
      parambg = finally;
      throw parambg;
    }
  }
  
  public void cr(String paramString)
  {
    try
    {
      oN();
      this.aon = paramString;
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
      bh.V("loadAfterDelay: containerId=" + this.anR + " delay=" + paramLong);
      oN();
      if (this.aqi == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.aqn != null) {
      this.aqn.cancel(false);
    }
    this.aqn = this.aql.schedule(cH(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void release()
  {
    try
    {
      oN();
      if (this.aqn != null) {
        this.aqn.cancel(false);
      }
      this.aql.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  static abstract interface a
  {
    public abstract co a(r paramr);
  }
  
  static abstract interface b
  {
    public abstract ScheduledExecutorService oO();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */