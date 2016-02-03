package com.jtpgodorncrqoeurl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class m
  implements Animation.AnimationListener
{
  m(l paraml) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (AdController.p(this.a.a) != null)
    {
      AdController.a(this.a.a, AdController.p(this.a.a));
      return;
    }
    AdController.a(this.a.a, this.a.a.b);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */