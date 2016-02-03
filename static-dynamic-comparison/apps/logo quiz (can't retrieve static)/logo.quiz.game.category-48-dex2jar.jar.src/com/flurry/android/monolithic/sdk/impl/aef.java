package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class aef<K, V>
  extends LinkedHashMap<K, V>
{
  protected final int a;
  
  public aef(int paramInt1, int paramInt2)
  {
    super(paramInt1, 0.8F, true);
    this.a = paramInt2;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */