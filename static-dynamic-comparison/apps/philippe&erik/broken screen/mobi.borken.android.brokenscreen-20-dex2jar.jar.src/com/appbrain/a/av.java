package com.appbrain.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

final class av
  implements Animation.AnimationListener
{
  av(au paramau, String paramString1, String paramString2) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.c.a.setText(this.a);
    this.c.a.postDelayed(new aw(this), 10000L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */