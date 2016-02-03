package com.flurry.android.monolithic.sdk.impl;

final class yd<T>
{
  public final T a;
  public final yd<T> b;
  public final String c;
  public final boolean d;
  public final boolean e;
  
  public yd(T paramT, yd<T> paramyd, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramT;
    this.b = paramyd;
    if (paramString == null) {}
    for (this.c = null;; this.c = paramT)
    {
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      return;
      paramT = paramString;
      if (paramString.length() == 0) {
        paramT = null;
      }
    }
  }
  
  private yd<T> b(yd<T> paramyd)
  {
    if (this.b == null) {
      return a(paramyd);
    }
    return a(this.b.b(paramyd));
  }
  
  public yd<T> a()
  {
    if (this.e)
    {
      if (this.b == null) {
        return null;
      }
      return this.b.a();
    }
    if (this.b != null)
    {
      yd localyd = this.b.a();
      if (localyd != this.b) {
        return a(localyd);
      }
    }
    return this;
  }
  
  public yd<T> a(yd<T> paramyd)
  {
    if (paramyd == this.b) {
      return this;
    }
    return new yd(this.a, paramyd, this.c, this.d, this.e);
  }
  
  public yd<T> a(T paramT)
  {
    if (paramT == this.a) {
      return this;
    }
    return new yd(paramT, this.b, this.c, this.d, this.e);
  }
  
  public yd<T> b()
  {
    if (this.b == null) {}
    for (yd localyd1 = null;; localyd1 = this.b.b())
    {
      yd localyd2 = localyd1;
      if (this.d) {
        localyd2 = a(localyd1);
      }
      return localyd2;
    }
  }
  
  public yd<T> c()
  {
    Object localObject;
    if (this.b == null) {
      localObject = this;
    }
    do
    {
      yd localyd;
      do
      {
        return (yd<T>)localObject;
        localyd = this.b.c();
        if (this.c != null)
        {
          if (localyd.c == null) {
            return a(null);
          }
          return a(localyd);
        }
        localObject = localyd;
      } while (localyd.c != null);
      if (this.d == localyd.d) {
        return a(localyd);
      }
      localObject = localyd;
    } while (!this.d);
    return a(null);
  }
  
  public String toString()
  {
    String str2 = this.a.toString() + "[visible=" + this.d + "]";
    String str1 = str2;
    if (this.b != null) {
      str1 = str2 + ", " + this.b.toString();
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */