package com.flurry.android;

final class ae
  implements Runnable
{
  ae(u paramu, String paramString) {}
  
  public final void run()
  {
    CallbackEvent localCallbackEvent = new CallbackEvent(101);
    localCallbackEvent.setMessage(this.a);
    if (u.a(this.b) != null) {
      u.a(this.b).onMarketAppLaunchError(localCallbackEvent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */