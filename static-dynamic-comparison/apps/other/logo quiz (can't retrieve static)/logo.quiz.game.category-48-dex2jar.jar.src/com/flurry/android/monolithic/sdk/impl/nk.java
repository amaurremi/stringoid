package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class nk
{
  public mq a(ji paramji, Map<nm, mq> paramMap)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    switch (nl.a[paramji.a().ordinal()])
    {
    default: 
      throw new RuntimeException("Unexpected schema type");
    case 1: 
      localObject1 = mq.c;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      do
      {
        return (mq)localObject1;
        return mq.d;
        return mq.e;
        return mq.f;
        return mq.g;
        return mq.h;
        return mq.i;
        return mq.j;
        return mq.b(new mq[] { new mz(paramji.l()), mq.k });
        return mq.b(new mq[] { new mz(paramji.c().size()), mq.l });
        return mq.b(new mq[] { mq.a(mq.o, new mq[] { a(paramji.i(), paramMap) }), mq.n });
        return mq.b(new mq[] { mq.a(mq.q, new mq[] { a(paramji.j(), paramMap), mq.i }), mq.p });
        localObject3 = new nm(paramji);
        localObject2 = (mq)paramMap.get(localObject3);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = new mq[paramji.b().size()];
      localObject2 = mq.b((mq[])localObject1);
      paramMap.put(localObject3, localObject2);
      i = localObject1.length;
      paramji = paramji.b().iterator();
    }
    while (paramji.hasNext())
    {
      localObject3 = (js)paramji.next();
      i -= 1;
      localObject1[i] = a(((js)localObject3).c(), paramMap);
      continue;
      localObject2 = paramji.k();
      localObject1 = new mq[((List)localObject2).size()];
      localObject2 = new String[((List)localObject2).size()];
      paramji = paramji.k().iterator();
      i = 0;
      while (paramji.hasNext())
      {
        localObject3 = (ji)paramji.next();
        localObject1[i] = a((ji)localObject3, paramMap);
        localObject2[i] = ((ji)localObject3).g();
        i += 1;
      }
      return mq.b(new mq[] { mq.a((mq[])localObject1, (String[])localObject2), mq.m });
    }
    return (mq)localObject2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */