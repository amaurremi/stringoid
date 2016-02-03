package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

public abstract class cn
{
  static final String a = cn.class.getSimpleName();
  private final Context b;
  private final FlurryAdModule c;
  private final m d;
  private final AdUnit e;
  
  public cn(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    this.b = paramContext;
    this.c = paramFlurryAdModule;
    this.d = paramm;
    this.e = paramAdUnit;
  }
  
  public abstract void a();
  
  public Context b()
  {
    return this.b;
  }
  
  public FlurryAdModule c()
  {
    return this.c;
  }
  
  public m d()
  {
    return this.d;
  }
  
  public AdUnit e()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */