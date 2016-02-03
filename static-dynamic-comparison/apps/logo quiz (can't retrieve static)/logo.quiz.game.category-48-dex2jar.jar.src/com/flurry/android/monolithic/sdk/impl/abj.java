package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Iterator;

@rz
public class abj
  extends aay<Iterable<?>>
{
  public abj(afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc)
  {
    super(Iterable.class, paramafm, paramBoolean, paramrx, paramqc, null);
  }
  
  public abc<?> a(rx paramrx)
  {
    return new abj(this.b, this.a, paramrx, this.e);
  }
  
  public void a(Iterable<?> paramIterable, or paramor, ru paramru)
    throws IOException, oq
  {
    Object localObject1 = null;
    Iterator localIterator = paramIterable.iterator();
    rx localrx;
    if (localIterator.hasNext())
    {
      localrx = this.c;
      paramIterable = null;
    }
    for (;;)
    {
      Object localObject3 = localIterator.next();
      if (localObject3 == null) {
        paramru.a(paramor);
      }
      while (!localIterator.hasNext())
      {
        return;
        Object localObject2 = localObject3.getClass();
        if (localObject2 == localObject1) {}
        for (localObject2 = paramIterable;; localObject2 = paramIterable)
        {
          if (localrx != null) {
            break label114;
          }
          ((ra)localObject2).a(localObject3, paramor, paramru);
          break;
          paramIterable = paramru.a((Class)localObject2, this.e);
          localObject1 = localObject2;
        }
        label114:
        ((ra)localObject2).a(localObject3, paramor, paramru, localrx);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */