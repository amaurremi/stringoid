package com.gau.go.launcherex.gowidget.weather.util;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class s
{
  public static Animation a(long paramLong)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    return localTranslateAnimation;
  }
  
  public static Animation a(long paramLong, float paramFloat)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, paramFloat, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static Animation a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);; localTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F))
    {
      localTranslateAnimation.setDuration(paramLong);
      return localTranslateAnimation;
    }
  }
  
  public static Animation b(long paramLong)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    return localTranslateAnimation;
  }
  
  public static Animation b(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);; localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F))
    {
      localTranslateAnimation.setDuration(paramLong);
      return localTranslateAnimation;
    }
  }
  
  public static Animation c(long paramLong)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(paramLong);
    return localAlphaAnimation;
  }
  
  public static Animation d(long paramLong)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramLong);
    return localAlphaAnimation;
  }
  
  public static Animation e(long paramLong)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.35F);
    ((TranslateAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static Animation f(long paramLong)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.5F);
    localScaleAnimation.setDuration(paramLong);
    return localScaleAnimation;
  }
  
  public static Animation g(long paramLong)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static Animation h(long paramLong)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.5F);
    localScaleAnimation.setDuration(paramLong);
    return localScaleAnimation;
  }
  
  public static Animation i(long paramLong)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static Animation j(long paramLong)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(0.3F, 1.0F, 0.3F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(paramLong);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */