package com.pocket.list.widget.b.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class a
  implements Animation.AnimationListener, e
{
  protected static String a = "Animate";
  protected static boolean b = false;
  protected final c c;
  protected int d;
  protected int e;
  private Animation f;
  private Animation g;
  private boolean h = false;
  
  protected a(c paramc)
  {
    this.c = paramc;
    a();
  }
  
  private TranslateAnimation a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt1, paramInt2, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setAnimationListener(this);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setFillBefore(paramBoolean);
    localTranslateAnimation.setFillEnabled(paramBoolean);
    return localTranslateAnimation;
  }
  
  public static a a(c paramc)
  {
    if (com.ideashower.readitlater.util.a.f()) {
      return new b(paramc);
    }
    return new a(paramc);
  }
  
  private void e()
  {
    if (b) {
      com.ideashower.readitlater.util.e.c(a, "removeOffset");
    }
    d locald = this.c.getCellHolder();
    if ((locald != null) && (this.e != 0))
    {
      locald.offsetLeftAndRight(-this.e);
      this.e = 0;
    }
  }
  
  protected void a()
  {
    this.c.getCellHolder().setItemCellAnimationListener(this);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.f = a(0, paramInt, false);
    this.c.getCellHolder().startAnimation(this.f);
  }
  
  public void b()
  {
    if (b) {
      com.ideashower.readitlater.util.e.c(a, "close");
    }
    d locald = this.c.getCellHolder();
    locald.clearAnimation();
    this.g = a(this.d, 0, true);
    locald.startAnimation(this.g);
    e();
  }
  
  public void c()
  {
    if (b) {
      com.ideashower.readitlater.util.e.c(a, "forceClose");
    }
    this.h = true;
    if (this.f != null) {
      this.f.cancel();
    }
    if (this.g != null) {
      this.g.cancel();
    }
    e();
  }
  
  public void d()
  {
    if (b) {
      com.ideashower.readitlater.util.e.c(a, "onAnimationEnd");
    }
    if (this.h)
    {
      if (b) {
        com.ideashower.readitlater.util.e.c(a, "onAnimationEnd - already closed");
      }
      return;
    }
    if (this.g != null)
    {
      if (b) {
        com.ideashower.readitlater.util.e.c(a, "onAnimationEnd is closing");
      }
      this.c.d();
      return;
    }
    if (b) {
      com.ideashower.readitlater.util.e.c(a, "onAnimationEnd is opening");
    }
    d locald = this.c.getCellHolder();
    this.e = this.d;
    locald.offsetLeftAndRight(this.e);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.h) {
      paramAnimation.cancel();
    }
    while (paramAnimation != this.g) {
      return;
    }
    e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */