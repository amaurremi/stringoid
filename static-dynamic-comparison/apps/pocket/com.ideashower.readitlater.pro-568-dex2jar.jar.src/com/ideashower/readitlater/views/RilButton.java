package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.Button;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class RilButton
  extends Button
{
  public static final int a = g.b(2131361795);
  public static final int b = g.b(2131361796);
  public static final int c = g.b(2131361798);
  public static final int d = g.b(2131361799);
  public static final int e = g.b(2131361800);
  public static final int f = g.b(2131361801);
  public static final int g = g.b(2131361803);
  public static final int h = g.b(2131361797);
  public static final int i = g.b(2131361802);
  private ColorStateList j;
  private ColorStateList k;
  private RectF l;
  private RectF m;
  private Paint n;
  private Paint o;
  private boolean p = true;
  private int q;
  private y r;
  
  public RilButton(Context paramContext)
  {
    super(paramContext);
    a();
    i.a(i.a, this);
    b();
  }
  
  public RilButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    a(paramContext, paramAttributeSet);
    b();
  }
  
  public RilButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramContext, paramAttributeSet);
    b();
  }
  
  private void a()
  {
    this.m = new RectF();
    this.l = new RectF();
    this.n = new Paint();
    this.n.setDither(true);
    this.n.setStyle(Paint.Style.FILL);
    this.o = new Paint();
    this.o.setStyle(Paint.Style.FILL);
    setGravity(17);
    setTypeface(null, 1);
    setBackgroundDrawable(null);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, y.a);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, y paramy)
  {
    Resources localResources = getResources();
    a(localResources.getColorStateList(paramInt1), localResources.getColorStateList(paramInt2), paramy);
    setTextColor(localResources.getColorStateList(paramInt3));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.RilButton);
    int i1 = paramContext.getInt(1, b);
    if (i1 == a) {
      a(paramContext.getColorStateList(2), paramContext.getColorStateList(3), y.a);
    }
    for (;;)
    {
      this.p = paramContext.getBoolean(0, this.p);
      i1 = paramContext.getResourceId(4, 0);
      if (i1 != 0) {
        a(i1, j.a(18.0F));
      }
      i.a(paramContext.getInt(5, i.a), this);
      paramContext.recycle();
      return;
      setStyle(i1);
    }
  }
  
  private void a(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, y paramy)
  {
    ColorStateList localColorStateList = paramColorStateList1;
    if (paramColorStateList1 == null) {
      localColorStateList = getResources().getColorStateList(2131165752);
    }
    this.j = localColorStateList;
    paramColorStateList1 = paramColorStateList2;
    if (paramColorStateList2 == null) {
      paramColorStateList1 = getResources().getColorStateList(2131165753);
    }
    this.k = paramColorStateList1;
    this.r = paramy;
    c();
    d();
    refreshDrawableState();
    invalidate();
  }
  
  private void b()
  {
    int i2 = j.a(3.0F);
    int i3 = getDrawnInPadding();
    if (getPaddingLeft() == 0) {}
    for (int i1 = j.a(14.0F);; i1 = getPaddingLeft())
    {
      i1 += i3;
      setPadding(i1, i2, i1, i2);
      if (this.q > 0) {
        setMinWidth(this.q + j.a(11.0F) * 2);
      }
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, y.b);
  }
  
  private void c()
  {
    int i1 = this.n.getColor();
    int i2 = this.o.getColor();
    int[] arrayOfInt = getDrawableState();
    int i3 = this.j.getColorForState(arrayOfInt, 0);
    int i4 = this.k.getColorForState(arrayOfInt, 0);
    this.n.setColor(i3);
    this.o.setColor(i4);
    if ((i1 != i3) || (i2 != i4)) {
      invalidate();
    }
  }
  
  private void d()
  {
    float f1 = getDrawnInPadding() + 1;
    float f2 = getWidth() - getDrawnInPadding() - 1;
    float f3 = getHeight() - 1;
    if (this.r == y.a)
    {
      this.l.set(f1, 1.0F, f2, f3 - 1.0F);
      this.m.set(this.l);
      this.m.offset(0.0F, 1.0F);
      return;
    }
    this.m.set(f1, 1.0F, f2, f3);
    this.l.set(this.m);
    this.l.inset(1.0F, 1.0F);
  }
  
  private int getDrawnInPadding()
  {
    if (this.p) {
      return j.a(11.0F);
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt1);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165325);
    setCompoundDrawablesWithIntrinsicBounds(new p(localBitmap, getContext(), localColorStateList), null, null, null);
    setCompoundDrawablePadding(paramInt2);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    c();
  }
  
  protected RectF getFillRect()
  {
    return this.l;
  }
  
  protected Paint getStrokePaint()
  {
    return this.o;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(this.m, 2.0F, 2.0F, this.o);
    paramCanvas.drawRoundRect(this.l, 2.0F, 2.0F, this.n);
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setIsBrightStyle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = c;; i1 = b)
    {
      setStyle(i1);
      return;
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    this.q = paramInt;
    super.setMinWidth(paramInt);
  }
  
  public void setStyle(int paramInt)
  {
    if ((paramInt == c) || (paramInt == d))
    {
      a(2131165748, 2131165750, 2131165751);
      return;
    }
    if (paramInt == e)
    {
      a(2131165748, 2131165749, 2131165751);
      return;
    }
    if (paramInt == f)
    {
      b(2131165755, 2131165756, 2131165757);
      return;
    }
    if (paramInt == g)
    {
      a(2131165758, 2131165759, 2131165760);
      return;
    }
    if (paramInt == h)
    {
      b(2131165745, 2131165746, 2131165747);
      return;
    }
    a(2131165752, 2131165753, 2131165754);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/RilButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */