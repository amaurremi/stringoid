package com.magmamobile.game.engine;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public final class AnimationUtils
{
  public static final Animation createAnimationLeftIn(int paramInt)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    ((Animation)localObject).setStartOffset(0L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static final Animation createAnimationLeftOut(int paramInt)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, -2.0F, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    ((Animation)localObject).setStartOffset(0L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(true);
    return localAnimationSet;
  }
  
  public static final Animation createAnimationRightIn(int paramInt)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, -2.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    ((Animation)localObject).setStartOffset(0L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static final Animation createAnimationRightOut(int paramInt)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(paramInt);
    ((Animation)localObject).setStartOffset(0L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(true);
    return localAnimationSet;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */