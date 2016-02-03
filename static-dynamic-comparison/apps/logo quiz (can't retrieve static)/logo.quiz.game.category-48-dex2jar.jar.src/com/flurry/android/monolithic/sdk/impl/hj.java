package com.flurry.android.monolithic.sdk.impl;

class hj
  extends jf
{
  private fr b = null;
  
  public hj(hi paramhi, fr paramfr)
  {
    this.b = paramfr;
  }
  
  public void a()
  {
    Object localObject = hi.a(this.a).a();
    localObject = hi.b(this.a).a((hm)localObject);
    hi.a(this.a).b();
    switch (((hn)localObject).a)
    {
    default: 
      ja.a(6, "CachingManager", "ERROR! UNKNOWN RESPONSE CODE!");
    }
    for (;;)
    {
      try
      {
        this.b.a(((hn)localObject).b);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ja.a(4, "CachingManager", "OPERATION_STATUS_SUCCEEDED");
      continue;
      ja.a(5, "CachingManager", "OPERATION_STATUS_TIME_OUT");
      continue;
      ja.a(5, "CachingManager", "OPERATION_STATUS_FAILED");
      continue;
      ja.a(5, "CachingManager", "OPERATION_STATUS_BAD_RESPONSE");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */