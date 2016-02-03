package com.pocket.i.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.p;

public class h
  extends Drawable
{
  private static final int a = j.a(5.0F);
  private final Paint b = new Paint();
  private final ColorStateList c;
  private final p d;
  
  public h(Context paramContext)
  {
    this(paramContext, 2131165782, 2131165783);
  }
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramContext.getResources().getColorStateList(paramInt1), paramContext.getResources().getColorStateList(paramInt2));
  }
  
  public h(Context paramContext, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(0.0F);
    this.c = paramColorStateList2;
    this.d = new p(2130837630, paramContext, paramColorStateList1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = getBounds();
    Rect localRect2 = this.d.getBounds();
    if (localRect1.isEmpty()) {}
    do
    {
      return;
      this.d.draw(paramCanvas);
    } while (localRect2.left - a < 0);
    float f = localRect1.exactCenterY();
    paramCanvas.drawLine(localRect1.left, f, localRect2.left - a, f, this.b);
    paramCanvas.drawLine(localRect2.right + a, f, localRect1.right, f, this.b);
  }
  
  public int getIntrinsicHeight()
  {
    return this.d.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public int getMinimumWidth()
  {
    return this.d.getIntrinsicWidth();
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
    this.d.a(paramRect.exactCenterX() - this.d.getIntrinsicWidth() / 2.0F, paramRect.exactCenterY() - this.d.getIntrinsicHeight() / 2.0F);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    this.b.setColor(this.c.getColorForState(paramArrayOfInt, 0));
    this.d.setState(paramArrayOfInt);
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
    this.d.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */