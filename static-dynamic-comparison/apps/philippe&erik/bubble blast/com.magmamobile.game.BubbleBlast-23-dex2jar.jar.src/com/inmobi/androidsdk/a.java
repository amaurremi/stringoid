package com.inmobi.androidsdk;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.androidsdk.impl.anim.IMRotate3dAnimation;
import com.inmobi.androidsdk.impl.anim.IMRotate3dAnimationVert;

class a
{
  private IMAdView a;
  private Animation.AnimationListener b;
  
  public a(IMAdView paramIMAdView, Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramIMAdView;
    this.b = paramAnimationListener;
  }
  
  public void a(IMAdView.AnimationType paramAnimationType)
  {
    Object localObject;
    if (paramAnimationType == IMAdView.AnimationType.ANIMATION_ALPHA)
    {
      paramAnimationType = new AlphaAnimation(0.0F, 0.5F);
      localObject = new AlphaAnimation(0.5F, 1.0F);
      paramAnimationType.setDuration(1000L);
      paramAnimationType.setFillAfter(false);
      paramAnimationType.setAnimationListener(this.b);
      paramAnimationType.setInterpolator(new DecelerateInterpolator());
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(false);
      ((AlphaAnimation)localObject).setAnimationListener(this.b);
      ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator());
      this.a.a(paramAnimationType);
      this.a.b((Animation)localObject);
    }
    for (;;)
    {
      this.a.startAnimation(this.a.a());
      return;
      if (paramAnimationType == IMAdView.AnimationType.ROTATE_HORIZONTAL_AXIS)
      {
        paramAnimationType = new IMRotate3dAnimation(0.0F, 90.0F, this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F, 0.0F, true);
        localObject = new IMRotate3dAnimation(270.0F, 360.0F, this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F, 0.0F, true);
        paramAnimationType.setDuration(500L);
        paramAnimationType.setFillAfter(false);
        paramAnimationType.setAnimationListener(this.b);
        paramAnimationType.setInterpolator(new AccelerateInterpolator());
        ((IMRotate3dAnimation)localObject).setDuration(500L);
        ((IMRotate3dAnimation)localObject).setFillAfter(false);
        ((IMRotate3dAnimation)localObject).setAnimationListener(this.b);
        ((IMRotate3dAnimation)localObject).setInterpolator(new DecelerateInterpolator());
        this.a.a(paramAnimationType);
        this.a.b((Animation)localObject);
      }
      else if (paramAnimationType == IMAdView.AnimationType.ROTATE_VERTICAL_AXIS)
      {
        paramAnimationType = new IMRotate3dAnimationVert(0.0F, 90.0F, this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F, 0.0F, true);
        localObject = new IMRotate3dAnimationVert(270.0F, 360.0F, this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F, 0.0F, true);
        paramAnimationType.setDuration(500L);
        paramAnimationType.setFillAfter(false);
        paramAnimationType.setAnimationListener(this.b);
        paramAnimationType.setInterpolator(new AccelerateInterpolator());
        ((IMRotate3dAnimationVert)localObject).setDuration(500L);
        ((IMRotate3dAnimationVert)localObject).setFillAfter(false);
        ((IMRotate3dAnimationVert)localObject).setAnimationListener(this.b);
        ((IMRotate3dAnimationVert)localObject).setInterpolator(new DecelerateInterpolator());
        this.a.a(paramAnimationType);
        this.a.b((Animation)localObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */