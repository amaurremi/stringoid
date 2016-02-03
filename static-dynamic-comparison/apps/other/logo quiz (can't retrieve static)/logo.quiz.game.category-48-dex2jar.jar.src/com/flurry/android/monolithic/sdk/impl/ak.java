package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;

final class ak
  extends aj
{
  ak()
  {
    super(null);
  }
  
  public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout)
  {
    return new LinearLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */