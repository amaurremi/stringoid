package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

public class abg
  extends aay<EnumSet<? extends Enum<?>>>
{
  public abg(afm paramafm, qc paramqc)
  {
    super(EnumSet.class, paramafm, true, null, paramqc, null);
  }
  
  public abc<?> a(rx paramrx)
  {
    return this;
  }
  
  public void a(EnumSet<? extends Enum<?>> paramEnumSet, or paramor, ru paramru)
    throws IOException, oq
  {
    Object localObject = this.d;
    Iterator localIterator = paramEnumSet.iterator();
    for (paramEnumSet = (EnumSet<? extends Enum<?>>)localObject; localIterator.hasNext(); paramEnumSet = (EnumSet<? extends Enum<?>>)localObject)
    {
      Enum localEnum = (Enum)localIterator.next();
      localObject = paramEnumSet;
      if (paramEnumSet == null) {
        localObject = paramru.a(localEnum.getDeclaringClass(), this.e);
      }
      ((ra)localObject).a(localEnum, paramor, paramru);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */