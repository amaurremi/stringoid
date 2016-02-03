package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.List;

@rz
public class ach
  extends aay<List<?>>
{
  public ach(afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc, ra<Object> paramra)
  {
    super(List.class, paramafm, paramBoolean, paramrx, paramqc, paramra);
  }
  
  public abc<?> a(rx paramrx)
  {
    return new ach(this.b, this.a, paramrx, this.e, this.d);
  }
  
  public void a(List<?> paramList, or paramor, ru paramru)
    throws IOException, oq
  {
    if (this.d != null) {
      a(paramList, paramor, paramru, this.d);
    }
    int k;
    do
    {
      return;
      if (this.c != null)
      {
        b(paramList, paramor, paramru);
        return;
      }
      k = paramList.size();
    } while (k == 0);
    int j = 0;
    int i = 0;
    for (;;)
    {
      Class localClass;
      try
      {
        localObject1 = this.f;
        if (i >= k) {
          break;
        }
        j = i;
        Object localObject4 = paramList.get(i);
        if (localObject4 == null)
        {
          j = i;
          paramru.a(paramor);
        }
        else
        {
          j = i;
          localClass = localObject4.getClass();
          j = i;
          ra localra = ((aal)localObject1).a(localClass);
          Object localObject2 = localObject1;
          Object localObject3 = localra;
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
            j = i;
            ((ra)localObject3).a(localObject4, paramor, paramru);
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception paramor)
      {
        a(paramru, paramor, paramList, j);
        return;
      }
      j = i;
      Object localObject1 = a((aal)localObject1, localClass, paramru);
      continue;
      i += 1;
    }
  }
  
  public void a(List<?> paramList, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    int j = paramList.size();
    if (j == 0) {}
    for (;;)
    {
      return;
      rx localrx = this.c;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramList.get(i);
        if (localObject == null) {}
        try
        {
          paramru.a(paramor);
        }
        catch (Exception localException)
        {
          a(paramru, localException, paramList, i);
        }
        if (localrx == null) {
          paramra.a(localObject, paramor, paramru);
        } else {
          paramra.a(localException, paramor, paramru, localrx);
        }
        i += 1;
      }
    }
  }
  
  public void b(List<?> paramList, or paramor, ru paramru)
    throws IOException, oq
  {
    int m = paramList.size();
    if (m == 0) {
      return;
    }
    int k = 0;
    int i = 0;
    int j = k;
    for (;;)
    {
      Class localClass;
      try
      {
        rx localrx = this.c;
        j = k;
        localObject1 = this.f;
        if (i >= m) {
          break;
        }
        j = i;
        Object localObject4 = paramList.get(i);
        if (localObject4 == null)
        {
          j = i;
          paramru.a(paramor);
        }
        else
        {
          j = i;
          localClass = localObject4.getClass();
          j = i;
          ra localra = ((aal)localObject1).a(localClass);
          Object localObject2 = localObject1;
          Object localObject3 = localra;
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
            j = i;
            ((ra)localObject3).a(localObject4, paramor, paramru, localrx);
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception paramor)
      {
        a(paramru, paramor, paramList, j);
        return;
      }
      j = i;
      Object localObject1 = a((aal)localObject1, localClass, paramru);
      continue;
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */