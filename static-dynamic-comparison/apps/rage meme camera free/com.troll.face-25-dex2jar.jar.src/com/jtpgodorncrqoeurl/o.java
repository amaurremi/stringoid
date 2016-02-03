package com.jtpgodorncrqoeurl;

import android.os.Handler;

final class o
  implements Runnable
{
  o(AdController paramAdController) {}
  
  public final void run()
  {
    try
    {
      if ((!AdController.y(this.a)) && (!AdController.d(this.a)))
      {
        AdLog.i("LBAdController", "onAdProgress triggered");
        AdController.z(this.a).onAdProgress();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */