package com.pocket.widget.premium;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;

@TargetApi(14)
public class c
  implements Animator.AnimatorListener
{
  private int a;
  private final d b;
  
  protected c(d paramd)
  {
    this.b = paramd;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a -= 1;
    if (this.a <= 0) {
      this.b.a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */