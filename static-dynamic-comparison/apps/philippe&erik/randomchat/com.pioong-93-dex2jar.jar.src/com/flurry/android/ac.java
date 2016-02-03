package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class ac
  extends RelativeLayout
{
  private static String d = "FlurryAgent";
  private final Context J;
  private final FlurryAds am;
  private final String an;
  private final ViewGroup ao;
  private long ap;
  private final ScheduledExecutorService aq = Executors.newSingleThreadScheduledExecutor();
  private final Runnable ar = new g(this);
  private ScheduledFuture<?> as;
  
  public ac(FlurryAds paramFlurryAds, Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    super(paramContext);
    this.am = paramFlurryAds;
    this.J = paramContext;
    this.an = paramString;
    this.ao = paramViewGroup;
  }
  
  private void i()
  {
    try
    {
      j();
      this.ap = 0L;
      removeCallbacks(this.ar);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void j()
  {
    if (this.as != null)
    {
      new StringBuilder().append("cancel banner rotation for adSpace = ").append(this.an).append(" with fixed rate in milliseconds = ").append(this.ap).toString();
      this.as.cancel(true);
      this.as = null;
    }
  }
  
  private p k()
  {
    if (getChildCount() < 1) {
      return null;
    }
    Object localObject = getChildAt(0);
    try
    {
      localObject = (p)localObject;
      return (p)localObject;
    }
    catch (ClassCastException localClassCastException) {}
    return null;
  }
  
  public final void a(long paramLong)
  {
    try
    {
      if (this.ap != paramLong)
      {
        j();
        this.ap = paramLong;
        if ((this.as == null) && (0L != this.ap))
        {
          new StringBuilder().append("schedule banner rotation for adSpace = ").append(this.an).append(" with fixed rate in milliseconds = ").append(this.ap).toString();
          this.as = this.aq.scheduleAtFixedRate(new ay(this), this.ap, this.ap, TimeUnit.MILLISECONDS);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final ViewGroup h()
  {
    return this.ao;
  }
  
  public final void stop()
  {
    i();
    p localp = k();
    if (localp != null) {
      localp.stop();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */