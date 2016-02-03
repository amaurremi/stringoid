package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;

final class ah
  extends aj
{
  ah()
  {
    super(null);
  }
  
  public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout)
  {
    ja.a(5, af.a(), "AbsoluteLayout is deprecated, please consider to use FrameLayout or RelativeLayout for banner ad container view");
    return new AbsoluteLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout), 0, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */