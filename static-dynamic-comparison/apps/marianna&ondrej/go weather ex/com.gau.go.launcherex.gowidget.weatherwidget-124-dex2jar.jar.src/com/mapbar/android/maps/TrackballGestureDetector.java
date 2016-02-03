package com.mapbar.android.maps;

import android.os.Handler;
import android.view.MotionEvent;

public class TrackballGestureDetector
{
  private Handler a;
  private Runnable b;
  private Runnable c;
  private boolean d;
  private boolean e;
  private boolean f;
  private float g;
  private float h;
  private boolean i;
  private boolean j;
  private float k;
  private float l;
  private float m;
  private float n;
  private long o;
  private long p;
  private float q;
  private float r;
  
  TrackballGestureDetector(Handler paramHandler)
  {
    this.a = paramHandler;
    this.c = new Runnable()
    {
      public void run()
      {
        TrackballGestureDetector.this.dispatchLongPress();
      }
    };
  }
  
  private void dispatchLongPress()
  {
    this.j = true;
    if (this.b != null) {
      this.b.run();
    }
  }
  
  public void analyze(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    this.d = false;
    this.e = false;
    this.f = false;
    switch (i1)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        this.r = f2;
        this.q = f1;
        this.m = this.k;
        this.n = this.l;
        this.k = f2;
        this.l = f1;
        this.p = this.o;
        this.o = paramMotionEvent.getDownTime();
        this.i = true;
        this.j = false;
        this.a.removeCallbacks(this.c);
        this.a.postAtTime(this.c, this.o + 1500L);
        return;
      } while (this.j);
      this.g = (this.r - f2);
      this.h = (this.q - f1);
      this.r = f2;
      this.q = f1;
      if ((int)(Math.abs(f2 - this.k) + Math.abs(f1 - this.l)) > 5)
      {
        this.i = false;
        this.a.removeCallbacks(this.c);
      }
      this.d = true;
      return;
    }
    if (this.j)
    {
      this.j = false;
      return;
    }
    long l1;
    if (this.i)
    {
      l1 = paramMotionEvent.getEventTime();
      if (l1 - this.p >= 600L) {
        break label295;
      }
      this.f = true;
    }
    for (;;)
    {
      this.a.removeCallbacks(this.c);
      return;
      label295:
      if (l1 - this.o < 300L) {
        this.e = true;
      }
    }
  }
  
  public float getCurrentDownX()
  {
    return this.k;
  }
  
  public float getCurrentDownY()
  {
    return this.l;
  }
  
  public float getFirstDownX()
  {
    return this.m;
  }
  
  public float getFirstDownY()
  {
    return this.n;
  }
  
  public boolean isDoubleTap()
  {
    return this.f;
  }
  
  public boolean isScroll()
  {
    return this.d;
  }
  
  public boolean isTap()
  {
    return this.e;
  }
  
  public void registerLongPressCallback(Runnable paramRunnable)
  {
    this.b = paramRunnable;
  }
  
  public float scrollX()
  {
    return this.g;
  }
  
  public float scrollY()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/TrackballGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */