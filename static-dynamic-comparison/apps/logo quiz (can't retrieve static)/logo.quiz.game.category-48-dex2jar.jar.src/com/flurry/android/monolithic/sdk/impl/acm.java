package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public final class acm
  extends abq<AtomicLong>
{
  public acm()
  {
    super(AtomicLong.class, false);
  }
  
  public void a(AtomicLong paramAtomicLong, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.a(paramAtomicLong.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */