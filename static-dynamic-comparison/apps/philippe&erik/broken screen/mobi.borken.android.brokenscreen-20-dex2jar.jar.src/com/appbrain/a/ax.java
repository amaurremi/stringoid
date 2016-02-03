package com.appbrain.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;

final class ax
  implements Animation.AnimationListener
{
  ax(aw paramaw) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.c.a.setText(this.a.a.b);
    this.a.a.c.c.removeView(this.a.a.c.a);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */