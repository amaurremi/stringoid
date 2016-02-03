package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class gu
  extends Drawable
  implements Drawable.Callback
{
  private b FA;
  private Drawable FB;
  private Drawable FC;
  private boolean FD;
  private boolean FE;
  private boolean FF;
  private int FG;
  private boolean Fm = true;
  private int Fs = 0;
  private long Ft;
  private int Fu;
  private int Fv;
  private int Fw = 255;
  private int Fx;
  private int Fy = 0;
  private boolean Fz;
  
  public gu(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = a.fc();
    }
    this.FB = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.FA;
    paramDrawable1.FK |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = a.fc();
    }
    this.FC = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.FA;
    paramDrawable2.FK |= paramDrawable1.getChangingConfigurations();
  }
  
  gu(b paramb)
  {
    this.FA = new b(paramb);
  }
  
  public boolean canConstantState()
  {
    if (!this.FD) {
      if ((this.FB.getConstantState() == null) || (this.FC.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.FE = bool;
      this.FD = true;
      return this.FE;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.Fs)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.Fy;
        bool = this.Fm;
        localDrawable1 = this.FB;
        localDrawable2 = this.FC;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.Fw)
        {
          localDrawable2.setAlpha(this.Fw);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.Ft = SystemClock.uptimeMillis();
        this.Fs = 2;
        i = k;
      }
    } while (this.Ft < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.Ft) / this.Fx;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.Fs = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.Fu;
      this.Fy = ((int)(f1 * (this.Fv - this.Fu) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.Fw - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.Fw);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.Fw);
    }
    invalidateSelf();
  }
  
  public Drawable fb()
  {
    return this.FC;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.FA.FJ | this.FA.FK;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.FA.FJ = getChangingConfigurations();
      return this.FA;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.FB.getIntrinsicHeight(), this.FC.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.FB.getIntrinsicWidth(), this.FC.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.FF)
    {
      this.FG = Drawable.resolveOpacity(this.FB.getOpacity(), this.FC.getOpacity());
      this.FF = true;
    }
    return this.FG;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (iq.fX())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.Fz) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.FB.mutate();
      this.FC.mutate();
      this.Fz = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.FB.setBounds(paramRect);
    this.FC.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (iq.fX())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.Fy == this.Fw) {
      this.Fy = paramInt;
    }
    this.Fw = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.FB.setColorFilter(paramColorFilter);
    this.FC.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.Fu = 0;
    this.Fv = this.Fw;
    this.Fy = 0;
    this.Fx = paramInt;
    this.Fs = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (iq.fX())
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
    private static final a FH = new a();
    private static final a FI = new a(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return FI;
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
        return gu.a.fc();
      }
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    int FJ;
    int FK;
    
    b(b paramb)
    {
      if (paramb != null)
      {
        this.FJ = paramb.FJ;
        this.FK = paramb.FK;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.FJ;
    }
    
    public Drawable newDrawable()
    {
      return new gu(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */