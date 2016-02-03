package com.jirbo.adcolony;

import java.util.ArrayList;

class ADCData$c
  extends ADCData.i
{
  ArrayList<ADCData.i> a = new ArrayList();
  
  double a(int paramInt, double paramDouble)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt);
    double d = paramDouble;
    if (locali != null)
    {
      d = paramDouble;
      if (locali.p()) {
        d = locali.d();
      }
    }
    return d;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt1);
    paramInt1 = paramInt2;
    if (locali != null)
    {
      paramInt1 = paramInt2;
      if (locali.p()) {
        paramInt1 = locali.e();
      }
    }
    return paramInt1;
  }
  
  c a(double paramDouble)
  {
    a(new ADCData.e(paramDouble));
    return this;
  }
  
  c a(int paramInt)
  {
    a(new ADCData.b(paramInt));
    return this;
  }
  
  c a(int paramInt, c paramc)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt);
    c localc = paramc;
    if (locali != null)
    {
      localc = paramc;
      if (locali.f()) {
        localc = locali.h();
      }
    }
    return localc;
  }
  
  c a(c paramc)
  {
    int i = 0;
    while (i < paramc.i())
    {
      a((ADCData.i)paramc.a.get(i));
      i += 1;
    }
    return this;
  }
  
  c a(ADCData.i parami)
  {
    this.a.add(parami);
    return this;
  }
  
  c a(String paramString)
  {
    a(new ADCData.f(paramString));
    return this;
  }
  
  c a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ADCData.i locali = ADCData.a;; locali = ADCData.b)
    {
      a(locali);
      return this;
    }
  }
  
  ADCData.g a(int paramInt, ADCData.g paramg)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt);
    ADCData.g localg = paramg;
    if (locali != null)
    {
      localg = paramg;
      if (locali.m()) {
        localg = locali.n();
      }
    }
    return localg;
  }
  
  String a(int paramInt, String paramString)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt);
    String str = paramString;
    if (locali != null)
    {
      str = paramString;
      if (locali.k()) {
        str = locali.b();
      }
    }
    return str;
  }
  
  void a(af paramaf)
  {
    int k = this.a.size();
    if (k == 0)
    {
      paramaf.a("[]");
      return;
    }
    if ((k == 1) && (((ADCData.i)this.a.get(0)).g()))
    {
      paramaf.a("[");
      ((ADCData.i)this.a.get(0)).a(paramaf);
      paramaf.a("]");
      return;
    }
    paramaf.b("[");
    paramaf.i += 2;
    int j = 0;
    int i = 1;
    if (j < k)
    {
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        ((ADCData.i)this.a.get(j)).a(paramaf);
        j += 1;
        break;
        paramaf.c(',');
      }
    }
    paramaf.d();
    paramaf.i -= 2;
    paramaf.a("]");
  }
  
  boolean a(int paramInt, boolean paramBoolean)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramInt);
    boolean bool = paramBoolean;
    if (locali != null) {
      if (!locali.a())
      {
        bool = paramBoolean;
        if (!locali.k()) {}
      }
      else
      {
        bool = locali.l();
      }
    }
    return bool;
  }
  
  ADCData.i a_()
  {
    return (ADCData.i)this.a.remove(this.a.size() - 1);
  }
  
  ADCData.g b(int paramInt)
  {
    ADCData.g localg = a(paramInt, null);
    if (localg != null) {
      return localg;
    }
    return new ADCData.g();
  }
  
  c c(int paramInt)
  {
    c localc = a(paramInt, null);
    if (localc != null) {
      return localc;
    }
    return new c();
  }
  
  String d(int paramInt)
  {
    return a(paramInt, "");
  }
  
  double e(int paramInt)
  {
    return a(paramInt, 0.0D);
  }
  
  int f(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  boolean f()
  {
    return true;
  }
  
  boolean g()
  {
    return (this.a.size() == 0) || ((this.a.size() == 1) && (((ADCData.i)this.a.get(0)).g()));
  }
  
  boolean g(int paramInt)
  {
    return a(paramInt, false);
  }
  
  c h()
  {
    return this;
  }
  
  int i()
  {
    return this.a.size();
  }
  
  void j()
  {
    this.a.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCData$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */