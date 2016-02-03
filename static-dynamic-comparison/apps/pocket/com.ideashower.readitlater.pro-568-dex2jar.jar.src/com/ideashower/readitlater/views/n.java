package com.ideashower.readitlater.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.ideashower.readitlater.util.j;

public class n
{
  private boolean a = false;
  private final int b;
  private boolean c = false;
  private float d;
  private float e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private o i;
  private boolean j;
  private final int k;
  private final int l;
  
  public n(Context paramContext)
  {
    this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.k = j.a(15.0F);
    this.l = j.a(70.0F);
  }
  
  public void a(o paramo)
  {
    this.i = paramo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int n = 1;
    if ((paramMotionEvent == null) || (this.i == null) || (!this.i.as())) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    float f2;
    label204:
    boolean bool;
    label228:
    do
    {
      do
      {
        for (m = 0;; m = 0)
        {
          if (m == 0) {
            break label352;
          }
          paramMotionEvent.setAction(3);
          return false;
          this.a = false;
          this.c = false;
          if (!this.i.a(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            break;
          }
          this.g = true;
          this.f = true;
          this.d = paramMotionEvent.getX();
          this.e = paramMotionEvent.getY();
          this.j = false;
        }
        if (!this.j) {}
        this.j = true;
        f2 = paramMotionEvent.getX() - this.d;
      } while (Math.abs(f2) <= this.b);
      if ((this.f) && (this.a))
      {
        if (!this.h) {
          break label330;
        }
        f1 = this.k;
        if (Math.abs(f2) >= f1)
        {
          o localo = this.i;
          if (f2 >= 0.0F) {
            break label339;
          }
          bool = true;
          localo.h(bool);
          this.f = false;
        }
      }
    } while (!this.g);
    float f1 = (float)Math.abs(Math.atan2(paramMotionEvent.getY() - this.e, f2) * 180.0D / 3.141592653589793D);
    if (this.h)
    {
      m = 73;
      label288:
      if ((f1 >= m) && (f1 <= 180 - m)) {
        break label357;
      }
      this.a = true;
      this.c = true;
    }
    label330:
    label339:
    label352:
    label357:
    for (int m = n;; m = 0)
    {
      this.g = false;
      break;
      f1 = this.l;
      break label204;
      bool = false;
      break label228;
      m = 17;
      break label288;
      return this.c;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */