package com.greystripe.sdk;

import android.view.View;
import android.view.ViewGroup;

final class u
  implements Runnable
{
  u(s params) {}
  
  public final void run()
  {
    bd.b("collapsing!", new Object[0]);
    if (s.b(this.a) != null)
    {
      ViewGroup localViewGroup = (ViewGroup)c.a(this.a.a).getRootView().findViewById(16908290);
      localViewGroup.removeViewAt(0);
      s.b(this.a).removeView(s.c(this.a));
      s.b(this.a).addView(c.a(this.a.a), s.d(this.a));
      localViewGroup.addView(s.a(this.a), s.e(this.a));
      s.a(this.a, null);
      s.a(this.a, null);
      c.b(this.a.a, false);
      c.n(this.a.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */