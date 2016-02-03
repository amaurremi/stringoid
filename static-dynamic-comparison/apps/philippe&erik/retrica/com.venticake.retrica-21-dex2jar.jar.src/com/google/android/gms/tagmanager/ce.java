package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ce
  implements dv
{
  private final String a;
  private final Context b;
  private final ScheduledExecutorService c;
  private final cf d;
  private ScheduledFuture<?> e;
  private boolean f;
  private dz g;
  private String h;
  private bg<c.j> i;
  
  public ce(Context paramContext, String paramString, dz paramdz)
  {
    this(paramContext, paramString, paramdz, null, null);
  }
  
  ce(Context paramContext, String paramString, dz paramdz, cg paramcg, cf paramcf)
  {
    this.g = paramdz;
    this.b = paramContext;
    this.a = paramString;
    paramContext = paramcg;
    if (paramcg == null) {
      paramContext = new cg()
      {
        public ScheduledExecutorService a()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.c = paramContext.a();
    if (paramcf == null)
    {
      this.d = new cf()
      {
        public cd a(dz paramAnonymousdz)
        {
          return new cd(ce.a(ce.this), ce.b(ce.this), paramAnonymousdz);
        }
      };
      return;
    }
    this.d = paramcf;
  }
  
  private void a()
  {
    try
    {
      if (this.f) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  private cd b(String paramString)
  {
    cd localcd = this.d.a(this.g);
    localcd.a(this.i);
    localcd.a(this.h);
    localcd.b(paramString);
    return localcd;
  }
  
  public void a(long paramLong, String paramString)
  {
    try
    {
      as.e("loadAfterDelay: containerId=" + this.a + " delay=" + paramLong);
      a();
      if (this.i == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.e != null) {
      this.e.cancel(false);
    }
    this.e = this.c.schedule(b(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void a(bg<c.j> parambg)
  {
    try
    {
      a();
      this.i = parambg;
      return;
    }
    finally
    {
      parambg = finally;
      throw parambg;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      a();
      this.h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void release()
  {
    try
    {
      a();
      if (this.e != null) {
        this.e.cancel(false);
      }
      this.c.shutdown();
      this.f = true;
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */