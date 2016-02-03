package com.ideashower.readitlater.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;

@TargetApi(14)
class am
  implements Animator.AnimatorListener
{
  private final int b;
  
  private am(al paramal, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = al.n(this.a);
    int i = this.b;
    paramAnimator[i] -= 1;
    if ((al.n(this.a)[this.b] <= 0) && (this.b == 2)) {
      al.c(this.a, true);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = al.n(this.a);
    int i = this.b;
    paramAnimator[i] += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */