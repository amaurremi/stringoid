package com.bluebird.mobile.tools.animations;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ViewAnimator;

public class AnimationFactory
{
  public static void fadeIn(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.startAnimation(fadeInAnimation(500L, paramView));
  }
  
  public static Animation fadeInAnimation(long paramLong1, long paramLong2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong1);
    localAlphaAnimation.setStartOffset(paramLong2);
    return localAlphaAnimation;
  }
  
  public static Animation fadeInAnimation(long paramLong, View paramView)
  {
    Animation localAnimation = fadeInAnimation(500L, 0L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        this.val$view.setVisibility(0);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        this.val$view.setVisibility(8);
      }
    });
    return localAnimation;
  }
  
  public static void fadeInThenOut(View paramView, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    Animation[] arrayOfAnimation = fadeInThenOutAnimation(500L, paramLong);
    localAnimationSet.addAnimation(arrayOfAnimation[0]);
    localAnimationSet.addAnimation(arrayOfAnimation[1]);
    localAnimationSet.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        this.val$v.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        this.val$v.setVisibility(0);
      }
    });
    paramView.startAnimation(localAnimationSet);
  }
  
  public static Animation[] fadeInThenOutAnimation(long paramLong1, long paramLong2)
  {
    return new Animation[] { fadeInAnimation(paramLong1, 0L), fadeOutAnimation(paramLong1, paramLong1 + paramLong2) };
  }
  
  public static void fadeOut(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.startAnimation(fadeOutAnimation(500L, paramView));
  }
  
  public static Animation fadeOutAnimation(long paramLong1, long paramLong2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setStartOffset(paramLong2);
    localAlphaAnimation.setDuration(paramLong1);
    return localAlphaAnimation;
  }
  
  public static Animation fadeOutAnimation(long paramLong, View paramView)
  {
    Animation localAnimation = fadeOutAnimation(500L, 0L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        this.val$view.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        this.val$view.setVisibility(0);
      }
    });
    return localAnimation;
  }
  
  public static Animation[] flipAnimation(View paramView1, View paramView2, FlipDirection paramFlipDirection, long paramLong, Interpolator paramInterpolator)
  {
    float f1 = paramView1.getWidth() / 2.0F;
    float f2 = paramView1.getHeight() / 2.0F;
    FlipAnimation localFlipAnimation = new FlipAnimation(paramFlipDirection.getStartDegreeForFirstView(), paramFlipDirection.getEndDegreeForFirstView(), f1, f2, 0.75F, FlipAnimation.ScaleUpDownEnum.SCALE_DOWN);
    localFlipAnimation.setDuration(paramLong);
    localFlipAnimation.setFillAfter(true);
    if (paramInterpolator == null) {}
    for (paramView1 = new AccelerateInterpolator();; paramView1 = paramInterpolator)
    {
      localFlipAnimation.setInterpolator(paramView1);
      paramView2 = new AnimationSet(true);
      paramView2.addAnimation(localFlipAnimation);
      paramFlipDirection = new FlipAnimation(paramFlipDirection.getStartDegreeForSecondView(), paramFlipDirection.getEndDegreeForSecondView(), f1, f2, 0.75F, FlipAnimation.ScaleUpDownEnum.SCALE_UP);
      paramFlipDirection.setDuration(paramLong);
      paramFlipDirection.setFillAfter(true);
      paramView1 = paramInterpolator;
      if (paramInterpolator == null) {
        paramView1 = new AccelerateInterpolator();
      }
      paramFlipDirection.setInterpolator(paramView1);
      paramFlipDirection.setStartOffset(paramLong);
      paramView1 = new AnimationSet(true);
      paramView1.addAnimation(paramFlipDirection);
      return new Animation[] { paramView2, paramView1 };
    }
  }
  
  public static void flipTransition(ViewAnimator paramViewAnimator, FlipDirection paramFlipDirection)
  {
    View localView1 = paramViewAnimator.getCurrentView();
    int i = paramViewAnimator.getDisplayedChild();
    int j = (i + 1) % paramViewAnimator.getChildCount();
    View localView2 = paramViewAnimator.getChildAt(j);
    if (j < i) {
      paramFlipDirection = paramFlipDirection.theOtherDirection();
    }
    for (;;)
    {
      paramFlipDirection = flipAnimation(localView1, localView2, paramFlipDirection, 300L, null);
      paramViewAnimator.setOutAnimation(paramFlipDirection[0]);
      paramViewAnimator.setInAnimation(paramFlipDirection[1]);
      paramViewAnimator.showNext();
      return;
    }
  }
  
  public static Animation inFromLeftAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, -1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static Animation inFromRightAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static Animation inFromTopAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static Animation outToLeftAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static Animation outToRightAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static Animation outToTopAnimation(long paramLong, Interpolator paramInterpolator)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1.0F);
    localTranslateAnimation.setDuration(paramLong);
    Object localObject = paramInterpolator;
    if (paramInterpolator == null) {
      localObject = new AccelerateInterpolator();
    }
    localTranslateAnimation.setInterpolator((Interpolator)localObject);
    return localTranslateAnimation;
  }
  
  public static enum FlipDirection
  {
    LEFT_RIGHT,  RIGHT_LEFT;
    
    private FlipDirection() {}
    
    public float getEndDegreeForFirstView()
    {
      switch (AnimationFactory.4.$SwitchMap$com$bluebird$mobile$tools$animations$AnimationFactory$FlipDirection[ordinal()])
      {
      default: 
        return 0.0F;
      case 1: 
        return 90.0F;
      }
      return -90.0F;
    }
    
    public float getEndDegreeForSecondView()
    {
      return 0.0F;
    }
    
    public float getStartDegreeForFirstView()
    {
      return 0.0F;
    }
    
    public float getStartDegreeForSecondView()
    {
      switch (AnimationFactory.4.$SwitchMap$com$bluebird$mobile$tools$animations$AnimationFactory$FlipDirection[ordinal()])
      {
      default: 
        return 0.0F;
      case 1: 
        return -90.0F;
      }
      return 90.0F;
    }
    
    public FlipDirection theOtherDirection()
    {
      switch (AnimationFactory.4.$SwitchMap$com$bluebird$mobile$tools$animations$AnimationFactory$FlipDirection[ordinal()])
      {
      default: 
        return null;
      case 1: 
        return RIGHT_LEFT;
      }
      return LEFT_RIGHT;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/animations/AnimationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */