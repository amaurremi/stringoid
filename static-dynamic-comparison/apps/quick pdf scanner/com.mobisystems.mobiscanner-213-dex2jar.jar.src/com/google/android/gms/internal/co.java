package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class co
  extends Drawable
  implements Drawable.Callback
{
  private int Gk = 0;
  private long Gl;
  private int Gm;
  private int Gn;
  private int Go = 255;
  private int Gp;
  private int Gq = 0;
  private boolean Gr;
  private b Gs;
  private Drawable Gt;
  private Drawable Gu;
  private boolean Gv;
  private boolean Gw;
  private boolean Gx;
  private int Gy;
  private boolean sC = true;
  
  public co(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = a.qg();
    }
    this.Gt = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.Gs;
    paramDrawable1.GC |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = a.qg();
    }
    this.Gu = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.Gs;
    paramDrawable2.GC |= paramDrawable1.getChangingConfigurations();
  }
  
  co(b paramb)
  {
    this.Gs = new b(paramb);
  }
  
  public boolean canConstantState()
  {
    if (!this.Gv) {
      if ((this.Gt.getConstantState() == null) || (this.Gu.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.Gw = bool;
      this.Gv = true;
      return this.Gw;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.Gk)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.Gq;
        bool = this.sC;
        localDrawable1 = this.Gt;
        localDrawable2 = this.Gu;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.Go)
        {
          localDrawable2.setAlpha(this.Go);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.Gl = SystemClock.uptimeMillis();
        this.Gk = 2;
        i = k;
      }
    } while (this.Gl < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.Gl) / this.Gp;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.Gk = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.Gm;
      this.Gq = ((int)(f1 * (this.Gn - this.Gm) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.Go - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.Go);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.Go);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.Gs.GB | this.Gs.GC;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.Gs.GB = getChangingConfigurations();
      return this.Gs;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.Gt.getIntrinsicHeight(), this.Gu.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.Gt.getIntrinsicWidth(), this.Gu.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.Gx)
    {
      this.Gy = Drawable.resolveOpacity(this.Gt.getOpacity(), this.Gu.getOpacity());
      this.Gx = true;
    }
    return this.Gy;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (dy.qY())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.Gr) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.Gt.mutate();
      this.Gu.mutate();
      this.Gr = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.Gt.setBounds(paramRect);
    this.Gu.setBounds(paramRect);
  }
  
  public Drawable qf()
  {
    return this.Gu;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (dy.qY())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.Gq == this.Go) {
      this.Gq = paramInt;
    }
    this.Go = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Gt.setColorFilter(paramColorFilter);
    this.Gu.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.Gm = 0;
    this.Gn = this.Go;
    this.Gq = 0;
    this.Gp = paramInt;
    this.Gk = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (dy.qY())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  private static final class a
    extends Drawable
  {
    private static final a GA = new a(null);
    private static final a Gz = new a();
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return GA;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class a
      extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return co.a.qg();
      }
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    int GB;
    int GC;
    
    b(b paramb)
    {
      if (paramb != null)
      {
        this.GB = paramb.GB;
        this.GC = paramb.GC;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.GB;
    }
    
    public Drawable newDrawable()
    {
      return new co(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */