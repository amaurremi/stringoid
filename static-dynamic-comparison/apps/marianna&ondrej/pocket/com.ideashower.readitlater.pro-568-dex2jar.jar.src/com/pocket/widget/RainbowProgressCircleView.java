package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.b.a.p;
import com.b.a.r;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.o;
import com.pocket.i.a.e;
import java.util.Random;

public class RainbowProgressCircleView
  extends View
  implements r
{
  private final RectF a = new RectF();
  private final Paint b = new Paint(1);
  private int[] c;
  private boolean d;
  private p e;
  private p f;
  private p g;
  private int h;
  private float i;
  private boolean j = true;
  private boolean k = true;
  private boolean l;
  private float m;
  
  public RainbowProgressCircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RainbowProgressCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public RainbowProgressCircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private p a(long paramLong)
  {
    p localp = p.a(new float[] { 0.0F, 360.0F });
    localp.a(paramLong);
    localp.a(-1);
    localp.b(1);
    localp.a(new LinearInterpolator());
    return localp;
  }
  
  private void a()
  {
    if (this.f != null) {
      return;
    }
    this.b.setStyle(Paint.Style.STROKE);
    this.d = this.k;
    this.h = o.a().nextInt(this.c.length);
    this.f = a(1250L);
    this.f.a(this);
    this.f.a();
    this.e = a(1750L);
    this.e.a();
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketTheme);
    paramInt = paramAttributeSet.getResourceId(0, 2131099649);
    setColors(getResources().getIntArray(paramInt));
    setStartAsArc(paramAttributeSet.getBoolean(1, this.k));
    paramAttributeSet.recycle();
  }
  
  private void b()
  {
    if (this.f == null) {
      return;
    }
    this.f.g();
    this.f.b();
    this.f = null;
    this.e.b();
    this.e = null;
  }
  
  private boolean c()
  {
    if ((getVisibility() == 0) && (this.l) && (isShown()))
    {
      a();
      return true;
    }
    b();
    return false;
  }
  
  public void a(p paramp)
  {
    invalidate();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.l = true;
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.l = false;
    c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.f == null) || (this.c == null) || (this.c.length == 0)) {}
    float f1;
    float f2;
    do
    {
      return;
      f1 = ((Float)this.f.f()).floatValue();
      f2 = ((Float)this.e.f()).floatValue();
      if (!this.j) {
        f1 = Math.max(((Float)this.g.f()).floatValue() * 360.0F, 5.0F);
      }
      if (f1 >= this.i) {
        break;
      }
      this.d = false;
      this.h += 1;
      if (this.h >= this.c.length) {
        this.h = 0;
      }
    } while (!c());
    paramCanvas.save();
    paramCanvas.rotate(f2, this.a.centerX(), this.a.centerY());
    this.b.setColor(this.c[this.h]);
    paramCanvas.drawArc(this.a, 0.0F, f1, false, this.b);
    int i1;
    if ((!this.d) || (!this.j))
    {
      n = 1;
      if (n != 0)
      {
        if (!this.j) {
          break label311;
        }
        i1 = this.h - 1;
        n = i1;
        if (i1 < 0) {
          n = this.c.length - 1;
        }
        i1 = this.c[n];
      }
    }
    for (int n = 255;; n = 50)
    {
      this.b.setColor(i1);
      this.b.setAlpha(n);
      paramCanvas.drawArc(this.a, f1, 360.0F - f1 + 1.0F, false, this.b);
      paramCanvas.restore();
      this.i = f1;
      return;
      n = 0;
      break;
      label311:
      i1 = this.c[this.h];
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.setStrokeWidth(paramInt2 * 0.08F);
    this.a.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.a.inset(this.b.getStrokeWidth() / 2.0F, this.b.getStrokeWidth() / 2.0F);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    c();
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
    this.h = 0;
    invalidate();
  }
  
  public void setProgress(float paramFloat)
  {
    setProgressIndeterminate(false);
    float f1 = this.m;
    if (this.g != null)
    {
      f1 = ((Float)this.g.f()).floatValue();
      this.g.b();
    }
    this.g = p.a(new float[] { f1, paramFloat });
    this.g.a(e.a);
    this.g.a(400L);
    this.g.a();
    this.m = paramFloat;
    invalidate();
  }
  
  public void setProgressIndeterminate(boolean paramBoolean)
  {
    this.j = paramBoolean;
    invalidate();
  }
  
  public void setStartAsArc(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/RainbowProgressCircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */