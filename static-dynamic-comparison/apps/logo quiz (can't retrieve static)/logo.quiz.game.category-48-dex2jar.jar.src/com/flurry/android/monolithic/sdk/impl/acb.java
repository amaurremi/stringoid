package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public final class acb
  extends abw<float[]>
{
  public acb()
  {
    this(null);
  }
  
  public acb(rx paramrx)
  {
    super(float[].class, paramrx, null);
  }
  
  public abc<?> a(rx paramrx)
  {
    return new acb(paramrx);
  }
  
  public void a(float[] paramArrayOfFloat, or paramor, ru paramru)
    throws IOException, oq
  {
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      paramor.a(paramArrayOfFloat[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */