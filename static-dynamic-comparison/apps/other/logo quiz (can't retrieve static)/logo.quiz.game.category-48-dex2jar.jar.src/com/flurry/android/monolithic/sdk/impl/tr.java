package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class tr
{
  protected final th a;
  protected final HashMap<String, sw> b;
  protected Object[] c;
  protected final sw[] d;
  
  public tr(th paramth)
  {
    this.a = paramth;
    this.b = new HashMap();
    sw[] arrayOfsw = paramth.k();
    int j = arrayOfsw.length;
    int i = 0;
    paramth = null;
    while (i < j)
    {
      sw localsw = arrayOfsw[i];
      this.b.put(localsw.c(), localsw);
      Object localObject2 = localObject1;
      if (localsw.a().t())
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Object[j];
        }
        localObject2[i] = adz.f(localsw.a().p());
      }
      localObject1 = paramth;
      if (localsw.k() != null)
      {
        localObject1 = paramth;
        if (paramth == null) {
          localObject1 = new sw[j];
        }
        localObject1[i] = localsw;
      }
      i += 1;
      paramth = (th)localObject1;
      localObject1 = localObject2;
    }
    this.c = ((Object[])localObject1);
    this.d = paramth;
  }
  
  public sw a(String paramString)
  {
    return (sw)this.b.get(paramString);
  }
  
  public tw a(ow paramow, qm paramqm)
  {
    paramow = new tw(paramow, paramqm, this.b.size());
    if (this.d != null) {
      paramow.a(this.d);
    }
    return paramow;
  }
  
  public Object a(tw paramtw)
    throws IOException
  {
    Object localObject = this.a.a(paramtw.a(this.c));
    for (paramtw = paramtw.a(); paramtw != null; paramtw = paramtw.a) {
      paramtw.a(localObject);
    }
    return localObject;
  }
  
  public Collection<sw> a()
  {
    return this.b.values();
  }
  
  public void a(sw paramsw, qu<Object> paramqu)
  {
    paramsw = paramsw.a(paramqu);
    this.b.put(paramsw.c(), paramsw);
    paramqu = paramqu.b();
    if (paramqu != null)
    {
      if (this.c == null) {
        this.c = new Object[this.b.size()];
      }
      this.c[paramsw.j()] = paramqu;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */