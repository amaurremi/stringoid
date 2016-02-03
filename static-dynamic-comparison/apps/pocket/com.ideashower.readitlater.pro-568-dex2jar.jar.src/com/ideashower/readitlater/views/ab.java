package com.ideashower.readitlater.views;

import android.view.MotionEvent;
import com.ideashower.readitlater.util.a;

public class ab
{
  protected ac a;
  private final int b = -1;
  private final int c = 0;
  private final int d;
  private final BaseWebView e;
  private int f;
  private boolean g;
  private int h;
  private final int i;
  private int j;
  private boolean k;
  private int l;
  private float m;
  
  public ab(BaseWebView paramBaseWebView, int paramInt)
  {
    if (a.h()) {}
    for (int n = 3;; n = 2)
    {
      this.d = n;
      this.f = -1;
      this.h = 0;
      this.k = false;
      this.e = paramBaseWebView;
      this.i = paramInt;
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (this.a != null) {
      return this.a.a(paramInt, this.g);
    }
    return false;
  }
  
  public void a()
  {
    if (this.f == -1) {}
    do
    {
      do
      {
        return;
        if (!this.g) {
          break;
        }
      } while (this.f <= 0);
      this.f = 0;
      if (this.f < this.d - 1)
      {
        this.f += 1;
        this.e.invalidate();
        return;
      }
      if (this.f == this.d - 1)
      {
        this.f += 1;
        this.e.postInvalidate();
        return;
      }
      this.f = -1;
    } while (this.a == null);
    this.a.b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.f == -1)
    {
      this.j = paramInt4;
      this.h = 0;
      if (this.a != null) {
        this.a.a();
      }
    }
    this.f = 0;
    paramInt1 = Integer.signum(paramInt2 - paramInt4);
    if ((paramInt1 != 0) && (this.h != paramInt1))
    {
      if (Math.abs(paramInt2 - this.j) > this.i)
      {
        if (a(paramInt1)) {
          this.h = paramInt1;
        }
        this.j = paramInt2;
      }
      return;
    }
    this.j = paramInt2;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        float f1;
        do
        {
          do
          {
            return;
            this.g = true;
            this.m = paramMotionEvent.getY();
            int n = this.e.getScrollY();
            if (n <= 0)
            {
              this.l = -1;
              return;
            }
            if (n >= this.e.getMaxContentScrollY())
            {
              this.l = 1;
              return;
            }
            this.l = 0;
            return;
            this.g = true;
          } while ((this.l == 0) || (this.k));
          f1 = this.m - paramMotionEvent.getY();
        } while ((Math.abs(f1) <= this.i) || (Integer.signum((int)f1) != this.l));
        this.k = true;
      } while (this.a == null);
      this.a.a(this.l);
      return;
      this.g = false;
      this.l = 0;
      this.k = false;
    } while (this.f == -1);
    this.e.invalidate();
  }
  
  public void a(ac paramac)
  {
    this.a = paramac;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean c()
  {
    return (!this.g) && (this.f != -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */