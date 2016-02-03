package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;

abstract class aj
{
  private static boolean h(AdSpaceLayout paramAdSpaceLayout)
  {
    return paramAdSpaceLayout.b().intValue() != 0;
  }
  
  private static boolean i(AdSpaceLayout paramAdSpaceLayout)
  {
    return paramAdSpaceLayout.c().intValue() != 0;
  }
  
  public abstract ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout);
  
  public int b(AdSpaceLayout paramAdSpaceLayout)
  {
    if (h(paramAdSpaceLayout)) {
      return d(paramAdSpaceLayout);
    }
    return f(paramAdSpaceLayout);
  }
  
  public int c(AdSpaceLayout paramAdSpaceLayout)
  {
    if (i(paramAdSpaceLayout)) {
      return e(paramAdSpaceLayout);
    }
    return g(paramAdSpaceLayout);
  }
  
  public int d(AdSpaceLayout paramAdSpaceLayout)
  {
    return je.b(paramAdSpaceLayout.b().intValue());
  }
  
  public int e(AdSpaceLayout paramAdSpaceLayout)
  {
    return je.b(paramAdSpaceLayout.c().intValue());
  }
  
  public int f(AdSpaceLayout paramAdSpaceLayout)
  {
    return -1;
  }
  
  public int g(AdSpaceLayout paramAdSpaceLayout)
  {
    return -2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */