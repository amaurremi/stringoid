package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class abb
  extends aay<Collection<?>>
{
  public abb(afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc, ra<Object> paramra)
  {
    super(Collection.class, paramafm, paramBoolean, paramrx, paramqc, paramra);
  }
  
  public abc<?> a(rx paramrx)
  {
    return new abb(this.b, this.a, paramrx, this.e, this.d);
  }
  
  public void a(Collection<?> paramCollection, or paramor, ru paramru)
    throws IOException, oq
  {
    if (this.d != null) {
      a(paramCollection, paramor, paramru, this.d);
    }
    Iterator localIterator;
    do
    {
      return;
      localIterator = paramCollection.iterator();
    } while (!localIterator.hasNext());
    Object localObject1 = this.f;
    rx localrx = this.c;
    int i = 0;
    int j = i;
    for (;;)
    {
      Object localObject4;
      Class localClass;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject4 = localIterator.next();
        if (localObject4 == null)
        {
          j = i;
          paramru.a(paramor);
          j = i + 1;
          i = j;
          if (localIterator.hasNext()) {
            break;
          }
          return;
        }
        j = i;
        localClass = localObject4.getClass();
        j = i;
        ra localra = ((aal)localObject1).a(localClass);
        localObject2 = localObject1;
        localObject3 = localra;
        if (localra == null)
        {
          j = i;
          if (this.b.e())
          {
            j = i;
            localObject1 = a((aal)localObject1, paramru.a(this.b, localClass), paramru);
            j = i;
            localObject2 = this.f;
            localObject3 = localObject1;
          }
        }
        else
        {
          if (localrx != null) {
            break label242;
          }
          j = i;
          ((ra)localObject3).a(localObject4, paramor, paramru);
          localObject1 = localObject2;
          continue;
        }
        j = i;
      }
      catch (Exception paramor)
      {
        a(paramru, paramor, paramCollection, j);
        return;
      }
      localObject1 = a((aal)localObject1, localClass, paramru);
      continue;
      label242:
      j = i;
      ((ra)localObject3).a(localObject4, paramor, paramru, localrx);
      localObject1 = localObject2;
    }
  }
  
  public void a(Collection<?> paramCollection, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    Iterator localIterator = paramCollection.iterator();
    rx localrx;
    int i;
    if (localIterator.hasNext())
    {
      localrx = this.c;
      i = 0;
    }
    for (;;)
    {
      Object localObject = localIterator.next();
      if (localObject == null) {}
      try
      {
        paramru.a(paramor);
        for (;;)
        {
          i += 1;
          if (localIterator.hasNext()) {
            break;
          }
          return;
          if (localrx != null) {
            break label95;
          }
          paramra.a(localObject, paramor, paramru);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(paramru, localException, paramCollection, i);
          continue;
          label95:
          paramra.a(localException, paramor, paramru, localrx);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */