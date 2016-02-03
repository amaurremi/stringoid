package uk.co.senab.photoview.a;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a
  implements e
{
  protected f a;
  float b;
  float c;
  final float d;
  final float e;
  private VelocityTracker f;
  private boolean g;
  
  public a(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.e = paramContext.getScaledMinimumFlingVelocity();
    this.d = paramContext.getScaledTouchSlop();
  }
  
  float a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getX();
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public boolean a()
  {
    return false;
  }
  
  float b(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getY();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          float f3;
          float f4;
          do
          {
            return true;
            this.f = VelocityTracker.obtain();
            if (this.f != null) {
              this.f.addMovement(paramMotionEvent);
            }
            for (;;)
            {
              this.b = a(paramMotionEvent);
              this.c = b(paramMotionEvent);
              this.g = false;
              return true;
              Log.i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            f1 = a(paramMotionEvent);
            f2 = b(paramMotionEvent);
            f3 = f1 - this.b;
            f4 = f2 - this.c;
            if (!this.g)
            {
              if (FloatMath.sqrt(f3 * f3 + f4 * f4) >= this.d) {
                bool = true;
              }
              this.g = bool;
            }
          } while (!this.g);
          this.a.a(f3, f4);
          this.b = f1;
          this.c = f2;
        } while (this.f == null);
        this.f.addMovement(paramMotionEvent);
        return true;
      } while (this.f == null);
      this.f.recycle();
      this.f = null;
      return true;
      if ((this.g) && (this.f != null))
      {
        this.b = a(paramMotionEvent);
        this.c = b(paramMotionEvent);
        this.f.addMovement(paramMotionEvent);
        this.f.computeCurrentVelocity(1000);
        f1 = this.f.getXVelocity();
        f2 = this.f.getYVelocity();
        if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.e) {
          this.a.a(this.b, this.c, -f1, -f2);
        }
      }
    } while (this.f == null);
    this.f.recycle();
    this.f = null;
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */