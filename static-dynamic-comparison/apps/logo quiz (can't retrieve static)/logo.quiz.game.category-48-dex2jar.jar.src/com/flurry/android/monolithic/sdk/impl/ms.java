package com.flurry.android.monolithic.sdk.impl;

import java.util.List;
import java.util.Map;

public class ms
  extends mq
{
  public final String[] A;
  public final mq[] z;
  
  private ms(mq[] paramArrayOfmq, String[] paramArrayOfString)
  {
    super(na.e);
    this.z = paramArrayOfmq;
    this.A = paramArrayOfString;
  }
  
  public mq a(int paramInt)
  {
    return this.z[paramInt];
  }
  
  public ms b(Map<ne, ne> paramMap, Map<ne, List<mx>> paramMap1)
  {
    mq[] arrayOfmq = new mq[this.z.length];
    int i = 0;
    while (i < arrayOfmq.length)
    {
      arrayOfmq[i] = this.z[i].a(paramMap, paramMap1);
      i += 1;
    }
    return new ms(arrayOfmq, this.A);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */