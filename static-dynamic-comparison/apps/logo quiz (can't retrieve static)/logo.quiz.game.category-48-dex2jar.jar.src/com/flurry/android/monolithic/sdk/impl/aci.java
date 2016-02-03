package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Iterator;

@rz
public class aci
  extends aay<Iterator<?>>
{
  public aci(afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc)
  {
    super(Iterator.class, paramafm, paramBoolean, paramrx, paramqc, null);
  }
  
  public abc<?> a(rx paramrx)
  {
    return new aci(this.b, this.a, paramrx, this.e);
  }
  
  public void a(Iterator<?> paramIterator, or paramor, ru paramru)
    throws IOException, oq
  {
    Object localObject1 = null;
    rx localrx;
    ra localra;
    if (paramIterator.hasNext())
    {
      localrx = this.c;
      localra = null;
    }
    for (;;)
    {
      Object localObject3 = paramIterator.next();
      if (localObject3 == null) {
        paramru.a(paramor);
      }
      while (!paramIterator.hasNext())
      {
        return;
        Object localObject2 = localObject3.getClass();
        if (localObject2 == localObject1) {}
        for (localObject2 = localra;; localObject2 = localra)
        {
          if (localrx != null) {
            break label107;
          }
          ((ra)localObject2).a(localObject3, paramor, paramru);
          break;
          localra = paramru.a((Class)localObject2, this.e);
          localObject1 = localObject2;
        }
        label107:
        ((ra)localObject2).a(localObject3, paramor, paramru, localrx);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */