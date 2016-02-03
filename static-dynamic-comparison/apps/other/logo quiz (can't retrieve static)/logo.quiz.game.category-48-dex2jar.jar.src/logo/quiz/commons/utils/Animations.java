package logo.quiz.commons.utils;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import logo.quiz.commons.R.anim;
import logo.quiz.commons.R.id;

public class Animations
{
  static boolean isPopUpOffAnimEnd = true;
  
  public static Animation animateZoomIn(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.winner_animation);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  public static Animation animateZoomIn(int paramInt1, int paramInt2, Activity paramActivity, int paramInt3)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, paramInt3);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  public static Animation animateZoomInAlpha(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.winner_animation_alpha);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  public static Animation darkScreen(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.dark_screen);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  public static Animation popUp(int paramInt1, int paramInt2, Activity paramActivity)
  {
    View localView = paramActivity.findViewById(paramInt1);
    localView.setVisibility(0);
    paramActivity = AnimationUtils.loadAnimation(paramActivity, R.anim.pop_up);
    paramActivity.setStartOffset(paramInt2);
    localView.startAnimation(paramActivity);
    return paramActivity;
  }
  
  public static Animation popUpHide(int paramInt, Activity paramActivity)
  {
    View localView = paramActivity.findViewById(R.id.popUp);
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, R.anim.pop_up_hide);
    if (isPopUpOffAnimEnd)
    {
      isPopUpOffAnimEnd = false;
      Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, R.anim.dark_screen_off);
      paramActivity.findViewById(R.id.popUpBg).startAnimation(localAnimation2);
      localAnimation1.setStartOffset(paramInt);
      localAnimation1.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          this.val$popUpView.setVisibility(8);
          Animations.isPopUpOffAnimEnd = true;
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      localView.startAnimation(localAnimation1);
    }
    return localAnimation1;
  }
  
  public static Animation rotate360(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.rotation360);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  public static Animation slideUp(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.slide_from_up);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/Animations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */