package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class s
{
  private final Runnable ep;
  private v eq;
  private boolean er = false;
  
  public s(final r paramr)
  {
    this.ep = new Runnable()
    {
      private final WeakReference<r> es = new WeakReference(paramr);
      
      public void run()
      {
        s.a(s.this, false);
        r localr = (r)this.es.get();
        if (localr != null) {
          localr.b(s.a(s.this));
        }
      }
    };
  }
  
  public void a(v paramv, long paramLong)
  {
    if (this.er)
    {
      ct.v("An ad refresh is already scheduled.");
      return;
    }
    ct.t("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    this.eq = paramv;
    this.er = true;
    cs.iI.postDelayed(this.ep, paramLong);
  }
  
  public void cancel()
  {
    cs.iI.removeCallbacks(this.ep);
  }
  
  public void d(v paramv)
  {
    a(paramv, 60000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */