package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class gt
  extends Drawable
  implements Drawable.Callback
{
  private int FA;
  private int FB = 0;
  private boolean FC;
  private oo FD;
  private Drawable FE;
  private Drawable FF;
  private boolean FG;
  private boolean FH;
  private boolean FI;
  private int FJ;
  private boolean Fp = true;
  private int Fv = 0;
  private long Fw;
  private int Fx;
  private int Fy;
  private int Fz = 255;
  
  public gt(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = om.a();
    }
    this.FE = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.FD;
    paramDrawable1.b |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = om.a();
    }
    this.FF = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.FD;
    paramDrawable2.b |= paramDrawable1.getChangingConfigurations();
  }
  
  gt(oo paramoo)
  {
    this.FD = new oo(paramoo);
  }
  
  public boolean canConstantState()
  {
    if (!this.FG) {
      if ((this.FE.getConstantState() == null) || (this.FF.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.FH = bool;
      this.FG = true;
      return this.FH;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.Fv)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.FB;
        bool = this.Fp;
        localDrawable1 = this.FE;
        localDrawable2 = this.FF;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.Fz)
        {
          localDrawable2.setAlpha(this.Fz);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.Fw = SystemClock.uptimeMillis();
        this.Fv = 2;
        i = k;
      }
    } while (this.Fw < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.Fw) / this.FA;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.Fv = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.Fx;
      this.FB = ((int)(f1 * (this.Fy - this.Fx) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.Fz - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.Fz);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.Fz);
    }
    invalidateSelf();
  }
  
  public Drawable fg()
  {
    return this.FF;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.FD.a | this.FD.b;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.FD.a = getChangingConfigurations();
      return this.FD;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.FE.getIntrinsicHeight(), this.FF.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.FE.getIntrinsicWidth(), this.FF.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.FI)
    {
      this.FJ = Drawable.resolveOpacity(this.FE.getOpacity(), this.FF.getOpacity());
      this.FI = true;
    }
    return this.FJ;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (ip.gc())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.FC) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.FE.mutate();
      this.FF.mutate();
      this.FC = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.FE.setBounds(paramRect);
    this.FF.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (ip.gc())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.FB == this.Fz) {
      this.FB = paramInt;
    }
    this.Fz = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.FE.setColorFilter(paramColorFilter);
    this.FF.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.Fx = 0;
    this.Fy = this.Fz;
    this.FB = 0;
    this.FA = paramInt;
    this.Fv = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (ip.gc())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */