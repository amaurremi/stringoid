package com.android.ex.chips;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View.DragShadowBuilder;

final class u
  extends View.DragShadowBuilder
{
  private final z b;
  
  public u(EmailChipsEditTextView14 paramEmailChipsEditTextView14, z paramz)
  {
    this.b = paramz;
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    this.b.getDrawable().draw(paramCanvas);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    Rect localRect = this.b.getDrawable().getBounds();
    paramPoint1.set(localRect.width(), localRect.height());
    paramPoint2.set(localRect.centerX(), localRect.centerY());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */