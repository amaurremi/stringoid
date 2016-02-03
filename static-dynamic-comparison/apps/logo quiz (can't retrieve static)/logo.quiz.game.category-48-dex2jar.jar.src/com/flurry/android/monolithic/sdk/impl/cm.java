package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

public final class cm
  extends cl
{
  private final cn a;
  
  public cm(cn paramcn, AdUnit paramAdUnit)
  {
    super(paramAdUnit);
    this.a = paramcn;
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */