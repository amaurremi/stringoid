package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public final class abz
  extends abt<char[]>
{
  public abz()
  {
    super(char[].class);
  }
  
  private final void a(or paramor, char[] paramArrayOfChar)
    throws IOException, oq
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      paramor.a(paramArrayOfChar, i, 1);
      i += 1;
    }
  }
  
  public void a(char[] paramArrayOfChar, or paramor, ru paramru)
    throws IOException, oq
  {
    if (paramru.a(rr.s))
    {
      paramor.b();
      a(paramor, paramArrayOfChar);
      paramor.c();
      return;
    }
    paramor.a(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void a(char[] paramArrayOfChar, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    if (paramru.a(rr.s))
    {
      paramrx.c(paramArrayOfChar, paramor);
      a(paramor, paramArrayOfChar);
      paramrx.f(paramArrayOfChar, paramor);
      return;
    }
    paramrx.a(paramArrayOfChar, paramor);
    paramor.a(paramArrayOfChar, 0, paramArrayOfChar.length);
    paramrx.d(paramArrayOfChar, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */