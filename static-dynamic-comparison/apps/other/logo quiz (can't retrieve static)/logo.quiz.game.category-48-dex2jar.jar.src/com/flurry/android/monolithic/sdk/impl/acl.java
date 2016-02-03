package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class acl
  extends abq<AtomicInteger>
{
  public acl()
  {
    super(AtomicInteger.class, false);
  }
  
  public void a(AtomicInteger paramAtomicInteger, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.b(paramAtomicInteger.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */