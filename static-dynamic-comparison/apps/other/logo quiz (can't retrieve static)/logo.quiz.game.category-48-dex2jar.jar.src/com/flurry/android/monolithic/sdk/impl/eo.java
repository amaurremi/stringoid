package com.flurry.android.monolithic.sdk.impl;

class eo
  implements Runnable
{
  eo(em paramem, eu parameu) {}
  
  public void run()
  {
    em.a(this.b);
    try
    {
      em.b(this.b);
      if (this.a != null) {
        this.a.a();
      }
      return;
    }
    catch (Exception localException)
    {
      ja.a(6, em.d(), "retransmitNotSentBlocks error", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */