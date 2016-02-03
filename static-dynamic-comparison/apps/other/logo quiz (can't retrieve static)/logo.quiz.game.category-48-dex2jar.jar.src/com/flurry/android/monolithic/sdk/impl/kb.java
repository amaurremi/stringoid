package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

abstract class kb
  extends ji
{
  final ka f;
  final String g;
  Set<ka> h;
  
  public kb(kj paramkj, ka paramka, String paramString)
  {
    super(paramkj);
    this.f = paramka;
    this.g = paramString;
    if (e.containsKey(ka.a(paramka))) {
      throw new jh("Schemas may not be named after primitives: " + ka.a(paramka));
    }
  }
  
  public void a(or paramor)
    throws IOException
  {
    if ((this.h == null) || (this.h.size() == 0)) {
      return;
    }
    paramor.a("aliases");
    paramor.b();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      paramor.b(((ka)localIterator.next()).a(ka.c(this.f)));
    }
    paramor.c();
  }
  
  public boolean a(kb paramkb)
  {
    return this.f.equals(paramkb.f);
  }
  
  public boolean c(kc paramkc, or paramor)
    throws IOException
  {
    if (equals(paramkc.a(this.f)))
    {
      paramor.b(this.f.a(paramkc.a()));
      return true;
    }
    if (ka.b(this.f) != null) {
      paramkc.a(this.f, this);
    }
    return false;
  }
  
  public String d()
  {
    return ka.b(this.f);
  }
  
  public void d(kc paramkc, or paramor)
    throws IOException
  {
    this.f.a(paramkc, paramor);
  }
  
  public void d(String paramString)
  {
    if (this.h == null) {
      this.h = new LinkedHashSet();
    }
    this.h.add(new ka(paramString, ka.c(this.f)));
  }
  
  public String e()
  {
    return this.g;
  }
  
  public String f()
  {
    return ka.c(this.f);
  }
  
  public String g()
  {
    return ka.a(this.f);
  }
  
  int m()
  {
    return super.m() + this.f.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */