package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class kg
  extends kb
{
  private List<js> i;
  private Map<String, js> j;
  private final boolean k;
  
  public kg(ka paramka, String paramString, boolean paramBoolean)
  {
    super(kj.a, paramka, paramString);
    this.k = paramBoolean;
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    if (c(paramkc, paramor)) {
      return;
    }
    String str2 = kc.a(paramkc);
    paramor.d();
    if (this.k) {}
    for (String str1 = "error";; str1 = "record")
    {
      paramor.a("type", str1);
      d(paramkc, paramor);
      kc.a(paramkc, ka.c(this.f));
      if (e() != null) {
        paramor.a("doc", e());
      }
      paramor.a("fields");
      b(paramkc, paramor);
      this.c.a(paramor);
      a(paramor);
      paramor.e();
      kc.a(paramkc, str2);
      return;
    }
  }
  
  public js b(String paramString)
  {
    if (this.j == null) {
      throw new jg("Schema fields not set yet");
    }
    return (js)this.j.get(paramString);
  }
  
  public List<js> b()
  {
    if (this.i == null) {
      throw new jg("Schema fields not set yet");
    }
    return this.i;
  }
  
  void b(kc paramkc, or paramor)
    throws IOException
  {
    paramor.b();
    Iterator localIterator1 = this.i.iterator();
    while (localIterator1.hasNext())
    {
      js localjs = (js)localIterator1.next();
      paramor.d();
      paramor.a("name", localjs.a());
      paramor.a("type");
      localjs.c().a(paramkc, paramor);
      if (localjs.d() != null) {
        paramor.a("doc", localjs.d());
      }
      if (localjs.e() != null)
      {
        paramor.a("default");
        paramor.a(localjs.e());
      }
      if (localjs.f() != jt.a) {
        paramor.a("order", jt.a(localjs.f()));
      }
      if ((js.b(localjs) != null) && (js.b(localjs).size() != 0))
      {
        paramor.a("aliases");
        paramor.b();
        Iterator localIterator2 = js.b(localjs).iterator();
        while (localIterator2.hasNext()) {
          paramor.b((String)localIterator2.next());
        }
        paramor.c();
      }
      js.c(localjs).a(paramor);
      paramor.e();
    }
    paramor.c();
  }
  
  public void b(List<js> paramList)
  {
    if (this.i != null) {
      throw new jg("Fields are already set");
    }
    this.j = new HashMap();
    jx localjx = new jx();
    paramList = paramList.iterator();
    int m = 0;
    while (paramList.hasNext())
    {
      js localjs = (js)paramList.next();
      if (js.a(localjs) != -1) {
        throw new jg("Field already used: " + localjs);
      }
      js.a(localjs, m);
      this.j.put(localjs.a(), localjs);
      localjx.add(localjs);
      m += 1;
    }
    this.i = localjx.a();
    this.d = Integer.MIN_VALUE;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof kg)) {
      return false;
    }
    Object localObject = (kg)paramObject;
    if (!c((ji)localObject)) {
      return false;
    }
    if (!a((kb)localObject)) {
      return false;
    }
    if (!this.c.equals(((kg)localObject).c)) {
      return false;
    }
    localObject = (Set)ji.o().get();
    kh localkh = new kh(this, paramObject, null);
    if (((Set)localObject).contains(localkh)) {
      return true;
    }
    boolean bool1 = ((Set)localObject).isEmpty();
    try
    {
      ((Set)localObject).add(localkh);
      boolean bool2 = this.i.equals(((kg)paramObject).i);
      return bool2;
    }
    finally
    {
      if (bool1) {
        ((Set)localObject).clear();
      }
    }
  }
  
  public boolean h()
  {
    return this.k;
  }
  
  int m()
  {
    Map localMap = (Map)ji.p().get();
    if (localMap.containsKey(this)) {
      return 0;
    }
    boolean bool = localMap.isEmpty();
    try
    {
      localMap.put(this, this);
      int m = super.m();
      int n = this.i.hashCode();
      return m + n;
    }
    finally
    {
      if (bool) {
        localMap.clear();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */