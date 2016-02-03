package com.bluebird.mobile.tools.animations;

import android.view.View;
import android.view.animation.Animation;

public class InvisibleViewOnEndAnimationListener
  extends BasicAnimationListener
{
  private View view;
  
  public InvisibleViewOnEndAnimationListener(View paramView)
  {
    this.view = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.view.setVisibility(4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/animations/InvisibleViewOnEndAnimationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */