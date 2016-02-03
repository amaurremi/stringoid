package com.flurry.android.monolithic.sdk.impl;

public class yc
  extends qe
  implements Comparable<yc>
{
  protected final String a;
  protected final String b;
  protected yd<xj> c;
  protected yd<xn> d;
  protected yd<xl> e;
  protected yd<xl> f;
  
  public yc(yc paramyc, String paramString)
  {
    this.b = paramyc.b;
    this.a = paramString;
    this.c = paramyc.c;
    this.d = paramyc.d;
    this.e = paramyc.e;
    this.f = paramyc.f;
  }
  
  public yc(String paramString)
  {
    this.b = paramString;
    this.a = paramString;
  }
  
  private xp a(int paramInt, yd<? extends xk>... paramVarArgs)
  {
    xp localxp = ((xk)paramVarArgs[paramInt].a).j();
    paramInt += 1;
    while (paramInt < paramVarArgs.length)
    {
      if (paramVarArgs[paramInt] != null) {
        return xp.a(localxp, a(paramInt, paramVarArgs));
      }
      paramInt += 1;
    }
    return localxp;
  }
  
  private <T> yd<T> a(yd<T> paramyd)
  {
    if (paramyd == null) {
      return paramyd;
    }
    return paramyd.a();
  }
  
  private static <T> yd<T> a(yd<T> paramyd1, yd<T> paramyd2)
  {
    if (paramyd1 == null) {
      return paramyd2;
    }
    if (paramyd2 == null) {
      return paramyd1;
    }
    return yd.a(paramyd1, paramyd2);
  }
  
  private <T> yd<T> b(yd<T> paramyd)
  {
    if (paramyd == null) {
      return paramyd;
    }
    return paramyd.b();
  }
  
  private yd<? extends xk> b(yd<? extends xk> paramyd1, yd<? extends xk> paramyd2)
  {
    if (paramyd1 != null)
    {
      String str = paramyd1.c;
      yd<? extends xk> localyd;
      if (str == null) {
        localyd = paramyd2;
      }
      label50:
      do
      {
        for (;;)
        {
          paramyd1 = paramyd1.b;
          paramyd2 = localyd;
          break;
          localyd = paramyd2;
          if (!str.equals(this.a))
          {
            if (paramyd2 != null) {
              break label50;
            }
            localyd = paramyd1;
          }
        }
        localyd = paramyd2;
      } while (str.equals(paramyd2.c));
      throw new IllegalStateException("Conflicting property name definitions: '" + paramyd2.c + "' (for " + paramyd2.a + ") vs '" + paramyd1.c + "' (for " + paramyd1.a + ")");
    }
    return paramyd2;
  }
  
  private <T> yd<T> c(yd<T> paramyd)
  {
    if (paramyd == null) {
      return paramyd;
    }
    return paramyd.c();
  }
  
  private <T> boolean d(yd<T> paramyd)
  {
    while (paramyd != null)
    {
      if ((paramyd.c != null) && (paramyd.c.length() > 0)) {
        return true;
      }
      paramyd = paramyd.b;
    }
    return false;
  }
  
  private <T> boolean e(yd<T> paramyd)
  {
    while (paramyd != null)
    {
      if (paramyd.d) {
        return true;
      }
      paramyd = paramyd.b;
    }
    return false;
  }
  
  private <T> boolean f(yd<T> paramyd)
  {
    while (paramyd != null)
    {
      if (paramyd.e) {
        return true;
      }
      paramyd = paramyd.b;
    }
    return false;
  }
  
  public int a(yc paramyc)
  {
    if (this.d != null)
    {
      if (paramyc.d == null) {
        return -1;
      }
    }
    else if (paramyc.d != null) {
      return 1;
    }
    return a().compareTo(paramyc.a());
  }
  
  public yc a(String paramString)
  {
    return new yc(this, paramString);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(xj paramxj, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = new yd(paramxj, this.c, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(xl paramxl, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = new yd(paramxl, this.e, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(xn paramxn, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = new yd(paramxn, this.d, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.e != null)
      {
        localxp = a(0, new yd[] { this.e, this.c, this.d, this.f });
        this.e = this.e.a(((xl)this.e.a).a(localxp));
      }
    }
    do
    {
      do
      {
        return;
      } while (this.c == null);
      localxp = a(0, new yd[] { this.c, this.d, this.f });
      this.c = this.c.a(((xj)this.c.a).a(localxp));
      return;
      if (this.d != null)
      {
        localxp = a(0, new yd[] { this.d, this.f, this.c, this.e });
        this.d = this.d.a(((xn)this.d.a).a(localxp));
        return;
      }
      if (this.f != null)
      {
        localxp = a(0, new yd[] { this.f, this.c, this.e });
        this.f = this.f.a(((xl)this.f.a).a(localxp));
        return;
      }
    } while (this.c == null);
    xp localxp = a(0, new yd[] { this.c, this.e });
    this.c = this.c.a(((xj)this.c.a).a(localxp));
  }
  
  public void b(xl paramxl, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = new yd(paramxl, this.f, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(yc paramyc)
  {
    this.c = a(this.c, paramyc.c);
    this.d = a(this.d, paramyc.d);
    this.e = a(this.e, paramyc.e);
    this.f = a(this.f, paramyc.f);
  }
  
  public boolean b()
  {
    return this.e != null;
  }
  
  public boolean c()
  {
    return this.f != null;
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public boolean e()
  {
    return this.d != null;
  }
  
  public xl g()
  {
    if (this.e == null) {
      localObject2 = null;
    }
    Object localObject1;
    yd localyd;
    do
    {
      return (xl)localObject2;
      localObject1 = (xl)this.e.a;
      localyd = this.e.b;
      localObject2 = localObject1;
    } while (localyd == null);
    Object localObject2 = (xl)localyd.a;
    Class localClass1 = ((xl)localObject1).h();
    Class localClass2 = ((xl)localObject2).h();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localyd = localyd.b;
        break;
      }
    }
    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + a() + "\": " + ((xl)localObject1).n() + " vs " + ((xl)localObject2).n());
  }
  
  public xl h()
  {
    if (this.f == null) {
      localObject2 = null;
    }
    Object localObject1;
    yd localyd;
    do
    {
      return (xl)localObject2;
      localObject1 = (xl)this.f.a;
      localyd = this.f.b;
      localObject2 = localObject1;
    } while (localyd == null);
    Object localObject2 = (xl)localyd.a;
    Class localClass1 = ((xl)localObject1).h();
    Class localClass2 = ((xl)localObject2).h();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localyd = localyd.b;
        break;
      }
    }
    throw new IllegalArgumentException("Conflicting setter definitions for property \"" + a() + "\": " + ((xl)localObject1).n() + " vs " + ((xl)localObject2).n());
  }
  
  public xj i()
  {
    if (this.c == null) {
      localObject2 = null;
    }
    Object localObject1;
    yd localyd;
    do
    {
      return (xj)localObject2;
      localObject1 = (xj)this.c.a;
      localyd = this.c.b;
      localObject2 = localObject1;
    } while (localyd == null);
    Object localObject2 = (xj)localyd.a;
    Class localClass1 = ((xj)localObject1).h();
    Class localClass2 = ((xj)localObject2).h();
    if (localClass1 != localClass2)
    {
      if (localClass1.isAssignableFrom(localClass2)) {
        localObject1 = localObject2;
      }
      while (localClass2.isAssignableFrom(localClass1))
      {
        localyd = localyd.b;
        break;
      }
    }
    throw new IllegalArgumentException("Multiple fields representing property \"" + a() + "\": " + ((xj)localObject1).f() + " vs " + ((xj)localObject2).f());
  }
  
  public xk j()
  {
    xl localxl = g();
    Object localObject = localxl;
    if (localxl == null) {
      localObject = i();
    }
    return (xk)localObject;
  }
  
  public xk k()
  {
    Object localObject2 = m();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = h();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = i();
      }
    }
    return (xk)localObject1;
  }
  
  public String l()
  {
    return this.b;
  }
  
  public xn m()
  {
    if (this.d == null) {
      return null;
    }
    yd localyd = this.d;
    for (;;)
    {
      if ((((xn)localyd.a).f() instanceof xi)) {
        return (xn)localyd.a;
      }
      localyd = localyd.b;
      if (localyd == null) {
        return (xn)this.d.a;
      }
    }
  }
  
  public void n()
  {
    this.c = a(this.c);
    this.e = a(this.e);
    this.f = a(this.f);
    this.d = a(this.d);
  }
  
  public void o()
  {
    this.e = b(this.e);
    this.d = b(this.d);
    if (this.e == null)
    {
      this.c = b(this.c);
      this.f = b(this.f);
    }
  }
  
  public void p()
  {
    this.c = c(this.c);
    this.e = c(this.e);
    this.f = c(this.f);
    this.d = c(this.d);
  }
  
  public boolean q()
  {
    return (d(this.c)) || (d(this.e)) || (d(this.f)) || (d(this.d));
  }
  
  public boolean r()
  {
    return (e(this.c)) || (e(this.e)) || (e(this.f)) || (e(this.d));
  }
  
  public boolean s()
  {
    return (f(this.c)) || (f(this.e)) || (f(this.f)) || (f(this.d));
  }
  
  public boolean t()
  {
    return (f(this.c)) || (f(this.f)) || (f(this.d));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Property '").append(this.a).append("'; ctors: ").append(this.d).append(", field(s): ").append(this.c).append(", getter(s): ").append(this.e).append(", setter(s): ").append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public String u()
  {
    yd localyd = b(this.c, null);
    localyd = b(this.e, localyd);
    localyd = b(this.f, localyd);
    localyd = b(this.d, localyd);
    if (localyd == null) {
      return null;
    }
    return localyd.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */