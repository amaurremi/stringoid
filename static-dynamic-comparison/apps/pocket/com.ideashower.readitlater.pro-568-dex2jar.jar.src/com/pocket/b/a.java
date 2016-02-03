package com.pocket.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;

@TargetApi(11)
public abstract class a
  implements Animator.AnimatorListener
{
  private boolean a = false;
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */