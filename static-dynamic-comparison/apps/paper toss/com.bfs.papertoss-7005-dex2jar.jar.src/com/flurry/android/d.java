package com.flurry.android;

import android.content.Context;

final class d
  implements Runnable
{
  d(FlurryAgent paramFlurryAgent, Context paramContext, boolean paramBoolean) {}
  
  public final void run()
  {
    if (!FlurryAgent.a(this.c)) {
      FlurryAgent.a(this.c, this.a);
    }
    FlurryAgent.a(this.c, this.a, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */