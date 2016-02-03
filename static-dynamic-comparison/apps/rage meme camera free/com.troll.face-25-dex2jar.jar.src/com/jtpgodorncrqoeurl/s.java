package com.jtpgodorncrqoeurl;

import android.os.Handler;

final class s
  implements Runnable
{
  s(AdController paramAdController) {}
  
  public final void run()
  {
    try
    {
      if ((!AdController.c(this.a)) && (!AdController.d(this.a)))
      {
        AdLog.i("LBAdController", "onAdProgress triggered");
        AdController.e(this.a).onAdProgress();
        AdController.h(this.a).postDelayed(AdController.f(this.a), AdController.g(this.a) * 1000);
      }
      return;
    }
    catch (Exception localException)
    {
      AdLog.e("LBAdController", "error when onAdProgress triggered");
      AdLog.printStackTrace("LBAdController", localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */