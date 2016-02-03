package com.chartboost.sdk.impl;

public class aa
{
  final Object a;
  final String b;
  
  public Object a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (aa)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(((aa)paramObject).a)) {}
      }
      else {
        while (((aa)paramObject).a != null) {
          return false;
        }
      }
      if (this.b == null) {
        break;
      }
    } while (this.b.equals(((aa)paramObject).b));
    for (;;)
    {
      return false;
      if (((aa)paramObject).b == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    return "{ \"$ref\" : \"" + this.b + "\", \"$id\" : \"" + this.a + "\" }";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */