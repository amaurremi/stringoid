package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;

public class hm
  extends hk
{
  private String e = "";
  private int f = -1;
  private int g = 0;
  private LinkedHashMap<Integer, Long> h = hv.a(1, 0L);
  
  public hm(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public LinkedHashMap<Integer, Long> d()
  {
    return this.h;
  }
  
  public void e()
  {
    this.g += 1;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public hl g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */