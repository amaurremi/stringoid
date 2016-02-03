package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class jr
  extends kb
{
  private final List<String> i;
  private final Map<String, Integer> j;
  
  public jr(ka paramka, String paramString, jx<String> paramjx)
  {
    super(kj.b, paramka, paramString);
    this.i = paramjx.a();
    this.j = new HashMap();
    paramka = paramjx.iterator();
    int k = 0;
    while (paramka.hasNext())
    {
      paramString = (String)paramka.next();
      if (this.j.put(ji.g(paramString), Integer.valueOf(k)) != null) {
        throw new kl("Duplicate enum symbol: " + paramString);
      }
      k += 1;
    }
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    if (c(paramkc, paramor)) {
      return;
    }
    paramor.d();
    paramor.a("type", "enum");
    d(paramkc, paramor);
    if (e() != null) {
      paramor.a("doc", e());
    }
    paramor.f("symbols");
    paramkc = this.i.iterator();
    while (paramkc.hasNext()) {
      paramor.b((String)paramkc.next());
    }
    paramor.c();
    this.c.a(paramor);
    a(paramor);
    paramor.e();
  }
  
  public int c(String paramString)
  {
    return ((Integer)this.j.get(paramString)).intValue();
  }
  
  public List<String> c()
  {
    return this.i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof jr)) {
        return false;
      }
      paramObject = (jr)paramObject;
    } while ((c((ji)paramObject)) && (a((kb)paramObject)) && (this.i.equals(((jr)paramObject).i)) && (this.c.equals(((jr)paramObject).c)));
    return false;
  }
  
  int m()
  {
    return super.m() + this.i.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */