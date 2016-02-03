package com.pocket.list.widget.b.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.ideashower.readitlater.util.e;

@TargetApi(12)
public class b
  extends a
{
  private static int f = 250;
  private static int g = 249;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  protected b(c paramc)
  {
    super(paramc);
    if (f == g) {
      throw new RuntimeException("durations cannot be identical!");
    }
  }
  
  protected void a()
  {
    this.c.getCellHolder().animate().setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (a.b) {
          e.c(a.a, "onAnimationEnd");
        }
        if (b.a(b.this)) {
          if (a.b) {
            e.c(a.a, "onAnimationEnd - is finished!");
          }
        }
        do
        {
          return;
          if (paramAnonymousAnimator.getDuration() == b.e())
          {
            if (a.b) {
              e.c(a.a, "onAnimationEnd is opening");
            }
            b.this.c.e();
            return;
          }
          if (paramAnonymousAnimator.getDuration() == b.f())
          {
            if (a.b) {
              e.c(a.a, "onAnimationEnd is closing");
            }
            b.a(b.this, false);
            b.b(b.this, true);
            b.this.c.d();
            return;
          }
        } while (!a.b);
        e.c(a.a, "onAnimationEnd ??");
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (a.b) {
          e.c(a.a, "onAnimationStart");
        }
        if (b.a(b.this))
        {
          if (a.b) {
            e.c(a.a, "onAnimationStart - is finished, cancel");
          }
          paramAnonymousAnimator.cancel();
        }
      }
    });
  }
  
  public void a(final int paramInt)
  {
    if (b) {
      e.c(a, "open");
    }
    this.d = paramInt;
    final d locald = this.c.getCellHolder();
    locald.post(new Runnable()
    {
      public void run()
      {
        if (a.b) {
          e.c(a.a, "run open ani " + locald.getX() + " to " + paramInt);
        }
        if ((b.b(b.this)) || (b.a(b.this)))
        {
          if (a.b) {
            e.c(a.a, "run open cancel");
          }
          return;
        }
        b.c(b.this, true);
        locald.animate().setDuration(b.e()).x(paramInt);
      }
    });
  }
  
  public void b()
  {
    if (b) {
      e.c(a, "close");
    }
    d locald = this.c.getCellHolder();
    this.i = true;
    if (this.h)
    {
      if (b) {
        e.c(a, "close start");
      }
      locald.animate().setDuration(g).x(0.0F);
      return;
    }
    if (b) {
      e.c(a, "close skipped");
    }
    this.c.d();
  }
  
  public void c()
  {
    if (b) {
      e.c(a, "force close");
    }
    if (this.j) {
      if (b) {
        e.c(a, "force close already closed");
      }
    }
    d locald;
    do
    {
      return;
      this.j = true;
      locald = this.c.getCellHolder();
      if (this.i) {
        locald.clearAnimation();
      }
    } while (!this.h);
    if (b) {
      e.c(a, "force close set 0 " + locald.getX());
    }
    locald.setX(0.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */