package com.chartboost.sdk.impl;

import java.io.Serializable;

public class az
  implements Serializable
{
  final String a;
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof az)) {
      return false;
    }
    paramObject = (az)paramObject;
    return this.a.equals(((az)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */