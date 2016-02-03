package com.flurry.android.monolithic.sdk.impl;

class ep
  implements Runnable
{
  ep(em paramem, byte[] paramArrayOfByte, String paramString1, String paramString2) {}
  
  public void run()
  {
    em.a(this.d);
    try
    {
      this.d.b(this.a, this.b, this.c);
      return;
    }
    catch (Exception localException)
    {
      ja.a(6, em.d(), "storeData error", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */