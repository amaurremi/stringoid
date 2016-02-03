package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class br
{
  private final String b;
  private final ViewGroup c;
  private final boolean d;
  private final FlurryAdSize e;
  private final Runnable f;
  private Future<?> g;
  
  public br(FlurryAdModule paramFlurryAdModule, String paramString, ViewGroup paramViewGroup, boolean paramBoolean, FlurryAdSize paramFlurryAdSize, jf paramjf)
  {
    this.b = paramString;
    this.c = paramViewGroup;
    this.d = paramBoolean;
    this.e = paramFlurryAdSize;
    this.f = paramjf;
  }
  
  public br a()
  {
    this.g = this.a.b(new bs(this));
    return this;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (this.g != null) {
      this.g.get(paramLong, paramTimeUnit);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.cancel(paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */