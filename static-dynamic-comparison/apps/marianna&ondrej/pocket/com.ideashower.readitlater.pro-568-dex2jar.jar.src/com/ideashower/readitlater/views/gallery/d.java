package com.ideashower.readitlater.views.gallery;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d
  implements View.OnTouchListener
{
  float a = 1.0F;
  private final PointF c = new PointF();
  private final f d = new f();
  private g e = this.d.a();
  private boolean f = false;
  
  private d(c paramc) {}
  
  private float a(l paraml)
  {
    float f1 = paraml.a(0) - paraml.a(1);
    float f2 = paraml.b(0) - paraml.b(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a(PointF paramPointF, l paraml)
  {
    float f1 = paraml.a(0);
    float f2 = paraml.a(1);
    float f3 = paraml.b(0);
    float f4 = paraml.b(1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    paramView = l.a(paramMotionEvent);
    if ((c.a(this.b) == -1) && (paramView.a() != 0)) {
      return true;
    }
    switch (paramView.a() & 0xFF)
    {
    }
    for (;;)
    {
      c.c(this.b);
      this.b.setImageMatrix(this.b.a);
      return true;
      this.d.a(this.b.a);
      this.e = this.d.a();
      if (this.e.c == this.b.d) {
        bool = true;
      }
      this.f = bool;
      this.c.set(paramView.b(), paramView.c());
      c.a(this.b, 1);
      continue;
      this.a = a(paramView);
      if (this.a > 10.0F)
      {
        this.d.a(this.b.a);
        a(this.b.e, paramView);
        c.a(this.b, 2);
        continue;
        int i = (int)Math.abs(paramView.b() - this.c.x);
        int j = (int)Math.abs(paramView.c() - this.c.y);
        if ((i < 8) && (j < 8)) {
          this.b.performClick();
        }
        c.a(this.b, 0);
        c.b(this.b);
        continue;
        float f1;
        if (c.a(this.b) == 1)
        {
          this.b.a.a(this.d);
          paramMotionEvent = this.b.a;
          float f2 = paramView.b();
          float f3 = this.c.x;
          if (this.f) {}
          for (f1 = 0.0F;; f1 = paramView.c() - this.c.y)
          {
            paramMotionEvent.postTranslate(f2 - f3, f1);
            break;
          }
        }
        if (c.a(this.b) == 2)
        {
          f1 = a(paramView);
          if (f1 > 10.0F)
          {
            this.b.a.a(this.d);
            f1 /= this.a;
            this.b.a.postScale(f1, f1, this.b.e.x, this.b.e.y);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */