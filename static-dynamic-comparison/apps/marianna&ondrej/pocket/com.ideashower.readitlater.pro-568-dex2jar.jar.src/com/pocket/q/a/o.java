package com.pocket.q.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;

public class o
  extends ResizeDetectRelativeLayout
{
  private final Rect a = new Rect();
  private final Rect b = new Rect();
  private boolean c;
  private int d;
  private int e;
  private Paint f;
  private ColorStateList g;
  private Paint h;
  private ColorStateList i;
  
  public o(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    b();
    c();
    d();
    f();
  }
  
  private void b()
  {
    this.f = new Paint();
    this.g = getResources().getColorStateList(2131165804);
  }
  
  private void c()
  {
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.i = getResources().getColorStateList(2131165541);
  }
  
  private void d()
  {
    Resources localResources = getResources();
    this.a.set(localResources.getDimensionPixelSize(2131296330), localResources.getDimensionPixelSize(2131296331), localResources.getDimensionPixelSize(2131296330), localResources.getDimensionPixelSize(2131296331));
    a(localResources.getDimensionPixelSize(2131296327), localResources.getDimensionPixelSize(2131296328), localResources.getDimensionPixelSize(2131296327), localResources.getDimensionPixelSize(2131296328));
    setMinimumHeight(localResources.getDimensionPixelSize(2131296329));
    setDividerHeight(j.a(1.0F));
    setDividerOffset(j.a(0.0F));
  }
  
  private void e()
  {
    setPadding(this.a.left + this.b.left, this.a.top + this.b.top, this.a.right + this.b.right, this.a.bottom + this.b.bottom);
  }
  
  private void f()
  {
    this.f.setColor(this.g.getColorForState(getDrawableState(), 0));
    this.h.setColor(this.i.getColorForState(getDrawableState(), 0));
    invalidate();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.set(paramInt1, paramInt2, paramInt3, paramInt4);
    e();
  }
  
  protected void a(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int k = paramView.getChildCount();
      int j = 0;
      while (j < k)
      {
        a(paramView.getChildAt(j), paramBoolean);
        j += 1;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (isPressed()) {
      paramCanvas.drawRect(this.a.left, this.a.top, getWidth() - this.a.right, getHeight() - this.a.bottom, this.h);
    }
    if ((!a.p()) || (this.c))
    {
      float f1 = getHeight() - this.d - this.e;
      paramCanvas.drawRect(this.a.left, f1, getWidth() - this.a.right, f1 + this.d, this.f);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    f();
  }
  
  protected int getInnerCellPaddingBottom()
  {
    return this.b.bottom;
  }
  
  protected int getInnerCellPaddingLeft()
  {
    return this.b.left;
  }
  
  protected int getInnerCellPaddingRight()
  {
    return this.b.right;
  }
  
  protected int getInnerCellPaddingTop()
  {
    return this.b.top;
  }
  
  public void setBottomDividerEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected void setDividerHeight(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  protected void setDividerOffset(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (isEnabled() != paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      super.setEnabled(paramBoolean);
      if (j != 0) {
        a(this, paramBoolean);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */