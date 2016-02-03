package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;
import java.util.Map;

class kc
  extends LinkedHashMap<ka, ji>
{
  private String a;
  
  public ji a(ka paramka, ji paramji)
  {
    if (containsKey(paramka)) {
      throw new kl("Can't redefine: " + paramka);
    }
    return (ji)super.put(paramka, paramji);
  }
  
  public ji a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      kj localkj = (kj)ji.e.get((String)paramObject);
      if (localkj != null) {
        return ji.a(localkj);
      }
    }
    for (paramObject = new ka((String)paramObject, this.a);; paramObject = (ka)paramObject) {
      return (ji)super.get(paramObject);
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(ji paramji)
  {
    a(((kb)paramji).f, paramji);
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */