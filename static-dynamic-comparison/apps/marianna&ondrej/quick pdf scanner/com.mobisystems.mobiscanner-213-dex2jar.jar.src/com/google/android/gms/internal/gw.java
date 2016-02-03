package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class gw
{
  private z Cc;
  private final Runnable De;
  private boolean TF = false;
  
  public gw(final gv paramgv)
  {
    this.De = new Runnable()
    {
      private final WeakReference<gv> TG = new WeakReference(paramgv);
      
      public void run()
      {
        gw.a(gw.this, false);
        gv localgv = (gv)this.TG.get();
        if (localgv != null) {
          localgv.d(gw.a(gw.this));
        }
      }
    };
  }
  
  public void b(z paramz, long paramLong)
  {
    if (this.TF)
    {
      ce.D("An ad refresh is already scheduled.");
      return;
    }
    ce.aa("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    this.Cc = paramz;
    this.TF = true;
    cb.Fw.postDelayed(this.De, paramLong);
  }
  
  public void cancel()
  {
    cb.Fw.removeCallbacks(this.De);
  }
  
  public void f(z paramz)
  {
    b(paramz, 60000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */