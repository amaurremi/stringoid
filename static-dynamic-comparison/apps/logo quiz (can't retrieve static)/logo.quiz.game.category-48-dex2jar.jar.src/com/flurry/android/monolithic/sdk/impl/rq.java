package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import java.util.HashMap;

public class rq
  extends ri<rr, rq>
{
  protected sf a = null;
  protected Class<?> b;
  protected zl c;
  
  public rq(qf<? extends qb> paramqf, py parampy, ye<?> paramye, yh paramyh, rl paramrl, adk paramadk, qs paramqs)
  {
    super(paramqf, parampy, paramye, paramyh, paramrl, paramadk, paramqs, d(rr.class));
    this.c = null;
  }
  
  protected rq(rq paramrq, rg paramrg)
  {
    super(paramrq, paramrg, paramrq.h);
    this.a = paramrq.a;
    this.b = paramrq.b;
    this.c = paramrq.c;
  }
  
  protected rq(rq paramrq, HashMap<adb, Class<?>> paramHashMap, yh paramyh)
  {
    this(paramrq, paramrq.e);
    this.f = paramHashMap;
    this.h = paramyh;
  }
  
  public py a()
  {
    if (a(rr.a)) {
      return super.a();
    }
    return py.a();
  }
  
  public <T extends qb> T a(afm paramafm)
  {
    return i().a(this, paramafm, this);
  }
  
  public ra<Object> a(xg paramxg, Class<? extends ra<?>> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.a(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (ra)adz.b(paramClass, c());
  }
  
  public rq a(yh paramyh)
  {
    HashMap localHashMap = this.f;
    this.g = true;
    return new rq(this, localHashMap, paramyh);
  }
  
  public boolean a(rr paramrr)
  {
    return (this.i & paramrr.b()) != 0;
  }
  
  public <T extends qb> T b(afm paramafm)
  {
    return i().a(this, paramafm, this);
  }
  
  public boolean b()
  {
    return a(rr.a);
  }
  
  public boolean c()
  {
    return a(rr.e);
  }
  
  public boolean d()
  {
    return a(rr.l);
  }
  
  public ye<?> e()
  {
    Object localObject2 = super.e();
    Object localObject1 = localObject2;
    if (!a(rr.b)) {
      localObject1 = ((ye)localObject2).a(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!a(rr.c)) {
      localObject2 = ((ye)localObject1).b(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!a(rr.d)) {
      localObject1 = ((ye)localObject2).e(JsonAutoDetect.Visibility.NONE);
    }
    return (ye<?>)localObject1;
  }
  
  public Class<?> f()
  {
    return this.b;
  }
  
  public sf g()
  {
    if (this.a != null) {
      return this.a;
    }
    if (a(rr.g)) {
      return sf.a;
    }
    return sf.b;
  }
  
  public zl h()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "[SerializationConfig: flags=0x" + Integer.toHexString(this.i) + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/rq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */