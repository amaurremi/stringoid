package com.bubble.keyboard.utils;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bubble.keyboard.R.anim;

public class Animations
{
  public static Animation animateZoomIn(View paramView, int paramInt, Activity paramActivity)
  {
    paramActivity = AnimationUtils.loadAnimation(paramActivity, R.anim.winner_animation);
    paramActivity.setStartOffset(paramInt);
    paramView.startAnimation(paramActivity);
    return paramActivity;
  }
  
  public static Animation shakeRotate(View paramView, int paramInt, Activity paramActivity)
  {
    paramActivity = AnimationUtils.loadAnimation(paramActivity, R.anim.shake_rotate);
    paramActivity.setStartOffset(paramInt);
    paramView.startAnimation(paramActivity);
    return paramActivity;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/utils/Animations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */