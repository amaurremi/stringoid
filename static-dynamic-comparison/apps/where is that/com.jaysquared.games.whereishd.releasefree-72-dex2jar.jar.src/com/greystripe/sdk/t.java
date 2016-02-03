package com.greystripe.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;

final class t
  implements Runnable
{
  t(s params) {}
  
  public final void run()
  {
    c.m(this.a.a);
    ViewGroup localViewGroup = (ViewGroup)c.a(this.a.a).getRootView().findViewById(16908290);
    s.a(this.a, localViewGroup.getChildAt(0));
    s.a(this.a, s.a(this.a).getLayoutParams());
    s.a(this.a, (z)c.a(this.a.a).getParent());
    if (s.b(this.a) == null)
    {
      s.a(this.a, null);
      s.a(this.a, null);
      return;
    }
    s.a(this.a, new FrameLayout(c.a(this.a.a).getContext()));
    int j = s.b(this.a).getChildCount();
    int i = 0;
    while ((i < j) && (s.b(this.a).getChildAt(i) != c.a(this.a.a))) {
      i += 1;
    }
    s.a(this.a, i);
    s.b(this.a).addView(s.c(this.a), s.d(this.a), new ViewGroup.LayoutParams(c.a(this.a.a).getWidth(), c.a(this.a.a).getHeight()));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, s.a(this.a).getWidth() / 2, 0, 0.0F, 0, s.a(this.a).getHeight() / 2, 0, 0.0F);
    localTranslateAnimation.setDuration(500L);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setFillBefore(false);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localViewGroup.removeViewAt(0);
    s.b(this.a).removeView(c.a(this.a.a));
    localViewGroup.addView(c.a(this.a.a), 0, localLayoutParams);
    c.a(this.a.a).startAnimation(localAnimationSet);
    c.b(this.a.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */