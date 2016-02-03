package com.flurry.android.monolithic.sdk.impl;

public final class yg
{
  protected final Class<?> a;
  protected final int b;
  protected String c;
  
  public yg(Class<?> paramClass, String paramString)
  {
    this.a = paramClass;
    this.b = paramClass.getName().hashCode();
    a(paramString);
  }
  
  public Class<?> a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = null;
    }
    this.c = str;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
    } while (this.a == ((yg)paramObject).a);
    return false;
  }
  
  public int hashCode()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[NamedType, class ").append(this.a.getName()).append(", name: ");
    if (this.c == null) {}
    for (String str = "null";; str = "'" + this.c + "'") {
      return str + "]";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */