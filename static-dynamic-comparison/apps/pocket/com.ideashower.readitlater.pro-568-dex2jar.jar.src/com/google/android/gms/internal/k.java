package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class k
  extends Drawable
  implements Drawable.Callback
{
  private int a = 0;
  private long b;
  private int c;
  private int d;
  private int e = 255;
  private int f;
  private int g = 0;
  private boolean h = true;
  private boolean i;
  private n j;
  private Drawable k;
  private Drawable l;
  private boolean m;
  private boolean n;
  private boolean o;
  private int p;
  
  public k(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = l.a();
    }
    this.k = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.j;
    paramDrawable1.b |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = l.a();
    }
    this.l = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.j;
    paramDrawable2.b |= paramDrawable1.getChangingConfigurations();
  }
  
  k(n paramn)
  {
    this.j = new n(paramn);
  }
  
  public void a(int paramInt)
  {
    this.c = 0;
    this.d = this.e;
    this.g = 0;
    this.f = paramInt;
    this.a = 1;
    invalidateSelf();
  }
  
  public boolean a()
  {
    if (!this.m) {
      if ((this.k.getConstantState() == null) || (this.l.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.n = bool;
      this.m = true;
      return this.n;
    }
  }
  
  public Drawable b()
  {
    return this.l;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i2 = 1;
    int i1 = 1;
    int i3 = 0;
    switch (this.a)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        i2 = this.g;
        bool = this.h;
        localDrawable1 = this.k;
        localDrawable2 = this.l;
        if (i1 == 0) {
          break;
        }
        if ((!bool) || (i2 == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (i2 == this.e)
        {
          localDrawable2.setAlpha(this.e);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.b = SystemClock.uptimeMillis();
        this.a = 2;
        i1 = i3;
      }
    } while (this.b < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.b) / this.f;
    if (f1 >= 1.0F) {}
    for (i1 = i2;; i1 = 0)
    {
      if (i1 != 0) {
        this.a = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.c;
      this.g = ((int)(f1 * (this.d - this.c) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.e - i2);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.e);
    }
    if (i2 > 0)
    {
      localDrawable2.setAlpha(i2);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.e);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.j.a | this.j.b;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (a())
    {
      this.j.a = getChangingConfigurations();
      return this.j;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.k.getIntrinsicHeight(), this.l.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.k.getIntrinsicWidth(), this.l.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.o)
    {
      this.p = Drawable.resolveOpacity(this.k.getOpacity(), this.l.getOpacity());
      this.o = true;
    }
    return this.p;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (bd.a())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.i) && (super.mutate() == this))
    {
      if (!a()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.k.mutate();
      this.l.mutate();
      this.i = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.k.setBounds(paramRect);
    this.l.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (bd.a())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.g == this.e) {
      this.g = paramInt;
    }
    this.e = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.k.setColorFilter(paramColorFilter);
    this.l.setColorFilter(paramColorFilter);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (bd.a())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */