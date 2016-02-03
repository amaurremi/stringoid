package com.pocket.widget.navigation;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.b.a.r;
import com.ideashower.readitlater.util.j;
import com.pocket.i.a.i;

class q
  extends Drawable
  implements r
{
  private final Paint b = new Paint();
  private final Paint c = new Paint();
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final ColorStateList h;
  private final RectF i = new RectF();
  private com.b.a.p j;
  
  private q(o paramo, Resources paramResources, int paramInt)
  {
    this.h = paramResources.getColorStateList(paramInt);
    this.d = j.a(10.0F);
    this.f = j.a(2.0F);
    this.g = j.a(3.5F);
    this.e = (this.f * 3 + this.g * 2);
    this.b.setAntiAlias(true);
    this.c.setAntiAlias(true);
    this.c.setColor(i.c);
    setCallback(paramo);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint)
  {
    Rect localRect = getBounds();
    a(localRect, 0, paramCanvas, paramPaint);
    a(localRect, this.f + this.g, paramCanvas, paramPaint);
    a(localRect, (this.f + this.g) * 2, paramCanvas, paramPaint);
  }
  
  private void a(Rect paramRect, int paramInt, Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = this.f / 2.0F;
    float f2 = paramRect.left;
    float f3 = paramRect.top + paramInt;
    float f4 = paramRect.right - f1;
    float f5 = paramRect.top + paramInt + this.f;
    paramCanvas.drawRect(f2, f3, f4, f5, paramPaint);
    paramRect = this.i;
    paramRect.set(f4 - f1, f3, f4 + f1, f5);
    paramCanvas.drawArc(paramRect, 270.0F, 180.0F, true, paramPaint);
  }
  
  public void a(com.b.a.p paramp)
  {
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.j != null) {}
    for (boolean bool = true; bool == paramBoolean; bool = false) {
      return;
    }
    if (paramBoolean)
    {
      this.j = com.b.a.p.a(new float[] { 0.0F, 1.0F });
      this.j.a(2000L);
      this.j.a(new p(this.a, 0.33F, new AccelerateDecelerateInterpolator()));
      this.j.a(-1);
      this.j.b(2);
      this.j.a(this);
      this.j.a();
      return;
    }
    this.j = null;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas, this.b);
    if (this.j != null)
    {
      float f1 = ((Float)this.j.f()).floatValue();
      this.c.setAlpha((int)(f1 * 255.0F));
      a(paramCanvas, this.c);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    this.b.setColor(this.h.getColorForState(paramArrayOfInt, 0));
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */