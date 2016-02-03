package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Date;

public class ax
  implements Serializable, Comparable<ax>
{
  static final boolean a = Boolean.getBoolean("DEBUG.DBTIMESTAMP");
  final int b = 0;
  final Date c = null;
  
  public int a()
  {
    if (this.c == null) {
      return 0;
    }
    return (int)(this.c.getTime() / 1000L);
  }
  
  public int a(ax paramax)
  {
    if (a() != paramax.a()) {
      return a() - paramax.a();
    }
    return b() - paramax.b();
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ax)) {
        break;
      }
      paramObject = (ax)paramObject;
    } while ((a() == ((ax)paramObject).a()) && (b() == ((ax)paramObject).b()));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return (this.b + 31) * 31 + a();
  }
  
  public String toString()
  {
    return "TS time:" + this.c + " inc:" + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */