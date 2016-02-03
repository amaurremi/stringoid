package com.b.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.b.a.b;
import java.lang.ref.WeakReference;

class h
  extends c
{
  private final WeakReference a;
  
  h(View paramView)
  {
    this.a = new WeakReference(paramView.animate());
  }
  
  public c a(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.x(paramFloat);
    }
    return this;
  }
  
  public c a(long paramLong)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setDuration(paramLong);
    }
    return this;
  }
  
  public c a(Interpolator paramInterpolator)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public c a(final b paramb)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
    {
      if (paramb == null) {
        localViewPropertyAnimator.setListener(null);
      }
    }
    else {
      return this;
    }
    localViewPropertyAnimator.setListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramb.d(null);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramb.a(null);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        paramb.c(null);
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramb.b(null);
      }
    });
    return this;
  }
  
  public void a()
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public c b(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.xBy(paramFloat);
    }
    return this;
  }
  
  public c b(long paramLong)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setStartDelay(paramLong);
    }
    return this;
  }
  
  public c c(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.y(paramFloat);
    }
    return this;
  }
  
  public c d(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.yBy(paramFloat);
    }
    return this;
  }
  
  public c e(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationX(paramFloat);
    }
    return this;
  }
  
  public c f(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationY(paramFloat);
    }
    return this;
  }
  
  public c g(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleX(paramFloat);
    }
    return this;
  }
  
  public c h(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleXBy(paramFloat);
    }
    return this;
  }
  
  public c i(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleY(paramFloat);
    }
    return this;
  }
  
  public c j(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleYBy(paramFloat);
    }
    return this;
  }
  
  public c k(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.alpha(paramFloat);
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */