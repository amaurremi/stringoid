package com.skplanet.tad.common;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.skplanet.tad.AdView.AnimationType;

public class f
{
  private static Animation a(Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    return localAlphaAnimation;
  }
  
  public static Animation a(AdView.AnimationType paramAnimationType, Animation.AnimationListener paramAnimationListener)
  {
    switch (b()[paramAnimationType.ordinal()])
    {
    default: 
      paramAnimationType = a(paramAnimationListener);
    }
    for (;;)
    {
      if (paramAnimationType != null)
      {
        paramAnimationType.setFillEnabled(true);
        paramAnimationType.setFillAfter(false);
        paramAnimationType.setFillBefore(true);
      }
      return paramAnimationType;
      paramAnimationType = b(paramAnimationListener);
      continue;
      paramAnimationType = d(paramAnimationListener);
      continue;
      paramAnimationType = f(paramAnimationListener);
      continue;
      paramAnimationType = h(paramAnimationListener);
      continue;
      paramAnimationType = i(paramAnimationListener);
      continue;
      paramAnimationType = j(paramAnimationListener);
      continue;
      paramAnimationType = k(paramAnimationListener);
      continue;
      paramAnimationType = p(paramAnimationListener);
      paramAnimationType.setStartOffset(1000L);
      continue;
      paramAnimationType = r(paramAnimationListener);
      paramAnimationType.setStartOffset(1000L);
      continue;
      paramAnimationType = t(paramAnimationListener);
      paramAnimationType.setStartOffset(1000L);
      continue;
      paramAnimationType = v(paramAnimationListener);
      paramAnimationType.setStartOffset(1000L);
    }
  }
  
  public static Animation a(a parama, Animation.AnimationListener paramAnimationListener)
  {
    int i;
    switch (a()[parama.ordinal()])
    {
    case 4: 
    case 5: 
    default: 
      parama = a(paramAnimationListener);
      i = 0;
    }
    for (;;)
    {
      if ((parama != null) && (i != 0))
      {
        parama.setFillEnabled(true);
        parama.setFillAfter(true);
        parama.setFillBefore(false);
      }
      return parama;
      parama = b(paramAnimationListener);
      i = 0;
      continue;
      parama = c(paramAnimationListener);
      i = 1;
      continue;
      parama = h(paramAnimationListener);
      i = 0;
      continue;
      parama = i(paramAnimationListener);
      i = 0;
      continue;
      parama = j(paramAnimationListener);
      i = 0;
      continue;
      parama = k(paramAnimationListener);
      i = 0;
      continue;
      parama = l(paramAnimationListener);
      i = 1;
      continue;
      parama = m(paramAnimationListener);
      i = 1;
      continue;
      parama = n(paramAnimationListener);
      i = 1;
      continue;
      parama = o(paramAnimationListener);
      i = 1;
      continue;
      parama = p(paramAnimationListener);
      i = 0;
      continue;
      parama = r(paramAnimationListener);
      i = 0;
      continue;
      parama = q(paramAnimationListener);
      i = 1;
      continue;
      parama = s(paramAnimationListener);
      i = 1;
    }
  }
  
  private static Animation b(Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(2000L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    return localAlphaAnimation;
  }
  
  public static Animation b(AdView.AnimationType paramAnimationType, Animation.AnimationListener paramAnimationListener)
  {
    switch (b()[paramAnimationType.ordinal()])
    {
    default: 
      paramAnimationType = a(paramAnimationListener);
    }
    for (;;)
    {
      if (paramAnimationType != null)
      {
        paramAnimationType.setFillEnabled(true);
        paramAnimationType.setFillAfter(true);
        paramAnimationType.setFillBefore(false);
      }
      return paramAnimationType;
      paramAnimationType = c(paramAnimationListener);
      continue;
      paramAnimationType = e(paramAnimationListener);
      continue;
      paramAnimationType = g(paramAnimationListener);
      continue;
      paramAnimationType = l(paramAnimationListener);
      continue;
      paramAnimationType = m(paramAnimationListener);
      continue;
      paramAnimationType = n(paramAnimationListener);
      continue;
      paramAnimationType = o(paramAnimationListener);
      continue;
      paramAnimationType = q(paramAnimationListener);
      continue;
      paramAnimationType = s(paramAnimationListener);
      continue;
      paramAnimationType = u(paramAnimationListener);
      continue;
      paramAnimationType = w(paramAnimationListener);
    }
  }
  
  private static Animation c(Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(2000L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    return localAlphaAnimation;
  }
  
  private static Animation d(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new ScaleAnimation(1.5F, 1.0F, 1.5F, 1.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation e(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation f(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new RotateAnimation(0.0F, 1080.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation g(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.addAnimation(new RotateAnimation(0.0F, 1080.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation h(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F));
    localAnimationSet.setAnimationListener(paramAnimationListener);
    localAnimationSet.setDuration(2000L);
    return localAnimationSet;
  }
  
  private static Animation i(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation j(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation k(Animation.AnimationListener paramAnimationListener)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F));
    localAnimationSet.setDuration(2000L);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    return localAnimationSet;
  }
  
  private static Animation l(Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setAnimationListener(paramAnimationListener);
    return localTranslateAnimation;
  }
  
  private static Animation m(Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setAnimationListener(paramAnimationListener);
    return localTranslateAnimation;
  }
  
  private static Animation n(Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setAnimationListener(paramAnimationListener);
    return localTranslateAnimation;
  }
  
  private static Animation o(Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setAnimationListener(paramAnimationListener);
    return localTranslateAnimation;
  }
  
  private static Animation p(Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setAnimationListener(paramAnimationListener);
    return localScaleAnimation;
  }
  
  private static Animation q(Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setAnimationListener(paramAnimationListener);
    return localScaleAnimation;
  }
  
  private static Animation r(Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setAnimationListener(paramAnimationListener);
    return localScaleAnimation;
  }
  
  private static Animation s(Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(1000L);
    localScaleAnimation.setAnimationListener(paramAnimationListener);
    return localScaleAnimation;
  }
  
  private static Animation t(Animation.AnimationListener paramAnimationListener)
  {
    g localg = new g(270.0F, 360.0F, 0.0F, false, false);
    localg.setDuration(1000L);
    localg.setAnimationListener(paramAnimationListener);
    localg.setInterpolator(new DecelerateInterpolator());
    return localg;
  }
  
  private static Animation u(Animation.AnimationListener paramAnimationListener)
  {
    g localg = new g(0.0F, 90.0F, 0.0F, false, false);
    localg.setDuration(1000L);
    localg.setAnimationListener(paramAnimationListener);
    localg.setInterpolator(new AccelerateInterpolator());
    return localg;
  }
  
  private static Animation v(Animation.AnimationListener paramAnimationListener)
  {
    g localg = new g(270.0F, 360.0F, 0.0F, false, true);
    localg.setDuration(1000L);
    localg.setAnimationListener(paramAnimationListener);
    localg.setInterpolator(new DecelerateInterpolator());
    return localg;
  }
  
  private static Animation w(Animation.AnimationListener paramAnimationListener)
  {
    g localg = new g(0.0F, 90.0F, 0.0F, false, true);
    localg.setDuration(1000L);
    localg.setAnimationListener(paramAnimationListener);
    localg.setInterpolator(new AccelerateInterpolator());
    return localg;
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */