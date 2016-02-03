package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import java.util.HashMap;

public class qk
  extends ri<ql, qk>
{
  protected aeg<qn> a;
  protected final aez b;
  protected boolean c;
  
  public qk(qf<? extends qb> paramqf, py parampy, ye<?> paramye, yh paramyh, rl paramrl, adk paramadk, qs paramqs)
  {
    super(paramqf, parampy, paramye, paramyh, paramrl, paramadk, paramqs, d(ql.class));
    this.b = aez.a;
  }
  
  protected qk(qk paramqk, rg paramrg)
  {
    super(paramqk, paramrg, paramqk.h);
    this.a = paramqk.a;
    this.b = paramqk.b;
    this.c = paramqk.c;
  }
  
  private qk(qk paramqk, HashMap<adb, Class<?>> paramHashMap, yh paramyh)
  {
    this(paramqk, paramqk.e);
    this.f = paramHashMap;
    this.h = paramyh;
  }
  
  public py a()
  {
    if (a(ql.a)) {
      return super.a();
    }
    return ya.a;
  }
  
  public <T extends qb> T a(afm paramafm)
  {
    return i().a(this, paramafm, this);
  }
  
  protected qk a(int paramInt)
  {
    if ((rr.l.b() & paramInt) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      return this;
    }
  }
  
  public qk a(yh paramyh)
  {
    HashMap localHashMap = this.f;
    this.g = true;
    return new qk(this, localHashMap, paramyh);
  }
  
  public qu<Object> a(xg paramxg, Class<? extends qu<?>> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.a(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (qu)adz.b(paramClass, c());
  }
  
  public boolean a(ql paramql)
  {
    return (this.i & paramql.b()) != 0;
  }
  
  public <T extends qb> T b(afm paramafm)
  {
    return i().a(this, paramafm, this);
  }
  
  public rc b(xg paramxg, Class<? extends rc> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.b(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (rc)adz.b(paramClass, c());
  }
  
  public boolean b()
  {
    return a(ql.a);
  }
  
  public <T extends qb> T c(afm paramafm)
  {
    return i().b(this, paramafm, this);
  }
  
  public th c(xg paramxg, Class<? extends th> paramClass)
  {
    qs localqs = k();
    if (localqs != null)
    {
      paramxg = localqs.c(this, paramxg, paramClass);
      if (paramxg != null) {
        return paramxg;
      }
    }
    return (th)adz.b(paramClass, c());
  }
  
  public boolean c()
  {
    return a(ql.f);
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public ye<?> e()
  {
    Object localObject2 = super.e();
    Object localObject1 = localObject2;
    if (!a(ql.b)) {
      localObject1 = ((ye)localObject2).c(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!a(ql.c)) {
      localObject2 = ((ye)localObject1).d(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!a(ql.d)) {
      localObject1 = ((ye)localObject2).e(JsonAutoDetect.Visibility.NONE);
    }
    return (ye<?>)localObject1;
  }
  
  public aeg<qn> f()
  {
    return this.a;
  }
  
  public on g()
  {
    return oo.a();
  }
  
  public final aez h()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/qk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */