package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class sr
{
  protected final xq a;
  protected final HashMap<String, sw> b = new LinkedHashMap();
  protected List<ty> c;
  protected HashMap<String, sw> d;
  protected HashSet<String> e;
  protected th f;
  protected sv g;
  protected boolean h;
  
  public sr(xq paramxq)
  {
    this.a = paramxq;
  }
  
  public qu<?> a(qc paramqc)
  {
    tj localtj = new tj(this.b.values());
    localtj.a();
    return new sp(this.a, paramqc, this.f, localtj, this.d, this.e, this.h, this.g, this.c);
  }
  
  public void a(qe paramqe) {}
  
  public void a(sv paramsv)
  {
    if ((this.g != null) && (paramsv != null)) {
      throw new IllegalStateException("_anySetter already set to non-null");
    }
    this.g = paramsv;
  }
  
  public void a(sw paramsw)
  {
    sw localsw = (sw)this.b.put(paramsw.c(), paramsw);
    if ((localsw != null) && (localsw != paramsw)) {
      throw new IllegalArgumentException("Duplicate property '" + paramsw.c() + "' for " + this.a.a());
    }
  }
  
  public void a(sw paramsw, boolean paramBoolean)
  {
    this.b.put(paramsw.c(), paramsw);
  }
  
  public void a(th paramth)
  {
    this.f = paramth;
  }
  
  public void a(String paramString)
  {
    if (this.e == null) {
      this.e = new HashSet();
    }
    this.e.add(paramString);
  }
  
  public void a(String paramString, afm paramafm, ado paramado, xk paramxk, Object paramObject)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(new ty(paramString, paramafm, paramado, paramxk, paramObject));
  }
  
  public void a(String paramString, sw paramsw)
  {
    if (this.d == null) {
      this.d = new HashMap(4);
    }
    this.d.put(paramString, paramsw);
    if (this.b != null) {
      this.b.remove(paramsw.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */