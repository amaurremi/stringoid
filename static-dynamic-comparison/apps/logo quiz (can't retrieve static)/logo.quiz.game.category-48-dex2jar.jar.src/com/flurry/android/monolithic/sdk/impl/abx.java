package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public final class abx
  extends abw<boolean[]>
{
  public abx()
  {
    super(boolean[].class, null, null);
  }
  
  public abc<?> a(rx paramrx)
  {
    return this;
  }
  
  public void a(boolean[] paramArrayOfBoolean, or paramor, ru paramru)
    throws IOException, oq
  {
    int i = 0;
    int j = paramArrayOfBoolean.length;
    while (i < j)
    {
      paramor.a(paramArrayOfBoolean[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */