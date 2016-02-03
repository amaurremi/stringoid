package com.flurry.android;

final class ad
  implements Runnable
{
  ad(u paramu, int paramInt) {}
  
  public final void run()
  {
    CallbackEvent localCallbackEvent = new CallbackEvent(this.a);
    u.a(this.b).onAdsUpdated(localCallbackEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */