package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class ns<T>
  extends la<T>
{
  public ns()
  {
    super(nn.b());
  }
  
  public ns(Class<T> paramClass)
  {
    super(nn.b().a(paramClass), nn.b());
  }
  
  protected void c(ji paramji, Object paramObject, mc parammc)
    throws IOException
  {
    if (!(paramObject instanceof Enum))
    {
      super.c(paramji, paramObject, parammc);
      return;
    }
    parammc.a(((Enum)paramObject).ordinal());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */