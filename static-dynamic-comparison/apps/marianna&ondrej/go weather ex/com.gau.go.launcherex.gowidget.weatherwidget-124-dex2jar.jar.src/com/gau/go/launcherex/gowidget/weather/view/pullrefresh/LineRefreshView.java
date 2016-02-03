package com.gau.go.launcherex.gowidget.weather.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class LineRefreshView
  extends View
{
  private int a = 50;
  private Handler b;
  private boolean c = false;
  private float d = 0.0F;
  private Paint e;
  private RectF f;
  private float g = 0.0F;
  private ArrayList h;
  private float i = 4.0F;
  private float j;
  private Runnable k = new b(this);
  
  public LineRefreshView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public LineRefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public LineRefreshView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.b = new Handler();
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setColor(-16736022);
    this.f = new RectF();
    this.h = new ArrayList();
    int m = 0;
    while (m < 4)
    {
      this.h.add(new RectF());
      m += 1;
    }
    this.i = (getResources().getDisplayMetrics().density * this.i);
  }
  
  private void c()
  {
    RectF localRectF1 = (RectF)this.h.get(0);
    localRectF1.right = (getRight() - getPaddingRight() + this.g);
    localRectF1.left = (localRectF1.right - this.j);
    int m = 1;
    while (m < this.h.size())
    {
      RectF localRectF2 = (RectF)this.h.get(m);
      localRectF2.right = (localRectF1.left - this.i - (this.i + this.j) * (m - 1));
      localRectF2.left = (localRectF2.right - this.j);
      m += 1;
    }
    if (localRectF1.left >= getRight() - getPaddingRight())
    {
      this.h.remove(0);
      this.h.add(localRectF1);
    }
  }
  
  private void d()
  {
    clearAnimation();
    f();
    this.g = 0.0F;
  }
  
  private void e()
  {
    f();
    this.b.post(this.k);
  }
  
  private void f()
  {
    this.b.removeCallbacks(this.k);
  }
  
  private void g()
  {
    this.g += 10.0F;
    if (this.g > this.j + this.i) {
      this.g = 0.0F;
    }
    this.b.postDelayed(this.k, 1000 / this.a);
  }
  
  public void a()
  {
    if (!this.c)
    {
      clearAnimation();
      c localc = new c(this, null);
      localc.a = this.d;
      localc.setDuration((this.d * 200.0F + 200.0F));
      startAnimation(localc);
    }
  }
  
  public void a(float paramFloat)
  {
    clearAnimation();
    this.d = paramFloat;
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      if (paramBoolean) {
        e();
      }
    }
    else
    {
      return;
    }
    d();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (getHeight() == 0)) {
      return;
    }
    if (this.c)
    {
      localObject = this.h.iterator();
      label31:
      RectF localRectF;
      if (((Iterator)localObject).hasNext())
      {
        localRectF = (RectF)((Iterator)localObject).next();
        if (localRectF.left >= getLeft() + getPaddingLeft()) {
          break label136;
        }
        f1 = getLeft() + getPaddingLeft();
        label83:
        if (localRectF.right <= getRight() - getPaddingRight()) {
          break label145;
        }
      }
      label136:
      label145:
      for (f2 = getRight() + getPaddingRight();; f2 = localRectF.right)
      {
        paramCanvas.drawRect(f1, localRectF.top, f2, localRectF.bottom, this.e);
        break label31;
        break;
        f1 = localRectF.left;
        break label83;
      }
    }
    float f1 = getRight() - getLeft() - getPaddingLeft() - getPaddingRight();
    float f2 = this.d * f1;
    Object localObject = this.f;
    float f3 = getPaddingLeft();
    ((RectF)localObject).left = ((f1 - f2) / 2.0F + f3);
    this.f.right = (f2 + this.f.left);
    paramCanvas.drawRect(this.f, this.e);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = getPaddingTop();
    float f2 = paramInt4 - paramInt2 - getPaddingBottom();
    this.f.bottom = f2;
    this.f.top = f1;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      RectF localRectF = (RectF)localIterator.next();
      localRectF.bottom = f2;
      localRectF.top = f1;
    }
    c();
    this.j = ((paramInt3 - paramInt1) / 5.0F * 2.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/pullrefresh/LineRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */