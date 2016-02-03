package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Member;
import java.util.HashMap;

public class tm
{
  final xq a;
  final boolean b;
  protected xi c;
  protected xo d;
  protected xo e;
  protected xo f;
  protected xo g;
  protected xo h;
  protected xo i;
  protected xo j;
  protected tn[] k = null;
  
  public tm(xq paramxq, boolean paramBoolean)
  {
    this.a = paramxq;
    this.b = paramBoolean;
  }
  
  public th a(qk paramqk)
  {
    ww localww = new ww(paramqk, this.a.a());
    if (this.i == null) {}
    for (paramqk = null;; paramqk = this.a.j().a(this.i.b(0)))
    {
      localww.a(this.c, this.i, paramqk, this.j, this.k);
      localww.a(this.d);
      localww.b(this.e);
      localww.c(this.f);
      localww.d(this.g);
      localww.e(this.h);
      return localww;
    }
  }
  
  protected xo a(xo paramxo1, xo paramxo2, String paramString)
  {
    if ((paramxo2 != null) && (paramxo2.getClass() == paramxo1.getClass())) {
      throw new IllegalArgumentException("Conflicting " + paramString + " creators: already had " + paramxo2 + ", encountered " + paramxo1);
    }
    if (this.b) {
      adz.a((Member)paramxo1.a());
    }
    return paramxo1;
  }
  
  public void a(xi paramxi)
  {
    this.c = paramxi;
  }
  
  public void a(xo paramxo)
  {
    this.d = a(paramxo, this.d, "String");
  }
  
  public void a(xo paramxo, tn[] paramArrayOftn)
  {
    this.j = a(paramxo, this.j, "property-based");
    if (paramArrayOftn.length > 1)
    {
      paramxo = new HashMap();
      int n = paramArrayOftn.length;
      int m = 0;
      while (m < n)
      {
        String str = paramArrayOftn[m].c();
        Integer localInteger = (Integer)paramxo.put(str, Integer.valueOf(m));
        if (localInteger != null) {
          throw new IllegalArgumentException("Duplicate creator property \"" + str + "\" (index " + localInteger + " vs " + m + ")");
        }
        m += 1;
      }
    }
    this.k = paramArrayOftn;
  }
  
  public void b(xo paramxo)
  {
    this.e = a(paramxo, this.e, "int");
  }
  
  public void c(xo paramxo)
  {
    this.f = a(paramxo, this.f, "long");
  }
  
  public void d(xo paramxo)
  {
    this.g = a(paramxo, this.g, "double");
  }
  
  public void e(xo paramxo)
  {
    this.h = a(paramxo, this.h, "boolean");
  }
  
  public void f(xo paramxo)
  {
    this.i = a(paramxo, this.i, "delegate");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */