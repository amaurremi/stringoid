package com.flurry.android.monolithic.sdk.impl;

public final class aau
{
  protected int a;
  protected Class<?> b;
  protected afm c;
  protected boolean d;
  
  public aau(afm paramafm, boolean paramBoolean)
  {
    this.c = paramafm;
    this.b = null;
    this.d = paramBoolean;
    this.a = a(paramafm, paramBoolean);
  }
  
  public aau(Class<?> paramClass, boolean paramBoolean)
  {
    this.b = paramClass;
    this.c = null;
    this.d = paramBoolean;
    this.a = a(paramClass, paramBoolean);
  }
  
  private static final int a(afm paramafm, boolean paramBoolean)
  {
    int j = paramafm.hashCode() - 1;
    int i = j;
    if (paramBoolean) {
      i = j - 1;
    }
    return i;
  }
  
  private static final int a(Class<?> paramClass, boolean paramBoolean)
  {
    int j = paramClass.getName().hashCode();
    int i = j;
    if (paramBoolean) {
      i = j + 1;
    }
    return i;
  }
  
  public void a(afm paramafm)
  {
    this.c = paramafm;
    this.b = null;
    this.d = true;
    this.a = a(paramafm, true);
  }
  
  public void a(Class<?> paramClass)
  {
    this.c = null;
    this.b = paramClass;
    this.d = true;
    this.a = a(paramClass, true);
  }
  
  public void b(afm paramafm)
  {
    this.c = paramafm;
    this.b = null;
    this.d = false;
    this.a = a(paramafm, false);
  }
  
  public void b(Class<?> paramClass)
  {
    this.c = null;
    this.b = paramClass;
    this.d = false;
    this.a = a(paramClass, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      paramObject = (aau)paramObject;
      if (((aau)paramObject).d != this.d) {
        break label55;
      }
      if (this.b == null) {
        break;
      }
    } while (((aau)paramObject).b == this.b);
    return false;
    return this.c.equals(((aau)paramObject).c);
    label55:
    return false;
  }
  
  public final int hashCode()
  {
    return this.a;
  }
  
  public final String toString()
  {
    if (this.b != null) {
      return "{class: " + this.b.getName() + ", typed? " + this.d + "}";
    }
    return "{type: " + this.c + ", typed? " + this.d + "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */