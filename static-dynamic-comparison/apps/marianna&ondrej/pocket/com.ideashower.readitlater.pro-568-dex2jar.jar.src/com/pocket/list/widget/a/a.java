package com.pocket.list.widget.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.util.i;
import com.pocket.p.e;

public class a
  extends Drawable
  implements com.ideashower.readitlater.e.j
{
  private static final float a = com.ideashower.readitlater.util.j.a(3.0F);
  private static final int b = com.ideashower.readitlater.util.j.a(5.0F);
  private final Paint c = new Paint();
  private final Paint d = new Paint();
  private final RectF e = new RectF();
  private final Path f = new Path();
  private b g;
  private Drawable h;
  private boolean i;
  private boolean j;
  private String k;
  private final Context l;
  private ColorStateList m;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, b paramb)
  {
    this.l = paramContext;
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    a(null);
    this.c.setFlags(this.c.getFlags() | 0x80);
    this.c.setAntiAlias(true);
    this.c.setTextAlign(Paint.Align.LEFT);
    this.c.setColor(paramContext.getResources().getColor(2131165336));
    this.f.setFillType(Path.FillType.EVEN_ODD);
    a(paramb);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.m = paramColorStateList;
    b();
    c();
  }
  
  private void b()
  {
    if (this.m != null)
    {
      this.d.setColor(e.b(0.95F, this.m.getColorForState(getState(), 0)));
      return;
    }
    this.d.setColor(0);
  }
  
  private void c()
  {
    this.j = true;
    invalidateSelf();
  }
  
  private void d()
  {
    int i1 = 0;
    Rect localRect = getBounds();
    if ((this.i) && (this.h != null)) {}
    for (int n = this.h.getIntrinsicWidth() + b;; n = 0)
    {
      if (this.k != null) {
        i1 = (int)this.c.measureText(this.k);
      }
      localRect.right = (i1 + (localRect.left + b.d(this.g) + n) + b.e(this.g));
      localRect.bottom = (localRect.top + b.f(this.g));
      setBounds(localRect);
      if (n > 0) {
        this.h.setBounds(localRect.left + b.d(this.g), (int)(localRect.exactCenterY() - this.h.getIntrinsicHeight() / 2), localRect.left + b.d(this.g) + this.h.getIntrinsicWidth(), (int)(localRect.exactCenterY() + this.h.getIntrinsicHeight() / 2));
      }
      return;
    }
  }
  
  private void e()
  {
    Object localObject = getBounds();
    Path localPath = this.f;
    localPath.rewind();
    float f1 = a * 2.0F;
    float f2 = ((Rect)localObject).left;
    float f3 = ((Rect)localObject).top;
    float f4 = ((Rect)localObject).width() + f2 - f1;
    float f5 = ((Rect)localObject).top;
    float f6 = f4 + f1;
    float f7 = ((Rect)localObject).top + f1 + (((Rect)localObject).height() - 2.0F * f1);
    int n = ((Rect)localObject).top;
    float f8 = ((Rect)localObject).height() + n;
    localObject = this.e;
    localPath.moveTo(f2, f3);
    localPath.lineTo(f4, f5);
    ((RectF)localObject).set(f4, f5, f6, f5 + f1);
    localPath.arcTo((RectF)localObject, 270.0F, 90.0F);
    localPath.lineTo(f6, f7);
    ((RectF)localObject).set(f6 - f1, f7, f1 + f4, f8);
    localPath.arcTo((RectF)localObject, 0.0F, 90.0F);
    localPath.lineTo(f2, f8);
    localPath.close();
  }
  
  public void a()
  {
    if ((this.j) && (this.g != null))
    {
      d();
      e();
      this.j = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setBounds(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(g paramg)
  {
    if (paramg != null)
    {
      this.k = paramg.b(this.l);
      this.h = paramg.a(this.l, this);
      a(paramg.b());
    }
    for (;;)
    {
      c();
      return;
      this.k = null;
      this.h = null;
    }
  }
  
  public void a(g paramg, BitmapDrawable paramBitmapDrawable)
  {
    if ((this.h == null) && (paramg.b(this.l).equals(this.k)))
    {
      this.h = paramBitmapDrawable;
      c();
    }
  }
  
  public void a(b paramb)
  {
    if (this.g == paramb) {
      return;
    }
    this.g = paramb;
    if (paramb != null)
    {
      a(b.a(paramb));
      this.c.setTextSize(b.b(paramb));
      this.c.setTypeface(i.a(b.c(paramb)));
    }
    for (;;)
    {
      c();
      return;
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i == paramBoolean) {
      return;
    }
    this.i = paramBoolean;
    c();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a();
    if ((this.k == null) || (this.g == null)) {
      return;
    }
    Rect localRect = getBounds();
    paramCanvas.drawPath(this.f, this.d);
    if ((this.i) && (this.h != null)) {
      this.h.draw(paramCanvas);
    }
    for (float f1 = this.h.getBounds().right + b;; f1 = localRect.left + b.d(this.g))
    {
      float f2 = (localRect.height() - (this.c.descent() + this.c.ascent())) / 2.0F;
      float f3 = localRect.top;
      paramCanvas.drawText(this.k, f1, f3 + f2, this.c);
      return;
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    c();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    b();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
    this.c.setAlpha(paramInt);
    if (this.h != null) {
      this.h.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
    this.c.setColorFilter(paramColorFilter);
    if (this.h != null) {
      this.h.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */