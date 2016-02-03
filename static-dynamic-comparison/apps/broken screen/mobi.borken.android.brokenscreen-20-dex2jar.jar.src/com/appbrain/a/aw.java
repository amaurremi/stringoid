package com.appbrain.a;

import android.view.View;
import android.view.animation.AlphaAnimation;

final class aw
  implements Runnable
{
  aw(av paramav) {}
  
  public final void run()
  {
    Object localObject = this.a.c.d;
    localObject = this.a.c.a;
    ax localax = new ax(this);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.startNow();
    localAlphaAnimation.setAnimationListener(localax);
    ((View)localObject).startAnimation(localAlphaAnimation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */