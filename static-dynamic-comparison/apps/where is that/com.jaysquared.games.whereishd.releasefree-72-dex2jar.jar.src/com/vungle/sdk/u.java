package com.vungle.sdk;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class u
  implements Animation.AnimationListener
{
  u(VungleAdvert paramVungleAdvert) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.a != null) && (VungleAdvert.c(this.a)) && (VungleAdvert.d(this.a))) {
      this.a.a.b();
    }
    if (this.a.b != null) {
      this.a.b.c();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */