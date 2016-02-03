package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class kk
  extends ji
{
  private final List<ji> f;
  private final Map<String, Integer> g = new HashMap();
  
  public kk(jx<ji> paramjx)
  {
    super(kj.e);
    this.f = paramjx.a();
    paramjx = paramjx.iterator();
    int i = 0;
    while (paramjx.hasNext())
    {
      Object localObject = (ji)paramjx.next();
      if (((ji)localObject).a() == kj.e) {
        throw new jg("Nested union: " + this);
      }
      localObject = ((ji)localObject).g();
      if (localObject == null) {
        throw new jg("Nameless in union:" + this);
      }
      if (this.g.put(localObject, Integer.valueOf(i)) != null) {
        throw new jg("Duplicate in union:" + (String)localObject);
      }
      i += 1;
    }
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    paramor.b();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((ji)localIterator.next()).a(paramkc, paramor);
    }
    paramor.c();
  }
  
  public void a(String paramString1, String paramString2)
  {
    throw new jg("Can't set properties on a union: " + this);
  }
  
  public Integer e(String paramString)
  {
    return (Integer)this.g.get(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof kk)) {
        return false;
      }
      paramObject = (kk)paramObject;
    } while ((c((ji)paramObject)) && (this.f.equals(((kk)paramObject).f)) && (this.c.equals(((kk)paramObject).c)));
    return false;
  }
  
  public List<ji> k()
  {
    return this.f;
  }
  
  int m()
  {
    int i = super.m();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      i = ((ji)localIterator.next()).m() + i;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */