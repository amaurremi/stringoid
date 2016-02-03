package com.flurry.android.monolithic.sdk.impl;

import java.util.List;

public class kw
  implements le, Comparable<kw>
{
  private final ji a;
  private final Object[] b;
  
  public kw(ji paramji)
  {
    if ((paramji == null) || (!kj.a.equals(paramji.a()))) {
      throw new jg("Not a record schema: " + paramji);
    }
    this.a = paramji;
    this.b = new Object[paramji.b().size()];
  }
  
  public int a(kw paramkw)
  {
    return kq.a().a(this, paramkw, this.a);
  }
  
  public ji a()
  {
    return this.a;
  }
  
  public Object a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.b[paramInt] = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof kw)) {
        return false;
      }
      paramObject = (kw)paramObject;
      if (!this.a.g().equals(((kw)paramObject).a.g())) {
        return false;
      }
    } while (kq.a().a(this, paramObject, this.a, true) == 0);
    return false;
  }
  
  public int hashCode()
  {
    return kq.a().b(this, this.a);
  }
  
  public String toString()
  {
    return kq.a().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */