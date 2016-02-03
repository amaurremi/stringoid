package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class tp
{
  private final ArrayList<tq> a = new ArrayList();
  private final HashMap<String, Integer> b = new HashMap();
  
  public to a()
  {
    return new to((tq[])this.a.toArray(new tq[this.a.size()]), this.b, null, null);
  }
  
  public void a(sw paramsw, String paramString)
  {
    Integer localInteger = Integer.valueOf(this.a.size());
    this.a.add(new tq(paramsw, paramString));
    this.b.put(paramsw.c(), localInteger);
    this.b.put(paramString, localInteger);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */