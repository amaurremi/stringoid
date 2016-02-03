package com.a.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.ref.WeakReference;

class i
  extends c
{
  private final WeakReference a;
  
  i(View paramView)
  {
    this.a = new WeakReference(paramView.animate());
  }
  
  public c a(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleX(paramFloat);
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
  
  public void a()
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.start();
    }
  }
  
  public c b(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.scaleY(paramFloat);
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */