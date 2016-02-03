package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public final class afe
  extends afg
{
  protected final Object c;
  
  public afe(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public double a(double paramDouble)
  {
    if ((this.c instanceof Number)) {
      paramDouble = ((Number)this.c).doubleValue();
    }
    return paramDouble;
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    if (this.c == null)
    {
      paramor.f();
      return;
    }
    paramor.a(this.c);
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
      paramObject = (afe)paramObject;
      if (this.c != null) {
        break;
      }
    } while (((afe)paramObject).c == null);
    return false;
    return this.c.equals(((afe)paramObject).c);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String m()
  {
    if (this.c == null) {
      return "null";
    }
    return this.c.toString();
  }
  
  public String toString()
  {
    return String.valueOf(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */