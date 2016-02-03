package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Arrays;

public class afu
  implements pf
{
  static final String a;
  static final char[] b;
  
  static
  {
    Object localObject1 = null;
    try
    {
      localObject2 = System.getProperty("line.separator");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "\n";
    }
    a = (String)localObject2;
    b = new char[64];
    Arrays.fill(b, ' ');
  }
  
  public void a(or paramor, int paramInt)
    throws IOException, oq
  {
    paramor.c(a);
    paramInt += paramInt;
    while (paramInt > 64)
    {
      paramor.b(b, 0, 64);
      paramInt -= b.length;
    }
    paramor.b(b, 0, paramInt);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */