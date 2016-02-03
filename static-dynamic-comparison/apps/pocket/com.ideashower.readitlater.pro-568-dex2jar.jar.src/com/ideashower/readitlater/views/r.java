package com.ideashower.readitlater.views;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.ideashower.readitlater.views.gallery.f;
import com.ideashower.readitlater.views.gallery.g;

class r
  implements View.OnTouchListener
{
  protected final PointF a = new PointF();
  private PointF c = new PointF();
  private float d = 1.0F;
  private f e = new f();
  private g f = this.e.a();
  private boolean g = false;
  
  private r(q paramq) {}
  
  private float a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((q.a(this.b) == -1) && (paramMotionEvent.getAction() != 0)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    float f1;
    label422:
    label577:
    do
    {
      do
      {
        float f3;
        for (;;)
        {
          this.b.setImageMatrix(this.b.a);
          return true;
          this.g = false;
          this.e.a(this.b.a);
          this.f = this.e.a();
          this.c.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          q.a(this.b, 1);
          continue;
          this.d = a(paramMotionEvent);
          if (this.d > 10.0F)
          {
            this.e.a(this.b.a);
            f1 = paramMotionEvent.getX(0);
            f2 = paramMotionEvent.getX(1);
            f3 = paramMotionEvent.getY(0);
            float f4 = paramMotionEvent.getY(1);
            this.a.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
            q.a(this.b, 2);
            continue;
            int i = (int)Math.abs(paramMotionEvent.getX() - this.c.x);
            int j = (int)Math.abs(paramMotionEvent.getY() - this.c.y);
            if ((i < q.b(this.b)) && (j < q.b(this.b))) {
              this.b.performClick();
            }
            q.a(this.b, 0);
            if (this.g)
            {
              this.b.b();
              this.g = false;
            }
          }
        }
        if (q.a(this.b) == 1)
        {
          this.b.a.a(this.e);
          f1 = paramMotionEvent.getX() - this.c.x;
          f2 = this.f.a + f1;
          if (f2 > this.b.e.left)
          {
            f1 = this.b.e.left - this.f.a;
            f2 = paramMotionEvent.getY() - this.c.y;
            f3 = this.f.b + f2;
            if (f3 <= this.b.e.top) {
              break label577;
            }
            f2 = this.b.e.top - this.f.b;
          }
          for (;;)
          {
            this.b.a.postTranslate(f1, f2);
            if ((f1 == 0.0F) && (f2 == 0.0F)) {
              break;
            }
            this.g = true;
            break;
            if (f2 + this.f.d >= this.b.e.right) {
              break label422;
            }
            f1 = this.b.e.right - (this.f.a + this.f.d);
            break label422;
            if (f3 + this.f.e < this.b.e.bottom) {
              f2 = this.b.e.bottom - (this.f.b + this.f.e);
            }
          }
        }
      } while (q.a(this.b) != 2);
      f1 = a(paramMotionEvent);
    } while (f1 <= 10.0F);
    this.b.a.a(this.e);
    f1 /= this.d;
    float f2 = this.f.c * f1;
    if (f2 > q.c(this.b)) {
      f1 = q.c(this.b) / this.f.c;
    }
    for (;;)
    {
      this.b.a.postScale(f1, f1, this.a.x, this.a.y);
      q.e(this.b);
      if (f1 == 0.0F) {
        break;
      }
      this.g = true;
      break;
      if (f2 < q.d(this.b)) {
        f1 = q.d(this.b) / this.f.c;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */