package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;

class hu
{
  public long a(hm paramhm)
  {
    int i = paramhm.f();
    paramhm = paramhm.d();
    ja.a(4, "RetryPolicyChecker", "checkOperation retryAttemps = " + (i + 1) + " / " + paramhm.size());
    if (i >= paramhm.size()) {
      return -1L;
    }
    return ((Long)paramhm.get(Integer.valueOf(i))).longValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */