package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public final class aff
  extends afg
{
  static final aff c = new aff("");
  final String d;
  
  public aff(String paramString)
  {
    this.d = paramString;
  }
  
  protected static void a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    afr.a(paramStringBuilder, paramString);
    paramStringBuilder.append('"');
  }
  
  public static aff b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return c;
    }
    return new aff(paramString);
  }
  
  public double a(double paramDouble)
  {
    return pt.a(this.d, paramDouble);
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    if (this.d == null)
    {
      paramor.f();
      return;
    }
    paramor.b(this.d);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    return ((aff)paramObject).d.equals(this.d);
  }
  
  public String h()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public String m()
  {
    return this.d;
  }
  
  public String toString()
  {
    int i = this.d.length();
    StringBuilder localStringBuilder = new StringBuilder((i >> 4) + (i + 2));
    a(localStringBuilder, this.d);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */