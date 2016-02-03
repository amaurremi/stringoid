package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class dq
  extends Drawable
  implements Drawable.Callback
{
  private int oB = 0;
  private long oC;
  private int oD;
  private int oE;
  private int oF = 255;
  private int oG;
  private int oH = 0;
  private boolean oI;
  private b oJ;
  private Drawable oK;
  private Drawable oL;
  private boolean oM;
  private boolean oN;
  private boolean oO;
  private int oP;
  private boolean oy = true;
  
  public dq(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = a.bD();
    }
    this.oK = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.oJ;
    paramDrawable1.oT |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = a.bD();
    }
    this.oL = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.oJ;
    paramDrawable2.oT |= paramDrawable1.getChangingConfigurations();
  }
  
  dq(b paramb)
  {
    this.oJ = new b(paramb);
  }
  
  public Drawable bC()
  {
    return this.oL;
  }
  
  public boolean canConstantState()
  {
    if (!this.oM) {
      if ((this.oK.getConstantState() == null) || (this.oL.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.oN = bool;
      this.oM = true;
      return this.oN;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.oB)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.oH;
        bool = this.oy;
        localDrawable1 = this.oK;
        localDrawable2 = this.oL;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.oF)
        {
          localDrawable2.setAlpha(this.oF);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.oC = SystemClock.uptimeMillis();
        this.oB = 2;
        i = k;
      }
    } while (this.oC < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.oC) / this.oG;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.oB = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.oD;
      this.oH = ((int)(f1 * (this.oE - this.oD) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.oF - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.oF);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.oF);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.oJ.oS | this.oJ.oT;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.oJ.oS = getChangingConfigurations();
      return this.oJ;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.oK.getIntrinsicHeight(), this.oL.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.oK.getIntrinsicWidth(), this.oL.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.oO)
    {
      this.oP = Drawable.resolveOpacity(this.oK.getOpacity(), this.oL.getOpacity());
      this.oO = true;
    }
    return this.oP;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (fg.cD())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.oI) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.oK.mutate();
      this.oL.mutate();
      this.oI = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.oK.setBounds(paramRect);
    this.oL.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (fg.cD())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.oH == this.oF) {
      this.oH = paramInt;
    }
    this.oF = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.oK.setColorFilter(paramColorFilter);
    this.oL.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.oD = 0;
    this.oE = this.oF;
    this.oH = 0;
    this.oG = paramInt;
    this.oB = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (fg.cD())
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
    private static final a oQ = new a();
    private static final a oR = new a(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return oR;
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
        return dq.a.bD();
      }
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    int oS;
    int oT;
    
    b(b paramb)
    {
      if (paramb != null)
      {
        this.oS = paramb.oS;
        this.oT = paramb.oT;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.oS;
    }
    
    public Drawable newDrawable()
    {
      return new dq(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */