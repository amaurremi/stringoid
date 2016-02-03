package com.flurry.android.monolithic.sdk.impl;

import java.util.IdentityHashMap;
import java.util.Map;

final class jk
  extends ThreadLocal<Map>
{
  protected Map a()
  {
    return new IdentityHashMap();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */