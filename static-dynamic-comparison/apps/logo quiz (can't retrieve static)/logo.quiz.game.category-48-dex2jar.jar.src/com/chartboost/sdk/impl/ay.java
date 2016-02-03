package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Arrays;

public class ay
  implements Serializable
{
  final byte a;
  final byte[] b;
  
  public byte a()
  {
    return this.a;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ay)) {
        return false;
      }
      paramObject = (ay)paramObject;
      if (this.a != ((ay)paramObject).a) {
        return false;
      }
    } while (Arrays.equals(this.b, ((ay)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a;
    if (this.b != null) {}
    for (int i = Arrays.hashCode(this.b);; i = 0) {
      return i + j * 31;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */