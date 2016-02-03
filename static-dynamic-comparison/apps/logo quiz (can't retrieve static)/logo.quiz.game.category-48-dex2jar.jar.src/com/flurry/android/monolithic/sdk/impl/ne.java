package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ne
  extends mq
  implements Iterable<mq>
{
  private ne(mq[] paramArrayOfmq)
  {
    super(na.c, paramArrayOfmq);
  }
  
  public final int a()
  {
    return a(this.b, 0);
  }
  
  public ne b(Map<ne, ne> paramMap, Map<ne, List<mx>> paramMap1)
  {
    Object localObject2 = (ne)paramMap.get(this);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ne(new mq[a()]);
      paramMap.put(this, localObject1);
      localObject2 = new ArrayList();
      paramMap1.put(localObject1, localObject2);
      a(this.b, 0, ((ne)localObject1).b, 0, paramMap, paramMap1);
      paramMap = ((List)localObject2).iterator();
      while (paramMap.hasNext())
      {
        localObject2 = (mx)paramMap.next();
        System.arraycopy(((ne)localObject1).b, 0, ((mx)localObject2).a, ((mx)localObject2).b, ((ne)localObject1).b.length);
      }
      paramMap1.remove(localObject1);
    }
    return (ne)localObject1;
  }
  
  public Iterator<mq> iterator()
  {
    return new nf(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */