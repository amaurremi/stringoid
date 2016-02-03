package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class x
{
  private final a kV;
  private final Runnable kW;
  private ah kX;
  private boolean kY = false;
  private boolean kZ = false;
  private long la = 0L;
  
  public x(v paramv)
  {
    this(paramv, new a(dv.rp));
  }
  
  x(final v paramv, a parama)
  {
    this.kV = parama;
    this.kW = new Runnable()
    {
      private final WeakReference<v> lb = new WeakReference(paramv);
      
      public void run()
      {
        x.a(x.this, false);
        v localv = (v)this.lb.get();
        if (localv != null) {
          localv.b(x.a(x.this));
        }
      }
    };
  }
  
  public void a(ah paramah, long paramLong)
  {
    if (this.kY) {
      dw.z("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      this.kX = paramah;
      this.kY = true;
      this.la = paramLong;
    } while (this.kZ);
    dw.x("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    this.kV.postDelayed(this.kW, paramLong);
  }
  
  public void cancel()
  {
    this.kY = false;
    this.kV.removeCallbacks(this.kW);
  }
  
  public void d(ah paramah)
  {
    a(paramah, 60000L);
  }
  
  public void pause()
  {
    this.kZ = true;
    if (this.kY) {
      this.kV.removeCallbacks(this.kW);
    }
  }
  
  public void resume()
  {
    this.kZ = false;
    if (this.kY)
    {
      this.kY = false;
      a(this.kX, this.la);
    }
  }
  
  public static class a
  {
    private final Handler mHandler;
    
    public a(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return this.mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      this.mHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */