package com.pocket.widget.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.b.a.p;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.b.b;
import com.pocket.widget.ThemedView;

public class o
  extends ThemedView
{
  public static final Interpolator a = new OvershootInterpolator(0.75F);
  private static final int b = j.a(15.0F);
  private static final int c = j.a(7.5F);
  private static final int d = j.a(8.0F);
  private static final int e = j.a(4.0F);
  private static final int f = j.a(4.0F);
  private r g;
  private Drawable h;
  private q i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private boolean n;
  private int o;
  private boolean p;
  private e q;
  private p r;
  private float s;
  private boolean t = com.ideashower.readitlater.util.a.i();
  
  public o(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return;
    }
    int i1 = e(paramDrawable);
    paramDrawable.setBounds(paramInt, i1, paramDrawable.getIntrinsicWidth() + paramInt, paramDrawable.getIntrinsicHeight() + i1);
  }
  
  private static void a(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setState(paramArrayOfInt);
  }
  
  private void b()
  {
    setBackgroundResource(2130837774);
    setClickable(true);
  }
  
  private int e(Drawable paramDrawable)
  {
    return (int)((getHeight() - paramDrawable.getIntrinsicHeight()) / 2.0F);
  }
  
  private void setVisibleTitle(Drawable paramDrawable)
  {
    Drawable localDrawable = this.m;
    if (this.m == paramDrawable) {}
    do
    {
      return;
      this.m = paramDrawable;
      this.p = true;
      requestLayout();
      invalidate();
    } while ((!this.t) || (getWidth() <= 0) || (getHeight() <= 0) || (localDrawable == null));
    this.r = p.a(new float[] { 0.75F, 1.0F }).a(400L);
    this.s = localDrawable.getBounds().exactCenterX();
    this.r.a(a);
    this.r.a(new com.b.a.r()
    {
      public void a(p paramAnonymousp)
      {
        o.this.invalidate();
      }
    });
    this.r.a(new b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        if (o.a(o.this) == paramAnonymousa) {
          o.a(o.this, null);
        }
      }
    });
    this.r.a();
  }
  
  public o a(int paramInt)
  {
    return b(getResources().getDrawable(paramInt));
  }
  
  public o a(Drawable paramDrawable)
  {
    this.h = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setState(getDrawableState());
    }
    invalidate();
    return this;
  }
  
  public o a(f paramf, e parame)
  {
    this.q = parame;
    paramf.a(new a()
    {
      protected void a()
      {
        super.a();
        if (o.d(o.this) != null) {
          o.a(o.this, o.d(o.this));
        }
      }
      
      public void a(View paramAnonymousView)
      {
        super.a(paramAnonymousView);
        o.a(o.this, true);
      }
      
      public void a(View paramAnonymousView, float paramAnonymousFloat)
      {
        super.a(paramAnonymousView, paramAnonymousFloat);
        o.a(o.this, 0 - (int)(o.a() * paramAnonymousFloat));
        o.a(o.this, o.b(o.this), o.c(o.this));
        o.this.invalidate();
      }
      
      protected void b()
      {
        super.b();
        if (o.e(o.this) != o.f(o.this)) {
          o.a(o.this, o.f(o.this));
        }
      }
      
      public void b(View paramAnonymousView)
      {
        super.b(paramAnonymousView);
        o.a(o.this, false);
      }
    });
    requestLayout();
    invalidate();
    return this;
  }
  
  public o a(r paramr)
  {
    if (this.g == paramr) {
      return this;
    }
    this.g = paramr;
    if ((paramr == r.b) && (this.i == null))
    {
      this.i = new q(this, getResources(), 2131165811, null);
      this.i.setState(getDrawableState());
      this.i.setCallback(this);
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return this;
      if ((paramr == r.a) && (this.h == null)) {
        a(getResources().getDrawable(2130837804));
      }
    }
  }
  
  public o a(String paramString)
  {
    return c(new com.pocket.i.a.f(paramString, getResources()));
  }
  
  public o b(int paramInt)
  {
    return a(getResources().getString(paramInt));
  }
  
  public o b(Drawable paramDrawable)
  {
    this.j = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setState(getDrawableState());
    }
    requestLayout();
    invalidate();
    return this;
  }
  
  public o c(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new NullPointerException("title may not be null");
    }
    if ((this.k != null) && (this.m == this.k)) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.k = paramDrawable;
      if ((i1 != 0) || (this.m == null)) {
        setVisibleTitle(paramDrawable);
      }
      paramDrawable.setState(getDrawableState());
      requestLayout();
      invalidate();
      return this;
    }
  }
  
  public o d(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new NullPointerException("app name may not be null");
    }
    if ((this.l != null) && (this.m == this.l)) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.l = paramDrawable;
      if (i1 != 0) {
        setVisibleTitle(paramDrawable);
      }
      paramDrawable.setState(getDrawableState());
      requestLayout();
      invalidate();
      return this;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    a(arrayOfInt, this.h);
    a(arrayOfInt, this.i);
    a(arrayOfInt, this.j);
    a(arrayOfInt, this.l);
    a(arrayOfInt, this.k);
    invalidate();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.g == r.b)
    {
      this.i.draw(paramCanvas);
      if (this.j != null) {
        this.j.draw(paramCanvas);
      }
      if (this.m != null) {
        if (this.r == null) {
          break label164;
        }
      }
    }
    label164:
    for (float f1 = ((Float)this.r.f()).floatValue();; f1 = 1.0F)
    {
      if (f1 != 1.0F)
      {
        paramCanvas.save();
        float f3 = this.m.getBounds().exactCenterX();
        float f2 = f3;
        if (f3 > this.s) {
          f2 = this.s;
        }
        paramCanvas.scale(f1, f1, f2, this.m.getBounds().exactCenterY());
      }
      this.m.draw(paramCanvas);
      if (f1 != 1.0F) {
        paramCanvas.restore();
      }
      return;
      if (this.g != r.a) {
        break;
      }
      this.h.draw(paramCanvas);
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      a(this.h, f);
      a(this.i, this.o);
      a(this.j, b);
    }
    if ((paramBoolean) || (this.p))
    {
      this.p = false;
      if (this.m != null) {
        if (this.j == null) {
          break label126;
        }
      }
    }
    label126:
    for (paramInt1 = this.j.getBounds().right + c; (this.m instanceof com.pocket.i.a.f); paramInt1 = f)
    {
      this.m.setBounds(paramInt1, 0, getWidth() - d, getHeight());
      return;
    }
    a(this.m, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if (i2 != 1073741824) {
      if (this.j == null) {
        break label131;
      }
    }
    label131:
    for (paramInt1 = 0 + b + this.j.getIntrinsicWidth() + c;; paramInt1 = 0)
    {
      if (this.m != null) {
        if ((this.m instanceof com.pocket.i.a.f))
        {
          paramInt1 = ((com.pocket.i.a.f)this.m).a() + paramInt1;
          paramInt1 += d;
        }
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i2 == Integer.MIN_VALUE)
        {
          paramInt2 = paramInt1;
          if (i1 < paramInt1) {
            paramInt2 = i1;
          }
        }
        setMeasuredDimension(paramInt2, getMeasuredHeight());
        return;
        paramInt1 = this.m.getIntrinsicWidth() + paramInt1;
        break;
      }
    }
  }
  
  public boolean performClick()
  {
    if (this.g == r.b)
    {
      if (!this.n) {
        break label31;
      }
      this.q.d();
    }
    for (;;)
    {
      return super.performClick();
      label31:
      this.q.c();
    }
  }
  
  public void setNavigationDrawerAlertEnabled(boolean paramBoolean)
  {
    this.i.a(paramBoolean);
  }
  
  public void setTitleAnimationEnabled(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.j) {}
    while (((this.g == r.a) && (paramDrawable == this.h)) || ((this.g == r.b) && (paramDrawable == this.i)) || ((this.g == r.b) && (paramDrawable == this.m))) {
      return true;
    }
    return super.verifyDrawable(paramDrawable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */