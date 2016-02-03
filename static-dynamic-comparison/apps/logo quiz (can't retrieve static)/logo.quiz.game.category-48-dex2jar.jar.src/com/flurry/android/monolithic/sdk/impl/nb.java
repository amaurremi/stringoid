package com.flurry.android.monolithic.sdk.impl;

import java.util.List;
import java.util.Map;

public class nb
  extends mq
{
  public final mq z;
  
  private nb(mq parammq, mq... paramVarArgs)
  {
    super(na.d, c(paramVarArgs));
    this.z = parammq;
    this.b[0] = this;
  }
  
  private static mq[] c(mq[] paramArrayOfmq)
  {
    mq[] arrayOfmq = new mq[paramArrayOfmq.length + 1];
    System.arraycopy(paramArrayOfmq, 0, arrayOfmq, 1, paramArrayOfmq.length);
    return arrayOfmq;
  }
  
  public nb b(Map<ne, ne> paramMap, Map<ne, List<mx>> paramMap1)
  {
    nb localnb = new nb(this.z, new mq[a(this.b, 1)]);
    a(this.b, 1, localnb.b, 1, paramMap, paramMap1);
    return localnb;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */