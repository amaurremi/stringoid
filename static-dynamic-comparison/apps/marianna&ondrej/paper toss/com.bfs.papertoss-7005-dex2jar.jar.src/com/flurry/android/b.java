package com.flurry.android;

import android.content.Context;
import android.os.Handler;

final class b
  implements Runnable
{
  b(FlurryAgent paramFlurryAgent, boolean paramBoolean, Context paramContext) {}
  
  public final void run()
  {
    FlurryAgent.b(this.b);
    FlurryAgent.c(this.b);
    if (!this.c) {
      FlurryAgent.d(this.b).postDelayed(new l(this), FlurryAgent.g());
    }
    if (FlurryAgent.h()) {
      FlurryAgent.e(this.b).c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */