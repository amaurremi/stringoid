package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ack
  extends abq<AtomicBoolean>
{
  public ack()
  {
    super(AtomicBoolean.class, false);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.a(paramAtomicBoolean.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */