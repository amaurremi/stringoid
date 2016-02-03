package com.chartboost.sdk.impl;

import java.io.Serializable;

public class be
  implements Serializable
{
  private final String a;
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label28:
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof be)) {
        break;
      }
      paramObject = ((be)paramObject).a;
      if (this.a == null) {
        break label65;
      }
    } while (this.a.equals(paramObject));
    for (;;)
    {
      return false;
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        break label28;
      }
      return false;
      label65:
      if (paramObject == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */