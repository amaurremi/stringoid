package com.ideashower.readitlater.views;

import android.view.MotionEvent;

public abstract class ay
{
  private long a;
  private boolean b;
  private boolean c;
  
  public void a()
  {
    this.a += 1L;
    this.b = false;
    this.c = false;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    String str;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      str = "touchstart";
      a();
    }
    for (;;)
    {
      a(str, this.a, paramMotionEvent.getX(), paramMotionEvent.getY());
      return;
      if ((this.c) && (this.b)) {
        break;
      }
      this.b = true;
      str = "touchmove";
      continue;
      str = "touchend";
      continue;
      str = "touchcancel";
    }
  }
  
  public abstract void a(String paramString, long paramLong, float paramFloat1, float paramFloat2);
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */