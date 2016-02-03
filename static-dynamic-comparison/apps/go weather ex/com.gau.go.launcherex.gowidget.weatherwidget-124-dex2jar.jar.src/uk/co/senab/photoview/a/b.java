package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
public class b
  extends a
{
  private int f = -1;
  private int g = 0;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(this.g);
      return f1;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getX();
  }
  
  float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getY(this.g);
      return f1;
    }
    catch (Exception localException) {}
    return paramMotionEvent.getY();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int j = 0;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      for (;;)
      {
        i = j;
        if (this.f != -1) {
          i = this.f;
        }
        this.g = paramMotionEvent.findPointerIndex(i);
        return super.c(paramMotionEvent);
        this.f = paramMotionEvent.getPointerId(0);
        continue;
        this.f = -1;
      }
      i = uk.co.senab.photoview.a.a(paramMotionEvent.getAction());
    } while (paramMotionEvent.getPointerId(i) != this.f);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      this.f = paramMotionEvent.getPointerId(i);
      this.b = paramMotionEvent.getX(i);
      this.c = paramMotionEvent.getY(i);
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */