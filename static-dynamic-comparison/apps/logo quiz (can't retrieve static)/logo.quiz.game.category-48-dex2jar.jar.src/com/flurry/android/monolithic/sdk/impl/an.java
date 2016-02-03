package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class an
  extends RelativeLayout
{
  private static final String a = an.class.getSimpleName();
  private final FlurryAdModule b;
  private final String c;
  private final ViewGroup d;
  private long e;
  private final ScheduledExecutorService f;
  private final Runnable g = new ap(this, null);
  private ScheduledFuture<?> h;
  
  public an(FlurryAdModule paramFlurryAdModule, Context paramContext, String paramString, ViewGroup paramViewGroup, ScheduledExecutorService paramScheduledExecutorService)
  {
    super(paramContext);
    this.b = paramFlurryAdModule;
    this.c = paramString;
    this.d = paramViewGroup;
    this.f = paramScheduledExecutorService;
  }
  
  private boolean c()
  {
    if ((this.f != null) && (this.h == null) && (0L != getRotationRateInMilliseconds()))
    {
      ja.a(3, a, "schedule banner rotation for adSpace = " + getAdSpace() + " with fixed rate in milliseconds = " + getRotationRateInMilliseconds());
      this.h = this.f.scheduleAtFixedRate(new ao(this), getRotationRateInMilliseconds(), getRotationRateInMilliseconds(), TimeUnit.MILLISECONDS);
    }
    return this.h != null;
  }
  
  private void d()
  {
    if (this.h != null)
    {
      ja.a(3, a, "cancel banner rotation for adSpace = " + getAdSpace() + " with fixed rate in milliseconds = " + getRotationRateInMilliseconds());
      this.h.cancel(true);
      this.h = null;
    }
  }
  
  private boolean e()
  {
    if (FlurryAdModule.e()) {
      ja.a(3, a, "Device is locked: banner will NOT rotate for adSpace: " + getAdSpace());
    }
    ac localac;
    do
    {
      return false;
      if (this.b.c())
      {
        ja.a(3, a, "Ad fullscreen panel is opened: banner will NOT rotate for adSpace: " + getAdSpace());
        return false;
      }
      localac = getCurrentBannerView();
    } while ((localac == null) || (!localac.e()));
    return true;
  }
  
  private void f()
  {
    ja.a(3, a, "Rotating banner for adSpace: " + getAdSpace());
    this.b.b().a(getContext(), this.c, FlurryAdSize.BANNER_BOTTOM, this.d, 1L);
  }
  
  private ac getCurrentBannerView()
  {
    if (getChildCount() < 1) {
      return null;
    }
    Object localObject = getChildAt(0);
    try
    {
      localObject = (ac)localObject;
      return (ac)localObject;
    }
    catch (ClassCastException localClassCastException) {}
    return null;
  }
  
  public void a()
  {
    try
    {
      d();
      this.e = 0L;
      removeCallbacks(this.g);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.e != paramLong)
      {
        d();
        this.e = paramLong;
        c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    a();
    ac localac = getCurrentBannerView();
    if (localac != null) {
      localac.stop();
    }
  }
  
  public String getAdSpace()
  {
    return this.c;
  }
  
  public long getRotationRateInMilliseconds()
  {
    return this.e;
  }
  
  public ViewGroup getViewGroup()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */