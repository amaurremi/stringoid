package com.jiubang.pla.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

final class c
  implements Runnable
{
  c(PLA_AbsListView paramPLA_AbsListView) {}
  
  public void run()
  {
    Object localObject;
    boolean bool;
    if (this.a.t == 0)
    {
      this.a.t = 1;
      localObject = this.a.getChildAt(this.a.o - this.a.B);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        this.a.a = 0;
        if (this.a.L) {
          break label178;
        }
        this.a.d();
        ((View)localObject).setPressed(true);
        this.a.a((View)localObject);
        this.a.setPressed(true);
        int i = ViewConfiguration.getLongPressTimeout();
        bool = this.a.isLongClickable();
        if (this.a.e != null)
        {
          localObject = this.a.e.getCurrent();
          if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label159;
            }
            ((TransitionDrawable)localObject).startTransition(i);
          }
        }
      }
    }
    while (bool)
    {
      return;
      label159:
      ((TransitionDrawable)localObject).resetTransition();
    }
    this.a.t = 2;
    return;
    label178:
    this.a.t = 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */