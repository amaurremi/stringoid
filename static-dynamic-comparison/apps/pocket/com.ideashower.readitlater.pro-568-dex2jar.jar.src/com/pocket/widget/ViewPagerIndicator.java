package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.b.a.a;
import com.b.a.b;
import com.b.a.p;
import com.b.a.r;

public class ViewPagerIndicator
  extends View
  implements b, r
{
  private static final Interpolator a = new DecelerateInterpolator();
  private int b;
  private Bitmap c;
  private int d;
  private int e;
  private int f;
  private p g;
  private float h;
  private final RectF i = new RectF();
  private Paint j;
  
  public ViewPagerIndicator(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.b = ((int)TypedValue.applyDimension(1, 13.0F, getResources().getDisplayMetrics()));
    this.c = BitmapFactory.decodeResource(getResources(), 2130837729);
    this.j = new Paint();
    this.j.setFilterBitmap(true);
    this.j.setAntiAlias(true);
  }
  
  public void a()
  {
    this.c = BitmapFactory.decodeResource(getResources(), 2130837730);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.d == paramInt1) && (paramInt3 == this.f)) {
      return;
    }
    int k;
    if ((paramInt3 == this.f) || (paramInt2 == paramInt3))
    {
      k = 0;
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
      if (k == 0) {
        break label122;
      }
      this.g = p.a(new float[] { 0.0F, 0.21000001F }).a(190L);
      this.g.a(a);
      this.g.a(this);
      this.g.a(this);
      this.g.a();
    }
    for (;;)
    {
      invalidate();
      return;
      k = 1;
      break;
      label122:
      if (this.g != null)
      {
        this.g.b();
        this.g = null;
      }
    }
  }
  
  public void a(a parama)
  {
    this.g = null;
  }
  
  public void a(p paramp)
  {
    if (this.g == null) {
      return;
    }
    this.h = ((Float)paramp.f()).floatValue();
    invalidate();
  }
  
  public void b(a parama) {}
  
  public void c(a parama) {}
  
  public void d(a parama) {}
  
  protected int getSuggestedMinimumHeight()
  {
    return (int)(this.c.getHeight() * 0.62F);
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return this.d * this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = this.i;
    float f3 = this.c.getWidth();
    float f4 = this.c.getHeight();
    float f5 = getHeight() / 2.0F;
    float f1 = (getWidth() - this.d * this.b) / 2.0F;
    float f2 = this.b / 2.0F;
    int m = this.d;
    f2 += f1;
    int k = 0;
    if (k < m)
    {
      if (k == this.f) {
        if (this.g != null) {
          f1 = this.h + 0.41F;
        }
      }
      for (;;)
      {
        float f6 = f3 * f1 / 2.0F;
        f1 = f1 * f4 / 2.0F;
        localRectF.set(f2 - f6, f5 - f1, f6 + f2, f1 + f5);
        paramCanvas.drawBitmap(this.c, null, localRectF, this.j);
        f2 += this.b;
        k += 1;
        break;
        f1 = 0.62F;
        continue;
        if ((k == this.e) && (this.g != null)) {
          f1 = 0.62F - this.h;
        } else {
          f1 = 0.41F;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ViewPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */