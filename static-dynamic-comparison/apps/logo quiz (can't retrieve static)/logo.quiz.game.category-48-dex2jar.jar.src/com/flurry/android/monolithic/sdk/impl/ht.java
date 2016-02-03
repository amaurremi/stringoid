package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.appcloud.AppCloudModule;

class ht
{
  private ho a = new ho();
  private hu b = new hu();
  
  private boolean a()
  {
    return AppCloudModule.getInstance().d();
  }
  
  public hn a(hm paramhm)
  {
    long l = this.b.a(paramhm);
    if (l == -1L) {
      ja.a(4, "RetryManager", "timeToStart == OPERATION_DIDNT_PROCCEED_CODE");
    }
    for (;;)
    {
      return b(paramhm);
      try
      {
        Thread.sleep(l);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public hn b(hm paramhm)
  {
    paramhm.e();
    hn localhn;
    if (a())
    {
      localhn = this.a.a(paramhm);
      switch (localhn.a)
      {
      default: 
        ja.a(6, "RetryManager", "ERROR! UNKNOWN RESPONSE CODE!");
      }
    }
    do
    {
      return localhn;
      localhn = new hn();
      localhn.a = 711;
      localhn.b = new fq(null);
      break;
    } while (this.b.a(paramhm) == -1L);
    return a(paramhm);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */